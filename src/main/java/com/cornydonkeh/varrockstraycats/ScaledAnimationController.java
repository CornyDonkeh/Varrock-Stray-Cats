package com.cornydonkeh.varrockstraycats;

import net.runelite.api.Animation;
import net.runelite.api.AnimationController;
import net.runelite.api.Client;
import net.runelite.api.Model;

/** NPC definition scaling belongs after the skeleton has posed the unscaled mesh. */
final class ScaledAnimationController extends AnimationController
{
    private final int width;
    private final int height;

    ScaledAnimationController(Client client, Animation animation, int width, int height)
    {
        super(client, animation);
        this.width = width;
        this.height = height;
    }

    @Override
    public Model animate(Model model, AnimationController other)
    {
        // applyTransformations produces the frame copy, including for a null animation.
        Model posed = super.animate(model, other);
        if (posed != null && (width != 128 || height != 128))
        {
            posed.scale(width, height, width);
        }
        return posed;
    }
}
