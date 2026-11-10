// Original binary: sg/ec/T92NxpcCLIT8RlL2
package sg.ec;

import com.mojang.blaze3d.platform.Window;
import java.util.Random;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public final class GuiHitTestUtils implements MinecraftAccess {
   public static final Random field11989 = new Random();
   private static final double field11990 = 100.0;
   private static final double field11991 = 100.0;
   private static final String field11992 = "This is a utility class and cannot be instantiated";

   public static int method05604(int var0) {
      Window var1 = mc.getWindow();
      return var0 * var1.getGuiScale() / 2;
   }

   public static double method05605(double var0, double var2) {
      return var0 - var2;
   }

   private GuiHitTestUtils() {
      throw new UnsupportedOperationException(field11992);
   }

   public static double method05606(double var0, double var2) {
      double var4 = Math.round(var0 / var2) * var2;
      return Math.round(var4 * field11990) / field11991;
   }

   public static Vec3 method05607(Vec3 var0, Vec3 var1, float var2) {
      return new Vec3(method05616(var0.x(), var1.x(), var2), method05616(var0.y(), var1.y(), var2), method05616(var0.z(), var1.z(), var2));
   }

   public static boolean method05608(Vec3 var0) {
      if (mc.player == null) {
         return false;
      }

      Vec3 var1 = mc.player.getEyePosition();
      return RaycastUtils.method09498(var1, var0, Block.COLLIDER, Fluid.NONE).getType() == Type.MISS;
   }

   public static boolean method05609(double var0, double var2, float var4, float var5, float var6, float var7) {
      return var0 > var4 && var0 < var4 + var6 && var2 > var5 && var2 < var5 + var7;
   }

   public static double method05610(double var0, double var2, double var4) {
      return Math.clamp(var4, var0, var2);
   }

   public static Vec2 method05611(float var0, float var1) {
      return new Vec2(var0 * mc.getWindow().getGuiScale() / 2.0F, var1 * mc.getWindow().getGuiScale() / 2.0F);
   }

   public static double method05612(double var0, double var2, double var4) {
      return method05616(var2, var0, var4);
   }

   public static float method05613(float var0, float var1) {
      return var0 + field11989.nextFloat() * (var1 - var0);
   }

   public static int method05614(int var0, int var1, double var2) {
      return (int)method05616(var1, var0, var2);
   }

   public static float method05615(float var0, float var1, float var2) {
      return Math.clamp(var2, var0, var1);
   }

   public static double method05616(double var0, double var2, double var4) {
      return var2 + (var0 - var2) * var4;
   }

   public static float method05617(float var0, float var1, float var2) {
      var0 = Math.clamp(var0, var1, var2);
      return var1 + (var2 - var0);
   }

   public static float method05618(float var0, float var1, double var2) {
      return (float)method05616(var1, var0, var2);
   }

   public static int method05619(int var0, int var1, int var2) {
      return Math.clamp(var2, var0, var1);
   }

   public static double method05620(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = method05605(var6, var0);
      double var14 = method05605(var8, var2);
      double var16 = method05605(var10, var4);
      return Math.sqrt(var12 * var12 + var14 * var14 + var16 * var16);
   }

   public static float method05621(float var0) {
      return method05615(0.0F, 1.0F, var0);
   }

   public static double method05622(double var0) {
      return method05610(0.0, 1.0, var0);
   }

   public static double method05623(Vec3 var0, Vec3 var1) {
      double var2 = method05605(var1.x, var0.x);
      double var4 = method05605(var1.y, var0.y);
      double var6 = method05605(var1.z, var0.z);
      return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   public static boolean method05624(int var0, int var1, float var2, float var3, float var4, float var5) {
      return var0 > var2 && var0 < var2 + var4 && var1 > var3 && var1 < var3 + var5;
   }

   public static boolean method05625(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 > var2 && var0 < var2 + var4 && var1 > var3 && var1 < var3 + var5;
   }
}
