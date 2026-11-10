// Original binary: sg/ec/U0KBtGx5Qa89gYyl
package sg.ec;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ClientboundOpenScreenPacket;
import net.minecraft.network.protocol.game.ServerboundChatPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomModelData;
import sg.mx.ItemCooldowns$CooldownInstanceMixin;
import sg.mx.ItemCooldownsMixin;

// $VF: Compiled from s
public class ServerHelper extends ClientModule {
   private final ModeSetting field12124;
   private final KeyBindSetting field12125;
   @Priority("ТрапкаRW")
   private final KeyBindSetting field12126;
   private final ToggleSetting field12127;
   private final ToggleSetting field12128;
   private final KeyBindSetting field12129;
   private final KeyBindSetting field12130;
   private final KeyBindSetting field12131;
   @Priority("СнежокHW")
   private final KeyBindSetting field12132;
   private final KeyBindSetting field12133;
   private final ToggleSetting field12134;
   @Priority("ТрапкаFT")
   private final KeyBindSetting field12135;
   private final KeyBindSetting field12136;
   private final KeyBindSetting field12137;
   @Priority("СнежокFT")
   private final KeyBindSetting field12138;
   private final KeyBindSetting field12139;
   private final KeyBindSetting field12140;
   private final KeyBindSetting field12141;
   private final KeyBindSetting field12142;
   private final KeyBindSetting field12143;
   private final KeyBindSetting field12144;
   private final KeyBindSetting field12145;
   private final KeyBindSetting field12146;
   private final KeyBindSetting field12147;
   private final KeyBindSetting field12148;
   private final KeyBindSetting field12149;
   private final ToggleSetting field12150;
   private final NumberSetting<Float> field12151;
   private final KeyBindSetting field12152;
   private final KeyBindSetting field12153;
   private final KeyBindSetting field12154;
   private final List<ServerHelper.Nested174> field12155;
   private final Map<KeyBindSetting, ServerHelper.Nested172> field12156;
   private final ServerItemUseController field12157;
   private static final int field12158 = 6;
   private static final int field12159 = 0;
   private static final int field12160 = 0;
   private static final int field12161 = 0;
   private static final int field12162 = 0;
   private static final int field12163 = 0;
   private static final int field12164 = 0;
   private static final int field12165 = 0;
   private static final int field12166 = 0;
   private static final int field12167 = 0;
   private static final String field12168 = "field12168";
   private int field12169;
   private int field12170;
   private boolean field12171;
   private static final List<Pattern> field12172 = List.of(
         ServerHelper.field12307,
         ServerHelper.field12308,
         ServerHelper.field12309,
         ServerHelper.field12310,
         ServerHelper.field12311,
         ServerHelper.field12312,
         ServerHelper.field12313,
         ServerHelper.field12314,
         ServerHelper.field12315,
         ServerHelper.field12316,
         ServerHelper.field12317,
         ServerHelper.field12318,
         ServerHelper.field12319,
         ServerHelper.field12320,
         ServerHelper.field12321,
         ServerHelper.field12322,
         ServerHelper.field12323,
         ServerHelper.field12324,
         ServerHelper.field12325,
         ServerHelper.field12326,
         ServerHelper.field12327,
         ServerHelper.field12328,
         ServerHelper.field12329,
         ServerHelper.field12330,
         ServerHelper.field12331,
         ServerHelper.field12332,
         ServerHelper.field12333,
         ServerHelper.field12334,
         ServerHelper.field12335,
         ServerHelper.field12336,
         ServerHelper.field12337,
         ServerHelper.field12338,
         ServerHelper.field12339,
         ServerHelper.field12340,
         ServerHelper.field12341,
         ServerHelper.field12342,
         ServerHelper.field12343,
         ServerHelper.field12344,
         ServerHelper.field12345,
         ServerHelper.field12346,
         ServerHelper.field12347,
         ServerHelper.field12348,
         ServerHelper.field12349,
         ServerHelper.field12350,
         ServerHelper.field12351,
         ServerHelper.field12352,
         ServerHelper.field12353,
         ServerHelper.field12354,
         ServerHelper.field12355,
         ServerHelper.field12356,
         ServerHelper.field12357,
         ServerHelper.field12358,
         ServerHelper.field12359,
         ServerHelper.field12360,
         ServerHelper.field12361,
         ServerHelper.field12362,
         ServerHelper.field12363,
         ServerHelper.field12364,
         ServerHelper.field12365,
         ServerHelper.field12366,
         ServerHelper.field12367,
         ServerHelper.field12368,
         ServerHelper.field12369
      )
      .stream()
      .map(Pattern::compile)
      .toList();
   private final Map<ItemStack, Component> field12173;
   public boolean field12174;
   private static final String field12175 = "Сервер";
   private static final String field12176 = "ReallyWorld";
   private static final String field12177 = "HolyWorld";
   private static final String field12178 = "Funtime";
   private static final String field12179 = "LonyGrief";
   private static final String field12180 = "HolyWorld";
   private static final String field12181 = "Анти полет";
   private static final String field12182 = "Трапка";
   private static final String field12183 = "Закрывать меню";
   private static final String field12184 = "Фильтр чата";
   private static final String field12185 = "Взрывная штучка";
   private static final String field12186 = "Взрывная трапка";
   private static final String field12187 = "Обычная трапка";
   private static final String field12188 = "Снежок";
   private static final String field12189 = "Стан";
   private static final String field12190 = "Индикация предметов";
   private static final String field12191 = "Трапка";
   private static final String field12192 = "Дезориентация";
   private static final String field12193 = "Явная пыль";
   private static final String field12194 = "Снежок";
   private static final String field12195 = "Пласт";
   private static final String field12196 = "Божья аура";
   private static final String field12197 = "Огненный смерч";
   private static final String field12198 = "Хлопушка";
   private static final String field12199 = "Зелье Ассасина";
   private static final String field12200 = "Зелье Радиации";
   private static final String field12201 = "Святая вода";
   private static final String field12202 = "Зелье Гнева";
   private static final String field12203 = "Зелье Паладина";
   private static final String field12204 = "Снотворное";
   private static final String field12205 = "Заряд ветра";
   private static final String field12206 = "Лучший бросок";
   private static final String field12207 = "Угол броска";
   private static final float field12208 = 60.0F;
   private static final float field12209 = 90.0F;
   private static final float field12210 = 80.0F;
   private static final String field12211 = "Обычная ливалка";
   private static final String field12212 = "Ливалка с платформой";
   private static final String field12213 = "Уникальная трапка";
   private static final String field12214 = "Server Helper";
   private static final String field12215 = "Funtime";
   private static final String field12216 = "ReallyWorld";
   private static final String field12217 = "ReallyWorld";
   private static final String field12218 = "HolyWorld";
   private static final String field12219 = "HolyWorld";
   private static final String field12220 = "HolyWorld";
   private static final String field12221 = "HolyWorld";
   private static final String field12222 = "HolyWorld";
   private static final String field12223 = "Funtime";
   private static final String field12224 = "Funtime";
   private static final String field12225 = "Funtime";
   private static final String field12226 = "Funtime";
   private static final String field12227 = "Funtime";
   private static final String field12228 = "Funtime";
   private static final String field12229 = "Funtime";
   private static final String field12230 = "Funtime";
   private static final String field12231 = "effect.minecraft.poison,dur=1200,lvl=2 | effect.minecraft.wither,dur=1200,lvl=2 | effect.minecraft.slowness,dur=1800,lvl=3 | effect.minecraft.hunger,dur=1200,lvl=5 | effect.minecraft.glowing,dur=2400,lvl=1";
   private static final int field12232 = 3329330;
   private static final String field12233 = "Funtime";
   private static final String field12234 = "effect.minecraft.resistance,dur=12000,lvl=1 | effect.minecraft.fire_resistance,dur=12000,lvl=1 | effect.minecraft.health_boost,dur=1200,lvl=3 | effect.minecraft.invisibility,dur=18000,lvl=1";
   private static final int field12235 = 65535;
   private static final String field12236 = "Funtime";
   private static final String field12237 = "effect.minecraft.weakness,dur=1800,lvl=2 | effect.minecraft.mining_fatigue,dur=200,lvl=2 | effect.minecraft.wither,dur=1800,lvl=3 | effect.minecraft.blindness,dur=200,lvl=1";
   private static final String field12238 = "Funtime";
   private static final String field12239 = "effect.minecraft.slowness,dur=200,lvl=10 | effect.minecraft.speed,dur=400,lvl=5 | effect.minecraft.blindness,dur=100,lvl=10 | effect.minecraft.glowing,dur=3600,lvl=1";
   private static final int field12240 = 16738740;
   private static final String field12241 = "Funtime";
   private static final String field12242 = "effect.minecraft.strength,dur=1200,lvl=4 | effect.minecraft.speed,dur=6000,lvl=3 | effect.minecraft.haste,dur=1200,lvl=1 | effect.minecraft.instant_damage,dur=0,lvl=2";
   private static final int field12243 = 3355443;
   private static final String field12244 = "Funtime";
   private static final String field12245 = "effect.minecraft.regeneration,dur=900,lvl=2 | effect.minecraft.invisibility,dur=12000,lvl=2 | effect.minecraft.instant_health,dur=0,lvl=2";
   private static final int field12246 = 16777215;
   private static final String field12247 = "Funtime";
   private static final String field12248 = "effect.minecraft.strength,dur=600,lvl=5 | effect.minecraft.slowness,dur=600,lvl=4";
   private static final String field12249 = "*";
   private static final String field12250 = "LonyGrief";
   private static final String field12251 = "LonyGrief";
   private static final String field12252 = "LonyGrief";
   private static final long field12253 = 2500L;
   private static final long field12254 = 2500L;
   private static final float field12255 = Float.MAX_VALUE;
   private static final float field12256 = Float.MAX_VALUE;
   private static final String field12257 = "Использован предмет";
   private static final String field12258 = ": ";
   private static final long field12259 = 2500L;
   private static final String field12260 = "Предмет ";
   private static final String field12261 = " в кд ";
   private static final double field12262 = 0.1F;
   private static final long field12263 = 2500L;
   private static final String field12264 = "Лучший бросок";
   private static final String field12265 = "Заряд ветра";
   private static final String field12266 = ": ";
   private static final long field12267 = 2500L;
   private static final float field12268 = Float.MAX_VALUE;
   private static final float field12269 = Float.MAX_VALUE;
   private static final String field12270 = "Использован предмет";
   private static final String field12271 = ": ";
   private static final long field12272 = 2500L;
   private static final String field12273 = "Анти полет";
   private static final String field12274 = ": ";
   private static final long field12275 = 2500L;
   private static final String field12276 = "ReallyWorld";
   private static final String field12277 = "ꈁꀀꈂꌁꈂꀁ§0ꈃꄀ";
   private static final String field12278 = "В сообщении найдено запретное слово, отправка отменена!";
   private static final float field12279 = 20.0F;
   private static final String field12280 = "LonyGrief";
   private static final String field12281 = "LonyGrief";
   private static final String field12282 = "LonyGrief";
   private static final String field12283 = "Funtime";
   private static final String field12284 = "Funtime";
   private static final String field12285 = "Funtime";
   private static final String field12286 = "Funtime";
   private static final String field12287 = "Funtime";
   private static final String field12288 = "Funtime";
   private static final String field12289 = "Funtime";
   private static final String field12290 = "Funtime";
   private static final String field12291 = "Funtime";
   private static final String field12292 = "Funtime";
   private static final String field12293 = "Funtime";
   private static final String field12294 = "Funtime";
   private static final String field12295 = "Funtime";
   private static final String field12296 = "Funtime";
   private static final String field12297 = "Funtime";
   private static final String field12298 = "HolyWorld";
   private static final String field12299 = "HolyWorld";
   private static final String field12300 = "HolyWorld";
   private static final String field12301 = "HolyWorld";
   private static final String field12302 = "HolyWorld";
   private static final String field12303 = "ReallyWorld";
   private static final String field12304 = "ReallyWorld";
   private static final String field12305 = "ReallyWorld";
   private static final String field12306 = "ReallyWorld";
   private static final String field12307 = "акриен(а|у|ом|е|чик)?";
   private static final String field12308 = "рич(а|у|ом|ей|е)?";
   private static final String field12309 = "ньюкод(ом|а|у|ами|ик|е)?";
   private static final String field12310 = "экспенсив(ом|а|у|ами|е)?";
   private static final String field12311 = "импакт(ом|а|у|ами|ик|е)?";
   private static final String field12312 = "экселлент(ом|а|у|ами|ик|е)?";
   private static final String field12313 = "экселент(ом|а|у|ами|ик)?";
   private static final String field12314 = "катлаван(ом|а|у|ами|чик)?";
   private static final String field12315 = "катлован(ом|а|у|ами|чик)?";
   private static final String field12316 = "целестиал(ом|а|у|ами|е)?";
   private static final String field12317 = "целк(ой|а|у|ами|очка|е)?";
   private static final String field12318 = "матикс(ом|а|у|ами|е)?";
   private static final String field12319 = "инерти(я|ей|ю|ями|е)?";
   private static final String field12320 = "эксп(а|ой|ою|у|уличка|е)?";
   private static final String field12321 = "флюгер(ом|а|у|ами)?";
   private static final String field12322 = "рикер(а|у|ом|очек)?";
   private static final String field12323 = "фанпе(й|ю|я|ем|е|йчик)?";
   private static final String field12324 = "вексайд(ом|а|у|ами|ик|е)?";
   private static final String field12325 = "нурсултан(а|у|е|ом|чик)?";
   private static final String field12326 = "нурик(а|у|ом|е)?";
   private static final String field12327 = "нурлан(а|у|ом|чик|е)?";
   private static final String field12328 = "векс(ом|у|а|ами|ик|е)?";
   private static final String field12329 = "релейк(ом|у|а|ами|е)?";
   private static final String field12330 = "арбуз(ом|а|у|ами|ик|е)?";
   private static final String field12331 = "вилд(ом|у|а|ами|ик|е)?";
   private static final String field12332 = "фантайм(е|а|у)?";
   private static final String field12333 = "холик(е|а|у)?";
   private static final String field12334 = "холиворлд(а|у|е)?";
   private static final String field12335 = "рокстар(ом|а|у|ами|чик|е)?";
   private static final String field12336 = "рогалик(а|у|ом|е)?";
   private static final String field12337 = "тандерхак(ом|у|и|ами|а|е)?";
   private static final String field12338 = "ликвидбаунс(а|у|ами|е)?";
   private static final String field12339 = "expensive";
   private static final String field12340 = "celestial";
   private static final String field12341 = "newcode";
   private static final String field12342 = "arbuz";
   private static final String field12343 = "akrien";
   private static final String field12344 = "nursultan";
   private static final String field12345 = "relake";
   private static final String field12346 = "wild";
   private static final String field12347 = "wurst";
   private static final String field12348 = "catlovan";
   private static final String field12349 = "excellent";
   private static final String field12350 = "rockstar";
   private static final String field12351 = "catlavan";
   private static final String field12352 = "impact";
   private static final String field12353 = "matix";
   private static final String field12354 = "inertia";
   private static final String field12355 = "wex";
   private static final String field12356 = "wexside";
   private static final String field12357 = "nurik";
   private static final String field12358 = "nurlan";
   private static final String field12359 = "rich";
   private static final String field12360 = "funpay";
   private static final String field12361 = "fluger";
   private static final String field12362 = "riker";
   private static final String field12363 = "funtime";
   private static final String field12364 = "holyworld";
   private static final String field12365 = "wwe";
   private static final String field12366 = "hvh";
   private static final String field12367 = "rogalik";
   private static final String field12368 = "thunderhack";
   private static final String field12369 = "liquidbounce";

