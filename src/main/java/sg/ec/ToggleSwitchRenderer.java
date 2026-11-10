// Original binary: sg/ec/F4kU8J9OGljCF5YK
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class ToggleSwitchRenderer {
   public static final float field07241 = 15.333333F;
   public static final float field07242 = 0;
   private static final float field07243 = 0;
   private static final float field07244 = 0;
   private static final float field07245 = 0;
   private static final float field07246 = 0;
   private static final float field07247 = 0;
   private static final float field07248 = 0;
   private static final float field07249 = 0.35F;
   private static final float field07250 = 0.8F;
   private static final float field07251 = 9.0F;
   private static final float field07252 = 5.5F;
   private static final float field07253 = 5.5F;
   private static final float field07254 = 5.5F;
   private static final float field07255 = 1.5F;
   private static final float field07256 = 0.8F;

   public static void method03323(GuiGraphicsExtractor var0, GuiBounds var1, float var2, float var3) {
      ThemeSettings var4 = ThemeManager.INSTANCE.method09611();
      int sx = ColorUtils.method04631(
         ColorUtils.method04611(var4.field22114.method11679(), var3), ColorUtils.method04611(var4.field22113.method11679(), var3), var2
      );
      int sxx = ColorUtils.method04611(var4.field22109.method11679(), var3);
      RoundedRectRenderer.method01272(
         var0, var1.method02809(), var1.method02808(), var1.method02804(), var1.method02802(), var1.method02802() * field07249, field07250, sx
      );
      float sxxx = var1.method02809() + 2.0F + (var1.method02804() - field07251) * var2;
      float sxxxx = var1.method02808() + (var1.method02802() - field07252) / 2.0F;
      RoundedRectRenderer.method01272(var0, sxxx, sxxxx, field07253, field07254, field07255, field07256, sxx);
   }

   private ToggleSwitchRenderer() {
   }
}
