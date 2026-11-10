// Original binary: sg/mx/1E02khFSbk5ZbnJf
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.ItemDisplayNameEvent;

// $VF: Compiled from s
@Mixin(ItemStack.class)
public class ItemStackMixin {
   @ModifyReturnValue(method = "getStyledHoverName", at = @At("RETURN"))
   private Component getFormattedName(Component var1) {
      return ItemDisplayNameEvent.field23595.method10664((ItemStack)(Object)this, var1);
   }
}
