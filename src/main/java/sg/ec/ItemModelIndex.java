// Original binary: sg/ec/JgCov6Ak4lprmO7F
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Comparator;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class ItemModelIndex {
   public static final String field09246 = "items";
   public static final String field09247 = "field09247";
   private static final String field09248 = "field09248";
   private static final String field09249 = "field09249";
   private static final String field09250 = "field09250";
   private static final String field09251 = "items/";
   private static final String field09252 = ".json";
   private static final String field09253 = "items";
   private static final String field09254 = "models/item/";
   private static final String field09255 = ".json";
   private static final String field09256 = "models/item";
   private static final String field09257 = "type";
   private static final String field09258 = "minecraft:range_dispatch";
   private static final String field09259 = "property";
   private static final String field09260 = "minecraft:custom_model_data";
   private static final String field09261 = "entries";
   private static final String field09262 = "fallback";
   private static final String field09263 = "model";
   private static final String field09264 = "overrides";
   private static final String field09265 = "predicate";
   private static final String field09266 = "custom_model_data";
   private static final String field09267 = "predicate";
   private static final String field09268 = "custom_model_data";
   private static final String field09269 = "model";
   private static final String field09270 = "threshold";
   private static final String field09271 = "model";
   private static final String field09272 = "type";
   private static final String field09273 = "minecraft:model";
   private static final String field09274 = "model";
   private static final String field09275 = "models/";
   private static final String field09276 = ".json";
   private static final String field09277 = "This is a utility class and cannot be instantiated";
   private static final String field09278 = "threshold";

   public static Identifier method04074(Identifier var0) {
      return Identifier.fromNamespaceAndPath(var0.getNamespace(), "models/item" + var0.getPath().substring(field09253.length()));
   }

   private static Identifier method04075(Identifier var0) {
      String var1 = var0.getPath();
      return Identifier.fromNamespaceAndPath(var0.getNamespace(), var1.substring(field09275.length(), var1.length() - field09276.length()));
   }

   public static String method04076(Identifier var0, String var1) {
      JsonArray var2 = method04082(var1);
      if (var2 == null) {
         return null;
      }

      ArrayList<JsonObject> var3 = new ArrayList<>();

      for (JsonElement var5 : var2) {
         JsonObject var6 = method04083(var5.getAsJsonObject());
         if (var6 == null) {
            return null;
         }

         var3.add(var6);
      }

      if (var3.isEmpty()) {
         return null;
      }

      var3.sort(Comparator.comparingDouble(var0x -> var0x.get(field09278).getAsDouble()));
      JsonArray var7 = new JsonArray();

      for (JsonObject var10 : (Iterable<JsonObject>) (Iterable) var3) {
         var7.add(var10);
      }

      JsonObject var9 = new JsonObject();
      var9.addProperty(field09257, field09258);
      var9.addProperty(field09259, field09260);
      var9.add(field09261, var7);
      var9.add(field09262, method04078(method04075(var0)));
      JsonObject var11 = new JsonObject();
      var11.add(field09263, var9);
      return var11.toString();
   }

   private static boolean method04077(JsonObject var0) {
      JsonElement var1 = var0.get(field09265);
      if (var1 != null && var1.isJsonObject()) {
         JsonObject var2 = var1.getAsJsonObject();
         return var2.size() == 1 && var2.has(field09266);
      } else {
         return false;
      }
   }

   private static JsonObject method04078(Identifier var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty(field09272, field09273);
      var1.addProperty(field09274, var0.toString());
      return var1;
   }

   private static Identifier method04079(String var0) {
      try {
         return Identifier.parse(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   private ItemModelIndex() {
      throw new UnsupportedOperationException(field09277);
   }

   public static Identifier method04080(Identifier var0) {
      String var1 = var0.getPath();
      return var1.startsWith(field09254) && var1.endsWith(field09255)
         ? Identifier.fromNamespaceAndPath(var0.getNamespace(), "items" + var1.substring(field09256.length()))
         : null;
   }

   public static boolean method04081(Identifier var0) {
      String var1 = var0.getPath();
      return var1.startsWith(field09251) && var1.endsWith(field09252);
   }

   private static JsonArray method04082(String var0) {
      JsonElement var1;
      try {
         var1 = JsonParser.parseString(var0);
      } catch (Exception var5) {
         return null;
      }

      if (!var1.isJsonObject()) {
         return null;
      }

      JsonArray var2 = var1.getAsJsonObject().getAsJsonArray(field09264);
      if (var2 != null && !var2.isEmpty()) {
         for (JsonElement var4 : var2) {
            if (!var4.isJsonObject() || !method04077(var4.getAsJsonObject())) {
               return null;
            }
         }

         return var2;
      } else {
         return null;
      }
   }

   private static JsonObject method04083(JsonObject var0) {
      JsonElement var1 = var0.getAsJsonObject(field09267).get(field09268);
      JsonElement var2 = var0.get(field09269);
      if (!var1.isJsonPrimitive() || !var1.getAsJsonPrimitive().isNumber()) {
         return null;
      }

      if (var2 != null && var2.isJsonPrimitive() && var2.getAsJsonPrimitive().isString()) {
         Identifier var3 = method04079(var2.getAsString());
         if (var3 == null) {
            return null;
         }

         JsonObject var4 = new JsonObject();
         var4.addProperty(field09270, var1.getAsFloat());
         var4.add(field09271, method04078(var3));
         return var4;
      } else {
         return null;
      }
   }
}
