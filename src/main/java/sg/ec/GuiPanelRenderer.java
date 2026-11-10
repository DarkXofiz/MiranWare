// Original binary: sg/ec/3i0xKxsmy4FcJXgu
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class GuiPanelRenderer {
   public static final float field01716 = 2.0F;
   public static final float field01717 = 0;
   private static final float field01718 = 0;
   private static final float field01719 = 0;
   private static final int field01720 = 0;
   private static final float field01721 = 0;
   private static final float field01722 = 0;
   private static final float field01723 = 0;
   private static final float field01724 = 0;
   private static final float field01725 = 0;
   private static final float field01726 = 0;
   private static final float field01727 = 0;
   private static final float field01728 = 0.28F;
   private static final float field01729 = 0.01F;
   private static final float field01730 = 0.05F;
   private static final int field01731 = -10263709;
   private static final float field01732 = 0.7F;
   private static final float field01733 = 0.32F;
   private static final float field01734 = 0.35F;
   private static final float field01735 = 0.65F;
   private static final float field01736 = 0.18F;
   private static final float field01737 = 17.0F;
   private static final float field01738 = 5.5F;
   private static final float field01739 = 4.0F;
   private static final float field01740 = 3.0F;
   private static final float field01741 = 6.0F;
   private static final float field01742 = 4.0F;
   private static final float field01743 = 6.0F;
   private static final float field01744 = 3.0F;
   private static final float field01745 = 5.5F;
   private static final float field01746 = 5.5F;

   public static void method00760(
      GuiGraphicsExtractor var0, FontRenderer var1, float var2, float var3, float var4, float var5, String var6, float var7, int var8, int var9
   ) {
      RoundedRectRenderer.method01272(var0, var2, var3, var4, var5, 2.0F, 1.0F, var8);
      var1.method09473(var0, var6, var2 + var4 / 2.0F, var3 + var5 / 2.0F - var1.method09485(var7) / 2.0F, var9, var7);
   }

   public static void method00761(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5) {
      GuiIcon.DOTS
         .method01190(
            var0,
            var1,
            var2,
            var3,
            GuiThemeStyle.method01443(GuiThemeStyle.method01440(field01731, GuiThemeStyle.method01441().field22109.method11676(), var4), var5)
         );
   }

   private GuiPanelRenderer() {
   }

   public static int method00762(float var0, float var1) {
      ThemeSettings var2 = GuiThemeStyle.method01441();
      return GuiThemeStyle.method01440(
         GuiThemeStyle.method01443(var2.field22120.method11676(), field01732 * var1),
         GuiThemeStyle.method01443(var2.field22113.method11676(), field01733 * var1),
         var0
      );
   }

   public static int method00763(float var0, float var1) {
      ThemeSettings var2 = GuiThemeStyle.method01441();
      return GuiThemeStyle.method01443(
         GuiThemeStyle.method01440(var2.field22110.method11676(), var2.field22109.method11676(), field01734 + field01735 * var0), var1
      );
   }

   public static float method00764(GuiGraphicsExtractor var0, float var1, float var2, float var3, GuiIcon var4, String var5, float var6, float var7) {
      return method00767(var0, var1, var2, var3, var4, var5, method00762(var6, var7), method00763(var6, var7));
   }

   public static void method00765(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      RoundedRectRenderer.method01272(
         var0, var1, var2, var3, var4, 2.0F, 1.0F, GuiThemeStyle.method01443(GuiThemeStyle.method01439(), field01728 * var6)
      );
      if (var5 > field01729) {
         RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, 2.0F, 1.0F, GuiThemeStyle.method01437(field01730 * var5 * var6));
      }
   }

   public static float method00766(String var0) {
      return field01737 + Fonts.field00110.method09486(var0, field01738) + 1.0F;
   }

   private static float method00767(GuiGraphicsExtractor var0, float var1, float var2, float var3, GuiIcon var4, String var5, int var6, int var7) {
      FontRenderer var8 = Fonts.field00110;
      float var9 = method00766(var5);
      RoundedRectRenderer.method01272(var0, var1, var2, var9, var3, 2.0F, 1.0F, var6);
      var4.method01190(var0, var1 + field01739 + field01740, var2 + var3 / 2.0F, field01741, var7);
      var8.method09480(var0, var5, var1 + field01742 + field01743 + field01744, var2 + var3 / 2.0F - var8.method09485(field01745) / 2.0F, var7, field01746);
      return var1 + var9;
   }

   public static int method00768(int var0, float var1) {
      return GuiThemeStyle.method01443(var0, field01736 * var1);
   }

   public static float method00769(GuiGraphicsExtractor var0, float var1, float var2, float var3, GuiIcon var4, String var5, int var6, float var7) {
      return method00767(var0, var1, var2, var3, var4, var5, method00768(var6, var7), GuiThemeStyle.method01443(var6, var7));
   }
}
