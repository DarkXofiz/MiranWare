// Original binary: sg/ec/YLaecbSjNuhwxW0w
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class CloudListS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, CloudListS2CPacket> {
   public static final String field14726 = "cloudListS2C";
   private GlobalPlayer field14727;
   private List<StoredContentInfo> field14728;
   private boolean field14729;
   private static final String field14730 = "cloudListS2C";

   @Override
   public String method00213() {
      return field14730;
   }

   public List<StoredContentInfo> method06528() {
      return this.field14728;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field14727);
      var1.writeInt(this.field14729 ? 1 : 0);
      List var2 = this.field14728 == null ? List.of() : this.field14728;
      var1.writeInt(var2.size());

      for (StoredContentInfo var4 : (Iterable<StoredContentInfo>) (Iterable) var2) {
         var1.writeString(var4.category().method00552());
         var1.writeString(var4.name());
         var1.writeLong(var4.size());
         var1.writeLong(var4.modified());
      }

      for (StoredContentInfo var6 : (Iterable<StoredContentInfo>) (Iterable) var2) {
         var1.writeBoolean(var6.locked());
      }
   }

   public GlobalPlayer method06529() {
      return this.field14727;
   }

   public CloudListS2CPacket() {
      this.field14728 = List.of();
   }

   public boolean method06530() {
      return this.field14729;
   }

   public CloudListS2CPacket method06531(VertexBufferData var1) {
      CloudListS2CPacket var2 = new CloudListS2CPacket();
      var2.field14727 = var1.readPlayer();
      var2.field14729 = var1.readInt() != 0;
      int var3 = var1.readInt();
      if (var3 < 0 || var3 > 4096) {
         var3 = 0;
      }

      ArrayList var4 = new ArrayList();
      StorageCategory[] var5 = new StorageCategory[var3];
      String[] var6 = new String[var3];
      long[] var7 = new long[var3];
      long[] var8 = new long[var3];

      for (int var9 = 0; var9 < var3; var9++) {
         var5[var9] = StorageCategory.method00554(var1.readString());
         var6[var9] = var1.readString();
         var7[var9] = var1.readLong();
         var8[var9] = var1.readLong();
      }

      boolean[] var11 = new boolean[var3];

      for (int var10 = 0; var10 < var3; var10++) {
         if (var1.remaining() > 0) {
            var11[var10] = var1.readBoolean();
         }
      }

      for (int var12 = 0; var12 < var3; var12++) {
         if (var5[var12] != null) {
            var4.add(new StoredContentInfo(var5[var12], var6[var12], var7[var12], var8[var12], var11[var12]));
         }
      }

      var2.field14728 = var4;
      return var2;
   }

   public void method06532(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10053(this);
   }

   public CloudListS2CPacket(GlobalPlayer var1, List<StoredContentInfo> var2) {
      this.field14727 = var1;
      this.field14728 = var2 == null ? List.of() : new ArrayList<>(var2);
   }

   @Override
   public CloudListS2CPacket method00210(VertexBufferData var1) {
      return this.method06531(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method06532(var1, var2);
   }
}
