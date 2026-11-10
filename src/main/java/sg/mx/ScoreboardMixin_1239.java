// Original binary: sg/mx/ZAXMAiXf5fRtlLhi
package sg.mx;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ScoreboardHooks;

// $VF: Compiled from s
@Mixin(Scoreboard.class)
public class ScoreboardMixin_1239 {
   @Inject(
      method = {
            "onTeamAdded(Lnet/minecraft/world/scores/PlayerTeam;)V",
            "onTeamChanged(Lnet/minecraft/world/scores/PlayerTeam;)V",
            "onTeamRemoved(Lnet/minecraft/world/scores/PlayerTeam;)V"
      },
      at = @At("HEAD")
   )
   private void hex$bumpTeamFormat(PlayerTeam var1, CallbackInfo var2) {
      ScoreboardHooks.method07403();
   }
}
