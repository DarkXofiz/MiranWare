// Original binary: sg/mx/9ZNB7Eg7KidUXZeM
package sg.mx;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.EntityMaskRenderHooks;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.client.renderer.feature.FeatureRenderDispatcher$PreparedFrame")
public class FeatureRenderDispatcher$PreparedFrameMixin {
   @Inject(method = {"executeSolid", "executeTranslucent", "executeTranslucentAfterTerrain", "executeOutline"}, at = @At("HEAD"), require = 0)
   private void hex$worldMergeBegin(CallbackInfo var1) {
      EntityMaskRenderHooks.method04014();
   }

   @Inject(method = {"executeSolid", "executeTranslucent", "executeTranslucentAfterTerrain", "executeOutline"}, at = @At("RETURN"), require = 0)
   private void hex$worldMergeEnd(CallbackInfo var1) {
      EntityMaskRenderHooks.method04011();
   }
}
