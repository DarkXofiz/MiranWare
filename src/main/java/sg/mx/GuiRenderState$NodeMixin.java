// Original binary: sg/mx/2b0Xxh28vqn4OGpe
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import java.util.ArrayList;
import net.minecraft.client.renderer.state.gui.GuiRenderState.Node;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.GuiNodeListFactory;

// $VF: Compiled from s
@Mixin(Node.class)
public class GuiRenderState$NodeMixin {
   @WrapOperation(method = "addGlyph", at = @At(value = "NEW", target = "java/util/ArrayList"), require = 0)
   private ArrayList hex$presizeGlyphs(Operation<ArrayList> hex$original) {
      return GuiNodeListFactory.method03304();
   }

   @WrapOperation(method = "addGuiElement", at = @At(value = "NEW", target = "java/util/ArrayList"), require = 0)
   private ArrayList hex$presizeElements(Operation<ArrayList> hex$original) {
      return GuiNodeListFactory.method03305();
   }

   @WrapOperation(method = "addText", at = @At(value = "NEW", target = "java/util/ArrayList"), require = 0)
   private ArrayList hex$presizeText(Operation<ArrayList> hex$original) {
      return GuiNodeListFactory.method03306();
   }
}
