// Original binary: sg/ec/08AN0a0zTRzGb4pv
package sg.ec;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public final class AttackCooldownUtils {
   private static final float field00069 = 50.0F;
   private static int field00070 = -1;
   private static long field00071 = AttackCooldownUtils.field00074;
   private static final float field00072 = 50.0F;
   private static final float field00073 = 50.0F;
   private static final long field00074 = -1L;

   private AttackCooldownUtils() {
   }

   public static int method00006(Player var0) {
      if (var0 == null) {
         return 0;
      }

      float var1 = var0.getCurrentItemAttackStrengthDelay();
      return Float.isFinite(var1) && !(var1 <= 0.0F) ? Math.max(0, Mth.ceil(var1 - method00009(var0))) : 0;
   }

   public static int method00007(Player var0, float var1, float var2) {
      if (var0 == null) {
         return 0;
      }

      float var3 = var0.getCurrentItemAttackStrengthDelay();
      return Float.isFinite(var3) && !(var3 <= 0.0F) ? Math.max(0, Mth.ceil(var2 * var3 - var1) - ((LivingEntityMixin_1248)(Object)var0).getAttackStrengthTicker()) : 0;
   }

   public static float method00008(Player var0, float var1) {
      if (var0 == null) {
         return 0.0F;
      } else {
         float var2 = var0.getCurrentItemAttackStrengthDelay();
         if (Float.isFinite(var2) && !(var2 <= 0.0F)) {
            float var3 = (method00009(var0) + var1) / var2;
            return Mth.clamp(var3, 0.0F, 1.0F);
         } else {
            return var0.getAttackStrengthScale(var1);
         }
      }
   }

   private static float method00009(Player var0) {
      int var1 = ((LivingEntityMixin_1248)(Object)var0).getAttackStrengthTicker();
      long var2 = System.currentTimeMillis();
      if (field00071 < 0L || var1 < field00070) {
         field00071 = var2 - (long)(var1 * field00072);
      }

      field00070 = var1;
      return Mth.clamp((float)(var2 - field00071) / field00073, var1, var1 + 1.0F);
   }

   public static int method00010(Player var0, float var1, float var2) {
      if (var0 == null) {
         return 0;
      }

      float var3 = var0.getCurrentItemAttackStrengthDelay();
      return Float.isFinite(var3) && !(var3 <= 0.0F) ? Math.max(1, Mth.floor(var2 * var3 - var1) + 1) : 0;
   }

   public static boolean method00011(Player var0, float var1) {
      if (var0 == null) {
         return false;
      }

      float var2 = var0.getCurrentItemAttackStrengthDelay();
      return Float.isFinite(var2) && !(var2 <= 0.0F) ? ((LivingEntityMixin_1248)(Object)var0).getAttackStrengthTicker() >= Mth.ceil(var2 - var1) : true;
   }
}
