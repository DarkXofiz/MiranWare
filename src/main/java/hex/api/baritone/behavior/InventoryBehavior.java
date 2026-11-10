// Original binary: hex/api/baritone/behavior/InventoryBehavior
package hex.api.baritone.behavior;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.event.events.TickEvent;
import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.utils.ToolSet;
import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Predicate;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class InventoryBehavior extends Behavior implements Helper {
   int ticksSinceLastInventoryMove;
   int[] lastTickRequestedMove;
   private static final String Ут = "Ут";
   private static final double Уд = 0;

   private boolean requestSwapWithHotBar(int var1, int var2) {
      this.lastTickRequestedMove = new int[]{var1, var2};
      if (this.ticksSinceLastInventoryMove < Baritone.settings().ticksBetweenInventoryMoves.value) {
         this.logDebug("Inventory move requested but delaying " + this.ticksSinceLastInventoryMove + " " + Baritone.settings().ticksBetweenInventoryMoves.value);
         return false;
      } else if (Baritone.settings().inventoryMoveOnlyIfStationary.value && !this.baritone.getInventoryPauserProcess().stationaryForInventoryMove()) {
         this.logDebug(Ут);
         return false;
      } else {
         this.ctx
            .playerController()
            .windowClick(this.ctx.player().inventoryMenu.containerId, var1 < 9 ? var1 + 36 : var1, var2, ContainerInput.SWAP, this.ctx.player());
         this.ticksSinceLastInventoryMove = 0;
         this.lastTickRequestedMove = null;
         return true;
      }
   }

   public boolean selectThrowawayForLocation(boolean var1, int var2, int var3, int var4) {
      BlockState var5 = this.baritone.getBuilderProcess().placeAt(var2, var3, var4, this.baritone.bsi().get0(var2, var3, var4));
      if (var5 != null
         && this.throwaway(
            var1,
            var2x -> var2x.getItem() instanceof BlockItem
               && var5.equals(
                  ((BlockItem)var2x.getItem())
                     .getBlock()
                     .getStateForPlacement(
                        new BlockPlaceContext(
                           new UseOnContext(
                              this.ctx.world(),
                              this.ctx.player(),
                              InteractionHand.MAIN_HAND,
                              var2x,
                              new BlockHitResult(
                                 new Vec3(this.ctx.player().position().x, this.ctx.player().position().y, this.ctx.player().position().z),
                                 Direction.UP,
                                 this.ctx.playerFeet(),
                                 false
                              )
                           )      // $VF: Compiled from s
                      {}
                        )
                     )
               )
         )) {
         return true;
      }

      if (var5 != null
         && this.throwaway(var1, var1x -> var1x.getItem() instanceof BlockItem && ((BlockItem)var1x.getItem()).getBlock().equals(var5.getBlock()))) {
         return true;
      }

      for (Item sx : Baritone.settings().acceptableThrowawayItems.value) {
         if (this.throwaway(var1, var1x -> sx.equals(var1x.getItem()))) {
            return true;
         }
      }

      return false;
   }

   private int firstValidThrowaway() {
      NonNullList<ItemStack> var1 = this.ctx.player().getInventory().getNonEquipmentItems();

      for (int sx = 0; sx < var1.size(); sx++) {
         if (Baritone.settings().acceptableThrowawayItems.value.contains(var1.get(sx).getItem())) {
            return sx;
         }
      }

      return -1;
   }

   public boolean hasGenericThrowaway() {
      for (Item var2 : Baritone.settings().acceptableThrowawayItems.value) {
         if (this.throwaway(false, var1 -> var2.equals(var1.getItem()))) {
            return true;
         }
      }

      return false;
   }

   public InventoryBehavior(Baritone var1) {
      super(var1);
   }


   public OptionalInt getTempHotbarSlot(Predicate<Integer> var1) {
      ArrayList<Integer> var2 = new ArrayList<>();

      for (int sx = 1; sx < 8; sx++) {
         if (this.ctx.player().getInventory().getNonEquipmentItems().get(sx).isEmpty() && !var1.test(sx)) {
            var2.add(sx);
         }
      }

      if (var2.isEmpty()) {
         for (int sx = 1; sx < 8; sx++) {
            if (!var1.test(sx)) {
               var2.add(sx);
            }
         }
      }

      return var2.isEmpty() ? OptionalInt.empty() : OptionalInt.of(var2.get(new Random().nextInt(var2.size())));
   }

   public boolean throwaway(boolean var1, Predicate<? super ItemStack> var2) {
      return this.throwaway(var1, var2, Baritone.settings().allowInventory.value);
   }

   public boolean attemptToPutOnHotbar(int var1, Predicate<Integer> var2) {
      OptionalInt var3 = this.getTempHotbarSlot(var2);
      return !var3.isPresent() || this.requestSwapWithHotBar(var1, var3.getAsInt());
   }

   @Override
   public void onTick(TickEvent var1) {
      if (Baritone.settings().allowInventory.value) {
         if (var1.getType() != TickEvent.Type.OUT) {
            if (this.ctx.player().containerMenu == this.ctx.player().inventoryMenu) {
               this.ticksSinceLastInventoryMove++;
               if (this.firstValidThrowaway() >= 9) {
                  this.requestSwapWithHotBar(this.firstValidThrowaway(), 8);
               }

               int var2 = this.bestToolAgainst(Blocks.STONE);
               if (var2 >= 9) {
                  this.requestSwapWithHotBar(var2, 0);
               }

               if (this.lastTickRequestedMove != null) {
                  this.logDebug("Remembering to move " + this.lastTickRequestedMove[0] + " " + this.lastTickRequestedMove[1] + " from a previous tick");
                  this.requestSwapWithHotBar(this.lastTickRequestedMove[0], this.lastTickRequestedMove[1]);
               }
            }
         }
      }
   }

   private int bestToolAgainst(Block var1) {
      NonNullList<ItemStack> var2 = this.ctx.player().getInventory().getNonEquipmentItems();
      int sx = -1;
      double sxx = Уд;

      for (int sxxx = 0; sxxx < var2.size(); sxxx++) {
         ItemStack sxxxx = (ItemStack) var2.get(sxxx);
         if (!sxxxx.isEmpty()
            && (
               !Baritone.settings().itemSaver.value
                  || sxxxx.getDamageValue() + Baritone.settings().itemSaverThreshold.value < sxxxx.getMaxDamage()
                  || sxxxx.getMaxDamage() <= 1
            )
            && sxxxx.getItem().components().has(DataComponents.TOOL)) {
            double sxxxxx = ToolSet.calculateSpeedVsBlock(sxxxx, var1.defaultBlockState());
            if (sxxxxx > sxx) {
               sxx = sxxxxx;
               sx = sxxx;
            }
         }
      }

      return sx;
   }

   public boolean throwaway(boolean var1, Predicate<? super ItemStack> var2, boolean var3) {
      LocalPlayer var4 = this.ctx.player();
      NonNullList<ItemStack> sx = var4.getInventory().getNonEquipmentItems();

      for (int sxx = 0; sxx < 9; sxx++) {
         ItemStack sxxx = (ItemStack) sx.get(sxx);
         if (var2.test(sxxx)) {
            if (var1) {
               var4.getInventory().setSelectedSlot(sxx);
            }

            return true;
         }
      }

      if (var2.test(var4.getItemBySlot(EquipmentSlot.OFFHAND))) {
         for (int sxx = 0; sxx < 9; sxx++) {
            ItemStack sxxx = (ItemStack) sx.get(sxx);
            if (sxxx.isEmpty() || sxxx.getItem().components().has(DataComponents.TOOL)) {
               if (var1) {
                  var4.getInventory().setSelectedSlot(sxx);
               }

               return true;
            }
         }
      }

      if (var3) {
         for (int sxx = 9; sxx < 36; sxx++) {
            if (var2.test(sx.get(sxx))) {
               if (var1) {
                  this.requestSwapWithHotBar(sxx, 7);
                  var4.getInventory().setSelectedSlot(7);
               }

               return true;
            }
         }
      }

      return false;
   }
}
