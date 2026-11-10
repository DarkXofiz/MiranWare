// Original binary: hex/api/baritone/api/schematic/IStaticSchematic
package hex.api.baritone.api.schematic;

import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public interface IStaticSchematic extends ISchematic {
   BlockState getDirect(int var1, int var2, int var3);

   default BlockState[] getColumn(int var1, int var2) {
      BlockState[] var3 = new BlockState[this.heightY()];

      for (int sx = 0; sx < this.heightY(); sx++) {
         var3[sx] = this.getDirect(var1, sx, var2);
      }

      return var3;
   }
}
