// Original binary: sg/ec/E5MP2XvwE7LScp35
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class KeyBadgeRenderer {
   public static final float field07003 = 2.0F;
   public static final float field07004 = 0;
   public static final float field07005 = 0;
   private static final FontRenderer field07006 = Fonts.field00110;
   private static final float field07007 = 0;
   private static final float field07008 = 0.7F;
   private static final float field07009 = 6.5F;
   private static final float field07010 = 6.5F;
   private static final float field07011 = 6.5F;

   public static void method03191(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, String var5, float var6, float var7) {
      ThemeSettings var8 = ThemeManager.INSTANCE.method09611();
      int sx = ColorUtils.method04611(var8.field22113.method11679(), var7);
      int sxx = ColorUtils.method04631(ColorUtils.method04611(sx, field07008), sx, var6);
      RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, 2.0F, 1.0F, sxx);
      field07006.method09473(
         var0,
         var5,
         var1 + var3 / 2.0F,
         var2 + (var4 - field07006.method09485(field07009)) / 2.0F,
         ColorUtils.method04611(var8.field22109.method11679(), var7),
         field07010
      );
   }

   public static float method03192(String var0) {
      return field07006.method09486(var0, field07011);
   }

   private KeyBadgeRenderer() {
   }
}
