// Original binary: sg/mx/MJvLvwfr3HRemqtP
package sg.mx;

import java.nio.file.Path;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(DynamicTexture.class)
public abstract class DynamicTextureMixin {
   private static final String field28009 = "hex";

   @Inject(method = "dumpContents", at = @At("HEAD"), cancellable = true)
   private void keepClientTexture(Identifier var1, Path var2, CallbackInfo var3) {
      if (field28009.equalsIgnoreCase(var1.getNamespace())) {
         var3.cancel();
      }
   }

}
