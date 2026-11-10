// Original binary: sg/mx/V8KYqH1GE2Xsa9eW
package sg.mx;

import com.mojang.realmsclient.RealmsAvailability;
import com.mojang.realmsclient.RealmsAvailability.Result;
import com.mojang.realmsclient.RealmsAvailability.Type;
import java.util.concurrent.CompletableFuture;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
@Mixin(RealmsAvailability.class)
public class RealmsAvailabilityMixin {
   @Inject(method = "get", at = @At("HEAD"), cancellable = true)
   private static void hex$unavailable(CallbackInfoReturnable<CompletableFuture<Result>> var0) {
      var0.setReturnValue(CompletableFuture.completedFuture(new Result(Type.INCOMPATIBLE_CLIENT)));
   }
}
