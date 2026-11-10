// Original binary: sg/mx/O3di2GQcCzoFqgn4
package sg.mx;

import com.mojang.blaze3d.platform.FramerateLimitTracker;
import com.mojang.blaze3d.platform.FramerateLimitTracker.FramerateThrottleReason;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ClientScreenManager;
import sg.ec.AutoBuyManager;

// $VF: Compiled from s
@Mixin(FramerateLimitTracker.class)
public class FramerateLimitTrackerMixin {
   @Inject(method = "getThrottleReason", at = @At("RETURN"), cancellable = true)
   private void hex$unthrottle(CallbackInfoReturnable<FramerateThrottleReason> var1) {
      if (this.hex$needsFullRate((FramerateThrottleReason)var1.getReturnValue())) {
         var1.setReturnValue(FramerateThrottleReason.NONE);
      }
   }

   @Unique
   private boolean hex$needsFullRate(FramerateThrottleReason var1) {
      return switch (var1) {
         case OUT_OF_LEVEL_MENU -> ClientScreenManager.INSTANCE.method08318();
         case WINDOW_ICONIFIED, SHORT_AFK, LONG_AFK -> AutoBuyManager.INSTANCE.method09759();
         case NONE -> false;
      };
   }
}
