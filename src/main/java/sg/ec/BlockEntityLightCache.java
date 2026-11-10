// Original binary: sg/ec/Uh681ZkRffJNluDv
package sg.ec;

import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
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

   /** 26.x LightCoordsUtil.max yerine 1.21.11 LightTexture ile ayni islem. */
   public static int maxLight(int var0, int var1) {
      return LightTexture.pack(Math.max(LightTexture.block(var0), LightTexture.block(var1)), Math.max(LightTexture.sky(var0), LightTexture.sky(var1)));
   }

   public static int method05926(BlockAndTintGetter var0, BlockPos var1, BlockEntity var2) {
      BlockEntityLightCacheAccess var3 = (BlockEntityLightCacheAccess)var2;
      if (var3.hex$lightStamp() == field12681) {
         return var3.hex$lightCoords();
      }

      int var4 = LevelRenderer.getLightColor(var0, var2.getBlockState(), var1);
      var3.hex$lightCoords(field12681, var4);
      return var4;
   }
}
