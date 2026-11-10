// Original binary: hex/api/baritone/pathing/movement/movements/MovementPillar
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
import java.util.Set;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class MovementPillar extends Movement {
   private static final double бА9 = 0;
   private static final double бАЮ = 0;
   private static final double бАO = 0;
   private static final double бА弟 = 0;
   private static final double бАВ = 0;
   private static final double бАж = 0;
   private static final double бА8 = 0;
   private static final double бАТ = 0;
   private static final double бАЙ = 0;
   private static final double бАэ = 0;
   private static final double бАО = 0;
   private static final double бАИ = 0;
   private static final double бАП = 0;
   private static final double бА_ = 0;
   private static final double бАс = 0;
   private static final double бАЛ = 0;
   private static final double бАь = 0;
   private static final double бАЯ = 0;
   private static final double бАХ = 0;
   private static final double бАШ = 0;
   private static final double бАа = 0;


   public static double cost(CalculationContext var0, int var1, int var2, int var3) {
      BlockState var4 = var0.get(var1, var2, var3);
      Block sx = var4.getBlock();
      boolean sxx = MovementHelper.isClimbable(sx);
      BlockState sxxx = var0.get(var1, var2 - 1, var3);
      if (!sxx) {
         if (MovementHelper.isClimbable(sxxx.getBlock())) {
            return бА9;
         }

         if (sxxx.getBlock() instanceof SlabBlock && sxxx.getValue(SlabBlock.TYPE) == SlabType.BOTTOM) {
            return бАЮ;
         }
      }

      BlockState sxxxx = var0.get(var1, var2 + 2, var3);
      Block sxxxxx = sxxxx.getBlock();
      if (sxxxxx instanceof FenceGateBlock) {
         return бАO;
      }

      BlockState sxxxxxx = null;
      if (MovementHelper.isWater(sxxxx) && MovementHelper.isWater(var4)) {
         sxxxxxx = var0.get(var1, var2 + 1, var3);
         if (MovementHelper.isWater(sxxxxxx)) {
            return бА弟;
         }
      }

      double sxxxxxxx = 0.0;
      if (!sxx) {
         sxxxxxxx = var0.costOfPlacingAt(var1, var2, var3, var4);
         if (sxxxxxxx >= бАВ) {
            return бАж;
         }

         if (sxxx.getBlock() instanceof AirBlock) {
            sxxxxxxx += бА8;
         }
      }

      if ((!MovementHelper.isLiquid(var4) || MovementHelper.canPlaceAgainst(var0.bsi, var1, var2 - 1, var3, sxxx))
         && (!MovementHelper.isLiquid(sxxx) || !var0.assumeWalkOnWater)) {
         if ((sx == Blocks.LILY_PAD || sx instanceof CarpetBlock) && !sxxx.getFluidState().isEmpty()) {
            return бАЙ;
         }

         double sxxxxxxxx = MovementHelper.getMiningDurationTicks(var0, var1, var2 + 2, var3, sxxxx, true);
         if (sxxxxxxxx >= бАэ) {
            return бАО;
         }

         if (sxxxxxxxx != 0.0) {
            if (MovementHelper.isClimbable(sxxxxx)) {
               sxxxxxxxx = 0.0;
            } else {
               BlockState sxxxxxxxxx = var0.get(var1, var2 + 3, var3);
               if (sxxxxxxxxx.getBlock() instanceof FallingBlock) {
                  if (sxxxxxx == null) {
                     sxxxxxx = var0.get(var1, var2 + 1, var3);
                  }

                  if (!(sxxxxx instanceof FallingBlock) || !(sxxxxxx.getBlock() instanceof FallingBlock)) {
                     return бАИ;
                  }
               }
            }
         }

         return sxx ? бАП + sxxxxxxxx * бА_ : JUMP_ONE_BLOCK_COST + sxxxxxxx + var0.jumpPenalty + sxxxxxxxx;
      } else {
         return бАТ;
      }
   }

   @Override
   protected boolean prepared(MovementState var1) {
      if (this.ctx.playerFeet().equals(this.src) || this.ctx.playerFeet().equals(this.src.below())) {
         Block var2 = BlockStateInterface.getBlock(this.ctx, this.src.below());
         if (MovementHelper.isClimbable(var2)) {
            var1.setInput(Input.SNEAK, true);
         }
      }

      return MovementHelper.isWater(this.ctx, this.dest.above()) ? true : super.prepared(var1);
   }

   @Override
   protected Set<BetterBlockPos> calculateValidPositions() {
      return ImmutableSet.of(this.src, this.dest);
   }

   @Override
   public MovementState updateState(MovementState var1) {
      super.updateState(var1);
      if (var1.getStatus() != MovementStatus.RUNNING) {
         return var1;
      }

      if (this.ctx.playerFeet().y < this.src.y) {
         return var1.setStatus(MovementStatus.UNREACHABLE);
      }

      BlockState var2 = BlockStateInterface.get(this.ctx, this.src);
      if (MovementHelper.isWater(var2) && MovementHelper.isWater(this.ctx, this.dest)) {
         var1.setTarget(
            new MovementState.MovementTarget(
               RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), VecUtils.getBlockPosCenter(this.dest), this.ctx.playerRotations()), false
            )
         );
         Vec3 sx = VecUtils.getBlockPosCenter(this.dest);
         if (Math.abs(this.ctx.player().position().x - sx.x) > бАс || Math.abs(this.ctx.player().position().z - sx.z) > бАЛ) {
            var1.setInput(Input.MOVE_FORWARD, true);
         }

         return this.ctx.playerFeet().equals(this.dest) ? var1.setStatus(MovementStatus.SUCCESS) : var1;
      } else {
         boolean sx = MovementHelper.isClimbable(var2.getBlock());
         Rotation sxx = RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), VecUtils.getBlockPosCenter(this.positionToPlace), this.ctx.playerRotations());
         if (!sx) {
            var1.setTarget(new MovementState.MovementTarget(this.ctx.playerRotations().withPitch(sxx.getPitch()), true));
         }

         boolean sxxx = MovementHelper.canWalkOn(this.ctx, this.src) || sx;
         if (sx) {
            if (this.ctx.playerFeet().equals(this.dest)) {
               return var1.setStatus(MovementStatus.SUCCESS);
            }

            MovementHelper.moveTowards(this.ctx, var1, this.dest);
            var1.setInput(Input.JUMP, true);
            return var1;
         } else {
            if (!((Baritone)this.baritone).getInventoryBehavior().selectThrowawayForLocation(true, this.src.x, this.src.y, this.src.z)) {
               return var1.setStatus(MovementStatus.UNREACHABLE);
            }

            var1.setInput(Input.SNEAK, true);
            double sxxxx = this.ctx.player().position().x - (this.dest.getX() + бАь);
            double sxxxxx = this.ctx.player().position().z - (this.dest.getZ() + бАЯ);
            double sxxxxxx = Math.sqrt(sxxxx * sxxxx + sxxxxx * sxxxxx);
            double sxxxxxxx = Math.sqrt(
               this.ctx.player().getDeltaMovement().x * this.ctx.player().getDeltaMovement().x
                  + this.ctx.player().getDeltaMovement().z * this.ctx.player().getDeltaMovement().z
            );
            if (sxxxxxx > бАХ) {
               var1.setInput(Input.MOVE_FORWARD, true);
               var1.setTarget(new MovementState.MovementTarget(sxx, true));
            } else if (sxxxxxxx < бАШ) {
               var1.setInput(Input.JUMP, this.ctx.player().position().y < this.dest.getY());
            }

            if (!sxxx) {
               BlockState sxxxxxxxx = BlockStateInterface.get(this.ctx, this.src);
               Block sxxxxxxxxx = sxxxxxxxx.getBlock();
               if (!(sxxxxxxxxx instanceof AirBlock) && !sxxxxxxxx.canBeReplaced()) {
                  RotationUtils.reachable(this.ctx, this.src, this.ctx.playerController().getBlockReachDistance())
                     .map(var0 -> new MovementState.MovementTarget(var0, true))
                     .ifPresent(var1::setTarget);
                  var1.setInput(Input.JUMP, false);
                  var1.setInput(Input.CLICK_LEFT, true);
                  sxxx = false;
               } else if (this.ctx.player().isCrouching()
                  && (this.ctx.isLookingAt(this.src.below()) || this.ctx.isLookingAt(this.src))
                  && this.ctx.player().position().y > this.dest.getY() + бАа) {
                  var1.setInput(Input.CLICK_RIGHT, true);
               }
            }

            return this.ctx.playerFeet().equals(this.dest) && sxxx ? var1.setStatus(MovementStatus.SUCCESS) : var1;
         }
      }
   }

   public MovementPillar(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3) {
      super(var1, var2, var3, new BetterBlockPos[]{var2.above(2)}, var2);
   }

   @Override
   public double calculateCost(CalculationContext var1) {
      return cost(var1, this.src.x, this.src.y, this.src.z);
   }
}
