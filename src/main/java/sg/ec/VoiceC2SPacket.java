// Original binary: sg/ec/2YusSajgFyIPEtLw
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class VoiceC2SPacket implements GlobalPacket<GlobalPacketHandler, VoiceC2SPacket> {
   public static final String field01071 = "voiceC2S";
   private GlobalPlayer field01072;
   private String field01073;
   private String field01074;
   private boolean field01075;
   private VoiceC2SPacket.Nested18 field01076;
   private int field01077;
   private int field01078;
   private int field01079;
   private int field01080;
   private byte[] field01081;
   private static final String field01082 = "voiceC2S";

   public VoiceC2SPacket(
      GlobalPlayer var1, String var2, String var3, boolean var4, VoiceC2SPacket.Nested18 var5, int var6, int var7, int var8, int var9, byte[] var10
   ) {
      this.field01072 = var1;
      this.field01073 = var2 == null ? "" : var2;
      this.field01074 = var3 == null ? "" : var3;
      this.field01075 = var4;
      this.field01076 = var5 == null ? VoiceC2SPacket.Nested18.STOP : var5;
      this.field01077 = var6;
      this.field01078 = var7;
      this.field01079 = var8;
      this.field01080 = var9;
      this.field01081 = var10 == null ? new byte[0] : var10;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field01072);
      var1.writeString(this.field01073 == null ? "" : this.field01073);
      var1.writeString(this.field01074 == null ? "" : this.field01074);
      var1.writeBoolean(this.field01075);
      var1.writeString(this.field01076.name());
      var1.writeInt(this.field01077);
      var1.writeInt(this.field01078);
      var1.writeInt(this.field01079);
      var1.writeInt(this.field01080);
      var1.writeBytes(this.field01081 == null ? new byte[0] : this.field01081);
   }

   public String method00557() {
      return this.field01073;
   }

   @Override
   public int method00558() {
      return (this.field01081 == null ? 0 : this.field01081.length) + 512;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public VoiceC2SPacket.Nested18 method00559() {
      return this.field01076;
   }

   public GlobalPlayer method00560() {
      return this.field01072;
   }

   public boolean method00561() {
      return this.field01075;
   }

   public VoiceC2SPacket() {
      this.field01073 = "";
      this.field01074 = "";
      this.field01076 = VoiceC2SPacket.Nested18.STOP;
      this.field01077 = 100;
      this.field01081 = new byte[0];
   }

   public int method00562() {
      return this.field01078;
   }

   public int method00563() {
      return this.field01077;
   }

   public VoiceC2SPacket method00564(VertexBufferData var1) {
      this.field01072 = var1.readPlayer();
      this.field01073 = var1.readString();
      this.field01074 = var1.readString();
      this.field01075 = var1.readBoolean();
      this.field01076 = VoiceC2SPacket.Nested18.method00569(var1.readString());
      this.field01077 = var1.readInt();
      this.field01078 = var1.readInt();
      this.field01079 = var1.readInt();
      this.field01080 = var1.readInt();
      this.field01081 = var1.readBytes();
      return this;
   }

   public String method00565() {
      return this.field01074;
   }

   public int method00566() {
      return this.field01080;
   }

   public byte[] method00567() {
      return this.field01081;
   }

   @Override
   public String method00213() {
      return field01082;
   }

   public int method00568() {
      return this.field01079;
   }

   // $VF: Compiled from s
   public enum Nested18 {
      START,
      STREAM,
      STOP,
      VOLUME,
      SEEK;

      public static VoiceC2SPacket.Nested18 method00569(String var0) {
         if (var0 != null) {
            for (VoiceC2SPacket.Nested18 var4 : values()) {
               if (var4.name().equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return STOP;
      }
   }

   @Override
   public VoiceC2SPacket method00210(VertexBufferData var1) {
      return this.method00564(var1);
   }
}
