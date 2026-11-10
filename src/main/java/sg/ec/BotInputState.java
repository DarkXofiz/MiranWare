// Original binary: sg/ec/QDh56DZRJeB3NI0G
package sg.ec;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Input;

// $VF: Compiled from s
public final class BotInputState {
   private Input field11214;
   private boolean field11215;

   private static boolean method05143(LivingEntity var0) {
      return !var0.onGround() && !var0.isInWater() && !var0.isInLava() && !var0.onClimbable() && !var0.isPassenger();
   }

   private static boolean method05144(Input var0) {
      return var0.forward() || var0.backward() || var0.left() || var0.right();
   }

   public Input method05145(LivingEntity var1, Input var2) {
      if (!method05143(var1)) {
         boolean var3 = method05144(var2);
         this.field11214 = var3 ? var2 : null;
         this.field11215 = var3 && var1.onGround() && var2.jump();
         return var2;
      }

      if (!this.field11215 && method05144(var2)) {
         this.field11214 = var2;
      }

      return this.field11214 == null
         ? var2
         : new Input(
            this.field11214.forward(),
            this.field11214.backward(),
            this.field11214.left(),
            this.field11214.right(),
            var2.jump(),
            var2.shift(),
            this.field11214.sprint() || var2.sprint()
         );
   }
}
