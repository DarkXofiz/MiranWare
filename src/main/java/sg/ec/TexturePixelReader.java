// Original binary: sg/ec/nC8i5AiwSciyCmXG
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.Resource;

// $VF: Compiled from s
public final class TexturePixelReader implements MinecraftAccess {
   public static final int field21920 = 64;
   private static final String field21921 = "This is a utility class and cannot be instantiated";

   public static boolean method09639(Identifier var0, Predicate<NativeImage> var1) {
      if (mc.getTextureManager().getTexture(var0) instanceof DynamicTexture var12) {
         NativeImage sx = var12.getPixels();
         return !sx.isClosed() && var1.test(sx);
      } else {
         var var2 = mc.getResourceManager().getResource(var0);
         if (var2.isEmpty()) {
            return false;
         }

         try (
            InputStream sx = var2.get().open();
            NativeImage sxx = NativeImage.read(sx);
         ) {
            return var1.test(sxx);
         } catch (IOException sx) {
            return false;
         }
      }
   }

   private TexturePixelReader() {
      throw new UnsupportedOperationException(field21921);
   }
}
