// Original binary: hex/api/baritone/utils/schematic/StaticSchematic
package hex.api.baritone.utils.schematic;

import hex.api.baritone.api.schematic.AbstractSchematic;
import hex.api.baritone.api.schematic.IStaticSchematic;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class StaticSchematic extends AbstractSchematic implements IStaticSchematic {
   protected BlockState[][][] states;

   @Override
   public BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5) {
      return this.states[var1][var3][var2];
   }

   public StaticSchematic() {
   }

   @Override
   public BlockState getDirect(int var1, int var2, int var3) {
      return this.states[var1][var3][var2];
   }

   @Override
   public BlockState[] getColumn(int var1, int var2) {
      return this.states[var1][var2];
   }

   public StaticSchematic(BlockState[][][] var1) {
      this.states = var1;
      boolean var2 = var1.length == 0 || var1[0].length == 0 || var1[0][0].length == 0;
      this.x = var2 ? 0 : var1.length;
      this.z = var2 ? 0 : var1[0].length;
      this.y = var2 ? 0 : var1[0][0].length;
   }
}
