// Original binary: sg/ec/x20EKDqwUzGAwxN5
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.pipeline.RenderPipeline.Builder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.AddressMode;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

// $VF: Compiled from s
public class GuiBlurRenderer {
   private static final Supplier<String> field25230 = () -> GuiBlurRenderer.field25266;
   private static final long field25231 = 5555555L;
   private static final float field25232 = 0;
   private static final int field25233 = 0;
   private static TextureTarget field25234;
   private static TextureTarget field25235;
   private static TextureTarget field25236;
   private static GpuSampler field25237;
   private static RenderPipeline field25238;
   private static RenderPipeline field25239;
   private static RenderPipeline field25240;
   private static int field25241 = -1;
   private static int field25242 = -1;
   private static long field25243;
   private static boolean field25244;
   private static boolean field25245;
   private static boolean field25246;
   private static final String field25247 = "hex gui blur result";
   private static final String field25248 = "hex gui blur tmp";
   private static final String field25249 = "hex gui blur down";
   private static final long field25250 = 5555555L;
   private static final String field25251 = "core/screenquad";
   private static final String field25252 = "post/gui_blur";
   private static final String field25253 = "BLUR_RADIUS";
   private static final float field25254 = 5.0F;
   private static final String field25255 = "BLUR_VERTICAL";
   private static final String field25256 = "InSampler";
   private static final String field25257 = "pipeline/gui_blur_h";
   private static final String field25258 = "pipeline/gui_blur_v";
   private static final String field25259 = "pipeline/gui_downsample";
   private static final String field25260 = "core/screenquad";
   private static final String field25261 = "post/gui_downsample";
   private static final String field25262 = "BLUR_SCALE";
   private static final String field25263 = "InSampler";
   private static final String field25264 = "InSampler";
   private static final String field25265 = "hex";
   private static final String field25266 = "hex gui blur";

   public static GpuSampler method11249() {
      if (field25237 == null) {
         field25237 = RenderSystem.getDevice()
            .createSampler(AddressMode.CLAMP_TO_EDGE, AddressMode.CLAMP_TO_EDGE, FilterMode.LINEAR, FilterMode.LINEAR, 1, OptionalDouble.empty());
      }

      return field25237;
   }

   public static GpuTextureView method11250() {
      field25245 = true;
      return field25234 != null ? field25234.getColorTextureView() : Minecraft.getInstance().gameRenderer.mainRenderTarget().getColorTextureView();
   }

   public static void method11251(boolean var0) {
      method11252(Minecraft.getInstance().gameRenderer.mainRenderTarget(), var0);
   }

   public static void method11252(RenderTarget var0, boolean var1) {
      if (var0 != null && var0.getColorTexture() != null) {
         int var2 = Math.max(1, var0.width / 6);
         int var3 = Math.max(1, var0.height / 6);
         boolean var4 = false;
         if (field25234 == null || field25241 != var2 || field25242 != var3) {
            field25234 = method11255(field25234, var2, var3, field25247);
            field25235 = method11255(field25235, var2, var3, field25248);
            field25236 = method11255(field25236, var2, var3, field25249);
            field25241 = var2;
            field25242 = var3;
            var4 = true;
         }

         if (var1) {
            field25245 = false;
            field25246 = true;
         } else {
            boolean var5 = field25245;
            field25245 = false;
            long var6 = Util.getNanos();
            if (!var4 && !field25246) {
               if (var6 - field25243 < field25250) {
                  return;
               }

               if (!var5) {
                  return;
               }
            }

            field25246 = false;
            field25243 = var6;
         }

         try {
            method11256();
            method11253(field25240, field25236.getColorTextureView(), var0.getColorTextureView());
            method11253(field25238, field25235.getColorTextureView(), field25236.getColorTextureView());
            method11253(field25239, field25234.getColorTextureView(), field25235.getColorTextureView());
         } catch (Throwable var8) {
            if (!field25244) {
               field25244 = true;
            }
         }
      }
   }

   private static void method11253(RenderPipeline var0, GpuTextureView var1, GpuTextureView var2) {
      RenderPass var3 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field25230, var1, Optional.empty());

      try {
         var3.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var0));
         RenderSystem.bindDefaultUniforms(var3);
         var3.setUniform(field25264, var2, method11249());
         var3.draw(3, 1, 0, 0);
      } finally {
         var3.close();
      }
   }

   public static GpuTextureView method11254() {
      return field25236 != null ? field25236.getColorTextureView() : Minecraft.getInstance().gameRenderer.mainRenderTarget().getColorTextureView();
   }

   private static TextureTarget method11255(TextureTarget var0, int var1, int var2, String var3) {
      if (var0 != null && var0.width == var1 && var0.height == var2) {
         return var0;
      }

      if (var0 != null) {
         var0.destroyBuffers();
      }

      return new TextureTarget(var3, var1, var2, GpuFormat.RGBA8_UNORM, null);
   }

   private static void method11256() {
      if (field25238 == null) {
         field25238 = method11259(field25257, false);
      }

      if (field25239 == null) {
         field25239 = method11259(field25258, true);
      }

      if (field25240 == null) {
         field25240 = RenderPipeline.builder()
            .withLocation(method11257(field25259))
            .withVertexShader(field25260)
            .withFragmentShader(method11257(field25261))
            .withShaderDefine(field25262, 6)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field25263, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }
   }

   private static Identifier method11257(String var0) {
      return Identifier.fromNamespaceAndPath(field25265, var0);
   }

   private static RenderPipeline method11259(String var0, boolean var1) {
      Builder var2 = RenderPipeline.builder()
         .withLocation(method11257(var0))
         .withVertexShader(field25251)
         .withFragmentShader(method11257(field25252))
         .withShaderDefine(field25253, field25254);
      if (var1) {
         var2.withShaderDefine(field25255);
      }

      return var2.withBindGroupLayout(BindGroupLayout.builder().withUniform(field25256, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
         .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
         .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
         .build();
   }
}
