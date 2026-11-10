// Original binary: sg/ec/GOpmg6g2004XeRCL
package sg.ec;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class TranslationLoader {
   public static final String field07980 = "lang/";
   private static final String field07981 = "field07981";
   private static final String field07982 = "field07982";
   private static final int field07983 = 0;
   private static final String field07984 = "lang/";
   private static final String field07985 = ".json";
   private static final String field07986 = "lang/";
   private static final String field07987 = ".json";
   private static final String field07988 = "\n";
   private static final int field07989 = 65536;
   private static final String field07990 = "This is a utility class and cannot be instantiated";

   private static void method03595(List<Identifier> var0, String var1, String var2) {
      try {
         Identifier var3 = Identifier.fromNamespaceAndPath(var1, "lang/" + var2 + ".lang");
         if (!var0.contains(var3)) {
            var0.add(var3);
         }
      } catch (Exception var4) {
      }
   }

   private TranslationLoader() {
      throw new UnsupportedOperationException(field07990);
   }

   public static String method03596(String var0) {
      JsonObject var1 = new JsonObject();
      int var2 = 0;

      for (String var6 : var0.split(field07988)) {
         String var7 = var6.strip();
         if (!var7.isEmpty() && var7.charAt(0) != '#') {
            int var8 = var7.indexOf(61);
            if (var8 > 0) {
               var1.addProperty(var7.substring(0, var8), var7.substring(var8 + 1));
               if (++var2 >= field07989) {
                  break;
               }
            }
         }
      }

      return var2 == 0 ? null : var1.toString();
   }

   public static boolean method03597(Identifier var0) {
      String var1 = var0.getPath();
      return var1.startsWith(field07984) && var1.endsWith(field07985);
   }

   public static List<Identifier> method03598(Identifier var0) {
      String var1 = var0.getNamespace();
      String var2 = var0.getPath().substring(field07986.length(), var0.getPath().length() - field07987.length());
      ArrayList var3 = new ArrayList();
      method03595(var3, var1, var2);
      int var4 = var2.indexOf(95);
      if (var4 > 0) {
         method03595(var3, var1, var2.substring(0, var4) + "_" + var2.substring(var4 + 1).toUpperCase(Locale.ROOT));
      }

      return var3;
   }
}
