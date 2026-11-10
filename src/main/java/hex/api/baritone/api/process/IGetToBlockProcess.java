// Original binary: hex/api/baritone/api/process/IGetToBlockProcess
package hex.api.baritone.api.process;

import hex.api.baritone.api.utils.BlockOptionalMeta;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public interface IGetToBlockProcess extends IBaritoneProcess {
   void getToBlock(BlockOptionalMeta var1);

   default void getToBlock(Block var1) {
      this.getToBlock(new BlockOptionalMeta(var1));
   }

   boolean blacklistClosest();
}
