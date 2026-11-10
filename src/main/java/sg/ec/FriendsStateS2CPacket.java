// Original binary: sg/ec/ftGbgfc8MzVsdMoM
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class FriendsStateS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, FriendsStateS2CPacket> {
   public static final String field19181 = "friendsStateS2C";
   private GlobalPlayer field19182;
   private List<String> field19183;
   private static final String field19184 = "friendsStateS2C";

   @Override
   public String method00213() {
      return field19184;
   }

   private List<String> method08340(VertexBufferData var1) {
      int var2 = var1.readInt();
      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2; var4++) {
         var3.add(var1.readString());
      }

      return var3;
   }

   private void method08341(VertexBufferData var1, List<String> var2) {
      List var3 = var2 != null ? var2 : List.of();
      var1.writeInt(var3.size());

      for (String var5 : (Iterable<String>) (Iterable) var3) {
         var1.writeString(var5 == null ? "" : var5);
      }
   }

   public List<String> method08342() {
      return this.field19183;
   }

   public GlobalPlayer method08343() {
      return this.field19182;
   }

   public void method08344(WebSocket var1, AbstractGlobalPacketHandler var2) {
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field19182);
      this.method08341(var1, this.field19183);
   }

   public FriendsStateS2CPacket method08345(VertexBufferData var1) {
      FriendsStateS2CPacket var2 = new FriendsStateS2CPacket();
      var2.field19182 = var1.readPlayer();
      var2.field19183 = this.method08340(var1);
      return var2;
   }

   public FriendsStateS2CPacket(GlobalPlayer var1, List<String> var2) {
      this.field19182 = var1;
      this.field19183 = var2 != null ? new ArrayList<>(var2) : new ArrayList<>();
   }

   public FriendsStateS2CPacket() {
   }

   @Override
   public FriendsStateS2CPacket method00210(VertexBufferData var1) {
      return this.method08345(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method08344(var1, var2);
   }
}
