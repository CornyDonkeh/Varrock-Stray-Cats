package com.cornydonkeh.varrockstraycats;

import net.runelite.api.ModelData;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ModelCopyTest
{
    @Test
    public void untexturedCatModelDoesNotCloneMissingTextureArray()
    {
        ModelData data = mock(ModelData.class);
        when(data.cloneVertices()).thenReturn(data);
        when(data.cloneColors()).thenReturn(data);
        when(data.getFaceTextures()).thenReturn(null);
        when(data.cloneTextures()).thenThrow(new NullPointerException("No face textures"));

        assertSame(data, VarrockStrayCatsPlugin.copyMutableModelData(data));
        verify(data).cloneVertices();
        verify(data).cloneColors();
        verify(data, never()).cloneTextures();
    }

    @Test
    public void texturedPetModelCopiesTexturesBeforeRetexturing()
    {
        ModelData data = mock(ModelData.class);
        ModelData textureCopy = mock(ModelData.class);
        when(data.cloneVertices()).thenReturn(data);
        when(data.cloneColors()).thenReturn(data);
        when(data.getFaceTextures()).thenReturn(new short[] {1});
        when(data.cloneTextures()).thenReturn(textureCopy);

        assertSame(textureCopy, VarrockStrayCatsPlugin.copyMutableModelData(data));
        verify(data).cloneTextures();
    }
}
