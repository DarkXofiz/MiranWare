// Original binary: sg/mx/JSY2Eh1cf6QNOSYe
package sg.mx;

import com.mojang.renderpearl.api.commands.RenderPass;
import net.minecraft.client.gui.render.GuiRenderer;
import net.minecraft.client.gui.render.GuiRenderer.Draw;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.RenderPipelineCache;

// $VF: Compiled from s
@Mixin(GuiRenderer.class)
public class GuiRendererMixin_1173 {
   @Inject(method = "executeDraw", at = @At("HEAD"), cancellable = true)
   private void skipBrokenPipeline(Draw var1, RenderPass var2, CallbackInfo var3) {
      if (!RenderPipelineCache.method10799(var1.pipeline())) {
         var3.cancel();
      }
   }
}
