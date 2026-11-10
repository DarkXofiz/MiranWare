// Original binary: sg/mx/mttkDwTGmoMbSFqb
package sg.mx;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.ScreenEffectRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.VisualRemovalEvent;

// $VF: Compiled from s
@Mixin(ScreenEffectRenderer.class)
public class ScreenEffectRendererMixin {
   @Inject(method = "submitFire", at = @At("HEAD"), cancellable = true)
   private static void renderFireOverlay(PoseStack var0, SubmitNodeCollector var1, TextureAtlasSprite var2, CallbackInfo var3) {
      VisualRemovalEvent.field19883.method08691(VisualRemovalEvent.Nested242.FIRE, var3);
   }
}
