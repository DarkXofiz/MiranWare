// Original binary: sg/ec/EtN0QuCf1b1aNcmG
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

// $VF: Compiled from s
public class RotateAroundYTransform extends ItemTransform implements PoseTransform {
   private float field07222;
   private float field07223;
   private float field07224;
   private float field07225;

   public RotateAroundYTransform(float var1, float var2, float var3, float var4) {
      this.field07225 = var1;
      this.field07222 = var2;
      this.field07223 = var3;
      this.field07224 = var4;
   }

   @Override
   public void method00356(PoseStack var1) {
      var1.rotateAround(Axis.YP.rotationDegrees(this.field07225), this.field07222, this.field07223, this.field07224);
   }
}
