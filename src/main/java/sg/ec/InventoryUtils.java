// Original binary: sg/ec/X2w5RMP7LOnrCwA4
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemLore;

// $VF: Compiled from s
public final class InventoryUtils implements MinecraftAccess {
   static int field13856 = -1;
   private static int field13857 = -1;
   static int field13858 = -1;
   public static boolean field13859 = false;
   private static final float field13860 = Float.MAX_VALUE;
   private static final float field13861 = Float.MAX_VALUE;
   private static final float field13862 = Float.MAX_VALUE;
   private static final float field13863 = Float.MAX_VALUE;
   private static final float field13864 = 9999.0F;
   private static final int field13865 = 99999;
   private static final float field13866 = Float.MAX_VALUE;
   private static final float field13867 = Float.MAX_VALUE;
   private static final float field13868 = 9999.0F;
   private static final int field13869 = 99999;
   private static final float field13870 = Float.MAX_VALUE;
   private static final float field13871 = Float.MAX_VALUE;
   private static final String field13872 = "This is a utility class and cannot be instantiated";

   public static void method06080(ItemStack var0, InteractionHand var1, float var2, float var3) {
      if (mc.player != null) {
         if (!mc.player.getCooldowns().isOnCooldown(var0)) {
            Slot var4 = method06136(var0.getItem());
            if (var4 != null) {
               method06122(var4, var1, var2, var3);
            }
         }
      }
   }

   public static Slot method06081(Item var0) {
      return method06096(var1 -> var1.getItem().equals(var0), true);
   }

   private static int method06083(Slot var0) {
      if (var0 != null && mc.player != null) {
         if (var0.container != mc.player.getInventory()) {
            return -1;
         }

         int var1 = var0.getContainerSlot();
         return var1 >= 0 && var1 < 9 ? var1 : -1;
      } else {
         return -1;
      }
   }

   public static void method06084(Slot var0, int var1, ContainerInput var2, boolean var3) {
      if (var0 != null) {
         method06123(var0.index, var1, var2, var3);
      }
   }

   public static void method06085(int var0, InteractionHand var1, boolean var2) {
      if (var0 != -1) {
         int var3 = var1.equals(InteractionHand.MAIN_HAND) ? mc.player.getInventory().getSelectedSlot() : 40;
         if (var2) {
            TickTaskScheduler.method03510(() -> method06123(var0, var3, ContainerInput.SWAP, false), 1);
         } else {
            method06123(var0, var3, ContainerInput.SWAP, false);
         }
      }
   }

   public static boolean method06086(Item var0) {
      if (mc.player == null) {
         return false;
      }

      ItemStack var1 = method06103(var0);
      return !var1.isEmpty() && mc.player.getCooldowns().isOnCooldown(var1);
   }

   public static boolean method06087(ItemStack var0) {
      Item var1 = var0.getItem();
      return var1 == Items.NETHERITE_SWORD || var1 == Items.DIAMOND_SWORD || var1 == Items.IRON_SWORD;
   }

   public static List<Slot> method06088() {
      if (mc.player == null) {
         return null;
      }

      int var0 = mc.player.containerMenu.slots.size() - 37;
      return var0 < mc.player.containerMenu.slots.size() ? mc.player.containerMenu.slots : null;
   }

   public static boolean method06089(ItemStack var0) {
      Item var1 = var0.getItem();
      return !method06087(var0) && !new ItemStack(var1).is(net.minecraft.tags.ItemTags.AXES) && var1 != Items.MACE
         ? var1 == Items.ELYTRA || var1 == Items.TOTEM_OF_UNDYING || var1 == Items.END_CRYSTAL || var1 == Items.OBSIDIAN || var1 == Items.CRYING_OBSIDIAN
         : true;
   }

   public static boolean method06091(int var0) {
      if (mc.player == null) {
         return false;
      }

      if (var0 < 0 || var0 > 8) {
         return false;
      }

      if (field13857 == var0) {
         return false;
      }

      mc.player.connection.send(new ServerboundSetCarriedItemPacket(var0));
      field13857 = var0;
      return true;
   }

