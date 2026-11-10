// Original binary: sg/mx/rz9NwUKbJ9WdoHLh
package sg.mx;

import com.mojang.realmsclient.util.RealmsPersistence;
import com.mojang.realmsclient.util.RealmsPersistence.RealmsPersistenceData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
@Mixin(RealmsPersistence.class)
public class RealmsPersistenceMixin {
   @Inject(method = "readFile", at = @At("HEAD"), cancellable = true)
   private static void hex$noRead(CallbackInfoReturnable<RealmsPersistenceData> var0) {
      var0.setReturnValue(new RealmsPersistenceData());
   }

   @Inject(method = "writeFile", at = @At("HEAD"), cancellable = true)
   private static void hex$noWrite(RealmsPersistenceData var0, CallbackInfo var1) {
      var1.cancel();
   }
}
