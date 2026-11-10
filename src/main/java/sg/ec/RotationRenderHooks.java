// Original binary: sg/ec/TczVzkfX9eTE21AG
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public final class RotationRenderHooks implements MinecraftAccess {
   private static final float field12031 = 0.0025000002F;
   private static final float field12032 = 0;
   private static final float field12033 = 0;
   private static final float field12034 = 0;
   private static final float field12035 = 0;
   private static final float field12036 = 0;
   private static final float field12037 = 0;
   private static boolean field12038;
   private static float field12039;
   private static float field12040;
   private static float field12041;
   private static float field12042;
   private static float field12043;
   private static float field12044;
   private static final double field12045 = 0.0025000002F;
   private static final float field12046 = 180.0F / (float)Math.PI;
   private static final float field12047 = 90.0F;
   private static final float field12048 = 95.0F;
   private static final float field12049 = 265.0F;
   private static final float field12050 = 180.0F;
   private static final float field12051 = 0.3F;
   private static final float field12052 = 15.0F;
   private static final float field12053 = 50.0F;

   private RotationRenderHooks() {
   }

   private static HitResult method05673(HitResult var0, Vec3 var1, double var2) {
      Vec3 var4 = var0.getLocation();
      if (var4.closerThan(var1, var2)) {
         return var0;
      }

      Vec3 var5 = var4.subtract(var1);
      return BlockHitResult.miss(var4, Direction.getApproximateNearest(var5.x, var5.y, var5.z), BlockPos.containing(var4));
   }

   public static float method05674(float var0) {
      return method05675() ? method05680(method05679()) : var0;
   }

   private static boolean method05675() {
      LocalPlayer var0 = mc.player;
      return var0 != null && mc.getCameraEntity() == var0 && method05678(var0);
   }

   private static float method05676(LivingEntity var0, float var1, float var2) {
      double var3 = var0.getX() - var0.xo;
      double var5 = var0.getZ() - var0.zo;
      float var7 = var1;
      if (var3 * var3 + var5 * var5 > field12045) {
         float var8 = (float)Mth.atan2(var5, var3) * field12046 - field12047;
         float var9 = Mth.abs(Mth.wrapDegrees(var2) - var8);
         var7 = field12048 < var9 && var9 < field12049 ? var8 - field12050 : var8;
      }

      if (var0.getAttackAnim(0.0F) > 0.0F) {
         var7 = var2;
      }

      var1 += Mth.wrapDegrees(var7 - var1) * field12051;
      float var11 = Mth.wrapDegrees(var2 - var1);
      float var12 = var0.isBlocking() ? field12052 : field12053;
      if (Math.abs(var11) > var12) {
         var1 += var11 - Mth.sign(var11) * var12;
      }

      return var1;
   }

   public static float method05677(float var0) {
      return method05675() ? method05682(method05679()) : var0;
   }

   public static boolean method05678(LivingEntity var0) {
      return field12038 && var0 == mc.player && !var0.isFallFlying() && !var0.isPassenger();
   }

   private static float method05679() {
      return mc.getDeltaTracker().getGameTimeDeltaPartialTick(true);
   }

   public static float method05680(float var0) {
      return Mth.lerp(var0, field12044, field12043);
   }

   private static boolean method05681(LivingEntity var0) {
      return Math.abs(Mth.wrapDegrees(field12041 - var0.yBodyRot)) < 1.0F && Math.abs(Mth.wrapDegrees(field12039 - var0.yHeadRot)) < 1.0F;
   }

   public static float method05682(float var0) {
      return Mth.rotLerp(var0, field12040, field12039);
   }

   public static HitResult method05683(HitResult var0) {
      if (mc.level != null && method05675()) {
         LocalPlayer var1 = mc.player;
         float var2 = method05679();
         double var3 = var1.blockInteractionRange();
         double var5 = Math.max(var3, var1.entityInteractionRange());
         Vec3 var7 = var1.getEyePosition(var2);
         Vec3 var8 = var1.calculateViewVector(method05680(var2), method05682(var2));
         BlockHitResult var9 = mc.level.clip(new ClipContext(var7, var7.add(var8.scale(var5)), Block.OUTLINE, Fluid.NONE, var1));
         double var10 = var9.getLocation().distanceToSqr(var7);
         if (var9.getType() != Type.MISS) {
            var5 = Math.sqrt(var10);
         }

         Vec3 var12 = var8.scale(var5);
         EntityHitResult var13 = ProjectileUtil.getEntityHitResult(
            var1, var7, var7.add(var12), var1.getBoundingBox().expandTowards(var12).inflate(1.0), EntitySelector.CAN_BE_PICKED, var5 * var5
         );
         return var13 != null && var13.getLocation().distanceToSqr(var7) < var10
            ? method05673(var13, var7, var1.entityInteractionRange())
            : method05673(var9, var7, var3);
      } else {
         return var0;
      }
   }

   public static float method05684(float var0) {
      return Mth.rotLerp(var0, field12042, field12041);
   }

   public static Direction method05685(Direction var0) {
      return method05675() ? Direction.fromYRot(method05682(method05679())) : var0;
   }

   static void method05686(Rotation var0) {
      LocalPlayer var1 = mc.player;
      if (var1 != null && (var0 != null || field12038)) {
         if (!field12038) {
            field12039 = var1.yHeadRot;
            field12041 = var1.yBodyRot;
            field12043 = var1.getXRot();
            field12038 = true;
         }

         field12040 = field12039;
         field12042 = field12041;
         field12044 = field12043;
         field12039 = var0 != null ? var0.method09439() : var1.yHeadRot;
         field12043 = var0 != null ? var0.method09443() : var1.getXRot();
         field12041 = method05676(var1, field12041, field12039);
         if (var0 == null && method05681(var1)) {
            field12038 = false;
         }
      } else {
         field12038 = false;
      }
   }
}
