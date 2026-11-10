// Original binary: sg/ec/HuzMD3ytbsgCem9U
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

// $VF: Compiled from s
public final class BotEntityUtils {
   private BotEntityUtils() {
   }

   public static boolean method03835(Entity var0) {
      return var0 != null && var0.level() instanceof BotClientLevel;
   }

   public static boolean method03836(Level var0) {
      return var0 instanceof BotClientLevel;
   }
}
