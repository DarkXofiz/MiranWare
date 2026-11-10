// Original binary: hex/dscRPC/packet/impl/FramePacket
package hex.dscRPC.packet.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import hex.dscRPC.packet.Packet;
import hex.dscRPC.packet.PacketOpcode;

// $VF: Compiled from s
public abstract class FramePacket implements Packet {
   @JsonProperty("cmd")
   protected String command;
   @JsonProperty("nonce")
   protected String uniqueId;

   public String command() {
      return this.command;
   }

   public String uniqueId() {
      return this.uniqueId;
   }

   public void setUniqueId(String var1) {
      this.uniqueId = var1;
   }

   @Override
   public PacketOpcode opcode() {
      return PacketOpcode.FRAME;
   }
}
