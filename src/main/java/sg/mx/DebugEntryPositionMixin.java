// Original binary: sg/mx/Ff2d79DIdB2sJoPp
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.components.debug.DebugEntryPosition;
import net.minecraft.core.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.RotationRenderHooks;

// $VF: Compiled from s
@Mixin(DebugEntryPosition.class)
public abstract class DebugEntryPositionMixin {
   @ModifyExpressionValue(
      method = "display",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getDirection()Lnet/minecraft/core/Direction;")
   )
   private Direction onFacingDirection(Direction var1) {
      return RotationRenderHooks.method05685(var1);
   }

   @ModifyExpressionValue(method = "display", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getYRot()F"))
   private float onFacingYaw(float var1) {
      return RotationRenderHooks.method05677(var1);
   }

   @ModifyExpressionValue(method = "display", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;getXRot()F"))
   private float onFacingPitch(float var1) {
      return RotationRenderHooks.method05674(var1);
   }
}
