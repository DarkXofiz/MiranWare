// Original binary: sg/ec/6DDgWkL8fmrBZCyY
package sg.ec;

import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.buffers.GpuBufferSlice.MappedView;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.GpuTexture;
import java.util.function.IntConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ARGB;

// $VF: Compiled from s
public final class PixelReader {
   private static final int field02782 = -16777216;
   private static final String field02783 = "hex pixel read";

   private PixelReader() {
   }

   public static void method01300(int var0, int var1, IntConsumer var2) {
      RenderTarget var3 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      if (var3 != null) {
         GpuTexture var4 = var3.getColorTexture();
         if (var4 != null) {
            int var5 = var3.width;
            int var6 = var3.height;
            if (var5 > 0 && var6 > 0) {
               int var7 = Math.max(0, Math.min(var5 - 1, var0));
               int var8 = Math.max(0, Math.min(var6 - 1, var1));
               int var9 = var4.getFormat().blockSize();
               int var10 = var6 - 1 - var8;

               try {
                  GpuBuffer var11 = RenderSystem.getDevice().createBuffer(() -> field02783, 9, var9);
                  RenderSystem.getDevice().createCommandEncoder().copyTextureToBuffer(var4, var11, 0L, () -> {
                     try (MappedView var2x = var11.map(true, false)) {
                        int var3x = var2x.data().getInt(0) | field02782;
                        var2.accept(ARGB.fromABGR(var3x));
                     } catch (Throwable var12x) {
                     } finally {
                        var11.close();
                     }
                  }, 0, var7, var10, 1, 1);
               } catch (Throwable var12) {
               }
            }
         }
      }
   }
}
