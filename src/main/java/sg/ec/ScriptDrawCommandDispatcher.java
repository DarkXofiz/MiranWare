// Original binary: sg/ec/m4303tG72uCOwkXZ
package sg.ec;

import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.RenderPipeline.Snippet;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class ScriptDrawCommandDispatcher {
   public static final Snippet field21429 = RenderPipeline.builder().withBindGroupLayout(BindGroupLayouts.DYNAMIC_TRANSFORMS).withBindGroupLayout(BindGroupLayouts.PROJECTION).buildSnippet();
   public static final RenderPipeline field21430 = RenderPipeline.builder(field21429)
      .withLocation(ScriptDrawCommandDispatcher.field21476)
      .withVertexShader(ScriptDrawCommandDispatcher.field21477)
      .withFragmentShader(ScriptDrawCommandDispatcher.field21478)
      .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
      .withCull(false)
      .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
      .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
      .build();
   private static final Snippet field21431 = RenderPipeline.builder(field21429)
      .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21445))
      .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21446))
      .withVertexBinding(0, VertexFormats.field09862)
      .withPrimitiveTopology(PrimitiveTopology.QUADS)
      .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
      .buildSnippet();
   private static final Snippet field21432 = RenderPipeline.builder(field21429)
      .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21447))
      .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21448))
      .withVertexBinding(0, VertexFormats.field09865)
      .withPrimitiveTopology(PrimitiveTopology.QUADS)
      .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
      .buildSnippet();
   private static final Snippet field21433 = RenderPipeline.builder(field21429)
      .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21449))
      .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21450))
      .withVertexBinding(0, VertexFormats.field09863)
      .withPrimitiveTopology(PrimitiveTopology.QUADS)
      .withBindGroupLayout(BindGroupLayouts.SAMPLER0)
      .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
      .buildSnippet();
   private static final Snippet field21434 = RenderPipeline.builder(field21429)
      .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21451))
      .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21452))
      .withVertexBinding(0, VertexFormats.field09864)
      .withPrimitiveTopology(PrimitiveTopology.QUADS)
      .withBindGroupLayout(BindGroupLayouts.SAMPLER0)
      .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
      .buildSnippet();
   private static final Snippet field21435 = RenderPipeline.builder(field21429)
      .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21453))
      .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21454))
      .withVertexBinding(0, VertexFormats.field09866)
      .withPrimitiveTopology(PrimitiveTopology.QUADS)
      .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
      .withBindGroupLayout(BindGroupLayouts.SAMPLER0_SAMPLER1)
      .buildSnippet();
   public static final RenderPipeline field21436 = RenderPipelines.register(
      RenderPipeline.builder(field21431)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21455.toLowerCase(), ScriptDrawCommandDispatcher.field21456))
         .build()
   );
   public static final RenderPipeline field21437 = RenderPipelines.register(
      RenderPipeline.builder(field21433)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21457.toLowerCase(), ScriptDrawCommandDispatcher.field21458))
         .build()
   );
   public static final RenderPipeline field21438 = RenderPipelines.register(
      RenderPipeline.builder(field21432)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21459.toLowerCase(), ScriptDrawCommandDispatcher.field21460))
         .build()
   );
   public static final RenderPipeline field21439 = RenderPipelines.register(
      RenderPipeline.builder(field21434)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21461.toLowerCase(), ScriptDrawCommandDispatcher.field21462))
         .build()
   );
   public static final RenderPipeline field21440 = RenderPipelines.register(
      RenderPipeline.builder(field21435)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21463.toLowerCase(), ScriptDrawCommandDispatcher.field21464))
         .build()
   );
   public static final RenderPipeline field21441 = RenderPipelines.register(
      RenderPipeline.builder(field21429)
         .withLocation(ScriptDrawCommandDispatcher.field21465)
         .withVertexShader(ScriptDrawCommandDispatcher.field21466)
         .withFragmentShader(ScriptDrawCommandDispatcher.field21467)
         .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
         .withCull(false)
         .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
         .withPrimitiveTopology(PrimitiveTopology.QUADS)
         .build()
   );
   public static final RenderPipeline field21442 = RenderPipelines.register(
      RenderPipeline.builder(field21429)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21468.toLowerCase(), ScriptDrawCommandDispatcher.field21469))
         .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21470))
         .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21471))
         .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
         .withCull(false)
         .withVertexBinding(0, VertexFormats.field09867)
         .withPrimitiveTopology(PrimitiveTopology.QUADS)
         .build()
   );
   public static final RenderPipeline field21443 = RenderPipelines.register(
      RenderPipeline.builder(field21429)
         .withLocation(Identifier.fromNamespaceAndPath(ScriptDrawCommandDispatcher.field21472.toLowerCase(), ScriptDrawCommandDispatcher.field21473))
         .withVertexShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21474))
         .withFragmentShader(ResourceLoader.method04276(ScriptDrawCommandDispatcher.field21475))
         .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
         .withCull(false)
         .withVertexBinding(0, VertexFormats.field09866)
         .withPrimitiveTopology(PrimitiveTopology.QUADS)
         .build()
   );
   private static final String field21444 = "This is a utility class and cannot be instantiated";
   private static final String field21445 = "rectangle";
   private static final String field21446 = "rectangle";
   private static final String field21447 = "border";
   private static final String field21448 = "border";
   private static final String field21449 = "texture";
   private static final String field21450 = "texture";
   private static final String field21451 = "msdf_font";
   private static final String field21452 = "msdf_font";
   private static final String field21453 = "blur";
   private static final String field21454 = "blur";
   private static final String field21455 = "Hex";
   private static final String field21456 = "pipeline/rectangle";
   private static final String field21457 = "Hex";
   private static final String field21458 = "pipeline/texture";
   private static final String field21459 = "Hex";
   private static final String field21460 = "pipeline/border";
   private static final String field21461 = "Hex";
   private static final String field21462 = "pipeline/msdf_font";
   private static final String field21463 = "Hex";
   private static final String field21464 = "pipeline/blur";
   private static final String field21465 = "pipeline/circle";
   private static final String field21466 = "core/position_color";
   private static final String field21467 = "core/position_color";
   private static final String field21468 = "Hex";
   private static final String field21469 = "pipeline/circle_outline";
   private static final String field21470 = "circle_outline";
   private static final String field21471 = "circle_outline";
   private static final String field21472 = "Hex";
   private static final String field21473 = "pipeline/glow_outline";
   private static final String field21474 = "glow_outline";
   private static final String field21475 = "glow_outline";
   private static final String field21476 = "pipeline/position_color";
   private static final String field21477 = "core/position_color";
   private static final String field21478 = "core/position_color";

   private ScriptDrawCommandDispatcher() {
      throw new UnsupportedOperationException(field21444);
   }
}
