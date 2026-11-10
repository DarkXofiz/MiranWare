// Original binary: sg/ec/ibcdjybJtuYl7GVO
package sg.ec;

import java.util.Locale;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class GuiInputRenderer {
   public static final float field20060 = 14.5F;
   public static final float field20061 = 0;
   public static final float field20062 = 0;
   public static final float field20063 = 0;
   public static final float field20064 = 0;
   public static final float field20065 = 0;
   public static final float field20066 = 0;
   public static final float field20067 = 0;
   public static final float field20068 = 0;
   public static final float field20069 = 0;
   private static final float field20070 = 0;
   private static final float field20071 = 0;
   private static final float field20072 = 0;
   private static final float field20073 = 5.0F;
   private static final float field20074 = 6.5F;
   private static final float field20075 = 6.5F;
   private static final float field20076 = 1.25F;
   private static final float field20077 = 3.75F;
   private static final float field20078 = 0.2F;
   private static final float field20079 = 0.5F;
   private static final float field20080 = 0.2F;
   private static final float field20081 = 7.25F;
   private static final float field20082 = 6.5F;
   private static final float field20083 = 0.5F;
   private static final float field20084 = 5.0F;
   private static final float field20085 = 6.5F;
   private static final float field20086 = 6.5F;
   private static final float field20087 = 5.0F;
   private static final float field20088 = 6.5F;
   private static final float field20089 = 5.0F;
   private static final float field20090 = 6.5F;
   private static final float field20091 = 6.0F;
   private static final float field20092 = 5.0F;
   private static final float field20093 = 7.25F;
   private static final float field20094 = 6.25F;
   private static final float field20095 = 12.5F;
   private static final float field20096 = 12.5F;
   private static final float field20097 = 6.5F;
   private static final float field20098 = 12.0F;
   private static final float field20099 = 7.25F;
   private static final float field20100 = 5.25F;
   private static final float field20101 = 10.5F;
   private static final float field20102 = 5.0F;
   private static final float field20103 = 10.0F;
   private static final float field20104 = 15.0F;
   private static final float field20105 = 15.333333F;
   private static final float field20106 = 9.333333F;
   private static final float field20107 = 5.0F;
   private static final float field20108 = 15.333333F;
   private static final float field20109 = 7.25F;
   private static final float field20110 = 4.6666665F;

   public static float method08814(float var0) {
      return var0 + field20099 - field20100;
   }

   private GuiInputRenderer() {
   }

   public static float method08815(float var0) {
      return var0 + field20081 - GuiThemeStyle.field03544.method09485(field20082) / 2.0F - field20083;
   }

   public static void method08816(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      ThemeSettings var7 = GuiThemeStyle.method01441();
      int var8 = GuiThemeStyle.method01440(
         GuiThemeStyle.method01443(var7.field22120.method11679(), var6), GuiThemeStyle.method01443(var7.field22119.method11679(), var6), var5
      );
      RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, 2.0F, 1.0F, var8);
   }

   public static void method08817(
      GuiGraphicsExtractor var0, String var1, GuiThemeStyle.Nested40 var2, float var3, float var4, float var5, float var6, float var7
   ) {
      GuiThemeStyle.method01444(var0, var3, var4, var5, field20101, var1, var6, var2, var7);
   }

   public static float method08818(String var0, float var1) {
      return var1 + field20089 + GuiThemeStyle.field03544.method09486(var0, field20090) + field20091;
   }

   public static float method08819(String var0) {
      return GuiThemeStyle.field03544.method09486(var0, field20097) + field20098;
   }

   public static float method08820(GuiGraphicsExtractor var0, String var1, float var2, float var3, float var4) {
      ThemeSettings var5 = GuiThemeStyle.method01441();
      String var6 = FontFallbackManager.method07179(var1.toUpperCase(Locale.ROOT), var5.method09800(), var5.method09809());
      GuiThemeStyle.field03543.method09480(var0, var6, var2 + field20073, var3, ColorUtils.method04611(-1, var4), field20074);
      return var3 + GuiThemeStyle.field03543.method09485(field20075) + field20076;
   }

   public static void method08821(
      GuiGraphicsExtractor var0, TextInputWidget var1, String var2, float var3, float var4, float var5, float var6, float var7, float var8
   ) {
      float var9 = method08818(var2, var3);
      float var10 = var3 + var4 - field20092 - var9;
      float var11 = var5 + field20093 - field20094;
      method08816(var0, var9, var11, var10, field20095, var7, var8);
      var1.method06700(var9, var11, var10, field20096).method06670(var0, var6, var8);
   }

   public static void method08822(GuiGraphicsExtractor var0, String var1, boolean var2, float var3, float var4, float var5, float var6, float var7) {
      GuiThemeStyle.method01444(
         var0,
         var3 + field20102,
         var5,
         var4 - field20103,
         field20104,
         var1,
         var6,
         var2 ? GuiThemeStyle.Nested40.NORMAL : GuiThemeStyle.Nested40.DISABLED,
         var7
      );
   }

   public static void method08823(GuiGraphicsExtractor var0, String var1, float var2, float var3, float var4) {
      GuiThemeStyle.field03544.method09480(var0, var1, var2 + field20084, method08815(var3), GuiThemeStyle.method01437(var4), field20085);
   }

   public static void method08824(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5) {
      RoundedRectRenderer.method01272(
         var0, var1, var2, var3, var4, field20077, 1.0F, GuiThemeStyle.method01443(GuiThemeStyle.method01439(), field20078 * var5)
      );
   }

   public static void method08825(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4) {
      RoundedRectRenderer.method01272(
         var0,
         var1 + 1.0F,
         var3 - field20079,
         var2 - 2.0F,
         1.0F,
         0.0F,
         0.0F,
         GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22117.method11676(), field20080 * var4)
      );
   }

   public static void method08826(GuiGraphicsExtractor var0, String var1, float var2, float var3, float var4, int var5) {
      float var6 = GuiThemeStyle.field03544.method09486(var1, field20086);
      GuiThemeStyle.field03544.method09480(var0, var1, var2 + var3 - field20087 - var6, method08815(var4), var5, field20088);
   }

   public static void method08827(GuiBounds var0, float var1, float var2, float var3) {
      var0.method02803(field20105);
      var0.method02798(field20106);
      var0.method02801(var1 + var2 - field20107 - field20108);
      var0.method02806(var3 + field20109 - field20110);
   }
}
