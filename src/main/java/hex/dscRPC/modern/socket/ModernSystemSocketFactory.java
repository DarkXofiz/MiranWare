// Original binary: hex/dscRPC/modern/socket/ModernSystemSocketFactory
package hex.dscRPC.modern.socket;

import hex.dscRPC.socket.SystemSocket;
import hex.dscRPC.socket.SystemSocketFactory;

// $VF: Compiled from s
public class ModernSystemSocketFactory implements SystemSocketFactory {
   @Override
   public SystemSocket createSystemSocket() {
      return new ModernSystemSocket();
   }
}
