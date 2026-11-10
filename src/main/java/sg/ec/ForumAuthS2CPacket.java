// Original binary: sg/ec/LZ8xyKM3JIC0KtW5
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ForumAuthS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, ForumAuthS2CPacket> {
   public static final String field09894 = "forumAuthS2C";
   private GlobalPlayer field09895;
   private String field09896;
   private String field09897;
   private String field09898;
   private String field09899;
   private String field09900;
   private static final String field09901 = "forumAuthS2C";

   public String method04429() {
      return this.field09897;
   }

   public void method04430(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10044(this);
   }

   public String method04431() {
      return this.field09898;
   }

   public String method04432() {
      return this.field09896;
   }

   public ForumAuthS2CPacket(GlobalPlayer var1, String var2, String var3, String var4, String var5, String var6) {
      this.field09895 = var1;
      this.field09896 = var2 == null ? "" : var2;
      this.field09897 = var3 == null ? "" : var3;
      this.field09898 = var4 == null ? "" : var4;
      this.field09899 = var5 == null ? "" : var5;
      this.field09900 = var6 == null ? "" : var6;
   }

   @Override
   public String method00213() {
      return field09901;
   }

   public ForumAuthS2CPacket() {
      this.field09896 = "";
      this.field09897 = "";
      this.field09898 = "";
      this.field09899 = "";
      this.field09900 = "";
   }

   public ForumAuthS2CPacket method04433(VertexBufferData var1) {
      this.field09895 = var1.readPlayer();
      this.field09896 = var1.readString();
      this.field09897 = var1.readString();
      this.field09898 = var1.readString();
      this.field09899 = var1.readString();
      this.field09900 = var1.readString();
      return this;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field09895);
      var1.writeString(this.field09896);
      var1.writeString(this.field09897);
      var1.writeString(this.field09898);
      var1.writeString(this.field09899);
      var1.writeString(this.field09900);
   }

   public GlobalPlayer method04434() {
      return this.field09895;
   }

   public String method04435() {
      return this.field09899;
   }

   public String method04436() {
      return this.field09900;
   }

   @Override
   public ForumAuthS2CPacket method00210(VertexBufferData var1) {
      return this.method04433(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method04430(var1, var2);
   }
}
