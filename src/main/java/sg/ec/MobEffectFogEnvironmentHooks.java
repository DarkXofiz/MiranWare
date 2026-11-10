// Original binary: sg/ec/dkfRjWAtIWyYmxqa
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class MobEffectFogEnvironmentHooks {
   public static void method07503(CallbackInfoReturnable<Boolean> var0) {
      if (NightVisionEvent.field19990.method08765()) {
         var0.setReturnValue(false);
      }
   }

   private MobEffectFogEnvironmentHooks() {
   }
}
