// Original binary: hex/api/baritone/utils/PlayerMovementInput
package hex.api.baritone.utils;

import hex.api.baritone.api.utils.input.Input;
import net.minecraft.client.player.ClientInput;
import net.minecraft.world.phys.Vec2;
import sg.ec.PlayerInputEvent;

// $VF: Compiled from s
public class PlayerMovementInput extends ClientInput {
   private final InputOverrideHandler handler;
   private static final double 诶хя = 0;
   private static final double 诶хI = 0;


   PlayerMovementInput(InputOverrideHandler var1) {
      this.handler = var1;
   }

   @Override
   public void tick() {
      float var1 = 0.0F;
      float sx = 0.0F;
      boolean sxx = this.handler.isInputForcedDown(Input.JUMP);
      boolean sxxx = this.handler.isInputForcedDown(Input.MOVE_FORWARD);
      if (sxxx) {
         sx++;
      }

      boolean sxxxx = this.handler.isInputForcedDown(Input.MOVE_BACK);
      if (sxxxx) {
         sx--;
      }

      boolean sxxxxx = this.handler.isInputForcedDown(Input.MOVE_LEFT);
      if (sxxxxx) {
         var1++;
      }

      boolean sxxxxxx = this.handler.isInputForcedDown(Input.MOVE_RIGHT);
      if (sxxxxxx) {
         var1--;
      }

      boolean sxxxxxxx = this.handler.isInputForcedDown(Input.SNEAK);
      if (sxxxxxxx) {
         var1 = (float)(var1 * 诶хя);
         sx = (float)(sx * 诶хI);
      }

      boolean sxxxxxxxx = this.handler.isInputForcedDown(Input.SPRINT) || this.handler.isForcedSprint();
      PlayerInputEvent.field06252.method02724(sx, var1, sxx, sxxxxxxx, sxxxxxxxx);
      this.keyPresses = PlayerInputEvent.field06252.method11171();
      this.moveVector = new Vec2(PlayerInputEvent.field06252.method11166(), PlayerInputEvent.field06252.method11161());
   }
}
