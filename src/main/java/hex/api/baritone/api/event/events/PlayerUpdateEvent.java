// Original binary: hex/api/baritone/api/event/events/PlayerUpdateEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.event.events.type.EventState;

// $VF: Compiled from s
public final class PlayerUpdateEvent {
   private final EventState state;

   public PlayerUpdateEvent(EventState var1) {
      this.state = var1;
   }

   public final EventState getState() {
      return this.state;
   }
}
