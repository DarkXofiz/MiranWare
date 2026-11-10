// Original binary: sg/ec/EFJlCzMoqWwyCBSd
package sg.ec;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.renderer.texture.ReloadableTexture;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.server.packs.resources.ResourceManager;

// $VF: Compiled from s
public final class ReloadableTextureHooks {
   private ReloadableTextureHooks() {
   }

   public static TextureContents method03210(ReloadableTexture var0, ResourceManager var1, Operation<TextureContents> var2) {
      try {
         return TextureImageUtils.method01620(var0.resourceId(), (TextureContents)var2.call(new Object[]{var1}));
      } catch (Exception var4) {
         return TextureImageUtils.method01623();
      }
   }
}
