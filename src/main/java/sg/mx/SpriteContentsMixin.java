// Original binary: sg/mx/5BIG77riZMiXDBkH
package sg.mx;

import java.util.Optional;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.SpriteContentsHooks;

// $VF: Compiled from s
@Mixin(SpriteContents.class)
public class SpriteContentsMixin {
   @Unique
   private volatile Object[] hex$metadataCache;

   @Inject(method = "getAdditionalMetadata", at = @At("HEAD"), cancellable = true)
   private <T> void hex$cachedMetadata(MetadataSectionType<T> var1, CallbackInfoReturnable<Optional<T>> var2) {
      SpriteContentsHooks.method06890(var1, this.hex$metadataCache, var2);
   }

   @Inject(method = "getAdditionalMetadata", at = @At("RETURN"))
   private <T> void hex$storeMetadata(MetadataSectionType<T> var1, CallbackInfoReturnable<Optional<T>> var2) {
      this.hex$metadataCache = SpriteContentsHooks.method06889(var1, this.hex$metadataCache, var2.getReturnValue());
   }
}
