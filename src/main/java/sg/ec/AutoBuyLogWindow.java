// Original binary: sg/ec/oqOzMGBjGBJoj3hD
package sg.ec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class AutoBuyLogWindow extends FloatingWindow {
   public static final String field22267 = "autobuy.log";
   public static final float field22268 = 0;
   private static final float field22269 = 0;
   private static final float field22270 = 0;
   private static final float field22271 = 0;
   private static final float field22272 = 0;
   private static final float field22273 = 0;
   private static final float field22274 = 0;
   private static final float field22275 = 0;
   private static final float field22276 = 0;
   private static final float field22277 = 0;
   private static final float field22278 = 0;
   private static final float field22279 = 0;
   private static final float field22280 = 0;
   private static final float field22281 = 0;
   private static final float field22282 = 0;
   private static final float field22283 = 0;
   private static final float field22284 = 0;
   private static final float field22285 = 0;
   private static final float field22286 = 0;
   private static final float field22287 = 0;
   private static final float field22288 = 0;
   private static final float field22289 = 0;
   private static final float field22290 = 0;
   private static final float field22291 = GuiSize.method04763(AutoBuyLogWindow.field22397)
      .method04764(AutoBuyLogWindow.field22398)
      .method04768();
   private static final int field22292 = 0;
   private static final String field22293 = "field22293";
   private static final String[] field22294 = new String[]{AutoBuyLogWindow.field22399, AutoBuyLogWindow.field22400};
   private static final String field22295 = "field22295";
   private static final String field22296 = "field22296";
   private static final String field22297 = "field22297";
   private static final String field22298 = "field22298";
   private static final String field22299 = "field22299";
   private static final String field22300 = "field22300";
   private final FontRenderer field22301 = GuiThemeStyle.field03544;
   private final TooltipRenderer field22302 = new TooltipRenderer(field22294, 0);
   private final ScrollController field22303 = new ScrollController();
   private final GuiBounds field22304 = new GuiBounds();
   private final GuiBounds field22305 = new GuiBounds();
   private final DateFormat field22306;
   private AutoBuyLogWindow.Nested278 field22307;
   private float field22308;
   private boolean field22309;
   private float field22310;
   private float field22311;
   private static final String field22312 = "autobuy.log";
   private static final String field22313 = "dd.MM HH:mm";
   private static final float field22314 = 180.0F;
   private static final float field22315 = 200.0F;
   private static final float field22316 = 5.5F;
   private static final float field22317 = 3.0F;
   private static final float field22318 = 0.92F;
   private static final float field22319 = 0.07999998F;
   private static final float field22320 = 10.0F;
   private static final float field22321 = 10.0F;
   private static final float field22322 = 6.0F;
   private static final float field22323 = 10.0F;
   private static final float field22324 = 4.0F;
   private static final float field22325 = 6.0F;
   private static final float field22326 = 18.0F;
   private static final float field22327 = 12.0F;
   private static final float field22328 = 12.0F;
   private static final float field22329 = 18.0F;
   private static final float field22330 = 12.0F;
   private static final float field22331 = 2.5F;
   private static final float field22332 = 18.0F;
   private static final float field22333 = 12.0F;
   private static final float field22334 = 2.5F;
   private static final float field22335 = 6.0F;
   private static final float field22336 = 24.5F;
   private static final float field22337 = 18.0F;
   private static final float field22338 = 7.0F;
   private static final float field22339 = 6.0F;
   private static final float field22340 = 7.0F;
   private static final float field22341 = 10.0F;
   private static final float field22342 = 7.0F;
   private static final String field22343 = "x";
   private static final float field22344 = 5.0F;
   private static final int field22345 = -1750963;
   private static final float field22346 = 7.0F;
   private static final String field22347 = "покупок ещё нет";
   private static final String field22348 = "лоты ещё не выставлялись";
   private static final float field22349 = 6.0F;
   private static final float field22350 = 3.0F;
   private static final float field22351 = 5.5F;
   private static final float field22352 = 22.0F;
   private static final String field22353 = "—";
   private static final float field22354 = 24.5F;
   private static final float field22355 = 22.0F;
   private static final String field22356 = "продано";
   private static final String field22357 = "ждёт";
   private static final String field22358 = "в продаже";
   private static final float field22359 = 24.5F;
   private static final float field22360 = 6.0F;
   private static final float field22361 = 12.0F;
   private static final float field22362 = 0.15F;
   private static final float field22363 = 0.5F;
   private static final float field22364 = 22.0F;
   private static final float field22365 = 3.0F;
   private static final float field22366 = 5.0F;
   private static final float field22367 = 11.0F;
   private static final float field22368 = 8.0F;
   private static final float field22369 = 5.0F;
   private static final float field22370 = 16.0F;
   private static final float field22371 = 6.0F;
   private static final float field22372 = 4.0F;
   private static final float field22373 = 22.0F;
   private static final float field22374 = 4.0F;
   private static final float field22375 = 5.5F;
   private static final float field22376 = 6.5F;
   private static final float field22377 = 5.5F;
   private static final float field22378 = 10.0F;
   private static final float field22379 = 16.0F;
   private static final float field22380 = 12.0F;
   private static final float field22381 = 6.5F;
   private static final float field22382 = 6.5F;
   private static final float field22383 = 5.5F;
   private static final float field22384 = 5.5F;
   private static final float field22385 = 4.0F;
   private static final float field22386 = 5.5F;
   private static final float field22387 = 5.5F;
   private static final float field22388 = 4.0F;
   private static final float field22389 = 0.7F;
   private static final float field22390 = 5.5F;
   private static final float field22391 = 5.0F;
   private static final float field22392 = 6.5F;
   private static final float field22393 = 5.0F;
   private static final float field22394 = 5.5F;
   private static final float field22395 = 0.999F;
   private static final float field22396 = 18.0F;
   private static final float field22397 = 10.0F;
   private static final float field22398 = 0.5F;
   private static final String field22399 = "Покупки";
   private static final String field22400 = "Продажи";

   @Override
   public boolean method01682() {
      return true;
   }

   private void method09901() {
      this.field22304.method02803(field22320);
      this.field22304.method02798(field22321);
      this.field22304.method02801(this.method09576() + this.method09568() - field22322 - field22323);
      this.field22304.method02806(this.method09560() + field22324);
      GuiBounds var1 = this.field22302.method02647();
      var1.method02801(this.method09576() + field22325);
      var1.method02806(this.method09560() + field22326);
      var1.method02803(this.method09568() - field22327);
      var1.method02798(field22328);
      this.field22305.method02801(this.method09576());
      this.field22305.method02806(this.method09560() + field22329 + field22330 + field22331);
      this.field22305.method02803(this.method09568());
      this.field22305.method02798(this.method09574() - field22332 - field22333 - field22334 - field22335);
      float var2 = this.method09908() * field22336;
      this.field22303.method01152(var2 > this.field22305.method02802());
      this.field22303.method01145();
      this.field22303.method01134(var2, this.field22305.method02802());
   }

   private void method09902(GuiGraphicsExtractor var1) {
      ThemeSettings var2 = GuiThemeStyle.method01441();
      float var3 = this.method09560() + (field22337 - this.field22301.method09485(field22338)) / 2.0F;
      this.field22301
         .method09480(
            var1,
            this.method09566(),
            this.method09576() + field22339,
            var3,
            ColorUtils.method04611(var2.field22108.method11679(), this.field22308),
            field22340
         );
      float var4 = this.field22304.method02808() + (field22341 - this.field22301.method09485(field22342)) / 2.0F;
      this.field22301
         .method09473(
            var1, field22343, this.field22304.method02809() + field22344, var4, ColorUtils.method04611(field22345, this.field22308), field22346
         );
   }

   private float method09903(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      for (PurchaseHistory.Nested87 var6 : PurchaseHistory.field06969.method03142(AutoBuyItemRegistry.INSTANCE.method10998())) {
         if (var2 + field22352 >= var3 && var2 <= var4) {
            String var7 = var6.seller().isBlank() ? field22353 : var6.seller();
            this.method09904(
               var1,
               var2,
               var6.stack(),
               var6.name(),
               var7,
               this.field22306.format(new Date(var6.timestamp())),
               NumberFormatUtils.method08163(var6.paidPrice()),
               NumberFormatUtils.method08160(var6),
               NumberFormatUtils.method08161(var6)
            );
         }

         var2 += field22354;
      }

      return var2;
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (var5 == 0 && !(this.method09573().method06173() < field22395)) {
         if (this.field22304.method02799(var1, var3)) {
            this.method09580().method09654(this);
         } else if (this.field22302.method02645(var1, var3)) {
            AutoBuyLogWindow.Nested278 var6 = AutoBuyLogWindow.Nested278.values()[this.field22302.method02648(var1)];
            if (var6 != this.field22307) {
               this.field22307 = var6;
               this.field22303.method01144();
            }
         } else {
            if (GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), field22396)) {
               this.field22309 = true;
               this.field22310 = (float)var1 - this.method09576();
               this.field22311 = (float)var3 - this.method09560();
            }
         }
      }
   }

   private void method09904(
      GuiGraphicsExtractor var1, float var2, ItemStack var3, String var4, String var5, String var6, String var7, String var8, boolean var9
   ) {
      ThemeSettings var10 = GuiThemeStyle.method01441();
      float var11 = this.method09576() + field22360;
      float var12 = this.method09568() - field22361;
      int var13 = ColorUtils.method04611(
         ColorUtils.method04583(var10.field22121.method11676(), ColorUtils.field10170, field22362), field22363 * this.field22308
      );
      RoundedRectRenderer.method01272(var1, var11, var2, var12, field22364, field22365, 1.0F, var13);
      ItemRenderUtils.method08416(var1, var3, var11 + field22366, var2 + field22367 - field22368, 1.0F, this.field22308);
      float var14 = var11 + field22369 + field22370 + field22371;
      float var15 = var2 + field22372;
      float var16 = var2 + field22373 - field22374 - GuiThemeStyle.field03545.method09485(field22375);
      float var17 = this.field22301.method09486(var7, field22376);
      float var18 = GuiThemeStyle.field03545.method09486(var8, field22377);
      float var19 = var12 - field22378 - field22379 - field22380 - Math.max(var17, var18);
      this.field22301
         .method09480(
            var1,
            GuiThemeStyle.method01438(this.field22301, var4, field22381, var19),
            var14,
            var15,
            GuiThemeStyle.method01437(this.field22308),
            field22382
         );
      float var20 = GuiThemeStyle.field03545.method09486(var6, field22383);
      String var21 = GuiThemeStyle.method01438(GuiThemeStyle.field03545, var5, field22384, var19 - var20 - field22385);
      GuiThemeStyle.field03545.method09480(var1, var21, var14, var16, GuiThemeStyle.method01445(this.field22308), field22386);
      GuiThemeStyle.field03545
         .method09480(
            var1,
            var6,
            var14 + GuiThemeStyle.field03545.method09486(var21, field22387) + field22388,
            var16,
            GuiThemeStyle.method01445(field22389 * this.field22308),
            field22390
         );
      this.field22301.method09480(var1, var7, var11 + var12 - field22391 - var17, var15, GuiThemeStyle.method01437(this.field22308), field22392);
      GuiThemeStyle.field03545
         .method09480(
            var1,
            var8,
            var11 + var12 - field22393 - var18,
            var16,
            var9 ? GuiThemeStyle.method01446(this.field22308) : GuiThemeStyle.method01445(this.field22308),
            field22394
         );
   }

   private void method09905(GuiGraphicsExtractor var1, float var2) {
      float var3 = var2 * var2 * (field22317 - 2.0F * var2);
      float var4 = field22318 + field22319 * var3;
      float var5 = this.method09576() + this.method09568() / 2.0F;
      var1.pose().pushMatrix();
      var1.pose().translate(var5, this.method09560());
      var1.pose().scale(1.0F, var4);
      var1.pose().translate(-var5, -this.method09560());
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      if (var5 == 0) {
         this.field22309 = false;
      }
   }

   private void method09906(int var1, int var2) {
      if (this.field22309) {
         this.method09571(Mth.clamp(var1 - this.field22310, 0.0F, GuiScaleUtils.method06753() - this.method09568()));
         this.method09563(Mth.clamp(var2 - this.field22311, 0.0F, GuiScaleUtils.method06754() - this.method09574()));
      }
   }

   @Override
   public boolean method01686() {
      return false;
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (this.field22305.method02799(var1, var3)) {
         this.field22303.method01133(var5);
      }
   }

   @Override
   public void method00612(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.field22308 = this.method09573().method06173() * GuiHitTestUtils.method05621(var4);
      this.method09906(var2, var3);
      this.method09901();
      GuiRenderBatch.method05183();
      this.method09905(var1, this.field22308);
      WindowFrameRenderer.method03057(var1, this, field22291, this.field22308);
      this.method09902(var1);
      this.field22302.method02646(var1, this.field22301, field22316, this.field22307.ordinal(), this.field22308);
      this.method09907(var1);
      var1.pose().popMatrix();
   }

   private void method09907(GuiGraphicsExtractor var1) {
      float var2 = this.field22305.method02808();
      float var3 = var2 + this.field22305.method02802();
      var1.enableScissor(
         (int)this.field22305.method02809(), (int)var2, (int)Math.ceil(this.field22305.method02809() + this.field22305.method02804()), (int)Math.ceil(var3)
      );
      float var4 = var2 + this.field22303.method01136();
      if (this.field22307 == AutoBuyLogWindow.Nested278.PURCHASES) {
         var4 = this.method09903(var1, var4, var2, var3);
      } else {
         var4 = this.method09909(var1, var4, var2, var3);
      }

      if (var4 == var2 + this.field22303.method01136()) {
         this.field22301
            .method09480(
               var1,
               this.field22307 == AutoBuyLogWindow.Nested278.PURCHASES ? field22347 : field22348,
               this.method09576() + field22349 + 2.0F,
               var2 + field22350,
               GuiThemeStyle.method01445(this.field22308),
               field22351
            );
      }

      var1.disableScissor();
   }

   private int method09908() {
      return this.field22307 == AutoBuyLogWindow.Nested278.PURCHASES
         ? PurchaseHistory.field06969.method03142(AutoBuyItemRegistry.INSTANCE.method10998()).size()
         : AuctionSaleHistory.field07563.method03356(AutoBuyItemRegistry.INSTANCE.method10998()).size();
   }

   public AutoBuyLogWindow() {
      super(field22312);
      this.field22306 = new SimpleDateFormat(field22313, Locale.ROOT);
      this.field22307 = AutoBuyLogWindow.Nested278.PURCHASES;
      this.method08971(field22314);
      this.method09561(field22315);
   }

   private float method09909(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      for (AuctionSaleHistory.Nested94 var6 : AuctionSaleHistory.field07563.method03356(AutoBuyItemRegistry.INSTANCE.method10998())) {
         if (var2 + field22355 >= var3 && var2 <= var4) {
            boolean var7 = var6.isSold();
            String var8 = this.field22306.format(new Date(var7 ? var6.soldAtMs() : var6.listedAtMs()));
            String var9 = var7 && var6.profit() > 0L ? "+" + NumberFormatUtils.method08163(var6.profit()) : (var7 ? field22356 : field22357);
            this.method09904(
               var1, var2, var6.stack(), var6.name(), var7 ? var6.buyer() : field22358, var8, NumberFormatUtils.method08163(var6.askPrice()), var9, var7
            );
         }

         var2 += field22359;
      }

      return var2;
   }

   // $VF: Compiled from s
   private enum Nested278 {
      PURCHASES,
      SALES;
   }
}
