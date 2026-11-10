// Original binary: sg/ec/7cY7u4Una5nIzqvB
package sg.ec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class AutoBuyScreen extends ClientScreen {
   private static final int field04111 = 10;
   private static final int field04112 = 0;
   private static final float field04113 = 0;
   private static final float field04114 = 0;
   private static final float field04115 = 0;
   private static final float field04116 = 0;
   private static final float field04117 = 0;
   private static final float field04118 = 0;
   private static final float field04119 = 0;
   private static final float field04120 = 0;
   private static final float field04121 = 0;
   private static final float field04122 = 0;
   private static final float field04123 = 0;
   private static final float field04124 = 0;
   private static final float field04125 = 0;
   private static final float field04126 = 0;
   private static final float field04127 = 0;
   private static final float field04128 = 0;
   private static final float field04129 = 0;
   private static final float field04130 = 0;
   private static final float field04131 = 0;
   private static final float field04132 = 0;
   private static final float field04133 = 0;
   private static final float field04134 = 0;
   private static final float field04135 = 0;
   private static final float field04136 = 0;
   private static final float field04137 = 0;
   private static final float field04138 = 0;
   private static final float field04139 = 0;
   private static final float field04140 = 0;
   private static final float field04141 = 0;
   private static final float field04142 = 0;
   private static final float field04143 = 0;
   private static final float field04144 = 0;
   private static final float field04145 = 0;
   private static final float field04146 = 0;
   private static final float field04147 = 0;
   private static final float field04148 = 0;
   private static final float field04149 = 0;
   private static final float field04150 = 0;
   private static final float field04151 = 0;
   private static final float field04152 = 0;
   private static final float field04153 = 0;
   private static final float field04154 = 0;
   private static final float field04155 = 0;
   private static final float field04156 = 0;
   private static final float field04157 = 0;
   private static final float field04158 = 0;
   private static final float field04159 = 0;
   private static final float field04160 = 0;
   private static final float field04161 = 0;
   private static final float field04162 = 0;
   private static final float field04163 = 0;
   private static final float field04164 = 0;
   private static final float field04165 = 0;
   private static final float field04166 = 0;
   private static final float field04167 = 0;
   private static final float field04168 = 0;
   private static final String field04169 = "field04169";
   private static final String field04170 = "field04170";
   private static final String field04171 = "field04171";
   private static final String field04172 = "field04172";
   private static final String field04173 = "field04173";
   private static final String field04174 = "field04174";
   private static final String field04175 = "field04175";
   private static final String field04176 = "field04176";
   private static final String field04177 = "field04177";
   private static final String field04178 = "field04178";
   private static final String field04179 = "field04179";
   private static final String field04180 = "field04180";
   private static final String field04181 = "field04181";
   private static final String field04182 = "field04182";
   private static final String field04183 = "field04183";
   private static final String field04184 = "field04184";
   private static final String field04185 = "field04185";
   private static final String field04186 = "field04186";
   private static final String field04187 = "field04187";
   private final ModuleContextMenu field04188 = new ModuleContextMenu();
   private final AutoBuyItemSearch field04189 = new AutoBuyItemSearch();
   private final Map<Object, SmoothAnimation> field04190 = new HashMap<>();
   private final Map<Object, SmoothAnimation> field04191 = new HashMap<>();
   private final GuiClickRegions field04192 = new GuiClickRegions();
   private final GuiClickRegions field04193 = new GuiClickRegions();
   private final GuiClickRegions field04194 = new GuiClickRegions();
   private final ScrollController field04195 = new ScrollController();
   private final GuiBounds field04196 = new GuiBounds();
   private final TextInputWidget field04197;
   private float field04198;
   private float field04199;
   private float field04200;
   private boolean field04201;
   private boolean field04202;
   private float field04203;
   private float field04204;
   private AutoBuyItem field04205;
   private AutoBuyItemSearch.Nested251 field04206;
   private final SmoothAnimation field04207;
   private AutoBuyItem field04208;
   private AutoBuyItemSearch.Nested251 field04209;
   private float field04210;
   private float field04211;
   private static final float field04212 = 6.0F;
   private static final String field04213 = "Поиск предмета";
   private static final float field04214 = 4.0F;
   private static final float field04215 = -1000.0F;
   private static final float field04216 = -1000.0F;
   private static final float field04217 = 166.0F;
   private static final float field04218 = 166.0F;
   private static final float field04219 = 129.0F;
   private static final float field04220 = 332.0F;
   private static final float field04221 = 258.0F;
   private static final float field04222 = 0.85F;
   private static final float field04223 = 332.0F;
   private static final float field04224 = 258.0F;
   private static final float field04225 = 7.0F;
   private static final float field04226 = 35.0F;
   private static final float field04227 = 332.0F;
   private static final float field04228 = 258.0F;
   private static final float field04229 = 7.0F;
   private static final float field04230 = 332.0F;
   private static final float field04231 = 258.0F;
   private static final float field04232 = 7.0F;
   private static final float field04233 = 15.0F;
   private static final float field04234 = 0.6F;
   private static final float field04235 = 22.0F;
   private static final float field04236 = 0.5F;
   private static final float field04237 = 328.0F;
   private static final float field04238 = 0.5F;
   private static final float field04239 = 0.5F;
   private static final float field04240 = 11.0F;
   private static final float field04241 = 7.5F;
   private static final float field04242 = 6.0F;
   private static final String field04243 = "QuickBuy";
   private static final float field04244 = 8.0F;
   private static final float field04245 = 7.5F;
   private static final float field04246 = 8.0F;
   private static final String field04247 = "QuickBuy";
   private static final float field04248 = 7.5F;
   private static final float field04249 = 5.0F;
   private static final float field04250 = 4.5F;
   private static final float field04251 = 9.0F;
   private static final float field04252 = 9.0F;
   private static final float field04253 = 14.0F;
   private static final float field04254 = 6.0F;
   private static final float field04255 = 6.0F;
   private static final float field04256 = 5.0F;
   private static final float field04257 = 332.0F;
   private static final float field04258 = 8.0F;
   private static final float field04259 = 9.0F;
   private static final float field04260 = 4.5F;
   private static final String field04261 = "x";
   private static final float field04262 = 9.0F;
   private static final float field04263 = 9.0F;
   private static final String field04264 = "x";
   private static final float field04265 = 4.5F;
   private static final float field04266 = 4.5F;
   private static final float field04267 = 7.5F;
   private static final float field04268 = 7.5F;
   private static final float field04269 = 9.0F;
   private static final float field04270 = 9.0F;
   private static final float field04271 = 5.0F;
   private static final float field04272 = 82.0F;
   private static final float field04273 = 6.5F;
   private static final float field04274 = 82.0F;
   private static final float field04275 = 13.0F;
   private static final String field04276 = "F";
   private static final float field04277 = 6.0F;
   private static final float field04278 = 0.2F;
   private static final String field04279 = "F";
   private static final float field04280 = 82.0F;
   private static final float field04281 = 4.0F;
   private static final float field04282 = 6.0F;
   private static final float field04283 = 0.5F;
   private static final float field04284 = 6.0F;
   private static final float field04285 = 0.2F;
   private static final float field04286 = 82.0F;
   private static final float field04287 = 5.0F;
   private static final float field04288 = 13.0F;
   private static final String field04289 = "скупка идёт";
   private static final float field04290 = 22.0F;
   private static final float field04291 = 8.0F;
   private static final float field04292 = 258.0F;
   private static final float field04293 = 8.0F;
   private static final float field04294 = 8.0F;
   private static final float field04295 = 316.0F;
   private static final float field04296 = 332.0F;
   private static final String field04297 = "Список пуст — найди предмет через поиск или добавь из руки";
   private static final String field04298 = "ничего не найдено";
   private static final float field04299 = 166.0F;
   private static final float field04300 = 6.0F;
   private static final float field04301 = 6.0F;
   private static final float field04302 = 28.0F;
   private static final float field04303 = 10.0F;
   private static final float field04304 = 8.0F;
   private static final float field04305 = 5.0F;
   private static final float field04306 = 0.5F;
   private static final float field04307 = 316.0F;
   private static final float field04308 = 0.5F;
   private static final float field04309 = 0.5F;
   private static final float field04310 = 8.0F;
   private static final float field04311 = 32.0F;
   private static final float field04312 = 32.0F;
   private static final float field04313 = 32.0F;
   private static final float field04314 = 4.0F;
   private static final float field04315 = 28.0F;
   private static final float field04316 = 28.0F;
   private static final float field04317 = 28.0F;
   private static final float field04318 = 0.4F;
   private static final float field04319 = 28.0F;
   private static final float field04320 = 4.0F;
   private static final float field04321 = 4.0F;
   private static final float field04322 = 1.5F;
   private static final float field04323 = 28.0F;
   private static final float field04324 = 28.0F;
   private static final float field04325 = 28.0F;
   private static final float field04326 = 28.0F;
   private static final float field04327 = 0.4F;
   private static final String field04328 = "+";
   private static final float field04329 = 6.0F;
   private static final String field04330 = "+";
   private static final float field04331 = 28.0F;
   private static final float field04332 = 4.0F;
   private static final float field04333 = 1.5F;
   private static final float field04334 = 1.5F;
   private static final float field04335 = 6.0F;
   private static final float field04336 = 28.0F;
   private static final float field04337 = 28.0F;
   private static final float field04338 = 0.5F;
   private static final float field04339 = 0.14F;
   private static final float field04340 = 0.01F;
   private static final float field04341 = 28.0F;
   private static final float field04342 = 28.0F;
   private static final float field04343 = 4.0F;
   private static final float field04344 = 6.0F;
   private static final float field04345 = 0.55F;
   private static final float field04346 = 28.0F;
   private static final float field04347 = 28.0F;
   private static final float field04348 = 4.0F;
   private static final float field04349 = 0.01F;
   private static final float field04350 = 28.0F;
   private static final float field04351 = 28.0F;
   private static final float field04352 = 4.0F;
   private static final float field04353 = 0.5F;
   private static final float field04354 = 0.75F;
   private static final float field04355 = 28.0F;
   private static final float field04356 = 28.0F;
   private static final float field04357 = 4.0F;
   private static final float field04358 = 6.0F;
   private static final float field04359 = 6.0F;
   private static final double field04360 = 0.15F;
   private static final float field04361 = 0.01F;
   private static final String field04362 = "добавить в список";
   private static final String field04363 = "включён";
   private static final String field04364 = "выключен";
   private static final String field04365 = "цена не задана";
   private static final float field04366 = 3.0F;
   private static final float field04367 = 7.0F;
   private static final float field04368 = 44.0F;
   private static final float field04369 = 12.0F;
   private static final float field04370 = 26.0F;
   private static final float field04371 = 7.0F;
   private static final float field04372 = 3.0F;
   private static final float field04373 = 9.0F;
   private static final float field04374 = 14.0F;
   private static final float field04375 = 28.0F;
   private static final float field04376 = 5.0F;
   private static final float field04377 = 5.0F;
   private static final float field04378 = 0.9F;
   private static final float field04379 = 0.7F;
   private static final float field04380 = 0.9F;
   private static final float field04381 = 0.100000024F;
   private static final float field04382 = 5.0F;
   private static final float field04383 = 12.0F;
   private static final float field04384 = 5.0F;
   private static final float field04385 = 10.0F;
   private static final float field04386 = 0.6F;
   private static final float field04387 = 5.0F;
   private static final float field04388 = 5.0F;
   private static final float field04389 = 0.5F;
   private static final float field04390 = 6.0F;
   private static final float field04391 = 13.0F;
   private static final float field04392 = 26.0F;
   private static final float field04393 = 26.0F;
   private static final float field04394 = 4.0F;
   private static final float field04395 = 0.6F;
   private static final float field04396 = 3.0F;
   private static final float field04397 = 1.25F;
   private static final float field04398 = 26.0F;
   private static final float field04399 = 6.0F;
   private static final float field04400 = 6.0F;
   private static final float field04401 = 7.0F;
   private static final float field04402 = 7.0F;
   private static final float field04403 = 3.0F;
   private static final float field04404 = 3.0F;
   private static final float field04405 = 6.0F;
   private static final float field04406 = 8.0F;
   private static final float field04407 = 9.0F;
   private static final float field04408 = 4.5F;
   private static final float field04409 = 0.18F;
   private static final float field04410 = 4.0F;
   private static final float field04411 = 4.5F;
   private static final float field04412 = 6.0F;
   private static final float field04413 = 0.5F;
   private static final float field04414 = 6.0F;
   private static final String field04415 = "AutoBuy";
   private static final String field04416 = "Добавлено в список покупок.";
   private static final String field04417 = "AutoBuy";
   private static final String field04418 = "Возьми предмет в руку, чтобы добавить его в список.";
   private static final String field04419 = "AutoBuy";
   private static final String field04420 = "Добавлено: ";
   private static final String field04421 = ".";
   private static final String field04422 = "AutoBuy";
   private static final String field04423 = "Такой предмет уже есть в списке.";
   private static final String field04424 = "autobuy.settings";
   private static final float field04425 = 332.0F;
   private static final float field04426 = 6.0F;
   private static final float field04427 = 150.0F;
   private static final float field04428 = 6.0F;
   private static final float field04429 = 150.0F;
   private static final String field04430 = "autobuy.entry";
   private static final float field04431 = 28.0F;
   private static final float field04432 = 150.0F;
   private static final float field04433 = 258.0F;
   private static final double field04434 = 0.2F;
   private static final float field04435 = 332.0F;
   private static final float field04436 = 22.0F;
   private static final float field04437 = 0.999F;

   private static float method01703(String var0) {
      return GuiThemeStyle.field03545.method09486(var0, field04405) + field04406;
   }

   private static void method01704(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3, float var4) {
      ItemRenderUtils.method08416(var0, var1, var2 + field04358, var3 + field04359, 1.0F, var4);
   }

   private void method01705(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      int var7 = GuiThemeStyle.method01441().field22120.method11676();
      int var8 = GuiThemeStyle.method01443(var7, field04338 * var6);
      int var9 = GuiThemeStyle.method01443(ColorUtils.method04583(var7, ColorUtils.field10169, field04339), var6);
      if (var5 > field04340) {
         GuiShadowRenderer.method10984(
            var1, var2, var3, field04341, field04342, field04343, 1.0F, field04344, GuiThemeStyle.method01446(field04345 * var5 * var6)
         );
      }

      RoundedRectRenderer.method01272(var1, var2, var3, field04346, field04347, field04348, 1.0F, GuiThemeStyle.method01440(var8, var9, var4));
      if (var4 > field04349) {
         GuiShapeRenderer.method09703(
            var1, var2, var3, field04350, field04351, field04352, field04353, GuiThemeStyle.method01446(field04354 * var4 * var6)
         );
      }

      GuiThemeStyle.method01448(var1, var2, var3, field04355, field04356, field04357, var5, var6);
   }

   private void method01706(GuiGraphicsExtractor var1, AutoBuyItem var2, float var3, float var4, float var5, float var6, float var7) {
      boolean var8 = this.method01734(var3, var4, var5, var6);
      float var9 = this.method01727(var2, var8);
      float var10 = method01719(this.field04191, var2, var2.method10672());
      this.method01705(var1, var3, var4, var10, var9, var7);
      method01704(var1, var2.method10716(), var3, var4, Mth.lerp(var10, field04318, 1.0F) * var7);
      if (var2.method10672() && var2.method10682() <= 0) {
         GuiThemeStyle.method01447(var1, var3 + field04319 - field04320, var4 + field04321, field04322, GuiThemeStyle.field03548, var7);
      }

      if (var8) {
         this.method01731(var2, null, var3, var4);
      }

      this.field04193.method03442(var3, var4, field04323, field04324, () -> this.method01713(var2));
      this.field04194.method03442(var3, var4, field04325, field04326, () -> this.method01725(var2, var3, var4));
   }

   private void method01707() {
      if (!this.field04201) {
         this.field04198 = GuiScaleUtils.method06753() / 2.0F - field04218;
         this.field04199 = GuiScaleUtils.method06754() / 2.0F - field04219;
         this.field04201 = true;
      }
   }

   @Override
   public boolean method01477(double var1, double var3, int var5, boolean var6) {
      Vec2 var7 = GuiScaleUtils.method06746(var1, var3);
      double var8 = var7.x;
      double var10 = var7.y;
      boolean var12 = this.field04188.method09666();
      this.field04188.method09653(var8, var10, var5);
      if (!var12 && !this.field04188.method09668(var8, var10)) {
         if (this.field04197.method06703(var8, var10, var5) || this.method01470() < field04437) {
            return true;
         }

         if (var5 == 1) {
            if (this.field04196.method02799(var8, var10)) {
               this.field04194.method03441(var8, var10);
            }

            return true;
         } else {
            if (var5 != 0) {
               return true;
            }

            if (this.field04192.method03441(var8, var10)) {
               return true;
            }

            if (this.field04196.method02799(var8, var10) && this.field04193.method03441(var8, var10)) {
               return true;
            }

            if (this.method01726(var8, var10)) {
               this.field04202 = true;
               this.field04203 = (float)var8 - this.field04198;
               this.field04204 = (float)var10 - this.field04199;
            }

            return true;
         }
      } else {
         return true;
      }
   }

   private static float method01709(float var0, int var1) {
      return var0 + var1 / 10 * field04312;
   }

   private float method01710(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5) {
      var var6 = this.field04189.method09032();
      var var7 = this.field04189.method09035();
      if (var6.isEmpty() && var7.isEmpty()) {
         String var13 = this.field04197.method06685() ? field04297 : field04298;
         GuiThemeStyle.field03545
            .method09473(
               var1,
               var13,
               this.field04198 + field04299,
               this.field04196.method02808() + this.field04196.method02802() / 2.0F - GuiThemeStyle.field03545.method09485(field04300) / 2.0F,
               GuiThemeStyle.method01445(var5),
               field04301
            );
         return var2 + field04302;
      }

      for (int var9 = 0; var9 < var6.size(); var9++) {
         float var10 = this.method01715(var9);
         float var11 = method01709(var2, var9);
         if (this.method01730(var11)) {
            this.method01706(var1, (AutoBuyItem)var6.get(var9), var10, var11, var3, var4, var5);
         }
      }

      float var8 = method01733(var2, var6.size());
      if (var7.isEmpty()) {
         return var8;
      }

      float var14 = var6.isEmpty() ? var2 : var8 + field04303;
      if (!var6.isEmpty()) {
         RoundedRectRenderer.method01272(
            var1,
            this.field04198 + field04304,
            var8 + field04305 - field04306,
            field04307,
            1.0F,
            field04308,
            1.0F,
            GuiThemeStyle.method01442(field04309 * var5)
         );
      }

      for (int var15 = 0; var15 < var7.size(); var15++) {
         float var16 = this.method01715(var15);
         float var12 = method01709(var14, var15);
         if (this.method01730(var12)) {
            this.method01714(var1, (AutoBuyItemSearch.Nested251)var7.get(var15), var16, var12, var3, var4, var5);
         }
      }

      return method01733(var14, var7.size());
   }

   private void method01712(Item var1) {
      if (AutoBuyItemRegistry.INSTANCE
         .method10990(
            AutoBuyItem.method10730(AutoBuyItemRegistry.INSTANCE.method10998(), var1).method10745(AutoBuyItem.method10670(var1)).method10743()
         )) {
         ChatTextUtils.method05101(field04415, field04416);
      }
   }

   private void method01713(AutoBuyItem var1) {
      var1.method10703(!var1.method10672());
      AutoBuyItemRegistry.INSTANCE.method10994();
   }

   private void method01714(GuiGraphicsExtractor var1, AutoBuyItemSearch.Nested251 var2, float var3, float var4, float var5, float var6, float var7) {
      boolean var8 = this.method01734(var3, var4, var5, var6);
      float var9 = this.method01727(var2.item(), var8);
      this.method01705(var1, var3, var4, 0.0F, var9, var7);
      method01704(var1, var2.stack(), var3, var4, Mth.lerp(var9, field04327, 1.0F) * var7);
      float var10 = GuiThemeStyle.field03544.method09486(field04328, field04329);
      GuiThemeStyle.field03544
         .method09480(
            var1, field04330, var3 + field04331 - field04332 + field04333 - var10, var4 + field04334, GuiThemeStyle.method01446(var7), field04335
         );
      if (var8) {
         this.method01731(null, var2, var3, var4);
      }

      this.field04193.method03442(var3, var4, field04336, field04337, () -> this.method01712(var2.item()));
   }

   @Override
   protected void method01472(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      float var5 = this.method01470();
      Vec2 var6 = GuiScaleUtils.method06746(var2, var3);
      boolean var7 = this.field04188.method09668(var6.x, var6.y);
      float var8 = var7 ? field04215 : var6.x;
      float var9 = var7 ? field04216 : var6.y;
      this.method01724(var6.x, var6.y);
      this.field04189.method09037(this.field04197.method06672());
      this.field04192.method03440();
      this.field04193.method03440();
      this.field04194.method03440();
      this.method01467(var1, this.field04198 + field04217, this.field04199);
      this.method01736(var1, var5);
      this.method01720(var1, var8, var9, var5);
      this.field04205 = null;
      this.field04206 = null;
      this.method01718(var1, var8, var9, var5);
      var1.pose().popMatrix();
      GuiRenderBatch.method05183();
      this.field04188.method09659(var1, (int)var6.x, (int)var6.y, var5);
      this.method01729(var1, var5);
   }

   public AutoBuyScreen() {
      this.field04197 = new TextInputWidget().method06678(GuiThemeStyle.field03544, field04212);
      this.field04207 = new SmoothAnimation();
      this.field04197.method06717(field04213);
      this.field04197.method06734(field04214);
   }

   @Override
   public boolean method01471() {
      return this.field04197.method06726() || this.field04188.method09665();
   }

   @Override
   public boolean method01464(int var1, int var2, int var3) {
      this.field04188.method09670(var1, var2, var3);
      if (this.field04188.method09665()) {
         return true;
      } else {
         return !this.field04197.method06726() ? false : this.field04197.method06733(var1) || var1 != 256;
      }
   }

   private float method01715(int var1) {
      return this.field04198 + field04310 + var1 % 10 * field04311;
   }

   private static float method01716(GuiGraphicsExtractor var0, String var1, int var2, float var3, float var4, float var5) {
      float var6 = method01703(var1);
      RoundedRectRenderer.method01272(var0, var3, var4, var6, field04407, field04408, 1.0F, GuiThemeStyle.method01443(var2, field04409 * var5));
      GuiThemeStyle.field03545
         .method09480(
            var0,
            var1,
            var3 + field04410,
            var4 + field04411 - GuiThemeStyle.field03545.method09485(field04412) / 2.0F - field04413,
            GuiThemeStyle.method01443(var2, var5),
            field04414
         );
      return var3 + var6;
   }

   private String method01717() {
      AutoBuyPurchaseController var1 = AutoBuyManager.INSTANCE.method09774();
      if (var1.method09139()) {
         return "подбор цен " + var1.method09150();
      } else {
         return AutoBuyManager.INSTANCE.method09776() ? field04289 : "";
      }
   }

   private void method01718(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      float var5 = this.field04199 + field04290 + field04291;
      float var6 = this.field04199 + field04292 - field04293 - var5;
      this.field04196.method02801(this.field04198 + field04294);
      this.field04196.method02806(var5);
      this.field04196.method02803(field04295);
      this.field04196.method02798(var6);
      this.field04195.method01152(this.field04200 > var6);
      this.field04195.method01145();
      this.field04195.method01134(this.field04200, var6);
      float var7 = var5 + this.field04195.method01136();
      var1.enableScissor((int)this.field04198, (int)var5, (int)Math.ceil(this.field04198 + field04296), (int)Math.ceil(var5 + var6));
      float var8 = this.method01710(var1, var7, var2, var3, var4);
      var1.disableScissor();
      this.field04200 = var8 - var7;
   }

   @Override
   protected void method01466() {
      this.field04202 = false;
      this.field04197.method06722();

      for (FloatingWindow var2 : this.field04188.method09655()) {
         if (!var2.method01698()) {
            this.field04188.method09654(var2);
         }
      }
   }

   private static float method01719(Map<Object, SmoothAnimation> var0, Object var1, boolean var2) {
      SmoothAnimation var3 = var0.computeIfAbsent(var1, var0x -> new SmoothAnimation());
      var3.method06162();
      var3.method06158(var2 ? 1.0 : 0.0, field04434, Easings.field19400);
      return var3.method06173();
   }

   private void method01720(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      ThemeSettings var5 = GuiThemeStyle.method01441();
      float var6 = this.field04199 + field04240;
      float var7 = var6 - GuiThemeStyle.field03543.method09485(field04241) / 2.0F;
      float var8 = var6 - GuiThemeStyle.field03545.method09485(field04242) / 2.0F;
      GuiThemeStyle.field03543
         .method09480(var1, field04243, this.field04198 + field04244, var7, GuiThemeStyle.method01443(var5.field22108.method11679(), var4), field04245);
      float var9 = this.field04198 + field04246 + GuiThemeStyle.field03543.method09486(field04247, field04248) + field04249;
      Identifier var10 = ClientTextures.INSTANCE.method04557(AutoBuyItemRegistry.INSTANCE.method10998().method06431());
      GuiTextureRenderer.method10259(var1, var10, var9, var6 - field04250, field04251, field04252, GuiThemeStyle.method01443(-1, var4));
      var9 += field04253;
      String var11 = this.method01717();
      if (!var11.isEmpty()) {
         GuiThemeStyle.field03545.method09480(var1, var11, var9, var8, GuiThemeStyle.method01446(var4), field04254);
         var9 += GuiThemeStyle.field03545.method09486(var11, field04255) + field04256;
      }

      float var12 = this.field04198 + field04257 - field04258 - field04259;
      float var13 = var6 - field04260;
      float var14 = this.method01727(field04261, GuiHitTestUtils.method05625(var2, var3, var12, var13, field04262, field04263));
      int var15 = GuiThemeStyle.method01440(
         GuiThemeStyle.method01445(var4), GuiThemeStyle.method01443(GuiThemeStyle.field03548, var4), var14
      );
      GuiThemeStyle.field03544
         .method09473(
            var1, field04264, var12 + field04265, var13 + field04266 - GuiThemeStyle.field03544.method09485(field04267) / 2.0F, var15, field04268
         );
      this.field04192.method03442(var12, var13, field04269, field04270, ClientScreenManager.INSTANCE::method08321);
      float var16 = var12 - field04271 - field04272;
      float var17 = var6 - field04273;
      GuiInputRenderer.method08816(var1, var16, var17, field04274, field04275, this.method01727(this.field04197, this.field04197.method06726()), var4);
      float var18 = Fonts.field00107.method09478(field04276, field04277, field04278);
      Fonts.field00107
         .method09490(
            var1,
            field04279,
            var16 + field04280 - field04281 - var18,
            var6 - Fonts.field00107.method09485(field04282) / 2.0F + field04283,
            GuiThemeStyle.method01445(var4),
            field04284,
            field04285
         );
      this.field04197.method06700(var16, var17, field04286 - var18 - field04287, field04288).method06670(var1, var2, var4);
   }

   @Override
   public boolean method01465(double var1, double var3, int var5) {
      Vec2 var6 = GuiScaleUtils.method06746(var1, var3);
      this.field04188.method09664(var6.x, var6.y, var5);
      this.field04197.method06673(var6.x, var6.y, var5);
      if (var5 == 0) {
         this.field04202 = false;
      }

      return true;
   }

   public ModuleContextMenu method01721() {
      return this.field04188;
   }

   @Override
   public boolean method01476(char var1, int var2) {
      this.field04188.method09662(var1, var2);
      return this.field04188.method09665() ? true : this.field04197.method06726() && this.field04197.method06730(var1);
   }

   private static void method01723(GuiGraphicsExtractor var0, float var1, float var2, float var3) {
      var0.pose().pushMatrix();
      var0.pose().translate(var1, var2);
      var0.pose().scale(var3, var3);
      var0.pose().translate(-var1, -var2);
   }

   private void method01724(float var1, float var2) {
      this.method01707();
      if (this.field04202) {
         this.field04198 = var1 - this.field04203;
         this.field04199 = var2 - this.field04204;
      }

      this.field04198 = Mth.clamp(this.field04198, 0.0F, Math.max(0.0F, GuiScaleUtils.method06753() - field04220));
      this.field04199 = Mth.clamp(this.field04199, 0.0F, Math.max(0.0F, GuiScaleUtils.method06754() - field04221));
   }

   @Override
   public boolean method01463(double var1, double var3, double var5, double var7) {
      Vec2 var9 = GuiScaleUtils.method06746(var1, var3);
      this.field04188.method09651(var9.x, var9.y, var7);
      if (this.field04188.method09668(var9.x, var9.y)) {
         return true;
      }

      if (this.field04196.method02799(var9.x, var9.y)) {
         this.field04195.method01133(var7);
      }

      return true;
   }

   private void method01725(AutoBuyItem var1, float var2, float var3) {
      FloatingWindow var4 = this.field04188.method09669(field04430);
      if (var4 != null) {
         this.field04188.method09655().remove(var4);
      }

      float var5 = Math.min(var2 + field04431 + 2.0F, GuiScaleUtils.method06753() - field04432 - 2.0F);
      float var6 = Math.min(var3, GuiScaleUtils.method06754() - field04433 - 2.0F);
      this.field04188.method09652(new AutoBuyEntryWindow(var1), var5, var6);
   }

   @Override
   protected void method01474() {
      this.field04197.method06702();
      this.field04195.method01144();
      this.method01707();
      this.method01732();
   }

   private boolean method01726(double var1, double var3) {
      return GuiHitTestUtils.method05609(var1, var3, this.field04198, this.field04199, field04435, field04436);
   }

   private float method01727(Object var1, boolean var2) {
      return method01719(this.field04190, var1, var2);
   }

   private void method01729(GuiGraphicsExtractor var1, float var2) {
      this.field04207.method06162();
      this.field04207.method06158(this.field04205 == null && this.field04206 == null ? 0.0 : 1.0, field04360, Easings.field19400);
      float var3 = this.field04207.method06173();
      if (!(var3 < field04361) && (this.field04208 != null || this.field04209 != null)) {
         float var4 = var3 * var2;
         boolean var5 = this.field04208 == null;
         ItemStack var6 = var5 ? this.field04209.stack() : this.field04208.method10716();
         String var7 = var5 ? this.field04209.name() : this.field04208.method10673();
         String var8 = var5 ? field04362 : (this.field04208.method10672() ? field04363 : field04364);
         int var9 = !var5 && !this.field04208.method10672() ? GuiThemeStyle.method01445(1.0F) : GuiThemeStyle.method01446(1.0F);
         boolean var10 = !var5 && this.field04208.method10682() > 0;
         String var11 = var5 ? null : (var10 ? "до " + NumberFormatUtils.method08163(this.field04208.method10682()) : field04365);
         int var12 = var10 ? GuiThemeStyle.method01437(1.0F) : GuiThemeStyle.method01443(GuiThemeStyle.field03548, 1.0F);
         float var13 = method01703(var8) + (var11 == null ? 0.0F : field04366 + method01703(var11));
         float var14 = Math.max(GuiThemeStyle.field03544.method09486(var7, field04367), var13);
         float var15 = field04368 + var14;
         float var16 = field04369 + Math.max(field04370, GuiThemeStyle.field03544.method09485(field04371) + field04372 + field04373);
         float var17 = Mth.clamp(this.field04210 + field04374 - var15 / 2.0F, 2.0F, GuiScaleUtils.method06753() - var15 - 2.0F);
         float var18 = this.field04211 + field04375 + field04376;
         float var19 = var18 + var16 <= GuiScaleUtils.method06754() - 2.0F ? var18 : this.field04211 - field04377 - var16;
         ThemeSettings var20 = GuiThemeStyle.method01441();
         int var21 = GuiThemeStyle.method01443(var20.field22121.method11676(), field04378 * var4);
         int var22 = !var5 && !this.field04208.method10672()
            ? GuiThemeStyle.method01443(var20.field22117.method11676(), var4)
            : GuiThemeStyle.method01446(field04379 * var4);
         GuiRenderBatch.method05183();
         method01723(var1, var17 + var15 / 2.0F, var19 + var16 / 2.0F, field04380 + field04381 * var3);
         GuiClipStack.method00341(var1, var17, var19, var15, var16, field04382, 1.0F, field04383, var4);
         GuiShadowRenderer.method10984(var1, var17, var19, var15, var16, field04384, 1.0F, field04385, GuiThemeStyle.method01443(var21, field04386));
         RoundedRectRenderer.method01272(var1, var17, var19, var15, var16, field04387, 1.0F, var21);
         GuiShapeRenderer.method09703(var1, var17, var19, var15, var16, field04388, field04389, var22);
         float var23 = var17 + field04390;
         float var24 = var19 + var16 / 2.0F - field04391;
         RoundedRectRenderer.method01272(
            var1, var23, var24, field04392, field04393, field04394, 1.0F, GuiThemeStyle.method01443(var20.field22120.method11676(), field04395 * var4)
         );
         float var25 = field04396;
         ItemRenderUtils.method08416(var1, var6, var23 + var25, var24 + var25, field04397, var4);
         float var26 = var23 + field04398 + field04399;
         float var27 = var19 + field04400;
         GuiThemeStyle.field03544.method09480(var1, var7, var26, var27, GuiThemeStyle.method01437(var4), field04401);
         float var28 = var27 + GuiThemeStyle.field03544.method09485(field04402) + field04403;
         float var29 = method01716(var1, var8, var9, var26, var28, var4);
         if (var11 != null) {
            method01716(var1, var11, var12, var29 + field04404, var28, var4);
         }

         var1.pose().popMatrix();
      }
   }

   private boolean method01730(float var1) {
      return var1 + field04315 >= this.field04196.method02808() && var1 <= this.field04196.method02808() + this.field04196.method02802();
   }

   private void method01731(AutoBuyItem var1, AutoBuyItemSearch.Nested251 var2, float var3, float var4) {
      this.field04205 = var1;
      this.field04206 = var2;
      this.field04208 = var1;
      this.field04209 = var2;
      this.field04210 = var3;
      this.field04211 = var4;
   }

   private void method01732() {
      FloatingWindow var1 = this.field04188.method09669(field04424);
      if (var1 != null) {
         var1.method09572(true);
      } else {
         float var2 = this.field04198 + field04425 + field04426;
         if (var2 + field04427 > GuiScaleUtils.method06753()) {
            var2 = this.field04198 - field04428 - field04429;
         }

         this.field04188.method09652(new AutoBuySettingsWindow(this), var2, this.field04199);
      }
   }

   private static float method01733(float var0, int var1) {
      int var2 = (var1 + 10 - 1) / 10;
      return var0 + var2 * field04313 - field04314;
   }

   private boolean method01734(float var1, float var2, float var3, float var4) {
      return this.field04196.method02799(var3, var4) && GuiHitTestUtils.method05625(var3, var4, var1, var2, field04316, field04317);
   }

   public void method01735() {
      if (mc.player != null) {
         ItemStack var1 = mc.player.getMainHandItem();
         if (var1.isEmpty()) {
            ChatTextUtils.method05101(field04417, field04418);
         } else {
            if (AutoBuyItemRegistry.INSTANCE.method10990(AutoBuyItem.method10700(AutoBuyItemRegistry.INSTANCE.method10998(), var1))) {
               ChatTextUtils.method05096(field04419, Component.literal(field04420).append(var1.getHoverName()).append(Component.literal(field04421)));
            } else {
               ChatTextUtils.method05101(field04422, field04423);
            }
         }
      }
   }

   private void method01736(GuiGraphicsExtractor var1, float var2) {
      int var3 = GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22119.method11676(), field04222 * var2);
      GuiClipStack.method00341(var1, this.field04198, this.field04199, field04223, field04224, field04225, 1.0F, field04226, var2);
      RoundedRectRenderer.method01272(var1, this.field04198, this.field04199, field04227, field04228, field04229, 1.0F, var3);
      GuiShadowRenderer.method10984(
         var1, this.field04198, this.field04199, field04230, field04231, field04232, 1.0F, field04233, GuiThemeStyle.method01443(var3, field04234)
      );
      RoundedRectRenderer.method01272(
         var1,
         this.field04198 + 2.0F,
         this.field04199 + field04235 - field04236,
         field04237,
         1.0F,
         field04238,
         1.0F,
         GuiThemeStyle.method01442(field04239 * var2)
      );
   }
}
