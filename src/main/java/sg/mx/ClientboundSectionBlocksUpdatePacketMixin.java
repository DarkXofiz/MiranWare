// Original binary: sg/mx/ASBmQYytd6BFNboO
package sg.mx;

import net.minecraft.core.SectionPos;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientboundSectionBlocksUpdatePacket.class)
public interface ClientboundSectionBlocksUpdatePacketMixin {
   @Accessor("sectionPos")
   SectionPos getSectionPos();
}
