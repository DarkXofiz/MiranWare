// Original binary: sg/mx/nVmmt7MjunwmEnw2
package sg.mx;

import hex.api.baritone.utils.accessor.IEntityRenderManager;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import org.spongepowered.asm.mixin.Mixin;

// $VF: Compiled from s
@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin implements IEntityRenderManager {
   @Override
   public double renderPosX() {
      return ((EntityRenderDispatcher)(Object)this).camera.position().x;
   }

   @Override
   public double renderPosY() {
      return ((EntityRenderDispatcher)(Object)this).camera.position().y;
   }

   @Override
   public double renderPosZ() {
      return ((EntityRenderDispatcher)(Object)this).camera.position().z;
   }
}
