// Original binary: sg/mx/ClyYJkXPeBu9EU2R
package sg.mx;

import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.PackedColorHook;

// $VF: Compiled from s
@Mixin({Style.class, TextColor.class})
public class StyleMixin {
   @Unique
   private int hex$hashCode;

   @Inject(method = "hashCode", at = @At("HEAD"), cancellable = true)
   private void hex$cachedHashCode(CallbackInfoReturnable<Integer> var1) {
      PackedColorHook.method02835(this.hex$hashCode, var1);
   }

   @Inject(method = "hashCode", at = @At("RETURN"))
   private void hex$storeHashCode(CallbackInfoReturnable<Integer> var1) {
      this.hex$hashCode = var1.getReturnValueI();
   }
}
