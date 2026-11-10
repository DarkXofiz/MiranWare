// Original binary: sg/mx/sUUJsql1bDsY9bvS
package sg.mx;

import java.util.Set;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.client.renderer.ShaderManager;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.EntityOutlineRenderHook;

// $VF: Compiled from s
@Mixin(ShaderManager.class)
public class ShaderManagerMixin {
   @Inject(method = "getPostChain", at = @At("HEAD"), cancellable = true)
   private void hexSwapGlowChain(Identifier var1, Set<Identifier> var2, CallbackInfoReturnable<PostChain> var3) {
      EntityOutlineRenderHook.method03000(var1, var3);
   }
}
