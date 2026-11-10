// Original binary: sg/mx/1htQ0aW9yVB5nZEA
package sg.mx;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Hud;
import net.minecraft.client.gui.components.PlayerTabOverlay;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.PlayerTabOverlayHooks;
import sg.ec.PlayerListEntryAccess;

// $VF: Compiled from s
@Mixin(PlayerTabOverlay.class)
public class PlayerTabOverlayMixin {
   @Shadow
   @Final
   private Minecraft minecraft;
   @Shadow
   @Final
   private Hud hud;
   @Unique
   private PlayerTabOverlayHooks hex$cache;

   @Inject(method = "<init>", at = @At("RETURN"))
   private void hex$initCache(CallbackInfo var1) {
      this.hex$cache = new PlayerTabOverlayHooks();
   }

   @Inject(method = "getPlayerInfos", at = @At("HEAD"), cancellable = true)
   private void hex$tabLookup(CallbackInfoReturnable<List<PlayerInfo>> var1) {
      this.hex$cache.method09161(this.hud.getGuiTicks(), this.hex$listedCount(), var1);
   }

   @Inject(method = "getPlayerInfos", at = @At("RETURN"))
   private void hex$tabStore(CallbackInfoReturnable<List<PlayerInfo>> var1) {
      this.hex$cache.method09162(this.hud.getGuiTicks(), this.hex$listedCount(), (List<PlayerInfo>)var1.getReturnValue());
   }

   @Inject(method = "getNameForDisplay", at = @At("HEAD"), cancellable = true)
   private void hex$nameLookup(PlayerInfo var1, CallbackInfoReturnable<Component> var2) {
      ((PlayerListEntryAccess)var1).hex$nameCache().method05957(var1, var2);
   }

   @Inject(method = "getNameForDisplay", at = @At("RETURN"))
   private void hex$nameStore(PlayerInfo var1, CallbackInfoReturnable<Component> var2) {
      ((PlayerListEntryAccess)var1).hex$nameCache().method05956(var1, (Component)var2.getReturnValue());
   }

   @Unique
   private int hex$listedCount() {
      return this.minecraft.player.connection.getListedOnlinePlayers().size();
   }
}
