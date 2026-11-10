// Original binary: hex/api/baritone/api/pathing/goals/GoalRunAway
package hex.api.baritone.api.pathing.goals;

import hex.api.baritone.api.utils.SettingsUtil;
import it.unimi.dsi.fastutil.doubles.DoubleIterator;
import it.unimi.dsi.fastutil.doubles.DoubleOpenHashSet;
import java.util.Arrays;
import java.util.Objects;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public class GoalRunAway implements Goal {
   private final BlockPos[] from;
   private final int distanceSq;
   private final Integer maintainY;
   private static final String АуК = "АуК";
   private static final double АуЭ = 0;
   private static final double АуЪ = 0;
   private static final double АуЧ = 0;
   private static final int АуЩ = 0;
   private static final int Аум = 0;
   private static final int АуФ = 0;
   private static final int Ау3 = 0;
   private static final int АуЬ = 0;
   private static final int Ау1 = 0;
   private static final int Ауя = 0;
   private static final int АуI = 0;
   private static final String Ауы = "Ауы";

   @Override
   public double heuristic(int var1, int var2, int var3) {
      double var4 = АуЭ;

      for (BlockPos sx : this.from) {
         double sxx = GoalXZ.calculate(sx.getX() - var1, sx.getZ() - var3);
         if (sxx < var4) {
            var4 = sxx;
         }
      }

      var4 = -var4;
      if (this.maintainY != null) {
         var4 = var4 * АуЪ + GoalYLevel.calculate(this.maintainY, var2) * АуЧ;
      }

      return var4;
   }

   @Override
   public int hashCode() {
      int var1 = Arrays.hashCode(this.from);
      var1 = var1 * Ауя + this.distanceSq;
      return var1 * АуI + this.maintainY;
   }

   @Override
   public double heuristic() {
      int var1 = (int)Math.ceil(Math.sqrt(this.distanceSq));
      int sx = АуЩ;
      int sxx = Аум;
      int sxxx = АуФ;
      int sxxxx = Ау3;
      int sxxxxx = АуЬ;
      int sxxxxxx = Ау1;

      for (BlockPos sxxxxxxx : this.from) {
         sx = Math.min(sx, sxxxxxxx.getX() - var1);
         sxx = Math.min(sxx, sxxxxxxx.getY() - var1);
         sxxx = Math.min(sxxx, sxxxxxxx.getZ() - var1);
         sxxxx = Math.max(sx, sxxxxxxx.getX() + var1);
         sxxxxx = Math.max(sxx, sxxxxxxx.getY() + var1);
         sxxxxxx = Math.max(sxxx, sxxxxxxx.getZ() + var1);
      }

      DoubleOpenHashSet sxxxxxxx = new DoubleOpenHashSet();
      double sxxxxxxxx = Double.POSITIVE_INFINITY;

      for (int sxxxxxxxxx = sx; sxxxxxxxxx <= sxxxx; sxxxxxxxxx++) {
         for (int sxxxxxxxxxx = sxx; sxxxxxxxxxx <= sxxxxx; sxxxxxxxxxx++) {
            for (int sxxxxxxxxxxx = sxxx; sxxxxxxxxxxx <= sxxxxxx; sxxxxxxxxxxx++) {
               double sxxxxxxxxxxxx = this.heuristic(sxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxxxx);
               if (sxxxxxxxxxxxx < sxxxxxxxx && this.isInGoal(sxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxxxx)) {
                  sxxxxxxx.add(sxxxxxxxxxxxx);
               } else {
                  sxxxxxxxx = Math.min(sxxxxxxxx, sxxxxxxxxxxxx);
               }
            }
         }
      }

      double sxxxxxxxxx = Double.NEGATIVE_INFINITY;
      DoubleIterator sxxxxxxxxxx = sxxxxxxx.iterator();

      while (sxxxxxxxxxx.hasNext()) {
         double sxxxxxxxxxxx = sxxxxxxxxxx.nextDouble();
         if (sxxxxxxxxxxx < sxxxxxxxx) {
            sxxxxxxxxx = Math.max(sxxxxxxxxx, sxxxxxxxxxxx);
         }
      }

      return sxxxxxxxxx;
   }

   public GoalRunAway(double var1, Integer var3, BlockPos... var4) {
      if (var4.length == 0) {
         throw new IllegalArgumentException(АуК);
      }

      this.from = var4;
      this.distanceSq = (int)(var1 * var1);
      this.maintainY = var3;
   }

   @Override
   public boolean isInGoal(int var1, int var2, int var3) {
      if (this.maintainY != null && this.maintainY != var2) {
         return false;
      }

      for (BlockPos var7 : this.from) {
         int sx = var1 - var7.getX();
         int sxx = var3 - var7.getZ();
         int sxxx = sx * sx + sxx * sxx;
         if (sxxx < this.distanceSq) {
            return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         GoalRunAway var2 = (GoalRunAway)var1;
         return this.distanceSq == var2.distanceSq && Arrays.equals(this.from, var2.from) && Objects.equals(this.maintainY, var2.maintainY);
      } else {
         return false;
      }
   }

   @Override
   public String toString() {
      return this.maintainY != null
         ? String.format(Ауы, SettingsUtil.maybeCensor(this.maintainY), Arrays.asList(this.from))
         : "GoalRunAwayFrom" + Arrays.<BlockPos>asList(this.from);
   }


   public GoalRunAway(double var1, BlockPos... var3) {
      this(var1, null, var3);
   }
}
