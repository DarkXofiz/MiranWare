// Original binary: sg/ec/GcwHo2BKkoslKGc6
package sg.ec;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

// $VF: Compiled from s
public class MacroStorage extends AbstractStorage {
   private static final String field08139 = "Macro";
   private static final String field08140 = "Macro";
   private static final String field08141 = "Macro";
   private static final String field08142 = "name";
   private static final String field08143 = "desc";
   private static final String field08144 = "key";
   private static final String field08145 = "name";
   private static final String field08146 = "desc";
   private static final String field08147 = "key";
   private static final String field08148 = "Macro";
   private static final String field08149 = "Macro";
   private static final String field08150 = "Macro";
   private static final String field08151 = "Macro";
   private static final String field08152 = "name";
   private static final String field08153 = "desc";
   private static final String field08154 = "key";

   private boolean method03670(JsonObject var1) {
      try {
         for (JsonElement var4 : var1.getAsJsonArray(field08141)) {
            JsonObject sx = var4.getAsJsonObject();
            MacroManager.INSTANCE
               .method07023(
                  sx.get(field08142).getAsString(), sx.get(field08143).getAsString(), KeyboardKey.method00361(sx.get(field08144).getAsString())
               );
         }

         return true;
      } catch (Exception var6) {
         return false;
      }
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         byte[] var3 = CustomResourceManager.method02470(var2);
         String var4 = new String(var3, StandardCharsets.UTF_8);
         JsonObject var5 = (JsonObject)new GsonBuilder().setPrettyPrinting().create().fromJson(var4, JsonObject.class);
         if (var5 != null && var5.has(field08139)) {
            return this.method03670(var5);
         }
      } catch (Exception var12) {
      }

      try (FileInputStream var13 = new FileInputStream(this.method03303())) {
         String var14 = new String(var13.readAllBytes(), StandardCharsets.UTF_8);
         JsonObject var15 = (JsonObject)new GsonBuilder().setPrettyPrinting().create().fromJson(var14, JsonObject.class);
         return var15 != null && var15.has(field08140) ? this.method03670(var15) : false;
      } catch (IOException var10) {
         return false;
      }
   }

   private static JsonObject method03671(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            return (JsonObject)new GsonBuilder().setPrettyPrinting().create().fromJson(new String(var0, StandardCharsets.UTF_8), JsonObject.class);
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static byte[] method03672() {
      JsonObject var0 = new JsonObject();
      JsonArray var1 = new JsonArray();

      for (Macro var3 : MacroManager.INSTANCE.method07029()) {
         JsonObject var4 = new JsonObject();
         var4.addProperty(field08145, var3.method00884());
         var4.addProperty(field08146, var3.method00879());
         var4.addProperty(field08147, KeyboardKey.method00360(var3.method00882()));
         if (!var1.contains(var4)) {
            var1.add(var4);
         }
      }

      var0.add(field08148, var1);
      String var5 = new GsonBuilder().setPrettyPrinting().create().toJson(var0);
      return var5.getBytes(StandardCharsets.UTF_8);
   }

   @Override
   public boolean method00296() {
      return this.method03302(method03672());
   }

   public static boolean method03673(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         JsonObject var1 = method03671(CustomResourceManager.method02470(var0));
         if (var1 == null || !var1.has(field08149)) {
            var1 = method03671(var0);
         }

         if (var1 != null && var1.has(field08150)) {
            try {
               var var2 = MacroManager.INSTANCE.method07029();
               var2.clear();

               for (JsonElement var4 : var1.getAsJsonArray(field08151)) {
                  JsonObject var5 = var4.getAsJsonObject();
                  var2.add(
                     new Macro(
                        var5.get(field08152).getAsString(),
                        var5.get(field08153).getAsString(),
                        KeyboardKey.method00361(var5.get(field08154).getAsString())
                     )
                  );
               }

               return true;
            } catch (Exception var6) {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public MacroStorage(File var1) {
      super(var1);
   }

   public static byte[] method03674() {
      try {
         return CustomResourceManager.method02469(method03672());
      } catch (Exception var1) {
         return new byte[0];
      }
   }
}
