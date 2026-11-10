// Original binary: sg/ec/Uh681ZkRffJNluDv
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.util.LightCoordsUtil.BrightnessGetter;
import net.minecraft.world.level.BlockAndLightGetter;
import net.minecraft.world.level.block.entity.BlockEntity;

// $VF: Compiled from s
public final class BlockEntityLightCache {
   private static int field12681 = 1;

   public static int method05924() {
      return field12681;
   }

   private BlockEntityLightCache() {
   }

   public static void method05925() {
      if (++field12681 == 0) {
         field12681 = 1;
      }
   }

   public static int method05926(BlockAndLightGetter var0, BlockPos var1, BlockEntity var2) {
      BlockEntityLightCacheAccess var3 = (BlockEntityLightCacheAccess)var2;
      if (var3.hex$lightStamp() == field12681) {
         return var3.hex$lightCoords();
      }

      int var4 = LightCoordsUtil.getLightCoords(BrightnessGetter.DEFAULT, var0, var2.getBlockState(), var1);
      var3.hex$lightCoords(field12681, var4);
      return var4;
   }
}
