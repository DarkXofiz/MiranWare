// Original binary: sg/ec/dbIQl5SlERsSZiK9
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

// $VF: Compiled from s
public class ItemFluidPhysics {
   private static final float field18187 = 6.0F;
   private static final double field18188 = 0.2;

   public static float method07427(Fluid var0, Level var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         return var0.is(FluidTags.LAVA) ? field18187 : 1.0F;
      }
   }

   public static Fluid method07428(ItemEntity var0) {
      return method07429(var0, false);
   }

   public static Fluid method07429(ItemEntity var0, boolean var1) {
      if (var0.level() == null) {
         return null;
      }

      double var2 = var0.getY();
      BlockPos var4 = var0.blockPosition();
      if (var1) {
         var4 = var4.below();
      }

      FluidState var5 = var0.level().getFluidState(var4);
      Fluid var6 = var5.getType();
      if (var5.isEmpty() || var6 == null) {
         return null;
      }

      if (var1) {
         return var6;
      }

      double var7 = var5.getHeight(var0.level(), var4);
      return var2 - var4.getY() - field18188 <= var7 ? var6 : null;
   }
}
