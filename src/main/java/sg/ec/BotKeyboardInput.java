// Original binary: sg/ec/jog565TeWZp4PQRU
package sg.ec;

import net.minecraft.client.player.ClientInput;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public final class BotKeyboardInput extends ClientInput {
   private volatile Input field20563 = Input.EMPTY;

   @Override
   public void tick() {
      Input var1 = this.field20563;
      this.keyPresses = var1;
      float var2 = (var1.left() ? 1.0F : 0.0F) - (var1.right() ? 1.0F : 0.0F);
      float var3 = (var1.forward() ? 1.0F : 0.0F) - (var1.backward() ? 1.0F : 0.0F);
      this.moveVector = new Vec2(var2, var3).normalized();
   }

   public void apply(Input var1) {
      this.field20563 = var1;
   }
}
