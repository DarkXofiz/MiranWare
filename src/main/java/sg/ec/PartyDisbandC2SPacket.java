// Original binary: sg/ec/gNQOH5bRuHg4cNWU
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyDisbandC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyDisbandC2SPacket> {
   public static final String field19538 = "partyDisbandC2S";
   private PartyMember field19539;
   private String field19540;
   private static final String field19541 = "partyDisbandC2S";

   public String method08453() {
      return this.field19540;
   }

   public PartyDisbandC2SPacket() {
   }

   public PartyDisbandC2SPacket method08454(VertexBufferData var1) {
      this.field19539 = var1.readPartyPlayer();
      this.field19540 = var1.readString();
      return this;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field19539);
      var1.writeString(this.field19540);
   }

   public PartyDisbandC2SPacket(PartyMember var1, String var2) {
      this.field19539 = var1;
      this.field19540 = var2;
   }

   @Override
   public String method00213() {
      return field19541;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public PartyMember method08455() {
      return this.field19539;
   }

   @Override
   public PartyDisbandC2SPacket method00210(VertexBufferData var1) {
      return this.method08454(var1);
   }
}
