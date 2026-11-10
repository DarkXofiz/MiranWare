// Original binary: hex/api/baritone/api/pathing/goals/GoalStrictDirection
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

// $VF: Compiled from s
public class GoalStrictDirection implements Goal {
   public final int x;
   public final int y;
   public final int z;
   public final int dx;
   public final int dz;
   private static final int АШ_ = 0;
   private static final int АШс = 0;
   private static final String АШЛ = "АШЛ";


   @Override
   public int hashCode() {
      int var1 = (int)BetterBlockPos.longHash(this.x, this.y, this.z);
      var1 = var1 * АШ_ + this.dx;
      return var1 * АШс + this.dz;
   }

   @Override
   public String toString() {
      return String.format(
         АШЛ,
         SettingsUtil.maybeCensor(this.x),
         SettingsUtil.maybeCensor(this.y),
         SettingsUtil.maybeCensor(this.z),
         SettingsUtil.maybeCensor(this.dx),
         SettingsUtil.maybeCensor(this.dz)
      );
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return false;
   }

   @Override
   public double heuristic() {
      return Double.NEGATIVE_INFINITY;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalStrictDirection var2 = (GoalStrictDirection)var1;
         return this.x == var2.x && this.y == var2.y && this.z == var2.z && this.dx == var2.dx && this.dz == var2.dz;
      } else {
         return false;
      }
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = (var1 - this.x) * this.dx + (var3 - this.z) * this.dz;
      int sx = Math.abs((var1 - this.x) * this.dz) + Math.abs((var3 - this.z) * this.dx);
      int sxx = Math.abs(var2 - this.y);
      double sxxx = -var4 * 100;
      sxxx += sx * 1000;
      return sxxx + sxx * 1000;
   }

   public GoalStrictDirection(BlockPos var1, Direction var2) {
      this.x = var1.getX();
      this.y = var1.getY();
      this.z = var1.getZ();
      this.dx = var2.getStepX();
      this.dz = var2.getStepZ();
      if (this.dx == 0 && this.dz == 0) {
         throw new IllegalArgumentException(var2 + "");
      }
   }
}
