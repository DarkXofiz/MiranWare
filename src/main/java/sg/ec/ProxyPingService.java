// Original binary: sg/ec/OV4alH2lVA6LpfLG
package sg.ec;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.network.Connection;
import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.DisconnectionDetails;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.ping.ClientboundPongResponsePacket;
import net.minecraft.network.protocol.ping.ServerboundPingRequestPacket;
import net.minecraft.network.protocol.status.ClientStatusPacketListener;
import net.minecraft.network.protocol.status.ClientboundStatusResponsePacket;
import net.minecraft.server.network.EventLoopGroupHolder;

// $VF: Compiled from s
public final class ProxyPingService {
   private static final int field10639 = 15;
   private static final ExecutorService field10640 = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, ProxyPingService.field10645);
      var1.setDaemon(true);
      return var1;
   });
   private volatile String field10641 = "";
   private volatile boolean field10642;
   private volatile Connection field10643;
   private volatile long field10644;
   private static final String field10645 = "Hex Proxy Ping";

   public String method04800() {
      return this.field10641;
   }

   private void method04801(String var1) {
      this.field10641 = var1;
      this.field10642 = false;
   }

   private void method04802(String var1, int var2, ProxyConfig var3) {
      final Connection var4;
      try {
         var4 = this.method04807(InetAddress.getByName(var1), var2, var3);
      } catch (Throwable var8) {
         this.method04801("Не удалось подключиться к " + var1);
         return;
      }

      this.field10643 = var4;
      ClientStatusPacketListener var5 = new ClientStatusPacketListener()      // $VF: Compiled from s
 {
         private boolean field10646;
         private static final String field10649 = "Готово";

         @Override
         public void handlePongResponse(ClientboundPongResponsePacket var1) {
            this.field10646 = true;
            ProxyPingService.this.field10643 = null;
            ProxyPingService.this.field10641 = "Пинг: " + (System.currentTimeMillis() - ProxyPingService.this.field10644) + " мс";
            ProxyPingService.this.field10642 = false;
            var4.disconnect(Component.literal(field10649));
         }

         @Override
         public ConnectionProtocol protocol() {
            return ConnectionProtocol.STATUS;
         }

         @Override
         public void handleStatusResponse(ClientboundStatusResponsePacket var1) {
            ProxyPingService.this.field10644 = System.currentTimeMillis();
            var4.send(new ServerboundPingRequestPacket(ProxyPingService.this.field10644));
         }

         @Override
         public boolean isAcceptingMessages() {
            return var4.isConnected();
         }

         @Override
         public void onDisconnect(DisconnectionDetails var1) {
            ProxyPingService.this.field10643 = null;
            if (!this.field10646) {
               ProxyPingService.this.field10641 = "Ошибка: " + var1.reason().getString();
            }

            ProxyPingService.this.field10642 = false;
         }
      };

      try {
         var4.initiateServerboundStatusConnection(var1, var2, var5);
      } catch (Throwable var7) {
         this.field10643 = null;
         this.method04801("Не удалось опросить " + var1);
      }
   }

   public void method04803() {
      Connection var1 = this.field10643;
      if (var1 != null) {
         if (var1.isConnected()) {
            var1.tick();
         } else {
            var1.handleDisconnection();
         }
      }
   }

   public boolean method04804() {
      return this.field10642;
   }

   public void method04805(String var1, int var2, ProxyConfig var3) {
      if (!this.field10642) {
         this.field10642 = true;
         this.field10641 = "Проверка " + var1 + ":" + var2 + "...";
         field10640.submit(() -> this.method04802(var1, var2, var3));
      }
   }

   private Connection method04807(InetAddress var1, int var2, final ProxyConfig var3) {
      final Connection var4 = new Connection(PacketFlow.CLIENTBOUND);
      ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(EventLoopGroupHolder.remote(false).eventLoopGroup()))
               .handler(new ChannelInitializer<Channel>()      // $VF: Compiled from s
          {
                  private static final String field10652 = "timeout";

                  protected void initChannel(Channel var1) {
                     try {
                        var1.config().setOption(ChannelOption.TCP_NODELAY, true);
                     } catch (ChannelException var3x) {
                     }

                     ChannelPipeline var2 = var1.pipeline();
                     var2.addLast(field10652, new ReadTimeoutHandler(15));
                     Connection.configureSerialization(var2, PacketFlow.CLIENTBOUND, false, null);
                     var4.configurePacketHandler(var2);
                     SocksProxyConnector.method05689(var1, var3);
                  }
               }))
            .channel(NioSocketChannel.class))
         .connect(var1, var2)
         .syncUninterruptibly();
      return var4;
   }

   public void method04808() {
      this.field10641 = "";
   }
}
