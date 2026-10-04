package com.cornydonkeh.varrockstraycats;

import org.junit.Test;
import static org.junit.Assert.*;

public class InteractionTextsTest
{
    @Test
    public void everyAppearanceHasAllApprovedTexts()
    {
        for (AppearanceVariant variant : AppearanceVariant.values())
        {
            String[] text = InteractionTexts.get(variant);
            assertNotNull(variant.name(), text);
            assertEquals(14, text.length);
            for (String value : text)
            {
                assertFalse(variant.name(), value.isEmpty());
            }
        }
    }

    @Test
    public void cabbageFeedingLinesAreDistinct()
    {
        assertEquals("You hear a faint, leafy crunch as the bone dissolves into fertilizer.",
            InteractionTexts.get(AppearanceVariant.APPEARANCEITEMCABBAGE)[9]);
        assertEquals("The bones vanish into the folds, followed by a wet, echoing crunch.",
            InteractionTexts.get(AppearanceVariant.APPEARANCEGIANTCABBAGE)[9]);
    }

    @Test
    public void onlyExactDogCallsAreRecognized()
    {
        assertTrue(VarrockStrayCatsPlugin.isDogCall("Woof!"));
        assertTrue(VarrockStrayCatsPlugin.isDogCall("Whine!"));
        assertFalse(VarrockStrayCatsPlugin.isDogCall("My dog says Woof!"));
        assertFalse(VarrockStrayCatsPlugin.isDogCall("Purr...purr..."));
        assertFalse(VarrockStrayCatsPlugin.isDogCall(null));
    }

    @Test
    public void multilineBoneMessagesUseTheCorrectCabbageNarration()
    {
        String original = "You give the dog some nice bones.<br>It happily gnaws on them.";
        assertEquals("The bones vanish into the folds, followed by a wet, echoing crunch.",
            VarrockStrayCatsPlugin.feedingText(original,
                InteractionTexts.get(AppearanceVariant.APPEARANCEGIANTCABBAGE)));
        assertEquals("You hear a faint, leafy crunch as the bone dissolves into fertilizer.",
            VarrockStrayCatsPlugin.feedingText(original.replace("<br>", "\n"),
                InteractionTexts.get(AppearanceVariant.APPEARANCEITEMCABBAGE)));
        assertNull(VarrockStrayCatsPlugin.feedingText("Someone said: " + original,
            InteractionTexts.get(AppearanceVariant.APPEARANCEITEMCABBAGE)));
    }
}
