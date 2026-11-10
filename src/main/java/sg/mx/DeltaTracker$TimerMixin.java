// Original binary: sg/mx/vy5Ws0VJVyPWtECr
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.DeltaTracker.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.TimerSpeedEvent;

// $VF: Compiled from s
@Mixin(Timer.class)
public class DeltaTracker$TimerMixin {
   @ModifyExpressionValue(method = "advanceGameTime", at = @At(value = "INVOKE", target = "Lit/unimi/dsi/fastutil/floats/FloatUnaryOperator;apply(F)F"))
   private float modifyTimerSpeed(float var1) {
      return TimerSpeedEvent.field03562.method01449((Timer)(Object)this, var1);
   }
}
