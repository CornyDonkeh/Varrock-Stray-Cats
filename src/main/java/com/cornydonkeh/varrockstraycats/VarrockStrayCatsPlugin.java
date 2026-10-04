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
import net.runelite.api.ChatMessageType;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.GameState;
import net.runelite.api.GameObject;
import net.runelite.api.ItemComposition;
import net.runelite.api.Model;
import net.runelite.api.ModelData;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Renderable;
import net.runelite.api.RuneLiteObject;
import net.runelite.api.Scene;
import net.runelite.api.TileObject;
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
	private NPC interactionNpc;
	private String[] interactionTexts;
	private int interactionAction;
	private int interactionTick;
	private boolean interactionNarrated;

	private String[] texts(NPC npc)
	{
		DogAppearance appearance = dogs.get(npc);
		return running && appearance != null && appearance.replacement != null
			&& appearance.replacement.isActive() ? InteractionTexts.get(appearance.variant) : null;
	}

	@Subscribe
	public void onMenuEntryAdded(MenuEntryAdded event)
	{
		MenuEntry entry = event.getMenuEntry();
		String[] text = texts(entry.getNpc());
		if (text != null)
		{
			// Preserve the selected item prefix, action opcode and original NPC index.
			entry.setTarget(entry.getTarget().replace("Stray dog", text[0]));
		}
	}

	@Subscribe
	public void onMenuOptionClicked(MenuOptionClicked event)
	{
		interactionNpc = null;
		MenuEntry entry = event.getMenuEntry();
		String[] text = texts(entry.getNpc());
		if (text == null)
		{
			return;
		}
		String option = entry.getOption();
		int action = "Pet".equals(option) ? 0 : "Shoo-away".equals(option) ? 1 : "Use".equals(option) ? 2 : -1;
		if (action >= 0)
		{
			interactionNpc = entry.getNpc();
			interactionTexts = text;
			interactionAction = action;
			interactionTick = client.getTickCount();
			interactionNarrated = false;
		}
	}

	private boolean hasInteraction()
	{
		return interactionNpc != null && texts(interactionNpc) != null
			&& client.getTickCount() - interactionTick <= 50;
	}

	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event)
	{
		if (event.getActor() instanceof NPC && isDogCall(event.getOverheadText())
			&& (!hasInteraction() || event.getActor() != interactionNpc))
		{
			String[] text = texts((NPC) event.getActor());
			if (text != null && !text[2].equals(event.getOverheadText()))
			{
				event.getActor().setOverheadText(text[2]);
			}
			return;
		}
		if (!hasInteraction())
		{
			return;
		}
		String original = event.getOverheadText();
		if (event.getActor() == interactionNpc && isDogCall(original))
		{
			String replacement = interactionTexts[2 + interactionAction * 3];
			if (!replacement.equals(original))
			{
				event.getActor().setOverheadText(replacement);
			}
			if (!interactionNarrated && interactionAction < 2)
			{
				interactionNarrated = true;
				client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", interactionTexts[3 + interactionAction * 3], "");
			}
		}
		else if (event.getActor() == client.getLocalPlayer())
		{
			if (interactionAction == 0 && "Who's a good doggy!".equals(original)
				|| interactionAction == 1 && "Boo!".equals(original))
			{
				event.getActor().setOverheadText(interactionTexts[1 + interactionAction * 3]);
			}
		}
	}

	static boolean isDogCall(String text)
	{
		return "Woof!".equalsIgnoreCase(text) || "Woof woof!".equalsIgnoreCase(text)
			|| "Whine!".equalsIgnoreCase(text) || "Grrrr!".equalsIgnoreCase(text)
			|| "Bark!".equalsIgnoreCase(text);
	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (!hasInteraction() || interactionAction != 2
			|| event.getType() != ChatMessageType.GAMEMESSAGE && event.getType() != ChatMessageType.SPAM)
		{
			return;
		}
		String original = event.getMessage();
		String replacement = null;
		if ("You give the dog some nice bones.".equals(original))
		{
			replacement = "You offer " + interactionTexts[0] + " some bones.";
		}
		else if ("It happily gnaws on them.".equals(original))
		{
			replacement = interactionTexts[9];
		}
		else if ("You give the dog a nice piece of meat.".equals(original))
		{
			replacement = "You offer " + interactionTexts[0] + " some meat.";
		}
		else if ("It gobbles it up.".equals(original))
		{
			replacement = interactionTexts[12];
		}
		else if ("The dog doesn't seem interested in that.".equals(original))
		{
			replacement = interactionTexts[13];
		}
		if (replacement != null)
		{
			event.getMessageNode().setValue(replacement);
			client.refreshChat();
		}
	}
	private final Random random = new Random();
	private final RenderCallback drawListener = new RenderCallback()
	{
		@Override
		public boolean drawObject(Scene scene, TileObject object)
		{
			// Keep the NPC in the scene for the client's original clickbox and menus.
			// Temporary NPC scene objects wrap their NPC as a GameObject renderable.
			return !(object instanceof GameObject)
				|| shouldDraw(((GameObject) object).getRenderable());
		}
	};
	private volatile boolean running;
	// Share geometry only among dogs with the same original color palette.
	private final Map<Object, Model> healthyModels = new HashMap<>();

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
		interactionNpc = null;
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
			Object modelKey = appearance.variant == null ? original.getId() : appearance.variant;
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
			NPCComposition sizeDefinition = appearance.variant == null
				? client.getNpcDefinition(NpcID.CLAN_HALL_DOG)
				: appearance.variant.item || appearance.variant == AppearanceVariant.APPEARANCEOLMHEAD
					? null : client.getNpcDefinition(appearance.variant.definitionId);
			appearance.widthScale = sizeDefinition == null ? 128 : sizeDefinition.getWidthScale();
			appearance.heightScale = sizeDefinition == null ? 128 : sizeDefinition.getHeightScale();
			int initialAnimation = appearance.variant == null ? entry.getKey().getPoseAnimation()
				: appearance.variant.idleAnimation;
			appearance.replacement = replacement;
			setReplacementAnimation(appearance, initialAnimation);
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
		if (variant == AppearanceVariant.APPEARANCEOLMHEAD)
		{
			// ObjectID.OLM_HEAD (29881): visible head meshes from the reviewed cache.
			// The NPC definition has only the invisible interaction placeholder (32709).
			ModelData head = client.loadModelData(32523);
			ModelData neck = client.loadModelData(32522);
			return head == null || neck == null ? null
				: copyMutableModelData(client.mergeModels(head, neck)).light();
		}
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
			if (variant.targetHeight > 0)
			{
				scaleToHeight(data, variant.targetHeight);
			}
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
		return data.light();
	}

	static void scaleToHeight(ModelData data, int targetHeight)
	{
		float[] y = data.getVerticesY();
		if (y == null || y.length == 0)
		{
			return;
		}
		float minimum = y[0];
		float maximum = y[0];
		for (float value : y)
		{
			minimum = Math.min(minimum, value);
			maximum = Math.max(maximum, value);
		}
		if (maximum > minimum)
		{
			int scale = Math.max(1, Math.round(targetHeight * 128f / (maximum - minimum)));
			data.scale(scale, scale, scale);
			// Rest the enlarged cabbage on the ground rather than burying its bottom half.
			data.translate(0, Math.round(-maximum * scale / 128f), 0);
		}
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
				setReplacementAnimation(appearance, animationId);
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

	private void setReplacementAnimation(DogAppearance appearance, int animationId)
	{
		appearance.replacement.setAnimationController(new ScaledAnimationController(client,
			animationId == -1 ? null : client.loadAnimation(animationId),
			appearance.widthScale, appearance.heightScale));
	}

	private boolean shouldDraw(Renderable renderable)
	{
		// Suppress geometry only, never scene insertion or interaction processing.
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
		private int widthScale = 128;
		private int heightScale = 128;
		private boolean suppressionLogged;

		private DogAppearance(int originalNpcId, AppearanceVariant variant)
		{
			this.originalNpcId = originalNpcId;
			this.variant = variant;
		}
	}
}
