// Original binary: sg/mx/FHNNBtsl8gwVt9Na
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ItemFeatureVariables;

// $VF: Compiled from s
@Mixin(UseDuration.class)
public class UseDurationMixin {
   @Inject(method = "get", at = @At("RETURN"), cancellable = true)
   private void hmiSwapProperty(ItemStack var1, ClientLevel var2, ItemOwner var3, int var4, CallbackInfoReturnable<Float> var5) {
      Minecraft var6 = Minecraft.getInstance();
      if (var6.player != null && var6.player.getUseItem() == var1) {
         Double var7 = ItemFeatureVariables.field24990.field25115.get(var1.getItem().toString());
         if (var7 != null) {
            var5.setReturnValue(var7.floatValue());
         }
      }
   }
}
