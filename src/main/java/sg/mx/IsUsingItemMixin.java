// Original binary: sg/mx/3Lydy4arAdL3m2eB
package sg.mx;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.IsUsingItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ItemFeatureVariables;

// $VF: Compiled from s
@Mixin(IsUsingItem.class)
public class IsUsingItemMixin {
   @Inject(method = "get", at = @At("RETURN"), cancellable = true)
   private void hmiSwapProperty(ItemStack var1, ClientLevel var2, LivingEntity var3, int var4, ItemDisplayContext var5, CallbackInfoReturnable<Boolean> var6) {
      if (var3 != null && var3.getUseItem() == var1) {
         Boolean var7 = ItemFeatureVariables.field24990.field25113.get(var1.getItem().toString());
         if (var7 != null) {
            var6.setReturnValue(var7);
         }
      }
   }
}
