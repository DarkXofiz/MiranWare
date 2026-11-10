// Original binary: sg/mx/6XYw3Cq1bq8nGWEp
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import sg.ec.EntityRendererHooks;

// $VF: Compiled from s
@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
   @WrapMethod(method = "getNameTag(Lnet/minecraft/world/entity/Entity;)Lnet/minecraft/network/chat/Component;")
   private Component hex$cachedNameTag(Entity var1, Operation<Component> var2) {
      return EntityRendererHooks.method11153(var1, var2);
   }
}
