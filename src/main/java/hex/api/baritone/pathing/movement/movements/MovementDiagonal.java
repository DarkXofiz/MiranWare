// Original binary: hex/api/baritone/pathing/movement/movements/MovementDiagonal
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
import hex.api.baritone.utils.pathing.MutableMoveResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class MovementDiagonal extends Movement {
   private static final double SQRT_2 = Math.sqrt(MovementDiagonal.诶х弟);
   private static final double 诶хб = 0;
   private static final double 诶хА = 0;
   private static final double 诶х诶 = 0;
   private static final double 诶хЫ = 0;
   private static final double 诶хз = 0;
   private static final double 诶хР = 0;
   private static final double 诶хх = 0;
   private static final double 诶хЦ = 0;
   private static final double 诶х9 = 0;
   private static final double 诶хЮ = 0;
   private static final double 诶хO = 0;
   private static final double 诶х弟 = 0;

   @Override
   public List<BlockPos> toWalkInto(BlockStateInterface var1) {
      if (this.toWalkIntoCached == null) {
         this.toWalkIntoCached = new ArrayList<>();
      }

      List var2 = new ArrayList<>();

      for (int sx = 0; sx < 4; sx++) {
         if (!MovementHelper.canWalkThrough(var1, this.positionsToBreak[sx].x, this.positionsToBreak[sx].y, this.positionsToBreak[sx].z)) {
            var2.add(this.positionsToBreak[sx]);
         }
      }

      this.toWalkIntoCached = var2;
      return this.toWalkIntoCached;
   }

   @Override
   protected boolean prepared(MovementState var1) {
      return true;
   }


   private MovementDiagonal(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3, BetterBlockPos var4, BetterBlockPos var5) {
      super(var1, var2, var3, new BetterBlockPos[]{var4, var4.above(), var5, var5.above(), var3, var3.above()});
   }

   @Override
   public List<BlockPos> toBreak(BlockStateInterface var1) {
      if (this.toBreakCached != null) {
         return this.toBreakCached;
      }

      List var2 = new ArrayList<>();

      for (int sx = 4; sx < 6; sx++) {
         if (!MovementHelper.canWalkThrough(var1, this.positionsToBreak[sx].x, this.positionsToBreak[sx].y, this.positionsToBreak[sx].z)) {
            var2.add(this.positionsToBreak[sx]);
         }
      }

      this.toBreakCached = var2;
      return var2;
   }

   private boolean sprint() {
      if (MovementHelper.isLiquid(this.ctx, this.ctx.playerFeet()) && !Baritone.settings().sprintInWater.value) {
         return false;
      }

      for (int var1 = 0; var1 < 4; var1++) {
         if (!MovementHelper.canWalkThrough(this.ctx, this.positionsToBreak[var1])) {
            return false;
         }
      }

      return true;
   }

   public static void cost(CalculationContext var0, int var1, int var2, int var3, int var4, int var5, MutableMoveResult var6) {
      if (MovementHelper.canWalkThrough(var0, var4, var2 + 1, var5)) {
         BlockState var7 = var0.get(var4, var2, var5);
         boolean sx = false;
         boolean sxx = false;
         boolean sxxx = false;
         boolean sxxxx = false;
         BlockState sxxxxx;
         BlockState sxxxxxx;
         if (!MovementHelper.canWalkThrough(var0, var4, var2, var5, var7)) {
            sx = true;
            if (!var0.allowDiagonalAscend
               || !MovementHelper.canWalkThrough(var0, var1, var2 + 2, var3)
               || !MovementHelper.canWalkOn(var0, var4, var2, var5, var7)
               || !MovementHelper.canWalkThrough(var0, var4, var2 + 2, var5)) {
               return;
            }

            sxxxxxx = var7;
            sxxxxx = var0.get(var1, var2 - 1, var3);
         } else {
            sxxxxxx = var0.get(var4, var2 - 1, var5);
            sxxxxx = var0.get(var1, var2 - 1, var3);
            boolean sxxxxxxx = MovementHelper.mustBeSolidToWalkOn(var0, var1, var2 - 1, var3, sxxxxx);
            sxxx = sxxxxxxx && MovementHelper.canUseFrostWalker(var0, sxxxxxx);
            if (!sxxx && !MovementHelper.canWalkOn(var0, var4, var2 - 1, var5, sxxxxxx)) {
               sxx = true;
               if (!var0.allowDiagonalDescend
                  || !MovementHelper.canWalkOn(var0, var4, var2 - 2, var5)
                  || !MovementHelper.canWalkThrough(var0, var4, var2 - 1, var5, sxxxxxx)) {
                  return;
               }
            }

            sxxx &= !var0.assumeWalkOnWater;
         }

         double sxxxxxxx = 诶х诶;
         if (sxxxxxx.is(Blocks.SOUL_SAND)) {
            sxxxxxxx += 诶хЫ;
         } else if (var0.allowWalkOnMagmaBlocks && sxxxxxx.is(Blocks.MAGMA_BLOCK)) {
            sxxxxxxx += 诶хз;
            sxxxx = true;
         } else if (!sxxx && sxxxxxx.getBlock() == Blocks.WATER) {
            sxxxxxxx += var0.walkOnWaterOnePenalty * SQRT_2;
         }

         Block sxxxxxxxx = sxxxxx.getBlock();
         if (!MovementHelper.isClimbable(sxxxxxxxx)) {
            if (sxxxxxxxx == Blocks.SOUL_SAND) {
               sxxxxxxx += 诶хР;
            } else if (var0.allowWalkOnMagmaBlocks && sxxxxxxxx.equals(Blocks.MAGMA_BLOCK)) {
               sxxxxxxx += 诶хх;
               sxxxx = true;
            }

            BlockState sxxxxxxxxx = var0.get(var1, var2 - 1, var5);
            if ((var0.allowWalkOnMagmaBlocks || !sxxxxxxxxx.is(Blocks.MAGMA_BLOCK)) && !MovementHelper.isLava(sxxxxxxxxx)) {
               BlockState sxxxxxxxxxx = var0.get(var4, var2 - 1, var3);
               if ((var0.allowWalkOnMagmaBlocks || !sxxxxxxxxx.is(Blocks.MAGMA_BLOCK)) && !MovementHelper.isLava(sxxxxxxxxxx)) {
                  boolean sxxxxxxxxxxx = false;
                  BlockState sxxxxxxxxxxxx = var0.get(var1, var2, var3);
                  Block sxxxxxxxxxxxxx = sxxxxxxxxxxxx.getBlock();
                  if (MovementHelper.isWater(sxxxxxxxxxxxx) || MovementHelper.isWater(var7)) {
                     if (sx) {
                        return;
                     }

                     sxxxxxxx = var0.waterWalkSpeed;
                     sxxxxxxxxxxx = true;
                  }

                  BlockState sxxxxxxxxxxxxxx = var0.get(var1, var2, var5);
                  BlockState sxxxxxxxxxxxxxxx = var0.get(var4, var2, var3);
                  if (sx) {
                     boolean sxxxxxxxxxxxxxxxx = MovementHelper.canWalkThrough(var0, var1, var2 + 2, var5);
                     boolean sxxxxxxxxxxxxxxxxx = MovementHelper.canWalkThrough(var0, var1, var2 + 1, var5);
                     boolean sxxxxxxxxxxxxxxxxxx = MovementHelper.canWalkThrough(var0, var1, var2, var5, sxxxxxxxxxxxxxx);
                     boolean sxxxxxxxxxxxxxxxxxxx = MovementHelper.canWalkThrough(var0, var4, var2 + 2, var3);
                     boolean sxxxxxxxxxxxxxxxxxxxx = MovementHelper.canWalkThrough(var0, var4, var2 + 1, var3);
                     boolean sxxxxxxxxxxxxxxxxxxxxx = MovementHelper.canWalkThrough(var0, var4, var2, var3, sxxxxxxxxxxxxxxx);
                     if ((
                           sxxxxxxxxxxxxxxxx && sxxxxxxxxxxxxxxxxx && sxxxxxxxxxxxxxxxxxx
                              || sxxxxxxxxxxxxxxxxxxx && sxxxxxxxxxxxxxxxxxxxx && sxxxxxxxxxxxxxxxxxxxxx
                        )
                        && !MovementHelper.avoidWalkingInto(sxxxxxxxxxxxxxx)
                        && !MovementHelper.avoidWalkingInto(sxxxxxxxxxxxxxxx)
                        && (!sxxxxxxxxxxxxxxxx || !sxxxxxxxxxxxxxxxxx || !MovementHelper.canWalkOn(var0, var1, var2, var5, sxxxxxxxxxxxxxx))
                        && (!sxxxxxxxxxxxxxxxxxxx || !sxxxxxxxxxxxxxxxxxxxx || !MovementHelper.canWalkOn(var0, var4, var2, var3, sxxxxxxxxxxxxxxx))
                        && (sxxxxxxxxxxxxxxxx || !sxxxxxxxxxxxxxxxxx || !sxxxxxxxxxxxxxxxxxx)
                        && (sxxxxxxxxxxxxxxxxxxx || !sxxxxxxxxxxxxxxxxxxxx || !sxxxxxxxxxxxxxxxxxxxxx)) {
                        var6.cost = sxxxxxxx * SQRT_2 + JUMP_ONE_BLOCK_COST;
                        var6.x = var4;
                        var6.z = var5;
                        var6.y = var2 + 1;
                     }
                  } else {
                     double sxxxxxxxxxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var1, var2, var5, sxxxxxxxxxxxxxx, false);
                     double sxxxxxxxxxxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var4, var2, var3, sxxxxxxxxxxxxxxx, false);
                     if (sxxxxxxxxxxxxxxxx == 0.0 || sxxxxxxxxxxxxxxxxx == 0.0) {
                        BlockState sxxxxxxxxxxxxxxxxxx = var0.get(var1, var2 + 1, var5);
                        sxxxxxxxxxxxxxxxx += MovementHelper.getMiningDurationTicks(var0, var1, var2 + 1, var5, sxxxxxxxxxxxxxxxxxx, true);
                        if (sxxxxxxxxxxxxxxxx == 0.0 || sxxxxxxxxxxxxxxxxx == 0.0) {
                           BlockState sxxxxxxxxxxxxxxxxxxx = var0.get(var4, var2 + 1, var3);
                           if (sxxxxxxxxxxxxxxxx != 0.0
                              || (!MovementHelper.avoidWalkingInto(sxxxxxxxxxxxxxxx) || sxxxxxxxxxxxxxxx.getBlock() == Blocks.WATER)
                                 && !MovementHelper.avoidWalkingInto(sxxxxxxxxxxxxxxxxxxx)) {
                              sxxxxxxxxxxxxxxxxx += MovementHelper.getMiningDurationTicks(var0, var4, var2 + 1, var3, sxxxxxxxxxxxxxxxxxxx, true);
                              if (sxxxxxxxxxxxxxxxx == 0.0 || sxxxxxxxxxxxxxxxxx == 0.0) {
                                 if (sxxxxxxxxxxxxxxxxx != 0.0
                                    || (!MovementHelper.avoidWalkingInto(sxxxxxxxxxxxxxx) || sxxxxxxxxxxxxxx.getBlock() == Blocks.WATER)
                                       && !MovementHelper.avoidWalkingInto(sxxxxxxxxxxxxxxxxxx)) {
                                    if (sxxxxxxxxxxxxxxxx != 0.0 || sxxxxxxxxxxxxxxxxx != 0.0) {
                                       sxxxxxxx *= SQRT_2 - 诶хЦ;
                                       if (MovementHelper.isClimbable(sxxxxxxxxxxxxx)) {
                                          return;
                                       }
                                    } else if (var0.canSprint && !sxxxxxxxxxxx && !sxxxx) {
                                       sxxxxxxx *= 诶х9;
                                    }

                                    var6.cost = sxxxxxxx * SQRT_2;
                                    if (sxx) {
                                       var6.cost = var6.cost + Math.max(FALL_N_BLOCKS_COST[1], 诶хЮ);
                                       var6.y = var2 - 1;
                                    } else {
                                       var6.y = var2;
                                    }

                                    var6.x = var4;
                                    var6.z = var5;
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
   protected boolean safeToCancel(MovementState var1) {
      LocalPlayer var2 = this.ctx.player();
      double sx = 诶хб;
      double sxx = var2.position().x;
      double sxxx = var2.position().y - 1.0;
      double sxxxx = var2.position().z;
      if (this.ctx.playerFeet().equals(this.src)) {
         return true;
      } else if (MovementHelper.canWalkOn(this.ctx, new BlockPos(this.src.x, this.src.y - 1, this.dest.z))
         && MovementHelper.canWalkOn(this.ctx, new BlockPos(this.dest.x, this.src.y - 1, this.src.z))) {
         return true;
      } else {
         return !this.ctx.playerFeet().equals(new BetterBlockPos(this.src.x, this.src.y, this.dest.z))
               && !this.ctx.playerFeet().equals(new BetterBlockPos(this.dest.x, this.src.y, this.src.z))
            ? true
            : MovementHelper.canWalkOn(this.ctx, new BetterBlockPos(sxx + sx, sxxx, sxxxx + sx))
               || MovementHelper.canWalkOn(this.ctx, new BetterBlockPos(sxx + sx, sxxx, sxxxx - sx))
               || MovementHelper.canWalkOn(this.ctx, new BetterBlockPos(sxx - sx, sxxx, sxxxx + sx))
               || MovementHelper.canWalkOn(this.ctx, new BetterBlockPos(sxx - sx, sxxx, sxxxx - sx));
      }
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

      if (this.playerInValidPosition() || MovementHelper.isLiquid(this.ctx, this.src) && this.getValidPositions().contains(this.ctx.playerFeet().above())) {
         if (this.dest.y > this.src.y) {
            double var10001 = this.src.y;
            if (this.ctx.player().position().y < var10001 + 诶хO && this.ctx.player().horizontalCollision) {
               var1.setInput(Input.JUMP, true);
            }
         }

         if (this.sprint()) {
            var1.setInput(Input.SPRINT, true);
         }

         var1.setInput(
            Input.SNEAK,
            Baritone.settings().allowWalkOnMagmaBlocks.value
               && MovementHelper.steppingOnBlocks(this.ctx).stream().anyMatch(var1x -> this.ctx.world().getBlockState(var1x).is(Blocks.MAGMA_BLOCK))
         );
         MovementHelper.moveTowards(this.ctx, var1, this.dest);
         return var1;
      } else {
         return var1.setStatus(MovementStatus.UNREACHABLE);
      }
   }

   public MovementDiagonal(IBaritone var1, BetterBlockPos var2, Direction var3, Direction var4, int var5) {
      this(var1, var2, var2.relative(var3), var2.relative(var4), var4, var5);
   }

   private MovementDiagonal(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3, BetterBlockPos var4, Direction var5, int var6) {
      this(var1, var2, var3.relative(var5).above(var6), var3, var4);
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      BetterBlockPos var1 = new BetterBlockPos(this.src.x, this.src.y, this.dest.z);
      BetterBlockPos sx = new BetterBlockPos(this.dest.x, this.src.y, this.src.z);
      if (this.dest.y < this.src.y) {
         return ImmutableSet.of(this.src, this.dest.above(), var1, sx, this.dest, var1.below(), new BetterBlockPos[]{sx.below()});
      } else {
         return this.dest.y > this.src.y
            ? ImmutableSet.of(this.src, this.src.above(), var1, sx, this.dest, var1.above(), new BetterBlockPos[]{sx.above()})
            : ImmutableSet.of(this.src, this.dest, var1, sx);
      }
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      MutableMoveResult var2 = new MutableMoveResult();
      cost(var1, this.src.x, this.src.y, this.src.z, this.dest.x, this.dest.z, var2);
      return var2.y != this.dest.y ? 诶хА : var2.cost;
   }
}
