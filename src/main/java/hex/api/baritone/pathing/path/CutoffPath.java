// Original binary: hex/api/baritone/pathing/path/CutoffPath
package hex.api.baritone.pathing.path;

import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.movement.IMovement;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.utils.pathing.PathBase;
import java.util.Collections;
import java.util.List;

// $VF: Compiled from s
public class CutoffPath extends PathBase {
   private final List<BetterBlockPos> path;
   private final List<IMovement> movements;
   private final int numNodes;
   private final Goal goal;

   @Override
   public Goal getGoal() {
      return this.goal;
   }

   public CutoffPath(IPath var1, int var2) {
      this(var1, 0, var2);
   }

   @Override
   public List<BetterBlockPos> positions() {
      return Collections.unmodifiableList(this.path);
   }

   @Override
   public int getNumNodesConsidered() {
      return this.numNodes;
   }

   public CutoffPath(IPath var1, int var2, int var3) {
      this.path = var1.positions().subList(var2, var3 + 1);
      this.movements = var1.movements().subList(var2, var3);
      this.numNodes = var1.getNumNodesConsidered();
      this.goal = var1.getGoal();
      this.sanityCheck();
   }

   @Override
   public List<IMovement> movements() {
      return Collections.unmodifiableList(this.movements);
   }
}
