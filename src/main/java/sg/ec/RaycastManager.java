// Original binary: sg/ec/rzJqd3TfmkpDF5hN
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public class RaycastManager implements MinecraftAccess {
   private static final double field23543 = 1.0E-4;
   private static final double field23544 = 0;
   private static final double field23545 = 1.0E-8;
   private static final double field23546 = 0.51;
   private static final double field23547 = 0.51;
   private static final double field23548 = 1.0E-4;
   private static final double field23549 = 1.0E-4;
   private static final double field23550 = 1.0E-8;
   private static final double field23551 = -1.0E-8;

   @Subscribe
   private void method10543(RaycastEvent var1) {
      RaycastEvent.Nested126 var2 = var1.method04129();
      if (var2 == RaycastEvent.Nested126.ENTITY) {
         this.method10549(var1);
      } else if (var2 == RaycastEvent.Nested126.BLOCK) {
         Entity sx = var1.method04123();
         if (sx == mc.player) {
            if (var1.method04136() instanceof BlockHitResult sxx) {
               Level sxxx = sx.level();
               if (sxxx != null) {
                  if (!this.method10547(sxxx, sx, sxx)) {
                     float sxxxx = var1.method04128();
                     double sxxxxx = var1.method04130();
                     Vec3 sxxxxxx = sx.getEyePosition(sxxxx);
                     Vec3 sxxxxxxx = sx.getViewVector(sxxxx);
                     Vec3 sxxxxxxxx = sxxxxxx.add(sxxxxxxx.scale(sxxxxx));
                     BlockHitResult sxxxxxxxxx = this.method10544(sxxx, sx, sxxxxxx, sxxxxxxxx, sxxxxxxx, sxxxxx, var1.method04127(), sxx);
                     var1.method04126(sxxxxxxxxx);
                     var1.method05695(true);
                  }
               }
            }
         }
      }
   }

   private BlockHitResult method10544(Level var1, Entity var2, Vec3 var3, Vec3 var4, Vec3 var5, double var6, boolean var8, BlockHitResult var9) {
      BlockHitResult var10 = var9;
      Fluid var11 = var8 ? Fluid.ANY : Fluid.NONE;
      double var12 = var6 * var6;

      for (int var14 = 0; var14 < 64; var14++) {
         Vec3 var15 = this.method10546(var5, var10);
         if (var15.distanceToSqr(var3) >= var12) {
            return BlockHitResult.miss(var4, var10.getDirection(), var10.getBlockPos());
         }

         var10 = var1.clip(new ClipContext(var15, var4, Block.OUTLINE, var11, var2));
         if (var10.getType() == Type.MISS) {
            return var10;
         }

         if (this.method10547(var1, var2, var10)) {
            return var10;
         }
      }

      return var10;
   }

   private Vec3 method10545(Vec3 var1, Vec3 var2, BlockPos var3) {
      double var4 = var3.getX();
      double var6 = var3.getY();
      double var8 = var3.getZ();
      double var10 = var4 + 1.0;
      double var12 = var6 + 1.0;
      double var14 = var8 + 1.0;
      double var16 = Double.POSITIVE_INFINITY;
      var16 = this.method10548(var16, var2.x, var4 - var1.x, var10 - var1.x);
      var16 = this.method10548(var16, var2.y, var6 - var1.y, var12 - var1.y);
      var16 = this.method10548(var16, var2.z, var8 - var1.z, var14 - var1.z);
      return !Double.isFinite(var16) ? null : var1.add(var2.scale(var16 + field23549));
   }

   private Vec3 method10546(Vec3 var1, BlockHitResult var2) {
      if (var2.isInside()) {
         Vec3 var3 = this.method10545(var2.getLocation(), var1, var2.getBlockPos());
         if (var3 != null) {
            return var3;
         }

         Vec3 var4 = var1.normalize();
         return var4.lengthSqr() < field23545 ? var2.getLocation().add(0.0, field23546, 0.0) : Vec3.atCenterOf(var2.getBlockPos()).add(var4.scale(field23547));
      } else {
         return var2.getLocation().add(var1.scale(field23548));
      }
   }

   private boolean method10547(Level var1, Entity var2, BlockHitResult var3) {
      BlockPos var4 = var3.getBlockPos();
      return HitResultEvent.field07211.method03287(var2, var4, var1.getBlockState(var4));
   }

   private double method10548(double var1, double var3, double var5, double var7) {
      if (var3 > field23550) {
         double var9 = var7 / var3;
         if (var9 >= 0.0 && var9 < var1) {
            return var9;
         }
      } else if (var3 < field23551) {
         double var11 = var5 / var3;
         if (var11 >= 0.0 && var11 < var1) {
            return var11;
         }
      }

      return var1;
   }

   public RaycastManager() {
      EventBus.method00263(this);
   }

   private void method10549(RaycastEvent var1) {
      Entity var2 = var1.method04136() instanceof EntityHitResult var3 ? var3.getEntity() : null;
      if (HitResultEvent.field07211.method03291(var2)) {
         var1.method04126(null);
         var1.method05695(true);
      }
   }
}
