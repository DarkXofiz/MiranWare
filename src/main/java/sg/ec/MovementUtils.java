// Original binary: sg/ec/TyfpkjJ0vzGWFeuJ
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class MovementUtils implements MinecraftAccess {
   private static final double field12068 = 0.001;
   private static final float field12069 = -1.0F;
   private static final double field12070 = 1.0E-4;
   private static final float field12071 = -1.0F;
   private static final float field12072 = -1.0F;
   private static final float field12073 = 180.0F;
   private static final float field12074 = 90.0F;
   private static final float field12075 = 90.0F;
   private static final float field12076 = 45.0F;
   private static final float field12077 = 45.0F;
   private static final float field12078 = 45.0F;
   private static final float field12079 = 45.0F;
   private static final double field12080 = -0.05;
   private static final float field12081 = -90.0F;
   private static final float field12082 = 90.0F;
   private static final float field12083 = -90.0F;
   private static final float field12084 = 90.0F;
   private static final float field12085 = 180.0F;
   private static final float field12086 = -180.0F;
   private static final double field12087 = 20.0;
   private static final double field12088 = -1.0;
   private static final double field12089 = -1.0;
   private static final float field12090 = 90.0F;
   private static final float field12091 = 90.0F;
   private static final float field12092 = 180.0F;
   private static final float field12093 = -0.5F;
   private static final float field12094 = 0.5F;
   private static final float field12095 = 90.0F;
   private static final float field12096 = 90.0F;
   private static final double field12097 = 360.0;
   private static final double field12098 = 360.0;
   private static final double field12099 = 90.0;
   private static final float field12100 = Float.MAX_VALUE;
   private static final float field12101 = -1.0F;
   private static final float field12102 = -1.0F;
   private static final String field12103 = "This is a utility class and cannot be instantiated";

   public static double[] method05708() {
      float var0 = method05717();
      if (var0 == field12069) {
         return new double[]{0.0, 0.0};
      }

      double sx = Math.toRadians(var0);
      return new double[]{-Math.sin(sx), Math.cos(sx)};
   }

   public static void method05709(double var0) {
      if (mc.player != null) {
         Vec3 var2 = mc.player.getDeltaMovement();
         mc.player.setDeltaMovement(var2.x, var2.y + var0, var2.z);
      }
   }

   public static Input method05710(Input var0, double var1, float var3) {
      boolean var4 = var0.forward();
      boolean var5 = var0.backward();
      boolean var6 = var0.left();
      boolean var7 = var0.right();
      if (var1 >= field12081 + var3 && var1 <= field12082 - var3) {
         var4 = true;
      } else if (var1 < field12083 - var3 || var1 > field12084 + var3) {
         var5 = true;
      }

      if (var1 >= 0.0F + var3 && var1 <= field12085 - var3) {
         var7 = true;
      } else if (var1 >= field12086 + var3 && var1 <= 0.0F - var3) {
         var6 = true;
      }

      return new Input(var4, var5, var6, var7, var0.jump(), var0.shift(), var0.sprint());
   }

   public static double method05711(Vec3 var0, float var1) {
      float var2 = (float)Math.atan2(-var0.x, var0.z);
      double var3 = Math.toRadians(Mth.wrapDegrees(var1));
      return Math.toDegrees(Mth.wrapDegrees(var2 - var3));
   }

   public static double method05712() {
      return mc.player == null ? 0.0 : Math.hypot(mc.player.getDeltaMovement().x, mc.player.getDeltaMovement().z);
   }

   private static double method05713(double var0, double var2) {
      double var4 = Math.abs(var0 - var2) % field12097;
      return Math.min(var4, field12098 - var4);
   }

   public static Double method05714() {
      return mc.player == null ? 0.0 : method05729(mc.player);
   }

   public static float method05715() {
      return mc.player == null
         ? 0.0F
         : (float)Math.sqrt(mc.player.getDeltaMovement().x * mc.player.getDeltaMovement().x + mc.player.getDeltaMovement().z * mc.player.getDeltaMovement().z);
   }

   public static double method05716() {
      if (mc.player == null) {
         return 0.0;
      }

      double var0 = mc.player.getX() - mc.player.xo;
      double var2 = mc.player.getZ() - mc.player.zo;
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   public static float method05717() {
      if (mc.player == null) {
         return field12071;
      }

      boolean var0 = mc.options.keyRight.isDown();
      boolean var1 = mc.options.keyLeft.isDown();
      boolean var2 = mc.options.keyUp.isDown();
      boolean var3 = mc.options.keyDown.isDown();
      float var4 = mc.player.getYRot();
      if (!var0 && !var3 && !var1 && !var2) {
         return field12072;
      }

      if (var3) {
         var4 -= field12073;
      }

      boolean var5 = (var3 || var2) && (!var3 || !var2);
      if (!var5) {
         if (var1) {
            var4 -= field12074;
         }

         if (var0) {
            var4 += field12075;
         }
      } else if (var4 == mc.player.getYRot()) {
         if (var1) {
            var4 -= field12076;
         }

         if (var0) {
            var4 += field12077;
         }
      } else {
         if (var1) {
            var4 += field12078;
         }

         if (var0) {
            var4 -= field12079;
         }
      }

      return Mth.wrapDegrees(var4);
   }

   public static Vec3 method05718(Entity var0) {
      double var1 = var0.getX() - var0.xo;
      double var3 = var0.getY() - var0.yo;
      double var5 = var0.getZ() - var0.zo;
      return new Vec3(var1, var3, var5);
   }

   public static void method05719(PlayerMovementEvent var0, float var1, double var2, double var4) {
      double var6 = Math.toDegrees(Math.atan2(var4, var2)) - field12099;
      var6 = Mth.wrapDegrees(var6);
      if (mc.options.keyUp.isDown()) {
         float var8 = var0.method11161();
         float var9 = var0.method11166();
         if (var8 != 0.0F || var9 != 0.0F) {
            float var10 = 0.0F;
            float var11 = 0.0F;
            float var12 = field12100;

            for (float var13 = field12101; var13 <= 1.0F; var13++) {
               for (float var14 = field12102; var14 <= 1.0F; var14++) {
                  if (var14 != 0.0F || var13 != 0.0F) {
                     double var15 = Math.toDegrees(method05725(var1, var13, var14));
                     var15 = Mth.wrapDegrees(var15);
                     double var17 = Math.abs(method05713(var6, var15));
                     if (var17 < var12) {
                        var12 = (float)var17;
                        var10 = var13;
                        var11 = var14;
                     }
                  }
               }
            }

            var0.method11167(var10);
            var0.method11158(var11);
         }
      }
   }

   public static void method05720(EntityMoveEvent var0, double var1, double var3) {
      if (mc.player != null) {
         double var5 = mc.player.zza;
         double var7 = mc.player.xxa;
         float var9 = mc.player.getYRot();
         method05731(var0, var1, var1, var9, var7, var5);
      }
   }

   private MovementUtils() {
      throw new UnsupportedOperationException(field12103);
   }

   public static boolean method05721(Entity var0) {
      Vec3 var1 = var0.getDeltaMovement();
      if (var1.y >= 0.0) {
         return false;
      }

      AABB var2 = var0.getBoundingBox().move(var1.x, var1.y, var1.z).expandTowards(0.0, field12080, 0.0);
      return !var0.level().noCollision(var0, var2);
   }

   public static void method05722() {
      if (mc.player != null && mc.player.connection != null) {
         mc.player.connection.send(new ServerboundPlayerCommandPacket(mc.player, Action.START_FALL_FLYING));
      }
   }

   public static double method05723(boolean var0, boolean var1, double var2) {
      return method05724(var0, var1, var2, var2);
   }

   public static double method05724(boolean var0, boolean var1, double var2, double var4) {
      if (var0) {
         return var2;
      } else {
         return var1 ? -var4 : 0.0;
      }
   }

   public static double method05725(float var0, float var1, float var2) {
      if (var1 < 0.0F) {
         var0 += field12092;
      }

      float var3 = 1.0F;
      if (var1 < 0.0F) {
         var3 = field12093;
      }

      if (var1 > 0.0F) {
         var3 = field12094;
      }

      if (var2 > 0.0F) {
         var0 -= field12095 * var3;
      }

      if (var2 < 0.0F) {
         var0 += field12096 * var3;
      }

      return Math.toRadians(var0);
   }

   public static boolean method05726() {
      if (mc.player != null && mc.level != null) {
         BlockPos var0 = BlockPos.containing(mc.player.getX(), Math.floor(mc.player.getY() - field12068), mc.player.getZ());
         BlockState var1 = mc.level.getBlockState(var0);
         return !var1.isAir() && !(var1.getBlock() instanceof FlowerBlock);
      } else {
         return false;
      }
   }

   public static void method05727(double var0, double var2) {
      if (mc.player != null) {
         Vec3 var4 = mc.player.getDeltaMovement();
         mc.player.setDeltaMovement(var4.x + var0, var4.y, var4.z + var2);
      }
   }

   public static void method05728(EntityMoveEvent var0, double var1) {
      if (mc.player != null) {
         double var3 = mc.player.zza;
         double var5 = mc.player.xxa;
         float var7 = mc.player.getYRot();
         method05731(var0, var1, var1, var7, var5, var3);
      }
   }

   public static Double method05729(Entity var0) {
      double var1 = var0.getX() - var0.xo;
      double var3 = var0.getY() - var0.yo;
      double var5 = var0.getZ() - var0.zo;
      return Math.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * field12087;
   }

   public static boolean method05730() {
      if (mc.player == null) {
         return false;
      }

      Vec2 var0 = mc.player.input.getMoveVector();
      return var0.x != 0.0F && var0.y != 0.0F;
   }

   public static void method05731(EntityMoveEvent var0, double var1, double var3, float var5, double var6, double var8) {
      if (var8 != 0.0) {
         if (var6 > 0.0) {
            var5 += var8 > 0.0 ? -45 : 45;
         }

         if (var6 < 0.0) {
            var5 += var8 > 0.0 ? 45 : -45;
         }

         var6 = 0.0;
         if (var8 > 0.0) {
            var8 = 1.0;
         }

         if (var8 < 0.0) {
            var8 = field12088;
         }
      }

      if (var6 > 0.0) {
         var6 = 1.0;
      }

      if (var6 < 0.0) {
         var6 = field12089;
      }

      double var10 = Math.cos(Math.toRadians(var5 + field12090));
      double var12 = Math.sin(Math.toRadians(var5 + field12091));
      var0.method10060(new Vec3(var8 * var1 * var10 + var6 * var1 * var12, var0.method10059().y, var8 * var3 * var12 - var6 * var1 * var10));
   }

   public static double[] method05732() {
      if (mc.player == null) {
         return new double[]{0.0, 0.0};
      }

      Vec2 var0 = mc.player.input.getMoveVector();
      double var1 = Math.hypot(var0.x, var0.y);
      if (var1 < field12070) {
         return new double[]{0.0, 0.0};
      }

      double var3 = Math.toRadians(mc.player.getYRot());
      double var5 = Math.sin(var3);
      double var7 = Math.cos(var3);
      double var9 = var0.x / var1;
      double var11 = var0.y / var1;
      return new double[]{var9 * var7 - var11 * var5, var11 * var7 + var9 * var5};
   }

   public static boolean method05733() {
      if (mc.player == null) {
         return false;
      }

      Vec2 var0 = mc.player.input.getMoveVector();
      return var0.x != 0.0F || var0.y != 0.0F;
   }
}
