// Original binary: sg/ec/uL7v4aIuLhODXXR0
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.renderpearl.api.pipeline.RenderPipeline.Builder;
import com.mojang.renderpearl.api.vertex.VertexFormat;
import hex.script.api.Shader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class ScriptShaderManager implements MinecraftAccess {
   public static final VertexFormat field24567 = VertexFormat.builder(0)
      .addAttribute(ScriptShaderManager.field24587, GpuFormat.RGB32_FLOAT)
      .addAttribute(ScriptShaderManager.field24588, GpuFormat.RGBA8_UNORM)
      .addAttribute(ScriptShaderManager.field24589, GpuFormat.RG32_FLOAT)
      .addAttribute(ScriptShaderManager.field24590, GpuFormat.RG16_SINT)
      .addAttribute(ScriptShaderManager.field24591, GpuFormat.RG16_SINT)
      .addAttribute(ScriptShaderManager.field24592, GpuFormat.R32_FLOAT)
      .build();
   private static final Map<String, RenderPipeline> field24568 = new LinkedHashMap<>();
   private static final Map<String, RenderPipeline> field24569 = new LinkedHashMap<>();
   private static final Map<String, RenderPipeline> field24570 = new LinkedHashMap<>();
   private static final Map<String, RenderPipeline> field24571 = new LinkedHashMap<>();
   private static final Map<String, String> field24572 = new LinkedHashMap<>();
   private static final Set<String> field24573 = new HashSet<>();
   private static boolean field24574;
   private static boolean field24575;
   private static final String field24576 = "quad_";
   private static final String field24577 = "mesh_";
   private static final String field24578 = "_tex";
   private static final String field24579 = "пак скриптов ещё не перезагрузился";
   private static final String field24580 = "шейдер не собрался, подробности в логе игры";
   private static final String field24581 = "shaders/core";
   private static final String field24582 = "пак скриптов ещё не перезагрузился";
   private static final String field24583 = "script";
   private static final String field24584 = "shader";
   private static final String field24585 = "This is a utility class and cannot be instantiated";
   private static final String field24586 = "mesh_";
   private static final String field24587 = "Position";
   private static final String field24588 = "Color";
   private static final String field24589 = "UV0";
   private static final String field24590 = "UV1";
   private static final String field24591 = "UV2";
   private static final String field24592 = "LineWidth";

   public static boolean method10927() {
      boolean var0 = field24575;
      field24575 = false;
      return var0;
   }

   public static boolean method10928(String var0) {
      RenderPipeline var1 = field24568.get(var0);
      if (var1 == null) {
         return false;
      }

      if (!method10941(var0)) {
         field24572.putIfAbsent(var0, field24579);
         field24575 = true;
         return false;
      }

      boolean var2 = RenderPipelineCache.method10799(var1);
      if (var2) {
         field24572.remove(var0);
      } else {
         field24572.putIfAbsent(var0, field24580);
      }

      return var2;
   }

   public static boolean method10929() {
      boolean var0 = field24574;
      field24574 = false;
      return var0;
   }

   public static Shader method10931(String var0) {
      String var1 = method10936(var0);
      field24568.computeIfAbsent(var1, ScriptShaderManager::method10948);
      return new Shader(var1, field24572::get);
   }

   public static RenderPipeline method10932(String var0, int var1) {
      if (var0 == null) {
         return null;
      } else {
         return var1 <= 0
            ? field24569.computeIfAbsent(var0, var0x -> method10938(var0x, PrimitiveTopology.TRIANGLES, field24586))
            : method10947(var0, PrimitiveTopology.TRIANGLES, var1, field24577);
      }
   }

   public static RenderPipeline method10933(String var0, int var1, boolean var2) {
      if (var0 != null && !var0.isEmpty()) {
         String var3 = method10936(var0);
         String var4 = var3 + "_" + var1 + (var2 ? field24578 : "");
         return field24570.computeIfAbsent(var4, var4x -> method10942(var3, var4, var1, var2));
      } else {
         return null;
      }
   }

   private static Identifier method10934(String var0) {
      return Identifier.fromNamespaceAndPath(field24583, var0);
   }

   public static RenderPipeline method10935(String var0) {
      return method10932(var0, 0);
   }

   private static String method10936(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = Character.toLowerCase(var0.charAt(var2));
            var1.append(!Character.isLetterOrDigit(var3) && var3 != '_' ? '_' : var3);
         }

         return var1.toString();
      } else {
         return field24584;
      }
   }

   private static RenderPipeline method10938(String var0, PrimitiveTopology var1, String var2) {
      try {
         return RenderPipeline.builder()
            .withBindGroupLayout(BindGroupLayouts.DYNAMIC_TRANSFORMS).withBindGroupLayout(BindGroupLayouts.PROJECTION)
            .withLocation(method10934("pipeline/script_" + var2 + var0))
            .withVertexShader(method10934("core/" + var0))
            .withFragmentShader(method10934("core/" + var0))
            .withVertexBinding(0, field24567)
            .withPrimitiveTopology(var1)
            .withColorTargetState(new ColorTargetState(BlendFunction.TRANSLUCENT))
            .build();
      } catch (Throwable var4) {
         field24572.put(var0, String.valueOf(var4));
         return null;
      }
   }

   private ScriptShaderManager() {
      throw new UnsupportedOperationException(field24585);
   }

   private static void method10939(String var0, String var1) {
      if (var1 != null && !var1.isEmpty()) {
         try {
            Path var2 = new File(ScriptManager.method01289(), field24581).toPath();
            Files.createDirectories(var2);
            Path var3 = var2.resolve(var0);
            if (Files.isRegularFile(var3) && var1.equals(Files.readString(var3, StandardCharsets.UTF_8))) {
               return;
            }

            Files.writeString(var3, var1, StandardCharsets.UTF_8);
            field24574 = true;
         } catch (IOException var4) {
            field24572.put(var0, "не записался: " + var4.getMessage());
         }
      }
   }

   public static void method10940() {
      field24568.clear();
      field24569.clear();
      field24570.clear();
      field24571.clear();
      EffectRenderPipelines.method05547();
      field24572.clear();
      field24573.clear();
      RenderPipelineCache.method10800();
   }

   private static boolean method10941(String var0) {
      if (field24573.contains(var0)) {
         return true;
      }

      if (mc != null && mc.getResourceManager() != null) {
         String var1 = method10936(var0);
         if (mc.getResourceManager().getResource(method10934("shaders/core/" + var1 + ".vsh")).isEmpty()) {
            return false;
         }

         field24573.add(var0);
         field24573.add(var1);
         return true;
      } else {
         return false;
      }
   }

   private static RenderPipeline method10942(String var0, String var1, int var2, boolean var3) {
      try {
         Builder var4 = RenderPipeline.builder()
            .withBindGroupLayout(BindGroupLayouts.DYNAMIC_TRANSFORMS).withBindGroupLayout(BindGroupLayouts.PROJECTION)
            .withLocation(method10934("pipeline/script_world_" + var1))
            .withVertexShader(method10934("core/" + var0))
            .withFragmentShader(method10934("core/" + var0))
            .withVertexBinding(0, field24567)
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .withColorTargetState(EffectRenderPipelines.method05551(var2 / 6))
            .withDepthStencilState(EffectRenderPipelines.method05546(var2 / 2 % 3))
            .withCull((var2 & 1) != 0);
         if (var3) {
            var4.withBindGroupLayout(BindGroupLayouts.SAMPLER0);
         }

         return var4.build();
      } catch (Throwable var5) {
         field24572.put(var0, String.valueOf(var5));
         return null;
      }
   }

   public static void method10943(String var0, String var1) {
      if (var0 != null && var1 != null) {
         field24572.put(method10936(var0), var1);
      }
   }

   public static Shader method10944(String var0, String var1, String var2) {
      String var3 = method10936(var0);
      method10939(var3 + ".vsh", var1);
      method10939(var3 + ".fsh", var2);
      return method10931(var3);
   }

   public static RenderPipeline method10945(String var0) {
      return method10951(var0, 0);
   }

   private static RenderPipeline method10947(String var0, PrimitiveTopology var1, int var2, String var3) {
      String var4 = var3 + var0 + "_" + var2;
      return field24571.computeIfAbsent(
         var4,
         var4x -> {
            try {
               return RenderPipeline.builder()
                  .withBindGroupLayout(BindGroupLayouts.DYNAMIC_TRANSFORMS).withBindGroupLayout(BindGroupLayouts.PROJECTION)
                  .withLocation(method10934("pipeline/script_" + var4))
                  .withVertexShader(method10934("core/" + var0))
                  .withFragmentShader(method10934("core/" + var0))
                  .withVertexBinding(0, field24567)
                  .withPrimitiveTopology(var1)
                  .withColorTargetState(EffectRenderPipelines.method05551(var2))
                  .build();
            } catch (Throwable var6) {
               field24572.put(var0, String.valueOf(var6));
               return null;
            }
         }
      );
   }

   private static RenderPipeline method10948(String var0) {
      return method10938(var0, PrimitiveTopology.QUADS, "");
   }

   public static String[] method10949() {
      return field24568.keySet().toArray(new String[0]);
   }

   public static void method10950() {
      RenderPipelineCache.method10800();
      field24572.clear();
      field24573.clear();
   }

   public static RenderPipeline method10951(String var0, int var1) {
      return var1 <= 0 ? field24568.get(var0) : method10947(var0, PrimitiveTopology.QUADS, var1, field24576);
   }

   public static boolean method10952(String var0, RenderPipeline var1) {
      if (var1 == null || var0 == null) {
         return false;
      } else if (!method10941(var0)) {
         field24572.putIfAbsent(method10936(var0), field24582);
         field24575 = true;
         return false;
      } else {
         return RenderPipelineCache.method10799(var1);
      }
   }
}
