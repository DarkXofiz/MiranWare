// Original binary: sg/ec/AE52jXw17veeIFaW
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.java_websocket.WebSocket;

// $VF: Compiled from s
public class ChatS2CPacket implements GlobalPacket<AbstractGlobalPacketHandler, ChatS2CPacket> {
   public static final String field05989 = "chatC2SPacket";
   private GlobalPlayer field05990;
   private ChatMessageValidator field05991;
   private String field05992;
   private static final String field05993 = "UNKNOWN";
   private static final String field05994 = "chatC2SPacket";

   @Override
   public String method00213() {
      return field05994;
   }

   public GlobalPlayer method02479() {
      return this.field05990;
   }

   public void method02480(WebSocket var1, AbstractGlobalPacketHandler var2) {
      var2.method04354(this);
   }

   public ChatS2CPacket(GlobalPlayer var1, String var2) {
      this.field05990 = var1;
      this.field05992 = var2;
      this.field05991 = ChatMessageValidator.method08483().method08488(var2).method08484("").method08487("").method08486(ChatChannel.GLOBAL).method08489();
   }

   @Override
   public void method00209(VertexBufferData var1) {
      String var2 = this.field05990 != null ? this.field05990.method07586() : "";
      String var3 = this.field05990 != null ? this.field05990.method07580() : "";
      String var4 = this.field05990 != null ? this.field05990.method07590() : "";
      String var5 = this.field05990 != null ? this.field05990.method07584() : field05993;
      var1.writeString(var2);
      var1.writeString(var3);
      var1.writeString(var4);
      var1.writeString(var5);
      String var6 = this.method02486();
      var1.writeString(var6 == null ? "" : var6);
      if (this.field05991 == null) {
         var1.writeBoolean(false);
      } else {
         var1.writeBoolean(true);
         var1.writeString(method02490(this.field05991.method08480()));
         var1.writeString(method02490(this.field05991.method08478()));
         var1.writeString(this.method02491().name());
         var var7 = this.field05991.method08476();
         var1.writeInt(var7.size());

         for (String var9 : var7) {
            var1.writeString(var9);
         }

         var var11 = this.field05991.method08481();
         var1.writeInt(var11.size());

         for (var var10 : var11.entrySet()) {
            var1.writeString((String)var10.getKey());
            var1.writeString((String)var10.getValue());
         }
      }
   }

   public String method02481() {
      return this.field05991 != null ? this.field05991.method08478() : "";
   }

   public String method02482() {
      return this.field05992;
   }

   public static ChatS2CPacket.Nested67 method02483() {
      return new ChatS2CPacket.Nested67();
   }

   public Map<String, String> method02484() {
      return this.field05991 != null ? this.field05991.method08481() : Map.of();
   }

   public ChatS2CPacket(GlobalPlayer var1, ChatMessageValidator var2) {
      this.field05990 = var1;
      this.field05991 = var2;
      this.field05992 = var2 != null ? var2.method08479() : null;
   }

   public ChatS2CPacket() {
   }

   public List<String> method02485() {
      return this.field05991 != null ? this.field05991.method08476() : List.of();
   }

   public String method02486() {
      return this.field05991 != null ? this.field05991.method08479() : this.field05992;
   }

   public ChatS2CPacket method02487(VertexBufferData var1) {
      ChatS2CPacket var2 = new ChatS2CPacket();
      var2.field05990 = var1.readPlayer();
      var2.field05992 = var1.readString();
      var2.field05991 = ChatMessageValidator.method08483()
         .method08488(var2.field05992)
         .method08484("")
         .method08487("")
         .method08486(ChatChannel.GLOBAL)
         .method08489();
      if (var1.remaining() <= 0) {
         return var2;
      }

      boolean var3 = var1.readBoolean();
      if (!var3) {
         return var2;
      }

      try {
         String var4 = var1.readString();
         String var5 = var1.readString();
         ChatChannel var6 = ChatChannel.method02177(var1.readString());
         int var7 = var1.readInt();
         ArrayList var8 = new ArrayList();

         for (int var9 = 0; var9 < var7; var9++) {
            var8.add(var1.readString());
         }

         int var15 = var1.readInt();
         HashMap var10 = new HashMap();

         for (int var11 = 0; var11 < var15; var11++) {
            String var12 = var1.readString();
            String var13 = var1.readString();
            var10.put(var12, var13);
         }

         var2.field05991 = ChatMessageValidator.method08483()
            .method08488(var2.field05992)
            .method08484(var4)
            .method08487(var5)
            .method08486(var6)
            .method08485(var8)
            .method08494(var10)
            .method08489();
      } catch (Exception var14) {
      }

      return var2;
   }

   public ChatMessageValidator method02488() {
      return this.field05991;
   }

   public String method02489() {
      return this.field05991 != null ? this.field05991.method08480() : "";
   }

   private static String method02490(String var0) {
      return var0 == null ? "" : var0;
   }

   public ChatChannel method02491() {
      return this.field05991 != null && this.field05991.method08482() != null ? this.field05991.method08482() : ChatChannel.GLOBAL;
   }

   // $VF: Compiled from s
   public static final class Nested67 {
      private GlobalPlayer field05995;
      private String field05996;
      private String field05997;
      private String field05998;
      private ChatChannel field05999;
      private List<String> field06000;
      private Map<String, String> field06001;

      public ChatS2CPacket.Nested67 method02492(List<String> var1) {
         this.field06000 = var1;
         return this;
      }

      public ChatS2CPacket.Nested67 method02493(String var1) {
         this.field05998 = var1;
         return this;
      }

      public ChatS2CPacket.Nested67 method02494(String var1) {
         this.field05997 = var1;
         return this;
      }

      public ChatS2CPacket method02495() {
         ChatMessageValidator var1 = ChatMessageValidator.method08483()
            .method08488(this.field05996)
            .method08484(this.field05997)
            .method08487(this.field05998)
            .method08486(this.field05999)
            .method08485(this.field06000)
            .method08494(this.field06001)
            .method08489();
         return new ChatS2CPacket(this.field05995, var1);
      }

      public ChatS2CPacket.Nested67 method02496(Map<String, String> var1) {
         this.field06001 = var1;
         return this;
      }

      public ChatS2CPacket.Nested67 method02497(ChatChannel var1) {
         this.field05999 = var1;
         return this;
      }

      public ChatS2CPacket.Nested67 method02498(String var1) {
         this.field05996 = var1;
         return this;
      }

      public ChatS2CPacket.Nested67 method02499(GlobalPlayer var1) {
         this.field05995 = var1;
         return this;
      }
   }

   @Override
   public ChatS2CPacket method00210(VertexBufferData var1) {
      return this.method02487(var1);
   }

   @Override
   public void method00212(WebSocket var1, AbstractGlobalPacketHandler var2) {
      this.method02480(var1, var2);
   }
}
