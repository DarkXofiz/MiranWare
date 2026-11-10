// Original binary: sg/ec/SWtUYmnrdFa9yYhW
package sg.ec;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.protocol.game.ServerboundSelectBundleItemPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.BundleItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.component.BundleContents.Mutable;

// $VF: Compiled from s
public final class ServerItemActionUtils implements MinecraftAccess {
   private static final int field11787 = 36;
   private static final int field11788 = 0;
   private static final int field11789 = 0;
   private static final int field11790 = Integer.MAX_VALUE;
   private static final String field11791 = "This is a utility class and cannot be instantiated";

   public static boolean method05465(Predicate<ItemStack> var0, Runnable var1) {
      ServerItemActionUtils.Nested168 var2 = method05479(var0);
      if (var2 == null) {
         return false;
      }

      ServerItemActionUtils.Nested167 sx = method05469(var2);
      if (sx == null) {
         return false;
      }

      int sxx = mc.player.containerMenu.containerId;
      int sxxx = var2.bundle().index;
      int sxxxx = var2.index();
      int sxxxxx = sx.landSlotId();
      int sxxxxxx = sx.parkSlotId();
      InventoryActionManager.INSTANCE.method10470(() -> method05485(sxx, sxxx, sxxxx), 1, false).method07542(1, false).method07534(() -> {
         method05492(sxx, sxxxxx);
         if (sxxxxxx != -1) {
            method05502(sxx, sxxxxxx);
         }

         method05502(sxx, sxxx);
         var1.run();
      }, 1, false);
      return true;
   }

   private static Slot method05466() {
      int var0 = mc.player.getInventory().getSelectedSlot();
      Slot var1 = null;

      for (Slot var3 : mc.player.containerMenu.slots) {
         if (method05499(var3) && var3.getItem().isEmpty()) {
            if (var3.getContainerSlot() != var0) {
               return var3;
            }

            var1 = var3;
         }
      }

      return var1;
   }

   private static ServerItemActionUtils.Nested167 method05469(ServerItemActionUtils.Nested168 var0) {
      Slot var1 = method05466();
      if (var1 != null) {
         return new ServerItemActionUtils.Nested167(var1.index, -1);
      }

      Slot var2 = method05496(var0.target());
      if (var2 != null) {
         return new ServerItemActionUtils.Nested167(var2.index, -1);
      }

      Slot var3 = null;
      Slot var4 = null;
      int var5 = field11790;
      int var6 = mc.player.getInventory().getSelectedSlot();

      for (Slot var8 : mc.player.containerMenu.slots) {
         if (method05499(var8) && var8 != var0.bundle() && var8.getContainerSlot() != var6) {
            ItemStack var9 = var8.getItem();
            if (!var9.isEmpty() && !method05500(var9)) {
               int var10 = method05483(var8, var9);
               if (var10 < var5) {
                  Slot var11 = method05498(var0, var8, var9);
                  if (var11 != null) {
                     var3 = var8;
                     var4 = var11;
                     var5 = var10;
                  }
               }
            }
         }
      }

      return var3 == null ? null : new ServerItemActionUtils.Nested167(var3.index, var4.index);
   }

   private static Slot method05470(int var0) {
      if (mc.player == null) {
         return null;
      }

      NonNullList<Slot> var1 = mc.player.containerMenu.slots;
      return var0 >= 0 && var0 < var1.size() ? (Slot)var1.get(var0) : null;
   }

   private static void method05472(int var0, int var1, int var2) {
      if (mc.player != null && mc.player.containerMenu.containerId == var0) {
         Slot var3 = method05470(var1);
         if (var3 != null) {
            ItemStack var4 = var3.getItem();
            if (method05500(var4)) {
               if (BundleItem.getSelectedItem(var4) != var2) {
                  BundleItem.toggleSelectedItem(var4, var2);
                  mc.player.connection.send(new ServerboundSelectBundleItemPacket(var1, var2));
               }
            }
         }
      }
   }