   private boolean method05750(ItemStack var1, ServerHelper.Nested172 var2) {
      if (var2.method05811() != null && var1.getItem() != var2.method05811()) {
         return false;
      } else {
         String var3 = var2.method05813();
         if ((var3 == null || var3.isEmpty()) && var2.method05807() == null) {
            return true;
         } else {
            PotionContents sx = var1.get(DataComponents.POTION_CONTENTS);
            if (sx == null) {
               return false;
            } else {
               return this.method05794(sx, var2) ? true : this.method05790(sx, var2);
            }
         }
      }
   }

   private void method05752(ItemStack var1) {
      if (!var1.isEmpty()) {
         if (var1.getItem() == Items.TOTEM_OF_UNDYING) {
            CustomModelData var2 = var1.get(DataComponents.CUSTOM_MODEL_DATA);
            if (var2 != null && !var2.floats().isEmpty()) {
               int var3 = var2.floats().getFirst().intValue();
               Component var4 = this.method05772(var3);
               if (var4 != null) {
                  this.field12173.put(var1, var4);
               }
            }
         }
      }
   }

   @Subscribe
   private void method05754(MouseButtonEvent var1) {
      if (var1.method06919() != InputAction.RELEASE) {
         this.method05769(var1.method06914());
      }
   }

   private float method05758(ItemStack var1) {
      if (mc.player == null) {
         return 0.0F;
      } else {
         ItemCooldowns var2 = mc.player.getCooldowns();
         Identifier var3 = var2.getCooldownGroup(var1);
         if (((ItemCooldownsMixin)(Object)var2).entries().get(var3) instanceof ItemCooldowns$CooldownInstanceMixin var5) {
            int var6 = ((ItemCooldownsMixin)(Object)var2).getTicks();
            int var7 = Math.max(0, var5.getEndTick() - var6);
            return var7 / field12279;
         } else {
            return 0.0F;
         }
      }
   }

