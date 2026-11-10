// Original binary: sg/mx/5lL1REnjTuz2Ow01
package sg.mx;

import net.minecraft.world.level.block.entity.BlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.BlockEntityLightCacheAccess;

// $VF: Compiled from s
@Mixin(BlockEntity.class)
public class BlockEntityMixin implements BlockEntityLightCacheAccess {
   @Unique
   private int hex$stamp;
   @Unique
   private int hex$coords;

   @Override
   public int hex$lightStamp() {
      return this.hex$stamp;
   }

   @Override
   public int hex$lightCoords() {
      return this.hex$coords;
   }

   @Override
   public void hex$lightCoords(int var1, int var2) {
      this.hex$stamp = var1;
      this.hex$coords = var2;
   }
}
