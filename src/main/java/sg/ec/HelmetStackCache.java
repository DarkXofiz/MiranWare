// Original binary: sg/ec/TWkvW548iAIRuGA1
package sg.ec;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class HelmetStackCache {
   private HelmetStackCache() {
   }

   public static ItemStack method05653(LivingEntity var0, EquipmentSlot var1) {
      long var2 = var0.level().getGameTime() + 1L;
      HelmetStackCacheAccess var4 = (HelmetStackCacheAccess)var0;
      if (var4.hex$helmetStamp() == var2) {
         return var4.hex$helmet();
      }

      ItemStack var5 = var0.getItemBySlot(var1);
      var4.hex$helmet(var5, var2);
      return var5;
   }
}
