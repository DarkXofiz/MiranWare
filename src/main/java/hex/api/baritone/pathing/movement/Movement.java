// Original binary: hex/api/baritone/pathing/movement/Movement
package hex.api.baritone.pathing.movement;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.movement.IMovement;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.VecUtils;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.utils.BlockStateInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.phys.AABB;

// $VF: Compiled from s
public abstract class Movement implements MovementHelper, IMovement {
   public static final Direction[] HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP = new Direction[]{
      Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.DOWN
   };
   protected final IBaritone baritone;
   protected final IPlayerContext ctx;
   private MovementState currentState = new MovementState().setStatus(MovementStatus.PREPPING);
   protected final BetterBlockPos src;
   protected final BetterBlockPos dest;
   protected final BetterBlockPos[] positionsToBreak;
   protected final BetterBlockPos positionToPlace;
   private Double cost;
   public List<BlockPos> toBreakCached = null;
   public List<BlockPos> toPlaceCached = null;
   public List<BlockPos> toWalkIntoCached = null;
   private Set<BetterBlockPos> validPositionsCached = null;
   private Boolean calculatedWhileLoaded;
   private static final double АЭБ = 0;
   private static final double АЭв = 0;

   @Override
   public boolean calculatedWhileLoaded() {
      return this.calculatedWhileLoaded;
   }

   public void checkLoadedChunk(CalculationContext var1) {
      this.calculatedWhileLoaded = var1.bsi.worldContainsLoadedChunk(this.dest.x, this.dest.z);
   }

   @Override
   public void resetBlockCache() {
      this.toBreakCached = null;
      this.toPlaceCached = null;
      this.toWalkIntoCached = null;
   }

   public MovementState updateState(MovementState var1) {
      if (!this.prepared(var1)) {
         return var1.setStatus(MovementStatus.PREPPING);
      }

      if (var1.getStatus() == MovementStatus.PREPPING) {
         var1.setStatus(MovementStatus.WAITING);
      }

      if (var1.getStatus() == MovementStatus.WAITING) {
         var1.setStatus(MovementStatus.RUNNING);
      }

      return var1;
   }

   public BlockPos[] toBreakAll() {
      return this.positionsToBreak;
   }

   protected Movement(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3, BetterBlockPos[] var4, BetterBlockPos var5) {
      this.baritone = var1;
      this.ctx = var1.getPlayerContext();
      this.src = var2;
      this.dest = var3;
      this.positionsToBreak = var4;
      this.positionToPlace = var5;
   }

   public abstract double calculateCost(CalculationContext var1);

   protected boolean playerInValidPosition() {
      return this.getValidPositions().contains(this.ctx.playerFeet())
         || this.getValidPositions().contains(((PathingBehavior)this.baritone.getPathingBehavior()).pathStart());
   }

   public double recalculateCost(CalculationContext var1) {
      this.cost = null;
      return this.getCost(var1);
   }

   public double getCost(CalculationContext var1) {
      if (this.cost == null) {
         this.cost = this.calculateCost(var1);
      }

      return this.cost;
   }

   @Override
   public MovementStatus update() {
      this.ctx.player().getAbilities().flying = false;
      this.currentState = this.updateState(this.currentState);
      if (MovementHelper.isLiquid(this.ctx, this.ctx.playerFeet())) {
         double var10001 = this.dest.y;
         if (this.ctx.player().position().y < var10001 + АЭБ) {
            this.currentState.setInput(Input.JUMP, true);
         }
      }

      if (this.ctx.player().isInWall()) {
         this.ctx.getSelectedBlock().ifPresent(var1 -> MovementHelper.switchToBestToolFor(this.ctx, BlockStateInterface.get(this.ctx, var1)));
         this.currentState.setInput(Input.CLICK_LEFT, true);
      }

      this.currentState
         .getTarget()
         .getRotation()
         .ifPresent(var1 -> this.baritone.getLookBehavior().updateTarget(var1, this.currentState.getTarget().hasToForceRotations()));
      this.baritone.getInputOverrideHandler().clearAllKeys();
      this.currentState.getInputStates().forEach((var1, var2) -> this.baritone.getInputOverrideHandler().setInputForceState(var1, var2));
      this.currentState.getInputStates().clear();
      if (this.currentState.getStatus().isComplete()) {
         this.baritone.getInputOverrideHandler().clearAllKeys();
      }

      return this.currentState.getStatus();
   }

