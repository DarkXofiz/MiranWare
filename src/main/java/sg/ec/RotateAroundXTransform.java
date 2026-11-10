// Original binary: sg/ec/78ZRKAVvSkXecSke
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

// $VF: Compiled from s
public class RotateAroundXTransform extends ItemTransform implements PoseTransform {
   private float field03949;
   private float field03950;
   private float field03951;
   private float field03952;

   @Override
   public void method00356(PoseStack var1) {
      var1.rotateAround(Axis.XP.rotationDegrees(this.field03952), this.field03949, this.field03950, this.field03951);
   }

   public RotateAroundXTransform(float var1, float var2, float var3, float var4) {
      this.field03952 = var1;
      this.field03949 = var2;
      this.field03950 = var3;
      this.field03951 = var4;
   }
}
