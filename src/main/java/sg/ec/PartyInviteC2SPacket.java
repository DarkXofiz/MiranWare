// Original binary: sg/ec/jYlaSP1YqPp6TyjP
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyInviteC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyInviteC2SPacket> {
   public static final String field20474 = "partyInviteC2S";
   private PartyMember field20475;
   private String field20476;
   private String field20477;
   private static final String field20478 = "partyInviteC2S";

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public PartyInviteC2SPacket() {
   }

   public String method09016() {
      return this.field20476;
   }

   public PartyMember method09017() {
      return this.field20475;
   }

   @Override
   public String method00213() {
      return field20478;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field20475);
      var1.writeString(this.field20476);
      var1.writeString(this.field20477);
   }

   public String method09018() {
      return this.field20477;
   }

   public PartyInviteC2SPacket(PartyMember var1, String var2, String var3) {
      this.field20475 = var1;
      this.field20476 = var2;
      this.field20477 = var3;
   }

   public PartyInviteC2SPacket method09019(VertexBufferData var1) {
      this.field20475 = var1.readPartyPlayer();
      this.field20476 = var1.readString();
      this.field20477 = var1.readString();
      return this;
   }

   @Override
   public PartyInviteC2SPacket method00210(VertexBufferData var1) {
      return this.method09019(var1);
   }
}
