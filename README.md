# Varrock Stray Cats

A cosmetic RuneLite plugin built directly on
[Healthy Stray Varrock Dogs](https://github.com/CornyDonkeh/healthy-stray-varrock-dogs).
Varrock's stray dogs can look healthy or take a randomly selected appearance from
cats, dogs, obtainable pets, bosses, the Wise Old Man, and a cabbage.

## Configuration

- **Enable appearances** enables healing and optional favorite replacements.
- **Random favorite appearances** chooses equally from every checked appearance.
  This is off by default, preserving the original healthy-dog behavior.
- Expand the collapsible **Cats**, **Dogs**, **Pets**, **Bosses**, and
  **Characters & cabbage** sections to check individual appearances. Cats include
  kitten, adult, overgrown, lazy and wily forms, with every coat and hell variant.
  Dogs retain all 72 original breed/age/color choices and saved checkbox keys.
- **Include Duke in favorites** lets Duke join the random pool. This is off
  by default, so Duke stays healthy unless explicitly included.

Each stray keeps its appearance while loaded. Changing settings, leaving and
returning, relogging, or hopping worlds can reroll it. With no favorites checked,
the plugin falls back to healthy dogs with their original coats.

Original NPC names and server behavior remain. These cosmetic models do not
become owned pets. The rendering callback hides the original dog's 3D clickbox
along with its model; the replacement does not add pet interactions.
Bosses keep their native scale. Stationary models and inventory
pets follow the stray without walking animations.
Wintertodt has no standalone NPC model in this cache and is excluded; multipart
bosses use their main NPC model. Historical event bosses with absent models are
also excluded. See the [appearance catalogue](docs/appearances.md) for IDs,
native animations, coverage and data provenance.

## Development

Plugin Hub installation becomes available after RuneLite reviews and accepts the
submission. Once listed, search for **Varrock Stray Cats** in RuneLite's Plugin Hub.
The plugin has its own settings group and copies existing selections from the
development version or Healthy Stray Varrock Dogs without overwriting new settings.

Requires Java 11 or later. From the plugin directory:

```powershell
.\gradlew.bat test
.\gradlew.bat run
```

For Jagex Accounts, follow RuneLite's
[development-client login instructions](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts).
Do not share or commit the credentials file referenced there.

## In-game acceptance checks

The build and unit tests cannot verify in-game rendering. Manually check:

1. With random appearances off, grey strays, the brown west-gate dog and Duke
   appear healthy with their original coats.
2. Enable random appearances and select only a kitten. Confirm every unnamed
   stray uses that kitten, including idle, walking, color, size and turning.
   Repeat with an adult/wily/hellcat and a puppy/adult dog option.
3. Test individual selections for a pet, large boss, Wise Old Man and
   cabbage. Check textured pets such as Scurry and the recent 2026 pets.
4. Check favorites across multiple sections together. Only those choices should
   appear, and watching a loaded stray must not continuously reroll it.
5. Duke stays healthy by default. Enable **Include Duke in favorites** and
   confirm he joins the pool; disable it to restore him.
6. Uncheck every favorite: healthy dogs return. Turn the master switch off:
   injured originals return. Disable/re-enable, relog, leave/return and hop
   worlds: no orphaned or doubled replacements should remain.
7. Check overhead text and right-click behavior; the original dog's 3D clickbox
   is hidden with its model. Repeat visibility checks with GPU on and off. Other NPCs,
   including actual bosses and owned pets, should retain normal appearances.

Original plugin copyright and BSD license are retained in [LICENSE](LICENSE).
