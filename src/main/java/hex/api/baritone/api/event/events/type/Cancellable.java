// Original binary: hex/api/baritone/api/event/events/type/Cancellable
package hex.api.baritone.api.event.events.type;

// $VF: Compiled from s
public class Cancellable implements ICancellable {
   private boolean cancelled;

   @Override
   public final void cancel() {
      this.cancelled = true;
   }

   @Override
   public final boolean isCancelled() {
      return this.cancelled;
   }
}
