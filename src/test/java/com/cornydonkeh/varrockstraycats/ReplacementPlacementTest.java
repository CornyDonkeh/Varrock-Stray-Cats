package com.cornydonkeh.varrockstraycats;

import net.runelite.api.NPC;
import net.runelite.api.RuneLiteObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import org.junit.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.*;

public class ReplacementPlacementTest
{
    @Test
    public void replacementIsPositionedOnTheStrayBeforeBeingRegistered()
    {
        NPC npc = mock(NPC.class);
        RuneLiteObject replacement = mock(RuneLiteObject.class);
        LocalPoint location = new LocalPoint(6400, 6400);
        when(npc.getLocalLocation()).thenReturn(location);
        when(npc.getWorldLocation()).thenReturn(new WorldPoint(3200, 3200, 0));
        when(npc.getCurrentOrientation()).thenReturn(512);

        VarrockStrayCatsPlugin.positionReplacement(npc, replacement);

        InOrder order = inOrder(replacement);
        order.verify(replacement).setLocation(location, 0);
        order.verify(replacement).setOrientation(512);
        order.verify(replacement).isActive();
        order.verify(replacement).setActive(true);
    }

    @Test
    public void alreadyRegisteredReplacementMovesWithoutRegisteringAgain()
    {
        NPC npc = mock(NPC.class);
        RuneLiteObject replacement = mock(RuneLiteObject.class);
        LocalPoint location = new LocalPoint(6528, 6400);
        when(npc.getLocalLocation()).thenReturn(location);
        when(npc.getWorldLocation()).thenReturn(new WorldPoint(3201, 3200, 0));
        when(replacement.isActive()).thenReturn(true);

        VarrockStrayCatsPlugin.positionReplacement(npc, replacement);

        verify(replacement).setLocation(location, 0);
        verify(replacement, never()).setActive(true);
    }
}
