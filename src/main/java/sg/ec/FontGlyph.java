// Original binary: sg/ec/GpllTLBH61SnwpNs
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class FontGlyph {
   private final int field08160;
   private final float field08161;
   private final float field08162;
   private final float field08163;
   private final float field08164;
   public static final float field08165 = 1.0F;
   private final float field08166;
   private final float field08167;
   private final float field08168;
   private final float field08169;
   private final float field08170;
   private final boolean field08171;

   public float method03689(
      Matrix3x2f var1, VertexConsumer var2, float var3, float var4, float var5, CornerColors var6, float var7, float var8, float var9
   ) {
      if (GlyphMeshCache.method00327(this, var4, var6)) {
         return this.method03699(var3);
      }

      var5 -= this.field08167 * var3;
      var5--;
      float var10 = var4 + this.field08168 * var3;
      float sx = this.field08169 * var3;
      float sxx = this.field08170 * var3;
      float sxxx = var10;
      float sxxxx = var5;
      float sxxxxx = var10 + sx;
      float sxxxxxx = var5 + sxx;
      float sxxxxxxx = var1.m00();
      float sxxxxxxxx = var1.m01();
      float sxxxxxxxxx = var1.m10();
      float sxxxxxxxxxx = var1.m11();
      float sxxxxxxxxxxx = var1.m20();
      float sxxxxxxxxxxxx = var1.m21();
      method03701(
         var2,
         sxxxxxxx * sxxx + sxxxxxxxxx * sxxxx + sxxxxxxxxxxx,
         sxxxxxxxx * sxxx + sxxxxxxxxxx * sxxxx + sxxxxxxxxxxxx,
         this.field08161,
         this.field08163,
         var6.color1(),
         var9,
         var8,
         var7
      );
      method03701(
         var2,
         sxxxxxxx * sxxx + sxxxxxxxxx * sxxxxxx + sxxxxxxxxxxx,
         sxxxxxxxx * sxxx + sxxxxxxxxxx * sxxxxxx + sxxxxxxxxxxxx,
         this.field08161,
         this.field08164,
         var6.color2(),
         var9,
         var8,
         var7
      );
      method03701(
         var2,
         sxxxxxxx * sxxxxx + sxxxxxxxxx * sxxxxxx + sxxxxxxxxxxx,
         sxxxxxxxx * sxxxxx + sxxxxxxxxxx * sxxxxxx + sxxxxxxxxxxxx,
         this.field08162,
         this.field08164,
         var6.color3(),
         var9,
         var8,
         var7
      );
      method03701(
         var2,
         sxxxxxxx * sxxxxx + sxxxxxxxxx * sxxxx + sxxxxxxxxxxx,
         sxxxxxxxx * sxxxxx + sxxxxxxxxxx * sxxxx + sxxxxxxxxxxxx,
         this.field08162,
         this.field08163,
         var6.color4(),
         var9,
         var8,
         var7
      );
      return this.method03699(var3);
   }

   public float method03690(float var1) {
      return this.method03699(var1);
   }

   public float method03691() {
      return this.field08167;
   }

   boolean method03692(float var1, float var2, CornerColors var3, float[] var4, float[] var5, int[] var6, int var7) {
      if (!this.field08171) {
         return false;
      }

      float var8 = var1 + this.field08168 * var2;
      float var9 = -this.field08167 * var2 - 1.0F;
      float var10 = var8 + this.field08169 * var2;
      float var11 = var9 + this.field08170 * var2;
      int var12 = var7 << 1;
      var4[var12] = var8;
      var4[var12 + 1] = var9;
      var4[var12 + 2] = var8;
      var4[var12 + 3] = var11;
      var4[var12 + 4] = var10;
      var4[var12 + 5] = var11;
      var4[var12 + 6] = var10;
      var4[var12 + 7] = var9;
      var5[var12] = this.field08161;
      var5[var12 + 1] = this.field08163;
      var5[var12 + 2] = this.field08161;
      var5[var12 + 3] = this.field08164;
      var5[var12 + 4] = this.field08162;
      var5[var12 + 5] = this.field08164;
      var5[var12 + 6] = this.field08162;
      var5[var12 + 7] = this.field08163;
      if (var6 != null) {
         var6[var7] = var3.color1();
         var6[var7 + 1] = var3.color2();
         var6[var7 + 2] = var3.color3();
         var6[var7 + 3] = var3.color4();
      }

      return true;
   }

   public float method03693(Matrix3x2f var1, VertexConsumer var2, float var3, float var4, float var5, int var6, float var7, float var8, float var9) {
      return this.method03689(var1, var2, var3, var4, var5, new CornerColors(var6), var7, var8, var9);
   }

   public float method03694() {
      return this.field08168;
   }

   public boolean method03695() {
      return this.field08171;
   }

   public float method03696() {
      return this.field08169;
   }

   public FontGlyph(FontAtlasMetadata.Nested23 var1, float var2, float var3) {
      this.field08160 = var1.method00827();
      this.field08166 = var1.method00826();
      FontAtlasMetadata.Nested24 var4 = var1.method00825();
      if (var4 != null) {
         this.field08161 = var4.method00831() / var2;
         this.field08162 = var4.method00828() / var2;
         this.field08163 = 1.0F - var4.method00830() / var3;
         this.field08164 = 1.0F - var4.method00829() / var3;
      } else {
         this.field08161 = this.field08162 = this.field08163 = this.field08164 = 0.0F;
      }

      FontAtlasMetadata.Nested24 var5 = var1.method00824();
      if (var5 != null) {
         this.field08171 = true;
         this.field08168 = var5.method00831();
         this.field08169 = var5.method00828() - var5.method00831();
         this.field08170 = var5.method00830() - var5.method00829();
         this.field08167 = var5.method00830();
      } else {
         this.field08171 = false;
         this.field08168 = 0.0F;
         this.field08169 = this.field08170 = this.field08167 = 0.0F;
      }
   }

   public float method03697(float var1) {
      return this.field08168 * var1 + this.field08169 * var1;
   }

   public int method03698() {
      return this.field08160;
   }

   public float method03699(float var1) {
      return this.field08166 * var1;
   }

   public float method03700() {
      return this.field08170;
   }

   static void method03701(VertexConsumer var0, float var1, float var2, float var3, float var4, int var5, float var6, float var7, float var8) {
      ((ExtendedVertexConsumer)var0).glyphVertex(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public float method03702(float var1) {
      float var2 = this.field08168 * var1 + this.field08169 * var1;
      float var3 = var2 - this.method03699(var1);
      return Math.max(0.0F, var3);
   }

   public float method03703(float var1) {
      return this.field08168 * var1;
   }
}
