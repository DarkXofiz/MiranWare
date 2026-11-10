// Original binary: sg/mx/Hxm1Rxc8IA8U6enk
package sg.mx;

import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.PlayerTeamEqualityHook;

// $VF: Compiled from s
@Mixin(Scoreboard.class)
public abstract class ScoreboardMixin {
   @Shadow
   @Nullable
   public abstract PlayerTeam getPlayersTeam(String var1);

   @Inject(method = "removePlayerFromTeam*", at = @At("HEAD"), cancellable = true)
   public void removeScoreHolderFromTeam(String var1, PlayerTeam var2, CallbackInfo var3) {
      PlayerTeamEqualityHook.method00246(this.getPlayersTeam(var1), var2, var3);
   }
}
