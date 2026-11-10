// Original binary: hex/api/baritone/pathing/calc/PathNode
package hex.api.baritone.pathing.calc;

import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;

// $VF: Compiled from s
public final class PathNode {
   public final int x;
   public final int y;
   public final int z;
   public final double estimatedCostToGoal;
   public double cost;
   public double combinedCost;
   public PathNode previous = null;
   public int heapPosition;
   private static final double 诶хШ = 0;
   private static final String 诶ха = "诶ха";


   @Override
   public int hashCode() {
      return (int)BetterBlockPos.longHash(this.x, this.y, this.z);
   }

   public boolean isOpen() {
      return this.heapPosition != -1;
   }

   @Override
   public boolean equals(Object var1) {
      PathNode var2 = (PathNode)var1;
      return this.x == var2.x && this.y == var2.y && this.z == var2.z;
   }

   public PathNode(int var1, int var2, int var3, Goal var4) {
      this.cost = 诶хШ;
      this.estimatedCostToGoal = var4.heuristic(var1, var2, var3);
      if (Double.isNaN(this.estimatedCostToGoal)) {
         throw new IllegalStateException(
            String.format(诶ха, var4, SettingsUtil.maybeCensor(var1), SettingsUtil.maybeCensor(var2), SettingsUtil.maybeCensor(var3))
         );
      }

      this.heapPosition = -1;
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }
}
