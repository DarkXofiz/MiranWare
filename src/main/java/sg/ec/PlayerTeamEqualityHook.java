// Original binary: sg/ec/14mjFbVEVN05Ja9I
package sg.ec;

import net.minecraft.world.scores.PlayerTeam;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public final class PlayerTeamEqualityHook {
   private PlayerTeamEqualityHook() {
   }

   public static void method00246(PlayerTeam var0, PlayerTeam var1, CallbackInfo var2) {
      if (var0 != var1) {
         var2.cancel();
      }
   }
}
