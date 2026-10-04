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
    private final VarrockStrayCatsConfig dogFavorites = new EmptyFavorites()
    {
        @Override public boolean randomBreeds() { return true; }
        @Override public boolean corgiPuppyFawn() { return true; }
        @Override public boolean labradorAdultChocolate() { return true; }
    };

    @Test
    public void dukeKeepsHealthyAppearanceUnlessExplicitlyIncluded()
    {
        assertNull(AppearanceVariant.choose(NpcID.XMAS24_STRAYDOG_FINAL, dogFavorites, new Random(1)));
        VarrockStrayCatsConfig includeDuke = new EmptyFavorites()
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
        VarrockStrayCatsConfig empty = new EmptyFavorites()
        {
            @Override public boolean randomBreeds() { return true; }
        };
        VarrockStrayCatsConfig disabled = new EmptyFavorites()
        {
            @Override public boolean randomBreeds() { return false; }
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
        VarrockStrayCatsConfig mixed = new EmptyFavorites()
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

    private static class EmptyFavorites implements VarrockStrayCatsConfig
    {
        @Override public boolean appearanceGrowncat() { return false; }
        @Override public boolean appearanceGrowncatLight() { return false; }
        @Override public boolean appearanceGrowncatBrown() { return false; }
        @Override public boolean appearanceGrowncatBlack() { return false; }
        @Override public boolean appearanceGrowncatBrowngrey() { return false; }
        @Override public boolean appearanceGrowncatBluegrey() { return false; }
        @Override public boolean appearanceGrowncatHell() { return false; }
        @Override public boolean appearanceLazycatLight() { return false; }
        @Override public boolean appearanceLazycat() { return false; }
        @Override public boolean appearanceLazycatBrown() { return false; }
        @Override public boolean appearanceLazycatBlack() { return false; }
        @Override public boolean appearanceLazycatBrowngrey() { return false; }
        @Override public boolean appearanceLazycatBluegrey() { return false; }
        @Override public boolean appearanceLazycatHell() { return false; }
        @Override public boolean appearanceWileycatLight() { return false; }
        @Override public boolean appearanceWileycat() { return false; }
        @Override public boolean appearanceWileycatBrown() { return false; }
        @Override public boolean appearanceWileycatBlack() { return false; }
        @Override public boolean appearanceWileycatBrowngrey() { return false; }
        @Override public boolean appearanceWileycatBluegrey() { return false; }
        @Override public boolean appearanceWileycatHell() { return false; }
        @Override public boolean appearanceKittenpet1() { return false; }
        @Override public boolean appearanceKittenpetLight() { return false; }
        @Override public boolean appearanceKittenpetBrown() { return false; }
        @Override public boolean appearanceKittenpetBlack() { return false; }
        @Override public boolean appearanceKittenpetBrowngrey() { return false; }
        @Override public boolean appearanceKittenpetBluegrey() { return false; }
        @Override public boolean appearanceKittenpetHell() { return false; }
        @Override public boolean appearanceOvergrowncat() { return false; }
        @Override public boolean appearanceOvergrowncatLight() { return false; }
        @Override public boolean appearanceOvergrowncatBrown() { return false; }
        @Override public boolean appearanceOvergrowncatBlack() { return false; }
        @Override public boolean appearanceOvergrowncatBrowngrey() { return false; }
        @Override public boolean appearanceOvergrowncatBluegrey() { return false; }
        @Override public boolean appearanceOvergrowncatHell() { return false; }
        @Override public boolean appearanceWiseOldMan() { return false; }
        @Override public boolean appearanceItemCabbage() { return false; }
    }

    @Test
    public void freshDefaultsChooseOnlyCatsWiseOldManAndCabbage()
    {
        VarrockStrayCatsConfig config = new VarrockStrayCatsConfig() {};
        assertTrue(config.healVarrockDogs());
        assertTrue(config.randomBreeds());
        EnumSet<AppearanceVariant> expected = EnumSet.of(
            AppearanceVariant.APPEARANCEGROWNCAT,
            AppearanceVariant.APPEARANCEGROWNCATLIGHT,
            AppearanceVariant.APPEARANCEGROWNCATBROWN,
            AppearanceVariant.APPEARANCEGROWNCATBLACK,
            AppearanceVariant.APPEARANCEGROWNCATBROWNGREY,
            AppearanceVariant.APPEARANCEGROWNCATBLUEGREY,
            AppearanceVariant.APPEARANCEGROWNCATHELL,
            AppearanceVariant.APPEARANCELAZYCATLIGHT,
            AppearanceVariant.APPEARANCELAZYCAT,
            AppearanceVariant.APPEARANCELAZYCATBROWN,
            AppearanceVariant.APPEARANCELAZYCATBLACK,
            AppearanceVariant.APPEARANCELAZYCATBROWNGREY,
            AppearanceVariant.APPEARANCELAZYCATBLUEGREY,
            AppearanceVariant.APPEARANCELAZYCATHELL,
            AppearanceVariant.APPEARANCEWILEYCATLIGHT,
            AppearanceVariant.APPEARANCEWILEYCAT,
            AppearanceVariant.APPEARANCEWILEYCATBROWN,
            AppearanceVariant.APPEARANCEWILEYCATBLACK,
            AppearanceVariant.APPEARANCEWILEYCATBROWNGREY,
            AppearanceVariant.APPEARANCEWILEYCATBLUEGREY,
            AppearanceVariant.APPEARANCEWILEYCATHELL,
            AppearanceVariant.APPEARANCEKITTENPET1,
            AppearanceVariant.APPEARANCEKITTENPETLIGHT,
            AppearanceVariant.APPEARANCEKITTENPETBROWN,
            AppearanceVariant.APPEARANCEKITTENPETBLACK,
            AppearanceVariant.APPEARANCEKITTENPETBROWNGREY,
            AppearanceVariant.APPEARANCEKITTENPETBLUEGREY,
            AppearanceVariant.APPEARANCEKITTENPETHELL,
            AppearanceVariant.APPEARANCEOVERGROWNCAT,
            AppearanceVariant.APPEARANCEOVERGROWNCATLIGHT,
            AppearanceVariant.APPEARANCEOVERGROWNCATBROWN,
            AppearanceVariant.APPEARANCEOVERGROWNCATBLACK,
            AppearanceVariant.APPEARANCEOVERGROWNCATBROWNGREY,
            AppearanceVariant.APPEARANCEOVERGROWNCATBLUEGREY,
            AppearanceVariant.APPEARANCEOVERGROWNCATHELL,
            AppearanceVariant.APPEARANCEWISEOLDMAN,
            AppearanceVariant.APPEARANCEITEMCABBAGE);
        EnumSet<AppearanceVariant> seen = EnumSet.noneOf(AppearanceVariant.class);
        Random random = new Random(42);
        for (int i = 0; i < 2000; i++)
        {
            AppearanceVariant choice = AppearanceVariant.choose(NpcID.DOG_STRAY, config, random);
            assertTrue(expected.contains(choice));
            seen.add(choice);
        }
        assertEquals(37, expected.size());
        assertEquals(expected, seen);
    }
}
