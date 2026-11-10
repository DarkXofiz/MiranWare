// Original binary: sg/ec/Z47mV1hAL7oicNCF
package sg.ec;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class PlayerMovementActionEvent extends Event {
   public static final PlayerMovementActionEvent field15333 = new PlayerMovementActionEvent();
   private PlayerMovementActionEvent.Nested199 field15334 = PlayerMovementActionEvent.Nested199.VELOCITY;

   public void method06802(Player var1, boolean var2) {
      if (!var1.level().isClientSide()) {
         var1.setSprinting(var2);
      } else {
         this.field15334 = PlayerMovementActionEvent.Nested199.SPRINT;
         super.method03208();
         if (this.method05697()) {
            this.method05695(false);
         } else {
            var1.setSprinting(var2);
         }
      }
   }

   public void method06803(Player var1, Vec3 var2) {
      if (!var1.level().isClientSide()) {
         var1.setDeltaMovement(var2);
      } else {
         this.field15334 = PlayerMovementActionEvent.Nested199.VELOCITY;
         super.method03208();
         if (this.method05697()) {
            this.method05695(false);
         } else {
            var1.setDeltaMovement(var2);
         }
      }
   }

   public PlayerMovementActionEvent.Nested199 method06804() {
      return this.field15334;
   }

   // $VF: Compiled from s
   public enum Nested199 {
      VELOCITY,
      SPRINT;
   }
}