   public static boolean method06092(int var0, int var1, ContainerInput var2) {
      return switch (var2) {
         case PICKUP, QUICK_MOVE, CLONE -> var1 >= 0 && var1 <= 2;
         case SWAP -> var0 >= 0 && (var1 >= 0 && var1 < 9 || var1 == 40);
         case THROW -> var1 == 0 || var1 == 1;
         case QUICK_CRAFT -> var1 >= 0 && var1 <= 10 && var1 != 3 && var1 != 7;
         case PICKUP_ALL -> var1 == 0;
      };
   }

   public static void method06093(Slot var0, InteractionHand var1, boolean var2) {
      if (var0 != null) {
         method06085(var0.index, var1, var2);
      }
   }

   public static int method06094(int var0) {
      if (mc.player == null) {
         return -1;
      }

      NonNullList<ItemStack> var1 = mc.player.getInventory().getNonEquipmentItems();

      for (int var2 = 0; var2 < 9; var2++) {
         if (var2 != var0 && ((ItemStack)var1.get(var2)).isEmpty() && mc.player.getInventory().getSelectedSlot() != var2) {
            return var2;
         }
      }

      return -1;
   }

   private static Slot method06096(Predicate<ItemStack> var0, boolean var1) {
      NonNullList<Slot> var2 = mc.player.containerMenu.slots;
      int var3 = var2.size() - 37;
      return var2.stream().filter(var3x -> var0.test(var3x.getItem()) && (!var1 || var3x.index >= var3)).findFirst().orElse(null);
   }

   public static void method06097(ItemStack var0, float var1, float var2) {
      if (mc.player != null) {
         if (!mc.player.getCooldowns().isOnCooldown(var0)) {
            Slot var3 = method06136(var0.getItem());
            if (var3 != null) {
               method06122(var3, InteractionHand.MAIN_HAND, var1, var2);
            }
         }
      }
   }

   public static int method06098(boolean var0) {
      if (mc.player == null) {
         return -1;
      }

      int var1 = var0 ? 0 : 9;
      int var2 = var0 ? 9 : 36;
      NonNullList<ItemStack> var3 = mc.player.getInventory().getNonEquipmentItems();

      for (int var4 = var1; var4 < var2; var4++) {
         if (((ItemStack)var3.get(var4)).is(net.minecraft.tags.ItemTags.AXES)) {
            return var4;
         }
      }

      return -1;
   }

   public static int method06099(Item var0) {
      return mc.player.containerMenu.slots.stream().filter(var1 -> var1.getItem().getItem().equals(var0)).mapToInt(var0x -> var0x.getItem().getCount()).sum();
   }

   private InventoryUtils() {
      throw new UnsupportedOperationException(field13872);
   }

   public static Slot method06102(List<Item> var0) {
      return method06096(var1 -> var0.contains(var1.getItem()), false);
   }

   public static ItemStack method06103(Item var0) {
      Slot var1 = method06136(var0);
      return var1 == null ? ItemStack.EMPTY : var1.getItem();
   }

   public static void method06105(Item var0) {
      if (mc.player != null) {
         if (!AutoTotem.method08643()) {
            boolean var1 = !mc.player.getOffhandItem().isEmpty();
            Slot var2 = method06136(var0);
            if (var2 != null) {
               int var3 = var2.index;
               if (var3 >= 0) {
                  method06137(mc.player.containerMenu.containerId, var3, 40, ContainerInput.SWAP, mc.player);
                  method06142(InteractionHand.OFF_HAND, field13860, field13861, false);
                  if (var1 && field13856 == -1) {
                     field13856 = var3;
                  }
               }

               if (mc.player.getOffhandItem().getItem() == var0) {
                  if (field13856 == -1) {
                     return;
                  }

                  method06137(mc.player.containerMenu.containerId, field13856, 40, ContainerInput.SWAP, mc.player);
                  field13856 = -1;
               }
            }
         }
      }
   }

   public static long method06107() {
      return method06124().stream().filter(var0 -> var0.getItem().isEmpty()).count();
   }

   public static InventoryActionSequence method06108(int var0, int var1) {
      return var0 != var1 && var0 != -1 ? InventoryActionManager.INSTANCE.method10469(() -> method06116(var0, var1)) : null;
   }

