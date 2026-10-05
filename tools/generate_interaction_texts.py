"""Generate the reviewed interaction catalogue, with no runtime file access."""
import json
import re
from pathlib import Path

root = Path(__file__).resolve().parents[1]
catalogue = json.loads((root / 'tools/appearance-catalogue.json').read_text())
proposal = (root / 'docs/interaction-text-proposal.md').read_text(encoding='utf-8')
entries = []
section = None
for block in re.split(r'(?m)(?=^## )', proposal):
    if not block.startswith('## '):
        continue
    section = block.splitlines()[0][3:]
    for match in re.finditer(r'(?ms)^### (.*?) \((NPC|Item) (\d+)\)\n(.*?)(?=^### |\Z)', block):
        label, kind, definition, body = match.groups()
        candidates = [c for c in catalogue if c['section'] == section and str(c.get('npcId', c.get('itemId'))) == definition]
        if len(candidates) > 1:
            candidates = [c for c in candidates if c['label'] == label]
        assert len(candidates) == 1, (section, label, definition, candidates)
        name = re.search(r'\*\*Menu:\*\* Pet (.*?);', body).group(1)
        rows = [line.split('|')[2:5] for line in body.splitlines() if re.match(r'\| (Pet|Shoo|Feed bones|Feed meat) \|', line)]
        rows = [[v.strip() for v in row] for row in rows]
        assert len(rows) == 4
        rejected = re.search(r'\*\*Rejected item:\*\* (.*)', body).group(1)
        entries.append((candidates[0]['key'].upper(), [name] + sum(rows, []) + [rejected]))
assert len(entries) == len(catalogue), len(entries)
quote = lambda s: json.dumps(s, ensure_ascii=False)
out = ['package com.cornydonkeh.varrockstraycats;', '', 'import java.util.EnumMap;', 'import java.util.Map;', '', '/** Generated from the approved interaction proposal. */', 'final class InteractionTexts', '{', '    private static final Map<AppearanceVariant, String[]> TEXTS = new EnumMap<>(AppearanceVariant.class);', '    static', '    {']
for i in range(0, len(entries), 20):
    out.append(f'        group{i}();')
fallback = ['Stray dog', "Who's a good doggy?", 'Woof!', 'You gently pet them. They wag their tail happily.', 'Go on, Stray dog!', 'Whine!', 'They lower their tail and move away.', 'Here you go, Stray dog!', 'Woof woof!', 'You offer them the bones. They happily gnaw on them.', 'Here you go, Stray dog!', 'Woof woof!', 'You offer them some meat. They gobble it up.', 'They sniff the item, then turn their nose up at it.']
out += ['    }', '    private static final String[] DOG = new String[] {' + ', '.join(map(quote, fallback)) + '};', '    static String[] get(AppearanceVariant variant)', '    {', '        return variant == null ? DOG : TEXTS.get(variant);', '    }']
for i in range(0, len(entries), 20):
    out += [f'    private static void group{i}()', '    {']
    for key, fields in entries[i:i+20]:
        out.append('        TEXTS.put(AppearanceVariant.' + key + ', new String[] {' + ', '.join(map(quote, fields)) + '});')
    out.append('    }')
out.append('}')
(root / 'src/main/java/com/cornydonkeh/varrockstraycats/InteractionTexts.java').write_text('\n'.join(out) + '\n', encoding='utf-8')
