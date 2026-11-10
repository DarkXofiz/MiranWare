// Original binary: sg/ec/s84dd5gnS4vdMrrv
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public enum DelayedInventoryActionManager implements MinecraftAccess, InventoryActionController {
   INSTANCE;

   private static final int field23590 = 3;
   private static final int field23591 = 0;
   private static final int field23592 = 0;
   private final ConcurrentLinkedDeque<DelayedInventoryActionManager.Nested310> field23593 = new ConcurrentLinkedDeque<>();
   private int field23594;

   public void method10615() {
      EventBus.method00263(this);
   }

   public void method10616(int var1) {
      if (var1 > this.field23594) {
         this.field23594 = var1;
      }
   }

   @Subscribe
   @Override
   public void method09010(PlayerUpdateEvent var1) {
      if (mc.player == null || mc.level == null) {
         this.method09009();
         this.method10634();
         this.field23594 = 0;
      } else if (this.field23594 > 0) {
         this.field23594--;
      } else {
         this.method10627();
      }
   }

   public boolean method10617() {
      return this.field23593.isEmpty() && !InventoryActionManager.INSTANCE.method10476();
   }

   @Override
   public void method09003(Item var1) {
      this.method09002(InteractionHand.MAIN_HAND, var1);
   }

   @Override
   public void method09008(Slot var1) {
      this.method09011(InteractionHand.MAIN_HAND, var1);
   }

   @Override
   public void method09002(InteractionHand var1, Item var2) {
      if (mc.player != null && mc.level != null) {
         this.method09004(var1, var2, Float.MAX_VALUE, Float.MAX_VALUE);
      }
   }

   @Override
   public void method09011(InteractionHand var1, Slot var2) {
      if (mc.player != null && mc.level != null) {
         this.method09004(var1, var2, Float.MAX_VALUE, Float.MAX_VALUE);
      }
   }

   @Override
   public void method09006(Item var1, float var2, float var3) {
      this.method09004(InteractionHand.MAIN_HAND, var1, var2, var3);
   }

   @Override
   public void method09005(Slot var1, float var2, float var3) {
      this.method09004(InteractionHand.MAIN_HAND, var1, var2, var3);
   }

   @Override
   public void method09004(InteractionHand var1, Object var2, float var3, float var4) {
      if (mc.player != null && mc.level != null && mc.gameMode != null) {
         if (var2 != null) {
            if (this.field23593.size() < 16) {
               if (this.method10619(var2) != Items.FIREWORK_ROCKET || this.method10620(Items.FIREWORK_ROCKET) < 2) {
                  this.field23593.offerLast(new DelayedInventoryActionManager.Nested310(var1, var2, var3, var4));
                  if (this.field23594 == 0) {
                     this.method10627();
                  }
               }
            }
         }
      }
   }

   public void method10618(Item var1, float var2, float var3) {
      if (mc.player != null && mc.gameMode != null) {
         if (!InventoryUtils.method06086(var1)) {
            if (mc.player.getMainHandItem().getItem() == var1) {
               InventoryActionManager.INSTANCE.method10475(() -> InventoryUtils.method06110(InteractionHand.MAIN_HAND, var2, var3), 0, false).method07555(true);
            } else {
               int var4 = mc.player.getInventory().getSelectedSlot();
               int var5 = InventoryUtils.method06111(var1, true);
               if (var5 != -1) {
                  InventoryActionManager.INSTANCE.method10475(() -> {
                     if (var4 != var5) {
                        mc.player.connection.send(new ServerboundSetCarriedItemPacket(var5));
                     }

                     InventoryUtils.method06110(InteractionHand.MAIN_HAND, var2, var3);
                     if (var4 != var5) {
                        mc.player.connection.send(new ServerboundSetCarriedItemPacket(var4));
                     }
                  }, 0, false);
               } else {
                  int var6 = InventoryUtils.method06111(var1, false);
                  if (var6 == -1) {
                     this.method10622(InteractionHand.MAIN_HAND, var1, var2, var3);
                  } else {
                     int var7 = mc.player.containerMenu.containerId;
                     InventoryActionManager.INSTANCE.method10470(() -> {
                        mc.gameMode.handleContainerInput(var7, var6, var4, ClickType.SWAP, mc.player);
                        InventoryUtils.method06110(InteractionHand.MAIN_HAND, var2, var3);
                        mc.gameMode.handleContainerInput(var7, var6, var4, ClickType.SWAP, mc.player);
                     }, 1, true);
                  }
               }
            }
         }
      }
   }

   private Item method10619(Object var1) {
      if (var1 instanceof Item var3) {
         return var3;
      } else {
         return var1 instanceof Slot var2 ? var2.getItem().getItem() : null;
      }
   }

   private int method10620(Item var1) {
      int var2 = 0;

      for (DelayedInventoryActionManager.Nested310 var4 : this.field23593) {
         if (this.method10619(var4.target()) == var1) {
            var2++;
         }
      }

      return var2;
   }

   private void method10621(InteractionHand var1, Object var2, float var3, float var4) {
      if (mc.player != null) {
         Slot var7 = null;
         Item var5;
         ItemStack var6;
         if (var2 instanceof Item var9) {
            var5 = var9;
            var6 = InventoryUtils.method06103(var9);
         } else {
            if (!(var2 instanceof Slot var8)) {
               return;
            }

            var7 = var8;
            var6 = var8.getItem();
            if (var6 == null || var6.isEmpty()) {
               return;
            }

            var5 = var6.getItem();
         }

         if (var5 != Items.AIR) {
            if (var5 == Items.FIREWORK_ROCKET || var6.isEmpty() || !mc.player.getCooldowns().isOnCooldown(var6)) {
               Item var16 = var1 == InteractionHand.OFF_HAND ? mc.player.getOffhandItem().getItem() : mc.player.getMainHandItem().getItem();
               if (var7 != null && var7.container == mc.player.getInventory()) {
                  this.method10623(var7, var1, var3, var4);
               } else if (var16 == var5) {
                  if (InventoryUtils.method06110(var1, var3, var4)) {
                     mc.player.swing(var1, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
                  }
               } else {
                  boolean var10 = var1 == InteractionHand.OFF_HAND;
                  int var11 = InventoryUtils.method06111(var5, false);
                  int var12 = InventoryUtils.method06111(var5, true);
                  if (var12 == -1 && var11 == -1) {
                     this.method10622(var1, var5, var3, var4);
                  } else {
                     int var13 = mc.player.getInventory().getSelectedSlot();
                     int var14 = var10 ? 40 : var13;
                     int var15 = mc.player.containerMenu.containerId;
                     if (var12 == -1) {
                        this.method10625(var15, var11, var14, var1, var3, var4);
                     } else if (var10) {
                        this.method10624(var15, var12, var14, var1, var3, var4);
                     } else {
                        this.method10626(var12, var13, var1, var3, var4);
                     }
                  }
               }
            }
         }
      }
   }

   private void method10622(InteractionHand var1, Item var2, float var3, float var4) {
      boolean var5 = ServerItemActionUtils.method05481(var2, () -> {
         if (InventoryUtils.method06111(var2, true) != -1 || InventoryUtils.method06111(var2, false) != -1) {
            this.method09004(var1, var2, var3, var4);
         }
      });
      if (!var5) {
         ServerItemActionUtils.method05473(var2, var1, var3, var4);
      }
   }

   private void method10623(Slot var1, InteractionHand var2, float var3, float var4) {
      if (mc.player != null) {
         int var5 = var1.getContainerSlot();
         int var6 = mc.player.getInventory().getSelectedSlot();
         int var7 = var2 == InteractionHand.OFF_HAND ? 40 : var6;
         int var8 = mc.player.containerMenu.containerId;
         if (var5 >= 0 && var5 < 9) {
            if (var2 == InteractionHand.OFF_HAND) {
               this.method10625(var8, var1.index, var7, var2, var3, var4);
            } else {
               this.method10626(var5, var6, var2, var3, var4);
            }
         } else {
            if (var5 >= 9 && var5 < 36) {
               this.method10625(var8, var1.index, var7, var2, var3, var4);
            }
         }
      }
   }

   private void method10624(int var1, int var2, int var3, InteractionHand var4, float var5, float var6) {
      int var7 = var2 + 36;
      this.method10625(var1, var7, var3, var4, var5, var6);
   }

   private void method10625(int var1, int var2, int var3, InteractionHand var4, float var5, float var6) {
      InventoryActionManager.INSTANCE
         .method10470(() -> mc.gameMode.handleContainerInput(var1, var2, var3, ClickType.SWAP, mc.player), 1, true)
         .method07542(1, false)
         .method07536(() -> {
            InteractionResult var3x = InventoryUtils.method06128(var4, var5, var6);
            mc.player.swing(var4, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
         }, 1, false)
         .method07542(1, false)
         .method07534(() -> mc.gameMode.handleContainerInput(var1, var2, var3, ClickType.SWAP, mc.player), 1, true)
         .method07555(false);
   }

   private void method10626(int var1, int var2, InteractionHand var3, float var4, float var5) {
      InventoryActionManager.INSTANCE.method10475(() -> {
         if (var2 != var1) {
            mc.player.connection.send(new ServerboundSetCarriedItemPacket(var1));
         }
      }, 0, false).method07545().method07536(() -> InventoryUtils.method06110(var3, var4, var5), 0, false).method07545().method07536(() -> {
         if (var2 != var1) {
            mc.player.connection.send(new ServerboundSetCarriedItemPacket(var2));
         }
      }, 0, false);
   }

   @Override
   public InventoryActionSequence method09007(int var1, int var2) {
      if (mc.player == null || mc.level == null || mc.gameMode == null) {
         return null;
      }

      if (var1 == var2 || var1 == -1 || var2 == -1) {
         return null;
      }

      if (InventoryActionManager.INSTANCE.method10476()) {
         return null;
      }

      int var3 = mc.player.containerMenu.containerId;
      int var4 = mc.player.getInventory().getSelectedSlot() % 8 + 1;
      return var1 >= 36 && var1 < 45
         ? InventoryActionManager.INSTANCE.method10469(() -> mc.gameMode.handleContainerInput(var3, var2, var1 - 36, ClickType.SWAP, mc.player))
         : InventoryActionManager.INSTANCE
            .method10469(() -> mc.gameMode.handleContainerInput(var3, var1, var4, ClickType.SWAP, mc.player))
            .method07545()
            .method07556(() -> mc.gameMode.handleContainerInput(var3, var2, var4, ClickType.SWAP, mc.player))
            .method07545()
            .method07556(() -> mc.gameMode.handleContainerInput(var3, var1, var4, ClickType.SWAP, mc.player));
   }

   private void method10627() {
      if (mc.gameMode != null) {
         if (!InventoryActionManager.INSTANCE.method10476()) {
            DelayedInventoryActionManager.Nested310 var1 = this.field23593.peekFirst();
            if (var1 != null) {
               if (!this.method10628(var1)) {
                  DelayedInventoryActionManager.Nested310 var4 = this.field23593.pollFirst();
                  if (var4 != null) {
                     this.method10621(var4.hand(), var4.target(), var4.yaw(), var4.pitch());
                  }
               } else {
                  ArrayList var2 = new ArrayList();

                  while (var2.size() < 3) {
                     DelayedInventoryActionManager.Nested310 var3 = this.field23593.peekFirst();
                     if (var3 == null || !this.method10628(var3)) {
                        break;
                     }

                     this.field23593.pollFirst();
                     var2.add(var3);
                  }

                  if (var2.size() == 1) {
                     DelayedInventoryActionManager.Nested310 var5 = (DelayedInventoryActionManager.Nested310)var2.get(0);
                     this.method10621(var5.hand(), var5.target(), var5.yaw(), var5.pitch());
                  } else if (!var2.isEmpty()) {
                     this.method10629(var2);
                  }
               }
            }
         }
      }
   }

   private boolean method10628(DelayedInventoryActionManager.Nested310 var1) {
      return var1.hand() == InteractionHand.MAIN_HAND && var1.target() instanceof Item;
   }

   private void method10629(List<DelayedInventoryActionManager.Nested310> var1) {
      int var2 = mc.player.containerMenu.containerId;
      int var3 = mc.player.getInventory().getSelectedSlot();
      boolean[] var4 = new boolean[9];
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();

      for (DelayedInventoryActionManager.Nested310 var8 : var1) {
         Item var9 = (Item)var8.target();
         int var10 = InventoryUtils.method06111(var9, true);
         if (var10 != -1) {
            var4[var10] = true;
            var6.add(new DelayedInventoryActionManager.Nested311(var10, var8.yaw(), var8.pitch()));
         } else {
            int var11 = InventoryUtils.method06111(var9, false);
            if (var11 != -1) {
               int var12 = this.method10631(var5, var11);
               if (var12 != -1) {
                  var6.add(new DelayedInventoryActionManager.Nested311(var12, var8.yaw(), var8.pitch()));
               } else {
                  int var13 = method10632(var4, var3);
                  if (var13 != -1) {
                     var4[var13] = true;
                     var5.add(new int[]{var11, var13});
                     var6.add(new DelayedInventoryActionManager.Nested311(var13, var8.yaw(), var8.pitch()));
                  }
               }
            }
         }
      }

      if (!var6.isEmpty()) {
         int[] var14 = new int[]{var3};
         int var15 = var5.isEmpty() ? 0 : 1;
         InventoryActionManager.INSTANCE.method10470(() -> this.method10630(var2, var5), var15, !var5.isEmpty()).method07545().method07536(() -> {
            for (DelayedInventoryActionManager.Nested311 var5x : (Iterable<DelayedInventoryActionManager.Nested311>) (Iterable) var6) {
               this.method10633(var14, var5x.hotbarSlot());
               InteractionResult var6x = InventoryUtils.method06128(InteractionHand.MAIN_HAND, var5x.yaw(), var5x.pitch());
               if (var6x == InteractionResult.SUCCESS) {
                  mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
               }
            }

            this.method10633(var14, var3);
         }, var15, false).method07545().method07534(() -> this.method10630(var2, var5), var15, !var5.isEmpty());
      }
   }

   private void method10630(int var1, List<int[]> var2) {
      if (mc.player != null && mc.gameMode != null) {
         if (!var2.isEmpty()) {
            for (int[] var4 : var2) {
               mc.gameMode.handleContainerInput(var1, var4[0], var4[1], ClickType.SWAP, mc.player);
            }
         }
      }
   }

   private int method10631(List<int[]> var1, int var2) {
      for (int[] var4 : var1) {
         if (var4[0] == var2) {
            return var4[1];
         }
      }

      return -1;
   }

   private static int method10632(boolean[] var0, int var1) {
      if (var1 >= 0 && var1 < 9 && !var0[var1]) {
         return var1;
      }

      for (int var2 = 1; var2 < 9; var2++) {
         int var3 = var1 + var2;
         if (var3 < 9 && !var0[var3]) {
            return var3;
         }

         int var4 = var1 - var2;
         if (var4 >= 0 && !var0[var4]) {
            return var4;
         }
      }

      return -1;
   }

   private void method10633(int[] var1, int var2) {
      if (mc.player != null) {
         if (var2 >= 0 && var2 <= 8 && var1[0] != var2) {
            mc.player.connection.send(new ServerboundSetCarriedItemPacket(var2));
            var1[0] = var2;
         }
      }
   }

   private void method10634() {
      this.field23593.clear();
   }

   @Override
   public void method09009() {
      InventoryActionManager.INSTANCE.method10478();
   }

   public ConcurrentLinkedDeque<DelayedInventoryActionManager.Nested310> method10635() {
      return this.field23593;
   }

   public int method10636() {
      return this.field23594;
   }

   // $VF: Compiled from s
   private record Nested310(InteractionHand hand, Object target, float yaw, float pitch) {
   }

   // $VF: Compiled from s
   private record Nested311(int hotbarSlot, float yaw, float pitch) {
   }
}
