// Original binary: sg/ec/pEwZS7jFHxCX0Enz
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;

// $VF: Compiled from s
public final class HudBlitRenderer {
   private static final Supplier<String> field22697 = () -> HudBlitRenderer.field22717;
   private static final GuiItemAtlasHooks field22698 = new GuiItemAtlasHooks();
   private static TextureTarget field22699;
   private static RenderPipeline field22700;
   private static RenderPipeline field22701;
   private static boolean field22702;
   private static boolean field22703;
   private static boolean field22704;
   private static boolean field22705;
   private static boolean field22706;
   private static final String field22707 = "InSampler";
   private static final String field22708 = "hex";
   private static final String field22709 = "pipeline/hud_throttle_blit";
   private static final String field22710 = "core/screenquad";
   private static final String field22711 = "hex";
   private static final String field22712 = "post/hand_copy";
   private static final String field22713 = "InSampler";
   private static final String field22714 = "hex";
   private static final String field22715 = "pipeline/gui_nausea_overlay";
   private static final String field22716 = "hex hud throttle";
   private static final String field22717 = "hex hud throttle";

   public static boolean method10061() {
      Minecraft var0 = Minecraft.getInstance();
      if (method10064(var0)) {
         field22702 = false;
         field22704 = false;
         return false;
      }

      RenderTarget sx = var0.gameRenderer.mainRenderTarget();
      if (sx == null) {
         field22704 = false;
         return false;
      }

      boolean sxx = field22699 == null || field22699.width != sx.width || field22699.height != sx.height;
      boolean sxxx = var0.gui.screen() != null;
      if (field22705 && !sxxx) {
         field22702 = false;
      }

      field22705 = sxxx;
      boolean sxxxx = field22698.method06043() || !field22702 || sxx || sxxx;
      field22704 = !sxxxx;
      return field22704;
   }

   public static RenderTarget method10062() {
      return field22699;
   }

   private static void method10063(Throwable var0) {
      if (!field22706) {
         field22706 = true;
      }
   }

   private static boolean method10064(Minecraft var0) {
      return var0.gui == null || var0.gui.overlay() != null || ClientScreenManager.INSTANCE.method08318();
   }

   public static boolean method10065() {
      field22703 = false;
      Minecraft var0 = Minecraft.getInstance();
      if (method10064(var0)) {
         return false;
      }

      RenderTarget var1 = var0.gameRenderer.mainRenderTarget();
      if (var1 == null) {
         return false;
      }

      if (field22704 && field22702 && field22699 != null) {
         method10072(var0);
         method10070(var1);
         return true;
      }

      try {
         field22699 = method10066(field22699, var1.width, var1.height);
         RenderSystem.getDevice()
            .createCommandEncoder()
            .clearColorAndDepthTextures(field22699.getColorTexture(), ARGB.vector4fFromARGB32(0), field22699.getDepthTexture(), 1.0);
         field22703 = true;
      } catch (Throwable var3) {
         method10063(var3);
         field22703 = false;
      }

      return false;
   }

   private static TextureTarget method10066(TextureTarget var0, int var1, int var2) {
      if (var0 != null && var0.width == var1 && var0.height == var2) {
         return var0;
      }

      if (var0 != null) {
         var0.destroyBuffers();
      }

      return new TextureTarget(field22716, var1, var2, GpuFormat.RGBA8_UNORM, com.mojang.renderpearl.api.GpuFormat.D32_FLOAT);
   }

   private HudBlitRenderer() {
   }

   public static RenderPipeline method10067() {
      if (field22701 == null) {
         field22701 = RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field22714, field22715))
            .withColorTargetState(new ColorTargetState(Optional.of(BlendFunction.ADDITIVE), GpuFormat.RGBA8_UNORM, 7))
            .build();
      }

      return field22701;
   }

   public static boolean method10068() {
      return field22703;
   }

   private static void method10070(RenderTarget var0) {
      if (field22699 != null) {
         try {
            RenderPass var1 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field22697, var0.getColorTextureView(), Optional.empty());

            try {
               var1.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(method10071()));
               RenderSystem.bindDefaultUniforms(var1);
               var1.setUniform(field22707, field22699.getColorTextureView(), RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST));
               var1.draw(3, 1, 0, 0);
            } finally {
               var1.close();
            }
         } catch (Throwable var6) {
            method10063(var6);
         }
      }
   }

   private static RenderPipeline method10071() {
      if (field22700 == null) {
         field22700 = RenderPipeline.builder()
            .withLocation(Identifier.fromNamespaceAndPath(field22708, field22709))
            .withVertexShader(field22710)
            .withFragmentShader(Identifier.fromNamespaceAndPath(field22711, field22712))
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field22713, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
            .withColorTargetState(new ColorTargetState(Optional.of(BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA), GpuFormat.RGBA8_UNORM, 7))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field22700;
   }

   private static void method10072(Minecraft var0) {
      if (var0.gui.screen() != null && var0.options.getMenuBackgroundBlurriness() > 0) {
         try {
            var0.gameRenderer.processBlurEffect();
         } catch (Throwable var2) {
            method10063(var2);
         }
      }
   }

   public static void method10073() {
      if (field22703) {
         field22703 = false;
         field22702 = true;
         RenderTarget var0 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
         if (var0 != null) {
            method10070(var0);
         }
      }
   }
}
