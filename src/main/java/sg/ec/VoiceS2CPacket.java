// Original binary: sg/ec/i7yoYrkMT0jXxKs8
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class VoiceS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, VoiceS2CPacket> {
   public static final String field19991 = "voiceS2C";
   private GlobalPlayer field19992;
   private VoiceC2SPacket.Nested18 field19993;
   private int field19994;
   private int field19995;
   private int field19996;
   private int field19997;
   private byte[] field19998;
   private static final String field19999 = "voiceS2C";

   @Override
   public String method00213() {
      return field19999;
   }

   public GlobalPlayer method08766() {
      return this.field19992;
   }

   public VoiceS2CPacket(GlobalPlayer var1, VoiceC2SPacket.Nested18 var2, int var3, int var4, int var5, int var6, byte[] var7) {
      this.field19992 = var1;
      this.field19993 = var2 == null ? VoiceC2SPacket.Nested18.STOP : var2;
      this.field19994 = var3;
      this.field19995 = var4;
      this.field19996 = var5;
      this.field19997 = var6;
      this.field19998 = var7 == null ? new byte[0] : var7;
   }

   public int method08767() {
      return this.field19997;
   }

   public VoiceS2CPacket() {
      this.field19993 = VoiceC2SPacket.Nested18.STOP;
      this.field19994 = 100;
      this.field19998 = new byte[0];
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field19992);
      var1.writeString(this.field19993.name());
      var1.writeInt(this.field19994);
      var1.writeInt(this.field19995);
      var1.writeInt(this.field19996);
      var1.writeInt(this.field19997);
      var1.writeBytes(this.field19998 == null ? new byte[0] : this.field19998);
   }

   public int method08768() {
      return this.field19994;
   }

   public VoiceC2SPacket.Nested18 method08769() {
      return this.field19993;
   }

   public int method08770() {
      return this.field19995;
   }

   public VoiceS2CPacket method08771(VertexBufferData var1) {
      this.field19992 = var1.readPlayer();
      this.field19993 = VoiceC2SPacket.Nested18.method00569(var1.readString());
      this.field19994 = var1.readInt();
      this.field19995 = var1.readInt();
      this.field19996 = var1.readInt();
      this.field19997 = var1.readInt();
      this.field19998 = var1.readBytes();
      return this;
   }

   @Override
   public int method00558() {
      return (this.field19998 == null ? 0 : this.field19998.length) + 512;
   }

   public void method08772(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04356(this);
   }

   public int method08773() {
      return this.field19996;
   }

   public byte[] method08774() {
      return this.field19998;
   }

   @Override
   public VoiceS2CPacket method00210(VertexBufferData var1) {
      return this.method08771(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method08772(var1, var2);
   }
}
