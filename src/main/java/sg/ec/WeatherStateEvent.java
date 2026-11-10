// Original binary: sg/ec/S43mTfAlHpOXDi8u
package sg.ec;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class WeatherStateEvent extends Event {
   public static final WeatherStateEvent field11736 = new WeatherStateEvent();
   private WeatherStateEvent.Nested165 field11737;

   public void method05398(WeatherStateEvent.Nested165 var1, CallbackInfoReturnable<Float> var2) {
      if (this.method05402(var1)) {
         var2.setReturnValue(0.0F);
      }
   }

   public WeatherStateEvent.Nested165 method05399() {
      return this.field11737;
   }

   public void method05400(WeatherStateEvent.Nested165 var1, CallbackInfoReturnable<Boolean> var2) {
      if (this.method05402(var1)) {
         var2.setReturnValue(false);
      }
   }

   public void method05401(WeatherStateEvent.Nested165 var1) {
      this.field11737 = var1;
   }

   public boolean method05402(WeatherStateEvent.Nested165 var1) {
      if (!this.method05698()) {
         return false;
      }

      this.field11737 = var1;
      super.method03208();
      return this.method05694();
   }

   // $VF: Compiled from s
   public enum Nested165 {
      RAIN,
      THUNDER;
   }
}
