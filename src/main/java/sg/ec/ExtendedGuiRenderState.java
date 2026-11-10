// Original binary: sg/ec/5pyw7gpkN49kPHux
package sg.ec;

import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;

// $VF: Compiled from s
public interface ExtendedGuiRenderState extends GuiElementRenderState {
   @Override
   default TextureSetup textureSetup() {
      return TextureSetup.noTexture();
   }
}
