// Original binary: sg/ec/6iEhOBFWvss5vItB
package sg.ec;

import hex.script.api.Slots;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class ScriptSlotsAdapter implements MinecraftAccess {
   private final Map<Object, Slots> field03564 = new HashMap<>();
   private final Map<Integer, ScriptSlotsAdapter.Nested41> field03565 = new LinkedHashMap<>();
   private final List<Integer> field03566 = new ArrayList<>();
   private static final int field03567 = 9;
   private int field03568;

   private boolean method01452(int var1, int var2) {
      if (mc.player == null || var1 < 0 || var1 >= ArmorScoreUtils.field12667.length || var2 < 0 || var2 >= 36) {
         return false;
      }

      if (mc.player.containerMenu == mc.player.inventoryMenu && mc.isSameThread()) {
         int var3 = var2 < 9 ? 36 + var2 : var2;
         ItemStack sx = mc.player.inventoryMenu.getSlot(var3).getItem();
         EquipmentSlot sxx = ArmorScoreUtils.field12667[var1];
         if (!sx.isEmpty() && mc.player.getEquipmentSlotForItem(sx) == sxx) {
            boolean sxxx = !mc.player.getItemBySlot(sxx).isEmpty();
            return ArmorScoreUtils.method05919(ArmorScoreUtils.method05921(sxx), var3, sxxx);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   Slots method01453(Object var1) {
      return this.field03564
         .computeIfAbsent(var1, var1x -> new Slots(var1x, this::method01458, this::method01462, this::method01455, this::method01452, this::method01457));
   }

   void method01454(Object var1) {
      this.field03564.remove(var1);

      for (Integer var5 : this.field03565.keySet().toArray(new Integer[0])) {
         ScriptSlotsAdapter.Nested41 var6 = this.field03565.get(var5);
         if (var6 != null && var6.owner() == var1) {
            this.method01456(this.field03565.remove(var5));
            this.field03566.remove(var5);
         }
      }
   }

   private int method01455(int var1, boolean var2) {
      if (mc.player == null || var1 < 0 || var1 >= ArmorScoreUtils.field12667.length) {
         return -1;
      }

      if (mc.player.containerMenu == mc.player.inventoryMenu && mc.isSameThread()) {
         EquipmentSlot var3 = ArmorScoreUtils.field12667[var1];
         int var4 = ArmorScoreUtils.method05920(var3);
         if (var4 == -1) {
            return -1;
         }

         if (!var2) {
            return var4 - 9;
         }

         boolean var5 = !mc.player.getItemBySlot(var3).isEmpty();
         return ArmorScoreUtils.method05919(ArmorScoreUtils.method05921(var3), var4, var5) ? 0 : -1;
      } else {
         return -1;
      }
   }

   private void method01456(ScriptSlotsAdapter.Nested41 var1) {
      if (var1 != null && mc.player != null) {
         this.method01461(var1.original());
      }
   }

   private void method01457(int var1, int var2) {
      ScriptSlotsAdapter.Nested41 var3 = this.field03565.get(var1);
      if (var3 != null && mc.isSameThread()) {
         switch (var2) {
            case 0:
               this.method01456(this.field03565.remove(var1));
               break;
            case 2:
               this.field03565.remove(var1);
               break;
            default:
               this.field03566.add(var1);
         }
      }
   }

   private int[] method01458(Object var1, int var2) {
      if (mc.player != null && var2 >= 0 && var2 <= 8 && mc.isSameThread()) {
         int var3 = mc.player.getInventory().getSelectedSlot();
         this.method01461(var2);
         int var4 = ++this.field03568;
         this.field03565.put(var4, new ScriptSlotsAdapter.Nested41(var1, var2, var3));
         return new int[]{var4, var2, var3};
      } else {
         return null;
      }
   }

   void method01459() {
      if (!this.field03566.isEmpty()) {
         for (int var1 = 0; var1 < this.field03566.size(); var1++) {
            this.method01456(this.field03565.remove(this.field03566.get(var1)));
         }

         this.field03566.clear();
      }
   }

   private void method01461(int var1) {
      mc.player.getInventory().setSelectedSlot(var1);
      InventoryUtils.method06091(var1);
   }

   private int method01462(int var1, int var2) {
      if (mc.player != null && (var1 == 0 || mc.isSameThread())) {
         return switch (var1) {
            case 1 -> {
               if (var2 >= 0 && var2 <= 8) {
                  this.method01461(var2);
                  yield var2;
               } else {
                  yield -1;
               }
            }
            case 2 -> {
               int var3 = mc.player.getInventory().getSelectedSlot();
               mc.player.connection.send(new ServerboundSetCarriedItemPacket(var3));
               yield var3;
            }
            default -> mc.player.getInventory().getSelectedSlot();
         };
      } else {
         return -1;
      }
   }

   // $VF: Compiled from s
   private record Nested41(Object owner, int slot, int original) {
   }
}
