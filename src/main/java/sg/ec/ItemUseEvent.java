// Original binary: sg/ec/A1DLQ0e9o6d7AdnE
package sg.ec;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class ItemUseEvent extends Event {
   public static final ItemUseEvent field05973 = new ItemUseEvent();
   private InteractionHand field05974;

   public void method02443(InteractionHand var1, CallbackInfoReturnable<InteractionResult> var2) {
      this.method05695(false);
      this.field05974 = var1;
      super.method03208();
      if (this.method05694()) {
         var2.setReturnValue(InteractionResult.CONSUME);
      }
   }

   public void method02444(InteractionHand var1) {
      this.field05974 = var1;
   }

   public InteractionHand method02445() {
      return this.field05974;
   }
}
