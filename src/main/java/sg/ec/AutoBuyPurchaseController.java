// Original binary: sg/ec/k1Tuav9qRyd3UoKA
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AutoBuyPurchaseController {
   private static final long field20744 = 5000L;
   private static final long field20745 = 0;
   private static final long field20746 = 0;
   private static final long field20747 = 0;
   private static final int field20748 = 0;
   private static final int field20749 = 0;
   private static final String field20750 = "field20750";
   private static final String field20751 = "field20751";
   private final AutoBuyExecutor field20752;
   private final boolean field20753;
   private final Consumer<String> field20754;
   private final List<AutoBuyItem> field20755 = new ArrayList<>();
   private final Map<AutoBuyItem, Long> field20756 = new HashMap<>();
   private volatile boolean field20757;
   private volatile String field20758 = "";
   private AutoBuyPurchaseController.Nested253 field20759 = AutoBuyPurchaseController.Nested253.IDLE;
   private int field20760;
   private int field20761;
   private int field20762;
   private long field20763;
   private long field20764;
   private long field20765;
   private volatile long field20766;
   private volatile boolean field20767;
   private static final long field20768 = 999L;
   private static final long field20769 = 1000L;
   private static final long field20770 = 60L;
   private static final long field20771 = 60L;
   private static final String field20772 = "в списке нет предметов для автоподбора цен";
   private static final String field20773 = "не было найдено ни одного фильтра";
   private static final long field20774 = 500L;
   private static final long field20775 = 5000L;
   private static final long field20776 = 500L;
   private static final long field20777 = 1500L;
   private static final String field20778 = "  окно поиска не открылось — повтор";
   private static final long field20779 = 300L;

   public int method09131() {
      return this.field20755.size();
   }

   public boolean method09132() {
      return this.field20757 && this.field20759 != AutoBuyPurchaseController.Nested253.IDLE && this.field20759 != AutoBuyPurchaseController.Nested253.COOLDOWN;
   }

   private void method09133(long var1) {
      for (var var4 : this.field20756.entrySet()) {
         long var5 = AutoBuyItemCatalog.method05258((AutoBuyItem)var4.getKey(), (Long)var4.getValue());
         this.field20754.accept("цена «" + ((AutoBuyItem)var4.getKey()).method10673() + "»: " + var5 + "$ (минимум " + var4.getValue() + "$)");
      }

      this.field20752.method02873("Проход окончен: цены найдены для " + this.field20756.size() + " из " + this.field20755.size() + ".");
      if (this.field20752.method02864()) {
         this.field20752.method02861();
      }

      if (!this.field20753) {
         AutoBuySettings.field19624.method08581(false);
         AutoBuyItemRegistry.INSTANCE.method10994();
         this.method09142();
      } else {
         this.field20756.clear();
         this.field20765 = var1 + AutoBuySettings.field19624.method08563();
         this.field20759 = AutoBuyPurchaseController.Nested253.COOLDOWN;
      }
   }

   private void method09134(long var1) {
      this.field20761 = 0;
      this.field20762 = 0;
      this.field20767 = false;
      this.field20766 = 0L;
      this.field20758 = this.field20755.get(this.field20760).method10673();
      this.field20759 = AutoBuyPurchaseController.Nested253.CLOSING;
      this.field20763 = var1;
   }

   private boolean method09135(long var1) {
      long var3 = this.field20766;
      if (var3 <= 0L) {
         return true;
      }

      this.field20766 = 0L;
      if (this.field20759 != AutoBuyPurchaseController.Nested253.WAITING_SCREEN) {
         return true;
      }

      this.field20754.accept("сервер просит подождать " + var3 + " мс — повтор поиска");
      this.field20759 = AutoBuyPurchaseController.Nested253.CLOSING;
      this.field20763 = var1 + var3;
      return false;
   }

   private void method09136(long var1) {
      if (var1 >= this.field20763) {
         AbstractContainerMenu var3 = this.field20752.method02862();
         if (var3 == null) {
            if (var1 >= this.field20764) {
               this.method09145(var1);
            }
         } else {
            long var4 = method09151(var3, this.field20755.get(this.field20760));
            this.field20762++;
            if (var4 > 0L) {
               this.field20756.put(this.field20755.get(this.field20760), var4);
               this.field20754.accept("  «" + this.field20758 + "»: минимум " + var4 + "$");
               this.method09145(var1);
            } else if (this.field20762 >= 2) {
               this.field20754.accept("  «" + this.field20758 + "»: в выдаче нет подходящих лотов");
               this.method09145(var1);
            } else {
               this.field20763 = var1 + field20779;
            }
         }
      }
   }

   private void method09137(long var1) {
      if (!this.field20752.method02868()) {
         if (this.field20752.method02870()) {
            this.field20763 = var1 + AutoBuyDelayUtils.method07071(field20776);
            this.field20764 = this.field20763 + field20777;
            this.field20759 = AutoBuyPurchaseController.Nested253.SCANNING;
         } else if (var1 >= this.field20764) {
            if (this.field20761 < 2) {
               this.field20754.accept(field20778);
               this.field20759 = AutoBuyPurchaseController.Nested253.CLOSING;
               this.field20763 = var1;
            } else {
               this.field20754.accept("  «" + this.field20758 + "»: окно поиска так и не открылось");
               this.method09145(var1);
            }
         }
      }
   }

   public int method09138() {
      return Math.min(this.field20760 + 1, Math.max(1, this.field20755.size()));
   }

   public boolean method09139() {
      return this.field20757;
   }

   public AutoBuyPurchaseController(AutoBuyExecutor var1, boolean var2, Consumer<String> var3) {
      this.field20752 = var1;
      this.field20753 = var2;
      this.field20754 = var3;
   }

   private boolean method09140() {
      return this.field20759 == AutoBuyPurchaseController.Nested253.WAITING_SCREEN || this.field20759 == AutoBuyPurchaseController.Nested253.SCANNING;
   }

   public float method09141() {
      return this.field20755.isEmpty() ? 0.0F : Math.min(1.0F, (float)this.field20760 / this.field20755.size());
   }

   public void method09142() {
      this.field20757 = false;
      this.field20759 = AutoBuyPurchaseController.Nested253.IDLE;
      this.field20755.clear();
      this.field20756.clear();
      this.field20760 = 0;
      this.field20761 = 0;
      this.field20762 = 0;
      this.field20767 = false;
      this.field20766 = 0L;
      this.field20758 = "";
      if (this.field20752.method02864()) {
         this.field20752.method02861();
      }
   }

   public void method09143(long var1) {
      if (this.field20757 && this.field20752.method02872()) {
         if (this.field20759 == AutoBuyPurchaseController.Nested253.COOLDOWN) {
            if (var1 >= this.field20765) {
               this.method09152(var1);
            }
         } else if (this.field20767) {
            this.field20767 = false;
            this.field20754.accept("  «" + this.field20758 + "»: на аукционе нет");
            this.method09145(var1);
         } else if (this.method09135(var1)) {
            switch (this.field20759) {
               case CLOSING:
                  this.method09147(var1);
                  break;
               case SEARCHING:
                  this.method09148(var1);
                  break;
               case WAITING_SCREEN:
                  this.method09137(var1);
                  break;
               case SCANNING:
                  this.method09136(var1);
                  break;
               default:
                  this.method09134(var1);
            }
         }
      }
   }

   public String method09144() {
      return this.field20758;
   }

   private void method09145(long var1) {
      if (++this.field20760 >= this.field20755.size()) {
         this.method09133(var1);
      } else {
         this.method09134(var1);
      }
   }

   private void method09146() {
      this.field20755.clear();
      this.field20755.addAll(AutoBuyItemCatalog.method05257());
   }

   private void method09147(long var1) {
      if (this.field20752.method02864()) {
         this.field20752.method02861();
         this.field20763 = var1 + AutoBuyDelayUtils.method07071(field20774);
      } else {
         if (var1 >= this.field20763) {
            this.field20759 = AutoBuyPurchaseController.Nested253.SEARCHING;
         }
      }
   }

   private void method09148(long var1) {
      this.field20752.method02867(AutoBuySettings.field19624.method08556() + " search " + this.field20758);
      this.field20761++;
      this.field20764 = var1 + field20775;
      this.field20759 = AutoBuyPurchaseController.Nested253.WAITING_SCREEN;
   }

   public boolean method09149() {
      AutoBuyServer var1 = AutoBuyItemRegistry.INSTANCE.method10998();
      if (!var1.method06433()) {
         this.field20754.accept("автоподбор цен не поддерживается на " + var1.method06430());
         return false;
      } else {
         this.method09146();
         if (this.field20755.isEmpty()) {
            this.field20754.accept(field20772);
            return false;
         } else {
            this.field20757 = true;
            this.field20754.accept("проход начат, предметов: " + this.field20755.size() + ", сервер: " + var1.method06430());
            this.method09134(System.currentTimeMillis());
            return true;
         }
      }
   }

   public String method09150() {
      if (!this.field20757) {
         return "";
      } else if (this.field20759 == AutoBuyPurchaseController.Nested253.COOLDOWN) {
         long var1 = Math.max(0L, (this.field20765 - System.currentTimeMillis() + field20768) / field20769);
         return "следующий проход через " + var1 / field20770 + " м " + var1 % field20771 + " с";
      } else {
         return this.method09138() + " / " + this.field20755.size();
      }
   }

   private static long method09151(AbstractContainerMenu var0, AutoBuyItem var1) {
      long var2 = 0L;
      int var4 = Math.min(44, var0.slots.size() - 1);

      for (int var5 = 0; var5 <= var4; var5++) {
         ItemStack var6 = AuctionContainerUtils.method02618(var0, var5);
         if (!var6.isEmpty() && AutoBuyItemCatalog.method05255(var1, var6)) {
            Long var7 = AutoBuyItemCatalog.method05256(var6);
            if (var7 != null && var7 > 0L && (var2 == 0L || var7 < var2)) {
               var2 = var7;
            }
         }
      }

      return var2;
   }

   private void method09152(long var1) {
      this.method09146();
      this.field20760 = 0;
      if (this.field20755.isEmpty()) {
         this.field20765 = var1 + AutoBuySettings.field19624.method08563();
      } else {
         this.method09134(var1);
      }
   }

   public void method09153(String var1) {
      if (this.field20757 && var1 != null && this.method09140()) {
         if (var1.contains(field20773)) {
            this.field20767 = true;
         } else {
            long var2 = AuctionNumberParser.method05959(var1);
            if (var2 > 0L) {
               this.field20766 = var2;
            }
         }
      }
   }

   // $VF: Compiled from s
   private enum Nested253 {
      IDLE,
      CLOSING,
      SEARCHING,
      WAITING_SCREEN,
      SCANNING,
      COOLDOWN;
   }
}