   public static Slot method06109(Item var0, String var1) {
      if (mc.player == null) {
         return null;
      }

      for (int var2 = 0; var2 < mc.player.containerMenu.slots.size(); var2++) {
         Slot var3 = mc.player.containerMenu.getSlot(var2);
         ItemStack var4 = var3.getItem();
         if (var4.getItem() == var0 && (var1 == null || var1.isEmpty() || var4.getHoverName().getString().equals(var1))) {
            return var3;
         }
      }

      return null;
   }

   public static boolean method06110(InteractionHand var0, float var1, float var2) {
      return method06142(var0, var1, var2, true);
   }

   public static int method06111(Item var0, boolean var1) {
      if (mc.player == null) {
         return -1;
      }

      if (var1) {
         for (int var2 = 0; var2 < 9; var2++) {
            if (mc.player.getInventory().getItem(var2).getItem() == var0) {
               return var2;
            }
         }
      } else {
         for (int var3 = 9; var3 < 45; var3++) {
            if (mc.player.getInventory().getItem(var3).getItem() == var0) {
               return var3;
            }
         }
      }

      return -1;
   }

   public static Slot method06112(List<Item> var0) {
      return method06096(var1 -> var0.contains(var1.getItem()), true);
   }

   public static int method06113(Item var0) {
      return IntStream.range(0, 9).filter(var1 -> mc.player.getInventory().getItem(var1).getItem().equals(var0)).findFirst().orElse(-1);
   }

   public static boolean method06114(Item var0) {
      if (mc.player == null) {
         return false;
      }

      for (ItemStack var3 : mc.player.getInventory().getNonEquipmentItems()) {
         if (var3.getItem() == var0) {
            return true;
         }
      }

      return false;
   }

   public static int method06115(Predicate<ItemStack> var0, boolean var1) {
      int var2 = var1 ? mc.player.getInventory().getContainerSize() : 9;
      return IntStream.range(0, var2).filter(var1x -> {
         ItemStack var2x = mc.player.getInventory().getItem(var1x);
         return !var2x.isEmpty() && var0.test(var2x);
      }).findFirst().orElse(-1);
   }

   public static void method06116(int var0, int var1) {
      if (var0 < 9) {
         method06123(var1, var0, ContainerInput.SWAP, false);
      } else if (var0 >= 36 && var0 < 45) {
         method06123(var1, var0 - 36, ContainerInput.SWAP, false);
      } else {
         int var2 = method06129();
         if (var2 == -1) {
            method06123(var0, 0, ContainerInput.PICKUP, false);
            method06123(var1, 0, ContainerInput.PICKUP, false);
            if (!mc.player.containerMenu.getCarried().isEmpty()) {
               method06123(var0, 0, ContainerInput.PICKUP, false);
            }
         } else {
            method06123(var0, var2, ContainerInput.SWAP, false);
            method06123(var1, var2, ContainerInput.SWAP, false);
            method06123(var0, var2, ContainerInput.SWAP, false);
         }
      }
   }

   private static void method06118(int var0) {
      if (mc.player != null && var0 >= 0 && var0 <= 8) {
         mc.player.connection.send(new ServerboundSetCarriedItemPacket(var0));
      }
   }

   public static void method06119() {
      boolean var0 = mc.player.isUsingItem();
      Item var1 = Items.FIREWORK_ROCKET;
      int var2 = mc.player.getInventory().getSelectedSlot();
      if (!var0) {
         for (int var3 = 0; var3 < 9; var3++) {
            if (mc.player.getInventory().getItem(var3).getItem() == var1) {
               if (var3 != mc.player.getInventory().getSelectedSlot()) {
                  mc.player.connection.send(new ServerboundSetCarriedItemPacket(var3));
               }

               method06142(InteractionHand.MAIN_HAND, field13870, field13871, false);
               if (var3 != mc.player.getInventory().getSelectedSlot()) {
                  mc.player.connection.send(new ServerboundSetCarriedItemPacket(mc.player.getInventory().getSelectedSlot()));
               }

               field13859 = true;
               return;
            }
         }

         InventoryActionManager.INSTANCE.method10470(() -> {
            for (int var1x = 0; var1x < 36; var1x++) {
               if (mc.player.getInventory().getItem(var1x).getItem() == var1) {
                  method06137(0, var1x, 8, ContainerInput.SWAP, mc.player);
                  break;
               }
            }
         }, 1, true);
      } else {
         InventoryActionManager.INSTANCE.method10474(() -> method06105(Items.FIREWORK_ROCKET));
      }
   }

