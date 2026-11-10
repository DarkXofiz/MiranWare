// Original binary: sg/ec/NlAZUd5gcAuWzGRM
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.state.WindowRenderState;

// $VF: Compiled from s
public final class GuiScreenRenderHooks {
   private static final float field10309 = 255.0F;

   private GuiScreenRenderHooks() {
   }

   public static int method04725(float var0, int var1) {
      if (var0 >= 1.0F) {
         return var1;
      }

      int var2 = (int)(var0 * field10309) & 0xFF;
      return var2 << 24 | var2 << 16 | var2 << 8 | var2;
   }

   public static boolean method04726(ScreenRectangle var0) {
      WindowRenderState var1 = Minecraft.getInstance().gameRenderer.gameRenderState().windowRenderState;
      int var2 = var1.guiScale;
      int var3 = var0.left() * var2;
      int var4 = var0.top() * var2;
      int var5 = Math.min(var0.right() * var2, var1.width);
      int var6 = Math.min(var0.bottom() * var2, var1.height);
      return var5 <= var3 || var6 <= var4;
   }

   public static void method04727() {
      if (Minecraft.getInstance().gui.screen() instanceof MainMenuScreen) {
         MainMenuBlitRenderer.method00878(MainMenuScreen.backgroundTexture());
      }

      GuiBlurRenderer.method11251(ClientScreenManager.INSTANCE.method08318());
   }
}
