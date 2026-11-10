// Original binary: sg/mx/174bYsA5Ff7Gb6DD
package sg.mx;

import net.minecraft.network.protocol.game.ClientboundRotateHeadPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ClientboundRotateHeadPacket.class)
public interface ClientboundRotateHeadPacketMixin {
   @Accessor("entityId")
   int getEntityId();
}
