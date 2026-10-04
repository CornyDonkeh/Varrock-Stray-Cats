"""Build reviewed catalogue/config Java from offline cache and RuneLite gamevals.

Inputs are downloaded only during development; no runtime network or cache reads.
"""
import csv, json, re
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
JAVA = ROOT / 'src/main/java/com/cornydonkeh/varrockstraycats'
def constants(file):
    return {int(v): k for k,v in re.findall(r'^\tpublic static final int (\w+) = (\d+);', (ROOT/file).read_text(), re.M)}
npc_constants = constants('npc-ids-source.txt')
anim_constants = constants('animation-ids-source.txt')
item_constants = constants('item-ids-source.txt')
npcs = sorted(csv.DictReader((ROOT/'tools/npcs.tsv').open(encoding='utf-8'), delimiter='\t'), key=lambda n:int(n['id']))
by_id = {int(n['id']): n for n in npcs}
wiki_ids = json.loads((ROOT/'tools/wiki-boss-ids.json').read_text()) if (ROOT/'tools/wiki-boss-ids.json').exists() else {}
def norm(s): return re.sub(r'[^a-z0-9]', '', s.lower())
def key(s):
    words = re.findall(r'[A-Za-z0-9]+', s)
    return words[0].lower() + ''.join(w.title() for w in words[1:])
entries = []
def boss_model(name, matches):
    verified=[by_id[id] for id in wiki_ids.get(name,[]) if id in by_id]
    if verified: matches=verified
    undesirable=['NONCOMBAT','CUTSCENE','SPAWNING','SPAWN','PLACEHOLDER','TRANSMOG','DEAD',
                 'SLEEPING','STASIS','THRONE','INACTIVE','_VIS','DORMANT','SUBMERGED',
                 'TRANSITION','_HUMAN','POST_COMBAT','_TUT_']
    def rank(n):
        symbol=npc_constants.get(int(n['id']),'')
        return (sum(token in symbol for token in undesirable), int(n['idle'])==-1, int(n['walk'])==-1)
    return min(matches,key=rank)
def add(n, section, label=None, config_key=None):
    id = int(n['id'])
    if any(e.get('npcId') == id for e in entries): return
    symbol = npc_constants.get(id)
    if symbol is None: raise ValueError(f'No gameval for {id}: {n["name"]}')
    entries.append(dict(npcId=id, symbol=symbol, label=label or n['name'], section=section,
                        key=config_key or key('appearance '+symbol), idle=int(n['idle']), walk=int(n['walk']),
                        textures=n['textures']))

# Existing dog settings retain their exact keys.
for dog in json.loads((ROOT/'tools/dog-settings.json').read_text()):
    add(by_id[dog['npcId']], dog['section'], dog['label'], dog['key'])

# Every cat follower coat at each stage, including hell variants.
stages = {'GROWNCAT':'Adult', 'LAZYCAT':'Lazy', 'WILEYCAT':'Wily', 'KITTENPET':'Kitten', 'OVERGROWNCAT':'Overgrown'}
for n in npcs:
    sym = npc_constants.get(int(n['id']), '')
    for prefix, stage in stages.items():
        if sym.startswith(prefix) and n['follower'] == 'true':
            coat = sym.removeprefix(prefix).strip('_')
            coat = {'':'Default', '1':'Default', 'LIGHT':'White', 'BROWN':'Brown', 'BLACK':'Black',
                    'BROWNGREY':'Brown & grey', 'BLUEGREY':'Blue & grey', 'HELL':'Hell'}.get(coat, coat.title())
            add(n, 'Cats: '+stage, coat)
            break

# Follower flag identifies pets; exclude quest companions explicitly.
excluded = {'Zanik', 'Nieve', 'Grubfoot'}
for n in npcs:
    id = int(n['id']); sym = npc_constants.get(id,'')
    if n['follower'] != 'true' or n['name'] in excluded or any(e.get('npcId') == id for e in entries): continue
    section = 'Pets: Skilling' if sym.startswith('SKILLPET') else 'Pets: Bosses & raids'
    if sym in {'BLOODHOUNDPET', 'CHOMPY_BIRD_PET', 'HERBIBOAR_PET', 'PENANCE_PET', 'QUETZAL_PET',
               'GOAT_PIT_PET', 'ABYSSAL_PET', 'SOULWARS_PET_RED', 'SOULWARS_PET_BLUE', 'POH_TOY_CAT', 'WGS_BROAV'} or n['name'] == 'Broav': section = 'Pets: Other'
    # Distinguish exact transmog variants with their cache symbol suffix.
    same = [x for x in npcs if x['follower']=='true' and x['name']==n['name']]
    label = n['name'] if len(same)==1 else n['name']+' — '+sym.replace('SKILLPET_', '').replace('_',' ').title()
    add(n, section, label)

