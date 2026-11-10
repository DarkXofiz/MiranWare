// Original binary: sg/mx/TE8CmUEWucG4SpOn
package sg.mx;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.gui.render.GuiRenderer;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.HudRenderTargetHooks;

// $VF: Compiled from s
@Mixin(value = GuiRenderer.class, priority = 900)
public class GuiRendererMixin_1217 {
   @Inject(method = "render", at = @At("HEAD"), cancellable = true)
   private void hex$throttleBegin(CallbackInfo var1) {
      HudRenderTargetHooks.method06930(var1);
   }

   @Inject(method = "render", at = @At("TAIL"))
   private void hex$throttleEnd(CallbackInfo var1) {
      HudRenderTargetHooks.method06929();
   }

   @Redirect(
      method = "draw",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;mainRenderTarget()Lcom/mojang/blaze3d/pipeline/RenderTarget;")
   )
   private RenderTarget hex$redirectTarget(GameRenderer var1) {
      return HudRenderTargetHooks.method06928(var1);
   }
}
