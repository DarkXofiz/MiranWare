// Original binary: sg/ec/ZYb4kaJMrS6BtJC9
package sg.ec;

import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AuctionSearchController {
   private static final int field15555 = 90;
   private static final int field15556 = 0;
   private static final char field15557 = ' ';
   private static final String[] field15558 = new String[]{
      UnicodeTextNormalizer.method09496(AuctionSearchController.field15564), UnicodeTextNormalizer.method09496(AuctionSearchController.field15565)
   };
   private int field15559 = -1;
   private boolean field15560;
   private boolean field15561;
   private static final String field15562 = "Аукцион";
   private static final String field15563 = "Хранилище";
   private static final String field15564 = "Вернуться";
   private static final String field15565 = "Перевыставить";

   private static boolean method06891(ItemStack var0) {
      String var1 = UnicodeTextNormalizer.method09496(var0.getHoverName().getString());

      for (String sx : field15558) {
         if (var1.contains(sx)) {
            return true;
         }
      }

      return false;
   }

   public boolean method06892(AbstractContainerMenu var1, String var2) {
      if (var2.contains(field15563)) {
         return true;
      }

      this.method06893(var1);
      return this.field15561;
   }

   private void method06893(AbstractContainerMenu var1) {
      if (var1 == null) {
         this.field15559 = -1;
         this.field15560 = false;
         this.field15561 = false;
      } else {
         if (var1.containerId != this.field15559) {
            this.field15559 = var1.containerId;
            this.field15560 = false;
            this.field15561 = false;
         }

         if (!this.field15560 && !this.field15561) {
            boolean var2 = false;
            int var3 = var1.slots.size() - 36 - 1;

            for (int var4 = 0; var4 <= var3; var4++) {
               ItemStack var5 = AuctionContainerUtils.method02618(var1, var4);
               if (!var5.isEmpty()) {
                  if (method06891(var5)) {
                     this.field15561 = true;
                     return;
                  }

                  var2 |= method06895(var5);
               }
            }

            this.field15560 = var2 && var1.slots.size() >= 90;
         }
      }
   }

   public boolean method06894(AbstractContainerMenu var1, String var2) {
      if (this.method06892(var1, var2)) {
         return false;
      }

      if (var2.contains(field15562)) {
         return true;
      }

      this.method06893(var1);
      return this.field15560;
   }

   private static boolean method06895(ItemStack var0) {
      for (Component var2 : ItemTooltipUtils.method02660(var0)) {
         String var3 = ItemTooltipUtils.method02659(var2.getString());
         if (var3.indexOf(36) >= 0 || var3.indexOf(164) >= 0) {
            return true;
         }
      }

      return false;
   }
}
