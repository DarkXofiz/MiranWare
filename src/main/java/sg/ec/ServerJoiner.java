// Original binary: sg/ec/Pck9DKi5u8E1aukU
package sg.ec;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import sg.mx.MinecraftMixin;

// $VF: Compiled from s
public class ServerJoiner extends ClientModule {
   private final ModeSetting field11011;
   private final NumberSetting<Integer> field11012;
   private static final String field11013 = "Выбор сервера";
   private static final int field11014 = 0;
   private static final int field11015 = 0;
   private static final long field11016 = 0;
   private static final long field11017 = 0;
   private static final long field11018 = 0;
   private static final long field11019 = 0;
   private static final long field11020 = 0;
   private volatile boolean field11021;
   private volatile boolean field11022;
   private volatile int field11023;
   private volatile int field11024;
   private volatile boolean field11025;
   private volatile int field11026;
   private volatile int field11027;
   private volatile Thread field11028;
   private volatile Notification field11029;
   private static final String field11030 = "Сервер";
   private static final String field11031 = "ReallyWorld";
   private static final String field11032 = "HolyWorld";
   private static final String field11033 = "ReallyWorld";
   private static final String field11034 = "Гриф";
   private static final String field11035 = "Server Joiner";
   private static final String field11036 = "Выбор сервера";
   private static final String field11037 = "ReallyWorld";
   private static final String field11038 = "ServerJoiner-Worker";
   private static final long field11039 = 400L;
   private static final long field11040 = 150L;
   private static final long field11041 = 150L;
   private static final long field11042 = 150L;
   private static final long field11043 = 250L;
   private static final String field11044 = "Онлайн";
   private static final long field11045 = 25L;
   private static final long field11046 = 3000L;
   private static final String field11047 = "Выбор мира грифа 1/3";
   private static final String field11048 = "Выбор мира грифа 2/3";
   private static final String field11049 = "Выбор мира грифа 3/3";
   private static final long field11050 = 2500L;
   private static final long field11051 = 3000L;
   private static final String field11052 = "ReallyWorld";

   @Override
   public void method00245() {
      this.method05023();
      super.method00245();
   }

   private void method05015(String var1) {
      Notification var2 = this.field11029;
      if (var2 != null) {
         mc.execute(() -> NotificationManager.method08600(var2, var1));
      }
   }

   private static int method05016(int var0) {
      if (var0 <= 32) {
         return 1;
      } else {
         return var0 <= 64 ? 2 : 3;
      }
   }

   private void method05019() {
      if (!this.field11022 && mc.player != null && this.field11011.method05600(field11037)) {
         int var1 = this.field11012.method03022();
         this.field11027 = var1;
         this.field11022 = true;
         this.field11021 = true;
         this.field11023 = 0;
         this.field11024 = 0;
         this.field11025 = false;
         this.field11026 = -1;
         this.field11029 = NotificationManager.method08596(Component.literal("Гриф " + var1 + " • запуск"), NotificationType.INFO);
         Thread var2 = new Thread(() -> this.method05039(var1), field11038);
         var2.setDaemon(false);
         this.field11028 = var2;
         var2.start();
      }
   }

   @Subscribe
   private void method05021(ScreenChangeEvent var1) {
      if (this.field11021) {
         if (var1.method03322() instanceof AbstractContainerScreen var3) {
            String var4 = var3.getTitle().getString();
            int var5 = this.method05032(var4);
            boolean var6 = var4.contains(field11036);
            if (var5 != 0 || var6) {
               this.field11026 = var3.getMenu().containerId;
               this.field11024 = var5;
               this.field11025 = var6;
               this.field11023++;
               var1.method05696();
            }
         }
      }
   }

   private void method05023() {
      this.field11022 = false;
      this.field11021 = false;
      Thread var1 = this.field11028;
      if (var1 != null) {
         var1.interrupt();
      }

      this.field11028 = null;
      NotificationManager.method08595(this.field11029);
      this.field11029 = null;
   }

   private Boolean method05024(Supplier<Boolean> var1) {
      CompletableFuture var2 = new CompletableFuture();
      mc.execute(() -> {
         try {
            var2.complete((Boolean)var1.get());
         } catch (Throwable var3) {
            var2.completeExceptionally(var3);
         }
      });

      try {
         return (Boolean)var2.get(field11046, TimeUnit.MILLISECONDS);
      } catch (Exception var4) {
         return Boolean.FALSE;
      }
   }

   private void method05026(boolean var1) {
      this.field11022 = false;
      this.field11021 = false;
      this.field11028 = null;
      Notification var2 = this.field11029;
      this.field11029 = null;
      int var3 = this.field11026;
      int var4 = this.field11027;
      mc.execute(() -> {
         NotificationManager.method08595(var2);
         if (!var1 && var3 != -1 && mc.player != null && mc.player.containerMenu.containerId == var3) {
            mc.player.closeContainer();
         }

         if (var1) {
            NotificationManager.method08612(Component.literal("Гриф " + var4 + " • готово"), NotificationType.INFO, field11050);
         }

         if (this.method03937()) {
            this.method00382();
         }
      });
   }

   private int method05027(int var1) {
      return method05016(var1);
   }

   @Override
   public void method00276() {
      super.method00276();
      this.method05019();
   }

