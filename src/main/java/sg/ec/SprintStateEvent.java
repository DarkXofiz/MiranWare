// Original binary: sg/ec/ILMmCLhbJb0gQNDC
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class SprintStateEvent extends Event {
   public static final SprintStateEvent field08731 = new SprintStateEvent();
   private boolean field08732;

   public void method03879(boolean var1) {
      this.field08732 = var1;
   }

   public boolean method03880() {
      return this.field08732;
   }

   public void method03881(LivingEntity var1, boolean var2, CallbackInfo var3) {
      if (var2 && var1 instanceof LocalPlayer) {
         this.field08732 = true;
         super.method03208();
         if (!this.field08732) {
            var3.cancel();
         }
      }
   }
}
