// Original binary: sg/ec/RylB6FgayiNSBWNW
package sg.ec;

import java.util.LinkedHashMap;
import java.util.Map;

// $VF: Compiled from s
public final class DefaultFontLoader {
   private static final Map<String, FontRenderer> field11719 = new LinkedHashMap<>();
   private static final String field11720 = "icons";
   private static final String field11721 = "sf_rounded_bold";
   private static final String field11722 = "sf_rounded_semibold";
   private static final String field11723 = "sf_rounded_medium";
   private static final String field11724 = "This is a utility class and cannot be instantiated";

   public static FontRenderer method05391(String var0) {
      method05392();
      FontRenderer var1 = var0 == null ? null : field11719.get(var0.toLowerCase());
      return var1 == null ? Fonts.field00110 : var1;
   }

   private static void method05392() {
      if (field11719.isEmpty() && Fonts.field00110 != null) {
         field11719.put(field11720, Fonts.field00107);
         field11719.put(field11721, Fonts.field00109);
         field11719.put(field11722, Fonts.field00110);
         field11719.put(field11723, Fonts.field00111);
      }
   }

   private DefaultFontLoader() {
      throw new UnsupportedOperationException(field11724);
   }

   public static String[] method05393() {
      method05392();
      return field11719.keySet().toArray(new String[0]);
   }
}
