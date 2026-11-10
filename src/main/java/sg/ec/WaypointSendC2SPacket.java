// Original binary: sg/ec/6HeYaUTA9LrUzp3t
package sg.ec;

import com.google.gson.Gson;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class WaypointSendC2SPacket implements GlobalPacket<GlobalPacketHandler, WaypointSendC2SPacket> {
   public static final String field03025 = "waypointSendC2S";
   private PartyMember field03026;
   private Party field03027;
   private MutableVector3f field03028;
   private static final String field03029 = "waypointSendC2S";

   public WaypointSendC2SPacket() {
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePartyPlayer(this.field03026);
      var1.writeVec3f(this.field03028);
      var1.writeString(this.field03027 != null ? new Gson().toJson(this.field03027, Party.class) : "");
   }

   public WaypointSendC2SPacket method01304(VertexBufferData var1) {
      this.field03026 = var1.readPartyPlayer();
      this.field03028 = var1.readVec3f();
      String var2 = var1.readString();
      this.field03027 = var2.isEmpty() ? null : (Party)new Gson().fromJson(var2, Party.class);
      return this;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public WaypointSendC2SPacket(PartyMember var1, Party var2, MutableVector3f var3) {
      this.field03026 = var1;
      this.field03027 = var2;
      this.field03028 = var3;
   }

   public PartyMember method01305() {
      return this.field03026;
   }

   public MutableVector3f method01306() {
      return this.field03028;
   }

   public Party method01307() {
      return this.field03027;
   }

   @Override
   public String method00213() {
      return field03029;
   }

   @Override
   public WaypointSendC2SPacket method00210(VertexBufferData var1) {
      return this.method01304(var1);
   }
}
