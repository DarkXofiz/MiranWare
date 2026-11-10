// Original binary: sg/ec/Wn1a3MZu5UqAuFoz
package sg.ec;

import net.minecraft.client.renderer.state.level.CameraRenderState;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public final class HurtCameraHooks {
   public static void method06046(CameraRenderState var0, CallbackInfo var1) {
      WorldProjectionUtils.method09453(var0);
      VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.NOHURTCAM, var1);
   }

   private HurtCameraHooks() {
   }
}
