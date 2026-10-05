package com.cornydonkeh.varrockstraycats;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import net.runelite.api.Model;

/** Temporarily masks faces without changing the original model's clickbox geometry. */
final class OriginalModelVisibility
{
	// Animated NPC models share these arrays with their cached base models.
	private final Map<int[], int[]> originalColors = new IdentityHashMap<>();

	void hide(Model model)
	{
		// Only single-tile models use a bounding-box clickbox independent of faces.
		if (model == null || !model.useBoundingBox())
		{
			return;
		}
		int[] colors = model.getFaceColors3();
		if (colors != null && !originalColors.containsKey(colors))
		{
			originalColors.put(colors, colors.clone());
			// -2 is the client's non-rendered face sentinel, not a color value.
			Arrays.fill(colors, -2);
		}
	}

	void restore()
	{
		for (Map.Entry<int[], int[]> entry : originalColors.entrySet())
		{
			System.arraycopy(entry.getValue(), 0, entry.getKey(), 0, entry.getKey().length);
		}
		originalColors.clear();
	}
}