   private void method05760() {
      if (this.field12169 >= 0 && mc.player != null) {
         this.field12169++;
         if (this.field12169 == 3) {
            mc.options.keyShift.setDown(true);
            this.field12171 = true;
         }

         if (this.field12169 == 5) {
            this.method05788();
         }

         if (this.field12169 >= 9) {
            int var1 = mc.player.containerMenu.containerId;
            int var2 = this.field12170;
            TickTaskScheduler.method03507(() -> mc.gameMode.handleContainerInput(var1, var2, 40, ClickType.SWAP, mc.player));
            this.method05788();
            this.field12169 = -1;
            this.field12170 = -1;
         }
      }
   }

   private void method05762() {
      this.field12156.put(this.field12125, new ServerHelper.Nested172(field12216, this.field12125.method03024(), Items.FIREWORK_STAR));
      this.field12156.put(this.field12126, new ServerHelper.Nested172(field12217, this.field12126.method03024(), Items.HEART_OF_THE_SEA));
      this.field12156.put(this.field12129, new ServerHelper.Nested172(field12218, this.field12129.method03024(), Items.FIRE_CHARGE));
      this.field12156.put(this.field12131, new ServerHelper.Nested172(field12219, this.field12131.method03024(), Items.POPPED_CHORUS_FRUIT));
      this.field12156.put(this.field12130, new ServerHelper.Nested172(field12220, this.field12130.method03024(), Items.PRISMARINE_SHARD));
      this.field12156.put(this.field12132, new ServerHelper.Nested172(field12221, this.field12132.method03024(), Items.SNOWBALL));
      this.field12156.put(this.field12133, new ServerHelper.Nested172(field12222, this.field12133.method03024(), Items.NETHER_STAR));
      this.field12156.put(this.field12135, new ServerHelper.Nested172(field12223, this.field12135.method03024(), Items.NETHERITE_SCRAP));
      this.field12156.put(this.field12140, new ServerHelper.Nested172(field12224, this.field12140.method03024(), Items.PHANTOM_MEMBRANE));
      this.field12156.put(this.field12141, new ServerHelper.Nested172(field12225, this.field12141.method03024(), Items.FIRE_CHARGE));
      this.field12156.put(this.field12138, new ServerHelper.Nested172(field12226, this.field12138.method03024(), Items.SNOWBALL));
      this.field12156.put(this.field12139, new ServerHelper.Nested172(field12227, this.field12139.method03024(), Items.DRIED_KELP));
      this.field12156.put(this.field12136, new ServerHelper.Nested172(field12228, this.field12136.method03024(), Items.ENDER_EYE));
      this.field12156.put(this.field12137, new ServerHelper.Nested172(field12229, this.field12137.method03024(), Items.SUGAR));
      this.field12156
         .put(this.field12144, new ServerHelper.Nested172(field12230, this.field12144.method03024(), Items.SPLASH_POTION, field12231, field12232));
      this.field12156
         .put(this.field12147, new ServerHelper.Nested172(field12233, this.field12147.method03024(), Items.SPLASH_POTION, field12234, field12235));
      this.field12156.put(this.field12148, new ServerHelper.Nested172(field12236, this.field12148.method03024(), Items.SPLASH_POTION, field12237, 255));
      this.field12156
         .put(this.field12142, new ServerHelper.Nested172(field12238, this.field12142.method03024(), Items.SPLASH_POTION, field12239, field12240));
      this.field12156
         .put(this.field12143, new ServerHelper.Nested172(field12241, this.field12143.method03024(), Items.SPLASH_POTION, field12242, field12243));
      this.field12156
         .put(this.field12145, new ServerHelper.Nested172(field12244, this.field12145.method03024(), Items.SPLASH_POTION, field12245, field12246));
      this.field12156.put(this.field12146, new ServerHelper.Nested172(field12247, this.field12146.method03024(), Items.SPLASH_POTION, field12248));
      ServerHelper.Nested172 var1 = new ServerHelper.Nested172(field12249, this.field12149.method03024(), Items.WIND_CHARGE);
      var1.method05814(true);
      this.field12156.put(this.field12149, var1);
      this.field12156.put(this.field12152, new ServerHelper.Nested172(field12250, this.field12152.method03024(), Items.MAGMA_CREAM));
      this.field12156.put(this.field12154, new ServerHelper.Nested172(field12251, this.field12154.method03024(), Items.CRYING_OBSIDIAN));
      this.field12156.put(this.field12153, new ServerHelper.Nested172(field12252, this.field12153.method03024(), Items.CLAY_BALL));
   }

