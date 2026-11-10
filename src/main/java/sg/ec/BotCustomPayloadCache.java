// Original binary: sg/ec/opntcKMpIQz83kU3
package sg.ec;

import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.BrandPayload;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class BotCustomPayloadCache {
   private static final int field22261 = 16;
   private static final long field22262 = 0;
   private static final long field22263 = 0;
   private static final Map<ConnectionProtocol, Map<Identifier, ServerboundCustomPayloadPacket>> field22264 = new EnumMap<>(ConnectionProtocol.class);
   private static Connection field22265;
   private static final long field22266 = 500L;

   public static void method09896(Channel var0, Connection var1, ConnectionProtocol var2) {
      List var3;
      synchronized (field22264) {
         var sx = field22264.get(var2);
         if (sx == null || sx.isEmpty()) {
            return;
         }

         var3 = new ArrayList<>(sx.values());
      }

      long var9 = var2 == ConnectionProtocol.CONFIGURATION ? 0L : field22266;

      for (ServerboundCustomPayloadPacket sx : (Iterable<ServerboundCustomPayloadPacket>) (Iterable) var3) {
         BotPacketDispatcher.method09318(var0, () -> {
            if (var1.isConnected() && method09897(var1) == var2 && ((BotConnectionAccess)var1).isBotConnection()) {
               var1.send(sx);
            }
         }, var9);
      }
   }

   private static ConnectionProtocol method09897(Connection var0) {
      PacketListener var1 = var0 == null ? null : var0.getPacketListener();
      if (var1 == null) {
         return null;
      }

      ConnectionProtocol var2 = var1.protocol();
      return var2 != ConnectionProtocol.CONFIGURATION && var2 != ConnectionProtocol.PLAY ? null : var2;
   }

   public static void method09898(Connection var0, ServerboundCustomPayloadPacket var1) {
      ConnectionProtocol var2 = method09897(var0);
      if (var2 != null && !(var1.payload() instanceof BrandPayload)) {
         Identifier var3 = var1.payload().type().id();
         synchronized (field22264) {
            if (field22265 != var0) {
               field22264.clear();
               field22265 = var0;
            }

            var var5 = field22264.computeIfAbsent(var2, var0x -> new LinkedHashMap<>());
            if (var5.size() < 16 || var5.containsKey(var3)) {
               var5.put(var3, var1);
            }
         }
      }
   }

   private BotCustomPayloadCache() {
   }
}
