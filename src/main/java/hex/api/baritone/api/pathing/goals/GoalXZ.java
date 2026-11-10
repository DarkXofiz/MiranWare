// Original binary: hex/api/baritone/api/pathing/goals/GoalXZ
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class GoalXZ implements Goal {
   private static final double SQRT_2 = Math.sqrt(GoalXZ.诶Рч);
   private final int x;
   private final int z;
   private static final int 诶Р0 = 0;
   private static final int 诶РГ = 0;
   private static final int 诶Рф = 0;
   private static final String 诶РЕ = "诶РЕ";
   private static final double 诶Рч = 0;


   public GoalXZ(int var1, int var2) {
      this.x = var1;
      this.z = var2;
   }

   public GoalXZ(BetterBlockPos var1) {
      this.x = var1.x;
      this.z = var1.z;
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return var1 == this.x && var3 == this.z;
   }

   public static double calculate(double var0, double var2) {
      double var4 = Math.abs(var0);
      double sx = Math.abs(var2);
      double sxx;
      double sxxx;
      if (var4 < sx) {
         sxx = sx - var4;
         sxxx = var4;
      } else {
         sxx = var4 - sx;
         sxxx = sx;
      }

      sxxx *= SQRT_2;
      return (sxxx + sxx) * BaritoneAPI.getSettings().costHeuristic.value;
   }

   @Override
   public String toString() {
      return String.format(诶РЕ, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.z));
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var3 - this.z;
      return calculate(var4, sx);
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalXZ var2 = (GoalXZ)var1;
         return this.x == var2.x && this.z == var2.z;
      } else {
         return false;
      }
   }

   public static GoalXZ fromDirection(Vec3 var0, float var1, double var2) {
      float var4 = (float)Math.toRadians(var1);
      double sx = var0.x - Mth.sin(var4) * var2;
      double sxx = var0.z + Mth.cos(var4) * var2;
      return new GoalXZ(Mth.floor(sx), Mth.floor(sxx));
   }

   public int getZ() {
      return this.z;
   }

   @Override
   public int hashCode() {
      int var1 = 诶Р0;
      var1 = var1 * 诶РГ + this.x;
      return var1 * 诶Рф + this.z;
   }

   public int getX() {
      return this.x;
   }
}