   public void override(double var1) {
      this.cost = var1;
   }

   protected boolean prepared(MovementState var1) {
      if (var1.getStatus() == MovementStatus.WAITING) {
         return true;
      }

      boolean var2 = false;

      for (BetterBlockPos sx : this.positionsToBreak) {
         if (!this.ctx.world().getEntitiesOfClass(FallingBlockEntity.class, new AABB(0.0, 0.0, 0.0, 1.0, АЭв, 1.0).move(sx)).isEmpty()
            && Baritone.settings().pauseMiningForFallingBlocks.value) {
            return false;
         }

         if (!MovementHelper.canWalkThrough(this.ctx, sx)) {
            var2 = true;
            MovementHelper.switchToBestToolFor(this.ctx, BlockStateInterface.get(this.ctx, sx));
            var sxx = RotationUtils.reachable(this.ctx, sx, this.ctx.playerController().getBlockReachDistance());
            if (!sxx.isPresent()) {
               var1.setTarget(
                  new MovementState.MovementTarget(
                     RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), VecUtils.getBlockPosCenter(sx), this.ctx.playerRotations()), true
                  )
               );
               var1.setInput(Input.CLICK_LEFT, true);
               return false;
            }

            Rotation sxxx = sxx.get();
            var1.setTarget(new MovementState.MovementTarget(sxxx, true));
            if (this.ctx.isLookingAt(sx) || this.ctx.playerRotations().isReallyCloseTo(sxxx)) {
               var1.setInput(Input.CLICK_LEFT, true);
            }

            return false;
         }
      }

      if (var2) {
         var1.setStatus(MovementStatus.UNREACHABLE);
         return true;
      } else {
         return true;
      }
   }

   @Override
   public double getCost() throws NullPointerException {
      return this.cost;
   }

   @Override
   public BlockPos getDirection() {
      return this.getDest().subtract(this.getSrc());
   }

   public List<BlockPos> toPlace(BlockStateInterface var1) {
      if (this.toPlaceCached != null) {
         return this.toPlaceCached;
      }

      List var2 = new ArrayList<>();
      if (this.positionToPlace != null && !MovementHelper.canWalkOn(var1, this.positionToPlace.x, this.positionToPlace.y, this.positionToPlace.z)) {
         var2.add(this.positionToPlace);
      }

      this.toPlaceCached = var2;
      return var2;
   }

   @Override
   public void reset() {
      this.currentState = new MovementState().setStatus(MovementStatus.PREPPING);
   }

   @Override
   public boolean safeToCancel() {
      return this.safeToCancel(this.currentState);
   }

   @Override
   public BetterBlockPos getSrc() {
      return this.src;
   }

   @Override
   public BetterBlockPos getDest() {
      return this.dest;
   }


   public List<BlockPos> toWalkInto(BlockStateInterface var1) {
      if (this.toWalkIntoCached == null) {
         this.toWalkIntoCached = new ArrayList<>();
      }

      return this.toWalkIntoCached;
   }

   protected abstract Set<BetterBlockPos> calculateValidPositions();

   public List<BlockPos> toBreak(BlockStateInterface var1) {
      if (this.toBreakCached != null) {
         return this.toBreakCached;
      }

      List var2 = new ArrayList<>();

      for (BetterBlockPos sx : this.positionsToBreak) {
         if (!MovementHelper.canWalkThrough(var1, sx.x, sx.y, sx.z)) {
            var2.add(sx);
         }
      }

      this.toBreakCached = var2;
      return var2;
   }

   public Set<BetterBlockPos> getValidPositions() {
      if (this.validPositionsCached == null) {
         this.validPositionsCached = this.calculateValidPositions();
         Objects.requireNonNull(this.validPositionsCached);
      }

      return this.validPositionsCached;
   }

   protected Movement(IBaritone var1, BetterBlockPos var2, BetterBlockPos var3, BetterBlockPos[] var4) {
      this(var1, var2, var3, var4, null);
   }

   protected boolean safeToCancel(MovementState var1) {
      return true;
   }
}
