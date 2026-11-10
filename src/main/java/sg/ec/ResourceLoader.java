// Original binary: sg/ec/KcIH124OBU1x17Qv
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;

// $VF: Compiled from s
public final class ResourceLoader {
   private static final Gson field09667 = new Gson();
   private static final String field09668 = "Minecraft ResourceManager is not initialized yet";
   private static final String field09669 = "Hex";
   private static final String field09670 = "\n";

   public static Identifier method04276(String var0) {
      return Identifier.fromNamespaceAndPath(field09669.toLowerCase(), "core/" + var0);
   }

   public static <T> T method04277(Identifier var0, Class<T> var1) {
      try (
         InputStream var2 = method04280().open(var0);
         InputStreamReader var3 = new InputStreamReader(var2, StandardCharsets.UTF_8);
      ) {
         return (T)(Object)field09667.fromJson(var3, var1);
      } catch (IOException var10) {
         throw new RuntimeException(var10);
      }
   }

   public static String method04278(Identifier var0, String var1) {
      try (
         InputStream var2 = method04280().open(var0);
         BufferedReader var3 = new BufferedReader(new InputStreamReader(var2, StandardCharsets.UTF_8));
      ) {
         StringBuilder var4 = new StringBuilder();

         String var5;
         for (boolean var6 = true; (var5 = var3.readLine()) != null; var6 = false) {
            if (!var6) {
               var4.append(var1);
            }

            var4.append(var5);
         }

         return var4.toString();
      } catch (IOException var12) {
         throw new RuntimeException(var12);
      }
   }

   public static JsonObject method04279(Identifier var0) {
      try (
         InputStream var1 = method04280().open(var0);
         InputStreamReader var2 = new InputStreamReader(var1, StandardCharsets.UTF_8);
      ) {
         return JsonParser.parseReader(var2).getAsJsonObject();
      } catch (IOException var9) {
         throw new RuntimeException(var9);
      }
   }

   private static ResourceManager method04280() {
      Minecraft var0 = Minecraft.getInstance();
      if (var0 != null && var0.getResourceManager() != null) {
         return var0.getResourceManager();
      } else {
         throw new IllegalStateException(field09668);
      }
   }

   public static String method04281(Identifier var0) {
      return method04278(var0, field09670);
   }
}
