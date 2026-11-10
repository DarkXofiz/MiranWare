// Original binary: sg/ec/WABTDuUoU2eciHZm
package sg.ec;

import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.client.gui.screens.Screen;

// $VF: Compiled from s
public class AutoRespawn extends ClientModule {
   private static final String field13493 = "Auto Respawn";

   public AutoRespawn() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.method03935(field13493);
   }

   @Subscribe
   private void method05976(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         Screen var2 = mc.screen;
         if (var2 instanceof DeathScreen && mc.player.deathTime > 0) {
            mc.player.respawn();
         }
      }
   }
}
