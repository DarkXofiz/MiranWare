// Original binary: hex/api/baritone/pathing/movement/movements/MovementDownward
package hex.api.baritone.pathing.movement.movements;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.MovementState;
import java.util.Set;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class MovementDownward extends Movement {
   private int numTicks = 0;
   private static final double _ю = 0;
   private static final double _4 = 0;
   private static final double _С = 0;
   private static final double _ъ = 0;
   private static final double _Б = 0;
   private static final double _в = 0;


   public MovementDownward(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3) {
      super(var1, var2, var3, new BetterBlockPos[]{var3});
   }

   public static double cost(CalculationContext var0, int var1, int var2, int var3) {
      if (!var0.allowDownward) {
         return _ю;
      }

      if (!MovementHelper.canWalkOn(var0, var1, var2 - 2, var3)) {
         return _4;
      }

      BlockState var4 = var0.get(var1, var2 - 1, var3);
      Block sx = var4.getBlock();
      return sx != Blocks.LADDER && sx != Blocks.VINE
         ? FALL_N_BLOCKS_COST[1] + MovementHelper.getMiningDurationTicks(var0, var1, var2 - 1, var3, var4, false)
         : _С;
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      return ImmutableSet.of(this.src, this.dest);
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      return cost(var1, this.src.x, this.src.y, this.src.z);
   }

   @Override
   public void reset() {
      super.reset();
      this.numTicks = 0;
   }

   @Override
   public MovementState updateState(MovementState var1) {
      super.updateState(var1);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         return var1;
      }

      if (this.ctx.playerFeet().equals(this.dest)) {
         return var1.setStatus(MovementStatus.SUCCESS);
      }

      if (!this.playerInValidPosition()) {
         return var1.setStatus(MovementStatus.UNREACHABLE);
      }

      double var2 = this.ctx.player().position().x - (this.dest.getX() + _ъ);
      double sx = this.ctx.player().position().z - (this.dest.getZ() + _Б);
      double sxx = Math.sqrt(var2 * var2 + sx * sx);
      if (this.numTicks++ < 10 && sxx < _в) {
         return var1;
      }

      MovementHelper.moveTowards(this.ctx, var1, this.positionsToBreak[0]);
      return var1;
   }
}
