// Original binary: sg/mx/1jLZZ0xgU7EAldlO
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.CameraRotationEvent;
import sg.ec.CameraAspectRatioHooks;
import sg.ec.VisualRemovalEvent;
import sg.ec.CameraPositionHooks;

// $VF: Compiled from s
@Mixin(Camera.class)
public class CameraMixin {
   @Redirect(method = "alignWithEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;setRotation(FF)V", ordinal = 1))
   public void update(Camera var1, float var2, float var3, @Local(ordinal = 0, argsOnly = true) float var4) {
      CameraRotationEvent.field12724.method05954(var1, var2, var3, var4);
   }

   @Redirect(method = "alignWithEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;setPosition(DDD)V"))
   private void modifyCameraPosition(Camera var1, double var2, double var4, double var6) {
      CameraPositionHooks.method11613(var1, var2, var4, var6);
   }

   @ModifyExpressionValue(method = "extractRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isSpectator()Z"))
   private boolean cullAsSpectator(boolean var1) {
      return CameraPositionHooks.method11612(var1);
   }

   @ModifyExpressionValue(
      method = "update(Lnet/minecraft/client/DeltaTracker;)V",
      at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getWidth()I")
   )
   private int modifyProjectionWidth(int var1) {
      return CameraAspectRatioHooks.method08591(var1);
   }

   @ModifyExpressionValue(method = "createProjectionMatrixForCulling", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/Window;getWidth()I"))
   private int modifyCullingWidth(int var1) {
      return CameraAspectRatioHooks.method08592(var1);
   }

   @Inject(method = "getMaxZoom", at = @At("HEAD"), cancellable = true)
   private void clipToSpace(float var1, CallbackInfoReturnable<Float> var2) {
      VisualRemovalEvent.field19883.method08698(VisualRemovalEvent.Nested242.F5_XUETA, var2, var1);
   }
}
