// Original binary: sg/ec/2VZrEDVWQO6IYGue
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.util.Mth;
import org.joml.Matrix4f;
import org.joml.Quaternionf;

// $VF: Compiled from s
public final class ItemAnimationMath {
   public static final double field01051 = (float) Math.PI;
   private static final float field01052 = 0;
   private static final Quaternionf field01053 = new Quaternionf();
   private static final float field01054 = (float) (Math.PI / 180.0);
   private static final float field01055 = (float) (Math.PI / 180.0);
   private static final float field01056 = (float) (Math.PI / 180.0);
   private static final float field01057 = (float) (Math.PI / 180.0);
   private static final float field01058 = (float) (Math.PI / 180.0);
   private static final float field01059 = (float) (Math.PI / 180.0);

   public static void method00508(PoseStack var0, double var1, double var3, double var5, double var7) {
      var0.rotateAround(field01053.rotationY((float)var1 * field01058), (float)var3, (float)var5, (float)var7);
   }

   public static void method00509(PoseStack var0, double var1, double var3, double var5, double var7) {
      var0.rotateAround(field01053.rotationZ((float)var1 * field01059), (float)var3, (float)var5, (float)var7);
   }

   public static double method00510(double var0) {
      return Math.ceil(var0);
   }

   public static void method00511(PoseStack var0, double var1, double var3, double var5, double var7) {
      var0.rotateAround(field01053.rotationX((float)var1 * field01057), (float)var3, (float)var5, (float)var7);
   }

   public static void method00512(PoseStack var0, double var1) {
      var0.mulPose(field01053.rotationY((float)var1 * field01055));
   }

   public static void method00513(PoseStack var0, double var1) {
      var0.mulPose(field01053.rotationX((float)var1 * field01054));
   }

   public static double method00514(double var0) {
      return Math.abs(var0);
   }

   private ItemAnimationMath() {
   }

   public static void method00515(PoseStack var0, double var1, double var3, double var5) {
      Matrix4f var7 = new Matrix4f(
         1.0F, (float)var1, (float)var1, 0.0F, (float)var3, 1.0F, (float)var3, 0.0F, (float)var5, (float)var5, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F
      );
      var0.last().pose().mul(var7);
   }

   public static void method00516(PoseStack var0, double var1, double var3, double var5) {
      var0.scale((float)var1, (float)var3, (float)var5);
   }

   public static void method00517(PoseStack var0, double var1) {
      var0.translate(0.0, 0.0, var1);
   }

   public static void method00518(PoseStack var0) {
      var0.popPose();
   }

   public static double method00519(double var0, double var2) {
      return Math.pow(var0, var2);
   }

   public static double method00520(double var0, double var2, double var4) {
      return Math.clamp(var0, var2, var4);
   }

   public static void method00521(PoseStack var0, double var1, double var3, double var5) {
      var0.translate(var1, var3, var5);
   }

   public static void method00522(PoseStack var0) {
      var0.pushPose();
   }

   public static double method00523(double var0) {
      return Math.round(var0);
   }

   public static void method00524(PoseStack var0, double var1) {
      var0.mulPose(field01053.rotationZ((float)var1 * field01056));
   }

   public static double method00525(double var0) {
      return Math.cos(var0);
   }

   public static double method00526(double var0) {
      return Math.sin(var0);
   }

   public static void method00527(PoseStack var0, double var1) {
      var0.translate(0.0, var1, 0.0);
   }

   public static double method00528(double var0, double var2, double var4) {
      return Mth.lerp(var0, var2, var4);
   }

   public static void method00529(PoseStack var0, double var1) {
      var0.translate(var1, 0.0, 0.0);
   }

   public static double method00530(double var0) {
      return Math.floor(var0);
   }
}
