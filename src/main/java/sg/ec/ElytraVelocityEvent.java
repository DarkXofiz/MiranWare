// Original binary: sg/ec/Xoo6SU2ItXy2MytM
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class ElytraVelocityEvent extends Event {
   public static final ElytraVelocityEvent field14681 = new ElytraVelocityEvent();
   private Vec3 field14682;
   private LivingEntity field14683;

   public Vec3 method06491() {
      return this.field14682;
   }

   public LivingEntity method06492() {
      return this.field14683;
   }

   public void method06493(LivingEntity var1) {
      this.field14683 = var1;
   }

   public void method06494(Vec3 var1) {
      this.field14682 = var1;
   }

   public Vec3 method06495(Vec3 var1, LivingEntity var2) {
      this.field14682 = var1;
      this.field14683 = var2;
      super.method03208();
      return this.field14682;
   }
}
