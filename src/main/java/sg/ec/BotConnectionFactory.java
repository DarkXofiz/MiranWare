// Original binary: sg/ec/zQ3tTjRJ6KP7ezXE
package sg.ec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.util.concurrent.Future;
import java.net.InetSocketAddress;
import java.util.Optional;
import net.minecraft.client.multiplayer.resolver.ResolvedServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerAddress;
import net.minecraft.client.multiplayer.resolver.ServerNameResolver;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.login.LoginProtocols;
import net.minecraft.network.protocol.login.ServerboundHelloPacket;
import net.minecraft.server.network.EventLoopGroupHolder;

// $VF: Compiled from s
public final class BotConnectionFactory implements MinecraftAccess {
   private static final long field27861 = 12000L;
   private static final String field27862 = "Не удалось определить адрес сервера";
   private static final long field27863 = 12000L;
   private static final String field27864 = "Прокси не открыл туннель за 12 с";
   private static final String field27865 = "причина неизвестна";

   private static ProxyConfig method11715(BotClient var0) {
      return var0 == BotSessionManager.INSTANCE.method08761()
         ? ProxyManager.INSTANCE.method05228()
         : ProxyManager.INSTANCE.method05225(var0.method00137().method00490());
   }

   private BotConnectionFactory() {
   }

   private static void method11717(Channel var0) {
      Future var1 = (Future)var0.attr(SocksProxyConnector.field12055).get();
      if (var1 != null) {
         if (!var1.awaitUninterruptibly(field27863)) {
            var0.close();
            throw new IllegalStateException(field27864);
         }

         if (!var1.isSuccess()) {
            var0.close();
            Throwable var2 = var1.cause();
            throw new IllegalStateException("Прокси отказал: " + (var2 == null ? field27865 : var2.getMessage()));
         }
      }
   }

   public static Channel method11718(BotClient var0) throws Exception {
      ServerAddress var1 = ServerAddress.parseString(var0.method00137().method00486());
      var var2 = ServerNameResolver.DEFAULT.resolveAddress(var1).map(ResolvedServerAddress::asInetSocketAddress);
      if (var2.isEmpty()) {
         throw new IllegalStateException(field27862);
      }

      InetSocketAddress var3 = (InetSocketAddress)var2.get();
      Connection var4 = new Connection(PacketFlow.CLIENTBOUND);
      ((BotConnectionAccess)var4).setBotConnection(true);
      ProxyConfig var5 = method11715(var0);
      SocksProxyConnector.method05687(var5);
      ((BotConnectionAccess)var4).setProxy(var5);
      ViaFabricPlusProtocolAccess.method11198(var4, var1, var3, var0.method00137().method00492());
      ChannelFuture var6 = Connection.connect(var3, EventLoopGroupHolder.remote(mc.options.useNativeTransport()), var4);
      var6.syncUninterruptibly();
      Channel var7 = var6.channel();
      method11717(var7);
      var0.method00155(var4, var7);
      boolean var8 = var0.method00129();
      var7.eventLoop()
         .execute(
            () -> {
               var4.initiateServerboundPlayConnection(
                  var3.getHostName(), var3.getPort(), LoginProtocols.SERVERBOUND, LoginProtocols.CLIENTBOUND, new BotLoginPacketListener(var0, var4), var8
               );
               var4.send(new ServerboundHelloPacket(var0.method00137().method00491(), var0.method00137().method00494()));
            }
         );
      return var7;
   }
}
