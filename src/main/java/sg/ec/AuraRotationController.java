// Original binary: sg/ec/RnNOAq99uPAD7f2Q
package sg.ec;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class AuraRotationController implements MinecraftAccess {
   static final float field11610 = 9999.0F;
   private static final float field11611 = 0;
   private static final float field11612 = 0;
   private static final float field11613 = 0;
   private static final float field11614 = 0;
   private static final float field11615 = 0;
   private static final float field11616 = 0;
   private static final float field11617 = 0;
   private final AttackAura field11618;
   private final Map<String, AuraRotationStrategy> field11619;
   private float field11620 = 1.0F;
   private int field11621;
   private boolean field11622;
   private static final int field11623 = Integer.MIN_VALUE;
   private static final int field11624 = Integer.MIN_VALUE;
   private static final double field11625 = 90.0;
   private static final float field11626 = -180.0F;
   private static final float field11627 = 180.0F;
   private static final float field11628 = -90.0F;
   private static final float field11629 = 90.0F;
   private static final float field11630 = 20.0F;
   private static final float field11631 = 4.0F;
   private static final float field11632 = 10.0F;
   private static final long field11633 = 300L;
   private static final double field11634 = 300.0;
   private static final double field11635 = 2.0;
   private static final double field11636 = Math.PI;
   private static final float field11637 = -89.9F;
   private static final float field11638 = 89.9F;
   private static final double field11639 = 3.0;
   private static final float field11640 = -89.9F;
   private static final float field11641 = 89.9F;
   private static final float field11642 = 0.05F;
   private static final float field11643 = 0.35F;

   private boolean method05310() {
      return mc.player != null && mc.level != null;
   }

   public void method05311() {
      this.field11620 = 1.0F;
      this.field11621 = field11624;
      this.field11619.values().forEach(AuraRotationStrategy::method02268);
   }

   public void method05312(int var1) {
      this.method05313(AuraRotationUpdateMode.TICK, false, var1);
   }

   private void method05313(AuraRotationUpdateMode var1, boolean var2, int var3) {
      if (this.method05310()) {
         LivingEntity var4 = AttackAura.field00785;
         if (var4 != null) {
            AuraRotationStrategy var5 = this.method05318();
            if (var5 != null && var5.method02264().contains(var1)) {
               boolean var6 = var1 == AuraRotationUpdateMode.FIXED_60;
               if (var6 && RotationManager.method06562(var3)) {
                  var5.method07066();
               } else {
                  AuraRotationController.Nested160 var7 = this.method05324(var4, var2, var1);
                  AuraRotationController.Nested161 var8 = this.method05314(var7);
                  var5.method02266(var7, var8);
                  if (!this.method05315(var1)) {
                     boolean var9 = this.method05320(var8, var3);
                     if (var6) {
                        var5.method07070(var9);
                     }
                  }
               }
            }
         }
      }
   }

   public AuraRotationController(AttackAura var1) {
      this.field11621 = field11623;
      this.field11622 = false;
      this.field11618 = var1;
      this.field11619 = this.method05321();
   }

   private AuraRotationController.Nested161 method05314(AuraRotationController.Nested160 var1) {
      AuraRotationController.Nested161 var2 = new AuraRotationController.Nested161(
         var1.currentYaw() + var1.yawDelta(), Mth.clamp(var1.currentPitch() + var1.pitchDelta(), field11637, field11638)
      );
      var2.method05337(var1.defaultReturnSpeed(), var1.defaultReturnSpeed());
      return var2;
   }

   private boolean method05315(AuraRotationUpdateMode var1) {
      return true && true && true && true && true ? var1 == AuraRotationUpdateMode.TICK && false : true;
   }

   public Rotation method05316() {
      AuraRotationStrategy var1 = this.method05318();
      return var1 == null ? null : var1.method02265(this.field11618);
   }

   public void method05317(boolean var1, int var2, boolean var3) {
      this.method05313(var3 ? AuraRotationUpdateMode.HIGH_FPS : AuraRotationUpdateMode.RENDER, var1, var2);
   }

   private AuraRotationStrategy method05318() {
      String var1 = this.field11618.method00429().method03022();
      AuraRotationStrategy var2 = CloudRotationRegistry.INSTANCE.method08497(var1);
      return var2 != null ? var2 : this.field11619.get(var1);
   }

   private float method05319() {
      float var1 = mc.getDeltaTracker().getGameTimeDeltaTicks();
      if (!Float.isFinite(var1)) {
         var1 = 1.0F;
      }

      var1 = Mth.clamp(var1, field11642, 2.0F);
      this.field11620 = Mth.lerp(field11643, this.field11620, var1);
      return this.field11620;
   }

   private boolean method05320(AuraRotationController.Nested161 var1, int var2) {
      float var3 = var1.method05326();
      float var4 = Mth.clamp(var1.method05328(), field11640, field11641);
      return RotationManager.method06554(
         new Rotation(var3, var4), var1.method05331(), var1.method05334(), var1.method05329(), var1.method05338(), var2, var1.method05327()
      );
   }

   private Map<String, AuraRotationStrategy> method05321() {
      LinkedHashMap var1 = new LinkedHashMap();

      for (AuraRotationStrategy var3 : List.of(
         new GrimAuraRotation(),
         new MatrixAuraRotation(),
         new MatrixSnapAuraRotation(),
         new LegitAuraRotation(),
         new SmoothAuraRotation(),
         new UniversalAuraRotation()
      )) {
         var1.put(var3.method02258(), var3);
      }

      return Collections.unmodifiableMap(var1);
   }

   private boolean method05322(float var1, float var2, LivingEntity var3, AABB var4) {
      int var5 = mc.player.tickCount;
      if (var5 != this.field11621) {
         this.field11621 = var5;
         this.field11622 = RaycastUtils.method09500(var1, var2, field11639, var3, false, var4);
      }

      return this.field11622;
   }

   public void method05323(int var1) {
      this.method05313(AuraRotationUpdateMode.FIXED_60, false, var1);
   }

   private AuraRotationController.Nested160 method05324(LivingEntity var1, boolean var2, AuraRotationUpdateMode var3) {
      Vec3 var4 = this.field11618.method00466().method01260(this.field11618, var1);
      float var5 = mc.player.getYRot();
      float var6 = mc.player.getXRot();
      float var7 = (float)Mth.wrapDegrees(Math.toDegrees(Math.atan2(var4.z, var4.x)) - field11625);
      float var8 = (float)Mth.wrapDegrees(Math.toDegrees(-Math.atan2(var4.y, Math.hypot(var4.x, var4.z))));
      float var9 = Mth.clamp(Mth.wrapDegrees(var7 - var5), field11626, field11627);
      float var10 = Mth.clamp(Mth.wrapDegrees(var8 - var6), field11628, field11629);
      AABB var11 = var1.getBoundingBox();
      boolean var12 = mc.player.isFallFlying();
      boolean var13 = this.method05322(var5, var6, var1, var11);
      float var14 = this.method05319();
      float var15 = (field11630 + GuiHitTestUtils.method05613(field11631, field11632)) * var14;
      float var16 = (float)(System.currentTimeMillis() % field11633 / field11634 * field11635 * field11636);
      return new AuraRotationController.Nested160(this.field11618, var1, var5, var6, var7, var8, var9, var10, var12, var13, var2, var11, var16, var14, var15, var3);
   }

   // $VF: Compiled from s
   public record Nested160(
      AttackAura aura,
      LivingEntity target,
      float currentYaw,
      float currentPitch,
      float rawYaw,
      float rawPitch,
      float yawDelta,
      float pitchDelta,
      boolean isGliding,
      boolean rayTrace,
      boolean snap,
      AABB targetBox,
      float angle,
      float frameDelta,
      float defaultReturnSpeed,
      AuraRotationUpdateMode pass
   ) {
   }

   // $VF: Compiled from s
   public static final class Nested161 {
      private float field11644;
      private float field11645;
      private float field11646;
      private float field11647;
      private float field11648;
      private float field11649;
      private boolean field11650;
      private static final float field11651 = 9999.0F;
      private static final float field11652 = 9999.0F;
      private static final float field11653 = 9999.0F;
      private static final float field11654 = 9999.0F;

      public void method05325(float var1, float var2) {
         this.field11646 = var1;
         this.field11647 = var2;
      }

      public float method05326() {
         return this.field11644;
      }

      public boolean method05327() {
         return this.field11650;
      }

      public float method05328() {
         return this.field11645;
      }

      public float method05329() {
         return this.field11648;
      }

      public void method05330(float var1) {
         this.field11649 = var1;
      }

      public float method05331() {
         return this.field11646;
      }

      public void method05332(float var1) {
         this.field11644 = var1;
      }

      public void method05333() {
         this.method05325(field11651, field11652);
         this.method05337(field11653, field11654);
      }

      public float method05334() {
         return this.field11647;
      }

      public void method05335(boolean var1) {
         this.field11650 = var1;
      }

      public void method05336(float var1) {
         this.field11648 = var1;
      }

      public void method05337(float var1, float var2) {
         this.field11648 = var1;
         this.field11649 = var2;
      }

      public float method05338() {
         return this.field11649;
      }

      public void method05339(float var1) {
         this.field11645 = var1;
      }

      public Nested161(float var1, float var2) {
         this.field11644 = var1;
         this.field11645 = var2;
      }

      public void method05340(float var1) {
         this.field11646 = var1;
      }

      public void method05341(float var1) {
         this.field11647 = var1;
      }
   }
}
