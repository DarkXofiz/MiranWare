// Original binary: hex/api/baritone/api/utils/VecUtils
package hex.api.baritone.api.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class VecUtils {
   private static final double Чф = 1.0;
   private static final double ЧЕ = 1.0;
   private static final double Чч = 1.0;
   private static final double Ч衣 = 0;
   private static final double Чц = 0;
   private static final double ЧМ = 0;
   private static final double Ч5 = 0;
   private static final double ЧЖ = 0;
   private static final double Чо = 0;
   private static final double ЧК = 0;

   public static double entityDistanceToCenter(Entity var0, BlockPos var1) {
      return distanceToCenter(var1, var0.position().x, var0.position().y, var0.position().z);
   }

   public static double entityFlatDistanceToCenter(Entity var0, BlockPos var1) {
      return distanceToCenter(var1, var0.position().x, var1.getY() + ЧК, var0.position().z);
   }


   public static Vec3 calculateBlockCenter(Level var0, BlockPos var1) {
      if (var1 instanceof BetterBlockPos) {
         var1 = new BlockPos(var1.getX(), var1.getY(), var1.getZ());
      }

      BlockState var2 = var0.getBlockState(var1);
      VoxelShape sx = var2.getCollisionShape(var0, var1);
      if (sx.isEmpty()) {
         return getBlockPosCenter(var1);
      }

      double sxx = (sx.min(Axis.X) + sx.max(Axis.X)) / Чф;
      double sxxx = (sx.min(Axis.Y) + sx.max(Axis.Y)) / ЧЕ;
      double sxxxx = (sx.min(Axis.Z) + sx.max(Axis.Z)) / Чч;
      if (!Double.isNaN(sxx) && !Double.isNaN(sxxx) && !Double.isNaN(sxxxx)) {
         if (var2.getBlock() instanceof BaseFireBlock) {
            sxxx = 0.0;
         }

         return new Vec3(var1.getX() + sxx, var1.getY() + sxxx, var1.getZ() + sxxxx);
      } else {
         throw new IllegalStateException(var2 + " " + var1 + " " + sx);
      }
   }

   public static double distanceToCenter(BlockPos var0, double var1, double var3, double var5) {
      double var7 = var0.getX() + Ч5 - var1;
      double sx = var0.getY() + ЧЖ - var3;
      double sxx = var0.getZ() + Чо - var5;
      return Math.sqrt(var7 * var7 + sx * sx + sxx * sxx);
   }

   private VecUtils() {
   }

   public static Vec3 getBlockPosCenter(BlockPos var0) {
      return new Vec3(var0.getX() + Ч衣, var0.getY() + Чц, var0.getZ() + ЧМ);
   }
}
