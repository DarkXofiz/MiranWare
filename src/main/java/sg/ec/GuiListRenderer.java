// Original binary: sg/ec/wBzfN5TGtBF5DtK9
package sg.ec;

import java.util.function.DoubleFunction;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class GuiListRenderer {
   public static final float field25116 = 25.0F;
   public static final float field25117 = 0;
   private static final float field25118 = 0;
   private static final float field25119 = 0;
   private static final float field25120 = 0;
   private static final float field25121 = 0;
   private static final float field25122 = 0;
   private static final float field25123 = 5.0F;
   private static final float field25124 = 10.0F;
   private static final float field25125 = 25.0F;
   private static final float field25126 = 6.0F;
   private static final float field25127 = 3.75F;
   private static final float field25128 = 6.5F;
   private static final float field25129 = 6.5F;
   private static final float field25130 = 6.5F;
   private static final float field25131 = 4.0F;
   private static final float field25132 = 5.0F;
   private static final float field25133 = 7.25F;
   private static final float field25134 = 6.5F;
   private static final float field25135 = 25.0F;
   private static final float field25136 = 6.0F;
   private static final float field25137 = 3.0F;
   private static final float field25138 = 3.0F;
   private static final float field25139 = 3.0F;
   private static final float field25140 = 1.5F;
   private static final float field25141 = 3.0F;
   private static final float field25142 = 1.5F;
   private static final float field25143 = 3.75F;
   private static final float field25144 = 1.5F;
   private static final float field25145 = 3.75F;
   private static final float field25146 = 7.5F;
   private static final float field25147 = 7.5F;
   private static final float field25148 = 2.7F;

   public static double method11179(
      GuiGraphics var0,
      String var1,
      double var2,
      double var4,
      double var6,
      double var8,
      boolean var10,
      float var11,
      DoubleFunction<String> var12,
      float var13,
      float var14,
      float var15,
      float var16
   ) {
      float var17 = method11181(var13);
      float sx = method11180(var14);
      if (var10) {
         double sxx = var2 + (var4 - var2) * Mth.clamp((var11 - var17) / sx, 0.0F, 1.0F);
         var8 = Mth.clamp(Math.round(sxx / var6) * var6, var2, var4);
      }

      ThemeSettings sxx = GuiThemeStyle.method01441();
      String sxxx = var12.apply(var8);
      float sxxxx = KeyLabelRenderer.method02576(GuiThemeStyle.field03544, sxxx, field25128);
      float sxxxxx = KeyLabelRenderer.method02577(GuiThemeStyle.field03544, field25129);
      GuiInputRenderer.method08823(
         var0, GuiThemeStyle.method01438(GuiThemeStyle.field03544, var1, field25130, sx - sxxxx - field25131), var13, var15, var16
      );
      KeyLabelRenderer.method02578(
         var0, GuiThemeStyle.field03544, var13 + var14 - field25132 - sxxxx, var15 + field25133 - sxxxxx / 2.0F, sxxx, field25134, 0.0F, var16
      );
      float sxxxxxx = var15 + field25135 - field25136;
      float sxxxxxxx = Mth.clamp((float)((var8 - var2) / (var4 - var2)) * sx, field25137, sx - field25138);
      RoundedRectRenderer.method01272(
         var0, var17, sxxxxxx, sx, field25139, field25140, 1.0F, GuiThemeStyle.method01443(sxx.field22123.method11676(), var16)
      );
      RoundedRectRenderer.method01272(
         var0, var17, sxxxxxx, sxxxxxxx, field25141, field25142, 1.0F, GuiThemeStyle.method01443(sxx.field22111.method11676(), var16)
      );
      RoundedRectRenderer.method01272(
         var0,
         var17 + sxxxxxxx - field25143,
         sxxxxxx + field25144 - field25145,
         field25146,
         field25147,
         field25148,
         1.0F,
         GuiThemeStyle.method01443(sxx.field22112.method11676(), var16)
      );
      return var8;
   }

   public static float method11180(float var0) {
      return var0 - field25124;
   }

   public static float method11181(float var0) {
      return var0 + field25123;
   }

   public static float method11182(float var0) {
      return var0 + field25125 - field25126 - field25127;
   }

   private GuiListRenderer() {
   }
}
