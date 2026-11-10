// Original binary: sg/ec/bp8sd2IDf5EZM71C
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

// $VF: Compiled from s
public class RotateAroundZTransform extends ItemTransform implements PoseTransform {
   private float field17454;
   private float field17455;
   private float field17456;
   private float field17457;

   public RotateAroundZTransform(float var1, float var2, float var3, float var4) {
      this.field17457 = var1;
      this.field17454 = var2;
      this.field17455 = var3;
      this.field17456 = var4;
   }

   @Override
   public void method00356(PoseStack var1) {
      var1.rotateAround(Axis.ZP.rotationDegrees(this.field17457), this.field17454, this.field17455, this.field17456);
   }
}
