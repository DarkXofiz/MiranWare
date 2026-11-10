// Original binary: sg/mx/G4BoXFDUPhFkQNwf
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.Camera;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.client.renderer.fog.FogRenderer;
import net.minecraft.world.level.material.FogType;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.FogColorEvent;
import sg.ec.FogRenderHooks;

// $VF: Compiled from s
@Mixin(FogRenderer.class)
public class FogRendererMixin {
   @ModifyExpressionValue(
      method = "getFogType",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Camera;getFluidInCamera()Lnet/minecraft/world/level/material/FogType;")
   )
   private FogType getFogType(FogType var1) {
      return FogRenderHooks.method03189(var1);
   }

   @ModifyExpressionValue(method = "computeFogColor", at = @At(value = "INVOKE", target = "Lorg/joml/Vector4f;set(FFFF)Lorg/joml/Vector4f;"))
   private Vector4f computeFogColor(Vector4f var1, @Local(argsOnly = true, name = "camera") Camera var2) {
      return FogColorEvent.field01083.method00580(var2, var1);
   }

   @ModifyExpressionValue(
      method = "computeFogColor",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GameRenderer;nightVisionScale(Lnet/minecraft/world/entity/LivingEntity;F)F")
   )
   private float nightVisionFogScale(float var1) {
      return FogRenderHooks.method03190(var1);
   }

   @Inject(
      method = "setupFog",
      at = @At(value = "FIELD", target = "Lnet/minecraft/client/renderer/fog/FogData;renderDistanceEnd:F", opcode = 181, shift = Shift.AFTER)
   )
   private void setupFog(Camera var1, int var2, DeltaTracker var3, float var4, ClientLevel var5, CallbackInfoReturnable<FogData> var6, @Local FogData var7) {
      FogColorEvent.field01083.method00579(var1, var7.color, var7);
   }
}
