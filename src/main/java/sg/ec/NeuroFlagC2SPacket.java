// Original binary: sg/ec/knLhneBmXmFMnUun
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class NeuroFlagC2SPacket implements GlobalPacket<GlobalPacketHandler, NeuroFlagC2SPacket> {
   public static final String field20918 = "neuroFlagC2S";
   private GlobalPlayer field20919;
   private String field20920;
   private static final String field20921 = "neuroFlagC2S";

   @Override
   public String method00213() {
      return field20921;
   }

   public NeuroFlagC2SPacket method09245(VertexBufferData var1) {
      this.field20919 = var1.readPlayer();
      this.field20920 = var1.readString();
      return this;
   }

   public NeuroFlagC2SPacket(GlobalPlayer var1, String var2) {
      this.field20919 = var1;
      this.field20920 = var2 == null ? "" : var2;
   }

   public String method09246() {
      return this.field20920;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field20919);
      var1.writeString(this.field20920 == null ? "" : this.field20920);
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public NeuroFlagC2SPacket() {
      this.field20920 = "";
   }

   public GlobalPlayer method09247() {
      return this.field20919;
   }

   @Override
   public NeuroFlagC2SPacket method00210(VertexBufferData var1) {
      return this.method09245(var1);
   }
}
