// Original binary: sg/mx/Eg6Q0553hc2aoceM
package sg.mx;

import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.LightLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.BlockEntityLightCache;

// $VF: Compiled from s
@Mixin(ClientChunkCache.class)
public class ClientChunkCacheMixin_1152 {
   @Inject(method = "onLightUpdate", at = @At("HEAD"))
   private void hex$invalidateLight(LightLayer var1, SectionPos var2, CallbackInfo var3) {
      BlockEntityLightCache.method05925();
   }
}
