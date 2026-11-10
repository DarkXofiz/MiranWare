// Original binary: sg/ec/3RwahkjnIp3oFpwX
package sg.ec;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

// $VF: Compiled from s
public class StaffStorage extends AbstractStorage {
   private static final String field01570 = "\n";

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] sx = var1.readAllBytes();
         var sxx = this.method00686(this.method00681(CustomResourceManager.method02470(sx)), true);
         if (sxx == null) {
            sxx = this.method00686(this.method00681(sx), false);
         }

         if (sxx == null) {
            return false;
         }

         StaffManager.INSTANCE.method02174();
         sxx.forEach(StaffManager.INSTANCE::method02172);
         return true;
      } catch (Exception var7) {
         return false;
      }
   }

   private String method00681(byte[] var1) {
      return var1 == null ? null : new String(var1, StandardCharsets.UTF_8);
   }

   @Override
   public boolean method00296() {
      return this.method03302(method00682());
   }

   private static byte[] method00682() {
      StringBuilder var0 = new StringBuilder();

      for (String var2 : StaffManager.INSTANCE.method02176()) {
         var0.append(var2).append(field01570);
      }

      return var0.toString().getBytes(StandardCharsets.UTF_8);
   }

   private static String method00683(byte[] var0) {
      return var0 == null ? null : new String(var0, StandardCharsets.UTF_8);
   }

   public static byte[] method00685() {
      try {
         return CustomResourceManager.method02469(method00682());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private List<String> method00686(String var1, boolean var2) {
      if (var1 == null) {
         return null;
      }

      var var3 = var1.lines().map(String::trim).filter(var0 -> !var0.isEmpty()).distinct().toList();
      if (var2) {
         for (String var5 : var3) {
            if (!TextRenderUtils.method00673(var5)) {
               return null;
            }
         }

         return var3;
      } else {
         return var3.stream().filter(TextRenderUtils::method00673).distinct().toList();
      }
   }

   public static boolean method00687(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         var var1 = method00688(method00683(CustomResourceManager.method02470(var0)), true);
         if (var1 == null) {
            var1 = method00688(method00683(var0), false);
         }

         if (var1 == null) {
            return false;
         }

         var var2 = StaffManager.INSTANCE.method02176();
         var2.clear();
         var2.addAll(var1);
         return true;
      } else {
         return false;
      }
   }

   public StaffStorage(File var1) {
      super(var1);
   }

   private static List<String> method00688(String var0, boolean var1) {
      if (var0 == null) {
         return null;
      }

      var var2 = var0.lines().map(String::trim).filter(var0x -> !var0x.isEmpty()).distinct().toList();
      if (var1) {
         for (String var4 : var2) {
            if (!TextRenderUtils.method00673(var4)) {
               return null;
            }
         }

         return var2;
      } else {
         return var2.stream().filter(TextRenderUtils::method00673).distinct().toList();
      }
   }
}
