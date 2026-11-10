// Original binary: sg/ec/gnB9yMiw71OCrMwP
package sg.ec;

import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class PrefixC2SPacket implements GlobalPacket<GlobalPacketHandler, PrefixC2SPacket> {
   public static final String field19616 = "prefixC2S";
   private GlobalPlayer field19617;
   private PrefixC2SPacket.Nested238 field19618;
   private String field19619;
   private UserRole field19620;
   private String field19621;
   private String field19622;
   private static final String field19623 = "prefixC2S";

   @Override
   public String method00213() {
      return field19623;
   }

   public PrefixC2SPacket() {
      this.field19618 = PrefixC2SPacket.Nested238.LIST;
      this.field19619 = "";
      this.field19620 = UserRole.USER;
      this.field19621 = "";
      this.field19622 = "";
   }

   @Override
   public void method00212(WebSocket var1, GlobalPacketHandler var2) {
   }

   public PrefixC2SPacket(GlobalPlayer var1, PrefixC2SPacket.Nested238 var2, String var3, UserRole var4, String var5, String var6) {
      this.field19617 = var1;
      this.field19618 = var2 == null ? PrefixC2SPacket.Nested238.LIST : var2;
      this.field19619 = var3 == null ? "" : var3;
      this.field19620 = var4 == null ? UserRole.USER : var4;
      this.field19621 = var5 == null ? "" : var5;
      this.field19622 = var6 == null ? "" : var6;
   }

   public PrefixC2SPacket method08528(VertexBufferData var1) {
      this.field19617 = var1.readPlayer();
      this.field19618 = PrefixC2SPacket.Nested238.method08535(var1.readString());
      this.field19619 = var1.readString();
      this.field19620 = UserRole.method08587(var1.readString());
      this.field19621 = var1.readString();
      this.field19622 = var1.remaining() > 0 ? var1.readString() : "";
      return this;
   }

   @Override
   public void method00209(VertexBufferData var1) {
      var1.writePlayer(this.field19617);
      var1.writeString(this.field19618.name());
      var1.writeString(this.field19619 == null ? "" : this.field19619);
      var1.writeString(this.field19620 == null ? UserRole.USER.name() : this.field19620.name());
      var1.writeString(this.field19621 == null ? "" : this.field19621);
      var1.writeString(this.field19622 == null ? "" : this.field19622);
   }

   public UserRole method08529() {
      return this.field19620;
   }

   public String method08530() {
      return this.field19621;
   }

   public PrefixC2SPacket.Nested238 method08531() {
      return this.field19618;
   }

   public GlobalPlayer method08532() {
      return this.field19617;
   }

   public String method08533() {
      return this.field19619;
   }

   public String method08534() {
      return this.field19622;
   }

   // $VF: Compiled from s
   public enum Nested238 {
      LIST,
      CREATE,
      EDIT,
      DELETE,
      SELECT,
      CLEAR,
      ASSIGN;

      public static PrefixC2SPacket.Nested238 method08535(String var0) {
         if (var0 == null) {
            return LIST;
         }

         try {
            return valueOf(var0.trim().toUpperCase());
         } catch (IllegalArgumentException var2) {
            return LIST;
         }
      }
   }

   @Override
   public PrefixC2SPacket method00210(VertexBufferData var1) {
      return this.method08528(var1);
   }
}
