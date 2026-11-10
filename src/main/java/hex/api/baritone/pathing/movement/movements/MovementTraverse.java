// Original binary: hex/api/baritone/pathing/movement/movements/MovementTraverse
package hex.api.baritone.pathing.movement.movements;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.VecUtils;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.MovementState;
import hex.api.baritone.utils.BlockStateInterface;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class MovementTraverse extends Movement {
   private boolean wasTheBridgeBlockAlwaysThere = true;
   private static final double шЛ = 0;
   private static final double шь = 0;
   private static final double шЯ = 0;
   private static final double шХ = 0;
   private static final double шШ = 0;
   private static final double ша = 0;
   private static final double ш7 = 0;
   private static final double шУ = 0;
   private static final double ш0 = 0;
   private static final double шГ = 0;
   private static final double шф = 0;
   private static final double шЕ = 0;
   private static final double шч = 0;
   private static final double ш衣 = 0;
   private static final double шц = 0;
   private static final double шМ = 0;
   private static final double ш5 = 0;
   private static final double шЖ = 0;
   private static final double шо = 0;
   private static final double шК = 0;
   private static final double шЭ = 0;
   private static final double шЪ = 0;
   private static final double шЧ = 0;
   private static final double шЩ = 0;
   private static final float шм = 0;
   private static final String шФ = "шФ";
   private static final double ш3 = 0;
   private static final double шЬ = 0;
   private static final double ш1 = 0;
   private static final double шя = 0;
   private static final double шI = 0;
   private static final double шы = 0;
   private static final double шу = 0;
   private static final double шг = 0;
   private static final double шю = 0;
   private static final double ш4 = 0;
   private static final double шС = 0;
   private static final double шъ = 0;
   private static final double шБ = 0;

   public static double cost(CalculationContext var0, int var1, int var2, int var3, int var4, int var5) {
      BlockState var6 = var0.get(var4, var2 + 1, var5);
      BlockState sx = var0.get(var4, var2, var5);
      BlockState sxx = var0.get(var4, var2 - 1, var5);
      BlockState sxxx = var0.get(var1, var2 - 1, var3);
      Block sxxxx = sxxx.getBlock();
      boolean sxxxxx = MovementHelper.mustBeSolidToWalkOn(var0, var1, var2 - 1, var3, sxxx);
      boolean sxxxxxx = sxxxxx && !var0.assumeWalkOnWater && MovementHelper.canUseFrostWalker(var0, sxx);
      if (!sxxxxxx && !MovementHelper.canWalkOn(var0, var4, var2 - 1, var5, sxx)) {
         if (MovementHelper.isClimbable(sxxxx)) {
            return шГ;
         }

         if (!MovementHelper.isReplaceable(var4, var2 - 1, var5, sxx, var0.bsi)) {
            return шЭ;
         }

         boolean sxxxxxxx = MovementHelper.isWater(var6) || MovementHelper.isWater(sx);
         if (MovementHelper.isWater(sxx) && sxxxxxxx) {
            return шф;
         }

         double sxxxxxxxx = var0.costOfPlacingAt(var4, var2 - 1, var5, sxx);
         if (sxxxxxxxx >= шЕ) {
            return шч;
         }

         double sxxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var4, var2, var5, sx, false);
         if (sxxxxxxxxx >= ш衣) {
            return шц;
         }

         double sxxxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var4, var2 + 1, var5, var6, true);
         double sxxxxxxxxxxx = sxxxxxxx ? var0.waterWalkSpeed : шМ;

         for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < 5; sxxxxxxxxxxxx++) {
            int sxxxxxxxxxxxxx = var4 + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxxxxxxxxxxx].getStepX();
            int sxxxxxxxxxxxxxx = var2 - 1 + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxxxxxxxxxxx].getStepY();
            int sxxxxxxxxxxxxxxx = var5 + HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP[sxxxxxxxxxxxx].getStepZ();
            if ((sxxxxxxxxxxxxx != var1 || sxxxxxxxxxxxxxxx != var3)
               && MovementHelper.canPlaceAgainst(var0.bsi, sxxxxxxxxxxxxx, sxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxx)) {
               return sxxxxxxxxxxx + sxxxxxxxx + sxxxxxxxxx + sxxxxxxxxxx;
            }
         }

         if (sxxxx == Blocks.SOUL_SAND || sxxxx instanceof SlabBlock && sxxx.getValue(SlabBlock.TYPE) != SlabType.DOUBLE) {
            return ш5;
         }

         if (!sxxxxx) {
            return шЖ;
         }

         Block sxxxxxxxxxxxx = var0.getBlock(var1, var2, var3);
         if ((sxxxxxxxxxxxx == Blocks.LILY_PAD || sxxxxxxxxxxxx instanceof CarpetBlock) && !sxxx.getFluidState().isEmpty()) {
            return шо;
         }

         sxxxxxxxxxxx *= шК;
         return sxxxxxxxxxxx + sxxxxxxxx + sxxxxxxxxx + sxxxxxxxxxx;
      } else {
         double sxxxxxxx = шЛ;
         boolean sxxxxxxxx = false;
         boolean sxxxxxxxxx = false;
         if (!MovementHelper.isWater(var6) && !MovementHelper.isWater(sx)) {
            if (sxx.getBlock() == Blocks.SOUL_SAND) {
               sxxxxxxx += шь;
            } else if (!sxxxxxx && sxx.getBlock() == Blocks.WATER) {
               sxxxxxxx += var0.walkOnWaterOnePenalty;
            }

            if (sxxxx == Blocks.SOUL_SAND) {
               sxxxxxxx += шЯ;
            } else if (var0.allowWalkOnMagmaBlocks && sxxxx.equals(Blocks.MAGMA_BLOCK)) {
               sxxxxxxxxx = true;
               sxxxxxxx += шХ;
            }
         } else {
            sxxxxxxx = var0.waterWalkSpeed;
            sxxxxxxxx = true;
         }

         double sxxxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var4, var2, var5, sx, false);
         if (sxxxxxxxxxx >= шШ) {
            return ша;
         }

         double sxxxxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var4, var2 + 1, var5, var6, true);
         if (sxxxxxxxxxx == 0.0 && sxxxxxxxxxxx == 0.0) {
            if (!sxxxxxxxx && !sxxxxxxxxx && var0.canSprint) {
               sxxxxxxx *= ш7;
            }

            return sxxxxxxx;
         } else {
            if (MovementHelper.isClimbable(sxxxx)) {
               sxxxxxxxxxx *= шУ;
               sxxxxxxxxxxx *= ш0;
            }

            return sxxxxxxx + sxxxxxxxxxx + sxxxxxxxxxxx;
         }
      }
   }

   @Override
   public void reset() {
      super.reset();
      this.wasTheBridgeBlockAlwaysThere = true;
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      return ImmutableSet.of(this.src, this.dest);
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      return cost(var1, this.src.x, this.src.y, this.src.z, this.dest.x, this.dest.z);
   }

   @Override
   protected boolean prepared(MovementState var1) {
      if (this.ctx.playerFeet().equals(this.src) || this.ctx.playerFeet().equals(this.src.below())) {
         Block var2 = BlockStateInterface.getBlock(this.ctx, this.src.below());
         if (MovementHelper.isClimbable(var2)) {
            var1.setInput(Input.SNEAK, true);
         }
      }

      return super.prepared(var1);
   }


   @Override
   public MovementState updateState(MovementState var1) {
      super.updateState(var1);
      BlockState var2 = BlockStateInterface.get(this.ctx, this.positionsToBreak[0]);
      BlockState sx = BlockStateInterface.get(this.ctx, this.positionsToBreak[1]);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         if (!Baritone.settings().walkWhileBreaking.value) {
            return var1;
         }

         if (var1.getStatus() != MovementStatus.PREPPING) {
            return var1;
         }

         if (MovementHelper.avoidWalkingInto(var2)) {
            return var1;
         }

         if (MovementHelper.avoidWalkingInto(sx)) {
            return var1;
         }

         double sxx = Math.max(
            Math.abs(this.ctx.player().position().x - (this.dest.getX() + шЪ)), Math.abs(this.ctx.player().position().z - (this.dest.getZ() + шЧ))
         );
         if (sxx < шЩ) {
            return var1;
         }

         if (!var1.getTarget().getRotation().isPresent()) {
            return var1;
         }

         float sxxx = RotationUtils.calcRotationFromVec3d(
               this.ctx.playerHead(), VecUtils.calculateBlockCenter(this.ctx.world(), this.dest), this.ctx.playerRotations()
            )
            .getYaw();
         float sxxxx = var1.getTarget().getRotation().get().getPitch();
         if (MovementHelper.isBlockNormalCube(var2)
            || var2.getBlock() instanceof AirBlock && (MovementHelper.isBlockNormalCube(sx) || sx.getBlock() instanceof AirBlock)) {
            sxxxx = шм;
         }

         return var1.setTarget(new MovementState.MovementTarget(new Rotation(sxxx, sxxxx), true))
            .setInput(Input.MOVE_FORWARD, true)
            .setInput(Input.SPRINT, true);
      } else {
         Block sxx = BlockStateInterface.get(this.ctx, this.src.below()).getBlock();
         boolean sxxx = MovementHelper.isClimbable(sxx);
         var1.setInput(
            Input.SNEAK,
            Baritone.settings().allowWalkOnMagmaBlocks.value
               && MovementHelper.steppingOnBlocks(this.ctx).stream().anyMatch(var1x -> this.ctx.world().getBlockState(var1x).is(Blocks.MAGMA_BLOCK))
         );
         if (var2.getBlock() instanceof DoorBlock || sx.getBlock() instanceof DoorBlock) {
            boolean sxxxx = var2.getBlock() instanceof DoorBlock && !MovementHelper.isDoorPassable(this.ctx, this.src, this.dest)
               || sx.getBlock() instanceof DoorBlock && !MovementHelper.isDoorPassable(this.ctx, this.dest, this.src);
            boolean sxxxxx = !Blocks.IRON_DOOR.equals(var2.getBlock()) && !Blocks.IRON_DOOR.equals(sx.getBlock());
            if (sxxxx && sxxxxx) {
               return var1.setTarget(
                     new MovementState.MovementTarget(
                        RotationUtils.calcRotationFromVec3d(
                           this.ctx.playerHead(), VecUtils.calculateBlockCenter(this.ctx.world(), this.positionsToBreak[0]), this.ctx.playerRotations()
                        ),
                        true
                     )
                  )
                  .setInput(Input.CLICK_RIGHT, true);
            }
         }

         if (var2.getBlock() instanceof FenceGateBlock || sx.getBlock() instanceof FenceGateBlock) {
            BlockPos sxxxx = !MovementHelper.isGatePassable(this.ctx, this.positionsToBreak[0], this.src.above())
               ? this.positionsToBreak[0]
               : (!MovementHelper.isGatePassable(this.ctx, this.positionsToBreak[1], this.src) ? this.positionsToBreak[1] : null);
            if (sxxxx != null) {
               var sxxxxx = RotationUtils.reachable(this.ctx, sxxxx);
               if (sxxxxx.isPresent()) {
                  return var1.setTarget(new MovementState.MovementTarget(sxxxxx.get(), true)).setInput(Input.CLICK_RIGHT, true);
               }
            }
         }

         boolean sxxxx = MovementHelper.canWalkOn(this.ctx, this.positionToPlace) || sxxx || MovementHelper.canUseFrostWalker(this.ctx, this.positionToPlace);
         BlockPos sxxxxx = this.ctx.playerFeet();
         if (sxxxxx.getY() != this.dest.getY() && !sxxx) {
            this.logDebug(шФ);
            return sxxxxx.getY() < this.dest.getY() ? var1.setInput(Input.JUMP, true) : var1;
         }

         if (sxxxx) {
            if (sxxxxx.equals(this.dest)) {
               return var1.setStatus(MovementStatus.SUCCESS);
            }

            if (!Baritone.settings().overshootTraverse.value
               || !sxxxxx.equals(this.dest.offset(this.getDirection())) && !sxxxxx.equals(this.dest.offset(this.getDirection()).offset(this.getDirection()))) {
               Block sxxxxxx = BlockStateInterface.get(this.ctx, this.src).getBlock();
               Block sxxxxxxx = BlockStateInterface.get(this.ctx, this.src.above()).getBlock();
               double var10001 = this.src.y;
               if (!(this.ctx.player().position().y > var10001 + ш3)
                  || this.ctx.player().onGround()
                  || !MovementHelper.isClimbable(sxxxxxx) && !MovementHelper.isClimbable(sxxxxxxx)) {
                  BlockPos sxxxxxxxx = this.dest.subtract(this.src).offset(this.dest);
                  BlockState sxxxxxxxxx = BlockStateInterface.get(this.ctx, sxxxxxxxx);
                  BlockState sxxxxxxxxxx = BlockStateInterface.get(this.ctx, sxxxxxxxx.above());
                  if (this.wasTheBridgeBlockAlwaysThere
                     && (!MovementHelper.isLiquid(this.ctx, sxxxxx) || Baritone.settings().sprintInWater.value)
                     && (!MovementHelper.avoidWalkingInto(sxxxxxxxxx) || MovementHelper.isWater(sxxxxxxxxx))
                     && !MovementHelper.avoidWalkingInto(sxxxxxxxxxx)) {
                     var1.setInput(Input.SPRINT, true);
                  }

                  BlockState sxxxxxxxxxxx = BlockStateInterface.get(this.ctx, this.dest.below());
                  if (sxxxxx.getY() != this.dest.getY() && sxxx && MovementHelper.isClimbable(sxxxxxxxxxxx.getBlock())) {
                     var1.setInput(Input.JUMP, true);
                  }

                  MovementHelper.moveTowards(this.ctx, var1, this.positionsToBreak[0]);
                  return var1;
               } else {
                  return var1;
               }
            } else {
               return var1.setStatus(MovementStatus.SUCCESS);
            }
         } else {
            this.wasTheBridgeBlockAlwaysThere = false;
            Block sxxxxxx = BlockStateInterface.get(this.ctx, sxxxxx.below()).getBlock();
            if (sxxxxxx.equals(Blocks.SOUL_SAND) || sxxxxxx instanceof SlabBlock) {
               double sxxxxxxx = Math.max(
                  Math.abs(this.dest.getX() + шЬ - this.ctx.player().position().x), Math.abs(this.dest.getZ() + ш1 - this.ctx.player().position().z)
               );
               if (sxxxxxxx < шя) {
                  MovementHelper.moveTowards(this.ctx, var1, this.dest);
                  return var1.setInput(Input.MOVE_FORWARD, false).setInput(Input.MOVE_BACK, true);
               }
            }

            double sxxxxxxx = Math.max(
               Math.abs(this.ctx.player().position().x - (this.dest.getX() + шI)), Math.abs(this.ctx.player().position().z - (this.dest.getZ() + шы))
            );
            MovementHelper.PlaceResult sxxxxxxxx = MovementHelper.attemptToPlaceABlock(
               var1, this.baritone, this.dest.below(), false, !Baritone.settings().assumeSafeWalk.value
            );
            if ((sxxxxxxxx == MovementHelper.PlaceResult.READY_TO_PLACE || sxxxxxxx < шу) && !Baritone.settings().assumeSafeWalk.value) {
               var1.setInput(Input.SNEAK, true);
            }

            switch (sxxxxxxxx) {
               case READY_TO_PLACE:
                  if (this.ctx.player().isCrouching() || Baritone.settings().assumeSafeWalk.value) {
                     var1.setInput(Input.CLICK_RIGHT, true);
                  }

                  return var1;
               case ATTEMPTING:
                  if (sxxxxxxx > шг) {
                     float sxxxxxxxxx = RotationUtils.calcRotationFromVec3d(
                           this.ctx.playerHead(), VecUtils.getBlockPosCenter(this.dest), this.ctx.playerRotations()
                        )
                        .getYaw();
                     if (Math.abs(var1.getTarget().rotation.getYaw() - sxxxxxxxxx) < шю) {
                        return var1.setInput(Input.MOVE_FORWARD, true);
                     }
                  } else if (this.ctx.playerRotations().isReallyCloseTo(var1.getTarget().rotation)) {
                     return var1.setInput(Input.CLICK_LEFT, true);
                  }

                  return var1;
               default:
                  if (sxxxxx.equals(this.dest)) {
                     double sxxxxxxxxx = (this.dest.getX() + this.src.getX() + 1.0) * ш4;
                     double sxxxxxxxxxx = (this.dest.getY() + this.src.getY() - 1.0) * шС;
                     double sxxxxxxxxxxx = (this.dest.getZ() + this.src.getZ() + 1.0) * шъ;
                     BlockPos sxxxxxxxxxxxx = this.src.below();
                     Rotation sxxxxxxxxxxxxx = RotationUtils.calcRotationFromVec3d(
                        this.ctx.playerHead(), new Vec3(sxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxxxx), this.ctx.playerRotations()
                     );
                     float sxxxxxxxxxxxxxx = sxxxxxxxxxxxxx.getPitch();
                     double sxxxxxxxxxxxxxxx = Math.max(
                        Math.abs(this.ctx.player().position().x - sxxxxxxxxx), Math.abs(this.ctx.player().position().z - sxxxxxxxxxxx)
                     );
                     if (sxxxxxxxxxxxxxxx < шБ) {
                        float sxxxxxxxxxxxxxxxx = RotationUtils.calcRotationFromVec3d(
                              VecUtils.getBlockPosCenter(this.dest), this.ctx.playerHead(), this.ctx.playerRotations()
                           )
                           .getYaw();
                        var1.setTarget(new MovementState.MovementTarget(new Rotation(sxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxx), true));
                        var1.setInput(Input.MOVE_BACK, true);
                     } else {
                        var1.setTarget(new MovementState.MovementTarget(sxxxxxxxxxxxxx, true));
                     }

                     if (this.ctx.isLookingAt(sxxxxxxxxxxxx)) {
                        return var1.setInput(Input.CLICK_RIGHT, true);
                     } else {
                        if (this.ctx.playerRotations().isReallyCloseTo(var1.getTarget().rotation)) {
                           var1.setInput(Input.CLICK_LEFT, true);
                        }

                        return var1;
                     }
                  } else {
                     MovementHelper.moveTowardsWithSlightRotation(this.ctx, var1, this.dest);
                     return var1;
                  }
            }
         }
      }
   }

   public MovementTraverse(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3) {
      super(var1, var2, var3, new BetterBlockPos[]{var3.above(), var3}, var3.below());
   }

   @Override
   public boolean safeToCancel(MovementState var1) {
      return var1.getStatus() != MovementStatus.RUNNING || MovementHelper.canWalkOn(this.ctx, this.dest.below());
   }
}
