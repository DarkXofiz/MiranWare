// Original binary: sg/mx/FFTP6PZAm3FgbVxy
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.PreHandRenderEvent;
import sg.ec.PostHandRenderEvent;
import sg.ec.NauseaStrengthEvent;
import sg.ec.WorldVisualRenderer;
import sg.ec.HurtCameraHooks;
import sg.ec.WorldProjectionUtils;

// $VF: Compiled from s
@Mixin(GameRenderer.class)
public class GameRendererMixin_1156 {
   @Inject(method = "bobHurt", at = @At("HEAD"), cancellable = true)
   private void tiltViewWhenHurt(CameraRenderState var1, PoseStack var2, CallbackInfo var3) {
      HurtCameraHooks.method06046(var1, var3);
   }

   @Inject(method = "bobView", at = @At("HEAD"))
   private void captureBobView(CameraRenderState var1, PoseStack var2, CallbackInfo var3) {
      WorldProjectionUtils.method09453(var1);
   }

   @Inject(method = "renderItemInHand", at = @At("HEAD"), cancellable = true)
   private void preHand(
      net.minecraft.client.renderer.state.level.CameraRenderState var0,
      net.minecraft.client.renderer.state.level.PlayerRenderState var3,
      com.mojang.renderpearl.api.textures.GpuTextureView var4,
      CallbackInfo var2
   ) {
      PreHandRenderEvent.field06545.method02814(net.minecraft.client.Minecraft.getInstance().getDeltaTracker(), var2);
   }

   @Inject(method = "renderItemInHand", at = @At("RETURN"))
   private void postHand(
      net.minecraft.client.renderer.state.level.CameraRenderState var0,
      net.minecraft.client.renderer.state.level.PlayerRenderState var3,
      com.mojang.renderpearl.api.textures.GpuTextureView var4,
      CallbackInfo var2
   ) {
      PostHandRenderEvent.field07600.method03416(net.minecraft.client.Minecraft.getInstance().getDeltaTracker(), var2);
   }

   @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;blitEntityOutline()V", shift = Shift.AFTER))
   private void worldVisual(CallbackInfo var3) {
      WorldVisualRenderer.method04990();
   }
}
