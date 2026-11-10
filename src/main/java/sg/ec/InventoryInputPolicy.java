// Original binary: sg/ec/8YyuPFdtr6HWR3YB
package sg.ec;

import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.SignEditScreen;

// $VF: Compiled from s
public final class InventoryInputPolicy {
   public static boolean method01915(Screen var0) {
      if (ClientScreenManager.INSTANCE.method08329()) {
         return true;
      } else if (var0 == null) {
         return false;
      } else {
         return !(var0 instanceof ChatScreen) && !(var0 instanceof SignEditScreen) ? var0.getFocused() instanceof EditBox var1 && var1.canConsumeInput() : true;
      }
   }

   private InventoryInputPolicy() {
   }
}
