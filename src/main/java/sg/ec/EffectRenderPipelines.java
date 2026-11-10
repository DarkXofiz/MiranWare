// Original binary: sg/ec/SkkS2bbjdwj6Omzc
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.DepthStencilState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.BlendFactor;
import com.mojang.renderpearl.api.pipeline.CompareOp;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.AddressMode;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderSetup.OutlineProperty;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

// $VF: Compiled from s
public final class EffectRenderPipelines {
   private static final DepthStencilState field11804 = new DepthStencilState(CompareOp.ALWAYS_PASS, false);
   private static final DepthStencilState field11805 = new DepthStencilState(CompareOp.GREATER_THAN_OR_EQUAL, true);
   private static final float field11806 = 1.0F;
   private static final float field11807 = 0;
   public static final RenderPipeline field11808 = method05529(EffectRenderPipelines.field11900, field11804);
   public static final RenderPipeline field11809 = method05529(EffectRenderPipelines.field11901, field11805);
   private static final RenderPipeline field11810 = method05523(EffectRenderPipelines.field11902, field11804);
   private static final RenderPipeline field11811 = method05523(EffectRenderPipelines.field11903, new DepthStencilState(field11805.depthTest(), false));
   private static final RenderPipeline field11812 = method05545();
   private static final RenderPipeline field11813 = method05521(EffectRenderPipelines.field11904, field11804);
   private static final RenderPipeline field11814 = method05521(EffectRenderPipelines.field11905, field11805);
   private static final RenderPipeline field11815 = method05534(EffectRenderPipelines.field11906, EffectRenderPipelines.field11907, BlendFunction.OVERLAY);
   private static final RenderPipeline field11816 = method05534(EffectRenderPipelines.field11908, EffectRenderPipelines.field11909, BlendFunction.TRANSLUCENT);
   private static final RenderPipeline field11817 = method05557(EffectRenderPipelines.field11910, PrimitiveTopology.QUADS, field11804, false);
   private static final RenderPipeline field11818 = method05559(EffectRenderPipelines.field11911, PrimitiveTopology.DEBUG_LINES, field11804, true);
   private static final RenderPipeline field11819 = method05559(EffectRenderPipelines.field11912, PrimitiveTopology.DEBUG_LINES, field11804, false);
   private static final RenderType field11820 = RenderType.create(EffectRenderPipelines.field11913, method05526(field11810));
   private static final RenderType field11821 = RenderType.create(EffectRenderPipelines.field11914, method05526(field11811));
   private static final RenderType field11822 = RenderType.create(
      EffectRenderPipelines.field11915, method05516(field11813, ClientTextures.INSTANCE.method04571())
   );
   private static final RenderType field11823 = RenderType.create(
      EffectRenderPipelines.field11916, method05516(field11814, ClientTextures.INSTANCE.method04571())
   );
   private static final RenderPipeline field11824 = method05539(
      EffectRenderPipelines.field11917, PrimitiveTopology.TRIANGLE_STRIP, field11804, false, BlendFunction.OVERLAY
   );
   private static final RenderPipeline field11825 = method05539(
      EffectRenderPipelines.field11918, PrimitiveTopology.DEBUG_LINE_STRIP, field11804, false, BlendFunction.OVERLAY
   );
   private static final RenderPipeline field11826 = method05544(EffectRenderPipelines.field11919, field11804, BlendFunction.OVERLAY);
   private static final DepthStencilState field11827 = new DepthStencilState(field11805.depthTest(), false);
   private static final RenderPipeline field11828 = method05539(
      EffectRenderPipelines.field11920, PrimitiveTopology.TRIANGLE_STRIP, field11827, false, BlendFunction.TRANSLUCENT
   );
   private static final RenderPipeline field11829 = method05523(EffectRenderPipelines.field11921, field11827);
   private static final RenderType field11830 = RenderType.create(EffectRenderPipelines.field11922, method05526(field11819));
   public static final BlendFunction field11831 = new BlendFunction(BlendFactor.SRC_ALPHA, BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ZERO);
   private static final int field11832 = 0;
   private static final int field11833 = 0;
   private static final Map<Integer, RenderType> field11834 = new HashMap<>();
   private static final Map<Integer, Function<Identifier, RenderType>> field11835 = new HashMap<>();
   private static final Map<Integer, RenderType> field11836 = new HashMap<>();
   private static final Map<RenderPipeline, RenderType> field11837 = new HashMap<>();
   private static final Map<RenderPipeline, Function<Identifier, RenderType>> field11838 = new HashMap<>();
   private static final RenderType field11839 = RenderType.create(
      EffectRenderPipelines.field11923, method05516(field11815, ClientTextures.INSTANCE.method04582())
   );
   private static final RenderType field11840 = RenderType.create(EffectRenderPipelines.field11924, method05526(field11816));
   private static final RenderType field11841 = RenderType.create(EffectRenderPipelines.field11925, method05526(field11824));
   private static final RenderType field11842 = RenderType.create(EffectRenderPipelines.field11926, method05526(field11825));
   private static final RenderType field11843 = RenderType.create(EffectRenderPipelines.field11927, method05526(field11826));
   private static final RenderType field11844 = RenderType.create(EffectRenderPipelines.field11928, method05526(field11828));
   private static final RenderType field11845 = RenderType.create(EffectRenderPipelines.field11929, method05526(field11829));
   private static final Function<Identifier, RenderType> field11846 = Util.memoize(
      var0 -> RenderType.create(EffectRenderPipelines.field11896, method05518(field11812, var0))
   );
   private static GpuSampler field11847;
   private static final RenderPipeline field11848 = method05524();
   private static final Function<Identifier, RenderType> field11849 = Util.memoize(
      var0 -> RenderType.create(EffectRenderPipelines.field11895, method05516(field11848, var0))
   );
   private static final RenderPipeline field11850 = method05554(EffectRenderPipelines.field11930, field11804);
   private static final Function<Identifier, RenderType> field11851 = Util.memoize(
      var0 -> RenderType.create(EffectRenderPipelines.field11894, method05516(field11850, var0))
   );
   private static final RenderPipeline field11852 = method05554(EffectRenderPipelines.field11931, field11805);
   private static final Function<Identifier, RenderType> field11853 = Util.memoize(
      var0 -> RenderType.create(EffectRenderPipelines.field11893, method05516(field11852, var0))
   );
   private static final Function<Identifier, RenderType> field11854 = Util.memoize(
      var0 -> RenderType.create(EffectRenderPipelines.field11892, method05516(field11817, var0))
   );
   private static final RenderType field11855 = RenderType.create(EffectRenderPipelines.field11932, method05526(field11818));
   public static final RenderType field11856 = RenderType.create(EffectRenderPipelines.field11933, method05526(field11808));
   public static final RenderType field11857 = RenderType.create(EffectRenderPipelines.field11934, method05526(field11809));
   private static final RenderPipeline field11858 = method05559(EffectRenderPipelines.field11935, PrimitiveTopology.TRIANGLE_STRIP, field11805, false);
   private static final RenderPipeline field11859 = method05523(
      EffectRenderPipelines.field11936, new DepthStencilState(field11805.depthTest(), false, 0.0F, EffectRenderPipelines.field11937)
   );
   private static final RenderPipeline field11860 = method05530(EffectRenderPipelines.field11938, PrimitiveTopology.TRIANGLE_STRIP, field11805, false);
   private static final RenderType field11861 = RenderType.create(EffectRenderPipelines.field11939, method05526(field11858));
   private static final RenderType field11862 = RenderType.create(EffectRenderPipelines.field11940, method05526(field11859));
   private static final RenderType field11863 = RenderType.create(
      EffectRenderPipelines.field11941,
      RenderSetup.builder(field11860).setOutline(OutlineProperty.IS_OUTLINE).createRenderSetup()
   );
   private static final String field11864 = "Hex";
   private static final String field11865 = "Hex";
   private static final String field11866 = "jump_circle";
   private static final String field11867 = "JumpCircle";
   private static final float field11868 = 8.0F;
   private static final String field11869 = "Hex";
   private static final String field11870 = "pipeline/kill_skin";
   private static final String field11871 = "Hex";
   private static final String field11872 = "ghost_model";
   private static final String field11873 = "ghost_model";
   private static final String field11874 = "Hex";
   private static final String field11875 = "Hex";
   private static final String field11876 = "Hex";
   private static final String field11877 = "Hex";
   private static final String field11878 = "prediction_line";
   private static final String field11879 = "prediction_line";
   private static final String field11880 = "Hex";
   private static final String field11881 = "Hex";
   private static final String field11882 = "particle";
   private static final String field11883 = "particle";
   private static final String field11884 = "Hex";
   private static final String field11885 = "pipeline/particle";
   private static final String field11886 = "particle";
   private static final String field11887 = "particle";
   private static final String field11888 = "Hex";
   private static final String field11889 = "Sampler0";
   private static final String field11890 = "Sampler0";
   private static final String field11891 = "This is a utility class and cannot be instantiated";
   private static final String field11892 = "3DTargetESPQuad";
   private static final String field11893 = "crystal_ghost";
   private static final String field11894 = "ghost_model";
   private static final String field11895 = "kill_skin";
   private static final String field11896 = "3DParticle";
   private static final String field11897 = "script_mesh_tex_";
   private static final String field11898 = "script_mesh_";
   private static final String field11899 = "script_lines_";
   private static final String field11900 = "pipeline/entity_highlight";
   private static final String field11901 = "pipeline/translucent_glow";
   private static final String field11902 = "pipeline/prediction_line";
   private static final String field11903 = "pipeline/trail_line";
   private static final String field11904 = "pipeline/target_esp_depth";
   private static final String field11905 = "pipeline/target_esp_no_depth";
   private static final String field11906 = "pipeline/jump_circles";
   private static final String field11907 = "jump_circle";
   private static final String field11908 = "pipeline/jump_warp";
   private static final String field11909 = "jump_warp";
   private static final String field11910 = "pipeline/target_esp_quad";
   private static final String field11911 = "pipeline/box_target";
   private static final String field11912 = "pipeline/box";
   private static final String field11913 = "prediction_line";
   private static final String field11914 = "trail_line";
   private static final String field11915 = "3DTargetESPDepth";
   private static final String field11916 = "3DTargetESPNoDepth";
   private static final String field11917 = "pipeline/target_esp_circle_1";
   private static final String field11918 = "pipeline/target_esp_circle_2";
   private static final String field11919 = "pipeline/target_esp_circle_line";
   private static final String field11920 = "pipeline/target_esp_old_circle_wall";
   private static final String field11921 = "pipeline/target_esp_old_circle_line";
   private static final String field11922 = "3DBox";
   private static final String field11923 = "3DJumpCircles";
   private static final String field11924 = "3DJumpWarp";
   private static final String field11925 = "3DTargetESPCircle1";
   private static final String field11926 = "3DTargetESPCircle2";
   private static final String field11927 = "3DTargetESPCircleLine";
   private static final String field11928 = "3DTargetESPOldCircleWall";
   private static final String field11929 = "3DTargetESPOldCircleLine";
   private static final String field11930 = "pipeline/ghost_model";
   private static final String field11931 = "pipeline/crystal_ghost";
   private static final String field11932 = "3DBox_Target";
   private static final String field11933 = "lines_Entity";
   private static final String field11934 = "lines_Glow";
   private static final String field11935 = "pipeline/china_hat";
   private static final String field11936 = "pipeline/china_hat_line";
   private static final float field11937 = 5.0F;
   private static final String field11938 = "pipeline/china_hat_outline";
   private static final String field11939 = "china_hat";
   private static final String field11940 = "china_hat_line";
   private static final String field11941 = "china_hat_outline";

