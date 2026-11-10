// Original binary: sg/mx/LIPoTY0muhKdVu02
package sg.mx;

import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import net.minecraft.client.gui.render.TextureSetup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.TextureSetupHooks;

// $VF: Compiled from s
@Mixin(TextureSetup.class)
public class TextureSetupMixin {
   @Inject(method = "singleTextureWithLightmap", at = @At("HEAD"), cancellable = true)
   private static void hex$cachedLightmap(GpuTextureView var0, GpuSampler var1, CallbackInfoReturnable<TextureSetup> var2) {
      TextureSetupHooks.method07074(var0, var1, var2);
   }

   @Inject(method = "singleTextureWithLightmap", at = @At("RETURN"))
   private static void hex$storeLightmap(GpuTextureView var0, GpuSampler var1, CallbackInfoReturnable<TextureSetup> var2) {
      TextureSetupHooks.method07075((TextureSetup)var2.getReturnValue());
   }

   @Inject(method = "singleTexture", at = @At("HEAD"), cancellable = true)
   private static void hex$cachedSingle(GpuTextureView var0, GpuSampler var1, CallbackInfoReturnable<TextureSetup> var2) {
      TextureSetupHooks.method07076(var0, var1, var2);
   }

   @Inject(method = "singleTexture", at = @At("RETURN"))
   private static void hex$storeSingle(GpuTextureView var0, GpuSampler var1, CallbackInfoReturnable<TextureSetup> var2) {
      TextureSetupHooks.method07077((TextureSetup)var2.getReturnValue());
   }
}
