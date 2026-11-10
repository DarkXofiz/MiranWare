// Original binary: sg/ec/s6v3II0MSatVVxWi
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class SocialStateUtils {
   private SocialStateUtils() {
   }

   public static List<String> method10612() {
      ArrayList var0 = new ArrayList();

      for (String var2 : FriendManager.INSTANCE.method00173()) {
         if (var2 != null && !var2.isEmpty()) {
            var0.add(var2);
         }
      }

      Party var5 = method10614();
      if (var5 != null) {
         for (PartyMember var3 : var5.method10148()) {
            if (method10613(var3)) {
               String var4 = var3.method07586();
               if (var4 != null && !var4.isEmpty()) {
                  var0.add(var4);
               }
            }
         }
      }

      return var0;
   }

   public static boolean method10613(PartyMember var0) {
      if (var0 == null) {
         return false;
      }

      String var1 = var0.method07580();
      if (var1 == null) {
         return false;
      }

      for (String var3 : FriendManager.INSTANCE.method00173()) {
         if (var3.equalsIgnoreCase(var1)) {
            return true;
         }
      }

      return false;
   }

   public static Party method10614() {
      if (MiranWare.getInit() == null) {
         return null;
      }

      GlobalWebSocketClient var0 = MiranWare.getInit().getClient();
      return var0 != null && var0.getManager() != null ? var0.getManager().method01805() : null;
   }
}
