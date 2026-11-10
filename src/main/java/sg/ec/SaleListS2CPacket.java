// Original binary: sg/ec/JkRO2qTPAuYlb730
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class SaleListS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, SaleListS2CPacket> {
   public static final String field09294 = "saleListS2C";
   private static final int field09295 = 0;
   private GlobalPlayer field09296;
   private List<SaleListS2CPacket.Nested122> field09297 = List.of();
   private static final String field09298 = "saleListS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field09296);
      List var2 = this.field09297 == null ? List.of() : this.field09297;
      var1.writeInt(var2.size());

      for (SaleListS2CPacket.Nested122 var4 : (Iterable<SaleListS2CPacket.Nested122>) (Iterable) var2) {
         var1.writeString(var4.field09299() == null ? "" : var4.field09299());
         var1.writeString(var4.config() == null ? "" : var4.config());
         var1.writeLong(var4.created());
         var1.writeLong(var4.updated());
         var1.writeInt(var4.active());
         var1.writeInt(var4.total());
         List var5 = var4.buyers() == null ? List.of() : var4.buyers();
         int var6 = Math.min(var5.size(), 500);
         var1.writeInt(var6);

         for (int var7 = 0; var7 < var6; var7++) {
            var1.writeString((String)var5.get(var7));
         }
      }
   }

   public List<SaleListS2CPacket.Nested122> method04095() {
      return this.field09297;
   }

   public void method04096(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10040(this);
   }

   public SaleListS2CPacket method04097(VertexBufferData var1) {
      this.field09296 = var1.readPlayer();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      ArrayList<SaleListS2CPacket.Nested122> var3 = new ArrayList<>();

      for (int var4 = 0; var4 < var2; var4++) {
         String var5 = var1.readString();
         String var6 = var1.readString();
         long var7 = var1.readLong();
         long var9 = var1.readLong();
         int var11 = var1.readInt();
         int var12 = var1.readInt();
         int var13 = var1.readInt();
         if (var13 < 0 || var13 > 500) {
            var13 = 0;
         }

         ArrayList var14 = new ArrayList(var13);

         for (int var15 = 0; var15 < var13; var15++) {
            var14.add(var1.readString());
         }

         var3.add(new SaleListS2CPacket.Nested122(var5, var6, var7, var9, var11, var12, var14));
      }

      this.field09297 = var3;
      return this;
   }

   @Override
   public String method00213() {
      return field09298;
   }

   public GlobalPlayer method04098() {
      return this.field09296;
   }

   // $VF: Compiled from s
   public record Nested122(String field09299, String config, long created, long updated, int active, int total, List<String> buyers) {
   }

   @Override
   public SaleListS2CPacket method00210(VertexBufferData var1) {
      return this.method04097(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method04096(var1, var2);
   }
}
