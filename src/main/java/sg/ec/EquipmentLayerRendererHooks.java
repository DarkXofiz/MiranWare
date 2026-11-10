// Original binary: sg/ec/Nwo0frUZyOdKTs3p
package sg.ec;

import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class EquipmentLayerRendererHooks {
   public static int method04735(int var0, ItemStack var1) {
      if (!ArmorColorEvent.field04612.method05698()) {
         return var0;
      }

      int var2 = ArmorColorEvent.field04612.method01911(var1, var0);
      return ArmorColorEvent.field04612.method01914() ? var2 : var0;
   }

   private EquipmentLayerRendererHooks() {
   }
}
