package com.cornydonkeh.varrockstraycats;

import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.TileObject;
import net.runelite.api.Model;
import net.runelite.api.MenuEntry;
import net.runelite.api.MenuAction;
import net.runelite.api.Player;
import net.runelite.api.MessageNode;
import net.runelite.api.ChatMessageType;
import net.runelite.api.events.ChatMessage;
import net.runelite.client.events.ChatboxInput;
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
import net.runelite.api.events.BeforeRender;
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
    public void dukeUsesBobsMenuNameAndExamineWhenReplaced() throws Exception
    {
        WorldView world = mock(WorldView.class);
        NPC duke = mock(NPC.class);
        NPCComposition definition = mock(NPCComposition.class);
        ModelData data = mock(ModelData.class);
        RuneLiteObject replacement = mock(RuneLiteObject.class);
        when(config.healVarrockDogs()).thenReturn(true);
        when(config.randomBreeds()).thenReturn(true);
        when(config.replaceDuke()).thenReturn(true);
        when(config.appearanceBob()).thenReturn(true);
        when(client.getTopLevelWorldView()).thenReturn(world);
        when(duke.getWorldView()).thenReturn(world);
        when(duke.getId()).thenReturn(NpcID.XMAS24_STRAYDOG_FINAL);
        when(duke.getTransformedComposition()).thenReturn(definition);
        when(duke.getLocalLocation()).thenReturn(new LocalPoint(6400, 6400));
        when(duke.getWorldLocation()).thenReturn(new WorldPoint(3200, 3200, 0));
        when(client.getNpcDefinition(NpcID.DS2_MEETING_BOB)).thenReturn(definition);
        when(definition.getModels()).thenReturn(new int[] {1});
        when(client.loadModelData(1)).thenReturn(data);
        when(data.shallowCopy()).thenReturn(data);
        when(data.cloneVertices()).thenReturn(data);
        when(data.cloneColors()).thenReturn(data);
        when(data.light()).thenReturn(mock(Model.class));
        when(client.createRuneLiteObject()).thenReturn(replacement);
        when(replacement.isActive()).thenReturn(true);

        plugin.startUp();
        plugin.onNpcSpawned(new NpcSpawned(duke));
        plugin.onGameTick(new GameTick());
        MenuEntry entry = mock(MenuEntry.class);
        when(entry.getNpc()).thenReturn(duke);
        when(entry.getTarget()).thenReturn("Bones -> <col=ffff00>Duke");
        plugin.onMenuEntryAdded(new MenuEntryAdded(entry));
        verify(entry).setTarget("Bones -> <col=ffff00>Bob");
        verify(entry, never()).setIdentifier(anyInt());
        when(entry.getType()).thenReturn(MenuAction.EXAMINE_NPC);
        MenuOptionClicked examine = new MenuOptionClicked(entry);
        plugin.onMenuOptionClicked(examine);
        assertTrue(examine.isConsumed());
        verify(client).addChatMessage(ChatMessageType.NPC_EXAMINE, "",
            ExamineTexts.get(AppearanceVariant.APPEARANCEBOB), "");
    }

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

        Model originalModel = mock(Model.class);
        int[] originalColors = {123, 456, -1};
        when(stray.getModel()).thenReturn(originalModel);
        when(originalModel.useBoundingBox()).thenReturn(true);
        when(originalModel.getFaceColors3()).thenReturn(originalColors);
        assertTrue("Preserve scene insertion for native NPC interactions",
            callback.getValue().addEntity(stray, false));
        assertArrayEquals(new int[] {-2, -2, -2}, originalColors);

        MenuEntry examineEntry = mock(MenuEntry.class);
        when(examineEntry.getNpc()).thenReturn(stray);
        when(examineEntry.getType()).thenReturn(MenuAction.EXAMINE_NPC);
        MenuOptionClicked examine = new MenuOptionClicked(examineEntry);
        plugin.onMenuOptionClicked(examine);
        assertTrue("Only the cosmetic examine should be consumed", examine.isConsumed());
        verify(client).addChatMessage(ChatMessageType.NPC_EXAMINE, "", ExamineTexts.get(null), "");
        verify(examineEntry, never()).setIdentifier(anyInt());

        MenuEntry unrelatedExamine = mock(MenuEntry.class);
        when(unrelatedExamine.getNpc()).thenReturn(unrelated);
        MenuOptionClicked normalExamine = new MenuOptionClicked(unrelatedExamine);
        plugin.onMenuOptionClicked(normalExamine);
        assertFalse(normalExamine.isConsumed());
        MenuEntry entry = mock(MenuEntry.class);
        when(entry.getNpc()).thenReturn(stray);
        when(entry.getOption()).thenReturn("Pet");
        plugin.onMenuEntryAdded(new MenuEntryAdded(entry));
        verify(entry, never()).setTarget(anyString());
        verify(entry, never()).setIdentifier(anyInt());
        plugin.onMenuOptionClicked(new MenuOptionClicked(entry));
        plugin.onOverheadTextChanged(new OverheadTextChanged(stray, "Woof!"));
        verify(client).addChatMessage(net.runelite.api.ChatMessageType.GAMEMESSAGE, "",
            "You gently pet them. They wag their tail happily.", "");
        plugin.onOverheadTextChanged(new OverheadTextChanged(unrelated, "Woof!"));
        verify(unrelated, never()).setOverheadText(anyString());
        Player player = mock(Player.class);
        when(client.getLocalPlayer()).thenReturn(player);
        when(player.getName()).thenReturn("Tester");
        MessageNode automatic = mock(MessageNode.class);
        plugin.onChatMessage(new ChatMessage(automatic, ChatMessageType.PUBLICCHAT,
            "Tester", "Who's a good doggy!", "", 0));
        verify(automatic).setValue("Who's a good doggy?");

        // Typed chat must remain intact, even when it matches the automatic line.
        plugin.onMenuOptionClicked(new MenuOptionClicked(entry));
        ChatboxInput typed = new ChatboxInput("Who's a good doggy!", 2, () -> {});
        plugin.onChatboxInput(typed);
        MessageNode manual = mock(MessageNode.class);
        plugin.onChatMessage(new ChatMessage(manual, ChatMessageType.PUBLICCHAT,
            "Tester", "Who's a good doggy!", "", 0));
        verify(manual, never()).setValue(anyString());
        assertFalse(typed.isConsumed());

        // Item-on-NPC uses the opcode even when another plugin changes its label.
        when(entry.getType()).thenReturn(MenuAction.WIDGET_TARGET_ON_NPC);
        when(entry.getOption()).thenReturn("Feed");
        plugin.onMenuOptionClicked(new MenuOptionClicked(entry));
        MessageNode bones = mock(MessageNode.class);
        plugin.onChatMessage(new ChatMessage(bones, ChatMessageType.GAMEMESSAGE, "",
            "You give the dog some nice bones.<br>It happily gnaws on them.", "", 0));
        verify(bones).setValue("You offer them the bones. They happily gnaw on them.");
        MessageNode privateChat = mock(MessageNode.class);
        plugin.onChatMessage(new ChatMessage(privateChat, ChatMessageType.PRIVATECHAT,
            "Tester", "It happily gnaws on them.", "", 0));
        verify(privateChat, never()).setValue(anyString());
        assertTrue("The original clickbox must remain in the scene",
            callback.getValue().addEntity(stray, false));
        assertTrue(callback.getValue().addEntity(stray, true));
        assertTrue(callback.getValue().addEntity(unrelated, false));
        assertTrue(callback.getValue().addEntity(mock(Renderable.class), false));
        GameObject unrelatedObject = mock(GameObject.class);
        assertTrue(callback.getValue().drawObject(null, unrelatedObject));
        assertTrue(callback.getValue().drawObject(null, mock(TileObject.class)));
        GameObject replacementObject = mock(GameObject.class);
        assertTrue(callback.getValue().drawObject(null, replacementObject));

        plugin.onBeforeRender(new BeforeRender());
        assertArrayEquals(new int[] {123, 456, -1}, originalColors);
        when(replacement.isActive()).thenReturn(false);
        assertTrue("Restore the original if the replacement becomes inactive",
            callback.getValue().addEntity(stray, false));
        assertArrayEquals(new int[] {123, 456, -1}, originalColors);

        when(replacement.isActive()).thenReturn(true);
        assertTrue(callback.getValue().addEntity(stray, false));
        assertArrayEquals(new int[] {-2, -2, -2}, originalColors);

        plugin.shutDown();
        MenuOptionClicked disabledExamine = new MenuOptionClicked(examineEntry);
        plugin.onMenuOptionClicked(disabledExamine);
        assertFalse("Disabled plugin must keep native examine", disabledExamine.isConsumed());
        ArgumentCaptor<Runnable> cleanup = ArgumentCaptor.forClass(Runnable.class);
        verify(clientThread, atLeastOnce()).invoke(cleanup.capture());
        cleanup.getValue().run();
        assertArrayEquals(new int[] {123, 456, -1}, originalColors);
        assertTrue(callback.getValue().addEntity(stray, false));
        verify(renderCallbackManager).unregister(callback.getValue());
    }
}
