// Original binary: sg/ec/FymtI6xGdaqk3OnU
package sg.ec;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

// $VF: Compiled from s
public final class StreamerNameUtils implements MinecraftAccess {
   public static final String field07811 = "Protected";
   private static final StreamerNameUtils.Nested101[] field07812 = new StreamerNameUtils.Nested101[0];
   private static final Comparator<StreamerNameUtils.Nested101> field07813 = Comparator.<StreamerNameUtils.Nested101>comparingInt(
         var0 -> -var0.source().length()
      )
      .thenComparing(StreamerNameUtils.Nested101::source);
   private static volatile StreamerNameUtils.Nested101[] field07814 = field07812;
   private static volatile Set<String> field07815 = Set.of();
   private static volatile boolean[] field07816 = new boolean[256];
   private static volatile int field07817 = StreamerNameUtils.field07822;
   private static volatile boolean field07818;
   private static volatile int field07819;
   private static final int field07820 = Integer.MAX_VALUE;
   private static final String field07821 = "This is a utility class and cannot be instantiated";
   private static final int field07822 = Integer.MAX_VALUE;

   private static String method03480(String var0) {
      if (var0 == null) {
         return null;
      }

      String var1 = var0.trim();
      return var1.isEmpty() ? null : var1;
   }

   public static String method03481(String var0) {
      if (var0 != null && field07818 && var0.length() >= field07817) {
         StreamerNameUtils.Nested101[] var1 = field07814;
         boolean[] var2 = field07816;
         int var3 = var0.length();
         StringBuilder var4 = null;
         int var5 = 0;
         int var6 = 0;

         while (var6 < var3) {
            if (!var2[var0.charAt(var6) & 0xFF]) {
               var6++;
            } else {
               StreamerNameUtils.Nested101 var7 = method03491(var0, var6, var3, var1);
               if (var7 == null) {
                  var6++;
               } else {
                  if (var4 == null) {
                     var4 = new StringBuilder(var3);
                  }

                  var4.append(var0, var5, var6).append(var7.replacement());
                  var6 += var7.source().length();
                  var5 = var6;
               }
            }
         }

         return var4 == null ? var0 : var4.append(var0, var5, var3).toString();
      } else {
         return var0;
      }
   }

   private static boolean method03482(String var0, int var1) {
      if (!method03487(var0.charAt(var1))) {
         return true;
      }

      if (var1 == 0) {
         return false;
      }

      char var2 = var0.charAt(var1 - 1);
      return var2 == 167 || var2 == '&';
   }

   public static void method03483() {
      StreamerMode var0 = ModuleManager.INSTANCE.method08203();
      method03492(var0 != null && var0.method10540() ? method03489() : new StreamerNameUtils.Nested100());
   }

   private static String method03484(String var0) {
      return var0.toLowerCase(Locale.ROOT);
   }

   private StreamerNameUtils() {
      throw new UnsupportedOperationException(field07821);
   }

   public static boolean method03486() {
      return field07818;
   }

   private static boolean method03487(char var0) {
      return var0 == '_' || Character.isLetterOrDigit(var0);
   }

   public static boolean method03488(String var0) {
      if (var0 != null && field07818) {
         String var1 = var0.trim();
         return !var1.isEmpty() && field07815.contains(method03484(var1));
      } else {
         return false;
      }
   }

   private static StreamerNameUtils.Nested100 method03489() {
      StreamerNameUtils.Nested100 var0 = new StreamerNameUtils.Nested100();
      Party var1 = SocialStateUtils.method10614();
      if (var1 != null) {
         for (PartyMember var3 : var1.method10148()) {
            var0.method03496(var3.method07580(), var3.method07586());
         }
      }

      var0.method03494(mc.getUser().getName());

      for (Friend var5 : FriendManager.INSTANCE.method00184().values()) {
         if (var5.method03786()) {
            var0.method03496(var5.method03787(), var5.method03788());
         } else {
            var0.method03494(var5.method03787());
         }
      }

      return var0;
   }

   public static int method03490() {
      return field07819;
   }

   private static StreamerNameUtils.Nested101 method03491(String var0, int var1, int var2, StreamerNameUtils.Nested101[] var3) {
      for (StreamerNameUtils.Nested101 var7 : var3) {
         String var8 = var7.source();
         int var9 = var8.length();
         int var10 = var1 + var9;
         if (var10 <= var2
            && var0.regionMatches(true, var1, var8, 0, var9)
            && (var1 <= 0 || !method03487(var8.charAt(0)) || method03482(var0, var1 - 1))
            && (var10 >= var2 || !method03487(var8.charAt(var9 - 1)) || method03482(var0, var10))) {
            return var7;
         }
      }

      return null;
   }

   private static void method03492(StreamerNameUtils.Nested100 var0) {
      StreamerNameUtils.Nested101[] var1 = var0.method03495();
      var var2 = var0.method03493();
      if (!Arrays.equals(var1, field07814) || !var2.equals(field07815)) {
         boolean[] var3 = new boolean[256];
         int var4 = field07820;

         for (StreamerNameUtils.Nested101 var8 : var1) {
            char var9 = var8.source().charAt(0);
            var3[Character.toLowerCase(var9) & 0xFF] = true;
            var3[Character.toUpperCase(var9) & 0xFF] = true;
            var4 = Math.min(var4, var8.source().length());
         }

         field07814 = var1;
         field07815 = var2;
         field07816 = var3;
         field07817 = var4;
         field07818 = var1.length != 0;
         field07819++;
         TextCacheInvalidator.method07278();
         FormattedTextCache.method01892();
         ChatMessagePolicy.method04007();
      }
   }

   // $VF: Compiled from s
   private static final class Nested100 {
      private final Map<String, String> field07823 = new LinkedHashMap<>();
      private final Set<String> field07824 = new HashSet<>();
      private static final String field07825 = "Protected";
      private static final String field07826 = "Protected";
      private static final String field07827 = "Protected";

      private Set<String> method03493() {
         return this.field07823.isEmpty() ? Set.of() : Set.copyOf(this.field07824);
      }

      private void method03494(String var1) {
         this.method03496(var1, field07826);
      }

      private StreamerNameUtils.Nested101[] method03495() {
         if (this.field07823.isEmpty()) {
            return StreamerNameUtils.field07812;
         }

         StreamerNameUtils.Nested101[] var1 = new StreamerNameUtils.Nested101[this.field07823.size()];
         int var2 = 0;

         for (var var4 : this.field07823.entrySet()) {
            var1[var2++] = new StreamerNameUtils.Nested101((String)var4.getKey(), (String)var4.getValue());
         }

         Arrays.sort(var1, StreamerNameUtils.field07813);
         return var1;
      }

      private void method03496(String var1, String var2) {
         String var3 = StreamerNameUtils.method03480(var1);
         if (var3 != null) {
            String var4 = StreamerNameUtils.method03484(var3);
            if (this.field07824.add(var4)) {
               String var5 = StreamerNameUtils.method03480(var2);
               if (var5 == null) {
                  var5 = field07827;
               }

               String var6 = StreamerNameUtils.method03484(var5);
               this.field07824.add(var6);
               if (!var4.equals(var6)) {
                  this.field07823.put(var4, var5);
               }
            }
         }
      }

      private Nested100() {
         this.field07824.add(StreamerNameUtils.method03484(field07825));
      }
   }

   // $VF: Compiled from s
   private record Nested101(String source, String replacement) {
   }
}
