// Original binary: sg/ec/MZv2ddE1cxjQNrhn
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class StringSplitterHooks {
   private final TextWidthCache field10211 = new TextWidthCache(4096);
   private int field10212 = -1;

   public void method04639(String var1, CallbackInfoReturnable<Float> var2) {
      int var3 = TextCacheInvalidator.field17747;
      if (var3 != this.field10212) {
         this.field10211.clear();
         this.field10212 = var3;
      } else {
         Float var4 = this.field10211.get(var1);
         if (var4 != null) {
            var2.setReturnValue(var4);
         }
      }
   }

   public void method04640(String var1, float var2) {
      this.field10211.put(var1, var2);
   }
}
