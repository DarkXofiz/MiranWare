// Original binary: sg/ec/apTai4ble3vKZr93
package sg.ec;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.pipeline.RenderPipeline.Builder;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.PoseStack;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public final class EntityGlowRenderer {
   private static final Supplier<String> field16767 = () -> EntityGlowRenderer.field16830;
   private static final int field16768 = 2;
   private static final int field16769 = 0;
   private static final int field16770 = 0;
   private static final double field16771 = 0;
   private static final double field16772 = 0;
   private static final PoseStack field16773 = new PoseStack();
   private static final Vector2f field16774 = new Vector2f();
   private static final Vector2f field16775 = new Vector2f();
   private static final Vector2f field16776 = new Vector2f();
   private static final float[] field16777 = new float[8];
   private static final float[] field16778 = new float[8];
   private static final float[] field16779 = new float[8];
   private static final float[] field16780 = new float[8];
   private static final boolean[] field16781 = new boolean[8];
   private static final boolean[] field16782 = new boolean[8];
   private static boolean field16783;
   private static TextureTarget field16784;
   private static TextureTarget field16785;
   private static final TextureTarget[] field16786 = new TextureTarget[8];
   private static RenderPipeline field16787;
   private static RenderPipeline field16788;
   private static RenderPipeline field16789;
   private static final GpuBuffer[] field16790 = new GpuBuffer[8];
   private static final GpuBuffer[] field16791 = new GpuBuffer[8];
   private static final GpuBuffer[] field16792 = new GpuBuffer[8];
   private static final GpuBuffer[] field16793 = new GpuBuffer[8];
   private static final float[] field16794 = new float[8];
   private static final float[] field16795 = new float[8];
   private static final float[] field16796 = new float[8];
   private static final float[] field16797 = new float[8];
   private static final float[] field16798 = new float[8];
   private static final float[] field16799 = new float[8];
   private static boolean field16800;
   private static final ByteBuffer field16801 = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
   private static final String field16802 = "hex entity glow a";
   private static final String field16803 = "hex entity glow b";
   private static final String field16804 = "hex entity glow buf";
   private static final String field16805 = "PrepConfig";
   private static final String field16806 = "BlurConfig";
   private static final String field16807 = "BlurConfig";
   private static final String field16808 = "OutlineConfig";
   private static final double field16809 = 2.0;
   private static final String field16810 = "PrepConfig";
   private static final String field16811 = "InSampler";
   private static final String field16812 = "MaskSampler";
   private static final String field16813 = "hex";
   private static final String field16814 = "core/screenquad";
   private static final String field16815 = "esp_glow_pre";
   private static final String field16816 = "glow_pre";
   private static final String field16817 = "InSampler";
   private static final String field16818 = "PrepConfig";
   private static final String field16819 = "esp_glow_blur";
   private static final String field16820 = "hand_blur";
   private static final String field16821 = "InSampler";
   private static final String field16822 = "BlurConfig";
   private static final String field16823 = "esp_glow_combine";
   private static final String field16824 = "esp_combine";
   private static final String field16825 = "InSampler";
   private static final String field16826 = "MaskSampler";
   private static final String field16827 = "OutlineConfig";
   private static final String field16828 = "PrepConfig";
   private static final long field16829 = 16L;
   private static final String field16830 = "hex entity glow";

   private static GpuBuffer method07035(String var0) {
      return RenderSystem.getDevice().createBuffer(() -> var0, 136, field16829);
   }

   public static boolean method07036() {
      boolean var0 = field16783;
      field16783 = false;
      return var0;
   }

   public static boolean method07037(RenderTarget var0, GpuTextureView var1) {
      EntityESP var2 = ModuleManager.INSTANCE.method08235();
      if (var2 == null || !var2.method09222()) {
         method07050();
         return false;
      }

      if (var0 != null && var1 != null) {
         int var3 = Math.min(var2.method09219(), 8);
         boolean var4 = false;

         for (int var5 = 0; var5 < var3; var5++) {
            if (var2.method09211(var5) && (field16781[var5] || field16782[var5])) {
               var4 = true;
               break;
            }
         }

         if (!var4) {
            method07050();
            return true;
         }

         try {
            Minecraft var25 = Minecraft.getInstance();
            int var6 = var0.width;
            int var7 = var0.height;
            int var8 = Math.max(1, var6 / 2);
            int var9 = Math.max(1, var7 / 2);
            float var10 = (float)var6 / var25.getWindow().getGuiScaledWidth();
            float var11 = (float)var7 / var25.getWindow().getGuiScaledHeight();
            field16784 = method07051(field16784, var8, var9, field16802);
            field16785 = method07051(field16785, var8, var9, field16803);

            for (int var12 = 0; var12 < var3; var12++) {
               if (var2.method09211(var12) && (field16781[var12] || field16782[var12])) {
                  method07043(var2, var12);
               }
            }

            for (int var26 = 0; var26 < var3; var26++) {
               if (var2.method09211(var26) && (field16781[var26] || field16782[var26])) {
                  float var13 = Math.max(1.0F, var2.method09234(var26));
                  float var14 = var2.method09221(var26);
                  int var15;
                  int var16;
                  int var17;
                  int var18;
                  if (field16782[var26]) {
                     var15 = 0;
                     var16 = 0;
                     var17 = var6;
                     var18 = var7;
                  } else {
                     int var19 = (int)Math.ceil(var13 + var14) + 8;
                     var15 = Math.max(0, (int)Math.floor(field16777[var26] * var10) - var19);
                     var16 = Math.max(0, (int)Math.floor(field16778[var26] * var11) - var19);
                     var17 = Math.min(var6, (int)Math.ceil(field16779[var26] * var10) + var19);
                     var18 = Math.min(var7, (int)Math.ceil(field16780[var26] * var11) + var19);
                     if (var17 <= var15 || var18 <= var16) {
                        continue;
                     }
                  }

                  field16786[var26] = method07051(field16786[var26], var8, var9, field16804);
                  int var27 = 2 * (int)Math.ceil(var13) + 8;
                  int var20 = Math.max(0, (var15 - var27) / 2);
                  int var21 = Math.max(0, (var16 - var27) / 2);
                  int var22 = Math.min(var8, (var17 + var27) / 2 + 1);
                  int var23 = Math.min(var9, (var18 + var27) / 2 + 1);
                  method07047(
                     method07044(),
                     field16784.getColorTextureView(),
                     var20,
                     var21,
                     var22,
                     var23,
                     var9,
                     field16805,
                     field16790[var26],
                     var0.getColorTextureView(),
                     FilterMode.NEAREST,
                     null,
                     null,
                     null
                  );
                  method07047(
                     method07041(),
                     field16785.getColorTextureView(),
                     var20,
                     var21,
                     var22,
                     var23,
                     var9,
                     field16806,
                     field16791[var26],
                     field16784.getColorTextureView(),
                     FilterMode.LINEAR,
                     null,
                     null,
                     null
                  );
                  method07047(
                     method07041(),
                     field16786[var26].getColorTextureView(),
                     var20,
                     var21,
                     var22,
                     var23,
                     var9,
                     field16807,
                     field16792[var26],
                     field16785.getColorTextureView(),
                     FilterMode.LINEAR,
                     null,
                     null,
                     null
                  );
                  method07047(
                     method07038(),
                     var1,
                     var15,
                     var16,
                     var17,
                     var18,
                     var7,
                     field16808,
                     field16793[var26],
                     field16786[var26].getColorTextureView(),
                     FilterMode.LINEAR,
                     var0.getColorTextureView(),
                     FilterMode.NEAREST,
                     field16790[var26]
                  );
               }
            }
         } catch (Throwable var24) {
            if (!field16800) {
               field16800 = true;
            }
         }

         method07050();
         return true;
      } else {
         method07050();
         return true;
      }
   }

   private static RenderPipeline method07038() {
      if (field16789 == null) {
         field16789 = method07039(field16823, field16824)
            .withBindGroupLayout(
               BindGroupLayout.builder()
                  .withUniform(field16825, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER)
                  .withUniform(field16826, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER)
                  .withUniform(field16827, UniformType.UNIFORM_BUFFER)
                  .withUniform(field16828, UniformType.UNIFORM_BUFFER)
                  .build()
            )
            .withColorTargetState(new ColorTargetState(Optional.of(BlendFunction.ENTITY_OUTLINE_BLIT), GpuFormat.RGBA8_UNORM, 7))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field16789;
   }

   private static Builder method07039(String var0, String var1) {
      return RenderPipeline.builder()
         .withLocation(method07042("pipeline/" + var0))
         .withVertexShader(field16814)
         .withFragmentShader(method07042("post/" + var1));
   }

   private EntityGlowRenderer() {
   }

   private static RenderPipeline method07041() {
      if (field16788 == null) {
         field16788 = method07039(field16819, field16820)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field16821, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field16822, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field16788;
   }

   private static Identifier method07042(String var0) {
      return Identifier.fromNamespaceAndPath(field16813, var0);
   }

   private static boolean method07043(EntityESP var0, int var1) {
      if (field16790[var1] == null) {
         field16790[var1] = method07035("hex glow prep " + var1);
      }

      if (field16791[var1] == null) {
         field16791[var1] = method07035("hex glow blur h " + var1);
      }

      if (field16792[var1] == null) {
         field16792[var1] = method07035("hex glow blur v " + var1);
      }

      if (field16793[var1] == null) {
         field16793[var1] = method07035("hex glow outline " + var1);
      }

      boolean var2 = false;
      float var3 = var0.method09236(var1) ? 1.0F : 0.0F;
      float var4 = var0.method09210(var1);
      if (var3 != field16798[var1] || var4 != field16799[var1]) {
         field16798[var1] = var3;
         field16799[var1] = var4;
         method07046(field16790[var1], var3, var4, var1, 0.0F);
         var2 = true;
      }

      float var5 = Math.max(1.0F, var0.method09234(var1));
      float var6 = Math.max(1.0F, var5 / 2.0F);
      if (var6 != field16794[var1]) {
         field16794[var1] = var6;
         method07046(field16791[var1], 1.0F, 0.0F, var6, 1.0F);
         method07046(field16792[var1], 0.0F, 1.0F, var6, 1.0F);
         var2 = true;
      }

      float var7 = var0.method09237(var1) ? 1.0F : 0.0F;
      float var8 = var0.method09221(var1);
      float var9 = var0.method09237(var1) && !(var5 >= var8 + 2.0F) ? 0.0F : 1.0F;
      if (var7 != field16795[var1] || var8 != field16796[var1] || var9 != field16797[var1]) {
         field16795[var1] = var7;
         field16796[var1] = var8;
         field16797[var1] = var9;
         method07046(field16793[var1], var7, var8, var9, var1);
         var2 = true;
      }

      return var2;
   }

   static {
      for (int var0 = 0; var0 < 8; var0++) {
         field16794[var0] = Float.NaN;
         field16795[var0] = Float.NaN;
         field16796[var0] = Float.NaN;
         field16797[var0] = Float.NaN;
         field16798[var0] = Float.NaN;
         field16799[var0] = Float.NaN;
      }
   }

   private static RenderPipeline method07044() {
      if (field16787 == null) {
         field16787 = method07039(field16815, field16816)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field16817, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field16818, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15))
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field16787;
   }

   private static void method07045(int var0, Entity var1, float var2) {
      Vec3 var3 = var1.getPosition(var2);
      AABB var4 = var1.getBoundingBox().move(var3.x - var1.getX(), var3.y - var1.getY(), var3.z - var1.getZ()).inflate(method07049(var1));
      double var5 = Minecraft.getInstance().gameRenderer.mainCamera().getFov();
      if (WorldProjectionUtils.method09456(field16773, var4, var5, field16774, field16775, field16776) < 8) {
         field16782[var0] = true;
      } else {
         if (!field16781[var0]) {
            field16781[var0] = true;
            field16777[var0] = field16775.x;
            field16778[var0] = field16775.y;
            field16779[var0] = field16776.x;
            field16780[var0] = field16776.y;
         } else {
            field16777[var0] = Math.min(field16777[var0], field16775.x);
            field16778[var0] = Math.min(field16778[var0], field16775.y);
            field16779[var0] = Math.max(field16779[var0], field16776.x);
            field16780[var0] = Math.max(field16780[var0], field16776.y);
         }
      }
   }

   private static void method07046(GpuBuffer var0, float var1, float var2, float var3, float var4) {
      field16801.clear();
      field16801.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4).flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var0.slice(), field16801);
   }

   private static void method07047(
      RenderPipeline var0,
      GpuTextureView var1,
      int var2,
      int var3,
      int var4,
      int var5,
      int var6,
      String var7,
      GpuBuffer var8,
      GpuTextureView var9,
      FilterMode var10,
      GpuTextureView var11,
      FilterMode var12,
      GpuBuffer var13
   ) {
      RenderPass var14 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field16767, var1, Optional.empty());

      try {
         var14.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var0));
         var14.enableScissor(var2, var6 - var5, var4 - var2, var5 - var3);
         RenderSystem.bindDefaultUniforms(var14);
         if (var8 != null) {
            var14.setUniform(var7, var8);
         }

         if (var13 != null) {
            var14.setUniform(field16810, var13);
         }

         var14.setUniform(field16811, var9, RenderSystem.getSamplerCache().getClampToEdge(var10));
         if (var11 != null) {
            var14.setUniform(field16812, var11, RenderSystem.getSamplerCache().getClampToEdge(var12));
         }

         var14.draw(3, 1, 0, 0);
      } finally {
         var14.close();
      }
   }

   public static int method07048(Entity var0, int var1, float var2) {
      int var3 = EntityOutlineColorEvent.field02043.method00861(var0, var1);
      if (var3 != 0) {
         field16783 = true;
         EntityESP var4 = ModuleManager.INSTANCE.method08235();
         if (var4 != null) {
            int var5 = var4.method09217(var0);
            if (var5 >= 0 && var5 < 8 && !field16782[var5]) {
               method07045(var5, var0, var2);
            }
         }
      }

      return var3;
   }

   private static double method07049(Entity var0) {
      return !(var0 instanceof LivingEntity var1 && (var1.isFallFlying() || var1.isAutoSpinAttack())) ? 1.0 : field16809;
   }

   private static void method07050() {
      for (int var0 = 0; var0 < 8; var0++) {
         field16781[var0] = false;
         field16782[var0] = false;
      }
   }

   private static TextureTarget method07051(TextureTarget var0, int var1, int var2, String var3) {
      if (var0 != null && var0.width == var1 && var0.height == var2) {
         return var0;
      }

      if (var0 != null) {
         var0.destroyBuffers();
      }

      return new TextureTarget(var3, var1, var2, GpuFormat.RGBA8_UNORM, null);
   }
}
