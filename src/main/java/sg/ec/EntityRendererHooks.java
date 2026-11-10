// Original binary: sg/ec/vqrQk9io38qlJA8j
package sg.ec;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public final class EntityRendererHooks {
   private EntityRendererHooks() {
   }

   public static Component method11153(Entity var0, Operation<Component> var1) {
      long var2 = var0.level().getGameTime() + 1L;
      EntityNameTagCacheAccess var4 = (EntityNameTagCacheAccess)var0;
      if (var4.hex$nameTagStamp() == var2) {
         return var4.hex$nameTag();
      } else {
         Component var5 = (Component)var1.call(new Object[]{var0});
         Component var6 = var4.hex$nameTag();
         if (var6 != null && var6.equals(var5)) {
            var4.hex$nameTag(var6, var2);
            return var6;
         } else {
            var4.hex$nameTag(var5, var2);
            return var5;
         }
      }
   }
}
