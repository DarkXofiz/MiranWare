// Original binary: sg/ec/n68YsZ1CgHEhcd9z
package sg.ec;

import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.phys.HitResult;

// $VF: Compiled from s
public class PotionHitEvent extends Event {
   public static final PotionHitEvent field21912 = new PotionHitEvent();
   private AbstractThrownPotion field21913;
   private HitResult field21914;

   public void method09604(AbstractThrownPotion var1) {
      this.field21913 = var1;
   }

   public void method09605(AbstractThrownPotion var1, HitResult var2) {
      this.field21913 = var1;
      this.field21914 = var2;
      super.method03208();
   }

   public HitResult method09606() {
      return this.field21914;
   }

   public void method09607(HitResult var1) {
      this.field21914 = var1;
   }

   public AbstractThrownPotion method09608() {
      return this.field21913;
   }
}
