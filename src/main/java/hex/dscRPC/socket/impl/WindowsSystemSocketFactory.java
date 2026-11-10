// Original binary: hex/dscRPC/socket/impl/WindowsSystemSocketFactory
package hex.dscRPC.socket.impl;

import hex.dscRPC.socket.SystemSocket;
import hex.dscRPC.socket.SystemSocketFactory;

// $VF: Compiled from s
public class WindowsSystemSocketFactory implements SystemSocketFactory {
   @Override
   public SystemSocket createSystemSocket() {
      return new WindowsSystemSocket();
   }
}
