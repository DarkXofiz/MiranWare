// Original binary: sg/mx/EvtGVVnNcuBymjOc
package sg.mx;

import com.mojang.renderpearl.frontend.FrontendCommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.commands.RenderPassDescriptor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.GuiGpuRenderer;

// $VF: Compiled from s
@Mixin(FrontendCommandEncoder.class)
public class CommandEncoderMixin {
   @Inject(method = "createRenderPass(Lcom/mojang/renderpearl/api/commands/RenderPassDescriptor;)Lcom/mojang/renderpearl/api/commands/RenderPass;", at = @At("HEAD"))
   private void hex$closeMergedPassBeforeForeign(RenderPassDescriptor var1, CallbackInfoReturnable<RenderPass> var2) {
      GuiGpuRenderer.method00368();
   }
}
