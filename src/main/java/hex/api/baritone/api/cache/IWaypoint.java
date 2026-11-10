// Original binary: hex/api/baritone/api/cache/IWaypoint
package hex.api.baritone.api.cache;

import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// $VF: Compiled from s
public interface IWaypoint {
   long getCreationTimestamp();

   IWaypoint.Tag getTag();

   BetterBlockPos getLocation();

   String getName();

   // $VF: Compiled from s
   enum Tag {
      HOME("home", "base"),
      DEATH("death"),
      BED("bed", "spawn"),
      USER("user");

      private static final List<IWaypoint.Tag> TAG_LIST = Collections.unmodifiableList(Arrays.asList(values()));
      public final String[] names;

      Tag(String... var3) {
         this.names = var3;
      }

      public String getName() {
         return this.names[0];
      }

      public static IWaypoint.Tag getByName(String var0) {
         for (IWaypoint.Tag var4 : values()) {
            for (String sx : var4.names) {
               if (sx.equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return null;
      }

      public static String[] getAllNames() {
         Set var0 = new HashSet<>();

         for (IWaypoint.Tag sx : values()) {
            var0.addAll(Arrays.asList(sx.names));
         }

         return (java.lang.String[]) var0.toArray(new String[0]);
      }
   }
}
