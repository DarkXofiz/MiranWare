// Original binary: sg/ec/Ufoa0vWRgEvSYiRY
package sg.ec;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.equipment.Equippable;

// $VF: Compiled from s
public final class ArmorScoreUtils implements MinecraftAccess {
   public static final EquipmentSlot[] field12667 = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};
   public static final double field12668 = 1.0E-4;
   private static final double field12669 = 0;
   private static final double field12670 = 0;
   private static final double field12671 = 0;
   private static final double field12672 = 0;
   private static final Object2IntOpenHashMap<Holder<Enchantment>> field12673 = new Object2IntOpenHashMap();
   private static final double field12674 = 1.0E-4;
   private static final double field12675 = 1.0E-4;
   private static final double field12676 = 0.5;
   private static final double field12677 = 0.25;
   private static final double field12678 = 0.05;
   private static final double field12679 = 1.0E-4;
   private static final String field12680 = "This is a utility class and cannot be instantiated";

   public static boolean method05910(ItemStack var0, ItemStack var1, double var2, double var4) {
      if (var2 > var4 + field12674) {
         return true;
      } else {
         return var2 + field12675 < var4 ? false : method05918(var0) > method05918(var1);
      }
   }

   public static double method05911(ItemStack var0, EquipmentSlot var1) {
      if (var0.isEmpty()) {
         return 0.0;
      }

      ItemAttributeModifiers var2 = var0.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);
      double var3 = var2.compute(Attributes.ARMOR, 0.0, var1) + var2.compute(Attributes.ARMOR_TOUGHNESS, 0.0, var1) * field12676;
      if (var3 <= 0.0) {
         return 0.0;
      }

      EnchantmentUtils.method06759(var0, field12673);
      ObjectIterator var5 = field12673.object2IntEntrySet().iterator();

      while (var5.hasNext()) {
         Entry var6 = (Entry)var5.next();
         Holder var7 = (Holder)var6.getKey();
         if (var7.is(Enchantments.PROTECTION)) {
            var3 += var6.getIntValue() * 1.0;
         } else if (var7.is(Enchantments.PROJECTILE_PROTECTION) || var7.is(Enchantments.BLAST_PROTECTION) || var7.is(Enchantments.FIRE_PROTECTION)) {
            var3 += var6.getIntValue() * field12677;
         } else if (var7.is(Enchantments.UNBREAKING)) {
            var3 += var6.getIntValue() * field12678;
         }
      }

      return var3;
   }

   public static boolean method05912() {
      for (int var0 = 9; var0 < 45; var0++) {
         if (mc.player.containerMenu.getSlot(var0).getItem().isEmpty()) {
            return true;
         }
      }

      return false;
   }

   private ArmorScoreUtils() {
      throw new UnsupportedOperationException(field12680);
   }

   public static boolean method05916(ItemStack var0, EquipmentSlot var1) {
      if (var0.isEmpty()) {
         return false;
      }

      Equippable var2 = var0.get(DataComponents.EQUIPPABLE);
      return var2 != null && var2.slot() == var1;
   }

   public static boolean method05917(int var0) {
      if (!method05912()) {
         return false;
      }

      int var1 = mc.player.containerMenu.containerId;
      InventoryActionManager.INSTANCE.method10469(() -> InventoryUtils.method06127(var1, var0, 0, ContainerInput.QUICK_MOVE, false));
      return true;
   }

   public static float method05918(ItemStack var0) {
      if (var0.isEmpty()) {
         return 0.0F;
      }

      int var1 = var0.getMaxDamage();
      return var1 <= 0 ? 1.0F : (float)(var1 - var0.getDamageValue()) / var1;
   }

   public static boolean method05919(int var0, int var1, boolean var2) {
      int var3 = mc.player.containerMenu.containerId;
      if (!var2) {
         InventoryActionManager.INSTANCE.method10469(() -> InventoryUtils.method06127(var3, var1, 0, ContainerInput.QUICK_MOVE, false));
         return true;
      }

      if (var1 >= 36) {
         int var5 = var1 - 36;
         InventoryActionManager.INSTANCE.method10469(() -> InventoryUtils.method06127(var3, var0, var5, ContainerInput.SWAP, false));
         return true;
      }

      int var4 = InventoryUtils.method06094(-1);
      if (var4 != -1) {
         InventoryActionManager.INSTANCE.method10469(() -> {
            InventoryUtils.method06127(var3, var1, var4, ContainerInput.SWAP, false);
            InventoryUtils.method06127(var3, var0, var4, ContainerInput.SWAP, false);
            InventoryUtils.method06127(var3, var1, var4, ContainerInput.SWAP, false);
         });
         return true;
      }

      if (!method05912()) {
         return false;
      }

      InventoryActionManager.INSTANCE.method10469(() -> {
         InventoryUtils.method06127(var3, var0, 0, ContainerInput.QUICK_MOVE, false);
         InventoryUtils.method06127(var3, var1, 0, ContainerInput.QUICK_MOVE, false);
      });
      return true;
   }

   public static int method05920(EquipmentSlot var0) {
      if (mc.player == null) {
         return -1;
      }

      ItemStack var1 = mc.player.getItemBySlot(var0);
      ItemStack var2 = var1;
      double var3 = method05911(var1, var0);
      int var5 = -1;

      for (int var6 = 9; var6 < 45; var6++) {
         ItemStack var7 = mc.player.containerMenu.getSlot(var6).getItem();
         if (method05916(var7, var0)) {
            double var8 = method05911(var7, var0);
            if (!(var8 <= field12679) && method05910(var7, var2, var8, var3)) {
               var2 = var7;
               var3 = var8;
               var5 = var6;
            }
         }
      }

      return var5;
   }

   public static int method05921(EquipmentSlot var0) {
      return 8 - var0.getIndex();
   }
}
