// Original binary: sg/ec/wb4HTTe0Odhf6zyc
package sg.ec;

import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState.Node;

// $VF: Compiled from s
public final class GuiNodeClipHooks {
   private GuiNodeClipHooks() {
   }

   public static void method11203(Node var0, GuiElementRenderState var1) {
      ScreenRectangle var2 = var1.scissorArea();
      if (var2 == null || var2.width() > 0 && var2.height() > 0) {
         var0.addGuiElement(var1);
      }
   }
}
