// Original binary: sg/mx/kIv9efjd31h8rLnX
package sg.mx;

import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.util.ARGB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// $VF: Compiled from s
@Mixin(SpriteContents.class)
public abstract class SpriteContentsMixin_1277 {
   private static final int ITEM_ALPHA_CUTOFF = 26;

   @Redirect(method = "isTransparent(III)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/ARGB;alpha(I)I"))
   private int hex$treatFaintAlphaAsTransparent(int var1) {
      int var2 = ARGB.alpha(var1);
      return var2 < 26 ? 0 : var2;
   }
}
