// Original binary: sg/ec/XIf8Gt7BD1iNBkUH
package sg.ec;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.pathing.calc.IPath;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.pathing.movement.movements.MovementAscend;
import hex.api.baritone.pathing.path.PathExecutor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

// $VF: Compiled from s
public final class BotPathingUtils {
   private static final double field13899 = 0.05;
   private static final int field13900 = 0;
   private static final double field13901 = 0;
   private static final double field13902 = 0;
   private static final double field13903 = 0;
   private static final double field13904 = 0;
   private static final double field13905 = 0;
   private static final double field13906 = 0;
   private static final double field13907 = 0.05;
   private static final double field13908 = 0.5;
   private static final double field13909 = 0.5;
   private static final double field13910 = 0.5;
   private static final double field13911 = 0.3;
   private static final double field13912 = 0.2;
   private static final double field13913 = 2.74;
   private static final double field13914 = 0.15;
   private static final double field13915 = 0.4;

   private BotPathingUtils() {
   }

   private static boolean method06241(Level var0, BlockPos var1) {
      return var0.getBlockState(var1).getCollisionShape(var0, var1).isEmpty();
   }

   private static boolean method06242(MovementAscend var0, Player var1) {
      BetterBlockPos var2 = var0.getSrc();
      BetterBlockPos var3 = var0.getDest();
      BlockPos var4 = var1.blockPosition();
      if (var4.getY() != var2.getY()) {
         return false;
      }

      BlockPos var5 = var0.getDirection();
      double var6 = var5.getX() * var1.getDeltaMovement().x + var5.getZ() * var1.getDeltaMovement().z;
      if (var6 < field13907) {
         return false;
      }

      double var8 = Math.abs(var5.getX()) * Math.abs(var3.getX() + field13908 - var1.getX())
         + Math.abs(var5.getZ()) * Math.abs(var3.getZ() + field13909 - var1.getZ());
      double var10 = var8 - field13910 - field13911;
      double var12 = var1.isSprinting() ? field13912 : 0.0;
      double var14 = (var6 + var12) * field13913 - field13914;
      if (var10 > Math.max(field13915, var14)) {
         return false;
      }

      Level var16 = var1.level();
      return method06241(var16, var4.above(2)) && method06241(var16, var2.above(2)) && method06241(var16, var3.above(2));
   }

   public static boolean method06243(IBaritone var0, Player var1) {
      if (var1 != null && var1.onGround()) {
         if (!(var0.getPathingBehavior() instanceof PathingBehavior var2)) {
            return false;
         } else {
            PathExecutor var10 = var2.getCurrent();
            if (var10 == null) {
               return false;
            }

            IPath var4 = var10.getPath();
            int var5 = var10.getPosition();
            int var6 = var4.movements().size();

            for (int var7 = var5; var7 <= var5 + 1 && var7 < var6; var7++) {
               if (var4.movements().get(var7) instanceof MovementAscend var8 && method06242(var8, var1)) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return false;
      }
   }
}
