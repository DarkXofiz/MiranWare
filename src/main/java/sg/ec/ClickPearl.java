// Original binary: sg/ec/FjzdFJLRvIUVpyr8
package sg.ec;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class ClickPearl extends ClientModule {
   private final ModeSetting field07613;
   private final KeyBindSetting field07614;
   private boolean field07615;
   private static final String field07616 = "Моды";
   private static final String field07617 = "Легитно";
   private static final String field07618 = "Рейджово";
   private static final String field07619 = "Рейджово";
   private static final String field07620 = "Кнопка перла";
   private static final String field07621 = "Click Pearl";
   private static final String field07622 = "Легитно";
   private static final float field07623 = -89.0F;
   private static final float field07624 = 89.0F;

   @Subscribe
   private void method03434(MouseButtonEvent var1) {
      this.method03435(var1.method06914(), var1.method06919());
   }

   private void method03435(int var1, InputAction var2) {
      if (var2 != InputAction.RELEASE) {
         if (var1 == this.field07614.method03022().method05871()) {
            this.field07615 = true;
         }
      }
   }

   public ClickPearl() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.field07613 = new ModeSetting(field07616).method05597(field07617, field07618).method03017(field07619).method03023(this);
      this.field07614 = new KeyBindSetting(field07620).method03017(new KeyBinding()).method03023(this);
      this.field07615 = false;
      this.method03935(field07621);
   }

   @Subscribe
   private void method03436(KeyInputEvent var1) {
      this.method03435(var1.method05887(), var1.method05884());
   }

   @Subscribe
   private void method03437(PreMovementPacketEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (this.field07615) {
            this.method03438(var1, FreeLookController.method10131(), FreeLookController.method10134());
            this.field07615 = false;
         }
      }
   }

   public boolean method03438(PreMovementPacketEvent var1, float var2, float var3) {
      if (mc.player == null) {
         return false;
      }

      Slot var4 = InventoryUtils.method06136(Items.ENDER_PEARL);
      if (var4 != null && !var4.getItem().isEmpty()) {
         if (mc.player.getCooldowns().isOnCooldown(var4.getItem())) {
            return false;
         } else {
            var3 = method03439(var3);
            if (this.field07613.method05600(field07622)) {
               DelayedInventoryActionManager.INSTANCE.method09006(Items.ENDER_PEARL, var2, var3);
               return true;
            } else {
               DelayedInventoryActionManager.INSTANCE.method10618(Items.ENDER_PEARL, var2, var3);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   private static float method03439(float var0) {
      return Math.max(field07623, Math.min(field07624, var0));
   }
}
