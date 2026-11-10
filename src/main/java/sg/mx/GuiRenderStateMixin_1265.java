// Original binary: sg/mx/hjpakMTctD5kvQx5
package sg.mx;

import java.util.Comparator;
import java.util.List;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState.Node;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.GuiRenderStateAccess;
import sg.ec.GuiRenderStateHooks;

// $VF: Compiled from s
@Mixin(GuiRenderState.class)
public abstract class GuiRenderStateMixin_1265 implements GuiRenderStateAccess {
   @Shadow
   private Node current;

   @Override
   public Object getCurrentLayer() {
      return this.current;
   }

   @Redirect(method = "lambda$sortElements$0", at = @At(value = "INVOKE", target = "Ljava/util/List;sort(Ljava/util/Comparator;)V"))
   private static void hex$fastSort(List<GuiElementRenderState> var0, Comparator<GuiElementRenderState> var1) {
      GuiRenderStateHooks.method09343(var0);
   }
}
