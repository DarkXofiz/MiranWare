// Original binary: sg/ec/l3vV0I3ZQILu9gzi
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class SocialC2SPacket implements GlobalPacket<GlobalPacketHandler, SocialC2SPacket> {
   public static final String field21161 = "socialC2S";
   private GlobalPlayer field21162;
   private String field21163;
   private String field21164;
   private String field21165;
   private static final String field21166 = "socialC2S";

   public String method09297() {
      return this.field21164;
   }

   @Override
   public String method00213() {
      return field21166;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public SocialC2SPacket method09298(VertexBufferData var1) {
      this.field21162 = var1.readPlayer();
      this.field21163 = var1.readString();
      this.field21164 = var1.readString();
      this.field21165 = var1.readString();
      return this;
   }

   public String method09299() {
      return this.field21165;
   }

   public GlobalPlayer method09300() {
      return this.field21162;
   }

   public SocialC2SPacket() {
   }

   public SocialC2SPacket(GlobalPlayer var1, String var2, String var3, String var4) {
      this.field21162 = var1;
      this.field21163 = var2;
      this.field21164 = var3;
      this.field21165 = var4;
   }

   public String method09301() {
      return this.field21163;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field21162);
      var1.writeString(this.field21163 == null ? "" : this.field21163);
      var1.writeString(this.field21164 == null ? "" : this.field21164);
      var1.writeString(this.field21165 == null ? "" : this.field21165);
   }

   @Override
   public SocialC2SPacket method00210(VertexBufferData var1) {
      return this.method09298(var1);
   }
}
