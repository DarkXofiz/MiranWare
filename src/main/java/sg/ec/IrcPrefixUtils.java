// Original binary: sg/ec/VZjLIDLs6UqOJoxD
package sg.ec;

import java.util.List;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public final class IrcPrefixUtils {
   private static final String field12723 = "This is a utility class and cannot be instantiated";

   public static PrefixEntry method05944(String var0) {
      if (var0 != null && !var0.isBlank()) {
         for (PrefixEntry var2 : method05947()) {
            if (var2.name().equalsIgnoreCase(var0.trim())) {
               return var2;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public static void method05945(PrefixC2SPacket.Nested238 var0, String var1, UserRole var2, String var3, String var4) {
      if (GlobalConnectionManager.method03858() != null) {
         GlobalConnectionManager.method03852(new PrefixC2SPacket(GlobalConnectionManager.method03858(), var0, var1, var2, var3, var4));
      }
   }

   public static String method05946() {
      GlobalWebSocketClient var0 = MiranWare.getInstance().getClient();
      return var0 == null ? "" : var0.getManager().method01863();
   }

   public static List<PrefixEntry> method05947() {
      GlobalWebSocketClient var0 = MiranWare.getInstance().getClient();
      return var0 == null ? List.of() : var0.getManager().method01879();
   }

   private IrcPrefixUtils() {
      throw new UnsupportedOperationException(field12723);
   }

   public static UserRole method05948() {
      return false ? UserRole.ADMIN : UserRole.method08587(ProfileAPI.get().getModel().getRole().toString());
   }
}
