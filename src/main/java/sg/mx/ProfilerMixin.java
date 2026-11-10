// Original binary: sg/mx/KlkvYhl66on6Ky2D
package sg.mx;

import net.minecraft.util.profiling.Profiler;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ProfilerHooks;

// $VF: Compiled from s
@Mixin(Profiler.class)
public abstract class ProfilerMixin {
   @Shadow
   @Final
   private static ThreadLocal<ProfilerFiller> ACTIVE;

   @Inject(method = "get", at = @At("HEAD"), cancellable = true)
   private static void hex$fastGet(CallbackInfoReturnable<ProfilerFiller> var0) {
      ProfilerHooks.method11720(var0);
   }

   @Inject(method = "startUsing", at = @At("TAIL"))
   private static void hex$cacheOnStart(ProfilerFiller var0, CallbackInfo var1) {
      ProfilerHooks.method11721(ACTIVE.get());
   }

   @Inject(method = "stopUsing", at = @At("TAIL"))
   private static void hex$clearOnStop(CallbackInfo var0) {
      ProfilerHooks.method11719();
   }
}
