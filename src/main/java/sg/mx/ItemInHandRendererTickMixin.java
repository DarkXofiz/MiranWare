package sg.mx;

import net.minecraft.client.renderer.ItemInHandRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.HandHeightTracker;

@Mixin(ItemInHandRenderer.class)
public abstract class ItemInHandRendererTickMixin {
   @Shadow
   private float mainHandHeight;

   @Inject(method = "tick", at = @At("TAIL"))
   private void miranware$trackMainHandHeight(CallbackInfo ci) {
      HandHeightTracker.update(this.mainHandHeight);
   }
}
