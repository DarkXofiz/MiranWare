// Original binary: hex/api/baritone/api/event/events/ChunkEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.event.events.type.EventState;

// $VF: Compiled from s
public final class ChunkEvent {
   private final EventState state;
   private final ChunkEvent.Type type;
   private final int x;
   private final int z;

   public EventState getState() {
      return this.state;
   }

   public ChunkEvent.Type getType() {
      return this.type;
   }

   public boolean isPostPopulate() {
      return this.state == EventState.POST && this.type.isPopulate();
   }

   public int getX() {
      return this.x;
   }

   public int getZ() {
      return this.z;
   }

   public ChunkEvent(EventState var1, ChunkEvent.Type var2, int var3, int var4) {
      this.state = var1;
      this.type = var2;
      this.x = var3;
      this.z = var4;
   }

   // $VF: Compiled from s
   public enum Type {
      LOAD,
      UNLOAD,
      POPULATE_FULL,
      POPULATE_PARTIAL;

      public final boolean isPopulate() {
         return this == POPULATE_FULL || this == POPULATE_PARTIAL;
      }
   }
}
