// Original binary: hex/api/baritone/api/pathing/goals/GoalTwoBlocks
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public class GoalTwoBlocks implements IGoalRenderPos, Goal {
   protected final int x;
   protected final int y;
   protected final int z;
   private static final int А1_ = 0;
   private static final String А1с = "А1с";

   @Override
   public int hashCode() {
      return (int)BetterBlockPos.longHash(this.x, this.y, this.z) * А1_;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalTwoBlocks var2 = (GoalTwoBlocks)var1;
         return this.x == var2.x && this.y == var2.y && this.z == var2.z;
      } else {
         return false;
      }
   }

   public GoalTwoBlocks(BlockPos var1) {
      this(var1.getX(), var1.getY(), var1.getZ());
   }

   @Override
   public BlockPos getGoalPos() {
      return new BlockPos(this.x, this.y, this.z);
   }

   public GoalTwoBlocks(int var1, int var2, int var3) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }


   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var2 - this.y;
      int sxx = var3 - this.z;
      return GoalBlock.calculate(var4, sx < 0 ? sx + 1 : sx, sxx);
   }

   @Override
   public String toString() {
      return String.format(А1с, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      return var1 == this.x && (var2 == this.y || var2 == this.y - 1) && var3 == this.z;
   }
}
