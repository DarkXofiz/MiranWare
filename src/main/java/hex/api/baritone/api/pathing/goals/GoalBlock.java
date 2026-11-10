// Original binary: hex/api/baritone/api/pathing/goals/GoalBlock
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public class GoalBlock implements IGoalRenderPos, Goal {
   public final int x;
   public final int y;
   public final int z;
   private static final int бЦя = 0;
   private static final String бЦI = "бЦI";


   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return var1 == this.x && var2 == this.y && var3 == this.z;
   }

   @Override
   public int hashCode() {
      return (int)BetterBlockPos.longHash(this.x, this.y, this.z) * бЦя;
   }

   public GoalBlock(BlockPos var1) {
      this(var1.getX(), var1.getY(), var1.getZ());
   }

   @Override
   public BlockPos getGoalPos() {
      return new BlockPos(this.x, this.y, this.z);
   }

   public static double calculate(double var0, int var2, double var3) {
      double var5 = 0.0;
      var5 += GoalYLevel.calculate(0, var2);
      return var5 + GoalXZ.calculate(var0, var3);
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalBlock var2 = (GoalBlock)var1;
         return this.x == var2.x && this.y == var2.y && this.z == var2.z;
      } else {
         return false;
      }
   }

   public GoalBlock(int var1, int var2, int var3) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var2 - this.y;
      int sxx = var3 - this.z;
      return calculate(var4, sx, sxx);
   }

   @Override
   public String toString() {
      return String.format(бЦI, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
   }
}