   public static RenderType method05513(int var0) {
      return field11834.computeIfAbsent(
         var0, var0x -> RenderType.create("3DScriptMesh" + var0x, method05526(method05515(field11898, var0x, PrimitiveTopology.TRIANGLES, false)))
      );
   }

   public static RenderType method05514() {
      return field11842;
   }

   private static RenderPipeline method05515(String var0, int var1, PrimitiveTopology var2, boolean var3) {
      int var4 = var1 / 6;
      int var5 = var1 / 2 % 3;
      boolean var6 = (var1 & 1) != 0;
      return RenderPipeline.builder(var3 ? RenderPipelines.GUI_TEXTURED_SNIPPET : RenderPipelines.DEBUG_FILLED_SNIPPET)
         .withLocation(Identifier.fromNamespaceAndPath(field11864.toLowerCase(), "pipeline/" + var0 + var1))
         .withVertexBinding(0, var3 ? DefaultVertexFormat.POSITION_TEX_COLOR : DefaultVertexFormat.POSITION_COLOR)
         .withPrimitiveTopology(var2)
         .withColorTargetState(method05551(var4))
         .withDepthStencilState(method05546(var5))
         .withCull(var6)
         .build();
   }

   private static RenderSetup method05516(RenderPipeline var0, Identifier var1) {
      return RenderSetup.builder(var0).withTexture(field11889, var1).createRenderSetup();
   }

