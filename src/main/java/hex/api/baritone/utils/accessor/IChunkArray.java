// Original binary: hex/api/baritone/utils/accessor/IChunkArray
package hex.api.baritone.utils.accessor;

import java.util.concurrent.atomic.AtomicReferenceArray;
import net.minecraft.world.level.chunk.LevelChunk;

// $VF: Compiled from s
public interface IChunkArray {
   int centerX();

   AtomicReferenceArray<LevelChunk> getChunks();

   int viewDistance();

   void copyFrom(IChunkArray var1);

   int centerZ();
}
