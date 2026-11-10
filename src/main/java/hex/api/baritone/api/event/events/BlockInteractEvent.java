// Original binary: hex/api/baritone/api/event/events/BlockInteractEvent
package hex.api.baritone.api.event.events;

import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public final class BlockInteractEvent {
   private final BlockPos pos;
   private final BlockInteractEvent.Type type;

   public final BlockInteractEvent.Type getType() {
      return this.type;
   }

   public final BlockPos getPos() {
      return this.pos;
   }

   public BlockInteractEvent(BlockPos var1, BlockInteractEvent.Type var2) {
      this.pos = var1;
      this.type = var2;
   }

   // $VF: Compiled from s
   public enum Type {
      START_BREAK,
      USE;
   }
}
