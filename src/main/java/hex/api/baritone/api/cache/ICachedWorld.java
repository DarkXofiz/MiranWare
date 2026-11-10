// Original binary: hex/api/baritone/api/cache/ICachedWorld
package hex.api.baritone.api.cache;

import java.util.ArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.chunk.LevelChunk;

// $VF: Compiled from s
public interface ICachedWorld {
   void reloadAllFromDisk();

   ArrayList<BlockPos> getLocationsOf(String var1, int var2, int var3, int var4, int var5);

   void queueForPacking(LevelChunk var1);

   ICachedRegion getRegion(int var1, int var2);

   void save();

   boolean isCached(int var1, int var2);
}
