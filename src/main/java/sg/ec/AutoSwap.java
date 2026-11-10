// Original binary: sg/ec/6ultTxunnridUmjP
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class AutoSwap extends ClientModule {
   private static final String field03655 = "Свап в левой руке";
   private static final String field03656 = "field03656";
   private static final String field03657 = "field03657";
   private static final String field03658 = "field03658";
   private static final String field03659 = "field03659";
   private static final int field03660 = 0;
   private static final int field03661 = 0;
   private static final int field03662 = 0;
   private final MultiToggleSetting field03663;
   private final ModeSetting field03664;
   private final KeyBindSetting field03665;
   private final ModeSetting field03666;
   private final ModeSetting field03667;
   private final KeyBindSetting field03668;
   private final ItemFilterSetting field03669;
   private final List<AutoSwap.Nested44> field03670;
   private AutoSwapWheelScreen field03671;
   private InventoryActionSequence field03672;
   private ItemStack field03673;
   private static final String field03674 = "Свапы";
   private static final String field03675 = "Свап в левой руке";
   private static final String field03676 = "Свап на голову";
   private static final String field03677 = "Мод свапа";
   private static final String field03678 = "2 предмета";
   private static final String field03679 = "3 предмета";
   private static final String field03680 = "2 предмета";
   private static final String field03681 = "Кнопка левой руки";
   private static final String field03682 = "Кнопка свапа";
   private static final String field03683 = "1 предмет";
   private static final String field03684 = "Shield";
   private static final String field03685 = "Shar";
   private static final String field03686 = "GGaple";
   private static final String field03687 = "Totem";
   private static final String field03688 = "Shar";
   private static final String field03689 = "2 предмет";
   private static final String field03690 = "Shield";
   private static final String field03691 = "Shar";
   private static final String field03692 = "GGaple";
   private static final String field03693 = "Totem";
   private static final String field03694 = "Totem";
   private static final String field03695 = "Кнопка свапа на голову";
   private static final String field03696 = "Голова";
   private static final String field03697 = "Auto Swap";
   private static final String field03698 = "3 предмета";
   private static final String field03699 = "Голова для свапа не выбрана";
   private static final long field03700 = 2000L;
   private static final String field03701 = "Авто тотем занимает вторую руку, свап невозможен";
   private static final long field03702 = 2000L;
   private static final String field03703 = "Shield";
   private static final String field03704 = "Totem";
   private static final String field03705 = "GGaple";
   private static final String field03706 = "Shar";
   private static final String field03707 = "Свап в левой руке";
   private static final String field03708 = "Свап на голову";
   private static final String field03709 = "2 предмета";

   private boolean method01509() {
      return this.field03663.method04520(field03708);
   }

   @Override
   public void method00245() {
      super.method00245();
      if (mc.gui.screen() instanceof AutoSwapWheelScreen) {
         mc.gui.setScreen(null);
      }

      this.field03671 = null;
   }

   private Item method01510(String var1) {
      return switch (var1) {
         case field03703 -> Items.SHIELD;
         case field03704 -> Items.TOTEM_OF_UNDYING;
         case field03705 -> Items.GOLDEN_APPLE;
         case field03706 -> Items.PLAYER_HEAD;
         default -> Items.AIR;
      };
   }

   public AutoSwap.Nested44 method01511(int var1) {
      return this.field03670.get(var1);
   }

   private boolean method01513() {
      return mc.player.containerMenu == mc.player.inventoryMenu;
   }

   private boolean method01514() {
      return this.method01520() && this.field03664.method05600(field03709);
   }

   private void method01515(int var1) {
      if (mc.player != null && var1 >= 0 && var1 < this.field03670.size()) {
         ItemStack var2 = this.field03670.get(var1).method01547();
         if (this.method01521(var2) != null && !this.method01519()) {
            this.field03672 = InventoryActionManager.INSTANCE.method10470(() -> this.method01529(var2), 1, this.method01513()).method07543();
         }
      }
   }

   public int method01516() {
      return this.field03670.size();
   }

   private void method01517() {
      this.field03670.clear();

      for (int var1 = 0; var1 < 3; var1++) {
         this.field03670.add(new AutoSwap.Nested44(ItemStack.EMPTY));
      }
   }

   private void method01518() {
      if (mc.player != null) {
         if (this.field03671 == null) {
            this.field03671 = new AutoSwapWheelScreen(this);
         }

         if (mc.gui.screen() != this.field03671) {
            mc.gui.setScreen(this.field03671);
         }
      }
   }

   private boolean method01519() {
      if (!AutoTotem.method08643()) {
         return false;
      }

      NotificationManager.method08597(field03701, field03702, NotificationType.WARNING);
      return true;
   }

   private boolean method01520() {
      return this.field03663.method04520(field03707);
   }

   private Slot method01521(ItemStack var1) {
      return !var1.isEmpty() && !ItemStack.isSameItemSameComponents(mc.player.getOffhandItem(), var1)
         ? this.method01522(var1x -> ItemStack.isSameItemSameComponents(var1x, var1) ? 1 : 0)
         : null;
   }

   private Slot method01522(ToIntFunction<ItemStack> var1) {
      Slot var2 = null;
      int var3 = 0;

      for (Slot var5 : mc.player.containerMenu.slots) {
         if (var5.container == mc.player.getInventory() && var5.getContainerSlot() < 36) {
            int var6 = var1.applyAsInt(var5.getItem());
            if (var6 > var3 || var6 > 0 && var6 == var3 && var5.getContainerSlot() < 9) {
               var2 = var5;
               var3 = var6;
            }
         }
      }

      return var2;
   }

   private boolean method01523() {
      return this.field03669.method00867(mc.player.inventoryMenu.getSlot(5).getItem());
   }

   private void method01525() {
      if (mc.player != null && !AutoTotem.method08643()) {
         this.method01536(this.method01533());
      }
   }

   public void method01526(int var1) {
      if (mc.player != null && var1 >= 0 && var1 < this.field03670.size()) {
         ItemStack var2 = mc.player.getOffhandItem();
         this.field03670.get(var1).method01545(var2.isEmpty() ? ItemStack.EMPTY : var2.copy());
      }
   }

   private void method01527() {
      if (mc.player != null && this.method01544()) {
         if (this.method01523()) {
            int var2 = this.method01532();
            if (var2 != -1) {
               InventoryUtils.method06116(var2, 5);
            } else {
               InventoryUtils.method06123(5, 0, ClickType.QUICK_MOVE, false);
            }
         } else {
            Slot var1 = this.method01522(this.field03669::method00864);
            this.field03673 = mc.player.inventoryMenu.getSlot(5).getItem().copy();
            InventoryUtils.method06116(var1.index, 5);
         }
      }
   }

   @Subscribe
   private void method01528(MouseButtonEvent var1) {
      this.method01540(var1.method06919(), var1.method06914());
   }

   private void method01529(ItemStack var1) {
      if (mc.player != null && !AutoTotem.method08643()) {
         this.method01536(this.method01521(var1));
      }
   }

   private void method01530(boolean var1, boolean var2) {
      if (mc.player != null && (var1 || var2) && !this.method01541()) {
         if (var1 && !this.field03669.method00872()) {
            NotificationManager.method08597(field03699, field03700, NotificationType.WARNING);
         }

         InventoryActionSequence var3 = null;
         if (var1 && this.method01544()) {
            var3 = InventoryActionManager.INSTANCE.method10470(this::method01527, 1, true);
         }

         if (var2 && this.method01533() != null && !this.method01519()) {
            var3 = var3 == null
               ? InventoryActionManager.INSTANCE.method10470(this::method01525, 1, this.method01513())
               : var3.method07545().method07534(this::method01525, 1, this.method01513());
         }

         if (var3 != null) {
            this.field03672 = var3.method07543();
         }
      }
   }

   private void method01531() {
      if (mc.gui.screen() instanceof AutoSwapWheelScreen var1) {
         int var3 = var1.getSelectedIndex();
         mc.gui.setScreen(null);
         this.field03671 = null;
         this.method01515(var3);
      }
   }

   private int method01532() {
      if (!this.field03673.isEmpty()) {
         Slot var1 = this.method01522(var1x -> ItemStack.isSameItemSameComponents(var1x, this.field03673) ? 1 : 0);
         if (var1 != null) {
            return var1.index;
         }
      }

      return ArmorScoreUtils.method05920(EquipmentSlot.HEAD);
   }

   private Slot method01533() {
      Slot var1 = this.method01522(var1x -> this.method01542(this.field03666.method03022(), var1x));
      Slot var2 = this.method01522(var1x -> this.method01542(this.field03667.method03022(), var1x));
      if (var1 == null) {
         return var2;
      } else if (var2 == null) {
         return var1;
      } else {
         return this.method01542(this.field03666.method03022(), mc.player.getOffhandItem()) > 0 ? var2 : var1;
      }
   }

   public AutoSwap() {
      super(ModuleCategory.Combat, ModuleSubCategory.Other);
      this.field03663 = new MultiToggleSetting(field03674)
         .method04517(NamedOption.method08077(field03675, true))
         .method04517(NamedOption.method08077(field03676, false))
         .method03023(this);
      this.field03664 = new ModeSetting(field03677)
         .method05597(field03678, field03679)
         .method03017(field03680)
         .method03025(this::method01520)
         .method03023(this);
      this.field03665 = new KeyBindSetting(field03681)
         .method03017(new KeyBinding(-1))
         .method03016(field03682)
         .method03025(this::method01520)
         .method03023(this);
      this.field03666 = new ModeSetting(field03683)
         .method05597(field03684, field03685, field03686, field03687)
         .method03017(field03688)
         .method03025(this::method01514)
         .method03023(this);
      this.field03667 = new ModeSetting(field03689)
         .method05597(field03690, field03691, field03692, field03693)
         .method03017(field03694)
         .method03025(this::method01514)
         .method03023(this);
      this.field03668 = new KeyBindSetting(field03695).method03017(new KeyBinding(-1)).method03025(this::method01509).method03023(this);
      this.field03669 = new ItemFilterSetting(field03696).method00868(PlayerHeadUtils::method09242).method03025(this::method01509).method03023(this);
      this.field03670 = new ArrayList<>();
      this.field03673 = ItemStack.EMPTY;
      this.method03935(field03697);
      this.method01517();
   }

   public void method01535(AutoSwapWheelScreen var1) {
      if (this.field03671 == var1) {
         this.field03671 = null;
      }
   }

   private void method01536(Slot var1) {
      if (var1 != null) {
         InventoryUtils.method06137(mc.player.containerMenu.containerId, var1.index, 40, ClickType.SWAP, mc.player);
      }
   }

   public ItemStack method01537(int var1) {
      AutoSwap.Nested44 var2 = this.method01511(var1);
      ItemStack var3 = var2.method01547();
      return var3.isEmpty() ? ItemStack.EMPTY : var3.copy();
   }

   @Subscribe
   private void method01538(KeyInputEvent var1) {
      this.method01540(var1.method05884(), var1.method05887());
   }

   private void method01540(InputAction var1, int var2) {
      if (var2 != -1) {
         boolean var3 = this.method01509() && var2 == this.field03668.method03022().method05871();
         boolean var4 = this.method01520() && var2 == this.field03665.method03022().method05871();
         boolean var5 = var4 && this.field03664.method05600(field03698);
         if (var1 == InputAction.PRESS) {
            if (var5) {
               this.method01518();
            }

            this.method01530(var3, var4 && !var5);
         } else if (var1 == InputAction.RELEASE && var5) {
            this.method01531();
         }
      }
   }

   private boolean method01541() {
      return this.field03672 != null && !this.field03672.method07546() && InventoryActionManager.INSTANCE.method10476();
   }

   private int method01542(String var1, ItemStack var2) {
      Item var3 = this.method01510(var1);
      if (var3 != Items.AIR && var2.getItem() == var3) {
         return InventoryUtils.method06120(var2) ? 2 : 1;
      } else {
         return 0;
      }
   }

   private boolean method01544() {
      if (!this.field03669.method00872() || mc.player.containerMenu != mc.player.inventoryMenu) {
         return false;
      } else {
         return !this.method01523() ? this.method01522(this.field03669::method00864) != null : this.method01532() != -1 || ArmorScoreUtils.method05912();
      }
   }

   // $VF: Compiled from s
   public static final class Nested44 {
      private ItemStack field03710;
      private final AnimationUtils field03711;
      private static final long field03712 = 50L;

      public Nested44(ItemStack var1) {
         this.field03711 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field03712);
         this.field03710 = var1 == null ? ItemStack.EMPTY : var1.copy();
      }

      public void method01545(ItemStack var1) {
         this.field03710 = var1 == null ? ItemStack.EMPTY : var1.copy();
      }

      public void method01546(boolean var1) {
         this.field03711.method03375(var1 ? 1.0 : 0.0);
      }

      public ItemStack method01547() {
         return this.field03710;
      }

      public float method01548() {
         return this.field03711.method03377();
      }
   }
}
