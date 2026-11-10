// Original binary: sg/mx/E0gd0DVGObOoUIR9
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.extract.LevelExtractor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.EntityVisibilityEvent;
import sg.ec.RotationRenderHooks;
import sg.ec.LevelExtractorHooks;

// $VF: Compiled from s
@Mixin(LevelExtractor.class)
public abstract class LevelExtractorMixin_1150 {
   @ModifyExpressionValue(method = "extractVisibleEntities", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;isDetached()Z", ordinal = 0))
   private boolean modifyThirdPersonCheck(boolean var1) {
      return LevelExtractorHooks.method10293(var1);
   }

   @ModifyExpressionValue(
      method = "isEntityVisible",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/entity/EntityRenderDispatcher;shouldRender(Lnet/minecraft/world/entity/Entity;Lnet/minecraft/client/renderer/culling/Frustum;DDDF)Z"
      )
   )
   private boolean onGetEntityToRender(boolean var1, @Local(argsOnly = true) Entity var2) {
      return EntityVisibilityEvent.field12028.method05671(var2, var1);
   }

   @ModifyExpressionValue(
      method = "extractBlockOutline",
      at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;hitResult:Lnet/minecraft/world/phys/HitResult;")
   )
   private HitResult onBlockOutlineHit(HitResult var1) {
      return RotationRenderHooks.method05683(var1);
   }

   @ModifyExpressionValue(
      method = "extractPlayerState",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getEffectBlendFactor(Lnet/minecraft/core/Holder;F)F")
   )
   private float hexNausea(float var1) {
      return sg.ec.NauseaStrengthEvent.field10218.method04657(var1);
   }
}
