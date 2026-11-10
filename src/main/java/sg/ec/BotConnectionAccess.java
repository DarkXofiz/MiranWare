// Original binary: sg/ec/R7IB5WPW1lsqV9oz
package sg.ec;

import java.util.concurrent.atomic.AtomicReference;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;

// $VF: Compiled from s
public interface BotConnectionAccess {
   AtomicReference<Connection> field11389 = new AtomicReference<>();

   void setProxy(ProxyConfig var1);

   static Connection method05259() {
      return field11389.get();
   }

   void setBotConnection(boolean var1);

   static void method05260(Connection var0) {
      field11389.set(var0);
   }

   boolean isBotConnection();

   ProxyConfig getProxy();

   void sendPacket(Packet<?> var1);
}
