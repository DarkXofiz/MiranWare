// Original binary: sg/ec/qRSfYBiP0XGvEtq9
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public interface GlobalPacket<V extends GlobalPacketHandler, T extends GlobalPacket<V, T>> {
   default int method00558() {
      return 2048;
   }

   void method00212(WebSocket var1, V var2);

   void method00209(VertexBufferData var1);

   T method00210(VertexBufferData var1);

   String method00213();
}
