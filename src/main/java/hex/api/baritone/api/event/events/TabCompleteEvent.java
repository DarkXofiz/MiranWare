// Original binary: hex/api/baritone/api/event/events/TabCompleteEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.event.events.type.Cancellable;

// $VF: Compiled from s
public final class TabCompleteEvent extends Cancellable {
   public final String prefix;
   public String[] completions;

   public TabCompleteEvent(String var1) {
      this.prefix = var1;
      this.completions = null;
   }
}
