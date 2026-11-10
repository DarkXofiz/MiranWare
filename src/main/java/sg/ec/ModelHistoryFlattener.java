// Original binary: sg/ec/HXpvqAZY9y5EaGRR
package sg.ec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class ModelHistoryFlattener {
   public static float[] method03798(ArrayDeque<float[]> var0, int var1, int var2) {
      float[] var3 = new float[var1 * var2];
      if (var0.isEmpty()) {
         return var3;
      }

      var sx = new ArrayList<>(var0);
      int sxx = sx.size();
      float[] sxxx = sx.get(sxx - 1);
      int sxxxx = var1 - sxx;
      int sxxxxx = 0;

      for (int sxxxxxx = 0; sxxxxxx < var1; sxxxxxx++) {
         float[] sxxxxxxx;
         if (sxxxxxx < sxxxx) {
            sxxxxxxx = sxxx;
         } else {
            int sxxxxxxxx = sxxxxxx - sxxxx;
            int sxxxxxxxxx = sxx - 1 - sxxxxxxxx;
            sxxxxxxx = sx.get(sxxxxxxxxx);
         }

         System.arraycopy(sxxxxxxx, 0, var3, sxxxxx, var2);
         sxxxxx += var2;
      }

      return var3;
   }

   private ModelHistoryFlattener() {
   }
}
