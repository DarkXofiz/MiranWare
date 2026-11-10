// Original binary: hex/api/baritone/pathing/movement/movements/MovementAscend
package hex.api.baritone.pathing.movement.movements;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.MovementState;
import hex.api.baritone.utils.BlockStateInterface;
import java.util.Set;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class MovementAscend extends Movement {
   private static final double SIDE_DIST_TOLERANCE = 0.3;
   private static final double LATERAL_MOTION_TOLERANCE = 0.15;
   private int ticksWithoutPlacement = 0;
   private static final double Адк = 0;
   private static final double Адп = 0;
   private static final double Ад2 = 0;
   private static final double Ад西 = 0;
   private static final double Адт = 0;
   private static final double Адд = 0;
   private static final double Аде = 0;
   private static final double Ад6 = 0;
   private static final double Адl = 0;
   private static final double Ад必 = 0;
   private static final double АдЗ = 0;
   private static final double Адн = 0;
   private static final double АдД = 0;
   private static final double АдН = 0;
   private static final double Адш = 0;
   private static final double Адл = 0;
   private static final double Ади = 0;
   private static final double Адщ = 0;
   private static final double Аеб = 0;
   private static final double АеА = 0;
   private static final double Ае诶 = 0;
   private static final double АеЫ = 0;
   private static final double Аез = 0;

   @Override
   public double calculateCost(CalculationContext var1) {
      return cost(var1, this.src.x, this.src.y, this.src.z, this.dest.x, this.dest.z);
   }


   @Override
   public boolean safeToCancel(MovementState var1) {
      return var1.getStatus() != MovementStatus.RUNNING || this.ticksWithoutPlacement == 0;
   }

   @Override
   public void reset() {
      super.reset();
      this.ticksWithoutPlacement = 0;
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      BetterBlockPos var1 = new BetterBlockPos(this.src.subtract(this.getDirection()).above());
      return ImmutableSet.of(this.src, this.src.above(), this.dest, var1, var1.above());
   }

   @Override
   public MovementState updateState(MovementState var1) {
      if (this.ctx.playerFeet().y < this.src.y) {
         return var1.setStatus(MovementStatus.UNREACHABLE);
      }

      super.updateState(var1);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         return var1;
      }

      if (!this.ctx.playerFeet().equals(this.dest) && !this.ctx.playerFeet().equals(this.dest.offset(this.getDirection().below()))) {
         BlockState var2 = BlockStateInterface.get(this.ctx, this.positionToPlace);
         if (!MovementHelper.canWalkOn(this.ctx, this.positionToPlace, var2)) {
            this.ticksWithoutPlacement++;
            if (MovementHelper.attemptToPlaceABlock(var1, this.baritone, this.dest.below(), false, true) == MovementHelper.PlaceResult.READY_TO_PLACE) {
               var1.setInput(Input.SNEAK, true);
               if (this.ctx.player().isCrouching()) {
                  var1.setInput(Input.CLICK_RIGHT, true);
               }
            }

            if (this.ticksWithoutPlacement > 10) {
               var1.setInput(Input.MOVE_BACK, true);
            }

            return var1;
         } else {
            MovementHelper.moveTowards(this.ctx, var1, this.dest);
            var1.setInput(Input.SNEAK, Baritone.settings().allowWalkOnMagmaBlocks.value && var2.is(Blocks.MAGMA_BLOCK));
            if (MovementHelper.isBottomSlab(var2) && !MovementHelper.isBottomSlab(BlockStateInterface.get(this.ctx, this.src.below()))) {
               return var1;
            } else if (Baritone.settings().assumeStep.value || this.ctx.playerFeet().equals(this.src.above())) {
               return var1;
            } else if (this.ctx.player().horizontalCollision && this.ctx.player().onGround()) {
               return var1.setInput(Input.JUMP, true);
            } else {
               int sx = Math.abs(this.src.getX() - this.dest.getX());
               int sxx = Math.abs(this.src.getZ() - this.dest.getZ());
               double sxxx = sx * Math.abs(this.dest.getX() + Ади - this.ctx.player().position().x)
                  + sxx * Math.abs(this.dest.getZ() + Адщ - this.ctx.player().position().z);
               double sxxxx = sxx * Math.abs(this.dest.getX() + Аеб - this.ctx.player().position().x)
                  + sx * Math.abs(this.dest.getZ() + АеА - this.ctx.player().position().z);
               double sxxxxx = sx * this.ctx.player().getDeltaMovement().z + sxx * this.ctx.player().getDeltaMovement().x;
               if (Math.abs(sxxxxx) > Ае诶) {
                  return var1;
               } else if (this.headBonkClear()) {
                  return var1.setInput(Input.JUMP, true);
               } else {
                  return !(sxxx > АеЫ) && !(sxxxx > Аез) ? var1.setInput(Input.JUMP, true) : var1;
               }
            }
         }
      } else {
         return var1.setStatus(MovementStatus.SUCCESS);
      }
   }

   public static double cost(CalculationContext var0, int var1, int var2, int var3, int var4, int var5) {
      BlockState var6 = var0.get(var4, var2, var5);
      double sx = 0.0;
      if (!MovementHelper.canWalkOn(var0, var4, var2, var5, var6)) {
         sx = var0.costOfPlacingAt(var4, var2, var5, var6);
         if (sx >= Адк) {
            return Адп;
         }

         if (!MovementHelper.isReplaceable(var4, var2, var5, var6, var0.bsi)) {
            return Ад2;
         }

         boolean sxx = false;

         for (int sxxx = 0; sxxx < 5; sxxx++) {
            int sxxxx = var4 + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxx].getStepX();
            int sxxxxx = var2 + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxx].getStepY();
            int sxxxxxx = var5 + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxx].getStepZ();
            if ((sxxxx != var1 || sxxxxxx != var3) && MovementHelper.canPlaceAgainst(var0.bsi, sxxxx, sxxxxx, sxxxxxx)) {
               sxx = true;
               break;
            }
         }

         if (!sxx) {
            return Ад西;
         }
      }

      BlockState sxx = var0.get(var1, var2 + 2, var3);
      if (!(var0.get(var1, var2 + 3, var3).getBlock() instanceof FallingBlock)
         || !MovementHelper.canWalkThrough(var0, var1, var2 + 1, var3) && sxx.getBlock() instanceof FallingBlock) {
         BlockState sxxx = var0.get(var1, var2 - 1, var3);
         if (MovementHelper.isClimbable(sxxx.getBlock())) {
            return Адд;
         }

         boolean sxxxx = MovementHelper.isBottomSlab(sxxx);
         boolean sxxxxx = MovementHelper.isBottomSlab(var6);
         if (sxxxx && !sxxxxx) {
            return Аде;
         }

         double sxxxxxx;
         if (sxxxxx) {
            if (sxxxx) {
               sxxxxxx = Math.max(JUMP_ONE_BLOCK_COST, Ад6);
               sxxxxxx += var0.jumpPenalty;
            } else {
               sxxxxxx = Адl;
            }
         } else {
            if (var6.is(Blocks.SOUL_SAND)) {
               sxxxxxx = Ад必;
            } else if (var6.is(Blocks.MAGMA_BLOCK)) {
               sxxxxxx = АдЗ;
            } else {
               sxxxxxx = Math.max(JUMP_ONE_BLOCK_COST, Адн);
            }

            sxxxxxx += var0.jumpPenalty;
         }

         double sxxxxxxx = sxxxxxx + sx;
         sxxxxxxx += MovementHelper.getMiningDurationTicks(var0, var1, var2 + 2, var3, sxx, false);
         if (sxxxxxxx >= АдД) {
            return АдН;
         }

         sxxxxxxx += MovementHelper.getMiningDurationTicks(var0, var4, var2 + 1, var5, false);
         return sxxxxxxx >= Адш ? Адл : sxxxxxxx + MovementHelper.getMiningDurationTicks(var0, var4, var2 + 2, var5, true);
      } else {
         return Адт;
      }
   }

   public boolean headBonkClear() {
      BetterBlockPos var1 = this.src.above(2);

      for (int sx = 0; sx < 4; sx++) {
         BetterBlockPos sxx = var1.relative(Direction.from2DDataValue(sx));
         if (!MovementHelper.canWalkThrough(this.ctx, sxx)) {
            return false;
         }
      }

      return true;
   }

   public MovementAscend(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3) {
      super(var1, var2, var3, new BetterBlockPos[]{var3, var2.above(2), var3.above()}, var3.below());
   }
}
