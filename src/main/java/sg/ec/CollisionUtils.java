// Original binary: sg/ec/B9FBZzbSKkFIXfAI
package sg.ec;

import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class CollisionUtils {
   private static final MutableBlockPos field06210 = new MutableBlockPos();
   private static final double field06211 = 1.0E-7;
   private static final double field06212 = 1.0E-7;
   private static final double field06213 = 1.0E-7;
   private static final double field06214 = 1.0E-7;
   private static final double field06215 = 1.0E-7;
   private static final double field06216 = 1.0E-7;
   private static final double field06217 = 1.0E-7;

   public static boolean method02657(Level var0, AABB var1, Vec3 var2) {
      if (var0 == null) {
         return false;
      }

      int var3 = Mth.floor(var1.minX + Math.min(var2.x, 0.0) - field06212) - 1;
      int sx = Mth.floor(var1.maxX + Math.max(var2.x, 0.0) + field06213) + 1;
      int sxx = Mth.floor(var1.minY + Math.min(var2.y, 0.0) - field06214) - 1;
      int sxxx = Mth.floor(var1.maxY + Math.max(var2.y, 0.0) + field06215) + 1;
      int sxxxx = Mth.floor(var1.minZ + Math.min(var2.z, 0.0) - field06216) - 1;
      int sxxxxx = Mth.floor(var1.maxZ + Math.max(var2.z, 0.0) + field06217) + 1;

      for (int sxxxxxx = var3; sxxxxxx <= sx; sxxxxxx++) {
         int sxxxxxxx = sxxxxxx != var3 && sxxxxxx != sx ? 0 : 1;

         for (int sxxxxxxxx = sxx; sxxxxxxxx <= sxxx; sxxxxxxxx++) {
            int sxxxxxxxxx = sxxxxxxx + (sxxxxxxxx != sxx && sxxxxxxxx != sxxx ? 0 : 1);

            for (int sxxxxxxxxxx = sxxxx; sxxxxxxxxxx <= sxxxxx; sxxxxxxxxxx++) {
               int sxxxxxxxxxxx = sxxxxxxxxx + (sxxxxxxxxxx != sxxxx && sxxxxxxxxxx != sxxxxx ? 0 : 1);
               if (sxxxxxxxxxxx != 3) {
                  BlockState var15 = var0.getBlockState(field06210.set(sxxxxxx, sxxxxxxxx, sxxxxxxxxxx));

                  boolean sxxxxxxxxxxxx = switch (sxxxxxxxxxxx) {
                     case 0 -> !var15.isAir();
                     case 1 -> var15.hasLargeCollisionShape();
                     default -> var15.is(Blocks.MOVING_PISTON);
                  };
                  if (sxxxxxxxxxxxx) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }

   private CollisionUtils() {
   }
}
