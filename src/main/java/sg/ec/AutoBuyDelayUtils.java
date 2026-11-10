// Original binary: sg/ec/az0PwaUqSa21paEQ
package sg.ec;

import java.util.concurrent.ThreadLocalRandom;

// $VF: Compiled from s
public final class AutoBuyDelayUtils {
   private static final double field16890 = 0.22;
   private static final double field16891 = 0;
   private static final double field16892 = 0;
   private static final double field16893 = 0.22;
   private static final double field16894 = 0.55;
   private static final double field16895 = 1.65;

   public static long method07071(long var0) {
      if (var0 > 0L && AutoBuySettings.field19624.method08541()) {
         double var2 = var0 + ThreadLocalRandom.current().nextGaussian() * var0 * field16893;
         long sx = Math.max(1L, Math.round(var0 * field16894));
         long sxx = Math.round(var0 * field16895);
         return Math.max(sx, Math.min(sxx, Math.round(var2)));
      } else {
         return var0;
      }
   }

   public static long method07072() {
      return method07071(Math.max(1L, AutoBuySettings.field19624.method08559()));
   }

   private AutoBuyDelayUtils() {
   }

   public static long method07073(long var0, long var2) {
      return var2 <= var0 ? var0 : var0 + ThreadLocalRandom.current().nextLong(var2 - var0 + 1L);
   }
}
