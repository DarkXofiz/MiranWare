// Original binary: sg/ec/l8AvNtpaogIxfLQo
package sg.ec;

import io.netty.channel.Channel;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket;
import net.minecraft.network.protocol.common.ServerboundResourcePackPacket.Action;

// $VF: Compiled from s
public final class BotPacketDispatcher {
   private static final long field21241 = 750L;
   private static final long field21242 = 0;
   private static final long field21243 = 750L;
   private static final long field21244 = 1900L;

   public static void method09318(Channel var0, Runnable var1, long var2) {
      if (var0 != null) {
         var0.eventLoop().schedule(var1, var2, TimeUnit.MILLISECONDS);
      }
   }

   private BotPacketDispatcher() {
   }

   public static void method09320(Channel var0, Connection var1, UUID var2) {
      var1.send(new ServerboundResourcePackPacket(var2, Action.ACCEPTED));
      method09321(var0, var1, new ServerboundResourcePackPacket(var2, Action.DOWNLOADED), field21243);
      method09321(var0, var1, new ServerboundResourcePackPacket(var2, Action.SUCCESSFULLY_LOADED), field21244);
   }

   public static void method09321(Channel var0, Connection var1, Packet<?> var2, long var3) {
      method09318(var0, () -> {
         if (var1.isConnected() && ((BotConnectionAccess)var1).isBotConnection()) {
            var1.send(var2);
         }
      }, var3);
   }
}
