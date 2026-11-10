// Original binary: sg/ec/e4l76LVV0UhRE6cc
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

// $VF: Compiled from s
public class ProxyStorage extends AbstractStorage {
   private static final String field18472 = "proxies";
   private static final String field18473 = "activeId";
   private static final String field18474 = "activeId";
   private static final String field18475 = "enabled";
   private static final String field18476 = "enabled";
   private static final String field18477 = "active";
   private static final String field18478 = "active";
   private static final String field18479 = "enabled";
   private static final String field18480 = "enabled";
   private static final String field18481 = "active";
   private static final String field18482 = "enabled";
   private static final String field18483 = "enabled";
   private static final String field18484 = "activeId";
   private static final String field18485 = "proxies";
   private static final String field18486 = "id";
   private static final String field18487 = "cloudName";
   private static final String field18488 = "name";
   private static final String field18489 = "host";
   private static final String field18490 = "port";
   private static final String field18491 = "type";
   private static final String field18492 = "username";
   private static final String field18493 = "password";
   private static final String field18494 = "host";
   private static final String field18495 = "port";
   private static final String field18496 = "type";
   private static final String field18497 = "SOCKS4";
   private static final String field18498 = "type";
   private static final String field18499 = "id";
   private static final String field18500 = "id";
   private static final String field18501 = "name";
   private static final String field18502 = "name";
   private static final String field18503 = "host";
   private static final String field18504 = "port";
   private static final String field18505 = "username";
   private static final String field18506 = "username";
   private static final String field18507 = "password";
   private static final String field18508 = "password";
   private static final String field18509 = "cloudName";
   private static final String field18510 = "cloudName";

   public ProxyStorage(File var1) {
      super(var1);
   }

   public static boolean method07612(byte[] var0) {
      JsonObject var1 = method07618(var0);
      if (var1 == null) {
         return false;
      }

      ProxyManager var2 = ProxyManager.INSTANCE;
      var2.method05231();
      JsonArray var3 = var1.getAsJsonArray(field18472);
      if (var3 != null) {
         for (JsonElement var5 : var3) {
            if (var5.isJsonObject()) {
               ProxyConfig var6 = method07613(var5.getAsJsonObject());
               if (var6 != null) {
                  var2.method05232(var6.method03917(), var6);
               }
            }
         }
      }

      var2.method05242(var1.has(field18473) ? var1.get(field18474).getAsString() : "");
      var2.method05243(var1.has(field18475) && var1.get(field18476).getAsBoolean());
      var2.method05233();
      return true;
   }

   @Override
   public boolean method00296() {
      File var1 = this.method03303().getParentFile();
      if (var1 != null && !var1.exists()) {
         var1.mkdirs();
      }

      return this.method03302(method07616());
   }

   private static ProxyConfig method07613(JsonObject var0) {
      if (var0.has(field18494) && var0.has(field18495)) {
         ProxyConfig.Nested114 var1 = var0.has(field18496) && field18497.equalsIgnoreCase(var0.get(field18498).getAsString())
            ? ProxyConfig.Nested114.SOCKS4
            : ProxyConfig.Nested114.SOCKS5;
         ProxyConfig var2 = new ProxyConfig(
            var0.has(field18499) ? var0.get(field18500).getAsString() : null,
            var0.has(field18501) ? var0.get(field18502).getAsString() : "",
            var0.get(field18503).getAsString(),
            var0.get(field18504).getAsInt(),
            var1,
            var0.has(field18505) ? var0.get(field18506).getAsString() : "",
            var0.has(field18507) ? var0.get(field18508).getAsString() : ""
         );
         if (var0.has(field18509)) {
            var2.method03908(var0.get(field18510).getAsString());
         }

         return var2.method03907() ? var2 : null;
      } else {
         return null;
      }
   }

   public static boolean method07614(String var0, byte[] var1) {
      JsonObject var2 = method07618(var1);
      if (var2 == null) {
         return false;
      }

      ProxyConfig var3 = method07613(var2);
      if (var3 == null) {
         return false;
      }

      ProxyManager var4 = ProxyManager.INSTANCE;
      if (var4.method05232(var0, var3) == null) {
         return false;
      }

      if (var2.has(field18477) && var2.get(field18478).getAsBoolean()) {
         var4.method05242(var3.method03913());
         var4.method05243(var2.has(field18479) && var2.get(field18480).getAsBoolean());
      }

      return true;
   }

   private static JsonObject method07615(ProxyConfig var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty(field18486, var0.method03913());
      var1.addProperty(field18487, var0.method03917());
      var1.addProperty(field18488, var0.method03916());
      var1.addProperty(field18489, var0.method03904());
      var1.addProperty(field18490, var0.method03912());
      var1.addProperty(field18491, var0.method03901().name());
      var1.addProperty(field18492, var0.method03899());
      var1.addProperty(field18493, var0.method03915());
      return var1;
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         return var2.length == 0 || method07612(var2);
      } catch (Exception var6) {
         return false;
      }
   }

   private static byte[] method07616() {
      ProxyManager var0 = ProxyManager.INSTANCE;
      JsonObject var1 = new JsonObject();
      var1.addProperty(field18483, var0.method05240());
      var1.addProperty(field18484, var0.method05239());
      JsonArray var2 = new JsonArray();

      for (ProxyConfig var4 : var0.method05237()) {
         var2.add(method07615(var4));
      }

      var1.add(field18485, var2);
      return var1.toString().getBytes(StandardCharsets.UTF_8);
   }

   public static byte[] method07617() {
      try {
         return CustomResourceManager.method02469(method07616());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private static JsonObject method07618(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         JsonObject var1 = method07619(CustomResourceManager.method02470(var0));
         return var1 == null ? method07619(var0) : var1;
      } else {
         return null;
      }
   }

   private static JsonObject method07619(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            JsonElement var1 = JsonParser.parseString(new String(var0, StandardCharsets.UTF_8));
            return var1.isJsonObject() ? var1.getAsJsonObject() : null;
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   public static byte[] method07620(ProxyConfig var0) {
      if (var0 == null) {
         return new byte[0];
      }

      ProxyManager var1 = ProxyManager.INSTANCE;
      JsonObject var2 = method07615(var0);
      boolean var3 = var1.method05229(var0.method03913());
      var2.addProperty(field18481, var3);
      var2.addProperty(field18482, var3 && var1.method05240());

      try {
         return CustomResourceManager.method02469(var2.toString().getBytes(StandardCharsets.UTF_8));
      } catch (Exception var5) {
         return new byte[0];
      }
   }
}
