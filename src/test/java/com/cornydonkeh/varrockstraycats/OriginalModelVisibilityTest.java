package com.cornydonkeh.varrockstraycats;

import net.runelite.api.Model;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class OriginalModelVisibilityTest
{
    @Test
    public void restoresSharedFacesAfterRepeatedMasking()
    {
        OriginalModelVisibility visibility = new OriginalModelVisibility();
        Model first = mock(Model.class);
        Model second = mock(Model.class);
        int[] colors = {123, -1, -2, 456};
        when(first.useBoundingBox()).thenReturn(true);
        when(second.useBoundingBox()).thenReturn(true);
        when(first.getFaceColors3()).thenReturn(colors);
        when(second.getFaceColors3()).thenReturn(colors);

        visibility.hide(first);
        visibility.hide(second);
        assertArrayEquals(new int[] {-2, -2, -2, -2}, colors);
        visibility.restore();
        assertArrayEquals(new int[] {123, -1, -2, 456}, colors);
        visibility.restore();
        assertArrayEquals(new int[] {123, -1, -2, 456}, colors);
        verify(first, never()).getVerticesX();
        verify(first, never()).getFaceIndices1();
    }

    @Test
    public void leavesModelsWithFaceBasedClickboxesUntouched()
    {
        OriginalModelVisibility visibility = new OriginalModelVisibility();
        Model model = mock(Model.class);
        visibility.hide(null);
        visibility.hide(model);
        verify(model, never()).getFaceColors3();
        visibility.restore();
    }
}
