// Original binary: sg/ec/dSTIDvyKs7eRbrQT
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.renderer.SubmitNodeStorage;
import net.minecraft.client.renderer.feature.CustomFeatureRenderer.Submit;
import net.minecraft.client.renderer.rendertype.RenderType;
import org.joml.Matrix4f;

// $VF: Compiled from s
public final class WorldVertexCollector {
   private static final Map<RenderType, WorldVertexCollector.Nested218> field18115 = new IdentityHashMap<>();
   private static Map<RenderType, WorldVertexCollector.Nested218> field18116;
   private final SubmitNodeStorage field18117;
   private final Map<RenderType, WorldVertexCollector.Nested218> field18118 = new LinkedHashMap<>();
   private RenderType field18119;
   private WorldVertexCollector.Nested218 field18120;
   private boolean field18121;
   private int field18122;

   public void method07404() {
      if (!this.field18121 && !this.field18118.isEmpty()) {
         this.field18121 = true;

         for (var var2 : this.field18118.entrySet()) {
            WorldVertexCollector.Nested218 sx = var2.getValue();
            if (!sx.isEmpty()) {
               RenderType sxx = var2.getKey();
               if (RenderPipelineCache.method10799(sxx.pipeline())) {
                  Submit sxxx = new Submit(new PoseStack().last().copy(), sxx, (var1, var2x) -> sx.replay(var2x));
                  ((RenderSubmissionAccess)this.field18117.order(0)).hexBeforeClear().submit(sxxx);
                  this.field18122++;
               }
            }
         }
      }
   }

   public int method07406() {
      return this.field18122;
   }

   public VertexConsumer method07407(RenderType var1) {
      if (var1 == this.field18119) {
         return this.field18120;
      }

      WorldVertexCollector.Nested218 var2 = this.field18118.computeIfAbsent(var1, var0 -> {
         WorldVertexCollector.Nested218 var1x = field18115.remove(var0);
         if (var1x != null) {
            var1x.reset();
            return var1x;
         } else {
            return new WorldVertexCollector.Nested218();
         }
      });
      this.field18119 = var1;
      this.field18120 = var2;
      return var2;
   }

   public WorldVertexCollector(SubmitNodeStorage var1) {
      this.field18117 = var1;
      var var2 = field18116;
      if (var2 != null && var2 != this.field18118) {
         field18115.putAll(var2);
      }

      field18116 = this.field18118;
   }

   // $VF: Compiled from s
   private static final class Nested218 implements BaritoneVertexConsumerAccess, VertexConsumer {
      @Override
      public com.mojang.blaze3d.vertex.VertexConsumer setUv3(float u, float v) {
         return this;
      }

      private static final byte field18123 = 0;
      private static final byte field18124 = 0;
      private static final byte field18125 = 0;
      private static final byte field18126 = 0;
      private static final byte field18127 = 0;
      private static final byte field18128 = 0;
      private static final byte field18129 = 0;
      private static final byte field18130 = 0;
      private static final byte field18131 = 0;
      private static final byte field18132 = 0;
      private static final byte field18133 = 0;
      private static final byte field18134 = 0;
      private static final byte field18135 = 0;
      private byte[] field18136 = new byte[64];
      private int field18137;
      private float[] field18138 = new float[128];
      private int field18139;
      private int[] field18140 = new int[64];
      private int field18141;

      @Override
      public void lineVertexF(
         Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, float var12
      ) {
         float var13 = var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30();
         float sx = var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31();
         float sxx = var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32();
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 12;
         this.ensureFloats(11);
         this.field18138[this.field18139++] = var13;
         this.field18138[this.field18139++] = sx;
         this.field18138[this.field18139++] = sxx;
         this.field18138[this.field18139++] = var5;
         this.field18138[this.field18139++] = var6;
         this.field18138[this.field18139++] = var7;
         this.field18138[this.field18139++] = var8;
         this.field18138[this.field18139++] = var9;
         this.field18138[this.field18139++] = var10;
         this.field18138[this.field18139++] = var11;
         this.field18138[this.field18139++] = var12;
      }

      @Override
      public void coloredVertex(Matrix4f var1, float var2, float var3, float var4, int var5) {
         float var6 = var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30();
         float var7 = var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31();
         float var8 = var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32();
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 10;
         this.ensureFloats(3);
         this.field18138[this.field18139++] = var6;
         this.field18138[this.field18139++] = var7;
         this.field18138[this.field18139++] = var8;
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var5;
      }

