// Original binary: sg/ec/lU2mDmCHslZ7szsG
package sg.ec;

import java.util.function.Consumer;

// $VF: Compiled from s
public final class GlobalRequestSender {
   public static boolean method09378(Consumer<GlobalPacketRegistry> var0) {
      GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
      if (var1 != null && var1.isOpen()) {
         var0.accept(var1.getManager());
         return true;
      } else {
         return false;
      }
   }

   private GlobalRequestSender() {
   }
}
