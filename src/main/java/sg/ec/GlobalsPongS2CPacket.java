// Original binary: sg/ec/tfxfnWRCVq5c0veU
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class GlobalsPongS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, GlobalsPongS2CPacket> {
   public static final String field24140 = "globalsPongS2C";
   private String field24141;
   private long field24142;
   private long field24143;
   private static final String field24144 = "globalsPongS2C";

   public void method10849(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10045(this);
   }

   public String method10850() {
      return this.field24141;
   }

   @Override
   public String method00213() {
      return field24144;
   }

   public GlobalsPongS2CPacket method10851(VertexBufferData var1) {
      GlobalsPongS2CPacket var2 = new GlobalsPongS2CPacket();
      var2.field24141 = var1.readString();
      var2.field24142 = var1.readLong();
      var2.field24143 = var1.readLong();
      return var2;
   }

   public long method10852() {
      return this.field24143;
   }

   public GlobalsPongS2CPacket(String var1, long var2, long var4) {
      this.field24141 = var1;
      this.field24142 = var2;
      this.field24143 = var4;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writeString(this.field24141 != null ? this.field24141 : "");
      var1.writeLong(this.field24142);
      var1.writeLong(this.field24143);
   }

   public GlobalsPongS2CPacket() {
   }

   public long method10853() {
      return this.field24142;
   }

   @Override
   public GlobalsPongS2CPacket method00210(VertexBufferData var1) {
      return this.method10851(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method10849(var1, var2);
   }
}
