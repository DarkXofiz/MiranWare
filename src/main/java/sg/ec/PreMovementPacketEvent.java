// Original binary: sg/ec/cqIoFCmwMaq9rT2e
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.mx.LocalPlayerMixin_1170;

// $VF: Compiled from s
public class PreMovementPacketEvent extends Event {
   public static final PreMovementPacketEvent field17844 = new PreMovementPacketEvent();
   private double field17845;
   private double field17846;
   private double field17847;
   private double field17848;
   private double field17849;
   private double field17850;
   private float field17851;
   private float field17852;
   private boolean field17853;
   private boolean field17854;

   public void method07295(double var1) {
      this.field17848 = var1;
   }

   public boolean method07296() {
      return this.field17853;
   }

   public void method07297(LocalPlayer var1, CallbackInfo var2) {
      this.field17854 = false;
      this.field17845 = var1.getX();
      this.field17846 = var1.getY();
      this.field17847 = var1.getZ();
      this.field17848 = ((LocalPlayerMixin_1170)(Object)var1).lastX();
      this.field17849 = ((LocalPlayerMixin_1170)(Object)var1).lastY();
      this.field17850 = ((LocalPlayerMixin_1170)(Object)var1).lastZ();
      this.field17851 = var1.getYRot();
      this.field17852 = var1.getXRot();
      this.field17853 = var1.onGround();
      super.method03208();
      if (this.method05694()) {
         var2.cancel();
      }
   }

   public double method07298() {
      return this.field17847;
   }

   public void method07299(float var1) {
      this.field17851 = var1;
   }

   public float method07300(float var1) {
      return this.field17854 ? this.field17852 : var1;
   }

   public float method07301() {
      return this.field17852;
   }

   public double method07302(double var1) {
      return this.field17854 ? this.field17846 : var1;
   }

   public void method07303(double var1) {
      this.field17847 = var1;
   }

   public float method07304(float var1) {
      return this.field17854 ? this.field17851 : var1;
   }

   public double method07305(double var1) {
      return this.field17854 ? this.field17845 : var1;
   }

   public double method07306() {
      return this.field17849;
   }

   public double method07307() {
      return this.field17846;
   }

   public void method07308(boolean var1) {
      this.field17853 = var1;
   }

   public void method07309(float var1) {
      this.field17852 = var1;
   }

   public float method07310() {
      return this.field17851;
   }

   public void method07311(double var1) {
      this.field17845 = var1;
   }

   public void method07312(double var1) {
      this.field17849 = var1;
   }

   public double method07313(double var1) {
      return this.field17854 ? this.field17847 : var1;
   }

   public void method07314(boolean var1) {
      this.field17854 = var1;
   }

   public double method07315() {
      return this.field17845;
   }

   public double method07316() {
      return this.field17850;
   }

   public void method07317(double var1) {
      this.field17846 = var1;
   }

   public boolean method07318() {
      return this.field17854;
   }

   public void method07319(double var1) {
      this.field17850 = var1;
   }

   public boolean method07320(boolean var1) {
      return this.field17853;
   }

   public double method07321() {
      return this.field17848;
   }
}