      @Override
      public void lineVertex(Matrix4f var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8, float var9) {
         float var10 = var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30();
         float var11 = var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31();
         float var12 = var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32();
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 9;
         this.ensureFloats(7);
         this.field18138[this.field18139++] = var10;
         this.field18138[this.field18139++] = var11;
         this.field18138[this.field18139++] = var12;
         this.field18138[this.field18139++] = var6;
         this.field18138[this.field18139++] = var7;
         this.field18138[this.field18139++] = var8;
         this.field18138[this.field18139++] = var9;
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var5;
      }

      @Override
      public VertexConsumer setUv(float var1, float var2) {
         this.method07410((byte)3);
         this.method07411(var1);
         this.method07411(var2);
         return this;
      }

      @Override
      public VertexConsumer setLineWidth(float var1) {
         this.method07410((byte)7);
         this.method07411(var1);
         return this;
      }

      private void ensureFloats(int var1) {
         int var2 = this.field18139 + var1;
         if (var2 > this.field18138.length) {
            int var3 = this.field18138.length;

            while (var3 < var2) {
               var3 <<= 1;
            }

            this.field18138 = Arrays.copyOf(this.field18138, var3);
         }
      }

      @Override
      public void coloredVertexPre(float var1, float var2, float var3, int var4) {
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 10;
         this.ensureFloats(3);
         this.field18138[this.field18139++] = var1;
         this.field18138[this.field18139++] = var2;
         this.field18138[this.field18139++] = var3;
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var4;
      }

      @Override
      public VertexConsumer setUv2(int var1, int var2) {
         this.method07410((byte)5);
         this.method07409(var1);
         this.method07409(var2);
         return this;
      }

      @Override
      public VertexConsumer setColor(int var1) {
         this.method07410((byte)2);
         this.method07409(var1);
         return this;
      }

      @Override
      public VertexConsumer setNormal(float var1, float var2, float var3) {
         this.method07410((byte)6);
         this.method07411(var1);
         this.method07411(var2);
         this.method07411(var3);
         return this;
      }

      @Override
      public void texturedVertexPre(float var1, float var2, float var3, float var4, float var5, int var6) {
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 8;
         this.ensureFloats(5);
         this.field18138[this.field18139++] = var1;
         this.field18138[this.field18139++] = var2;
         this.field18138[this.field18139++] = var3;
         this.field18138[this.field18139++] = var4;
         this.field18138[this.field18139++] = var5;
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var6;
      }

      @Override
      public void lineVertexPre(float var1, float var2, float var3, int var4, float var5, float var6, float var7, float var8) {
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 9;
         this.ensureFloats(7);
         this.field18138[this.field18139++] = var1;
         this.field18138[this.field18139++] = var2;
         this.field18138[this.field18139++] = var3;
         this.field18138[this.field18139++] = var5;
         this.field18138[this.field18139++] = var6;
         this.field18138[this.field18139++] = var7;
         this.field18138[this.field18139++] = var8;
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var4;
      }

      @Override
      public VertexConsumer setUv1(int var1, int var2) {
         this.method07410((byte)4);
         this.method07409(var1);
         this.method07409(var2);
         return this;
      }

      @Override
      public void coloredVertexF(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         float var9 = var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30();
         float var10 = var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31();
         float var11 = var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32();
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 11;
         this.ensureFloats(7);
         this.field18138[this.field18139++] = var9;
         this.field18138[this.field18139++] = var10;
         this.field18138[this.field18139++] = var11;
         this.field18138[this.field18139++] = var5;
         this.field18138[this.field18139++] = var6;
         this.field18138[this.field18139++] = var7;
         this.field18138[this.field18139++] = var8;
      }

      private void reset() {
         this.field18137 = 0;
         this.field18139 = 0;
         this.field18141 = 0;
      }

      @Override
      public VertexConsumer addVertex(float var1, float var2, float var3) {
         this.method07410((byte)0);
         this.method07411(var1);
         this.method07411(var2);
         this.method07411(var3);
         return this;
      }

      private void method07409(int var1) {
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var1;
      }

