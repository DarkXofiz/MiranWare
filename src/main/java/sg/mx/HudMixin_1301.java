// Original binary: sg/mx/rUTmdwKIhFy5FTuZ
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import net.minecraft.client.gui.Hud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.HudBlitRenderer;

// $VF: Compiled from s
@Mixin(Hud.class)
public class HudMixin_1301 {
   @ModifyExpressionValue(
      method = "extractConfusionOverlay",
      at = @At(
         value = "FIELD",
         target = "Lnet/minecraft/client/renderer/RenderPipelines;GUI_NAUSEA_OVERLAY:Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;",
         opcode = 178
      )
   )
   private RenderPipeline hex$fboSafeNausea(RenderPipeline var1) {
      return HudBlitRenderer.method10067();
   }
}
