// Original binary: sg/ec/rlluSJPK0KGXr2In
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import net.minecraft.core.NonNullList;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import sg.mx.ClientboundContainerSetContentPacketMixin;
import sg.mx.ClientboundContainerSetSlotPacketMixin;

// $VF: Compiled from s
public enum InventoryActionManager implements MinecraftAccess {
   INSTANCE;

   private static final long field23441 = 1500L;
   private static final long field23442 = 0;
   private static final int field23443 = 0;
   private static final int field23444 = 0;
   private static final int field23445 = 0;
   private final ConcurrentLinkedDeque<InventoryActionSequence> field23446 = new ConcurrentLinkedDeque<>();
   private final ConcurrentLinkedDeque<Runnable> field23447 = new ConcurrentLinkedDeque<>();
   private InventoryActionSequence field23448;
   private int field23449;
   private int field23450;
   private boolean field23451;
   private ItemStack[] field23452;
   private long[] field23453;
   private long field23454;
   private int field23455;
   private ItemStack[] field23456;
   private long[] field23457;
   private long field23458;
   private int field23459;
   private ItemStack[] field23460;
   private ItemStack[] field23461;
   private int field23462;
   private volatile Connection field23463;
   private volatile boolean field23464;
   private volatile int field23465;
   private InventoryActionSequence field23466;
   private InventoryActionSequence field23467;
   private InventoryActionSequence field23468;
   private ItemStack[] field23469;
   private ItemStack[] field23470;
   private ItemStack field23471;
   private ItemStack field23472;
   private int field23473;
   private int field23474;
   private int field23475;
   private int field23476;
   private long field23477;

   public void method10468() {
      EventBus.method00263(this);
   }

   public InventoryActionSequence method10469(Runnable var1) {
      return this.method10470(var1, 1, true);
   }

   public InventoryActionSequence method10470(Runnable var1, int var2, boolean var3) {
      InventoryActionSequence var4 = new InventoryActionSequence();
      this.field23446.add(var4);
      return var4.method07534(var1, var2, var3);
   }

   public InventoryActionSequence method10471(Runnable var1, int var2, boolean var3) {
      InventoryActionSequence var4 = new InventoryActionSequence();
      this.field23446.offerFirst(var4);
      return var4.method07534(var1, var2, var3);
   }

   public InventoryActionSequence method10472(Runnable var1, int var2, boolean var3) {
      InventoryActionSequence var4 = new InventoryActionSequence();
      var4.method07534(var1, var2, var3);
      this.method10473(var4);
      return var4;
   }

   private void method10473(InventoryActionSequence var1) {
      if (this.field23448 != null && (this.field23448.method07549() || this.field23448 == this.field23466)) {
         if (!this.field23448.method07553()) {
            this.method10497();
         }

         if (this.field23448.method07549()) {
            this.field23446.offerFirst(this.field23448);
         }

         this.field23448 = null;
      }

      this.field23449 = 0;
      this.field23450 = 0;
      this.field23451 = false;
      this.field23452 = null;
      this.field23446.offerFirst(var1);
   }

   public InventoryActionSequence method10474(Runnable var1) {
      return this.method10475(var1, 1, false);
   }

   public InventoryActionSequence method10475(Runnable var1, int var2, boolean var3) {
      InventoryActionSequence var4 = new InventoryActionSequence();
      this.field23446.add(var4);
      return var4.method07536(var1, var2, var3);
   }

   public boolean method10476() {
      return this.field23448 != null || this.field23469 != null || !this.field23446.isEmpty() || !this.field23447.isEmpty();
   }

   public void method10477(Runnable var1) {
      this.field23447.add(var1);
   }

   public void method10478() {
      this.field23446.clear();
      this.field23447.clear();
      this.field23448 = null;
      this.field23449 = 0;
      this.field23450 = 0;
      this.field23451 = false;
      this.field23468 = null;
      this.field23452 = null;
      this.field23453 = null;
      this.field23454 = 0L;
      this.field23456 = null;
      this.field23457 = null;
      this.field23458 = 0L;
      this.field23460 = null;
      this.field23461 = null;
      this.method10509();
   }

