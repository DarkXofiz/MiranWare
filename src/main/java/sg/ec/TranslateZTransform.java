// Original binary: sg/ec/wCHsTJPoSZHEekYu
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;

// $VF: Compiled from s
public class TranslateZTransform extends ItemTransform implements PoseTransform {
   float field25149;

   public TranslateZTransform(float var1) {
      this.field25149 = var1;
   }

   @Override
   public void method00356(PoseStack var1) {
      var1.translate(0.0F, 0.0F, this.field25149);
   }
}
