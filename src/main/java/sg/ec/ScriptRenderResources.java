// Original binary: sg/ec/iRbxLw1oo7A5YLPo
package sg.ec;

import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.SamplerCache;
import com.mojang.renderpearl.api.textures.AddressMode;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class ScriptRenderResources implements MinecraftAccess {
   private static final int field20037 = 4;
   private static final int field20038 = 0;
   private static final AddressMode[] field20039 = new AddressMode[]{AddressMode.CLAMP_TO_EDGE, AddressMode.REPEAT};
   private static final FilterMode[] field20040 = new FilterMode[]{FilterMode.NEAREST, FilterMode.LINEAR};
   private static final Map<String, Identifier> field20041 = new HashMap<>();
   private static final Map<String, ItemStack> field20042 = new HashMap<>();
   private static final Map<String, RenderPipeline> field20043 = new HashMap<>();
   private static final Map<Identifier, ScriptRenderResources.Nested245> field20044 = new HashMap<>();
   private static final String field20045 = "script";
   private static final String field20046 = "script";
   private static final String field20047 = "This is a utility class and cannot be instantiated";

   public static Identifier method08786(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         Identifier var1 = field20041.get(var0);
         if (var1 != null || field20041.containsKey(var0)) {
            return var1;
         } else if (var0.indexOf(58) >= 0) {
            Identifier sx = Identifier.tryParse(var0);
            field20041.put(var0, sx);
            return sx;
         } else {
            ScriptSourceLoader sx = ScriptLifecycle.method03301(var0);
            return sx == null ? null : Identifier.fromNamespaceAndPath(field20045, sx.method08400() + "/" + var0);
         }
      } else {
         return null;
      }
   }

   public static ItemStack method08787(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         ItemStack var1 = field20042.get(var0);
         if (var1 != null) {
            return var1;
         }

         Identifier var2 = Identifier.tryParse(var0.indexOf(58) < 0 ? "minecraft:" + var0 : var0);
         Item var3 = var2 == null ? null : BuiltInRegistries.ITEM.getOptional(var2).orElse(null);
         ItemStack var4 = var3 == null ? ItemStack.EMPTY : new ItemStack(var3);
         field20042.put(var0, var4);
         return var4;
      } else {
         return ItemStack.EMPTY;
      }
   }

   private ScriptRenderResources() {
      throw new UnsupportedOperationException(field20047);
   }

   private static GpuSampler method08788(int var0) {
      SamplerCache var1 = RenderSystem.getSamplerCache();
      if (var1 == null) {
         return null;
      }

      AddressMode var2 = field20039[var0 >> 1 & 1];
      FilterMode var3 = field20040[var0 & 1];

      try {
         return var1.getSampler(var2, var2, var3, var3, false);
      } catch (Throwable var5) {
         return null;
      }
   }

   private static RenderPipeline method08789(String var0, String var1, PrimitiveTopology var2, int var3) {
      try {
         return RenderPipeline.builder()
            .withBindGroupLayout(BindGroupLayouts.DYNAMIC_TRANSFORMS).withBindGroupLayout(BindGroupLayouts.PROJECTION)
            .withBindGroupLayout(BindGroupLayouts.SAMPLER0)
            .withLocation(method08792("pipeline/script_textured_" + var1.toLowerCase(Locale.ROOT)))
            .withVertexShader(method08792("core/" + var0))
            .withFragmentShader(method08792("core/" + var0))
            .withVertexBinding(0, ScriptShaderManager.field24567)
            .withPrimitiveTopology(var2)
            .withColorTargetState(EffectRenderPipelines.method05551(var3))
            .withCull(false)
            .build();
      } catch (Throwable var5) {
         return null;
      }
   }

   public static void method08790() {
      field20041.clear();
      field20042.clear();
      field20043.clear();
      field20044.clear();
   }

   public static TextureSetup method08791(Identifier var0, int var1) {
      if (var0 == null) {
         return TextureSetup.noTexture();
      }

      AbstractTexture var2 = mc.getTextureManager().getTexture(var0);
      GpuSampler var3 = var1 < 0 ? null : method08788(var1);
      int var4 = var3 == null ? 4 : var1 & 3;
      ScriptRenderResources.Nested245 var5 = field20044.get(var0);
      if (var5 == null) {
         var5 = new ScriptRenderResources.Nested245();
         field20044.put(var0, var5);
      }

      return var5.method08794(var4, var2.getTextureView(), var3 == null ? var2.getSampler() : var3);
   }

   private static Identifier method08792(String var0) {
      return Identifier.fromNamespaceAndPath(field20046, var0);
   }

   public static RenderPipeline method08793(String var0, PrimitiveTopology var1, int var2) {
      if (var0 != null && !var0.isEmpty()) {
         String var3 = var0 + "_" + var1.name() + "_" + var2;
         RenderPipeline var4 = field20043.get(var3);
         if (var4 == null && !field20043.containsKey(var3)) {
            RenderPipeline var5 = method08789(var0, var3, var1, var2);
            field20043.put(var3, var5);
            return var5;
         } else {
            return var4;
         }
      } else {
         return null;
      }
   }

   // $VF: Compiled from s
   private static final class Nested245 {
      private final TextureSetup[] field20048 = new TextureSetup[5];
      private GpuTextureView field20049;

      private TextureSetup method08794(int var1, GpuTextureView var2, GpuSampler var3) {
         if (this.field20049 != var2) {
            this.field20049 = var2;
            Arrays.fill(this.field20048, null);
         }

         TextureSetup var4 = this.field20048[var1];
         if (var4 == null || var4.sampler0() != var3) {
            var4 = TextureSetup.singleTexture(var2, var3);
            this.field20048[var1] = var4;
         }

         return var4;
      }
   }
}
