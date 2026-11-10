// Original binary: sg/ec/g7LHIcPJxX4kYs5b
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class ClickGuiDecorationRenderer {
   public static final float field19357 = 15.0F;
   public static final float field19358 = 0;
   private static final float field19359 = 0;
   private static final float field19360 = 0;
   private static final float field19361 = 0;
   private static final float field19362 = 0;
   private static final float field19363 = 0;
   private static final float field19364 = 0;
   private static final float field19365 = 7.5F;
   private static final float field19366 = 9.0F;
   private static final float field19367 = 0.05F;
   private static final float field19368 = 0.6F;
   private static final float field19369 = 15.0F;
   private static final float field19370 = 15.0F;
   private static final float field19371 = 3.0F;
   private static final float field19372 = 0.12F;
   private static final float field19373 = 15.0F;
   private static final float field19374 = 0.375F;
   private static final float field19375 = 3.0F;
   private static final float field19376 = 0.75F;
   private static final float field19377 = 9.0F;

   public static void method08404(GuiGraphicsExtractor var0, float var1, float var2, String var3, float var4, float var5) {
      ThemeSettings var6 = ThemeManager.INSTANCE.method09611();
      Fonts.field00107
         .method09487(
            var0,
            var3,
            var1 + field19365,
            var2 - 1.0F,
            field19366,
            ColorUtils.method04631(
               ColorUtils.method04611(var6.field22110.method11676(), var5), ColorUtils.method04611(var6.field22109.method11676(), var5), var4
            )
         );
   }

   public static void method08405(GuiGraphicsExtractor var0, float var1, float var2, float var3) {
      int var4 = ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22118.method11676(), field19372 * var3);
      RoundedRectRenderer.method01272(var0, var1 + field19373 - field19374, var2 + field19375, field19376, field19377, 0.0F, 0.0F, var4);
   }

   private ClickGuiDecorationRenderer() {
   }

   public static void method08406(GuiGraphicsExtractor var0, float var1, float var2, int var3, float var4) {
      RoundedRectRenderer.method01272(var0, var1, var2, var3 * field19369, field19370, field19371, 1.0F, method08407(var4));
   }

   public static int method08407(float var0) {
      int var1 = ColorUtils.method04583(ThemeManager.INSTANCE.method09611().field22119.method11676(), ColorUtils.field10170, field19367);
      return ColorUtils.method04611(var1, field19368 * var0);
   }
}
