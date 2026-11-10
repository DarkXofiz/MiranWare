// Original binary: sg/mx/2b0Xxh28vqn4OGpe
package sg.mx;

import java.util.ArrayList;
import net.minecraft.client.renderer.state.gui.GuiRenderState.Node;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.GuiNodeListFactory;

// $VF: Compiled from s
@Mixin(Node.class)
public class GuiRenderState$NodeMixin {
   @Redirect(method = "addGlyph", at = @At(value = "NEW", target = "java/util/ArrayList"), require = 0)
   private ArrayList hex$presizeGlyphs() {
      return GuiNodeListFactory.method03304();
   }

   @Redirect(method = "addGuiElement", at = @At(value = "NEW", target = "java/util/ArrayList"), require = 0)
   private ArrayList hex$presizeElements() {
      return GuiNodeListFactory.method03305();
   }

   @Redirect(method = "addText", at = @At(value = "NEW", target = "java/util/ArrayList"), require = 0)
   private ArrayList hex$presizeText() {
      return GuiNodeListFactory.method03306();
   }
}
