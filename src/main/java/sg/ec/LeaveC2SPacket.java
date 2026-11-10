// Original binary: sg/ec/fohCLo6QWmfiSWTj
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class LeaveC2SPacket implements GlobalPacket<GlobalPacketHandler, LeaveC2SPacket> {
   public static final String field19176 = "leaveC2S";
   private GlobalPlayer field19177;
   private static final String field19178 = "leaveC2S";

   @Override
   public String method00213() {
      return field19178;
   }

   public LeaveC2SPacket(GlobalPlayer var1) {
      this.field19177 = var1;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field19177);
   }

   public LeaveC2SPacket method08333(VertexBufferData var1) {
      this.field19177 = var1.readPlayer();
      return this;
   }

   public GlobalPlayer method08334() {
      return this.field19177;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public LeaveC2SPacket() {
   }

   @Override
   public LeaveC2SPacket method00210(VertexBufferData var1) {
      return this.method08333(var1);
   }
}
