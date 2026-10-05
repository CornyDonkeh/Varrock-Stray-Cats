package com.cornydonkeh.varrockstraycats;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import net.runelite.api.Model;

/** Temporarily masks faces while preserving the vertices used by the native bounding-box clickbox. */
final class OriginalModelVisibility
{
	// Animated NPC models share these arrays with their cached base models.
	private final Map<int[], int[]> originalArrays = new IdentityHashMap<>();

	void hide(Model model)
	{
		// Only single-tile models use a bounding-box clickbox independent of faces.
		if (model == null || !model.useBoundingBox())
		{
			return;
		}
		// -2 is the client's non-rendered face sentinel, not a color value.
		mask(model.getFaceColors3(), -2);
		// Outline renderers ignore face colours. Zero-area triangles are culled by
		// those renderers too. Keep all vertices intact for the original bounds.
		mask(model.getFaceIndices1(), 0);
		mask(model.getFaceIndices2(), 0);
		mask(model.getFaceIndices3(), 0);
	}

	private void mask(int[] array, int value)
	{
		if (array != null && !originalArrays.containsKey(array))
		{
			originalArrays.put(array, array.clone());
			Arrays.fill(array, value);
		}
	}

	void restore()
	{
		for (Map.Entry<int[], int[]> entry : originalArrays.entrySet())
		{
			System.arraycopy(entry.getValue(), 0, entry.getKey(), 0, entry.getKey().length);
		}
		originalArrays.clear();
	}
}
