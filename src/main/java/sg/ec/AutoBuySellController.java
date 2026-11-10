// Original binary: sg/ec/vbQ6kCYgB8YyEg4Z
package sg.ec;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;

// $VF: Compiled from s
public final class AutoBuySellController implements MinecraftAccess {
   private static final long field24685 = 65000L;
   private static final long field24686 = 0;
   private static final long field24687 = 0;
   private static final long field24688 = 0;
   private static final String field24689 = "field24689";
   private static final String field24690 = "field24690";
   private static final String field24691 = "field24691";
   private static final String field24692 = UnicodeTextNormalizer.method09496(AutoBuySellController.field24718);
   private AutoBuySellController.Nested317 field24693 = AutoBuySellController.Nested317.IDLE;
   private long field24694;
   private long field24695;
   private long field24696;
   private int field24697 = -1;
   private boolean field24698;
   private boolean field24699;
   private volatile long field24700;
   private static final long field24701 = 65000L;
   private static final long field24702 = 350L;
   private static final long field24703 = 4000L;
   private static final long field24704 = 350L;
   private static final String field24705 = "Хранилище";
   private static final long field24706 = 350L;
   private static final String field24707 = "Переход в хранилище не найден.";
   private static final long field24708 = 4000L;
   private static final long field24709 = 350L;
   private static final String field24710 = "Перевыставить";
   private static final String field24711 = "Кнопка перевыставления не найдена.";
   private static final long field24712 = 700L;
   private static final String field24713 = "AutoBuy";
   private static final String field24714 = "Лоты перевыставлены.";
   private static final String field24715 = "Вернуться";
   private static final long field24716 = 65000L;
   private static final String field24717 = "AutoBuy";
   private static final String field24718 = "раз в минуту";

   private void method11008(String var1) {
      if (!this.field24699) {
         this.field24699 = true;
         ChatTextUtils.method05101(field24717, var1);
      }
   }

   private void method11009(long var1) {
      AbstractContainerMenu var3 = AuctionContainerUtils.method02612();
      if (var3 != null && var3.containerId != this.field24697) {
         this.field24693 = AutoBuySellController.Nested317.CLICK_RELIST;
         this.field24695 = var1 + AutoBuyDelayUtils.method07071(field24709);
      } else {
         if (var1 >= this.field24696) {
            this.method11011(var1);
         }
      }
   }

   public void method11010(String var1) {
      if (var1 != null) {
         long var2 = AuctionNumberParser.method05959(var1);
         if (var2 <= 0L && UnicodeTextNormalizer.method09496(var1).contains(field24692)) {
            var2 = field24701;
         }

         if (var2 > 0L) {
            this.field24700 = Math.max(this.field24700, var2);
         }
      }
   }

   private void method11011(long var1) {
      this.method11012();
      long var3 = this.field24700;
      this.field24700 = 0L;
      this.field24694 = var1 + (var3 > 0L ? var3 : AutoBuyDelayUtils.method07071(field24716));
   }

   public void method11012() {
      this.field24693 = AutoBuySellController.Nested317.IDLE;
      this.field24697 = -1;
      this.field24698 = false;
   }

   private void method11013(long var1) {
      if (var1 >= this.field24695) {
         AbstractContainerMenu var3 = AuctionContainerUtils.method02612();
         int var4 = AuctionContainerUtils.method02622(var3, field24710);
         if (var4 >= 0) {
            AuctionContainerUtils.method02614(var3, var4, ContainerInput.PICKUP);
            this.field24699 = false;
         } else {
            this.method11008(field24711);
         }

         this.field24693 = AutoBuySellController.Nested317.RETURNING;
         this.field24695 = var1 + field24712;
      }
   }

   private void method11014(long var1) {
      if (AuctionContainerUtils.method02626()) {
         this.field24693 = AutoBuySellController.Nested317.CLICK_STORAGE;
         this.field24695 = var1 + AutoBuyDelayUtils.method07071(field24704);
      } else {
         if (var1 >= this.field24696) {
            this.method11011(var1);
         }
      }
   }

   private void method11015(long var1) {
      if (AuctionContainerUtils.method02626()) {
         this.field24693 = AutoBuySellController.Nested317.CLICK_STORAGE;
         this.field24695 = var1 + AutoBuyDelayUtils.method07071(field24702);
      } else if (var1 >= this.field24695) {
         AuctionCommandSender.field08741.method03893(AutoBuySettings.field19624.method08556());
         this.field24693 = AutoBuySellController.Nested317.WAIT_AUCTION;
         this.field24696 = var1 + field24703;
      }
   }

   private void method11016(long var1) {
      if (var1 >= this.field24695) {
         if (this.field24700 <= 0L) {
            ChatTextUtils.method05101(field24713, field24714);
         }

         AbstractContainerMenu var3 = AuctionContainerUtils.method02612();
         int var4 = AuctionContainerUtils.method02622(var3, field24715);
         if (var4 >= 0) {
            AuctionContainerUtils.method02614(var3, var4, ContainerInput.PICKUP);
         } else {
            AuctionContainerUtils.method02623();
         }

         this.method11011(var1);
      }
   }

   public boolean method11017() {
      return this.field24693 != AutoBuySellController.Nested317.IDLE;
   }

   public void method11018(long var1) {
      if (AutoBuySettings.field19624.method08549() && mc.player != null && mc.player.connection != null) {
         switch (this.field24693) {
            case IDLE:
               if (var1 >= this.field24694) {
                  this.field24693 = AutoBuySellController.Nested317.OPEN_AUCTION;
                  this.field24695 = var1;
               }
               break;
            case OPEN_AUCTION:
               this.method11015(var1);
               break;
            case WAIT_AUCTION:
               this.method11014(var1);
               break;
            case CLICK_STORAGE:
               this.method11019(var1);
               break;
            case WAIT_STORAGE:
               this.method11009(var1);
               break;
            case CLICK_RELIST:
               this.method11013(var1);
               break;
            case RETURNING:
               this.method11016(var1);
         }
      } else {
         this.method11012();
         this.field24694 = var1;
         this.field24699 = false;
      }
   }

   private void method11019(long var1) {
      if (var1 >= this.field24695) {
         AbstractContainerMenu var3 = AuctionContainerUtils.method02612();
         int var4 = AuctionContainerUtils.method02622(var3, field24705);
         if (var4 < 0) {
            if (!this.field24698) {
               this.field24698 = true;
               AuctionContainerUtils.method02623();
               this.field24693 = AutoBuySellController.Nested317.OPEN_AUCTION;
               this.field24695 = var1 + AutoBuyDelayUtils.method07071(field24706);
            } else {
               this.method11008(field24707);
               this.method11011(var1);
            }
         } else {
            this.field24697 = var3.containerId;
            AuctionContainerUtils.method02614(var3, var4, ContainerInput.PICKUP);
            this.field24693 = AutoBuySellController.Nested317.WAIT_STORAGE;
            this.field24696 = var1 + field24708;
         }
      }
   }

   // $VF: Compiled from s
   private enum Nested317 {
      IDLE,
      OPEN_AUCTION,
      WAIT_AUCTION,
      CLICK_STORAGE,
      WAIT_STORAGE,
      CLICK_RELIST,
      RETURNING;
   }
}
