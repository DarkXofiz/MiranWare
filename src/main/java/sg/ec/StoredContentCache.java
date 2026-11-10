// Original binary: sg/ec/QjduwoDCfbiR54Nq
package sg.ec;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// $VF: Compiled from s
public final class StoredContentCache {
   private static final Map<String, byte[]> field11357 = new ConcurrentHashMap<>();
   private static final String field11358 = "?";

   private static String method05218(StorageCategory var0, String var1) {
      return (var0 == null ? field11358 : var0.name()) + "\u0000" + (var1 == null ? "" : var1);
   }

   public static void method05219(StorageCategory var0, String var1, byte[] var2) {
      if (var2 != null) {
         field11357.put(method05218(var0, var1), (byte[])var2.clone());
      }
   }

   public static void method05220(List<StoredContent> var0) {
      field11357.clear();
      if (var0 != null) {
         for (StoredContent var2 : var0) {
            if (var2 != null && var2.content() != null) {
               field11357.put(method05218(var2.category(), var2.name()), (byte[])var2.content().clone());
            }
         }
      }
   }

   private StoredContentCache() {
   }

   public static boolean method05221(StorageCategory var0, String var1, byte[] var2) {
      byte[] var3 = field11357.get(method05218(var0, var1));
      return var3 == null || !Arrays.equals(var3, var2);
   }
}
