// Original binary: sg/ec/YkVktXBTFGmsVUId
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class BlockUpdateEvent extends Event {
   public static final BlockUpdateEvent field14952 = new BlockUpdateEvent();
   private BlockPos field14953;
   private BlockState field14954;

   public BlockPos method06654() {
      return this.field14953;
   }

   public void method06655(BlockPos var1, BlockState var2) {
      this.field14953 = var1;
      this.field14954 = var2;
      super.method03208();
   }

   public void method06656(BlockPos var1) {
      this.field14953 = var1;
   }

   public void method06657(BlockState var1) {
      this.field14954 = var1;
   }

   public BlockState method06658() {
      return this.field14954;
   }
}
