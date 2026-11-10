// Original binary: sg/ec/TpKS3KdpqB3WoSen
package sg.ec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelPipeline;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// $VF: Compiled from s
public final class SocksProxyConnector {
   public static final String field12054 = "hex_socks_tunnel";
   public static final AttributeKey<Future<Void>> field12055 = AttributeKey.valueOf(SocksProxyConnector.field12059);
   private static final Map<String, InetSocketAddress> field12056 = new ConcurrentHashMap<>();
   private static final String field12057 = "hex_socks_tunnel";
   private static final String field12058 = "hex_socks_tunnel";
   private static final String field12059 = "hex_socks_handshake";

   public static void method05687(ProxyConfig var0) {
      if (var0 != null && var0.method03907()) {
         method05688(var0);
      }
   }

   private static InetSocketAddress method05688(ProxyConfig var0) {
      InetSocketAddress var1 = field12056.get(var0.method03902());
      if (var1 != null) {
         return var1;
      }

      InetSocketAddress var2 = new InetSocketAddress(var0.method03904(), var0.method03912());
      if (var2.isUnresolved()) {
         return null;
      }

      field12056.put(var0.method03902(), var2);
      return var2;
   }

   private SocksProxyConnector() {
   }

   public static void method05689(Channel var0, ProxyConfig var1) {
      if (var0 != null && var1 != null && var1.method03907()) {
         ChannelPipeline var2 = var0.pipeline();
         if (var2.get(field12057) == null) {
            InetSocketAddress var3 = method05688(var1);
            if (var3 == null) {
               Promise var5 = var0.eventLoop().newPromise();
               var5.tryFailure(new IOException("Не удалось определить адрес прокси " + var1.method03902()));
               var0.attr(field12055).set(var5);
               var0.close();
            } else {
               Promise var4 = var0.eventLoop().newPromise();
               var0.attr(field12055).set(var4);
               var2.addFirst(field12058, new SocksHandshakeHandler(var1, var3, var4));
            }
         }
      }
   }
}
