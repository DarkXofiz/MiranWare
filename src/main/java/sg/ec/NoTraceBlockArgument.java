// Original binary: sg/ec/9u6pxTVdAF0mnPcO
package sg.ec;

import java.util.List;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class NoTraceBlockArgument extends AbstractBlockArgument {
   @Override
   protected List<Block> blocks() {
      return CommandManager.INSTANCE.method04650(NotraceCommand.class).field18407;
   }

   @Override
   protected String errorMessage(String var1) {
      return "Unknown block: " + var1;
   }
}
