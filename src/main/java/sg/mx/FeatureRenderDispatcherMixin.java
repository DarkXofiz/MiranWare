// Original binary: sg/mx/66mN3pTGXaou1xZV
package sg.mx;

import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher.PreparedFrame;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.FeatureRenderDispatcherHooks;

// $VF: Compiled from s
@Mixin(FeatureRenderDispatcher.class)
public abstract class FeatureRenderDispatcherMixin {
   @Inject(
      method = "renderAllFeatures",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/feature/FeatureRenderDispatcher$PreparedFrame;executeAlwaysOnTop(Lcom/mojang/renderpearl/api/commands/RenderPass;)V",
         shift = Shift.AFTER
      )
   )
   private static void hexHandOutline(com.mojang.renderpearl.api.commands.RenderPass var0, PreparedFrame var1, CallbackInfo var2) {
      if (sg.ec.HandGlowRenderer.method01229() || sg.ec.HandGlowRenderer.method01242() != 0) {
         var0.close();
      }

      FeatureRenderDispatcherHooks.method10880(var1);
   }
}
