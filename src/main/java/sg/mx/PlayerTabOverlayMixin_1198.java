// Original binary: sg/mx/Op7sEdeThg5a4mH1
package sg.mx;

import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(PlayerTabOverlay.class)
public interface PlayerTabOverlayMixin_1198 {
   @Accessor("header")
   Component getTabHeader();

   @Accessor("footer")
   Component getTabFooter();
}
