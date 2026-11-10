// Original binary: sg/mx/d8y4TY5BRFat3a21
package sg.mx;

import java.util.List;
import net.minecraft.client.renderer.feature.FeatureFrameContext;
import net.minecraft.client.renderer.feature.RenderTypeFeatureRenderer;
import net.minecraft.client.renderer.feature.submit.SubmitNode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ReorderableRenderState;

// $VF: Compiled from s
@Mixin(RenderTypeFeatureRenderer.class)
public class RenderTypeFeatureRendererMixin implements ReorderableRenderState {
   @Unique
   private boolean hex$canReorder;

   @Inject(method = "prepareGroup", at = @At("HEAD"))
   private void hex$captureOrdering(FeatureFrameContext var1, List<? extends SubmitNode> var2, boolean var3, CallbackInfo var4) {
      this.hex$canReorder = !var3;
   }

   @Override
   public boolean hexCanReorder() {
      return this.hex$canReorder;
   }
}
