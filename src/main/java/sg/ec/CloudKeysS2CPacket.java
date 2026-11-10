// Original binary: sg/ec/FtWJJIoElnN02h7C
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class CloudKeysS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, CloudKeysS2CPacket> {
   public static final String field07708 = "cloudKeysS2C";
   private GlobalPlayer field07709;
   private List<ConfigShareRequest> field07710;
   private static final String field07711 = "cloudKeysS2C";

   @Override
   public String method00213() {
      return field07711;
   }

   public CloudKeysS2CPacket() {
      this.field07710 = List.of();
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field07709);
      List var2 = this.field07710 == null ? List.of() : this.field07710;
      var1.writeInt(var2.size());

      for (ConfigShareRequest var4 : (Iterable<ConfigShareRequest>) (Iterable) var2) {
         var1.writeString(var4.key());
         var1.writeString(var4.config());
         var1.writeString(var4.target());
         var1.writeBoolean(var4.noShare());
      }
   }

   public CloudKeysS2CPacket method03456(VertexBufferData var1) {
      CloudKeysS2CPacket var2 = new CloudKeysS2CPacket();
      var2.field07709 = var1.readPlayer();
      int var3 = var1.readInt();
      if (var3 < 0 || var3 > 4096) {
         var3 = 0;
      }

      ArrayList var4 = new ArrayList();

      for (int var5 = 0; var5 < var3; var5++) {
         String var6 = var1.readString();
         String var7 = var1.readString();
         String var8 = var1.readString();
         boolean var9 = var1.readBoolean();
         var4.add(new ConfigShareRequest(var6, var7, var8, var9));
      }

      var2.field07710 = var4;
      return var2;
   }

   public void method03457(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10041(this);
   }

   public CloudKeysS2CPacket(GlobalPlayer var1, List<ConfigShareRequest> var2) {
      this.field07709 = var1;
      this.field07710 = var2 == null ? List.of() : new ArrayList<>(var2);
   }

   public GlobalPlayer method03458() {
      return this.field07709;
   }

   public List<ConfigShareRequest> method03459() {
      return this.field07710;
   }

   @Override
   public CloudKeysS2CPacket method00210(VertexBufferData var1) {
      return this.method03456(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method03457(var1, var2);
   }
}