   public static ItemStack method05473(Item var0, InteractionHand var1, float var2, float var3) {
      return method05474(var1x -> var1x.getItem() == var0, var1, var2, var3);
   }

   public static ItemStack method05474(Predicate<ItemStack> var0, InteractionHand var1, float var2, float var3) {
      ServerItemActionUtils.Nested168 var4 = method05479(var0);
      if (var4 == null) {
         return ItemStack.EMPTY;
      }

      if (mc.player.getCooldowns().isOnCooldown(var4.target())) {
         return ItemStack.EMPTY;
      }

      Slot var5 = method05486(var1 == InteractionHand.OFF_HAND ? 40 : mc.player.getInventory().getSelectedSlot());
      if (var5 == null) {
         return ItemStack.EMPTY;
      }

      int var6 = mc.player.containerMenu.containerId;
      int var7 = var4.bundle().index;
      int var8 = var4.index();
      int var9 = var5.index;
      InventoryActionManager.INSTANCE
         .method10470(() -> method05485(var6, var7, var8), 1, false)
         .method07542(1, false)
         .method07534(() -> method05492(var6, var9), 1, false)
         .method07542(1, false)
         .method07536(() -> {
            InteractionResult var3x = InventoryUtils.method06128(var1, var2, var3);
            if (var3x == InteractionResult.SUCCESS) {
               mc.player.swing(var1);
            }
         }, 1, false)
         .method07542(1, false)
         .method07534(() -> {
            method05491(var6, var9);
            method05502(var6, var7);
         }, 1, false);
      return var4.target();
   }

   public static Slot method05475(Predicate<ItemStack> var0) {
      if (mc.player == null) {
         return null;
      }

      for (Slot var2 : mc.player.containerMenu.slots) {
         if (var2.container == mc.player.getInventory()) {
            ItemStack var3 = var2.getItem();
            if (method05500(var3) && method05494(var3, var0) != -1) {
               return var2;
            }
         }
      }

      return null;
   }

   public static boolean method05477(Item var0) {
      return method05495(var0) != null;
   }

   private static ServerItemActionUtils.Nested168 method05479(Predicate<ItemStack> var0) {
      if (mc.player == null || mc.gameMode == null) {
         return null;
      }

      if (InventoryActionManager.INSTANCE.method10476()) {
         return null;
      }

      if (!mc.player.containerMenu.getCarried().isEmpty()) {
         return null;
      }

      Slot var1 = method05475(var0);
      if (var1 == null) {
         return null;
      }

      BundleContents var2 = var1.getItem().get(DataComponents.BUNDLE_CONTENTS);
      if (var2 == null) {
         return null;
      }

      int var3 = method05494(var1.getItem(), var0);
      return var3 == -1 ? null : new ServerItemActionUtils.Nested168(var1, var2, var3, var2.items().get(var3).create());
   }

   public static int method05480(ItemStack var0, Item var1) {
      return method05494(var0, var1x -> var1x.getItem() == var1);
   }

   public static boolean method05481(Item var0, Runnable var1) {
      return method05465(var1x -> var1x.getItem() == var0, var1);
   }

   private static int method05483(Slot var0, ItemStack var1) {
      return var0.getContainerSlot() < 9 ? var1.getCount() + 99 : var1.getCount();
   }

   private static void method05485(int var0, int var1, int var2) {
      method05472(var0, var1, var2);
      method05501(var0, var1, 1);
   }

   private static Slot method05486(int var0) {
      for (Slot var2 : mc.player.containerMenu.slots) {
         if (var2.container == mc.player.getInventory() && var2.getContainerSlot() == var0) {
            return var2;
         }
      }

      return null;
   }

   private static boolean method05487(BundleContents var0, ItemStack var1) {
      if (var0 == null) {
         return false;
      }
      Mutable var2 = new Mutable();
      var0.itemCopies().forEach(var2::tryInsert);
      return var2.tryInsert(var1.copy()) >= var1.getCount();
   }

