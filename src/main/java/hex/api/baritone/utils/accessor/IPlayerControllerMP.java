// Original binary: hex/api/baritone/utils/accessor/IPlayerControllerMP
package hex.api.baritone.utils.accessor;

import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public interface IPlayerControllerMP {
   BlockPos getCurrentBlock();

   void setDestroyDelay(int var1);

   boolean isHittingBlock();

   void callSyncCurrentPlayItem();

   void setIsHittingBlock(boolean var1);
}
