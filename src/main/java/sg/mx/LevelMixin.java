// Original binary: sg/mx/gVW0P9bBZYsJ4YDX
package sg.mx;

import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.WeatherStateEvent;

// $VF: Compiled from s
@Mixin(Level.class)
public abstract class LevelMixin {
   @Inject(method = "isRaining", at = @At("HEAD"), cancellable = true)
   private void onIsRaining(CallbackInfoReturnable<Boolean> var1) {
      WeatherStateEvent.field11736.method05400(WeatherStateEvent.Nested165.RAIN, var1);
   }

   @Inject(method = "isThundering", at = @At("HEAD"), cancellable = true)
   private void onIsThundering(CallbackInfoReturnable<Boolean> var1) {
      WeatherStateEvent.field11736.method05400(WeatherStateEvent.Nested165.THUNDER, var1);
   }

   @Inject(method = "getRainLevel", at = @At("HEAD"), cancellable = true)
   private void onGetRainGradient(float var1, CallbackInfoReturnable<Float> var2) {
      WeatherStateEvent.field11736.method05398(WeatherStateEvent.Nested165.RAIN, var2);
   }

   @Inject(method = "getThunderLevel", at = @At("HEAD"), cancellable = true)
   private void onGetThunderGradient(float var1, CallbackInfoReturnable<Float> var2) {
      WeatherStateEvent.field11736.method05398(WeatherStateEvent.Nested165.THUNDER, var2);
   }
}
