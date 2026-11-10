// Original binary: hex/dscRPC/packet/impl/ClosePacket
package hex.dscRPC.packet.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import hex.dscRPC.packet.Packet;
import hex.dscRPC.packet.PacketOpcode;

// $VF: Compiled from s
public class ClosePacket implements Packet {
   @JsonProperty("code")
   private final int code;
   @JsonProperty("message")
   private final String message;

   @JsonCreator
   private ClosePacket(@JsonProperty("code") int var1, @JsonProperty("message") String var2) {
      this.code = var1;
      this.message = var2;
   }

   public String message() {
      return this.message;
   }

   @Override
   public String toString() {
      return "ClosePacket { code = " + this.code + ", message = \"" + this.message + "\" }";
   }

   @Override
   public PacketOpcode opcode() {
      return PacketOpcode.CLOSE;
   }

   public int code() {
      return this.code;
   }
}
