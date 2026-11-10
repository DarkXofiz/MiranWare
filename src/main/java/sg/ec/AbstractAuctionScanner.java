// Original binary: sg/ec/W0GajWeHkd4UbkGY
package sg.ec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public abstract class AbstractAuctionScanner {
   private static final int field13479 = 54;
   private static final long field13480 = 0;
   private static final int field13481 = 0;
   private final ItemStack[] field13482 = new ItemStack[54];
   private final long[] field13483 = new long[54];
   private int field13484 = -1;
   private final Map<String, Long> field13485 = new HashMap<>();
   private long field13486;
   protected final AutoBuyExecutor field13487;
   private static final long field13488 = -1L;
   private static final long field13489 = 500L;
   private static final long field13490 = 500L;
   private static final long field13491 = 3000L;
   private static final long field13492 = 3000L;

   protected final Optional<AutoBuyItem> method05965(ItemStack var1, Long var2) {
      return !var1.isEmpty() && var2 != null
         ? AutoBuyItemMatcher.method11535(this.method05966(), var1, this.field13487::method02869)
            .filter(var3 -> AutoBuyItemMatcher.method11533(this.method05966(), var3, var1, var2, this.field13487.method02871()))
         : Optional.empty();
   }

   protected abstract Long method04347(ItemStack var1);

   protected AutoBuyServer method05966() {
      return AutoBuyItemRegistry.INSTANCE.method10998();
   }

   public void method04343() {
      this.method05970();
      this.field13486 = 0L;
      this.field13485.clear();
   }

   public abstract void method04339(long var1);

   protected final void method05967(long var1) {
      if (this.field13487.method02872()) {
         if (this.field13487.method02864()) {
            this.field13487.method02861();
            this.field13486 = var1 + AutoBuyDelayUtils.method07071(field13489);
         } else if (this.field13486 == 0L) {
            this.field13486 = var1 + AutoBuyDelayUtils.method07071(field13490);
         } else {
            if (var1 >= this.field13486) {
               this.field13487.method02867(AutoBuySettings.field19624.method08556());
               this.field13486 = var1 + AutoBuyDelayUtils.method07071(field13491);
            }
         }
      }
   }

   protected final void method05968(AutoBuyItem var1, ItemStack var2) {
      this.field13487
         .method02866(
            var2,
            AuctionItemText.method04155(var2),
            AutoBuyItemMatcher.method11540(this.method05966(), var1, var2),
            AutoBuyItemMatcher.method11541(var1, var2)
         );
   }

   protected AbstractAuctionScanner(AutoBuyExecutor var1) {
      this.field13487 = var1;
   }

   protected static AbstractAuctionScanner.Nested179 method05969(List<AbstractAuctionScanner.Nested179> var0) {
      AbstractAuctionScanner.Nested179 var1 = null;

      for (AbstractAuctionScanner.Nested179 var3 : var0) {
         if (var1 == null || var3.unitPrice() < var1.unitPrice()) {
            var1 = var3;
         }
      }

      return var1;
   }

   protected final void method05970() {
      Arrays.fill(this.field13482, null);
      this.field13484 = -1;
   }

   protected final Long method05971(AbstractContainerMenu var1, int var2, ItemStack var3) {
      if (var1.containerId != this.field13484) {
         this.method05970();
         this.field13484 = var1.containerId;
      }

      boolean var4 = var2 >= 0 && var2 < 54;
      if (var4 && this.field13482[var2] == var3) {
         return this.field13483[var2] < 0L ? null : this.field13483[var2];
      }

      Long var5 = this.method04347(var3);
      if (var4) {
         this.field13482[var2] = var3;
         this.field13483[var2] = var5 == null ? field13488 : var5;
      }

      return var5;
   }

   protected final void method05972(AbstractContainerMenu var1, int var2, ItemStack var3, Long var4, long var5) {
      if (AutoBuySettings.field19624.method08580() && AutoBuyItemMatcher.method11537(this.method05966(), var3.getItem())) {
         this.method05973(var1.containerId, var2, var3, AutoBuyItemMatcher.method11542(this.method05966(), var3, var4), var5);
      }
   }

   protected final void method05973(int var1, int var2, ItemStack var3, String var4, long var5) {
      if (AutoBuySettings.field19624.method08580() && var4 != null) {
         String var7 = var1 + ":" + var2 + ":" + var3.getItem() + ":" + var4;
         Long var8 = this.field13485.get(var7);
         if (var8 == null || var5 - var8 > field13492) {
            if (this.field13485.size() > 200) {
               this.field13485.clear();
            }

            this.field13485.put(var7, var5);
            this.field13487.method02873("Пропущен " + var3.getHoverName().getString() + " (слот " + var2 + "): " + var4);
         }
      }
   }

   protected final boolean method05974(AbstractContainerMenu var1, long var2, List<AbstractAuctionScanner.Nested179> var4) {
      boolean var5 = false;
      int var6 = Math.min(44, var1.slots.size() - 1);

      for (int var7 = 0; var7 <= var6; var7++) {
         ItemStack var8 = AuctionContainerUtils.method02618(var1, var7);
         if (!var8.isEmpty()) {
            var5 = true;
            var var9 = AutoBuyItemMatcher.method11535(this.method05966(), var8, this.field13487::method02869);
            Long var10 = this.method05971(var1, var7, var8);
            if (var9.isPresent()
               && var10 != null
               && AutoBuyItemMatcher.method11533(this.method05966(), (AutoBuyItem)var9.get(), var8, var10, this.field13487.method02871())) {
               var4.add(new AbstractAuctionScanner.Nested179(var7, var8, (AutoBuyItem)var9.get(), var10));
            } else {
               this.method05972(var1, var7, var8, var10, var2);
            }
         }
      }

      return var5;
   }

   protected final void method05975() {
      this.field13486 = 0L;
   }

   // $VF: Compiled from s
   protected record Nested179(int slot, ItemStack stack, AutoBuyItem entry, long totalPrice) {
      long unitPrice() {
         return this.totalPrice / Math.max(1, this.stack.getCount());
      }
   }

   // $VF: Compiled from s
   protected enum Nested180 {
      EMPTY,
      NO_MATCH,
      CLICKED;
   }
}
