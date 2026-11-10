// Original binary: hex/api/baritone/api/schematic/MaskSchematic
package hex.api.baritone.api.schematic;

import hex.api.baritone.api.schematic.mask.Mask;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public abstract class MaskSchematic extends AbstractSchematic {
   private final ISchematic schematic;

   public MaskSchematic(ISchematic var1) {
      super(var1.widthX(), var1.heightY(), var1.lengthZ());
      this.schematic = var1;
   }

   @Override
   public boolean inSchematic(int var1, int var2, int var3, BlockState var4) {
      return this.schematic.inSchematic(var1, var2, var3, var4) && this.partOfMask(var1, var2, var3, var4);
   }

   public static MaskSchematic create(final ISchematic var0, final Mask var1) {
      return new MaskSchematic(var0)      // $VF: Compiled from s
 {
         @Override
         protected boolean partOfMask(int var1x, int var2, int var3, BlockState var4) {
            return var1.partOfMask(var1x, var2, var3, var4);
         }
      };
   }

   @Override
   public BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5) {
      return this.schematic.desiredState(var1, var2, var3, var4, var5);
   }

   protected abstract boolean partOfMask(int var1, int var2, int var3, BlockState var4);
}
