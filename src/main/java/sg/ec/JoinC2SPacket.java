// Original binary: sg/ec/Z1L1rFcH3UDZcWjM
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class JoinC2SPacket implements GlobalPacket<GlobalPacketHandler, JoinC2SPacket> {
   public static String field15220 = JoinC2SPacket.field15228;
   private GlobalPlayer field15221;
   private String field15222;
   private String field15223;
   private static final String field15224 = "Пользователь";
   private static final String field15225 = "Пользователь";
   private static final String field15226 = "Пользователь";
   private static final String field15227 = "Пользователь";
   private static final String field15228 = "JOIN";

   public String method06793() {
      return this.field15223;
   }

   @Override
   public String method00213() {
      return field15220;
   }

   public JoinC2SPacket(GlobalPlayer var1) {
      this(var1, field15224, false, "", "");
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public JoinC2SPacket(GlobalPlayer var1, String var2, boolean var3, String var4, String var5) {
      this.field15221 = var1;
      this.field15222 = var2 == null ? field15225 : var2;
      if (var4 == null) {
         String var10001 = "";
      }

      if (var5 == null) {
         String var6 = "";
      }

      this.field15223 = ClientEnvironment.field07578;
   }

   public JoinC2SPacket() {
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field15221);
      var1.writeString(this.field15222 == null ? field15227 : this.field15222);
      var1.writeBoolean(false);
      var1.writeString(null == null ? "" : null);
      var1.writeString(null == null ? "" : null);
      var1.writeString(this.field15223 == null ? "" : this.field15223);
   }

   public JoinC2SPacket(GlobalPlayer var1, String var2, boolean var3, String var4) {
      this(var1, var2, var3, var4, "");
   }

   public JoinC2SPacket method06794(VertexBufferData var1) {
      this.field15221 = var1.readPlayer();
      this.field15222 = var1.remaining() > 0 ? var1.readString() : field15226;
      if (var1.remaining() > 0 && var1.readBoolean()) {
         boolean var2 = true;
      } else {
         boolean var10001 = false;
      }

      if (var1.remaining() > 0) {
         var1.readString();
      } else {
         String var3 = "";
      }

      if (var1.remaining() > 0) {
         var1.readString();
      } else {
         String var4 = "";
      }

      this.field15223 = var1.remaining() > 0 ? var1.readString() : "";
      return this;
   }

   public String method06795() {
      return this.field15222;
   }

   public GlobalPlayer method06796() {
      return this.field15221;
   }

   @Override
   public JoinC2SPacket method00210(VertexBufferData var1) {
      return this.method06794(var1);
   }
}
