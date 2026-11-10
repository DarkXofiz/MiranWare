// Original binary: sg/mx/1XRLdMHSgYuWCRkN
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.renderer.texture.CubeMapTexture;
import net.minecraft.client.renderer.texture.ReloadableTexture;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.server.packs.resources.ResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import sg.ec.ReloadableTextureHooks;

// $VF: Compiled from s
@Mixin(CubeMapTexture.class)
public abstract class CubeMapTextureMixin {
   @WrapMethod(method = "loadContents")
   private TextureContents safeLoadCubeMapContents(ResourceManager var1, Operation<TextureContents> var2) {
      return ReloadableTextureHooks.method03210((ReloadableTexture)(Object)this, var1, var2);
   }
}
