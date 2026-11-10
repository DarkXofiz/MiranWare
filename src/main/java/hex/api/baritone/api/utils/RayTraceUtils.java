// Original binary: hex/api/baritone/api/utils/RayTraceUtils
package hex.api.baritone.api.utils;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class RayTraceUtils {
   public static HitResult rayTraceTowards(Entity var0, Rotation var1, double var2) {
      return rayTraceTowards(var0, var1, var2, false);
   }

   public static HitResult rayTraceTowards(Entity var0, Rotation var1, double var2, boolean var4) {
      Vec3 var5;
      if (var4) {
         var5 = inferSneakingEyePosition(var0);
      } else {
         var5 = var0.getEyePosition(1.0F);
      }

      Vec3 sx = RotationUtils.calcLookDirectionFromRotation(var1);
      Vec3 sxx = var5.add(sx.x * var2, sx.y * var2, sx.z * var2);
      return var0.level().clip(new ClipContext(var5, sxx, Block.OUTLINE, Fluid.NONE, var0));
   }

   private RayTraceUtils() {
   }

   public static Vec3 inferSneakingEyePosition(Entity var0) {
      return new Vec3(var0.getX(), var0.getY() + var0.getEyeHeight(Pose.CROUCHING), var0.getZ());
   }
}
