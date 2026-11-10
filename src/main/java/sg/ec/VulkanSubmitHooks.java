// Original binary: sg/ec/HOnOMalXpPAjA7xz
package sg.ec;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;

// $VF: Compiled from s
public final class VulkanSubmitHooks {
   private static final int field08527 = 2;
   private static final int field08528 = 0;

   private VulkanSubmitHooks() {
   }

   public static int method03789(Object var0, long var1, long var3, long var5, long var7, Object var9, Operation<Integer> var10) {
      int var11 = (Integer)var10.call(new Object[]{var0, var1, var3, var5, var7, var9});

      for (int var12 = 0; var12 < 2 && var11 == 2; var12++) {
         var11 = (Integer)var10.call(new Object[]{var0, var1, var3, var5, var7, var9});
      }

      return var11;
   }

   public static boolean method03790(Object var0, long var1, long var3, Operation<Boolean> var5) {
      for (int var6 = 0; var6 <= 2; var6++) {
         if ((Boolean)var5.call(new Object[]{var0, var1, var3})) {
            return true;
         }
      }

      return false;
   }
}
