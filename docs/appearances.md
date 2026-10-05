# Appearance catalogue

Based on [Healthy Stray Varrock Dogs](https://github.com/CornyDonkeh/healthy-stray-varrock-dogs),
with the original healing/rendering approach and saved dog option keys preserved.

Catalogue generated on 2026-10-03 from a workspace copy of the OSRS game cache,
cross-checked against the [OSRS pet list](https://oldschool.runescape.wiki/w/Pet)
and [boss list](https://oldschool.runescape.wiki/w/Boss), using RuneLite gameval constants.
Idle/walk animations and retextures below come from each model's own cache definition.
No runtime cache files are read or edited and no runtime network requests are added.

All follower pets in this cache are included, excluding quest companions Zanik, Nieve
and Grubfoot. Cats include all seven coats across kitten, adult, overgrown, lazy and
wily stages. Pet fish use inventory models; spooky chair and Mayor of Catherby use
their menagerie NPC models because they have no normal follower model definition.
Boss entries cover world, Wilderness, Slayer, raid, minigame and quest bosses with
available NPC models. Wintertodt has no standalone NPC model in this cache and
therefore is not a selectable appearance. Historical event bosses whose models
are absent are also excluded. Multipart bosses use their principal NPC model.

Large boss models keep their native scale, applied after animation. Great Olm
uses the visible head scene-object geometry rather than its invisible NPC placeholder.
Giant cabbage uniformly scales the regular cabbage mesh to approximately player height.
The drawing callback keeps the original NPC in the scene for normal interactions.
Static pets, fishbowls and cabbage follow the stray without an animation.

## Rebuilding

Run `gradlew.bat -p tools run --args="cache npcs.tsv"` against a COPY of the game
cache in `tools/cache/`. Save RuneLite gameval sources as `npc-ids-source.txt`,
`animation-ids-source.txt`, `item-ids-source.txt`, and wiki raw pet/boss lists as
`pets-wiki.txt` / `bosses-wiki.txt` in the workspace root. Then run
`python tools/build_catalogue.py` and `python tools/generate_java.py`.
Regenerate interaction texts with `python tools/generate_interaction_texts.py`.
Regenerate the unverified local examine drafts with `python tools/generate_examine_texts.py`.
Run `tools/fetch-boss-ids.ps1` to refresh the optional per-boss wiki ID cross-check.
Review `tools/appearance-catalogue.json` before generating Java. Sleeping, dead,
cutscene and other inactive models are deprioritized when choosing boss models.

## Choices

### Cats: Adult

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Default | NpcID.GROWNCAT (1619) | 317 | 314 |
| White | NpcID.GROWNCAT_LIGHT (1620) | 317 | 314 |
| Brown | NpcID.GROWNCAT_BROWN (1621) | 317 | 314 |
| Black | NpcID.GROWNCAT_BLACK (1622) | 317 | 314 |
| Brown & grey | NpcID.GROWNCAT_BROWNGREY (1623) | 317 | 314 |
| Blue & grey | NpcID.GROWNCAT_BLUEGREY (1624) | 317 | 314 |
| Hell | NpcID.GROWNCAT_HELL (1625) | 317 | 314 |

### Cats: Lazy

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| White | NpcID.LAZYCAT_LIGHT (1626) | 317 | 314 |
| Default | NpcID.LAZYCAT (1627) | 317 | 314 |
| Brown | NpcID.LAZYCAT_BROWN (1628) | 317 | 314 |
| Black | NpcID.LAZYCAT_BLACK (1629) | 317 | 314 |
| Brown & grey | NpcID.LAZYCAT_BROWNGREY (1630) | 317 | 314 |
| Blue & grey | NpcID.LAZYCAT_BLUEGREY (1631) | 317 | 314 |
| Hell | NpcID.LAZYCAT_HELL (1632) | 317 | 314 |

### Cats: Wily

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| White | NpcID.WILEYCAT_LIGHT (5584) | 317 | 314 |
| Default | NpcID.WILEYCAT (5585) | 317 | 314 |
| Brown | NpcID.WILEYCAT_BROWN (5586) | 317 | 314 |
| Black | NpcID.WILEYCAT_BLACK (5587) | 317 | 314 |
| Brown & grey | NpcID.WILEYCAT_BROWNGREY (5588) | 317 | 314 |
| Blue & grey | NpcID.WILEYCAT_BLUEGREY (5589) | 317 | 314 |
| Hell | NpcID.WILEYCAT_HELL (5590) | 317 | 314 |

### Cats: Kitten

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Default | NpcID.KITTENPET1 (5591) | 317 | 2662 |
| White | NpcID.KITTENPET_LIGHT (5592) | 317 | 2662 |
| Brown | NpcID.KITTENPET_BROWN (5593) | 317 | 2662 |
| Black | NpcID.KITTENPET_BLACK (5594) | 317 | 2662 |
| Brown & grey | NpcID.KITTENPET_BROWNGREY (5595) | 317 | 2662 |
| Blue & grey | NpcID.KITTENPET_BLUEGREY (5596) | 317 | 2662 |
| Hell | NpcID.KITTENPET_HELL (5597) | 317 | 2662 |

### Cats: Overgrown

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Default | NpcID.OVERGROWNCAT (5598) | 317 | 314 |
| White | NpcID.OVERGROWNCAT_LIGHT (5599) | 317 | 314 |
| Brown | NpcID.OVERGROWNCAT_BROWN (5600) | 317 | 314 |
| Black | NpcID.OVERGROWNCAT_BLACK (5601) | 317 | 314 |
| Brown & grey | NpcID.OVERGROWNCAT_BROWNGREY (5602) | 317 | 314 |
| Blue & grey | NpcID.OVERGROWNCAT_BLUEGREY (5603) | 317 | 314 |
| Hell | NpcID.OVERGROWNCAT_HELL (5604) | 317 | 314 |

### Dogs: Bernese Mountain Dog

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Chocolate | NpcID.SHEPARD_CHOCO_PUPPY (16457) | 6561 | 6560 |
| Puppy: Merle | NpcID.SHEPARD_MERLE_PUPPY (16458) | 6561 | 6560 |
| Puppy: Toasted | NpcID.SHEPARD_TOASTED_PUPPY (16459) | 6561 | 6560 |
| Adult: Chocolate | NpcID.SHEPARD_CHOCO (16385) | 6561 | 6560 |
| Adult: Merle | NpcID.SHEPARD_MERLE (16386) | 6561 | 6560 |
| Adult: Toasted | NpcID.SHEPARD_TOASTED (16387) | 6561 | 6560 |

### Dogs: Border Collie

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Chocolate | NpcID.COLLIE_CHOCO_PUPPY (16442) | 6561 | 6560 |
| Puppy: Merle | NpcID.COLLIE_MERLE_PUPPY (16443) | 6561 | 6560 |
| Puppy: Black White | NpcID.COLLIE_BW_PUPPY (16444) | 6561 | 6560 |
| Adult: Chocolate | NpcID.COLLIE_CHOCO (16367) | 6561 | 6560 |
| Adult: Merle | NpcID.COLLIE_MERLE (16368) | 6561 | 6560 |
| Adult: Black White | NpcID.COLLIE_BW (16369) | 6561 | 6560 |

### Dogs: Chihuahua

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Tan | NpcID.CHIHUAHUA_TAN_PUPPY (16439) | 7858 | 6560 |
| Puppy: White | NpcID.CHIHUAHUA_WHITE_PUPPY (16440) | 7858 | 6560 |
| Puppy: Toasted | NpcID.CHIHUAHUA_TOASTED_PUPPY (16441) | 7858 | 6560 |
| Adult: Tan | NpcID.CHIHUAHUA_TAN (16364) | 6561 | 6560 |
| Adult: White | NpcID.CHIHUAHUA_WHITE (16365) | 6561 | 6560 |
| Adult: Toasted | NpcID.CHIHUAHUA_TOASTED (16366) | 6561 | 6560 |

### Dogs: Corgi

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Tan | NpcID.CORGI_TAN_PUPPY (16445) | 6561 | 6560 |
| Puppy: Fawn | NpcID.CORGI_YELLOW_PUPPY (16446) | 6561 | 6560 |
| Puppy: Toasted | NpcID.CORGI_TOASTED_PUPPY (16447) | 6561 | 6560 |
| Adult: Tan | NpcID.CORGI_TAN (16370) | 6561 | 6560 |
| Adult: Fawn | NpcID.CORGI_YELLOW (16371) | 6561 | 6560 |
| Adult: Toasted | NpcID.CORGI_TOASTED (16372) | 6561 | 6560 |

### Dogs: Greyhound

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Tan | NpcID.GREYHOUND_TAN_PUPPY (16448) | 6561 | 6560 |
| Puppy: Grey | NpcID.GREYHOUND_GREY_PUPPY (16449) | 6561 | 6560 |
| Puppy: Cream | NpcID.GREYHOUND_CREAM_PUPPY (16450) | 6561 | 6560 |
| Adult: Tan | NpcID.GREYHOUND_TAN (16373) | 6561 | 6560 |
| Adult: Grey | NpcID.GREYHOUND_GREY (16374) | 6561 | 6560 |
| Adult: Cream | NpcID.GREYHOUND_CREAM (16375) | 6561 | 6560 |

### Dogs: Husky

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Black White | NpcID.HUSKY_BW_PUPPY (16436) | 6561 | 6560 |
| Puppy: Grey | NpcID.HUSKY_GREY_PUPPY (16437) | 6561 | 6560 |
| Puppy: Chocolate | NpcID.HUSKY_CHOCO_PUPPY (16438) | 6561 | 6560 |
| Adult: Black White | NpcID.HUSKY_BW (16376) | 6561 | 6560 |
| Adult: Grey | NpcID.HUSKY_GREY (16377) | 6561 | 6560 |
| Adult: Chocolate | NpcID.HUSKY_CHOCO (16378) | 6561 | 6560 |

### Dogs: Labrador

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Golden | NpcID.LABRADOR_YELLOW_PUPPY (16433) | 7858 | 6560 |
| Puppy: Chocolate | NpcID.LABRADOR_CHOCO_PUPPY (16434) | 7858 | 6560 |
| Puppy: Black | NpcID.LABRADOR_BLACK_PUPPY (16435) | 7858 | 6560 |
| Adult: Golden | NpcID.LABRADOR_YELLOW (16361) | 6561 | 6560 |
| Adult: Chocolate | NpcID.LABRADOR_BROWN (16362) | 6561 | 6560 |
| Adult: Black | NpcID.LABRADOR_BLACK (16363) | 6561 | 6560 |

### Dogs: Pug

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Fawn | NpcID.PUG_FAWN_PUPPY (16451) | 6561 | 6560 |
| Puppy: Brown | NpcID.PUG_BROWN_PUPPY (16452) | 6561 | 6560 |
| Puppy: Black | NpcID.PUG_BLACK_PUPPY (16453) | 6561 | 6560 |
| Adult: Fawn | NpcID.PUG_FAWN (16379) | 6561 | 6560 |
| Adult: Brown | NpcID.PUG_BROWN (16380) | 6561 | 6560 |
| Adult: Black | NpcID.PUG_BLACK (16381) | 6561 | 6560 |

### Dogs: Samoyed

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: White | NpcID.SAMOYED_WHITE_PUPPY (16454) | 6561 | 6560 |
| Puppy: Golden | NpcID.SAMOYED_YELLOW_PUPPY (16455) | 6561 | 6560 |
| Puppy: Black | NpcID.SAMOYED_BLACK_PUPPY (16456) | 6561 | 6560 |
| Adult: White | NpcID.SAMOYED_WHITE (16382) | 6561 | 6560 |
| Adult: Golden | NpcID.SAMOYED_YELLOW (16383) | 6561 | 6560 |
| Adult: Black | NpcID.SAMOYED_BLACK (16384) | 6561 | 6560 |

### Dogs: Shiba

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Tan | NpcID.SHIBA_TAN_PUPPY (16460) | 6561 | 6560 |
| Puppy: White | NpcID.SHIBA_WHITE_PUPPY (16461) | 6561 | 6560 |
| Puppy: Toasted | NpcID.SHIBA_TOASTED_PUPPY (16462) | 6561 | 6560 |
| Adult: Tan | NpcID.SHIBA_TAN (16388) | 6561 | 6560 |
| Adult: White | NpcID.SHIBA_WHITE (16389) | 6561 | 6560 |
| Adult: Toasted | NpcID.SHIBA_TOASTED (16390) | 6561 | 6560 |

### Dogs: Spaniel

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Red | NpcID.SPANIEL_RED_PUPPY (16463) | 6561 | 6560 |
| Puppy: White | NpcID.SPANIEL_WHITE_PUPPY (16464) | 6561 | 6560 |
| Puppy: Black | NpcID.SPANIEL_BLACK_PUPPY (16465) | 6561 | 6560 |
| Adult: Red | NpcID.SPANIEL_RED (16391) | 6561 | 6560 |
| Adult: White | NpcID.SPANIEL_WHITE (16392) | 6561 | 6560 |
| Adult: Black | NpcID.SPANIEL_BLACK (16393) | 6561 | 6560 |

### Dogs: Yorkie

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Puppy: Brown | NpcID.YORKIE_BROWN_PUPPY (16466) | 6561 | 6560 |
| Puppy: White | NpcID.YORKIE_WHITE_PUPPY (16467) | 6561 | 6560 |
| Puppy: Golden | NpcID.YORKIE_YELLOW_PUPPY (16468) | 6561 | 6560 |
| Adult: Brown | NpcID.YORKIE_BROWN (16394) | 6561 | 6560 |
| Adult: White | NpcID.YORKIE_WHITE (16395) | 6561 | 6560 |
| Adult: Golden | NpcID.YORKIE_YELLOW (16396) | 6561 | 6560 |

### Pets: Bosses & raids

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Dark core | NpcID.CORE_PET (318) | 7980 | 2417 |
| Chaos Elemental Jr. | NpcID.CHAOS_ELEMENTAL_PET (2055) | 3144 | 3145 |
| Snakeling: Green | NpcID.SNAKE_PET_GREEN (2130) | 1721 | 2405 |
| Snakeling: Orange | NpcID.SNAKE_PET_ORANGE (2131) | 1721 | 2405 |
| Snakeling: Blue | NpcID.SNAKE_PET_BLUE (2132) | 1721 | 2405 |
| Sraracha: Default | NpcID.SARACHNISPET (2144) | 8320 | 8319 |
| Phoenix: Green | NpcID.PHOENIX_PET_GREEN (3081) | 6809 | 6808 |
| Phoenix: Blue | NpcID.PHOENIX_PET_BLUE (3082) | 6809 | 6808 |
| Phoenix: White | NpcID.PHOENIX_PET_WHITE (3083) | 6809 | 6808 |
| Phoenix: Purple | NpcID.PHOENIX_PET_PURPLE (3084) | 6809 | 6808 |
| Hellpuppy | NpcID.HELLPET (3099) | 6561 | 6560 |
| Venenatis spiderling: Default | NpcID.VENENATISPET (5557) | 9986 | 9987 |
| Callisto cub: Default | NpcID.CALLISTOPET (5558) | 10011 | 10010 |
| Vet'ion Jr.: Default | NpcID.VETIONPET (5559) | 9965 | 9967 |
| Vet'ion Jr.: Reborn | NpcID.VETIONPET_2 (5560) | 9965 | 9967 |
| Scorpia's offspring | NpcID.SCORPIAPET (5561) | 6258 | 6257 |
| Abyssal orphan | NpcID.ABYSSALSIRE_PET (5884) | 7125 | 7124 |
| TzRek-Jad | NpcID.JADPET (5893) | 2650 | 5805 |
| Dagannoth Supreme Jr. | NpcID.SUPREME_PET (6628) | 2850 | 2849 |
| Dagannoth Prime Jr. | NpcID.PRIME_PET (6629) | 2850 | 2849 |
| Dagannoth Rex Jr. | NpcID.REX_PET (6630) | 2850 | 2849 |
| Kree'arra Jr. | NpcID.ARMADYL_PET (6631) | 7166 | 7167 |
| General Graardor Jr. | NpcID.BANDOS_PET (6632) | 7017 | 7016 |
| Zilyana Jr. | NpcID.SARADOMIN_PET (6633) | 6966 | 6965 |
| K'ril Tsutsaroth Jr. | NpcID.ZAMORAK_PET (6634) | 6935 | 4070 |
| Baby Mole | NpcID.MOLE_PET (6635) | 3309 | 3313 |
| Prince Black Dragon | NpcID.KBD_PET (6636) | 90 | 4635 |
| Kalphite Princess: Flying | NpcID.KQ_PET_FLYING (6637) | 6236 | 6236 |
| Kalphite Princess: Walking | NpcID.KQ_PET_WALKING (6638) | 6239 | 6238 |
| Smoke Devil: Modern | NpcID.SMOKE_PET (6639) | 1829 | 1828 |
| Kraken | NpcID.KRAKEN_PET (6640) | 3989 | 3989 |
| Phoenix: Orange | NpcID.PHOENIX_PET (7370) | 6809 | 6808 |
| Olmlet | NpcID.RAIDS_OLM_PET (7520) | 7396 | 7395 |
| Scurry | NpcID.SCURRIUS_PET (7616) | 10687 | 10715 |
| Skotos | NpcID.SKOTIZO_PET (7671) | 6935 | 4070 |
| Jal-Nib-Rek | NpcID.INFERNO_PET (7675) | 7573 | 7572 |
| Noon | NpcID.DAWN_PET (7892) | 7768 | 7768 |
| Midnight | NpcID.DUSK_PET (7893) | 7807 | 7806 |
| Corporeal Critter | NpcID.CORP_PET (8010) | 1678 | 7974 |
| TzRek-Zuk | NpcID.ZUK_PET (8011) | 7975 | 7977 |
| Vorki | NpcID.VORKATH_PET (8029) | 7948 | 7959 |
| Puppadile | NpcID.DOGADILE_PET (8201) | 7417 | 7982 |
| Tektiny | NpcID.TEKTON_PET (8202) | 7476 | 7983 |
| Vanguard | NpcID.VANGUARD_PET (8203) | 7430 | 7984 |
| Vasa Minirio | NpcID.VASA_PET (8204) | 7416 | 7985 |
| Vespina | NpcID.VESPULA_PET (8205) | 7449 | 7986 |
| Lil' Zik | NpcID.VERZIK_PET (8337) | 13135 | 8122 |
| Smoke Devil: Legacy | NpcID.SMOKE_PET_OLD (8483) | 1829 | 1828 |
| Ikkle Hydra: Default | NpcID.HYDRA_PET (8492) | 8233 | 8296 |
| Ikkle Hydra: Electric | NpcID.HYDRA_PET_ELECTRIC (8493) | 8298 | 8297 |
| Ikkle Hydra: Fire | NpcID.HYDRA_PET_FIRE (8494) | 8247 | 8299 |
| Ikkle Hydra: Extinguished | NpcID.HYDRA_PET_EXTINGUISHED (8495) | 8254 | 8300 |
| Little Parasite | NpcID.NIGHTMARE_PET_PARASITE (8541) | 8553 | 8553 |
| Youngllef | NpcID.GAUNTLET_PET (8737) | 8417 | 8428 |
| Corrupted Youngllef | NpcID.GAUNTLET_PET_CORRUPT (8738) | 8417 | 8428 |
| Smolcano | NpcID.ZALCANO_PET (8739) | 8429 | 8447 |
| Little Nightmare | NpcID.NIGHTMARE_PET (9399) | 8593 | 8634 |
| Enraged Tektiny | NpcID.TEKTON_ENRAGED_PET (9513) | 7485 | 8637 |
| Flying Vespina | NpcID.VESPULA_FLYING_PET (9514) | 8639 | 8639 |
| JalRek-Jad | NpcID.JADPET_INFERNO (10625) | 7589 | 8857 |
| Tiny Tempor | NpcID.TEMPOROSS_PET (10637) | 8895 | 8895 |
| Baby Mole-rat | NpcID.MOLE_PET_NAKED (10651) | 3309 | 3313 |
| Lil' Maiden | NpcID.VERZIK_PET_MAIDEN (10870) | 14520 | 14520 |
| Lil' Bloat | NpcID.VERZIK_PET_BLOAT (10871) | 8080 | 9031 |
| Lil' Nylo | NpcID.VERZIK_PET_NYLOCAS (10872) | 8002 | 8003 |
| Lil' Sot | NpcID.VERZIK_PET_SOTETSEG (10873) | 8137 | 9032 |
| Lil' Xarp | NpcID.VERZIK_PET_XARPUS (10874) | 9033 | 9033 |
| Sraracha: Orange | NpcID.SARACHNISPET_ORANGE (11159) | 8320 | 8319 |
| Sraracha: Blue | NpcID.SARACHNISPET_BLUE (11160) | 8320 | 8319 |
| Nexling | NpcID.NEX_PET (11277) | 9177 | 9176 |
| Tumeken's Guardian | NpcID.WARDEN_PET_TUMEKEN (11812) | 9655 | 9651 |
| Elidinis' Guardian | NpcID.WARDEN_PET_ELIDINIS (11813) | 9656 | 9652 |
| Akkhito | NpcID.WARDEN_PET_AKKHA (11846) | 9760 | 9421 |
| Babi | NpcID.WARDEN_PET_BABA (11847) | 9741 | 9739 |
| Kephriti | NpcID.WARDEN_PET_KEPHRI (11848) | 9572 | 9419 |
| Zebo | NpcID.WARDEN_PET_ZEBAK (11849) | 2037 | 2036 |
| Tumeken's Damaged Guardian | NpcID.WARDEN_PET_TUMEKEN_DESTROYED (11850) | 9420 | 9420 |
| Elidinis' Damaged Guardian | NpcID.WARDEN_PET_ELIDINIS_DESTROYED (11851) | 9420 | 9420 |
| Venenatis spiderling: Legacy | NpcID.VENENATISPET_LEGACY (11985) | 5326 | 5325 |
| Callisto cub: Legacy | NpcID.CALLISTOPET_LEGACY (11986) | 4919 | 4923 |
| Vet'ion Jr.: Legacy | NpcID.VETIONPET_LEGACY (11987) | 5505 | 5497 |
| Vet'ion Jr.: Reborn Legacy | NpcID.VETIONPET_2_LEGACY (11988) | 5505 | 5497 |
| Muphin: Default | NpcID.MUSPAH_PET (12014) | 9913 | 9915 |
| Muphin: Melee | NpcID.MUSPAH_PET_MELEE (12015) | 9913 | 9915 |
| Muphin: Shielded | NpcID.MUSPAH_PET_SHIELDED (12016) | 9913 | 9915 |
| Wisp | NpcID.WHISPERER_PET (12157) | 10230 | 10233 |
| Butch | NpcID.VARDORVIS_PET (12158) | 10337 | 10339 |
| Baron | NpcID.DUKE_SUCELLUS_PET (12159) | 10217 | 10218 |
| Lil'viathan | NpcID.LEVIATHAN_PET (12160) | 10277 | 10292 |
| Bran | NpcID.RTBRANDA_PET (12593) | 11970 | 11972 |
| Ric | NpcID.RTELDRIC_PET (12595) | 11969 | 11971 |
| Smol Heredit | NpcID.SOLHEREDIT_PET (12857) | 10874 | 10880 |
| Nid | NpcID.ARAXXOR_PET (13683) | 11473 | 11474 |
| Rax | NpcID.ARAXXOR_PET_CUTE (13684) | 8340 | 9139 |
| Huberte | NpcID.HUEY_PET (14045) | 11732 | 11733 |
| Moxi | NpcID.AMOXLIATL_PET (14046) | 11528 | 11529 |
| Yami | NpcID.YAMA_PET (14204) | 12140 | 12143 |
| Dom | NpcID.DOM_PET (14785) | 12401 | 12402 |
| Gull | NpcID.GRYPHONBOSS_PET (14931) | 12586 | 12587 |
| Gulliver | NpcID.GRYPHONBOSS_PET_ADULT (14932) | 12548 | 12550 |
| Beef | NpcID.COWBOSS_PET (15631) | 5852 | 5856 |
| Maggot marquess | NpcID.MAGGOT_KING_PET (15740) | 13926 | 13935 |
| Aggy | NpcID.MAD_ANGEL_PET (16317) | 4588 | 4588 |

### Pets: Other

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Clockwork cat | NpcID.POH_TOY_CAT (2782) | 317 | 314 |
| Lil' Creator | NpcID.SOULWARS_PET_BLUE (3566) | 8842 | 8846 |
| Chompy chick | NpcID.CHOMPY_BIRD_PET (4002) | 6764 | 6765 |
| Lil' Destructor | NpcID.SOULWARS_PET_RED (5008) | 3079 | 8847 |
| Penance Pet | NpcID.PENANCE_PET (6674) | 5410 | 5409 |
| Bloodhound | NpcID.BLOODHOUNDPET (7232) | 7269 | 7280 |
| Herbi | NpcID.HERBIBOAR_PET (7760) | 7694 | 7695 |
| Abyssal protector | NpcID.ABYSSAL_PET (11429) | 2185 | 2184 |
| Quetzin | NpcID.QUETZAL_PET (12858) | 10952 | 10952 |
| Broav | NpcID.WGS_BROAV (13518) | 11232 | 11234 |
| Mr McGroot | NpcID.GOAT_PIT_PET (16316) | 5339 | 14449 |
| Humphrey Dumphrey | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EGG (14518) | -1 | -1 |
| Archibald: Pattern 1 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG (15587) | -1 | -1 |
| Archibald: Pattern 2 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG_02 (15590) | -1 | -1 |
| Archibald: Pattern 3 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG_03 (15592) | -1 | -1 |
| Archibald: Pattern 4 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG_04 (15594) | -1 | -1 |
| Archibald: Pattern 5 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG_05 (15596) | -1 | -1 |
| Archibald: Pattern 6 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG_06 (15598) | -1 | -1 |
| Archibald: Pattern 7 | NpcID.DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG_07 (15600) | -1 | -1 |
| Spooky chair | NpcID.POH_HW_CHAIR (14815) | -1 | 3220 |
| Mayor of Catherby | NpcID.POH_FISHBOWL_MAYOR_OF_CATHERBY (15050) | -1 | -1 |
| Pet fish: Default | ItemID.FISHBOWL_BLUEFISH (6670) | -1 | -1 |
| Pet fish: Default | ItemID.FISHBOWL_GREENFISH (6671) | -1 | -1 |
| Pet fish: Default | ItemID.FISHBOWL_SPINEFISH (6672) | -1 | -1 |

### Pets: Skilling

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Heron | NpcID.SKILLPET_FISH (6722) | 6772 | 6774 |
| Baby Chinchompa: Red | NpcID.SKILLPET_HUNTER_RED (6756) | 5182 | 5181 |
| Baby Chinchompa: Grey | NpcID.SKILLPET_HUNTER_GREY (6757) | 5182 | 5181 |
| Baby Chinchompa: Black | NpcID.SKILLPET_HUNTER_BLACK (6758) | 5182 | 5181 |
| Baby Chinchompa: Gold | NpcID.SKILLPET_HUNTER_GOLD (6759) | 5182 | 5181 |
| Giant Squirrel | NpcID.SKILLPET_AGILITY (7351) | 7309 | 7310 |
| Tangleroot: Default | NpcID.SKILLPET_FARMING (7352) | 7312 | 7313 |
| Rocky | NpcID.SKILLPET_THIEVING (7353) | 7315 | 7316 |
| Rift guardian: Fire | NpcID.SKILLPET_RUNECRAFTING_FIRE (7354) | 7307 | 7306 |
| Rift guardian: Air | NpcID.SKILLPET_RUNECRAFTING_AIR (7355) | 7307 | 7306 |
| Rift guardian: Mind | NpcID.SKILLPET_RUNECRAFTING_MIND (7356) | 7307 | 7306 |
| Rift guardian: Water | NpcID.SKILLPET_RUNECRAFTING_WATER (7357) | 7307 | 7306 |
| Rift guardian: Earth | NpcID.SKILLPET_RUNECRAFTING_EARTH (7358) | 7307 | 7306 |
| Rift guardian: Body | NpcID.SKILLPET_RUNECRAFTING_BODY (7359) | 7307 | 7306 |
| Rift guardian: Cosmic | NpcID.SKILLPET_RUNECRAFTING_COSMIC (7360) | 7307 | 7306 |
| Rift guardian: Chaos | NpcID.SKILLPET_RUNECRAFTING_CHAOS (7361) | 7307 | 7306 |
| Rift guardian: Nature | NpcID.SKILLPET_RUNECRAFTING_NATURE (7362) | 7307 | 7306 |
| Rift guardian: Law | NpcID.SKILLPET_RUNECRAFTING_LAW (7363) | 7307 | 7306 |
| Rift guardian: Death | NpcID.SKILLPET_RUNECRAFTING_DEATH (7364) | 7307 | 7306 |
| Rift guardian: Soul | NpcID.SKILLPET_RUNECRAFTING_SOUL (7365) | 7307 | 7306 |
| Rift guardian: Astral | NpcID.SKILLPET_RUNECRAFTING_ASTRAL (7366) | 7307 | 7306 |
| Rift guardian: Blood | NpcID.SKILLPET_RUNECRAFTING_BLOOD (7367) | 7307 | 7306 |
| Rock Golem: Default | NpcID.SKILLPET_MINING_DEFAULT (7451) | 7180 | 7181 |
| Rock Golem: Tin | NpcID.SKILLPET_MINING_TIN (7452) | 7180 | 7181 |
| Rock Golem: Copper | NpcID.SKILLPET_MINING_COPPER (7453) | 7180 | 7181 |
| Rock Golem: Iron | NpcID.SKILLPET_MINING_IRON (7454) | 7180 | 7181 |
| Rock Golem: Blurite | NpcID.SKILLPET_MINING_BLURITE (7455) | 7180 | 7181 |
| Rock Golem: Silver | NpcID.SKILLPET_MINING_SILVER (7642) | 7180 | 7181 |
| Rock Golem: Coal | NpcID.SKILLPET_MINING_COAL (7643) | 7180 | 7181 |
| Rock Golem: Gold | NpcID.SKILLPET_MINING_GOLD (7644) | 7180 | 7181 |
| Rock Golem: Mithril | NpcID.SKILLPET_MINING_MITHRIL (7645) | 7180 | 7181 |
| Rock Golem: Granite | NpcID.SKILLPET_MINING_GRANITE (7646) | 7180 | 7181 |
| Rock Golem: Adamantite | NpcID.SKILLPET_MINING_ADAMANTITE (7647) | 7180 | 7181 |
| Rock Golem: Runite | NpcID.SKILLPET_MINING_RUNITE (7648) | 7180 | 7181 |
| Rock Golem: Amethyst | NpcID.SKILLPET_MINING_AMETHYST (7711) | 7180 | 7181 |
| Rock Golem: Lovakite | NpcID.SKILLPET_MINING_LOVAKITE (7739) | 7180 | 7181 |
| Rock Golem: Elemental | NpcID.SKILLPET_MINING_ELEMENTAL (7740) | 7180 | 7181 |
| Rock Golem: Daeyalt | NpcID.SKILLPET_MINING_DAEYALT (7741) | 7180 | 7181 |
| Rift guardian: Wrath | NpcID.SKILLPET_RUNECRAFTING_WRATH (8028) | 7307 | 7306 |
| Tangleroot: Crystal | NpcID.SKILLPET_FARMING_CRYSTAL (9497) | 7312 | 7313 |
| Tangleroot: Dragon | NpcID.SKILLPET_FARMING_DRAGON (9498) | 7312 | 7313 |
| Tangleroot: Herb | NpcID.SKILLPET_FARMING_HERB (9499) | 7312 | 7313 |
| Tangleroot: Lily | NpcID.SKILLPET_FARMING_LILY (9500) | 7312 | 7313 |
| Tangleroot: Redwood | NpcID.SKILLPET_FARMING_REDWOOD (9501) | 7312 | 7313 |
| Dark Squirrel | NpcID.SKILLPET_AGILITY_DARK (9637) | 7309 | 7310 |
| Red | NpcID.SKILLPET_THIEVING_PANDA (9852) | 7315 | 7316 |
| Ziggy | NpcID.SKILLPET_THIEVING_TANUKI (9853) | 7315 | 7316 |
| Great blue heron | NpcID.SKILLPET_FISH_TEMPOROSS (10636) | 6772 | 6774 |
| Greatish guardian | NpcID.SKILLPET_RUNECRAFTING_GOTR (11428) | 9379 | 9378 |
| Beaver: Default | NpcID.SKILLPETWC (12181) | 7177 | 7178 |
| Beaver: Oak | NpcID.SKILLPET_WC_OAK (12182) | 7177 | 7178 |
| Beaver: Willow | NpcID.SKILLPET_WC_WILLOW (12183) | 7177 | 7178 |
| Beaver: Maple | NpcID.SKILLPET_WC_MAPLE (12184) | 7177 | 7178 |
| Beaver: Yew | NpcID.SKILLPET_WC_YEW (12185) | 7177 | 7178 |
| Beaver: Magic | NpcID.SKILLPET_WC_MAGIC (12186) | 7177 | 7178 |
| Beaver: Redwood | NpcID.SKILLPET_WC_REDWOOD (12187) | 7177 | 7178 |
| Beaver: Teak | NpcID.SKILLPET_WC_TEAK (12188) | 7177 | 7178 |
| Beaver: Mahogany | NpcID.SKILLPET_WC_MAHOGANY (12189) | 7177 | 7178 |
| Beaver: Arctic | NpcID.SKILLPET_WC_ARCTIC (12190) | 7177 | 7178 |
| Pheasant | NpcID.SKILLPET_WC_PHEASANT (12549) | 2370 | 2369 |
| Fox | NpcID.SKILLPET_WC_FOX (12550) | 6561 | 6560 |
| Bone Squirrel | NpcID.SKILLPET_AGILITY_BONE (14044) | 11662 | 11663 |
| Rock Golem: Lead | NpcID.SKILLPET_MINING_LEAD (14923) | 7180 | 7181 |
| Rock Golem: Rubium | NpcID.SKILLPET_MINING_RUBIUM (14924) | 7180 | 7181 |
| Rock Golem: Nickel | NpcID.SKILLPET_MINING_NICKEL (14925) | 7180 | 7181 |
| Beaver: Camphor | NpcID.SKILLPET_WC_CAMPHOR (14926) | 7177 | 7178 |
| Beaver: Ironwood | NpcID.SKILLPET_WC_IRONWOOD (14927) | 7177 | 7178 |
| Beaver: Jatoba | NpcID.SKILLPET_WC_JATOBA (14928) | 7177 | 7178 |
| Beaver: Rosewood | NpcID.SKILLPET_WC_ROSEWOOD (14929) | 7177 | 7178 |
| Soup | NpcID.SKILLPET_SAILING (14930) | 13498 | 13499 |

### Bosses: World

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Ahrim the Blighted | NpcID.BARROWS_AHRIM (1672) | 813 | 1205 |
| Karil the Tainted | NpcID.BARROWS_KARIL (1675) | 808 | 819 |
| Dharok the Wretched | NpcID.BARROWS_DHAROK (1673) | 2065 | 2064 |
| Guthan the Infested | NpcID.BARROWS_GUTHAN (1674) | 813 | 1205 |
| Torag the Corrupted | NpcID.BARROWS_TORAG (1676) | 808 | 819 |
| Verac the Defiled | NpcID.BARROWS_VERAC (1677) | 2061 | 2060 |
| Gemstone Crab | NpcID.GEMSTONE_CRAB (14779) | 12480 | -1 |
| Scurrius | NpcID.RAT_BOSS_NORMAL (7221) | 10687 | 10690 |
| Giant Mole | NpcID.MOLE_GIANT (5779) | 3309 | 3313 |
| Deranged Archaeologist | NpcID.FOSSIL_CRAZY_ARCHAEOLOGIST (7806) | 3846 | 819 |
| Dagannoth Supreme | NpcID.DAGCAVE_RANGED_BOSS (2265) | 2850 | 2849 |
| Dagannoth Rex | NpcID.DAGCAVE_MELEE_BOSS (2267) | 2850 | 2849 |
| Dagannoth Prime | NpcID.DAGCAVE_MAGIC_BOSS (2266) | 2850 | 2849 |
| Sarachnis | NpcID.SARACHNIS (8713) | 8320 | 8319 |
| Blood Moon | NpcID.PMOON_BOSS_BLOOD_MOON_VIS (13011) | -1 | -1 |
| Blue Moon | NpcID.PMOON_BOSS_BLUE_MOON_VIS (13013) | -1 | -1 |
| Eclipse Moon | NpcID.PMOON_BOSS_ECLIPSE_MOON_VIS (13012) | -1 | -1 |
| Kalphite Queen | NpcID.KALPHITE_QUEEN (963) | 6239 | 6238 |
| Kree'arra | NpcID.GODWARS_ARMADYL_AVATAR (3162) | 6976 | 6977 |
| Commander Zilyana | NpcID.GODWARS_SARADOMIN_AVATAR (2205) | 6966 | 6965 |
| General Graardor | NpcID.GODWARS_BANDOS_AVATAR (2215) | 7017 | 7016 |
| K'ril Tsutsaroth | NpcID.GODWARS_ZAMORAK_AVATAR (3129) | 6935 | 4070 |
| The Hueycoatl | NpcID.HUEY_HEAD (14009) | 11668 | -1 |
| Corporeal Beast | NpcID.CORP_BEAST (319) | 1678 | 1684 |
| Nex | NpcID.NEX (11278) | 9177 | 9175 |
| Brutus | NpcID.COWBOSS (15626) | 13781 | 13782 |
| Demonic Brutus | NpcID.COWBOSS_HARDMODE (15628) | 13781 | 13782 |
| Obor | NpcID.HILLGIANT_BOSS (7416) | 4650 | 4649 |
| Bryophyta | NpcID.GB_MOSSGIANT (8195) | 4656 | 4654 |
| Amoxliatl | NpcID.AMOXLIATL (13685) | 11528 | 11529 |
| Branda the Fire Queen | NpcID.RT_FIRE_QUEEN (12596) | 11970 | 11972 |
| Doom of Mokhaiotl | NpcID.DOM_BOSS (14707) | 12405 | -1 |
| Mad Angel | NpcID.MAD_ANGEL (16305) | 4588 | 4588 |
| Zulrah | NpcID.SNAKEBOSS_BOSS_RANGED (2042) | 5070 | 5070 |
| Vorkath | NpcID.VORKATH_QUEST (8060) | 7948 | 7947 |
| Phantom Muspah | NpcID.MUSPAH (12077) | 9913 | 9914 |
| Maggot King | NpcID.MAGGOT_KING (15742) | 13926 | 13927 |
| The Nightmare | NpcID.NIGHTMARE_PHASE_01 (9425) | 8593 | 8592 |
| Phosani's Nightmare | NpcID.NIGHTMARE_CHALLENGE_PHASE_01 (9416) | 8593 | 8592 |
| Yama | NpcID.YAMA (14176) | 12140 | 12141 |
| Duke Sucellus | NpcID.DUKE_SUCELLUS_ASLEEP (12167) | 10174 | -1 |
| The Leviathan | NpcID.LEVIATHAN (12214) | 10276 | 10276 |
| The Whisperer | NpcID.WHISPERER (12204) | 10230 | 10232 |
| Vardorvis | NpcID.VARDORVIS (12223) | 10337 | 10338 |
| The Mimic | NpcID.TRAIL_MIMIC_COMBAT (8633) | 8307 | 8306 |
| Hespori | NpcID.HESPORI (8583) | 8222 | 8222 |
| Skotizo | NpcID.CATA_BOSS (7286) | 4675 | 4674 |
| Shellbane gryphon | NpcID.GRYPHON_BOSS (14860) | 12548 | 12550 |
| Eldric the Ice King | NpcID.RT_ICE_KING (14147) | 11969 | 11971 |

### Bosses: Wilderness

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Chaos Fanatic | NpcID.CHAOS_FANATIC (6619) | 2770 | 2769 |
| Crazy archaeologist | NpcID.CRAZY_ARCHAEOLOGIST (6618) | 3846 | 819 |
| Scorpia | NpcID.SCORPIA (6615) | 6252 | 6262 |
| King Black Dragon | NpcID.KING_DRAGON (239) | 90 | 4635 |
| Chaos Elemental | NpcID.CHAOSELEMENTAL (2054) | 3144 | 3145 |
| Revenant maledictus | NpcID.WILD_CAVE_SUPERIOR (11246) | 9276 | 9275 |
| Calvar'ion | NpcID.VETION_SINGLE (11993) | 9965 | 9967 |
| Vet'ion | NpcID.VETION (6611) | 9965 | 9967 |
| Spindel | NpcID.VENENATIS_SINGLES (11998) | 9986 | 9988 |
| Venenatis | NpcID.VENENATIS (6610) | 9986 | 9988 |
| Artio | NpcID.CALLISTO_SINGLES (11992) | 10011 | 10009 |
| Callisto | NpcID.CALLISTO (6609) | 10011 | 10009 |

### Bosses: Slayer

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Dusk | NpcID.GARGBOSS_DUSK_PHASE1_DEFENSIVE (7851) | 7781 | 7782 |
| Abyssal Sire | NpcID.ABYSSALSIRE_SIRE_PUPPET (5889) | 4533 | 4534 |
| Kraken | NpcID.SLAYER_KRAKEN_BOSS (494) | 3989 | 3989 |
| Cerberus | NpcID.CERBERUS_ATTACKING (5862) | 4484 | 4488 |
| Araxxor | NpcID.ARAXXOR (13668) | 11473 | 11474 |
| Thermonuclear smoke devil | NpcID.SMOKE_DEVIL_BOSS (499) | 1829 | 1828 |
| Alchemical Hydra | NpcID.HYDRABOSS (8615) | 8233 | 8232 |
| Dawn | NpcID.GARGBOSS_DAWN_PHASE1 (7852) | 7768 | 7768 |

### Bosses: Minigames & skilling

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Crystalline Hunllef | NpcID.CRYSTAL_HUNLLEF_MELEE (9021) | 8417 | 8416 |
| Corrupted Hunllef | NpcID.CRYSTAL_HUNLLEF_MELEE_HM (9035) | 8417 | 8416 |
| TzTok-Jad | NpcID.TZHAAR_FIGHTCAVE_SWARM_BOSS (3127) | 2650 | 2651 |
| TzKal-Zuk | NpcID.INFERNO_TZKALZUK_PLACEHOLDER (7706) | 7564 | -1 |
| Sol Heredit | NpcID.COLOSSEUM_SOL_P1 (12821) | 10874 | 10878 |
| Tempoross | NpcID.TEMPOROSS_BOSS_READY (10572) | 8895 | -1 |
| Zalcano | NpcID.ZALCANO (9049) | 8429 | 8430 |
| Penance Queen | NpcID.BARBASSAULT_PEN_QUEEN_NEW (5775) | 5410 | 5409 |
| Avatar of Creation | NpcID.SOUL_WARS_AVATAR_BLUE (10531) | 8842 | 8843 |
| Avatar of Destruction | NpcID.SOUL_WARS_AVATAR_RED (10532) | 3079 | 3082 |

### Bosses: Raids

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Tekton | NpcID.RAIDS_TEKTON_WAITING (7540) | 7473 | 7473 |
| Vanguard | NpcID.RAIDS_VANGUARD_WALKING (7526) | 7430 | 7429 |
| Vespula | NpcID.RAIDS_VESPULA_FLYING (7530) | 7453 | 7453 |
| Vasa Nistirio | NpcID.RAIDS_VASANISTIRIO_WALKING (7566) | 7416 | 7411 |
| Muttadile | NpcID.RAIDS_DOGODILE_JUNIOR (7562) | 7417 | 7419 |
| Great Olm | NpcID.OLM_HEAD (7554) | 7336 | -1 |
| The Maiden of Sugadinti | NpcID.TOB_MAIDEN_100 (8360) | 8090 | 8090 |
| Pestilent Bloat | NpcID.TOB_BLOAT (8359) | 8080 | 8081 |
| Nylocas Vasilias | NpcID.NYLOCAS_BOSS_MELEE (8355) | 8002 | 8003 |
| Sotetseg | NpcID.TOB_SOTETSEG_COMBAT (8388) | 8137 | 8136 |
| Xarpus | NpcID.TOB_XARPUS_STATIC (8338) | 8060 | 8060 |
| Verzik Vitur | NpcID.VERZIK_PHASE2 (8372) | 8113 | 8113 |
| Akkha | NpcID.AKKHA_MELEE (11790) | 9760 | 9764 |
| Ba-Ba | NpcID.TOA_BABA (11778) | 9741 | 9737 |
| Kephri | NpcID.TOA_KEPHRI_BOSS_SHIELDED (11719) | 9572 | 9572 |
| Zebak | NpcID.TOA_ZEBAK (11730) | 9618 | -1 |
| Tumeken's Warden | NpcID.TOA_WARDEN_TUMEKEN_PHASE1 (11749) | 9665 | 9649 |
| Elidinis' Warden | NpcID.TOA_WARDEN_ELIDINIS_PHASE1 (11748) | 9665 | 9649 |

### Bosses: Quests

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Abomination | NpcID.MYQ4_ABOMINATION (8262) | 8022 | 8028 |
| Agrith-Naar | NpcID.AGRITH_NAAR (911) | 4675 | 4674 |
| Ancient Guardian | NpcID.BIM_GOLEM_BOSS (10654) | 8941 | 8939 |
| Arrg | NpcID.TROLLROMANCE_ARRG_ATTACKABLE (643) | 286 | 283 |
| Barrelchest | NpcID.BRAIN_BARREL_CHEST (600) | 5893 | 5892 |
| Black Knight Titan | NpcID.BLACK_KNIGHT_TITAN (4067) | 130 | 127 |
| Bouncer | NpcID.ARENA_BOUNCER (1224) | 6580 | 6582 |
| General Khazard | NpcID.SHADOW_MAJ_KHAZARD (3510) | 9874 | 9875 |
| Chronozon | NpcID.CHRONOZON (4987) | 66 | 63 |
| Corrupt Lizardman | NpcID.SHAYZIENQUEST_LIZARDMAN_BOSS (8000) | 7191 | 7195 |
| Count Draynor | NpcID.COUNT_DRAYNOR (3481) | 808 | 819 |
| Culinaromancer | NpcID.HUNDRED_CULINAROMANCER_BASE (3400) | 808 | 819 |
| Cuthbert | NpcID.FROG_QUEST_CUTHBERT_NAMED (12955) | 1796 | 1797 |
| Dad | NpcID.TROLL_CHAMPION (4130) | 925 | 1140 |
| Delrith | NpcID.DELRITH (5079) | 66 | 63 |
| Elvarg | NpcID.ELVARG_ALIVE (8033) | -1 | -1 |
| Evil Spirit | NpcID.DEAL_EVIL_SPIRIT (625) | 2803 | 2802 |
| Fragment of Seren | NpcID.DARK_SEREN (8917) | 8372 | 8372 |
| Gadderanks | NpcID.BURGH_GADDERANKS (4483) | 2065 | 2064 |
| Galvek | NpcID.GALVEK_WAVES (8094) | 7902 | 7902 |
| Giant Roc | NpcID.MYARM_GIANT_ROC (763) | 5021 | 5022 |
| giant scarab | NpcID.CONTACT_SCARAB_BOSS (797) | 5455 | 5454 |
| Giant Sea Snake | NpcID.ROYAL_SEA_SNAKE_MOTHER_SMALLER (1101) | 4037 | 4037 |
| Glod | NpcID.GRIM_GLOD (5129) | 6504 | 6505 |
| Ice Troll King | NpcID.FRIS_TROLL_KING_TRUE (5822) | 286 | 283 |
| Ithoi the Navigator | NpcID.CORSCURS_NAVIGATOR (7961) | 808 | 819 |
| Jungle demon | NpcID.MM_DEMON (1443) | 66 | 63 |
| Khazard Ogre | NpcID.ARENA_OGRE (1225) | 357 | 358 |
| Koschei the Deathless | NpcID.VIKING_ENEMY1 (3897) | 813 | 819 |
| Lowerniel Drakan | NpcID.MYQ6_LOWERNIEL_HURT (15936) | 8726 | 8725 |
| Me | NpcID.QUEST_LUNAR_MIRROR_OF_PLAYER (785) | 813 | 1205 |
| Melzar the Mad | NpcID.MELZAR_THE_MAD (823) | 808 | 819 |
| Moss Guardian | NpcID.ROVING_MOSSGIANT (891) | 4656 | 4654 |
| Nezikchened | NpcID.NEZIKCHENED (3962) | 66 | 63 |
| Ranis Drakan | NpcID.MYQ3_RANIS_DRAKAN (3744) | 4702 | 4699 |
| Sand Snake | NpcID.HOSIDIUSQUEST_SNAKE (7903) | 3535 | 3537 |
| Sea Troll Queen | NpcID.SWAN_SEATROLL_QUEEN (4315) | 3989 | -1 |
| Sigmund | NpcID.DTTD_SIGMUND_MILL (990) | 808 | 819 |
| Sir Leye | NpcID.RD_COMBAT_NPC_ROOM_3 (4682) | 808 | 819 |
| Sir Mordred | NpcID.SIR_MORDRED (3527) | 6487 | 6486 |
| Slagilith | NpcID.SLAGILITH (1362) | 1749 | 1748 |
| Slash Bash | NpcID.ZOGRE_SLASH_BASH (882) | 357 | 358 |
| Tolna | NpcID.SOULBANE_TOLNA (1057) | 5752 | 819 |
| Treus Dayth | NpcID.HAUNTEDMINE_BOSS_GHOST (3616) | 5538 | 5539 |
| Ulfric | NpcID.OLAF2_ULFRIC (4500) | 6113 | 6112 |
| black golem | NpcID.ELID_GOLEM_BLACK (4742) | 1913 | 1912 |
| grey golem | NpcID.ELID_GOLEM_GREY (4744) | 1913 | 1912 |
| white golem | NpcID.ELID_GOLEM_WHITE (4743) | 1913 | 1912 |
| Dessous | NpcID.BLOODDIAMOND_VAMPIREWARRIOR (3459) | 808 | 819 |
| Kamil | NpcID.ICEDIAMOND_ICEWARRIOR (3458) | 842 | 841 |
| Fareed | NpcID.FIREDIAMOND_FIREWARRIOR (3456) | 808 | 819 |
| Damis | NpcID.FD_DAMIS_NORMAL (682) | 808 | 819 |
| Agrith Na-Na | NpcID.HUNDRED_MINION1 (4880) | 3498 | 3499 |
| Flambeed | NpcID.HUNDRED_MINION2 (4881) | 1749 | 1748 |
| Karamel | NpcID.HUNDRED_MINION3 (4882) | 808 | 819 |
| Dessourt | NpcID.HUNDRED_MINION4 (4883) | 3504 | 3506 |
| Gelatinnoth Mother | NpcID.HUNDRED_MINION5_AIR (4884) | 1338 | 1339 |
| The Inadequacy | NpcID.DREAM_INADEQUACY (3473) | 6317 | 6317 |
| The Everlasting | NpcID.DREAM_EVERLASTING (3474) | 6343 | 6344 |
| The Untouchable | NpcID.DREAM_UNTOUCHABLE (3475) | 6328 | 6328 |
| The Illusive | NpcID.DREAM_ILLUSIVE (3476) | 6338 | 6339 |
| Kruk | NpcID.MM_KRUK (5257) | 1386 | 1385 |
| Kob | NpcID.MM2_GENERAL_KOB_COMBAT (7107) | 927 | 1141 |
| Keef | NpcID.MM2_CHIEFTAN_KEEF_COMBAT (7105) | 357 | 358 |
| Robert the Strong | NpcID.DREAM_ROBERT_COMBAT (8057) | 808 | 819 |
| Essyllt | NpcID.REGICIDE_EVIL_ELF1 (3415) | 808 | 819 |
| Surok Magis | NpcID.SUROK_SUROK_TYPE1 (4159) | 808 | 819 |
| Balance Elemental | NpcID.WGS_BALANCE_ELEMENTAL (13528) | 11352 | 11353 |
| Prince Itzla Arkan | NpcID.VMQ2_ITZLA_COMBAT (12898) | 808 | 819 |
| golem guard | NpcID.COA_MASTABA_GOLEM (14125) | 10778 | 10775 |
| Arrav | NpcID.DOV_ARRAV_COMBAT (12613) | 808 | 819 |
| Emissary Enforcer | NpcID.VMQ4_TEMPLE_GUARD_BOSS_PATROL (14266) | 808 | 819 |
| Lucius | NpcID.VMQ4_KEYSTONE_CHAMBER_BOSS_MAGIC (14363) | 813 | 1205 |
| Chimalli | NpcID.VMQ4_KEYSTONE_CHAMBER_BOSS_RANGED (14362) | 808 | 819 |
| Ennius Tullus | NpcID.VMQ4_CRYPT_ENNIUS_BOSS (14331) | 808 | 819 |
| Augur Metzli | NpcID.VMQ4_CRYPT_METZLI_NOOPS (14318) | 813 | 1205 |
| Wyrd | NpcID.SAFALAAN_WYRD (16212) | 14014 | 14016 |
| Glough | NpcID.GRANDTREE_GLOUGH_BATTLE (1425) | 2331 | 12042 |
| Dagannoth Mother | NpcID.HORROR_DAGGANOTH_AIRA (980) | 1344 | 1344 |
| Dramen Tree Spirit | NpcID.TREE_SPIRIT (1163) | 5530 | 5531 |
| Draugen | NpcID.VIKING_DRAUGEN (3922) | 808 | 819 |
| Evil Chicken | NpcID.CHICKENQUEST_EVIL_CHICKEN (1870) | 2298 | 2297 |
| Arzinian Avatar: Strength | NpcID.DWARF_ROCK_AVATAR_WARRIOR (1227) | 1838 | 1839 |
| Arzinian Avatar: Ranging | NpcID.DWARF_ROCK_AVATAR_ARCHER (1230) | 1838 | 1839 |
| Arzinian Avatar: Magic | NpcID.DWARF_ROCK_AVATAR_MAGE (1233) | 1838 | 1839 |
| Tarn Razorlor | NpcID.LOTR_TRAN_RAZORLOR_MUTANT (6477) | 5616 | 5615 |
| Bouncer (ghost) | NpcID.SHADOW_MAJ_BOUNCER (3509) | 6580 | 6582 |
| Black demon (The Grand Tree) | NpcID.BLACK_DEMON_STRONGHOLDCAVE_1 (240) | 66 | 63 |
| Glough: Mutated | NpcID.MM2_DEMON_GLOUGH (7101) | 4650 | 4649 |
| Elven traitor (Arianwyn) | NpcID.SOTE_ARIANWYN_COMBAT (8865) | 808 | 819 |

### Characters & cabbage

| Checkbox | Definition | Idle | Walk |
| --- | --- | --- | --- |
| Wise Old Man | NpcID.WISE_OLD_MAN (2108) | 813 | 1146 |
| Bob | NpcID.DS2_MEETING_BOB (8055) | 317 | 314 |
| Evil Bob | NpcID.MACRO_EVIL_BOB_OUTSIDE (390) | 317 | 314 |
| Cabbage | ItemID.CABBAGE (1965) | -1 | -1 |
| Giant cabbage | ItemID.CABBAGE (1965) | -1 | -1 |

