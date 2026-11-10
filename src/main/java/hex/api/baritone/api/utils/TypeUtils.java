// Original binary: hex/api/baritone/api/utils/TypeUtils
package hex.api.baritone.api.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// $VF: Compiled from s
public final class TypeUtils {
   public static Class<?> resolveBaseClass(Type var0) {
      return var0 instanceof Class ? (Class)var0 : (var0 instanceof ParameterizedType ? (Class)((ParameterizedType)var0).getRawType() : null);
   }

   private TypeUtils() {
   }
}
