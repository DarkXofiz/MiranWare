// Original binary: sg/ec/Iwf8IgJNTWmEVWqO
package sg.ec;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class BlockEspEntry {
   private BlockState field08826;
   private BlockEntityType<?> field08827;
   private EntityType<?> field08828;
   private ItemStack field08829;
   private String field08830;
   private RgbColor field08831;
   private int field08832;
   private boolean field08833;
   private boolean field08834;

   public int method03975() {
      return this.field08832;
   }

   public void method03976(RgbColor var1) {
      this.field08831 = var1;
   }

   public ItemStack method03977() {
      if (this.field08829 == null) {
         this.field08829 = this.field08828 != null ? new ItemStack(BlockNameUtils.method03818(this.field08828)) : new ItemStack(this.field08826.getBlock());
      }

      return this.field08829;
   }

   public void method03978(ItemStack var1) {
      this.field08829 = var1;
   }

   public RgbColor method03979() {
      return this.field08831;
   }

   public EntityType<?> method03980() {
      return this.field08828;
   }

   public void method03981(boolean var1) {
      this.field08833 = var1;
   }

   public boolean method03982() {
      return this.field08828 != null || this.field08826 != null;
   }

   public BlockState method03983() {
      return this.field08826;
   }

   public boolean method03984() {
      return this.field08834;
   }

   public void method03985(int var1) {
      this.field08832 = var1;
   }

   public void method03986(String var1) {
      this.field08830 = var1;
   }

   public static BlockEspEntry method03987(BlockEntityType<?> var0, RgbColor var1, int var2, boolean var3) {
      BlockEspEntry var4 = new BlockEspEntry(BlockNameUtils.method03816(var0), BlockNameUtils.method03815(var0), var1, var2, true, var3);
      var4.field08827 = var0;
      return var4;
   }

   public String method03988() {
      return this.field08830;
   }

   public BlockEntityType<?> method03989() {
      return this.field08827;
   }

   public void method03990(boolean var1) {
      this.field08834 = var1;
   }

   public void method03991(BlockState var1) {
      this.field08826 = var1;
      this.field08829 = null;
   }

   public static BlockEspEntry method03992(EntityType<?> var0, RgbColor var1, int var2, boolean var3) {
      BlockEspEntry var4 = new BlockEspEntry(null, BlockNameUtils.method03811(var0), var1, var2, true, var3);
      var4.field08828 = var0;
      return var4;
   }

   public boolean method03993() {
      return this.field08833;
   }

   public BlockEspEntry(BlockState var1, String var2, RgbColor var3, int var4, boolean var5, boolean var6) {
      this.field08826 = var1;
      this.field08830 = var2;
      this.field08831 = var3;
      this.field08832 = var4;
      this.field08833 = var5;
      this.field08834 = var6;
   }

   // $VF: Compiled from s
   public static class Nested116 implements JsonSerializer<BlockEspEntry>, JsonDeserializer<BlockEspEntry> {
      private static final String field08835 = "color";
      private static final String field08836 = "order";
      private static final String field08837 = "active";
      private static final String field08838 = "tile";
      private static final String field08839 = "tile";
      private static final String field08840 = "entity";
      private static final String field08841 = "entity";
      private static final String field08842 = "state";
      private static final String field08843 = "name";
      private static final String field08844 = "isDefault";
      private static final String field08845 = "tile";
      private static final String field08846 = "entity";
      private static final String field08847 = "state";
      private static final String field08848 = "name";
      private static final String field08849 = "color";
      private static final String field08850 = "order";
      private static final String field08851 = "isDefault";
      private static final String field08852 = "active";

      public BlockEspEntry deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         RgbColor var5 = RgbColor.method01350(var4.get(field08835).getAsString());
         int var6 = var4.get(field08836).getAsInt();
         boolean var7 = var4.get(field08837).getAsBoolean();
         if (var4.has(field08838)) {
            BlockEntityType var9 = BlockNameUtils.method03819(var4.get(field08839).getAsString());
            return var9 == null ? null : BlockEspEntry.method03987(var9, var5, var6, var7);
         } else if (var4.has(field08840)) {
            EntityType var8 = BlockNameUtils.method03821(var4.get(field08841).getAsString());
            return var8 == null ? null : BlockEspEntry.method03992(var8, var5, var6, var7);
         } else {
            return new BlockEspEntry(
               ThemeColorEntry.method06789(var4.get(field08842).getAsString()),
               var4.get(field08843).getAsString(),
               var5,
               var6,
               var4.get(field08844).getAsBoolean(),
               var7
            );
         }
      }

      public JsonElement serialize(BlockEspEntry var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         if (var1.field08827 != null) {
            var4.addProperty(field08845, BlockNameUtils.method03810(var1.field08827));
         } else if (var1.field08828 != null) {
            var4.addProperty(field08846, BlockNameUtils.method03814(var1.field08828));
         } else {
            var4.addProperty(field08847, ThemeColorEntry.method06788(var1.method03983()));
         }

         var4.addProperty(field08848, var1.field08830);
         var4.addProperty(field08849, var1.field08831.toHex());
         var4.addProperty(field08850, var1.field08832);
         var4.addProperty(field08851, var1.field08833);
         var4.addProperty(field08852, var1.field08834);
         return var4;
      }
   }
}
