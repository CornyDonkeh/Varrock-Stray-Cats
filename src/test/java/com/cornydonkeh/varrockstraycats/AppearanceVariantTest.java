package com.cornydonkeh.varrockstraycats;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppearanceVariantTest
{
    private final VarrockStrayCatsConfig dogFavorites = new VarrockStrayCatsConfig()
    {
        @Override public boolean randomBreeds() { return true; }
        @Override public boolean corgiPuppyFawn() { return true; }
        @Override public boolean labradorAdultChocolate() { return true; }
    };

    @Test
    public void dukeKeepsHealthyAppearanceUnlessExplicitlyIncluded()
    {
        assertNull(AppearanceVariant.choose(NpcID.XMAS24_STRAYDOG_FINAL, dogFavorites, new Random(1)));
        VarrockStrayCatsConfig includeDuke = new VarrockStrayCatsConfig()
        {
            @Override public boolean randomBreeds() { return true; }
            @Override public boolean replaceDuke() { return true; }
            @Override public boolean appearanceItemCabbage() { return true; }
        };
        assertEquals(ItemID.CABBAGE,
            AppearanceVariant.choose(NpcID.XMAS24_STRAYDOG_FINAL, includeDuke, new Random(1)).definitionId);
    }

    @Test
    public void emptyFavoritesAndDisabledRandomizationFallBackToHealing()
    {
        VarrockStrayCatsConfig empty = new VarrockStrayCatsConfig()
        {
            @Override public boolean randomBreeds() { return true; }
        };
        VarrockStrayCatsConfig disabled = new VarrockStrayCatsConfig()
        {
            @Override public boolean appearanceGrowncat() { return true; }
            @Override public boolean corgiPuppyFawn() { return true; }
        };
        assertNull(AppearanceVariant.choose(NpcID.DOG_STRAY2, empty, new Random(1)));
        assertNull(AppearanceVariant.choose(NpcID.DOG_STRAY, disabled, new Random(1)));
    }

    @Test
    public void originalSavedDogPreferencesStillSelectExactAgeAndColor()
    {
        Random random = new Random(42);
        EnumSet<AppearanceVariant> seen = EnumSet.noneOf(AppearanceVariant.class);
        for (int i = 0; i < 100; i++)
        {
            AppearanceVariant choice = AppearanceVariant.choose(NpcID.DOG_STRAY, dogFavorites, random);
            assertTrue(choice == AppearanceVariant.CORGIPUPPYFAWN
                || choice == AppearanceVariant.LABRADORADULTCHOCOLATE);
            seen.add(choice);
        }
        assertEquals(EnumSet.of(AppearanceVariant.CORGIPUPPYFAWN,
            AppearanceVariant.LABRADORADULTCHOCOLATE), seen);
    }

    @Test
    public void mixedCategoriesShareOneEqualWeightPool()
    {
        VarrockStrayCatsConfig mixed = new VarrockStrayCatsConfig()
        {
            @Override public boolean randomBreeds() { return true; }
            @Override public boolean corgiPuppyFawn() { return true; }
            @Override public boolean appearanceGrowncat() { return true; }
            @Override public boolean appearanceMolePet() { return true; }
            @Override public boolean appearanceGodwarsBandosAvatar() { return true; }
            @Override public boolean appearanceWiseOldMan() { return true; }
            @Override public boolean appearanceItemCabbage() { return true; }
        };
        Set<Integer> definitions = new HashSet<>();
        for (int index = 0; index < 6; index++)
        {
            final int selectedIndex = index;
            Random deterministic = new Random()
            {
                @Override public int nextInt(int bound)
                {
                    assertEquals(6, bound);
                    return selectedIndex;
                }
            };
            AppearanceVariant chosen = AppearanceVariant.choose(NpcID.DOG_STRAY, mixed, deterministic);
            definitions.add(chosen.definitionId);
            if (chosen.definitionId == ItemID.CABBAGE)
            {
                assertTrue(chosen.item);
                assertEquals(-1, chosen.idleAnimation);
                assertEquals(-1, chosen.walkAnimation);
            }
        }
        assertEquals(6, definitions.size());
        assertTrue(definitions.contains(NpcID.GROWNCAT));
        assertTrue(definitions.contains(NpcID.MOLE_PET));
        assertTrue(definitions.contains(NpcID.GODWARS_BANDOS_AVATAR));
        assertTrue(definitions.contains(NpcID.WISE_OLD_MAN));
        assertTrue(definitions.contains(ItemID.CABBAGE));
    }

    @Test
    public void catalogueHasNoDuplicateDefinitionsAndIncludesEveryCatStage()
    {
        Set<String> definitions = new HashSet<>();
        Set<Integer> npcIds = new HashSet<>();
        for (AppearanceVariant variant : AppearanceVariant.values())
        {
            assertTrue("Duplicate definition", definitions.add(variant.item + ":" + variant.definitionId));
            if (!variant.item) { npcIds.add(variant.definitionId); }
            assertTrue(variant.idleAnimation >= -1);
            assertTrue(variant.walkAnimation >= -1);
        }
        int[] cats = {NpcID.KITTENPET1, NpcID.KITTENPET_HELL, NpcID.GROWNCAT, NpcID.GROWNCAT_HELL,
            NpcID.OVERGROWNCAT, NpcID.OVERGROWNCAT_HELL, NpcID.LAZYCAT, NpcID.LAZYCAT_HELL,
            NpcID.WILEYCAT, NpcID.WILEYCAT_HELL};
        for (int id : cats) { assertTrue("Missing cat stage " + id, npcIds.contains(id)); }
        int[] recentPets = {NpcID.DOM_PET, NpcID.GRYPHONBOSS_PET, NpcID.SKILLPET_SAILING,
            NpcID.COWBOSS_PET, NpcID.MAGGOT_KING_PET, NpcID.GOAT_PIT_PET, NpcID.MAD_ANGEL_PET};
        for (int id : recentPets) { assertTrue("Missing recent pet " + id, npcIds.contains(id)); }
    }
}
