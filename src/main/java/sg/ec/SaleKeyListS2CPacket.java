// Original binary: sg/ec/RrG85WEeS5sNcpx6
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class SaleKeyListS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, SaleKeyListS2CPacket> {
   public static final String field11699 = "saleKeyListS2C";
   private static final int field11700 = 0;
   private GlobalPlayer field11701;
   private String field11702 = "";
   private String field11703 = "";
   private List<SaleKeyListS2CPacket.Nested163> field11704 = List.of();
   private static final String field11705 = "saleKeyListS2C";

   public void method05364(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10038(this);
   }

   public List<SaleKeyListS2CPacket.Nested163> method05365() {
      return this.field11704;
   }

   public GlobalPlayer method05366() {
      return this.field11701;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field11701);
      var1.writeString(this.field11702 == null ? "" : this.field11702);
      var1.writeString(this.field11703 == null ? "" : this.field11703);
      List var2 = this.field11704 == null ? List.of() : this.field11704;
      var1.writeInt(var2.size());

      for (SaleKeyListS2CPacket.Nested163 var4 : (Iterable<SaleKeyListS2CPacket.Nested163>) (Iterable) var2) {
         var1.writeString(var4.key() == null ? "" : var4.key());
         var1.writeString(var4.holder() == null ? "" : var4.holder());
      }
   }

   public SaleKeyListS2CPacket method05367(VertexBufferData var1) {
      this.field11701 = var1.readPlayer();
      this.field11702 = var1.readString();
      this.field11703 = var1.readString();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      ArrayList var3 = new ArrayList(var2);

      for (int var4 = 0; var4 < var2; var4++) {
         var3.add(new SaleKeyListS2CPacket.Nested163(var1.readString(), var1.readString()));
      }

      this.field11704 = var3;
      return this;
   }

   public String method05368() {
      return this.field11703;
   }

   public String method05369() {
      return this.field11702;
   }

   @Override
   public String method00213() {
      return field11705;
   }

   // $VF: Compiled from s
   public record Nested163(String key, String holder) {
      public boolean redeemed() {
         return this.holder != null && !this.holder.isBlank();
      }
   }

   @Override
   public SaleKeyListS2CPacket method00210(VertexBufferData var1) {
      return this.method05367(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method05364(var1, var2);
   }
}
