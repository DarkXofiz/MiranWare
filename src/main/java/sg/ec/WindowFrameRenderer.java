// Original binary: sg/ec/D1DEN5pZceuF4YQH
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class WindowFrameRenderer {
   private static final float field06849 = 0.575F;
   private static final float field06850 = 0;
   private static final float field06851 = 0;
   private static final float field06852 = 0;
   private static final float field06853 = 7.0F;
   private static final float field06854 = 0.575F;
   private static final float field06855 = 15.0F;
   private static final float field06856 = 0.6F;

   private WindowFrameRenderer() {
   }

   public static void method03055(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      method03058(var0, var1, var2, var3, var4, var5, var6, true);
   }

   public static void method03056(GuiGraphicsExtractor var0, FloatingWindow var1, float var2) {
      method03057(var0, var1, var2, var1.method09573().method06173());
   }

   public static void method03057(GuiGraphicsExtractor var0, FloatingWindow var1, float var2, float var3) {
      method03058(var0, var1.method09576(), var1.method09560(), var1.method09568(), var1.method09574(), var2, var3, var1.method09579());
   }

   private static void method03058(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
      if (var7) {
         GuiBlurBarrierHooks.method03410(var0.guiRenderState);
         GuiClipStack.method00341(var0, var1, var2, var3, var4, var5, 1.0F, field06853, var6);
      }

      int var8 = ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22121.method11676(), field06854 * var6);
      GuiShadowRenderer.method10984(var0, var1, var2, var3, var4, var5, 1.0F, field06855, ColorUtils.method04611(var8, field06856));
      RoundedRectRenderer.method01272(var0, var1, var2, var3, var4, var5, 1.0F, var8);
   }
}
