// Original binary: sg/ec/uCjFArcCkud7gnYi
package sg.ec;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// $VF: Compiled from s
public final class EncryptedAssetArchive {
   public static final String field24555 = "0.bin";
   public static final String field24556 = "field24556";
   private static final String field24557 = "field24557";
   private static final Map<String, String> field24558 = new HashMap<>();
   private static final Map<String, String> field24559 = new HashMap<>();
   private static final Set<String> field24560 = new HashSet<>();
   private static final List<String[]> field24561 = new ArrayList<>();
   private static final String field24562 = "/assets/hex/0.bin";
   private static final String field24563 = "assets/";
   private static final String field24564 = "assets/";
   private static final String field24565 = "assets/";
   private static final String field24566 = "This is a utility class and cannot be instantiated";

   public static boolean method10917() {
      return !field24561.isEmpty();
   }

   public static boolean method10918(String var0, String var1) {
      return field24560.contains(method10922(var0, var1));
   }

   private static void method10919() {
      String var0 = field24562;

      try {
         label77: {
            try (InputStream var1 = EncryptedAssetArchive.class.getResourceAsStream(var0)) {
               if (var1 != null) {
                  String var3;
                  try (BufferedReader var2 = new BufferedReader(new InputStreamReader(EncryptedTextureUtils.method08943(var1), StandardCharsets.UTF_8))) {
                     while ((var3 = var2.readLine()) != null) {
                        method10920(var3);
                     }
                     break label77;
                  }
               }
            }

            return;
         }
      } catch (Throwable var9) {
         field24558.clear();
         field24559.clear();
         field24560.clear();
         field24561.clear();
      }
   }

   private EncryptedAssetArchive() {
      throw new UnsupportedOperationException(field24566);
   }

   private static void method10920(String var0) {
      int var1 = var0.indexOf(9);
      if (var1 > 0 && var1 != var0.length() - 1) {
         String var2 = var0.substring(0, var1);
         String var3 = var0.substring(var1 + 1);
         String[] var4 = method10925(var2);
         String[] var5 = method10925(var3);
         if (var4 != null && var5 != null) {
            field24559.put("/" + var2, "/" + var3);
            field24560.add(method10922(var5[0], var5[1]));
            if (var4[0].equals(var5[0]) && method10923(var4[0]) && method10923(var4[1]) && method10923(var5[1])) {
               field24558.put(method10922(var4[0], var4[1]), var5[1]);
               field24561.add(new String[]{var4[0], var4[1], var5[1]});
            }
         }
      }
   }

   public static List<String[]> method10921() {
      return Collections.unmodifiableList(field24561);
   }

   private static String method10922(String var0, String var1) {
      return var0 + ":" + var1;
   }

   static {
      method10919();
   }

   private static boolean method10923(String var0) {
      for (int var1 = 0; var1 < var0.length(); var1++) {
         char var2 = var0.charAt(var1);
         boolean var3 = var2 >= 'a' && var2 <= 'z' || var2 >= '0' && var2 <= '9' || var2 == '/' || var2 == '.' || var2 == '_' || var2 == '-';
         if (!var3) {
            return false;
         }
      }

      return true;
   }

   public static String method10924(String var0) {
      String var1 = field24559.get(var0);
      return var1 == null ? var0 : var1;
   }

   private static String[] method10925(String var0) {
      if (!var0.startsWith(field24563)) {
         return null;
      }

      int var1 = var0.indexOf(47, field24564.length());
      return var1 >= 0 && var1 != var0.length() - 1 ? new String[]{var0.substring(field24565.length(), var1), var0.substring(var1 + 1)} : null;
   }

   public static String method10926(String var0, String var1) {
      return field24558.get(method10922(var0, var1));
   }
}
