// Original binary: sg/ec/HQPjgEVLhxSpDIig
package sg.ec;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// $VF: Compiled from s
public final class ItemModelTransformer {
   private static final String field08529 = "special";
   private static final String field08530 = "field08530";
   private static final String field08531 = "field08531";
   private static final String field08532 = "field08532";
   private static final String field08533 = "field08533";
   private static final String field08534 = "field08534";
   private static final String field08535 = "field08535";
   private static final String field08536 = "field08536";
   private static final String field08537 = "field08537";
   private static final String field08538 = "field08538";
   private static final String field08539 = "field08539";
   private static final String[] field08540 = new String[]{
      ItemModelTransformer.field08559,
      ItemModelTransformer.field08560,
      ItemModelTransformer.field08561,
      ItemModelTransformer.field08562,
      ItemModelTransformer.field08563,
      ItemModelTransformer.field08564,
      ItemModelTransformer.field08565,
      ItemModelTransformer.field08566,
      ItemModelTransformer.field08567,
      ItemModelTransformer.field08568
   };
   private static final Map<String, JsonObject> field08541 = method03793();
   private static final String field08542 = "special";
   private static final String field08543 = "model";
   private static final String field08544 = "transformation";
   private static final String field08545 = "transformation";
   private static final String field08546 = "head";
   private static final String field08547 = "texture";
   private static final String field08548 = "kind";
   private static final String field08549 = "player";
   private static final String field08550 = "animation";
   private static final String field08551 = "kind";
   private static final String field08552 = "animation";
   private static final String field08553 = "type";
   private static final String field08554 = "minecraft:player_head";
   private static final String field08555 = "type";
   private static final String field08556 = "minecraft:";
   private static final String field08557 = "minecraft:";
   private static final String field08558 = "This is a utility class and cannot be instantiated";
   private static final String field08559 = "banner";
   private static final String field08560 = "{\"left_rotation\":[0.0,-0.0,0.0,1.0],\"right_rotation\":[0.0,0.0,0.0,1.0],\"scale\":[0.6666667,-0.6666667,-0.6666667],\"translation\":[0.5,0.0,0.5]}";
   private static final String field08561 = "conduit";
   private static final String field08562 = "{\"left_rotation\":[0.0,0.0,0.0,1.0],\"right_rotation\":[0.0,0.0,0.0,1.0],\"scale\":[1.0,1.0,1.0],\"translation\":[0.5,0.5,0.5]}";
   private static final String field08563 = "head";
   private static final String field08564 = "{\"left_rotation\":[1.0,0.0,0.0,-0.0],\"right_rotation\":[0.0,0.0,0.0,1.0],\"scale\":[1.0,1.0,1.0],\"translation\":[0.5,0.0,0.5]}";
   private static final String field08565 = "player_head";
   private static final String field08566 = "{\"left_rotation\":[1.0,0.0,0.0,-0.0],\"right_rotation\":[0.0,0.0,0.0,1.0],\"scale\":[1.0,1.0,1.0],\"translation\":[0.5,0.0,0.5]}";
   private static final String field08567 = "shulker_box";
   private static final String field08568 = "{\"left_rotation\":[1.0,0.0,0.0,0.0],\"right_rotation\":[-0.0,-0.0,-0.0,1.0],\"scale\":[0.9995,0.9995,0.9995],\"translation\":[0.5,1.4995,0.5]}";

   private static String method03791(JsonObject var0) {
      JsonElement var1 = var0.get(field08555);
      return var1 != null && var1.isJsonPrimitive() ? var1.getAsString() : null;
   }

   private static boolean method03792(JsonElement var0) {
      if (var0.isJsonArray()) {
         boolean var5 = false;

         for (JsonElement var7 : var0.getAsJsonArray()) {
            var5 |= method03792(var7);
         }

         return var5;
      } else {
         if (!var0.isJsonObject()) {
            return false;
         }

         JsonObject var1 = var0.getAsJsonObject();
         boolean var2 = method03794(var1);

         for (var var4 : var1.entrySet()) {
            var2 |= method03792((JsonElement)var4.getValue());
         }

         return var2;
      }
   }

   private static Map<String, JsonObject> method03793() {
      HashMap var0 = new HashMap();

      for (byte var1 = 0; var1 < field08540.length; var1 += 2) {
         var0.put(field08540[var1], JsonParser.parseString(field08540[var1 + 1]).getAsJsonObject());
      }

      return Map.copyOf(var0);
   }

   private ItemModelTransformer() {
      throw new UnsupportedOperationException(field08558);
   }

   private static boolean method03794(JsonObject var0) {
      if (!field08542.equals(method03795(method03791(var0)))) {
         return false;
      }

      JsonElement var1 = var0.get(field08543);
      if (var1 != null && var1.isJsonObject()) {
         boolean var2 = method03797(var1.getAsJsonObject());
         if (var0.has(field08544)) {
            return var2;
         }

         JsonObject var3 = field08541.get(method03795(method03791(var1.getAsJsonObject())));
         if (var3 == null) {
            return var2;
         }

         var0.add(field08545, var3.deepCopy());
         return true;
      } else {
         return false;
      }
   }

   private static String method03795(String var0) {
      if (var0 == null) {
         return null;
      } else {
         return var0.startsWith(field08556) ? var0.substring(field08557.length()) : var0;
      }
   }

   public static String method03796(String var0) {
      JsonElement var1;
      try {
         var1 = JsonParser.parseString(var0);
      } catch (Exception var3) {
         return var0;
      }

      return var1.isJsonObject() && method03792(var1) ? var1.toString() : var0;
   }

   private static boolean method03797(JsonObject var0) {
      if (field08546.equals(method03795(method03791(var0))) && !var0.has(field08547)) {
         JsonElement var1 = var0.get(field08548);
         if (var1 != null && var1.isJsonPrimitive() && field08549.equals(method03795(var1.getAsString()))) {
            JsonElement var2 = var0.get(field08550);
            if (var2 != null && var2.isJsonPrimitive() && var2.getAsFloat() != 0.0F) {
               return false;
            }

            var0.remove(field08551);
            var0.remove(field08552);
            var0.addProperty(field08553, field08554);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
