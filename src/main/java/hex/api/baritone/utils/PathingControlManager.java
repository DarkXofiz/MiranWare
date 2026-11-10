// Original binary: hex/api/baritone/utils/PathingControlManager
package hex.api.baritone.utils;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.event.listener.AbstractGameEventListener;
import hex.api.baritone.api.pathing.calc.IPathingControlManager;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.process.IBaritoneProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.pathing.path.PathExecutor;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public class PathingControlManager implements IPathingControlManager {
   private final Baritone baritone;
   private final HashSet<IBaritoneProcess> processes;
   private final List<IBaritoneProcess> active;
   private IBaritoneProcess inControlLastTick;
   private IBaritoneProcess inControlThisTick;
   private PathingCommand command;

   @Override
   public void registerProcess(IBaritoneProcess var1) {
      var1.onLostControl();
      this.processes.add(var1);
   }

   @Override
   public Optional<IBaritoneProcess> mostRecentInControl() {
      return Optional.ofNullable(this.inControlThisTick);
   }

   @Override
   public Optional<PathingCommand> mostRecentCommand() {
      return Optional.ofNullable(this.command);
   }

   public PathingControlManager(Baritone var1) {
      this.baritone = var1;
      this.processes = new HashSet<>();
      this.active = new ArrayList<>();
      var1.getGameEventHandler().registerEventListener(new AbstractGameEventListener()      // $VF: Compiled from s
 {
         @Override
         public void onTick(TickEvent var1) {
            if (var1.getType() == TickEvent.Type.IN) {
               PathingControlManager.this.postTick();
            }
         }
      });
   }

   private void postTick() {
      if (this.command != null) {
         PathingBehavior var1 = this.baritone.getPathingBehavior();
         switch (this.command.commandType) {
            case FORCE_REVALIDATE_GOAL_AND_PATH:
               if (this.command.goal == null || this.forceRevalidate(this.command.goal) || this.revalidateGoal(this.command.goal)) {
                  var1.softCancelIfSafe();
               }

               var1.secretInternalSetGoalAndPath(this.command);
               break;
            case REVALIDATE_GOAL_AND_PATH:
               if (Baritone.settings().cancelOnGoalInvalidation.value && (this.command.goal == null || this.revalidateGoal(this.command.goal))) {
                  var1.softCancelIfSafe();
               }

               var1.secretInternalSetGoalAndPath(this.command);
         }
      }
   }

   public boolean forceRevalidate(Goal var1) {
      PathExecutor var2 = this.baritone.getPathingBehavior().getCurrent();
      if (var2 != null) {
         return var1.isInGoal(var2.getPath().getDest()) ? false : !var1.equals(var2.getPath().getGoal());
      } else {
         return false;
      }
   }

   public PathingCommand executeProcesses() {
      for (IBaritoneProcess var2 : this.processes) {
         if (var2.isActive()) {
            if (!this.active.contains(var2)) {
               this.active.add(0, var2);
            }
         } else {
            this.active.remove(var2);
         }
      }

      this.active.sort(Comparator.comparingDouble(IBaritoneProcess::priority).reversed());
      var var4 = this.active.iterator();

      while (var4.hasNext()) {
         IBaritoneProcess sx = var4.next();
         PathingCommand sxx = sx.onTick(
            Objects.equals(sx, this.inControlLastTick) && this.baritone.getPathingBehavior().calcFailedLastTick(),
            this.baritone.getPathingBehavior().isSafeToCancel()
         );
         if (sxx == null) {
            if (sx.isActive()) {
               throw new IllegalStateException(sx.displayName() + " actively returned null PathingCommand");
            }
         } else if (sxx.commandType != PathingCommandType.DEFER) {
            this.inControlThisTick = sx;
            if (!sx.isTemporary()) {
               var4.forEachRemaining(IBaritoneProcess::onLostControl);
            }

            return sxx;
         }
      }

      return null;
   }

   public void preTick() {
      this.inControlLastTick = this.inControlThisTick;
      this.inControlThisTick = null;
      PathingBehavior var1 = this.baritone.getPathingBehavior();
      this.command = this.executeProcesses();
      if (this.command == null) {
         var1.cancelSegmentIfSafe();
         var1.secretInternalSetGoal(null);
      } else {
         if (!Objects.equals(this.inControlThisTick, this.inControlLastTick)
            && this.command.commandType != PathingCommandType.REQUEST_PAUSE
            && this.inControlLastTick != null
            && !this.inControlLastTick.isTemporary()) {
            var1.cancelSegmentIfSafe();
         }

         switch (this.command.commandType) {
            case SET_GOAL_AND_PAUSE:
               var1.secretInternalSetGoalAndPath(this.command);
            case REQUEST_PAUSE:
               var1.requestPause();
               break;
            case CANCEL_AND_SET_GOAL:
               var1.secretInternalSetGoal(this.command.goal);
               var1.cancelSegmentIfSafe();
               break;
            case FORCE_REVALIDATE_GOAL_AND_PATH:
            case REVALIDATE_GOAL_AND_PATH:
               if (!var1.isPathing() && !var1.getInProgress().isPresent()) {
                  var1.secretInternalSetGoalAndPath(this.command);
               }
               break;
            case SET_GOAL_AND_PATH:
               if (this.command.goal != null) {
                  var1.secretInternalSetGoalAndPath(this.command);
               }
               break;
            default:
               throw new IllegalStateException("Unexpected command type " + this.command.commandType);
         }
      }
   }

   public void cancelEverything() {
      this.inControlLastTick = null;
      this.inControlThisTick = null;
      this.command = null;
      this.active.clear();

      for (IBaritoneProcess var2 : this.processes) {
         var2.onLostControl();
         if (var2.isActive() && !var2.isTemporary()) {
            throw new IllegalStateException(var2.displayName() + " stayed active after being cancelled");
         }
      }
   }

   public boolean revalidateGoal(Goal var1) {
      PathExecutor var2 = this.baritone.getPathingBehavior().getCurrent();
      if (var2 != null) {
         Goal sx = var2.getPath().getGoal();
         BlockPos sxx = var2.getPath().getDest();
         if (sx.isInGoal(sxx) && !var1.isInGoal(sxx)) {
            return true;
         }
      }

      return false;
   }
}
