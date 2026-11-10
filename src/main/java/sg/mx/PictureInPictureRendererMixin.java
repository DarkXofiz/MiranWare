// Original binary: sg/mx/dcTgdOmozh0qia9O
package sg.mx;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import net.minecraft.client.gui.render.pip.PictureInPictureRenderer;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher;
import net.minecraft.client.renderer.state.gui.GuiRenderState;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.PictureInPictureRendererHooks;

// $VF: Compiled from s
@Mixin(PictureInPictureRenderer.class)
public abstract class PictureInPictureRendererMixin {
   @Shadow
   private GpuTextureView textureView;

   @ModifyArg(
      method = "blitTexture",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/state/gui/BlitRenderState;<init>(Lcom/mojang/renderpearl/api/pipeline/RenderPipeline;Lnet/minecraft/client/gui/render/TextureSetup;Lorg/joml/Matrix3x2fc;IIIIFFFFILnet/minecraft/client/gui/navigation/ScreenRectangle;Lnet/minecraft/client/gui/navigation/ScreenRectangle;)V"
      ),
      index = 11
   )
   private int hexApplyGuiEntityFade(int var1, @Local(argsOnly = true) PictureInPictureRenderState var2) {
      return PictureInPictureRendererHooks.method07561(var2, var1);
   }

   @Inject(
      method = "prepare",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/feature/FeatureRenderDispatcher;renderAllFeatures(Lcom/mojang/renderpearl/api/commands/RenderPass;Lnet/minecraft/client/renderer/feature/FeatureRenderDispatcher$PreparedFrame;)V",
         shift = Shift.AFTER
      )
   )
   private void hexBakePreviewGlow(PictureInPictureRenderState var1, GuiRenderState var2, FeatureRenderDispatcher var3, int var4, CallbackInfo var5) {
      PictureInPictureRendererHooks.method07564(var1, this.textureView, var4);
   }

   @Inject(method = "textureIsReadyToBlit", at = @At("HEAD"), cancellable = true)
   private void hexReusePreviewTexture(PictureInPictureRenderState var1, CallbackInfoReturnable<Boolean> var2) {
      PictureInPictureRendererHooks.method07559(var1, var2);
   }
}
