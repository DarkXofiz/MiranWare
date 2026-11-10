// Original binary: sg/ec/MHzsQjDmvcxLT0A3
package sg.ec;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

// $VF: Compiled from s
public final class RawTextScope {
   private static final ThreadLocal<Boolean> field10043 = ThreadLocal.withInitial(() -> Boolean.FALSE);
   private static final AtomicInteger field10044 = new AtomicInteger();

   private RawTextScope() {
   }

   public static <T> T method04525(Supplier<T> var0) {
      boolean var1 = field10043.get();
      if (!var1) {
         field10043.set(Boolean.TRUE);
         field10044.incrementAndGet();
      }

      try {
         return (T)(Object)var0.get();
      } finally {
         if (!var1) {
            field10044.decrementAndGet();
            field10043.set(Boolean.FALSE);
         }
      }
   }

   public static boolean method04526() {
      return field10044.get() != 0 && field10043.get();
   }
}
