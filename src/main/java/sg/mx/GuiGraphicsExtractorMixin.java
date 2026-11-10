// Original binary: sg/mx/eE0AHFBDFpRk6yIR
package sg.mx;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import sg.ec.TooltipRenderEvent;

// $VF: Compiled from s
@Mixin(GuiGraphics.class)
public class GuiGraphicsExtractorMixin {
   @ModifyVariable(
      method = "setTooltipForNextFrame(Lnet/minecraft/client/gui/Font;Ljava/util/List;Ljava/util/Optional;IILnet/minecraft/resources/Identifier;)V",
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 0
   )
   private List<Component> onRenderTooltip(List<Component> var1) {
      var var2 = new ArrayList<>(var1);
      TooltipRenderEvent.field18101.method07399((GuiGraphics)(Object)this, var2);
      return var2;
   }
}
