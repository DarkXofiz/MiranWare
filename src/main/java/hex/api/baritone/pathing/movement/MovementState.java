// Original binary: hex/api/baritone/pathing/movement/MovementState
package hex.api.baritone.pathing.movement;

import hex.api.baritone.api.pathing.movement.MovementStatus;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.input.Input;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// $VF: Compiled from s
public class MovementState {
   private MovementStatus status;
   private MovementState.MovementTarget target = new MovementState.MovementTarget();
   private final Map<Input, Boolean> inputState = new HashMap<>();

   public MovementState setStatus(MovementStatus var1) {
      this.status = var1;
      return this;
   }

   public MovementState setTarget(MovementState.MovementTarget var1) {
      this.target = var1;
      return this;
   }

   public MovementState.MovementTarget getTarget() {
      return this.target;
   }

   public Map<Input, Boolean> getInputStates() {
      return this.inputState;
   }

   public MovementState setInput(Input var1, boolean var2) {
      this.inputState.put(var1, var2);
      return this;
   }

   public MovementStatus getStatus() {
      return this.status;
   }

   // $VF: Compiled from s
   public static class MovementTarget {
      public Rotation rotation;
      private boolean forceRotations;

      public boolean hasToForceRotations() {
         return this.forceRotations;
      }

      public final Optional<Rotation> getRotation() {
         return Optional.ofNullable(this.rotation);
      }

      public MovementTarget(Rotation var1, boolean var2) {
         this.rotation = var1;
         this.forceRotations = var2;
      }

      public MovementTarget() {
         this(null, false);
      }
   }
}
