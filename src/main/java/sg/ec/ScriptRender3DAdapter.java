// Original binary: sg/ec/nUrRaQxj8eOVxroE
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import hex.script.api.Render3D;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

// $VF: Compiled from s
public final class ScriptRender3DAdapter implements MinecraftAccess {
   private final Render3D field21960 = new Render3D(
      this::method09692,
      this::method09677,
      this::method09685,
      this::method09693,
      this::method09687,
      this::method09696,
      this::method09695,
      this::method09682,
      this::method09698
   );
   private final Quaternionf field21961 = new Quaternionf();
   private final Vector3f field21962 = new Vector3f();
   private PoseStack field21963;
   private WorldVertexCollector field21964;
   private Camera field21965;
   private float field21966;
   private boolean field21967;
   private static final double field21968 = 2.0;
   private static final double field21969 = Math.PI;
   private static final float field21970 = 8.0F;
   private static final long field21971 = 1000000000000L;
   private static final float field21972 = 1.0E9F;

   private void method09676(double var1, double var3, double var5, double var7, double var9, double var11, int var13, boolean var14) {
      this.method09692(var1, var3, var5, var7, var9, var11, var13, var14);
   }

   private void method09677(double var1, double var3, double var5, double var7, double var9, double var11, int var13, boolean var14, boolean var15) {
      if (this.field21964 != null) {
         if (var15) {
            this.method09678(var1, var3, var5, var7, var9, var11, var13, var14);
         } else {
            this.method09676(var1, var3, var5, var7, var3, var5, var13, var14);
            this.method09676(var7, var3, var5, var7, var3, var11, var13, var14);
            this.method09676(var7, var3, var11, var1, var3, var11, var13, var14);
            this.method09676(var1, var3, var11, var1, var3, var5, var13, var14);
            this.method09676(var1, var9, var5, var7, var9, var5, var13, var14);
            this.method09676(var7, var9, var5, var7, var9, var11, var13, var14);
            this.method09676(var7, var9, var11, var1, var9, var11, var13, var14);
            this.method09676(var1, var9, var11, var1, var9, var5, var13, var14);
            this.method09676(var1, var3, var5, var1, var9, var5, var13, var14);
            this.method09676(var7, var3, var5, var7, var9, var5, var13, var14);
            this.method09676(var7, var3, var11, var7, var9, var11, var13, var14);
            this.method09676(var1, var3, var11, var1, var9, var11, var13, var14);
         }
      }
   }

   private void method09678(double var1, double var3, double var5, double var7, double var9, double var11, int var13, boolean var14) {
      this.method09679(var13, var14, var1, var3, var5, var7, var3, var5, var7, var3, var11, var1, var3, var11);
      this.method09679(var13, var14, var1, var9, var5, var7, var9, var5, var7, var9, var11, var1, var9, var11);
      this.method09679(var13, var14, var1, var3, var5, var7, var3, var5, var7, var9, var5, var1, var9, var5);
      this.method09679(var13, var14, var1, var3, var11, var7, var3, var11, var7, var9, var11, var1, var9, var11);
      this.method09679(var13, var14, var1, var3, var5, var1, var3, var11, var1, var9, var11, var1, var9, var5);
      this.method09679(var13, var14, var7, var3, var5, var7, var3, var11, var7, var9, var11, var7, var9, var5);
   }

   private void method09679(int var1, boolean var2, double... var3) {
      this.method09687(var3, var1, var2);
   }

   private void method09680(VertexConsumer var1, Matrix4f var2, double var3, double var5, double var7, int var9) {
      Vec3 var10 = this.field21965.position();
      var1.addVertex(var2, (float)(var3 - var10.x), (float)(var5 - var10.y), (float)(var7 - var10.z)).setColor(var9);
   }

   private VertexConsumer method09681(boolean var1) {
      return this.field21964.method07407(EffectRenderPipelines.method05567(this.method09688(-1, var1, false)));
   }

