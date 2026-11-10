// Original binary: hex/api/baritone/pathing/movement/MovementOption
package hex.api.baritone.pathing.movement;

import hex.api.baritone.api.utils.input.Input;
import java.util.stream.Stream;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public record MovementOption(Input input1, Input input2, float motionX, float motionZ) {
   private static final float SPRINT_MULTIPLIER = 1.3F;

   public float distanceToSq(float var1, float var2) {
      return Mth.abs(this.motionX() - var1) + Mth.abs(this.motionZ() - var2);
   }

   public void setInputs(MovementState var1) {
      if (this.input1 != null) {
         var1.setInput(this.input1, true);
      }

      if (this.input2 != null) {
         var1.setInput(this.input2, true);
      }
   }

   public MovementOption(Input var1, float var2, float var3) {
      this(var1, null, var2, var3);
   }

   public static Stream<MovementOption> getOptions(float var0, float var1, boolean var2) {
      return Stream.of(
         new MovementOption(Input.MOVE_FORWARD, var2 ? var0 * 1.3F : var0, var2 ? var1 * 1.3F : var1),
         new MovementOption(Input.MOVE_BACK, -var0, -var1),
         new MovementOption(Input.MOVE_LEFT, -var1, var0),
         new MovementOption(Input.MOVE_RIGHT, var1, -var0),
         new MovementOption(Input.MOVE_FORWARD, Input.MOVE_LEFT, (var2 ? var0 * 1.3F : var0) - var1, (var2 ? var1 * 1.3F : var1) + var0),
         new MovementOption(Input.MOVE_FORWARD, Input.MOVE_RIGHT, (var2 ? var0 * 1.3F : var0) + var1, (var2 ? var1 * 1.3F : var1) - var0),
         new MovementOption(Input.MOVE_BACK, Input.MOVE_LEFT, -var0 - var1, -var1 + var0),
         new MovementOption(Input.MOVE_BACK, Input.MOVE_RIGHT, -var0 + var1, -var1 - var0)
      );
   }
}
