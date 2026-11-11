// Original binary: sg/mx/WJQLsX9HdwcrrLhB
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.renderer.state.gui.GlyphRenderState;
import org.joml.Matrix3x2fc;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.GuiMatrixCache;

// $VF: Compiled from s
@Mixin(GlyphRenderState.class)
public class GlyphRenderStateMixin {
   @WrapOperation(method = "buildVertices", at = @At(value = "NEW", target = "org/joml/Matrix4f"))
   private Matrix4f hex$scratchMatrix(Operation<Matrix4f> hex$original) {
      return GuiMatrixCache.method00248();
   }

   @WrapOperation(method = "buildVertices", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;mul(Lorg/joml/Matrix3x2fc;)Lorg/joml/Matrix4f;"))
   private Matrix4f hex$reusePose(Matrix4f var1, Matrix3x2fc var2, Operation<Matrix4f> hex$original) {
      return GuiMatrixCache.method00247(var1, var2);
   }
}
