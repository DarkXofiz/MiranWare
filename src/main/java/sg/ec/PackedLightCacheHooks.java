// Original binary: sg/ec/EDDNfA1jFXEeiv56
package sg.ec;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// $VF: Compiled from s
public final class PackedLightCacheHooks {
   private static final int field07043 = 0;

   public static void method03206(PackedLightCacheAccess var0) {
      var0.hex$light(0);
   }

   public static int method03207(PackedLightCacheAccess var0, float var1, Operation<Integer> var2) {
      int var3 = var0.hex$light();
      if (var3 != 0) {
         return var3 - 1;
      }

      int var4 = (Integer)var2.call(new Object[]{var1});
      var0.hex$light(var4 + 1);
      return var4;
   }

   private PackedLightCacheHooks() {
   }
}
