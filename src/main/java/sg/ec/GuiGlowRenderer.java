// Original binary: sg/ec/3ynzSVNXdMos4mYX
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.pipeline.RenderPipeline.Builder;
import com.mojang.renderpearl.api.pipeline.BlendFactor;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class GuiGlowRenderer {
   private static final Supplier<String> field01771 = () -> GuiGlowRenderer.field01831;
   private static final int field01772 = 2;
   private static final ByteBuffer field01773 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
   private static TextureTarget field01774;
   private static TextureTarget field01775;
   private static TextureTarget field01776;
   private static TextureTarget field01777;
   private static RenderPipeline field01778;
   private static RenderPipeline field01779;
   private static RenderPipeline field01780;
   private static GpuBuffer field01781;
   private static GpuBuffer field01782;
   private static GpuBuffer field01783;
   private static GpuBuffer field01784;
   private static float field01785 = Float.NaN;
   private static float field01786 = Float.NaN;
   private static float field01787 = Float.NaN;
   private static float field01788 = Float.NaN;
   private static float field01789 = Float.NaN;
   private static float field01790 = Float.NaN;
   private static float field01791 = Float.NaN;
   private static float field01792 = Float.NaN;
   private static boolean field01793;
   private static final String field01794 = "hex gui glow mask";
   private static final String field01795 = "hex gui glow prep";
   private static final String field01796 = "hex gui glow blur a";
   private static final String field01797 = "hex gui glow blur b";
   private static final String field01798 = "GuiGlowPrep";
   private static final String field01799 = "GuiGlowPrep";
   private static final String field01800 = "BlurConfig";
   private static final String field01801 = "BlurConfig";
   private static final String field01802 = "GuiCombine";
   private static final String field01803 = "hex gui glow prep ubo";
   private static final long field01804 = 32L;
   private static final String field01805 = "hex gui glow blur h ubo";
   private static final long field01806 = 16L;
   private static final String field01807 = "hex gui glow blur v ubo";
   private static final long field01808 = 16L;
   private static final String field01809 = "hex gui glow combine ubo";
   private static final long field01810 = 16L;
   private static final float field01811 = 255.0F;
   private static final float field01812 = 255.0F;
   private static final float field01813 = 255.0F;
   private static final String field01814 = "InSampler";
   private static final String field01815 = "MaskSampler";
   private static final String field01816 = "hex";
   private static final String field01817 = "core/screenquad";
   private static final String field01818 = "gui_glow_pre";
   private static final String field01819 = "gui_glow_pre";
   private static final String field01820 = "InSampler";
   private static final String field01821 = "GuiGlowPrep";
   private static final String field01822 = "gui_glow_blur";
   private static final String field01823 = "hand_blur";
   private static final String field01824 = "InSampler";
   private static final String field01825 = "BlurConfig";
   private static final String field01826 = "gui_glow_combine";
   private static final String field01827 = "gui_glow_combine";
   private static final String field01828 = "InSampler";
   private static final String field01829 = "MaskSampler";
   private static final String field01830 = "GuiCombine";
   private static final String field01831 = "hex gui entity glow";

   private static void method00775(float var0, float var1, float var2, float var3, float var4) {
      field01773.clear();
      field01773.putFloat(var0).putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4).putFloat(0.0F).putFloat(0.0F).putFloat(0.0F).flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(field01781.slice(), field01773);
   }

   private static void method00776(boolean var0, float var1, int var2, float var3, boolean var4, float var5) {
      if (field01781 == null) {
         field01781 = method00789(field01803, field01804);
      }

      if (field01782 == null) {
         field01782 = method00789(field01805, field01806);
      }

      if (field01783 == null) {
         field01783 = method00789(field01807, field01808);
      }

      if (field01784 == null) {
         field01784 = method00789(field01809, field01810);
      }

      float var6 = var0 ? 1.0F : 0.0F;
      float var7 = (var2 >> 16 & 0xFF) / field01811;
      float var8 = (var2 >> 8 & 0xFF) / field01812;
      float var9 = (var2 & 0xFF) / field01813;
      if (var6 != field01785 || var1 != field01786 || var7 != field01787 || var8 != field01788 || var9 != field01789) {
         field01785 = var6;
         field01786 = var1;
         field01787 = var7;
         field01788 = var8;
         field01789 = var9;
         method00775(var6, var1, var7, var8, var9);
      }

      float var10 = Math.max(1.0F, var3 / 2.0F);
      if (var10 != field01790) {
         field01790 = var10;
         method00778(field01782, 1.0F, 0.0F, var10);
         method00778(field01783, 0.0F, 1.0F, var10);
      }

      float var11 = var4 ? 1.0F : 0.0F;
      float var12 = Math.max(0.0F, var5);
      if (var11 != field01791 || var12 != field01792) {
         field01791 = var11;
         field01792 = var12;
         method00788(var11, var12);
      }
   }

   private static Builder method00777(String var0, String var1) {
      return RenderPipeline.builder()
         .withLocation(method00782("pipeline/" + var0))
         .withVertexShader(field01817)
         .withFragmentShader(method00782("post/" + var1));
   }

   private static void method00778(GpuBuffer var0, float var1, float var2, float var3) {
      field01773.clear();
      field01773.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(1.0F).flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var0.slice(), field01773);
   }

   private static void method00779(
      RenderPipeline var0, GpuTextureView var1, String var2, GpuBuffer var3, GpuTextureView var4, FilterMode var5, GpuTextureView var6, FilterMode var7
   ) {
      RenderPass var8 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field01771, var1, Optional.empty());

      try {
         var8.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var0));
         RenderSystem.bindDefaultUniforms(var8);
         if (var3 != null) {
            var8.setUniform(var2, var3);
         }

         var8.setUniform(field01814, var4, RenderSystem.getSamplerCache().getClampToEdge(var5));
         if (var6 != null) {
            var8.setUniform(field01815, var6, RenderSystem.getSamplerCache().getClampToEdge(var7));
         }

         var8.draw(3, 1, 0, 0);
      } finally {
         var8.close();
      }
   }

   private GuiGlowRenderer() {
   }

   private static Identifier method00782(String var0) {
      return Identifier.fromNamespaceAndPath(field01816, var0);
   }

   private static RenderPipeline method00783() {
      if (field01779 == null) {
         field01779 = method00777(field01822, field01823)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field01824, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field01825, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field01779;
   }

   private static TextureTarget method00784(TextureTarget var0, int var1, int var2, String var3) {
      if (var0 != null && var0.width == var1 && var0.height == var2) {
         return var0;
      }

      if (var0 != null) {
         var0.destroyBuffers();
      }

      return new TextureTarget(var3, var1, var2, GpuFormat.RGBA8_UNORM, null);
   }

   private static RenderPipeline method00785() {
      if (field01780 == null) {
         BlendFunction var0 = new BlendFunction(BlendFactor.ONE_MINUS_DST_ALPHA, BlendFactor.ONE, BlendFactor.ONE_MINUS_DST_ALPHA, BlendFactor.ONE);
         field01780 = method00777(field01826, field01827)
            .withBindGroupLayout(
               BindGroupLayout.builder().withUniform(field01828, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field01829, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field01830, UniformType.UNIFORM_BUFFER).build()
            )
            .withColorTargetState(new ColorTargetState(Optional.of(var0), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field01780;
   }

   private static RenderPipeline method00786() {
      if (field01778 == null) {
         field01778 = method00777(field01818, field01819)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field01820, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field01821, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field01778;
   }

   public static void method00787(GpuTextureView var0, int var1, int var2, boolean var3, float var4, int var5, float var6, boolean var7, float var8) {
      if (var0 != null && var1 > 0 && var2 > 0) {
         try {
            int var9 = Math.max(1, var1 / 2);
            int var10 = Math.max(1, var2 / 2);
            field01774 = method00784(field01774, var1, var2, field01794);
            field01775 = method00784(field01775, var9, var10, field01795);
            field01776 = method00784(field01776, var9, var10, field01796);
            field01777 = method00784(field01777, var9, var10, field01797);
            method00776(var3, var4, var5, var6, var7, var8);
            method00779(method00786(), field01774.getColorTextureView(), field01798, field01781, var0, FilterMode.LINEAR, null, null);
            if (var7) {
               method00779(method00786(), field01775.getColorTextureView(), field01799, field01781, var0, FilterMode.LINEAR, null, null);
               method00779(
                  method00783(), field01776.getColorTextureView(), field01800, field01782, field01775.getColorTextureView(), FilterMode.LINEAR, null, null
               );
               method00779(
                  method00783(), field01777.getColorTextureView(), field01801, field01783, field01776.getColorTextureView(), FilterMode.LINEAR, null, null
               );
            }

            method00779(
               method00785(),
               var0,
               field01802,
               field01784,
               field01777.getColorTextureView(),
               FilterMode.LINEAR,
               field01774.getColorTextureView(),
               FilterMode.NEAREST
            );
         } catch (Throwable var11) {
            if (!field01793) {
               field01793 = true;
            }
         }
      }
   }

   private static void method00788(float var0, float var1) {
      field01773.clear();
      field01773.putFloat(var0).putFloat(var1).putFloat(0.0F).putFloat(0.0F).flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(field01784.slice(), field01773);
   }

   private static GpuBuffer method00789(String var0, long var1) {
      return RenderSystem.getDevice().createBuffer(() -> var0, 136, var1);
   }
}
