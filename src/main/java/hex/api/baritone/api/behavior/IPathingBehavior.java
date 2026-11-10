// Original binary: hex/api/baritone/api/behavior/IPathingBehavior
package hex.api.baritone.api.behavior;

import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.calc.IPathFinder;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.path.IPathExecutor;
import java.util.Optional;

// $VF: Compiled from s
public interface IPathingBehavior extends IBehavior {
   default Optional<IPath> getPath() {
      return Optional.ofNullable(this.getCurrent()).map(IPathExecutor::getPath);
   }

   default Optional<Double> ticksRemainingInSegment(boolean var1) {
      IPathExecutor var2 = this.getCurrent();
      if (var2 == null) {
         return Optional.empty();
      }

      int sx = var1 ? var2.getPosition() : var2.getPosition() + 1;
      return Optional.of(var2.getPath().ticksRemainingFrom(sx));
   }

   default Optional<Double> ticksRemainingInSegment() {
      return this.ticksRemainingInSegment(true);
   }

   Goal getGoal();

   IPathExecutor getCurrent();

   Optional<? extends IPathFinder> getInProgress();

   default boolean hasPath() {
      return this.getCurrent() != null;
   }

   Optional<Double> estimatedTicksToGoal();

   boolean isPathing();

   boolean cancelEverything();

   IPathExecutor getNext();

   void forceCancel();
}
