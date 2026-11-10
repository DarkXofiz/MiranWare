// Original binary: sg/ec/2WQ1gsEjO8mTS7od
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// $VF: Compiled from s
public enum StorageCategory {
   CONFIG("config"),
   THEME("theme"),
   THEME_STATE("themestate"),
   FRIEND_LIST("friendlist", "friends", "friend"),
   STAFF_LIST("stafflist", "staff"),
   DRAGS("drags", "drag"),
   LAST_ACCOUNT("lastaccount", "account"),
   MACROS("macros", "macro"),
   NO_TRACE_LIST("notracelist", "notrace"),
   WAYPOINT_LIST("waypointlist", "waypoint", "waypoints"),
   BLOCK_ESP("blockesp", "blocks", "espblocks"),
   BOTS("bots", "bot", "botlist"),
   AUTO_BUY("autobuy", "auto_buy", "ab"),
   PROXY("proxy", "proxies", "socks");

   private final String[] field01070;

   StorageCategory(String... var3) {
      this.field01070 = var3;
   }

   public String method00552() {
      return this.name();
   }

   public String method00553() {
      return this.field01070.length > 0 ? this.field01070[0] : this.name().toLowerCase(Locale.ROOT);
   }

   public static StorageCategory method00554(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim().toLowerCase(Locale.ROOT);

         for (StorageCategory var5 : values()) {
            if (var5.name().equalsIgnoreCase(var1)) {
               return var5;
            }

            for (String var9 : var5.field01070) {
               if (var9.equals(var1)) {
                  return var5;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public static String method00555() {
      StringBuilder var0 = new StringBuilder();

      for (StorageCategory var4 : values()) {
         if (var0.length() > 0) {
            var0.append(", ");
         }

         var0.append(var4.method00553());
      }

      return var0.toString();
   }

   public static List<String> method00556() {
      var var0 = new ArrayList(values().length);

      for (StorageCategory var4 : values()) {
         var0.add(var4.method00553());
      }

      return var0;
   }
}
