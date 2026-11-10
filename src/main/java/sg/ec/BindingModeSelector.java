// Original binary: sg/ec/8UaONV2ZzfzA7FaE
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class BindingModeSelector {
   private static final float field04603 = 5.5F;
   private static final float field04604 = 0;
   private static final float field04605 = 0;
   private final GuiBounds field04606 = new GuiBounds();
   private final SmoothAnimation field04607 = new SmoothAnimation();
   private static final double field04608 = 0.15F;
   private static final float field04609 = 5.5F;
   private static final float field04610 = 5.5F;
   private static final float field04611 = 5.5F;

   private void method01903(GuiGraphicsExtractor var1, FontRenderer var2, String var3, float var4, float var5, int var6) {
      float var7 = var2.method09486(var3, field04609);
      float sx = this.field04606.method02808() + (this.field04606.method02802() - var2.method09485(field04610)) / 2.0F;
      var2.method09480(var1, var3, var4 + (var5 - var7) / 2.0F, sx, var6, field04611);
   }

   public GuiBounds method01904() {
      return this.field04606;
   }

   public boolean method01905(double var1, double var3) {
      return this.field04606.method02799(var1, var3);
   }

   private static float method01906(KeyBindingMode var0) {
      return var0 == KeyBindingMode.Hold ? 1.0F : 0.0F;
   }

   public BindingModeSelector(KeyBindingMode var1) {
      this.field04607.method06155(method01906(var1));
   }

   public KeyBindingMode method01907(double var1) {
      return var1 >= this.field04606.method02809() + this.field04606.method02804() / 2.0F ? KeyBindingMode.Hold : KeyBindingMode.Toggle;
   }

   public void method01908(GuiGraphicsExtractor var1, FontRenderer var2, KeyBindingMode var3, float var4) {
      this.field04607.method06162();
      this.field04607.method06158(method01906(var3), field04608, Easings.field19412);
      float var5 = this.field04607.method06173();
      ThemeSettings var6 = ThemeManager.INSTANCE.method09611();
      int var7 = ColorUtils.method04611(var6.field22114.method11679(), var4);
      int var8 = ColorUtils.method04611(var6.field22113.method11679(), var4);
      int var9 = ColorUtils.method04611(var6.field22109.method11679(), var4);
      int var10 = ColorUtils.method04611(var6.field22110.method11679(), var4);
      float var11 = this.field04606.method02804() / 2.0F;
      float var12 = this.field04606.method02809() + var11 * var5;
      RoundedRectRenderer.method01272(
         var1, this.field04606.method02809(), this.field04606.method02808(), this.field04606.method02804(), this.field04606.method02802(), 2.0F, 1.0F, var7
      );
      RoundedRectRenderer.method01272(var1, var12, this.field04606.method02808(), var11, this.field04606.method02802(), 2.0F, 1.0F, var8);
      this.method01903(var1, var2, KeyBindingMode.Toggle.name(), this.field04606.method02809(), var11, ColorUtils.method04631(var9, var10, var5));
      this.method01903(
         var1, var2, KeyBindingMode.Hold.name(), this.field04606.method02809() + var11, var11, ColorUtils.method04631(var10, var9, var5)
      );
   }
}
