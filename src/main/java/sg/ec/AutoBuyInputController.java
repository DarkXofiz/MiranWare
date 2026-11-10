// Original binary: sg/ec/RY5NXzhNBLINQ0Ek
package sg.ec;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

// $VF: Compiled from s
final class AutoBuyInputController implements MinecraftAccess {
   private final AutoBuyPurchaseController field11435;

   AutoBuyInputController(AutoBuyPurchaseController var1) {
      this.field11435 = var1;
   }

   @Subscribe
   private void method05274(PlayerInputEvent var1) {
      if (this.method05276()) {
         var1.method11159();
      }
   }

   @Subscribe
   private void method05275(MouseTurnEvent var1) {
      if (this.method05276()) {
         var1.method05696();
      }
   }

   private boolean method05276() {
      return this.field11435.method09132() && mc.player != null && mc.player.containerMenu != mc.player.inventoryMenu;
   }

   @Subscribe
   private void method05277(ScreenChangeEvent var1) {
      if (this.field11435.method09132() && var1.method03322() instanceof AbstractContainerScreen) {
         var1.method05696();
      }
   }
}
