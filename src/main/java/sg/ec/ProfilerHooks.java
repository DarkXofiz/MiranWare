// Original binary: sg/ec/zSDLWfAXMa9ptuR3
package sg.ec;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.util.profiling.ProfilerFiller;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class ProfilerHooks {
   private static Thread field27866;
   private static ProfilerFiller field27867;

   public static void method11719() {
      if (Thread.currentThread() == field27866) {
         field27867 = null;
      }
   }

   public static void method11720(CallbackInfoReturnable<ProfilerFiller> var0) {
      if (Thread.currentThread() == field27866) {
         ProfilerFiller var1 = field27867;
         if (var1 != null) {
            var0.setReturnValue(var1);
         }
      }
   }

   private ProfilerHooks() {
   }

   public static void method11721(ProfilerFiller var0) {
      if (RenderSystem.isOnRenderThread()) {
         field27867 = var0;
         field27866 = Thread.currentThread();
      }
   }
}
