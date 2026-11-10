// Original binary: sg/mx/3Ii8lzbqzk7CX1jb
package sg.mx;

import net.minecraft.client.gui.font.FontManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.TextCacheInvalidator;

// $VF: Compiled from s
@Mixin(FontManager.class)
public class FontManagerMixin {
   @Inject(method = "apply", at = @At("TAIL"), require = 0)
   private void hex$invalidateWidthCache(CallbackInfo var1) {
      TextCacheInvalidator.method07278();
   }
}
