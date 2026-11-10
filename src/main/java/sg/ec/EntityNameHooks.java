// Original binary: sg/ec/mFWX93FkhucT7dOx
package sg.ec;

import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class EntityNameHooks {
   public static void method09469(Component var0, Object[] var1, CallbackInfoReturnable<Component> var2) {
      if (var0 != null) {
         MixinCallbackUtils.method09738(var0, var1, var2);
      }
   }

   public static Object[] method09470(Component var0, Object[] var1, Component var2) {
      return var0 == null ? var1 : MixinCallbackUtils.method09737(var0, var1, var2);
   }

   private EntityNameHooks() {
   }
}
