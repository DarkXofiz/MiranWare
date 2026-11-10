// Original binary: sg/ec/ywVWQKxE64rxSAYp
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class MarketListS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, MarketListS2CPacket> {
   public static final String field27808 = "marketListS2C";
   private GlobalPlayer field27809;
   private List<MarketListS2CPacket.Nested327> field27810 = List.of();
   private static final String field27811 = "marketListS2C";

   public GlobalPlayer method11660() {
      return this.field27809;
   }

   public MarketListS2CPacket method11661(VertexBufferData var1) {
      this.field27809 = var1.readPlayer();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2; var4++) {
         String var5 = var1.readString();
         String var6 = var1.readString();
         String var7 = var1.readString();
         String var8 = var1.readString();
         String var9 = var1.readString();
         long var10 = var1.readLong();
         long var12 = var1.readLong();
         boolean var14 = var1.readBoolean();
         String var15 = var1.readString();
         long var16 = var1.readLong();
         var3.add(new MarketListS2CPacket.Nested327(var5, var6, var7, var8, var9, var10, var12, var14, var15, var16));
      }

      this.field27810 = var3;
      return this;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field27809);
      List var2 = this.field27810 == null ? List.of() : this.field27810;
      var1.writeInt(var2.size());

      for (MarketListS2CPacket.Nested327 var4 : (Iterable<MarketListS2CPacket.Nested327>) (Iterable) var2) {
         var1.writeString(var4.field27812() == null ? "" : var4.field27812());
         var1.writeString(var4.name() == null ? "" : var4.name());
         var1.writeString(var4.category() == null ? "" : var4.category());
         var1.writeString(var4.description() == null ? "" : var4.description());
         var1.writeString(var4.author() == null ? "" : var4.author());
         var1.writeLong(var4.size());
         var1.writeLong(var4.updatedAt());
         var1.writeBoolean(var4.noCopy());
         var1.writeString(var4.key() == null ? "" : var4.key());
         var1.writeLong(var4.redeemedAt());
      }
   }

   public List<MarketListS2CPacket.Nested327> method11662() {
      return this.field27810;
   }

   @Override
   public String method00213() {
      return field27811;
   }

   public void method11663(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10048(this);
   }

   // $VF: Compiled from s
   public record Nested327(
      String field27812,
      String name,
      String category,
      String description,
      String author,
      long size,
      long updatedAt,
      boolean noCopy,
      String key,
      long redeemedAt
   ) {
      public boolean activated() {
         return this.key != null && !this.key.isBlank();
      }
   }

   @Override
   public MarketListS2CPacket method00210(VertexBufferData var1) {
      return this.method11661(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method11663(var1, var2);
   }
}
