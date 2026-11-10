// Original binary: sg/ec/91DBipa3EXg5UFOq
package sg.ec;

import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class NameTagRenderEvent extends Event {
   public static final NameTagRenderEvent field05154 = new NameTagRenderEvent();
   private Entity field05155;

   public void method02157(Entity var1) {
      this.field05155 = var1;
   }

   public Entity method02158() {
      return this.field05155;
   }

   public void method02159(Entity var1, CallbackInfo var2) {
      if (var1 != null && this.method05698()) {
         this.field05155 = var1;
         super.method03208();
         if (this.method05694()) {
            var2.cancel();
         }
      }
   }
}
