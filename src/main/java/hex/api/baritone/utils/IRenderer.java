// Original binary: hex/api/baritone/utils/IRenderer
package hex.api.baritone.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.Settings;
import hex.api.baritone.utils.accessor.IEntityRenderManager;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import sg.ec.BaritoneVertexConsumerAccess;
import sg.ec.EffectRenderPipelines;
import sg.ec.WorldVertexCollector;

// $VF: Compiled from s
public interface IRenderer {
   IEntityRenderManager renderManager = (IEntityRenderManager)Minecraft.getInstance().getEntityRenderDispatcher();
   Settings settings = BaritoneAPI.getSettings();
   float[] color = new float[]{1.0F, 1.0F, 1.0F, 255.0F};
   WorldVertexCollector[] PROVIDER = new WorldVertexCollector[1];

   static void emitLine(BaritoneVertexConsumerAccess var0, PoseStack var1, Vec3 var2, Vec3 var3, float var4) {
      double var5 = renderManager.renderPosX();
      double sx = renderManager.renderPosY();
      double sxx = renderManager.renderPosZ();
      emitLine(var0, var1, var2.x - var5, var2.y - sx, var2.z - sxx, var3.x - var5, var3.y - sx, var3.z - sxx, var4);
   }

   static BaritoneVertexConsumerAccess buffer() {
      WorldVertexCollector var0 = PROVIDER[0];
      if (var0 == null) {
         return null;
      }

      RenderType sx = EffectRenderPipelines.method05562();
      return var0.method07407(sx) instanceof BaritoneVertexConsumerAccess sxx ? sxx : null;
   }

   static BaritoneVertexConsumerAccess startLines(Color var0, float var1) {
      glColor(var0, var1);
      return buffer();
   }

   static void emitLine(
      BaritoneVertexConsumerAccess var0,
      PoseStack var1,
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
      emitLine(var0, var1, var2, var3, var4, var5, var6, var7, var11);
   }

   static void setProvider(WorldVertexCollector var0) {
      PROVIDER[0] = var0;
   }

   static void emitAABB(BaritoneVertexConsumerAccess var0, PoseStack var1, AABB var2, double var3, float var5) {
      emitAABB(var0, var1, var2.inflate(var3, var3, var3), var5);
   }

   static void endLines(BaritoneVertexConsumerAccess var0, boolean var1) {
   }

   static void emitLine(BaritoneVertexConsumerAccess var0, PoseStack var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14) {
      if (var0 != null) {
         vertex(var0, var2, var4, var6);
         vertex(var0, var8, var10, var12);
      }
   }

   static void emitLine(
      BaritoneVertexConsumerAccess var0,
      PoseStack var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      float var20
   ) {
      emitLine(var0, var1, var2, var4, var6, var8, var10, var12, var20);
   }

   static void vertex(BaritoneVertexConsumerAccess var0, double var1, double var3, double var5) {
      var0.coloredVertexFPre((float)var1, (float)var3, (float)var5, color[0], color[1], color[2], color[3]);
   }

   static void glColor(Color var0, float var1) {
      float[] var2 = var0.getColorComponents(null);
      color[0] = var2[0];
      color[1] = var2[1];
      color[2] = var2[2];
      color[3] = var1;
   }

   static void emitAABB(BaritoneVertexConsumerAccess var0, PoseStack var1, AABB var2, float var3) {
      if (var0 != null) {
         AABB var4 = var2.move(-renderManager.renderPosX(), -renderManager.renderPosY(), -renderManager.renderPosZ());
         emitLine(var0, var1, var4.minX, var4.minY, var4.minZ, var4.maxX, var4.minY, var4.minZ, var3);
         emitLine(var0, var1, var4.maxX, var4.minY, var4.minZ, var4.maxX, var4.minY, var4.maxZ, var3);
         emitLine(var0, var1, var4.maxX, var4.minY, var4.maxZ, var4.minX, var4.minY, var4.maxZ, var3);
         emitLine(var0, var1, var4.minX, var4.minY, var4.maxZ, var4.minX, var4.minY, var4.minZ, var3);
         emitLine(var0, var1, var4.minX, var4.maxY, var4.minZ, var4.maxX, var4.maxY, var4.minZ, var3);
         emitLine(var0, var1, var4.maxX, var4.maxY, var4.minZ, var4.maxX, var4.maxY, var4.maxZ, var3);
         emitLine(var0, var1, var4.maxX, var4.maxY, var4.maxZ, var4.minX, var4.maxY, var4.maxZ, var3);
         emitLine(var0, var1, var4.minX, var4.maxY, var4.maxZ, var4.minX, var4.maxY, var4.minZ, var3);
         emitLine(var0, var1, var4.minX, var4.minY, var4.minZ, var4.minX, var4.maxY, var4.minZ, var3);
         emitLine(var0, var1, var4.maxX, var4.minY, var4.minZ, var4.maxX, var4.maxY, var4.minZ, var3);
         emitLine(var0, var1, var4.maxX, var4.minY, var4.maxZ, var4.maxX, var4.maxY, var4.maxZ, var3);
         emitLine(var0, var1, var4.minX, var4.minY, var4.maxZ, var4.minX, var4.maxY, var4.maxZ, var3);
      }
   }

   static BaritoneVertexConsumerAccess startLines(Color var0) {
      return startLines(var0, 0.4F);
   }
}
