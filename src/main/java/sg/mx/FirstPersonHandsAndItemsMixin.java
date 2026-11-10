package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.FirstPersonHandsAndItems;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.HeldItemRenderEvent;
import sg.ec.HeldItemRenderHooks;

@Mixin(FirstPersonHandsAndItems.class)
public abstract class FirstPersonHandsAndItemsMixin {
   @ModifyExpressionValue(method = "extractRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getViewXRot(F)F"))
   private float renderItemPitch(float var1) {
      return HeldItemRenderHooks.method05664(Minecraft.getInstance(), var1);
   }

   @ModifyExpressionValue(method = "extractRenderState", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getViewYRot(F)F"))
   private float renderItemYaw(float var1) {
      return HeldItemRenderHooks.method05661(Minecraft.getInstance(), var1);
   }

   @ModifyExpressionValue(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;getMainHandItem()Lnet/minecraft/world/item/ItemStack;"))
   private ItemStack updateHeldItemsMainHand(ItemStack var1) {
      return HeldItemRenderEvent.field00682.method00316(Minecraft.getInstance().player, var1);
   }
}
