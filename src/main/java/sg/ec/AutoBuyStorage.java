// Original binary: sg/ec/6Krt5xyDZDozWteV
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class AutoBuyStorage extends AbstractStorage {
   private static final Gson field03030 = new GsonBuilder().setPrettyPrinting().create();
   private static final String field03031 = "server";
   private static final String field03032 = "settings";
   private static final String field03033 = "entries";
   private static final String field03034 = "history";
   private static final String field03035 = "sales";
   private static final String field03036 = "blockedSellers";
   private static final String field03037 = "actionDelayMs";
   private static final String field03038 = "humanizeDelays";
   private static final String field03039 = "tickSync";
   private static final String field03040 = "totemLimit";
   private static final String field03041 = "logSkipReasons";
   private static final String field03042 = "auctionCommand";
   private static final String field03043 = "overlayEnabled";
   private static final String field03044 = "autoInvisibility";
   private static final String field03045 = "antiAfkSpin";
   private static final String field03046 = "paybackMode";
   private static final String field03047 = "paybackMinDiscountPercent";
   private static final String field03048 = "autoSell";
   private static final String field03049 = "autoRelist";
   private static final String field03050 = "sellMarkupPercent";
   private static final String field03051 = "priceScan";
   private static final String field03052 = "tradeMode";
   private static final String field03053 = "scanDebug";
   private static final String field03054 = "scanIntervalMinutes";
   private static final String field03055 = "scanMarkupPercent";
   private static final String field03056 = "keepAliveCommand";
   private static final String field03057 = "keepAliveIntervalMinutes";
   private static final String field03058 = "botActiveBuyers";
   private static final String field03059 = "botShiftMinutes";
   private static final String field03060 = "server";
   private static final String field03061 = "key";
   private static final String field03062 = "enabled";
   private static final String field03063 = "max";
   private static final String field03064 = "min";
   private static final String field03065 = "durability";
   private static final String field03066 = "markupOverride";
   private static final String field03067 = "markup";
   private static final String field03068 = "market";
   private static final String field03069 = "item";
   private static final String field03070 = "id";
   private static final String field03071 = "name";
   private static final String field03072 = "nbt";
   private static final String field03073 = "texture";
   private static final String field03074 = "containerValued";
   private static final String field03075 = "enchantments";
   private static final String field03076 = "lore";
   private static final String field03077 = "effects";
   private static final String field03078 = "id";
   private static final String field03079 = "count";
   private static final String field03080 = "name";
   private static final String field03081 = "paid";
   private static final String field03082 = "ceiling";
   private static final String field03083 = "market";
   private static final String field03084 = "seller";
   private static final String field03085 = "time";
   private static final String field03086 = "server";
   private static final String field03087 = "id";
   private static final String field03088 = "count";
   private static final String field03089 = "name";
   private static final String field03090 = "ask";
   private static final String field03091 = "paid";
   private static final String field03092 = "buyer";
   private static final String field03093 = "listed";
   private static final String field03094 = "sold";
   private static final String field03095 = "server";
   private static final String field03096 = "settings";
   private static final String field03097 = "settings";
   private static final String field03098 = "entries";
   private static final String field03099 = "entries";
   private static final String field03100 = "blockedSellers";
   private static final String field03101 = "blockedSellers";
   private static final String field03102 = "sales";
   private static final String field03103 = "sales";
   private static final String field03104 = "history";
   private static final String field03105 = "history";
   private static final String field03106 = "server";
   private static final String field03107 = "server";
   private static final String field03108 = "actionDelayMs";
   private static final String field03109 = "humanizeDelays";
   private static final String field03110 = "tickSync";
   private static final String field03111 = "totemLimit";
   private static final String field03112 = "logSkipReasons";
   private static final String field03113 = "auctionCommand";
   private static final String field03114 = "overlayEnabled";
   private static final String field03115 = "autoInvisibility";
   private static final String field03116 = "antiAfkSpin";
   private static final String field03117 = "paybackMode";
   private static final String field03118 = "paybackMinDiscountPercent";
   private static final String field03119 = "autoSell";
   private static final String field03120 = "autoRelist";
   private static final String field03121 = "sellMarkupPercent";
   private static final String field03122 = "priceScan";
   private static final String field03123 = "tradeMode";
   private static final String field03124 = "scanDebug";
   private static final String field03125 = "scanIntervalMinutes";
   private static final String field03126 = "scanMarkupPercent";
   private static final String field03127 = "keepAliveCommand";
   private static final String field03128 = "keepAliveIntervalMinutes";
   private static final String field03129 = "botActiveBuyers";
   private static final String field03130 = "botShiftMinutes";
   private static final String field03131 = "server";
   private static final String field03132 = "key";
   private static final String field03133 = "key";
   private static final String field03134 = "max";
   private static final String field03135 = "min";
   private static final String field03136 = "durability";
   private static final String field03137 = "markupOverride";
   private static final String field03138 = "markup";
   private static final String field03139 = "market";
   private static final String field03140 = "enabled";
   private static final String field03141 = "item";
   private static final String field03142 = "item";
   private static final String field03143 = "item";
   private static final String field03144 = "id";
   private static final String field03145 = "name";
   private static final String field03146 = "nbt";
   private static final String field03147 = "nbt";
   private static final String field03148 = "texture";
   private static final String field03149 = "texture";
   private static final String field03150 = "containerValued";
   private static final String field03151 = "enchantments";
   private static final String field03152 = "enchantments";
   private static final String field03153 = "lore";
   private static final String field03154 = "lore";
   private static final String field03155 = "effects";
   private static final String field03156 = "effects";
   private static final String field03157 = "id";
   private static final String field03158 = "count";
   private static final String field03159 = "name";
   private static final String field03160 = "paid";
   private static final String field03161 = "ceiling";
   private static final String field03162 = "market";
   private static final String field03163 = "seller";
   private static final String field03164 = "time";
   private static final String field03165 = "time";
   private static final String field03166 = "server";
   private static final String field03167 = "id";
   private static final String field03168 = "count";
   private static final String field03169 = "name";
   private static final String field03170 = "ask";
   private static final String field03171 = "paid";
   private static final String field03172 = "buyer";
   private static final String field03173 = "listed";
   private static final String field03174 = "sold";
   private static final String field03175 = "server";

   private static JsonObject method01308(AutoBuyItem var0) {
      JsonObject var1 = new JsonObject();
      var1.addProperty(field03070, BuiltInRegistries.ITEM.getKey(var0.method10693()).toString());
      var1.addProperty(field03071, var0.method10673());
      if (var0.method10720() != null) {
         var1.addProperty(field03072, var0.method10720().toString());
      }

      if (var0.method10717() != null) {
         var1.addProperty(field03073, var0.method10717());
      }

      if (var0.method10735()) {
         var1.addProperty(field03074, true);
      }

      if (!var0.method10710().isEmpty()) {
         JsonObject sx = new JsonObject();
         var0.method10710().forEach((var1x, var2x) -> sx.addProperty(var1x.toString(), var2x));
         var1.add(field03075, sx);
      }

      if (!var0.method10697().isEmpty()) {
         JsonArray sx = new JsonArray();
         var0.method10697().forEach(sx::add);
         var1.add(field03076, sx);
      }

      if (!var0.method10683().isEmpty()) {
         JsonObject sx = new JsonObject();
         var0.method10683().forEach(sx::addProperty);
         var1.add(field03077, sx);
      }

      return var1;
   }

   public static boolean method01309(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         JsonObject var1 = method01337(CustomResourceManager.method02470(var0));
         if (var1 == null) {
            var1 = method01337(var0);
         }

         if (var1 == null) {
            return false;
         }

         method01338(var1);
         return true;
      } else {
         return false;
      }
   }

   private static JsonArray method01310() {
      JsonArray var0 = new JsonArray();

      for (AutoBuyServer var4 : AutoBuyServer.values()) {
         for (AutoBuyItem var6 : AutoBuyItemRegistry.INSTANCE.method10987(var4)) {
            var0.add(method01312(var4, var6));
         }
      }

      return var0;
   }

   private static AutoBuyItem method01311(AutoBuyServer var0, JsonObject var1) {
      if (var1.has(field03141) && var1.get(field03142).isJsonObject()) {
         JsonObject var2 = var1.getAsJsonObject(field03143);
         Item var3 = method01328(method01333(var2, field03144, ""));
         if (var3 == null) {
            return null;
         }

         AutoBuyItem.Nested312 var4 = AutoBuyItem.method10730(var0, var3).method10745(method01333(var2, field03145, ""));
         if (var2.has(field03146)) {
            CompoundTag var5 = method01320(var2.get(field03147).getAsString());
            if (var5 != null) {
               var4.method10744(var5);
            }
         }

         if (var2.has(field03148)) {
            var4.method10748(var2.get(field03149).getAsString());
         }

         if (method01332(var2, field03150, false)) {
            var4.method10740();
         }

         if (var2.has(field03151)) {
            LinkedHashMap var6 = new LinkedHashMap();
            var2.getAsJsonObject(field03152)
               .entrySet()
               .forEach(var1x -> var6.put(Identifier.parse((String)var1x.getKey()), ((JsonElement)var1x.getValue()).getAsInt()));
            var4.method10750(var6);
         }

         if (var2.has(field03153)) {
            ArrayList var7 = new ArrayList();
            var2.getAsJsonArray(field03154).forEach(var1x -> var7.add(var1x.getAsString()));
            var4.method10742(var7);
         }

         if (var2.has(field03155)) {
            LinkedHashMap var8 = new LinkedHashMap();
            var2.getAsJsonObject(field03156).entrySet().forEach(var1x -> var8.put((String)var1x.getKey(), ((JsonElement)var1x.getValue()).getAsInt()));
            var4.method10747(var8);
         }

         return var4.method10743();
      } else {
         return null;
      }
   }

   private static JsonObject method01312(AutoBuyServer var0, AutoBuyItem var1) {
      JsonObject var2 = new JsonObject();
      var2.addProperty(field03060, var0.name());
      var2.addProperty(field03061, var1.method10691());
      var2.addProperty(field03062, var1.method10672());
      var2.addProperty(field03063, var1.method10682());
      var2.addProperty(field03064, var1.method10699());
      var2.addProperty(field03065, var1.method10733());
      var2.addProperty(field03066, var1.method10715());
      var2.addProperty(field03067, var1.method10718());
      var2.addProperty(field03068, var1.method10731());
      var2.add(field03069, method01308(var1));
      return var2;
   }

   private static void method01314(JsonArray var0) {
      ArrayList var1 = new ArrayList();

      for (JsonElement var3 : var0) {
         if (var3.isJsonObject()) {
            JsonObject var4 = var3.getAsJsonObject();
            Item var5 = method01328(method01333(var4, field03167, ""));
            if (var5 != null) {
               ItemStack var6 = new ItemStack(var5, Math.max(1, method01335(var4, field03168, 1)));
               var1.add(
                  new AuctionSaleHistory.Nested94(
                     var6,
                     method01333(var4, field03169, var6.getHoverName().getString()),
                     method01319(var4, field03170, 0L),
                     method01319(var4, field03171, 0L),
                     method01333(var4, field03172, ""),
                     method01319(var4, field03173, System.currentTimeMillis()),
                     method01319(var4, field03174, 0L),
                     method01315(AutoBuyServer.class, method01333(var4, field03175, ""), AutoBuyServer.HOLY_WORLD)
                  )
               );
            }
         }
      }

      AuctionSaleHistory.field07563.method03353(var1);
   }

   private static <T extends Enum<T>> T method01315(Class<T> var0, String var1, T var2) {
      if (var1 != null && !var1.isBlank()) {
         try {
            return Enum.valueOf(var0, var1);
         } catch (IllegalArgumentException var4) {
            return (T)(Object)var2;
         }
      } else {
         return (T)(Object)var2;
      }
   }

   private static void method01316(JsonArray var0) {
      for (JsonElement var2 : var0) {
         if (var2.isJsonObject()) {
            JsonObject var3 = var2.getAsJsonObject();
            AutoBuyServer var4 = method01315(AutoBuyServer.class, method01333(var3, field03131, ""), null);
            if (var4 != null && var3.has(field03132)) {
               AutoBuyItem var5 = AutoBuyItemRegistry.INSTANCE.method10992(var4, var3.get(field03133).getAsString());
               if (var5 == null) {
                  var5 = method01311(var4, var3);
                  if (var5 == null || !AutoBuyItemRegistry.INSTANCE.method10990(var5)) {
                     continue;
                  }
               }

               method01318(var5, var3);
            }
         }
      }
   }

   private static void method01318(AutoBuyItem var0, JsonObject var1) {
      var0.method10669(method01335(var1, field03134, var0.method10682()));
      var0.method10724(method01335(var1, field03135, var0.method10699()));
      var0.method10737(method01324(var1, field03136, var0.method10733()));
      var0.method10707(method01332(var1, field03137, var0.method10715()));
      var0.method10713(method01324(var1, field03138, var0.method10718()));
      var0.method10674(method01335(var1, field03139, var0.method10731()));
      var0.method10703(method01332(var1, field03140, var0.method10672()));
   }

   private static long method01319(JsonObject var0, String var1, long var2) {
      return var0.has(var1) ? var0.get(var1).getAsLong() : var2;
   }

   @Override
   public boolean method00296() {
      return this.method03302(method01329());
   }

   private static CompoundTag method01320(String var0) {
      try {
         return TagParser.parseCompoundFully(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   private static JsonArray method01321() {
      JsonArray var0 = new JsonArray();

      for (AuctionSaleHistory.Nested94 var2 : AuctionSaleHistory.field07563.method03357()) {
         JsonObject var3 = new JsonObject();
         var3.addProperty(field03087, BuiltInRegistries.ITEM.getKey(var2.stack().getItem()).toString());
         var3.addProperty(field03088, Math.max(1, var2.stack().getCount()));
         var3.addProperty(field03089, var2.name());
         var3.addProperty(field03090, var2.askPrice());
         var3.addProperty(field03091, var2.paidPrice());
         var3.addProperty(field03092, var2.buyer());
         var3.addProperty(field03093, var2.listedAtMs());
         var3.addProperty(field03094, var2.soldAtMs());
         var3.addProperty(field03095, var2.server().name());
         var0.add(var3);
      }

      return var0;
   }

   private static void method01322(JsonObject var0) {
      AutoBuySettings var1 = AutoBuySettings.field19624;
      var1.method08562(method01335(var0, field03108, var1.method08559()));
      var1.method08543(method01332(var0, field03109, var1.method08541()));
      var1.method08567(method01332(var0, field03110, var1.method08569()));
      var1.method08555(method01335(var0, field03111, var1.method08554()));
      var1.method08546(method01332(var0, field03112, var1.method08580()));
      var1.method08550(method01333(var0, field03113, var1.method08556()));
      var1.method08561(method01332(var0, field03114, var1.method08558()));
      var1.method08578(method01332(var0, field03115, var1.method08551()));
      var1.method08570(method01332(var0, field03116, var1.method08577()));
      var1.method08566(method01332(var0, field03117, var1.method08552()));
      var1.method08564(method01324(var0, field03118, var1.method08538()));
      var1.method08584(method01332(var0, field03119, var1.method08557()));
      var1.method08571(method01332(var0, field03120, var1.method08549()));
      var1.method08583(method01324(var0, field03121, var1.method08565()));
      var1.method08581(method01332(var0, field03122, var1.method08579()));
      var1.method08582(method01315(AutoBuySettings.Nested239.class, method01333(var0, field03123, var1.method08576().name()), var1.method08576()));
      var1.method08542(method01332(var0, field03124, var1.method08573()));
      var1.method08568(method01324(var0, field03125, var1.method08553()));
      var1.method08545(method01324(var0, field03126, var1.method08574()));
      var1.method08560(method01333(var0, field03127, var1.method08544()));
      var1.method08547(method01324(var0, field03128, var1.method08537()));
      var1.method08572(method01335(var0, field03129, var1.method08548()));
      var1.method08575(method01335(var0, field03130, var1.method08585()));
   }

   public static byte[] method01323() {
      try {
         return CustomResourceManager.method02469(method01329());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private static float method01324(JsonObject var0, String var1, float var2) {
      return var0.has(var1) ? var0.get(var1).getAsFloat() : var2;
   }

   private static JsonObject method01326() {
      AutoBuySettings var0 = AutoBuySettings.field19624;
      JsonObject var1 = new JsonObject();
      var1.addProperty(field03037, var0.method08559());
      var1.addProperty(field03038, var0.method08541());
      var1.addProperty(field03039, var0.method08569());
      var1.addProperty(field03040, var0.method08554());
      var1.addProperty(field03041, var0.method08580());
      var1.addProperty(field03042, var0.method08556());
      var1.addProperty(field03043, var0.method08558());
      var1.addProperty(field03044, var0.method08551());
      var1.addProperty(field03045, var0.method08577());
      var1.addProperty(field03046, var0.method08552());
      var1.addProperty(field03047, var0.method08538());
      var1.addProperty(field03048, var0.method08557());
      var1.addProperty(field03049, var0.method08549());
      var1.addProperty(field03050, var0.method08565());
      var1.addProperty(field03051, var0.method08579());
      var1.addProperty(field03052, var0.method08576().name());
      var1.addProperty(field03053, var0.method08573());
      var1.addProperty(field03054, var0.method08553());
      var1.addProperty(field03055, var0.method08574());
      var1.addProperty(field03056, var0.method08544());
      var1.addProperty(field03057, var0.method08537());
      var1.addProperty(field03058, var0.method08548());
      var1.addProperty(field03059, var0.method08585());
      return var1;
   }

   private static JsonArray method01327() {
      JsonArray var0 = new JsonArray();

      for (PurchaseHistory.Nested87 var2 : PurchaseHistory.field06969.method03139()) {
         JsonObject var3 = new JsonObject();
         var3.addProperty(field03078, BuiltInRegistries.ITEM.getKey(var2.stack().getItem()).toString());
         var3.addProperty(field03079, Math.max(1, var2.stack().getCount()));
         var3.addProperty(field03080, var2.name());
         var3.addProperty(field03081, var2.paidPrice());
         var3.addProperty(field03082, var2.priceCeiling());
         var3.addProperty(field03083, var2.marketPrice());
         var3.addProperty(field03084, var2.seller());
         var3.addProperty(field03085, var2.timestamp());
         var3.addProperty(field03086, var2.server().name());
         var0.add(var3);
      }

      return var0;
   }

   private static Item method01328(String var0) {
      if (var0 != null && !var0.isBlank()) {
         try {
            return BuiltInRegistries.ITEM.getOptional(Identifier.parse(var0)).orElse(null);
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static byte[] method01329() {
      JsonObject var0 = new JsonObject();
      var0.addProperty(field03031, AutoBuyItemRegistry.INSTANCE.method10998().name());
      var0.add(field03032, method01326());
      var0.add(field03033, method01310());
      var0.add(field03034, method01327());
      var0.add(field03035, method01321());
      var0.add(field03036, method01336());
      return field03030.toJson(var0).getBytes(StandardCharsets.UTF_8);
   }

   private static void method01330(JsonArray var0) {
      ArrayList var1 = new ArrayList();

      for (JsonElement var3 : var0) {
         if (var3.isJsonObject()) {
            JsonObject var4 = var3.getAsJsonObject();
            Item var5 = method01328(method01333(var4, field03157, ""));
            if (var5 != null) {
               ItemStack var6 = new ItemStack(var5, Math.max(1, method01335(var4, field03158, 1)));
               var1.add(
                  new PurchaseHistory.Nested87(
                     var6,
                     method01333(var4, field03159, var6.getHoverName().getString()),
                     method01335(var4, field03160, 0),
                     method01335(var4, field03161, 0),
                     method01335(var4, field03162, 0),
                     method01333(var4, field03163, ""),
                     var4.has(field03164) ? var4.get(field03165).getAsLong() : System.currentTimeMillis(),
                     method01315(AutoBuyServer.class, method01333(var4, field03166, ""), AutoBuyServer.HOLY_WORLD)
                  )
               );
            }
         }
      }

      PurchaseHistory.field06969.method03143(var1);
   }

   private static void method01331(JsonArray var0) {
      ArrayList var1 = new ArrayList();

      for (JsonElement var3 : var0) {
         if (var3.isJsonPrimitive()) {
            var1.add(var3.getAsString());
         }
      }

      BlockedSellerRegistry.field08823.method03973(var1);
   }

   private static boolean method01332(JsonObject var0, String var1, boolean var2) {
      return var0.has(var1) ? var0.get(var1).getAsBoolean() : var2;
   }

   @Override
   public boolean method00298() {
      if (!this.method03303().exists()) {
         return false;
      }

      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         return method01309(var1.readAllBytes());
      } catch (Exception var6) {
         return false;
      }
   }

   private static String method01333(JsonObject var0, String var1, String var2) {
      return var0.has(var1) ? var0.get(var1).getAsString() : var2;
   }

   private static int method01335(JsonObject var0, String var1, int var2) {
      return var0.has(var1) ? var0.get(var1).getAsInt() : var2;
   }

   private static JsonArray method01336() {
      JsonArray var0 = new JsonArray();

      for (String var2 : BlockedSellerRegistry.field08823.method03971()) {
         var0.add(var2);
      }

      return var0;
   }

   public AutoBuyStorage(File var1) {
      super(var1);
   }

   private static JsonObject method01337(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            JsonElement var1 = JsonParser.parseString(new String(var0, StandardCharsets.UTF_8));
            return var1 != null && var1.isJsonObject() ? var1.getAsJsonObject() : null;
         } catch (Exception var2) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static void method01338(JsonObject var0) {
      if (var0.has(field03096)) {
         method01322(var0.getAsJsonObject(field03097));
      }

      if (var0.has(field03098)) {
         method01316(var0.getAsJsonArray(field03099));
      }

      if (var0.has(field03100)) {
         method01331(var0.getAsJsonArray(field03101));
      }

      if (var0.has(field03102)) {
         method01314(var0.getAsJsonArray(field03103));
      }

      if (var0.has(field03104)) {
         method01330(var0.getAsJsonArray(field03105));
      }

      if (var0.has(field03106)) {
         AutoBuyServer var1 = method01315(AutoBuyServer.class, var0.get(field03107).getAsString(), AutoBuyServer.HOLY_WORLD);
         AutoBuyItemRegistry.INSTANCE.method10989(var1);
      }
   }
}
