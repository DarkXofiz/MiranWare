// Original binary: hex/api/baritone/pathing/precompute/PrecomputedData
package hex.api.baritone.pathing.precompute;

import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.utils.BlockStateInterface;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class PrecomputedData {
   private final byte[] data = new byte[Block.BLOCK_STATE_REGISTRY.size()];
   private static final byte COMPLETED_MASK = 1;
   private static final byte FULLY_PASSABLE_MAYBE_MASK = 2;
   private static final byte FULLY_PASSABLE_MASK = 4;
   private static final byte CAN_WALK_THROUGH_MAYBE_MASK = 8;
   private static final byte CAN_WALK_THROUGH_MASK = 16;
   private static final byte CAN_WALK_ON_MAYBE_MASK = 32;
   private static final byte CAN_WALK_ON_MASK = 64;

   public boolean canWalkThrough(BlockStateInterface var1, int var2, int var3, int var4, BlockState var5) {
      int var6 = Block.BLOCK_STATE_REGISTRY.getId(var5);
      int sx = this.data[var6];
      if ((sx & 1) == 0) {
         sx = this.fillData(var6, var5);
      }

      return (sx & 8) != 0 ? MovementHelper.canWalkThroughPosition(var1, var2, var3, var4, var5) : (sx & 16) != 0;
   }

   public boolean fullyPassable(BlockStateInterface var1, int var2, int var3, int var4, BlockState var5) {
      int var6 = Block.BLOCK_STATE_REGISTRY.getId(var5);
      int sx = this.data[var6];
      if ((sx & 1) == 0) {
         sx = this.fillData(var6, var5);
      }

      return (sx & 2) != 0 ? MovementHelper.fullyPassablePosition(var1, var2, var3, var4, var5) : (sx & 4) != 0;
   }

   private int fillData(int var1, BlockState var2) {
      byte var3 = 0;
      Ternary sx = MovementHelper.canWalkOnBlockState(var2);
      switch (sx) {
         case YES:
            var3 = (byte)(var3 | 64);
            break;
         case MAYBE:
            var3 = (byte)(var3 | 32);
      }

      Ternary var5 = MovementHelper.canWalkThroughBlockState(var2);
      switch (var5) {
         case YES:
            var3 = (byte)(var3 | 16);
            break;
         case MAYBE:
            var3 = (byte)(var3 | 8);
      }

      Ternary var6 = MovementHelper.fullyPassableBlockState(var2);
      switch (var6) {
         case YES:
            var3 = (byte)(var3 | 4);
            break;
         case MAYBE:
            var3 = (byte)(var3 | 2);
      }

      var3 = (byte)(var3 | 1);
      this.data[var1] = var3;
      return var3;
   }

   public boolean canWalkOn(BlockStateInterface var1, int var2, int var3, int var4, BlockState var5) {
      int var6 = Block.BLOCK_STATE_REGISTRY.getId(var5);
      int sx = this.data[var6];
      if ((sx & 1) == 0) {
         sx = this.fillData(var6, var5);
      }

      return (sx & 32) != 0 ? MovementHelper.canWalkOnPosition(var1, var2, var3, var4, var5) : (sx & 64) != 0;
   }
}
