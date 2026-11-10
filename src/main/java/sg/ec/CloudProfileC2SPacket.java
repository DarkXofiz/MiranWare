// Original binary: sg/ec/eEZArlWCRn5mQ9LX
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class CloudProfileC2SPacket implements GlobalPacket<GlobalPacketHandler, CloudProfileC2SPacket> {
   public static final String field18517 = "cloudProfileC2S";
   private GlobalPlayer field18518;
   private List<StoredContent> field18519;
   private static final String field18520 = "cloudProfileC2S";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field18518);
      List var2 = this.field18519 == null ? List.of() : this.field18519;
      var1.writeInt(var2.size());

      for (StoredContent sx : (Iterable<StoredContent>) (Iterable) var2) {
         var1.writeString(sx.category().method00552());
         var1.writeString(sx.name());
         var1.writeBytes(sx.content());
      }
   }

   public CloudProfileC2SPacket() {
      this.field18519 = List.of();
   }

   public GlobalPlayer method07627() {
      return this.field18518;
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public List<StoredContent> method07628() {
      return this.field18519;
   }

   public CloudProfileC2SPacket(GlobalPlayer var1, List<StoredContent> var2) {
      this.field18518 = var1;
      this.field18519 = var2 == null ? List.of() : new ArrayList<>(var2);
   }

   @Override
   public String method00213() {
      return field18520;
   }

   public CloudProfileC2SPacket method07629(VertexBufferData var1) {
      this.field18518 = var1.readPlayer();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2; var4++) {
         StorageCategory var5 = StorageCategory.method00554(var1.readString());
         String var6 = var1.readString();
         byte[] var7 = var1.readBytes();
         if (var5 != null) {
            var3.add(new StoredContent(var5, var6, var7));
         }
      }

      this.field18519 = var3;
      return this;
   }

   @Override
   public CloudProfileC2SPacket method00210(VertexBufferData var1) {
      return this.method07629(var1);
   }
}
