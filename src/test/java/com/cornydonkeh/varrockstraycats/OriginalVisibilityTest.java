package com.cornydonkeh.varrockstraycats;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.TileObject;
import net.runelite.api.Model;
import net.runelite.api.MenuEntry;
import net.runelite.api.events.MenuEntryAdded;
import net.runelite.api.events.MenuOptionClicked;
import net.runelite.api.events.OverheadTextChanged;
import net.runelite.api.ModelData;
import net.runelite.api.NPC;
import net.runelite.api.NPCComposition;
import net.runelite.api.Renderable;
import net.runelite.api.RuneLiteObject;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.gameval.NpcID;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.callback.RenderCallback;
import net.runelite.client.callback.RenderCallbackManager;
import net.runelite.client.config.ConfigManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OriginalVisibilityTest
{
    @Mock private Client client;
    @Mock private VarrockStrayCatsConfig config;
    @Mock private ClientThread clientThread;
    @Mock private RenderCallbackManager renderCallbackManager;
    @Mock private ConfigManager configManager;
    @InjectMocks private VarrockStrayCatsPlugin plugin;

    @Test
    public void hidesOnlyTheOriginalStrayOnceReplacementIsActive() throws Exception
    {
        WorldView world = mock(WorldView.class);
        NPC stray = mock(NPC.class);
        GameObject strayObject = mock(GameObject.class);
        when(strayObject.getRenderable()).thenReturn(stray);
        NPC unrelated = mock(NPC.class);
        NPCComposition definition = mock(NPCComposition.class);
        ModelData data = mock(ModelData.class);
        Model model = mock(Model.class);
        RuneLiteObject replacement = mock(RuneLiteObject.class);
        when(config.healVarrockDogs()).thenReturn(true);
        when(client.getTopLevelWorldView()).thenReturn(world);
        when(stray.getWorldView()).thenReturn(world);
        when(stray.getId()).thenReturn(NpcID.DOG_STRAY2);
        when(stray.getTransformedComposition()).thenReturn(definition);
        when(stray.getLocalLocation()).thenReturn(new LocalPoint(6400, 6400));
        when(stray.getWorldLocation()).thenReturn(new WorldPoint(3200, 3200, 0));
        when(client.getNpcDefinition(NpcID.CLAN_HALL_DOG)).thenReturn(definition);
        when(definition.getModels()).thenReturn(new int[] {1});
        when(client.loadModelData(1)).thenReturn(data);
        when(data.shallowCopy()).thenReturn(data);
        when(data.cloneVertices()).thenReturn(data);
        when(data.cloneColors()).thenReturn(data);
        when(data.light()).thenReturn(model);
        when(client.createRuneLiteObject()).thenReturn(replacement);

        plugin.startUp();
        ArgumentCaptor<RenderCallback> callback = ArgumentCaptor.forClass(RenderCallback.class);
        verify(renderCallbackManager).register(callback.capture());
        plugin.onNpcSpawned(new NpcSpawned(stray));

        // Missing/unready assets must not make the dog disappear.
        assertTrue(callback.getValue().drawObject(null, strayObject));
        plugin.onGameTick(new GameTick());
        assertTrue(callback.getValue().drawObject(null, strayObject));

        when(replacement.isActive()).thenReturn(true);
        MenuEntry entry = mock(MenuEntry.class);
        when(entry.getNpc()).thenReturn(stray);
        when(entry.getTarget()).thenReturn("Bones -> <col=ffff00>Stray dog");
        when(entry.getOption()).thenReturn("Pet");
        plugin.onMenuEntryAdded(new MenuEntryAdded(entry));
        verify(entry).setTarget("Bones -> <col=ffff00>Stray dog");
        verify(entry, never()).setIdentifier(anyInt());
        plugin.onMenuOptionClicked(new MenuOptionClicked(entry));
        plugin.onOverheadTextChanged(new OverheadTextChanged(stray, "Woof!"));
        verify(client).addChatMessage(net.runelite.api.ChatMessageType.GAMEMESSAGE, "",
            "You gently pet them. They wag their tail happily.", "");
        plugin.onOverheadTextChanged(new OverheadTextChanged(unrelated, "Woof!"));
        verify(unrelated, never()).setOverheadText(anyString());
        assertFalse("Original dog must not render underneath the replacement",
            callback.getValue().drawObject(null, strayObject));
        assertTrue("Keep original NPC in scene for clickbox and item-on-NPC menus",
            callback.getValue().addEntity(stray, false));
        assertTrue(callback.getValue().addEntity(stray, true));
        assertTrue(callback.getValue().addEntity(unrelated, false));
        assertTrue(callback.getValue().addEntity(mock(Renderable.class), false));
        GameObject unrelatedObject = mock(GameObject.class);
        when(unrelatedObject.getRenderable()).thenReturn(unrelated);
        assertTrue(callback.getValue().drawObject(null, unrelatedObject));
        assertTrue(callback.getValue().drawObject(null, mock(TileObject.class)));
        GameObject replacementObject = mock(GameObject.class);
        when(replacementObject.getRenderable()).thenReturn(mock(Renderable.class));
        assertTrue(callback.getValue().drawObject(null, replacementObject));

        plugin.shutDown();
        assertTrue(callback.getValue().addEntity(stray, false));
        assertTrue(callback.getValue().drawObject(null, strayObject));
        verify(renderCallbackManager).unregister(callback.getValue());
    }
}
