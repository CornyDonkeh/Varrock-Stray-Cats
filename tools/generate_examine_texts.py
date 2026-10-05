"""Offline lore-based examine drafts. Original in-game examines are NOT verified."""
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
entries = json.loads((ROOT / 'tools/appearance-catalogue.json').read_text())

# Individually written lore drafts, not quotations or verified normal examines.
SPECIAL = dict(line.split('|', 1) for line in '''
Wise Old Man|A wise old wizard with a twinkle in his eye and suspiciously roomy pockets.
Bob|A wandering black cat with the heart of a hero and whiskers worth protecting.
Evil Bob|A fluffy little tyrant. Your fish is cooked, and your apology is overdue.
Cabbage|A leafy little friend. Somehow too sweet to put in a stew.
Giant cabbage|So much leafy goodness, and still convinced they are a lap cabbage.
Dark core|A little darkness with a surprisingly clingy heart.
Chaos Elemental Jr.|A tiny tangle of chaos. Even their cuddles are unpredictable.
Hellpuppy|Three little heads, three goodnight kisses, one very warm puppy.
Scorpia's offspring|A pocket-sized scorpion with a sting and a soft spot for you.
Abyssal orphan|A small abyssal oddity looking for a very ordinary cuddle.
TzRek-Jad|A little volcanic legend with a very big stomp in their step.
Dagannoth Supreme Jr.|A tiny spined monarch, practising a regal little waddle.
Dagannoth Prime Jr.|A little dagannoth mage. Their most powerful spell is puppy eyes.
Dagannoth Rex Jr.|A tiny prehistoric king with an enormous appetite for attention.
Kree'arra Jr.|A little feathered general, reporting for wing scritches.
General Graardor Jr.|A miniature general with mighty fists and a teeny victory dance.
Zilyana Jr.|A little commander shining with enough kindness to fill a battlefield.
K'ril Tsutsaroth Jr.|A tiny demonic general. Even the grumbles are adorable.
Baby Mole|A little gardener who believes every walk needs a digging break.
Prince Black Dragon|Three tiny heads, all waiting patiently for their turn to be praised.
Kraken|A little sea monster with enough arms for a proper hug.
Olmlet|A little olmic friend. Those tiny claws have a big hold on your heart.
Scurry|A little rat who has promoted your pockets to their personal pantry.
Skotos|A tiny shadow demon, following you like the world's cutest dark omen.
Jal-Nib-Rek|A little lava nibber. Please keep your furniture and fingers out of reach.
Noon|A little gargoyle who thinks every sunny ledge is a cuddle spot.
Midnight|A little night guardian with a stony face and a soft little heart.
Corporeal Critter|A wee spectral beast, haunting your footsteps in the friendliest way.
TzRek-Zuk|A little infernal champion with a very dramatic warm welcome.
Vorki|A little blue dragon. The cold shoulder comes with warm affection.
Puppadile|A baby swamp chomper with a grin much bigger than their bite.
Tektiny|A little walking forge, hammering out a place in your heart.
Vanguard|A little raiding companion who would rather regroup for a cuddle.
Vasa Minirio|A tiny crystal guardian, glittering with pride at every compliment.
Vespina|A little buzzing queen who has declared you their favourite flower.
Lil' Zik|A little vampyric lady with grand manners and a tiny appetite for mischief.
Little Parasite|A little clingy horror. They have really taken to you.
Youngllef|A crystalline youngster learning to roar one tiny squeak at a time.
Corrupted Youngllef|A corrupted little crystal beast with an uncorrupted love of attention.
Smolcano|A little stony demon with a molten centre and a warm welcome.
Little Nightmare|A tiny bad dream who makes waking up beside you feel rather nice.
Enraged Tektiny|A little forge in a big mood. Perhaps a compliment will cool them down.
Flying Vespina|A little airborne queen, buzzing over to see their favourite human.
JalRek-Jad|A fiery little champion with six reasons to stomp over for a cuddle.
Tiny Tempor|A small spirit of the sea. All the storm, in one precious little splash.
Baby Mole-rat|A little underground explorer with whiskers made for tickling.
Lil' Maiden|A little scarlet lady, making a rather dramatic entrance into your heart.
Lil' Bloat|A little shambling fellow who hopes you appreciate their unique perfume.
Lil' Nylo|A tiny many-legged companion. More feet means more happy little taps.
Lil' Sot|A little dark beast who has found something nicer than the maze: you.
Lil' Xarp|A little flying oddity, saving their best flappy greeting for you.
Nexling|A little ancient menace who has taken a surprisingly affectionate interest in you.
Tumeken's Guardian|A little sunlit sentinel, warming your path with quiet loyalty.
Elidinis' Guardian|A little riverlit sentinel, watching over you with gentle patience.
Akkhito|A little desert guardian with four fighting styles and one cuddling style.
Babi|A tiny baboon queen. Your company is a treasure worth guarding.
Kephriti|A little scarab queen, rolling up to claim your attention.
Zebo|A baby desert crocodile with a toothy little smile just for you.
Tumeken's Damaged Guardian|A little sun guardian with a few dents and plenty of devotion.
Elidinis' Damaged Guardian|A little river guardian. A little worn, and very well loved.
Wisp|A little whisper from the depths, humming a softer song beside you.
Butch|A tiny axe-loving companion. Their devotion is rather cutting.
Baron|A little duke with grand dreams of ruling your favourite cushion.
Lil'viathan|A little sea serpent, making a very big fuss over a very small splash.
Bran|A little fiery royal with a warm heart beneath the grand entrance.
Ric|A little icy royal, trying very hard to look too cool for cuddles.
Smol Heredit|A little colosseum champion. Their proudest victory is winning your attention.
Nid|A little eight-legged friend, weaving themselves into your heart.
Rax|A little arachnid menace, practising a surprisingly gentle skitter.
Huberte|A little serpentine companion, coiling up for a well-earned rest beside you.
Moxi|A little frosty friend, leaving tiny chilly footprints on your heart.
Yami|A little infernal companion. Their affection burns brighter than their temper.
Dom|A little ominous companion, bringing a rather sweet sort of doom.
Gull|A little feathered adventurer, always ready to steal a snack and your heart.
Gulliver|A little feathered traveller who has decided your shoulder looks like home.
Beef|A little beefy companion, flexing bravely for one more compliment.
Maggot marquess|A little wriggly noble, dressed for a very important garden party.
Aggy|A little companion with a big personality and a soft spot for you.
Clockwork cat|A little clockwork kitty. Their purr runs like a well-loved machine.
Lil' Creator|A little leafy guardian, growing fonder of you by the day.
Chompy chick|A tiny chick with a proud little hop and an appetite for adventures.
Lil' Destructor|A little fiery guardian, warming up to you in their own way.
Penance Pet|A little minigame menace who thinks teamwork means following you everywhere.
Bloodhound|A devoted little detective. Every trail leads back to their favourite human.
Herbi|A little herbiboar, snuffling out greens and good company.
Abyssal protector|A little guardian of the rift, protecting your heart between adventures.
Quetzin|A little quetzal with colourful feathers and an equally colourful personality.
Broav|A little tracker with a nose for trouble and a fondness for your footsteps.
Mr McGroot|A leafy little gentleman, putting down roots in your heart.
Humphrey Dumphrey|A little egg-shaped friend. Please handle all their grand plans with care.
Spooky chair|A tiny haunted seat. They have saved their best spot for you.
Mayor of Catherby|A very important little resident, conducting official snack inspections.
Heron|A patient little fisher who would happily share your company, if not your fish.
Giant Squirrel|A bright-eyed little acrobat with big plans for your nut collection.
Rocky|A tiny masked rascal. They have already stolen your heart.
Dark Squirrel|A shadowy little acrobat, hoarding nuts and precious moments with you.
Red|A red little companion, bringing a bright splash of affection to your travels.
Ziggy|A little skilling companion, proudly keeping pace with their favourite adventurer.
Great blue heron|A grand blue fisher with a surprisingly delicate little greeting.
Greatish guardian|A not-quite-great guardian, giving your friendship their very greatest effort.
Pheasant|A handsome little bird, strutting as though your compliments made the feathers.
Fox|A clever little woodland friend. That sly smile says they know you adore them.
Bone Squirrel|A little squirrel with rattly bones and an enduring love of nuts.
Soup|A little companion with a name that sounds suspiciously like a warm hug.
Ahrim the Blighted|A brooding Barrows mage. Perhaps a kind word can lift the gloom.
Karil the Tainted|A watchful Barrows ranger, guarding your walk with quiet care.
Dharok the Wretched|A mighty Barrows warrior. Even that enormous axe cannot cut your bond.
Guthan the Infested|A hungry Barrows warrior who would rather share a snack than a spear.
Torag the Corrupted|A stout Barrows smith with two hammers and a surprisingly tender heart.
Verac the Defiled|A stern Barrows brother, keeping a little faith in your friendship.
Gemstone Crab|A glittery little crab, polishing their shell for your approval.
Scurrius|A rat king who has crowned your pockets the royal snack cupboard.
Giant Mole|A devoted digger. Their idea of a gift is a freshly excavated garden.
Deranged Archaeologist|A frantic explorer who has unearthed a small fondness for you.
Dagannoth Supreme|A spiny dagannoth king, making room on the throne for your company.
Dagannoth Rex|A prehistoric king with a mighty stomp and a soft little welcome.
Dagannoth Prime|A regal dagannoth mage, conjuring up a little extra time beside you.
Sarachnis|A motherly spider with far too many feet to leave your side unnoticed.
Blood Moon|A scarlet lunar warrior, glowing a little brighter when you arrive.
Blue Moon|A chilly lunar guardian. Your company is their favourite warm spell.
Eclipse Moon|A golden lunar warrior, peeking out of the shadows to see you.
Kalphite Queen|A desert queen with a hard shell and a soft spot for good company.
Kree'arra|A feathered commander, turning a fearsome wingspan into a welcoming flutter.
Commander Zilyana|A radiant commander who has found a little peace beside you.
General Graardor|A mighty general, trying very hard to make a gentle little wave.
K'ril Tsutsaroth|A demonic commander with a fearsome title and an affectionate little grumble.
The Hueycoatl|A mountain serpent, winding a colourful trail straight into your heart.
Corporeal Beast|A great spectral beast. Somehow your company makes them feel at home.
Nex|An ancient terror, allowing one small exception for your company.
Brutus|A brawny champion, proud to be your very big little companion.
Demonic Brutus|A fiery brute whose favourite victory is getting your attention.
Obor|A hill giant king with a big club and an even bigger need for praise.
Bryophyta|A mossy giant, letting a little friendship take root.
Amoxliatl|A frosty guardian, thawing just enough for a tiny affectionate glance.
Branda the Fire Queen|A fiery queen who has declared your company a royal comfort.
Doom of Mokhaiotl|An ominous presence, bringing a surprisingly sweet end to loneliness.
Mad Angel|A peculiar angel, keeping one gentle wing turned towards you.
Zulrah|A swamp serpent with a venomous reputation and a rather endearing little wiggle.
Vorkath|A blue dragon with cold breath and a warm place for you in their heart.
Phantom Muspah|A shifting phantom who keeps coming back to their favourite shape: beside you.
Maggot King|A wriggly ruler, granting you a very special place in the royal compost heap.
The Nightmare|A terrible dream, trying to be your nicest bedtime companion.
Phosani's Nightmare|An especially restless dream, finding a little comfort in your company.
Yama|An infernal ruler. Your company is a small blessing in a fiery day.
Duke Sucellus|A sleepy duke who thinks you would make an excellent naptime attendant.
The Leviathan|A great sea serpent, greeting you with a rather enthusiastic splash.
The Whisperer|A whisper from the depths, saving their gentlest murmur for you.
Vardorvis|A restless axe-wielder who has taken a rather firm liking to your company.
The Mimic|A suspicious treasure chest. The real treasure is the friend peeking inside.
Hespori|A fierce garden guardian, blooming with a little extra affection.
Skotizo|A shadowy demon, casting a surprisingly comforting shadow beside you.
Shellbane gryphon|A proud winged hunter, folding those fearsome wings for a gentle rest.
Eldric the Ice King|An icy king who has reserved you the warmest seat in the court.
Chaos Fanatic|A chaotic little enthusiast, getting rather excited about your friendship.
Crazy archaeologist|A dusty explorer who has discovered that company is a treasure too.
Scorpia|A great scorpion, carrying a tiny fondness beneath that armoured shell.
King Black Dragon|Three royal heads, all politely requesting another compliment.
Chaos Elemental|A jumble of chaos, somehow always finding a way back to you.
Revenant maledictus|A restless spirit whose favourite haunting ground is beside you.
Calvar'ion|A rattly wilderness monarch, making a little room in their old bones for affection.
Vet'ion|A skeletal king who has sworn to guard your snacks with royal dignity.
Spindel|A patient spider, spinning a little friendship into every thread.
Venenatis|A venomous spider with a surprisingly sweet attachment to your footsteps.
Artio|A woodland bear, lumbering over for a very serious cuddle.
Callisto|A mighty bear with big paws and an even bigger soft spot.
Dusk|A stony gargoyle, saving a little evening watchfulness just for you.
Dawn|A winged gargoyle, greeting you with a bright little flutter.
Abyssal Sire|An abyssal patriarch, looking almost pleased to see their favourite visitor.
Cerberus|Three fearsome heads, all agreeing that you deserve a warm welcome.
Araxxor|A formidable spider, weaving a tiny place for you in their plans.
Thermonuclear smoke devil|A swirling cloud of trouble, blowing you a very small smoky kiss.
Alchemical Hydra|A many-headed marvel, experimenting with four kinds of affection.
Crystalline Hunllef|A crystal beast, shining a little brighter beside their favourite adventurer.
Corrupted Hunllef|A corrupted crystal guardian with a remarkably wholesome fondness for you.
TzTok-Jad|A volcanic guardian whose mighty stomp sounds almost like a happy greeting.
TzKal-Zuk|An infernal champion, warming to your company one towering step at a time.
Sol Heredit|A proud champion, pretending your admiration has not made their day.
Tempoross|A stormy sea spirit, bringing a gentle little breeze along for your walk.
Zalcano|A stone-bound demon, holding a little warmth beneath the rocky exterior.
Penance Queen|A formidable queen, granting your friendship an unexpectedly gracious audience.
Avatar of Creation|A leafy guardian, letting a little kindness grow around you.
Avatar of Destruction|A fiery guardian whose warmest welcome is, unfortunately, quite literal.
Tekton|A walking forge, shaping a surprisingly sturdy friendship.
Vespula|A buzzing queen who considers your attention the sweetest nectar.
Vasa Nistirio|A crystal guardian, reflecting a little fondness in every facet.
Muttadile|A swamp chomper with a toothy smile that is mostly meant kindly.
Great Olm|An ancient chamber guardian, peeking out to check on their favourite guest.
The Maiden of Sugadinti|A scarlet lady, offering a little courtly affection between dramatic poses.
Pestilent Bloat|A shambling fellow who hopes you like them despite the lingering perfume.
Nylocas Vasilias|A many-legged ruler, changing colours to match their cheerful little mood.
Sotetseg|A dark beast who thinks your company is worth finding a way through any maze.
Xarpus|A winged horror, practising a much friendlier little flutter.
Verzik Vitur|A grand vampyric lady who has graciously permitted your cuddly admiration.
Akkha|A desert guardian, reserving a little time between disciplines for your company.
Ba-Ba|A baboon queen who has decided you belong in the royal troop.
Kephri|A scarab queen, carefully rolling your friendship into their greatest treasure.
Zebak|A great desert crocodile, grinning as though you brought the whole river.
Tumeken's Warden|A sunlit sentinel, standing proudly over your little shared journey.
Elidinis' Warden|A riverlit sentinel, keeping a gentle watch on your footsteps.
Abomination|A peculiar creation, delighted that someone finally called them adorable.
Agrith-Naar|A summoned demon who seems rather glad you called them over.
Ancient Guardian|An old sentinel with a new favourite adventurer to watch over.
Arrg|A mighty troll champion. Apparently your compliments are stronger than they look.
Barrelchest|A nautical contraption with a surprisingly affectionate little clank.
Black Knight Titan|A towering dark knight, offering you a rather dignified little nod.
Bouncer|A big faithful hound, bouncing with delight at your company.
General Khazard|A stern warlord, secretly rather pleased to have a walking companion.
Chronozon|A fierce demon who has found three magical words: who's a goodie?
Corrupt Lizardman|A scaly troublemaker, trying their best to be your good little lizard.
Count Draynor|A sleepy vampire count, keeping one affectionate eye on your neck warmer.
Culinaromancer|A culinary menace, cooking up a surprisingly sweet friendship.
Cuthbert|A little acquaintance with a very big enthusiasm for your adventures.
Dad|A great big troll, trying very carefully to give a little friendly pat.
Delrith|A summoned menace who has stayed for the warm welcome.
Elvarg|A fearsome green dragon, guarding a tiny soft spot beneath the scales.
Evil Spirit|A mischievous spirit, haunting you with rather affectionate intentions.
Fragment of Seren|A radiant crystal fragment, reflecting a little love in every facet.
Gadderanks|A stern collector who has apparently taken payment in your attention.
Galvek|A mighty dragon, making a very small exception for your friendship.
Giant Roc|A grand mountain bird, saving a soft feathered welcome for you.
giant scarab|A desert beetle, polishing their shell for your next compliment.
Giant Sea Snake|A long sea serpent with an equally long list of reasons to like you.
Glod|A mighty golden-armed dwarf, forging a little place in your heart.
Ice Troll King|A frosty troll monarch, granting you a very warm royal welcome.
Ithoi the Navigator|A wayward navigator who has finally found some nice company.
Jungle demon|A jungle menace, swinging by for one unexpectedly gentle greeting.
Khazard Ogre|A sturdy ogre with an enormous grin and a tiny need for reassurance.
Koschei the Deathless|A tireless warrior whose fondness for you is equally enduring.
Lowerniel Drakan|A grand vampyre lord, pretending this pleasant stroll was their idea.
Me|A familiar face. Somehow even your double deserves a little kindness.
Melzar the Mad|A muddled wizard, quite certain this friendship is their finest experiment.
Moss Guardian|A mossy sentinel, growing a little greener with every kind word.
Nezikchened|A scheming demon who has unexpectedly developed a soft spot.
Ranis Drakan|A proud vampyre who considers your admiration a charming tribute.
Sand Snake|A sandy little serpent, wriggling closer for a warmer patch of company.
Sea Troll Queen|A sea queen with a mighty splash and a rather gentle royal wave.
Sigmund|A suspicious fellow. At least they seem fond of this little walk.
Sir Leye|A knight with a sharp name and a surprisingly soft greeting.
Sir Mordred|A dark knight, trying to keep their fondness hidden beneath the armour.
Slagilith|A rocky guardian, slowly warming to your steady company.
Slash Bash|A formidable figure with a remarkably gentle little shuffle beside you.
Tolna|A troubled soul, finding a small moment of comfort in your company.
Treus Dayth|A restless spirit, enjoying a friendly visit for a change.
Ulfric|A stern warrior, allowing themselves one little companionable smile.
black golem|A dark stone sentinel with a small spark of affection inside.
grey golem|A grey stone guardian, steadily building a little friendship.
white golem|A pale stone sentinel, quietly shining with pride at your company.
Dessous|A vampyric lord, looking suspiciously pleased with your attention.
Kamil|An icy warrior whose cool expression hides a little warmth.
Fareed|A fiery warrior, glowing with a rather friendly sort of heat.
Damis|A shadowy fighter, keeping a little watchful affection at your side.
Agrith Na-Na|A banana-flavoured menace. Your company is apparently the sweetest ingredient.
Flambeed|A fiery culinary creation, serving up a very warm welcome.
Karamel|A frosty confection, melting just a little at your kind words.
Dessourt|A sweetly named vampyre who thinks your attention is a fine dessert.
Gelatinnoth Mother|A wobbly sea mother, quivering with a rather happy little greeting.
The Inadequacy|A restless nightmare, learning that being loved is enough.
The Everlasting|An enduring nightmare whose little fondness seems equally everlasting.
The Untouchable|An elusive nightmare, cautiously accepting one very gentle compliment.
The Illusive|A slippery dream, choosing to linger a little longer beside you.
Kruk|A formidable monkey, proudly declaring you an honorary member of the troop.
Kob|A burly monkey with a little bashful grin when you look their way.
Keef|A sturdy monkey, keeping a careful watch on your snack supply.
Robert the Strong|A legendary hero, lending a little strength to your shared journey.
Essyllt|An elven warrior, allowing a little tenderness beneath the proud stance.
Surok Magis|A scheming wizard who has somehow conjured up a rather nice friendship.
Balance Elemental|A harmony of elements, finding a little balance in your company.
Prince Itzla Arkan|A proud prince, granting you a small place in the royal procession.
golem guard|A steadfast stone guard, taking their duty to your friendship very seriously.
Arrav|An old hero, still making room for a little warmth beneath the armour.
Emissary Enforcer|A stern emissary, delivering one surprisingly gentle nod of approval.
Lucius|A watchful acquaintance, keeping a small companionable step beside you.
Chimalli|A proud warrior whose warmest greeting is a little respectful nod.
Ennius Tullus|A dignified figure, secretly enjoying this much less formal little outing.
Augur Metzli|A solemn augur who sees a rather sweet future in your friendship.
Wyrd|A strange presence, making your little journey feel pleasantly unusual.
Glough|A scheming gnome, whose smallest plan is apparently to follow you around.
Dagannoth Mother|A colourful sea mother, proudly showing off for their favourite visitor.
Dramen Tree Spirit|An old tree spirit, letting a new little friendship take root.
Draugen|A restless northern spirit, bringing a small shiver of affection.
Evil Chicken|A wicked chicken. That tiny cluck might just mean they like you.
Tarn Razorlor|A haunted figure, finding your company rather less chilling than usual.
Bouncer (ghost)|A faithful hound whose affection has outlasted even their paws.
Black demon (The Grand Tree)|A fearsome demon, trying to make a very gentle little impression.
Glough: Mutated|A transformed gnome with enormous hands and a surprisingly tiny wave.
Elven traitor (Arianwyn)|An elf with a complicated past and a simple wish for pleasant company.
'''.strip().splitlines())

