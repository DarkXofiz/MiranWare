// Original binary: sg/mx/uTPdilIcw3Np0hbt
package sg.mx;

import io.netty.channel.Channel;
import net.minecraft.network.Connection;
import net.minecraft.network.PacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(Connection.class)
public interface ConnectionMixin_1310 {
   @Accessor("channel")
   Channel getChannel();

   @Accessor("packetListener")
   void setPacketListener(PacketListener var1);

   @Accessor("disconnectListener")
   void setDisconnectListener(PacketListener var1);
}
