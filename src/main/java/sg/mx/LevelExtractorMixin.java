// Original binary: sg/mx/4OwWwuqhKMZ4U1sh
package sg.mx;

import net.minecraft.client.renderer.extract.LevelExtractor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.BlockEntityLightCache;

// $VF: Compiled from s
@Mixin(LevelExtractor.class)
public class LevelExtractorMixin {
   @Inject(method = "setSectionDirty(IIIZ)V", at = @At("HEAD"))
   private void hex$invalidateLight(int var1, int var2, int var3, boolean var4, CallbackInfo var5) {
      BlockEntityLightCache.method05925();
   }
}
