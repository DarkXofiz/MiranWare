// Original binary: hex/dscRPC/packet/impl/HandshakePacket
package hex.dscRPC.packet.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import hex.dscRPC.packet.Packet;
import hex.dscRPC.packet.PacketOpcode;

// $VF: Compiled from s
public class HandshakePacket implements Packet {
   public static final int DEFAULT_VERSION = 1;
   @JsonProperty("v")
   private final int version;
   @JsonProperty("client_id")
   private final String clientId;

   @Override
   public PacketOpcode opcode() {
      return PacketOpcode.HANDSHAKE;
   }

   @Override
   public String toString() {
      return "HandshakePacket { version = " + this.version + ", clientId = \"" + this.clientId + "\" }";
   }

   public HandshakePacket(long var1) {
      this(1, String.valueOf(var1));
   }

   public HandshakePacket(int var1, String var2) {
      this.version = var1;
      this.clientId = var2;
   }
}
