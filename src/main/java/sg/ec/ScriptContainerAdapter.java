// Original binary: sg/ec/9se99Pakcfd6NmHe
package sg.ec;

import hex.script.api.Container;
import hex.script.api.Item;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;

// $VF: Compiled from s
public final class ScriptContainerAdapter implements MinecraftAccess {
   private final Container field05956 = new Container(this::method02435, this::method02431, this::method02425, this::method02427);

   private Item method02425(int var1) {
      AbstractContainerMenu var2 = this.method02434();
      return var2 != null && var1 >= 0 && var1 < this.method02428(var2) ? ScriptEntitiesAdapter.method09078(var2.getSlot(var1).getItem()) : new Item();
   }

   private boolean method02427(int var1, int var2, int var3) {
      AbstractContainerMenu var4 = this.method02434();
      if (var4 != null && mc.isSameThread()) {
         int var5 = var4.containerId;
         if (var1 == 4) {
            InventoryActionManager.INSTANCE.method10470(() -> this.method02430(var5), 1, false);
            return true;
         }

         int var6 = this.method02429(var1, var3);
         if (var6 >= 0 && var2 >= 0 && var2 < var4.slots.size()) {
            ContainerInput var7 = switch (var1) {
               case 1 -> ContainerInput.QUICK_MOVE;
               case 2 -> ContainerInput.SWAP;
               case 3 -> ContainerInput.THROW;
               default -> ContainerInput.PICKUP;
            };
            InventoryActionManager.INSTANCE.method10470(() -> InventoryUtils.method06127(var5, var2, var6, var7, false), 1, false);
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private int method02428(AbstractContainerMenu var1) {
      int var2 = 0;

      for (Slot var4 : var1.slots) {
         if (var4.container != mc.player.getInventory()) {
            var2++;
         }
      }

      return var2;
   }

   private int method02429(int var1, int var2) {
      return switch (var1) {
         case 1 -> 0;
         case 2 -> var2 != 40 && (var2 < 0 || var2 > 8) ? -1 : var2;
         case 3 -> 1;
         default -> var2 == 1 ? 1 : 0;
      };
   }

   private void method02430(int var1) {
      if (mc.player != null && mc.player.containerMenu.containerId == var1) {
         mc.player.closeContainer();
      }
   }

   private String method02431(int var1) {
      AbstractContainerMenu var2 = this.method02434();
      if (var2 == null) {
         return "";
      }

      if (var1 == 1) {
         try {
            return String.valueOf(BuiltInRegistries.MENU.getKey(var2.getType()));
         } catch (Throwable var5) {
            return "";
         }
      } else {
         return mc.gui.screen() instanceof AbstractContainerScreen var3 ? var3.getTitle().getString() : "";
      }
   }

   Container method02432() {
      return this.field05956;
   }

   private AbstractContainerMenu method02434() {
      if (mc.player == null) {
         return null;
      }

      AbstractContainerMenu var1 = mc.player.containerMenu;
      return var1 != null && var1 != mc.player.inventoryMenu ? var1 : null;
   }

   private int method02435(int var1) {
      AbstractContainerMenu var2 = this.method02434();
      if (var2 == null) {
         return 0;
      }

      return switch (var1) {
         case 1 -> var2.containerId;
         case 2 -> this.method02428(var2);
         default -> 1;
      };
   }
}
