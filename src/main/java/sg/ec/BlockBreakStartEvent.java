// Original binary: sg/ec/fn13xT45NexIZOu3
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

// $VF: Compiled from s
public class BlockBreakStartEvent extends Event {
   public static final BlockBreakStartEvent field19164 = new BlockBreakStartEvent();
   private BlockPos field19165;
   private Direction field19166;

   public void method08304(BlockPos var1, Direction var2) {
      this.field19165 = var1;
      this.field19166 = var2;
      super.method03208();
   }

   public BlockPos method08305() {
      return this.field19165;
   }

   public Direction method08306() {
      return this.field19166;
   }
}
