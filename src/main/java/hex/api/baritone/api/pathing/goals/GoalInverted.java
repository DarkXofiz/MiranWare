// Original binary: hex/api/baritone/api/pathing/goals/GoalInverted
package hex.api.baritone.api.pathing.goals;

import java.util.Objects;

// $VF: Compiled from s
public class GoalInverted implements Goal {
   public final Goal origin;
   private static final int аа = 0;
   private static final String а7 = "а7";

   @Override
   public int hashCode() {
      return this.origin.hashCode() * аа;
   }


   public GoalInverted(Goal var1) {
      this.origin = var1;
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return false;
   }

   @Override
   public String toString() {
      return String.format(а7, this.origin.toString());
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      return -this.origin.heuristic(var1, var2, var3);
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalInverted var2 = (GoalInverted)var1;
         return Objects.equals(this.origin, var2.origin);
      } else {
         return false;
      }
   }

   @Override
   public double heuristic() {
      return Double.NEGATIVE_INFINITY;
   }
}
