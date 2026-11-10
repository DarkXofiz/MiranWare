// Original binary: sg/ec/zTiBgpaQ5sIUttaP
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class CobwebCollisionEvent extends Event {
   public static final CobwebCollisionEvent field27868 = new CobwebCollisionEvent();
   private BlockPos field27869;

   public void method11722(BlockPos var1, Entity var2, CallbackInfo var3) {
      if (var2 instanceof LocalPlayer) {
         this.field27869 = var1;
         super.method03208();
         if (this.method05694()) {
            var3.cancel();
         }
      }
   }

   public void method11723(BlockPos var1) {
      this.field27869 = var1;
   }

   public BlockPos method11724() {
      return this.field27869;
   }
}
