// Original binary: sg/ec/ZDHYlzmd8l0LoGuI
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public abstract class SettingsListWindow extends FloatingWindow {
   protected static final float field15346 = 6.0F;
   protected static final float field15347 = 0;
   protected static final float field15348 = 0;
   protected static final float field15349 = 0;
   protected static final float field15350 = 0;
   private static final float field15351 = 0;
   private static final float field15352 = 0;
   private static final float field15353 = 0;
   private static final float field15354 = 0;
   private static final float field15355 = 0;
   private static final float field15356 = 0;
   private static final float field15357 = 0;
   private static final float field15358 = 0;
   private static final float field15359 = 0;
   private static final float field15360 = 0;
   private static final float field15361 = 0;
   private static final float field15362 = 0;
   private static final float field15363 = 0;
   private static final float field15364 = 0;
   private static final float field15365 = 0;
   private static final float field15366 = GuiSize.method04763(SettingsListWindow.field15472)
      .method04764(SettingsListWindow.field15473)
      .method04768();
   private static final int field15367 = 0;
   private static final String field15368 = "field15368";
   protected final FontRenderer field15369 = GuiThemeStyle.field03544;
   protected final GuiClickRegions field15370 = new GuiClickRegions();
   protected GuiGraphicsExtractor field15371;
   protected float field15372;
   protected float field15373;
   protected float field15374;
   private final float field15375;
   private final ScrollController field15376 = new ScrollController();
   private final GuiBounds field15377 = new GuiBounds();
   private final GuiBounds field15378 = new GuiBounds();
   private final GuiBounds field15379 = new GuiBounds();
   private final Map<Object, SmoothAnimation> field15380 = new HashMap<>();
   private final Map<String, SmoothAnimation> field15381 = new HashMap<>();
   private final List<TextInputWidget> field15382 = new ArrayList<>();
   private final List<TooltipRenderer> field15383 = new ArrayList<>();
   private final List<Runnable> field15384 = new ArrayList<>();
   private float field15385;
   private boolean field15386;
   private String field15387;
   private float field15388;
   private float field15389;
   private static final String field15390 = "unknown";
   private static final String field15391 = "%.1f";
   private static final float field15392 = 14.0F;
   private static final float field15393 = 18.0F;
   private static final float field15394 = 26.0F;
   private static final float field15395 = 26.0F;
   private static final float field15396 = 13.0F;
   private static final float field15397 = 13.0F;
   private static final float field15398 = 6.0F;
   private static final float field15399 = 4.0F;
   private static final float field15400 = 14.0F;
   private static final float field15401 = 14.0F;
   private static final float field15402 = 26.0F;
   private static final float field15403 = 25.0F;
   private static final float field15404 = 6.0F;
   private static final float field15405 = 6.0F;
   private static final float field15406 = 7.0F;
   private static final float field15407 = 6.0F;
   private static final float field15408 = 0.5F;
   private static final float field15409 = 6.0F;
   private static final float field15410 = 6.0F;
   private static final float field15411 = 10.0F;
   private static final float field15412 = 7.0F;
   private static final String field15413 = "x";
   private static final float field15414 = 5.0F;
   private static final int field15415 = -1750963;
   private static final float field15416 = 7.0F;
   private static final float field15417 = 6.0F;
   private static final float field15418 = 12.0F;
   private static final float field15419 = 3.0F;
   private static final float field15420 = 0.92F;
   private static final float field15421 = 0.07999998F;
   private static final float field15422 = 18.0F;
   private static final float field15423 = 6.0F;
   private static final float field15424 = 10.0F;
   private static final float field15425 = 10.0F;
   private static final float field15426 = 6.0F;
   private static final float field15427 = 10.0F;
   private static final float field15428 = 4.0F;
   private static final float field15429 = 18.0F;
   private static final float field15430 = 18.0F;
   private static final float field15431 = 6.0F;
   private static final float field15432 = 9.6F;
   private static final float field15433 = 18.0F;
   private static final float field15434 = 0.6F;
   private static final float field15435 = 3.0F;
   private static final float field15436 = 18.0F;
   private static final float field15437 = 7.0F;
   private static final float field15438 = 7.0F;
   private static final float field15439 = 6.0F;
   private static final float field15440 = 7.0F;
   private static final double field15441 = 0.15F;
   private static final float field15442 = 0.999F;
   private static final float field15443 = 18.0F;
   private static final float field15444 = 5.0F;
   private static final float field15445 = 10.0F;
   private static final float field15446 = 10.5F;
   private static final float field15447 = 9.0F;
   private static final float field15448 = 13.0F;
   private static final float field15449 = 5.5F;
   private static final float field15450 = 6.0F;
   private static final float field15451 = 6.0F;
   private static final float field15452 = 7.0F;
   private static final float field15453 = 6.0F;
   private static final float field15454 = 0.5F;
   private static final float field15455 = 6.0F;
   private static final float field15456 = 15.333333F;
   private static final float field15457 = 9.333333F;
   private static final float field15458 = 15.333333F;
   private static final float field15459 = 7.0F;
   private static final float field15460 = 4.6666665F;
   private static final float field15461 = 6.0F;
   private static final float field15462 = 14.0F;
   private static final float field15463 = 9.0F;
   private static final float field15464 = 9.0F;
   private static final float field15465 = 15.0F;
   private static final float field15466 = 15.0F;
   private static final float field15467 = 15.0F;
   private static final float field15468 = 0.5F;
   private static final float field15469 = 0.5F;
   private static final float field15470 = 5.0F;
   private static final float field15471 = 5.5F;
   private static final float field15472 = 10.0F;
   private static final float field15473 = 0.5F;

   @Override
   public void method00612(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.field15371 = var1;
      this.field15372 = var2;
      this.field15373 = var3;
      this.field15374 = this.method09573().method06173() * GuiHitTestUtils.method05621(var4);
      this.method09557(this.method09569() && this.method06817() != null);
      this.method06846(var2, var3);
      this.field15370.method03440();
      var var5 = this.method04173();
      this.method06834(var5);
      GuiRenderBatch.method05183();
      this.method06843(this.field15374);
      WindowFrameRenderer.method03057(var1, this, field15366, this.field15374);
      this.method06857();
      this.method06855(var5);
      var1.pose().popMatrix();
   }

   private TextInputWidget method06817() {
      for (TextInputWidget var2 : this.field15382) {
         if (var2.method06726()) {
            return var2;
         }
      }

      return null;
   }

   protected void method06818(Runnable var1) {
      var1.run();
      this.method04187();
   }

   @Override
   public boolean method01686() {
      return false;
   }

   protected static SettingsListWindow.Nested200 method06819(final float var0, final SettingsListWindow.Nested201 var1) {
      return new SettingsListWindow.Nested200()      // $VF: Compiled from s
 {
         @Override
         public void method04198(float var1x) {
            var1.method06861(var1x);
         }

         @Override
         public float method04200() {
            return var0;
         }
      };
   }

   protected SettingsListWindow.Nested200 method06821(String var1, String[] var2, IntSupplier var3, IntConsumer var4) {
      TooltipRenderer var5 = new TooltipRenderer(var2, var3.getAsInt());
      this.field15383.add(var5);
      this.field15384.add(() -> this.method06818(() -> var4.accept(var5.method02648(this.field15372))));
      return method06819(field15402, var4x -> {
         this.method06836(var1, var4x);
         GuiBounds var5x = var5.method02647();
         var5x.method02801(this.method06833());
         var5x.method02806(var4x + field15447);
         var5x.method02803(this.method06856());
         var5x.method02798(field15448);
         var5.method02646(this.field15371, this.field15369, field15449, var3.getAsInt(), this.field15374);
      });
   }

   protected static <K> float method06824(Map<K, SmoothAnimation> var0, K var1, boolean var2) {
      SmoothAnimation var3 = var0.computeIfAbsent(var1, var0x -> new SmoothAnimation());
      var3.method06162();
      var3.method06158(var2 ? 1.0 : 0.0, field15441, Easings.field19400);
      return var3.method06173();
   }

   private void method06825(String var1, Consumer<String> var2) {
      try {
         var2.accept(var1.trim().replace(',', '.'));
         this.method04187();
      } catch (NumberFormatException var4) {
      }
   }

   protected void method04187() {
   }

   protected SettingsListWindow.Nested200 method06826(String var1) {
      return method06819(
         field15392,
         var2 -> {
            RoundedRectRenderer.method01272(
               this.field15371,
               this.method06833(),
               var2 + 1.0F,
               this.method06856(),
               1.0F,
               field15468,
               1.0F,
               GuiThemeStyle.method01442(field15469 * this.field15374)
            );
            this.field15369
               .method09480(
                  this.field15371,
                  var1.toUpperCase(Locale.ROOT),
                  this.method06833(),
                  var2 + field15470,
                  GuiThemeStyle.method01445(this.field15374),
                  field15471
               );
         }
      );
   }

   protected void method06827(String var1, float var2, float var3) {
      float var4 = var2 + field15406 - this.field15369.method09485(field15407) / 2.0F - field15408;
      this.field15369
         .method09480(
            this.field15371,
            GuiThemeStyle.method01438(this.field15369, var1, field15409, var3 - this.method06833()),
            this.method06833(),
            var4,
            GuiThemeStyle.method01437(this.field15374),
            field15410
         );
   }

   protected SettingsListWindow.Nested200 method06830(Supplier<String> var1, Supplier<GuiThemeStyle.Nested40> var2, Runnable var3) {
      return method06819(
         field15393,
         var4 -> {
            float var5 = method06824(
               this.field15380,
               var3,
               GuiHitTestUtils.method05625(this.field15372, this.field15373, this.method06833(), var4, this.method06856(), field15465)
            );
            GuiThemeStyle.method01444(
               this.field15371,
               this.method06833(),
               var4,
               this.method06856(),
               field15466,
               (String)var1.get(),
               var5,
               (GuiThemeStyle.Nested40)var2.get(),
               this.field15374
            );
            this.field15370.method03442(this.method06833(), var4, this.method06856(), field15467, var3);
         }
      );
   }

   private TextInputWidget method06831(int var1) {
      TextInputWidget var2 = new TextInputWidget().method06678(this.field15369, field15398);
      var2.method06734(field15399);
      var2.method06669(var1);
      this.field15382.add(var2);
      return var2;
   }

   @Override
   public void method01898(char var1, int var2) {
      TextInputWidget var3 = this.method06817();
      if (var3 != null) {
         var3.method06730(var1);
      }
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (this.field15378.method02799(var1, var3)) {
         this.field15376.method01133(var5);
      }
   }

   protected void method06832() {
      this.field15382.clear();
      this.field15383.clear();
      this.field15384.clear();
   }

   protected float method06833() {
      return this.method09576() + field15417;
   }

   private void method06834(List<SettingsListWindow.Nested200> var1) {
      this.field15385 = 0.0F;

      for (SettingsListWindow.Nested200 var3 : var1) {
         this.field15385 = this.field15385 + var3.method04200();
      }

      this.method09561(Math.min(this.field15375, field15422 + this.field15385 + field15423));
      this.field15377.method02803(field15424);
      this.field15377.method02798(field15425);
      this.field15377.method02801(this.method09576() + this.method09568() - field15426 - field15427);
      this.field15377.method02806(this.method09560() + field15428);
      this.field15378.method02801(this.method09576());
      this.field15378.method02806(this.method09560() + field15429);
      this.field15378.method02803(this.method09568());
      this.field15378.method02798(this.method09574() - field15430 - field15431);
      this.field15376.method01152(this.field15385 > this.field15378.method02802());
      this.field15376.method01145();
      this.field15376.method01134(this.field15385, this.field15378.method02802());
   }

   protected void method06836(String var1, float var2) {
      this.field15369
         .method09480(
            this.field15371,
            GuiThemeStyle.method01438(this.field15369, var1, field15404, this.method06856()),
            this.method06833(),
            var2 + 1.0F,
            GuiThemeStyle.method01437(this.field15374),
            field15405
         );
   }

   protected SettingsListWindow(String var1, float var2, float var3) {
      this(ModuleContextMenu.field21943.getOrDefault(var1, field15390), var1, var2, var3);
   }

   protected SettingsListWindow.Nested200 method06837(String var1, Supplier<String> var2, Consumer<String> var3, int var4) {
      TextInputWidget var5 = this.method06831(var4);
      var5.method06686(var2x -> this.method06825(var2x, var3));
      return method06819(field15394, var4x -> {
         this.method06836(var1, var4x);
         String var5x = (String)var2.get();
         if (!var5.method06726() && !var5.method06687().equals(var5x)) {
            var5.method06675(var5x);
         }

         this.method06841(var5, var4x + field15464);
      });
   }

   @Override
   public boolean method01682() {
      return true;
   }

   protected void method06841(TextInputWidget var1, float var2) {
      GuiInputRenderer.method08816(
         this.field15371, this.method06833(), var2, this.method06856(), field15396, method06824(this.field15380, var1, var1.method06726()), this.field15374
      );
      var1.method06700(this.method06833(), var2, this.method06856(), field15397).method06670(this.field15371, this.field15372, this.field15374);
   }

   private void method06843(float var1) {
      float var2 = var1 * var1 * (field15419 - 2.0F * var1);
      float var3 = field15420 + field15421 * var2;
      float var4 = this.method09576() + this.method09568() / 2.0F;
      this.field15371.pose().pushMatrix();
      this.field15371.pose().translate(var4, this.method09560());
      this.field15371.pose().scale(1.0F, var3);
      this.field15371.pose().translate(-var4, -this.method09560());
   }

   protected SettingsListWindow.Nested200 method06844(
      String var1, double var2, double var4, double var6, DoubleSupplier var8, DoubleConsumer var9, DoubleFunction<String> var10
   ) {
      return method06819(
         field15403,
         var11 -> {
            float var12 = this.method06833() - field15444;
            float var13 = this.method06856() + field15445;
            double var14 = var8.getAsDouble();
            double var16 = GuiListRenderer.method11179(
               this.field15371, var1, var2, var4, var6, var14, var1.equals(this.field15387), this.field15372, var10, var12, var13, var11, this.field15374
            );
            if (var16 != var14) {
               this.method06818(() -> var9.accept(var16));
            }

            this.field15370
               .method03442(
                  GuiListRenderer.method11181(var12),
                  GuiListRenderer.method11182(var11),
                  GuiListRenderer.method11180(var13),
                  field15446,
                  () -> this.field15387 = var1
               );
         }
      );
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      TextInputWidget var4 = this.method06817();
      if (var4 != null) {
         var4.method06733(var1);
      }
   }

   private void method06846(int var1, int var2) {
      if (this.field15386) {
         this.method09571(Mth.clamp(var1 - this.field15388, 0.0F, GuiScaleUtils.method06753() - this.method09568()));
         this.method09563(Mth.clamp(var2 - this.field15389, 0.0F, GuiScaleUtils.method06754() - this.method09574()));
      }
   }

   protected void method06847(float var1, float var2) {
      float var3 = var2 + (field15411 - this.field15369.method09485(field15412)) / 2.0F;
      this.field15369
         .method09473(this.field15371, field15413, var1 + field15414, var3, ColorUtils.method04611(field15415, this.field15374), field15416);
   }

   protected TextInputWidget method06849(String var1, int var2, Consumer<TextInputWidget> var3) {
      TextInputWidget var4 = this.method06831(var2);
      var4.method06717(var1);
      var4.method06689(() -> var3.accept(var4));
      return var4;
   }

   protected SettingsListWindow.Nested200 method06850(String var1, BooleanSupplier var2, Consumer<Boolean> var3) {
      return method06819(field15400, var4 -> {
         this.field15379.method02803(field15456);
         this.field15379.method02798(field15457);
         this.field15379.method02801(this.method06833() + this.method06856() - field15458);
         this.field15379.method02806(var4 + field15459 - field15460);
         ToggleSwitchRenderer.method03323(this.field15371, this.field15379, method06824(this.field15381, var1, var2.getAsBoolean()), this.field15374);
         this.method06827(var1, var4, this.field15379.method02809() - field15461);
         this.field15370.method03442(this.method06833(), var4, this.method06856(), field15462, () -> this.method06818(() -> var3.accept(!var2.getAsBoolean())));
      });
   }

   protected SettingsListWindow(String var1, String var2, float var3, float var4) {
      super(var1, var2);
      this.field15375 = var4;
      this.method08971(var3);
      this.method09561(var4);
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (!(this.method09573().method06173() < field15442)) {
         boolean var6 = this.field15378.method02799(var1, var3);
         boolean var7 = false;

         for (TextInputWidget var9 : this.field15382) {
            if (var6) {
               var7 |= var9.method06703(var1, var3, var5);
            } else if (var5 == 0) {
               var9.method06722();
            }
         }

         if (!var7 && var5 == 0) {
            if (this.field15377.method02799(var1, var3)) {
               this.method09580().method09654(this);
            } else if (GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), field15443)) {
               this.field15386 = true;
               this.field15388 = (float)var1 - this.method09576();
               this.field15389 = (float)var3 - this.method09560();
            } else if (this.field15378.method02799(var1, var3)) {
               for (int var10 = 0; var10 < this.field15383.size(); var10++) {
                  if (this.field15383.get(var10).method02645(var1, var3)) {
                     this.field15384.get(var10).run();
                     return;
                  }
               }

               this.field15370.method03441(var1, var3);
            }
         }
      }
   }

   protected SettingsListWindow.Nested200 method06851(String var1, Supplier<String> var2, Runnable var3) {
      return method06819(field15401, var4 -> {
         String var5 = (String)var2.get();
         float var6 = KeyLabelRenderer.method02576(this.field15369, var5, field15450);
         float var7 = KeyLabelRenderer.method02577(this.field15369, field15451);
         float var8 = this.method06833() + this.method06856() - var6;
         float var9 = var4 + field15452 - var7 / 2.0F;
         float var10 = method06824(this.field15380, var1, GuiHitTestUtils.method05625(this.field15372, this.field15373, var8, var9, var6, var7));
         KeyLabelRenderer.method02578(this.field15371, this.field15369, var8, var9, var5, field15453, var10 * field15454, this.field15374);
         this.method06827(var1, var4, var8 - field15455);
         this.field15370.method03442(var8, var9, var6, var7, () -> this.method06818(var3));
      });
   }

   protected static String method06852(float var0) {
      return var0 == (int)var0 ? String.valueOf((int)var0) : String.format(Locale.ROOT, field15391, var0);
   }

   protected abstract List<SettingsListWindow.Nested200> method04173();

   private void method06855(List<SettingsListWindow.Nested200> var1) {
      float var2 = this.field15378.method02808();
      float var3 = var2 + this.field15378.method02802();
      this.field15371
         .enableScissor(
            (int)this.field15378.method02809(), (int)var2, (int)Math.ceil(this.field15378.method02809() + this.field15378.method02804()), (int)Math.ceil(var3)
         );
      float var4 = var2 + this.field15376.method01136();

      for (SettingsListWindow.Nested200 var6 : var1) {
         float var7 = var6.method04200();
         if (var4 + var7 >= var2 && var4 <= var3) {
            var6.method04198(var4);
         }

         var4 += var7;
      }

      this.field15371.disableScissor();
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      for (TextInputWidget var7 : this.field15382) {
         var7.method06673(var1, var3, var5);
      }

      if (var5 == 0) {
         this.field15386 = false;
         this.field15387 = null;
      }
   }

   protected float method06856() {
      return this.method09568() - field15418;
   }

   protected ItemStack method05464() {
      return ItemStack.EMPTY;
   }

   private void method06857() {
      ThemeSettings var1 = GuiThemeStyle.method01441();
      float var2 = this.method06833();
      ItemStack var3 = this.method05464();
      if (!var3.isEmpty()) {
         float var4 = field15432;
         ItemRenderUtils.method08416(this.field15371, var3, var2, this.method09560() + (field15433 - var4) / 2.0F, field15434, this.field15374);
         var2 += var4 + field15435;
      }

      float var6 = this.method09560() + (field15436 - this.field15369.method09485(field15437)) / 2.0F;
      String var5 = GuiThemeStyle.method01438(this.field15369, this.method09566(), field15438, this.field15377.method02809() - field15439 - var2);
      this.field15369
         .method09480(this.field15371, var5, var2, var6, ColorUtils.method04611(var1.field22108.method11679(), this.field15374), field15440);
      this.method06847(this.field15377.method02809(), this.field15377.method02808());
   }

   protected SettingsListWindow.Nested200 method06858(String var1, TextInputWidget var2) {
      return method06819(field15395, var3 -> {
         this.method06836(var1, var3);
         this.method06841(var2, var3 + field15463);
      });
   }

   // $VF: Compiled from s
   protected interface Nested200 {
      float method04200();

      void method04198(float var1);
   }

   // $VF: Compiled from s
   private interface Nested201 {
      void method06861(float var1);
   }
}
