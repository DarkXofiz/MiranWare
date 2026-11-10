// Original binary: sg/ec/E65tc8viHApI9FmO
package sg.ec;

import net.minecraft.client.Minecraft;

import com.mojang.renderpearl.api.GpuFormat;
import com.mojang.renderpearl.api.pipeline.IndexType;
import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.blaze3d.pipeline.TextureTarget;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.systems.RenderSystem.AutoStorageIndexBuffer;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import net.minecraft.client.renderer.rendertype.PreparedRenderType;
import net.minecraft.client.renderer.rendertype.PreparedRenderType.Texture;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class JumpCircleRenderer {
   public static final int field07012 = 20;
   public static final int field07013 = 0;
   private static final Supplier<String> field07014 = () -> JumpCircleRenderer.field07035;
   private static final Supplier<String> field07015 = () -> JumpCircleRenderer.field07034;
   private static final int field07016 = 0;
   private static final int field07017 = 0;
   private static final ByteBuffer field07018 = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder());
   private static final GpuBuffer[] field07019 = new GpuBuffer[16];
   private static final JumpCircleRenderer.Nested89[] field07020 = new JumpCircleRenderer.Nested89[16];
   private static final int[] field07021 = new int[16];
   private static int field07022;
   private static boolean field07023;
   private static TextureTarget field07024;
   private static final long field07025 = 80L;
   private static final float field07026 = 255.0F;
   private static final float field07027 = 255.0F;
   private static final float field07028 = 255.0F;
   private static final float field07029 = 255.0F;
   private static final String field07030 = "hex jump scene";
   private static final String field07031 = "DynamicTransforms";
   private static final String field07032 = "Sampler0";
   private static final String field07033 = "JumpCircle";
   private static final String field07034 = "hex jump circle mesh";
   private static final String field07035 = "hex jump circles";

   private static void method03193(RenderPass var0, PreparedRenderType var1, boolean var2) {
      var0.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var1.pipeline()));
      RenderSystem.bindDefaultUniforms(var0);
      var0.setUniform(field07031, var1.dynamicTransforms());
      if (var2) {
         var0.setUniform(field07032, field07024.getColorTextureView(), RenderSystem.getSamplerCache().getClampToEdge(FilterMode.LINEAR));
      }

      for (Texture var4 : var1.textures()) {
         var0.setUniform(var4.name(), var4.textureView(), var4.sampler());
      }

      for (int var5 = 0; var5 < field07022; var5++) {
         var0.setUniform(field07033, field07019[var5]);
         var0.setVertexBuffer(0, field07020[var5].field07036.slice());
         var0.drawIndexed(PrimitiveTopology.QUADS.indexCount(field07021[var5]), 1, 0, 0, 0);
      }
   }

   public static void method03194(boolean var0) {
      field07022 = 0;
      field07023 = var0;
   }

   private static boolean method03196(RenderTarget var0) {
      if (var0.getColorTexture() == null) {
         return false;
      }

      int var1 = var0.width;
      int var2 = var0.height;
      if (field07024 == null || field07024.width != var1 || field07024.height != var2) {
         method03201();
         field07024 = new TextureTarget(field07030, var1, var2, GpuFormat.RGBA8_UNORM, null);
      }

      RenderSystem.getDevice().createCommandEncoder().copyTextureToTexture(var0.getColorTexture(), field07024.getColorTexture(), 0, 0, 0, 0, 0, var1, var2);
      return true;
   }

   public static boolean method03197() {
      return field07022 > 0;
   }

   private static void method03199(int var0) {
      field07018.putFloat((var0 >> 16 & 0xFF) / field07026)
         .putFloat((var0 >> 8 & 0xFF) / field07027)
         .putFloat((var0 & 0xFF) / field07028)
         .putFloat((var0 >>> 24 & 0xFF) / field07029);
   }

   public static void method03200() {
      if (field07022 != 0) {
         int var0 = 0;

         for (int var1 = 0; var1 < field07022; var1++) {
            var0 = Math.max(var0, field07021[var1]);
         }

         AutoStorageIndexBuffer var15 = RenderSystem.getSequentialBuffer(PrimitiveTopology.QUADS);
         GpuBuffer var2 = var15.getBuffer(PrimitiveTopology.QUADS.indexCount(var0));
         IndexType var3 = var15.type();
         PreparedRenderType var4 = EffectRenderPipelines.method05548().prepare();
         PreparedRenderType var5 = field07023 ? EffectRenderPipelines.method05570().prepare() : null;
         RenderTarget var6 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
         if (var5 != null && !method03196(var6)) {
            var5 = null;
         }

         GpuTextureView var7 = var6.getColorTextureView();
         GpuTextureView var8 = var6.getDepthTextureView();
         CommandEncoder var9 = RenderSystem.getDevice().createCommandEncoder();

         try (RenderPass var10 = var9.createRenderPass(field07014, var7, Optional.empty(), var8, OptionalDouble.empty())) {
            var10.setIndexBuffer(var2, var3);
            if (var5 != null) {
               method03193(var10, var5, true);
            }

            method03193(var10, var4, false);
         }

         for (int var16 = 0; var16 < field07022; var16++) {
            field07020[var16] = null;
         }

         field07022 = 0;
      }
   }

   public static void method03201() {
      if (field07024 != null) {
         field07024.destroyBuffers();
         field07024 = null;
      }
   }

   private JumpCircleRenderer() {
   }

   public static JumpCircleRenderer.Nested89 method03202(ByteBuffer var0, int var1, int[] var2) {
      if (var1 == 0) {
         return null;
      }

      int var3 = var1 * 20;
      GpuBuffer var4 = RenderSystem.getDevice().createBuffer(field07015, 40, var3);
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var4.slice(0L, var3), var0);
      return new JumpCircleRenderer.Nested89(var4, var2);
   }

   public static void method03203(
      JumpCircleRenderer.Nested89 var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      if (var0 != null && field07022 != 16) {
         int var15 = var0.method03205(var14);
         if (var15 != 0) {
            field07018.clear();
            field07018.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4).putFloat(var5).putFloat(var6).putFloat(var7).putFloat(var8);
            method03199(var9);
            method03199(var10);
            field07018.putFloat(var11).putFloat(var12).putFloat(var13).putFloat(0.0F).flip();
            GpuBuffer var16 = field07019[field07022];
            if (var16 == null) {
               var16 = RenderSystem.getDevice().createBuffer(field07014, 136, field07025);
               field07019[field07022] = var16;
            }

            RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var16.slice(), field07018);
            field07021[field07022] = var15;
            field07020[field07022++] = var0;
         }
      }
   }

   // $VF: Compiled from s
   public static final class Nested89 {
      private final GpuBuffer field07036;
      private final int[] field07037;
      private static final float field07038 = 24.0F;

      private Nested89(GpuBuffer var1, int[] var2) {
         this.field07036 = var1;
         this.field07037 = var2;
      }

      public void method03204() {
         this.field07036.close();
      }

      private int method03205(float var1) {
         int var2 = Mth.ceil(var1 * field07038);
         return this.field07037[Mth.clamp(var2, 0, 24)];
      }
   }
}
