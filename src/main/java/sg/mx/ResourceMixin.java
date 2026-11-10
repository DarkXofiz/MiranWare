// Original binary: sg/mx/R7UsAe67VawsJxDd
package sg.mx;

import java.io.IOException;
import java.io.InputStream;
import net.minecraft.server.packs.resources.Resource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.EncryptedTextureUtils;

// $VF: Compiled from s
@Mixin(Resource.class)
public abstract class ResourceMixin {
   @Inject(method = "open", at = @At("RETURN"), cancellable = true)
   private void decryptResource(CallbackInfoReturnable<InputStream> var1) throws IOException {
      var1.setReturnValue(EncryptedTextureUtils.method08943((InputStream)var1.getReturnValue()));
   }
}