   @Subscribe
   private void method05763(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         this.method05765();
         this.field12157.method11656();
         this.method05760();
         this.field12155.clear();
         boolean var2 = ModuleManager.INSTANCE.method08274().method04953().method00017(ItemHelperHud.class).method04678().method03022();
         ArrayList var3 = new ArrayList();

         for (ItemStack var5 : mc.player.getInventory().getNonEquipmentItems()) {
            if (!var5.isEmpty()) {
               var3.add(var5);
               if (ServerItemActionUtils.method05500(var5)) {
                  ServerItemActionUtils.method05489(var5, var3);
               }
            }
         }

         String var15 = this.field12124.method03022();

         for (var var6 : this.field12156.entrySet()) {
            KeyBindSetting var7 = (KeyBindSetting)var6.getKey();
            ServerHelper.Nested172 var8 = (ServerHelper.Nested172)var6.getValue();
            if ((var8.method05815() || var15.equals(var8.method05819())) && var7.method03022().method05871() != -1) {
               int var9 = var7.method03022().method05871();
               int var10 = 0;
               ItemStack var11 = ItemStack.EMPTY;

               for (int var12 = 0; var12 < var3.size(); var12++) {
                  ItemStack var13 = (ItemStack)var3.get(var12);
                  boolean var14 = mc.player.getCooldowns().isOnCooldown(var13);
                  if ((!var14 || !var2) && this.method05750(var13, var8)) {
                     var10 += var13.getCount();
                     if (var11.isEmpty()) {
                        var11 = var13.copy();
                     }
                  }
               }

               if (var10 > 0) {
                  ItemStack var17 = var11.copy();
                  var17.setCount(var10);
                  String var18 = KeyboardKey.method00360(var9);
                  this.field12155.add(new ServerHelper.Nested174(var17, var18));
               }
            }
         }
      }
   }

   private boolean method05764(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);

      for (Pattern var4 : field12172) {
         if (var4.matcher(var2).find()) {
            return true;
         }
      }

      return false;
   }

   private void method05765() {
      this.field12174 = this.field12124.method05600(field12215) && this.field12134.method05999() && !mc.isLocalServer();
      this.field12173.clear();
      if (this.field12174 && mc.level != null) {
         for (Entity var2 : mc.level.entitiesForRendering()) {
            if (var2 instanceof Player var3) {
               this.method05789(var3.getMainHandItem());
               this.method05789(var3.getOffhandItem());
               this.method05752(var3.getMainHandItem());
               this.method05752(var3.getOffhandItem());
            }
         }
      }
   }

   private Slot method05768(ServerHelper.Nested172 var1) {
      if (mc.player == null) {
         return null;
      }

      Slot var2 = this.method05777(mc.player.getInventory().getSelectedSlot(), var1);
      if (var2 != null) {
         return var2;
      }

      for (int var3 = 0; var3 < 9; var3++) {
         if (var3 != mc.player.getInventory().getSelectedSlot()) {
            Slot var4 = this.method05777(var3, var1);
            if (var4 != null) {
               return var4;
            }
         }
      }

      for (int var5 = 9; var5 < 36; var5++) {
         Slot var6 = this.method05777(var5, var1);
         if (var6 != null) {
            return var6;
         }
      }

      return null;
   }

   private void method05769(int var1) {
      String var2 = this.field12124.method03022();

      for (var var4 : this.field12156.entrySet()) {
         KeyBindSetting var5 = (KeyBindSetting)var4.getKey();
         ServerHelper.Nested172 var6 = (ServerHelper.Nested172)var4.getValue();
         if ((var6.method05815() || var2.equals(var6.method05819())) && var5.method03022().method05871() == var1) {
            Slot var7 = this.method05768(var6);
            if (var7 == null) {
               Predicate<ItemStack> var11 = var2x -> this.method05750(var2x, var6);
               if (ServerItemActionUtils.method05475(var11) == null) {
                  NotificationManager.method08619(Component.literal("Предмет " + var6.method05818() + " не найден"), field12253, NotificationType.INFO);
               } else if (!ServerItemActionUtils.method05465(var11, () -> {
                  if (this.method05768(var6) != null) {
                     this.method05769(var1);
                  }
               })) {
                  if (var5 != this.field12149 && var5 != this.field12125) {
                     ItemStack var14 = ServerItemActionUtils.method05474(var11, InteractionHand.MAIN_HAND, field12255, field12256);
                     if (!var14.isEmpty()) {
                        MutableComponent var10 = Component.literal(field12257).copy().append(field12258).append(var14.getStyledHoverName());
                        NotificationManager.method08598(var10, field12259, var14);
                     }
                  } else if (DelayedInventoryActionManager.INSTANCE.method10617()) {
                     NotificationManager.method08619(
                        Component.literal("Инвентарь забит, " + var6.method05818() + " не достать из мешка"), field12254, NotificationType.INFO
                     );
                  }
               }
            } else {
               ItemStack var8 = var7.getItem().copy();
               if (mc.player.getCooldowns().isOnCooldown(var8)) {
                  float var9 = this.method05758(var8);
                  NotificationManager.method08598(
                     Component.literal(field12260)
                        .append(var8.getStyledHoverName())
                        .append(field12261)
                        .append(GuiHitTestUtils.method05606(var9, field12262) + "s."),
                     field12263,
                     var8
                  );
               } else if (var5 == this.field12149) {
                  this.field12157.method11647(var7, this.field12150.method05999(), this.field12151.method03022());
                  MutableComponent var12 = Component.literal(this.field12150.method05999() ? field12264 : field12265)
                     .copy()
                     .append(field12266)
                     .append(var8.getStyledHoverName());
                  NotificationManager.method08598(var12, field12267, var8);
               } else if (var5 == this.field12125) {
                  this.method05792(var7, var8);
               } else {
                  DelayedInventoryActionManager.INSTANCE.method09004(InteractionHand.MAIN_HAND, var7, field12268, field12269);
                  MutableComponent var13 = Component.literal(field12270).copy().append(field12271).append(var8.getStyledHoverName());
                  NotificationManager.method08598(var13, field12272, var8);
               }
            }
         }
      }
   }

   private Component method05772(int var1) {
      return switch (var1) {
         case 1 -> PotionItemData.field26033;
         case 2 -> PotionItemData.field26035;
         case 3 -> PotionItemData.field26034;
         case 4 -> PotionItemData.field26036;
         case 5 -> PotionItemData.field26038;
         case 6 -> PotionItemData.field26031;
         case 7 -> PotionItemData.field26032;
         case 8 -> PotionItemData.field26037;
         default -> null;
      };
   }

   public List<ServerHelper.Nested174> method05776() {
      return this.field12155;
   }

   private Slot method05777(int var1, ServerHelper.Nested172 var2) {
      if (mc.player != null && mc.player.containerMenu != null) {
         for (Slot var4 : mc.player.containerMenu.slots) {
            if (var4.container == mc.player.getInventory() && var4.getContainerSlot() == var1) {
               ItemStack var5 = var4.getItem();
               if (!var5.isEmpty() && this.method05750(var5, var2)) {
                  return var4;
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   @Subscribe
   private void method05779(ItemDisplayNameEvent var1) {
      if (this.field12174) {
         Component var2 = this.field12173.get(var1.method10665());
         if (var2 != null) {
            var1.method10667(var2);
         }
      }
   }

   @Subscribe(3)
   private void method05781(PlayerInputEvent var1) {
      this.field12157.method11652(var1);
   }

   @Subscribe
   private void method05786(FrameUpdateEvent var1) {
      this.field12157.method11648(var1);
   }

   private void method05788() {
      if (this.field12171) {
         this.field12171 = false;
         if (mc.options != null) {
            mc.options.keyShift.setDown(false);
         }
      }
   }

   private void method05789(ItemStack var1) {
      if (!var1.isEmpty()) {
         if (var1.getItem() == Items.SPLASH_POTION) {
            PotionContents var2 = var1.get(DataComponents.POTION_CONTENTS);
            if (var2 != null) {
               int var3 = var2.customColor().orElse(-1);
               Component var4 = PotionItemData.method11489(var3);
               if (var4 != null) {
                  this.field12173.put(var1, var4);
               }
            }
         }
      }
   }

   private boolean method05790(PotionContents var1, ServerHelper.Nested172 var2) {
      Integer var3 = var2.method05807();
      return var3 == null ? false : var1.getColor() == var3;
   }

   @Override
   public void method00276() {
      this.method05797();
      super.method00276();
   }

   public ServerHelper() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field12124 = new ModeSetting(field12175)
         .method05597(field12176, field12177, field12178, field12179)
         .method03017(field12180)
         .method03023(this);
      this.field12125 = new KeyBindSetting(field12181)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12306))
         .method03023(this);
      this.field12126 = new KeyBindSetting(field12182)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12305))
         .method03023(this);
      this.field12127 = new ToggleSetting(field12183).method03017(false).method03025(() -> this.field12124.method05600(field12304)).method03023(this);
      this.field12128 = new ToggleSetting(field12184).method03017(false).method03025(() -> this.field12124.method05600(field12303)).method03023(this);
      this.field12129 = new KeyBindSetting(field12185)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12302))
         .method03023(this);
      this.field12130 = new KeyBindSetting(field12186)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12301))
         .method03023(this);
      this.field12131 = new KeyBindSetting(field12187)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12300))
         .method03023(this);
      this.field12132 = new KeyBindSetting(field12188)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12299))
         .method03023(this);
      this.field12133 = new KeyBindSetting(field12189)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12298))
         .method03023(this);
      this.field12134 = new ToggleSetting(field12190).method03017(true).method03025(() -> this.field12124.method05600(field12297)).method03023(this);
      this.field12135 = new KeyBindSetting(field12191)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12296))
         .method03023(this);
      this.field12136 = new KeyBindSetting(field12192)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12295))
         .method03023(this);
      this.field12137 = new KeyBindSetting(field12193)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12294))
         .method03023(this);
      this.field12138 = new KeyBindSetting(field12194)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12293))
         .method03023(this);
      this.field12139 = new KeyBindSetting(field12195)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12292))
         .method03023(this);
      this.field12140 = new KeyBindSetting(field12196)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12291))
         .method03023(this);
      this.field12141 = new KeyBindSetting(field12197)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12290))
         .method03023(this);
      this.field12142 = new KeyBindSetting(field12198)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12289))
         .method03023(this);
      this.field12143 = new KeyBindSetting(field12199)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12288))
         .method03023(this);
      this.field12144 = new KeyBindSetting(field12200)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12287))
         .method03023(this);
      this.field12145 = new KeyBindSetting(field12201)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12286))
         .method03023(this);
      this.field12146 = new KeyBindSetting(field12202)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12285))
         .method03023(this);
      this.field12147 = new KeyBindSetting(field12203)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12284))
         .method03023(this);
      this.field12148 = new KeyBindSetting(field12204)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12283))
         .method03023(this);
      this.field12149 = new KeyBindSetting(field12205).method03017(new KeyBinding()).method03023(this);
      this.field12150 = new ToggleSetting(field12206).method03017(false).method03023(this);
      this.field12151 = new NumberSetting<Float>(field12207)
         .method10835(field12208)
         .method10838(field12209)
         .method10834(1.0F)
         .method03017(field12210)
         .method03025(this.field12150::method05999)
         .method03023(this);
      this.field12152 = new KeyBindSetting(field12211)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12282))
         .method03023(this);
      this.field12153 = new KeyBindSetting(field12212)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12281))
         .method03023(this);
      this.field12154 = new KeyBindSetting(field12213)
         .method03017(new KeyBinding())
         .method03025(() -> this.field12124.method05600(field12280))
         .method03023(this);
      this.field12155 = new ArrayList<>();
      this.field12156 = new LinkedHashMap<>();
      this.field12157 = new ServerItemUseController();
      this.field12169 = -1;
      this.field12170 = -1;
      this.field12173 = new IdentityHashMap<>();
      this.field12174 = false;
      this.method05762();
      this.method03935(field12214);
      PotionItemData.method11423();
   }

   private void method05792(Slot var1, ItemStack var2) {
      if (this.field12169 < 0) {
         int var3 = mc.player.containerMenu.containerId;
         int var4 = var1.index;
         TickTaskScheduler.method03507(() -> mc.gameMode.handleContainerInput(var3, var4, 40, ClickType.SWAP, mc.player));
         this.field12170 = var4;
         this.field12169 = 0;
         MutableComponent var5 = Component.literal(field12273).copy().append(field12274).append(var2.getStyledHoverName());
         NotificationManager.method08598(var5, field12275, var2);
      }
   }

   private boolean method05794(PotionContents var1, ServerHelper.Nested172 var2) {
      var var3 = var2.method05812();
      if (var3.isEmpty()) {
         return false;
      }

      ArrayList var4 = new ArrayList();

      for (MobEffectInstance var6 : var1.getAllEffects()) {
         var4.add(var6);
      }

      if (var4.size() != var3.size()) {
         return false;
      }

      for (ServerHelper.Nested173 var10 : var3) {
         int var7 = -1;

         for (int var8 = 0; var8 < var4.size(); var8++) {
            if (var10.method05821((MobEffectInstance)var4.get(var8))) {
               var7 = var8;
               break;
            }
         }

         if (var7 == -1) {
            return false;
         }

         var4.remove(var7);
      }

      return true;
   }

   @Override
   public void method00245() {
      this.method05797();
      super.method00245();
   }

   public void method05797() {
      this.field12174 = false;
      this.field12155.clear();
      this.field12157.method11649();
      this.method05788();
      this.field12169 = -1;
      this.field12170 = -1;
   }

   @Subscribe
   private void method05800(KeyInputEvent var1) {
      if (var1.method05884() != InputAction.RELEASE) {
         this.method05769(var1.method05887());
      }
   }

   @Subscribe
   private void method05805(PacketEvent var1) {
      if (this.field12124.method05600(field12276)) {
         if (var1.method10904()
            && var1.method10897() instanceof ClientboundOpenScreenPacket var2
            && this.field12127.method05999()
            && mc.player != null
            && mc.player.tickCount < 100
            && var2.getTitle().getString().contains(field12277)) {
            mc.player.connection.send(new ServerboundContainerClosePacket(var2.getContainerId()));
            var1.method05696();
         } else {
            if (var1.method10899()
               && var1.method10897() instanceof ServerboundChatPacket var4
               && this.field12128.method05999()
               && this.method05764(var4.message())) {
               var1.method05696();
               ChatTextUtils.method05086(field12278);
            }
         }
      }
   }

   // $VF: Compiled from s
   public static class Nested172 {
      private String field12370;
      private String field12371;
      private Item field12372;
      private String field12373;
      private Integer field12374;
      private boolean field12375;
      private List<ServerHelper.Nested173> field12376;
      private static final String field12377 = "\\|";

      public List<ServerHelper.Nested173> method05806() {
         return this.field12376;
      }

      public Nested172() {
      }

      public Integer method05807() {
         return this.field12374;
      }

      public void method05808(List<ServerHelper.Nested173> var1) {
         this.field12376 = var1;
      }

      public void method05809(Integer var1) {
         this.field12374 = var1;
      }

      public void method05810(String var1) {
         this.field12370 = var1;
      }

      public Item method05811() {
         return this.field12372;
      }

      public List<ServerHelper.Nested173> method05812() {
         if (this.field12376 != null) {
            return this.field12376;
         }

         ArrayList var1 = new ArrayList();
         if (this.field12373 != null && !this.field12373.isEmpty()) {
            String[] var2 = this.field12373.split(field12377);

            for (String var6 : var2) {
               String var7 = var6.trim();
               if (!var7.isEmpty()) {
                  var1.add(ServerHelper.Nested173.method05822(var7));
               }
            }
         }

         this.field12376 = var1;
         return this.field12376;
      }

      public String method05813() {
         return this.field12373;
      }

      public void method05814(boolean var1) {
         this.field12375 = var1;
      }

      public boolean method05815() {
         return this.field12375;
      }

      public void method05816(Item var1) {
         this.field12372 = var1;
      }

      public Nested172(String var1, String var2, Item var3, String var4, Integer var5) {
         this.field12370 = var1;
         this.field12372 = var3;
         this.field12371 = var2;
         this.field12373 = var4;
         this.field12374 = var5;
      }

      public void method05817(String var1) {
         this.field12373 = var1;
         this.field12376 = null;
      }

      public Nested172(String var1, String var2, Item var3) {
         this.field12370 = var1;
         this.field12371 = var2;
         this.field12372 = var3;
      }

      public String method05818() {
         return this.field12371;
      }

      public String method05819() {
         return this.field12370;
      }

      public void method05820(String var1) {
         this.field12371 = var1;
      }

      public Nested172(String var1, String var2, Item var3, String var4) {
         this.field12370 = var1;
         this.field12372 = var3;
         this.field12371 = var2;
         this.field12373 = var4;
      }
   }

   // $VF: Compiled from s
   private static class Nested173 {
      private final String field12378;
      private final Integer field12379;
      private final Integer field12380;
      private static final String field12381 = ",";
      private static final String field12382 = "dur=";
      private static final String field12383 = "lvl=";

      private Nested173(String var1, Integer var2, Integer var3) {
         this.field12378 = var1;
         this.field12379 = var2;
         this.field12380 = var3;
      }

      public boolean method05821(MobEffectInstance var1) {
         if (!this.field12378.equals(var1.getDescriptionId())) {
            return false;
         } else {
            return this.field12379 != null && var1.getDuration() != this.field12379
               ? false
               : this.field12380 == null || var1.getAmplifier() + 1 == this.field12380;
         }
      }

      public static ServerHelper.Nested173 method05822(String var0) {
         String[] var1 = var0.split(field12381);
         String var2 = var1[0].trim();
         Integer var3 = null;
         Integer var4 = null;

         for (int var5 = 1; var5 < var1.length; var5++) {
            String var6 = var1[var5].trim();
            if (var6.startsWith(field12382)) {
               var3 = method05823(var6.substring(4));
            } else if (var6.startsWith(field12383)) {
               var4 = method05823(var6.substring(4));
            }
         }

         return new ServerHelper.Nested173(var2, var3, var4);
      }

      private static Integer method05823(String var0) {
         try {
            return Integer.parseInt(var0.trim());
         } catch (NumberFormatException var2) {
            return null;
         }
      }
   }

   // $VF: Compiled from s
   public static class Nested174 {
      private ItemStack field12384;
      private String field12385;

      public ItemStack method05824() {
         return this.field12384;
      }

      public String method05825() {
         return this.field12385;
      }

      public Nested174(ItemStack var1, String var2) {
         this.field12384 = var1;
         this.field12385 = var2;
      }
   }
}
