// Original binary: sg/ec/BwEASMBeyq03kEmO
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class PackedColorHook {
   public static void method02835(int var0, CallbackInfoReturnable<Integer> var1) {
      if (var0 != 0) {
         var1.setReturnValue(var0);
      }
   }

   private PackedColorHook() {
   }
}
