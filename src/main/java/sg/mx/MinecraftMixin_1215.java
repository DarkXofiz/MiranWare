// Original binary: sg/mx/SOkjCf1r0jpespDg
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.PlayerAnimationAccess;

// $VF: Compiled from s
@Mixin(Minecraft.class)
public abstract class MinecraftMixin_1215 {
   @Shadow
   @Nullable
   public LocalPlayer player;

   @Inject(
      method = "startAttack",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;swing(Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/component/SwingAnimation;Z)Z")
   )
   private void hmiDoAttack(CallbackInfoReturnable<Boolean> var1) {
      if (this.player instanceof PlayerAnimationAccess var2) {
         var2.hMI5_0$resetMainHandSwing(false);
      }
   }

   @Redirect(
      method = "startUseItem",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;swing(Lnet/minecraft/world/InteractionHand;Lnet/minecraft/world/item/component/SwingAnimation;Z)Z")
   )
   private boolean hmiDoItemUse(LocalPlayer var1, InteractionHand var2, net.minecraft.world.item.component.SwingAnimation var4, boolean var5) {
      if (var1 instanceof PlayerAnimationAccess var3) {
         if (var2 == InteractionHand.MAIN_HAND) {
            var3.hMI5_0$resetMainHandSwing(true);
         } else {
            var3.hMI5_0$resetOffHandSwing(true);
         }
      }

      return var1.swing(var2, var4, var5);
   }
}
