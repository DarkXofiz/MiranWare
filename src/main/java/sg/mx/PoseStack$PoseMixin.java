// Original binary: sg/mx/7wm5jAGSHtGph4TV
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack.Pose;
import org.joml.Matrix3f;
import org.joml.Matrix4fc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// $VF: Compiled from s
@Mixin(Pose.class)
public class PoseStack$PoseMixin {
   @Unique
   private Matrix3f hex$normalScratch;

   @Redirect(method = "mulPose(Lorg/joml/Matrix4fc;)V", at = @At(value = "NEW", target = "(Lorg/joml/Matrix4fc;)Lorg/joml/Matrix3f;"))
   private Matrix3f hex$reuseNormalScratch(Matrix4fc var1) {
      Matrix3f var2 = this.hex$normalScratch;
      if (var2 == null) {
         var2 = new Matrix3f();
         this.hex$normalScratch = var2;
      }

      return var2.set(var1);
   }
}
