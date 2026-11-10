// Original binary: sg/ec/UMqUv4z9uvn0al77
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ColorSettingComponent extends SettingComponent<ColorSetting> {
   private final FontRenderer field12477 = Fonts.field00110;
   private final FloatingWindow field12478;
   private float field12479;
   private float field12480;
   private float field12481;
   private static final float field12482 = 12.5F;
   private static final float field12483 = 7.0F;
   private static final float field12484 = 8.0F;
   private static final float field12485 = 2.75F;
   private static final float field12486 = 12.5F;
   private static final float field12487 = 4.5F;
   private static final float field12488 = 4.0F;

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      float var5 = this.method09780();
      float sx = this.method09782();
      float sxx = field12483;
      float sxxx = this.method09785();
      this.field12477
         .method09480(
            var1,
            this.method10977().method03024(),
            var5,
            sx + sxxx / 2.0F - this.field12477.method09485(sxx) / 2.0F,
            ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22108.method11676(), this.method09790()),
            sxx
         );
      this.field12481 = field12484;
      this.field12479 = var5 + this.method09784() - this.field12481;
      this.field12480 = sx + sxxx / 2.0F - this.field12481 / 2.0F;
      RoundedRectRenderer.method01272(
         var1,
         this.field12479,
         this.field12480,
         this.field12481,
         this.field12481,
         field12485,
         1.0F,
         ColorUtils.method04611(this.method10977().method11676(), this.method09790())
      );
      this.method09786(field12486);
   }

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (var5 == 0) {
         if (GuiHitTestUtils.method05609(var1, var3, this.field12479, this.field12480, this.field12481, this.field12481)) {
            if (this.field12478 != null && this.field12478.method09580() != null) {
               this.field12478.method09565(false);
               this.field12478
                  .method09580()
                  .method09652(new ColorPickerWindow(this.method10977(), this.field12478), this.field12479 - field12487, this.field12480 - field12488);
            }
         }
      }
   }

   public ColorSettingComponent(ColorSetting var1, FloatingWindow var2) {
      super(var1);
      this.field12478 = var2;
      this.method09786(field12482);
   }
}
