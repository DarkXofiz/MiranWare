// Original binary: sg/mx/6YluphAzcA5aGYzb
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.PlayerSkin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.AbstractClientPlayerHooks;
import sg.ec.BotClientLevel;

// $VF: Compiled from s
@Mixin(AbstractClientPlayer.class)
public abstract class AbstractClientPlayerMixin {
   @Inject(method = "getPlayerInfo", at = @At("HEAD"), cancellable = true)
   private void hexBotPlayerInfo(CallbackInfoReturnable<PlayerInfo> var1) {
      AbstractClientPlayer var2 = (AbstractClientPlayer)(Object)this;
      if (var2.level() instanceof BotClientLevel var3) {
         var1.setReturnValue(var3.sink().getPlayerInfo(var2.getUUID()));
      } else {
         if (Minecraft.getInstance().getConnection() == null) {
            var1.setReturnValue(null);
         }
      }
   }

   @Inject(method = "getSkin", at = @At("RETURN"), cancellable = true)
   private void hexCustomCape(CallbackInfoReturnable<PlayerSkin> var1) {
      AbstractClientPlayerHooks.method00802((AbstractClientPlayer)(Object)this, var1);
   }
}
