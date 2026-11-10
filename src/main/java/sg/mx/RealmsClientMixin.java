// Original binary: sg/mx/0uPA6Px06R9xJ5LG
package sg.mx;

import com.mojang.realmsclient.client.RealmsClient;
import com.mojang.realmsclient.client.Request;
import com.mojang.realmsclient.client.RealmsError.CustomError;
import com.mojang.realmsclient.exception.RealmsServiceException;
import java.util.Set;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
@Mixin(RealmsClient.class)
public class RealmsClientMixin {
   @Inject(method = "fetchFeatureFlags", at = @At("HEAD"), cancellable = true)
   private void hex$noFeatureFlags(CallbackInfoReturnable<Set<String>> var1) {
      var1.setReturnValue(Set.of());
   }

   @Inject(method = "execute", at = @At("HEAD"))
   private void hex$noRequests(Request<?> var1, CallbackInfoReturnable<String> var2) throws RealmsServiceException {
      throw new RealmsServiceException(CustomError.noPayload(503));
   }
}