DOGS = {
    'Bernese Mountain Dog': 'A mountain-loving fluffball with a cuddle as warm as their coat',
    'Border Collie': 'A clever little herder, keeping your footsteps together',
    'Chihuahua': 'A tiny watchdog with a heart much bigger than their paws',
    'Corgi': 'A short-legged little royal with a wonderfully wiggly welcome',
    'Greyhound': 'A graceful little runner, saving their quickest dash for your greeting',
    'Husky': 'A snowy adventurer with a chatty little opinion about everything',
    'Labrador': 'A cheerful little retriever, proudly fetching your affection',
    'Pug': 'A wrinkly little sweetheart with a snuffly greeting',
    'Samoyed': 'A smiling little snow cloud with paws',
    'Shiba': 'A fox-faced little friend, pretending your praise is no big deal',
    'Spaniel': 'A silky-eared little explorer, bouncing home to your side',
    'Yorkie': 'A tiny silky adventurer with a surprisingly mighty little strut',
}
COATS = {'Default': 'their own lovely coat', 'White': 'snowy white fluff', 'Brown': 'warm brown fluff',
         'Black': 'velvety black fluff', 'Brown & grey': 'a cosy brown-and-grey coat',
         'Blue & grey': 'a soft blue-and-grey coat', 'Hell': 'a toasty infernal coat'}

