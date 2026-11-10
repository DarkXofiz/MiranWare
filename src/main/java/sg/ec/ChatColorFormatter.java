// Original binary: sg/ec/dmUk9b7cxAeDRnik
package sg.ec;

import java.util.regex.Pattern;

// $VF: Compiled from s
public final class ChatColorFormatter {
   public static Pattern field18394 = Pattern.compile(ChatColorFormatter.field18406, 2);
   private static final String field18395 = "${rgb(%s,%s,%s)}";
   private static final String field18396 = "${rgba(%s,%s,%s,%s)}";
   private static final String field18397 = "${rgba(%s,%s,%s,%s)}";
   private static final String field18398 = "${reset}";
   private static final String field18399 = "rgb";
   private static final String field18400 = "rgba";
   private static final String field18401 = "${";
   private static final String field18402 = "reset";
   private static final String field18403 = "rgba(";
   private static final String field18404 = "rgb(";
   private static final String field18405 = "This is a utility class and cannot be instantiated";
   private static final String field18406 = "\\$\\{(rgba|rgb)\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})(?:,(\\d{1,3}))?\\)}|\\$\\{reset}";

   public static String method07507() {
      return field18399;
   }

   private static int method07508(String var0, int var1, int var2) {
      int var3 = 0;
      int sx = 0;

      for (int sxx = var1; sxx < var2; sxx++) {
         char sxxx = var0.charAt(sxx);
         if (sxxx >= '0' && sxxx <= '9') {
            sx++;
         } else if (sxxx != ' ') {
            if (sxxx != ',' && sxxx != ')') {
               return -1;
            }

            if (sx == 0) {
               return -1;
            }

            var3++;
            sx = 0;
            if (sxxx == ')') {
               break;
            }
         }
      }

      if (sx > 0) {
         var3++;
      }

      return var3;
   }

   public static String method07509(int var0) {
      return String.format(
         field18397,
         ColorUtils.method04588(var0),
         ColorUtils.method04589(var0),
         ColorUtils.method04587(var0),
         ColorUtils.method04625(var0)
      );
   }

   public static String method07510(String var0, int... var1) {
      if (var0 != null && !var0.isEmpty() && var1 != null && var1.length != 0) {
         if (var1.length == 1) {
            return method07520(ColorUtils.method04588(var1[0]), ColorUtils.method04589(var1[0]), ColorUtils.method04587(var1[0]))
               + var0;
         }

         StringBuilder var2 = new StringBuilder();
         int var3 = var0.length();

         for (int var4 = 0; var4 < var3; var4++) {
            float var5 = (float)var4 / (var3 - 1);
            int var6 = ColorUtils.method04586(var5, var1);
            var2.append(method07520(ColorUtils.method04588(var6), ColorUtils.method04589(var6), ColorUtils.method04587(var6)));
            var2.append(var0.charAt(var4));
         }

         var2.append(method07517());
         return var2.toString();
      } else {
         return "";
      }
   }

   public static int method07511(int var0, int var1, float var2) {
      return ColorUtils.method04583(var0, var1, var2);
   }

   public static String method07512() {
      return field18400;
   }

   public static String method07513(int var0, int var1, int var2, int var3) {
      return String.format(field18396, var0, var1, var2, var3);
   }

   private static String method07514(String var0, String var1) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var2 = null;
         int var3 = 0;
         int var4 = var0.length();

         while (var3 < var4) {
            int var5 = var0.indexOf(field18401, var3);
            if (var5 < 0) {
               break;
            }

            int var6 = var0.indexOf(125, var5 + 2);
            if (var6 < 0) {
               break;
            }

            if (method07519(var0, var5, var6)) {
               if (var2 == null) {
                  var2 = new StringBuilder(var4);
                  if (var5 > 0) {
                     var2.append(var0, 0, var5);
                  }
               } else if (var5 > var3) {
                  var2.append(var0, var3, var5);
               }

               var2.append(var1);
               var3 = var6 + 1;
            } else {
               if (var2 != null && var5 > var3) {
                  var2.append(var0, var3, var5);
               }

               var3 = var5 + 2;
            }
         }

         if (var2 == null) {
            return var0;
         }

         if (var3 < var4) {
            var2.append(var0, var3, var4);
         }

         return var2.toString();
      } else {
         return var0;
      }
   }

   public static String method07515(String var0, int var1, int var2, int var3) {
      return method07514(var0, method07520(var1, var2, var3));
   }

   public static String method07516(String var0) {
      return method07514(var0, "");
   }

   public static String method07517() {
      return field18398;
   }

   public static String method07518(String var0, int var1, int var2, int var3, int var4) {
      return method07514(var0, method07513(var1, var2, var3, var4));
   }

   private static boolean method07519(String var0, int var1, int var2) {
      int var3 = var2 - (var1 + 2);
      if (var3 == 5 && var0.regionMatches(true, var1 + 2, field18402, 0, 5)) {
         return true;
      }

      if (var3 >= 5 && var0.charAt(var2 - 1) == ')') {
         boolean var4 = var0.regionMatches(true, var1 + 2, field18403, 0, 5);
         boolean var5 = !var4 && var0.regionMatches(true, var1 + 2, field18404, 0, 4);
         if (!var4 && !var5) {
            return false;
         }

         int var6 = var1 + (var4 ? 7 : 6);
         int var7 = method07508(var0, var6, var2);
         return var5 ? var7 == 3 : var7 == 3 || var7 == 4;
      } else {
         return false;
      }
   }

   private ChatColorFormatter() {
      throw new UnsupportedOperationException(field18405);
   }

   public static String method07520(int var0, int var1, int var2) {
      return String.format(field18395, var0, var1, var2);
   }
}
