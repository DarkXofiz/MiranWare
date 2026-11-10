// Original binary: sg/ec/POSR2bG66sBGWxQj
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuSampler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;

// $VF: Compiled from s
public final class WorldVisualRenderer {
   private static final Supplier<String> field10950 = () -> WorldVisualRenderer.field10975;
   private static final ByteBuffer field10951 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
   private static RenderPipeline field10952;
   private static GpuBuffer field10953;
   private static GpuSampler field10954;
   private static float field10955 = Float.NaN;
   private static float field10956;
   private static float field10957;
   private static float field10958;
   private static float field10959;
   private static boolean field10960;
   private static final float field10961 = 0.001F;
   private static final float field10962 = 0.001F;
   private static final float field10963 = 255.0F;
   private static final float field10964 = 255.0F;
   private static final float field10965 = 255.0F;
   private static final String field10966 = "VisualConfig";
   private static final String field10967 = "InSampler";
   private static final String field10968 = "pipeline/world_visual";
   private static final String field10969 = "core/screenquad";
   private static final String field10970 = "post/world_visual";
   private static final String field10971 = "InSampler";
   private static final String field10972 = "VisualConfig";
   private static final long field10973 = 32L;
   private static final String field10974 = "hex world visual cfg";
   private static final String field10975 = "hex world visual";

   private static void method04985(float var0, float var1, float var2, float var3, float var4) {
      if (field10953 == null) {
         field10953 = RenderSystem.getDevice().createBuffer(() -> field10974, 136, field10973);
      }

      if (var0 != field10955 || var1 != field10956 || var2 != field10957 || var3 != field10958 || var4 != field10959) {
         field10955 = var0;
         field10956 = var1;
         field10957 = var2;
         field10958 = var3;
         field10959 = var4;
         field10951.clear();
         field10951.putFloat(var0).putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).flip();
         RenderSystem.getDevice().createCommandEncoder().writeToBuffer(field10953.slice(), field10951);
      }
   }

   private static RenderPipeline method04986() {
      if (field10952 == null) {
         field10952 = RenderPipeline.builder()
            .withLocation(SceneSwapRenderer.method03866(field10968))
            .withVertexShader(field10969)
            .withFragmentShader(SceneSwapRenderer.method03866(field10970))
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field10971, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field10972, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field10952;
   }

   private WorldVisualRenderer() {
   }

   private static GpuSampler method04988() {
      if (field10954 == null) {
         field10954 = RenderSystem.getSamplerCache().getClampToEdge(FilterMode.LINEAR);
      }

      return field10954;
   }

   public static void method04990() {
      Ambience var0 = ModuleManager.INSTANCE.method08254();
      if (var0 != null && var0.method03937() && var0.method03239()) {
         float var1 = var0.method03248();
         float var2 = var0.method03258();
         if (!(var1 < field10961) || !(Math.abs(var2 - 1.0F) < field10962)) {
            RenderTarget var3 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
            if (var3 != null) {
               int var4 = var0.method03252();
               float var5 = (var4 >> 16 & 0xFF) / field10963;
               float var6 = (var4 >> 8 & 0xFF) / field10964;
               float var7 = (var4 & 0xFF) / field10965;
               method04985(var5, var6, var7, var1, var2);

               try {
                  CommandEncoder var8 = RenderSystem.getDevice().createCommandEncoder();
                  TextureTarget var9 = SceneSwapRenderer.method03868(var3, var8);
                  if (var9 == null) {
                     return;
                  }

                  try (RenderPass var10 = var8.createRenderPass(field10950, var3.getColorTextureView(), Optional.empty())) {
                     var10.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(method04986()));
                     RenderSystem.bindDefaultUniforms(var10);
                     var10.setUniform(field10966, field10953);
                     var10.setUniform(field10967, var9.getColorTextureView(), method04988());
                     var10.draw(3, 1, 0, 0);
                  }
               } catch (Throwable var15) {
                  if (!field10960) {
                     field10960 = true;
                  }
               }
            }
         }
      }
   }
}
