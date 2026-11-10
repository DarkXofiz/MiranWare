// Original binary: sg/mx/M1GCOgeoYaj8TzM6
package sg.mx;

import net.minecraft.client.ClientClockManager;
import net.minecraft.core.Holder;
import net.minecraft.world.clock.WorldClock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ClientClockManagerHooks;

// $VF: Compiled from s
@Mixin(ClientClockManager.class)
public class ClientClockManagerMixin {
   @Inject(method = "getTotalTicks", at = @At("HEAD"), cancellable = true)
   private void getTotalTicks(Holder<WorldClock> var1, CallbackInfoReturnable<Long> var2) {
      ClientClockManagerHooks.method08335(var1, var2);
   }
}