   private double method09682(int var1) {
      if (this.field21965 == null) {
         return 0.0;
      }

      if (var1 == 3) {
         return this.field21965.yRot();
      }

      if (var1 == 4) {
         return this.field21965.xRot();
      }

      Vec3 var2 = this.field21965.position();
      return var1 == 0 ? var2.x : (var1 == 1 ? var2.y : var2.z);
   }

   private VertexConsumer method09683(boolean var1) {
      return this.field21964.method07407(EffectRenderPipelines.method05513(this.method09688(-1, var1, false)));
   }

   void method09684(PoseStack var1, WorldVertexCollector var2, Camera var3, float var4) {
      this.field21963 = var1;
      this.field21964 = var2;
      this.field21965 = var3;
      this.field21966 = var4;
   }

   private void method09685(Object var1, int var2, boolean var3, boolean var4) {
      Entity var5 = ScriptEntitiesAdapter.method09073(var1);
      if (this.field21964 != null && var5 != null) {
         double var6 = var5.xOld + (var5.getX() - var5.xOld) * this.field21966;
         double var8 = var5.yOld + (var5.getY() - var5.yOld) * this.field21966;
         double var10 = var5.zOld + (var5.getZ() - var5.zOld) * this.field21966;
         AABB var12 = var5.getBoundingBox();
         double var13 = (var12.maxX - var12.minX) / field21968;
         double var15 = var12.maxY - var12.minY;
         this.method09677(var6 - var13, var8, var10 - var13, var6 + var13, var8 + var15, var10 + var13, var2, var3, var4);
      }
   }

   private float method09686() {
      return (float)(System.nanoTime() % field21971) / field21972;
   }

   private void method09687(double[] var1, int var2, boolean var3) {
      if (this.field21964 != null && var1 != null && var1.length >= 9) {
         Matrix4f var4 = this.field21963.last().pose();
         VertexConsumer var5 = this.method09683(var3);
         int var6 = var1.length / 3;

         for (int var7 = 1; var7 + 1 < var6; var7++) {
            this.method09680(var5, var4, var1[0], var1[1], var1[2], var2);
            this.method09680(var5, var4, var1[var7 * 3], var1[var7 * 3 + 1], var1[var7 * 3 + 2], var2);
            this.method09680(var5, var4, var1[(var7 + 1) * 3], var1[(var7 + 1) * 3 + 1], var1[(var7 + 1) * 3 + 2], var2);
         }
      }
   }

   private int method09688(int var1, boolean var2, boolean var3) {
      int var4 = var1 < 0 ? (this.field21967 ? 1 : 0) : var1;
      return EffectRenderPipelines.method05520(var4, var2 ? 0 : 1, var3);
   }

   private RenderType method09689(String var1, Identifier var2, int var3) {
      if (var1 != null && !var1.isEmpty()) {
         RenderPipeline var4 = ScriptShaderManager.method10933(var1, var3, var2 != null);
         return ScriptShaderManager.method10952(var1, var4) ? EffectRenderPipelines.method05537(var4, var2) : null;
      } else {
         return var2 == null ? EffectRenderPipelines.method05513(var3) : EffectRenderPipelines.method05565(var2, var3);
      }
   }

   void method09690() {
      this.field21967 = false;
      this.field21963 = null;
      this.field21964 = null;
      this.field21965 = null;
   }

   private void method09691(VertexConsumer var1, Matrix4f var2, double var3, double var5, double var7, int var9, float var10, float var11) {
      Vec3 var12 = this.field21965.position();
      var1.addVertex(var2, (float)(var3 - var12.x), (float)(var5 - var12.y), (float)(var7 - var12.z)).setUv(var10, var11).setColor(var9);
   }

   private void method09692(double var1, double var3, double var5, double var7, double var9, double var11, int var13, boolean var14) {
      if (this.field21964 != null) {
         Matrix4f var15 = this.field21963.last().pose();
         VertexConsumer var16 = this.method09681(var14);
         this.method09680(var16, var15, var1, var3, var5, var13);
         this.method09680(var16, var15, var7, var9, var11, var13);
      }
   }

