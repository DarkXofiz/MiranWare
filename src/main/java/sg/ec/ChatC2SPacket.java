// Original binary: sg/ec/Jl9xw81huNXHUzkE
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ChatC2SPacket implements GlobalPacket<GlobalPacketHandler, ChatC2SPacket> {
   public static String field09331 = ChatC2SPacket.field09334;
   private GlobalPlayer field09332;
   private String field09333;
   private static final String field09334 = "chatC2SPacket";

   public ChatC2SPacket method04108(VertexBufferData var1) {
      this.field09332 = var1.readPlayer();
      this.field09333 = var1.readString();
      return this;
   }

   @Override
   public String method00213() {
      return field09331;
   }

   public ChatC2SPacket() {
   }

   public String method04109() {
      return this.field09333;
   }

   public ChatC2SPacket(GlobalPlayer var1, String var2) {
      this.field09332 = var1;
      this.field09333 = var2;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field09332);
      var1.writeString(this.field09333);
   }

   public GlobalPlayer method04110() {
      return this.field09332;
   }

   @Override
   public ChatC2SPacket method00210(VertexBufferData var1) {
      return this.method04108(var1);
   }
}
