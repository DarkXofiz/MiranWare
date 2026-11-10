// Original binary: sg/ec/vnOEr6duUS9hjGmk
package sg.ec;

import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.BlendFactor;
import com.mojang.renderpearl.api.pipeline.CompareOp;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.InteractionHand;

// $VF: Compiled from s
public class ParticleRenderer {
   public static float field24961 = ParticleRenderer.field24973;
   private static final DepthStencilState field24962 = new DepthStencilState(CompareOp.ALWAYS_PASS, false);
   private static final RenderPipeline field24963 = method11150(
      ParticleRenderer.field24974, new BlendFunction(BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ZERO)
   );
   private static final RenderPipeline field24964 = method11150(ParticleRenderer.field24975, BlendFunction.TRANSLUCENT_PREMULTIPLIED_ALPHA);
   private static final Function<Identifier, RenderType> field24965 = Util.memoize(
      var0 -> RenderType.create(ParticleRenderer.field24972, method11146(field24963, var0))
   );
   private static final Function<Identifier, RenderType> field24966 = Util.memoize(
      var0 -> RenderType.create(ParticleRenderer.field24971, method11146(field24964, var0))
   );
   private static final String field24967 = "Hex";
   private static final String field24968 = "particle";
   private static final String field24969 = "particle";
   private static final String field24970 = "Sampler0";
   private static final String field24971 = "hmi_particle_translucent";
   private static final String field24972 = "hmi_particle_additive";
   private static final float field24973 = 0.016666668F;
   private static final String field24974 = "pipeline/hmi_particle_additive";
   private static final String field24975 = "pipeline/hmi_particle_translucent";

   private static RenderSetup method11146(RenderPipeline var0, Identifier var1) {
      return RenderSetup.builder(var0).withTexture(field24970, var1).createRenderSetup();
   }

   public static void method11149(
      List<ParticleAnimationConfig> var0,
      PoseStack var1,
      SubmitNodeCollector var2,
      String var3,
      InteractionHand var4,
      int var5,
      AbstractClientPlayer var6,
      float var7
   ) {
      var var8 = var0.iterator();

      while (var8.hasNext()) {
         ParticleAnimationConfig var9 = (ParticleAnimationConfig)var8.next();
         if (var9.field08002) {
            var8.remove();
         } else if (var3.equals(var9.field08001) && var9.field08023 == var4) {
            if (var9.field08026 != null) {
               var9.method03621(var9.field08026, var2, var5, var6, var7);
            } else {
               var9.method03621(var1, var2, var5, var6, var7);
            }

            var9.method03623();
         }
      }
   }

   private static RenderPipeline method11150(String var0, BlendFunction var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field24967.toLowerCase(Locale.ROOT), var0))
            .withVertexShader(ResourceLoader.method04276(field24968))
            .withFragmentShader(ResourceLoader.method04276(field24969))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR)
            .withPrimitiveTopology(PrimitiveTopology.QUADS)
            .withColorTargetState(new ColorTargetState(var1))
            .withDepthStencilState(field24962)
            .withCull(false)
            .build()
      );
   }

   public static RenderType method11151(Identifier var0) {
      return field24966.apply(var0);
   }

   public static RenderType method11152(Identifier var0) {
      return field24965.apply(var0);
   }
}
