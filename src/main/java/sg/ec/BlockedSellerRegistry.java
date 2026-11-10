// Original binary: sg/ec/Iwb7vLQhZn0ab9rK
package sg.ec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

// $VF: Compiled from s
public final class BlockedSellerRegistry {
   public static final BlockedSellerRegistry field08823 = new BlockedSellerRegistry();
   private static final int field08824 = 200;
   private final Map<String, String> field08825 = new LinkedHashMap<>();

   private static String method03968(String var0) {
      return var0 == null ? "" : var0.trim().toLowerCase(Locale.ROOT);
   }

   public synchronized boolean method03969() {
      return this.field08825.isEmpty();
   }

   public synchronized boolean method03970(String var1) {
      String var2 = method03968(var1);
      return !var2.isEmpty() && this.field08825.containsKey(var2);
   }

   public synchronized List<String> method03971() {
      return new ArrayList<>(this.field08825.values());
   }

   public synchronized boolean method03972(String var1) {
      String var2 = method03968(var1);
      if (!var2.isEmpty() && this.field08825.size() < 200 && !this.field08825.containsKey(var2)) {
         this.field08825.put(var2, var1.trim());
         return true;
      } else {
         return false;
      }
   }

   public synchronized void method03973(Collection<String> var1) {
      this.field08825.clear();
      if (var1 != null) {
         for (String var3 : var1) {
            this.method03972(var3);
         }
      }
   }

   public synchronized boolean method03974(String var1) {
      return this.field08825.remove(method03968(var1)) != null;
   }

   private BlockedSellerRegistry() {
   }
}