   private void method09693(double var1, double var3, double var5, int var7, boolean var8) {
      if (this.field21964 != null && this.field21965 != null) {
         Vec3 var9 = Vec3.directionFromRotation(this.field21965.xRot(), this.field21965.yRot());
         Vec3 var10 = this.field21965.position().add(var9);
         this.method09692(var10.x, var10.y, var10.z, var1, var3, var5, var7, var8);
      }
   }

   Render3D method09694() {
      return this.field21960;
   }

   private float method09695() {
      return this.field21966;
   }

   private void method09696(
      String var1,
      String var2,
      String var3,
      double var4,
      double var6,
      double var8,
      float var10,
      float var11,
      float var12,
      int var13,
      int var14,
      int var15,
      boolean var16,
      boolean var17
   ) {
      float[] var18 = MeshBufferUtils.method07839(var1);
      int var19 = MeshBufferUtils.method07837(var18);
      if (this.field21964 != null && this.field21965 != null && var19 != 0) {
         if (var17) {
            this.field21961.set(this.field21965.rotation());
         } else {
            this.field21961.rotationYXZ((float)(field21969 - Math.toRadians(var11)), (float)(-Math.toRadians(var12)), 0.0F);
         }

         int var20 = var14 < 0 ? (this.field21967 ? 1 : 0) : var14;
         int var21 = EffectRenderPipelines.method05520(var20, var15, var16);
         Identifier var22 = ScriptRenderResources.method08786(var3);
         RenderType var23 = this.method09689(var2, var22, var21);
         if (var23 != null) {
            boolean var24 = var2 != null && !var2.isEmpty();
            boolean var25 = var24 && MeshBufferUtils.method07831(var1);
            int var26 = Math.round(var10 * field21970);
            float var27 = this.method09686();
            Matrix4f var28 = this.field21963.last().pose();
            VertexConsumer var29 = this.field21964.method07407(var23);

            for (int var30 = 0; var30 < var19; var30++) {
               int var31 = var30 * 11;
               this.field21962.set(var18[var31] * var10, var18[var31 + 1] * var10, var18[var31 + 2] * var10).rotate(this.field21961);
               int var32 = MeshBufferUtils.method07836(Float.floatToRawIntBits(var18[var31 + 3]), var13);
               double var33 = var4 + this.field21962.x;
               double var35 = var6 + this.field21962.y;
               double var37 = var8 + this.field21962.z;
               if (var24) {
                  this.method09697(var29, var28, var33, var35, var37, var32, var18, var31, var25, var26, var27);
               } else if (var22 == null) {
                  this.method09680(var29, var28, var33, var35, var37, var32);
               } else {
                  this.method09691(var29, var28, var33, var35, var37, var32, var18[var31 + 4], var18[var31 + 5]);
               }
            }
         }
      }
   }

   private void method09697(
      VertexConsumer var1, Matrix4f var2, double var3, double var5, double var7, int var9, float[] var10, int var11, boolean var12, int var13, float var14
   ) {
      Vec3 var15 = this.field21965.position();
      var1.addVertex(var2, (float)(var3 - var15.x), (float)(var5 - var15.y), (float)(var7 - var15.z))
         .setColor(var9)
         .setUv(var10[var11 + 4], var10[var11 + 5])
         .setUv1(var12 ? Math.round(var10[var11 + 6]) : var13, var12 ? Math.round(var10[var11 + 7]) : 0)
         .setUv2(var12 ? Math.round(var10[var11 + 8]) : 0, var12 ? Math.round(var10[var11 + 9]) : 0)
         .setLineWidth(var12 ? var10[var11 + 10] : var14);
   }

   private void method09698(boolean var1) {
      this.field21967 = var1;
   }
}
