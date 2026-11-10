// Original binary: sg/mx/WJQLsX9HdwcrrLhB
package sg.mx;

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
   @Redirect(method = "buildVertices", at = @At(value = "NEW", target = "org/joml/Matrix4f"))
   private Matrix4f hex$scratchMatrix() {
      return GuiMatrixCache.method00248();
   }

   @Redirect(method = "buildVertices", at = @At(value = "INVOKE", target = "Lorg/joml/Matrix4f;mul(Lorg/joml/Matrix3x2fc;)Lorg/joml/Matrix4f;"))
   private Matrix4f hex$reusePose(Matrix4f var1, Matrix3x2fc var2) {
      return GuiMatrixCache.method00247(var1, var2);
   }
}
