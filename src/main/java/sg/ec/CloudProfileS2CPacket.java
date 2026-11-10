// Original binary: sg/ec/526wjSzT0J85I5GF
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class CloudProfileS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, CloudProfileS2CPacket> {
   public static final String field02086 = "cloudProfileS2C";
   private GlobalPlayer field02087;
   private List<StoredContent> field02088;
   private static final String field02089 = "cloudProfileS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field02087);
      List var2 = this.field02088 == null ? List.of() : this.field02088;
      var1.writeInt(var2.size());

      for (StoredContent sx : (Iterable<StoredContent>) (Iterable) var2) {
         var1.writeString(sx.category().method00552());
         var1.writeString(sx.name());
         var1.writeBytes(sx.content());
      }
   }

   public List<StoredContent> method00904() {
      return this.field02088;
   }

   public GlobalPlayer method00905() {
      return this.field02087;
   }

   @Override
   public String method00213() {
      return field02089;
   }

   public CloudProfileS2CPacket method00906(VertexBufferData var1) {
      CloudProfileS2CPacket var2 = new CloudProfileS2CPacket();
      var2.field02087 = var1.readPlayer();
      int var3 = var1.readInt();
      if (var3 < 0 || var3 > 4096) {
         var3 = 0;
      }

      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < var3; var5++) {
         StorageCategory var6 = StorageCategory.method00554(var1.readString());
         String var7 = var1.readString();
         byte[] var8 = var1.readBytes();
         if (var6 != null) {
            var4.add(new StoredContent(var6, var7, var8));
         }
      }

      var2.field02088 = var4;
      return var2;
   }

   public void method00907(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10042(this);
   }

   public CloudProfileS2CPacket() {
      this.field02088 = List.of();
   }

   public CloudProfileS2CPacket(GlobalPlayer var1, List<StoredContent> var2) {
      this.field02087 = var1;
      this.field02088 = var2 == null ? List.of() : new ArrayList<>(var2);
   }

   @Override
   public CloudProfileS2CPacket method00210(VertexBufferData var1) {
      return this.method00906(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method00907(var1, var2);
   }
}
