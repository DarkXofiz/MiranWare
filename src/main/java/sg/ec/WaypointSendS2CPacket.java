// Original binary: sg/ec/O6Rh5xIqDX15rgfP
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class WaypointSendS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, WaypointSendS2CPacket> {
   public static final String field10482 = "waypointSendS2C";
   private PartyMember field10483;
   private PartyMember field10484;
   private MutableVector3f field10485;
   private static final String field10486 = "waypointSendS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field10483);
      var1.writePartyPlayer(this.field10484);
      var1.writeVec3f(this.field10485);
   }

   public WaypointSendS2CPacket(PartyMember var1, PartyMember var2, MutableVector3f var3) {
      this.field10483 = var1;
      this.field10484 = var2;
      this.field10485 = var3;
   }

   public WaypointSendS2CPacket method04751(VertexBufferData var1) {
      WaypointSendS2CPacket var2 = new WaypointSendS2CPacket();
      var2.field10483 = var1.readPartyPlayer();
      var2.field10484 = var1.readPartyPlayer();
      var2.field10485 = var1.readVec3f();
      return var2;
   }

   public MutableVector3f method04752() {
      return this.field10485;
   }

   public void method04753(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04363(this);
   }

   @Override
   public String method00213() {
      return field10486;
   }

   public PartyMember method04754() {
      return this.field10484;
   }

   public WaypointSendS2CPacket() {
   }

   public PartyMember method04755() {
      return this.field10483;
   }

   @Override
   public WaypointSendS2CPacket method00210(VertexBufferData var1) {
      return this.method04751(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method04753(var1, var2);
   }
}
