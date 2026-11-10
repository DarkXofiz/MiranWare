// Original binary: sg/ec/RAYOmNdEOpvxq0I9
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class MarketC2SPacket implements GlobalPacket<GlobalPacketHandler, MarketC2SPacket> {
   public static final String field11390 = "marketC2S";
   private static final byte[] field11391 = new byte[0];
   private GlobalPlayer field11392;
   private MarketC2SPacket.Nested158 field11393;
   private String field11394;
   private int field11395;
   private byte[] field11396;
   private static final String field11397 = "marketC2S";

   public GlobalPlayer method05261() {
      return this.field11392;
   }

   public MarketC2SPacket(GlobalPlayer var1, MarketC2SPacket.Nested158 var2, String var3) {
      this(var1, var2, var3, 0, field11391);
   }

   public byte[] method05262() {
      return this.field11396;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field11392);
      var1.writeString(this.field11393.name());
      var1.writeString(this.field11394 == null ? "" : this.field11394);
      var1.writeInt(this.field11395);
      var1.writeBytes(this.field11396 == null ? field11391 : this.field11396);
   }

   public int method05263() {
      return this.field11395;
   }

   public String method05264() {
      return this.field11394;
   }

   public MarketC2SPacket() {
      this.field11393 = MarketC2SPacket.Nested158.LIST;
      this.field11394 = "";
      this.field11396 = field11391;
   }

   public MarketC2SPacket method05265(VertexBufferData var1) {
      this.field11392 = var1.readPlayer();
      this.field11393 = MarketC2SPacket.Nested158.method05267(var1.readString());
      this.field11394 = var1.readString();
      this.field11395 = var1.readInt();
      this.field11396 = var1.readBytes();
      return this;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public MarketC2SPacket.Nested158 method05266() {
      return this.field11393;
   }

   public MarketC2SPacket(GlobalPlayer var1, MarketC2SPacket.Nested158 var2, String var3, int var4, byte[] var5) {
      this.field11392 = var1;
      this.field11393 = var2 == null ? MarketC2SPacket.Nested158.LIST : var2;
      this.field11394 = var3 == null ? "" : var3;
      this.field11395 = var4;
      this.field11396 = var5 == null ? field11391 : var5;
   }

   @Override
   public String method00213() {
      return field11397;
   }

   // $VF: Compiled from s
   public enum Nested158 {
      LIST,
      DOWNLOAD,
      SELL_LIST,
      SELL_CREATE,
      SELL_UPDATE,
      SELL_DELETE,
      SELL_KEYS,
      REDEEM,
      SELL_KEY_LIST,
      SELL_REVOKE;

      public static MarketC2SPacket.Nested158 method05267(String var0) {
         if (var0 != null) {
            for (MarketC2SPacket.Nested158 var4 : values()) {
               if (var4.name().equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return LIST;
      }
   }

   @Override
   public MarketC2SPacket method00210(VertexBufferData var1) {
      return this.method05265(var1);
   }
}