for name in ['Humphrey Dumphrey','Archibald']:
    matches = [n for n in npcs if n['name']==name and not npc_constants.get(int(n['id']),'').startswith('POH_')]
    # Follower definitions use these gameval names rather than the follower flag.
    matches = [n for n in matches if 'PRESSURE_PET' in npc_constants.get(int(n['id']),'') or name=='Spooky chair' or name=='Mayor of Catherby']
    for n in matches: add(n,'Pets: Other', name + (' — '+npc_constants[int(n['id'])].replace('_',' ').title() if len(matches)>1 else ''))
for id in [14815,15050]: add(by_id[id],'Pets: Other')

# Extract the first cell of every boss table row, plus quest boss links.
wiki = (ROOT/'bosses-wiki.txt').read_text().split('==Event bosses==')[0]
names = []
section = 'Bosses: World'
for block in wiki.split('|-'):
    first = re.search(r'\n\|\[\[([^\n]+)', block)
    if first:
        for name in re.findall(r'\[\[([^\]|]+)', '[['+first[1]):
            if not name.startswith('File:'): names.append((name, 'Bosses: World'))
quest = wiki.split('==Quest bosses==')[-1].split('==Event bosses==')[0]
for line in quest.splitlines():
    if line.startswith('*'):
        # first linked monster per quest description; multiple boss bullets handled below
        links = re.findall(r'\[\[([^\]|#]+)', line)
        for name in links: names.append((name, 'Bosses: Quests'))
# Only matches with cache models are included, so quest/item/area links cannot enter.
aliases = {'The Maiden of Sugadinti':'The Maiden of Sugadinti', 'Grotesque Guardians':'Dusk',
           'Royal Titans':'Branda the Fire Queen', 'Wintertodt':'Wintertodt', 'Great Olm':'Great Olm'}
missing=[]
for name,section in names:
    name = aliases.get(name,name)
    matches=[n for n in npcs if norm(n['name'])==norm(name) and n['follower']!='true'
             and not npc_constants.get(int(n['id']),'').startswith(('POH_', 'NZONE_', 'CLANCUP_'))]
    if not matches:
        if section=='Bosses: World': missing.append(name)
        continue
    # Avoid making regular NPCs from quest links into boss entries.
    if section=='Bosses: Quests' and name in {'Seren','Drakan','Vannaka','Hespori','Mi-Gor','Glough',
        'mountain troll','hellhound','lizardman','green dragon','giant','gnome','black demon',
        'Renegade Knight','zogre','ghost','Dagannoth Mother'}: continue
    add(boss_model(name,matches),section,name)
for name in ['Dawn','Eldric the Ice King','Demonic Brutus']:
    matches=[n for n in npcs if n['name']==name and n['follower']!='true']
    if matches: add(boss_model(name,matches),'Bosses: World')
for id,label in [(1425,'Glough'), (980,'Dagannoth Mother'), (1163,'Dramen Tree Spirit'),
                  (3922,'Draugen'), (1870,'Evil Chicken'), (1227,'Arzinian Avatar: Strength'),
                  (1230,'Arzinian Avatar: Ranging'), (1233,'Arzinian Avatar: Magic'),
                  (6477,'Tarn Razorlor'), (3509,'Bouncer (ghost)'), (240,'Black demon (The Grand Tree)')]:
    if id in by_id: add(by_id[id],'Bosses: Quests',label)
for name in ['Penance Queen','Avatar of Creation','Avatar of Destruction']:
    matches=[n for n in npcs if norm(n['name'])==norm(name) and n['follower']!='true']
    if matches: add(boss_model(name,matches),'Bosses: World')
