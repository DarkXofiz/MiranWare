// Original binary: sg/mx/u7wFwONNT0ooT4gJ
package sg.mx;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.BlockPlaceEvent;

// $VF: Compiled from s
@Mixin(BlockItem.class)
public class BlockItemMixin {
   @Inject(method = "place(Lnet/minecraft/world/item/context/BlockPlaceContext;)Lnet/minecraft/world/InteractionResult;", at = @At("TAIL"))
   private void place(BlockPlaceContext var1, CallbackInfoReturnable<InteractionResult> var2) {
      BlockPlaceEvent.field24606.method10969(var1, var2);
   }
}
