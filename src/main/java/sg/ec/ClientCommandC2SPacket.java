// Original binary: sg/ec/tCqO3lQDi3RvSSbP
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ClientCommandC2SPacket implements GlobalPacket<GlobalPacketHandler, ClientCommandC2SPacket> {
   public static final String field23833 = "clientCommandC2S";
   private GlobalPlayer field23834;
   private ClientCommandC2SPacket.Nested313 field23835;
   private String field23836;
   private String field23837;
   private int field23838;
   private String field23839;
   private static final String field23840 = "clientCommandC2S";

   public ClientCommandC2SPacket(GlobalPlayer var1, ClientCommandC2SPacket.Nested313 var2, String var3, String var4) {
      this(var1, var2, var3, var4, 30, "");
   }

   @Override
   public String method00213() {
      return field23840;
   }

   public GlobalPlayer method10801() {
      return this.field23834;
   }

   public ClientCommandC2SPacket() {
   }

   public ClientCommandC2SPacket(GlobalPlayer var1, ClientCommandC2SPacket.Nested313 var2, String var3, String var4, int var5, String var6) {
      this.field23834 = var1;
      this.field23835 = var2 == null ? ClientCommandC2SPacket.Nested313.REQUEST_USERS : var2;
      this.field23836 = var3 == null ? "" : var3;
      this.field23837 = var4 == null ? "" : var4;
      this.field23838 = Math.max(1, var5);
      this.field23839 = var6 == null ? "" : var6;
   }

   public String method10802() {
      return this.field23836;
   }

   public String method10803() {
      return this.field23837;
   }

   public ClientCommandC2SPacket method10804(VertexBufferData var1) {
      this.field23834 = var1.readPlayer();
      this.field23835 = ClientCommandC2SPacket.Nested313.valueOf(var1.readString());
      this.field23836 = var1.readString();
      this.field23837 = var1.readString();
      this.field23838 = var1.remaining() > 0 ? Math.max(1, var1.readInt()) : 30;
      this.field23839 = var1.remaining() > 0 ? var1.readString() : "";
      return this;
   }

   public int method10805() {
      return this.field23838;
   }

   public ClientCommandC2SPacket(GlobalPlayer var1, ClientCommandC2SPacket.Nested313 var2, String var3, String var4, int var5) {
      this(var1, var2, var3, var4, var5, "");
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field23834);
      var1.writeString(this.field23835.name());
      var1.writeString(this.field23836 == null ? "" : this.field23836);
      var1.writeString(this.field23837 == null ? "" : this.field23837);
      var1.writeInt(Math.max(1, this.field23838));
      var1.writeString(this.field23839 == null ? "" : this.field23839);
   }

   public String method10806() {
      return this.field23839;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public ClientCommandC2SPacket.Nested313 method10807() {
      return this.field23835;
   }

   // $VF: Compiled from s
   public enum Nested313 {
      REQUEST_USERS,
      CLOSE,
      NETWORK_STOP,
      MESSAGE,
      DROP_ALL,
      CURRENT_DROP,
      NEURO_UNFLAG,
      PROFILE,
      PROFILE_STOP;
   }

   @Override
   public ClientCommandC2SPacket method00210(VertexBufferData var1) {
      return this.method10804(var1);
   }
}
