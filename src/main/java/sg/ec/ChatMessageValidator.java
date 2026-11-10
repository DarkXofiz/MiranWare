// Original binary: sg/ec/gZPegpkLIEo9tOU8
package sg.ec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// $VF: Compiled from s
public final class ChatMessageValidator {
   public static final int field19569 = 2048;
   public static final int field19570 = 0;
   public static final int field19571 = 0;
   public static final int field19572 = 0;
   private final String field19573;
   private final String field19574;
   private final String field19575;
   private final ChatChannel field19576;
   private final List<String> field19577;
   private final Map<String, String> field19578;

   public List<String> method08476() {
      return this.field19577;
   }

   public boolean method08477() {
      return this.field19573 != null && !this.field19573.trim().isEmpty();
   }

   public String method08478() {
      return this.field19575;
   }

   private ChatMessageValidator(ChatMessageValidator.Nested235 var1) {
      this.field19573 = var1.field19579;
      this.field19574 = var1.field19580;
      this.field19575 = var1.field19581;
      this.field19576 = var1.field19582;
      this.field19577 = var1.field19583;
      this.field19578 = var1.field19584;
   }

   public String method08479() {
      return this.field19573;
   }

   public String method08480() {
      return this.field19574;
   }

   public Map<String, String> method08481() {
      return this.field19578;
   }

   public ChatChannel method08482() {
      return this.field19576;
   }

   public static ChatMessageValidator.Nested235 method08483() {
      return new ChatMessageValidator.Nested235();
   }

   // $VF: Compiled from s
   public static final class Nested235 {
      private String field19579;
      private String field19580;
      private String field19581;
      private ChatChannel field19582;
      private List<String> field19583 = Collections.emptyList();
      private Map<String, String> field19584 = Collections.emptyMap();
      private boolean field19585;
      private boolean field19586;
      private static final String field19587 = "Chat message is empty";

      public ChatMessageValidator.Nested235 method08484(String var1) {
         this.field19580 = var1;
         this.field19585 = true;
         return this;
      }

      public ChatMessageValidator.Nested235 method08485(List<String> var1) {
         this.field19583 = var1;
         return this;
      }

      public ChatMessageValidator.Nested235 method08486(ChatChannel var1) {
         this.field19582 = var1;
         return this;
      }

      public ChatMessageValidator.Nested235 method08487(String var1) {
         this.field19581 = var1;
         this.field19586 = true;
         return this;
      }

      public ChatMessageValidator.Nested235 method08488(String var1) {
         this.field19579 = var1;
         return this;
      }

      public ChatMessageValidator method08489() {
         ChatChannel var1 = this.field19582 != null ? this.field19582 : ChatChannel.GLOBAL;
         String var2 = method08492(this.field19579);
         if (var2 != null && !var2.trim().isEmpty()) {
            String var3 = this.field19585 ? method08491(this.field19580) : ChatChannelFormatter.method11201(var1);
            String var4 = this.field19586 ? method08490(this.field19581) : ChatChannelFormatter.method11202(var1);
            var var5 = method08493(this.field19583);
            var var6 = method08495(this.field19584);
            ChatMessageValidator.Nested235 var7 = new ChatMessageValidator.Nested235();
            var7.field19579 = var2;
            var7.field19580 = var3;
            var7.field19581 = var4;
            var7.field19582 = var1;
            var7.field19583 = var5;
            var7.field19584 = var6;
            var7.field19585 = true;
            var7.field19586 = true;
            return new ChatMessageValidator(var7);
         } else {
            throw new IllegalArgumentException(field19587);
         }
      }

      private static String method08490(String var0) {
         if (var0 == null) {
            return "";
         }

         String var1 = ChatChannelFormatter.method11200(var0);
         if (var1.length() > 32) {
            var1 = var1.substring(0, 32);
         }

         return var1;
      }

      private static String method08491(String var0) {
         if (var0 == null) {
            return "";
         }

         String var1 = var0.trim();
         if (var1.length() > 512) {
            var1 = var1.substring(0, 512);
         }

         return var1;
      }

      private static String method08492(String var0) {
         if (var0 == null) {
            return null;
         }

         String var1 = var0.trim();
         if (var1.length() > 2048) {
            var1 = var1.substring(0, 2048);
         }

         return var1;
      }

      private static List<String> method08493(List<String> var0) {
         if (var0 != null && !var0.isEmpty()) {
            ArrayList var1 = new ArrayList();

            for (String var3 : var0) {
               if (var3 != null) {
                  String var4 = var3.trim();
                  if (!var4.isEmpty()) {
                     var1.add(var4);
                  }
               }
            }

            return Collections.unmodifiableList(var1);
         } else {
            return Collections.emptyList();
         }
      }

      public ChatMessageValidator.Nested235 method08494(Map<String, String> var1) {
         this.field19584 = var1;
         return this;
      }

      private static Map<String, String> method08495(Map<String, String> var0) {
         if (var0 != null && !var0.isEmpty()) {
            LinkedHashMap var1 = new LinkedHashMap();
            int var2 = 0;

            for (var var4 : var0.entrySet()) {
               if (var2 >= 32) {
                  break;
               }

               String var5 = (String)var4.getKey();
               if (var5 != null && !var5.trim().isEmpty()) {
                  String var6 = var4.getValue() == null ? "" : ((String)var4.getValue()).trim();
                  var1.put(var5.trim(), var6);
                  var2++;
               }
            }

            return Collections.unmodifiableMap(var1);
         } else {
            return Collections.emptyMap();
         }
      }
   }
}
