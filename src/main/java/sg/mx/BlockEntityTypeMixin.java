// Original binary: sg/mx/SX9Dl9fAhG2Gstm8
package sg.mx;

import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.BlockEntityRendererCacheAccess;

// $VF: Compiled from s
@Mixin(BlockEntityType.class)
public class BlockEntityTypeMixin implements BlockEntityRendererCacheAccess {
   @Unique
   private Object hex$owner;
   @Unique
   private BlockEntityRenderer<?, ?> hex$cached;

   @Override
   public Object hex$rendererOwner() {
      return this.hex$owner;
   }

   @Override
   public BlockEntityRenderer<?, ?> hex$renderer() {
      return this.hex$cached;
   }

   @Override
   public void hex$renderer(Object var1, BlockEntityRenderer<?, ?> var2) {
      this.hex$owner = var1;
      this.hex$cached = var2;
   }
}
