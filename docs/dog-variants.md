# Dog appearance catalogue

NPC follower IDs were originally read from the OSRS Wiki's structured page data on 2026-09-10 and checked against the local game cache. The expanded plugin uses RuneLite 1.13.1 gameval NPC constants for these same 72 choices. Their saved checkbox keys are preserved. See [the expanded catalogue](appearances.md) for current constants and all added appearances.

| Breed | Colors (in ID order) | Adult IDs | Puppy IDs |
| --- | --- | --- | --- |
| [Bernese Mountain Dog](https://oldschool.runescape.wiki/w/Bernese_Mountain_Dog) / [puppy](https://oldschool.runescape.wiki/w/Bernese_Mountain_Dog_puppy) | Chocolate, Merle, Toasted | 16385, 16386, 16387 | 16457, 16458, 16459 |
| [Border Collie](https://oldschool.runescape.wiki/w/Border_Collie) / [puppy](https://oldschool.runescape.wiki/w/Border_Collie_puppy) | Chocolate, Merle, Black & white | 16367, 16368, 16369 | 16442, 16443, 16444 |
| [Chihuahua](https://oldschool.runescape.wiki/w/Chihuahua) / [puppy](https://oldschool.runescape.wiki/w/Chihuahua_puppy) | Tan, White, Toasted | 16364, 16365, 16366 | 16439, 16440, 16441 |
| [Corgi](https://oldschool.runescape.wiki/w/Corgi) / [puppy](https://oldschool.runescape.wiki/w/Corgi_puppy) | Tan, Fawn, Toasted | 16370, 16371, 16372 | 16445, 16446, 16447 |
| [Greyhound](https://oldschool.runescape.wiki/w/Greyhound) / [puppy](https://oldschool.runescape.wiki/w/Greyhound_puppy) | Tan, Grey, Cream | 16373, 16374, 16375 | 16448, 16449, 16450 |
| [Husky](https://oldschool.runescape.wiki/w/Husky) / [puppy](https://oldschool.runescape.wiki/w/Husky_puppy) | Black & white, Grey, Chocolate | 16376, 16377, 16378 | 16436, 16437, 16438 |
| [Labrador](https://oldschool.runescape.wiki/w/Labrador) / [puppy](https://oldschool.runescape.wiki/w/Labrador_puppy) | Golden, Chocolate, Black | 16361, 16362, 16363 | 16433, 16434, 16435 |
| [Pug](https://oldschool.runescape.wiki/w/Pug) / [puppy](https://oldschool.runescape.wiki/w/Pug_puppy) | Fawn, Brown, Black | 16379, 16380, 16381 | 16451, 16452, 16453 |
| [Samoyed](https://oldschool.runescape.wiki/w/Samoyed) / [puppy](https://oldschool.runescape.wiki/w/Samoyed_puppy) | White, Golden, Black | 16382, 16383, 16384 | 16454, 16455, 16456 |
| [Shiba](https://oldschool.runescape.wiki/w/Shiba) / [puppy](https://oldschool.runescape.wiki/w/Shiba_puppy) | Tan, White, Toasted | 16388, 16389, 16390 | 16460, 16461, 16462 |
| [Spaniel](https://oldschool.runescape.wiki/w/Spaniel) / [puppy](https://oldschool.runescape.wiki/w/Spaniel_puppy) | Red, White, Black | 16391, 16392, 16393 | 16463, 16464, 16465 |
| [Yorkie](https://oldschool.runescape.wiki/w/Yorkie) / [puppy](https://oldschool.runescape.wiki/w/Yorkie_puppy) | Brown, White, Golden | 16394, 16395, 16396 | 16466, 16467, 16468 |

Native animations were verified using RuneLite's NpcManager on a copy of the game cache: all variants walk with `AnimationID.DOG_UPDATE_WALK`; all idle with `DOG_UPDATE_SMALL_DOG_READY` except Labrador and Chihuahua puppies, which use `DOG_UPDATE_SMALL_DOG_READY_SIMPLE`. The plugin loads models, recolors, and scale from the selected NPC definition. No game cache files are edited and no runtime network requests are added.

## Manual acceptance checks

- Default healing: brown west-gate dog, grey strays, and Duke retain their coat colors.
- Random mode with only Corgi puppy/fawn checked: all unnamed strays become that exact puppy; Duke stays healed and grey.
- Switch to only adult Corgi/fawn: verify adult size, color, idle, walking, and turning.
- Select several combinations: only selected appearances occur; no changing breeds while watching a loaded dog. Leaving the area and returning gives a fresh roll, which may repeat.
- No favorites or random mode off: normal healing. Master switch off: original injured models. Re-enable, relog, and hop worlds: no orphaned replacements.
- Check right-click options, overhead text, existing pet/shoo interactions, and using food on a dog, with random mode both off and on. Cosmetic models do not add server actions.
- Watch an ordinary healed stray walking: legs must animate rather than slide. Repeat for Duke and a favorite breed.
- Repeat visibility and interaction checks with GPU enabled and disabled (and any other renderer you use). Look for doubled original/replacement models. Rendering-only suppression must leave the original NPC's native click target intact.
- Test representatives of every breed and both ages, including Labrador/Chihuahua puppies with their distinct idle animation.
