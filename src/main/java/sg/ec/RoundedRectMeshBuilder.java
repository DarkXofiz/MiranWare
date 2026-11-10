// Original binary: sg/ec/zYjYNUHCgowyqUk2
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class RoundedRectMeshBuilder {
   private static final float field27907 = -1.5F;

   public static void method11741(
      VertexConsumer var0,
      Matrix3x2f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15
   ) {
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2, var3).setColor(var6))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .smooth(var14)
         .range(var15);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2, var3 + var5).setColor(var7))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .smooth(var14)
         .range(var15);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2 + var4, var3 + var5).setColor(var8))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .smooth(var14)
         .range(var15);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2 + var4, var3).setColor(var9))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .smooth(var14)
         .range(var15);
   }

   public static void method11742(
      VertexConsumer var0,
      Matrix3x2f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16
   ) {
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2, var3).setColor(var6))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .thickness(var14)
         .vec2f(var15, var16)
         .coord(0.0F, 0.0F);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2, var3 + var5).setColor(var7))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .thickness(var14)
         .vec2f(var15, var16)
         .coord(0.0F, 1.0F);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2 + var4, var3 + var5).setColor(var8))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .thickness(var14)
         .vec2f(var15, var16)
         .coord(1.0F, 1.0F);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2 + var4, var3).setColor(var9))
         .size(var4, var5)
         .radius(var10, var11, var12, var13)
         .thickness(var14)
         .vec2f(var15, var16)
         .coord(1.0F, 0.0F);
   }

   public static void method11743(
      VertexConsumer var0,
      Matrix3x2f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14
   ) {
      float var15 = var2;
      float var16 = var3;
      float var17 = var4;
      float var18 = var5;
      if (var14 <= field27907) {
         var15 = var2 - 1.0F;
         var16 = var3 - 1.0F;
         var17 = var4 + 2.0F;
         var18 = var5 + 2.0F;
      }

      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var15, var16).setColor(var6))
         .radius(var10, var11, var12, var13)
         .size(var4, var5)
         .smooth(var14)
         .coord(0.0F, 0.0F);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var15, var16 + var18).setColor(var7))
         .radius(var10, var11, var12, var13)
         .size(var4, var5)
         .smooth(var14)
         .coord(0.0F, 1.0F);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var15 + var17, var16 + var18).setColor(var8))
         .radius(var10, var11, var12, var13)
         .size(var4, var5)
         .smooth(var14)
         .coord(1.0F, 1.0F);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var15 + var17, var16).setColor(var9))
         .radius(var10, var11, var12, var13)
         .size(var4, var5)
         .smooth(var14)
         .coord(1.0F, 0.0F);
   }

   private RoundedRectMeshBuilder() {
   }

   public static void method11744(
      VertexConsumer var0,
      Matrix3x2f var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      int var10,
      int var11,
      int var12,
      int var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18
   ) {
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2, var3).setUv(var6, var7).setColor(var10))
         .size(var4, var5)
         .radius(var14, var15, var16, var17)
         .smooth(var18);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2, var3 + var5).setUv(var6, var7 + var9).setColor(var11))
         .size(var4, var5)
         .radius(var14, var15, var16, var17)
         .smooth(var18);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2 + var4, var3 + var5).setUv(var6 + var8, var7 + var9).setColor(var12))
         .size(var4, var5)
         .radius(var14, var15, var16, var17)
         .smooth(var18);
      ((ExtendedVertexConsumer)var0.addVertexWith2DPose(var1, var2 + var4, var3).setUv(var6 + var8, var7).setColor(var13))
         .size(var4, var5)
         .radius(var14, var15, var16, var17)
         .smooth(var18);
   }
}
