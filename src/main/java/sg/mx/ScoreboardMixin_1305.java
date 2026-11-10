// Original binary: sg/mx/tbSrZkotEpbb8DgH
package sg.mx;

import java.util.Collection;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.Scoreboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ScoreboardEntryCache;

// $VF: Compiled from s
@Mixin(Scoreboard.class)
public class ScoreboardMixin_1305 {
   @Unique
   private ScoreboardEntryCache hex$cache;

   @Inject(method = "<init>", at = @At("RETURN"))
   private void hex$initCache(CallbackInfo var1) {
      this.hex$cache = new ScoreboardEntryCache();
   }

   @Inject(method = "listPlayerScores(Lnet/minecraft/world/scores/Objective;)Ljava/util/Collection;", at = @At("HEAD"), cancellable = true)
   private void hex$sidebarLookup(Objective var1, CallbackInfoReturnable<Collection<PlayerScoreEntry>> var2) {
      this.hex$cache.method04143(var1, var2);
   }

   @Inject(method = "listPlayerScores(Lnet/minecraft/world/scores/Objective;)Ljava/util/Collection;", at = @At("RETURN"))
   private void hex$sidebarStore(Objective var1, CallbackInfoReturnable<Collection<PlayerScoreEntry>> var2) {
      this.hex$cache.method04144(var1, (Collection<PlayerScoreEntry>)var2.getReturnValue());
   }

   @Inject(
      method = "onScoreChanged(Lnet/minecraft/world/scores/ScoreHolder;Lnet/minecraft/world/scores/Objective;Lnet/minecraft/world/scores/Score;)V",
      at = @At("HEAD")
   )
   private void hex$invalidateOnScoreChanged(CallbackInfo var1) {
      this.hex$cache.method04142();
   }

   @Inject(
      method = {
            "onScoreLockChanged(Lnet/minecraft/world/scores/ScoreHolder;Lnet/minecraft/world/scores/Objective;)V",
            "resetSinglePlayerScore(Lnet/minecraft/world/scores/ScoreHolder;Lnet/minecraft/world/scores/Objective;)V",
            "resetAllPlayerScores(Lnet/minecraft/world/scores/ScoreHolder;)V",
            "removeObjective(Lnet/minecraft/world/scores/Objective;)V",
            "onObjectiveRemoved(Lnet/minecraft/world/scores/Objective;)V",
            "onObjectiveChanged(Lnet/minecraft/world/scores/Objective;)V"
      },
      at = @At("HEAD")
   )
   private void hex$invalidateOnMutation(CallbackInfo var1) {
      this.hex$cache.method04142();
   }
}
