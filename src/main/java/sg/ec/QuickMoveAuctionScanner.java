// Original binary: sg/ec/pyM5MmeHKrCIm3FP
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class QuickMoveAuctionScanner extends AbstractAuctionScanner {
   private static final int field22824 = 0;
   private static final int field22825 = 0;
   private static final long field22826 = 0;
   private static final long field22827 = 0;
   private static final String field22828 = "field22828";
   private static final String field22829 = "field22829";
   private long field22830;
   private long field22831;
   private long field22832;
   private static final String field22833 = "Подтверждение покупки";
   private static final long field22834 = 5L;
   private static final long field22835 = 10L;
   private static final String field22836 = "упить";
   private static final String field22837 = "Вернуться";
   private static final long field22838 = 5L;
   private static final long field22839 = 10L;

   private AbstractAuctionScanner.Nested180 method10153(AbstractContainerMenu var1, long var2) {
      List var4 = new ArrayList<>();
      boolean sx = this.method05974(var1, var2, var4);
      AbstractAuctionScanner.Nested179 sxx = method05969(var4);
      if (sxx == null) {
         return sx ? AbstractAuctionScanner.Nested180.NO_MATCH : AbstractAuctionScanner.Nested180.EMPTY;
      }

      if (var2 < this.field22832) {
         return AbstractAuctionScanner.Nested180.CLICKED;
      }

      this.method05968(sxx.entry(), sxx.stack());
      this.field13487.method02863(var1, sxx.slot(), ContainerInput.QUICK_MOVE);
      this.field22832 = var2 + AutoBuyDelayUtils.method07073(field22838, field22839);
      return AbstractAuctionScanner.Nested180.CLICKED;
   }

   @Override
   public void method04339(long var1) {
      if (this.field13487.method02872()) {
         if (this.field13487.method10161(field22833)) {
            if (var1 >= this.field22831) {
               this.method10155(var1);
               this.field22831 = var1 + AutoBuyDelayUtils.method07073(field22834, field22835);
            }
         } else {
            this.field22831 = 0L;
            if (!this.field13487.method02870()) {
               this.method10156();
               this.method05967(var1);
            } else {
               this.method05975();
               AbstractContainerMenu var3 = this.field13487.method02862();
               if (var3 != null) {
                  AbstractAuctionScanner.Nested180 var4 = this.method10153(var3, var1);
                  if (var4 != AbstractAuctionScanner.Nested180.CLICKED && var4 != AbstractAuctionScanner.Nested180.EMPTY) {
                     if (var1 >= this.field22830) {
                        this.method10154(var3);
                        this.field22830 = var1 + AutoBuyDelayUtils.method07072();
                     }
                  }
               }
            }
         }
      }
   }

   private void method10154(AbstractContainerMenu var1) {
      int var2 = AuctionContainerUtils.method02615(var1);
      if (var2 >= 0) {
         this.field13487.method02863(var1, var2, ContainerInput.PICKUP);
      }
   }

   private void method10155(long var1) {
      AbstractContainerMenu var3 = this.field13487.method02862();
      if (var3 != null) {
         ItemStack var4 = AuctionContainerUtils.method02618(var3, 13);
         Long var5 = var4.isEmpty() ? null : this.method04347(var4);
         var var6 = this.method05965(var4, var5);
         boolean var7 = var6.isPresent();
         if (!var7 && !var4.isEmpty()) {
            this.method05972(var3, 13, var4, var5, var1);
         }

         int var8 = var7 ? 0 : 6;
         ItemStack var9 = AuctionContainerUtils.method02618(var3, var8);
         if (!var9.isEmpty() && var9.getItem() == Items.PAPER) {
            if (AuctionContainerUtils.method02611(var9, var7 ? field22836 : field22837)) {
               if (var7) {
                  this.method05968((AutoBuyItem)var6.get(), var4);
               }

               this.field13487.method02863(var3, var8, ContainerInput.PICKUP);
            }
         }
      }
   }

   @Override
   protected Long method04347(ItemStack var1) {
      return AuctionPriceParser.method09594(var1);
   }

   @Override
   public void method04343() {
      super.method04343();
      this.field22830 = 0L;
      this.field22831 = 0L;
      this.field22832 = 0L;
   }

   public QuickMoveAuctionScanner(AutoBuyExecutor var1) {
      super(var1);
   }

   private void method10156() {
      this.field22830 = 0L;
      this.field22832 = 0L;
      this.method05970();
   }
}
