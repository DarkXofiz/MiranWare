// Original binary: sg/ec/uloLwKgXTNn53mQE
package sg.ec;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.BlockPlaceContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class BlockPlaceEvent extends Event {
   public static final BlockPlaceEvent field24606 = new BlockPlaceEvent();
   private BlockPlaceContext field24607;

   public BlockPlaceContext method10967() {
      return this.field24607;
   }

   public void method10968(BlockPlaceContext var1) {
      this.field24607 = var1;
   }

   public void method10969(BlockPlaceContext var1, CallbackInfoReturnable<InteractionResult> var2) {
      if (((InteractionResult)var2.getReturnValue()).consumesAction()) {
         this.field24607 = var1;
         super.method03208();
      }
   }
}
