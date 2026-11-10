// Original binary: sg/ec/yXfrjZLVjzpAnDSE
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// $VF: Compiled from s
public enum McpServer implements MinecraftAccess {
   INSTANCE;

   private static final String field26479 = "2025-03-26";
   private static final Set<String> field26480 = Set.of("2024-11-05", "2025-03-26", "2025-06-18");
   private static final String field26481 = "field26481";
   private static final String field26482 = "field26482";
   private static final int field26483 = 0;
   private static final int field26484 = 0;
   private static final int field26485 = 0;
   private static final int field26486 = 0;
   private static final int field26487 = 0;
   private static final String field26488 = "field26488";
   private static final Gson field26489 = new Gson();
   private final ScriptMcpTools field26490 = new ScriptMcpTools();
   private McpConfigStorage field26491 = McpConfigStorage.method08290();
   private HttpServer field26492;
   private ExecutorService field26493;

   public void method11628() {
      this.field26491 = McpConfigStorage.method08290();
      if (this.field26491.method08279()) {
         this.method11631();
      }

      Runtime.getRuntime().addShutdownHook(new Thread(this::method11632, "mcp-shutdown"));
   }

   public synchronized boolean method11629() {
      return this.field26492 != null;
   }

   public synchronized void method11630() {
      this.method11632();
      if (this.field26491.method08279()) {
         this.method11631();
      }

      this.field26491.method08282();
   }

   private synchronized void method11631() {
      try {
         this.field26492 = HttpServer.create(new InetSocketAddress("127.0.0.1", this.field26491.method08293()), 0);
         this.field26492.createContext("/mcp", this::method11633);
         this.field26493 = Executors.newCachedThreadPool(var0 -> {
            Thread var1 = new Thread(var0, "mcp-http");
            var1.setDaemon(true);
            return var1;
         });
         this.field26492.setExecutor(this.field26493);
         this.field26492.start();
         ScriptLogManager.INSTANCE.method08092(0, "[mcp] сервер запущен: " + this.field26491.method08286());
      } catch (IOException var2) {
         this.field26492 = null;
         ScriptLogManager.INSTANCE.method08092(2, "[mcp] не запустился на порту " + this.field26491.method08293() + " — " + var2.getMessage());
      }
   }

   private synchronized void method11632() {
      if (this.field26492 != null) {
         this.field26492.stop(0);
         this.field26492 = null;
         if (this.field26493 != null) {
            this.field26493.shutdownNow();
            this.field26493 = null;
         }

         ScriptLogManager.INSTANCE.method08092(0, "[mcp] сервер остановлен");
      }
   }

   private void method11633(HttpExchange var1) throws IOException {
      try (var1) {
         if (this.method11634(var1)) {
            switch (var1.getRequestMethod()) {
               case "POST":
                  this.method11635(var1);
                  return;
               case "DELETE":
                  method11636(var1, 200, null);
                  return;
               default:
                  var1.getResponseHeaders().set("Allow", "POST, DELETE");
                  method11636(var1, 405, null);
            }
         } else {
            method11636(var1, 401, method11643(null, -32600, "нужен заголовок Authorization: Bearer <токен>"));
         }
      } catch (RuntimeException var7) {
         method11636(var1, 500, method11643(null, -32603, var7.getMessage()));
      }
   }

   private boolean method11634(HttpExchange var1) {
      String var2 = var1.getRequestHeaders().getFirst("Authorization");
      return var2 != null && var2.startsWith("Bearer ") && var2.substring("Bearer ".length()).trim().equals(this.field26491.method08280());
   }

   private void method11635(HttpExchange var1) throws IOException {
      String var2 = new String(var1.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);

      JsonElement var3;
      try {
         var3 = JsonParser.parseString(var2);
      } catch (JsonSyntaxException var8) {
         method11636(var1, 400, method11643(null, -32700, "невалидный JSON"));
         return;
      }

      if (var3.isJsonArray()) {
         JsonArray var9 = new JsonArray();

         for (JsonElement var6 : var3.getAsJsonArray()) {
            JsonObject var7 = var6.isJsonObject() ? this.method11637(var6.getAsJsonObject()) : method11643(null, -32600, "ожидался объект");
            if (var7 != null) {
               var9.add(var7);
            }
         }

         method11636(var1, var9.isEmpty() ? 202 : 200, var9.isEmpty() ? null : var9);
      } else if (!var3.isJsonObject()) {
         method11636(var1, 400, method11643(null, -32600, "ожидался объект JSON-RPC"));
      } else {
         JsonObject var4 = this.method11637(var3.getAsJsonObject());
         method11636(var1, var4 == null ? 202 : 200, var4);
      }
   }

   private static void method11636(HttpExchange var0, int var1, JsonElement var2) throws IOException {
      if (var2 == null) {
         var0.sendResponseHeaders(var1, -1L);
      } else {
         byte[] var3 = field26489.toJson(var2).getBytes(StandardCharsets.UTF_8);
         var0.getResponseHeaders().set("Content-Type", "application/json");
         var0.sendResponseHeaders(var1, var3.length);

         try (OutputStream var4 = var0.getResponseBody()) {
            var4.write(var3);
         }
      }
   }

