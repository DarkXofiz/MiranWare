// Original binary: sg/ec/G0Gxzq0yw1WCsE9c
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;

// $VF: Compiled from s
public class ScaleItemTransform extends ItemTransform implements PoseTransform {
   float field07828;
   float field07829;
   float field07830;

   public ScaleItemTransform(float var1, float var2, float var3) {
      this.field07828 = var1;
      this.field07829 = var2;
      this.field07830 = var3;
   }

   @Override
   public void method00356(PoseStack var1) {
      var1.scale(this.field07828, this.field07829, this.field07830);
   }
}
