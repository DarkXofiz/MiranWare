// Original binary: hex/dscRPC/packet/impl/PingPacket
package hex.dscRPC.packet.impl;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import hex.dscRPC.packet.Packet;
import hex.dscRPC.packet.PacketOpcode;
import java.util.HashMap;
import java.util.Map;

// $VF: Compiled from s
public class PingPacket implements Packet {
   @JsonIgnore
   private final Map<String, Object> properties;

   public PingPacket(Map<String, Object> var1) {
      this.properties = new HashMap<>(var1);
   }

   @JsonAnySetter
   public void setProperties(String var1, Object var2) {
      this.properties.put(var1, var2);
   }

   @JsonCreator
   public PingPacket() {
      this.properties = new HashMap<>();
   }

   @Override
   public PacketOpcode opcode() {
      return PacketOpcode.PING;
   }

   @JsonAnyGetter
   public Map<String, Object> properties() {
      return this.properties;
   }
}
