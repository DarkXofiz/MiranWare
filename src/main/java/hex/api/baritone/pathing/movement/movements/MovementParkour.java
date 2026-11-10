// Original binary: hex/api/baritone/pathing/movement/movements/MovementParkour
package hex.api.baritone.pathing.movement.movements;

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
import hex.api.baritone.utils.pathing.MutableMoveResult;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.WaterFluid;

// $VF: Compiled from s
public class MovementParkour extends Movement {
   private static final BetterBlockPos[] EMPTY = new BetterBlockPos[0];
   private final Direction direction;
   private final int dist;
   private final boolean ascend;
   private static final double field00053 = 0;
   private static final double field00054 = 0;
   private static final double field00055 = 0;
   private static final double field00056 = 0;
   private static final double field00057 = 0;
   private static final double field00058 = 0;
   private static final String field00059 = "field00059";
   private static final double field00060 = 0;
   private static final double field00061 = 0;
   private static final double field00062 = 0;
   private static final double field00063 = 0;
   private static final double field00064 = 0;

   public static void cost(CalculationContext var0, int var1, int var2, int var3, Direction var4, MutableMoveResult var5) {
      if (var0.allowParkour) {
         if (var0.allowJumpAtBuildLimit || var2 < var0.world.getMaxY()) {
            int var6 = var4.getStepX();
            int sx = var4.getStepZ();
            if (MovementHelper.fullyPassable(var0, var1 + var6, var2, var3 + sx)) {
               BlockState sxx = var0.get(var1 + var6, var2 - 1, var3 + sx);
               if (!MovementHelper.canWalkOn(var0, var1 + var6, var2 - 1, var3 + sx, sxx)) {
                  if (!MovementHelper.avoidWalkingInto(sxx) || sxx.getFluidState().getType() instanceof WaterFluid) {
                     if (MovementHelper.fullyPassable(var0, var1 + var6, var2 + 1, var3 + sx)) {
                        if (MovementHelper.fullyPassable(var0, var1 + var6, var2 + 2, var3 + sx)) {
                           if (MovementHelper.fullyPassable(var0, var1, var2 + 2, var3)) {
                              BlockState sxxx = var0.get(var1, var2 - 1, var3);
                              if (!MovementHelper.isClimbable(sxxx.getBlock())
                                 && !(sxxx.getBlock() instanceof StairBlock)
                                 && !MovementHelper.isBottomSlab(sxxx)) {
                                 if (!var0.assumeWalkOnWater || sxxx.getFluidState().isEmpty()) {
                                    if (var0.get(var1, var2, var3).getFluidState().isEmpty()) {
                                       int sxxxx;
                                       if (var0.allowWalkOnMagmaBlocks && sxxx.is(Blocks.MAGMA_BLOCK)) {
                                          sxxxx = 2;
                                       } else if (sxxx.getBlock() == Blocks.SOUL_SAND) {
                                          sxxxx = 2;
                                       } else if (var0.canSprint) {
                                          sxxxx = 4;
                                       } else {
                                          sxxxx = 3;
                                       }

                                       int sxxxxx = 1;

                                       for (int sxxxxxx = 2; sxxxxxx <= sxxxx; sxxxxx = sxxxxxx++) {
                                          int sxxxxxxx = var1 + var6 * sxxxxxx;
                                          int sxxxxxxxx = var3 + sx * sxxxxxx;
                                          if (!MovementHelper.fullyPassable(var0, sxxxxxxx, var2 + 1, sxxxxxxxx)
                                             || !MovementHelper.fullyPassable(var0, sxxxxxxx, var2 + 2, sxxxxxxxx)) {
                                             break;
                                          }

                                          BlockState sxxxxxxxxx = var0.bsi.get0(sxxxxxxx, var2, sxxxxxxxx);
                                          if (!MovementHelper.fullyPassable(var0, sxxxxxxx, var2, sxxxxxxxx, sxxxxxxxxx)) {
                                             if (sxxxxxx <= 3
                                                && var0.allowParkourAscend
                                                && var0.canSprint
                                                && MovementHelper.canWalkOn(var0, sxxxxxxx, var2, sxxxxxxxx, sxxxxxxxxx)
                                                && checkOvershootSafety(var0.bsi, sxxxxxxx + var6, var2 + 1, sxxxxxxxx + sx)) {
                                                var5.x = sxxxxxxx;
                                                var5.y = var2 + 1;
                                                var5.z = sxxxxxxxx;
                                                var5.cost = sxxxxxx * field00053 + var0.jumpPenalty;
                                                return;
                                             }
                                             break;
                                          }

                                          BlockState sxxxxxxxxxx = var0.bsi.get0(sxxxxxxx, var2 - 1, sxxxxxxxx);
                                          if (sxxxxxxxxxx.getBlock() != Blocks.FARMLAND
                                                && MovementHelper.canWalkOn(var0, sxxxxxxx, var2 - 1, sxxxxxxxx, sxxxxxxxxxx)
                                             || Math.min(16, var0.frostWalker + 2) >= sxxxxxx && MovementHelper.canUseFrostWalker(var0, sxxxxxxxxxx)) {
                                             if (checkOvershootSafety(var0.bsi, sxxxxxxx + var6, var2, sxxxxxxxx + sx)) {
                                                var5.x = sxxxxxxx;
                                                var5.y = var2;
                                                var5.z = sxxxxxxxx;
                                                var5.cost = costFromJumpDistance(sxxxxxx) + var0.jumpPenalty;
                                                return;
                                             }
                                             break;
                                          }

                                          if (!MovementHelper.fullyPassable(var0, sxxxxxxx, var2 + 3, sxxxxxxxx)) {
                                             break;
                                          }
                                       }

                                       if (var0.allowParkourPlace) {
                                          for (int sxxxxxx = sxxxxx; sxxxxxx > 1; sxxxxxx--) {
                                             int sxxxxxxx = var1 + sxxxxxx * var6;
                                             int sxxxxxxxx = var3 + sxxxxxx * sx;
                                             BlockState sxxxxxxxxx = var0.get(sxxxxxxx, var2 - 1, sxxxxxxxx);
                                             double sxxxxxxxxxx = var0.costOfPlacingAt(sxxxxxxx, var2 - 1, sxxxxxxxx, sxxxxxxxxx);
                                             if (!(sxxxxxxxxxx >= field00054)
                                                && MovementHelper.isReplaceable(sxxxxxxx, var2 - 1, sxxxxxxxx, sxxxxxxxxx, var0.bsi)
                                                && checkOvershootSafety(var0.bsi, sxxxxxxx + var6, var2, sxxxxxxxx + sx)) {
                                                for (int sxxxxxxxxxxx = 0; sxxxxxxxxxxx < 5; sxxxxxxxxxxx++) {
                                                   int sxxxxxxxxxxxx = sxxxxxxx
                                                      + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxxxxxxxxxx].getStepX();
                                                   int sxxxxxxxxxxxxx = var2
                                                      - 1
                                                      + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxxxxxxxxxx].getStepY();
                                                   int sxxxxxxxxxxxxxx = sxxxxxxxx
                                                      + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxxxxxxxxxx].getStepZ();
                                                   if ((sxxxxxxxxxxxx != sxxxxxxx - var6 || sxxxxxxxxxxxxxx != sxxxxxxxx - sx)
                                                      && MovementHelper.canPlaceAgainst(var0.bsi, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, sxxxxxxxxxxxxxx)) {
                                                      var5.x = sxxxxxxx;
                                                      var5.y = var2;
                                                      var5.z = sxxxxxxxx;
                                                      var5.cost = costFromJumpDistance(sxxxxxx) + sxxxxxxxxxx + var0.jumpPenalty;
                                                      return;
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public MovementState updateState(MovementState var1) {
      super.updateState(var1);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         return var1;
      }

      if (this.ctx.playerFeet().y < this.src.y) {
         this.logDebug(field00059);
         return var1.setStatus(MovementStatus.UNREACHABLE);
      }

      if (this.dist >= 4 || this.ascend) {
         var1.setInput(Input.SPRINT, true);
      }

      if (Baritone.settings().allowWalkOnMagmaBlocks.value && this.ctx.world().getBlockState(this.ctx.playerFeet().below()).is(Blocks.MAGMA_BLOCK)) {
         var1.setInput(Input.SNEAK, true);
      }

      MovementHelper.moveTowards(this.ctx, var1, this.dest);
      if (this.ctx.playerFeet().equals(this.dest)) {
         Block var2 = BlockStateInterface.getBlock(this.ctx, this.dest);
         if (var2 == Blocks.VINE || var2 == Blocks.LADDER) {
            return var1.setStatus(MovementStatus.SUCCESS);
         }

         if (this.ctx.player().position().y - this.ctx.playerFeet().getY() < field00060) {
            var1.setStatus(MovementStatus.SUCCESS);
         }
      } else if (!this.ctx.playerFeet().equals(this.src)) {
         if (!this.ctx.playerFeet().equals(this.src.relative(this.direction)) && !(this.ctx.player().position().y - this.src.y > field00061)) {
            if (!this.ctx.playerFeet().equals(this.dest.relative(this.direction, -1))) {
               var1.setInput(Input.SPRINT, false);
               if (this.ctx.playerFeet().equals(this.src.relative(this.direction, -1))) {
                  MovementHelper.moveTowards(this.ctx, var1, this.src);
               } else {
                  MovementHelper.moveTowards(this.ctx, var1, this.src.relative(this.direction, -1));
               }
            }
         } else {
            if (Baritone.settings().allowPlace.value
               && ((Baritone)this.baritone).getInventoryBehavior().hasGenericThrowaway()
               && !MovementHelper.canWalkOn(this.ctx, this.dest.below())
               && !this.ctx.player().onGround()
               && MovementHelper.attemptToPlaceABlock(var1, this.baritone, this.dest.below(), true, false) == MovementHelper.PlaceResult.READY_TO_PLACE) {
               var1.setInput(Input.CLICK_RIGHT, true);
            }

            if (this.dist == 3 && !this.ascend) {
               double var8 = this.src.x + field00062 - this.ctx.player().position().x;
               double sx = this.src.z + field00063 - this.ctx.player().position().z;
               double sxx = Math.max(Math.abs(var8), Math.abs(sx));
               if (sxx < field00064) {
                  return var1;
               }
            }

            var1.setInput(Input.JUMP, true);
         }
      }

      return var1;
   }

   private MovementParkour(IBaritone var1, BetterBlockPos var2, int var3, Direction var4, boolean var5) {
      super(var1, var2, var2.relative(var4, var3).above(var5 ? 1 : 0), EMPTY, var2.relative(var4, var3).below(var5 ? 0 : 1));
      this.direction = var4;
      this.dist = var3;
      this.ascend = var5;
   }

   private static double costFromJumpDistance(int var0) {
      switch (var0) {
         case 2:
            return field00055;
         case 3:
            return field00056;
         case 4:
            return field00057;
         default:
            throw new IllegalStateException("LOL " + var0);
      }
   }

   public static MovementParkour cost(CalculationContext var0, BetterBlockPos var1, Direction var2) {
      MutableMoveResult var3 = new MutableMoveResult();
      cost(var0, var1.x, var1.y, var1.z, var2, var3);
      int sx = Math.abs(var3.x - var1.x) + Math.abs(var3.z - var1.z);
      return new MovementParkour(var0.getBaritone(), var1, sx, var2, var3.y > var1.y);
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      MutableMoveResult var2 = new MutableMoveResult();
      cost(var1, this.src.x, this.src.y, this.src.z, this.direction, var2);
      return var2.x == this.dest.x && var2.y == this.dest.y && var2.z == this.dest.z ? var2.cost : field00058;
   }

   private static boolean checkOvershootSafety(BlockStateInterface var0, int var1, int var2, int var3) {
      return !MovementHelper.avoidWalkingInto(var0.get0(var1, var2, var3)) && !MovementHelper.avoidWalkingInto(var0.get0(var1, var2 + 1, var3));
   }

   @Override
   public boolean safeToCancel(MovementState var1) {
      return var1.getStatus() != MovementStatus.RUNNING;
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      Set var1 = new HashSet<>();

      for (int sx = 0; sx <= this.dist; sx++) {
         for (int sxx = 0; sxx < 2; sxx++) {
            var1.add(this.src.relative(this.direction, sx).above(sxx));
         }
      }

      return var1;
   }

}
