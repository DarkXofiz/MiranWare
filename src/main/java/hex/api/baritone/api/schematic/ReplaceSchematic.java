// Original binary: hex/api/baritone/api/schematic/ReplaceSchematic
package hex.api.baritone.api.schematic;

import hex.api.baritone.api.utils.BlockOptionalMetaLookup;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class ReplaceSchematic extends MaskSchematic {
   private final BlockOptionalMetaLookup filter;
   private final Boolean[][][] cache;

   @Override
   public void reset() {
      for (int var1 = 0; var1 < this.cache.length; var1++) {
         for (int sx = 0; sx < this.cache[0].length; sx++) {
            for (int sxx = 0; sxx < this.cache[0][0].length; sxx++) {
               this.cache[var1][sx][sxx] = null;
            }
         }
      }
   }

   @Override
   protected boolean partOfMask(int var1, int var2, int var3, BlockState var4) {
      if (this.cache[var1][var2][var3] == null) {
         this.cache[var1][var2][var3] = this.filter.has(var4);
      }

      return this.cache[var1][var2][var3];
   }

   public ReplaceSchematic(ISchematic var1, BlockOptionalMetaLookup var2) {
      super(var1);
      this.filter = var2;
      this.cache = new Boolean[this.widthX()][this.heightY()][this.lengthZ()];
   }
}