      @Override
      public void coloredVertexFPre(float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 11;
         this.ensureFloats(7);
         this.field18138[this.field18139++] = var1;
         this.field18138[this.field18139++] = var2;
         this.field18138[this.field18139++] = var3;
         this.field18138[this.field18139++] = var4;
         this.field18138[this.field18139++] = var5;
         this.field18138[this.field18139++] = var6;
         this.field18138[this.field18139++] = var7;
      }

      private boolean isEmpty() {
         return this.field18137 == 0;
      }

      private void method07410(byte var1) {
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = var1;
      }

      private void method07411(float var1) {
         if (this.field18139 == this.field18138.length) {
            this.field18138 = Arrays.copyOf(this.field18138, this.field18139 << 1);
         }

         this.field18138[this.field18139++] = var1;
      }

      @Override
      public void texturedVertex(Matrix4f var1, float var2, float var3, float var4, float var5, float var6, int var7) {
         float var8 = var1.m00() * var2 + var1.m10() * var3 + var1.m20() * var4 + var1.m30();
         float var9 = var1.m01() * var2 + var1.m11() * var3 + var1.m21() * var4 + var1.m31();
         float var10 = var1.m02() * var2 + var1.m12() * var3 + var1.m22() * var4 + var1.m32();
         if (this.field18137 == this.field18136.length) {
            this.field18136 = Arrays.copyOf(this.field18136, this.field18137 << 1);
         }

         this.field18136[this.field18137++] = 8;
         this.ensureFloats(5);
         this.field18138[this.field18139++] = var8;
         this.field18138[this.field18139++] = var9;
         this.field18138[this.field18139++] = var10;
         this.field18138[this.field18139++] = var5;
         this.field18138[this.field18139++] = var6;
         if (this.field18141 == this.field18140.length) {
            this.field18140 = Arrays.copyOf(this.field18140, this.field18141 << 1);
         }

         this.field18140[this.field18141++] = var7;
      }

      private void replay(VertexConsumer var1) {
         byte[] var2 = this.field18136;
         float[] var3 = this.field18138;
         int[] var4 = this.field18140;
         int var5 = 0;
         int var6 = 0;
         int var7 = 0;

         for (int var8 = this.field18137; var7 < var8; var7++) {
            switch (var2[var7]) {
               case 0:
                  var1.addVertex(var3[var5++], var3[var5++], var3[var5++]);
                  break;
               case 1:
                  var1.setColor(var4[var6++], var4[var6++], var4[var6++], var4[var6++]);
                  break;
               case 2:
                  var1.setColor(var4[var6++]);
                  break;
               case 3:
                  var1.setUv(var3[var5++], var3[var5++]);
                  break;
               case 4:
                  var1.setUv1(var4[var6++], var4[var6++]);
                  break;
               case 5:
                  var1.setUv2(var4[var6++], var4[var6++]);
                  break;
               case 6:
                  var1.setNormal(var3[var5++], var3[var5++], var3[var5++]);
                  break;
               case 7:
                  var1.setLineWidth(var3[var5++]);
                  break;
               case 8:
                  var1.addVertex(var3[var5++], var3[var5++], var3[var5++]).setUv(var3[var5++], var3[var5++]).setColor(var4[var6++]);
                  break;
               case 9:
                  var1.addVertex(var3[var5++], var3[var5++], var3[var5++])
                     .setColor(var4[var6++])
                     .setNormal(var3[var5++], var3[var5++], var3[var5++])
                     .setLineWidth(var3[var5++]);
                  break;
               case 10:
                  var1.addVertex(var3[var5++], var3[var5++], var3[var5++]).setColor(var4[var6++]);
                  break;
               case 11:
                  var1.addVertex(var3[var5++], var3[var5++], var3[var5++]).setColor(var3[var5++], var3[var5++], var3[var5++], var3[var5++]);
                  break;
               case 12:
                  var1.addVertex(var3[var5++], var3[var5++], var3[var5++])
                     .setColor(var3[var5++], var3[var5++], var3[var5++], var3[var5++])
                     .setNormal(var3[var5++], var3[var5++], var3[var5++])
                     .setLineWidth(var3[var5++]);
            }
         }
      }

      @Override
      public VertexConsumer setColor(int var1, int var2, int var3, int var4) {
         this.method07410((byte)1);
         this.method07409(var1);
         this.method07409(var2);
         this.method07409(var3);
         this.method07409(var4);
         return this;
      }
   }
}
