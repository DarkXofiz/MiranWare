// Original binary: hex/api/baritone/api/event/events/ChatEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.event.events.type.Cancellable;

// $VF: Compiled from s
public final class ChatEvent extends Cancellable {
   private final String message;

   public final String getMessage() {
      return this.message;
   }

   public ChatEvent(String var1) {
      this.message = var1;
   }
}
