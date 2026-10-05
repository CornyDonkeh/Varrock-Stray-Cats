package com.cornydonkeh.varrockstraycats;

import java.util.HashSet;
import java.util.Set;
import net.runelite.api.gameval.NpcID;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExamineTextsTest
{
    @Test
    public void everyOptionHasItsOwnExamine()
    {
        Set<String> seen = new HashSet<>();
        for (AppearanceVariant variant : AppearanceVariant.values())
        {
            String text = ExamineTexts.get(variant);
            assertNotNull(variant.name(), text);
            assertFalse(variant.name(), text.trim().isEmpty());
            assertTrue("Duplicate examine: " + variant.name(), seen.add(text));
        }
        assertNotNull(ExamineTexts.get(null));
    }

    @Test
    public void bobOptionsUseLiveCatModelsAndStayOptIn()
    {
        VarrockStrayCatsConfig config = new VarrockStrayCatsConfig() {};
        assertEquals(NpcID.DS2_MEETING_BOB, AppearanceVariant.APPEARANCEBOB.definitionId);
        assertEquals(NpcID.MACRO_EVIL_BOB_OUTSIDE, AppearanceVariant.APPEARANCEEVILBOB.definitionId);
        assertFalse(config.appearanceBob());
        assertFalse(config.appearanceEvilBob());
        assertNotEquals(ExamineTexts.get(AppearanceVariant.APPEARANCEBOB),
            ExamineTexts.get(AppearanceVariant.APPEARANCEEVILBOB));
        assertEquals("Bob", InteractionTexts.get(AppearanceVariant.APPEARANCEBOB)[0]);
        assertEquals("Evil Bob", InteractionTexts.get(AppearanceVariant.APPEARANCEEVILBOB)[0]);
    }
}
