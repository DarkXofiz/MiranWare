// Original binary: sg/ec/lva6HnDoMasJ0W9Q
package sg.ec;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class AttackEntityEvent extends Event {
   public static final AttackEntityEvent field21423 = new AttackEntityEvent();
   private Entity field21424;
   private AttackEntityEvent.Nested264 field21425;

   public void method09430(Entity var1) {
      this.field21424 = var1;
      this.field21425 = AttackEntityEvent.Nested264.POST;
      super.method03208();
   }

   public AttackEntityEvent.Nested264 method09431() {
      return this.field21425;
   }

   public void method09432(Entity var1) {
      this.field21424 = var1;
   }

   public void method09433(Entity var1, CallbackInfo var2) {
      this.field21424 = var1;
      this.field21425 = AttackEntityEvent.Nested264.PRE;
      super.method03208();
      if (this.method05694()) {
         var2.cancel();
      }
   }

   public Entity method09434() {
      return this.field21424;
   }

   public void method09435(AttackEntityEvent.Nested264 var1) {
      this.field21425 = var1;
   }

   // $VF: Compiled from s
   public enum Nested264 {
      PRE,
      POST;
   }
}
