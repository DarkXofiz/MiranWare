// Original binary: hex/api/baritone/api/pathing/calc/IPathFinder
package hex.api.baritone.api.pathing.calc;

import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.utils.PathCalculationResult;
import java.util.Optional;

// $VF: Compiled from s
public interface IPathFinder {
   Goal getGoal();

   Optional<IPath> bestPathSoFar();

   PathCalculationResult calculate(long var1, long var3);

   Optional<IPath> pathToMostRecentNodeConsidered();

   boolean isFinished();
}
