// Original binary: sg/ec/Iuas4dNnOQ1DMwkU
package sg.ec;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class LowDurabilityWarn extends ClientModule {
   private final NumberSetting<Integer> field08780;
   private final ToggleSetting field08781;
   private int field08782;
   private boolean field08783;
   private static final String field08784 = "Прочность в %";
   private static final String field08785 = "Писать /repair";
   private static final String field08786 = "Low Durability Warn";
   private static final String field08787 = "У предмета ";
   private static final String field08788 = " Осталось мало прочности";
   private static final long field08789 = 3000L;
   private static final String field08790 = "/repair all";

   public LowDurabilityWarn() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.field08780 = new NumberSetting<Integer>(field08784).method10835(5).method10838(75).method10834(1).method03017(10).method03023(this);
      this.field08781 = new ToggleSetting(field08785).method03017(false).method03023(this);
      this.field08782 = 0;
      this.field08783 = false;
      this.method03935(field08786);
   }

   private static int method03942(int var0, int var1) {
      return 100 - var0 * 100 / var1;
   }

   @Subscribe
   private void method03943(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         ItemStack var2 = mc.player.getMainHandItem();
         if (var2.isEmpty()) {
            this.field08782 = 0;
         } else {
            int var3 = this.field08780.method03022();
            int var4 = var2.getDamageValue();
            int var5 = var2.getMaxDamage();
            if (var5 <= 0) {
               this.field08782 = 0;
            } else {
               int var6 = method03942(var4, var5);
               if (var6 != this.field08782) {
                  this.field08782 = var6;
                  this.field08783 = false;
               }

               if (var6 <= var3 && !this.field08783) {
                  this.field08783 = true;
                  this.method03944(var2.getStyledHoverName());
               }

               if (var6 > var3) {
                  this.field08783 = false;
               }
            }
         }
      }
   }

   private void method03944(Component var1) {
      MutableComponent var2 = Component.literal(field08787).append(var1).append(field08788);
      NotificationManager.method08619(var2, field08789, NotificationType.WARNING);
      if (this.field08781.method05999()) {
         ChatTextUtils.method05080(field08790);
      }
   }
}
