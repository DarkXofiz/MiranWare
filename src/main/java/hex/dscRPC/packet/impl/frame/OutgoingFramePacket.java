// Original binary: hex/dscRPC/packet/impl/frame/OutgoingFramePacket
package hex.dscRPC.packet.impl.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import hex.dscRPC.packet.impl.FramePacket;

// $VF: Compiled from s
public class OutgoingFramePacket<A> extends FramePacket {
   @JsonProperty("args")
   private final A arguments;

   public OutgoingFramePacket(String var1, A var2) {
      this.command = var1;
      this.arguments = var2;
   }

   public A arguments() {
      return this.arguments;
   }
}