   private static RenderSetup method05518(RenderPipeline var0, Identifier var1) {
      return RenderSetup.builder(var0).withTexture(field11890, var1, EffectRenderPipelines::method05558).createRenderSetup();
   }

   public static RenderType method05519() {
      return field11821;
   }

   public static int method05520(int var0, int var1, boolean var2) {
      int var3 = Math.max(0, Math.min(2, var0));
      int var4 = Math.max(0, Math.min(2, var1));
      return (var3 * 3 + var4) * 2 + (var2 ? 1 : 0);
   }

   private static RenderPipeline method05521(String var0, DepthStencilState var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11881.toLowerCase(), var0))
            .withVertexShader(ResourceLoader.method04276(field11882))
            .withFragmentShader(ResourceLoader.method04276(field11883))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR)
            .withPrimitiveTopology(PrimitiveTopology.QUADS)
            .withColorTargetState(new ColorTargetState(new BlendFunction(BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ZERO)))
            .withDepthStencilState(new DepthStencilState(var1.depthTest(), false))
            .withCull(true)
            .build()
      );
   }

   private static RenderPipeline method05523(String var0, DepthStencilState var1) {
      return method05544(var0, var1, BlendFunction.TRANSLUCENT);
   }

   private static RenderPipeline method05524() {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11869.toLowerCase(), field11870))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR)
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
            .withDepthStencilState(new DepthStencilState(field11805.depthTest(), false))
            .withCull(false)
            .build()
      );
   }

   private static RenderSetup method05526(RenderPipeline var0) {
      return RenderSetup.builder(var0).createRenderSetup();
   }

   public static RenderType method05527() {
      return field11841;
   }

   public static RenderType method05528() {
      return field11843;
   }

   private static RenderPipeline method05529(String var0, DepthStencilState var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.DEBUG_FILLED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11876.toLowerCase(), var0))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
            .withPrimitiveTopology(PrimitiveTopology.QUADS)
            .withColorTargetState(new ColorTargetState(Optional.of(BlendFunction.TRANSLUCENT), GpuFormat.RGBA8_UNORM, 7))
            .withDepthStencilState(new DepthStencilState(var1.depthTest(), false))
            .withCull(false)
            .build()
      );
   }

   private static RenderPipeline method05530(String var0, PrimitiveTopology var1, DepthStencilState var2, boolean var3) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.DEBUG_FILLED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11875.toLowerCase(), var0))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
            .withPrimitiveTopology(var1)
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withDepthStencilState(var2)
            .withCull(var3)
            .build()
      );
   }

   public static RenderType method05531() {
      return field11845;
   }

   public static RenderType method05532(Identifier var0) {
      return field11854.apply(var0);
   }

   public static RenderType method05533() {
      return field11861;
   }

   private static RenderPipeline method05534(String var0, String var1, BlendFunction var2) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11865.toLowerCase(), var0))
            .withVertexShader(ResourceLoader.method04276(field11866))
            .withFragmentShader(ResourceLoader.method04276(var1))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX)
            .withPrimitiveTopology(PrimitiveTopology.QUADS)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field11867, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(new ColorTargetState(var2))
            .withDepthStencilState(new DepthStencilState(field11805.depthTest(), false, 1.0F, field11868))
            .withCull(false)
            .build()
      );
   }

   public static RenderType method05535(Identifier var0) {
      return field11851.apply(var0);
   }

   public static RenderType method05537(RenderPipeline var0, Identifier var1) {
      if (var0 == null) {
         return null;
      } else {
         return var1 == null
            ? field11837.computeIfAbsent(var0, var0x -> RenderType.create("3DScriptWorld" + var0x.getLocation().getPath(), method05526(var0x)))
            : field11838.computeIfAbsent(
                  var0, var0x -> Util.memoize(var1x -> RenderType.create("3DScriptWorldTex" + var0x.getLocation().getPath(), method05518(var0x, var1x)))
               )
               .apply(var1);
      }
   }

   public static RenderType method05538() {
      return field11863;
   }

   private static RenderPipeline method05539(String var0, PrimitiveTopology var1, DepthStencilState var2, boolean var3, BlendFunction var4) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.DEBUG_FILLED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11874.toLowerCase(), var0))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR)
            .withPrimitiveTopology(var1)
            .withColorTargetState(new ColorTargetState(var4))
            .withDepthStencilState(var2)
            .withCull(var3)
            .build()
      );
   }

   public static RenderType method05541(Identifier var0) {
      return field11846.apply(var0);
   }

   public static RenderType method05542() {
      return field11844;
   }

   private static RenderPipeline method05543(String var0, DepthStencilState var1, double var2) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.LINES_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11880.toLowerCase(), var0))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR_NORMAL_LINE_WIDTH)
            .withPrimitiveTopology(PrimitiveTopology.LINES)
            .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
            .withDepthStencilState(new DepthStencilState(var1.depthTest(), var1.writeDepth(), 0.0F, (float)var2))
            .withCull(true)
            .build()
      );
   }

   private static RenderPipeline method05544(String var0, DepthStencilState var1, BlendFunction var2) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.LINES_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11877.toLowerCase(), var0))
            .withVertexShader(ResourceLoader.method04276(field11878))
            .withFragmentShader(ResourceLoader.method04276(field11879))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_COLOR_NORMAL_LINE_WIDTH)
            .withPrimitiveTopology(PrimitiveTopology.LINES)
            .withColorTargetState(new ColorTargetState(var2))
            .withDepthStencilState(var1)
            .withCull(false)
            .build()
      );
   }

   private static RenderPipeline method05545() {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11884.toLowerCase(), field11885))
            .withVertexShader(ResourceLoader.method04276(field11886))
            .withFragmentShader(ResourceLoader.method04276(field11887))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR)
            .withPrimitiveTopology(PrimitiveTopology.QUADS)
            .withColorTargetState(new ColorTargetState(new BlendFunction(BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ONE, BlendFactor.ZERO)))
            .withDepthStencilState(new DepthStencilState(field11805.depthTest(), false))
            .withCull(true)
            .build()
      );
   }

   public static DepthStencilState method05546(int var0) {
      return switch (var0) {
         case 1 -> field11827;
         case 2 -> field11805;
         default -> field11804;
      };
   }

   public static void method05547() {
      field11837.clear();
      field11838.clear();
   }

   public static RenderType method05548() {
      return field11839;
   }

   public static ColorTargetState method05551(int var0) {
      return switch (var0) {
         case 1 -> new ColorTargetState(field11831);
         case 2 -> new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15);
         default -> new ColorTargetState(BlendFunction.TRANSLUCENT);
      };
   }

   public static RenderType method05552() {
      return field11855;
   }

   public static RenderType method05553(boolean var0) {
      return var0 ? field11822 : field11823;
   }

   private static RenderPipeline method05554(String var0, DepthStencilState var1) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11871.toLowerCase(), var0))
            .withVertexShader(ResourceLoader.method04276(field11872))
            .withFragmentShader(ResourceLoader.method04276(field11873))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR_NORMAL)
            .withPrimitiveTopology(PrimitiveTopology.QUADS)
            .withColorTargetState(new ColorTargetState(BlendFunction.OVERLAY))
            .withDepthStencilState(new DepthStencilState(var1.depthTest(), false))
            .withCull(false)
            .build()
      );
   }

   public static RenderType method05555() {
      return field11862;
   }

   private static RenderPipeline method05557(String var0, PrimitiveTopology var1, DepthStencilState var2, boolean var3) {
      return RenderPipelines.register(
         RenderPipeline.builder(RenderPipelines.GUI_TEXTURED_SNIPPET)
            .withLocation(Identifier.fromNamespaceAndPath(field11888.toLowerCase(), var0))
            .withVertexBinding(0, DefaultVertexFormat.POSITION_TEX_COLOR)
            .withPrimitiveTopology(var1)
            .withColorTargetState(new ColorTargetState(BlendFunction.OVERLAY))
            .withDepthStencilState(new DepthStencilState(var2.depthTest(), false))
            .withCull(var3)
            .build()
      );
   }

   private static GpuSampler method05558() {
      if (field11847 == null) {
         field11847 = RenderSystem.getDevice()
            .createSampler(AddressMode.CLAMP_TO_EDGE, AddressMode.CLAMP_TO_EDGE, FilterMode.LINEAR, FilterMode.LINEAR, 1, OptionalDouble.empty());
      }

      return field11847;
   }

   private static RenderPipeline method05559(String var0, PrimitiveTopology var1, DepthStencilState var2, boolean var3) {
      return method05539(var0, var1, var2, var3, BlendFunction.TRANSLUCENT);
   }

   public static RenderType method05561(Identifier var0) {
      return field11853.apply(var0);
   }

   public static RenderType method05562() {
      return field11830;
   }

   public static RenderType method05563() {
      return field11820;
   }

   private EffectRenderPipelines() {
      throw new UnsupportedOperationException(field11891);
   }

   public static RenderType method05565(Identifier var0, int var1) {
      return field11835.computeIfAbsent(
            var1,
            var0x -> Util.memoize(
               var1x -> RenderType.create("3DScriptMeshTex" + var0x, method05518(method05515(field11897, var0x, PrimitiveTopology.TRIANGLES, true), var1x))
            )
         )
         .apply(var0);
   }

   public static RenderType method05567(int var0) {
      return field11836.computeIfAbsent(
         var0, var0x -> RenderType.create("3DScriptLines" + var0x, method05526(method05515(field11899, var0x, PrimitiveTopology.DEBUG_LINES, false)))
      );
   }

   public static RenderPipeline method05568() {
      return field11810;
   }

   public static RenderType method05569(Identifier var0) {
      return field11849.apply(var0);
   }

   public static RenderType method05570() {
      return field11840;
   }
}
