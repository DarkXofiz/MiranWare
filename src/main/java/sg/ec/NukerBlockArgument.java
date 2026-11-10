// Original binary: sg/ec/rv5dkUlRR02bz4ng
package sg.ec;

import java.util.List;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class NukerBlockArgument extends AbstractBlockArgument {
   @Override
   protected String errorMessage(String var1) {
      return "Блок не найден: " + var1;
   }

   @Override
   protected List<Block> blocks() {
      return CommandManager.INSTANCE.method04650(NukerCommand.class).field24123;
   }
}
