// Original binary: sg/ec/B4ffxTDK2EKzkKPp
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public final class TooltipRenderer {
   private static final float field06201 = 2.0F;
   private static final float field06202 = 0;
   private final GuiBounds field06203 = new GuiBounds();
   private final SmoothAnimation field06204 = new SmoothAnimation();
   private final String[] field06205;
   private static final double field06206 = 0.15F;

   public boolean method02645(double var1, double var3) {
      return this.field06203.method02799(var1, var3);
   }

   public void method02646(GuiGraphics var1, FontRenderer var2, float var3, int var4, float var5) {
      this.field06204.method06162();
      this.field06204.method06158(var4, field06206, Easings.field19412);
      float var6 = this.field06204.method06173();
      ThemeSettings var7 = ThemeManager.INSTANCE.method09611();
      int var8 = ColorUtils.method04611(var7.field22114.method11679(), var5);
      int var9 = ColorUtils.method04611(var7.field22113.method11679(), var5);
      int var10 = ColorUtils.method04611(var7.field22109.method11679(), var5);
      int var11 = ColorUtils.method04611(var7.field22110.method11679(), var5);
      float var12 = this.field06203.method02804() / this.field06205.length;
      RoundedRectRenderer.method01272(
         var1, this.field06203.method02809(), this.field06203.method02808(), this.field06203.method02804(), this.field06203.method02802(), 2.0F, 1.0F, var8
      );
      RoundedRectRenderer.method01272(
         var1, this.field06203.method02809() + var12 * var6, this.field06203.method02808(), var12, this.field06203.method02802(), 2.0F, 1.0F, var9
      );
      float var13 = this.field06203.method02808() + (this.field06203.method02802() - var2.method09485(var3)) / 2.0F;

      for (int var14 = 0; var14 < this.field06205.length; var14++) {
         float var15 = Math.max(0.0F, 1.0F - Math.abs(var6 - var14));
         float var16 = var2.method09486(this.field06205[var14], var3);
         float var17 = this.field06203.method02809() + var12 * var14 + (var12 - var16) / 2.0F;
         var2.method09480(var1, this.field06205[var14], var17, var13, ColorUtils.method04631(var11, var10, var15), var3);
      }
   }

   public GuiBounds method02647() {
      return this.field06203;
   }

   public int method02648(double var1) {
      int var3 = (int)((var1 - this.field06203.method02809()) / (this.field06203.method02804() / this.field06205.length));
      return Math.max(0, Math.min(this.field06205.length - 1, var3));
   }

   public TooltipRenderer(String[] var1, int var2) {
      this.field06205 = var1;
      this.field06204.method06155(var2);
   }

   public float method02649(FontRenderer var1, float var2, float var3) {
      float var4 = 0.0F;

      for (String var8 : this.field06205) {
         var4 = Math.max(var4, var1.method09486(var8, var2));
      }

      return (var4 + var3 * 2.0F) * this.field06205.length;
   }
}
