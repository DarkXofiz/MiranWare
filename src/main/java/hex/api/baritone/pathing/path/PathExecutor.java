// Original binary: hex/api/baritone/pathing/path/PathExecutor
package hex.api.baritone.pathing.path;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.movement.IMovement;
import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.pathing.path.IPathExecutor;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.Tuple;
import hex.api.baritone.api.utils.VecUtils;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.pathing.calc.AbstractNodeCostSearch;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.movement.movements.MovementAscend;
import hex.api.baritone.pathing.movement.movements.MovementDescend;
import hex.api.baritone.pathing.movement.movements.MovementDiagonal;
import hex.api.baritone.pathing.movement.movements.MovementFall;
import hex.api.baritone.pathing.movement.movements.MovementParkour;
import hex.api.baritone.pathing.movement.movements.MovementTraverse;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.player.BotBaritonePlayerContext;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class PathExecutor implements Helper, IPathExecutor {
   private static final double MAX_MAX_DIST_FROM_PATH = 3.0;
   private static final double MAX_DIST_FROM_PATH = 2.0;
   private static final double MAX_TICKS_AWAY = 200.0;
   private final IPath path;
   private int pathPosition;
   private int ticksAway;
   private int ticksOnCurrent;
   private Double currentMovementOriginalCostEstimate;
   private Integer costEstimateIndex;
   private boolean failed;
   private boolean recalcBP = true;
   private HashSet<BlockPos> toBreak = new HashSet<>();
   private HashSet<BlockPos> toPlace = new HashSet<>();
   private HashSet<BlockPos> toWalkInto = new HashSet<>();
   private final PathingBehavior behavior;
   private final IPlayerContext ctx;
   private boolean sprintNextTick;
   private boolean sprintUnsafe;
   private static final double SPRINT_ASCEND_SIDE_TOLERANCE = 0.2;
   private static final double АЭ7 = 0;
   private static final double АЭУ = 0;
   private static final String АЭ0 = "АЭ0";
   private static final double АЭГ = 0;
   private static final String АЭф = "АЭф";
   private static final String АЭЕ = "АЭЕ";
   private static final double АЭч = 0;
   private static final String АЭ衣 = "АЭ衣";
   private static final double АЭц = 0;
   private static final String АЭМ = "АЭМ";
   private static final String АЭ5 = "АЭ5";
   private static final double АЭЖ = 0;
   private static final double АЭо = 0;
   private static final double АЭК = 0;
   private static final String АЭЭ = "АЭЭ";
   private static final String АЭЪ = "АЭЪ";
   private static final String АЭЧ = "АЭЧ";
   private static final String АЭЩ = "АЭЩ";
   private static final double АЭм = 0;
   private static final String АЭФ = "АЭФ";
   private static final double АЭ3 = 0;
   private static final double АЭЬ = 0;
   private static final double АЭ1 = 0;
   private static final double АЭя = 0;
   private static final double АЭI = 0;
   private static final double АЭы = 0;
   private static final double АЭу = 0;
   private static final double АЭг = 0;
   private static final double АЭю = 0;
   private static final String АЭ4 = "АЭ4";
   private static final String АЭС = "АЭС";
   private static final String АЭъ = "АЭъ";

   public boolean finished() {
      return this.pathPosition >= this.path.length();
   }

   private static boolean canSprintFromDescendInto(IPlayerContext var0, IMovement var1, IMovement var2) {
      if (var2 instanceof MovementDescend && var2.getDirection().equals(var1.getDirection())) {
         return true;
      } else if (!MovementHelper.canWalkOn(var0, var1.getDest().offset(var1.getDirection()))) {
         return false;
      } else {
         return var2 instanceof MovementTraverse && var2.getDirection().equals(var1.getDirection())
            ? true
            : var2 instanceof MovementDiagonal && Baritone.settings().allowOvershootDiagonalDescend.value;
      }
   }

   public boolean onTick() {
      if (this.pathPosition == this.path.length() - 1) {
         this.pathPosition++;
      }

      if (this.pathPosition >= this.path.length()) {
         return true;
      }

      Movement var1 = (Movement)this.path.movements().get(this.pathPosition);
      BetterBlockPos sx = this.ctx.playerFeet();
      if (!var1.getValidPositions().contains(sx)) {
         for (int sxx = 0; sxx < this.pathPosition && sxx < this.path.length(); sxx++) {
            if (((Movement)this.path.movements().get(sxx)).getValidPositions().contains(sx)) {
               int sxxx = this.pathPosition;
               this.pathPosition = sxx;

               for (int sxxxx = this.pathPosition; sxxxx <= sxxx; sxxxx++) {
                  this.path.movements().get(sxxxx).reset();
               }

               this.onChangeInPathPosition();
               this.onTick();
               return false;
            }
         }

         for (int sxx = this.pathPosition + 3; sxx < this.path.length() - 1; sxx++) {
            if (((Movement)this.path.movements().get(sxx)).getValidPositions().contains(sx)) {
               if (sxx - this.pathPosition > 2) {
                  this.logDebug("Skipping forward " + (sxx - this.pathPosition) + " steps, to " + sxx);
               }

               this.pathPosition = sxx - 1;
               this.onChangeInPathPosition();
               this.onTick();
               return false;
            }
         }
      }

      var sxx = this.closestPathPos(this.path);
      if (this.possiblyOffPath(sxx, АЭ7)) {
         this.ticksAway++;
         if (this.ticksAway > АЭУ) {
            this.logDebug(АЭ0);
            this.cancel();
            return false;
         }
      } else {
         this.ticksAway = 0;
      }

      if (this.possiblyOffPath(sxx, АЭГ)) {
         this.logDebug(АЭф);
         this.cancel();
         return false;
      }

      BlockStateInterface sxxx = new BlockStateInterface(this.ctx);

      for (int sxxxx = this.pathPosition - 10; sxxxx < this.pathPosition + 10; sxxxx++) {
         if (sxxxx >= 0 && sxxxx < this.path.movements().size()) {
            Movement sxxxxx = (Movement)this.path.movements().get(sxxxx);
            var sxxxxxx = sxxxxx.toBreak(sxxx);
            var sxxxxxxx = sxxxxx.toPlace(sxxx);
            var sxxxxxxxx = sxxxxx.toWalkInto(sxxx);
            sxxxxx.resetBlockCache();
            if (!sxxxxxx.equals(sxxxxx.toBreak(sxxx))) {
               this.recalcBP = true;
            }

            if (!sxxxxxxx.equals(sxxxxx.toPlace(sxxx))) {
               this.recalcBP = true;
            }

            if (!sxxxxxxxx.equals(sxxxxx.toWalkInto(sxxx))) {
               this.recalcBP = true;
            }
         }
      }

      if (this.recalcBP) {
         HashSet sxxxx = new HashSet<>();
         HashSet sxxxxx = new HashSet<>();
         HashSet sxxxxxx = new HashSet<>();

         for (int sxxxxxxx = this.pathPosition; sxxxxxxx < this.path.movements().size(); sxxxxxxx++) {
            Movement sxxxxxxxx = (Movement)this.path.movements().get(sxxxxxxx);
            sxxxx.addAll(sxxxxxxxx.toBreak(sxxx));
            sxxxxx.addAll(sxxxxxxxx.toPlace(sxxx));
            sxxxxxx.addAll(sxxxxxxxx.toWalkInto(sxxx));
         }

         this.toBreak = sxxxx;
         this.toPlace = sxxxxx;
         this.toWalkInto = sxxxxxx;
         this.recalcBP = false;
      }

      if (this.pathPosition < this.path.movements().size() - 1) {
         IMovement sxxxx = this.path.movements().get(this.pathPosition + 1);
         if (!this.behavior.baritone.bsi().worldContainsLoadedChunk(sxxxx.getDest().x, sxxxx.getDest().z)) {
            this.logDebug(АЭЕ);
            this.clearKeys();
            return true;
         }
      }

      boolean sxxxx = var1.safeToCancel();
      if (this.costEstimateIndex == null || this.costEstimateIndex != this.pathPosition) {
         this.costEstimateIndex = this.pathPosition;
         this.currentMovementOriginalCostEstimate = var1.getCost();

         for (int sxxxxx = 1; sxxxxx < Baritone.settings().costVerificationLookahead.value && this.pathPosition + sxxxxx < this.path.length() - 1; sxxxxx++) {
            if (((Movement)this.path.movements().get(this.pathPosition + sxxxxx)).calculateCost(this.behavior.secretInternalGetCalculationContext()) >= АЭч
               && sxxxx) {
               this.logDebug(АЭ衣);
               this.cancel();
               return true;
            }
         }
      }

      double sxxxxx = var1.recalculateCost(this.behavior.secretInternalGetCalculationContext());
      if (sxxxxx >= АЭц && sxxxx) {
         this.logDebug(АЭМ);
         this.cancel();
         return true;
      }

      if (!var1.calculatedWhileLoaded() && sxxxxx - this.currentMovementOriginalCostEstimate > Baritone.settings().maxCostIncrease.value && sxxxx) {
         this.logDebug("Original cost " + this.currentMovementOriginalCostEstimate + " current cost " + sxxxxx + ". Cancelling.");
         this.cancel();
         return true;
      }

      if (this.shouldPause()) {
         this.logDebug(АЭ5);
         this.clearKeys();
         return true;
      }

      MovementStatus sxxxxxx = var1.update();
      if (sxxxxxx == MovementStatus.UNREACHABLE || sxxxxxx == MovementStatus.FAILED) {
         this.logDebug("Movement returns status " + sxxxxxx);
         this.cancel();
         return true;
      }

      if (sxxxxxx == MovementStatus.SUCCESS) {
         this.pathPosition++;
         this.onChangeInPathPosition();
         this.onTick();
         return true;
      }

      this.sprintNextTick = this.shouldSprintNextTick();
      this.behavior.baritone.getInputOverrideHandler().setForcedSprint(this.sprintNextTick);
      if (this.shouldJumpWhileTraversing(var1)) {
         this.behavior.baritone.getInputOverrideHandler().setInputForceState(Input.JUMP, true);
      }

      if (!this.sprintNextTick && this.sprintUnsafe) {
         this.ctx.player().setSprinting(false);
      }

      this.ticksOnCurrent++;
      if (this.ticksOnCurrent > this.currentMovementOriginalCostEstimate + Baritone.settings().movementTimeoutTicks.value.intValue()) {
         this.logDebug(
            "This movement has taken too long (" + this.ticksOnCurrent + " ticks, expected " + this.currentMovementOriginalCostEstimate + "). Cancelling."
         );
         this.cancel();
         return true;
      } else {
         return sxxxx;
      }
   }

   private void onChangeInPathPosition() {
      this.clearKeys();
      this.ticksOnCurrent = 0;
   }

   private boolean shouldPause() {
      var var1 = this.behavior.getInProgress();
      if (!var1.isPresent()) {
         return false;
      }

      if (!this.ctx.player().onGround()) {
         return false;
      }

      if (!MovementHelper.canWalkOn(this.ctx, this.ctx.playerFeet().below())) {
         return false;
      }

      if (!MovementHelper.canWalkThrough(this.ctx, this.ctx.playerFeet()) || !MovementHelper.canWalkThrough(this.ctx, this.ctx.playerFeet().above())) {
         return false;
      }

      if (!this.path.movements().get(this.pathPosition).safeToCancel()) {
         return false;
      }

      var sx = var1.get().bestPathSoFar();
      if (!sx.isPresent()) {
         return false;
      }

      var sxx = sx.get().positions();
      if (sxx.size() < 3) {
         return false;
      }

      sxx = sxx.subList(1, sxx.size());
      return sxx.contains(this.ctx.playerFeet());
   }

   public Set<BlockPos> toBreak() {
      return Collections.unmodifiableSet(this.toBreak);
   }


   private static boolean sprintableAscend(IPlayerContext var0, MovementTraverse var1, MovementAscend var2, IMovement var3) {
      if (!Baritone.settings().sprintAscends.value) {
         return false;
      }

      if (!var1.getDirection().equals(var2.getDirection().below())) {
         return false;
      }

      if (var3.getDirection().getX() == var2.getDirection().getX() && var3.getDirection().getZ() == var2.getDirection().getZ()) {
         if (!MovementHelper.canWalkOn(var0, var1.getDest().below())) {
            return false;
         }

         if (!MovementHelper.canWalkOn(var0, var2.getDest().below())) {
            return false;
         }

         if (!var2.toBreakCached.isEmpty()) {
            return false;
         }

         for (int var4 = 0; var4 < 2; var4++) {
            for (int sx = 0; sx < 3; sx++) {
               BlockPos sxx = var1.getSrc().above(sx);
               if (var4 == 1) {
                  sxx = sxx.offset(var1.getDirection());
               }

               if (!MovementHelper.fullyPassable(var0, sxx)) {
                  return false;
               }
            }
         }

         return MovementHelper.avoidWalkingInto(var0.world().getBlockState(var1.getSrc().above(3)))
            ? false
            : !MovementHelper.avoidWalkingInto(var0.world().getBlockState(var2.getDest().above(2)));
      } else {
         return false;
      }
   }

   public Set<BlockPos> toPlace() {
      return Collections.unmodifiableSet(this.toPlace);
   }

   public boolean isSprinting() {
      return this.sprintNextTick;
   }

   public PathExecutor trySplice(PathExecutor var1) {
      return var1 == null ? this.cutIfTooLong() : SplicedPath.trySplice(this.path, var1.path, false).map(var2 -> {
         if (!var2.getDest().equals(var1.getPath().getDest())) {
            throw new IllegalStateException(String.format(АЭъ, var2.getDest(), var1.getPath().getDest()));
         }

         PathExecutor var3 = new PathExecutor(this.behavior, var2);
         var3.pathPosition = this.pathPosition;
         var3.currentMovementOriginalCostEstimate = this.currentMovementOriginalCostEstimate;
         var3.costEstimateIndex = this.costEstimateIndex;
         var3.ticksOnCurrent = this.ticksOnCurrent;
         return var3;
      }).orElseGet(this::cutIfTooLong);
   }

   @Override
   public int getPosition() {
      return this.pathPosition;
   }

   public boolean isSprintUnsafe() {
      return this.sprintUnsafe;
   }

   private boolean possiblyOffPath(Tuple<Double, BlockPos> var1, double var2) {
      double var4 = var1.getA();
      if (var4 > var2) {
         if (this.path.movements().get(this.pathPosition) instanceof MovementFall) {
            BlockPos sx = this.path.positions().get(this.pathPosition + 1);
            return VecUtils.entityFlatDistanceToCenter(this.ctx.player(), sx) >= var2;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   private Tuple<Double, BlockPos> closestPathPos(IPath var1) {
      double var2 = АЭЖ;
      BlockPos sx = null;

      for (IMovement sxx : var1.movements()) {
         for (BlockPos sxxx : ((Movement)sxx).getValidPositions()) {
            double sxxxx = VecUtils.entityDistanceToCenter(this.ctx.player(), sxxx);
            if (sxxxx < var2 || var2 == АЭо) {
               var2 = sxxxx;
               sx = sxxx;
            }
         }
      }

      return new Tuple<>(var2, sx);
   }

   public Set<BlockPos> toWalkInto() {
      return Collections.unmodifiableSet(this.toWalkInto);
   }

   public boolean failed() {
      return this.failed;
   }

   private boolean shouldJumpWhileTraversing(IMovement var1) {
      if (var1 instanceof MovementTraverse
         && this.sprintNextTick
         && this.ctx.player().onGround()
         && !this.ctx.player().isPassenger()
         && !this.ctx.player().getAbilities().flying
         && !this.ctx.player().isInWater()
         && !this.ctx.player().isInLava()
         && !this.ctx.player().isCrouching()
         && !this.ctx.player().isUsingItem()) {
         boolean var2 = !MovementHelper.canWalkThrough(this.ctx, this.ctx.playerFeet().above(2));
         return !var2 && this.ctx.player().hasEffect(MobEffects.SPEED) ? false : this.hasStraightTraverseRunway(var1, var2 ? 2 : 3);
      } else {
         return false;
      }
   }

   private Tuple<Vec3, BlockPos> overrideFall(MovementFall var1) {
      Vec3i var2 = var1.getDirection();
      if (var2.getY() < -3) {
         return null;
      }

      if (!var1.toBreakCached.isEmpty()) {
         return null;
      }

      Vec3i sx = new Vec3i(var2.getX(), 0, var2.getZ());

      int sxx;
      label49:
      for (sxx = this.pathPosition + 1; sxx < this.path.length() - 1 && sxx < this.pathPosition + 3; sxx++) {
         IMovement sxxx = this.path.movements().get(sxx);
         if (!(sxxx instanceof MovementTraverse) || !sx.equals(sxxx.getDirection())) {
            break;
         }

         for (int sxxxx = sxxx.getDest().y; sxxxx <= var1.getSrc().y + 1; sxxxx++) {
            BlockPos sxxxxx = new BlockPos(sxxx.getDest().x, sxxxx, sxxx.getDest().z);
            if (!MovementHelper.fullyPassable(this.ctx, sxxxxx)) {
               break label49;
            }
         }

         if (!MovementHelper.canWalkOn(this.ctx, sxxx.getDest().below())) {
            break;
         }
      }

      if (--sxx == this.pathPosition) {
         return null;
      }

      double sxxx = sxx - this.pathPosition - АЭ3;
      return new Tuple<>(
         new Vec3(sx.getX() * sxxx + var1.getDest().x + АЭЬ, var1.getDest().y, sx.getZ() * sxxx + var1.getDest().z + АЭ1),
         var1.getDest().offset(sx.getX() * (sxx - this.pathPosition), 0, sx.getZ() * (sxx - this.pathPosition))
      );
   }

   private static boolean skipNow(IPlayerContext var0, IMovement var1) {
      double var2 = Math.abs(var1.getDirection().getX() * (var1.getSrc().z + АЭя - var0.player().position().z))
         + Math.abs(var1.getDirection().getZ() * (var1.getSrc().x + АЭI - var0.player().position().x));
      if (var2 > АЭы) {
         return false;
      }

      BlockPos sx = var1.getSrc().subtract(var1.getDirection()).above(2);
      if (MovementHelper.fullyPassable(var0, sx)) {
         return true;
      }

      double sxx = Math.abs(var1.getDirection().getX() * (sx.getX() + АЭу - var0.player().position().x))
         + Math.abs(var1.getDirection().getZ() * (sx.getZ() + АЭг - var0.player().position().z));
      return sxx > АЭю;
   }

   public boolean snipsnapifpossible() {
      if (!this.ctx.player().onGround() && this.ctx.world().getFluidState(this.ctx.playerFeet()).isEmpty()) {
         return false;
      }

      if (this.ctx.player().getDeltaMovement().y < АЭК) {
         return false;
      }

      int var1 = this.path.positions().indexOf(this.ctx.playerFeet());
      if (var1 == -1) {
         return false;
      }

      this.pathPosition = var1;
      this.clearKeys();
      return true;
   }

   private void clearKeys() {
      this.behavior.baritone.getInputOverrideHandler().clearAllKeys();
   }

   private PathExecutor cutIfTooLong() {
      if (this.pathPosition > Baritone.settings().maxPathHistoryLength.value) {
         int var1 = Baritone.settings().pathHistoryCutoffAmount.value;
         CutoffPath sx = new CutoffPath(this.path, var1, this.path.length() - 1);
         if (!sx.getDest().equals(this.path.getDest())) {
            throw new IllegalStateException(String.format(АЭ4, sx.getDest(), this.path.getDest()));
         }

         this.logDebug("Discarding earliest segment movements, length cut from " + this.path.length() + " to " + sx.length());
         PathExecutor sxx = new PathExecutor(this.behavior, sx);
         sxx.pathPosition = this.pathPosition - var1;
         sxx.currentMovementOriginalCostEstimate = this.currentMovementOriginalCostEstimate;
         if (this.costEstimateIndex != null) {
            sxx.costEstimateIndex = this.costEstimateIndex - var1;
         }

         sxx.ticksOnCurrent = this.ticksOnCurrent;
         return sxx;
      } else {
         return this;
      }
   }

   private void cancel() {
      this.clearKeys();
      this.behavior.baritone.getInputOverrideHandler().getBlockBreakHelper().stopBreakingBlock();
      this.pathPosition = this.path.length() + 3;
      this.failed = true;
   }

   private boolean shouldSprintNextTick() {
      this.sprintUnsafe = false;
      boolean var1 = this.behavior.baritone.getInputOverrideHandler().isInputForcedDown(Input.SPRINT);
      this.behavior.baritone.getInputOverrideHandler().setInputForceState(Input.SPRINT, false);
      if (!(new CalculationContext(this.behavior.baritone, false)).canSprint) {
         this.sprintUnsafe = true;
         return false;
      }

      IMovement sx = this.path.movements().get(this.pathPosition);
      if (sx instanceof MovementTraverse && this.pathPosition < this.path.length() - 3) {
         IMovement sxx = this.path.movements().get(this.pathPosition + 1);
         if (sxx instanceof MovementAscend
            && sprintableAscend(this.ctx, (MovementTraverse)sx, (MovementAscend)sxx, this.path.movements().get(this.pathPosition + 2))) {
            if (skipNow(this.ctx, sx)) {
               this.logDebug(АЭЭ);
               this.pathPosition++;
               this.onChangeInPathPosition();
               this.onTick();
               this.behavior.baritone.getInputOverrideHandler().setInputForceState(Input.JUMP, true);
               return true;
            }

            this.logDebug(АЭЪ);
         }
      }

      if (var1) {
         return true;
      }

      if (sx instanceof MovementDescend) {
         if (this.pathPosition < this.path.length() - 2) {
            IMovement sxx = this.path.movements().get(this.pathPosition + 1);
            if (MovementHelper.canUseFrostWalker(this.ctx, sxx.getDest().below()) && (sxx instanceof MovementTraverse || sxx instanceof MovementParkour)) {
               boolean sxxx = Baritone.settings().allowPlace.value
                  && this.behavior.baritone.getInventoryBehavior().hasGenericThrowaway()
                  && sxx instanceof MovementParkour;
               boolean sxxxx = !sx.getDirection().above().offset(sxx.getDirection()).equals(BlockPos.ZERO)
                  && sx.getDirection().above().cross(sxx.getDirection()).equals(BlockPos.ZERO);
               if (sxxxx && !sxxx) {
                  ((MovementDescend)sx).forceSafeMode();
               }
            }
         }

         if (((MovementDescend)sx).safeMode() && !((MovementDescend)sx).skipToAscend()) {
            this.logDebug(АЭЧ);
            this.sprintUnsafe = true;
            return false;
         }

         if (this.pathPosition < this.path.length() - 2) {
            IMovement sxx = this.path.movements().get(this.pathPosition + 1);
            if (sxx instanceof MovementAscend && sx.getDirection().above().equals(sxx.getDirection().below())) {
               this.pathPosition++;
               this.onChangeInPathPosition();
               this.onTick();
               this.logDebug(АЭЩ);
               return true;
            }

            if (canSprintFromDescendInto(this.ctx, sx, sxx)) {
               if (sxx instanceof MovementDescend && this.pathPosition < this.path.length() - 3) {
                  IMovement sxxx = this.path.movements().get(this.pathPosition + 2);
                  if (sxxx instanceof MovementDescend && !canSprintFromDescendInto(this.ctx, sxx, sxxx)) {
                     return false;
                  }
               }

               if (this.ctx.playerFeet().equals(sx.getDest())) {
                  this.pathPosition++;
                  this.onChangeInPathPosition();
                  this.onTick();
               }

               return true;
            }
         }
      }

      if (sx instanceof MovementAscend && this.pathPosition != 0) {
         IMovement sxx = this.path.movements().get(this.pathPosition - 1);
         if (sxx instanceof MovementDescend && sxx.getDirection().above().equals(sx.getDirection().below())) {
            BlockPos sxxx = sx.getSrc().above();
            if (this.ctx.player().position().y >= sxxx.getY() - АЭм) {
               this.behavior.baritone.getInputOverrideHandler().setInputForceState(Input.JUMP, false);
               return true;
            }
         }

         if (this.pathPosition < this.path.length() - 2
            && sxx instanceof MovementTraverse
            && sprintableAscend(this.ctx, (MovementTraverse)sxx, (MovementAscend)sx, this.path.movements().get(this.pathPosition + 1))) {
            return true;
         }
      }

      if (sx instanceof MovementFall) {
         var sxx = this.overrideFall((MovementFall)sx);
         if (sxx != null) {
            BetterBlockPos sxxx = new BetterBlockPos(sxx.getB());
            if (!this.path.positions().contains(sxxx)) {
               throw new IllegalStateException(String.format(АЭФ, sx.getSrc(), sxxx));
            }

            if (this.ctx.playerFeet().equals(sxxx)) {
               this.pathPosition = this.path.positions().indexOf(sxxx);
               this.onChangeInPathPosition();
               this.onTick();
               return true;
            }

            this.clearKeys();
            this.behavior
               .baritone
               .getLookBehavior()
               .updateTarget(RotationUtils.calcRotationFromVec3d(this.ctx.playerHead(), sxx.getA(), this.ctx.playerRotations()), false);
            this.behavior.baritone.getInputOverrideHandler().setInputForceState(Input.MOVE_FORWARD, true);
            return true;
         }
      }

      return false;
   }

   public PathExecutor(PathingBehavior var1, IPath var2) {
      this.behavior = var1;
      this.ctx = var1.ctx;
      this.path = var2;
      this.pathPosition = 0;
   }

   private boolean hasStraightTraverseRunway(IMovement var1, int var2) {
      if (this.pathPosition + var2 > this.path.movements().size()) {
         return false;
      }

      BlockPos var3 = var1.getDirection();

      for (int sx = this.pathPosition; sx < this.pathPosition + var2; sx++) {
         IMovement sxx = this.path.movements().get(sx);
         if (!(sxx instanceof MovementTraverse) || sxx.getSrc().getY() != sxx.getDest().getY() || !var3.equals(sxx.getDirection())) {
            return false;
         }
      }

      return true;
   }

   @Override
   public void logDebug(String var1) {
      if (this.behavior.baritone.getPlayerContext() instanceof BotBaritonePlayerContext var2) {
         var2.bot();
      } else {
         Helper.super.logDebug(var1);
      }
   }

   @Override
   public IPath getPath() {
      return this.path;
   }
}
