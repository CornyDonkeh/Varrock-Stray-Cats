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
        verify(first, never()).getVerticesY();
        verify(first, never()).getVerticesZ();
    }

    @Test
    public void masksHoverOutlineTrianglesAndRestoresTheirSharedIndices()
    {
        OriginalModelVisibility visibility = new OriginalModelVisibility();
        Model first = mock(Model.class);
        Model second = mock(Model.class);
        int[] a = {2, 3};
        int[] b = {4, 5};
        int[] c = {6, 7};
        for (Model model : new Model[] {first, second})
        {
            when(model.useBoundingBox()).thenReturn(true);
            when(model.getFaceIndices1()).thenReturn(a);
            when(model.getFaceIndices2()).thenReturn(b);
            when(model.getFaceIndices3()).thenReturn(c);
        }
        visibility.hide(first);
        visibility.hide(second);
        assertArrayEquals(new int[] {0, 0}, a);
        assertArrayEquals(a, b);
        assertArrayEquals(a, c);
        verify(first, never()).getVerticesX();
        verify(first, never()).getVerticesY();
        verify(first, never()).getVerticesZ();
        visibility.restore();
        assertArrayEquals(new int[] {2, 3}, a);
        assertArrayEquals(new int[] {4, 5}, b);
        assertArrayEquals(new int[] {6, 7}, c);
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
