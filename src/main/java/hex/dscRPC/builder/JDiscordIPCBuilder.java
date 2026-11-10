// Original binary: hex/dscRPC/builder/JDiscordIPCBuilder
package hex.dscRPC.builder;

import hex.dscRPC.JDiscordIPC;
import hex.dscRPC.ReconnectPolicy;
import hex.dscRPC.exception.JDiscordIPCBuilderException;
import hex.dscRPC.internal.util.SystemUtil;
import hex.dscRPC.socket.SystemSocketFactory;
import hex.dscRPC.socket.impl.WindowsSystemSocketFactory;

// $VF: Compiled from s
public class JDiscordIPCBuilder {
   private final long clientId;
   private ReconnectPolicy reconnectPolicy;
   private SystemSocketFactory systemSocketFactory;

   public JDiscordIPCBuilder systemSocketFactory(SystemSocketFactory var1) {
      this.systemSocketFactory = var1;
      return this;
   }

   public JDiscordIPC build() {
      SystemSocketFactory var1;
      if (SystemUtil.isWindows()) {
         var1 = new WindowsSystemSocketFactory();
      } else {
         var1 = this.systemSocketFactory;
      }

      if (var1 == null) {
         throw new JDiscordIPCBuilderException.MissingSystemSocketFactoryException();
      } else {
         return new JDiscordIPC(this.clientId, this.reconnectPolicy, var1.createSystemSocket());
      }
   }

   public JDiscordIPCBuilder reconnectPolicy(ReconnectPolicy var1) {
      this.reconnectPolicy = var1;
      return this;
   }

   public JDiscordIPCBuilder(long var1) {
      this.clientId = var1;
      this.reconnectPolicy = ReconnectPolicy.NEVER;
      this.systemSocketFactory = null;
   }
}
