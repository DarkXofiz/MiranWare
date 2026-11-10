// Original binary: sg/ec/AaO7VrwqMb0fTTg3
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;

// $VF: Compiled from s
public final class KeyLabelRenderer {
   private static final float field06130 = 3.0F;
   private static final float field06131 = 0;
   private static final float field06132 = 0;
   private static final float field06133 = 6.0F;
   private static final float field06134 = 3.0F;
   private static final float field06135 = 3.0F;
   private static final float field06136 = 1.5F;

   private KeyLabelRenderer() {
   }

   public static float method02576(FontRenderer var0, String var1, float var2) {
      return var0.method09486(var1, var2) + field06133;
   }

   public static float method02577(FontRenderer var0, float var1) {
      return var0.method09485(var1) + field06134;
   }

   public static void method02578(GuiGraphics var0, FontRenderer var1, float var2, float var3, String var4, float var5, float var6, float var7) {
      ThemeSettings var8 = ThemeManager.INSTANCE.method09611();
      int var9 = ColorUtils.method04631(
         ColorUtils.method04611(var8.field22120.method11679(), var7), ColorUtils.method04611(var8.field22113.method11679(), var7), var6
      );
      RoundedRectRenderer.method01272(var0, var2, var3, method02576(var1, var4, var5), method02577(var1, var5), 2.0F, 1.0F, var9);
      var1.method09480(var0, var4, var2 + field06135, var3 + field06136, ColorUtils.method04611(var8.field22109.method11679(), var7), var5);
   }
}
