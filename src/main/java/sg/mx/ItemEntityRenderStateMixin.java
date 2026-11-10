// Original binary: sg/mx/UMcTQPTkU8p17rGA
package sg.mx;

import net.minecraft.client.renderer.entity.state.ItemEntityRenderState;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.ItemEntityPhysicsAccess;
import sg.ec.ItemEntityRenderStateHooks;

// $VF: Compiled from s
@Mixin(ItemEntityRenderState.class)
public class ItemEntityRenderStateMixin implements ItemEntityPhysicsAccess {
   @Unique
   private ItemEntityRenderStateHooks hex$physics;

   @Unique
   private ItemEntityRenderStateHooks hex$physics() {
      ItemEntityRenderStateHooks var1 = this.hex$physics;
      if (var1 == null) {
         var1 = new ItemEntityRenderStateHooks();
         this.hex$physics = var1;
      }

      return var1;
   }

   @Override
   public float getXRot() {
      return this.hex$physics().method11184();
   }

   @Override
   public float getYRot() {
      return this.hex$physics().method11186();
   }

   @Override
   public boolean skipRendering() {
      return this.hex$physics().method11185();
   }

   @Override
   public boolean hasAdditionalOffset() {
      return this.hex$physics().method11187();
   }

   @Override
   public boolean isBlock() {
      return this.hex$physics().method11189();
   }

   @Override
   public void extractPhysic(ItemEntity var1) {
      this.hex$physics().method11188((ItemEntityRenderState)(Object)this, var1);
   }
}
