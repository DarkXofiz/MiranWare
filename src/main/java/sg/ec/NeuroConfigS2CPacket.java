// Original binary: sg/ec/8psBzZfRw1UYBdHh
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
@Deprecated
public class NeuroConfigS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, NeuroConfigS2CPacket> {
   public static final String field05100 = "neuroConfigS2C";
   private byte[] field05101 = new byte[0];
   private String field05102 = "";
   private byte[] field05103 = new byte[0];
   private static final String field05104 = "neuroConfigS2C";

   public byte[] method02133() {
      return this.field05103;
   }

   public void method02134(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10052(this);
   }

   @Override
   public String method00213() {
      return field05104;
   }

   public String method02135() {
      return this.field05102;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writeBytes(this.field05101);
      var1.writeString(this.field05102);
      var1.writeBytes(this.field05103);
   }

   public byte[] method02136() {
      return this.field05101;
   }

   public NeuroConfigS2CPacket method02137(VertexBufferData var1) {
      NeuroConfigS2CPacket var2 = new NeuroConfigS2CPacket();
      var2.field05101 = var1.readBytes();
      var2.field05102 = var1.readString();
      var2.field05103 = var1.readBytes();
      return var2;
   }

   @Override
   public NeuroConfigS2CPacket method00210(VertexBufferData var1) {
      return this.method02137(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method02134(var1, var2);
   }
}
