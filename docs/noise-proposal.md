# Varrock Stray Cats — proposed interaction voices

Proposal only, 2026-10-04. No plugin source or configuration changes made for this request.

This is overhead text replacing the cosmetic dog's reactions, not recorded audio or sound-effect IDs. Each row lists the proposed response to **pet / accepted feed / shoo**. Feed means the existing dog successfully receives bones or meat; a cosmetic refusal such as “Fish, please.” does not undo the server's feeding action. A future implementation should distinguish accepted food from rejected items.

## Matching interaction labels and player text

### Chat-box narration

Customize the automatic game messages for petting, shooing, and feeding as well as the overhead reactions. Dogs and cats always use **they/them/their**, including Duke, hellcats, canine pets and ghost dogs. For bosses and other appearances, use their proper name or a confirmed character pronoun; use **it/its** for cabbage, furniture, eggs and other objects. When a character's pronouns are uncertain, repeat their name instead of guessing.

| Appearance | Pet narration | Shoo narration | Accepted bone-feeding narration |
| --- | --- | --- | --- |
| Dogs and canine pets | You give them a gentle pat. They happily follow you. | They back away from you with a whine. | You give them some nice bones. They happily gnaw on them. |
| Cats, kittens and hellcats | You scratch them behind the ears. They lean into your hand. | They flick their tail and step away. | You offer them the bones. They sniff them, then nibble curiously. |
| Artio / Callisto | You pat Artio's thick fur. A low rumble answers you. | Artio gives a warning growl and lumbers away. | Artio crunches the bones between powerful jaws. |
| Great Olm | You stroke Great Olm's head. A deep rumble echoes back. | Great Olm turns away with a cavernous growl. | Great Olm crushes the bones with a resonant crunch. |
| Sol Heredit | You pat Sol Heredit's armour. He gives you a stern look. | Sol Heredit steps away, visibly offended. | Sol Heredit examines the bones with disdain. |
| Wise Old Man | You give the Wise Old Man a friendly pat. He clears his throat. | The Wise Old Man walks away, muttering about manners. | The Wise Old Man inspects the bones. He seems unimpressed. |
| Cabbage | You pat the cabbage. Its leaves rustle: Kah-Bah-Gee! | The cabbage rolls away with an indignant rustle. | You hear a faint, leafy crunch as the bone dissolves into fertilizer. |
| Giant cabbage | You pat the giant cabbage. Its leaves rustle: KAH-BAH-GEE! | The giant cabbage rolls away with an indignant rustle. | The bones vanish into the folds, followed by a wet, echoing crunch. |
| Stone / runic constructs | You pat {Name}. A low hum answers you. | {Name} retreats with a grinding sound. | {Name} studies the bones, then sets them aside. |
| Fish / fishbowl pets | You gently tap the bowl. {Name} swims closer. | {Name} turns away with a trail of bubbles. | {Name} blows a bubble at the bones. Fish food might be more suitable. |
| Plant creatures | You stroke {Name}'s leaves. They rustle softly. | {Name} withdraws with a leafy hiss. | {Name}'s roots curl around the bones like fresh compost. |
| Spooky chair | You pat the spooky chair. It creaks contentedly. | The spooky chair scrapes away with a long creak. | The spooky chair creaks at the bones. It has nowhere to put them. |
| Unhatched egg pets | You gently pat {Name}. A faint tapping answers you. | {Name} rocks away from you. | The bones rest beside {Name}. No beak has hatched to eat them yet. |

These are local cosmetic descriptions of the original successful action. A character declining to eat does not return an item already consumed by the game's stray-dog interaction. Distinguish bones from meat: dog meat feeding says “They happily gobble it up.”; cats use “They nibble the food contentedly.”; cabbage meat feeding needs its own compost sentence, while the user's exact **bone** sentence above remains verbatim. Rejected items should get a matching uninterested reaction instead of a successful feeding description.

Every appearance should receive the fitting creature-specific narration from its voice profile below rather than blindly retaining “dog,” “it happily gnaws,” or a gendered dog pronoun. The table supplies concrete wording for the key appearances and reusable creature types; individual narration for the remaining bosses/pets is still to be drafted, not silently treated as verified NPC dialogue.

For each row's **Name**, show `Pet Name`, `Shoo-away Name`, `Examine Name`, and `Use Bones -> Name` (or the actual selected food). Keep `Walk here` and `Cancel` as they are. This is a local label change: clicking still performs the original stray dog's action. Bosses get “Who's a good bossy?”, cats “Who's a good kitty?”, the Wise Old Man “Who's a good old man?”, and both cabbage sizes “Who's a good cabbage?”. Other pets get a short name-specific version, listed in full below.

Only replace the game's automatic player reaction associated with the targeted interaction, including its local overhead/chat display. Never rewrite player-authored public/clan/private chat. For the automatic shoo line, keep “Go on, Name!”; for accepted feeding, propose “Here you go, Name!” where an automatic line/message already exists. Dog-specific feeding/examine messages should use the chosen Name locally too. Custom examine descriptions are not proposed here; do not display a false boss combat level or add combat/talk/pick-up actions.

All **494 appearance checkboxes** are listed individually, including coats, stages, legacy forms, transmogs, dog options, and both cabbages. Colour-only variants share their creature's voice. Same-species pets can share sensible calls with their parent boss; the pet must never inherit an unrelated dog voice. Existing dog appearances and genuinely canine pets keep dog noises.

**Evidence:** “Existing” identifies calls verified in the sources below, reused in a new interaction context. “Proposed” is an original suggestion based on the creature or character; it is not a claim that Jagex uses that exact line. Not every NPC transcript or audio asset was verified. Before implementation, verified matching NPC/pet calls should supersede proposed imitations. Recent cache-only identities especially need a transcript/audio check. Human characters use short speech; plants, rocks, fish, insects and furniture use stylized rustles, resonance, bubbles, clicks and creaks rather than pretending every creature has mammal vocal cords.

Sources:

