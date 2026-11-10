// Original binary: sg/ec/HFdynzybvu7IYsEH
package sg.ec;

import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public class EntityJumpEvent extends Event {
   public static final EntityJumpEvent field08473 = new EntityJumpEvent();
   private LivingEntity field08474;

   public void method03778(LivingEntity var1) {
      this.field08474 = var1;
      super.method03208();
   }

   public LivingEntity method03779() {
      return this.field08474;
   }

   public void method03780(LivingEntity var1) {
      this.field08474 = var1;
   }
}
