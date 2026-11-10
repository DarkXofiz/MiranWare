// Original binary: sg/mx/gy1sFMJfZBIrNkgE
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(GuiGraphics.class)
public interface GuiGraphicsExtractorMixin_1263 {
   @Accessor("minecraft")
   Minecraft client();
}