for name in ['Elven traitor']:
    for id in wiki_ids.get(name,[]):
        if id in by_id:
            add(by_id[id],'Bosses: Quests',name)
            break
add(by_id[7101],'Bosses: Quests','Glough: Mutated')
add(by_id[8865],'Bosses: Quests','Elven traitor (Arianwyn)')

# Scope is pets, obtainable cat stages, bosses, Wise Old Man and cabbage.
add(by_id[2108],'Characters & cabbage','Wise Old Man')

def item(symbol,label,section):
    id=next(i for i,s in item_constants.items() if s==symbol)
    entries.append(dict(itemId=id,symbol=symbol,label=label,section=section,key=key('appearance item '+symbol),idle=-1,walk=-1,textures='null:null'))
item('CABBAGE','Cabbage','Characters & cabbage')
# Pet fish are inventory pets with no follower NPC; use the actual fishbowl models.
for sym in ['FISHBOWL_BLUEFISH','FISHBOWL_GREENFISH','FISHBOWL_SPINEFISH']:
    if sym in item_constants.values(): item(sym,'Pet fish — '+sym.removeprefix('FISHBOWL_').title(),'Pets: Other')

# Friendly checkbox labels; implementation symbols stay in the provenance table.
pet_prefixes=['SKILLPET_RUNECRAFTING_', 'SKILLPET_MINING_', 'SKILLPET_FARMING_',
              'SKILLPET_HUNTER_', 'SKILLPET_THIEVING_', 'SKILLPET_WC_', 'PHOENIX_PET_',
              'SNAKE_PET_', 'HYDRA_PET_', 'MUSPAH_PET_', 'SARACHNISPET_']
for e in entries:
    if ' — ' in e['label'] and e['section'].startswith('Pets:'):
        symbol=e['symbol']
        suffix=next((symbol.removeprefix(p) for p in pet_prefixes if symbol.startswith(p)), '')
        if 'EASTER26_EGG' in symbol: suffix = 'Pattern '+str(1+['', '_02','_03','_04','_05','_06','_07'].index(symbol.removeprefix('DAGANNOTH_DUNGEON_PRESSURE_PET_EASTER26_EGG')))
        if not suffix:
            suffix={'VETIONPET_2':'Reborn','VETIONPET_2_LEGACY':'Reborn legacy', 'KQ_PET_FLYING':'Flying',
                    'KQ_PET_WALKING':'Walking','SMOKE_PET_OLD':'Legacy', 'SMOKE_PET':'Modern',
                    'PHOENIX_PET':'Orange'}.get(symbol, 'Legacy' if symbol.endswith('_LEGACY') else 'Default')
        e['label']=e['label'].split(' — ')[0]+': '+suffix.replace('_',' ').title()
slayer={'Dusk','Dawn','Abyssal Sire','Kraken','Cerberus','Araxxor','Thermonuclear smoke devil','Alchemical Hydra'}
raids={'Tekton','Vanguard','Vespula','Vasa Nistirio','Muttadile','Great Olm','The Maiden of Sugadinti',
       'Pestilent Bloat','Nylocas Vasilias','Sotetseg','Xarpus','Verzik Vitur','Akkha','Ba-Ba','Kephri','Zebak',
       "Tumeken's Warden", "Elidinis' Warden"}
minigame={'Crystalline Hunllef','Corrupted Hunllef','TzTok-Jad','TzKal-Zuk','Sol Heredit','Tempoross',
          'Zalcano','Penance Queen','Avatar of Creation','Avatar of Destruction'}
wild={'Chaos Fanatic','Crazy archaeologist','Scorpia','King Black Dragon','Chaos Elemental',
      'Revenant maledictus', "Calvar'ion", "Vet'ion",'Spindel','Venenatis','Artio','Callisto'}
for e in entries:
    if e['section']=='Bosses: World':
        for group,names in [('Slayer',slayer),('Raids',raids),('Minigames & skilling',minigame),('Wilderness',wild)]:
            if e['label'] in names:e['section']='Bosses: '+group

(ROOT/'tools/appearance-catalogue.json').write_text(json.dumps(entries,indent=2)+'\n')
print(f'{len(entries)} entries; missing world bosses: {missing}')
