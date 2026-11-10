// Original binary: sg/ec/zv0bh0yrRUdG7gCL
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

// $VF: Compiled from s
public final class ScriptDataStorage {
   private static final String field27976 = ".data";
   private final Path field27977;
   private final Map<String, String> field27978 = new LinkedHashMap<>();
   private static final String field27979 = "scripts";
   private static final String field27980 = ".data";
   private static final String field27981 = "storage";
   private static final String field27982 = "\\";
   private static final String field27983 = "\\\\";
   private static final String field27984 = "\n";
   private static final String field27985 = "\\n";
   private static final String field27986 = "\r";

   void method11791() {
      this.field27978.clear();
   }

   void method11792(String var1, String var2) {
      if (var1 != null && !var1.isEmpty()) {
         if (var2 == null) {
            this.field27978.remove(var1);
         } else {
            this.field27978.put(var1, var2);
         }
      }
   }

   private String method11793(String var1) {
      return var1.replace(field27982, field27983).replace(field27984, field27985).replace(field27986, "");
   }

   private String method11794(String var1) {
      StringBuilder var2 = new StringBuilder(var1.length());

      for (int var3 = 0; var3 < var1.length(); var3++) {
         char var4 = var1.charAt(var3);
         if (var4 == '\\' && var3 + 1 < var1.length()) {
            char var5 = var1.charAt(++var3);
            var2.append(var5 == 'n' ? '\n' : var5);
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   static String method11795(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = Character.toLowerCase(var0.charAt(var2));
            var1.append(!Character.isLetterOrDigit(var3) && var3 != '_' && var3 != '-' ? '_' : var3);
         }

         return var1.toString();
      } else {
         return field27981;
      }
   }

   void method11796() {
      try {
         Files.createDirectories(this.field27977.getParent());
         var var1 = new ArrayList(this.field27978.size());

         for (var var3 : this.field27978.entrySet()) {
            var1.add((String)var3.getKey() + "=" + this.method11793((String)var3.getValue()));
         }

         Files.write(this.field27977, var1, StandardCharsets.UTF_8);
      } catch (IOException var4) {
      }
   }

   String[] method11797() {
      return this.field27978.keySet().toArray(new String[0]);
   }

   ScriptDataStorage(String var1, String var2) {
      this.field27977 = method11798(var1).resolve(var2 + ".txt");
      this.method11800();
   }

   static Path method11798(String var0) {
      return new File(new File(ClientEnvironment.field07577, field27979), field27980).toPath().resolve(var0);
   }

   boolean method11799() {
      return this.field27978.isEmpty();
   }

   private void method11800() {
      if (Files.isRegularFile(this.field27977)) {
         try {
            for (String var2 : Files.readAllLines(this.field27977, StandardCharsets.UTF_8)) {
               int var3 = var2.indexOf(61);
               if (var3 > 0) {
                  this.field27978.put(var2.substring(0, var3), this.method11794(var2.substring(var3 + 1)));
               }
            }
         } catch (IOException var4) {
         }
      }
   }

   String method11801(String var1) {
      return var1 != null && !var1.isEmpty() ? this.field27978.get(var1) : null;
   }
}
