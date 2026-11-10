// Original binary: hex/api/baritone/api/pathing/movement/MovementStatus
package hex.api.baritone.api.pathing.movement;

// $VF: Compiled from s
public enum MovementStatus {
   PREPPING(false),
   WAITING(false),
   RUNNING(false),
   SUCCESS(true),
   UNREACHABLE(true),
   FAILED(true),
   CANCELED(true);

   private final boolean complete;

   MovementStatus(boolean var3) {
      this.complete = var3;
   }

   public final boolean isComplete() {
      return this.complete;
   }
}
