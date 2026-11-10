// Original binary: sg/ec/PPxH31pIC6xm1Xtb
package sg.ec;

import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AuctionSellingController implements MinecraftAccess {
   private static final int field10976 = 35;
   private static final int field10977 = 0;
   private static final long field10978 = 0;
   private static final long field10979 = 0;
   private static final int field10980 = 0;
   private static final String field10981 = "field10981";
   private static final int field10982 = 0;
   private final Deque<AuctionSellingController.Nested149> field10983 = new ArrayDeque<>();
   private AuctionSellingController.Nested150 field10984 = AuctionSellingController.Nested150.IDLE;
   private AutoBuyItem field10985;
   private long field10986;
   private ItemStack field10987 = ItemStack.EMPTY;
   private int field10988 = -1;
   private int field10989 = -1;
   private long field10990;
   private long field10991;
   private int field10992;
   private boolean field10993;
   private volatile boolean field10994;
   private volatile boolean field10995;
   private volatile long field10996;
   private static final String field10997 = "выставлять товары на аукцион";
   private static final String field10998 = "AutoBuy";
   private static final String field10999 = "Слоты аукциона заняты, продажа ждёт освобождения.";
   private static final String field11000 = "AutoBuy";
   private static final String field11001 = "AutoBuy";
   private static final String field11002 = "Сервер не принимает команду продажи, лот пропущен.";
   private static final long field11003 = 250L;
   private static final long field11004 = 250L;
   private static final long field11005 = 250L;
   private static final long field11006 = 1200L;
   private static final long field11007 = 1200L;
   private static final String field11008 = "AutoBuy";
   private static final String field11009 = "AutoBuy";
   private static final double field11010 = 100.0;

   private void method04991(long var1) {
      if (var1 >= this.field10990) {
         String var3 = this.field10985.method10673();
         if (this.method05009(mc.player.getInventory().getItem(this.field10988))) {
            if (++this.field10992 < 4) {
               this.field10990 = var1 + field11007;
               this.field10984 = AuctionSellingController.Nested150.SEND_COMMAND;
               return;
            }

            ChatTextUtils.method05101(field11008, "Не удалось выставить: " + var3 + " за " + this.field10991 + "$.");
         } else {
            AuctionSaleHistory.field07563.method03359(this.field10987, var3, this.field10991, this.field10986, AutoBuyItemRegistry.INSTANCE.method10998());
            ChatTextUtils.method05101(field11009, "Выставлено: " + var3 + " за " + this.field10991 + "$.");
         }

         this.method05000();
         this.method05003();
      }
   }

   public void method04992(long var1) {
      if (mc.player == null || mc.player.connection == null) {
         this.method05003();
      } else if (!AutoBuySettings.field19624.method08557()) {
         this.method04993();
      } else {
         if (this.field10995) {
            this.field10995 = false;
            this.method05007();
         }

         if (this.field10994) {
            this.field10994 = false;
            this.method04997();
         } else if (!this.field10993) {
            if (this.field10984 == AuctionSellingController.Nested150.IDLE) {
               if (this.field10983.isEmpty()) {
                  this.field10996 = 0L;
                  return;
               }

               this.method05001(this.field10983.pollFirst());
            }

            if (this.method05012(var1)) {
               this.method05011(var1);
            }
         }
      }
   }

   public void method04993() {
      this.field10983.clear();
      this.method05003();
      this.field10993 = false;
      this.field10994 = false;
      this.field10995 = false;
      this.field10996 = 0L;
   }

   private static boolean method04994(int var0) {
      return var0 >= 0 && var0 < 9;
   }

   private void method04995(long var1) {
      if (var1 >= this.field10990) {
         ItemStack var3 = mc.player.getInventory().getItem(this.field10988);
         if (!this.method05009(var3)) {
            this.method05003();
         } else {
            this.field10991 = method04999(this.field10985, var3.getCount());
            this.field10987 = var3.copy();
            AuctionCommandSender.field08741.method03893(AutoBuySettings.field19624.method08556() + " sell " + this.field10991);
            this.field10990 = var1 + field11006;
            this.field10984 = AuctionSellingController.Nested150.WAIT_LISTED;
         }
      }
   }

   private void method04996(long var1) {
      if (AuctionContainerUtils.method02624()) {
         AuctionContainerUtils.method02623();
         this.field10990 = var1 + field11003;
      } else {
         if (var1 >= this.field10990) {
            this.field10984 = AuctionSellingController.Nested150.PREPARE_SLOT;
         }
      }
   }

   private void method04997() {
      if (this.field10985 != null) {
         this.field10983.addFirst(new AuctionSellingController.Nested149(this.field10985, this.field10986));
      }

      this.method05000();
      this.method05003();
      if (!this.field10993) {
         this.field10993 = true;
         ChatTextUtils.method05101(field10998, field10999);
      }
   }

   private void method04998(long var1) {
      if (method04994(this.field10988) && this.method05009(mc.player.getInventory().getItem(this.field10988))) {
         if (mc.player.getInventory().getSelectedSlot() != this.field10988) {
            mc.player.getInventory().setSelectedSlot(this.field10988);
            mc.player.connection.send(new ServerboundSetCarriedItemPacket(this.field10988));
         }

         this.field10990 = var1 + AutoBuyDelayUtils.method07071(field11005);
         this.field10984 = AuctionSellingController.Nested150.SEND_COMMAND;
      } else {
         this.method05003();
      }
   }

   public static long method04999(AutoBuyItem var0, int var1) {
      double var2 = 1.0 + Math.max(0.0F, AutoBuySettings.field19624.method08565()) / field11010;
      long var4 = Math.max(1L, Math.round(var0.method10682() * var2));
      return Math.max(1L, var4 * Math.max(1, var1));
   }

   private void method05000() {
      if (method04994(this.field10989) && mc.player.getInventory().getSelectedSlot() != this.field10989) {
         mc.player.getInventory().setSelectedSlot(this.field10989);
         mc.player.connection.send(new ServerboundSetCarriedItemPacket(this.field10989));
      }
   }

   private void method05001(AuctionSellingController.Nested149 var1) {
      this.field10985 = var1.entry();
      this.field10986 = var1.paidPrice();
      this.field10992 = 0;
      this.field10988 = -1;
      this.field10989 = mc.player.getInventory().getSelectedSlot();
      this.field10984 = AuctionSellingController.Nested150.CLOSE_SCREEN;
   }

   public void method05002(String var1) {
      if (var1 != null) {
         if (var1.contains(field10997)) {
            this.field10994 = true;
         } else if (AuctionSaleParser.method04759(var1)) {
            this.field10995 = true;
         } else {
            long var2 = AuctionNumberParser.method05959(var1);
            if (var2 > 0L) {
               this.field10996 = var2;
            }
         }
      }
   }

   private void method05003() {
      this.field10985 = null;
      this.field10986 = 0L;
      this.field10987 = ItemStack.EMPTY;
      this.field10988 = -1;
      this.field10989 = -1;
      this.field10990 = 0L;
      this.field10991 = 0L;
      this.field10992 = 0;
      this.field10984 = AuctionSellingController.Nested150.IDLE;
   }

   private void method05004(long var1, AuctionSellingController.Nested150 var3) {
      if (var1 >= this.field10990) {
         this.field10984 = var3;
      }
   }

   private int method05005() {
      Inventory var1 = mc.player.getInventory();

      for (int var2 = 0; var2 <= 35; var2++) {
         if (this.method05009(var1.getItem(var2))) {
            return var2;
         }
      }

      return -1;
   }

   private static int method05006(int var0) {
      return method04994(var0) ? 36 + var0 : var0;
   }

   private void method05007() {
      if (this.field10993) {
         this.field10993 = false;
         ChatTextUtils.method05101(field11000, "Слот освободился, продолжаю выставлять (" + this.field10983.size() + " в очереди).");
      }
   }

   public boolean method05008() {
      return this.field10984 != AuctionSellingController.Nested150.IDLE;
   }

   private boolean method05009(ItemStack var1) {
      return this.field10985 != null && var1 != null && !var1.isEmpty() && this.field10985.method10682() > 0 && this.field10985.method10721(var1);
   }

   public void method05010(AutoBuyItem var1, long var2) {
      if (var1 != null && AutoBuySettings.field19624.method08557() && this.field10983.size() < 32) {
         this.field10983.addLast(new AuctionSellingController.Nested149(var1, Math.max(0L, var2)));
      }
   }

   private void method05011(long var1) {
      switch (this.field10984) {
         case CLOSE_SCREEN:
            this.method04996(var1);
            break;
         case PREPARE_SLOT:
            this.method05014(var1);
            break;
         case WAIT_SWAP:
            this.method05004(var1, AuctionSellingController.Nested150.SELECT_SLOT);
            break;
         case SELECT_SLOT:
            this.method04998(var1);
            break;
         case SEND_COMMAND:
            this.method04995(var1);
            break;
         case WAIT_LISTED:
            this.method04991(var1);
      }
   }

   private boolean method05012(long var1) {
      long var3 = this.field10996;
      if (var3 <= 0L) {
         return true;
      } else {
         this.field10996 = 0L;
         if (this.field10984 != AuctionSellingController.Nested150.WAIT_LISTED) {
            return true;
         } else if (++this.field10992 >= 4) {
            ChatTextUtils.method05101(field11001, field11002);
            this.method05000();
            this.method05003();
            return false;
         } else {
            this.field10990 = var1 + var3;
            this.field10984 = AuctionSellingController.Nested150.SEND_COMMAND;
            return false;
         }
      }
   }

   public int method05013() {
      return this.field10983.size();
   }

   private void method05014(long var1) {
      int var3 = this.method05005();
      if (var3 < 0) {
         this.method05003();
      } else if (method04994(var3)) {
         this.field10988 = var3;
         this.field10984 = AuctionSellingController.Nested150.SELECT_SLOT;
      } else {
         AbstractContainerMenu var4 = mc.player.containerMenu;
         if (var4 != null && mc.gameMode != null) {
            this.field10988 = this.field10989;
            mc.gameMode.handleInventoryMouseClick(var4.containerId, method05006(var3), this.field10988, ClickType.SWAP, mc.player);
            this.field10990 = var1 + field11004;
            this.field10984 = AuctionSellingController.Nested150.WAIT_SWAP;
         } else {
            this.method05003();
         }
      }
   }

   // $VF: Compiled from s
   private record Nested149(AutoBuyItem entry, long paidPrice) {
   }

   // $VF: Compiled from s
   private enum Nested150 {
      IDLE,
      CLOSE_SCREEN,
      PREPARE_SLOT,
      WAIT_SWAP,
      SELECT_SLOT,
      SEND_COMMAND,
      WAIT_LISTED;
   }
}