   private static boolean method05488(ServerItemActionUtils.Nested168 var0, ItemStack var1) {
      Mutable var2 = new Mutable();
      var0.contents().itemCopies().forEach(var2::tryInsert);
      if (var0.contents().getSelectedItem() != var0.index()) {
         var2.toggleSelectedItem(var0.index());
      }

      return var2.removeOne() == null ? false : var2.tryInsert(var1.copy()) >= var1.getCount();
   }

   private ServerItemActionUtils() {
      throw new UnsupportedOperationException(field11791);
   }

   public static void method05489(ItemStack var0, List<ItemStack> var1) {
      BundleContents var2 = var0.get(DataComponents.BUNDLE_CONTENTS);
      if (var2 != null) {
         var var3 = var2.items();

         for (int var4 = 0; var4 < var3.size(); var4++) {
            ItemStack var5 = (ItemStack)var3.get(var4);
            var1.add(var5);
            if (method05500(var5)) {
               method05489(var5, var1);
            }
         }
      }
   }

   private static void method05491(int var0, int var1) {
      Slot var2 = method05470(var1);
      if (var2 != null) {
         if (!var2.getItem().isEmpty() || !mc.player.containerMenu.getCarried().isEmpty()) {
            method05492(var0, var1);
         }
      }
   }

   private static void method05492(int var0, int var1) {
      method05501(var0, var1, 0);
   }

   public static int method05494(ItemStack var0, Predicate<ItemStack> var1) {
      BundleContents var2 = var0.get(DataComponents.BUNDLE_CONTENTS);
      if (var2 == null) {
         return -1;
      }

      var var3 = var2.items();

      for (int var4 = 0; var4 < var3.size(); var4++) {
         if (var1.test((ItemStack)var3.get(var4))) {
            return var4;
         }
      }

      return -1;
   }

   public static Slot method05495(Item var0) {
      return method05475(var1 -> var1.getItem() == var0);
   }

   private static Slot method05496(ItemStack var0) {
      for (Slot var2 : mc.player.containerMenu.slots) {
         if (method05499(var2)) {
            ItemStack var3 = var2.getItem();
            if (ItemStack.isSameItemSameComponents(var3, var0) && var3.getCount() + var0.getCount() <= var2.getMaxStackSize(var3)) {
               return var2;
            }
         }
      }

      return null;
   }

   private static Slot method05498(ServerItemActionUtils.Nested168 var0, Slot var1, ItemStack var2) {
      if (BundleContents.canItemBeInBundle(var2)) {
         if (method05488(var0, var2)) {
            return var0.bundle();
         }

         for (Slot var4 : mc.player.containerMenu.slots) {
            if (method05499(var4) && var4 != var1 && var4 != var0.bundle()) {
               ItemStack var5 = var4.getItem();
               if (method05500(var5) && method05487(var5.get(DataComponents.BUNDLE_CONTENTS), var2)) {
                  return var4;
               }
            }
         }
      }

      Slot var6 = method05486(40);
      return var6 != null && var6.getItem().isEmpty() && var6.mayPlace(var2) ? var6 : null;
   }

   private static boolean method05499(Slot var0) {
      if (var0.container != mc.player.getInventory()) {
         return false;
      }

      int var1 = var0.getContainerSlot();
      return var1 >= 0 && var1 < 36;
   }

   public static boolean method05500(ItemStack var0) {
      return var0.getItem() instanceof BundleItem && var0.get(DataComponents.BUNDLE_CONTENTS) != null;
   }

   private static void method05501(int var0, int var1, int var2) {
      if (mc.player != null && mc.gameMode != null) {
         if (mc.player.containerMenu.containerId == var0) {
            mc.gameMode.handleInventoryMouseClick(var0, var1, var2, ClickType.PICKUP, mc.player);
         }
      }
   }

   private static void method05502(int var0, int var1) {
      if (mc.player != null && !mc.player.containerMenu.getCarried().isEmpty()) {
         method05492(var0, var1);
      }
   }

   // $VF: Compiled from s
   private record Nested167(int landSlotId, int parkSlotId) {
   }

   // $VF: Compiled from s
   private record Nested168(Slot bundle, BundleContents contents, int index, ItemStack target) {
   }
}
