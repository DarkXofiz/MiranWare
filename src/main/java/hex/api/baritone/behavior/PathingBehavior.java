// Original binary: hex/api/baritone/behavior/PathingBehavior
package hex.api.baritone.behavior;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.behavior.IPathingBehavior;
import hex.api.baritone.api.event.events.PathEvent;
import hex.api.baritone.api.event.events.PlayerUpdateEvent;
import hex.api.baritone.api.event.events.RenderEvent;
import hex.api.baritone.api.event.events.SprintStateEvent;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.PathCalculationResult;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import hex.api.baritone.pathing.calc.AStarPathFinder;
import hex.api.baritone.pathing.calc.AbstractNodeCostSearch;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.pathing.path.PathExecutor;
import hex.api.baritone.utils.PathRenderer;
import hex.api.baritone.utils.PathingCommandContext;
import hex.api.baritone.utils.pathing.Favoring;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public final class PathingBehavior extends Behavior implements IPathingBehavior, Helper {
   private PathExecutor current;
   private PathExecutor next;
   private Goal goal;
   private CalculationContext context;
   private int ticksElapsedSoFar;
   private BetterBlockPos startPosition;
   private boolean safeToCancel;
   private boolean pauseRequestedLastTick;
   private boolean unpausedLastTick;
   private boolean pausedThisTick;
   private boolean cancelRequested;
   private boolean calcFailedLastTick;
   private volatile AbstractNodeCostSearch inProgress;
   private final Object pathCalcLock = new Object();
   private final Object pathPlanLock = new Object();
   private boolean lastAutoJump;
   private BetterBlockPos expectedSegmentStart;
   private final LinkedBlockingQueue<PathEvent> toDispatch = new LinkedBlockingQueue<>();
   private static final String field00009 = "field00009";
   private static final String field00010 = "field00010";
   private static final String field00011 = "field00011";
   private static final String field00012 = "field00012";
   private static final String field00013 = "field00013";
   private static final double field00014 = 0;
   private static final double field00015 = 0;
   private static final double field00016 = 0;
   private static final double field00017 = 0;
   private static final String field00018 = "field00018";
   private static final String field00019 = "field00019";
   private static final String field00020 = "field00020";
   private static final String field00021 = "field00021";
   private static final String field00022 = "field00022";
   private static final String field00023 = "field00023";
   private static final String field00024 = "field00024";
   private static final double field00025 = 0;
   private static final double field00026 = 0;
   private static final double field00027 = 0;
   private static final double field00028 = 0;

   public void softCancelIfSafe() {
      synchronized (this.pathPlanLock) {
         this.getInProgress().ifPresent(AbstractNodeCostSearch::cancel);
         if (!this.isSafeToCancel()) {
            return;
         }

         this.current = null;
         this.next = null;
      }

      this.cancelRequested = true;
   }

   public boolean calcFailedLastTick() {
      return this.calcFailedLastTick;
   }

   public void secretInternalSegmentCancel() {
      this.queuePathEvent(PathEvent.CANCELED);
      synchronized (this.pathPlanLock) {
         this.getInProgress().ifPresent(AbstractNodeCostSearch::cancel);
         if (this.current != null) {
            this.current = null;
            this.next = null;
            this.baritone.getInputOverrideHandler().clearAllKeys();
            this.baritone.getInputOverrideHandler().getBlockBreakHelper().stopBreakingBlock();
         }
      }
   }

   public void secretInternalSetGoal(Goal var1) {
      this.goal = var1;
   }

   private void resetEstimatedTicksToGoal(BetterBlockPos var1) {
      this.ticksElapsedSoFar = 0;
      this.startPosition = var1;
   }

   @Override
   public void onTick(TickEvent var1) {
      this.dispatchEvents();
      if (var1.getType() == TickEvent.Type.OUT) {
         this.secretInternalSegmentCancel();
         this.baritone.getPathingControlManager().cancelEverything();
      } else {
         this.expectedSegmentStart = this.pathStart();
         this.baritone.getPathingControlManager().preTick();
         this.tickPath();
         this.ticksElapsedSoFar++;
         this.dispatchEvents();
      }
   }

   public BetterBlockPos pathStart() {
      BetterBlockPos var1 = this.ctx.playerFeet();
      if (!MovementHelper.canWalkOn(this.ctx, var1.below())) {
         if (this.ctx.player().onGround()) {
            double sx = this.ctx.player().position().x;
            double sxx = this.ctx.player().position().z;
            ArrayList<BetterBlockPos> sxxx = new ArrayList<>();

            for (int sxxxx = -1; sxxxx <= 1; sxxxx++) {
               for (int sxxxxx = -1; sxxxxx <= 1; sxxxxx++) {
                  sxxx.add(new BetterBlockPos(var1.x + sxxxx, var1.y, var1.z + sxxxxx));
               }
            }

            sxxx.sort(
               Comparator.comparingDouble(
                  var4x -> (var4x.x + field00025 - sx) * (var4x.x + field00026 - sx) + (var4x.z + field00027 - sxx) * (var4x.z + field00028 - sxx)
               )
            );

            for (int sxxxx = 0; sxxxx < 4; sxxxx++) {
               BetterBlockPos sxxxxx = sxxx.get(sxxxx);
               double sxxxxxx = Math.abs(sxxxxx.x + field00014 - sx);
               double sxxxxxxx = Math.abs(sxxxxx.z + field00015 - sxx);
               if ((!(sxxxxxx > field00016) || !(sxxxxxxx > field00017))
                  && MovementHelper.canWalkOn(this.ctx, sxxxxx.below())
                  && MovementHelper.canWalkThrough(this.ctx, sxxxxx)
                  && MovementHelper.canWalkThrough(this.ctx, sxxxxx.above())) {
                  return sxxxxx;
               }
            }
         } else if (MovementHelper.canWalkOn(this.ctx, var1.below().below())) {
            return var1.below();
         }
      }

      return var1;
   }

   private void resetEstimatedTicksToGoal() {
      this.resetEstimatedTicksToGoal(this.expectedSegmentStart);
   }

   @Override
   public boolean cancelEverything() {
      boolean var1 = this.isSafeToCancel();
      if (var1) {
         this.secretInternalSegmentCancel();
      }

      this.baritone.getPathingControlManager().cancelEverything();
      return var1;
   }

   public boolean isSafeToCancel() {
      return this.current != null ? this.safeToCancel : !this.baritone.getElytraProcess().isActive() || this.baritone.getElytraProcess().isSafeToCancel();
   }

   public CalculationContext secretInternalGetCalculationContext() {
      return this.context;
   }

   @Override
   public void onPlayerSprintState(SprintStateEvent var1) {
      if (this.isPathing()) {
         var1.setState(this.current.isSprinting());
      }
   }

   private void tickPath() {
      this.pausedThisTick = false;
      if (this.pauseRequestedLastTick && this.safeToCancel) {
         this.pauseRequestedLastTick = false;
         if (this.unpausedLastTick) {
            this.baritone.getInputOverrideHandler().clearAllKeys();
            this.baritone.getInputOverrideHandler().getBlockBreakHelper().stopBreakingBlock();
         }

         this.unpausedLastTick = false;
         this.pausedThisTick = true;
      } else {
         this.unpausedLastTick = true;
         if (this.cancelRequested) {
            this.cancelRequested = false;
            this.baritone.getInputOverrideHandler().clearAllKeys();
         }

         synchronized (this.pathPlanLock) {
            synchronized (this.pathCalcLock) {
               if (this.inProgress != null) {
                  BetterBlockPos var3 = this.inProgress.getStart();
                  Optional<IPath> sx = this.inProgress.bestPathSoFar();
                  if ((this.current == null || !this.current.getPath().getDest().equals(var3))
                     && !var3.equals(this.ctx.playerFeet())
                     && !var3.equals(this.expectedSegmentStart)
                     && (!sx.isPresent() || !sx.get().positions().contains(this.ctx.playerFeet()) && !sx.get().positions().contains(this.expectedSegmentStart))
                     )
                   {
                     this.inProgress.cancel();
                  }
               }
            }

            if (this.current != null) {
               this.safeToCancel = this.current.onTick();
               if (this.current.failed() || this.current.finished()) {
                  this.current = null;
                  if (this.goal != null && !this.goal.isInGoal(this.ctx.playerFeet())) {
                     if (this.next != null
                        && !this.next.getPath().positions().contains(this.ctx.playerFeet())
                        && !this.next.getPath().positions().contains(this.expectedSegmentStart)) {
                        this.logDebug(field00010);
                        this.queuePathEvent(PathEvent.DISCARD_NEXT);
                        this.next = null;
                     }

                     if (this.next != null) {
                        this.logDebug(field00011);
                        this.queuePathEvent(PathEvent.CONTINUING_ONTO_PLANNED_NEXT);
                        this.current = this.next;
                        this.next = null;
                        this.current.onTick();
                     } else {
                        synchronized (this.pathCalcLock) {
                           if (this.inProgress != null) {
                              this.queuePathEvent(PathEvent.PATH_FINISHED_NEXT_STILL_CALCULATING);
                              return;
                           }

                           this.queuePathEvent(PathEvent.CALC_STARTED);
                           this.findPathInNewThread(this.expectedSegmentStart, true, this.context);
                        }
                     }
                  } else {
                     this.logDebug("All done. At " + this.goal);
                     this.queuePathEvent(PathEvent.AT_GOAL);
                     this.next = null;
                     if (Baritone.settings().disconnectOnArrival.value && this.ctx.world() instanceof ClientLevel var14) {
                        var14.disconnect(Component.literal(field00009));
                     }
                  }
               } else if (this.safeToCancel && this.next != null && this.next.snipsnapifpossible()) {
                  this.logDebug(field00012);
                  this.queuePathEvent(PathEvent.SPLICING_ONTO_NEXT_EARLY);
                  this.current = this.next;
                  this.next = null;
                  this.current.onTick();
               } else {
                  if (Baritone.settings().splicePath.value) {
                     this.current = this.current.trySplice(this.next);
                  }

                  if (this.next != null && this.current.getPath().getDest().equals(this.next.getPath().getDest())) {
                     this.next = null;
                  }

                  synchronized (this.pathCalcLock) {
                     if (this.inProgress != null) {
                        return;
                     }

                     if (this.next != null) {
                        return;
                     }

                     if (this.goal == null || this.goal.isInGoal(this.current.getPath().getDest())) {
                        return;
                     }

                     if (this.ticksRemainingInSegment(false).get() < Baritone.settings().planningTickLookahead.value.intValue()) {
                        this.logDebug(field00013);
                        this.queuePathEvent(PathEvent.NEXT_SEGMENT_CALC_STARTED);
                        this.findPathInNewThread(this.current.getPath().getDest(), false, this.context);
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   public Goal getGoal() {
      return this.goal;
   }

   @Override
   public void onPlayerUpdate(PlayerUpdateEvent var1) {
      if (this.current != null) {
         switch (var1.getState()) {
            case PRE:
               this.lastAutoJump = this.ctx.minecraft().options.autoJump().get();
               this.ctx.minecraft().options.autoJump().set(false);
               break;
            case POST:
               this.ctx.minecraft().options.autoJump().set(this.lastAutoJump);
         }
      }
   }

   public PathExecutor getCurrent() {
      return this.current;
   }

   private AbstractNodeCostSearch createPathfinder(BlockPos var1, Goal var2, IPath var3, CalculationContext var4) {
      Goal var5 = var2;
      if (Baritone.settings().simplifyUnloadedYCoord.value && var2 instanceof IGoalRenderPos) {
         BlockPos sx = ((IGoalRenderPos)var2).getGoalPos();
         if (!var4.bsi.worldContainsLoadedChunk(sx.getX(), sx.getZ())) {
            var5 = new GoalXZ(sx.getX(), sx.getZ());
         }
      }

      Favoring sx = new Favoring(var4.getBaritone().getPlayerContext(), var3, var4);
      BetterBlockPos sxx = this.ctx.playerFeet();
      BetterBlockPos sxxx = new BetterBlockPos(var1);
      BlockPos sxxxx = sxx.subtract(sxxx);
      if (sxx.getY() == sxxx.getY() && Math.abs(sxxxx.getX()) <= 1 && Math.abs(sxxxx.getZ()) <= 1) {
         sxxx = sxx;
      }

      return new AStarPathFinder(sxxx, var1.getX(), var1.getY(), var1.getZ(), var5, sx, var4);
   }

   @Override
   public void onRenderPass(RenderEvent var1) {
      PathRenderer.render(var1, this);
   }

   private void findPathInNewThread(BlockPos var1, boolean var2, CalculationContext var3) {
      if (!Thread.holdsLock(this.pathCalcLock)) {
         throw new IllegalStateException(field00018);
      }

      if (this.inProgress != null) {
         throw new IllegalStateException(field00019);
      }

      if (!var3.safeForThreadedUse) {
         throw new IllegalStateException(field00020);
      }

      Goal var4 = this.goal;
      if (var4 == null) {
         this.logDebug(field00021);
      } else {
         long sx;
         long sxx;
         if (this.current == null) {
            sx = Baritone.settings().primaryTimeoutMS.value;
            sxx = Baritone.settings().failureTimeoutMS.value;
         } else {
            sx = Baritone.settings().planAheadPrimaryTimeoutMS.value;
            sxx = Baritone.settings().planAheadFailureTimeoutMS.value;
         }

         AbstractNodeCostSearch sxxx = this.createPathfinder(var1, var4, this.current == null ? null : this.current.getPath(), var3);
         if (!Objects.equals(sxxx.getGoal(), var4)) {
            this.logDebug("Simplifying " + var4.getClass() + " to GoalXZ due to distance");
         }

         this.inProgress = sxxx;
         Baritone.getExecutor()
            .execute(
               () -> {
                  if (var2) {
                     this.logDebug("Starting to search for path from " + var1 + " to " + var4);
                  }

                  PathCalculationResult sxxxx = sxxx.calculate(sx, sxx);
                  synchronized (this.pathPlanLock) {
                     Optional<PathExecutor> exec = sxxxx.getPath().map(var1x -> new PathExecutor(this, var1x));
                     if (this.current == null) {
                        if (exec.isPresent()) {
                           if (exec.get().getPath().positions().contains(this.expectedSegmentStart)) {
                              this.queuePathEvent(PathEvent.CALC_FINISHED_NOW_EXECUTING);
                              this.current = exec.get();
                              this.resetEstimatedTicksToGoal(var1);
                           } else {
                              this.logDebug(field00022);
                           }
                        } else if (sxxxx.getType() != PathCalculationResult.Type.CANCELLATION && sxxxx.getType() != PathCalculationResult.Type.EXCEPTION) {
                           this.queuePathEvent(PathEvent.CALC_FAILED);
                        }
                     } else if (this.next == null) {
                        if (exec.isPresent()) {
                           if (exec.get().getPath().getSrc().equals(this.current.getPath().getDest())) {
                              this.queuePathEvent(PathEvent.NEXT_SEGMENT_CALC_FINISHED);
                              this.next = exec.get();
                           } else {
                              this.logDebug(field00023);
                           }
                        } else {
                           this.queuePathEvent(PathEvent.NEXT_CALC_FAILED);
                        }
                     } else {
                        this.logDirect(field00024);
                     }

                     if (var2 && this.current != null && this.current.getPath() != null) {
                        if (var4.isInGoal(this.current.getPath().getDest())) {
                           this.logDebug(
                              "Finished finding a path from "
                                 + var1
                                 + " to "
                                 + var4
                                 + ". "
                                 + this.current.getPath().getNumNodesConsidered()
                                 + " nodes considered"
                           );
                        } else {
                           this.logDebug(
                              "Found path segment from "
                                 + var1
                                 + " towards "
                                 + var4
                                 + ". "
                                 + this.current.getPath().getNumNodesConsidered()
                                 + " nodes considered"
                           );
                        }
                     }

                     synchronized (this.pathCalcLock) {
                        this.inProgress = null;
                     }
                  }
               }
            );
      }
   }

   public boolean secretInternalSetGoalAndPath(PathingCommand var1) {
      this.secretInternalSetGoal(var1.goal);
      if (var1 instanceof PathingCommandContext) {
         this.context = ((PathingCommandContext)var1).desiredCalcContext;
      } else {
         this.context = new CalculationContext(this.baritone, true);
      }

      if (this.goal == null) {
         return false;
      }

      if (this.goal.isInGoal(this.ctx.playerFeet())) {
         return false;
      }

      synchronized (this.pathPlanLock) {
         if (this.current != null) {
            return false;
         }

         boolean var10000;
         synchronized (this.pathCalcLock) {
            if (this.inProgress != null) {
               return false;
            }

            this.queuePathEvent(PathEvent.CALC_STARTED);
            this.findPathInNewThread(this.expectedSegmentStart, true, this.context);
            var10000 = true;
         }

         return var10000;
      }
   }

   public void requestPause() {
      this.pauseRequestedLastTick = true;
   }

   @Override
   public Optional<AbstractNodeCostSearch> getInProgress() {
      return Optional.ofNullable(this.inProgress);
   }

   public PathingBehavior(Baritone var1) {
      super(var1);
   }

   @Override
   public void forceCancel() {
      this.cancelEverything();
      this.secretInternalSegmentCancel();
      synchronized (this.pathCalcLock) {
         this.inProgress = null;
      }
   }

   public PathExecutor getNext() {
      return this.next;
   }

   private void dispatchEvents() {
      ArrayList<PathEvent> var1 = new ArrayList<>();
      this.toDispatch.drainTo(var1);
      this.calcFailedLastTick = var1.contains(PathEvent.CALC_FAILED);

      for (PathEvent sx : var1) {
         this.baritone.getGameEventHandler().onPathEvent(sx);
      }
   }

   @Override
   public Optional<Double> estimatedTicksToGoal() {
      BetterBlockPos var1 = this.ctx.playerFeet();
      if (this.goal != null && var1 != null && this.startPosition != null) {
         if (this.goal.isInGoal(this.ctx.playerFeet())) {
            this.resetEstimatedTicksToGoal();
            return Optional.of(0.0);
         }

         if (this.ticksElapsedSoFar == 0) {
            return Optional.empty();
         }

         double sx = this.goal.heuristic(var1.x, var1.y, var1.z);
         double sxx = this.goal.heuristic(this.startPosition.x, this.startPosition.y, this.startPosition.z);
         if (sx == sxx) {
            return Optional.empty();
         }

         double sxxx = Math.abs(sx - this.goal.heuristic()) * this.ticksElapsedSoFar / Math.abs(sxx - sx);
         return Optional.of(sxxx);
      } else {
         return Optional.empty();
      }
   }

   private void queuePathEvent(PathEvent var1) {
      this.toDispatch.add(var1);
   }


   private void resetEstimatedTicksToGoal(BlockPos var1) {
      this.resetEstimatedTicksToGoal(new BetterBlockPos(var1));
   }

   public boolean cancelSegmentIfSafe() {
      if (this.isSafeToCancel()) {
         this.secretInternalSegmentCancel();
         return true;
      } else {
         return false;
      }
   }

   @Override
   public boolean isPathing() {
      return this.hasPath() && !this.pausedThisTick;
   }
}
