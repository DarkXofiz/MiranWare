// Original binary: sg/ec/0kh2mz4t2iD2S13a
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyCreateC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyCreateC2SPacket> {
   public static final String field00413 = "partyCreateC2S";
   private GlobalPlayer field00414;
   private String field00415;
   private static final String field00416 = "partyCreateC2S";

   public PartyCreateC2SPacket method00208(VertexBufferData var1) {
      this.field00414 = var1.readPlayer();
      this.field00415 = var1.readString();
      return this;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field00414);
      var1.writeString(this.field00415);
   }

   public PartyCreateC2SPacket() {
   }

   public GlobalPlayer method00211() {
      return this.field00414;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   @Override
   public String method00213() {
      return field00416;
   }

   public PartyCreateC2SPacket(GlobalPlayer var1, String var2) {
      this.field00414 = var1;
      this.field00415 = var2;
   }

   public String method00214() {
      return this.field00415;
   }

   @Override
   public PartyCreateC2SPacket method00210(VertexBufferData var1) {
      return this.method00208(var1);
   }
}
