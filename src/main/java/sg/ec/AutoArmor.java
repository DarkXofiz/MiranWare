// Original binary: sg/ec/F8iQ3PYmGI7BFVmb
package sg.ec;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class AutoArmor extends ClientModule {
   private final NumberSetting<Integer> field07277;
   private final ToggleSetting field07278;
   private final NumberSetting<Integer> field07279;
   private int field07280;
   private static final String field07281 = "Задержка";
   private static final String field07282 = "Сейвить броню";
   private static final String field07283 = "Прочность сейва в %";
   private static final String field07284 = "Auto Armor";
   private static final double field07285 = 1.0E-4;

   public AutoArmor() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field07277 = new NumberSetting<Integer>(field07281).method10835(1).method10838(10).method10834(1).method03017(5).method03023(this);
      this.field07278 = new ToggleSetting(field07282).method03017(false).method03023(this);
      this.field07279 = new NumberSetting<Integer>(field07283)
         .method10835(3)
         .method10838(8)
         .method10834(1)
         .method03017(5)
         .method03025(() -> this.field07278.method05999())
         .method03023(this);
      this.method03935(field07284);
   }

   private boolean method03332(ItemStack var1) {
      if (this.field07278.method05999() && !var1.isEmpty()) {
         int var2 = var1.getMaxDamage();
         return var2 <= 0 ? false : (var2 - var1.getDamageValue()) * 100 / var2 <= this.field07279.method03022();
      } else {
         return false;
      }
   }

   private boolean method03334(EquipmentSlot var1) {
      ItemStack var2 = mc.player.getItemBySlot(var1);
      if (var2.getItem() == Items.ELYTRA) {
         return false;
      }

      boolean var3 = this.method03332(var2);
      ItemStack var4 = var3 ? ItemStack.EMPTY : var2;
      double var5 = var3 ? 0.0 : ArmorScoreUtils.method05911(var2, var1);
      int var7 = -1;

      for (int var8 = 9; var8 < 45; var8++) {
         ItemStack var9 = mc.player.containerMenu.getSlot(var8).getItem();
         if (ArmorScoreUtils.method05916(var9, var1) && !this.method03332(var9)) {
            double var10 = ArmorScoreUtils.method05911(var9, var1);
            if (!(var10 <= field07285) && ArmorScoreUtils.method05910(var9, var4, var10, var5)) {
               var4 = var9;
               var5 = var10;
               var7 = var8;
            }
         }
      }

      int var12 = ArmorScoreUtils.method05921(var1);
      return var7 != -1 ? this.method03335(var12, var7, !var2.isEmpty()) : var3 && ArmorScoreUtils.method05917(var12);
   }

   private boolean method03335(int var1, int var2, boolean var3) {
      if (!var3) {
         if (this.field07280 > 0) {
            return false;
         }

         this.field07280 = this.field07277.method03022();
      }

      return ArmorScoreUtils.method05919(var1, var2, var3);
   }

   @Subscribe
   private void method03336(TickEvent var1) {
      if (mc.player != null && mc.level != null && mc.gameMode != null) {
         if (this.field07280 > 0) {
            this.field07280--;
         }

         if (!mc.player.isSpectator() && !mc.player.isDeadOrDying()) {
            if (mc.player.containerMenu == mc.player.inventoryMenu) {
               if (!InventoryActionManager.INSTANCE.method10476()) {
                  for (EquipmentSlot var5 : ArmorScoreUtils.field12667) {
                     if (this.method03334(var5)) {
                        return;
                     }
                  }
               }
            }
         }
      } else {
         this.field07280 = 0;
      }
   }
}
