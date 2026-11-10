// Original binary: sg/ec/0cXzYHeceQDjpNsS
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class SliderSettingComponent extends SettingComponent<SliderSetting> {
   private final FontRenderer field00246 = Fonts.field00110;
   private final FloatingWindow field00247;
   private float field00248;
   private float field00249;
   private float field00250;
   private static final float field00251 = 12.5F;
   private static final float field00252 = 7.0F;
   private static final float field00253 = 10.0F;
   private static final float field00254 = 0.3F;
   private static final float field00255 = 1.6F;
   private static final float field00256 = 1.6F;
   private static final float field00257 = 4.0F;
   private static final float field00258 = 1.5F;
   private static final float field00259 = 2.6F;
   private static final float field00260 = 12.5F;
   private static final float field00261 = 4.5F;
   private static final float field00262 = 4.0F;

   @Override
   public void method00040(double var1, double var3, int var5) {
      if (var5 == 0) {
         if (GuiHitTestUtils.method05609(var1, var3, this.field00248, this.field00249, this.field00250, this.field00250)) {
            if (this.field00247 != null && this.field00247.method09580() != null) {
               this.field00247.method09565(false);
               this.field00247
                  .method09580()
                  .method09652(new DiagramWindow(this.method10977(), this.field00247), this.field00248 - field00261, this.field00249 - field00262);
            }
         }
      }
   }

   public SliderSettingComponent(SliderSetting var1, FloatingWindow var2) {
      super(var1);
      this.field00247 = var2;
      this.method09786(field00251);
   }

   @Override
   public void method00042(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00042(var1, var2, var3, var4);
      float var5 = this.method09780();
      float var6 = this.method09782();
      float var7 = field00252;
      float var8 = this.method09785();
      ThemeSettings var9 = ThemeManager.INSTANCE.method09611();
      this.field00246
         .method09480(
            var1,
            this.method10977().method03024(),
            var5,
            var6 + var8 / 2.0F - this.field00246.method09485(var7) / 2.0F,
            ColorUtils.method04605(var9.field22108.method11676(), this.method09790()),
            var7
         );
      this.field00250 = field00253;
      this.field00248 = var5 + this.method09784() - this.field00250;
      this.field00249 = var6 + var8 / 2.0F - this.field00250 / 2.0F;
      float var10 = this.field00248 + this.field00250 / 2.0F;
      float var11 = this.field00249 + this.field00250 / 2.0F;
      float var12 = this.field00250 / 2.0F;
      int var13 = ColorUtils.method04611(
         ColorUtils.method04631(var9.field22120.method11676(), var9.field22121.method11676(), field00254), this.method09790()
      );
      int var14 = ColorUtils.method04611(var9.field22113.method11676(), this.method09790());
      RoundedRectRenderer.method01274(var1, var10, var11, this.field00250, var13);
      GuiShapeRenderer.method09703(
         var1,
         this.field00248,
         this.field00249,
         this.field00250,
         this.field00250,
         var12,
         1.0F,
         ColorUtils.method04611(var9.field22117.method11676(), this.method09790())
      );
      float var15 = (float)Math.toRadians(this.method10977().method00358());
      float var16 = var10 + Mth.sin(var15) * (var12 - field00255);
      float var17 = var11 - Mth.cos(var15) * (var12 - field00256);

      for (int var18 = 1; var18 <= 4; var18++) {
         float var19 = var18 / field00257;
         RoundedRectRenderer.method01274(var1, var10 + (var16 - var10) * var19, var11 + (var17 - var11) * var19, field00258, var14);
      }

      RoundedRectRenderer.method01274(var1, var16, var17, field00259, var14);
      this.method09786(field00260);
   }
}