   public static boolean method06120(ItemStack var0) {
      if (var0.isEmpty()) {
         return false;
      }

      if (!var0.isEnchanted() && !var0.hasFoil()) {
         if (Boolean.TRUE.equals(var0.get(DataComponents.ENCHANTMENT_GLINT_OVERRIDE))) {
            return true;
         }

         if (!var0.has(DataComponents.CUSTOM_MODEL_DATA) && !var0.has(DataComponents.CUSTOM_NAME)) {
            ItemLore var1 = var0.get(DataComponents.LORE);
            if (var1 != null && !var1.lines().isEmpty()) {
               return true;
            }

            ItemAttributeModifiers var2 = var0.get(DataComponents.ATTRIBUTE_MODIFIERS);
            return var2 != null && !var2.modifiers().isEmpty();
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public static boolean method06122(Slot var0, InteractionHand var1, float var2, float var3) {
      if (mc.player == null) {
         return false;
      } else {
         int var4 = var1 == InteractionHand.MAIN_HAND ? method06083(var0) : -1;
         if (var4 != -1) {
            int var5 = mc.player.getInventory().getSelectedSlot();
            method06118(var4);
            method06110(var1, var2, var3);
            method06118(var5);
            return true;
         } else {
            InventoryActionManager.INSTANCE.method10469(() -> {
               method06093(var0, var1, false);
               method06110(var1, var2, var3);
               method06093(var0, var1, false);
            });
            return true;
         }
      }
   }

   public static void method06123(int var0, int var1, ContainerInput var2, boolean var3) {
      method06127(0, var0, var1, var2, var3);
   }

   public static List<Slot> method06124() {
      NonNullList<Slot> var0 = mc.player.containerMenu.slots;
      return new ArrayList<>(var0.stream().filter(var1 -> var1.index > var0.size() - 10).toList());
   }

   public static void method06127(int var0, int var1, int var2, ContainerInput var3, boolean var4) {
      if (mc.player != null) {
         method06137(var0, var1, var2, var3, mc.player);
      }
   }

   public static InteractionResult method06128(InteractionHand var0, float var1, float var2) {
      if (mc.gameMode != null && mc.player != null) {
         if (var1 != field13866 || var2 != field13867) {
            RotationManager.method06547(new Rotation(var1, var2), field13868, field13869, false);
         }

         return mc.gameMode.useItem(mc.player, var0);
      } else {
         return InteractionResult.FAIL;
      }
   }

   public static int method06129() {
      int var0 = method06094(-1);
      return var0 != -1 ? var0 : method06134(-1);
   }

   public static int method06131(Item var0) {
      return IntStream.range(0, 36)
         .filter(var1 -> mc.player.getInventory().getItem(var1).getItem().equals(var0))
         .map(var0x -> mc.player.getInventory().getItem(var0x).getCount())
         .sum();
   }

   public static int method06134(int var0) {
      if (mc.player == null) {
         return -1;
      }

      NonNullList<ItemStack> var1 = mc.player.getInventory().getNonEquipmentItems();

      for (int var2 = 0; var2 < 9; var2++) {
         if (var2 != var0 && mc.player.getInventory().getSelectedSlot() != var2 && !method06089((ItemStack)var1.get(var2))) {
            return var2;
         }
      }

      return -1;
   }

   public static Slot method06136(Item var0) {
      return method06096(var1 -> var1.getItem() == var0, false);
   }

   public static void method06137(int var0, int var1, int var2, ContainerInput var3, Player var4) {
      if (mc.gameMode != null && method06092(var1, var2, var3)) {
         mc.gameMode.handleContainerInput(var0, var1, var2, var3, var4);
      }
   }

   public static Slot method06141() {
      return method06096(var0 -> var0.is(net.minecraft.tags.ItemTags.AXES), false);
   }

   public static boolean method06142(InteractionHand var0, float var1, float var2, boolean var3) {
      if (mc.gameMode != null && mc.player != null) {
         if (var1 != field13862 || var2 != field13863) {
            RotationManager.method06547(new Rotation(var1, var2), field13864, field13865, false);
         }

         mc.gameMode.useItem(mc.player, var0);
         if (var3) {
            mc.player.swing(var0, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
         }

         return false;
      } else {
         return false;
      }
   }
}
