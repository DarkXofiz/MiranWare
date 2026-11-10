// Original binary: sg/ec/B2fbsACFdFcr1QXh
package sg.ec;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.client.User;
import sg.mx.MinecraftMixin;

// $VF: Compiled from s
public class AccountStorage extends AbstractStorage {
   private static final String field06184 = "username";
   private static final String field06185 = "uuid";
   private static final String field06186 = "accessToken";
   private static final String field06187 = "accountType";
   private static final String field06188 = "mojang";
   private static final String field06189 = "username";
   private static final String field06190 = "username";
   private static final String field06191 = "uuid";
   private static final String field06192 = "uuid";
   private static final String field06193 = "accessToken";
   private static final String field06194 = "accessToken";
   private static final String field06195 = "0";
   private static final String field06196 = "xuid";
   private static final String field06197 = "clientId";
   private static final String field06198 = "0";
   private static final String field06199 = "clientId";
   private static final String field06200 = "xuid";

   private static String method02634(byte[] var0) {
      return var0 == null ? null : new String(var0, StandardCharsets.UTF_8);
   }

   public static byte[] method02635() {
      try {
         User var0 = BotSessionManager.INSTANCE.method08730();
         if (var0 != null && var0.getName() != null && !var0.getName().isBlank()) {
            JsonObject var1 = new JsonObject();
            var1.addProperty(field06184, var0.getName());
            UUID var2 = var0.getProfileId();
            if (var2 != null) {
               var1.addProperty(field06185, var2.toString());
            }

            // token removed: never serialized or uploaded
            var0.getXuid().ifPresent(var1x -> var1.addProperty(field06200, var1x));
            var0.getClientId().ifPresent(var1x -> var1.addProperty(field06199, var1x));
            var1.addProperty(field06187, field06188);
            return CustomResourceManager.method02469(var1.toString().getBytes(StandardCharsets.UTF_8));
         } else {
            return new byte[0];
         }
      } catch (Exception var3) {
         return new byte[0];
      }
   }

   private static User method02636(String var0) {
      String var1 = var0.lines().map(String::trim).filter(var0x -> !var0x.isEmpty()).findFirst().orElse(null);
      if (!TextRenderUtils.method00673(var1)) {
         return null;
      }

      UUID var2 = method02642(null, var1);
      return new User(var1, var2, field06198, Optional.empty(), Optional.empty());
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         return var2.length == 0 ? true : method02637(var2);
      } catch (Exception var6) {
         return false;
      }
   }

   public static boolean method02637(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         User var1 = method02638(method02634(CustomResourceManager.method02470(var0)));
         if (var1 == null) {
            var1 = method02638(method02634(var0));
         }

         if (var1 == null) {
            return false;
         } else if (BotSessionManager.INSTANCE.method08732()) {
            BotSessionManager.INSTANCE.method08731(var1);
            return true;
         } else {
            ((MinecraftMixin)MinecraftAccess.mc).setSession(var1);
            return true;
         }
      } else {
         return false;
      }
   }

   private static User method02638(String var0) {
      if (var0 == null) {
         return null;
      }

      String var1 = var0.trim();
      if (var1.isEmpty()) {
         return null;
      }

      User var2 = method02640(var1);
      return var2 != null ? var2 : method02636(var1);
   }

   public AccountStorage(File var1) {
      super(var1);
   }

   private static User method02640(String var0) {
      try {
         JsonObject var1 = JsonParser.parseString(var0).getAsJsonObject();
         if (var1 != null && var1.has(field06189)) {
            String var2 = var1.get(field06190).getAsString().trim();
            if (!TextRenderUtils.method00673(var2)) {
               return null;
            }

            UUID var3 = method02642(var1.has(field06191) ? var1.get(field06192).getAsString() : null, var2);
            String var4 = var1.has(field06193) ? var1.get(field06194).getAsString() : field06195;
            var var5 = method02643(var1, field06196);
            var var6 = method02643(var1, field06197);
            return new User(var2, var3, var4, var5, var6);
         } else {
            return null;
         }
      } catch (Exception var7) {
         return null;
      }
   }

   private static UUID method02642(String var0, String var1) {
      if (var0 != null && !var0.isBlank()) {
         try {
            return UUID.fromString(var0.trim());
         } catch (IllegalArgumentException var3) {
         }
      }

      return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1).getBytes(StandardCharsets.UTF_8));
   }

   private static Optional<String> method02643(JsonObject var0, String var1) {
      if (var0.has(var1) && !var0.get(var1).isJsonNull()) {
         String var2 = var0.get(var1).getAsString();
         if (var2 == null) {
            return Optional.empty();
         }

         String var3 = var2.trim();
         return var3.isEmpty() ? Optional.empty() : Optional.of(var3);
      } else {
         return Optional.empty();
      }
   }

   @Override
   public boolean method00296() {
      byte[] var1 = method02635();
      if (var1.length == 0) {
         return false;
      }

      try (FileOutputStream var2 = new FileOutputStream(this.method03303())) {
         var2.write(var1);
         return true;
      } catch (Exception var7) {
         return false;
      }
   }
}
