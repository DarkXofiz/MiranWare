// Original binary: sg/ec/CcE1d103npy82mpp
package sg.ec;

import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class EntityOutlineRenderHook {
   private static final String field06826 = "entity_outline";

   public static void method03000(Identifier var0, CallbackInfoReturnable<PostChain> var1) {
      if (var0 != null && field06826.equals(var0.getPath())) {
         EntityESP var2 = ModuleManager.INSTANCE.method08235();
         if (var2 != null && var2.method09222()) {
            var1.setReturnValue(null);
         }
      }
   }

   private EntityOutlineRenderHook() {
   }
}
