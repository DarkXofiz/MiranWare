// Original binary: sg/ec/VaQ2ayVZJImuGySY
package sg.ec;

import net.minecraft.client.Camera;
import sg.mx.CameraMixin_1260;

// $VF: Compiled from s
public class CameraRotationEvent extends Event {
   public static final CameraRotationEvent field12724 = new CameraRotationEvent();
   private float field12725;
   private float field12726;
   private float field12727;

   public void method05949(float var1) {
      this.field12727 = var1;
   }

   public float method05950() {
      return this.field12725;
   }

   public void method05951(float var1) {
      this.field12726 = var1;
   }

   public void method05952(float var1) {
      this.field12725 = var1;
   }

   public float method05953() {
      return this.field12727;
   }

   public void method05954(Camera var1, float var2, float var3, float var4) {
      if (!this.method05698()) {
         ((CameraMixin_1260)(Object)var1).IsetRotation(var2, var3);
      } else {
         this.field12725 = var2;
         this.field12726 = var3;
         this.field12727 = var4;
         this.method05695(false);
         super.method03208();
         this.method05694();
         ((CameraMixin_1260)(Object)var1).IsetRotation(this.field12725, this.field12726);
      }
   }

   public float method05955() {
      return this.field12726;
   }
}
