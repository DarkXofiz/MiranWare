// Original binary: sg/ec/YMBtLGfJ8jERluQo
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class WorldLineRenderer {
   private static final float field14731 = 255.0F;
   private static final float field14732 = 255.0F;
   private static final float field14733 = 255.0F;
   private static final float field14734 = 255.0F;
   private static final float field14735 = 255.0F;
   private static final float field14736 = 255.0F;
   private static final float field14737 = 0.7F;
   private static final float field14738 = 0.35F;
   private static final float field14739 = 0.35F;
   private static final float field14740 = 0.35F;
   private static final float field14741 = 0.35F;
   private static final float field14742 = 0.7F;
   private static final float field14743 = 0.7F;
   private static final float field14744 = 0.7F;

   public static void method06533(VertexConsumer var0, Matrix4f var1, Vec3 var2, int var3, Vec3 var4, float var5) {
      if (var0 instanceof BaritoneVertexConsumerAccess var6) {
         float var7 = field14737;
         float var8 = field14738;
         float var9 = (float)(var4.x() - var2.x) - field14739;
         float var10 = (float)(var4.y() - var2.y) - field14740;
         float var11 = (float)(var4.z() - var2.z) - field14741;
         var3 = ColorUtils.method04611(var3, var5);
         float var12 = var9 + field14742;
         float var13 = var10 + field14743;
         float var14 = var11 + field14744;
         float var15 = var1.m00();
         float var16 = var1.m10();
         float var17 = var1.m20();
         float var18 = var1.m30();
         float var19 = var1.m01();
         float var20 = var1.m11();
         float var21 = var1.m21();
         float var22 = var1.m31();
         float var23 = var1.m02();
         float var24 = var1.m12();
         float var25 = var1.m22();
         float var26 = var1.m32();
         float var27 = var15 * var9 + var16 * var10 + var17 * var11 + var18;
         float var28 = var19 * var9 + var20 * var10 + var21 * var11 + var22;
         float var29 = var23 * var9 + var24 * var10 + var25 * var11 + var26;
         float var30 = var15 * var12 + var16 * var10 + var17 * var11 + var18;
         float var31 = var19 * var12 + var20 * var10 + var21 * var11 + var22;
         float var32 = var23 * var12 + var24 * var10 + var25 * var11 + var26;
         float var33 = var15 * var9 + var16 * var13 + var17 * var11 + var18;
         float var34 = var19 * var9 + var20 * var13 + var21 * var11 + var22;
         float var35 = var23 * var9 + var24 * var13 + var25 * var11 + var26;
         float var36 = var15 * var12 + var16 * var13 + var17 * var11 + var18;
         float var37 = var19 * var12 + var20 * var13 + var21 * var11 + var22;
         float var38 = var23 * var12 + var24 * var13 + var25 * var11 + var26;
         float var39 = var15 * var9 + var16 * var10 + var17 * var14 + var18;
         float var40 = var19 * var9 + var20 * var10 + var21 * var14 + var22;
         float var41 = var23 * var9 + var24 * var10 + var25 * var14 + var26;
         float var42 = var15 * var12 + var16 * var10 + var17 * var14 + var18;
         float var43 = var19 * var12 + var20 * var10 + var21 * var14 + var22;
         float var44 = var23 * var12 + var24 * var10 + var25 * var14 + var26;
         float var45 = var15 * var9 + var16 * var13 + var17 * var14 + var18;
         float var46 = var19 * var9 + var20 * var13 + var21 * var14 + var22;
         float var47 = var23 * var9 + var24 * var13 + var25 * var14 + var26;
         float var48 = var15 * var12 + var16 * var13 + var17 * var14 + var18;
         float var49 = var19 * var12 + var20 * var13 + var21 * var14 + var22;
         float var50 = var23 * var12 + var24 * var13 + var25 * var14 + var26;
         var6.coloredVertexPre(var33, var34, var35, var3);
         var6.coloredVertexPre(var36, var37, var38, var3);
         var6.coloredVertexPre(var36, var37, var38, var3);
         var6.coloredVertexPre(var48, var49, var50, var3);
         var6.coloredVertexPre(var48, var49, var50, var3);
         var6.coloredVertexPre(var45, var46, var47, var3);
         var6.coloredVertexPre(var45, var46, var47, var3);
         var6.coloredVertexPre(var33, var34, var35, var3);
         var6.coloredVertexPre(var30, var31, var32, var3);
         var6.coloredVertexPre(var42, var43, var44, var3);
         var6.coloredVertexPre(var42, var43, var44, var3);
         var6.coloredVertexPre(var39, var40, var41, var3);
         var6.coloredVertexPre(var39, var40, var41, var3);
         var6.coloredVertexPre(var27, var28, var29, var3);
         var6.coloredVertexPre(var27, var28, var29, var3);
         var6.coloredVertexPre(var30, var31, var32, var3);
         var6.coloredVertexPre(var42, var43, var44, var3);
         var6.coloredVertexPre(var48, var49, var50, var3);
         var6.coloredVertexPre(var30, var31, var32, var3);
         var6.coloredVertexPre(var36, var37, var38, var3);
         var6.coloredVertexPre(var39, var40, var41, var3);
         var6.coloredVertexPre(var45, var46, var47, var3);
         var6.coloredVertexPre(var27, var28, var29, var3);
         var6.coloredVertexPre(var33, var34, var35, var3);
      }
   }

   public static void method06534(VertexConsumer var0, Matrix4f var1, Vec3 var2, ColoredBlockPos var3, Frustum var4, float var5) {
      if (var0 instanceof BaritoneVertexConsumerAccess var6) {
         int var7 = var3.pos().getX();
         int var8 = var3.pos().getY();
         int var9 = var3.pos().getZ();
         float var10 = (float)(var7 - var2.x);
         float var11 = (float)(var8 - var2.y);
         float var12 = (float)(var9 - var2.z);
         method06536(
            var6,
            var1,
            var10,
            var11,
            var12,
            var10 + 1.0F,
            var11 + 1.0F,
            var12 + 1.0F,
            var3.color().red() / field14731,
            var3.color().green() / field14732,
            var3.color().blue() / field14733,
            var5
         );
      }
   }

   public static void method06535(VertexConsumer var0, Matrix4f var1, Vec3 var2, AABB var3, int var4, float var5) {
      if (var0 instanceof BaritoneVertexConsumerAccess var6) {
         method06536(
            var6,
            var1,
            (float)(var3.minX - var2.x),
            (float)(var3.minY - var2.y),
            (float)(var3.minZ - var2.z),
            (float)(var3.maxX - var2.x),
            (float)(var3.maxY - var2.y),
            (float)(var3.maxZ - var2.z),
            ColorUtils.method04588(var4) / field14734,
            ColorUtils.method04589(var4) / field14735,
            ColorUtils.method04587(var4) / field14736,
            var5
         );
      }
   }

   private static void method06536(
      BaritoneVertexConsumerAccess var0,
      Matrix4f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11
   ) {
      float var12 = var1.m00();
      float var13 = var1.m10();
      float var14 = var1.m20();
      float var15 = var1.m30();
      float var16 = var1.m01();
      float var17 = var1.m11();
      float var18 = var1.m21();
      float var19 = var1.m31();
      float var20 = var1.m02();
      float var21 = var1.m12();
      float var22 = var1.m22();
      float var23 = var1.m32();
      float var24 = var12 * var2 + var13 * var3 + var14 * var4 + var15;
      float var25 = var16 * var2 + var17 * var3 + var18 * var4 + var19;
      float var26 = var20 * var2 + var21 * var3 + var22 * var4 + var23;
      float var27 = var12 * var5 + var13 * var3 + var14 * var4 + var15;
      float var28 = var16 * var5 + var17 * var3 + var18 * var4 + var19;
      float var29 = var20 * var5 + var21 * var3 + var22 * var4 + var23;
      float var30 = var12 * var2 + var13 * var6 + var14 * var4 + var15;
      float var31 = var16 * var2 + var17 * var6 + var18 * var4 + var19;
      float var32 = var20 * var2 + var21 * var6 + var22 * var4 + var23;
      float var33 = var12 * var5 + var13 * var6 + var14 * var4 + var15;
      float var34 = var16 * var5 + var17 * var6 + var18 * var4 + var19;
      float var35 = var20 * var5 + var21 * var6 + var22 * var4 + var23;
      float var36 = var12 * var2 + var13 * var3 + var14 * var7 + var15;
      float var37 = var16 * var2 + var17 * var3 + var18 * var7 + var19;
      float var38 = var20 * var2 + var21 * var3 + var22 * var7 + var23;
      float var39 = var12 * var5 + var13 * var3 + var14 * var7 + var15;
      float var40 = var16 * var5 + var17 * var3 + var18 * var7 + var19;
      float var41 = var20 * var5 + var21 * var3 + var22 * var7 + var23;
      float var42 = var12 * var2 + var13 * var6 + var14 * var7 + var15;
      float var43 = var16 * var2 + var17 * var6 + var18 * var7 + var19;
      float var44 = var20 * var2 + var21 * var6 + var22 * var7 + var23;
      float var45 = var12 * var5 + var13 * var6 + var14 * var7 + var15;
      float var46 = var16 * var5 + var17 * var6 + var18 * var7 + var19;
      float var47 = var20 * var5 + var21 * var6 + var22 * var7 + var23;
      var0.coloredVertexFPre(var30, var31, var32, var8, var9, var10, var11);
      var0.coloredVertexFPre(var33, var34, var35, var8, var9, var10, var11);
      var0.coloredVertexFPre(var33, var34, var35, var8, var9, var10, var11);
      var0.coloredVertexFPre(var45, var46, var47, var8, var9, var10, var11);
      var0.coloredVertexFPre(var45, var46, var47, var8, var9, var10, var11);
      var0.coloredVertexFPre(var42, var43, var44, var8, var9, var10, var11);
      var0.coloredVertexFPre(var42, var43, var44, var8, var9, var10, var11);
      var0.coloredVertexFPre(var30, var31, var32, var8, var9, var10, var11);
      var0.coloredVertexFPre(var27, var28, var29, var8, var9, var10, var11);
      var0.coloredVertexFPre(var39, var40, var41, var8, var9, var10, var11);
      var0.coloredVertexFPre(var39, var40, var41, var8, var9, var10, var11);
      var0.coloredVertexFPre(var36, var37, var38, var8, var9, var10, var11);
      var0.coloredVertexFPre(var36, var37, var38, var8, var9, var10, var11);
      var0.coloredVertexFPre(var24, var25, var26, var8, var9, var10, var11);
      var0.coloredVertexFPre(var24, var25, var26, var8, var9, var10, var11);
      var0.coloredVertexFPre(var27, var28, var29, var8, var9, var10, var11);
      var0.coloredVertexFPre(var39, var40, var41, var8, var9, var10, var11);
      var0.coloredVertexFPre(var45, var46, var47, var8, var9, var10, var11);
      var0.coloredVertexFPre(var27, var28, var29, var8, var9, var10, var11);
      var0.coloredVertexFPre(var33, var34, var35, var8, var9, var10, var11);
      var0.coloredVertexFPre(var36, var37, var38, var8, var9, var10, var11);
      var0.coloredVertexFPre(var42, var43, var44, var8, var9, var10, var11);
      var0.coloredVertexFPre(var24, var25, var26, var8, var9, var10, var11);
      var0.coloredVertexFPre(var30, var31, var32, var8, var9, var10, var11);
   }
}