- [C: Cat transcript](https://oldschool.runescape.wiki/w/Transcript:Cat): purring, meowing and hissing; kitten/lazy/wily/hell adaptations are original proposals.
- [D: Spidey dog transcript](https://oldschool.runescape.wiki/w/Transcript:Spidey_dog): confirms the pet/feed/shoo dog reaction pattern.
- [G: General Graardor Jr. transcript](https://oldschool.runescape.wiki/w/Transcript:General_Graardor_Jr.): roar and bone-grinding/puny-foe lines. Parent uses the same proposed short interaction set.
- [O: Order of Cabbage's own forum](https://www.tapatalk.com/groups/the_order_of_cabbage/) and [Cabbagepalooza announcement](https://forum.tip.it/topic/297020-the-order-of-cabbage-cabbagepalooza-7-over/): Kah-Bah-Gee chant and cabbage-patch tradition. Other cabbage calls below are original.
- [Sol Heredit](https://oldschool.runescape.wiki/w/Fortis_boss): sun-heir theme; proposed reactions are not combat quotes.

## Original targeted NPCs

The source strays remain the actual interactive NPCs. Their chosen appearance determines the voice. With healing only (no chosen appearance), keep normal dog reactions.

| Target | NPC symbol | Pet | Feed | Shoo |
| --- | --- | --- | --- | --- |
| Stray dog, grey | DOG_STRAY | Woof! | Woof woof! | Whine! |
| Stray dog, brown | DOG_STRAY2 | Woof! | Woof woof! | Whine! |
| Duke | XMAS24_STRAYDOG_FINAL | Woof! | Woof woof! | Whine! |

## Cats: Adult

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Default | NPC 1619 | Cat | Who's a good kitty? | Purr...purr... | Meow! | Hiss! | Existing cat calls [C]; assigned to these actions |
| White | NPC 1620 | Cat | Who's a good kitty? | Purr...purr... | Meow! | Hiss! | Existing cat calls [C]; assigned to these actions |
| Brown | NPC 1621 | Cat | Who's a good kitty? | Purr...purr... | Meow! | Hiss! | Existing cat calls [C]; assigned to these actions |
| Black | NPC 1622 | Cat | Who's a good kitty? | Purr...purr... | Meow! | Hiss! | Existing cat calls [C]; assigned to these actions |
| Brown & grey | NPC 1623 | Cat | Who's a good kitty? | Purr...purr... | Meow! | Hiss! | Existing cat calls [C]; assigned to these actions |
| Blue & grey | NPC 1624 | Cat | Who's a good kitty? | Purr...purr... | Meow! | Hiss! | Existing cat calls [C]; assigned to these actions |
| Hell | NPC 1625 | Hellcat | Who's a good kitty? | Prrr-grr... | Mrrrow, crunch! | HSSSS! | Proposed: hellcat versions of cat calls [C] |

## Cats: Kitten

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Default | NPC 5591 | Kitten | Who's a good kitty? | Mew-purr! | Mew, munch! | Meeeow! | Proposed kitten variation of cat calls [C] |
| White | NPC 5592 | Kitten | Who's a good kitty? | Mew-purr! | Mew, munch! | Meeeow! | Proposed kitten variation of cat calls [C] |
| Brown | NPC 5593 | Kitten | Who's a good kitty? | Mew-purr! | Mew, munch! | Meeeow! | Proposed kitten variation of cat calls [C] |
| Black | NPC 5594 | Kitten | Who's a good kitty? | Mew-purr! | Mew, munch! | Meeeow! | Proposed kitten variation of cat calls [C] |
| Brown & grey | NPC 5595 | Kitten | Who's a good kitty? | Mew-purr! | Mew, munch! | Meeeow! | Proposed kitten variation of cat calls [C] |
| Blue & grey | NPC 5596 | Kitten | Who's a good kitty? | Mew-purr! | Mew, munch! | Meeeow! | Proposed kitten variation of cat calls [C] |
| Hell | NPC 5597 | Hellkitten | Who's a good kitty? | Prrr-grr... | Mrrrow, crunch! | HSSSS! | Proposed: hellcat versions of cat calls [C] |

## Cats: Lazy

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| White | NPC 1626 | Lazy cat | Who's a good kitty? | Prrr... zzz... | Mrrp, munch! | Mrrr... | Proposed lazy variation of cat calls [C] |
| Default | NPC 1627 | Lazy cat | Who's a good kitty? | Prrr... zzz... | Mrrp, munch! | Mrrr... | Proposed lazy variation of cat calls [C] |
| Brown | NPC 1628 | Lazy cat | Who's a good kitty? | Prrr... zzz... | Mrrp, munch! | Mrrr... | Proposed lazy variation of cat calls [C] |
| Black | NPC 1629 | Lazy cat | Who's a good kitty? | Prrr... zzz... | Mrrp, munch! | Mrrr... | Proposed lazy variation of cat calls [C] |
| Brown & grey | NPC 1630 | Lazy cat | Who's a good kitty? | Prrr... zzz... | Mrrp, munch! | Mrrr... | Proposed lazy variation of cat calls [C] |
| Blue & grey | NPC 1631 | Lazy cat | Who's a good kitty? | Prrr... zzz... | Mrrp, munch! | Mrrr... | Proposed lazy variation of cat calls [C] |
| Hell | NPC 1632 | Lazy hellcat | Who's a good kitty? | Prrr-grr... | Mrrrow, crunch! | HSSSS! | Proposed: hellcat versions of cat calls [C] |

## Cats: Overgrown

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Default | NPC 5598 | Overgrown cat | Who's a good kitty? | Prrrr... | Mrrr, munch! | Meeeooow! | Proposed overgrown variation of cat calls [C] |
| White | NPC 5599 | Overgrown cat | Who's a good kitty? | Prrrr... | Mrrr, munch! | Meeeooow! | Proposed overgrown variation of cat calls [C] |
| Brown | NPC 5600 | Overgrown cat | Who's a good kitty? | Prrrr... | Mrrr, munch! | Meeeooow! | Proposed overgrown variation of cat calls [C] |
| Black | NPC 5601 | Overgrown cat | Who's a good kitty? | Prrrr... | Mrrr, munch! | Meeeooow! | Proposed overgrown variation of cat calls [C] |
| Brown & grey | NPC 5602 | Overgrown cat | Who's a good kitty? | Prrrr... | Mrrr, munch! | Meeeooow! | Proposed overgrown variation of cat calls [C] |
| Blue & grey | NPC 5603 | Overgrown cat | Who's a good kitty? | Prrrr... | Mrrr, munch! | Meeeooow! | Proposed overgrown variation of cat calls [C] |
| Hell | NPC 5604 | Overgrown hellcat | Who's a good kitty? | Prrr-grr... | Mrrrow, crunch! | HSSSS! | Proposed: hellcat versions of cat calls [C] |

## Cats: Wily

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| White | NPC 5584 | Wily cat | Who's a good kitty? | Prrr-rrrow! | Mrrp, crunch! | Hiss! | Proposed wily variation of cat calls [C] |
| Default | NPC 5585 | Wily cat | Who's a good kitty? | Prrr-rrrow! | Mrrp, crunch! | Hiss! | Proposed wily variation of cat calls [C] |
| Brown | NPC 5586 | Wily cat | Who's a good kitty? | Prrr-rrrow! | Mrrp, crunch! | Hiss! | Proposed wily variation of cat calls [C] |
| Black | NPC 5587 | Wily cat | Who's a good kitty? | Prrr-rrrow! | Mrrp, crunch! | Hiss! | Proposed wily variation of cat calls [C] |
| Brown & grey | NPC 5588 | Wily cat | Who's a good kitty? | Prrr-rrrow! | Mrrp, crunch! | Hiss! | Proposed wily variation of cat calls [C] |
| Blue & grey | NPC 5589 | Wily cat | Who's a good kitty? | Prrr-rrrow! | Mrrp, crunch! | Hiss! | Proposed wily variation of cat calls [C] |
| Hell | NPC 5590 | Wily hellcat | Who's a good kitty? | Prrr-grr... | Mrrrow, crunch! | HSSSS! | Proposed: hellcat versions of cat calls [C] |

## Dogs: Bernese Mountain Dog

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Chocolate | NPC 16457 | Bernese Mountain Dog puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Merle | NPC 16458 | Bernese Mountain Dog puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Toasted | NPC 16459 | Bernese Mountain Dog puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Chocolate | NPC 16385 | Bernese Mountain Dog | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Merle | NPC 16386 | Bernese Mountain Dog | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Toasted | NPC 16387 | Bernese Mountain Dog | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Border Collie

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Chocolate | NPC 16442 | Border Collie puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Merle | NPC 16443 | Border Collie puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Black White | NPC 16444 | Border Collie puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Chocolate | NPC 16367 | Border Collie | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Merle | NPC 16368 | Border Collie | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Black White | NPC 16369 | Border Collie | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Chihuahua

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Tan | NPC 16439 | Chihuahua puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: White | NPC 16440 | Chihuahua puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Toasted | NPC 16441 | Chihuahua puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Tan | NPC 16364 | Chihuahua | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: White | NPC 16365 | Chihuahua | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Toasted | NPC 16366 | Chihuahua | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Corgi

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Tan | NPC 16445 | Corgi puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Fawn | NPC 16446 | Corgi puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Toasted | NPC 16447 | Corgi puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Tan | NPC 16370 | Corgi | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Fawn | NPC 16371 | Corgi | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Toasted | NPC 16372 | Corgi | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Greyhound

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Tan | NPC 16448 | Greyhound puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Grey | NPC 16449 | Greyhound puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Cream | NPC 16450 | Greyhound puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Tan | NPC 16373 | Greyhound | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Grey | NPC 16374 | Greyhound | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Cream | NPC 16375 | Greyhound | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Husky

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Black White | NPC 16436 | Husky puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Grey | NPC 16437 | Husky puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Chocolate | NPC 16438 | Husky puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Black White | NPC 16376 | Husky | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Grey | NPC 16377 | Husky | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Chocolate | NPC 16378 | Husky | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Labrador

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Golden | NPC 16433 | Labrador puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Chocolate | NPC 16434 | Labrador puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Black | NPC 16435 | Labrador puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Golden | NPC 16361 | Labrador | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Chocolate | NPC 16362 | Labrador | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Black | NPC 16363 | Labrador | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Pug

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Fawn | NPC 16451 | Pug puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Brown | NPC 16452 | Pug puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Black | NPC 16453 | Pug puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Fawn | NPC 16379 | Pug | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Brown | NPC 16380 | Pug | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Black | NPC 16381 | Pug | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Samoyed

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: White | NPC 16454 | Samoyed puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Golden | NPC 16455 | Samoyed puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Black | NPC 16456 | Samoyed puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: White | NPC 16382 | Samoyed | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Golden | NPC 16383 | Samoyed | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Black | NPC 16384 | Samoyed | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Shiba

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Tan | NPC 16460 | Shiba puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: White | NPC 16461 | Shiba puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Toasted | NPC 16462 | Shiba puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Tan | NPC 16388 | Shiba | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: White | NPC 16389 | Shiba | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Toasted | NPC 16390 | Shiba | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Spaniel

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Red | NPC 16463 | Spaniel puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: White | NPC 16464 | Spaniel puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Black | NPC 16465 | Spaniel puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Red | NPC 16391 | Spaniel | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: White | NPC 16392 | Spaniel | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Black | NPC 16393 | Spaniel | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Dogs: Yorkie

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Puppy: Brown | NPC 16466 | Yorkie puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: White | NPC 16467 | Yorkie puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Puppy: Golden | NPC 16468 | Yorkie puppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Brown | NPC 16394 | Yorkie | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: White | NPC 16395 | Yorkie | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Adult: Golden | NPC 16396 | Yorkie | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |

## Pets: Bosses & raids

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Dark core | NPC 318 | Dark core | Who's a good little dark core? | Vrrr-ooo... | Hollow hunger... | WHOOOM! | Proposed: spectral beast/core resonance |
| Chaos Elemental Jr. | NPC 2055 | Chaos Elemental Jr. | Who's a good little chaos elemental jr.? | Blrrp? | Glorp! | BZZRRP! | Proposed: incoherent chaos warble |
| Snakeling: Green | NPC 2130 | Snakeling | Who's a good little snakeling? | Sss-sss... | Sss, gulp! | HSSSS! | Proposed: serpent hiss |
| Snakeling: Orange | NPC 2131 | Snakeling | Who's a good little snakeling? | Sss-sss... | Sss, gulp! | HSSSS! | Proposed: serpent hiss |
| Snakeling: Blue | NPC 2132 | Snakeling | Who's a good little snakeling? | Sss-sss... | Sss, gulp! | HSSSS! | Proposed: serpent hiss |
| Sraracha: Default | NPC 2144 | Sraracha | Who's a good little sraracha? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Phoenix: Green | NPC 3081 | Phoenix | Who's a good little phoenix? | Chirr-fsssh! | Seeds, please. | SKREE-FWOOSH! | Proposed: fiery bird |
| Phoenix: Blue | NPC 3082 | Phoenix | Who's a good little phoenix? | Chirr-fsssh! | Seeds, please. | SKREE-FWOOSH! | Proposed: fiery bird |
| Phoenix: White | NPC 3083 | Phoenix | Who's a good little phoenix? | Chirr-fsssh! | Seeds, please. | SKREE-FWOOSH! | Proposed: fiery bird |
| Phoenix: Purple | NPC 3084 | Phoenix | Who's a good little phoenix? | Chirr-fsssh! | Seeds, please. | SKREE-FWOOSH! | Proposed: fiery bird |
| Hellpuppy | NPC 3099 | Hellpuppy | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Venenatis spiderling: Default | NPC 5557 | Venenatis spiderling | Who's a good little venenatis spiderling? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Callisto cub: Default | NPC 5558 | Callisto cub | Who's a good little callisto cub? | Rrrrum... | Huff, crunch! | GRRRAWR! | Proposed: bear rumble and warning growl |
| Vet'ion Jr.: Default | NPC 5559 | Vet'ion Jr. | Who's a good little vet'ion jr.? | Rattle... | More bones! | CLATTER! | Proposed: skeletal warrior |
| Vet'ion Jr.: Reborn | NPC 5560 | Vet'ion Jr. | Who's a good little vet'ion jr.? | Rattle... | More bones! | CLATTER! | Proposed: skeletal warrior |
| Scorpia's offspring | NPC 5561 | Scorpia's offspring | Who's a good little scorpia's offspring? | Tik-tik! | Krik, crunch! | KSSS! | Proposed: scorpion clicks |
| Abyssal orphan | NPC 5884 | Abyssal orphan | Who's a good little abyssal orphan? | Hrrr-glrk... | Glrk, gulp! | HRRRAAH! | Proposed: abyssal creature |
| TzRek-Jad | NPC 5893 | TzRek-Jad | Who's a good little tzrek-jad? | Hrrrum... | Krr, crunch! | HRRAAH! | Proposed: volcanic beast |
| Dagannoth Supreme Jr. | NPC 6628 | Dagannoth Supreme Jr. | Who's a good little dagannoth supreme jr.? | Krr-krr! | Krak, crunch! | SKREE! | Proposed: ranged dagannoth |
| Dagannoth Prime Jr. | NPC 6629 | Dagannoth Prime Jr. | Who's a good little dagannoth prime jr.? | Krrr-ooo... | Krr, crunch! | KREEE! | Proposed: magical dagannoth |
| Dagannoth Rex Jr. | NPC 6630 | Dagannoth Rex Jr. | Who's a good little dagannoth rex jr.? | Rrrrum... | Rrr, crunch! | ROAAR! | Proposed: heavy melee dagannoth |
| Kree'arra Jr. | NPC 6631 | Kree'arra Jr. | Who's a good little kree'arra jr.? | Krr-ree! | Kraak, crunch! | SKREE! | Proposed: aviansie screech |
| General Graardor Jr. | NPC 6632 | General Graardor Jr. | Who's a good little general graardor jr.? | ARRRGGGGH! | I grind your bones! | You die, puny foe! | Existing phrases [G]; assigned to new actions |
| Zilyana Jr. | NPC 6633 | Zilyana Jr. | Who's a good little zilyana jr.? | Ahem. | No, thank you. | Saradomin guide you. | Proposed: dignified Saradominist speech |
| K'ril Tsutsaroth Jr. | NPC 6634 | K'ril Tsutsaroth Jr. | Who's a good little k'ril tsutsaroth jr.? | Grrr-hah! | Crunch! | GRRRAH! | Proposed: guttural demon voice |
| Baby Mole | NPC 6635 | Baby Mole | Who's a good little baby mole? | Snff-snff! | Chrr, munch! | Eep! | Proposed: burrowing mammal |
| Prince Black Dragon | NPC 6636 | Prince Black Dragon | Who's a good little prince black dragon? | Rrrr... | Three cheers! | GRRROAR! | Proposed: dragon rumble; three cheers only for three-headed forms |
| Kalphite Princess: Flying | NPC 6637 | Kalphite Princess | Who's a good little kalphite princess? | Trik-trik! | Klik, crunch! | SKRIT! | Proposed: insect clicks |
| Kalphite Princess: Walking | NPC 6638 | Kalphite Princess | Who's a good little kalphite princess? | Trik-trik! | Klik, crunch! | SKRIT! | Proposed: insect clicks |
| Smoke Devil: Modern | NPC 6639 | Smoke Devil | Who's a good little smoke devil? | Fsssh... | Fff, ash! | WHOOOSH! | Proposed: smoke elemental |
| Kraken | NPC 6640 | Kraken | Who's a good little kraken? | Glub-glub... | Glup! | GLRRAH! | Proposed: tentacled sea monster |
| Phoenix: Orange | NPC 7370 | Phoenix | Who's a good little phoenix? | Chirr-fsssh! | Seeds, please. | SKREE-FWOOSH! | Proposed: fiery bird |
| Olmlet | NPC 7520 | Olmlet | Who's a good little olmlet? | Rrr-ooo... | Krr, crunch! | KRAAAH! | Proposed: cavern salamander/dragon rumble |
| Scurry | NPC 7616 | Scurry | Who's a good little scurry? | Squeak! | Squeak, crunch! | Screee! | Proposed: rat vocalizations |
| Skotos | NPC 7671 | Skotos | Who's a good little skotos? | Grrr-ooo... | Crunch! | GRAAAH! | Proposed: dark demon |
| Jal-Nib-Rek | NPC 7675 | Jal-Nib-Rek | Who's a good little jal-nib-rek? | Krr-krr! | Krik, crunch! | Skrit! | Proposed: volcanic nibbler |
| Noon | NPC 7892 | Noon | Who's a good little noon? | Krrr... | Stone, not bones. | SKREE! | Proposed: winged gargoyle |
| Midnight | NPC 7893 | Midnight | Who's a good little midnight? | Rrr-grind... | Krr, crunch! | GRRRAH! | Proposed: stone gargoyle |
| Corporeal Critter | NPC 8010 | Corporeal Critter | Who's a good little corporeal critter? | Vrrr-ooo... | Hollow hunger... | WHOOOM! | Proposed: spectral beast/core resonance |
| TzRek-Zuk | NPC 8011 | TzRek-Zuk | Who's a good little tzrek-zuk? | Hrrr... | Stone, not bones. | GRAAAH! | Proposed: volcanic champion |
| Vorki | NPC 8029 | Vorki | Who's a good little vorki? | Hrrr... | Rrr, crunch! | KRAAAH! | Proposed: undead dragon rasp |
| Puppadile | NPC 8201 | Puppadile | Who's a good little puppadile? | Krrr... | Chomp! | KRAAAR! | Proposed: crocodilian, not a dog |
| Tektiny | NPC 8202 | Tektiny | Who's a good little tektiny? | Clink-clink! | Not for forging. | CLANG! | Proposed: smith and stone armour |
| Vanguard | NPC 8203 | Vanguard | Who's a good little vanguard? | Krrr... | Crunch! | SKRRR! | Proposed: subterranean guardian |
| Vasa Minirio | NPC 8204 | Vasa Minirio | Who's a good little vasa minirio? | Vrrr-hum... | Crystal, please. | KRAANG! | Proposed: crystal magic resonance |
| Vespina | NPC 8205 | Vespina | Who's a good little vespina? | Bzz-bzz! | Bzz, slurp! | BZZZZ! | Proposed: flying insect |
| Lil' Zik | NPC 8337 | Lil' Zik | Who's a good little lil' zik? | Heh-heh... | More! | How insolent! | Proposed: vampyric aristocrat/spider hybrid |
| Smoke Devil: Legacy | NPC 8483 | Smoke Devil | Who's a good little smoke devil? | Fsssh... | Fff, ash! | WHOOOSH! | Proposed: smoke elemental |
| Ikkle Hydra: Default | NPC 8492 | Ikkle Hydra | Who's a good little ikkle hydra? | Sss-krr... | Gulp-gulp! | HSSSRAH! | Proposed: multi-headed reptile |
| Ikkle Hydra: Electric | NPC 8493 | Ikkle Hydra | Who's a good little ikkle hydra? | Sss-krr... | Gulp-gulp! | HSSSRAH! | Proposed: multi-headed reptile |
| Ikkle Hydra: Fire | NPC 8494 | Ikkle Hydra | Who's a good little ikkle hydra? | Sss-krr... | Gulp-gulp! | HSSSRAH! | Proposed: multi-headed reptile |
| Ikkle Hydra: Extinguished | NPC 8495 | Ikkle Hydra | Who's a good little ikkle hydra? | Sss-krr... | Gulp-gulp! | HSSSRAH! | Proposed: multi-headed reptile |
| Little Parasite | NPC 8541 | Little Parasite | Who's a good little little parasite? | Tik-tik... | Slurp! | SKRIT! | Proposed: parasite |
| Youngllef | NPC 8737 | Youngllef | Who's a good little youngllef? | Krrr-chime... | Krik, crunch! | KRAAANG! | Proposed: crystal beast |
| Corrupted Youngllef | NPC 8738 | Corrupted Youngllef | Who's a good little corrupted youngllef? | Vrrr-chime... | Krr, crunch! | SKRAAANG! | Proposed: corrupted crystal beast |
| Smolcano | NPC 8739 | Smolcano | Who's a good little smolcano? | Hrrr-clink... | Ore, not bones. | GRRRAH! | Proposed: stone-imprisoned demon |
| Little Nightmare | NPC 9399 | Little Nightmare | Who's a good little little nightmare? | Hhhhhh... | Your fear feeds me. | EEEEEE! | Proposed: nightmare whisper and shriek |
| Enraged Tektiny | NPC 9513 | Enraged Tektiny | Who's a good little enraged tektiny? | Clink-clink! | Not for forging. | CLANG! | Proposed: smith and stone armour |
| Flying Vespina | NPC 9514 | Flying Vespina | Who's a good little flying vespina? | Bzz-bzz! | Bzz, slurp! | BZZZZ! | Proposed: flying insect |
| JalRek-Jad | NPC 10625 | JalRek-Jad | Who's a good little jalrek-jad? | Hrrrum... | Krr, crunch! | HRRAAH! | Proposed: volcanic beast |
| Tiny Tempor | NPC 10637 | Tiny Tempor | Who's a good little tiny tempor? | Whooosh... | Glub! | SPLAAASH! | Proposed: sea spirit |
| Baby Mole-rat | NPC 10651 | Baby Mole-rat | Who's a good little baby mole-rat? | Snff-snff! | Chrr, munch! | Eep! | Proposed: burrowing mammal |
| Lil' Maiden | NPC 10870 | Lil' Maiden | Who's a good little lil' maiden? | Hhh... | Blood, not bones. | AAAAH! | Proposed: blood-starved apparition |
| Lil' Bloat | NPC 10871 | Lil' Bloat | Who's a good little lil' bloat? | Brrr-gh... | Brrp! | GROOAN! | Proposed: bloated undead |
| Lil' Nylo | NPC 10872 | Lil' Nylo | Who's a good little lil' nylo? | Tik-trik! | Krik, crunch! | SKRIT! | Proposed: nylocas chitter |
| Lil' Sot | NPC 10873 | Lil' Sot | Who's a good little lil' sot? | Hrrr... | Crunch! | HRRRAAH! | Proposed: dark beast |
| Lil' Xarp | NPC 10874 | Lil' Xarp | Who's a good little lil' xarp? | Krrr-eee... | Glrk, gulp! | SKREEE! | Proposed: winged poison beast |
| Sraracha: Orange | NPC 11159 | Sraracha | Who's a good little sraracha? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Sraracha: Blue | NPC 11160 | Sraracha | Who's a good little sraracha? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Nexling | NPC 11277 | Nexling | Who's a good little nexling? | You amuse me. | An offering? | No escape! | Proposed: imperious voice; shoo adapts Nex escape motif |
| Tumeken's Guardian | NPC 11812 | Tumeken's Guardian | Who's a good little tumeken's guardian? | Hummm... | The sun needs none. | VROOOM! | Proposed: solar construct resonance |
| Elidinis' Guardian | NPC 11813 | Elidinis' Guardian | Who's a good little elidinis' guardian? | Whooom... | The river needs none. | SHOOOM! | Proposed: river construct resonance |
| Akkhito | NPC 11846 | Akkhito | Who's a good little akkhito? | Hmmm... | A humble offering. | Enough. | Proposed: disciplined warrior |
| Babi | NPC 11847 | Babi | Who's a good little babi? | Ook-ook! | Ook, munch! | AAK-AAK! | Proposed: baboon |
| Kephriti | NPC 11848 | Kephriti | Who's a good little kephriti? | Trik-trik! | Klik, crunch! | SKRIT! | Proposed: insect clicks |
| Zebo | NPC 11849 | Zebo | Who's a good little zebo? | Krrr-rr... | Chomp! | KRAAAR! | Proposed: crocodile |
| Tumeken's Damaged Guardian | NPC 11850 | Tumeken's Damaged Guardian | Who's a good little tumeken's damaged guardian? | Hummm... | The sun needs none. | VROOOM! | Proposed: solar construct resonance |
| Elidinis' Damaged Guardian | NPC 11851 | Elidinis' Damaged Guardian | Who's a good little elidinis' damaged guardian? | Whooom... | The river needs none. | SHOOOM! | Proposed: river construct resonance |
| Venenatis spiderling: Legacy | NPC 11985 | Venenatis spiderling | Who's a good little venenatis spiderling? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Callisto cub: Legacy | NPC 11986 | Callisto cub | Who's a good little callisto cub? | Rrrrum... | Huff, crunch! | GRRRAWR! | Proposed: bear rumble and warning growl |
| Vet'ion Jr.: Legacy | NPC 11987 | Vet'ion Jr. | Who's a good little vet'ion jr.? | Rattle... | More bones! | CLATTER! | Proposed: skeletal warrior |
| Vet'ion Jr.: Reborn Legacy | NPC 11988 | Vet'ion Jr. | Who's a good little vet'ion jr.? | Rattle... | More bones! | CLATTER! | Proposed: skeletal warrior |
| Muphin: Default | NPC 12014 | Muphin | Who's a good little muphin? | Grrr-glrp... | Glrrp! | GRRRAA! | Proposed: phantom beast growl |
| Muphin: Melee | NPC 12015 | Muphin | Who's a good little muphin? | Grrr-glrp... | Glrrp! | GRRRAA! | Proposed: phantom beast growl |
| Muphin: Shielded | NPC 12016 | Muphin | Who's a good little muphin? | Grrr-glrp... | Glrrp! | GRRRAA! | Proposed: phantom beast growl |
| Wisp | NPC 12157 | Wisp | Who's a good little wisp? | Ssshh... | A hollow gift... | Leave... | Proposed: ghostly whisper |
| Butch | NPC 12158 | Butch | Who's a good little butch? | Hrrrk... | Roots drink deep. | GRAAH! | Proposed: strangler-root-controlled corpse |
| Baron | NPC 12159 | Baron | Who's a good little baron? | Hrrmm... | Glorp, gulp! | Hrrrogh! | Proposed: sleepy demonic gulp and grunt |
| Lil'viathan | NPC 12160 | Lil'viathan | Who's a good little lil'viathan? | Krrrss... | Krr, gulp! | KRAAAH! | Proposed: abyssal sea serpent |
| Bran | NPC 12593 | Bran | Who's a good little bran? | Hah! | Too cold. | Back off! | Proposed: fiery royal character |
| Ric | NPC 12595 | Ric | Who's a good little ric? | Hmm... | A cold offering. | Chill out! | Proposed: icy royal character |
| Smol Heredit | NPC 12857 | Smol Heredit | Who's a good little smol heredit? | Hmph! | I need no scraps. | Know your place! | Proposed: proud sun champion; not a quoted combat line |
| Nid | NPC 13683 | Nid | Who's a good little nid? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Rax | NPC 13684 | Rax | Who's a good little rax? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Huberte | NPC 14045 | Huberte | Who's a good little huberte? | Krrr-ooo! | Krr, crunch! | KRAAA! | Proposed: feathered serpent |
| Moxi | NPC 14046 | Moxi | Who's a good little moxi? | Krr-rr... | Krr, crunch! | KRAAK! | Proposed: icy reptile |
| Yami | NPC 14204 | Yami | Who's a good little yami? | Hrrr-hah... | An offering! | GRAAAH! | Proposed: demon lord |
| Dom | NPC 14785 | Dom | Who's a good little dom? | Krr-click... | Krr, crunch! | KRRRAAA! | Proposed: subterranean insectoid |
| Gull | NPC 14931 | Gull | Who's a good little gull? | Krrr-ree! | Kraak, crunch! | SKRAAA! | Proposed: gryphon bird/beast voice |
| Gulliver | NPC 14932 | Gulliver | Who's a good little gulliver? | Krrr-ree! | Kraak, crunch! | SKRAAA! | Proposed: gryphon bird/beast voice |
| Beef | NPC 15631 | Beef | Who's a good little beef? | Mmmmoo... | Grass, please. | MOOO! | Proposed: bovine voice; declines bones |
| Maggot marquess | NPC 15740 | Maggot marquess | Who's a good little maggot marquess? | Glrrp... | Slurp! | SKREE! | Proposed: grub squelch/chitter |
| Aggy | NPC 16317 | Aggy | Who's a good little aggy? | Heh... heh... | A strange offering. | Ahahaha! | Proposed: uncanny angelic voice; not verified dialogue |

## Pets: Other

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Clockwork cat | NPC 2782 | Clockwork cat | Who's a good kitty? | Tik-tik-purr! | Clink? | Rrr-click! | Proposed: mechanical cat; no chewing |
| Lil' Creator | NPC 3566 | Lil' Creator | Who's a good little lil' creator? | Rrrustle... | Seeds, please. | Hrrr-ooo! | Proposed: nature avatar |
| Chompy chick | NPC 4002 | Chompy chick | Who's a good little chompy chick? | Chirp! | Frogs, please! | Peep! | Proposed: chompy bird diet |
| Lil' Destructor | NPC 5008 | Lil' Destructor | Who's a good little lil' destructor? | Fsssh... | Ashes! | FWOOSH! | Proposed: destruction avatar |
| Penance Pet | NPC 6674 | Penance Pet | Who's a good little penance pet? | Krrr-eee... | Krik, crunch! | SKREEE! | Proposed: penance creature |
| Bloodhound | NPC 7232 | Bloodhound | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Herbi | NPC 7760 | Herbi | Who's a good little herbi? | Snuff-snuff! | Herbs, please. | Hrrnk! | Proposed: herbiboar |
| Abyssal protector | NPC 11429 | Abyssal protector | Who's a good little abyssal protector? | Krrr... | Runes, please. | SKRRR! | Proposed: abyssal guardian |
| Quetzin | NPC 12858 | Quetzin | Who's a good little quetzin? | Chirrr! | Chirp, munch! | KREE! | Proposed: quetzal-like bird |
| Broav | NPC 13518 | Broav | Who's a good little broav? | Snuff-snuff! | Snort, munch! | Hrrnk! | Proposed: tracking boar-like creature |
| Mr McGroot | NPC 16316 | Mr McGroot | Who's a good little mr mcgroot? | Maa-aa! | Grass, please. | MAAA! | Proposed: goat |
| Humphrey Dumphrey | NPC 14518 | Humphrey Dumphrey | Who's a good little humphrey dumphrey? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 1 | NPC 15587 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 2 | NPC 15590 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 3 | NPC 15592 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 4 | NPC 15594 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 5 | NPC 15596 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 6 | NPC 15598 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Archibald: Pattern 7 | NPC 15600 | Archibald | Who's a good little archibald? | Tap-tap! | No mouth yet! | Wobble! | Proposed: egg, not yet hatched |
| Spooky chair | NPC 14815 | Spooky chair | Who's a good little spooky chair? | Creak... | Wood, please. | CREAAAK! | Proposed: haunted furniture |
| Mayor of Catherby | NPC 15050 | Mayor of Catherby | Who's a good little mayor of catherby? | Blub-blub! | Fish food, please. | Bloop! | Proposed: fish bubbles; declines bones |
| Pet fish: blue fish | Item 6670 | Blue fish | Who's a good little blue fish? | Blub-blub! | Fish food, please. | Bloop! | Proposed: fish bubbles; declines bones |
| Pet fish: green fish | Item 6671 | Green fish | Who's a good little green fish? | Blub-blub! | Fish food, please. | Bloop! | Proposed: fish bubbles; declines bones |
| Pet fish: spine fish | Item 6672 | Spinefish | Who's a good little spinefish? | Blub-blub! | Fish food, please. | Bloop! | Proposed: fish bubbles; declines bones |

## Pets: Skilling

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Heron | NPC 6722 | Heron | Who's a good little heron? | Kraak... | Fish, please. | KRAAK! | Proposed: heron call; declines bones |
| Baby Chinchompa: Red | NPC 6756 | Baby Chinchompa | Who's a good little baby chinchompa? | Chrr-chrr! | Chrr, munch! | Eep! | Proposed: small rodent; no explosion gag |
| Baby Chinchompa: Grey | NPC 6757 | Baby Chinchompa | Who's a good little baby chinchompa? | Chrr-chrr! | Chrr, munch! | Eep! | Proposed: small rodent; no explosion gag |
| Baby Chinchompa: Black | NPC 6758 | Baby Chinchompa | Who's a good little baby chinchompa? | Chrr-chrr! | Chrr, munch! | Eep! | Proposed: small rodent; no explosion gag |
| Baby Chinchompa: Gold | NPC 6759 | Baby Chinchompa | Who's a good little baby chinchompa? | Chrr-chrr! | Chrr, munch! | Eep! | Proposed: small rodent; no explosion gag |
| Giant Squirrel | NPC 7351 | Giant Squirrel | Who's a good little giant squirrel? | Chik-chik! | Nuts, please. | Chrrr! | Proposed: squirrel chatter |
| Tangleroot: Default | NPC 7352 | Tangleroot | Who's a good little tangleroot? | Rrrustle... | Compost, please. | Hsssh! | Proposed: living plant |
| Rocky | NPC 7353 | Rocky | Who's a good little rocky? | Chrr-chrr! | Chrr, munch! | Chrrr! | Proposed: raccoon/red panda/tanuki chatter |
| Rift guardian: Fire | NPC 7354 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Air | NPC 7355 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Mind | NPC 7356 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Water | NPC 7357 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Earth | NPC 7358 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Body | NPC 7359 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Cosmic | NPC 7360 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Chaos | NPC 7361 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Nature | NPC 7362 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Law | NPC 7363 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Death | NPC 7364 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Soul | NPC 7365 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Astral | NPC 7366 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rift guardian: Blood | NPC 7367 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Rock Golem: Default | NPC 7451 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Tin | NPC 7452 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Copper | NPC 7453 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Iron | NPC 7454 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Blurite | NPC 7455 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Silver | NPC 7642 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Coal | NPC 7643 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Gold | NPC 7644 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Mithril | NPC 7645 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Granite | NPC 7646 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Adamantite | NPC 7647 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Runite | NPC 7648 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Amethyst | NPC 7711 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Lovakite | NPC 7739 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Elemental | NPC 7740 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Daeyalt | NPC 7741 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rift guardian: Wrath | NPC 8028 | Rift guardian | Who's a good little rift guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Tangleroot: Crystal | NPC 9497 | Tangleroot | Who's a good little tangleroot? | Rrrustle... | Compost, please. | Hsssh! | Proposed: living plant |
| Tangleroot: Dragon | NPC 9498 | Tangleroot | Who's a good little tangleroot? | Rrrustle... | Compost, please. | Hsssh! | Proposed: living plant |
| Tangleroot: Herb | NPC 9499 | Tangleroot | Who's a good little tangleroot? | Rrrustle... | Compost, please. | Hsssh! | Proposed: living plant |
| Tangleroot: Lily | NPC 9500 | Tangleroot | Who's a good little tangleroot? | Rrrustle... | Compost, please. | Hsssh! | Proposed: living plant |
| Tangleroot: Redwood | NPC 9501 | Tangleroot | Who's a good little tangleroot? | Rrrustle... | Compost, please. | Hsssh! | Proposed: living plant |
| Dark Squirrel | NPC 9637 | Dark Squirrel | Who's a good little dark squirrel? | Chik-chik! | Nuts, please. | Chrrr! | Proposed: squirrel chatter |
| Red | NPC 9852 | Red | Who's a good little red? | Chrr-chrr! | Chrr, munch! | Chrrr! | Proposed: raccoon/red panda/tanuki chatter |
| Ziggy | NPC 9853 | Ziggy | Who's a good little ziggy? | Chrr-chrr! | Chrr, munch! | Chrrr! | Proposed: raccoon/red panda/tanuki chatter |
| Great blue heron | NPC 10636 | Great blue heron | Who's a good little great blue heron? | Kraak... | Fish, please. | KRAAK! | Proposed: heron call; declines bones |
| Greatish guardian | NPC 11428 | Greatish guardian | Who's a good little greatish guardian? | Hummm... | Runes, please. | Vrrroom! | Proposed: runic construct |
| Beaver: Default | NPC 12181 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Oak | NPC 12182 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Willow | NPC 12183 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Maple | NPC 12184 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Yew | NPC 12185 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Magic | NPC 12186 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Redwood | NPC 12187 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Teak | NPC 12188 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Mahogany | NPC 12189 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Arctic | NPC 12190 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Pheasant | NPC 12549 | Pheasant | Who's a good little pheasant? | Kuk-kuk! | Seeds, please. | KRAAK! | Proposed: pheasant |
| Fox | NPC 12550 | Fox | Who's a good little fox? | Yip-yip! | Yip, munch! | YAAAP! | Proposed: fox calls; not domestic-dog bark |
| Bone Squirrel | NPC 14044 | Bone Squirrel | Who's a good little bone squirrel? | Chik-rattle! | More bones! | Clatter! | Proposed: skeletal squirrel |
| Rock Golem: Lead | NPC 14923 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Rubium | NPC 14924 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Rock Golem: Nickel | NPC 14925 | Rock Golem | Who's a good little rock golem? | Clink-clink! | Ore, please. | KRRANG! | Proposed: mineral construct |
| Beaver: Camphor | NPC 14926 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Ironwood | NPC 14927 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Jatoba | NPC 14928 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Beaver: Rosewood | NPC 14929 | Beaver | Who's a good little beaver? | Chrr-chrr! | Wood, please. | Chrrr! | Proposed: beaver chatter |
| Soup | NPC 14930 | Soup | Who's a good little soup? | Honk-honk! | Fish, please. | HOOONK! | Proposed: albatross; confirm species before implementation |

## Bosses: Minigames & skilling

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Crystalline Hunllef | NPC 9021 | Crystalline Hunllef | Who's a good bossy? | Krrr-chime... | Krik, crunch! | KRAAANG! | Proposed: crystal beast |
| Corrupted Hunllef | NPC 9035 | Corrupted Hunllef | Who's a good bossy? | Vrrr-chime... | Krr, crunch! | SKRAAANG! | Proposed: corrupted crystal beast |
| TzTok-Jad | NPC 3127 | TzTok-Jad | Who's a good bossy? | Hrrrum... | Krr, crunch! | HRRAAH! | Proposed: volcanic beast |
| TzKal-Zuk | NPC 7706 | TzKal-Zuk | Who's a good bossy? | Hrrr... | Stone, not bones. | GRAAAH! | Proposed: volcanic champion |
| Sol Heredit | NPC 12821 | Sol Heredit | Who's a good bossy? | Hmph! | I need no scraps. | Know your place! | Proposed: proud sun champion; not a quoted combat line |
| Tempoross | NPC 10572 | Tempoross | Who's a good bossy? | Whooosh... | Glub! | SPLAAASH! | Proposed: sea spirit |
| Zalcano | NPC 9049 | Zalcano | Who's a good bossy? | Hrrr-clink... | Ore, not bones. | GRRRAH! | Proposed: stone-imprisoned demon |
| Penance Queen | NPC 5775 | Penance Queen | Who's a good bossy? | Krrr-eee... | Krik, crunch! | SKREEE! | Proposed: penance creature |
| Avatar of Creation | NPC 10531 | Avatar of Creation | Who's a good bossy? | Rrrustle... | Seeds, please. | Hrrr-ooo! | Proposed: nature avatar |
| Avatar of Destruction | NPC 10532 | Avatar of Destruction | Who's a good bossy? | Fsssh... | Ashes! | FWOOSH! | Proposed: destruction avatar |

## Bosses: Quests

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Abomination | NPC 8262 | Abomination | Who's a good bossy? | Grr-glrk... | Glrk, crunch! | GRAAAH! | Proposed: stitched beast |
| Agrith-Naar | NPC 911 | Agrith-Naar | Who's a good bossy? | Grrr... | Crunch! | GRAAAH! | Proposed: demon growl |
| Ancient Guardian | NPC 10654 | Ancient Guardian | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| Arrg | NPC 643 | Arrg | Who's a good bossy? | Hurr-hurr! | Good crunch! | GRAAAGH! | Proposed: troll/ogre voice |
| Barrelchest | NPC 600 | Barrelchest | Who's a good bossy? | Clank-clank! | Clunk! | CLANG! | Proposed: mechanical undead construct |
| Black Knight Titan | NPC 4067 | Black Knight Titan | Who's a good bossy? | Hmph! | Keep your scraps. | Stand aside! | Proposed: armoured knight |
| Bouncer | NPC 1224 | Bouncer | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| General Khazard | NPC 3510 | General Khazard | Who's a good bossy? | Hmph. | Not a ration. | Move along! | Proposed: militaristic warlord |
| Chronozon | NPC 4987 | Chronozon | Who's a good bossy? | Grrr... | Crunch! | GRAAAH! | Proposed: demon growl |
| Corrupt Lizardman | NPC 8000 | Corrupt Lizardman | Who's a good bossy? | Krr-ss... | Sss, crunch! | HSSS! | Proposed: reptilian voice |
| Count Draynor | NPC 3481 | Count Draynor | Who's a good bossy? | Hmmm... | Blood, not bones. | HSSS! | Proposed: vampire hunger |
| Culinaromancer | NPC 3400 | Culinaromancer | Who's a good bossy? | Hehehe! | Where is the sauce? | Out of my kitchen! | Proposed: food-magic villain |
| Cuthbert | NPC 12955 | Cuthbert | Who's a good bossy? | Cluck-cluck! | Seeds, please. | BWAARK! | Proposed: chicken |
| Dad | NPC 4130 | Dad | Who's a good bossy? | Hurr-hurr! | Good crunch! | GRAAAGH! | Proposed: troll/ogre voice |
| Delrith | NPC 5079 | Delrith | Who's a good bossy? | Grrr... | Crunch! | GRAAAH! | Proposed: demon growl |
| Elvarg | NPC 8033 | Elvarg | Who's a good bossy? | Rrrr... | Rrr, crunch! | GRRROAR! | Proposed: single-headed dragon |
| Evil Spirit | NPC 625 | Evil Spirit | Who's a good bossy? | Wooo... | Nothing fills the void. | WAAAAH! | Proposed: ghostly wail |
| Fragment of Seren | NPC 8917 | Fragment of Seren | Who's a good bossy? | Hmmm... | A broken offering... | Stay... | Proposed: sorrowful divine fragment |
| Gadderanks | NPC 4483 | Gadderanks | Who's a good bossy? | Hmph! | Not ale. | Off with you! | Proposed: bullying human |
| Galvek | NPC 8094 | Galvek | Who's a good bossy? | Rrrr... | Rrr, crunch! | GRRROAR! | Proposed: single-headed dragon |
| Giant Roc | NPC 763 | Giant Roc | Who's a good bossy? | Krrr-ree! | Kraak, crunch! | SKREE! | Proposed: giant bird |
| giant scarab | NPC 797 | giant scarab | Who's a good bossy? | Trik-trik! | Klik, crunch! | SKRIT! | Proposed: insect clicks |
| Giant Sea Snake | NPC 1101 | Giant Sea Snake | Who's a good bossy? | Sss-sss... | Sss, gulp! | HSSSS! | Proposed: snake hiss |
| Glod | NPC 5129 | Glod | Who's a good bossy? | Hmph! | Not gold. | Hands off! | Proposed: hostile dwarf |
| Ice Troll King | NPC 5822 | Ice Troll King | Who's a good bossy? | Hurr-hurr! | Good crunch! | GRAAAGH! | Proposed: troll/ogre voice |
| Ithoi the Navigator | NPC 7961 | Ithoi the Navigator | Who's a good bossy? | Ahem. | Not provisions. | Back to your ship! | Proposed: corsair mage |
| Jungle demon | NPC 1443 | Jungle demon | Who's a good bossy? | Grrr... | Crunch! | GRAAAH! | Proposed: demon growl |
| Khazard Ogre | NPC 1225 | Khazard Ogre | Who's a good bossy? | Hurr-hurr! | Good crunch! | GRAAAGH! | Proposed: troll/ogre voice |
| Koschei the Deathless | NPC 3897 | Koschei the Deathless | Who's a good bossy? | Hah! | Feed my courage! | I fear nothing! | Proposed: unyielding warrior |
| Lowerniel Drakan | NPC 15936 | Lowerniel Drakan | Who's a good bossy? | Hmmm... | Blood, not bones. | HSSS! | Proposed: vampire hunger |
| Me | NPC 785 | Me | Who's a good bossy? | Huh? | You eat it. | No, you shoo! | Proposed: reflected player |
| Melzar the Mad | NPC 823 | Melzar the Mad | Who's a good bossy? | Hehehe! | Where is my cabbage? | Away, away! | Proposed: cabbage-obsessed mage |
| Moss Guardian | NPC 891 | Moss Guardian | Who's a good bossy? | Rrrustle... | Mulch! | Hrrr! | Proposed: moss-covered giant |
| Nezikchened | NPC 3962 | Nezikchened | Who's a good bossy? | Grrr... | Crunch! | GRAAAH! | Proposed: demon growl |
| Ranis Drakan | NPC 3744 | Ranis Drakan | Who's a good bossy? | Hmmm... | Blood, not bones. | HSSS! | Proposed: vampire hunger |
| Sand Snake | NPC 7903 | Sand Snake | Who's a good bossy? | Sss-sss... | Sss, gulp! | HSSSS! | Proposed: snake hiss |
| Sea Troll Queen | NPC 4315 | Sea Troll Queen | Who's a good bossy? | Hrrr... | Gulp! | HRRRAAH! | Proposed: sea troll |
| Sigmund | NPC 990 | Sigmund | Who's a good bossy? | Hmph. | Keep it. | Filthy nuisance! | Proposed: hostile zealot |
| Sir Leye | NPC 4682 | Sir Leye | Who's a good bossy? | Ahem! | That is uncivil. | En garde! | Proposed: duelling knight |
| Sir Mordred | NPC 3527 | Sir Mordred | Who's a good bossy? | Hmph! | Not fit for a knight. | Begone! | Proposed: hostile knight |
| Slagilith | NPC 1362 | Slagilith | Who's a good bossy? | Krrr-grind... | Stone, please. | CRRACK! | Proposed: rock creature |
| Slash Bash | NPC 882 | Slash Bash | Who's a good bossy? | Hrrrgh... | Bones! | GROOAN! | Proposed: undead ogre |
| Tolna | NPC 1057 | Tolna | Who's a good bossy? | Hrrr... | Three mouths, one bone? | GRAAAH! | Proposed: three-headed transformed boy |
| Treus Dayth | NPC 3616 | Treus Dayth | Who's a good bossy? | Wooo... | Nothing fills the void. | WAAAAH! | Proposed: ghostly wail |
| Ulfric | NPC 4500 | Ulfric | Who's a good bossy? | Hrrr... | More bones? | GROOAN! | Proposed: undead Fremennik |
| black golem | NPC 4742 | black golem | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| grey golem | NPC 4744 | grey golem | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| white golem | NPC 4743 | white golem | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| Dessous | NPC 3459 | Dessous | Who's a good bossy? | Hmmm... | Blood, not bones. | HSSS! | Proposed: vampire hunger |
| Kamil | NPC 3458 | Kamil | Who's a good bossy? | Hrrr... | Too warm. | HSSS! | Proposed: ice warrior |
| Fareed | NPC 3456 | Fareed | Who's a good bossy? | Fsssh... | Ashes! | FWOOSH! | Proposed: fire warrior |
| Damis | NPC 682 | Damis | Who's a good bossy? | Hrrr... | Dust to dust. | GRAAH! | Proposed: shadow warrior |
| Agrith Na-Na | NPC 4880 | Agrith Na-Na | Who's a good bossy? | Grrr-hah... | Bananas, please. | GRAAAH! | Proposed: banana-themed demon |
| Flambeed | NPC 4881 | Flambeed | Who's a good bossy? | Fsssh... | Ashes! | FWOOSH! | Proposed: fire warrior |
| Karamel | NPC 4882 | Karamel | Who's a good bossy? | Hrrr... | Too warm. | HSSS! | Proposed: ice warrior |
| Dessourt | NPC 4883 | Dessourt | Who's a good bossy? | Hmmm... | Where is dessert? | HSSS! | Proposed: dessert-themed vampire |
| Gelatinnoth Mother | NPC 4884 | Gelatinnoth Mother | Who's a good bossy? | Glrrp... | Slurp! | GLRRAAH! | Proposed: gelatinous dagannoth |
| The Inadequacy | NPC 3473 | The Inadequacy | Who's a good bossy? | Hhh... | Still not enough. | Hrrr... | Proposed: nightmare of inadequacy |
| The Everlasting | NPC 3474 | The Everlasting | Who's a good bossy? | Hrrr... | Still hungry. | I remain. | Proposed: enduring nightmare |
| The Untouchable | NPC 3475 | The Untouchable | Who's a good bossy? | Ssshh... | Cannot reach it. | Missed me. | Proposed: elusive nightmare |
| The Illusive | NPC 3476 | The Illusive | Who's a good bossy? | Hhh...? | Was that real? | Gone... | Proposed: illusory nightmare |
| Kruk | NPC 5257 | Kruk | Who's a good bossy? | Ook! | Ook, munch! | AAK! | Proposed: monkey warrior |
| Kob | NPC 7107 | Kob | Who's a good bossy? | Hurr-hurr! | Good crunch! | GRAAAGH! | Proposed: troll/ogre voice |
| Keef | NPC 7105 | Keef | Who's a good bossy? | Hurr-hurr! | Good crunch! | GRAAAGH! | Proposed: troll/ogre voice |
| Robert the Strong | NPC 8057 | Robert the Strong | Who's a good bossy? | Hah! | Not a ration. | Stand your ground! | Proposed: steadfast hero |
| Essyllt | NPC 3415 | Essyllt | Who's a good bossy? | Hmph. | No, thank you. | Leave me. | Proposed: hostile elven warrior |
| Surok Magis | NPC 4159 | Surok Magis | Who's a good bossy? | Hmm... | Not a reagent. | Begone! | Proposed: dark mage |
| Balance Elemental | NPC 13528 | Balance Elemental | Who's a good bossy? | Hummm... | Balance restored. | Whooom! | Proposed: elemental harmony |
| Prince Itzla Arkan | NPC 12898 | Prince Itzla Arkan | Who's a good bossy? | Hmph! | Unworthy tribute. | Know your place. | Proposed: royal arrogance |
| golem guard | NPC 14125 | golem guard | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| Arrav | NPC 12613 | Arrav | Who's a good bossy? | Hrrm... | I cannot eat. | Leave me in peace. | Proposed: undead hero |
| Emissary Enforcer | NPC 14266 | Emissary Enforcer | Who's a good bossy? | Hmph! | Not a ration. | Move along! | Proposed: temple enforcer |
| Lucius | NPC 14363 | Lucius | Who's a good bossy? | Hmm... | Not a reagent. | Enough! | Proposed: mage guardian |
| Chimalli | NPC 14362 | Chimalli | Who's a good bossy? | Hmph. | Not provisions. | Keep your distance! | Proposed: ranged guardian |
| Ennius Tullus | NPC 14331 | Ennius Tullus | Who's a good bossy? | Hrrr... | For the dead? | Leave this crypt! | Proposed: crypt guardian |
| Augur Metzli | NPC 14318 | Augur Metzli | Who's a good bossy? | Hmmm... | A poor offering. | The omen is clear. | Proposed: augur |
| Wyrd | NPC 16212 | Wyrd | Who's a good bossy? | Hrrr-eee... | Blood, not bones. | SKREEE! | Proposed: vampyric horror |
| Glough | NPC 1425 | Glough | Who's a good bossy? | Hmph! | Keep your scraps. | Get away! | Proposed: hostile gnome |
| Dagannoth Mother | NPC 980 | Dagannoth Mother | Who's a good bossy? | Krrr-ooo... | Krr, crunch! | SKREE! | Proposed: dagannoth matriarch |
| Dramen Tree Spirit | NPC 1163 | Dramen Tree Spirit | Who's a good bossy? | Rrrustle... | Mulch, please. | HSSSH! | Proposed: tree spirit |
| Draugen | NPC 3922 | Draugen | Who's a good bossy? | Wooo... | Nothing fills the void. | WAAAAH! | Proposed: ghostly wail |
| Evil Chicken | NPC 1870 | Evil Chicken | Who's a good bossy? | Cluck... hehehe! | Seeds, fool! | BWAHAHAARK! | Proposed: malicious chicken |
| Arzinian Avatar: Strength | NPC 1227 | Arzinian Avatar | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| Arzinian Avatar: Ranging | NPC 1230 | Arzinian Avatar | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| Arzinian Avatar: Magic | NPC 1233 | Arzinian Avatar | Who's a good bossy? | Clrrk... | Stone, not bones. | KRAANG! | Proposed: animated stone |
| Tarn Razorlor | NPC 6477 | Tarn Razorlor | Who's a good bossy? | Hrrrgh... | The dead hunger. | GRAAAH! | Proposed: mutated necromancer |
| Bouncer (ghost) | NPC 3509 | Bouncer (ghost) | Who's a good doggy? | Woof! | Woof woof! | Whine! | Unchanged canine reactions [D] |
| Black demon (The Grand Tree) | NPC 240 | Black demon (The Grand Tree) | Who's a good bossy? | Grrr... | Crunch! | GRAAAH! | Proposed: demon growl |
| Glough: Mutated | NPC 7101 | Glough | Who's a good bossy? | Hrrrgh... | Crunch! | GRAAAH! | Proposed: mutated gnome roar |
| Elven traitor (Arianwyn) | NPC 8865 | Elven traitor (Arianwyn) | Who's a good bossy? | Hmph. | No, thank you. | Leave me. | Proposed: hostile elven warrior |

## Bosses: Raids

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Tekton | NPC 7540 | Tekton | Who's a good bossy? | Clink-clink! | Not for forging. | CLANG! | Proposed: smith and stone armour |
| Vanguard | NPC 7526 | Vanguard | Who's a good bossy? | Krrr... | Crunch! | SKRRR! | Proposed: subterranean guardian |
| Vespula | NPC 7530 | Vespula | Who's a good bossy? | Bzz-bzz! | Bzz, slurp! | BZZZZ! | Proposed: flying insect |
| Vasa Nistirio | NPC 7566 | Vasa Nistirio | Who's a good bossy? | Vrrr-hum... | Crystal, please. | KRAANG! | Proposed: crystal magic resonance |
| Muttadile | NPC 7562 | Muttadile | Who's a good bossy? | Krrr... | Chomp! | KRAAAR! | Proposed: crocodilian, not a dog |
| Great Olm | NPC 7554 | Great Olm | Who's a good bossy? | Rrr-ooo... | Krr, crunch! | KRAAAH! | Proposed: cavern salamander/dragon rumble |
| The Maiden of Sugadinti | NPC 8360 | The Maiden of Sugadinti | Who's a good bossy? | Hhh... | Blood, not bones. | AAAAH! | Proposed: blood-starved apparition |
| Pestilent Bloat | NPC 8359 | Pestilent Bloat | Who's a good bossy? | Brrr-gh... | Brrp! | GROOAN! | Proposed: bloated undead |
| Nylocas Vasilias | NPC 8355 | Nylocas Vasilias | Who's a good bossy? | Tik-trik! | Krik, crunch! | SKRIT! | Proposed: nylocas chitter |
| Sotetseg | NPC 8388 | Sotetseg | Who's a good bossy? | Hrrr... | Crunch! | HRRRAAH! | Proposed: dark beast |
| Xarpus | NPC 8338 | Xarpus | Who's a good bossy? | Krrr-eee... | Glrk, gulp! | SKREEE! | Proposed: winged poison beast |
| Verzik Vitur | NPC 8372 | Verzik Vitur | Who's a good bossy? | Heh-heh... | More! | How insolent! | Proposed: vampyric aristocrat/spider hybrid |
| Akkha | NPC 11790 | Akkha | Who's a good bossy? | Hmmm... | A humble offering. | Enough. | Proposed: disciplined warrior |
| Ba-Ba | NPC 11778 | Ba-Ba | Who's a good bossy? | Ook-ook! | Ook, munch! | AAK-AAK! | Proposed: baboon |
| Kephri | NPC 11719 | Kephri | Who's a good bossy? | Trik-trik! | Klik, crunch! | SKRIT! | Proposed: insect clicks |
| Zebak | NPC 11730 | Zebak | Who's a good bossy? | Krrr-rr... | Chomp! | KRAAAR! | Proposed: crocodile |
| Tumeken's Warden | NPC 11749 | Tumeken's Warden | Who's a good bossy? | Hummm... | The sun needs none. | VROOOM! | Proposed: solar construct resonance |
| Elidinis' Warden | NPC 11748 | Elidinis' Warden | Who's a good bossy? | Whooom... | The river needs none. | SHOOOM! | Proposed: river construct resonance |

## Bosses: Slayer

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Dusk | NPC 7851 | Dusk | Who's a good bossy? | Rrr-grind... | Krr, crunch! | GRRRAH! | Proposed: stone gargoyle |
| Abyssal Sire | NPC 5889 | Abyssal Sire | Who's a good bossy? | Hrrr-glrk... | Glrk, gulp! | HRRRAAH! | Proposed: abyssal creature |
| Kraken | NPC 494 | Kraken | Who's a good bossy? | Glub-glub... | Glup! | GLRRAH! | Proposed: tentacled sea monster |
| Cerberus | NPC 5862 | Cerberus | Who's a good doggy? | Rrrr-rrr-rrr... | Crunch! Crunch! Crunch! | GRRROOF! | Proposed: three-headed dog; canine sounds retained |
| Araxxor | NPC 13668 | Araxxor | Who's a good bossy? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Thermonuclear smoke devil | NPC 499 | Thermonuclear smoke devil | Who's a good bossy? | Fsssh... | Fff, ash! | WHOOOSH! | Proposed: smoke elemental |
| Alchemical Hydra | NPC 8615 | Alchemical Hydra | Who's a good bossy? | Sss-krr... | Gulp-gulp! | HSSSRAH! | Proposed: multi-headed reptile |
| Dawn | NPC 7852 | Dawn | Who's a good bossy? | Krrr... | Stone, not bones. | SKREE! | Proposed: winged gargoyle |

## Bosses: Wilderness

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Chaos Fanatic | NPC 6619 | Chaos Fanatic | Who's a good bossy? | Hehehe! | Chaos snack! | Madness! | Proposed: chaotic mage babble |
| Crazy archaeologist | NPC 6618 | Crazy archaeologist | Who's a good bossy? | Hehehe! | Not a book! | Keep away! | Proposed: book-obsessed archaeologist |
| Scorpia | NPC 6615 | Scorpia | Who's a good bossy? | Tik-tik! | Krik, crunch! | KSSS! | Proposed: scorpion clicks |
| King Black Dragon | NPC 239 | King Black Dragon | Who's a good bossy? | Rrrr... | Three cheers! | GRRROAR! | Proposed: dragon rumble; three cheers only for three-headed forms |
| Chaos Elemental | NPC 2054 | Chaos Elemental | Who's a good bossy? | Blrrp? | Glorp! | BZZRRP! | Proposed: incoherent chaos warble |
| Revenant maledictus | NPC 11246 | Revenant maledictus | Who's a good bossy? | Wooo... | The dead hunger. | WRAAAH! | Proposed: revenant wail |
| Calvar'ion | NPC 11993 | Calvar'ion | Who's a good bossy? | Rattle... | More bones! | CLATTER! | Proposed: skeletal warrior |
| Vet'ion | NPC 6611 | Vet'ion | Who's a good bossy? | Rattle... | More bones! | CLATTER! | Proposed: skeletal warrior |
| Spindel | NPC 11998 | Spindel | Who's a good bossy? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Venenatis | NPC 6610 | Venenatis | Who's a good bossy? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Artio | NPC 11992 | Artio | Who's a good bossy? | Rrrrum... | Huff, crunch! | GRRRAWR! | Proposed: bear rumble and warning growl |
| Callisto | NPC 6609 | Callisto | Who's a good bossy? | Rrrrum... | Huff, crunch! | GRRRAWR! | Proposed: bear rumble and warning growl |

## Bosses: World

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Ahrim the Blighted | NPC 1672 | Ahrim the Blighted | Who's a good bossy? | Hmmm... | No sustenance. | Begone. | Proposed: undead mage |
| Karil the Tainted | NPC 1675 | Karil the Tainted | Who's a good bossy? | Hmph. | Not ammunition. | Keep your distance. | Proposed: undead crossbowman |
| Dharok the Wretched | NPC 1673 | Dharok the Wretched | Who's a good bossy? | Hrrgh... | More strength! | GRAAAGH! | Proposed: wounded berserker |
| Guthan the Infested | NPC 1674 | Guthan the Infested | Who's a good bossy? | Hrrmmm... | I hunger. | Grrr... | Proposed: life-draining warrior |
| Torag the Corrupted | NPC 1676 | Torag the Corrupted | Who's a good bossy? | Hmph! | Not for forging. | Stand back. | Proposed: hammer-bearing warrior |
| Verac the Defiled | NPC 1677 | Verac the Defiled | Who's a good bossy? | Hmm... | An offering? | Leave me. | Proposed: undead prayer warrior |
| Gemstone Crab | NPC 14779 | Gemstone Crab | Who's a good bossy? | Clik-clik! | Clack, crunch! | CLACK! | Proposed: crystal crustacean |
| Scurrius | NPC 7221 | Scurrius | Who's a good bossy? | Squeak! | Squeak, crunch! | Screee! | Proposed: rat vocalizations |
| Giant Mole | NPC 5779 | Giant Mole | Who's a good bossy? | Snff-snff! | Chrr, munch! | Eep! | Proposed: burrowing mammal |
| Deranged Archaeologist | NPC 7806 | Deranged Archaeologist | Who's a good bossy? | Heh... heh... | Not a relic! | Leave the ruins! | Proposed: obsessed archaeologist |
| Dagannoth Supreme | NPC 2265 | Dagannoth Supreme | Who's a good bossy? | Krr-krr! | Krak, crunch! | SKREE! | Proposed: ranged dagannoth |
| Dagannoth Rex | NPC 2267 | Dagannoth Rex | Who's a good bossy? | Rrrrum... | Rrr, crunch! | ROAAR! | Proposed: heavy melee dagannoth |
| Dagannoth Prime | NPC 2266 | Dagannoth Prime | Who's a good bossy? | Krrr-ooo... | Krr, crunch! | KREEE! | Proposed: magical dagannoth |
| Sarachnis | NPC 8713 | Sarachnis | Who's a good bossy? | Chrr-chrr... | Tik-tik, crunch! | SKRRR! | Proposed: spider chitter; stylized, not a real spider voice |
| Blood Moon | NPC 13011 | Blood Moon | Who's a good bossy? | Hhh... | Blood, not bones. | HSSS! | Proposed: blood-themed apparition |
| Blue Moon | NPC 13013 | Blue Moon | Who's a good bossy? | Hoooh... | Frozen scraps? | Hrrr... | Proposed: frost-themed apparition |
| Eclipse Moon | NPC 13012 | Eclipse Moon | Who's a good bossy? | Ssshhh... | A dark offering. | Sss-haa! | Proposed: eclipse-themed apparition |
| Kalphite Queen | NPC 963 | Kalphite Queen | Who's a good bossy? | Trik-trik! | Klik, crunch! | SKRIT! | Proposed: insect clicks |
| Kree'arra | NPC 3162 | Kree'arra | Who's a good bossy? | Krr-ree! | Kraak, crunch! | SKREE! | Proposed: aviansie screech |
| Commander Zilyana | NPC 2205 | Commander Zilyana | Who's a good bossy? | Ahem. | No, thank you. | Saradomin guide you. | Proposed: dignified Saradominist speech |
| General Graardor | NPC 2215 | General Graardor | Who's a good bossy? | ARRRGGGGH! | I grind your bones! | You die, puny foe! | Existing phrases [G]; assigned to new actions |
| K'ril Tsutsaroth | NPC 3129 | K'ril Tsutsaroth | Who's a good bossy? | Grrr-hah! | Crunch! | GRRRAH! | Proposed: guttural demon voice |
| The Hueycoatl | NPC 14009 | The Hueycoatl | Who's a good bossy? | Krrr-ooo! | Krr, crunch! | KRAAA! | Proposed: feathered serpent |
| Corporeal Beast | NPC 319 | Corporeal Beast | Who's a good bossy? | Vrrr-ooo... | Hollow hunger... | WHOOOM! | Proposed: spectral beast/core resonance |
| Nex | NPC 11278 | Nex | Who's a good bossy? | You amuse me. | An offering? | No escape! | Proposed: imperious voice; shoo adapts Nex escape motif |
| Brutus | NPC 15626 | Brutus | Who's a good bossy? | Mmmmoo... | Grass, please. | MOOO! | Proposed: bovine voice; declines bones |
| Demonic Brutus | NPC 15628 | Demonic Brutus | Who's a good bossy? | Mrrr-ooo... | Crunch! | MRROOO! | Proposed: demonic bull |
| Obor | NPC 7416 | Obor | Who's a good bossy? | Hurr-hurr! | Good crunch! | HRRAAGH! | Proposed: hill giant |
| Bryophyta | NPC 8195 | Bryophyta | Who's a good bossy? | Rrrustle... | Mulch! | Hrrr! | Proposed: moss-covered giant |
| Amoxliatl | NPC 13685 | Amoxliatl | Who's a good bossy? | Krr-rr... | Krr, crunch! | KRAAK! | Proposed: icy reptile |
| Branda the Fire Queen | NPC 12596 | Branda the Fire Queen | Who's a good bossy? | Hah! | Too cold. | Back off! | Proposed: fiery royal character |
| Doom of Mokhaiotl | NPC 14707 | Doom of Mokhaiotl | Who's a good bossy? | Krr-click... | Krr, crunch! | KRRRAAA! | Proposed: subterranean insectoid |
| Mad Angel | NPC 16305 | Mad Angel | Who's a good bossy? | Heh... heh... | A strange offering. | Ahahaha! | Proposed: uncanny angelic voice; not verified dialogue |
| Zulrah | NPC 2042 | Zulrah | Who's a good bossy? | Sss-sss... | Sss, gulp! | HSSSS! | Proposed: serpent hiss |
| Vorkath | NPC 8060 | Vorkath | Who's a good bossy? | Hrrr... | Rrr, crunch! | KRAAAH! | Proposed: undead dragon rasp |
| Phantom Muspah | NPC 12077 | Phantom Muspah | Who's a good bossy? | Grrr-glrp... | Glrrp! | GRRRAA! | Proposed: phantom beast growl |
| Maggot King | NPC 15742 | Maggot King | Who's a good bossy? | Glrrp... | Slurp! | SKREE! | Proposed: grub squelch/chitter |
| The Nightmare | NPC 9425 | The Nightmare | Who's a good bossy? | Hhhhhh... | Your fear feeds me. | EEEEEE! | Proposed: nightmare whisper and shriek |
| Phosani's Nightmare | NPC 9416 | Phosani's Nightmare | Who's a good bossy? | Hhhhhh... | Your fear feeds me. | EEEEEE! | Proposed: nightmare whisper and shriek |
| Yama | NPC 14176 | Yama | Who's a good bossy? | Hrrr-hah... | An offering! | GRAAAH! | Proposed: demon lord |
| Duke Sucellus | NPC 12167 | Duke Sucellus | Who's a good bossy? | Hrrmm... | Glorp, gulp! | Hrrrogh! | Proposed: sleepy demonic gulp and grunt |
| The Leviathan | NPC 12214 | The Leviathan | Who's a good bossy? | Krrrss... | Krr, gulp! | KRAAAH! | Proposed: abyssal sea serpent |
| The Whisperer | NPC 12204 | The Whisperer | Who's a good bossy? | Ssshh... | A hollow gift... | Leave... | Proposed: ghostly whisper |
| Vardorvis | NPC 12223 | Vardorvis | Who's a good bossy? | Hrrrk... | Roots drink deep. | GRAAH! | Proposed: strangler-root-controlled corpse |
| The Mimic | NPC 8633 | The Mimic | Who's a good bossy? | Creak... | Clack, gulp! | SNAP! | Proposed: hungry living chest |
| Hespori | NPC 8583 | Hespori | Who's a good bossy? | Rrrustle... | Compost, please. | HSSSH! | Proposed: carnivorous plant |
| Skotizo | NPC 7286 | Skotizo | Who's a good bossy? | Grrr-ooo... | Crunch! | GRAAAH! | Proposed: dark demon |
| Shellbane gryphon | NPC 14860 | Shellbane gryphon | Who's a good bossy? | Krrr-ree! | Kraak, crunch! | SKRAAA! | Proposed: gryphon bird/beast voice |
| Eldric the Ice King | NPC 14147 | Eldric the Ice King | Who's a good bossy? | Hmm... | A cold offering. | Chill out! | Proposed: icy royal character |

## Characters & cabbage

| Appearance | NPC / item ID | Name in menus | Player: pet | NPC: pet | NPC: feed | NPC: shoo | Basis |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Wise Old Man | NPC 2108 | Wise Old Man | Who's a good old man? | Ahem. | Not a banknote. | How rude! | Proposed: elderly bank-robbing wizard |
| Cabbage | Item 1965 | Cabbage | Who's a good cabbage? | Kah-Bah-Gee! | For the patch! | Leaf me be! | Order chant [O]; feed/shoo are proposed cabbage puns |
| Giant cabbage | Item 1965 | Giant cabbage | Who's a good cabbage? | KAH-BAH-GEE! | ALL HAIL THE PATCH! | KAH-BAH-BEGONE! | Order chant [O]; larger, louder invented calls |

