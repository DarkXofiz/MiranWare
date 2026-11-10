// Original binary: hex/api/baritone/api/pathing/goals/GoalAxis
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.BaritoneAPI;

// $VF: Compiled from s
public class GoalAxis implements Goal {
   private static final double SQRT_2_OVER_2 = Math.sqrt(GoalAxis.АlИ) / GoalAxis.АlП;
   private static final int Аlэ = 0;
   private static final String АlО = "АlО";
   private static final double АlИ = 0;
   private static final double АlП = 1.0;

   @Override
   public String toString() {
      return АlО;
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = Math.abs(var1);
      int sx = Math.abs(var3);
      int sxx = Math.min(var4, sx);
      int sxxx = Math.max(var4, sx);
      int sxxxx = sxxx - sxx;
      double sxxxxx = Math.min(var4, Math.min(sx, sxxxx * SQRT_2_OVER_2));
      return sxxxxx * BaritoneAPI.getSettings().costHeuristic.value + GoalYLevel.calculate(BaritoneAPI.getSettings().axisHeight.value, var2);
   }

   @Override
   public int hashCode() {
      return Аlэ;
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return var2 == BaritoneAPI.getSettings().axisHeight.value && (var1 == 0 || var3 == 0 || Math.abs(var1) == Math.abs(var3));
   }

   @Override
   public boolean equals(Object var1) {
      return var1.getClass() == GoalAxis.class;
   }

}
