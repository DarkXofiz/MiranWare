// Original binary: sg/ec/L1Mh7HizyHGccUTj
package sg.ec;

import java.util.ArrayList;
import java.util.Optional;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class ConfirmScreenAuctionScanner extends AbstractAuctionScanner {
   private static final long field09732 = 300L;
   private static final long field09733 = 0;
   private static final String field09734 = "field09734";
   private static final String field09735 = "field09735";
   private static final String field09736 = "field09736";
   private long field09737;
   private long field09738;
   private long field09739;
   private int field09740 = -1;
   private int field09741 = -1;
   private long field09742;
   private int field09743;
   private long field09744;
   private static final String field09745 = "Покупка предмета";
   private static final long field09746 = 300L;
   private static final String field09747 = "Сортировка";
   private static final long field09748 = 400L;
   private static final String field09749 = "✔";
   private static final String field09750 = "Сначала новые";

   private void method04336(AbstractContainerMenu var1, long var2) {
      int var4 = AuctionContainerUtils.method02621(var1) ? 47 : AuctionContainerUtils.method02615(var1);
      if (var4 >= 0) {
         this.field13487.method02863(var1, var4, ContainerInput.PICKUP);
         this.field09744 = var2 + field09746;
      }

      this.field09737 = var2 + AutoBuyDelayUtils.method07072();
   }

   private void method04337() {
      this.field09737 = 0L;
      this.field09738 = 0L;
      this.field09744 = 0L;
      this.field09743 = 0;
      this.method04338();
      this.method05970();
   }

   private void method04338() {
      this.field09740 = -1;
      this.field09741 = -1;
      this.field09742 = 0L;
   }

   @Override
   public void method04339(long var1) {
      if (this.field13487.method02872()) {
         if (this.field13487.method10161(field09745)) {
            this.method04350(var1);
         } else {
            this.field09739 = 0L;
            if (!this.field13487.method02870()) {
               this.method04337();
               this.method05967(var1);
            } else {
               this.method05975();
               AbstractContainerMenu var3 = this.field13487.method02862();
               if (var3 != null) {
                  if (!this.method04346(var3, var1)) {
                     if (this.method04348(var3, var1)) {
                        if (var1 >= this.field09737) {
                           int var4 = method04342(var3);
                           if (var4 != this.field09743 || var1 >= this.field09744) {
                              this.field09743 = var4;
                              AbstractAuctionScanner.Nested180 var5 = this.method04349(var3, var1);
                              if (var5 != AbstractAuctionScanner.Nested180.CLICKED && var5 != AbstractAuctionScanner.Nested180.EMPTY) {
                                 this.method04336(var3, var1);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void method04340(AbstractContainerMenu var1, int var2, long var3) {
      this.field09740 = var2;
      this.field09741 = var1.containerId;
      this.field09742 = var3;
   }

   private static boolean method04341(ItemStack var0) {
      for (Component var2 : ItemTooltipUtils.method02658(var0)) {
         String var3 = ItemTooltipUtils.method02659(var2.getString()).trim();
         if (var3.startsWith(field09749) && var3.contains(field09750)) {
            return true;
         }
      }

      return false;
   }

   public ConfirmScreenAuctionScanner(AutoBuyExecutor var1) {
      super(var1);
   }

   private static int method04342(AbstractContainerMenu var0) {
      int var1 = var0.containerId;
      int var2 = Math.min(44, var0.slots.size() - 1);

      for (int var3 = 0; var3 <= var2; var3++) {
         var1 = var1 * 31 + System.identityHashCode(var0.getSlot(var3).getItem());
      }

      return var1;
   }

   @Override
   public void method04343() {
      super.method04343();
      this.field09737 = 0L;
      this.field09738 = 0L;
      this.field09739 = 0L;
      this.field09744 = 0L;
      this.field09743 = 0;
      this.method04338();
   }

   private ConfirmScreenAuctionScanner.Nested130 method04344(AbstractContainerMenu var1, ItemStack var2, long var3) {
      if (var2.isEmpty()) {
         return new ConfirmScreenAuctionScanner.Nested130(false, null, var2);
      }

      Long var5 = this.method04347(var2);
      var var6 = this.method05965(var2, var5);
      if (var6.isPresent()) {
         return new ConfirmScreenAuctionScanner.Nested130(true, (AutoBuyItem)var6.get(), var2);
      }

      this.method05972(var1, 13, var2, var5, var3);
      return new ConfirmScreenAuctionScanner.Nested130(false, null, var2);
   }

   private void method04345(AbstractContainerMenu var1, Item var2, ConfirmScreenAuctionScanner.Nested130 var3) {
      for (int var4 = 0; var4 < var1.slots.size(); var4++) {
         if (AuctionContainerUtils.method02618(var1, var4).getItem() == var2) {
            if (var3.confirmed()) {
               this.method05968(var3.entry(), var3.stack());
            }

            this.field13487.method02863(var1, var4, ContainerInput.PICKUP);
            return;
         }
      }
   }

   private boolean method04346(AbstractContainerMenu var1, long var2) {
      if (this.field09740 < 0) {
         return false;
      } else if (var2 < this.field09742) {
         return true;
      } else if (var1.containerId == this.field09741 && this.field09740 < var1.slots.size()) {
         this.field13487.method02863(var1, this.field09740, ContainerInput.PICKUP);
         this.method04338();
         return true;
      } else {
         this.method04338();
         return false;
      }
   }

   @Override
   protected Long method04347(ItemStack var1) {
      Long var2 = AuctionPriceParser.method09587(var1);
      return var2 == null ? null : var2 * Math.max(1, var1.getCount());
   }

   private boolean method04348(AbstractContainerMenu var1, long var2) {
      ItemStack var4 = AuctionContainerUtils.method02618(var1, 52);
      if (var4.isEmpty() || var4.getItem() != Items.HOPPER || !AuctionContainerUtils.method02611(var4, field09747)) {
         return true;
      }

      if (method04341(var4)) {
         this.field09738 = 0L;
         return true;
      }

      if (this.field09738 == 0L) {
         this.field09738 = var2 + AutoBuyDelayUtils.method07072();
         return false;
      }

      if (var2 >= this.field09738) {
         this.field13487.method02863(var1, 52, ContainerInput.PICKUP);
         this.field09738 = var2 + field09748;
      }

      return false;
   }

   private AbstractAuctionScanner.Nested180 method04349(AbstractContainerMenu var1, long var2) {
      ArrayList var4 = new ArrayList();
      boolean var5 = this.method05974(var1, var2, var4);
      AbstractAuctionScanner.Nested179 var6 = method05969(var4);
      if (var6 == null) {
         return var5 ? AbstractAuctionScanner.Nested180.NO_MATCH : AbstractAuctionScanner.Nested180.EMPTY;
      }

      this.method04340(var1, var6.slot(), var2);
      return AbstractAuctionScanner.Nested180.CLICKED;
   }

   private void method04350(long var1) {
      AbstractContainerMenu var3 = this.field13487.method02862();
      if (var3 != null) {
         if (this.field09739 == 0L) {
            this.field09739 = var1 + AutoBuyDelayUtils.method07072();
         } else if (var1 >= this.field09739) {
            ItemStack var4 = AuctionContainerUtils.method02618(var3, 13);
            ConfirmScreenAuctionScanner.Nested130 var5 = this.method04344(var3, var4, var1);
            this.method04345(var3, Items.STAINED_GLASS_PANE.pick(var5.confirmed() ? DyeColor.LIME : DyeColor.RED), var5);
            this.field09739 = var1 + AutoBuyDelayUtils.method07072();
         }
      }
   }

   // $VF: Compiled from s
   private record Nested130(boolean confirmed, AutoBuyItem entry, ItemStack stack) {
   }
}
