// Original binary: sg/ec/fXuck6UFB4HsothM
package sg.ec;

import java.util.Locale;

// $VF: Compiled from s
public final class NumberFormatUtils {
   private static final float field19026 = 1.05F;
   private static final long field19027 = 10000L;
   private static final long field19028 = 1000000L;
   private static final String field19029 = "%.1fk";
   private static final double field19030 = 1000.0;
   private static final String field19031 = "%.2fM";
   private static final double field19032 = 1000000.0;
   private static final float field19033 = 1.05F;
   private static final String field19034 = "цена неизвестна";
   private static final float field19035 = 1.05F;
   private static final String field19036 = "без окупа";
   private static final float field19037 = 10.0F;
   private static final String field19038 = "%.1f";
   private static final String field19039 = "This is a utility class and cannot be instantiated";

   public static String method08160(PurchaseHistory.Nested87 var0) {
      float var1 = var0.payback();
      if (var1 <= 0.0F) {
         return field19034;
      }

      if (var1 < field19035) {
         return field19036;
      }

      String sx = var1 < field19037 ? String.format(Locale.ROOT, field19038, var1) : String.valueOf(Math.round(var1));
      return "x" + sx + " окупа";
   }

   public static boolean method08161(PurchaseHistory.Nested87 var0) {
      return var0.payback() >= field19033;
   }

   private NumberFormatUtils() {
      throw new UnsupportedOperationException(field19039);
   }

   public static String method08162(long var0) {
      if (var0 < field19027) {
         return String.valueOf(var0);
      } else {
         return var0 < field19028 ? String.format(Locale.ROOT, field19029, var0 / field19030) : String.format(Locale.ROOT, field19031, var0 / field19032);
      }
   }

   public static String method08163(long var0) {
      return method08162(var0) + "$";
   }
}
