// Original binary: sg/ec/IMfwdBm9yAlTKKrE
package sg.ec;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.Entity.RemovalReason;

// $VF: Compiled from s
public class CapturedPlayerManager {
   private static final Set<CapturedPlayer> field08740 = Collections.newSetFromMap(new ConcurrentHashMap<>());

   public static void method03886() {
      for (CapturedPlayer var1 : field08740) {
         var1.remove(RemovalReason.DISCARDED);
      }

      field08740.clear();
   }

   public static Set<CapturedPlayer> method03887() {
      return field08740;
   }

   public static CapturedPlayer method03888(AbstractClientPlayer var0) {
      CapturedPlayer var1 = new CapturedPlayer(var0);
      field08740.add(var1);
      return var1;
   }
}
