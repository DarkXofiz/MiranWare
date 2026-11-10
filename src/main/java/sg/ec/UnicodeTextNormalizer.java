// Original binary: sg/ec/mTxQpDdjeMDFgzM5
package sg.ec;

import java.util.Locale;

// $VF: Compiled from s
public final class UnicodeTextNormalizer {
   private static final char[] field21535 = new char[]{'a', 'c', 'e', 'k', 'm', 'o', 'p', 't', 'x', 'y'};
   private static final char[] field21536 = new char[]{'а', 'с', 'е', 'к', 'м', 'о', 'р', 'т', 'х', 'у'};

   private static char method09495(char var0) {
      for (int var1 = 0; var1 < field21535.length; var1++) {
         if (var0 == field21535[var1]) {
            return field21536[var1];
         }
      }

      return var0;
   }

   private UnicodeTextNormalizer() {
   }

   public static String method09496(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         char[] var1 = var0.toLowerCase(Locale.ROOT).toCharArray();

         for (int var2 = 0; var2 < var1.length; var2++) {
            var1[var2] = method09495(var1[var2]);
         }

         return new String(var1);
      } else {
         return "";
      }
   }
}
