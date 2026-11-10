// Original binary: sg/ec/K6WN0eEItygq0xJ2
package sg.ec;

// $VF: Compiled from s
public final class RandomIdUtils {
   private static final int[][] field09355 = new int[][]{{101, 114}, {201, 236}, {301, 325}, {501, 515}};
   private static final String field09356 = "This is a utility class and cannot be instantiated";

   public static int method04145(int var0) {
      int var1 = method04147(var0);

      for (int sx = field09355.length - 1; sx >= 0; sx--) {
         int[] sxx = field09355[sx];
         if (var1 > sxx[0] && var1 <= sxx[1]) {
            return var1 - 1;
         }

         if (var1 == sxx[0]) {
            return sx == 0 ? method04148() : field09355[sx - 1][1];
         }
      }

      return method04148();
   }

   public static int method04146(int var0) {
      int var1 = method04147(var0);

      for (int[] var5 : field09355) {
         if (var1 >= var5[0] && var1 < var5[1]) {
            return var1 + 1;
         }

         if (var1 == var5[1]) {
            return var5 == field09355[field09355.length - 1] ? method04150() : method04149(var5);
         }
      }

      return method04150();
   }

   public static int method04147(int var0) {
      if (method04151(var0)) {
         return var0;
      }

      if (var0 < method04150()) {
         return method04150();
      }

      if (var0 > method04148()) {
         return method04148();
      }

      for (int[] var4 : field09355) {
         if (var0 < var4[0]) {
            return var4[0];
         }
      }

      return method04148();
   }

   private RandomIdUtils() {
      throw new UnsupportedOperationException(field09356);
   }

   public static int method04148() {
      return field09355[field09355.length - 1][1];
   }

   private static int method04149(int[] var0) {
      for (int var1 = 0; var1 < field09355.length - 1; var1++) {
         if (field09355[var1] == var0) {
            return field09355[var1 + 1][0];
         }
      }

      return method04150();
   }

   public static int method04150() {
      return field09355[0][0];
   }

   public static boolean method04151(int var0) {
      for (int[] var4 : field09355) {
         if (var0 >= var4[0] && var0 <= var4[1]) {
            return true;
         }
      }

      return false;
   }
}
