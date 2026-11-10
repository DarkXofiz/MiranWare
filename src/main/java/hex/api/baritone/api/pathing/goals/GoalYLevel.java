// Original binary: hex/api/baritone/api/pathing/goals/GoalYLevel
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.pathing.movement.ActionCosts;
import hex.api.baritone.api.utils.SettingsUtil;

// $VF: Compiled from s
public class GoalYLevel implements ActionCosts, Goal {
   public final int level;
   private static final double бПЯ = 1.0;
   private static final int бПХ = 0;
   private static final String бПШ = "бПШ";

   public GoalYLevel(int var1) {
      this.level = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalYLevel var2 = (GoalYLevel)var1;
         return this.level == var2.level;
      } else {
         return false;
      }
   }

   public static double calculate(int var0, int var1) {
      if (var1 > var0) {
         return FALL_N_BLOCKS_COST[2] / бПЯ * (var1 - var0);
      } else {
         return var1 < var0 ? (var0 - var1) * JUMP_ONE_BLOCK_COST : 0.0;
      }
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return var2 == this.level;
   }

   @Override
   public int hashCode() {
      return this.level * бПХ;
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      return calculate(this.level, var2);
   }


   @Override
   public String toString() {
      return String.format(бПШ, SettingsUtil.maybeCensor(this.level));
   }
}
