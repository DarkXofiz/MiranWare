// Original binary: sg/ec/4BWgJKuQQpYEeMGy
package sg.ec;

import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.PlayerSkin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class AbstractClientPlayerHooks {
   private AbstractClientPlayerHooks() {
   }

   public static void method00802(AbstractClientPlayer var0, CallbackInfoReturnable<PlayerSkin> var1) {
      if (CapeTextureUtils.field17855) {
         if (var0 instanceof LocalPlayer || FriendManager.INSTANCE.method00172(var0)) {
            if (!ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CLIENT_CAPE)) {
               var1.setReturnValue(CapeTextureUtils.method07324((PlayerSkin)var1.getReturnValue()));
            }
         }
      }
   }
}
