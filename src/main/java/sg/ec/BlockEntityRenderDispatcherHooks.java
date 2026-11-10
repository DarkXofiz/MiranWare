// Original binary: sg/ec/ZTZZ6SHKeBltDBwr
package sg.ec;

import java.util.Map;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;

// $VF: Compiled from s
public final class BlockEntityRenderDispatcherHooks {
   public static Object method06872(Map<Object, Object> var0, Object var1) {
      BlockEntityRendererCacheAccess var2 = (BlockEntityRendererCacheAccess)var1;
      if (var2.hex$rendererOwner() == var0) {
         return var2.hex$renderer();
      }

      BlockEntityRenderer sx = (BlockEntityRenderer<?, ?>)var0.get(var1);
      var2.hex$renderer(var0, sx);
      return sx;
   }

   private BlockEntityRenderDispatcherHooks() {
   }
}
