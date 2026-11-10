// Original binary: sg/mx/HAKITuW5KqlOqXY0
package sg.mx;

import java.nio.file.Path;
import java.util.Map;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(TextureAtlas.class)
public abstract class TextureAtlasMixin {
   @Shadow
   private Map<Identifier, TextureAtlasSprite> texturesByName;
   private static final String field28006 = "hex";

   @Inject(method = "dumpContents", at = @At("HEAD"), cancellable = true)
   private void keepClientSprites(Identifier var1, Path var2, CallbackInfo var3) {
      for (Identifier var5 : this.texturesByName.keySet()) {
         if (field28006.equalsIgnoreCase(var5.getNamespace())) {
            var3.cancel();
            return;
         }
      }
   }

}
