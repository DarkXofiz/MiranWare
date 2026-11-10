// Original binary: sg/ec/JWwpqcTUk1eMRVpf
package sg.ec;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Options;
import net.minecraft.world.entity.player.Inventory;

// $VF: Compiled from s
public final class MinecraftHooks {
   public static boolean method04015(KeyMapping var0, Options var1) {
      boolean var2 = var0.isDown();
      if (var0 == var1.keyUse) {
         return ItemUseInputEvent.field23424.method10457(var2);
      } else {
         return var0 != var1.keyAttack ? var2 : var2 || BlockBreakManager.INSTANCE.method04907();
      }
   }

   public static void method04016(Inventory var0, int var1) {
      var0.setSelectedSlot(var1);
      SelectedSlotEvent.field07852.method03513(var1);
   }

   private MinecraftHooks() {
   }

   public static void method04017(Window var0) {
      if (var0.shouldClose()) {
         ClientShutdownEvent.field20788.method03208();
      }
   }
}