FAMILIES = {
    'Snakeling': 'A little {detail} swamp noodle, practising a very friendly wiggle.',
    'Sraracha': 'A little {detail} spider, weaving a very warm place in your heart.',
    'Phoenix': 'A little {detail} flame-feather, glowing with affection between rebirths.',
    'Venenatis spiderling': 'A little {detail} spiderling. Eight feet, one very fond heart.',
    'Callisto cub': 'A {detail} bear cub with a honey-sweet little welcome.',
    "Vet'ion Jr.": 'A {detail} skeletal prince, rattling happily at your footsteps.',
    'Kalphite Princess': 'A {detail} desert princess with a shiny shell and a shy little greeting.',
    'Smoke Devil': 'A {detail} puff of trouble, swirling over for your attention.',
    'Ikkle Hydra': 'A {detail} little hydra. Every head agrees that you are lovely.',
    'Muphin': 'A {detail} little phantom, changing shapes but never their fondness for you.',
    'Archibald': 'A little egg in {detail} finery, looking positively cracking today.',
    'Baby Chinchompa': 'A {detail} little chinchompa, practically bursting with affection.',
    'Tangleroot': 'A little {detail} gardener, growing ever fonder of your company.',
    'Rift guardian': 'A little guardian of {detail} runes, keeping your friendship magically safe.',
    'Rock Golem': 'A little {detail} rock friend with a soft heart beneath the minerals.',
    'Beaver': 'A little {detail} woodworker, patiently building a place in your heart.',
    'Arzinian Avatar': 'A golden avatar of {detail}, taking your little friendship very seriously.',
}

