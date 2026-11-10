// Original binary: sg/ec/tq8eo7idmVIK13EH
package sg.ec;

import net.minecraft.client.renderer.feature.FeatureRenderDispatcher.PreparedFrame;

// $VF: Compiled from s
public final class FeatureRenderDispatcherHooks {
   private FeatureRenderDispatcherHooks() {
   }

   public static void method10880(PreparedFrame var0) {
      if (HandGlowRenderer.method01229() || HandGlowRenderer.method01242() != 0) {
         try {
            if (var0.hasAnyOutline()) {
               HandGlowRenderer.method01205(var0);
            }

            if (HandGlowRenderer.method01229()) {
               HandGlowRenderer.method01223();
            }
         } finally {
            HandGlowRenderer.method01213();
         }
      }
   }
}
