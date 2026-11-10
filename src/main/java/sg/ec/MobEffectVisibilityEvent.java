// Original binary: sg/ec/35TBqYCHoEMkCtae
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public class MobEffectVisibilityEvent extends Event {
   public static final MobEffectVisibilityEvent field01112 = new MobEffectVisibilityEvent();
   private MobEffect field01113;

   public void method00607(MobEffect var1) {
      this.field01113 = var1;
   }

   public boolean method00608(LivingEntity var1, MobEffect var2, boolean var3) {
      if (var1 instanceof LocalPlayer && this.method05698()) {
         this.field01113 = var2;
         super.method03208();
         return this.method05694() ? false : var3;
      } else {
         return var3;
      }
   }

   public MobEffect method00609() {
      return this.field01113;
   }
}
