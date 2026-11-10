// Original binary: sg/ec/RaUCiQpxGNgXYgxH
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class ItemFilterSettingComponent extends SettingComponent<ItemFilterSetting> {
   private static final float field11438 = 16.0F;
   private static final float field11439 = 0;
   private static final float field11440 = 0;
   private static final float field11441 = 0;
   private static final float field11442 = 0;
   private static final float field11443 = 0;
   private static final float field11444 = 0;
   private static final float field11445 = 0;
   private static final float field11446 = 0;
   private static final float field11447 = 0;
   private static final float field11448 = 0;
   private static final float field11449 = 0;
   private static final String field11450 = "field11450";
   private static final String field11451 = "field11451";
   private final FontRenderer field11452 = Fonts.field00110;
   private final FontRenderer field11453 = Fonts.field00111;
   private final SmoothAnimation field11454 = new SmoothAnimation();
   private final FloatingWindow field11455;
   private float field11456;
   private float field11457;
   private static final float field11458 = 16.0F;
   private static final double field11459 = 0.15F;
   private static final float field11460 = 14.0F;
   private static final float field11461 = 14.0F;
   private static final float field11462 = 4.0F;
   private static final float field11463 = 7.0F;
   private static final float field11464 = 16.0F;
   private static final float field11465 = 1.5F;
   private static final float field11466 = 5.5F;
   private static final String field11467 = "Не выбрано";
   private static final float field11468 = 7.0F;
   private static final float field11469 = 7.0F;
   private static final float field11470 = 5.5F;
   private static final float field11471 = 1.5F;
   private static final float field11472 = 5.5F;
   private static final float field11473 = 14.0F;
   private static final float field11474 = 14.0F;
   private static final float field11475 = 3.0F;
   private static final float field11476 = 14.0F;
   private static final float field11477 = 14.0F;
   private static final float field11478 = 3.0F;
   private static final float field11479 = 0.5F;
   private static final String field11480 = "+";
   private static final float field11481 = 7.0F;
   private static final float field11482 = 14.0F;
   private static final float field11483 = 7.0F;
   private static final float field11484 = 7.0F;
   private static final float field11485 = 0.75F;
   private static final float field11486 = 0.999F;
   private static final float field11487 = 14.0F;

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (!(this.method09790() < field11486) && var5 == 0 && this.method09787(var1, var3)) {
         if (this.field11455 != null && this.field11455.method09580() != null) {
            this.field11455.method09565(false);
            this.field11455
               .method09580()
               .method09652(new ItemPickerWindow(this.method10977(), this.field11455), this.field11456, this.field11457 + field11487 + 2.0F);
         }
      }
   }

   public ItemFilterSettingComponent(ItemFilterSetting var1, FloatingWindow var2) {
      super(var1);
      this.field11455 = var2;
      this.method09786(field11458);
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      ItemFilterSetting var6 = this.method10977();
      this.field11454.method06162();
      this.field11454.method06158(this.method09787(var2, var3) ? 1.0 : 0.0, field11459, Easings.field19400);
      this.field11456 = this.method09780() + this.method09784() - field11460;
      this.field11457 = this.method09782() + 1.0F;
      float var7 = this.method09784() - field11461 - field11462;
      float var8 = this.field11452.method09485(field11463);
      float var9 = this.method09782() + (field11464 - var8 - field11465 - this.field11453.method09485(field11466)) / 2.0F;
      String var10 = var6.method00872() ? var6.method03022().name() : field11467;
      this.field11452
         .method09480(
            var1,
            GuiThemeStyle.method01438(this.field11452, var6.method03024(), field11468, var7),
            this.method09780(),
            var9,
            ColorUtils.method04611(var5.field22108.method11676(), this.method09790()),
            field11469
         );
      this.field11453
         .method09480(
            var1,
            GuiThemeStyle.method01438(this.field11453, var10, field11470, var7),
            this.method09780(),
            var9 + var8 + field11471,
            ColorUtils.method04611(var5.field22110.method11676(), this.method09790()),
            field11472
         );
      int var11 = ColorUtils.method04631(var5.field22116.method11676(), var5.field22115.method11676(), this.field11454.method06173());
      RoundedRectRenderer.method01272(
         var1, this.field11456, this.field11457, field11473, field11474, field11475, 1.0F, ColorUtils.method04611(var11, this.method09790())
      );
      GuiShapeRenderer.method09703(
         var1,
         this.field11456,
         this.field11457,
         field11476,
         field11477,
         field11478,
         field11479,
         ColorUtils.method04611(var5.field22117.method11676(), this.method09790())
      );
      ItemStack var12 = var6.method00874();
      if (var12.isEmpty()) {
         this.field11453
            .method09473(
               var1,
               field11480,
               this.field11456 + field11481,
               this.field11457 + (field11482 - this.field11453.method09485(field11483)) / 2.0F,
               ColorUtils.method04611(var5.field22110.method11676(), this.method09790()),
               field11484
            );
      } else {
         ItemRenderUtils.method08416(var1, var12, this.field11456 + 1.0F, this.field11457 + 1.0F, field11485, this.method09790());
      }
   }
}
