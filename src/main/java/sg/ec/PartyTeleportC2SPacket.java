// Original binary: sg/ec/4lJ6qVk0mZO9LySV
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PartyTeleportC2SPacket implements GlobalPacket<GlobalPacketHandler, PartyTeleportC2SPacket> {
   public static final String field02064 = "partyTeleportC2S";
   private PartyMember field02065;
   private PartyMember field02066;
   private String field02067;
   private PartyTeleportC2SPacket.Nested30 field02068;
   private String field02069;
   private long field02070;
   private static final String field02071 = "partyTeleportC2S";

   public PartyTeleportC2SPacket method00886(VertexBufferData var1) {
      this.field02065 = var1.readPartyPlayer();
      this.field02066 = var1.readPartyPlayer();
      this.field02067 = var1.readString();
      this.field02068 = PartyTeleportC2SPacket.Nested30.valueOf(var1.readString());
      this.field02069 = var1.readString();
      this.field02070 = var1.readLong();
      return this;
   }

   @Override
   public String method00213() {
      return field02071;
   }

   public PartyTeleportC2SPacket(PartyMember var1, PartyMember var2, String var3, PartyTeleportC2SPacket.Nested30 var4, String var5, long var6) {
      this.field02065 = var1;
      this.field02066 = var2;
      this.field02067 = var3 == null ? "" : var3;
      this.field02068 = var4 == null ? PartyTeleportC2SPacket.Nested30.STOP : var4;
      this.field02069 = var5 == null ? "" : var5;
      this.field02070 = Math.max(0L, var6);
   }

   public long method00887() {
      return this.field02070;
   }

   public PartyTeleportC2SPacket() {
   }

   public String method00888() {
      return this.field02069;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field02065);
      var1.writePartyPlayer(this.field02066);
      var1.writeString(this.field02067);
      var1.writeString(this.field02068.name());
      var1.writeString(this.field02069);
      var1.writeLong(this.field02070);
   }

   public PartyTeleportC2SPacket.Nested30 method00889() {
      return this.field02068;
   }

   public String method00890() {
      return this.field02067;
   }

   public PartyMember method00891() {
      return this.field02065;
   }

   public PartyMember method00892() {
      return this.field02066;
   }

   // $VF: Compiled from s
   public enum Nested30 {
      START,
      STOP;
   }

   @Override
   public PartyTeleportC2SPacket method00210(VertexBufferData var1) {
      return this.method00886(var1);
   }
}
