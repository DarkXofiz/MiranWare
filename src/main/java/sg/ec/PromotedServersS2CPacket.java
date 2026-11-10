// Original binary: sg/ec/ZYvNRDyLCcYCraKx
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PromotedServersS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, PromotedServersS2CPacket> {
   public static final String field15566 = "promotedServersS2C";
   private GlobalPlayer field15567;
   private List<PromotedServer> field15568 = List.of();
   private static final String field15569 = "promotedServersS2C";

   public void method06896(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10039(this);
   }

   public GlobalPlayer method06897() {
      return this.field15567;
   }

   @Override
   public String method00213() {
      return field15569;
   }

   public PromotedServersS2CPacket method06898(VertexBufferData var1) {
      this.field15567 = var1.readPlayer();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 64) {
         var2 = 0;
      }

      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2; var4++) {
         String var5 = var1.readString();
         String var6 = var1.readString();
         int var7 = var1.readInt();
         String var8 = var1.readString();
         long var9 = var1.readLong();
         var3.add(new PromotedServer(var5, var6, var7, var8, var9));
      }

      this.field15568 = var3;
      return this;
   }

   public List<PromotedServer> method06899() {
      return this.field15568;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field15567);
      List var2 = this.field15568 == null ? List.of() : this.field15568;
      var1.writeInt(var2.size());

      for (PromotedServer var4 : (Iterable<PromotedServer>) (Iterable) var2) {
         var1.writeString(var4.name() == null ? "" : var4.name());
         var1.writeString(var4.field20793() == null ? "" : var4.field20793());
         var1.writeInt(var4.color());
         var1.writeString(var4.category() == null ? "" : var4.category());
         var1.writeLong(var4.expiresAt());
      }
   }

   @Override
   public PromotedServersS2CPacket method00210(VertexBufferData var1) {
      return this.method06898(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method06896(var1, var2);
   }
}
