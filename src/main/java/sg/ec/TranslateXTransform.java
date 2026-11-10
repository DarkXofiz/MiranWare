// Original binary: sg/ec/IgGEYLXjz9pTkm9A
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;

// $VF: Compiled from s
public class TranslateXTransform extends ItemTransform implements PoseTransform {
   float field08756;

   public TranslateXTransform(float var1) {
      this.field08756 = var1;
   }

   @Override
   public void method00356(PoseStack var1) {
      var1.translate(this.field08756, 0.0F, 0.0F);
   }
}
