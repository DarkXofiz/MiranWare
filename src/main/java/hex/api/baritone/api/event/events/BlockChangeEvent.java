// Original binary: hex/api/baritone/api/event/events/BlockChangeEvent
package hex.api.baritone.api.event.events;

import hex.api.baritone.api.utils.Pair;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class BlockChangeEvent {
   private final ChunkPos chunk;
   private final List<Pair<BlockPos, BlockState>> blocks;

   public BlockChangeEvent(ChunkPos var1, List<Pair<BlockPos, BlockState>> var2) {
      this.chunk = var1;
      this.blocks = var2;
   }

   public ChunkPos getChunkPos() {
      return this.chunk;
   }

   public List<Pair<BlockPos, BlockState>> getBlocks() {
      return this.blocks;
   }
}
