package com.cornydonkeh.varrockstraycats;

import net.runelite.api.Animation;
import net.runelite.api.Client;
import net.runelite.api.Model;
import net.runelite.api.ModelData;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ModelScaleTest
{
    @Test
    public void artioAndSolScaleOnlyThePosedFrame()
    {
        for (int scale : new int[] {38, 300})
        {
            Client client = mock(Client.class);
            Animation animation = mock(Animation.class);
            Model base = mock(Model.class);
            Model posed = mock(Model.class);
            when(client.applyTransformations(base, animation, 0, null, 0)).thenReturn(posed);
            ScaledAnimationController controller = new ScaledAnimationController(client, animation, scale, scale);
            assertSame(posed, controller.animate(base));
            verify(posed).scale(scale, scale, scale);
            verifyNoInteractions(base);
        }
    }

    @Test
    public void giantCabbageIsUniformAndGrounded()
    {
        ModelData data = mock(ModelData.class);
        when(data.getVerticesY()).thenReturn(new float[] {-20, 0, 20});
        VarrockStrayCatsPlugin.scaleToHeight(data, 200);
        verify(data).scale(640, 640, 640);
        verify(data).translate(0, -100, 0);
        assertEquals(0, AppearanceVariant.APPEARANCEITEMCABBAGE.targetHeight);
        assertEquals(200, AppearanceVariant.APPEARANCEGIANTCABBAGE.targetHeight);
        assertFalse(new VarrockStrayCatsConfig() {}.appearanceGiantCabbage());
    }
}
