// Original binary: sg/ec/AKnCCa2EfORFXFX6
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
final class RotationDerivativeHistory {
   private float field06006;
   private float field06007;
   private boolean field06008;
   private float field06009;
   private float field06010;
   private boolean field06011;
   private float field06012;
   private float field06013;
   private boolean field06014;
   private float field06015;
   private float field06016;
   private boolean field06017;

   boolean method02505() {
      return this.field06008;
   }

   void method02506() {
      this.field06008 = false;
      this.field06011 = false;
      this.field06014 = false;
      this.field06017 = false;
      this.field06009 = 0.0F;
      this.field06010 = 0.0F;
      this.field06012 = 0.0F;
      this.field06013 = 0.0F;
   }

   RotationDerivativeHistory.Nested68 method02507(float var1, float var2, float var3, float var4) {
      float var5 = this.field06008 ? Mth.wrapDegrees(var1 - this.field06006) : 0.0F;
      float var6 = this.field06008 ? var2 - this.field06007 : 0.0F;
      float var7 = this.field06011 ? var5 - this.field06009 : 0.0F;
      float var8 = this.field06011 ? var6 - this.field06010 : 0.0F;
      float var9 = this.field06014 ? var7 - this.field06012 : 0.0F;
      float var10 = this.field06014 ? var8 - this.field06013 : 0.0F;
      float var11 = this.field06017 ? Mth.wrapDegrees(var3 - this.field06015) : 0.0F;
      float var12 = this.field06017 ? var4 - this.field06016 : 0.0F;
      return new RotationDerivativeHistory.Nested68(var5, var6, var7, var8, var9, var10, var11, var12);
   }

   void method02508(RotationDerivativeHistory.Nested68 var1, float var2, float var3, float var4, float var5) {
      if (this.field06011) {
         this.field06014 = true;
      }

      if (this.field06008) {
         this.field06011 = true;
      }

      this.field06009 = var1.velYaw();
      this.field06010 = var1.velPitch();
      this.field06012 = var1.accelYaw();
      this.field06013 = var1.accelPitch();
      this.field06006 = var2;
      this.field06007 = var3;
      this.field06008 = true;
      this.field06015 = var4;
      this.field06016 = var5;
      this.field06017 = true;
   }

   // $VF: Compiled from s
   record Nested68(float velYaw, float velPitch, float accelYaw, float accelPitch, float jerkYaw, float jerkPitch, float errVelYaw, float errVelPitch) {
   }
}
