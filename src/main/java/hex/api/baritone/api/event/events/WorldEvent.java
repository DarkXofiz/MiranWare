// Original binary: hex/api/baritone/api/event/events/WorldEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.event.events.type.EventState;
import net.minecraft.client.multiplayer.ClientLevel;

// $VF: Compiled from s
public final class WorldEvent {
   private final ClientLevel world;
   private final EventState state;

   public final EventState getState() {
      return this.state;
   }

   public final ClientLevel getWorld() {
      return this.world;
   }

   public WorldEvent(ClientLevel var1, EventState var2) {
      this.world = var1;
      this.state = var2;
   }
}
