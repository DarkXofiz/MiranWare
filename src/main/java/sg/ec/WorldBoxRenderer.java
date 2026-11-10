// Original binary: sg/ec/aag5xcASZ7Qhb2BD
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

// $VF: Compiled from s
public final class WorldBoxRenderer {
   private static final String field15678 = "This is a utility class and cannot be instantiated";

   public static void method06956(Vec3 var0, PoseStack var1, Camera var2, Frustum var3, WorldVertexCollector var4) {
      method06957(var0, var1, var2, var3, var4, -1);
   }

   public static void method06957(Vec3 var0, PoseStack var1, Camera var2, Frustum var3, WorldVertexCollector var4, int var5) {
      method06958(new AABB(var0, var0.add(1.0, 1.0, 1.0)), var1, var2, var3, var4, var5);
   }

   private WorldBoxRenderer() {
      throw new UnsupportedOperationException(field15678);
   }

   public static void method06958(AABB var0, PoseStack var1, Camera var2, Frustum var3, WorldVertexCollector var4, int var5) {
      if (var3.isVisible(var0)) {
         var1.pushPose();
         Vec3 var6 = var2.position();
         if (var4.method07407(EffectRenderPipelines.field11856) instanceof BaritoneVertexConsumerAccess var8) {
            Matrix4f var9 = var1.last().pose();
            float var10 = (float)(var0.minX - var6.x);
            float var11 = (float)(var0.minY - var6.y);
            float var12 = (float)(var0.minZ - var6.z);
            float var13 = (float)(var0.maxX - var6.x);
            float var14 = (float)(var0.maxY - var6.y);
            float var15 = (float)(var0.maxZ - var6.z);
            var8.coloredVertex(var9, var10, var11, var12, var5);
            var8.coloredVertex(var9, var13, var11, var12, var5);
            var8.coloredVertex(var9, var13, var11, var15, var5);
            var8.coloredVertex(var9, var10, var11, var15, var5);
            var8.coloredVertex(var9, var10, var11, var12, var5);
            var8.coloredVertex(var9, var10, var14, var12, var5);
            var8.coloredVertex(var9, var13, var14, var12, var5);
            var8.coloredVertex(var9, var13, var11, var12, var5);
            var8.coloredVertex(var9, var13, var11, var12, var5);
            var8.coloredVertex(var9, var13, var14, var12, var5);
            var8.coloredVertex(var9, var13, var14, var15, var5);
            var8.coloredVertex(var9, var13, var11, var15, var5);
            var8.coloredVertex(var9, var10, var11, var15, var5);
            var8.coloredVertex(var9, var13, var11, var15, var5);
            var8.coloredVertex(var9, var13, var14, var15, var5);
            var8.coloredVertex(var9, var10, var14, var15, var5);
            var8.coloredVertex(var9, var10, var11, var12, var5);
            var8.coloredVertex(var9, var10, var11, var15, var5);
            var8.coloredVertex(var9, var10, var14, var15, var5);
            var8.coloredVertex(var9, var10, var14, var12, var5);
            var8.coloredVertex(var9, var10, var14, var12, var5);
            var8.coloredVertex(var9, var10, var14, var15, var5);
            var8.coloredVertex(var9, var13, var14, var15, var5);
            var8.coloredVertex(var9, var13, var14, var12, var5);
            var1.popPose();
         } else {
            var1.popPose();
         }
      }
   }
}
