// Original binary: sg/ec/QG3APi51IxQgeSh9
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class SwingDurationEvent extends Event {
   public static final SwingDurationEvent field11216 = new SwingDurationEvent();
   private LivingEntity field11217;
   private CallbackInfoReturnable<Integer> field11218;

   public void method05146(LivingEntity var1, CallbackInfoReturnable<Integer> var2) {
      this.method05695(false);
      this.field11217 = var1;
      this.field11218 = var2;
      super.method03208();
   }

   public void method05147(CallbackInfoReturnable<Integer> var1) {
      this.field11218 = var1;
   }

   public LivingEntity method05148() {
      return this.field11217;
   }

   public void method05149(LivingEntity var1) {
      this.field11217 = var1;
   }

   public CallbackInfoReturnable<Integer> method05150() {
      return this.field11218;
   }
}
