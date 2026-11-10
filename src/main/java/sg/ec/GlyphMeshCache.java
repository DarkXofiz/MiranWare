// Original binary: sg/ec/1w9mB67Zhp2U93xJ
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GlyphMeshCache {
   public static final GlyphMeshCache field00691 = new GlyphMeshCache();
   private static final int field00692 = 3;
   private static final int field00693 = 0;
   private static final Matrix3x2f field00694 = new Matrix3x2f();
   private static final Map<GlyphMeshCache.Nested15, GlyphMeshCache.Nested14> field00695 = new HashMap<>();
   private static final GlyphMeshCache.Nested15 field00696 = new GlyphMeshCache.Nested15();
   private static GlyphMeshCache.Nested14 field00697;
   private static CornerColors field00698;
   private static long field00699;
   private static final long field00700 = 30L;
   private static final long field00701 = 3L;

   private GlyphMeshCache() {
   }

   static boolean method00327(FontGlyph var0, float var1, CornerColors var2) {
      GlyphMeshCache.Nested14 var3 = field00697;
      if (var3 == null) {
         return false;
      }

      var3.method00333(var0, var1, var2, var2 == field00698);
      return true;
   }

   @Subscribe
   private void method00328(RenderFrameEndEvent var1) {
      if (field00699 % field00700 == 0L && !field00695.isEmpty()) {
         long var2 = field00699;
         var var4 = field00695.values().iterator();

         while (var4.hasNext()) {
            if (var2 - ((GlyphMeshCache.Nested14)var4.next()).field00708 > field00701) {
               var4.remove();
            }
         }
      }
   }

   private static GlyphMeshCache.Nested14 method00329(
      FontFace var0, String var1, float var2, float var3, CornerColors var4, float var5, FontAtlasMetadata.Nested25 var6
   ) {
      GlyphMeshCache.Nested14 var7 = new GlyphMeshCache.Nested14();
      field00697 = var7;
      field00698 = var4;

      try {
         var0.method06996(field00694, null, var1, var2, var3, 0.0F, 0.0F, var4, var5, var6);
      } finally {
         field00697 = null;
         field00698 = null;
      }

      var7.method00334(var2);
      return var7;
   }

   @Subscribe
   private void method00330(RenderFrameStartEvent var1) {
      field00699++;
   }

   public static void method00331(
      FontFace var0,
      Matrix3x2f var1,
      VertexConsumer var2,
      String var3,
      float var4,
      float var5,
      float var6,
      float var7,
      CornerColors var8,
      float var9,
      FontAtlasMetadata.Nested25 var10
   ) {
      if (var3 != null && !var3.isEmpty()) {
         field00696.method00338(var0, var3, var4, var5);
         GlyphMeshCache.Nested14 var11 = field00695.get(field00696);
         if (var11 == null) {
            var11 = method00329(var0, var3, var4, var5, var8, var9, var10);
            field00695.put(field00696.method00337(), var11);
         }

         var11.field00708 = field00699;
         var11.method00335(var1, var2, var6, var7, var9, var10.method00832(), var5, var8);
      }
   }

   public void method00332() {
      EventBus.method00263(this);
   }

   // $VF: Compiled from s
   private static final class Nested14 {
      private FontGlyph[] field00702 = new FontGlyph[32];
      private float[] field00703 = new float[32];
      private CornerColors[] field00704 = new CornerColors[32];
      private boolean[] field00705 = new boolean[32];
      private int field00706;
      private boolean field00707;
      private long field00708;
      private float[] field00709;
      private float[] field00710;
      private int[] field00711;
      private boolean[] field00712;
      private int field00713;
      private static final int field00714 = 16777215;

      private void method00333(FontGlyph var1, float var2, CornerColors var3, boolean var4) {
         if (this.field00706 == this.field00702.length) {
            int var5 = this.field00706 << 1;
            this.field00702 = Arrays.copyOf(this.field00702, var5);
            this.field00703 = Arrays.copyOf(this.field00703, var5);
            this.field00704 = Arrays.copyOf(this.field00704, var5);
            this.field00705 = Arrays.copyOf(this.field00705, var5);
         }

         this.field00702[this.field00706] = var1;
         this.field00703[this.field00706] = var2;
         this.field00704[this.field00706] = var3;
         this.field00705[this.field00706] = var4;
         this.field00707 |= !var4;
         this.field00706++;
      }

      private void method00334(float var1) {
         float[] var2 = new float[this.field00706 << 3];
         float[] var3 = new float[this.field00706 << 3];
         int[] var4 = this.field00707 ? new int[this.field00706 << 2] : null;
         boolean[] var5 = this.field00707 ? new boolean[this.field00706] : null;
         int var6 = 0;

         for (int var7 = 0; var7 < this.field00706; var7++) {
            if (this.field00702[var7].method03692(this.field00703[var7], var1, this.field00704[var7], var2, var3, var4, var6 << 2)) {
               if (var5 != null) {
                  var5[var6] = this.field00705[var7];
               }

               var6++;
            }
         }

         int var8 = var6 << 2;
         if (var8 << 1 != var2.length) {
            var2 = Arrays.copyOf(var2, var8 << 1);
            var3 = Arrays.copyOf(var3, var8 << 1);
            if (var4 != null) {
               var4 = Arrays.copyOf(var4, var8);
               var5 = Arrays.copyOf(var5, var6);
            }
         }

         this.field00709 = var2;
         this.field00710 = var3;
         this.field00711 = var4;
         this.field00712 = var5;
         this.field00713 = var8;
         this.field00702 = null;
         this.field00703 = null;
         this.field00704 = null;
         this.field00705 = null;
      }

      private void method00335(Matrix3x2f var1, VertexConsumer var2, float var3, float var4, float var5, float var6, float var7, CornerColors var8) {
         int var9 = this.field00713;
         if (var9 != 0) {
            float[] var10 = this.field00709;
            float[] var11 = this.field00710;
            int[] var12 = this.field00711;
            boolean[] var13 = this.field00712;
            int var14 = var8.color1();
            int var15 = var8.color2();
            int var16 = var8.color3();
            int var17 = var8.color4();
            float var18 = var1.m00();
            float var19 = var1.m01();
            float var20 = var1.m10();
            float var21 = var1.m11();
            float var22 = var1.m20();
            float var23 = var1.m21();
            ExtendedVertexConsumer var24 = (ExtendedVertexConsumer)var2;
            int var25 = 0;
            int var26 = 0;

            for (int var27 = 0; var25 < var9; var27++) {
               float var28 = var3 + var10[var26];
               float var29 = var4 + var10[var26 + 1];
               float var30 = var18 * var28 + var20 * var29 + var22;
               float var31 = var19 * var28 + var21 * var29 + var23;
               float var32 = var10[var26 + 3] - var10[var26 + 1];
               float var33 = var10[var26 + 4] - var10[var26];
               float var34 = var20 * var32;
               float var35 = var21 * var32;
               float var36 = var18 * var33;
               float var37 = var19 * var33;
               boolean var38 = var12 == null || var13[var27];
               var24.glyphVertex(var30, var31, var11[var26], var11[var26 + 1], var38 ? var14 : method00336(var12[var25], var14), var7, var6, var5);
               var24.glyphVertex(
                  var30 + var34, var31 + var35, var11[var26 + 2], var11[var26 + 3], var38 ? var15 : method00336(var12[var25 + 1], var15), var7, var6, var5
               );
               var24.glyphVertex(
                  var30 + var34 + var36,
                  var31 + var35 + var37,
                  var11[var26 + 4],
                  var11[var26 + 5],
                  var38 ? var16 : method00336(var12[var25 + 2], var16),
                  var7,
                  var6,
                  var5
               );
               var24.glyphVertex(
                  var30 + var36, var31 + var37, var11[var26 + 6], var11[var26 + 7], var38 ? var17 : method00336(var12[var25 + 3], var17), var7, var6, var5
               );
               var25 += 4;
               var26 += 8;
            }
         }
      }

      private static int method00336(int var0, int var1) {
         int var2 = (var0 >>> 24) * (var1 >>> 24) / 255;
         return var2 << 24 | var0 & field00714;
      }
   }

   // $VF: Compiled from s
   private static final class Nested15 {
      private FontFace field00715;
      private String field00716;
      private float field00717;
      private float field00718;
      private int field00719;

      Nested15() {
      }

      GlyphMeshCache.Nested15 method00337() {
         GlyphMeshCache.Nested15 var1 = new GlyphMeshCache.Nested15();
         var1.method00338(this.field00715, this.field00716, this.field00717, this.field00718);
         return var1;
      }

      @Override
      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else {
            return !(var1 instanceof GlyphMeshCache.Nested15 var2)
               ? false
               : this.field00717 == var2.field00717
                  && this.field00718 == var2.field00718
                  && this.field00715.equals(var2.field00715)
                  && this.field00716.equals(var2.field00716);
         }
      }

      void method00338(FontFace var1, String var2, float var3, float var4) {
         this.field00715 = var1;
         this.field00716 = var2;
         this.field00717 = var3;
         this.field00718 = var4;
         int var5 = var1.hashCode();
         var5 = 31 * var5 + var2.hashCode();
         var5 = 31 * var5 + Float.floatToIntBits(var3);
         var5 = 31 * var5 + Float.floatToIntBits(var4);
         this.field00719 = var5;
      }

      @Override
      public int hashCode() {
         return this.field00719;
      }
   }
}
