// Original binary: hex/api/baritone/api/pathing/goals/GoalNear
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import it.unimi.dsi.fastutil.doubles.DoubleIterator;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public class GoalNear implements Goal, IGoalRenderPos {
   private final int x;
   private final int y;
   private final int z;
   private final int rangeSq;
   private static final String АЕв = "АЕв";

   @Override
   public int hashCode() {
      return (int)BetterBlockPos.longHash(this.x, this.y, this.z) + this.rangeSq;
   }

   @Override
   public String toString() {
      return String.format(АЕв, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z), this.rangeSq);
   }

   @Override
   public BlockPos getGoalPos() {
      return new BlockPos(this.x, this.y, this.z);
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalNear var2 = (GoalNear)var1;
         return this.x == var2.x && this.y == var2.y && this.z == var2.z && this.rangeSq == var2.rangeSq;
      } else {
         return false;
      }
   }

   public GoalNear(BlockPos var1, int var2) {
      this.x = var1.getX();
      this.y = var1.getY();
      this.z = var1.getZ();
      this.rangeSq = var2 * var2;
   }


   @Override
   public double heuristic() {
      int var1 = (int)Math.ceil(Math.sqrt(this.rangeSq));
      DoubleOpenHashSet sx = new DoubleOpenHashSet();
      double sxx = Double.POSITIVE_INFINITY;

      for (int sxxx = -var1; sxxx <= var1; sxxx++) {
         for (int sxxxx = -var1; sxxxx <= var1; sxxxx++) {
            for (int sxxxxx = -var1; sxxxxx <= var1; sxxxxx++) {
               double sxxxxxx = this.heuristic(this.x + sxxx, this.y + sxxxx, this.z + sxxxxx);
               if (sxxxxxx < sxx && this.isInGoal(this.x + sxxx, this.y + sxxxx, this.z + sxxxxx)) {
                  sx.add(sxxxxxx);
               } else {
                  sxx = Math.min(sxx, sxxxxxx);
               }
            }
         }
      }

      double sxxx = Double.NEGATIVE_INFINITY;
      DoubleIterator sxxxx = sx.iterator();

      while (sxxxx.hasNext()) {
         double sxxxxx = sxxxx.nextDouble();
         if (sxxxxx < sxx) {
            sxxx = Math.max(sxxx, sxxxxx);
         }
      }

      return sxxx;
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var2 - this.y;
      int sxx = var3 - this.z;
      return var4 * var4 + sx * sx + sxx * sxx <= this.rangeSq;
   }

   @Override
   public double heuristic(int var1, int var2, int var3) {
      int var4 = var1 - this.x;
      int sx = var2 - this.y;
      int sxx = var3 - this.z;
      return GoalBlock.calculate(var4, sx, sxx);
   }
}
