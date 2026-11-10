// Original binary: sg/ec/WCMiN7vln3ikOjeC
package sg.ec;

import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.buffers.GpuBuffer;
import com.mojang.renderpearl.api.pipeline.BindGroupLayout;
import com.mojang.renderpearl.api.pipeline.BlendFunction;
import com.mojang.renderpearl.api.pipeline.ColorTargetState;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.pipeline.RenderTarget;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.commands.RenderPass.RenderArea;
import com.mojang.renderpearl.api.textures.FilterMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// $VF: Compiled from s
public final class TargetScanRenderer {
   private static final Logger field13494 = LoggerFactory.getLogger(TargetScanRenderer.field13548);
   private static final Supplier<String> field13495 = () -> TargetScanRenderer.field13547;
   private static final int field13496 = 160;
   private static final float field13497 = 0;
   private static final float field13498 = 0;
   private static final ByteBuffer field13499 = ByteBuffer.allocateDirect(160).order(ByteOrder.nativeOrder());
   private static final int field13500 = 0;
   private static final GpuBuffer[] field13501 = new GpuBuffer[3];
   private static int field13502;
   private static RenderPipeline field13503;
   private static boolean field13504;
   private static boolean field13505;
   private static final Matrix4f field13506 = new Matrix4f();
   private static final Matrix4f field13507 = new Matrix4f();
   private static final Matrix4f field13508 = new Matrix4f();
   private static final Vector4f field13509 = new Vector4f();
   private static final int field13510 = 0;
   private static final float field13511 = 0;
   private static final float field13512 = 0;
   private static int field13513;
   private static int field13514;
   private static int field13515;
   private static int field13516;
   private static final float field13517 = 1.4434999F;
   private static final double field13518 = 2.6F;
   private static final double field13519 = 3.4F;
   private static final float field13520 = 0.5F;
   private static final float field13521 = 1.0E-4F;
   private static final float field13522 = Float.MAX_VALUE;
   private static final float field13523 = Float.MAX_VALUE;
   private static final float field13524 = -Float.MAX_VALUE;
   private static final float field13525 = -Float.MAX_VALUE;
   private static final float field13526 = 1.0E-4F;
   private static final float field13527 = 0.5F;
   private static final float field13528 = 0.5F;
   private static final float field13529 = 0.5F;
   private static final float field13530 = 0.5F;
   private static final float field13531 = 255.0F;
   private static final float field13532 = 255.0F;
   private static final float field13533 = 255.0F;
   private static final float field13534 = 255.0F;
   private static final long field13535 = 160L;
   private static final String field13536 = "TargetScan";
   private static final String field13537 = "MaskSampler";
   private static final String field13538 = "DepthSampler";
   private static final String field13539 = "[target scan] проход отключён после сбоя";
   private static final String field13540 = "pipeline/target_scan";
   private static final String field13541 = "core/screenquad";
   private static final String field13542 = "post/target_scan";
   private static final String field13543 = "MaskSampler";
   private static final String field13544 = "DepthSampler";
   private static final String field13545 = "TargetScan";
   private static final String field13546 = "Hex";
   private static final String field13547 = "hex target scan";
   private static final String field13548 = "MiranWare";

   private TargetScanRenderer() {
   }

   private static void method05977(int var0, int var1, int var2, int var3) {
      field13513 = var0;
      field13514 = var1;
      field13515 = Math.max(0, var2);
      field13516 = Math.max(0, var3);
   }

   private static void method05978(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      RenderTarget var7 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      int var8 = var7 == null ? 0 : var7.width;
      int var9 = var7 == null ? 0 : var7.height;
      if (var8 > 0 && var9 > 0) {
         field13509.set(var0, var1 + var4 * field13520, var2, 1.0F).mul(field13508);
         if (field13509.w <= field13521) {
            method05977(0, 0, 0, 0);
         } else {
            float var10 = Math.max(var1 - var3, var5 - var6);
            float var11 = Math.min(var1 + var4 + var3, var5 + var6);
            if (var10 > var11) {
               method05977(0, 0, 0, 0);
            } else {
               float var12 = field13522;
               float var13 = field13523;
               float var14 = field13524;
               float var15 = field13525;

               for (int var16 = 0; var16 < 8; var16++) {
                  float var17 = var0 + ((var16 & 1) == 0 ? -var3 : var3);
                  float var18 = var2 + ((var16 & 2) == 0 ? -var3 : var3);
                  float var19 = (var16 & 4) == 0 ? var10 : var11;
                  field13509.set(var17, var19, var18, 1.0F).mul(field13508);
                  if (field13509.w <= field13526) {
                     method05977(0, 0, var8, var9);
                     return;
                  }

                  float var20 = field13509.x / field13509.w * field13527 + field13528;
                  float var21 = field13509.y / field13509.w * field13529 + field13530;
                  var12 = Math.min(var12, var20);
                  var14 = Math.max(var14, var20);
                  var13 = Math.min(var13, var21);
                  var15 = Math.max(var15, var21);
               }

               int var22 = Mth.clamp(Mth.floor(var12 * var8) - 2, 0, var8);
               int var23 = Mth.clamp(Mth.ceil(var14 * var8) + 2, 0, var8);
               int var24 = Mth.clamp(Mth.floor(var13 * var9) - 2, 0, var9);
               int var25 = Mth.clamp(Mth.ceil(var15 * var9) + 2, 0, var9);
               method05977(var22, var24, var23 - var22, var25 - var24);
            }
         }
      } else {
         method05977(0, 0, 0, 0);
      }
   }

