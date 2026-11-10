// Original binary: sg/ec/fqQPnYu8pnqDto10
package sg.ec;

import net.minecraft.core.Holder;
import net.minecraft.world.clock.WorldClock;
import net.minecraft.world.clock.WorldClocks;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class ClientClockManagerHooks {
   public static void method08335(Holder<WorldClock> var0, CallbackInfoReturnable<Long> var1) {
      Ambience var2 = ModuleManager.INSTANCE.method08254();
      if (var2 != null && var2.method03937() && var0.is(WorldClocks.OVERWORLD)) {
         long sx = var2.method03244();
         if (sx >= 0L) {
            var1.setReturnValue(sx);
         }
      }
   }

   private ClientClockManagerHooks() {
   }
}
