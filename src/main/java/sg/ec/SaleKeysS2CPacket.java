// Original binary: sg/ec/e9iKVrFbmEctQSSv
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class SaleKeysS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, SaleKeysS2CPacket> {
   public static final String field18511 = "saleKeysS2C";
   private GlobalPlayer field18512;
   private String field18513 = "";
   private String field18514 = "";
   private List<String> field18515 = List.of();
   private static final String field18516 = "saleKeysS2C";

   public GlobalPlayer method07621() {
      return this.field18512;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field18512);
      var1.writeString(this.field18513 == null ? "" : this.field18513);
      var1.writeString(this.field18514 == null ? "" : this.field18514);
      List var2 = this.field18515 == null ? List.of() : this.field18515;
      var1.writeInt(var2.size());

      for (String var4 : (Iterable<String>) (Iterable) var2) {
         var1.writeString(var4 == null ? "" : var4);
      }
   }

   @Override
   public String method00213() {
      return field18516;
   }

   public List<String> method07622() {
      return this.field18515;
   }

   public void method07623(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10049(this);
   }

   public SaleKeysS2CPacket method07624(VertexBufferData var1) {
      this.field18512 = var1.readPlayer();
      this.field18513 = var1.readString();
      this.field18514 = var1.readString();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2; var4++) {
         var3.add(var1.readString());
      }

      this.field18515 = var3;
      return this;
   }

   public String method07625() {
      return this.field18513;
   }

   public String method07626() {
      return this.field18514;
   }

   @Override
   public SaleKeysS2CPacket method00210(VertexBufferData var1) {
      return this.method07624(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method07623(var1, var2);
   }
}
