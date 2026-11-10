// Original binary: sg/ec/rs1tRHreCMbFRR5Y
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// $VF: Compiled from s
public final class BlockEspConfigCodec {
   private String field23478;
   private List<BlockEspEntry> field23479;
   private int field23480;
   private boolean field23481;

   public void method10510(List<BlockEspEntry> var1) {
      this.field23479 = var1;
   }

   @Override
   public String toString() {
      return "BlockGroup[name=" + this.field23478 + ", entries=" + this.field23479 + ", order=" + this.field23480 + ", active=" + this.field23481 + "]";
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (var1 != null && var1.getClass() == this.getClass()) {
         BlockEspConfigCodec var2 = (BlockEspConfigCodec)var1;
         return Objects.equals(this.field23478, var2.field23478)
            && Objects.equals(this.field23479, var2.field23479)
            && this.field23480 == var2.field23480
            && this.field23481 == var2.field23481;
      } else {
         return false;
      }
   }

   public String method10511() {
      return this.field23478;
   }

   public BlockEspConfigCodec(String var1, List<BlockEspEntry> var2, int var3, boolean var4) {
      this.field23478 = var1;
      this.field23479 = var2;
      this.field23480 = var3;
      this.field23481 = var4;
   }

   public List<BlockEspEntry> method10512() {
      return this.field23479;
   }

   public boolean method10513() {
      return this.field23481;
   }

   public void method10514(int var1) {
      this.field23480 = var1;
   }

   public String method10515() {
      return this.field23478;
   }

   public boolean method10516() {
      return this.field23481;
   }

   public void method10517(boolean var1) {
      this.field23481 = var1;
   }

   public int method10518() {
      return this.field23480;
   }

   @Override
   public int hashCode() {
      return Objects.hash(this.field23478, this.field23479, this.field23480, this.field23481);
   }

   public void method10519(String var1) {
      this.field23478 = var1;
   }

   public List<BlockEspEntry> method10520() {
      return this.field23479;
   }

   public int method10521() {
      return this.field23480;
   }

   // $VF: Compiled from s
   public static class Nested303 implements JsonSerializer<BlockEspConfigCodec>, JsonDeserializer<BlockEspConfigCodec> {
      private static final String field23482 = "entries";
      private static final String field23483 = "name";
      private static final String field23484 = "name";
      private static final String field23485 = "Default";
      private static final String field23486 = "order";
      private static final String field23487 = "order";
      private static final String field23488 = "active";
      private static final String field23489 = "active";
      private static final String field23490 = "name";
      private static final String field23491 = "Default";
      private static final String field23492 = "entries";
      private static final String field23493 = "order";
      private static final String field23494 = "active";

      public BlockEspConfigCodec deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         ArrayList var5 = new ArrayList();
         JsonElement var6 = var4.get(field23482);
         if (var6 != null && var6.isJsonArray()) {
            for (JsonElement var8 : var6.getAsJsonArray()) {
               BlockEspEntry var9 = (BlockEspEntry)var3.deserialize(var8, BlockEspEntry.class);
               if (var9 != null && var9.method03982()) {
                  var5.add(var9);
               }
            }
         }

         return new BlockEspConfigCodec(
            var4.has(field23483) ? var4.get(field23484).getAsString() : field23485,
            var5,
            var4.has(field23486) ? var4.get(field23487).getAsInt() : 0,
            !var4.has(field23488) || var4.get(field23489).getAsBoolean()
         );
      }

      public JsonElement serialize(BlockEspConfigCodec var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         var4.addProperty(field23490, var1.field23478 == null ? field23491 : var1.field23478);
         JsonArray var5 = new JsonArray();
         if (var1.field23479 != null) {
            for (BlockEspEntry var7 : var1.field23479) {
               if (var7 != null && var7.method03982()) {
                  var5.add(var3.serialize(var7, BlockEspEntry.class));
               }
            }
         }

         var4.add(field23492, var5);
         var4.addProperty(field23493, var1.field23480);
         var4.addProperty(field23494, var1.field23481);
         return var4;
      }
   }
}
