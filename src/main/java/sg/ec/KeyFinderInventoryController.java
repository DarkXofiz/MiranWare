// Original binary: sg/ec/rUYimJNWBXA75JgK
package sg.ec;

import java.util.Set;
import java.util.function.Predicate;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public final class KeyFinderInventoryController implements MinecraftAccess {
   private static final int field23234 = 2;
   private static final int field23235 = 0;
   private static final int field23236 = 0;
   private static final int field23237 = 0;
   private static final int field23238 = 0;
   private static final Set<Item> field23239 = Set.of(
      Items.GOLDEN_APPLE,
      Items.ENCHANTED_GOLDEN_APPLE,
      Items.CHORUS_FRUIT,
      Items.ROTTEN_FLESH,
      Items.SPIDER_EYE,
      Items.POISONOUS_POTATO,
      Items.PUFFERFISH,
      Items.SUSPICIOUS_STEW
   );
   private static final Predicate<ItemStack> field23240 = KeyFinderInventoryController::method10324;
   private static final Predicate<ItemStack> field23241 = var0 -> var0.getItem() == Items.GOLDEN_APPLE;
   private KeyFinderInventoryController.Nested293 field23242 = KeyFinderInventoryController.Nested293.IDLE;
   private Predicate<ItemStack> field23243;
   private int field23244;
   private int field23245;
   private int field23246 = -1;
   private int field23247 = -1;
   private int field23248 = -1;

   private int method10321(int var1, int var2) {
      for (int var3 = var1; var3 < var2; var3++) {
         if (this.field23243.test(mc.player.getInventory().getItem(var3))) {
            return var3;
         }
      }

      return -1;
   }

   private void method10322(int var1) {
      if (var1 >= 0 && var1 <= 8 && mc.player.getInventory().getSelectedSlot() != var1) {
         mc.player.getInventory().setSelectedSlot(var1);
         ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).hookEnsureHasSentCarriedItem();
      }
   }

   public boolean method10323() {
      return this.field23242 != KeyFinderInventoryController.Nested293.IDLE;
   }

   public static boolean method10324(ItemStack var0) {
      return !var0.isEmpty() && var0.has(DataComponents.FOOD) && !field23239.contains(var0.getItem());
   }

   private boolean method10325(Predicate<ItemStack> var1) {
      if (mc.player.containerMenu != mc.player.inventoryMenu) {
         return false;
      }

      this.field23243 = var1;
      int var2 = this.method10321(0, 9);
      int var3 = var2 == -1 ? this.method10321(9, 36) : -1;
      if (var2 == -1 && var3 == -1) {
         this.field23243 = null;
         return false;
      }

      this.field23246 = mc.player.getInventory().getSelectedSlot();
      if (var2 == -1) {
         int var4 = InventoryUtils.method06129();
         var2 = var4 >= 0 && var4 <= 8 ? var4 : this.field23246;
         InventoryUtils.method06123(var3, var2, ContainerInput.SWAP, false);
         this.field23247 = var3;
         this.field23248 = var2;
      }

      this.method10322(var2);
      this.method10331(KeyFinderInventoryController.Nested293.HAND);
      return true;
   }

   public void method10326(ItemUseInputEvent var1) {
      if (this.field23242 != KeyFinderInventoryController.Nested293.IDLE) {
         var1.method10456(this.field23242 == KeyFinderInventoryController.Nested293.USE && mc.player.isUsingItem());
      }
   }

   public boolean method10327() {
      return this.field23242 == KeyFinderInventoryController.Nested293.IDLE && this.method10325(field23241);
   }

   public void method10328() {
      this.field23244++;
      ItemStack var1 = mc.player.getMainHandItem();
      switch (this.field23242) {
         case HAND:
            if (this.field23243.test(var1)) {
               this.method10331(KeyFinderInventoryController.Nested293.ARM);
            } else if (this.field23244 > 20) {
               this.method10332();
            }
            break;
         case ARM:
            if (!this.field23243.test(var1)) {
               this.method10331(KeyFinderInventoryController.Nested293.HAND);
               return;
            }

            if (this.field23244 < 2) {
               return;
            }

            this.field23245 = var1.getCount();
            this.method10331(KeyFinderInventoryController.Nested293.USE);
            break;
         case USE:
            if (!mc.player.isUsingItem() && this.field23244 % 10 == 1) {
               mc.gameMode.useItem(mc.player, InteractionHand.MAIN_HAND);
            }

            if (!this.field23243.test(var1) || var1.getCount() < this.field23245) {
               this.method10331(KeyFinderInventoryController.Nested293.RELEASE);
            } else if (this.field23244 > 60) {
               this.method10331(KeyFinderInventoryController.Nested293.RELEASE);
            }
            break;
         case RELEASE:
            if (mc.player.isUsingItem() && this.field23244 <= 20) {
               return;
            }

            this.method10332();
      }
   }

   public boolean method10330(int var1) {
      int var2 = mc.player.getFoodData().getFoodLevel();
      return this.field23242 == KeyFinderInventoryController.Nested293.IDLE && var2 <= var1 ? this.method10325(field23240) : false;
   }

   private void method10331(KeyFinderInventoryController.Nested293 var1) {
      this.field23242 = var1;
      this.field23244 = 0;
   }

   public void method10332() {
      if (this.field23242 != KeyFinderInventoryController.Nested293.IDLE) {
         if (this.field23247 != -1) {
            InventoryUtils.method06123(this.field23247, this.field23248, ContainerInput.SWAP, false);
         }

         this.method10322(this.field23246);
         this.field23242 = KeyFinderInventoryController.Nested293.IDLE;
         this.field23243 = null;
         this.field23244 = 0;
         this.field23246 = -1;
         this.field23247 = -1;
         this.field23248 = -1;
      }
   }

   // $VF: Compiled from s
   private enum Nested293 {
      IDLE,
      HAND,
      ARM,
      USE,
      RELEASE;
   }
}
