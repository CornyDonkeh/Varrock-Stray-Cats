package com.cornydonkeh.varrockstraycats;

import net.runelite.api.Client;
import net.runelite.api.Model;
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
        assertTrue(callback.getValue().addEntity(stray, false));
        plugin.onGameTick(new GameTick());
        assertTrue(callback.getValue().addEntity(stray, false));

        when(replacement.isActive()).thenReturn(true);
        assertFalse("Original dog must not render underneath the replacement",
            callback.getValue().addEntity(stray, false));
        assertTrue(callback.getValue().addEntity(stray, true));
        assertTrue(callback.getValue().addEntity(unrelated, false));
        assertTrue(callback.getValue().addEntity(mock(Renderable.class), false));

        plugin.shutDown();
        assertTrue(callback.getValue().addEntity(stray, false));
        verify(renderCallbackManager).unregister(callback.getValue());
    }
}
