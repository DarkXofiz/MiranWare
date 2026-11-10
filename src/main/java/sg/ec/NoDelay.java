// Original binary: sg/ec/iBkkTAt8PR1MZotU
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class NoDelay extends ClientModule {
   public final MultiToggleSetting field20026;
   public final ToggleSetting field20027;
   private static final String field20028 = "Убрать задержку на";
   private static final String field20029 = "На прыжки";
   private static final String field20030 = "На пкм";
   private static final String field20031 = "Выбор условий для убирания задержки";
   private static final String field20032 = "Только с опытом";
   private static final String field20033 = "No Delay";
   private static final String field20034 = "На прыжки";
   private static final String field20035 = "На пкм";
   private static final String field20036 = "На пкм";

   public NoDelay() {
      super(ModuleCategory.Misc, ModuleSubCategory.Other);
      this.field20026 = new MultiToggleSetting(field20028)
         .method04517(NamedOption.method08077(field20029, false))
         .method04517(NamedOption.method08077(field20030, false))
         .method03018(field20031)
         .method03023(this);
      this.field20027 = new ToggleSetting(field20032).method03014(false).method03025(() -> this.field20026.method04520(field20036)).method03023(this);
      this.method03935(field20033);
   }

   @Subscribe
   private void method08783(PlayerUpdateEvent var1) {
      Minecraft var2 = mc;
      if (var2.player != null) {
         if (this.field20026.method04520(field20034)) {
            ((LivingEntityMixin_1248)(Object)var2.player).setjumpingCooldown(0);
         }

         if (this.method08785(var2)) {
            ((MinecraftInteractionAccess)var2).setitemUseCooldown(0);
         }
      }
   }

   private boolean method08784(Minecraft var1) {
      ItemStack var2 = var1.player.getMainHandItem();
      if (var2.is(Items.EXPERIENCE_BOTTLE)) {
         return !var1.player.getCooldowns().isOnCooldown(var2);
      }

      ItemStack var3 = var1.player.getOffhandItem();
      return var3.is(Items.EXPERIENCE_BOTTLE) ? !var1.player.getCooldowns().isOnCooldown(var3) : false;
   }

   private boolean method08785(Minecraft var1) {
      return this.field20026.method04520(field20035) && var1.player != null ? !this.field20027.method03022() || this.method08784(var1) : false;
   }
}