def examine(entry):
    label, section = entry['label'], entry['section']
    if section.startswith('Bosses:') and label == 'Kraken':
        return 'A great deep-sea kraken, offering a rather enthusiastic many-armed welcome.'
    if section.startswith('Bosses:') and label == 'Vanguard':
        return 'A raiding guardian who thinks staying together makes every little journey nicer.'
    if section.startswith('Dogs: '):
        stage, coat = label.split(': ', 1)
        return DOGS[section[6:]] + f'. A {coat.lower()} {stage.lower()}, and entirely too precious.'
    if section.startswith('Cats: '):
        stage = section[6:]
        mood = {'Adult': 'A contented little cat, purring as if you are their whole world',
                'Lazy': 'A sleepy little cat who has put cuddles ahead of chores',
                'Wily': 'A clever little mouser, proudly guarding your company',
                'Kitten': 'A tiny kitten with a mighty purr and rather wobbly paws',
                'Overgrown': 'A great fluffy cat, still quite sure they fit in your lap'}[stage]
        return mood + '. All wrapped up in ' + COATS[label] + '.'
    if entry.get('itemId') in (6670, 6671, 6672):
        colour = {6670: 'blue', 6671: 'green', 6672: 'spiny'}[entry['itemId']]
        return f'A little {colour} fish, bubbling with delight in their portable pond.'
    if label in SPECIAL:
        return SPECIAL[label]
    if ': ' in label:
        family, detail = label.split(': ', 1)
        if family in FAMILIES:
            detail = 'classic' if detail == 'Default' else detail.lower()
            return FAMILIES[family].format(detail=detail)
    raise ValueError('Write an individual lore draft for ' + label)

