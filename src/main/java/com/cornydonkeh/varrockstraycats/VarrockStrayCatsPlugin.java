package com.cornydonkeh.varrockstraycats;

import com.google.inject.Provides;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Random;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Animation;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.ItemComposition;
import net.runelite.api.Model;
import net.runelite.api.ModelData;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Renderable;
import net.runelite.api.RuneLiteObject;
import net.runelite.api.events.BeforeRender;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.PostClientTick;
import net.runelite.api.gameval.NpcID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.callback.RenderCallback;
import net.runelite.client.callback.RenderCallbackManager;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Varrock Stray Cats",
	enabledByDefault = true,
	description = "Give Varrock's stray dogs healthy, cat, pet, boss, Wise Old Man or cabbage appearances.",
	tags = {"cat", "cats", "dog", "dogs", "pets", "boss", "varrock", "duke", "cosmetic"}
)
public class VarrockStrayCatsPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private VarrockStrayCatsConfig config;
	@Inject
	private ClientThread clientThread;
	@Inject
	private RenderCallbackManager renderCallbackManager;
	@Inject
	private ConfigManager configManager;

	// NPC indices can be reused after despawn: track the actual NPC instances.
	private final Map<NPC, DogAppearance> dogs = new IdentityHashMap<>();
	private final Random random = new Random();
	private final RenderCallback drawListener = new RenderCallback()
	{
		@Override
		public boolean addEntity(Renderable renderable, boolean ui)
		{
			// Keep the NPC's 2D layer, but suppress its 3D model once our replacement is ready.
			if (!ui && renderable instanceof NPC)
			{
				DogAppearance appearance = dogs.get(renderable);
				if (appearance != null && !appearance.observedInScene)
				{
					appearance.observedInScene = true;
					log.debug("Tracked stray {} added to scene; replacement active={}",
						appearance.originalNpcId, appearance.replacement != null && appearance.replacement.isActive());
				}
			}
			return ui || shouldDraw(renderable);
		}
	};
	private volatile boolean running;
	// Share geometry only among dogs with the same original color palette.
	private final Map<Integer, Model> healthyModels = new HashMap<>();

	@Provides
	VarrockStrayCatsConfig provideConfig(ConfigManager manager)
	{
		// Migrate before RuneLite fills missing keys with default values.
		migrateConfig(manager);
		return manager.getConfig(VarrockStrayCatsConfig.class);
	}

	@Override
	protected void startUp()
	{
		migrateConfig(configManager);
		running = true;
		renderCallbackManager.register(drawListener);
		clientThread.invoke(this::refresh);
	}

	@Override
	protected void shutDown()
	{
		running = false;
		renderCallbackManager.unregister(drawListener);
		clientThread.invoke(() ->
		{
			clearDogs();
			healthyModels.clear();
			// Handle a quick re-enable that occurred before queued cleanup.
			if (running)
			{
				refresh();
			}
		});
	}

	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (running && VarrockStrayCatsConfig.GROUP.equals(event.getGroup()))
		{
			clientThread.invoke(this::refresh);
		}
	}

	static void migrateConfig(ConfigManager manager)
	{
		for (String key : VarrockStrayCatsConfig.LEGACY_KEYS)
		{
			if (manager.getConfiguration(VarrockStrayCatsConfig.GROUP, key) == null)
			{
				String previous = manager.getConfiguration(VarrockStrayCatsConfig.LEGACY_GROUP, key);
				if (previous != null)
				{
					manager.setConfiguration(VarrockStrayCatsConfig.GROUP, key, previous);
				}
			}
		}
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			refresh();
		}
		else
		{
			clearDogs();
			healthyModels.clear();
		}
	}

	private void refresh()
	{
		clearDogs();
		healthyModels.clear();
		if (!running || !config.healVarrockDogs() || client.getGameState() != GameState.LOGGED_IN)
		{
			return;
		}
		// One scan on enable/login/config change, never on every tick or frame.
		for (NPC npc : client.getTopLevelWorldView().npcs())
		{
			track(npc);
		}
		createReplacements();
	}

	@Subscribe
	public void onNpcSpawned(NpcSpawned event)
	{
		track(event.getNpc());
	}

	@Subscribe
	public void onNpcDespawned(NpcDespawned event)
	{
		removeDog(event.getNpc());
	}

	@Subscribe
	public void onNpcChanged(NpcChanged event)
	{
		DogAppearance previous = dogs.get(event.getNpc());
		if (previous != null && previous.originalNpcId == event.getNpc().getId())
		{
			return;
		}
		removeDog(event.getNpc());
		track(event.getNpc());
	}

	private void track(NPC npc)
	{
		if (running && config.healVarrockDogs() && npc != null
			&& npc.getWorldView() == client.getTopLevelWorldView() && isDog(npc.getId()))
		{
			// Choose once per encounter, not on render, animation change, or asset retry.
			dogs.computeIfAbsent(npc, dog -> new DogAppearance(dog.getId(),
				AppearanceVariant.choose(dog.getId(), config, random)));
		}
	}

	private static boolean isDog(int id)
	{
		return id == NpcID.DOG_STRAY || id == NpcID.DOG_STRAY2 || id == NpcID.XMAS24_STRAYDOG_FINAL;
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		// Retry missing cache assets only while tracked dogs are present.
		createReplacements();
	}

	private void createReplacements()
	{
		if (!running || !config.healVarrockDogs() || dogs.isEmpty())
		{
			return;
		}
		for (Map.Entry<NPC, DogAppearance> entry : dogs.entrySet())
		{
			DogAppearance appearance = entry.getValue();
			if (appearance.replacement != null)
			{
				continue;
			}
			NPCComposition original = entry.getKey().getTransformedComposition();
			if (original == null)
			{
				continue;
			}
			int modelKey = appearance.variant == null ? original.getId()
				: (appearance.variant.item ? -appearance.variant.definitionId : appearance.variant.definitionId);
			Model healthyModel = healthyModels.get(modelKey);
			if (healthyModel == null)
			{
				healthyModel = appearance.variant == null ? loadHealedModel(original)
					: loadAppearanceModel(appearance.variant);
				if (healthyModel == null)
				{
					continue;
				}
				healthyModels.put(modelKey, healthyModel);
			}
			RuneLiteObject replacement = client.createRuneLiteObject();
			replacement.setModel(healthyModel);
			replacement.setShouldLoop(true);
			appearance.replacement = replacement;
			positionReplacement(entry.getKey(), replacement);
			log.debug("Created appearance {} for NPC {}", modelKey, original.getId());
		}
	}

	private Model loadHealedModel(NPCComposition original)
	{
		NPCComposition healthy = client.getNpcDefinition(NpcID.CLAN_HALL_DOG);
		return loadModel(healthy, original);
	}

	private Model loadAppearanceModel(AppearanceVariant variant)
	{
		if (variant.item)
		{
			ItemComposition item = client.getItemDefinition(variant.definitionId);
			ModelData cached = client.loadModelData(item.getInventoryModel());
			if (cached == null)
			{
				return null;
			}
			ModelData data = copyMutableModelData(cached.shallowCopy());
			recolor(data, item.getColorToReplace(), item.getColorToReplaceWith());
			retexture(data, item.getTextureToReplace(), item.getTextureToReplaceWith());
			return data.light();
		}
		NPCComposition definition = client.getNpcDefinition(variant.definitionId);
		return loadModel(definition, definition, variant.textureFrom, variant.textureTo);
	}

	private Model loadModel(NPCComposition healthy, NPCComposition colors)
	{
		return loadModel(healthy, colors, null, null);
	}

	private Model loadModel(NPCComposition healthy, NPCComposition colors, short[] textureFrom, short[] textureTo)
	{
		if (healthy == null || colors == null || healthy.getModels() == null || healthy.getModels().length == 0)
		{
			return null;
		}
		int[] ids = healthy.getModels();
		ModelData[] parts = new ModelData[ids.length];
		for (int i = 0; i < ids.length; i++)
		{
			parts[i] = client.loadModelData(ids[i]);
			if (parts[i] == null)
			{
				return null;
			}
		}
		// Merge before lighting: merging lit Models loses legacy animation skin groups.
		// Copy the arrays we change so cached geometry and other NPCs remain untouched.
		ModelData data = copyMutableModelData(parts.length == 1 ? parts[0].shallowCopy() : client.mergeModels(parts));
		recolor(data, colors.getColorToReplace(), colors.getColorToReplaceWith());
		retexture(data, textureFrom, textureTo);
		data.scale(healthy.getWidthScale(), healthy.getHeightScale(), healthy.getWidthScale());
		return data.light();
	}

	static ModelData copyMutableModelData(ModelData data)
	{
		data = data.cloneVertices().cloneColors();
		// Untextured models (including cats) have no face-texture array.
		// RuneLite's cloneTextures() assumes that array is non-null.
		return data.getFaceTextures() == null ? data : data.cloneTextures();
	}

	private static void recolor(ModelData data, short[] from, short[] to)
	{
		if (from != null && to != null)
		{
			for (int i = 0; i < Math.min(from.length, to.length); i++)
			{
				data.recolor(from[i], to[i]);
			}
		}
	}

	private static void retexture(ModelData data, short[] from, short[] to)
	{
		if (from != null && to != null)
		{
			for (int i = 0; i < Math.min(from.length, to.length); i++)
			{
				data.retexture(from[i], to[i]);
			}
		}
	}

	@Subscribe
	public void onBeforeRender(BeforeRender event)
	{
		synchronizeReplacements();
	}

	@Subscribe
	public void onPostClientTick(PostClientTick event)
	{
		// Placement must not depend on the renderer invoking BeforeRender.
		synchronizeReplacements();
	}

	private void synchronizeReplacements()
	{
		// Follow just the tracked dogs, without loading models or scanning the scene.
		for (Map.Entry<NPC, DogAppearance> entry : dogs.entrySet())
		{
			DogAppearance appearance = entry.getValue();
			RuneLiteObject replacement = appearance.replacement;
			if (replacement == null)
			{
				continue;
			}
			NPC npc = entry.getKey();
			positionReplacement(npc, replacement);
			int animationId = npc.getAnimation() == -1 ? npc.getPoseAnimation() : npc.getAnimation();
			if (appearance.variant != null)
			{
				// Each appearance uses its native skeleton, never stray attack/idle animations.
				animationId = npc.getPoseAnimation() == npc.getIdlePoseAnimation()
					|| appearance.variant.walkAnimation == -1
					? appearance.variant.idleAnimation : appearance.variant.walkAnimation;
			}
			Animation current = replacement.getAnimation();
			if ((current == null ? -1 : current.getId()) != animationId)
			{
				replacement.setAnimation(animationId == -1 ? null : client.loadAnimation(animationId));
			}
		}
	}

	static void positionReplacement(NPC npc, RuneLiteObject replacement)
	{
		replacement.setLocation(npc.getLocalLocation(), npc.getWorldLocation().getPlane());
		replacement.setOrientation(npc.getCurrentOrientation());
		if (!replacement.isActive())
		{
			replacement.setActive(true);
		}
	}

	private boolean shouldDraw(Renderable renderable)
	{
		// addEntity covers NPCs in both the software and GPU renderers.
		// drawObject alone does not suppress the original in every rendering path.
		if (!running || !(renderable instanceof NPC))
		{
			return true;
		}
		DogAppearance appearance = dogs.get(renderable);
		if (appearance != null && appearance.replacement != null && appearance.replacement.isActive()
			&& !appearance.suppressionLogged)
		{
			appearance.suppressionLogged = true;
			log.debug("Suppressing original stray {} draw", appearance.originalNpcId);
		}
		return appearance == null || appearance.replacement == null || !appearance.replacement.isActive();
	}

	private void removeDog(NPC npc)
	{
		DogAppearance appearance = dogs.remove(npc);
		if (appearance != null && appearance.replacement != null)
		{
			appearance.replacement.setActive(false);
		}
	}

	private void clearDogs()
	{
		for (DogAppearance appearance : dogs.values())
		{
			if (appearance.replacement != null)
			{
				appearance.replacement.setActive(false);
			}
		}
		dogs.clear();
	}

	private static final class DogAppearance
	{
		private final int originalNpcId;
		private final AppearanceVariant variant;
		private RuneLiteObject replacement;
		private boolean observedInScene;
		private boolean suppressionLogged;

		private DogAppearance(int originalNpcId, AppearanceVariant variant)
		{
			this.originalNpcId = originalNpcId;
			this.variant = variant;
		}
	}
}
