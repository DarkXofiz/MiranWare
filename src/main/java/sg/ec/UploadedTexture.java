// Original binary: sg/ec/90jhNVcGdj9Re1o5
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.renderpearl.api.device.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import java.util.function.Supplier;
import net.minecraft.client.renderer.texture.AbstractTexture;

// $VF: Compiled from s
public final class UploadedTexture extends AbstractTexture {
   private NativeImage[] field05153;

   private void releaseImages() {
      if (this.field05153 != null) {
         for (NativeImage var4 : this.field05153) {
            if (var4 != null) {
               var4.close();
            }
         }

         this.field05153 = null;
      }
   }

   @Override
   public void close() {
      super.close();
      this.releaseImages();
   }

   public UploadedTexture(Supplier<String> var1, NativeImage[] var2) {
      this.field05153 = var2;
      NativeImage var3 = var2[0];
      GpuDevice var4 = RenderSystem.getDevice();
      this.texture = var4.createTexture(var1, 5, GpuFormat.RGBA8_UNORM, var3.getWidth(), var3.getHeight(), 1, var2.length);
      this.sampler = RenderSystem.getSamplerCache().getRepeat(FilterMode.LINEAR);
      this.textureView = var4.createTextureView(this.texture);

      for (int var5 = 0; var5 < var2.length; var5++) {
         var4.createCommandEncoder().writeToTexture(this.texture, var2[var5], var5, 0, 0, 0);
      }
   }
}
