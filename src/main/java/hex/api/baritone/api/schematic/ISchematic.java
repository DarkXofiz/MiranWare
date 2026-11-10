// Original binary: hex/api/baritone/api/schematic/ISchematic
package hex.api.baritone.api.schematic;

import java.util.List;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public interface ISchematic {
   BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5);

   default void reset() {
   }

   default boolean inSchematic(int var1, int var2, int var3, BlockState var4) {
      return var1 >= 0 && var1 < this.widthX() && var2 >= 0 && var2 < this.heightY() && var3 >= 0 && var3 < this.lengthZ();
   }

   int lengthZ();

   default int size(Axis var1) {
      switch (var1) {
         case X:
            return this.widthX();
         case Y:
            return this.heightY();
         case Z:
            return this.lengthZ();
         default:
            throw new UnsupportedOperationException(var1 + "");
      }
   }

   int heightY();

   int widthX();
}
