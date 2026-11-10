// Original binary: sg/ec/9e60EdiP62FE5Ekz
package sg.ec;

import java.util.EnumSet;
import java.util.Set;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class SmoothAuraRotation implements AuraRotationStrategy {
   private static final float field05380 = 180.0F;
   private static final float field05381 = 0;
   private static final float field05382 = 0;
   private static final float field05383 = 0;
   private static final float field05384 = 0;
   private static final float field05385 = 0;
   private static final float field05386 = 0;
   private static final float field05387 = 0;
   private static final float field05388 = 0;
   private static final float field05389 = 0;
   private final SmoothAuraRotation.Nested59 field05390 = new SmoothAuraRotation.Nested59();
   private float field05391;
   private float field05392;
   private int field05393;
   private float field05394;
   private float field05395;
   private float field05396;
   private float field05397;
   private boolean field05398;
   private RotationModelRepository field05399;
   private AttackAura field05400;
   private LivingEntity field05401;
   private static final String field05402 = "Smooth";
   private static final float field05403 = -180.0F;
   private static final float field05404 = 180.0F;
   private static final float field05405 = 25.0F;
   private static final float field05406 = -90.0F;
   private static final float field05407 = 90.0F;
   private static final float field05408 = 15.0F;
   private static final float field05409 = 12.0F;
   private static final float field05410 = 0.2F;
   private static final float field05411 = 0.8F;
   private static final float field05412 = 0.2F;
   private static final float field05413 = 0.8F;
   private static final float field05414 = -6.5F;
   private static final float field05415 = 6.5F;
   private static final float field05416 = -4.5F;
   private static final float field05417 = 4.5F;
   private static final float field05418 = -89.9F;
   private static final float field05419 = 89.9F;
   private static final float field05420 = 0.35F;
   private static final float field05421 = -0.8F;
   private static final float field05422 = 0.8F;
   private static final float field05423 = -0.55F;
   private static final float field05424 = 0.55F;
   private static final float field05425 = 0.72F;
   private static final float field05426 = 0.28F;
   private static final float field05427 = 0.72F;
   private static final float field05428 = 0.28F;
   private static final float field05429 = 0.03F;
   private static final float field05430 = 0.5F;
   private static final float field05431 = 0.05F;
   private static final float field05432 = -1.9F;
   private static final float field05433 = 1.9F;
   private static final float field05434 = -1.2F;
   private static final float field05435 = 1.2F;
   private static final float field05436 = 0.45F;
   private static final float field05437 = 0.45F;
   private static final float field05438 = 5.0F;
   private static final float field05439 = 5.0F;
   private static final float field05440 = 1.5F;
   private static final float field05441 = -180.0F;
   private static final float field05442 = 180.0F;
   private static final float field05443 = -90.0F;
   private static final float field05444 = 90.0F;
   private static final float field05445 = -90.0F;
   private static final float field05446 = 90.0F;

   @Override
   public String method02258() {
      return field05402;
   }

   private boolean method02259() {
      if (mc.player != null && this.field05399 != null && this.field05399.method03657()) {
         float var1 = mc.player.getYRot();
         float var2 = mc.player.getXRot();
         float var3 = FreeLookController.method10131();
         float var4 = FreeLookController.method10134();
         float var5 = Mth.wrapDegrees(var3 - var1);
         float var6 = var4 - var2;
         if (Math.abs(var5) <= field05438 && Math.abs(var6) <= field05439) {
            this.field05399.method03664();
            return true;
         }

         Vec3 var7 = mc.player.position();
         Vec3 var8 = mc.player.getDeltaMovement();
         float var9 = mc.player.getAttackStrengthScale(field05440);
         RotationModelSnapshot var10 = RotationModelSnapshot.fallbackReset(
            mc.player,
            var1,
            var2,
            var3,
            var4,
            var7,
            var8,
            var9,
            mc.player.onGround(),
            mc.player.isFallFlying(),
            mc.player.isSprinting(),
            mc.player.isUsingItem(),
            mc.options.keyJump.isDown(),
            (float)mc.player.fallDistance,
            mc.player.tickCount
         );
         RotationModelRepository.Nested107 var11 = this.field05399.method03634(var10);
         if (var11 == null) {
            return true;
         }

         float var12 = method02260(Mth.clamp(var11.yawStep(), field05441, field05442), var5);
         float var13 = method02260(Mth.clamp(var11.pitchStep(), field05443, field05444), var6);
         mc.player.setYRot(var1 + RotationMath.method11343(var12));
         mc.player.setXRot(Mth.clamp(var2 + RotationMath.method11343(var13), field05445, field05446));
         return false;
      } else {
         return true;
      }
   }

   private static float method02260(float var0, float var1) {
      return var1 >= 0.0F ? Mth.clamp(var0, 0.0F, var1) : Mth.clamp(var0, var1, 0.0F);
   }

   private void method02261(boolean var1, float var2, float var3) {
      if (!var1 && this.field05393 <= 0 && RandomUtils.method10442() < field05429 + (var2 + var3) * field05430 * field05431) {
         this.field05393 = RandomUtils.method10445(1, 4);
         this.field05394 = RandomUtils.method10454(field05432, field05433) * var2;
         this.field05395 = RandomUtils.method10454(field05434, field05435) * var3;
      }

      if (var1) {
         this.field05391 = 0.0F;
         this.field05392 = 0.0F;
         this.field05393 = 0;
         this.field05394 = 0.0F;
         this.field05395 = 0.0F;
      }

      if (this.field05393 > 0) {
         this.field05393--;
      } else {
         this.field05394 = this.field05394 * field05436;
         this.field05395 = this.field05395 * field05437;
      }
   }

   private void method02262(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      this.field05400 = var1.aura();
      RotationModelRepository var3 = this.field05400.method00390();
      LivingEntity var4 = var1.target();
      if (var4 != this.field05401) {
         this.field05401 = var4;
         var3.method03654();
         this.method02269();
      }

      this.field05399 = var3;
      RotationManager.method06569(this::method02259);
      RotationModelSnapshot var5 = RotationModelSnapshot.from(var4.getId(), var1);
      RotationModelRepository.Nested107 var6 = var3.method03634(var5);
      if (var6 == null) {
         this.field05390.method02270(mc.player.getYRot(), mc.player.getXRot());
         this.field05390.method02271(var2);
      } else {
         float var7 = mc.player.getYRot();
         float var8 = mc.player.getXRot();
         boolean var9 = var1.rayTrace();
         float var10 = var9 ? 0.0F : this.field05400.method00467();
         float var11 = var9 ? 0.0F : this.field05400.method00385();
         float var12 = this.method02263(Mth.clamp(var6.yawStep(), field05403, field05404), Math.abs(Mth.wrapDegrees(var1.rawYaw() - var7)), field05405);
         float var13 = this.method02263(Mth.clamp(var6.pitchStep(), field05406, field05407), Math.abs(var1.rawPitch() - var8), field05408);
         float var14 = Math.abs(Mth.wrapDegrees(var1.rawYaw() - var7)) + Math.abs(var1.rawPitch() - var8);
         float var15;
         float var16;
         if (this.field05398 && !(var14 > field05409)) {
            this.field05396 = field05410 * this.field05396 + field05411 * var12;
            this.field05397 = field05412 * this.field05397 + field05413 * var13;
            var15 = this.field05396;
            var16 = this.field05397;
         } else {
            this.field05396 = var12;
            this.field05397 = var13;
            this.field05398 = true;
            var15 = var12;
            var16 = var13;
         }

         float var17 = Mth.clamp(Mth.wrapDegrees(var1.rawYaw() - var7), field05414 * var10, field05415 * var10);
         float var18 = Mth.clamp(var1.rawPitch() - var8, field05416 * var11, field05417 * var11);
         this.method02267(var10, var11);
         this.method02261(var9, var10, var11);
         float var19 = var15 + var17 + this.field05391 + this.field05394;
         float var20 = var16 + var18 + this.field05392 + this.field05395;
         this.field05390
            .method02272(
               var7 + var19,
               Mth.clamp(var8 + var20, field05418, field05419),
               var6.turnSpeedYaw(),
               var6.turnSpeedPitch(),
               var6.reverbSpeedYaw(),
               var6.reverbSpeedPitch()
            );
         this.field05390.method02271(var2);
      }
   }

   private float method02263(float var1, float var2, float var3) {
      float var4 = Math.min(1.0F, var2 / var3);
      return var1 * (1.0F - field05420 * (1.0F - var4 * var4));
   }

   @Override
   public Set<AuraRotationUpdateMode> method02264() {
      return EnumSet.of(AuraRotationUpdateMode.TICK, AuraRotationUpdateMode.RENDER);
   }

   @Override
   public Rotation method02265(AttackAura var1) {
      return null;
   }

   @Override
   public void method02266(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      if (var1.pass() == AuraRotationUpdateMode.TICK) {
         this.method02262(var1, var2);
      } else {
         this.field05390.method02271(var2);
      }
   }

   private void method02267(float var1, float var2) {
      float var3 = RandomUtils.method10454(field05421, field05422) * var1;
      float var4 = RandomUtils.method10454(field05423, field05424) * var2;
      this.field05391 = this.field05391 * field05425 + var3 * field05426;
      this.field05392 = this.field05392 * field05427 + var4 * field05428;
   }

   @Override
   public void method02268() {
      this.method02269();
      this.field05401 = null;
      RotationManager.method06550();
      if (this.field05400 != null) {
         this.field05400.method00390().method03654();
      }
   }

   private void method02269() {
      this.field05390.method02273();
      this.field05391 = 0.0F;
      this.field05392 = 0.0F;
      this.field05393 = 0;
      this.field05394 = 0.0F;
      this.field05395 = 0.0F;
      this.field05396 = 0.0F;
      this.field05397 = 0.0F;
      this.field05398 = false;
   }

   // $VF: Compiled from s
   private static final class Nested59 {
      private float field05447;
      private float field05448;
      private float field05449;
      private float field05450;
      private float field05451;
      private float field05452;
      private boolean field05453;
      private static final float field05454 = 9999.0F;
      private static final float field05455 = 9999.0F;
      private static final float field05456 = 9999.0F;
      private static final float field05457 = 9999.0F;
      private static final float field05458 = 9999.0F;
      private static final float field05459 = 9999.0F;
      private static final float field05460 = 9999.0F;
      private static final float field05461 = 9999.0F;

      void method02270(float var1, float var2) {
         this.method02272(var1, var2, 0.0F, 0.0F, 0.0F, 0.0F);
      }

      private Nested59() {
         this.field05449 = field05454;
         this.field05450 = field05455;
         this.field05451 = field05456;
         this.field05452 = field05457;
      }

      void method02271(AuraRotationController.Nested161 var1) {
         if (this.field05453) {
            var1.method05332(this.field05447);
            var1.method05339(this.field05448);
            var1.method05325(this.field05449, this.field05450);
            var1.method05337(this.field05451, this.field05452);
            var1.method05335(false);
         }
      }

      void method02272(float var1, float var2, float var3, float var4, float var5, float var6) {
         this.field05447 = var1;
         this.field05448 = var2;
         this.field05449 = var3;
         this.field05450 = var4;
         this.field05451 = var5;
         this.field05452 = var6;
         this.field05453 = true;
      }

      void method02273() {
         this.field05447 = 0.0F;
         this.field05448 = 0.0F;
         this.field05449 = field05458;
         this.field05450 = field05459;
         this.field05451 = field05460;
         this.field05452 = field05461;
         this.field05453 = false;
      }
   }
}
