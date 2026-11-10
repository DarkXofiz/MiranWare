// Original binary: sg/ec/jURJXMv3Jixd0z6i
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult.Type;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public class AutoTool extends ClientModule {
   private final ModeSetting field20412;
   private final ToggleSetting field20413;
   private static final int field20414 = 2;
   private static final int field20415 = 0;
   private static final float field20416 = 0;
   private static final int field20417 = 0;
   private int field20418;
   private int field20419;
   private int field20420;
   private int field20421;
   private int field20422;
   private int field20423;
   private Item field20424;
   private int field20425;
   private int field20426;
   private Item field20427;
   private static final String field20428 = "Режим";
   private static final String field20429 = "Обычный";
   private static final String field20430 = "Скрытый";
   private static final String field20431 = "Обычный";
   private static final String field20432 = "Брать из инвентаря";
   private static final String field20433 = "Auto Tool";
   private static final float field20434 = 1.0E-4F;
   private static final float field20435 = 1.0E-4F;
   private static final float field20436 = 1.0E-4F;
   private static final String field20437 = "Скрытый";

   private void method08973() {
      this.method08974();
      this.field20422 = -1;
      this.field20423 = -1;
      this.field20424 = null;
   }

   private void method08974() {
      this.field20418 = -1;
      this.field20419 = -1;
      this.field20421 = 0;
   }

   public AutoTool() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field20412 = new ModeSetting(field20428).method05597(field20429, field20430).method03017(field20431).method03023(this);
      this.field20413 = new ToggleSetting(field20432).method03017(false).method03023(this);
      Object var10001 = null;
      this.field20418 = -1;
      this.field20419 = -1;
      this.field20420 = -1;
      this.field20422 = -1;
      this.field20423 = -1;
      this.field20425 = -1;
      this.field20426 = -1;
      var10001 = -1;
      this.method03935(field20433);
   }

   private void method08975(BlockState var1) {
      if (this.field20413.method05999()) {
         if (this.field20422 == -1 && !InventoryActionManager.INSTANCE.method10476()) {
            if (mc.player.containerMenu == mc.player.inventoryMenu) {
               int var2 = method08990(var1, method08993(var1));
               if (var2 == -1) {
                  if (this.field20425 != -1 && method08997(var1) != this.field20425) {
                     this.method09001();
                  }
               } else {
                  int var3 = this.field20425;
                  if (var3 != -1) {
                     boolean var4 = var2 == this.field20426;
                     this.method09001();
                     if (var4) {
                        return;
                     }
                  } else {
                     var3 = this.method08979(var1);
                  }

                  if (var3 != -1) {
                     this.method08982(var2, var3);
                     this.field20422 = var3;
                     this.field20423 = var2;
                     this.field20424 = mc.player.getInventory().getItem(var2).getItem();
                  }
               }
            }
         }
      }
   }

   private static boolean method08976(ItemStack var0) {
      return !var0.isEmpty() && var0.getItem() == Items.SHEARS && BlockBreakSpeedUtils.method04451(var0) <= 0.0F;
   }

   private void method08977() {
      if (this.field20422 != -1 && !InventoryActionManager.INSTANCE.method10476()) {
         int var1 = this.field20422;
         int var2 = this.field20423;
         Item var3 = this.field20424;
         this.field20422 = -1;
         this.field20423 = -1;
         this.field20424 = null;
         if (mc.player.getInventory().getItem(var1).getItem() == var3) {
            this.field20425 = var1;
            this.field20426 = var2;
            this.field20427 = var3;
         }
      }
   }

   private static float method08978(ItemStack var0, BlockState var1) {
      return BlockBreakSpeedUtils.method04455(var0, var1);
   }

   private int method08979(BlockState var1) {
      int var2 = InventoryUtils.method06094(this.field20418);
      if (var2 != -1) {
         return var2;
      }

      int var3 = method08997(var1);
      return var3 != -1 && var3 != this.field20418 ? var3 : InventoryUtils.method06134(this.field20418);
   }

   private void method08980() {
      this.field20425 = -1;
      this.field20426 = -1;
      this.field20427 = null;
   }

   private void method08981(BlockPos var1) {
      BlockState var2 = mc.level.getBlockState(var1);
      if (!(var2.getDestroyProgress(mc.player, mc.level, var1) >= 1.0F)) {
         this.method08975(var2);
         this.field20420 = this.method08992(var2);
      }
   }

   private void method08982(int var1, int var2) {
      int var3 = mc.player.containerMenu.containerId;
      InventoryActionManager.INSTANCE.method10469(() -> mc.gameMode.handleContainerInput(var3, var1, var2, ClickType.SWAP, mc.player));
   }

   private void method08983() {
      this.field20421 = this.field20425 == -1 ? 2 : 3;
   }

   @Subscribe
   public void method08984(SelectedSlotEvent var1) {
      this.method08974();
   }

   private BlockPos method08985() {
      BlockBreakManager var1 = BlockBreakManager.INSTANCE;
      if (var1.method04905() && !mc.options.keyAttack.isDown()) {
         return var1.method04907() ? var1.method04912() : null;
      } else if (mc.gui.screen() != null) {
         return null;
      } else if (mc.hitResult instanceof BlockHitResult var2 && var2.getType() == Type.BLOCK) {
         return mc.level.getBlockState(var2.getBlockPos()).isAir() ? null : var2.getBlockPos();
      } else {
         return null;
      }
   }

   private boolean method08986() {
      return mc.gameMode.isDestroying() || mc.options.keyAttack.isDown() || BlockBreakManager.INSTANCE.method04905();
   }

   @Subscribe
   public void method08987(PlayerUpdateEvent var1) {
      if (this.field20420 != -1 && mc.gameMode != null) {
         int var2 = this.field20420;
         this.field20420 = -1;
         int var3 = mc.player.getInventory().getSelectedSlot();
         if (var3 != var2) {
            this.method08999();
            mc.player.getInventory().setSelectedSlot(var2);
            this.field20419 = var2;
            ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).hookEnsureHasSentCarriedItem();
         }
      }
   }

   @Subscribe
   public void method08988(HeldItemRenderEvent var1) {
      if (this.field20412.method05600(field20437)) {
         int var2 = this.field20418;
         if (var2 >= 0 && var2 < 9) {
            switch (var1.method00319()) {
               case SELECTED_SLOT:
                  var1.method00325(var2);
                  break;
               case MAIN_HAND_STACK:
                  if (var1.method00323() instanceof LocalPlayer) {
                     var1.method00320(mc.player.getInventory().getItem(var2));
                  }
                  break;
               case STACK_IN_ARM:
                  if (var1.method00312() instanceof LocalPlayer && var1.method00313() == mc.player.getMainArm()) {
                     var1.method00320(mc.player.getInventory().getItem(var2));
                  }
            }
         }
      }
   }

   private boolean method08989() {
      return this.field20419 != -1 && mc.player.getInventory().getSelectedSlot() != this.field20419;
   }

   private static int method08990(BlockState var0, ItemStack var1) {
      float var2 = method08978(var1, var0);
      int var3 = -1;

      for (int var4 = 9; var4 < 36; var4++) {
         ItemStack var5 = mc.player.getInventory().getItem(var4);
         float var6 = method08978(var5, var0);
         if (method08996(var5, var1, var6, var2, var0)) {
            var2 = var6;
            var3 = var4;
            var1 = var5;
         }
      }

      return var3;
   }

   @Subscribe
   public void method08991(TickEvent var1) {
      this.field20420 = -1;
      if (mc.player != null && mc.level != null && mc.gameMode != null && !mc.player.isCreative()) {
         this.method08977();
         if (this.method08986()) {
            BlockPos var2 = this.method08985();
            if (var2 != null) {
               this.method08981(var2);
            }

            if (this.field20418 != -1 || this.field20425 != -1) {
               this.method08983();
            }
         } else if (this.field20418 != -1 || this.field20425 != -1) {
            if (this.field20421 > 0) {
               this.field20421--;
            } else if (!this.method08989()) {
               this.method08994();
               this.method09001();
               this.method08973();
            }
         }
      } else {
         this.method08973();
         this.method08980();
      }
   }

   private int method08992(BlockState var1) {
      Inventory var2 = mc.player.getInventory();
      int var3 = method08997(var1);
      if (var3 != -1 && var3 != var2.getSelectedSlot()) {
         float var4 = method08978(var2.getItem(var3), var1);
         float var5 = method08978(var2.getItem(var2.getSelectedSlot()), var1);
         return var4 > var5 + field20434 ? var3 : -1;
      } else {
         return -1;
      }
   }

   private static ItemStack method08993(BlockState var0) {
      int var1 = method08997(var0);
      return var1 == -1 ? mc.player.getMainHandItem() : mc.player.getInventory().getItem(var1);
   }

   private void method08994() {
      if (this.field20418 != -1 && mc.player != null) {
         if (this.field20419 == -1 || mc.player.getInventory().getSelectedSlot() == this.field20419) {
            int var1 = mc.player.getInventory().getSelectedSlot();
            mc.player.getInventory().setSelectedSlot(this.field20418);
         }
      }
   }

   private static boolean method08996(ItemStack var0, ItemStack var1, float var2, float var3, BlockState var4) {
      if (var2 > var3 + field20435) {
         return true;
      }

      if (var2 + field20436 < var3) {
         return false;
      }

      boolean var5 = var0.isCorrectToolForDrops(var4);
      boolean var6 = !var1.isEmpty() && var1.isCorrectToolForDrops(var4);
      if (var5 != var6) {
         return var5;
      }

      boolean var7 = method08976(var0);
      boolean var8 = method08976(var1);
      return var7 != var8 ? !var7 : false;
   }

   public static int method08997(BlockState var0) {
      if (mc.player == null) {
         return -1;
      }

      int var1 = -1;
      ItemStack var2 = ItemStack.EMPTY;
      float var3 = method08978(ItemStack.EMPTY, var0);

      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack var5 = mc.player.getInventory().getItem(var4);
         float var6 = method08978(var5, var0);
         if (method08996(var5, var2, var6, var3, var0)) {
            var3 = var6;
            var1 = var4;
            var2 = var5;
         }
      }

      return var1;
   }

   public static ItemStack method08998(BlockState var0) {
      if (mc.player == null) {
         return ItemStack.EMPTY;
      } else {
         ItemStack var1 = method08993(var0);
         AutoTool var2 = ModuleManager.INSTANCE.method08253();
         if (var2 != null && var2.method03937() && var2.field20413.method05999()) {
            int var3 = method08990(var0, var1);
            return var3 == -1 ? var1 : mc.player.getInventory().getItem(var3);
         } else {
            return var1;
         }
      }
   }

   private void method08999() {
      int var1 = mc.player.getInventory().getSelectedSlot();
      if (this.field20418 == -1 || var1 != this.field20419) {
         this.field20418 = var1;
      }
   }

   public static int method09000(BlockState var0) {
      AutoTool var1 = ModuleManager.INSTANCE.method08253();
      return var1 != null && var1.method03937() ? method08997(var0) : -1;
   }

   private void method09001() {
      if (this.field20425 != -1 && mc.player != null && mc.gameMode != null) {
         if (mc.player.containerMenu == mc.player.inventoryMenu) {
            Inventory var1 = mc.player.getInventory();
            int var2 = this.field20425;
            int var3 = this.field20426;
            Item var4 = this.field20427;
            this.method08980();
            if (var1.getItem(var2).getItem() == var4) {
               this.method08982(var3, var2);
            }
         }
      }
   }

   @Override
   public void method00245() {
      this.method08994();
      this.method09001();
      this.method08973();
      this.method08980();
      super.method00245();
   }

   // $VF: Compiled from s
   private record Nested249(int tick, BlockState before) {
   }
}
