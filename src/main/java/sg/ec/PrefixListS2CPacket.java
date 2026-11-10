// Original binary: sg/ec/Rsw5u32z2XabuiJk
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PrefixListS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, PrefixListS2CPacket> {
   public static final String field11714 = "prefixListS2C";
   private GlobalPlayer field11715;
   private List<PrefixEntry> field11716 = List.of();
   private String field11717 = "";
   private static final String field11718 = "prefixListS2C";

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field11715);
      List var2 = this.field11716 == null ? List.of() : this.field11716;
      var1.writeInt(var2.size());

      for (PrefixEntry sx : (Iterable<PrefixEntry>) (Iterable) var2) {
         var1.writeString(sx.name() == null ? "" : sx.name());
         var1.writeString(sx.role() == null ? UserRole.USER.name() : sx.role().name());
         var1.writeString(sx.value() == null ? "" : sx.value());
      }

      var1.writeString(this.field11717 == null ? "" : this.field11717);
   }

   public List<PrefixEntry> method05386() {
      return this.field11716;
   }

   public GlobalPlayer method05387() {
      return this.field11715;
   }

   @Override
   public String method00213() {
      return field11718;
   }

   public PrefixListS2CPacket method05388(VertexBufferData var1) {
      this.field11715 = var1.readPlayer();
      int var2 = var1.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      ArrayList var3 = new ArrayList();

      for (int var4 = 0; var4 < var2; var4++) {
         String var5 = var1.readString();
         UserRole var6 = UserRole.method08587(var1.readString());
         String var7 = var1.readString();
         var3.add(new PrefixEntry(var5, var6, var7));
      }

      this.field11716 = var3;
      this.field11717 = var1.remaining() > 0 ? var1.readString() : "";
      return this;
   }

   public String method05389() {
      return this.field11717;
   }

   public void method05390(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10043(this);
   }

   @Override
   public PrefixListS2CPacket method00210(VertexBufferData var1) {
      return this.method05388(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method05390(var1, var2);
   }
}
