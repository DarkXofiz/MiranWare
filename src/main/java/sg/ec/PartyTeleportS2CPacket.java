// Original binary: sg/ec/KRUcUxLHrU1du8w9
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyTeleportS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, PartyTeleportS2CPacket> {
   public static final String field09660 = "partyTeleportS2C";
   private PartyMember field09661;
   private PartyMember field09662;
   private PartyTeleportC2SPacket.Nested30 field09663;
   private String field09664;
   private long field09665;
   private static final String field09666 = "partyTeleportS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field09661);
      var1.writePartyPlayer(this.field09662);
      var1.writeString(this.field09663.name());
      var1.writeString(this.field09664);
      var1.writeLong(this.field09665);
   }

   public PartyTeleportS2CPacket() {
   }

   public PartyTeleportS2CPacket(PartyMember var1, PartyMember var2, PartyTeleportC2SPacket.Nested30 var3, String var4, long var5) {
      this.field09661 = var1;
      this.field09662 = var2;
      this.field09663 = var3 == null ? PartyTeleportC2SPacket.Nested30.STOP : var3;
      this.field09664 = var4 == null ? "" : var4;
      this.field09665 = Math.max(0L, var5);
   }

   public PartyTeleportS2CPacket method04269(VertexBufferData var1) {
      PartyTeleportS2CPacket var2 = new PartyTeleportS2CPacket();
      var2.field09661 = var1.readPartyPlayer();
      var2.field09662 = var1.readPartyPlayer();
      var2.field09663 = PartyTeleportC2SPacket.Nested30.valueOf(var1.readString());
      var2.field09664 = var1.readString();
      var2.field09665 = var1.readLong();
      return var2;
   }

   public long method04270() {
      return this.field09665;
   }

   public PartyMember method04271() {
      return this.field09662;
   }

   public PartyTeleportC2SPacket.Nested30 method04272() {
      return this.field09663;
   }

   @Override
   public String method00213() {
      return field09666;
   }

   public String method04273() {
      return this.field09664;
   }

   public PartyMember method04274() {
      return this.field09661;
   }

   public void method04275(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10050(this);
   }

   @Override
   public PartyTeleportS2CPacket method00210(VertexBufferData var1) {
      return this.method04269(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method04275(var1, var2);
   }
}
