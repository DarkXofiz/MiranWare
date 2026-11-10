// Original binary: sg/mx/jshr34b93VpMbLyY
package sg.mx;

import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientboundMoveEntityPacket.class)
public interface ClientboundMoveEntityPacketMixin {
   @Accessor("entityId")
   int getEntityId();
}
