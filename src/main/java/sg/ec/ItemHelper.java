// Original binary: sg/ec/el5Ze82RagrLqCDV
package sg.ec;

import java.util.List;
import java.util.function.Predicate;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public class ItemHelper extends ClientModule {
   private static final int field18678 = 2;
   private static final int field18679 = 0;
   private static final int field18680 = 0;
   private static final int field18681 = 0;
   private static final int field18682 = 0;
   private final KeyBindSetting field18683;
   private final KeyBindSetting field18684;
   private final KeyBindSetting field18685;
   private final KeyBindSetting field18686;
   private final KeyBindSetting field18687;
   private final KeyBindSetting field18688;
   private final KeyBindSetting field18689;
   private final List<ItemHelper.Nested230> field18690;
   private static final List<ItemHelper.Nested228> field18691 = List.of(
      new ItemHelper.Nested228(MobEffects.STRENGTH, List.of(Potions.STRONG_STRENGTH)),
      new ItemHelper.Nested228(MobEffects.SPEED, List.of(Potions.STRONG_SWIFTNESS)),
      new ItemHelper.Nested228(MobEffects.FIRE_RESISTANCE, List.of(Potions.FIRE_RESISTANCE, Potions.LONG_FIRE_RESISTANCE))
   );
   private ItemHelper.Nested229 field18692;
   private int field18693;
   private int field18694;
   private boolean field18695;
   private Predicate<ItemStack> field18696;
   private Item field18697;
   private Item field18698;
   private boolean field18699;
   private boolean field18700;
   private int field18701;
   private ItemHelper.Nested228 field18702;
   private int field18703;
   private int field18704;
   private int field18705;
   private int field18706;
   private static final String field18707 = "Зачарованное золотое яблоко";
   private static final String field18708 = "Золотое яблоко";
   private static final String field18709 = "Хорус";
   private static final String field18710 = "Золотая морковь";
   private static final String field18711 = "Трезубец";
   private static final String field18712 = "Арбалет";
   private static final String field18713 = "Авто разбафф";
   private static final String field18714 = "Item Helper";

   @Override
   public void method00245() {
      super.method00245();
      this.field18698 = null;
      this.field18699 = false;
      if (this.field18692 != ItemHelper.Nested229.IDLE) {
         this.method07844();
      }
   }

   private static boolean method07841(ItemStack var0, ItemHelper.Nested228 var1) {
      if (var0.getItem() != Items.POTION) {
         return false;
      }

      PotionContents var2 = var0.get(DataComponents.POTION_CONTENTS);
      if (var2 == null) {
         return false;
      }

      for (var var4 : var1.potions()) {
         if (var2.is(var4)) {
            return true;
         }
      }

      return false;
   }

   private boolean method07842(Holder<MobEffect> var1) {
      return mc.player != null && method07868(mc.player.getEffect(var1), 20);
   }

   private void method07843(int var1, int var2) {
      int var3 = this.field18705;
      int var4 = this.field18706;
      this.field18705 = var1;
      this.field18706 = var2;
      InventoryActionManager.INSTANCE.method10469(() -> {
         if (var3 != -1) {
            InventoryUtils.method06123(var3, var4, ContainerInput.SWAP, false);
         }

         InventoryUtils.method06123(var1, var2, ContainerInput.SWAP, false);
      });
   }

   private void method07844() {
      this.method07871();
      this.method07875(this.field18703);
      this.method07874();
   }

   private void method07845() {
      if (this.method07862()) {
         this.method07864(ItemHelper.Nested229.ARM);
      } else {
         if (this.field18693 > 40) {
            this.method07844();
         }
      }
   }

   public ItemHelper() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field18683 = new KeyBindSetting(field18707).method03017(new KeyBinding()).method03023(this);
      this.field18684 = new KeyBindSetting(field18708).method03017(new KeyBinding()).method03023(this);
      this.field18685 = new KeyBindSetting(field18709).method03017(new KeyBinding()).method03023(this);
      this.field18686 = new KeyBindSetting(field18710).method03017(new KeyBinding()).method03023(this);
      this.field18687 = new KeyBindSetting(field18711).method03017(new KeyBinding()).method03023(this);
      this.field18688 = new KeyBindSetting(field18712).method03017(new KeyBinding()).method03023(this);
      this.field18689 = new KeyBindSetting(field18713).method03017(new KeyBinding()).method03023(this);
      this.field18690 = List.of(
         new ItemHelper.Nested230(this.field18683, Items.ENCHANTED_GOLDEN_APPLE),
         new ItemHelper.Nested230(this.field18684, Items.GOLDEN_APPLE),
         new ItemHelper.Nested230(this.field18685, Items.CHORUS_FRUIT),
         new ItemHelper.Nested230(this.field18686, Items.GOLDEN_CARROT),
         new ItemHelper.Nested230(this.field18687, Items.TRIDENT),
         new ItemHelper.Nested230(this.field18688, Items.CROSSBOW)
      );
      this.field18692 = ItemHelper.Nested229.IDLE;
      this.field18703 = -1;
      this.field18704 = -1;
      this.field18705 = -1;
      this.field18706 = -1;
      this.method03935(field18714);
   }

   @Subscribe
   private void method07846(MouseButtonEvent var1) {
      this.method07858(var1.method06914(), var1.method06919());
   }

   private void method07847() {
      if (this.field18692 != ItemHelper.Nested229.IDLE && this.field18692 != ItemHelper.Nested229.FINISH) {
         this.method07864(ItemHelper.Nested229.FINISH);
      }
   }

   private void method07848() {
      if (!mc.player.isUsingItem() || this.field18693 > 20) {
         this.method07844();
      }
   }

   private void method07849() {
      if (!this.method07862()) {
         this.method07864(ItemHelper.Nested229.HAND);
      } else if (this.field18693 >= 2) {
         this.field18694 = mc.player.getMainHandItem().getCount();
         this.method07864(ItemHelper.Nested229.USE);
      }
   }

   private void method07850() {
      if (this.field18692 == ItemHelper.Nested229.IDLE) {
         if (this.field18699) {
            this.method07872();
         } else if (this.field18698 != null) {
            this.method07853(this.field18698);
         }
      } else if (this.field18692 != ItemHelper.Nested229.FINISH) {
         if (this.field18700 ? !this.field18699 : this.field18698 != this.field18697) {
            this.method07847();
         }
      }
   }

   private void method07851() {
      if (this.field18702 != null && this.method07842(this.field18702.effect())) {
         this.method07856();
      } else {
         ItemStack var1 = mc.player.getMainHandItem();
         if (!this.method07862() || var1.getCount() < this.field18694) {
            this.method07856();
         } else if (mc.player.isUsingItem()) {
            this.field18695 = true;
         } else {
            if (this.field18695 || this.field18693 > 20) {
               this.method07856();
            }
         }
      }
   }

   private int method07852(int var1, int var2) {
      if (mc.player != null && this.field18696 != null) {
         for (int var3 = var1; var3 < var2; var3++) {
            if (this.field18696.test(mc.player.getInventory().getItem(var3))) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   private void method07853(Item var1) {
      if (this.method07869()) {
         this.method07859();
         this.field18696 = var1x -> var1x.getItem() == var1;
         if (!this.method07854()) {
            this.method07874();
         } else {
            this.field18697 = var1;
         }
      }
   }

   private boolean method07854() {
      this.field18695 = false;
      int var1 = this.method07852(0, 9);
      if (var1 != -1) {
         this.method07871();
         this.method07870(var1);
         this.method07864(this.method07862() ? ItemHelper.Nested229.ARM : ItemHelper.Nested229.HAND);
         return true;
      }

      int var2 = this.method07852(9, 36);
      if (var2 == -1) {
         return false;
      }

      this.method07870(this.field18704);
      this.method07843(var2, this.field18704);
      this.method07864(ItemHelper.Nested229.HAND);
      return true;
   }

   @Subscribe
   private void method07855(ItemUseInputEvent var1) {
      switch (this.field18692) {
         case HAND:
         case ARM:
         case FINISH:
            var1.method10456(false);
            break;
         case USE:
            var1.method10456(true);
         case HOLD:
      }
   }

   private void method07856() {
      if (!this.field18700) {
         this.method07864(ItemHelper.Nested229.HOLD);
      } else {
         this.field18701++;
         this.field18702 = null;
         this.method07860();
      }
   }

   private Item method07857(int var1) {
      for (ItemHelper.Nested230 var3 : this.field18690) {
         if (var1 == var3.bind().method03022().method05871()) {
            return var3.item();
         }
      }

      return null;
   }

   private void method07858(int var1, InputAction var2) {
      if (var1 != -1) {
         if (var1 == this.field18689.method03022().method05871()) {
            this.field18699 = var2 == InputAction.PRESS;
         } else {
            Item var3 = this.method07857(var1);
            if (var3 != null) {
               if (var2 == InputAction.PRESS) {
                  this.field18698 = var3;
               } else if (this.field18698 == var3) {
                  this.field18698 = null;
               }
            }
         }
      }
   }

   private void method07859() {
      this.field18703 = mc.player.getInventory().getSelectedSlot();
      this.field18704 = InventoryUtils.method06129();
      if (this.field18704 < 0 || this.field18704 > 8) {
         this.field18704 = this.field18703;
      }
   }

   private void method07860() {
      while (this.field18701 < field18691.size()) {
         ItemHelper.Nested228 var1 = field18691.get(this.field18701);
         if (this.method07842(var1.effect())) {
            this.field18701++;
         } else {
            this.field18696 = var1x -> method07841(var1x, var1);
            if (this.method07854()) {
               this.field18702 = var1;
               return;
            }

            this.field18701++;
         }
      }

      this.method07844();
   }

   private boolean method07862() {
      return this.field18696 != null && mc.player != null && this.field18696.test(mc.player.getMainHandItem());
   }

   @Subscribe(0)
   private void method07863(TickEvent var1) {
      if (mc.player != null && mc.gameMode != null) {
         this.method07850();
         if (this.field18692 != ItemHelper.Nested229.IDLE) {
            this.field18693++;
            switch (this.field18692) {
               case HAND:
                  this.method07845();
                  break;
               case ARM:
                  this.method07849();
                  break;
               case USE:
                  this.method07851();
               case HOLD:
               default:
                  break;
               case FINISH:
                  this.method07848();
            }
         }
      } else {
         this.field18698 = null;
         this.field18699 = false;
         this.method07874();
      }
   }

   private void method07864(ItemHelper.Nested229 var1) {
      this.field18692 = var1;
      this.field18693 = 0;
   }

   @Subscribe
   private void method07867(KeyInputEvent var1) {
      this.method07858(var1.method05887(), var1.method05884());
   }

   static boolean method07868(MobEffectInstance var0, int var1) {
      return var0 != null && var0.getDuration() >= var1;
   }

   private boolean method07869() {
      return mc.player != null
         && mc.gameMode != null
         && this.field18692 == ItemHelper.Nested229.IDLE
         && mc.player.containerMenu == mc.player.inventoryMenu;
   }

   private void method07870(int var1) {
      if (this.method07875(var1) && mc.gameMode != null) {
         ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).hookEnsureHasSentCarriedItem();
      }
   }

   private void method07871() {
      if (this.field18705 != -1) {
         int var1 = this.field18705;
         int var2 = this.field18706;
         this.field18705 = -1;
         this.field18706 = -1;
         InventoryActionManager.INSTANCE.method10469(() -> InventoryUtils.method06123(var1, var2, ContainerInput.SWAP, false));
      }
   }

   private void method07872() {
      if (this.method07869()) {
         this.method07859();
         this.field18700 = true;
         this.field18701 = 0;
         this.method07860();
      }
   }

   private void method07874() {
      this.field18692 = ItemHelper.Nested229.IDLE;
      this.field18693 = 0;
      this.field18694 = 0;
      this.field18695 = false;
      this.field18696 = null;
      this.field18697 = null;
      this.field18700 = false;
      this.field18701 = 0;
      this.field18702 = null;
      this.field18703 = -1;
      this.field18704 = -1;
      this.field18705 = -1;
      this.field18706 = -1;
   }

   private boolean method07875(int var1) {
      if (mc.player != null && var1 >= 0 && var1 <= 8) {
         if (mc.player.getInventory().getSelectedSlot() == var1) {
            return false;
         }

         mc.player.getInventory().setSelectedSlot(var1);
         return true;
      } else {
         return false;
      }
   }

   // $VF: Compiled from s
   private record Nested228(Holder<MobEffect> effect, List<Holder<Potion>> potions) {
   }

   // $VF: Compiled from s
   private enum Nested229 {
      IDLE,
      HAND,
      ARM,
      USE,
      HOLD,
      FINISH;
   }

   // $VF: Compiled from s
   private record Nested230(KeyBindSetting bind, Item item) {
   }
}
