// Original binary: sg/ec/IH55bmGvsEdPNC3e
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTexture;
import java.util.Locale;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class SceneSwapRenderer {
   private static final Supplier<String> field08678 = () -> SceneSwapRenderer.field08691;
   private static RenderPipeline field08679;
   private static TextureTarget field08680;
   private static GpuFormat field08681;
   private static Boolean field08682;
   private static final String field08683 = "hex scene swap";
   private static final String field08684 = "InSampler";
   private static final String field08685 = "hex";
   private static final String field08686 = "opengl";
   private static final String field08687 = "pipeline/scene_swap_copy";
   private static final String field08688 = "core/screenquad";
   private static final String field08689 = "post/hand_copy";
   private static final String field08690 = "InSampler";
   private static final String field08691 = "hex scene swap copy";

   private static RenderPipeline method03865() {
      if (field08679 == null) {
         field08679 = RenderPipeline.builder()
            .withLocation(method03866(field08687))
            .withVertexShader(field08688)
            .withFragmentShader(method03866(field08689))
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field08690, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field08679;
   }

   public static Identifier method03866(String var0) {
      return Identifier.fromNamespaceAndPath(field08685, var0);
   }

   private static boolean method03867() {
      if (field08682 == null) {
         String var0 = RenderSystem.getDevice().getDeviceInfo().backendName();
         field08682 = var0 != null && var0.toLowerCase(Locale.ROOT).contains(field08686);
      }

      return field08682;
   }

   public static TextureTarget method03868(RenderTarget var0, CommandEncoder var1) {
      GpuTexture var2 = var0.getColorTexture();
      if (var2 == null) {
         return null;
      }

      int var3 = var0.width;
      int var4 = var0.height;
      if (field08680 == null || field08680.width != var3 || field08680.height != var4 || field08681 != var2.getFormat()) {
         if (field08680 != null) {
            field08680.destroyBuffers();
         }

         field08680 = new TextureTarget(field08683, var3, var4, var2.getFormat(), null);
         field08681 = var2.getFormat();
      }

      if (method03867()) {
         try (RenderPass var5 = var1.createRenderPass(field08678, field08680.getColorTextureView(), Optional.empty())) {
            var5.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(method03865()));
            RenderSystem.bindDefaultUniforms(var5);
            var5.setUniform(field08684, var0.getColorTextureView(), RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST));
            var5.draw(3, 1, 0, 0);
         }
      } else {
         var1.copyTextureToTexture(var2, field08680.getColorTexture(), 0, 0, 0, 0, 0, var3, var4);
      }

      return field08680;
   }

   private SceneSwapRenderer() {
   }
}
