// Original binary: sg/ec/rdLOVp78bsuajPsd
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyCommandC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyCommandC2SPacket> {
   public static final String field23396 = "partyCommandC2S";
   private GlobalPlayer field23397;
   private String field23398;
   private PartyCommandC2SPacket.Nested301 field23399;
   private String field23400;
   private static final String field23401 = "partyCommandC2S";

   public GlobalPlayer method10432() {
      return this.field23397;
   }

   @Override
   public String method00213() {
      return field23401;
   }

   public PartyCommandC2SPacket.Nested301 method10433() {
      return this.field23399;
   }

   public PartyCommandC2SPacket(GlobalPlayer var1, String var2, PartyCommandC2SPacket.Nested301 var3) {
      this.field23397 = var1;
      this.field23398 = var2;
      this.field23399 = var3;
      this.field23400 = "";
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field23397);
      var1.writeString(this.field23398);
      var1.writeString(this.field23399.name());
      var1.writeString(this.field23400 == null ? "" : this.field23400);
   }

   public PartyCommandC2SPacket() {
   }

   public String method10434() {
      return this.field23400;
   }

   public String method10435() {
      return this.field23398;
   }

   public PartyCommandC2SPacket(GlobalPlayer var1, String var2, PartyCommandC2SPacket.Nested301 var3, String var4) {
      this.field23397 = var1;
      this.field23398 = var2;
      this.field23399 = var3;
      this.field23400 = var4 == null ? "" : var4;
   }

   public PartyCommandC2SPacket method10436(VertexBufferData var1) {
      this.field23397 = var1.readPlayer();
      this.field23398 = var1.readString();
      this.field23399 = PartyCommandC2SPacket.Nested301.valueOf(var1.readString());
      this.field23400 = var1.readString();
      return this;
   }

   // $VF: Compiled from s
   public enum Nested301 {
      Accept,
      Deny,
      Chat,
      Back;
   }

   @Override
   public PartyCommandC2SPacket method00210(VertexBufferData var1) {
      return this.method10436(var1);
   }
}
