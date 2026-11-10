// Original binary: sg/ec/aOihDq7rd4a6yjUZ
package sg.ec;

import com.mojang.blaze3d.pipeline.RenderTarget;
import net.minecraft.client.renderer.GameRenderer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public final class HudRenderTargetHooks {
   public static void method06927(CallbackInfo var0) {
      if (HudBlitRenderer.method10061()) {
         var0.cancel();
      }
   }

   private HudRenderTargetHooks() {
   }

   public static RenderTarget method06928(GameRenderer var0) {
      if (HudBlitRenderer.method10068()) {
         RenderTarget var1 = HudBlitRenderer.method10062();
         if (var1 != null) {
            return var1;
         }
      }

      return var0.mainRenderTarget();
   }

   public static void method06929() {
      HudBlitRenderer.method10073();
   }

   public static void method06930(CallbackInfo var0) {
      if (HudBlitRenderer.method10065()) {
         var0.cancel();
      }
   }
}
