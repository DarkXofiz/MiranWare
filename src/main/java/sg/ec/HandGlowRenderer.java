// Original binary: sg/ec/5jwsAYzZnT1lIagV
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
import com.mojang.renderpearl.api.pipeline.BlendFactor;
import com.mojang.renderpearl.api.pipeline.UniformType;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.renderpearl.api.textures.FilterMode;
import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Optional;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BindGroupLayouts;
import net.minecraft.client.renderer.feature.FeatureRenderDispatcher.PreparedFrame;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class HandGlowRenderer {
   private static final Supplier<String> field02520 = () -> HandGlowRenderer.field02677;
   private static final float field02521 = 40.0F;
   private static final int field02522 = 0;
   private static final int field02523 = 0;
   private static TextureTarget field02524;
   private static TextureTarget field02525;
   private static TextureTarget field02526;
   private static TextureTarget field02527;
   private static TextureTarget field02528;
   private static TextureTarget field02529;
   private static TextureTarget field02530;
   private static boolean field02531;
   private static int field02532;
   private static boolean field02533;
   private static boolean field02534 = true;
   private static boolean field02535;
   private static boolean field02536;
   private static boolean field02537;
   private static int field02538;
   private static int field02539;
   private static RenderPipeline field02540;
   private static RenderPipeline field02541;
   private static RenderPipeline field02542;
   private static RenderPipeline field02543;
   private static RenderPipeline field02544;
   private static RenderPipeline field02545;
   private static RenderPipeline field02546;
   private static RenderPipeline field02547;
   private static RenderPipeline field02548;
   private static GpuBuffer field02549;
   private static GpuBuffer field02550;
   private static GpuBuffer field02551;
   private static GpuBuffer field02552;
   private static GpuBuffer field02553;
   private static float field02554 = Float.NaN;
   private static float field02555 = Float.NaN;
   private static float field02556 = Float.NaN;
   private static float field02557 = Float.NaN;
   private static int field02558;
   private static int field02559;
   private static boolean field02560;
   private static boolean field02561;
   private static boolean field02562;
   private static boolean field02563;
   private static int field02564;
   private static int field02565;
   private static float field02566 = Float.NaN;
   private static float field02567 = Float.NaN;
   private static float field02568 = Float.NaN;
   private static boolean field02569;
   private static final ByteBuffer field02570 = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
   private static final ByteBuffer field02571 = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder());
   private static final ByteBuffer field02572 = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder());
   private static final ByteBuffer field02573 = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder());
   private static GpuSampler field02574;
   private static GpuSampler field02575;
   private static final String field02576 = "pass failed";
   private static final String field02577 = "hex hand glow prep";
   private static final String field02578 = "hex hand glow blur h";
   private static final String field02579 = "hex hand glow tex";
   private static final String field02580 = "OutlineConfig";
   private static final String field02581 = "BlurConfig";
   private static final String field02582 = "BlurConfig";
   private static final String field02583 = "hex hand item blur h";
   private static final String field02584 = "hex hand item blur";
   private static final String field02585 = "MaskConfig";
   private static final String field02586 = "hex hand glow capture";
   private static final String field02587 = "hex hand glow bg";
   private static final String field02588 = "snapshot failed";
   private static final String field02589 = "hex";
   private static final String field02590 = "core/screenquad";
   private static final String field02591 = "hand_glow_pre";
   private static final String field02592 = "hand_glow_pre";
   private static final String field02593 = "InSampler";
   private static final String field02594 = "ColorSampler";
   private static final String field02595 = "OutlineConfig";
   private static final String field02596 = "hand_blur";
   private static final String field02597 = "hand_blur";
   private static final String field02598 = "InSampler";
   private static final String field02599 = "BlurConfig";
   private static final String field02600 = "hand_fused";
   private static final String field02601 = "hand_fused";
   private static final String field02602 = "InSampler";
   private static final String field02603 = "GlowSampler";
   private static final String field02604 = "MaskSampler";
   private static final String field02605 = "MaskConfig";
   private static final String field02606 = "MaskConfig";
   private static final String field02607 = "InSampler";
   private static final String field02608 = "GlowSampler";
   private static final String field02609 = "MaskSampler";
   private static final String field02610 = "hand_blit";
   private static final String field02611 = "hand_blit";
   private static final String field02612 = "InSampler";
   private static final String field02613 = "MaskSampler";
   private static final String field02614 = "hand_copy";
   private static final String field02615 = "hand_copy";
   private static final String field02616 = "InSampler";
   private static final String field02617 = "hand_item_blur_v";
   private static final String field02618 = "hand_item_blur_h";
   private static final String field02619 = "gui_blur";
   private static final String field02620 = "BLUR_RADIUS";
   private static final float field02621 = 10.0F;
   private static final String field02622 = "BLUR_VERTICAL";
   private static final String field02623 = "InSampler";
   private static final String field02624 = "hand_item_mask";
   private static final String field02625 = "hand_item_mask";
   private static final String field02626 = "InSampler";
   private static final String field02627 = "MaskSampler";
   private static final String field02628 = "MaskConfig";
   private static final String field02629 = "hand_item_gloss";
   private static final String field02630 = "hand_item_gloss";
   private static final String field02631 = "MaskSampler";
   private static final String field02632 = "GlossConfig";
   private static final String field02633 = "GlossConfig";
   private static final String field02634 = "MaskSampler";
   private static final String field02635 = "InSampler";
   private static final String field02636 = "MaskSampler";
   private static final String field02637 = "InSampler";
   private static final String field02638 = "ColorSampler";
   private static final String field02639 = "MaskSampler";
   private static final String field02640 = "InSampler";
   private static final String field02641 = "hex hand outline cfg";
   private static final long field02642 = 64L;
   private static final float field02643 = 255.0F;
   private static final float field02644 = 255.0F;
   private static final float field02645 = 255.0F;
   private static final float field02646 = 255.0F;
   private static final float field02647 = 255.0F;
   private static final float field02648 = 255.0F;
   private static final String field02649 = "hex hand blur h";
   private static final long field02650 = 16L;
   private static final String field02651 = "hex hand blur v";
   private static final long field02652 = 16L;
   private static final String field02653 = "hex hand mask cfg";
   private static final long field02654 = 48L;
   private static final int field02655 = -16777216;
   private static final int field02656 = 16777215;
   private static final int field02657 = -16777216;
   private static final int field02658 = 16777215;
   private static final long field02659 = 100000L;
   private static final float field02660 = 1000.0F;
   private static final float field02661 = 255.0F;
   private static final float field02662 = 255.0F;
   private static final float field02663 = 255.0F;
   private static final float field02664 = 255.0F;
   private static final float field02665 = 255.0F;
   private static final float field02666 = 255.0F;
   private static final String field02667 = "hex hand gloss cfg";
   private static final long field02668 = 64L;
   private static final long field02669 = 100000L;
   private static final float field02670 = 1000.0F;
   private static final float field02671 = 255.0F;
   private static final float field02672 = 255.0F;
   private static final float field02673 = 255.0F;
   private static final float field02674 = 255.0F;
   private static final float field02675 = 255.0F;
   private static final float field02676 = 255.0F;
   private static final String field02677 = "hex hand glow";

   private static RenderPipeline method01192() {
      if (field02547 == null) {
         field02547 = method01194(field02591, field02592)
            .withBindGroupLayout(
               BindGroupLayout.builder().withUniform(field02593, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02594, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02595, UniformType.UNIFORM_BUFFER).build()
            )
            .withBindGroupLayout(BindGroupLayouts.GLOBALS)
            .withColorTargetState(method01226())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02547;
   }

   private static RenderPipeline method01193() {
      if (field02540 == null) {
         field02540 = method01194(field02596, field02597)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field02598, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02599, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(method01226())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02540;
   }

   private static Builder method01194(String var0, String var1) {
      return RenderPipeline.builder()
         .withLocation(method01245("pipeline/" + var0))
         .withVertexShader(field02590)
         .withFragmentShader(method01245("post/" + var1));
   }

   private static GpuBuffer method01195(String var0, long var1) {
      return RenderSystem.getDevice().createBuffer(() -> var0, 136, var1);
   }

   private static void method01196(RenderPass var0, GpuTextureView var1) {
      var0.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(method01197()));
      RenderSystem.bindDefaultUniforms(var0);
      var0.setUniform(field02633, field02553);
      var0.setUniform(field02634, var1, method01241(FilterMode.NEAREST));
      var0.draw(3, 1, 0, 0);
   }

   private static RenderPipeline method01197() {
      if (field02548 == null) {
         field02548 = method01194(field02629, field02630)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field02631, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02632, UniformType.UNIFORM_BUFFER).build())
            .withColorTargetState(method01228())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02548;
   }

   private static TextureTarget method01198(TextureTarget var0) {
      if (var0 != null) {
         var0.destroyBuffers();
      }

      return null;
   }

   private static boolean method01200(CustomHands var0) {
      return var0 != null && var0.method09100() && (var0.method09123() || var0.method09117());
   }

   private static RenderPipeline method01201(String var0, boolean var1) {
      Builder var2 = method01194(var0, field02619).withShaderDefine(field02620, field02621);
      if (var1) {
         var2.withShaderDefine(field02622);
      }

      return var2.withBindGroupLayout(BindGroupLayout.builder().withUniform(field02623, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
         .withColorTargetState(method01226())
         .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
         .build();
   }

   private static RenderPipeline method01202(boolean var0) {
      if (var0) {
         if (field02542 == null) {
            field02542 = method01201(field02617, true);
         }

         return field02542;
      } else {
         if (field02541 == null) {
            field02541 = method01201(field02618, false);
         }

         return field02541;
      }
   }

   private static void method01203(
      RenderPass var0, RenderPipeline var1, GpuTextureView var2, FilterMode var3, GpuTextureView var4, FilterMode var5, String var6, GpuBuffer var7
   ) {
      var0.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var1));
      RenderSystem.bindDefaultUniforms(var0);
      if (var7 != null) {
         var0.setUniform(var6, var7);
      }

      var0.setUniform(field02635, var2, method01241(var3));
      var0.setUniform(field02636, var4, method01241(var5));
      var0.draw(3, 1, 0, 0);
   }

   private static void method01204(RenderTarget var0, int var1, int var2) {
      int var3 = Math.max(1, var1 / 2);
      int var4 = Math.max(1, var2 / 2);
      boolean var5 = field02527 == null || field02527.width != var3 || field02527.height != var4;
      field02525 = method01246(field02525, var3, var4, false, field02577);
      field02526 = method01246(field02526, var3, var4, false, field02578);
      field02527 = method01246(field02527, var3, var4, false, field02579);
      if (field02535 || var5) {
         method01212(
            method01192(),
            field02525.getColorTextureView(),
            field02524.getColorTextureView(),
            FilterMode.LINEAR,
            var0.getColorTextureView(),
            FilterMode.LINEAR,
            field02580,
            field02549
         );
         method01243(method01193(), field02526.getColorTextureView(), field02525.getColorTextureView(), field02581, field02550);
         method01243(method01193(), field02527.getColorTextureView(), field02526.getColorTextureView(), field02582, field02551);
      }
   }

   public static void method01205(PreparedFrame var0) {
      RenderTarget var1 = field02531 ? Minecraft.getInstance().gameRenderer.mainRenderTarget() : null;
      RenderTarget var2 = ((LevelRendererAccess)Minecraft.getInstance().levelRenderer).hexRawOutlineTarget();
      if (var2 == null) {
         return;
      }

      try (com.mojang.renderpearl.api.commands.RenderPass var3 = RenderSystem.getDevice()
            .createCommandEncoder()
            .createRenderPass(
               () -> "hex hand outline", var2.getColorTextureView(), java.util.Optional.empty(), var1 == null ? null : var1.getDepthTextureView(), java.util.OptionalDouble.empty()
            )) {
         RenderSystem.bindDefaultUniforms(var3);
         var0.executeOutline(var3);
      }
   }

   private static void method01206() {
      if (!field02534) {
         field02534 = true;
         field02531 = false;
         field02533 = false;
         field02524 = method01198(field02524);
         method01220();
         method01237();
      }
   }

   public static GpuTextureView method01207() {
      return field02530 == null ? null : field02530.getColorTextureView();
   }

   private static void method01208(int var0, int var1, boolean var2, float var3, float var4, float var5, float var6) {
      if (field02553 == null) {
         field02553 = method01195(field02667, field02668);
      }

      float var7 = (float)(System.currentTimeMillis() % field02669) / field02670;
      method01211(
         field02553,
         (var0 >> 16 & 0xFF) / field02671,
         (var0 >> 8 & 0xFF) / field02672,
         (var0 & 0xFF) / field02673,
         (var1 >> 16 & 0xFF) / field02674,
         (var1 >> 8 & 0xFF) / field02675,
         (var1 & 0xFF) / field02676,
         var3,
         var4,
         var5,
         var6,
         var7,
         var2 ? 1.0F : 0.0F
      );
   }

   private static void method01209(int var0, int var1, boolean var2, boolean var3) {
      if (var0 != field02538 || var1 != field02539 || var2 != field02536 || var3 != field02537) {
         field02538 = var0;
         field02539 = var1;
         field02536 = var2;
         field02537 = var3;
         field02535 = true;
      }
   }

   private static void method01210(float var0, float var1, int var2, int var3, boolean var4, boolean var5, float var6, float var7) {
      if (field02550 == null) {
         field02550 = method01195(field02649, field02650);
      }

      if (field02551 == null) {
         field02551 = method01195(field02651, field02652);
      }

      if (field02552 == null) {
         field02552 = method01195(field02653, field02654);
      }

      int var8 = var4 ? field02655 | var2 & field02656 : 0;
      int var9 = var5 ? field02657 | var3 & field02658 : 0;
      boolean var10 = !field02560 || var8 != field02558 || var9 != field02559;
      if (var5 || var10) {
         field02560 = true;
         field02558 = var8;
         field02559 = var9;
         float var11 = var5 ? (float)(System.currentTimeMillis() % field02659) / field02660 : 0.0F;
         method01238(
            field02552,
            (var2 >> 16 & 0xFF) / field02661,
            (var2 >> 8 & 0xFF) / field02662,
            (var2 & 0xFF) / field02663,
            var4 ? 1.0F : 0.0F,
            (var3 >> 16 & 0xFF) / field02664,
            (var3 >> 8 & 0xFF) / field02665,
            (var3 & 0xFF) / field02666,
            var5 ? 1.0F : 0.0F,
            var11,
            var6,
            var7
         );
      }

      boolean var13 = false;
      if (var0 != field02556 || var1 != field02557) {
         field02556 = var0;
         field02557 = var1;
         float var12 = Math.max(1.0F, var0 / 2.0F);
         method01218(field02550, 1.0F, 0.0F, var12, 1.0F);
         method01218(field02551, 0.0F, 1.0F, var12, var1);
         var13 = true;
      }

      if (var13) {
         field02535 = true;
      }
   }

   private static void method01211(
      GpuBuffer var0,
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
      float var11,
      float var12
   ) {
      field02572.clear();
      field02572.putFloat(var1)
         .putFloat(var2)
         .putFloat(var3)
         .putFloat(0.0F)
         .putFloat(var4)
         .putFloat(var5)
         .putFloat(var6)
         .putFloat(0.0F)
         .putFloat(var7)
         .putFloat(var8)
         .putFloat(var9)
         .putFloat(var10)
         .putFloat(var11)
         .putFloat(var12)
         .putFloat(0.0F)
         .putFloat(0.0F)
         .flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var0.slice(), field02572);
   }

   private static void method01212(
      RenderPipeline var0, GpuTextureView var1, GpuTextureView var2, FilterMode var3, GpuTextureView var4, FilterMode var5, String var6, GpuBuffer var7
   ) {
      String var8 = var0 == field02547 ? field02638 : field02639;
      RenderPass var9 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field02520, var1, Optional.empty());

      try {
         var9.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var0));
         RenderSystem.bindDefaultUniforms(var9);
         if (var7 != null) {
            var9.setUniform(var6, var7);
         }

         var9.setUniform(field02640, var2, method01241(var3));
         var9.setUniform(var8, var4, method01241(var5));
         var9.draw(3, 1, 0, 0);
      } finally {
         var9.close();
      }
   }

   public static void method01213() {
      field02531 = false;
      field02532 = 0;
   }

   private static RenderPipeline method01214() {
      if (field02546 == null) {
         field02546 = method01194(field02600, field02601)
            .withBindGroupLayout(
               BindGroupLayout.builder()
                  .withUniform(field02602, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER)
                  .withUniform(field02603, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER)
                  .withUniform(field02604, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER)
                  .withUniform(field02605, UniformType.UNIFORM_BUFFER)
                  .build()
            )
            .withColorTargetState(method01232())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02546;
   }

   private static void method01215(
      GpuBuffer var0,
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
      float var11,
      float var12,
      float var13
   ) {
      field02573.clear();
      field02573.putFloat(var1)
         .putFloat(var2)
         .putFloat(var3)
         .putFloat(var4)
         .putFloat(var5)
         .putFloat(var6)
         .putFloat(var7)
         .putFloat(0.0F)
         .putFloat(var8)
         .putFloat(var9)
         .putFloat(var10)
         .putFloat(0.0F)
         .putFloat(var11)
         .putFloat(var12)
         .putFloat(var13)
         .putFloat(0.0F)
         .flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var0.slice(), field02573);
   }

   public static RenderTarget method01216() {
      return field02531 ? field02524 : null;
   }

   private static void method01217(float var0, float var1, boolean var2, boolean var3, int var4, int var5, float var6, float var7, float var8) {
      if (field02549 == null) {
         field02549 = method01195(field02641, field02642);
      }

      boolean var9 = !field02561
         || var0 != field02554
         || var1 != field02555
         || var2 != field02562
         || var3 != field02563
         || var4 != field02564
         || var5 != field02565
         || var6 != field02566
         || var7 != field02567
         || var8 != field02568;
      if (var9) {
         field02561 = true;
         field02554 = var0;
         field02555 = var1;
         field02562 = var2;
         field02563 = var3;
         field02564 = var4;
         field02565 = var5;
         field02566 = var6;
         field02567 = var7;
         field02568 = var8;
         method01215(
            field02549,
            var0,
            var1,
            var2 ? 1.0F : 0.0F,
            var3 ? 1.0F : 0.0F,
            (var4 >> 16 & 0xFF) / field02643,
            (var4 >> 8 & 0xFF) / field02644,
            (var4 & 0xFF) / field02645,
            (var5 >> 16 & 0xFF) / field02646,
            (var5 >> 8 & 0xFF) / field02647,
            (var5 & 0xFF) / field02648,
            var6,
            var7,
            var8
         );
         field02535 = true;
      }
   }

   private static void method01218(GpuBuffer var0, float var1, float var2, float var3, float var4) {
      field02570.clear();
      field02570.putFloat(var1).putFloat(var2).putFloat(var3).putFloat(var4).flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var0.slice(), field02570);
   }

   private static void method01219(int var0, int var1) {
      if (field02535 && field02533 && field02528 != null) {
         int var2 = Math.max(1, var0 / 4);
         int var3 = Math.max(1, var1 / 4);
         field02529 = method01246(field02529, var2, var3, false, field02583);
         field02530 = method01246(field02530, var2, var3, false, field02584);
         method01243(method01202(false), field02529.getColorTextureView(), field02528.getColorTextureView(), null, null);
         method01243(method01202(true), field02530.getColorTextureView(), field02529.getColorTextureView(), null, null);
      }
   }

   private static void method01220() {
      field02525 = method01198(field02525);
      field02526 = method01198(field02526);
      field02527 = method01198(field02527);
   }

   private static void method01221(RenderPass var0, GpuTextureView var1, GpuTextureView var2, GpuTextureView var3) {
      var0.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(method01214()));
      RenderSystem.bindDefaultUniforms(var0);
      var0.setUniform(field02606, field02552);
      var0.setUniform(field02607, var1, method01241(FilterMode.LINEAR));
      var0.setUniform(field02608, var2, method01241(FilterMode.LINEAR));
      var0.setUniform(field02609, var3, method01241(FilterMode.NEAREST));
      var0.draw(3, 1, 0, 0);
   }

   private static RenderPipeline method01222() {
      if (field02543 == null) {
         field02543 = method01194(field02624, field02625)
            .withBindGroupLayout(
               BindGroupLayout.builder().withUniform(field02626, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02627, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02628, UniformType.UNIFORM_BUFFER).build()
            )
            .withColorTargetState(method01232())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02543;
   }

   public static void method01223() {
      CustomHands var0 = ModuleManager.INSTANCE.method08200();
      if (field02524 != null && var0 != null) {
         boolean var1 = var0.method09123();
         boolean var2 = var0.method09117();
         boolean var3 = var2 && var0.method09128();
         boolean var4 = var2 && !var3;
         RenderTarget var5 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
         int var6 = var5.width;
         int var7 = var5.height;
         method01209(var6, var7, var1, var2);
         method01227(var0, var1, var3);

         try {
            if (var1) {
               method01204(var5, var6, var7);
            } else {
               method01220();
            }

            if (var4) {
               method01219(var6, var7);
            } else {
               method01237();
            }

            method01236(var5, var1, var4, var3);
         } catch (Throwable var9) {
            method01244(field02576, var9);
         }

         field02533 = false;
      } else {
         field02533 = false;
      }
   }

   public static void method01224(ItemStack var0, ItemStack var1) {
      field02531 = false;
      field02532 = 0;
      CustomHands var2 = ModuleManager.INSTANCE.method08200();
      if (!method01200(var2)) {
         method01206();
      } else if (!var0.isEmpty() || !var1.isEmpty()) {
         boolean var3 = var2.method09117() && var2.method09128();
         if (!var2.method09123() && var2.method09117()) {
            method01231();
            if (var3) {
               field02532 = 1;
               method01206();
            } else {
               field02532 = 2;
               method01235();
            }
         } else {
            method01231();
            method01240();
            if (field02535 && var2.method09117() && !var3) {
               method01233();
            }
         }
      }
   }

   private static ColorTargetState method01226() {
      return new ColorTargetState(Optional.empty(), GpuFormat.RGBA8_UNORM, 15);
   }

   private static void method01227(CustomHands var0, boolean var1, boolean var2) {
      if (var1) {
         method01217(
            var0.method09096() ? 1.0F : 0.0F,
            var0.method09106(),
            var0.method09109(),
            var0.method09112(),
            var0.method09081(),
            var0.method09095(),
            var0.method09120(),
            var0.method09107(),
            var0.method09085()
         );
      }

      boolean var3 = var0.method09098();
      method01210(
         var0.method09118(),
         var0.method09104(),
         var0.method09103(),
         var0.method09121(),
         var3,
         var3 && var0.method09099(),
         var0.method09101(),
         var0.method09089()
      );
      if (var2) {
         method01208(var0.method09127(), var0.method09092(), var0.method09110(), var0.method09130(), var0.method09105(), var0.method09102(), var0.method09088());
      }
   }

   private static ColorTargetState method01228() {
      return new ColorTargetState(Optional.of(new BlendFunction(BlendFactor.SRC_ALPHA, BlendFactor.ONE)), GpuFormat.RGBA8_UNORM, 7);
   }

   public static boolean method01229() {
      return field02531;
   }

   private static RenderPipeline method01230() {
      if (field02545 == null) {
         field02545 = method01194(field02614, field02615)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field02616, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
            .withColorTargetState(method01226())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02545;
   }

   private static void method01231() {
      field02535 = true;
   }

   private static ColorTargetState method01232() {
      return new ColorTargetState(Optional.of(BlendFunction.ENTITY_OUTLINE_BLIT), GpuFormat.RGBA8_UNORM, 7);
   }

   private static void method01233() {
      RenderTarget var0 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      if (var0 != null) {
         try {
            field02528 = method01246(field02528, Math.max(1, var0.width / 4), Math.max(1, var0.height / 4), false, field02587);
            method01243(method01230(), field02528.getColorTextureView(), var0.getColorTextureView(), null, null);
            field02533 = true;
         } catch (Throwable var2) {
            field02533 = false;
            method01244(field02588, var2);
         }
      }
   }

   private HandGlowRenderer() {
   }

   private static RenderPipeline method01234() {
      if (field02544 == null) {
         field02544 = method01194(field02610, field02611)
            .withBindGroupLayout(BindGroupLayout.builder().withUniform(field02612, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).withUniform(field02613, com.mojang.renderpearl.api.pipeline.UniformType.COMBINED_IMAGE_SAMPLER).build())
            .withColorTargetState(method01232())
            .withPrimitiveTopology(PrimitiveTopology.TRIANGLES)
            .build();
      }

      return field02544;
   }

   private static void method01235() {
      RenderTarget var0 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      if (var0 != null) {
         field02524 = method01198(field02524);
         method01220();
         field02534 = false;
         method01233();
         method01219(var0.width, var0.height);
         field02533 = false;
      }
   }

   private static void method01236(RenderTarget var0, boolean var1, boolean var2, boolean var3) {
      boolean var4 = var1 && field02527 != null;
      boolean var5 = var2 && field02530 != null;
      if (var4 || var5 || var3) {
         GpuTextureView var6 = field02524.getColorTextureView();
         RenderPass var7 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field02520, var0.getColorTextureView(), Optional.empty());

         try {
            if (var4 && var5) {
               method01221(var7, field02530.getColorTextureView(), field02527.getColorTextureView(), var6);
            } else {
               if (var5) {
                  method01203(var7, method01222(), field02530.getColorTextureView(), FilterMode.LINEAR, var6, FilterMode.NEAREST, field02585, field02552);
               }

               if (var4) {
                  method01203(var7, method01234(), field02527.getColorTextureView(), FilterMode.LINEAR, var6, FilterMode.NEAREST, null, null);
               }
            }

            if (var3) {
               method01196(var7, var6);
            }
         } finally {
            var7.close();
         }
      }
   }

   private static void method01237() {
      field02528 = method01198(field02528);
      field02529 = method01198(field02529);
      field02530 = method01198(field02530);
      field02533 = false;
   }

   private static void method01238(
      GpuBuffer var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11
   ) {
      field02571.clear();
      field02571.putFloat(var1)
         .putFloat(var2)
         .putFloat(var3)
         .putFloat(var4)
         .putFloat(var5)
         .putFloat(var6)
         .putFloat(var7)
         .putFloat(var8)
         .putFloat(var9)
         .putFloat(var10)
         .putFloat(var11)
         .putFloat(0.0F)
         .flip();
      RenderSystem.getDevice().createCommandEncoder().writeToBuffer(var0.slice(), field02571);
   }

   public static int method01239(int var0) {
      if (!field02531 && field02532 == 0) {
         return var0;
      }

      CustomHands var1 = ModuleManager.INSTANCE.method08200();
      return var1 != null && var1.method09100() ? var1.method09093() : var0;
   }

   private static void method01240() {
      RenderTarget var0 = Minecraft.getInstance().gameRenderer.mainRenderTarget();
      if (var0 != null) {
         field02524 = method01246(field02524, var0.width, var0.height, true, field02586);
         RenderSystem.getDevice()
            .createCommandEncoder()
            .clearColorAndDepthTextures(field02524.getColorTexture(), ARGB.vector4fFromARGB32(0), field02524.getDepthTexture(), 1.0);
         field02531 = true;
         field02534 = false;
      }
   }

   private static GpuSampler method01241(FilterMode var0) {
      if (var0 == FilterMode.NEAREST) {
         if (field02575 == null) {
            field02575 = RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST);
         }

         return field02575;
      } else {
         if (field02574 == null) {
            field02574 = RenderSystem.getSamplerCache().getClampToEdge(FilterMode.LINEAR);
         }

         return field02574;
      }
   }

   public static int method01242() {
      return field02532;
   }

   private static void method01243(RenderPipeline var0, GpuTextureView var1, GpuTextureView var2, String var3, GpuBuffer var4) {
      RenderPass var5 = RenderSystem.getDevice().createCommandEncoder().createRenderPass(field02520, var1, Optional.empty());

      try {
         var5.setPipeline(com.mojang.blaze3d.systems.RenderSystem.getCompiledPipeline(var0));
         RenderSystem.bindDefaultUniforms(var5);
         if (var4 != null) {
            var5.setUniform(var3, var4);
         }

         var5.setUniform(field02637, var2, method01241(FilterMode.LINEAR));
         var5.draw(3, 1, 0, 0);
      } finally {
         var5.close();
      }
   }

   private static void method01244(String var0, Throwable var1) {
      if (!field02569) {
         field02569 = true;
      }
   }

   private static Identifier method01245(String var0) {
      return Identifier.fromNamespaceAndPath(field02589, var0);
   }

   private static TextureTarget method01246(TextureTarget var0, int var1, int var2, boolean var3, String var4) {
      if (var0 != null && var0.width == var1 && var0.height == var2) {
         return var0;
      }

      if (var0 != null) {
         var0.destroyBuffers();
      }

      return new TextureTarget(var4, var1, var2, GpuFormat.RGBA8_UNORM, var3 ? com.mojang.renderpearl.api.GpuFormat.D32_FLOAT : null);
   }
}
