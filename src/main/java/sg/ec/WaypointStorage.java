// Original binary: sg/ec/7e20d04AuKr4EJOC
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public class WaypointStorage extends AbstractStorage {
   private static final Gson field04438 = new GsonBuilder().setPrettyPrinting().create();
   private static final String field04439 = "WayPoint";
   private static final String field04440 = "WayPoint";
   private static final String field04441 = "name";
   private static final String field04442 = "x";
   private static final String field04443 = "y";
   private static final String field04444 = "z";
   private static final String field04445 = "name";
   private static final String field04446 = "x";
   private static final String field04447 = "y";
   private static final String field04448 = "z";
   private static final String field04449 = "name";
   private static final String field04450 = "x";
   private static final String field04451 = "y";
   private static final String field04452 = "z";
   private static final String field04453 = "WayPoint";
   private static final String field04454 = "WayPoint";
   private static final String field04455 = "name";
   private static final String field04456 = "x";
   private static final String field04457 = "y";
   private static final String field04458 = "z";
   private static final String field04459 = "name";
   private static final String field04460 = "x";
   private static final String field04461 = "y";
   private static final String field04462 = "z";

   public static byte[] method01737() {
      try {
         return CustomResourceManager.method02469(method01740());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private List<WaypointStorage.Nested51> method01738(JsonObject var1) {
      if (var1 == null) {
         return null;
      }

      JsonArray var2 = var1.getAsJsonArray(field04440);
      if (var2 == null) {
         return new ArrayList<>();
      }

      ArrayList var3 = new ArrayList();

      for (JsonElement var5 : var2) {
         if (var5.isJsonObject()) {
            JsonObject var6 = var5.getAsJsonObject();
            if (var6.has(field04441) && var6.has(field04442) && var6.has(field04443) && var6.has(field04444)) {
               String var7 = var6.get(field04445).getAsString();
               if (var7 != null && !var7.isBlank()) {
                  float var8 = var6.get(field04446).getAsFloat();
                  float var9 = var6.get(field04447).getAsFloat();
                  float var10 = var6.get(field04448).getAsFloat();
                  var3.add(new WaypointStorage.Nested51(var8, var9, var10, var7));
               }
            }
         }
      }

      return var3;
   }

   private static JsonObject method01739(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            return (JsonObject)field04438.fromJson(new String(var0, StandardCharsets.UTF_8), JsonObject.class);
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static byte[] method01740() {
      JsonObject var0 = new JsonObject();
      JsonArray var1 = new JsonArray();

      for (Waypoint var3 : WaypointManager.INSTANCE.method09838()) {
         JsonObject var4 = new JsonObject();
         var4.addProperty(field04449, var3.method11262());
         var4.addProperty(field04450, var3.method11264());
         var4.addProperty(field04451, var3.method11260());
         var4.addProperty(field04452, var3.method11269());
         var1.add(var4);
      }

      var0.add(field04453, var1);
      return field04438.toJson(var0).getBytes(StandardCharsets.UTF_8);
   }

   private JsonObject method01741(byte[] var1) {
      if (var1 != null && var1.length != 0) {
         try {
            return (JsonObject)field04438.fromJson(new String(var1, StandardCharsets.UTF_8), JsonObject.class);
         } catch (Exception var3) {
            return null;
         }
      } else {
         return null;
      }
   }

   public WaypointStorage(File var1) {
      super(var1);
   }

   @Override
   public boolean method00296() {
      return this.method03302(method01740());
   }

   public static boolean method01742(byte[] var0) {
      if (var0 == null) {
         return false;
      }

      if (var0.length == 0) {
         WaypointManager.INSTANCE.method09836(false);
         return true;
      }

      JsonObject var1 = method01739(CustomResourceManager.method02470(var0));
      if (var1 == null) {
         var1 = method01739(var0);
      }

      if (var1 == null) {
         return false;
      }

      JsonArray var2 = var1.getAsJsonArray(field04454);
      WaypointManager.INSTANCE.method09836(false);
      if (var2 != null) {
         for (JsonElement var4 : var2) {
            if (var4.isJsonObject()) {
               JsonObject var5 = var4.getAsJsonObject();
               if (var5.has(field04455) && var5.has(field04456) && var5.has(field04457) && var5.has(field04458)) {
                  String var6 = var5.get(field04459).getAsString();
                  if (var6 != null && !var6.isBlank()) {
                     WaypointManager.INSTANCE
                        .method09833(var5.get(field04460).getAsFloat(), var5.get(field04461).getAsFloat(), var5.get(field04462).getAsFloat(), var6, false);
                  }
               }
            }
         }
      }

      return true;
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         if (var2.length == 0) {
            WaypointManager.INSTANCE.method09836(false);
            return true;
         }

         JsonObject var3 = this.method01741(CustomResourceManager.method02470(var2));
         if (var3 == null) {
            var3 = this.method01741(var2);
         }

         if (var3 == null) {
            return false;
         }

         var var4 = this.method01738(var3);
         if (var4 == null) {
            return false;
         }

         WaypointManager.INSTANCE.method09836(false);

         for (WaypointStorage.Nested51 var6 : var4) {
            WaypointManager.INSTANCE.method09833(var6.field04463, var6.field04464, var6.field04465, var6.field04466, false);
         }

         return true;
      } catch (Exception var9) {
         return false;
      }
   }

   // $VF: Compiled from s
   private static class Nested51 {
      private final float field04463;
      private final float field04464;
      private final float field04465;
      private final String field04466;

      private Nested51(float var1, float var2, float var3, String var4) {
         this.field04463 = var1;
         this.field04464 = var2;
         this.field04465 = var3;
         this.field04466 = var4;
      }
   }
}
