// Original binary: hex/api/baritone/utils/accessor/IClientChunkProvider
package hex.api.baritone.utils.accessor;

import net.minecraft.client.multiplayer.ClientChunkCache;

// $VF: Compiled from s
public interface IClientChunkProvider {
   IChunkArray extractReferenceArray();

   ClientChunkCache createThreadSafeCopy();
}
