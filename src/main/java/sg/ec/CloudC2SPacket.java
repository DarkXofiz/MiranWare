// Original binary: sg/ec/ogStNwFOg3RjVHv0
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class CloudC2SPacket implements GlobalPacket<GlobalPacketHandler, CloudC2SPacket> {
   public static final String field22159 = "cloudC2S";
   private GlobalPlayer field22160;
   private CloudC2SPacket.Nested276 field22161;
   private String field22162;
   private String field22163;
   private byte[] field22164;
   private String field22165;
   private static final String field22166 = "cloudC2S";

   @Override
   public String method00213() {
      return field22166;
   }

   public String method09855() {
      return this.field22165;
   }

   public CloudC2SPacket(GlobalPlayer var1, CloudC2SPacket.Nested276 var2, String var3, String var4, byte[] var5, String var6) {
      this.field22160 = var1;
      this.field22161 = var2 == null ? CloudC2SPacket.Nested276.LIST : var2;
      this.field22162 = var3 == null ? "" : var3;
      this.field22163 = var4 == null ? "" : var4;
      this.field22164 = var5 == null ? new byte[0] : var5;
      this.field22165 = var6 == null ? "" : var6;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field22160);
      var1.writeString(this.field22161.name());
      var1.writeString(this.field22162 == null ? "" : this.field22162);
      var1.writeString(this.field22163 == null ? "" : this.field22163);
      var1.writeBytes(this.field22164 == null ? new byte[0] : this.field22164);
      var1.writeString(this.field22165 == null ? "" : this.field22165);
   }

   public CloudC2SPacket() {
      this.field22161 = CloudC2SPacket.Nested276.LIST;
      this.field22162 = "";
      this.field22163 = "";
      this.field22164 = new byte[0];
      this.field22165 = "";
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public CloudC2SPacket.Nested276 method09856() {
      return this.field22161;
   }

   public String method09857() {
      return this.field22162;
   }

   public GlobalPlayer method09858() {
      return this.field22160;
   }

   public byte[] method09859() {
      return this.field22164;
   }

   public String method09860() {
      return this.field22163;
   }

   public CloudC2SPacket method09861(VertexBufferData var1) {
      this.field22160 = var1.readPlayer();
      this.field22161 = CloudC2SPacket.Nested276.method09862(var1.readString());
      this.field22162 = var1.readString();
      this.field22163 = var1.readString();
      this.field22164 = var1.readBytes();
      this.field22165 = var1.remaining() > 0 ? var1.readString() : "";
      return this;
   }

   // $VF: Compiled from s
   public enum Nested276 {
      UPLOAD,
      DOWNLOAD,
      LIST,
      DELETE,
      PROFILE,
      KEY_CREATE,
      KEY_LOAD,
      KEY_LIST,
      KEY_DELETE,
      TRASH_LIST,
      TRASH_RESTORE;

      public static CloudC2SPacket.Nested276 method09862(String var0) {
         if (var0 != null) {
            for (CloudC2SPacket.Nested276 var4 : values()) {
               if (var4.name().equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return LIST;
      }
   }

   @Override
   public CloudC2SPacket method00210(VertexBufferData var1) {
      return this.method09861(var1);
   }
}
