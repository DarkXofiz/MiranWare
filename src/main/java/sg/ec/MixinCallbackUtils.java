// Original binary: sg/ec/nn8yMhbas02FM2Mk
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class MixinCallbackUtils {
   public static Object[] method09737(Object var0, Object[] var1, Object var2) {
      return var1 != null && var1[0] == var0 ? var1 : new Object[]{var0, var2};
   }

   private MixinCallbackUtils() {
   }

   public static <R> void method09738(Object var0, Object[] var1, CallbackInfoReturnable<R> var2) {
      if (var1 != null && var1[0] == var0) {
         var2.setReturnValue((R) var1[1]);
      }
   }
}
