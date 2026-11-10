// Original binary: sg/ec/3hwXVKH7PVFv9DqD
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

// $VF: Compiled from s
public class ThemeStorage extends AbstractStorage {
   private static final Gson field01704 = new GsonBuilder().setPrettyPrinting().create();
   private static final String field01705 = "name";
   private static final String field01706 = "name";
   private static final String field01707 = "author";
   private static final String field01708 = "author";
   private static final String field01709 = "author";
   private static final String field01710 = "colors";
   private static final String field01711 = "colors";
   private static final String field01712 = "name";
   private static final String field01713 = "author";
   private static final String field01714 = "colors";
   private static final String field01715 = ".json";

   private void method00749(ThemeSettings var1) {
      try (FileWriter var2 = new FileWriter(ThemeManager.INSTANCE.method09623(var1.method09815()))) {
         field01704.toJson(method00753(var1), var2);
      } catch (IOException var7) {
      }
   }

   private static ThemeSettings method00750(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         for (ThemeSettings var2 : ThemeManager.INSTANCE.method09636()) {
            if (var2.method09815().equals(var0)) {
               return var2;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static void method00751(ThemeSettings var0, JsonObject var1) {
      if (var1 != null) {
         for (Setting var3 : var0.method03026()) {
            if (var3 instanceof ColorSetting var4) {
               JsonElement var5 = var1.get(var3.method03024());
               if (var5 != null && var5.isJsonPrimitive()) {
                  var4.method11672(new Color(var5.getAsInt(), true));
               }
            }
         }
      }
   }

   public static void method00752(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         String var1 = new String(var0, StandardCharsets.UTF_8).trim();
         int var2 = var1.indexOf(10);
         if (var2 >= 0) {
            var1 = var1.substring(0, var2).trim();
         }

         ThemeSettings var3 = method00750(var1);
         if (var3 != null) {
            ThemeManager.INSTANCE.method09612(var3);
         }
      }
   }

   private static JsonObject method00753(ThemeSettings var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty(field01712, var0.method09815());
      var1.addProperty(field01713, var0.method09817() == null ? "" : var0.method09817());
      JsonObject var2 = new JsonObject();

      for (Setting var4 : var0.method03026()) {
         if (var4 instanceof ColorSetting var5 && var5.method03022() != null) {
            var2.addProperty(var4.method03024(), var5.method03022().getRGB());
         }
      }

      var1.add(field01714, var2);
      return var1;
   }

   public static byte[] method00754() {
      ThemeSettings var0 = ThemeManager.INSTANCE.method09611();
      return var0 == null ? new byte[0] : var0.method09815().getBytes(StandardCharsets.UTF_8);
   }

   @Override
   public boolean method00296() {
      File var1 = CustomResourceManager.INSTANCE.field05982;
      if (!var1.exists()) {
         var1.mkdirs();
      }

      for (ThemeSettings var3 : ThemeManager.INSTANCE.method09636()) {
         if (!ThemeManager.INSTANCE.method09614(var3)) {
            this.method00749(var3);
         }
      }

      try (PrintWriter var8 = new PrintWriter(this.method03303())) {
         var8.println(ThemeManager.INSTANCE.method09611().method09815());
         return true;
      } catch (IOException var7) {
         return false;
      }
   }

   public static byte[] method00756(ThemeSettings var0) {
      return var0 == null ? new byte[0] : field01704.toJson(method00753(var0)).getBytes(StandardCharsets.UTF_8);
   }

   public ThemeStorage(File var1) {
      super(var1);
   }

   public static boolean method00757(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            return method00758(JsonParser.parseString(new String(var0, StandardCharsets.UTF_8)).getAsJsonObject());
         } catch (Exception var2) {
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean method00758(JsonObject var0) {
      if (var0 != null && var0.has(field01705)) {
         String var1 = var0.get(field01706).getAsString();
         ThemeSettings var2 = method00750(var1);
         if (var2 != null && ThemeManager.INSTANCE.method09614(var2)) {
            return false;
         }

         if (var2 == null) {
            var2 = new ThemeSettings(var1);
            ThemeManager.INSTANCE.method09609(var2);
         }

         if (var0.has(field01707) && var0.get(field01708).isJsonPrimitive()) {
            var2.method09826(var0.get(field01709).getAsString());
         }

         if (var0.has(field01710)) {
            method00751(var2, var0.getAsJsonObject(field01711));
         }

         return true;
      } else {
         return false;
      }
   }

   private void method00759(File var1) {
      try (FileReader var2 = new FileReader(var1)) {
         method00758(JsonParser.parseReader(var2).getAsJsonObject());
      } catch (Exception var7) {
      }
   }

   @Override
   public boolean method00298() {
      File var1 = CustomResourceManager.INSTANCE.field05982;
      if (var1.exists() && var1.isDirectory()) {
         File[] var2 = var1.listFiles((var0, var1x) -> var1x.endsWith(field01715));
         if (var2 != null) {
            for (File var6 : var2) {
               this.method00759(var6);
            }
         }
      }

      try (BufferedReader var10 = Files.newBufferedReader(this.method03303().toPath())) {
         String var11 = var10.readLine();
         if (var11 != null) {
            ThemeSettings var12 = method00750(var11.trim());
            if (var12 != null) {
               ThemeManager.INSTANCE.method09612(var12);
            }
         }
      } catch (IOException var9) {
      }

      return true;
   }
}
