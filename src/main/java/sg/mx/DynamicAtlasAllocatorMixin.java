// Original binary: sg/mx/RaymcdUFA4gTWOg6
package sg.mx;

import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.gui.render.DynamicAtlasAllocator;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
@Mixin(DynamicAtlasAllocator.class)
public class DynamicAtlasAllocatorMixin {
   @Shadow
   @Final
   private List<?> slots;
   @Shadow
   @Final
   private Map<?, ?> usedSlotByKey;

   @Inject(method = "hasSpaceForAll", at = @At("HEAD"), cancellable = true)
   private void hex$trivialFit(Set<?> var1, CallbackInfoReturnable<Boolean> var2) {
      if (this.usedSlotByKey.size() + var1.size() <= this.slots.size()) {
         var2.setReturnValue(true);
      }
   }
}
