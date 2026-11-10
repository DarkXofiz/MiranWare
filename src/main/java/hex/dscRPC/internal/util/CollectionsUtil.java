// Original binary: hex/dscRPC/internal/util/CollectionsUtil
package hex.dscRPC.internal.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// $VF: Compiled from s
public class CollectionsUtil {
   @SafeVarargs
   public static <T> Set<T> setOf(T... var0) {
      return Collections.unmodifiableSet(new HashSet<>(Arrays.asList(var0)));
   }
}
