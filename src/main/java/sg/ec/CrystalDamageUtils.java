// Original binary: sg/ec/c5uzVzEoqoigGjYe
package sg.ec;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class CrystalDamageUtils implements MinecraftAccess {
   private static final double field17646 = 0.4F;
   private static final double field17647 = 0;
   private static final double field17648 = 0;
   private static final float field17649 = 0;
   private static final float field17650 = 0;
   private static final float field17651 = 0;
   private static final EquipmentSlot[] field17652 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   private static final float field17653 = 0.5F;
   private static final float field17654 = 0.9F;
   private static final float field17655 = 0.5F;
   private static final double field17656 = 180.0F / (float)Math.PI;
   private static final float field17657 = 90.0F;
   private static final double field17658 = 0.4F;
   private static final float field17659 = (float) (Math.PI / 180.0);
   private static final float field17660 = (float) (Math.PI / 180.0);
   private static final double field17661 = 1.0E-5F;
   private static final double field17662 = 2.0;
   private static final double field17663 = 0.4;
   private static final double field17664 = 2.0;
   private static final double field17665 = 2.0;

   public static float method07233(Vec3 var0, LivingEntity var1) {
      return (float)(Mth.atan2(var1.getZ() - var0.z, var1.getX() - var0.x) * field17656) - field17657;
   }

   public static Vec3 method07234(LivingEntity var0, Vec3 var1, boolean var2, Vec3 var3, float var4, float var5) {
      double var6 = method07235(var0);
      Vec3 var8 = method07237(var1, field17658, var3.x - var0.getX(), var3.z - var0.getZ(), var2, var6);
      if (var5 > 0.0F) {
         double var9 = Mth.sin(var4 * field17659);
         double var11 = -Mth.cos(var4 * field17660);
         var8 = method07237(var8, var5, var9, var11, var2, var6);
      }

      return var8;
   }

   private static double method07235(LivingEntity var0) {
      double[] var1 = new double[]{0.0};

      for (EquipmentSlot var5 : field17652) {
         var0.getItemBySlot(var5).forEachModifier(var5, (var1x, var2) -> {
            if (var1x.equals(Attributes.KNOCKBACK_RESISTANCE) && var2.operation() == Operation.ADD_VALUE) {
               var1[0] += var2.amount();
            }
         });
      }

      return Mth.clamp(Math.max(var0.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE), var1[0]), 0.0, 1.0);
   }

   private CrystalDamageUtils() {
   }

   public static Vec3 method07237(Vec3 var0, double var1, double var3, double var5, boolean var7, double var8) {
      double var10 = var1 * (1.0 - var8);
      if (!(var10 <= 0.0) && !(var3 * var3 + var5 * var5 < field17661)) {
         Vec3 var12 = new Vec3(var3, 0.0, var5).normalize().scale(var10);
         return new Vec3(var0.x / field17662 - var12.x, var7 ? Math.min(field17663, var0.y / field17664 + var10) : var0.y, var0.z / field17665 - var12.z);
      } else {
         return var0;
      }
   }

   public static float method07238() {
      return method07239(mc.player.isSprinting() && mc.player.getAttackStrengthScale(field17653) > field17654);
   }

   public static float method07239(boolean var0) {
      float var1 = (float)mc.player.getAttributeValue(Attributes.ATTACK_KNOCKBACK);
      var1 += EnchantmentUtils.method06757(mc.player.getMainHandItem(), Enchantments.KNOCKBACK);
      return var1 / 2.0F + (var0 ? field17655 : 0.0F);
   }
}
