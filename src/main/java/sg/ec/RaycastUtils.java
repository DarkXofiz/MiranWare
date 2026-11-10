// Original binary: sg/ec/mZLJdJO9PUbZoscY
package sg.ec;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class RaycastUtils implements MinecraftAccess {
   private static final double field21537 = 6.0;
   private static final float field21538 = (float) (Math.PI / 180.0);
   private static final float field21539 = (float) Math.PI;
   private static final float field21540 = (float) (Math.PI / 180.0);
   private static final double field21541 = 6.0;
   private static final double field21542 = 6.0;
   private static final double field21543 = 6.0;
   private static final String field21544 = "This is a utility class and cannot be instantiated";

   public static boolean method09497(BlockPos var0) {
      if (mc.player != null && mc.level != null) {
         Vec3 var1 = mc.player.getEyePosition();
         Vec3 sx = Vec3.atCenterOf(var0);
         Vec3 sxx = mc.player.getViewVector(1.0F);
         double sxxx = var1.distanceTo(sx) + 1.0;
         Vec3 sxxxx = var1.add(sxx.scale(sxxx));
         VoxelShape sxxxxx = mc.level.getBlockState(var0).getCollisionShape(mc.level, var0);
         if (sxxxxx.isEmpty()) {
            return false;
         }

         var sxxxxxx = sxxxxx.bounds().move(var0).clip(var1, sxxxx);
         if (sxxxxxx.isEmpty()) {
            return false;
         }

         BlockHitResult sxxxxxxx = method09507(var1, sxxxxxx.get());
         return sxxxxxxx.getType() == Type.BLOCK && sxxxxxxx.getBlockPos().equals(var0);
      } else {
         return false;
      }
   }

   public static HitResult method09498(Vec3 var0, Vec3 var1, Block var2, Fluid var3) {
      return mc.level == null ? null : mc.level.clip(new ClipContext(var0, var1, var2, var3, mc.player));
   }

   public static boolean method09499(Vec3 var0, float var1, float var2, double var3, boolean var5, AABB var6) {
      if (mc.level == null) {
         return false;
      } else {
         Vec3 var7 = var0.add(method09509(var2, var1).scale(var3));
         if (var6.contains(var0)) {
            return true;
         } else {
            var var8 = var6.clip(var0, var7);
            if (var8.isEmpty()) {
               return false;
            } else if (!var5) {
               return true;
            } else {
               BlockHitResult var9 = method09507(var0, (Vec3)var8.get());
               if (var9.getType() == Type.BLOCK) {
                  double var10 = var0.distanceTo(var9.getLocation());
                  double var12 = var0.distanceTo((Vec3)var8.get());
                  return !(var10 < var12);
               } else {
                  return true;
               }
            }
         }
      }
   }

   public static boolean method09500(float var0, float var1, double var2, Entity var4, boolean var5, AABB var6) {
      return mc.player == null ? false : method09499(mc.player.getEyePosition(), var0, var1, var2, var5, var6);
   }

   public static boolean method09501(BlockPos var0, double var1) {
      float var3 = RotationManager.method06563();
      return Float.isNaN(var3) || method09503(var0, var3, RotationManager.method06557(), var1);
   }

   public static boolean method09502(float var0, float var1, double var2, Entity var4) {
      return method09505(var0, var1, var2, var4, false);
   }

   private RaycastUtils() {
      throw new UnsupportedOperationException(field21544);
   }

   public static boolean method09503(BlockPos var0, float var1, float var2, double var3) {
      if (mc.player == null) {
         return false;
      }

      Vec3 var5 = mc.player.getEyePosition();
      Vec3 var6 = var5.add(method09509(var2, var1).scale(var3));
      AABB var7 = new AABB(var0);
      return var7.contains(var5) || var7.clip(var5, var6).isPresent();
   }

   public static Entity method09504(float var0, float var1, float var2, boolean var3) {
      if (mc.player != null && mc.level != null) {
         Vec3 var4 = mc.player.getEyePosition();
         Vec3 var5 = var4.add(method09509(var1, var0).scale(var2));
         if (var3) {
            BlockHitResult var6 = method09507(var4, var5);
            if (var6.getType() != Type.MISS) {
               var5 = var6.getLocation();
            }
         }

         Entity var14 = null;
         double var7 = var2;

         for (Entity var10 : mc.level.entitiesForRendering()) {
            if (var10 != mc.player && var10.isAlive()) {
               var var11 = var10.getBoundingBox().clip(var4, var5);
               if (var11.isPresent()) {
                  double var12 = var4.distanceTo((Vec3)var11.get());
                  if (var12 < var7) {
                     var7 = var12;
                     var14 = var10;
                  }
               }
            }
         }

         return var14;
      } else {
         return null;
      }
   }

   public static boolean method09505(float var0, float var1, double var2, Entity var4, boolean var5) {
      return method09500(var0, var1, var2, var4, var5, var4.getBoundingBox());
   }

   public static boolean method09506(net.minecraft.world.level.block.Block var0) {
      if (mc.player != null && mc.level != null) {
         BlockHitResult var1 = method09507(mc.player.getEyePosition(), method09510());
         return var1.getType() == Type.BLOCK ? mc.level.getBlockState(var1.getBlockPos()).is(var0) : false;
      } else {
         return false;
      }
   }

   private static BlockHitResult method09507(Vec3 var0, Vec3 var1) {
      return mc.level.clip(new ClipContext(var0, var1, Block.COLLIDER, Fluid.NONE, mc.player));
   }

   public static Vec3 method09508(float var0, float var1, double var2) {
      if (mc.level == null) {
         return null;
      }

      Vec3 var4 = mc.gameRenderer.mainCamera().position();
      Vec3 var5 = var4.add(method09509(var1, var0).scale(var2));
      BlockHitResult var6 = method09507(var4, var5);
      return var6.getType() == Type.BLOCK ? var6.getLocation() : null;
   }

   public static Vec3 method09509(float var0, float var1) {
      float var2 = -var1 * field21538 - field21539;
      float var3 = -var0 * field21540;
      float var4 = Mth.cos(var2);
      float var5 = Mth.sin(var2);
      float var6 = -Mth.cos(var3);
      float var7 = Mth.sin(var3);
      return new Vec3(var5 * var6, var7, var4 * var6);
   }

   private static Vec3 method09510() {
      Vec3 var0 = mc.player.getViewVector(1.0F);
      return mc.player.getEyePosition().add(var0.x * field21541, var0.y * field21542, var0.z * field21543);
   }

   public static BlockHitResult method09511(net.minecraft.world.level.block.Block... var0) {
      if (mc.player != null && mc.level != null) {
         BlockHitResult var1 = method09507(mc.player.getEyePosition(), method09510());
         if (var1.getType() == Type.BLOCK) {
            BlockState var2 = mc.level.getBlockState(var1.getBlockPos());

            for (net.minecraft.world.level.block.Block var6 : var0) {
               if (var2.is(var6)) {
                  return var1;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }
}
