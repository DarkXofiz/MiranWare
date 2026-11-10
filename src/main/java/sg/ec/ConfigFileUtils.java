// Original binary: sg/ec/e1yqL1F9sp1ruhCg
package sg.ec;

import java.io.File;
import java.util.List;

// $VF: Compiled from s
public final class ConfigFileUtils {
   private static final String field18452 = "default";

   public static List<ModuleConfigStorage> method07557() {
      return CustomResourceManager.INSTANCE.method02468();
   }

   public static boolean method07558(String var0) {
      if (var0 != null && !var0.equalsIgnoreCase(field18452)) {
         File var1 = new File(CustomResourceManager.INSTANCE.field05980, var0 + ".file");
         return var1.exists() && var1.delete();
      } else {
         return false;
      }
   }
}
