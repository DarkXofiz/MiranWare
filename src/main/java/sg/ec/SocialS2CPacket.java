// Original binary: sg/ec/8xxEkVU7G7BzRW6W
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class SocialS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, SocialS2CPacket> {
   public static final String field05105 = "socialS2C";
   private GlobalPlayer field05106;
   private String field05107 = "";
   private List<SocialS2CPacket.Nested57> field05108 = new ArrayList<>();
   private List<SocialS2CPacket.Nested57> field05109 = new ArrayList<>();
   private List<SocialS2CPacket.Nested57> field05110 = new ArrayList<>();
   private String field05111 = "";
   private String field05112 = "";
   private String field05113 = "";
   private String field05114 = "";
   private static final String field05115 = "friends";
   private static final String field05116 = "pending";
   private static final String field05117 = "friends";
   private static final String field05118 = "pending";
   private static final String field05119 = "socialS2C";

   public String method02138() {
      return this.field05113;
   }

   public String method02139() {
      return this.field05114;
   }

   public List<SocialS2CPacket.Nested57> method02140() {
      return this.field05109;
   }

   public List<SocialS2CPacket.Nested57> method02141() {
      return this.field05108;
   }

   public void method02142(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method10046(this);
   }

   public String method02143() {
      return this.field05112;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field05106);
      var1.writeString(this.field05107 == null ? "" : this.field05107);
      if (field05117.equals(this.field05107)) {
         method02147(var1, this.field05108);
      } else if (field05118.equals(this.field05107)) {
         method02147(var1, this.field05109);
         method02147(var1, this.field05110);
      } else {
         var1.writeString(this.field05111 == null ? "" : this.field05111);
         var1.writeString(this.field05112 == null ? "" : this.field05112);
         var1.writeString(this.field05113 == null ? "" : this.field05113);
         var1.writeString(this.field05114 == null ? "" : this.field05114);
      }
   }

   public GlobalPlayer method02144() {
      return this.field05106;
   }

   public String method02145() {
      return this.field05107;
   }

   public SocialS2CPacket method02146(VertexBufferData var1) {
      this.field05106 = var1.readPlayer();
      this.field05107 = var1.readString();
      this.field05108 = new ArrayList<>();
      this.field05109 = new ArrayList<>();
      this.field05110 = new ArrayList<>();
      if (field05115.equals(this.field05107)) {
         method02149(var1, this.field05108);
      } else if (field05116.equals(this.field05107)) {
         method02149(var1, this.field05109);
         method02149(var1, this.field05110);
      } else {
         this.field05111 = var1.readString();
         this.field05112 = var1.readString();
         this.field05113 = var1.readString();
         this.field05114 = var1.readString();
      }

      return this;
   }

   private static void method02147(VertexBufferData var0, List<SocialS2CPacket.Nested57> var1) {
      List var2 = var1 != null ? var1 : List.of();
      var0.writeInt(var2.size());

      for (SocialS2CPacket.Nested57 var4 : (Iterable<SocialS2CPacket.Nested57>) (Iterable) var2) {
         var0.writeString(var4.username() == null ? "" : var4.username());
         var0.writeBoolean(var4.online());
         var0.writeString(var4.server() == null ? "" : var4.server());
         var0.writeString(var4.status() == null ? "" : var4.status());
      }
   }

   public String method02148() {
      return this.field05111;
   }

   @Override
   public String method00213() {
      return field05119;
   }

   private static void method02149(VertexBufferData var0, List<SocialS2CPacket.Nested57> var1) {
      int var2 = var0.readInt();
      if (var2 < 0 || var2 > 4096) {
         var2 = 0;
      }

      for (int var3 = 0; var3 < var2; var3++) {
         String var4 = var0.readString();
         boolean var5 = var0.readBoolean();
         String var6 = var0.readString();
         String var7 = var0.readString();
         var1.add(new SocialS2CPacket.Nested57(var4, var5, var6, var7));
      }
   }

   public List<SocialS2CPacket.Nested57> method02150() {
      return this.field05110;
   }

   // $VF: Compiled from s
   public record Nested57(String username, boolean online, String server, String status) {
   }

   @Override
   public SocialS2CPacket method00210(VertexBufferData var1) {
      return this.method02146(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method02142(var1, var2);
   }
}