   public ServerJoiner() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field11011 = new ModeSetting(field11030).method05597(field11031, field11032).method03017(field11033).method03023(this);
      this.field11012 = new NumberSetting<Integer>(field11034)
         .method10835(1)
         .method10838(80)
         .method10834(1)
         .method03017(1)
         .method03025(() -> this.field11011.method05600(field11052))
         .method03023(this);
      this.field11026 = -1;
      this.field11027 = 1;
      this.method03935(field11035);
   }

   private boolean method05031(int var1, int var2) {
      if (mc.player == null) {
         return false;
      }

      AbstractContainerMenu var3 = mc.player.containerMenu;
      if (var3 != null && var3.containerId == this.field11026) {
         Slot var4 = this.method05036(var1, var2, var3);
         if (var4 != null) {
            ItemStack var5 = var4.getItem();
            Component var6 = ServerJoinTextUtils.method08518(field11044, var5, true);
            MutableComponent var7 = Component.literal("Захожу на '" + var1 + "' гриф ").append(var6 != null ? var6 : var5.getHoverName());
            NotificationManager.method08617(this.field11029, var7);
            mc.gameMode.handleContainerInput(var3.containerId, var4.index, 0, ClickType.PICKUP, mc.player);
         }

         return false;
      } else {
         return true;
      }
   }

   private int method05032(String var1) {
      if (var1.contains(field11047)) {
         return 1;
      } else if (var1.contains(field11048)) {
         return 2;
      } else {
         return var1.contains(field11049) ? 3 : 0;
      }
   }

   private Slot method05036(int var1, int var2, AbstractContainerMenu var3) {
      if (mc.player == null) {
         return null;
      }

      for (Slot var5 : var3.slots) {
         if (var5.container != mc.player.getInventory() && var5.index != 44) {
            ItemStack var6 = var5.getItem();
            if (var6.getItem() == Items.PLAYER_HEAD) {
               int var7 = var2 == 3 ? var6.getCount() + 64 : var6.getCount();
               if (var7 == var1) {
                  return var5;
               }
            }
         }
      }

      return null;
   }

   private boolean method05037() {
      if (mc.player == null) {
         return false;
      }

      int var1 = InventoryUtils.method06111(Items.COMPASS, true);
      if (var1 == -1) {
         return false;
      }

      if (mc.player.getInventory().getSelectedSlot() != var1) {
         mc.player.getInventory().setSelectedSlot(var1);
         mc.player.connection.send(new ServerboundSetCarriedItemPacket(var1));
      }

      ((MinecraftMixin)(Object)mc).IdoItemUse();
      return true;
   }

   private boolean method05038(BooleanSupplier var1) throws InterruptedException {
      while (this.field11022 && mc.player != null) {
         if (var1.getAsBoolean()) {
            return true;
         }

         Thread.sleep(field11045);
      }

      return false;
   }

   private void method05039(int var1) {
      boolean var2 = false;

      try {
         try {
            int var3 = this.method05027(var1);
            this.method05015("Гриф " + var1 + " • открываю меню");

            while (this.field11022 && mc.player != null && this.field11023 == 0) {
               if (!Boolean.TRUE.equals(this.method05024(this::method05037))) {
                  this.method05024(() -> {
                     NotificationManager.method08612(Component.literal("Гриф " + var1 + " • компас не найден"), NotificationType.ERROR, field11051);
                     return Boolean.TRUE;
                  });
                  return;
               }

               Thread.sleep(field11039);
            }

            if (this.field11023 == 0) {
               return;
            }

            if (this.field11025) {
               this.method05015("Гриф " + var1 + " • выбор сервера");
               Thread.sleep(field11040);
               int var4 = this.field11023;
               this.method05024(() -> {
                  Slot var1x = InventoryUtils.method06136(Items.CRAFTING_TABLE);
                  int var2x = var1x.index;
                  return this.method05040(var2x);
               });
               if (!this.method05038(() -> this.field11023 > var4 && this.field11024 >= 1)) {
                  return;
               }
            }

            while (this.field11022 && mc.player != null && this.field11024 < var3) {
               this.method05015("Гриф " + var1 + " • страница " + this.field11024 + "/3");
               int var13 = this.field11024;
               int var5 = this.field11023;
               Thread.sleep(field11041);
               this.method05024(() -> this.method05040(44));
               if (!this.method05038(() -> this.field11023 > var5 && this.field11024 > var13)) {
                  return;
               }
            }

            if (this.field11022 && mc.player != null && this.field11024 == var3) {
               this.method05015("Гриф " + var1 + " • выбираю мир");
               Thread.sleep(field11042);

               while (this.field11022 && mc.player != null) {
                  if (Boolean.TRUE.equals(this.method05024(() -> this.method05031(var1, var3)))) {
                     var2 = true;
                     return;
                  }

                  Thread.sleep(field11043);
               }

               return;
            }

            return;
         } catch (InterruptedException var10) {
         } catch (Throwable var11) {
         }
      } finally {
         this.method05026(var2);
      }
   }

   private boolean method05040(int var1) {
      if (mc.player != null && mc.gameMode != null) {
         AbstractContainerMenu var2 = mc.player.containerMenu;
         if (var2 != null && var1 >= 0 && var1 < var2.slots.size()) {
            mc.gameMode.handleContainerInput(var2.containerId, var1, 0, ClickType.PICKUP, mc.player);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }
}
