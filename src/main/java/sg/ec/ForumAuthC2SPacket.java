// Original binary: sg/ec/F2aUsLJ2kPuT6Rs4
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ForumAuthC2SPacket implements GlobalPacket<GlobalPacketHandler, ForumAuthC2SPacket> {
   public static final String field07234 = "forumAuthC2S";
   private GlobalPlayer field07235;
   private String field07236;
   private boolean field07237;
   private static final String field07238 = "forumAuthC2S";

   public ForumAuthC2SPacket() {
      this.field07236 = "";
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public boolean method03317() {
      return this.field07237;
   }

   @Override
   public String method00213() {
      return field07238;
   }

   public GlobalPlayer method03318() {
      return this.field07235;
   }

   public ForumAuthC2SPacket(GlobalPlayer var1, String var2, boolean var3) {
      this.field07235 = var1;
      this.field07236 = var2 == null ? "" : var2;
      this.field07237 = var3;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field07235);
      var1.writeString(this.field07236 == null ? "" : this.field07236);
      var1.writeBoolean(this.field07237);
   }

   public ForumAuthC2SPacket method03319(VertexBufferData var1) {
      this.field07235 = var1.readPlayer();
      this.field07236 = var1.readString();
      this.field07237 = var1.readBoolean();
      return this;
   }

   public String method03320() {
      return this.field07236;
   }

   @Override
   public ForumAuthC2SPacket method00210(VertexBufferData var1) {
      return this.method03319(var1);
   }
}
