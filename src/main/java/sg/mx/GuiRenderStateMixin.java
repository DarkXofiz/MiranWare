// Original binary: sg/mx/ejw0IfoNSmezY4Am
package sg.mx;

import java.util.List;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.renderer.state.gui.GuiRenderState;
import net.minecraft.client.renderer.state.gui.ScreenArea;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.FastArrayList;

// $VF: Compiled from s
@Mixin(GuiRenderState.class)
public class GuiRenderStateMixin {
   @Redirect(
      method = "navigateToAboveHighestElementWithIntersectingBounds",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/renderer/state/gui/GuiRenderState;hasIntersection(Lnet/minecraft/client/gui/navigation/ScreenRectangle;Ljava/util/List;)Z"
      )
   )
   private boolean hex$indexedIntersection(GuiRenderState var1, ScreenRectangle var2, List<? extends ScreenArea> var3) {
      return FastArrayList.method10122(var2, var3);
   }
}
