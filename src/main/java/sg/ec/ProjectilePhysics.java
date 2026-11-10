// Original binary: sg/ec/J0HS7fydxGFeh1Rq
package sg.ec;

import java.util.List;
import java.util.Optional;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public final class ProjectilePhysics implements MinecraftAccess {
   public static final double field08853 = 0.05;
   public static final double field08854 = 0;
   public static final double field08855 = 0;
   public static final double field08856 = 0;
   public static final double field08857 = 0;
   private static final int field08858 = 0;
   private static final int field08859 = 0;
   private static final double field08860 = 0;
   private static final double field08861 = 0;
   private static final double field08862 = 0.1F;
   private static final double field08863 = 1.0E-4;
   private static final double field08864 = Double.MAX_VALUE;
   private static final double field08865 = 0.5;
   private static final double field08866 = Double.MAX_VALUE;
   private static final double field08867 = 1.0E-8;
   private static final double field08868 = 1.0E-6;
   private static final double field08869 = 1.0E-6;
   private static final double field08870 = 0.5;
   private static final double field08871 = 20.0;
   private static final double field08872 = 0.3;

   private static double method03994(int var0) {
      return Mth.clamp((var0 - 2) / field08871, 0.0, field08872);
   }

   private static Vec3 method03995(Vec3 var0, Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, int var8, double var9) {
      return var1.add(var2.scale(var8 + var9)).subtract(var0).subtract(var3.scale(method04002(var6, var9))).add(0.0, method04000(var4, var6, var9), 0.0);
   }

   private ProjectilePhysics() {
   }

   public static ProjectilePhysics.Nested117 method03996(
      Vec3 var0, Vec3 var1, double var2, Vec3 var4, double var5, double var7, double var9, AABB var11, Vec3 var12, int var13, int var14, List<Vec3> var15
   ) {
      Vec3 var16 = var0;
      Vec3 var17 = var1.scale(var2).add(var4);
      double var18 = mc.level.getMinY() - 8;
      if (var15 != null) {
         var15.clear();
         var15.add(var16);
      }

      for (int var20 = 0; var20 < var14; var20++) {
         if (ProjectileTrajectoryTracker.field00265.method00196(var16)) {
            var17 = var17.scale(var9);
         }

         Vec3 var21 = var16.add(var17);
         BlockHitResult var22 = mc.level.clip(new ClipContext(var16, var21, Block.COLLIDER, Fluid.NONE, mc.player));
         Vec3 var23 = var22.getType() == Type.MISS ? null : var22.getLocation();
         double var24 = var23 == null ? field08866 : var16.distanceToSqr(var23);
         if (var11 != null) {
            AABB var26 = var11.move(var12.scale(var13 + var20 + 1.0)).inflate(method03994(var20));
            var var27 = var26.clip(var16, var21);
            if (var27.isPresent() && var16.distanceToSqr((Vec3)var27.get()) <= var24) {
               Vec3 var28 = (Vec3)var27.get();
               if (var15 != null) {
                  var15.add(var28);
               }

               return new ProjectilePhysics.Nested117(var28, var28, var20 + 1, false);
            }
         }

         if (var23 != null) {
            if (var15 != null) {
               var15.add(var23);
            }

            return new ProjectilePhysics.Nested117(var23, null, var20 + 1, true);
         }

         var16 = var21;
         if (var15 != null) {
            var15.add(var16);
         }

         if (!ProjectileTrajectoryTracker.field00265.method00196(var16)) {
            var17 = var17.scale(var7);
         }

         var17 = var17.subtract(0.0, var5, 0.0);
         if (var16.y < var18) {
            return new ProjectilePhysics.Nested117(var16, null, var20 + 1, true);
         }
      }

      return new ProjectilePhysics.Nested117(var16, null, var14, false);
   }

   private static ProjectilePhysics.Nested118 method03997(
      Vec3 var0, Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, int var8, double var9, boolean var11
   ) {
      Vec3 var12 = method03995(var0, var1, var2, var3, var4, var6, var8, var9);
      if (var12.lengthSqr() < field08867) {
         return null;
      }

      Vec3 var13 = var12.normalize();
      return new ProjectilePhysics.Nested118(Rotation.method09438(var13), var13, var9, var11);
   }

   private static double method03998(Vec3 var0, Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, double var8, int var10, double var11) {
      return method03995(var0, var1, var2, var3, var6, var8, var10, var11).length() - var4 * method04002(var8, var11);
   }

   public static Vec3 method03999(Entity var0, float var1) {
      return var0.getEyePosition(var1).subtract(0.0, field08862, 0.0);
   }

   private static double method04000(double var0, double var2, double var4) {
      if (var0 == 0.0) {
         return 0.0;
      } else {
         return 1.0 - var2 < field08869 ? var0 * var4 * (var4 - 1.0) * field08870 : var0 * (var4 - method04002(var2, var4)) / (1.0 - var2);
      }
   }

   public static ProjectilePhysics.Nested118 method04001(Vec3 var0, Vec3 var1, Vec3 var2, Vec3 var3, double var4, double var6, double var8, int var10) {
      if (var4 <= field08863) {
         return null;
      }

      if (method03998(var0, var1, var2, var3, var4, var6, var8, var10, 1.0) <= 0.0) {
         return method03997(var0, var1, var2, var3, var6, var8, var10, 1.0, true);
      }

      double var11 = field08864;
      double var13 = 1.0;

      for (int var15 = 2; var15 <= 120; var15++) {
         double var16 = method03998(var0, var1, var2, var3, var4, var6, var8, var10, var15);
         if (var16 <= 0.0) {
            double var18 = var15 - 1.0;
            double var20 = var15;

            for (int var22 = 0; var22 < 22; var22++) {
               double var23 = (var18 + var20) * field08865;
               if (method03998(var0, var1, var2, var3, var4, var6, var8, var10, var23) > 0.0) {
                  var18 = var23;
               } else {
                  var20 = var23;
               }
            }

            return method03997(var0, var1, var2, var3, var6, var8, var10, var20, true);
         }

         if (var16 < var11) {
            var11 = var16;
            var13 = var15;
         }
      }

      return method03997(var0, var1, var2, var3, var6, var8, var10, var13, false);
   }

   private static double method04002(double var0, double var2) {
      return 1.0 - var0 < field08868 ? var2 : (1.0 - Math.pow(var0, var2)) / (1.0 - var0);
   }

   // $VF: Compiled from s
   public record Nested117(Vec3 end, Vec3 hitPos, int ticks, boolean blocked) {
      public boolean reached() {
         return this.hitPos != null;
      }
   }

   // $VF: Compiled from s
   public record Nested118(Rotation rotation, Vec3 direction, double flightTicks, boolean exact) {
   }
}
