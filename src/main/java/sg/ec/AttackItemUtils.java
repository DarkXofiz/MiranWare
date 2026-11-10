// Original binary: sg/ec/RnPpb5LJwmPjzhRi
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class AttackItemUtils implements MinecraftAccess {
   public static final double field11655 = 3.0;
   private static final int field11656 = 0;
   private static int field11657 = AttackItemUtils.field11662;
   private static boolean field11658;
   private static final double field11659 = 3.0;
   private static final double field11660 = 3.0;
   private static final String field11661 = "This is a utility class and cannot be instantiated";
   private static final int field11662 = Integer.MIN_VALUE;

   public static int method05342() {
      return InventoryUtils.method06111(Items.MACE, true);
   }

   public static boolean method05343() {
      return mc.player != null && mc.player.getMainHandItem().is(Items.MACE);
   }

   private AttackItemUtils() {
      throw new UnsupportedOperationException(field11661);
   }

   public static Slot method05344() {
      return InventoryUtils.method06136(Items.MACE);
   }

   public static boolean method05345() {
      int var0 = TickEvent.method03209();
      if (field11657 == var0) {
         return field11658;
      }

      field11657 = var0;
      field11658 = method05347();
      return field11658;
   }

   public static boolean method05346(LivingEntity var0) {
      return var0 == null ? false : !var0.onGround() && !var0.isFallFlying() && var0.fallDistance > field11659;
   }

   private static boolean method05347() {
      if (mc.player == null || mc.player.input == null) {
         return false;
      }

      if (mc.player.isFallFlying()) {
         return false;
      }

      if (method05346(mc.player)) {
         return true;
      }

      SimulatedPlayerInput var0 = SimulatedPlayerInput.method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(mc.player.input.keyPresses));

      for (int var1 = 0; var1 < 20; var1++) {
         var0.method08897();
         if (var0.field20229 || var0.field20232) {
            return false;
         }

         if (var0.field20225 > field11660) {
            return true;
         }
      }

      return false;
   }
}