   private JsonObject method11637(JsonObject var1) {
      JsonElement var2 = var1.get("method");
      JsonElement var3 = var1.get("id");
      if (var2 != null && var2.isJsonPrimitive()) {
         String var4 = var2.getAsString();
         if (var4.startsWith("notifications/")) {
            return null;
         }

         JsonObject var5 = var1.has("params") && var1.get("params").isJsonObject() ? var1.getAsJsonObject("params") : new JsonObject();

         try {
            return switch (var4) {
               case "initialize" -> method11642(var3, this.method11638(var5));
               case "ping" -> method11642(var3, new JsonObject());
               case "tools/list" -> method11642(var3, this.method11639());
               case "tools/call" -> method11642(var3, this.method11640(var5));
               default -> method11643(var3, -32601, "неизвестный метод " + var4);
            };
         } catch (IllegalArgumentException var8) {
            return method11643(var3, -32602, var8.getMessage());
         }
      } else {
         return null;
      }
   }

   private JsonObject method11638(JsonObject var1) {
      String var2 = var1.has("protocolVersion") ? var1.get("protocolVersion").getAsString() : "2025-03-26";
      JsonObject var3 = new JsonObject();
      var3.addProperty("listChanged", false);
      JsonObject var4 = new JsonObject();
      var4.add("tools", var3);
      JsonObject var5 = new JsonObject();
      var5.addProperty("name", "miranware");
      var5.addProperty("version", ClientEnvironment.field07578);
      JsonObject var6 = new JsonObject();
      var6.addProperty("protocolVersion", field26480.contains(var2) ? var2 : "2025-03-26");
      var6.add("capabilities", var4);
      var6.add("serverInfo", var5);
      var6.addProperty(
         "instructions",
         "Это Minecraft-клиент MiranWare. Скрипт — jar в папке scripts: java/ с исходниками на Java, resources/ с файлами,\nmixin/ с миксинами в пакете scriptmixin.<имя jar в нижнем регистре>. Миксины вшиваются только при запуске Minecraft\n(после правки скрипт попадает в restartRequired), с кодом из java/ они общаются через hex.script.api.Hooks.\nСкрипт наследует hex.script.api.Script (см. api_docs без аргументов, затем api_docs с путём hex/script/api/Script.java).\nПорядок работы: scripts_list → script_read → script_write (сразу компилирует и перезагружает, возвращает ошибки\nи свежие строки консоли) → console_read c since для наблюдения за логами → script_toggle для включения.\n"
      );
      return var6;
   }

   private JsonObject method11639() {
      JsonArray var1 = new JsonArray();

      for (McpToolHandler var3 : this.field26490.method01582()) {
         var1.add(var3.describe());
      }

      JsonObject var4 = new JsonObject();
      var4.add("tools", var1);
      return var4;
   }

   private JsonObject method11640(JsonObject var1) {
      if (!var1.has("name")) {
         throw new IllegalArgumentException("нужно имя инструмента");
      }

      McpToolHandler var2 = this.field26490.method01604(var1.get("name").getAsString());
      if (var2 == null) {
         throw new IllegalArgumentException("нет инструмента " + var1.get("name").getAsString());
      }

      JsonObject var3 = var1.has("arguments") && var1.get("arguments").isJsonObject() ? var1.getAsJsonObject("arguments") : new JsonObject();

      try {
         return method11641(field26489.toJson(var2.handler().method05130(var3)), false);
      } catch (McpToolHandler.Nested154 var5) {
         return method11641(var5.getMessage(), true);
      } catch (Exception var6) {
         return method11641(var6.getClass().getSimpleName() + ": " + var6.getMessage(), true);
      }
   }

   private static JsonObject method11641(String var0, boolean var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty("type", "text");
      var2.addProperty("text", var0);
      JsonArray var3 = new JsonArray();
      var3.add(var2);
      JsonObject var4 = new JsonObject();
      var4.add("content", var3);
      var4.addProperty("isError", var1);
      return var4;
   }

   private static JsonObject method11642(JsonElement var0, JsonObject var1) {
      JsonObject var2 = method11644(var0);
      var2.add("result", var1);
      return var2;
   }

   private static JsonObject method11643(JsonElement var0, int var1, String var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty("code", var1);
      var3.addProperty("message", var2 == null ? "ошибка" : var2);
      JsonObject var4 = method11644(var0);
      var4.add("error", var3);
      return var4;
   }

   private static JsonObject method11644(JsonElement var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty("jsonrpc", "2.0");
      var1.add("id", (JsonElement)(var0 == null ? JsonNull.INSTANCE : var0));
      return var1;
   }

   public McpConfigStorage method11645() {
      return this.field26491;
   }
}
