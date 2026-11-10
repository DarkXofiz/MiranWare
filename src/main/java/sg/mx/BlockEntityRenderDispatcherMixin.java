// Original binary: sg/mx/l8U3FA9jLgAEBr6e
package sg.mx;

import java.util.Map;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.BlockEntityRenderDispatcherHooks;

// $VF: Compiled from s
@Mixin(BlockEntityRenderDispatcher.class)
public class BlockEntityRenderDispatcherMixin {
   @Redirect(
      method = {
            "getRenderer(Lnet/minecraft/world/level/block/entity/BlockEntity;)Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;",
            "getRenderer(Lnet/minecraft/client/renderer/blockentity/state/BlockEntityRenderState;)Lnet/minecraft/client/renderer/blockentity/BlockEntityRenderer;"
      },
      at = @At(value = "INVOKE", target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;")
   )
   private Object hex$cachedRenderer(Map<Object, Object> var1, Object var2) {
      return BlockEntityRenderDispatcherHooks.method06872(var1, var2);
   }
}