   @Subscribe(4)
   private void method10479(TickEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (false) {
            ;
         }

         this.method10487();
         boolean var2 = this.field23449 > 0;
         if (this.field23449 > 0) {
            this.field23449--;
         }

         this.field23468 = null;
         if (this.field23469 != null) {
            this.method10505();
         }

         if (this.field23451) {
            this.field23451 = false;
            this.method10499();
         } else {
            if (this.field23448 == null) {
               this.field23448 = this.field23446.poll();
               if (this.field23448 == null) {
                  return;
               }

               if (!this.field23448.method07553()) {
                  this.method10496();
               }
            }

            if (this.field23448 != this.field23466) {
               if (this.field23450 > 0) {
                  this.field23450--;
                  if (this.field23450 > 0) {
                     return;
                  }
               }

               int var3 = this.field23448.method07540();
               if (var3 > 0 && !var2 && !this.field23448.method07551()) {
                  this.field23449 = var3;
                  if (this.field23448.method07552()) {
                     this.field23468 = this.field23448;
                  }
               } else {
                  if (var3 > this.field23449) {
                     this.field23449 = var3;
                  }

                  if (this.field23448.method07551()) {
                     this.method10499();
                  } else {
                     this.field23451 = true;
                  }
               }
            }
         }
      } else {
         this.method10478();
      }
   }

   @Subscribe(4)
   private void method10480(PostTickEvent var1) {
      Runnable var2;
      while ((var2 = this.field23447.poll()) != null) {
         var2.run();
      }
   }

   @Subscribe(4)
   private void method10481(PreMovementPacketEvent var1) {
      InventoryActionSequence var2 = this.field23468;
      if (var2 != null) {
         this.field23468 = null;
         if (var2 == this.field23448 && mc.player != null) {
            this.method10499();
         }
      }
   }

   @Subscribe(4)
   private void method10482(PlayerInputEvent var1) {
      if (this.field23449 > 0) {
         var1.method11159();
         if (this.field23451) {
            this.field23451 = false;
            this.method10499();
         }
      }
   }

   @Subscribe(4)
   private void method10483(PacketEvent var1) {
      if (var1.method10904()) {
         this.method10484(var1);
         if (mc.player != null) {
            boolean var2 = this.field23448 != null && !this.field23448.method07553() && this.field23452 != null;
            if (var2 || this.field23460 != null || this.method10489() || this.method10490()) {
               int var3 = mc.player.containerMenu.containerId;
               long var4 = System.currentTimeMillis();
               NonNullList<Slot> var6 = mc.player.containerMenu.slots;
               if (var1.method10897() instanceof ClientboundContainerSetSlotPacket var7) {
                  if (var7.getContainerId() != var3) {
                     return;
                  }

                  ItemStack var14 = this.method10485(var7.getSlot(), var7.getItem(), var2, var4, var3, var6, false);
                  if (var14 == null) {
                     return;
                  }

                  ((ClientboundContainerSetSlotPacketMixin)(Object)var7).setItem(var14);
               } else if (var1.method10897() instanceof ClientboundContainerSetContentPacket var8) {
                  if (var8.containerId() != var3) {
                     return;
                  }

                  var var16 = var8.items();
                  var var10 = new ArrayList(var16.size());
                  int var11 = 0;

                  for (int var12 = 0; var12 < var16.size(); var12++) {
                     ItemStack var13 = this.method10485(var12, (ItemStack)var16.get(var12), var2, var4, var3, var6, true);
                     if (var13 == null) {
                        var10.add((ItemStack)var16.get(var12));
                     } else {
                        var10.add(var13);
                        var11++;
                     }
                  }

                  if (var11 == 0) {
                     return;
                  }

                  ((ClientboundContainerSetContentPacketMixin)(Object)var8).setItems(var10);
               }
            }
         }
      }
   }

   private void method10484(PacketEvent var1) {
      int var2;
      if (var1.method10897() instanceof ClientboundContainerSetContentPacket var4 && var4.containerId() == 0) {
         this.field23465++;
         var2 = var4.stateId();
      } else {
         if (!(var1.method10897() instanceof ClientboundContainerSetSlotPacket var3) || var3.getContainerId() != 0) {
            return;
         }

         var2 = var3.getStateId();
      }

      this.field23463 = var1.method10901();
      this.field23464 = var2 != 0;
      if (false) {
         var1.method10897();
      }
   }

   private ItemStack method10485(int var1, ItemStack var2, boolean var3, long var4, int var6, List<Slot> var7, boolean var8) {
      if (var1 < 0) {
         return null;
      }

      ItemStack var9 = null;
      boolean var10 = false;
      if (this.field23452 != null && var6 == this.field23455 && var1 < this.field23452.length && this.method10491(var1, var2, var3, var4, var7)) {
         var9 = this.field23452[var1];
      } else if (var8 && this.field23456 != null && var6 == this.field23459 && var1 < this.field23456.length && this.method10492(var1, var2, var4, var7)) {
         var9 = this.field23456[var1];
         var10 = true;
      }

      if (var9 != null && false) {
         ;
      }

      this.method10486(var1, !var3 && !var10 && var9 != null && !ItemStack.matches(var2, var9) ? var2.copy() : null, var9, var6, var7);
      return var9 == null ? null : var9.copy();
   }

   private void method10486(int var1, ItemStack var2, ItemStack var3, int var4, List<Slot> var5) {
      if (var2 == null) {
         if (this.field23460 != null && this.field23462 == var4 && var1 < this.field23460.length) {
            this.field23460[var1] = null;
         }
      } else {
         if (this.field23460 == null || this.field23460.length != var5.size() || this.field23462 != var4) {
            this.field23460 = new ItemStack[var5.size()];
            this.field23461 = new ItemStack[var5.size()];
            this.field23462 = var4;
         }

         this.field23460[var1] = var2;
         this.field23461[var1] = var3;
      }
   }

   private void method10487() {
      if (this.field23460 != null) {
         if (this.field23448 == null || this.field23448.method07553()) {
            int var1 = mc.player.containerMenu.containerId;
            if (var1 != this.field23462) {
               this.field23460 = null;
               this.field23461 = null;
            } else {
               NonNullList<Slot> var2 = mc.player.containerMenu.slots;
               long var3 = System.currentTimeMillis();
               boolean var5 = false;

               for (int var6 = 0; var6 < this.field23460.length && var6 < var2.size(); var6++) {
                  ItemStack var7 = this.field23460[var6];
                  if (var7 != null) {
                     if (!this.method10488(var6, var3, var1)) {
                        var5 = true;
                     } else {
                        this.field23460[var6] = null;
                        if (ItemStack.matches(((Slot)var2.get(var6)).getItem(), this.field23461[var6])) {
                           ((Slot)var2.get(var6)).set(var7);
                        }
                     }
                  }
               }

               if (!var5) {
                  this.field23460 = null;
                  this.field23461 = null;
               }
            }
         }
      }
   }

   private boolean method10488(int var1, long var2, int var4) {
      return this.field23452 != null && this.field23455 == var4 && this.field23453 != null && var1 < this.field23453.length && var2 <= this.field23453[var1]
         ? false
         : this.field23456 == null || this.field23459 != var4 || this.field23457 == null || var1 >= this.field23457.length || var2 > this.field23457[var1];
   }

   private boolean method10489() {
      return this.field23452 != null && this.field23453 != null && System.currentTimeMillis() <= this.field23454;
   }

   private boolean method10490() {
      return this.field23456 != null && System.currentTimeMillis() <= this.field23458;
   }

   private boolean method10491(int var1, ItemStack var2, boolean var3, long var4, List<Slot> var6) {
      if (this.field23453 == null || var1 >= var6.size() || var4 > this.field23453[var1]) {
         return false;
      } else if (var3) {
         return true;
      } else if (!ItemStack.matches(this.field23452[var1], ((Slot)var6.get(var1)).getItem())) {
         this.field23453[var1] = 0L;
         return false;
      } else if (ItemStack.isSameItem(var2, this.field23452[var1])) {
         this.field23453[var1] = 0L;
         return false;
      } else if (var2.isEmpty() && this.field23452[var1].getCount() == 1 && !this.method10494(var1)) {
         this.field23453[var1] = 0L;
         return false;
      } else {
         return true;
      }
   }

   private boolean method10492(int var1, ItemStack var2, long var3, List<Slot> var5) {
      ItemStack var6 = this.field23456[var1];
      if (var6 == null || var1 >= var5.size() || var3 > this.field23457[var1]) {
         return false;
      } else if (!ItemStack.matches(var6, ((Slot)var5.get(var1)).getItem())) {
         this.field23457[var1] = 0L;
         return false;
      } else if (ItemStack.isSameItem(var2, var6)) {
         this.field23457[var1] = 0L;
         return false;
      } else {
         return true;
      }
   }

   private void method10493(InventoryActionSequence var1) {
      int[] var2 = var1.method07541();
      if (var2 != null && mc.player != null) {
         NonNullList<Slot> var3 = mc.player.containerMenu.slots;
         int var4 = mc.player.containerMenu.containerId;
         if (this.field23456 == null || this.field23456.length != var3.size() || this.field23459 != var4) {
            this.field23456 = new ItemStack[var3.size()];
            this.field23457 = new long[var3.size()];
            this.field23459 = var4;
         }

         long var5 = System.currentTimeMillis() + this.method10498();

         for (int var10 : var2) {
            if (var10 >= 0 && var10 < var3.size()) {
               this.field23456[var10] = ((Slot)var3.get(var10)).getItem().copy();
               this.field23457[var10] = var5;
               if (this.field23453 != null && var10 < this.field23453.length) {
                  this.field23453[var10] = 0L;
               }
            }
         }

         if (var5 > this.field23458) {
            this.field23458 = var5;
         }
      }
   }

   private boolean method10494(int var1) {
      if (mc.player == null) {
         return false;
      } else {
         return var1 == 45 ? true : var1 == 36 + mc.player.getInventory().getSelectedSlot();
      }
   }

   private static ItemStack[] method10495(List<Slot> var0) {
      ItemStack[] var1 = new ItemStack[var0.size()];

      for (int var2 = 0; var2 < var1.length; var2++) {
         var1[var2] = ((Slot)var0.get(var2)).getItem().copy();
      }

      return var1;
   }

   private void method10496() {
      if (mc.player == null) {
         this.field23452 = null;
      } else {
         ItemStack[] var1 = method10495(mc.player.containerMenu.slots);
         this.field23452 = var1;
         this.field23455 = mc.player.containerMenu.containerId;
         if (this.field23453 == null || this.field23453.length != var1.length) {
            this.field23453 = new long[var1.length];
         }
      }
   }

   private void method10497() {
      if (this.field23452 != null && mc.player != null && mc.player.containerMenu.containerId == this.field23455) {
         NonNullList<Slot> var1 = mc.player.containerMenu.slots;
         long var2 = System.currentTimeMillis() + this.method10498();

         for (int var4 = 0; var4 < this.field23452.length && var4 < var1.size(); var4++) {
            if (!ItemStack.matches(this.field23452[var4], ((Slot)var1.get(var4)).getItem())) {
               ((Slot)var1.get(var4)).set(this.field23452[var4].copy());
               this.field23453[var4] = var2;
               if (var2 > this.field23454) {
                  this.field23454 = var2;
               }
            }
         }
      }
   }

   public long method10498() {
      return 1500L;
   }

   private void method10499() {
      boolean var1 = this.field23448.method07547() && this.field23469 == null && this.method10501();
      if (false) {
         ;
      }

      if (var1) {
         this.method10502();
      }

      this.field23450 = this.field23448.method07554();
      if (this.field23450 > 0 && this.field23448.method07544() && this.field23450 > this.field23449) {
         this.field23449 = this.field23450;
      }

      if (!this.field23448.method07553()) {
         this.method10497();
      }

      if (var1) {
         this.method10503();
      }

      if (false) {
         ;
      }

      if (!this.field23448.method07549() && this.field23466 != this.field23448) {
         this.method10500();
      }
   }

   private void method10500() {
      this.method10493(this.field23448);
      this.field23448.method07537();
      this.field23448 = null;
   }

   private boolean method10501() {
      return this.field23464
         && mc.player.containerMenu == mc.player.inventoryMenu
         && mc.getConnection() != null
         && mc.getConnection().getConnection() == this.field23463;
   }

   private void method10502() {
      InventoryMenu var1 = mc.player.inventoryMenu;
      this.field23466 = this.field23448;
      this.field23469 = method10495(var1.slots);
      this.field23471 = var1.getCarried().copy();
      this.field23473 = var1.getStateId();
      this.field23474 = this.field23473 + 16384 & 32767;
      var1.stateId = this.field23474;
      this.field23475 = this.field23465;
      this.field23476 = 0;
   }

   private void method10503() {
      InventoryMenu var1 = mc.player.inventoryMenu;
      this.field23470 = method10495(var1.slots);
      this.field23472 = var1.getCarried().copy();
      if (!this.method10504()) {
         if (var1.getStateId() == this.field23474) {
            var1.stateId = this.field23473;
         }

         this.method10509();
      } else {
         this.field23477 = System.currentTimeMillis() + 800L;
      }
   }

   private boolean method10504() {
      if (!ItemStack.matches(this.field23471, this.field23472)) {
         return true;
      }

      for (int var1 = 0; var1 < this.field23469.length && var1 < this.field23470.length; var1++) {
         if (!ItemStack.matches(this.field23469[var1], this.field23470[var1])) {
            return true;
         }
      }

      return false;
   }

   private void method10505() {
      boolean var1 = this.field23465 != this.field23475;
      if (var1 || System.currentTimeMillis() > this.field23477) {
         if (!var1 && this.field23476 < 2) {
            this.method10506();
         } else {
            InventoryActionSequence var2 = this.field23466;
            if (false) {
               ;
            }

            if (!var1) {
               this.method10508();
            }

            this.method10509();
            if (!var1 || !var2.method07549()) {
               if (var2 != this.field23448) {
                  this.field23446.remove(var2);
                  var2.method07537();
               } else if (var1) {
                  this.method10500();
               } else {
                  var2.method07537();
                  this.field23448 = null;
                  this.field23450 = 0;
               }
            }
         }
      }
   }

   private void method10506() {
      this.field23476++;
      this.field23477 = Long.MAX_VALUE;
      if (false) {
         ;
      }

      InventoryActionSequence var1 = this.field23466;
      if (var1 == this.field23448) {
         this.field23448 = null;
         this.field23450 = 0;
         if (var1.method07549()) {
            this.field23446.offerFirst(var1);
         }
      }

      this.field23467 = new InventoryActionSequence().method07534(this::method10507, 1, false);
      this.field23446.offerFirst(this.field23467);
   }

   private void method10507() {
      if (this.field23469 != null && mc.player != null) {
         InventoryMenu var1 = mc.player.inventoryMenu;
         if (mc.player.containerMenu == var1 && var1.getCarried().isEmpty()) {
            var1.stateId = this.field23474;
            mc.gameMode.handleInventoryMouseClick(var1.containerId, -999, 0, ClickType.PICKUP, mc.player);
            PlayerUtils.method11812(new ServerboundContainerClosePacket(var1.containerId));
         }

         this.field23477 = System.currentTimeMillis() + 800L;
      }
   }

   private void method10508() {
      InventoryMenu var1 = mc.player.inventoryMenu;
      NonNullList<Slot> var2 = var1.slots;

      for (int var3 = 0; var3 < this.field23469.length && var3 < this.field23470.length && var3 < var2.size(); var3++) {
         if (!ItemStack.matches(this.field23469[var3], this.field23470[var3])) {
            boolean var4 = ItemStack.matches(((Slot)var2.get(var3)).getItem(), this.field23470[var3]);
            if (false) {
               ((Slot)var2.get(var3)).getItem();
            }

            if (var4) {
               ((Slot)var2.get(var3)).set(this.field23469[var3].copy());
            }
         }
      }

      if (!ItemStack.matches(this.field23471, this.field23472) && ItemStack.matches(var1.getCarried(), this.field23472)) {
         var1.setCarried(this.field23471.copy());
      }

      if (var1.getStateId() == this.field23474) {
         var1.stateId = this.field23473;
      }
   }

   private void method10509() {
      if (this.field23467 != null) {
         this.field23446.remove(this.field23467);
         if (this.field23448 == this.field23467) {
            this.field23448 = null;
            this.field23450 = 0;
            this.field23451 = false;
         }

         this.field23467 = null;
      }

      this.field23466 = null;
      this.field23469 = null;
      this.field23470 = null;
      this.field23471 = null;
      this.field23472 = null;
   }
}
