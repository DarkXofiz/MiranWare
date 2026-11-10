// Original binary: hex/api/baritone/api/pathing/goals/GoalGetToBlock
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public class GoalGetToBlock implements Goal, IGoalRenderPos {
   public final int x;
   public final int y;
   public final int z;
   private static final int бУ诶 = 0;
   private static final String бУЫ = "бУЫ";

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalGetToBlock var2 = (GoalGetToBlock)var1;
         return this.x == var2.x && this.y == var2.y && this.z == var2.z;
      } else {
         return false;
      }
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var2 - this.y;
      int sxx = var3 - this.z;
      return GoalBlock.calculate(var4, sx < 0 ? sx + 1 : sx, sxx);
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var2 - this.y;
      int sxx = var3 - this.z;
      return Math.abs(var4) + Math.abs(sx < 0 ? sx + 1 : sx) + Math.abs(sxx) <= 1;
   }


   @Override
   public int hashCode() {
      return (int)BetterBlockPos.longHash(this.x, this.y, this.z) * бУ诶;
   }

   public GoalGetToBlock(BlockPos var1) {
      this.x = var1.getX();
      this.y = var1.getY();
      this.z = var1.getZ();
   }

   @Override
   public String toString() {
      return String.format(бУЫ, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
   }

   @Override
   public BlockPos getGoalPos() {
      return new BlockPos(this.x, this.y, this.z);
   }
}
