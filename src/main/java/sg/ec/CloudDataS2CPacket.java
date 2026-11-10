// Original binary: sg/ec/I3gCCMkPDJtTnOcL
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class CloudDataS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, CloudDataS2CPacket> {
   public static final String field08644 = "cloudDataS2C";
   private GlobalPlayer field08645;
   private String field08646;
   private String field08647;
   private boolean field08648;
   private String field08649;
   private byte[] field08650;
   private static final String field08651 = "cloudDataS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field08645);
      var1.writeString(this.field08646 == null ? "" : this.field08646);
      var1.writeString(this.field08647 == null ? "" : this.field08647);
      var1.writeBoolean(this.field08648);
      var1.writeString(this.field08649 == null ? "" : this.field08649);
      var1.writeBytes(this.field08650 == null ? new byte[0] : this.field08650);
   }

   public CloudDataS2CPacket() {
      this.field08646 = "";
      this.field08647 = "";
      this.field08649 = "";
      this.field08650 = new byte[0];
   }

   public GlobalPlayer method03837() {
      return this.field08645;
   }

   public String method03838() {
      return this.field08647;
   }

   public String method03839() {
      return this.field08646;
   }

   public String method03840() {
      return this.field08649;
   }

   public boolean method03841() {
      return this.field08648;
   }

   public void method03842(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04357(this);
   }

   @Override
   public String method00213() {
      return field08651;
   }

   public CloudDataS2CPacket(GlobalPlayer var1, String var2, String var3, boolean var4, String var5, byte[] var6) {
      this.field08645 = var1;
      this.field08646 = var2 == null ? "" : var2;
      this.field08647 = var3 == null ? "" : var3;
      this.field08648 = var4;
      this.field08649 = var5 == null ? "" : var5;
      this.field08650 = var6 == null ? new byte[0] : var6;
   }

   public byte[] method03843() {
      return this.field08650;
   }

   public CloudDataS2CPacket method03844(VertexBufferData var1) {
      CloudDataS2CPacket var2 = new CloudDataS2CPacket();
      var2.field08645 = var1.readPlayer();
      var2.field08646 = var1.readString();
      var2.field08647 = var1.readString();
      var2.field08648 = var1.readBoolean();
      var2.field08649 = var1.readString();
      var2.field08650 = var1.readBytes();
      return var2;
   }

   @Override
   public CloudDataS2CPacket method00210(VertexBufferData var1) {
      return this.method03844(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method03842(var1, var2);
   }
}
