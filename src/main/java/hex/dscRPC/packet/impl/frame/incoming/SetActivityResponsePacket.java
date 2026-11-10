// Original binary: hex/dscRPC/packet/impl/frame/incoming/SetActivityResponsePacket
package hex.dscRPC.packet.impl.frame.incoming;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import hex.dscRPC.packet.impl.frame.IncomingFramePacket;

// $VF: Compiled from s
public class SetActivityResponsePacket extends IncomingFramePacket<JsonNode> {
   @JsonProperty("data")
   private JsonNode data;

   public JsonNode data() {
      return this.data;
   }
}
