// Original binary: sg/mx/R0apOaRdVqh2Zzkp
package sg.mx;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.renderpearl.api.vertex.VertexFormat;
import com.mojang.renderpearl.api.vertex.VertexFormatElement;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.system.MemoryUtil;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import sg.ec.VertexTransformUtils;
import sg.ec.ExtendedVertexConsumer;
import sg.ec.ShaderUniformLayout;

// $VF: Compiled from s
@Mixin(BufferBuilder.class)
public abstract class BufferBuilderMixin implements ExtendedVertexConsumer {
   @Shadow
   private long vertexPointer;
   @Shadow
   @Final
   private VertexFormat format;
   @Shadow
   private int elementsToFill;
   @Shadow
   @Final
   private VertexFormatElement[] elements;
   private ShaderUniformLayout.Nested220 cache;
   private static final long field28015 = 4L;

   @Shadow
   private static void putRgba(long var0, int var2) {
   }

   private ShaderUniformLayout.Nested220 cache() {
      if (this.cache == null) {
         this.cache = new ShaderUniformLayout.Nested220();
      }

      return this.cache;
   }

   @Override
   public VertexConsumer addVertex(Matrix4fc var1, float var2, float var3, float var4) {
      return VertexTransformUtils.method00301(this, var1, var2, var3, var4);
   }

   @Override
   public ExtendedVertexConsumer radius(float var1, float var2, float var3, float var4) {
      ShaderUniformLayout.method07421(this.cache(), this.format, this.vertexPointer, var1, var2, var3, var4);
      return this;
   }

   @Override
   public ExtendedVertexConsumer vec2f(float var1, float var2) {
      ShaderUniformLayout.method07412(this.cache(), this.format, this.vertexPointer, var1, var2);
      return this;
   }

   @Override
   public ExtendedVertexConsumer range(float var1) {
      ShaderUniformLayout.method07417(this.cache(), this.format, this.vertexPointer, var1);
      return this;
   }

   @Override
   public ExtendedVertexConsumer size(float var1, float var2) {
      ShaderUniformLayout.method07413(this.cache(), this.format, this.vertexPointer, var1, var2);
      return this;
   }

   @Override
   public ExtendedVertexConsumer smooth(float var1) {
      ShaderUniformLayout.method07414(this.cache(), this.format, this.vertexPointer, var1);
      return this;
   }

   @Override
   public ExtendedVertexConsumer coord(float var1, float var2) {
      ShaderUniformLayout.method07420(this.cache(), this.format, this.vertexPointer, var1, var2);
      return this;
   }

   @Override
   public ExtendedVertexConsumer thickness(float var1) {
      ShaderUniformLayout.method07418(this.cache(), this.format, this.vertexPointer, var1);
      return this;
   }

   @Override
   public void glyphVertex(float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8) {
      this.addVertex(var1, var2, 0.0F);
      long var9 = this.vertexPointer;
      int var11 = this.elementsToFill;
      VertexFormatElement var12 = this.elements[2];
      int var13 = var11 & -5;
      if (var13 != var11 && var12 != null) {
         var11 = var13;
         long var14 = var9 + var12.offset();
         MemoryUtil.memPutFloat(var14, var3);
         MemoryUtil.memPutFloat(var14 + field28015, var4);
      }

      VertexFormatElement var16 = this.elements[1];
      int var15 = var11 & -3;
      if (var15 != var11 && var16 != null) {
         var11 = var15;
         putRgba(var9 + var16.offset(), var5);
      }

      this.elementsToFill = var11;
      ShaderUniformLayout.method07416(this.cache(), this.format, var9, var6, var7, var8);
   }

   @Override
   public void coloredVertex(Matrix4f var1, float var2, float var3, float var4, int var5) {
      VertexTransformUtils.method00302(this, var1, var2, var3, var4, var5);
   }

   @Override
   public void lineVertex(Matrix4f var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9) {
      VertexTransformUtils.method00303(this, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

}
