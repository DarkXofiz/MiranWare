// Original binary: sg/mx/IQ6Q6NpirhAAuEMl
package sg.mx;

import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.ChestPairCacheAccess;

// $VF: Compiled from s
@Mixin(ChestBlockEntity.class)
public class ChestBlockEntityMixin implements ChestPairCacheAccess {
   @Unique
   private int hex$chestPairStamp;
   @Unique
   private BlockState hex$chestPairState;
   @Unique
   private ChestBlockEntity hex$chestPairFirst;
   @Unique
   private ChestBlockEntity hex$chestPairSecond;

   @Override
   public int hex$pairStamp() {
      return this.hex$chestPairStamp;
   }

   @Override
   public BlockState hex$pairState() {
      return this.hex$chestPairState;
   }

   @Override
   public ChestBlockEntity hex$pairFirst() {
      return this.hex$chestPairFirst;
   }

   @Override
   public ChestBlockEntity hex$pairSecond() {
      return this.hex$chestPairSecond;
   }

   @Override
   public void hex$pair(int var1, BlockState var2, ChestBlockEntity var3, ChestBlockEntity var4) {
      this.hex$chestPairStamp = var1;
      this.hex$chestPairState = var2;
      this.hex$chestPairFirst = var3;
      this.hex$chestPairSecond = var4;
   }
}
