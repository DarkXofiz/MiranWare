// Original binary: sg/ec/x9JbGyrLXmXHIJtJ
package sg.ec;

import net.minecraft.locale.Language;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.mx.MutableComponentMixin;

// $VF: Compiled from s
public final class MutableComponentHooks {
   public static final long field25736 = 0L;

   private MutableComponentHooks() {
   }

   public static void method11299(MutableComponentMixin var0, long var1, CallbackInfoReturnable<FormattedCharSequence> var3) {
      if (RawTextScope.method04526()) {
         var0.hex$setDecomposedWith(null);
      } else {
         ((ComponentTextCacheAccess)var0).hex$decomposeGeneration(TextCacheInvalidator.field17747);
         if (var1 != 0L) {
            FormattedCharSequence var4 = (FormattedCharSequence)var3.getReturnValue();
            if (var4 != null) {
               FormattedTextCache.method01893(var1, var4);
            }
         }
      }
   }

   public static long method11300(MutableComponentMixin var0, CallbackInfoReturnable<FormattedCharSequence> var1) {
      if (RawTextScope.method04526()) {
         var0.hex$setDecomposedWith(null);
         return 0L;
      }

      Language var2 = Language.getInstance();
      ComponentTextCacheAccess var3 = (ComponentTextCacheAccess)var0;
      int var4 = TextCacheInvalidator.field17747;
      if (var0.hex$getDecomposedWith() == var2) {
         if (var3.hex$decomposeGeneration() == var4) {
            return 0L;
         }

         var0.hex$setDecomposedWith(null);
      }

      Component var5 = (Component)var0;
      long var6 = TextCacheKeys.method03823(TextCacheKeys.method03825(var5), var2.isDefaultRightToLeft() ? 1 : 0);
      if (var6 == 0L) {
         return 0L;
      } else {
         FormattedCharSequence var8 = FormattedTextCache.method01891(var6);
         if (var8 != null) {
            var0.hex$setVisualOrderText(var8);
            var0.hex$setDecomposedWith(var2);
            var3.hex$decomposeGeneration(var4);
            var1.setReturnValue(var8);
            return 0L;
         } else {
            return var6;
         }
      }
   }
}
