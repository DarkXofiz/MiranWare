// Original binary: sg/ec/m5UPjK5OdT8IuuFs
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;
import sg.mx.GameRendererMixin;

// $VF: Compiled from s
public final class WorldProjectionUtils implements MinecraftAccess {
   public static double field21479 = 0.0;
   public static double field21480 = 0.0;
   private static final Matrix4f field21481 = new Matrix4f();
   private static final Quaternionf field21482 = new Quaternionf();
   private static final Vector3f field21483 = new Vector3f();
   private static CameraRenderState field21484;
   private static boolean field21485 = true;
   private static final float field21486 = Float.MAX_VALUE;
   private static final float field21487 = Float.MAX_VALUE;
   private static final float field21488 = -Float.MAX_VALUE;
   private static final float field21489 = -Float.MAX_VALUE;
   private static final float field21490 = Float.MAX_VALUE;
   private static final float field21491 = Float.MAX_VALUE;
   private static final float field21492 = Float.MAX_VALUE;
   private static final float field21493 = Float.MAX_VALUE;
   private static final float field21494 = Float.MAX_VALUE;
   private static final double field21495 = 2.0;
   private static final String field21496 = "This is a utility class and cannot be instantiated";

   public static Vector2f method09446(PoseStack var0, double var1, double var3, double var5, double var7, Vector2f var9) {
      Camera var10 = mc.gameRenderer.mainCamera();
      Vec3 sx = var10.position();
      field21482.set(var10.rotation()).conjugate();
      Vector3f sxx = field21483.set((float)(var1 - sx.x), (float)(var3 - sx.y), (float)(var5 - sx.z));
      sxx.rotate(field21482);
      method09451(sxx);
      return method09458(sxx, var7, var9);
   }

   private static boolean method09447(Vector2f var0, float var1, float var2, float var3, float var4) {
      return var0.x != field21491
         && var0.y != field21492
         && Float.isFinite(var0.x)
         && Float.isFinite(var0.y)
         && var0.x >= -var3
         && var0.x <= var1 + var3
         && var0.y >= -var4
         && var0.y <= var2 + var4;
   }

   public static Vector2f method09448(PoseStack var0, Vec3 var1, double var2) {
      return method09457(var0, var1.x, var1.y, var1.z, var2);
   }

   private WorldProjectionUtils() {
      throw new UnsupportedOperationException(field21496);
   }

   public static double method09449() {
      return field21479;
   }

   public static void method09450() {
      field21479 = mc.gameRenderer.mainCamera().getFov();
   }

   private static void method09451(Vector3f var0) {
      if (field21484 != null && mc.player != null) {
         boolean var1 = mc.options.bobView().get();
         boolean var2 = mc.player.hurtTime > 0;
         if (var1 || var2) {
            if (field21485) {
               PoseStack var3 = new PoseStack();
               GameRendererMixin var4 = (GameRendererMixin)(Object)mc.gameRenderer;
               if (var2) {
                  var4.tiltViewWhenHurtAccessor(field21484, var3);
               }

               if (var1) {
                  var4.bobViewAccessor(field21484, var3);
               }

               field21481.set(var3.last().pose());
               field21485 = false;
            }

            field21481.transformPosition(var0);
         }
      }
   }

   public static int method09452(PoseStack var0, AABB var1, Vector2f var2, Vector2f var3, Vector2f var4, float var5, float var6, float var7, float var8) {
      return method09459(var0, var1, method09449(), true, var5, var6, var7, var8, var2, var3, var4);
   }

   public static void method09453(CameraRenderState var0) {
      field21484 = var0;
      field21485 = true;
   }

   public static Vector2f method09454(PoseStack var0, double var1, double var3, double var5, Vector2f var7) {
      return method09446(var0, var1, var3, var5, method09449(), var7);
   }

   public static Vector2f method09455(PoseStack var0, double var1, double var3, double var5) {
      return method09457(var0, var1, var3, var5, method09449());
   }

   public static int method09456(PoseStack var0, AABB var1, double var2, Vector2f var4, Vector2f var5, Vector2f var6) {
      return method09459(var0, var1, var2, false, 0.0F, 0.0F, 0.0F, 0.0F, var4, var5, var6);
   }

   public static Vector2f method09457(PoseStack var0, double var1, double var3, double var5, double var7) {
      return method09446(var0, var1, var3, var5, var7, new Vector2f());
   }

   private static Vector2f method09458(Vector3f var0, double var1, Vector2f var3) {
      if (var0.z() >= 0.0F) {
         return var3.set(field21493, field21494);
      }

      float var4 = CameraAspectRatioHooks.method08590(mc.getWindow().getWidth(), mc.getWindow().getHeight());
      float var5 = mc.getWindow().getGuiScaledHeight() / 2.0F;
      float var6 = mc.getWindow().getGuiScaledWidth() / 2.0F;
      float var7 = (float)(1.0 / Math.tan(Math.toRadians(var1) / field21495));
      float var8 = var0.x() * (var7 / var4);
      float var9 = var0.y() * var7;
      float var10 = var8 / -var0.z();
      float var11 = var9 / -var0.z();
      return var3.set(var10 * var6 + var6, var5 - var11 * var5);
   }

   private static int method09459(
      PoseStack var0, AABB var1, double var2, boolean var4, float var5, float var6, float var7, float var8, Vector2f var9, Vector2f var10, Vector2f var11
   ) {
      var10.set(field21486, field21487);
      var11.set(field21488, field21489);
      int var12 = 0;

      for (int var13 = 0; var13 < 8; var13++) {
         double var14 = (var13 & 1) == 0 ? var1.minX : var1.maxX;
         double var16 = (var13 & 2) == 0 ? var1.minY : var1.maxY;
         double var18 = (var13 & 4) == 0 ? var1.minZ : var1.maxZ;
         Vector2f var20 = method09446(var0, var14, var16, var18, var2, var9);
         if (var20.x != field21490 && (!var4 || method09447(var20, var5, var6, var7, var8))) {
            var10.x = Math.min(var10.x, var20.x);
            var10.y = Math.min(var10.y, var20.y);
            var11.x = Math.max(var11.x, var20.x);
            var11.y = Math.max(var11.y, var20.y);
            var12++;
         }
      }

      return var12;
   }

   public static Vector2f method09460(PoseStack var0, Vec3 var1) {
      return method09455(var0, var1.x, var1.y, var1.z);
   }
}
