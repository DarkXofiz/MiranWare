// Original binary: sg/mx/QLfWxUwwiXua6tQN
package sg.mx;

import net.minecraft.client.gui.font.GlyphStitcher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.TextCacheInvalidator;

// $VF: Compiled from s
@Mixin(GlyphStitcher.class)
public class GlyphStitcherMixin {
   @Inject(method = "reset", at = @At("TAIL"))
   private void hex$invalidateGlyphCaches(CallbackInfo var1) {
      TextCacheInvalidator.method07278();
   }
}