texts = [(e, examine(e)) for e in entries]
assert len({text for _, text in texts}) == len(texts), 'Each option needs its own distinct examine'
quote = lambda text: json.dumps(text, ensure_ascii=False)
out = ['package com.cornydonkeh.varrockstraycats;', '', 'import java.util.EnumMap;',
       'import java.util.Map;', '', '/** Generated lore-based drafts; original examine texts are unverified. */',
       'final class ExamineTexts', '{',
       '    private static final Map<AppearanceVariant, String> TEXTS = new EnumMap<>(AppearanceVariant.class);',
       '    static', '    {']
for i in range(0, len(texts), 20):
    out.append(f'        group{i}();')
out += ['    }', '', '    static String get(AppearanceVariant variant)', '    {',
        '        return variant == null ? "A once-stray little dog, looking healthier and hoping for a friendly pat." : TEXTS.get(variant);',
        '    }']
for i in range(0, len(texts), 20):
    out += ['', f'    private static void group{i}()', '    {']
    for entry, text in texts[i:i+20]:
        out.append(f'        TEXTS.put(AppearanceVariant.{entry["key"].upper()}, {quote(text)});')
    out.append('    }')
out.append('}')
(ROOT / 'src/main/java/com/cornydonkeh/varrockstraycats/ExamineTexts.java').write_text('\n'.join(out)+'\n', encoding='utf-8')
doc = ['# Examine drafts for local testing', '',
       '**Source status: unverified lore-based drafts.** These lines are original writing, not verified adaptations or quotations of the normal in-game examines. No Wiki lookup was used for this catalogue.', '',
       'Every appearance has a distinct line. Existing native Examine menus are used; only an active cosmetic stray receives the local replacement text. Actual creatures, pets, items, and disabled appearances keep their normal examines.', '']
for section in dict.fromkeys(e['section'] for e in entries):
    doc += ['## '+section, '', '| Option | Draft examine |', '| --- | --- |']
    doc += [f'| {e["label"]} | {text} |' for e, text in texts if e['section'] == section]
    doc.append('')
(ROOT / 'docs/examine-drafts.md').write_text('\n'.join(doc)+'\n', encoding='utf-8')
print(f'Generated {len(texts)} distinct, unverified lore-based examine drafts.')
