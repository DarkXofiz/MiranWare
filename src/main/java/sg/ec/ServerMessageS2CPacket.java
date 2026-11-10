// Original binary: sg/ec/TuPWkWeLWUKmBwBf
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ServerMessageS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, ServerMessageS2CPacket> {
   public static final String field12060 = "serverMessageS2C";
   private GlobalPlayer field12061;
   private String field12062;
   private static final String field12063 = "serverMessageS2C";

   public GlobalPlayer method05690() {
      return this.field12061;
   }

   public void method05691(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04362(this);
   }

   public ServerMessageS2CPacket() {
   }

   public ServerMessageS2CPacket(GlobalPlayer var1, String var2) {
      this.field12061 = var1;
      this.field12062 = var2;
   }

   public ServerMessageS2CPacket method05692(VertexBufferData var1) {
      ServerMessageS2CPacket var2 = new ServerMessageS2CPacket();
      var2.field12061 = var1.readPlayer();
      var2.field12062 = var1.readString();
      return var2;
   }

   public String method05693() {
      return this.field12062;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field12061);
      var1.writeString(this.field12062);
   }

   @Override
   public String method00213() {
      return field12063;
   }

   @Override
   public ServerMessageS2CPacket method00210(VertexBufferData var1) {
      return this.method05692(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method05691(var1, var2);
   }
}
