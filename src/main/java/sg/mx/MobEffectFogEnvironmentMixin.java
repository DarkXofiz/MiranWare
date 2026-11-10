// Original binary: sg/mx/R9YYkqp4AI3catGY
package sg.mx;

import net.minecraft.client.renderer.fog.environment.MobEffectFogEnvironment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.MobEffectFogEnvironmentHooks;

// $VF: Compiled from s
@Mixin(MobEffectFogEnvironment.class)
public class MobEffectFogEnvironmentMixin {
   @Inject(method = "isApplicable", at = @At("HEAD"), cancellable = true)
   private void hexNoBlindness(FogType var1, Entity var2, CallbackInfoReturnable<Boolean> var3) {
      MobEffectFogEnvironmentHooks.method07503(var3);
   }
}
