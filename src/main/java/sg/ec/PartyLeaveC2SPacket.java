// Original binary: sg/ec/5KeOfIzVqfAKlHDe
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyLeaveC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyLeaveC2SPacket> {
   public static final String field02190 = "partyLeaveC2S";
   private PartyMember field02191;
   private static final String field02192 = "partyLeaveC2S";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field02191);
   }

   public PartyLeaveC2SPacket(PartyMember var1) {
      this.field02191 = var1;
   }

   public PartyLeaveC2SPacket() {
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   @Override
   public String method00213() {
      return field02192;
   }

   public PartyMember method00955() {
      return this.field02191;
   }

   public PartyLeaveC2SPacket method00956(VertexBufferData var1) {
      this.field02191 = var1.readPartyPlayer();
      return this;
   }

   @Override
   public PartyLeaveC2SPacket method00210(VertexBufferData var1) {
      return this.method00956(var1);
   }
}
