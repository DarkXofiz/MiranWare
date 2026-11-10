// Original binary: sg/ec/O0u66d1ZU0pBkTOv
package sg.ec;

import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.renderpearl.api.pipeline.RenderPipeline.Builder;
import com.mojang.renderpearl.api.pipeline.BlendFactor;
import com.mojang.renderpearl.api.pipeline.CompareOp;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.PreparedRenderType.Texture;
import net.minecraft.resources.Identifier;
import org.joml.Matrix4f;

// $VF: Compiled from s
public final class HandRenderPipelines {
   public static final int field10445 = 0;
   public static final int field10446 = 0;
   public static final int field10447 = 0;
   private static final DepthStencilState field10448 = new DepthStencilState(CompareOp.EQUAL, false);
   private static final Matrix4f field10449 = new Matrix4f();
   private static final RenderPipeline field10450 = method04741(HandRenderPipelines.field10476, true);
   private static final RenderPipeline field10451 = method04741(HandRenderPipelines.field10477, false);
   private static final RenderPipeline field10452 = method04749(HandRenderPipelines.field10478, true);
   private static final RenderPipeline field10453 = method04749(HandRenderPipelines.field10479, false);
   private static final RenderPipeline field10454 = method04743(HandRenderPipelines.field10480, true);
   private static final RenderPipeline field10455 = method04743(HandRenderPipelines.field10481, false);
   private static final String field10456 = "Sampler1";
   private static final float field10457 = 255.0F;
   private static final float field10458 = 255.0F;
   private static final float field10459 = 255.0F;
   private static final float field10460 = 255.0F;
   private static final float field10461 = 255.0F;
   private static final float field10462 = 255.0F;
   private static final float field10463 = 255.0F;
   private static final float field10464 = 255.0F;
   private static final float field10465 = 255.0F;
   private static final float field10466 = 255.0F;
   private static final float field10467 = 255.0F;
   private static final float field10468 = 255.0F;
   private static final long field10469 = 100000L;
   private static final float field10470 = 1000.0F;
   private static final String field10471 = "core/hand_gloss";
   private static final String field10472 = "core/hand_item_blur";
   private static final String field10473 = "hex";
   private static final String field10474 = "hex";
   private static final String field10475 = "hex";
   private static final String field10476 = "pipeline/hand_gloss_cull";
   private static final String field10477 = "pipeline/hand_gloss_no_cull";
   private static final String field10478 = "pipeline/hand_item_blur_cull";
   private static final String field10479 = "pipeline/hand_item_blur_no_cull";
   private static final String field10480 = "pipeline/hand_capture_cull";
   private static final String field10481 = "pipeline/hand_capture_no_cull";

   public static Matrix4f method04736(Matrix4f var0, RenderPipeline var1) {
      int var2 = method04750(var1);
      if (var2 == 1) {
         return method04740();
      } else {
         return var2 == 2 ? method04737() : var0;
      }
   }

   private static Matrix4f method04737() {
      CustomHands var0 = ModuleManager.INSTANCE.method08200();
      if (var0 == null) {
         return field10449.identity();
      }

      boolean var1 = var0.method09098();
      boolean var2 = var1 && var0.method09099();
      int var3 = var0.method09103();
      int var4 = var0.method09121();
      return field10449.set(
         (var3 >> 16 & 0xFF) / field10463,
         (var3 >> 8 & 0xFF) / field10464,
         (var3 & 0xFF) / field10465,
         var1 ? 1.0F : 0.0F,
         (var4 >> 16 & 0xFF) / field10466,
         (var4 >> 8 & 0xFF) / field10467,
         (var4 & 0xFF) / field10468,
         var2 ? 1.0F : 0.0F,
         var2 ? method04744() : 0.0F,
         var0.method09101(),
         var0.method09089(),
         0.0F,
         method04738(),
         method04742(),
         0.0F,
         0.0F
      );
   }

   private static float method04738() {
      RenderTarget var0 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      return var0 == null ? 0.0F : 1.0F / var0.width;
   }

   public static RenderPipeline method04739(RenderPipeline var0) {
      int var1 = method04750(var0);
      if (var1 == 1) {
         return var0.isCull() ? field10450 : field10451;
      } else if (var1 == 2) {
         return var0.isCull() ? field10452 : field10453;
      } else if (method04746(var0) && HandGlowRenderer.method01229()) {
         return var0.isCull() ? field10454 : field10455;
      } else {
         return var0;
      }
   }

   private static Matrix4f method04740() {
      CustomHands var0 = ModuleManager.INSTANCE.method08200();
      if (var0 == null) {
         return field10449.identity();
      }

      int var1 = var0.method09127();
      int var2 = var0.method09092();
      return field10449.set(
         (var1 >> 16 & 0xFF) / field10457,
         (var1 >> 8 & 0xFF) / field10458,
         (var1 & 0xFF) / field10459,
         var0.method09130(),
         (var2 >> 16 & 0xFF) / field10460,
         (var2 >> 8 & 0xFF) / field10461,
         (var2 & 0xFF) / field10462,
         var0.method09105(),
         var0.method09102(),
         var0.method09088(),
         method04744(),
         var0.method09110() ? 1.0F : 0.0F,
         method04738(),
         method04742(),
         0.0F,
         0.0F
      );
   }

   private static RenderPipeline method04741(String var0, boolean var1) {
      return method04745(var0, field10471, var1, new ColorTargetState(new BlendFunction(BlendFactor.SRC_ALPHA, BlendFactor.ONE)), false);
   }

   private static float method04742() {
      RenderTarget var0 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      return var0 == null ? 0.0F : 1.0F / var0.height;
   }

   private static RenderPipeline method04743(String var0, boolean var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.OUTLINE_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field10473, var0))
            .withDepthStencilState(field10448)
            .withCull(var1)
            .build()
      );
   }

   private static float method04744() {
      return (float)(System.currentTimeMillis() % field10469) / field10470;
   }

   private static RenderPipeline method04745(String var0, String var1, boolean var2, ColorTargetState var3, boolean var4) {
      Builder var5 = RenderPipeline.builder(RenderPipelines.OUTLINE_SNIPPET)
         .withLocation(Identifier.fromNamespaceAndPath(field10474, var0))
         .withFragmentShader(Identifier.fromNamespaceAndPath(field10475, var1))
         .withColorTargetState(var3)
         .withDepthStencilState(field10448)
         .withCull(var2);
      if (var4) {
         var5.withBindGroupLayout(BindGroupLayouts.SAMPLER1);
      }

      return RenderPipelines.register(var5.build());
   }

   private static boolean method04746(RenderPipeline var0) {
      return var0 == RenderPipelines.OUTLINE_CULL || var0 == RenderPipelines.OUTLINE_NO_CULL;
   }

   public static List<Texture> method04747(List<Texture> var0, RenderPipeline var1) {
      if (method04750(var1) != 2) {
         return var0;
      }

      GpuTextureView var2 = HandGlowRenderer.method01207();
      if (var2 == null) {
         return var0;
      }

      var var3 = new ArrayList(var0.size() + 1);
      var3.addAll(var0);
      var3.add(new Texture(field10456, var2, RenderSystem.getSamplerCache().getClampToEdge(FilterMode.LINEAR)));
      return var3;
   }


   private static RenderPipeline method04749(String var0, boolean var1) {
      return method04745(var0, field10472, var1, new ColorTargetState(BlendFunction.TRANSLUCENT), true);
   }

   public static int method04750(RenderPipeline var0) {
      return method04746(var0) ? HandGlowRenderer.method01242() : 0;
   }

   private HandRenderPipelines() {
   }
}
