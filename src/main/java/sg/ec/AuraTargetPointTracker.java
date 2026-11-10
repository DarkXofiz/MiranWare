// Original binary: sg/ec/F73B1iqG10kIshaY
package sg.ec;

import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class AuraTargetPointTracker {
   private static final int field07257 = 8;
   private static final double field07258 = 0;
   private Vec3 field07259 = Vec3.ZERO;
   private static final double field07260 = 0.5;
   private static final double field07261 = 1.0E-4;
   private static final double field07262 = 8.0;
   private static final double field07263 = 0.5;
   private static final float field07264 = (float) (Math.PI / 180.0);
   private static final double field07265 = -1.0;
   private static final double field07266 = 0.75;
   private static final double field07267 = 0.01;
   private static final double field07268 = -0.1;
   private static final double field07269 = 0.04;
   private static final double field07270 = 3.2;
   private static final double field07271 = 0.1;
   private static final double field07272 = 0.1;
   private static final double field07273 = 0.99F;
   private static final double field07274 = 0.98F;
   private static final double field07275 = 0.99F;
   private static final double field07276 = 0.5;

   public Vec3 method03324() {
      return this.field07259;
   }

   private Vec3 method03325(LivingEntity var1) {
      AuraTargetPointTracker.Nested93 var2 = this.method03328(var1);
      Vec3 var3 = var1.position().add(0.0, field07263, 0.0);
      Vec3 var4 = var3;
      Vec3 var5 = var1.getDeltaMovement();

      for (int var6 = 0; var6 < 8; var6++) {
         var5 = this.method03331(var5, var2);
         var4 = var4.add(var5);
      }

      return var4.subtract(var3);
   }

   public Vec3 method03326(LivingEntity var1, float var2, float var3) {
      if (var1 == null) {
         this.field07259 = Vec3.ZERO;
         return Vec3.ZERO;
      } else {
         Vec3 var4 = var1.position().add(0.0, field07276, 0.0);
         Vec2 var5 = ((EntityExtensionAccess)var1).getVec2f();
         Vec3 var6 = var1.calculateViewVector(var5.y, var5.x).normalize();
         return this.method03327(var4, var6, var2, var3);
      }
   }

   private Vec3 method03327(Vec3 var1, Vec3 var2, float var3, float var4) {
      this.field07259 = var1.add(var2.scale(var3));
      return var1.add(var2.scale(var4));
   }

   private AuraTargetPointTracker.Nested93 method03328(LivingEntity var1) {
      Vec2 var2 = ((EntityExtensionAccess)var1).getVec2f();
      float var3 = var2.x;
      float var4 = var2.y;
      Vec3 var5 = var1.calculateViewVector(var4, var3);
      float var6 = var4 * field07264;
      double var7 = Math.sqrt(var5.x * var5.x + var5.z * var5.z);
      double var9 = Mth.square(Math.cos(var6));
      boolean var11 = var7 > 0.0;
      double var12 = ((LivingEntityMixin_1248)(Object)var1).IgetEffectiveGravity();
      boolean var14 = var1.hasEffect(MobEffects.SLOW_FALLING);
      double var15 = field07265 + var9 * field07266;
      return new AuraTargetPointTracker.Nested93(
         var11 ? var5.x / var7 : 0.0,
         var11 ? var5.z / var7 : 0.0,
         var11,
         var12 * var15,
         Math.min(var12, field07267) * var15,
         var14,
         field07268 * var9,
         var6 < 0.0F && var11,
         -Mth.sin(var6) * field07269
      );
   }

   public void method03329() {
      this.field07259 = Vec3.ZERO;
   }

   public Vec3 method03330(LivingEntity var1, float var2, float var3) {
      if (var1 == null) {
         this.field07259 = Vec3.ZERO;
         return Vec3.ZERO;
      } else {
         Vec3 var4 = var1.position().add(0.0, field07260, 0.0);
         Vec3 var5 = this.method03325(var1);
         if (var5.lengthSqr() < field07261) {
            Vec2 var10 = ((EntityExtensionAccess)var1).getVec2f();
            Vec3 var7 = var1.calculateViewVector(var10.y, var10.x).normalize();
            return this.method03327(var4, var7, 0.0F, 0.0F);
         } else {
            double var6 = var5.length();
            Vec3 var8 = var5.scale(1.0 / var6);
            float var9 = (float)(var6 / field07262);
            return this.method03327(var4, var8, var2 * var9, var3 * var9);
         }
      }
   }

   private Vec3 method03331(Vec3 var1, AuraTargetPointTracker.Nested93 var2) {
      double var3 = var1.x;
      double var5 = var1.y;
      double var7 = var1.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      var5 += var2.slowFalling() && var5 <= 0.0 ? var2.gravLiftSlow() : var2.gravLiftNormal();
      if (var2.hasHor() && var5 < 0.0) {
         double var11 = var5 * var2.diveCoef();
         var3 += var2.lookX() * var11;
         var5 += var11;
         var7 += var2.lookZ() * var11;
      }

      if (var2.liftUp()) {
         double var14 = var9 * var2.liftCoef();
         var3 -= var2.lookX() * var14;
         var5 += var14 * field07270;
         var7 -= var2.lookZ() * var14;
      }

      if (var2.hasHor()) {
         var3 += (var2.lookX() * var9 - var3) * field07271;
         var7 += (var2.lookZ() * var9 - var7) * field07272;
      }

      return new Vec3(var3 * field07273, var5 * field07274, var7 * field07275);
   }

   // $VF: Compiled from s
   private record Nested93(
      double lookX,
      double lookZ,
      boolean hasHor,
      double gravLiftNormal,
      double gravLiftSlow,
      boolean slowFalling,
      double diveCoef,
      boolean liftUp,
      double liftCoef
   ) {
   }
}
