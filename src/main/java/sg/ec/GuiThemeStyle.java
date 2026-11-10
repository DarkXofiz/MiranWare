// Original binary: sg/ec/6fbCuvdHA6l4xYSq
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public final class GuiThemeStyle {
   public static final FontRenderer field03543 = Fonts.field00109;
   public static final FontRenderer field03544 = Fonts.field00110;
   public static final FontRenderer field03545 = Fonts.field00111;
   public static final int field03546 = ColorUtils.method04604(120, 230, 130);
   public static final int field03547 = ColorUtils.method04604(235, 190, 90);
   public static final int field03548 = ColorUtils.method04604(235, 90, 90);
   public static final float field03549 = 2.0F;
   public static final float field03550 = 0;
   private static final float field03551 = 0;
   private static final float field03552 = 0;
   private static final float field03553 = 0;
   private static final float field03554 = 0.025F;
   private static final float field03555 = 0.01F;
   private static final float field03556 = 0.06F;
   private static final float field03557 = 6.5F;
   private static final float field03558 = 6.0F;
   private static final float field03559 = 0.6F;
   private static final float field03560 = 6.5F;
   private static final float field03561 = 6.5F;

   public static int method01437(float var0) {
      return method01443(method01441().field22109.method11676(), var0);
   }

   public static String method01438(FontRenderer var0, String var1, float var2, float var3) {
      return var1 != null && !var1.isEmpty() && !(var3 <= 0.0F) ? TextRenderUtils.method00678(var0, var1, var3, var2) : "";
   }

   public static int method01439() {
      return ColorUtils.method04583(method01441().field22119.method11676(), ColorUtils.field10170, field03554);
   }

   public static int method01440(int var0, int var1, float var2) {
      return ColorUtils.method04631(var0, var1, var2);
   }

   public static ThemeSettings method01441() {
      return ThemeManager.INSTANCE.method09611();
   }

   public static int method01442(float var0) {
      return method01443(method01441().field22118.method11676(), var0);
   }

   private GuiThemeStyle() {
   }

   public static int method01443(int var0, float var1) {
      return ColorUtils.method04611(var0, var1);
   }

   public static void method01444(
      GuiGraphics var0, float var1, float var2, float var3, float var4, String var5, float var6, GuiThemeStyle.Nested40 var7, float var8
   ) {
      String var9 = method01438(field03544, var5, field03557, var3 - field03558);
      if (var7 == GuiThemeStyle.Nested40.NORMAL) {
         KeyBadgeRenderer.method03191(var0, var1, var2, var3, var4, var9, var6, var8);
      } else {
         RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, 2.0F, 1.0F, method01443(method01441().field22120.method11676(), field03559 * var8));
         if (var7 == GuiThemeStyle.Nested40.DANGER) {
            method01448(var0, var1, var2, var3, var4, 2.0F, var6, var8);
         }

         int var10 = var7 == GuiThemeStyle.Nested40.DANGER ? method01443(field03548, var8) : method01445(var8);
         field03544.method09473(var0, var9, var1 + var3 / 2.0F, var2 + var4 / 2.0F - field03544.method09485(field03560) / 2.0F, var10, field03561);
      }
   }

   public static int method01445(float var0) {
      return method01443(method01441().field22110.method11676(), var0);
   }

   public static int method01446(float var0) {
      return method01443(method01441().field22113.method11676(), var0);
   }

   public static void method01447(GuiGraphics var0, float var1, float var2, float var3, int var4, float var5) {
      RoundedRectRenderer.method01272(var0, var1 - var3, var2 - var3, var3 * 2.0F, var3 * 2.0F, var3, 1.0F, method01443(var4, var5));
   }

   public static void method01448(GuiGraphics var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (var6 > field03555) {
         RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, var5, 1.0F, method01437(field03556 * var6 * var7));
      }
   }

   // $VF: Compiled from s
   public enum Nested40 {
      NORMAL,
      DISABLED,
      DANGER;
   }
}
