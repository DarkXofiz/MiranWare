// Original binary: sg/ec/2QedknKLbgz4uS61
package sg.ec;

import java.util.List;
import java.util.Locale;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class MovementInputFormatter {
   private static final float field01029 = 5.0F;
   private static final float field01030 = 0;
   private static final int field01031 = 0;
   private static final double field01032 = 0;
   private static final float field01033 = 0.2F;
   private static final float field01034 = 5.0F;
   private static final String field01035 = "AIR";
   private static final String field01036 = "%s pos=%.2f/%.2f/%.2f vel=%.3f/%.3f/%.3f ввод=%s%s%s%s%s%s спринт=%b гориз=%b xxa=%.2f zza=%.2f";
   private static final String field01037 = "приземление";
   private static final String field01038 = "в воздухе";
   private static final String field01039 = "F";
   private static final String field01040 = "-";
   private static final String field01041 = "B";
   private static final String field01042 = "-";
   private static final String field01043 = "L";
   private static final String field01044 = "-";
   private static final String field01045 = "R";
   private static final String field01046 = "-";
   private static final String field01047 = "J";
   private static final String field01048 = "-";
   private static final String field01049 = "S";
   private static final String field01050 = "-";

   private static void method00501(BotClient var0, BotLocalPlayer var1, Input var2) {
      BotPlayerState var3 = var0.method00070();
      boolean sx = var1.onGround();
      if (!sx || var3.method08025()) {
         var3.method07984(!sx);
         Vec3 sxx = var1.getDeltaMovement();
         String.format(
            Locale.ROOT,
            field01036,
            sx ? field01037 : field01038,
            var1.getX(),
            var1.getY(),
            var1.getZ(),
            sxx.x,
            sxx.y,
            sxx.z,
            var2.forward() ? field01039 : field01040,
            var2.backward() ? field01041 : field01042,
            var2.left() ? field01043 : field01044,
            var2.right() ? field01045 : field01046,
            var2.jump() ? field01047 : field01048,
            var2.sprint() ? field01049 : field01050,
            var1.isSprinting(),
            var1.horizontalCollision,
            var1.xxa,
            var1.zza
         );
      }
   }

   public static void method00502(BotClient var0) {
      BotWorldState var1 = var0.method00090();
      BotLocalPlayer var2 = var1.method07688();
      BotPlayerState var3 = var0.method00070();
      if (var2 != null && var3.method08011()) {
         BotPlayerSynchronizer.method07170(var1, var3, var2);
      }
   }

   private MovementInputFormatter() {
   }

   public static boolean method00503(BotClient var0) {
      BotWorldState var1 = var0.method00090();
      BotPlayerState var2 = var0.method00070();
      BotClientLevel var3 = var1.method07636();
      BotLocalPlayer var4 = var1.method07688();
      if (var3 == null) {
         return false;
      }

      if (var4 == null) {
         return false;
      }

      if (!var2.method07988()) {
         return false;
      }

      if (!method00504(var3, var2)) {
         return false;
      }

      if (var2.method07981() < var3.getMinY() - 64) {
         return false;
      }

      var var5 = var2.method07944(var4);
      boolean var6 = var2.method08011();
      boolean var7 = !var4.isSynced() || var2.method07971();
      Input var8 = var2.method07958().method05145(var4, var0.method00089().method10873());
      if (var5 != null) {
         var4.applyMetadata(var5);
      }

      var4.setGameType(var2.method07950());
      if (var6) {
         BotPlayerSynchronizer.method07170(var1, var2, var4);
      }

      if (var7) {
         var4.syncFrom(var2);
         var2.method07996();
      } else if (var2.method07996()) {
         var4.aimFrom(var2);
      }

      var4.setInput(var8);
      if (var2.method08021()) {
         var4.setXRot(Mth.lerp(field01033, var4.getXRot(), field01034));
      }

      method00506(var3, var4);
      if (var4.isPassenger()) {
         var4.ridingTick();
      } else {
         var4.physicsTick();
      }

      Vec3 var9 = var4.getDeltaMovement();
      var2.method07977(var4.getX(), var4.getY(), var4.getZ(), var9.x, var9.y, var9.z, var4.onGround(), var4.horizontalCollision);
      var2.method08016(var4.getYRot(), var4.getXRot());
      method00501(var0, var4, var8);
      return true;
   }

   private static boolean method00504(BotClientLevel var0, BotPlayerState var1) {
      int var2 = method00505(var1.method08006() - 1.0);
      int var3 = method00505(var1.method08006() + 1.0);
      int var4 = method00505(var1.method08004() - 1.0);
      int var5 = method00505(var1.method08004() + 1.0);
      return var0.isChunkLoaded(var2, var4) && var0.isChunkLoaded(var2, var5) && var0.isChunkLoaded(var3, var4) && var0.isChunkLoaded(var3, var5);
   }

   private static int method00505(double var0) {
      int var2 = (int)var0;
      return var0 < var2 ? var2 - 1 : var2;
   }

   private static void method00506(BotClientLevel var0, BotLocalPlayer var1) {
      Entity var2 = var1.getVehicle();
      if (var2 != null) {
         if (var2.isRemoved() || !var0.entityStore().method07249(var2)) {
            var1.stopRiding();
         }
      }
   }

   public static boolean method00507(BotClient var0) {
      BotWorldState var1 = var0.method00090();
      BotClientLevel var2 = var1.method07636();
      return var2 != null && var1.method07688() != null && var0.method00070().method07988() && method00504(var2, var0.method00070());
   }
}
