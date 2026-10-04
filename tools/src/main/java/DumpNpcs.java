import java.io.*;
import java.nio.charset.StandardCharsets;
import net.runelite.cache.NpcManager;
import net.runelite.cache.fs.Store;
import net.runelite.cache.definitions.NpcDefinition;

/** Offline development tool; run against a COPY of the cache, never the live cache. */
public class DumpNpcs {
    public static void main(String[] args) throws Exception {
        try (Store store = new Store(new File(args[0]))) {
            store.load();
            NpcManager manager = new NpcManager(store);
            manager.load();
            try (PrintWriter out = new PrintWriter(args[1], StandardCharsets.UTF_8.name())) {
                out.println("id\tname\tidle\twalk\tfollower\tmodels\ttextures");
                for (NpcDefinition npc : manager.getNpcs()) {
                    if (npc.models != null && npc.models.length > 0)
                        out.printf("%d\t%s\t%d\t%d\t%s\t%s\t%s%n", npc.id, npc.name,
                            npc.standingAnimation, npc.walkingAnimation, npc.isFollower,
                            java.util.Arrays.toString(npc.models),
                            java.util.Arrays.toString(npc.retextureToFind) + ":" + java.util.Arrays.toString(npc.retextureToReplace));
                }
            }
        }
    }
}
