// Original binary: sg/ec/plwfXTOOun2fQIYY
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

// $VF: Compiled from s
public final class ScriptConsole {
   private static final long field22797 = 20L;
   private static final Gson field22798 = new GsonBuilder().setPrettyPrinting().create();
   private static final String field22799 = "os.name";
   private static final String field22800 = "win";
   private static final String field22801 = "cmd";
   private static final String field22802 = "/c";
   private static final long field22803 = 20L;
   private static final String field22804 = "прервано";
   private static final String field22805 = "[";
   private static final String field22806 = "\n";
   private static final String field22807 = "\n\n";
   private static final String field22808 = "miranware";

   private static JsonObject method10140(File var0) throws ScriptConsole.Nested282 {
      if (!var0.isFile()) {
         return new JsonObject();
      }

      try {
         String var1 = Files.readString(var0.toPath(), StandardCharsets.UTF_8);
         if (var1.isBlank()) {
            return new JsonObject();
         } else {
            JsonElement sx = JsonParser.parseString(var1);
            if (!sx.isJsonObject()) {
               throw new ScriptConsole.Nested282(var0.getName() + ": в корне не объект");
            } else {
               return sx.getAsJsonObject();
            }
         }
      } catch (IOException var3) {
         throw new ScriptConsole.Nested282(var0.getName() + " не читается");
      } catch (JsonSyntaxException var4) {
         throw new ScriptConsole.Nested282(var0.getName() + " повреждён, поправь вручную");
      }
   }

   private ScriptConsole() {
   }

   private static String method10141(File var0, String var1, JsonObject var2) throws ScriptConsole.Nested282 {
      JsonObject var3 = method10140(var0);
      JsonElement var4 = var3.get(var1);
      JsonObject var5 = var4 != null && var4.isJsonObject() ? var4.getAsJsonObject() : new JsonObject();
      var5.add(field22808, var2);
      var3.add(var1, var5);
      method10142(var0, field22798.toJson(var3));
      return "записано в " + var0.getName();
   }

   private static void method10142(File var0, String var1) throws ScriptConsole.Nested282 {
      File var2 = var0.getParentFile();
      if (var2 != null && !var2.isDirectory() && !var2.mkdirs()) {
         throw new ScriptConsole.Nested282("нет папки " + var2.getName());
      }

      try {
         Files.writeString(var0.toPath(), var1, StandardCharsets.UTF_8);
      } catch (IOException var4) {
         throw new ScriptConsole.Nested282(var0.getName() + " не записывается");
      }
   }

   private static String method10143(String var0) {
      int var1 = var0.lastIndexOf(10);
      return var1 < 0 ? var0 : var0.substring(var1 + 1).trim();
   }

   private static String method10144(File var0, String var1) throws ScriptConsole.Nested282 {
      String var2 = var1.substring(0, var1.indexOf(10));
      ArrayList var3 = new ArrayList();
      boolean var4 = false;

      for (String var6 : method10146(var0)) {
         String var7 = var6.trim();
         if (var7.equals(var2)) {
            var4 = true;
         } else {
            if (var4 && var7.startsWith(field22805)) {
               var4 = false;
            }

            if (!var4) {
               var3.add(var6);
            }
         }
      }

      while (!var3.isEmpty() && ((String)var3.get(var3.size() - 1)).isBlank()) {
         var3.remove(var3.size() - 1);
      }

      StringBuilder var8 = new StringBuilder(String.join(field22806, var3));
      if (!var3.isEmpty()) {
         var8.append(field22807);
      }

      var8.append(var1);
      method10142(var0, var8.toString());
      return "записано в " + var0.getName();
   }

   private static String method10145(String[] var0) throws ScriptConsole.Nested282 {
      ArrayList var1 = new ArrayList();
      if (System.getProperty(field22799, "").toLowerCase(Locale.ROOT).contains(field22800)) {
         var1.add(field22801);
         var1.add(field22802);
      }

      var1.addAll(List.of(var0));

      try {
         Process var2 = new ProcessBuilder(var1).redirectErrorStream(true).start();
         String var3 = new String(var2.getInputStream().readAllBytes(), StandardCharsets.UTF_8).trim();
         if (!var2.waitFor(field22803, TimeUnit.SECONDS)) {
            var2.destroyForcibly();
            throw new ScriptConsole.Nested282(var0[0] + " не ответил за 20 с");
         } else if (var2.exitValue() != 0) {
            throw new ScriptConsole.Nested282(var0[0] + ": " + (var3.isEmpty() ? "код " + var2.exitValue() : method10143(var3)));
         } else {
            return var0[0] + " mcp add выполнен";
         }
      } catch (IOException var4) {
         throw new ScriptConsole.Nested282(var0[0] + " не найден в PATH");
      } catch (InterruptedException var5) {
         Thread.currentThread().interrupt();
         throw new ScriptConsole.Nested282(field22804);
      }
   }

   private static List<String> method10146(File var0) throws ScriptConsole.Nested282 {
      if (!var0.isFile()) {
         return new ArrayList<>();
      }

      try {
         return new ArrayList<>(Files.readAllLines(var0.toPath(), StandardCharsets.UTF_8));
      } catch (IOException var2) {
         throw new ScriptConsole.Nested282(var0.getName() + " не читается");
      }
   }

   public static String method10147(McpServerMode var0, McpConfigStorage var1) throws ScriptConsole.Nested282 {
      String var2 = var1.method08286();
      String var3 = var1.method08280();

      return switch (var0.field26006) {
         case CLI -> method10145(var0.method11337(var2, var3));
         case TOML -> method10144(var0.method11336(), var0.method11339(var2, var3));
         case JSON -> method10141(var0.method11336(), var0.method11334(), var0.method11338(var2, var3));
      };
   }

   // $VF: Compiled from s
   public static final class Nested282 extends Exception {
      Nested282(String var1) {
         super(var1);
      }
   }
}
