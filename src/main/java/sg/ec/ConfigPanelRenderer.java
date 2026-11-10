// Original binary: sg/ec/DTvgPvpug2F4E8xz
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class ConfigPanelRenderer {
   public static final int field06873 = -29813;
   public static final float field06874 = 0;
   public static final float field06875 = 0;
   public static final float field06876 = 0;
   public static final float field06877 = 0;
   private static final float field06878 = 0;
   private static final float field06879 = 0;
   private static final float field06880 = 0;
   private static final float field06881 = 0;
   private static final float field06882 = 0;
   private static final float field06883 = 0;
   private static final float field06884 = 0;
   private static final float field06885 = 0;
   private static final float field06886 = 0;
   private static final float field06887 = 0;
   private static final float field06888 = 0;
   private static final float field06889 = 0;
   private static final float field06890 = 0;
   private static final float field06891 = 0;
   private static final float field06892 = 0;
   private static final float field06893 = 0;
   private static final float field06894 = 0;
   private static final float field06895 = 0;
   private static final float field06896 = 0;
   private static final float field06897 = 0;
   private static final float field06898 = 0;
   private static final float field06899 = 0;
   private static final int field06900 = -16777216;
   private static final float field06901 = 0.55F;
   private static final float field06902 = 0.07F;
   private static final float field06903 = 0.825F;
   private static final float field06904 = 0.5F;
   private static final float field06905 = 35.0F;
   private static final float field06906 = 15.0F;
   private static final float field06907 = 0.6F;
   private static final float field06908 = 0.08F;
   private static final float field06909 = 0.035F;
   private static final float field06910 = 0.07F;
   private static final float field06911 = 0.14F;
   private static final float field06912 = 0.07F;
   private static final float field06913 = 0.15F;
   private static final float field06914 = 0.45F;
   private static final float field06915 = 0.5F;
   private static final float field06916 = 0.07F;
   private static final float field06917 = 0.8F;
   private static final float field06918 = 2.5F;
   private static final float field06919 = 0.55F;
   private static final float field06920 = 1.1F;
   private static final float field06921 = 1.1F;
   private static final float field06922 = 0.55F;
   private static final float field06923 = 3.6F;
   private static final float field06924 = 4.0F;
   private static final float field06925 = 8.0F;
   private static final float field06926 = 0.5F;
   private static final float field06927 = 2.5F;
   private static final float field06928 = 8.0F;
   private static final float field06929 = 3.0F;
   private static final float field06930 = 0.5F;
   private static final float field06931 = 2.5F;
   private static final float field06932 = 2.5F;
   private static final float field06933 = 3.0F;
   private static final float field06934 = 8.0F;
   private static final float field06935 = 3.0F;
   private static final float field06936 = 0.5F;
   private static final float field06937 = 3.0F;
   private static final float field06938 = 0.25F;
   private static final float field06939 = 0.25F;
   private static final float field06940 = 0.5F;
   private static final float field06941 = 3.0F;

   public static int method03104(float var0) {
      return method03127(method03114().field22110.method11679(), var0);
   }

   public static void method03105(GuiGraphicsExtractor var0, float var1, float var2, float var3) {
      int var4 = method03104(field06917 * var3);
      float var5 = field06918;

      for (int var6 = -1; var6 <= 1; var6++) {
         for (int var7 = 0; var7 < 2; var7++) {
            RoundedRectRenderer.method01272(var0, var1 + var7 * var5, var2 + var6 * var5 - field06919, field06920, field06921, field06922, 1.0F, var4);
         }
      }
   }

   public static float method03106(FontRenderer var0, String var1, float var2, float var3) {
      return field06925 + var3 * field06926 + field06927 + var0.method09486(var1, var2);
   }

   public static void method03107(
      GuiGraphicsExtractor var0,
      FontRenderer var1,
      float var2,
      float var3,
      float var4,
      float var5,
      String var6,
      float var7,
      int var8,
      float var9,
      float var10
   ) {
      method03116(var0, var2, var3, var4, var5, field06933, var9, 0.0F, var10);
      String var11 = GuiThemeStyle.method01438(var1, var6, var7, var4 - field06934);
      var1.method09473(var0, var11, var2 + var4 / 2.0F, var3 + var5 / 2.0F - var1.method09485(var7) / 2.0F, var8, var7);
   }

   public static float method03108(float var0) {
      return var0 + field06923 + field06924;
   }

   public static void method03109(GuiGraphicsExtractor var0, float var1, float var2, float var3, GuiIcon var4, int var5, float var6, float var7) {
      method03116(var0, var1, var2, var3, var3, field06935, var6, 0.0F, var7);
      var4.method01190(var0, var1 + var3 / 2.0F, var2 + var3 / 2.0F, var3 * field06936, var5);
   }

   public static void method03110(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4) {
      RoundedRectRenderer.method01272(var0, var1, var2, var3, field06915, 0.0F, 0.0F, method03112(field06916 * var4));
   }

   public static void method03111(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, int var6, int var7) {
      RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, var5, 1.0F, var6);
      GuiShapeRenderer.method09703(var0, var1, var2, var3, var4, var5, field06904, var7);
   }

   private static int method03112(float var0) {
      return method03127(ColorUtils.field10169, var0);
   }

   public static void method03113(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5) {
      GuiIcon.CLOSE.method01190(var0, var1, var2, var3, method03120(var4, var5));
   }

   private static ThemeSettings method03114() {
      return ThemeManager.INSTANCE.method09611();
   }

   public static int method03115(float var0) {
      return method03127(method03114().method09800() | field06900, var0);
   }

   public static void method03116(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      int var9 = method03122(method03122(method03112(field06909 * var8), method03112(field06910 * var8), var6), method03115(field06911 * var8), var7);
      int var10 = method03122(method03122(method03112(field06912 * var8), method03112(field06913 * var8), var6), method03115(field06914 * var8), var7);
      method03111(var0, var1, var2, var3, var4, var5, var9, var10);
   }

   public static void method03117(
      GuiGraphicsExtractor var0, FontRenderer var1, float var2, float var3, float var4, float var5, String[] var6, float var7, float var8, float var9
   ) {
      method03116(var0, var2, var3, var4, var5, field06937, 0.0F, 0.0F, var9);
      float var10 = var4 / var6.length;
      float var11 = var5 * field06938;

      for (int var12 = 1; var12 < var6.length; var12++) {
         RoundedRectRenderer.method01272(var0, var2 + var10 * var12 - field06939, var3 + var11, field06940, var5 - var11 * 2.0F, 0.0F, 0.0F, method03119(var9));
      }

      method03116(var0, var2 + var10 * var7, var3, var10, var5, field06941, 0.0F, 1.0F, var9);
      float var15 = var3 + var5 / 2.0F - var1.method09485(var8) / 2.0F;

      for (int var13 = 0; var13 < var6.length; var13++) {
         float var14 = Math.max(0.0F, 1.0F - Math.abs(var7 - var13));
         var1.method09473(var0, var6[var13], var2 + var10 * var13 + var10 / 2.0F, var15, method03120(var14, var9), var8);
      }
   }

   public static int method03118(float var0) {
      return method03104(field06901 * var0);
   }

   private ConfigPanelRenderer() {
   }

   public static int method03119(float var0) {
      return method03112(field06902 * var0);
   }

   public static int method03120(float var0, float var1) {
      return method03122(method03104(var1), method03126(var1), var0);
   }

   public static void method03121(
      GuiGraphicsExtractor var0,
      FontRenderer var1,
      float var2,
      float var3,
      float var4,
      float var5,
      GuiIcon var6,
      int var7,
      String var8,
      float var9,
      float var10,
      float var11
   ) {
      method03116(var0, var2, var3, var4, var5, field06929, var10, 0.0F, var11);
      float var12 = var5 * field06930;
      float var13 = var12 + field06931 + var1.method09486(var8, var9);
      float var14 = var2 + var4 / 2.0F - var13 / 2.0F;
      var6.method01190(var0, var14 + var12 / 2.0F, var3 + var5 / 2.0F, var12, var7);
      var1.method09480(var0, var8, var14 + var12 + field06932, var3 + var5 / 2.0F - var1.method09485(var9) / 2.0F, method03120(var10, var11), var9);
   }

   public static int method03122(int var0, int var1, float var2) {
      return ColorUtils.method04631(var0, var1, var2);
   }

   public static float method03123(FontRenderer var0, String var1, float var2) {
      return field06928 + var0.method09486(var1, var2);
   }

   public static void method03124(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
      if (var7) {
         GuiBlurBarrierHooks.method03410(var0.guiRenderState);
         GuiClipStack.method00341(var0, var1, var2, var3, var4, var5, 1.0F, field06905, var6);
      }

      int var8 = method03128(var6);
      GuiShadowRenderer.method10984(var0, var1, var2, var3, var4, var5, 1.0F, field06906, method03127(var8, field06907));
      method03111(var0, var1, var2, var3, var4, var5, var8, method03112(field06908 * var6));
   }

   public static void method03125(
      GuiGraphicsExtractor var0, FontRenderer var1, float var2, float var3, float var4, float var5, String var6, float var7, float var8, float var9
   ) {
      method03107(var0, var1, var2, var3, var4, var5, var6, var7, method03120(var8, var9), var8, var9);
   }

   public static int method03126(float var0) {
      return method03127(method03114().field22109.method11679(), var0);
   }

   public static int method03127(int var0, float var1) {
      return ColorUtils.method04611(var0, var1);
   }

   public static int method03128(float var0) {
      ThemeSettings var1 = method03114();
      return ColorUtils.method04605(var1.field22119.method11676(), field06903 * var0 * var1.field22119.method11680());
   }
}
