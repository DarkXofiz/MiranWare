// Original binary: sg/ec/JOWaWY2hENUZVFJ8
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class MultiPlayerGameModeHooks {
   private MultiPlayerGameModeHooks() {
   }

   public static void method04003(Player var0, InteractionHand var1, CallbackInfoReturnable<InteractionResult> var2) {
      if (var0 == Minecraft.getInstance().player) {
         ItemUseEvent.field05973.method02443(var1, var2);
      }
   }
}
