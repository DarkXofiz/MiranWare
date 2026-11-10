// Original binary: sg/mx/AWTTFPxRZ15XNeg3
package sg.mx;

import net.minecraft.client.StringSplitter;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.StringSplitterHooks;

// $VF: Compiled from s
@Mixin(StringSplitter.class)
public class StringSplitterMixin {
   @Unique
   private StringSplitterHooks hex$cache;

   @Inject(method = "<init>", at = @At("RETURN"))
   private void hex$initCache(CallbackInfo var1) {
      this.hex$cache = new StringSplitterHooks();
   }

   @Inject(method = "stringWidth(Ljava/lang/String;)F", at = @At("HEAD"), cancellable = true)
   private void hex$widthLookup(String var1, CallbackInfoReturnable<Float> var2) {
      this.hex$cache.method04639(var1, var2);
   }

   @Inject(method = "stringWidth(Ljava/lang/String;)F", at = @At("RETURN"))
   private void hex$widthStore(String var1, CallbackInfoReturnable<Float> var2) {
      this.hex$cache.method04640(var1, var2.getReturnValueF());
   }
}