   private static void method05979(int var0) {
      field13499.putFloat((var0 >> 16 & 0xFF) / field13531)
         .putFloat((var0 >> 8 & 0xFF) / field13532)
         .putFloat((var0 & 0xFF) / field13533)
         .putFloat((var0 >>> 24 & 0xFF) / field13534);
   }

   private static RenderPipeline method05980() {
      if (field13503 == null) {
         field13503 = RenderPipelines.register(
            RenderPipeline.builder()
               .withLocation(method05984(field13540))
               .withVertexShader(field13541)
               .withFragmentShader(method05984(field13542))
               .withBindGroupLayout(
                  BindGroupLayout.builder().withUniform(field13543, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field13544, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field13545, UniformType.UNIFORM_BUFFER).build()
               )
               .withColorTargetState(new ColorTargetState(BlendFunction.OVERLAY))
               .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
               .build()
         );
      }

      return field13503;
   }

   public static void method05982() {
      if (field13504) {
         field13504 = false;
         if (!field13505 && field13515 > 0 && field13516 > 0) {
            Minecraft var0 = Minecraft.getInstance();
            RenderTarget var1 = ((LevelRendererAccess)var0.levelRenderer).hexRawOutlineTarget();
            RenderTarget var2 = var0.gameRenderer.mainRenderTarget();
            if (var1 != null && var2 != null && var2.getDepthTextureView() != null) {
               EntityMaskRenderHooks.method04011();
               CommandEncoder var3 = RenderSystem.getDevice().createCommandEncoder();
               field13502 = (field13502 + 1) % 3;
               GpuBuffer var4 = field13501[field13502];
               if (var4 == null) {
                  var4 = RenderSystem.getDevice().createBuffer(field13495, 136, field13535);
                  field13501[field13502] = var4;
               }

               field13499.rewind();
               var3.writeToBuffer(var4.slice(), field13499);

               try (RenderPass var5 = var3.createRenderPass(
                     field13495,
                     var2.getColorTextureView(),
                     Optional.empty(),
                     null,
                     OptionalDouble.empty(),
                     new RenderArea(field13513, field13514, field13515, field13516)
                  )) {
                  var5.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(method05980()));
                  RenderSystem.bindDefaultUniforms(var5);
                  var5.setUniform(field13536, var4);
                  var5.setUniform(field13537, var1.getColorTextureView(), RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST));
                  var5.setUniform(field13538, var2.getDepthTextureView(), RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST));
                  var5.draw(3, 1, 0, 0);
               } catch (Throwable var10) {
                  field13505 = true;
                  field13494.error(field13539, var10);
               }
            }
         }
      }
   }

   public static void method05983() {
      field13504 = false;
   }

   private static Identifier method05984(String var0) {
      return Identifier.fromNamespaceAndPath(field13546.toLowerCase(), var0);
   }

   public static void method05985(
      Matrix4f var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      float var13,
      float var14
   ) {
      if (var0 != null && !(var13 <= 0.0F) && !(var5 <= 0.0F)) {
         float var15 = var4 + var6;
         field13508.set(field13506).mul(var0);
         field13507.set(field13508).invert();
         method05978(var1, var2, var3, var15, var5, var7, Math.max(field13517, var14));
         field13499.clear();
         field13507.get(field13499);
         field13499.position(64);
         field13499.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var15);
         field13499.putFloat(var7).putFloat(var8).putFloat(var9).putFloat(var14);
         method05979(var11);
         method05979(var12);
         field13499.putFloat(var5).putFloat(var13).putFloat(var6).putFloat(0.0F);
         double var16 = var10 * field13518;
         double var18 = var10 * field13519;
         field13499.putFloat((float)Math.sin(var16)).putFloat((float)Math.cos(var16)).putFloat((float)Math.sin(var18)).putFloat((float)Math.cos(var18));
         field13499.flip();
         field13504 = true;
      }
   }

   public static void method05986(Matrix4f var0) {
      if (var0 != null) {
         field13506.set(var0);
      }
   }
}
