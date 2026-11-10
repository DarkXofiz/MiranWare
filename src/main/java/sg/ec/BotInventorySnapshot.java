// Original binary: sg/ec/941LcbSj8zlaRwmZ
package sg.ec;

import java.util.Arrays;
import java.util.List;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerInventoryPacket;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
final class BotInventorySnapshot {
   static final int field05156 = 36;
   static final int field05157 = 0;
   private static final int field05158 = 0;
   private static final int field05159 = 0;
   private static final int field05160 = 0;
   private final ItemStack[] field05161 = new ItemStack[36];

   void method02160(BotClient var1) {
      BotWorldState var2 = var1.method00090();
      BotLocalPlayer sx = var2.method07688();
      if (var2.method07683() && sx != null) {
         this.method02165(sx.getInventory());
      } else {
         this.method02163(var1.method00070());
      }
   }

   BotInventorySnapshot() {
      Arrays.fill(this.field05161, ItemStack.EMPTY);
   }

   private static int method02161(int var0) {
      if (var0 >= 9 && var0 < 36) {
         return var0;
      } else {
         return var0 >= 36 && var0 < 45 ? var0 - 36 : -1;
      }
   }

   private void method02162(int var1, ItemStack var2) {
      if (var1 >= 0 && var1 < 36) {
         this.field05161[var1] = var2 == null ? ItemStack.EMPTY : var2;
      }
   }

   private void method02163(BotPlayerState var1) {
      Arrays.fill(this.field05161, ItemStack.EMPTY);
      ClientboundContainerSetContentPacket var2 = var1.method07955();
      if (var2 != null) {
         var var3 = var2.items();

         for (int var4 = 0; var4 < var3.size(); var4++) {
            this.method02162(method02161(var4), (ItemStack)var3.get(var4));
         }
      }

      for (ClientboundContainerSetSlotPacket var7 : var1.method07964()) {
         this.method02162(method02161(var7.getSlot()), var7.getItem());
      }

      for (ClientboundSetPlayerInventoryPacket var8 : var1.method08007()) {
         this.method02162(var8.slot(), var8.contents());
      }
   }

   ItemStack method02164(int var1) {
      return this.field05161[var1];
   }

   private void method02165(Inventory var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         this.field05161[var2] = var1.getItem(var2);
      }
   }
}
