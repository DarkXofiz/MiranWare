// Original binary: sg/ec/AgglBH7kxqNBdFO6
package sg.ec;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;

// $VF: Compiled from s
public final class ItemUtils implements MinecraftAccess {
   private static final EquipmentSlot[] field06137 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private static final double field06138 = 0.25;
   private static final double field06139 = 20.0;
   private static final double field06140 = 20.0;
   private static final String field06141 = "This is a utility class and cannot be instantiated";

   public static boolean method02579(LivingEntity var0) {
      return var0 instanceof Player var1 && var1.getItemBySlot(EquipmentSlot.CHEST).getItem() == Items.ELYTRA;
   }

   public static double method02580(Player var0) {
      double var1 = 0.0;

      for (EquipmentSlot var6 : field06137) {
         ItemStack var7 = var0.getItemBySlot(var6);
         if (!var7.isEmpty() && var7.isEnchanted()) {
            var1 += EnchantmentUtils.method06757(var7, Enchantments.PROTECTION) * field06138;
         }
      }

      return var1;
   }

   public static double method02581(LivingEntity var0) {
      float var1 = PlayerUtils.method11820(var0) + var0.getAbsorptionAmount();
      return var0 instanceof Player var2 ? var1 * (method02580(var2) / field06140) : var1;
   }

   public static double method02582(LivingEntity var0) {
      return method02581(var0) / var0.getMaxHealth();
   }

   public static double method02583(LivingEntity var0) {
      return Math.abs(MovementUtils.method05711(var0.position().subtract(mc.player.position()), mc.player.getYRot()));
   }

   public static double method02584(LivingEntity var0) {
      return (var0 instanceof Player var1 ? method02580(var1) : var0.getArmorValue()) / field06139;
   }

   private ItemUtils() {
      throw new UnsupportedOperationException(field06141);
   }
}
