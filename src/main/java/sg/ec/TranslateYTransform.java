// Original binary: sg/ec/fIDSziwRdNGWZ2WQ
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;

// $VF: Compiled from s
public class TranslateYTransform extends ItemTransform implements PoseTransform {
   float field18900;

   @Override
   public void method00356(PoseStack var1) {
      var1.translate(0.0F, this.field18900, 0.0F);
   }

   public TranslateYTransform(float var1) {
      this.field18900 = var1;
   }
}
