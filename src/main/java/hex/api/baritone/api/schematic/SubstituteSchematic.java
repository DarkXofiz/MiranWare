// Original binary: hex/api/baritone/api/schematic/SubstituteSchematic
package hex.api.baritone.api.schematic;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

// $VF: Compiled from s
public class SubstituteSchematic extends AbstractSchematic {
   private final ISchematic schematic;
   private final Map<Block, List<Block>> substitutions;
   private final Map<BlockState, Map<Block, BlockState>> blockStateCache = new HashMap<>();

   public SubstituteSchematic(ISchematic var1, Map<Block, List<Block>> var2) {
      super(var1.widthX(), var1.heightY(), var1.lengthZ());
      this.schematic = var1;
      this.substitutions = var2;
   }

   @Override
   public boolean inSchematic(int var1, int var2, int var3, BlockState var4) {
      return this.schematic.inSchematic(var1, var2, var3, var4);
   }

   private <T extends Comparable<T>> BlockState copySingleProp(BlockState var1, BlockState var2, Property<T> var3) {
      return var2.setValue(var3, var1.getValue(var3));
   }

   @Override
   public BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5) {
      BlockState var6 = this.schematic.desiredState(var1, var2, var3, var4, var5);
      Block sx = var6.getBlock();
      if (!this.substitutions.containsKey(sx)) {
         return var6;
      }

      var sxx = this.substitutions.get(sx);
      if (sxx.contains(var4.getBlock()) && !(var4.getBlock() instanceof AirBlock)) {
         return this.withBlock(var6, var4.getBlock());
      }

      for (Block sxxx : sxx) {
         if (sxxx instanceof AirBlock) {
            return var4.getBlock() instanceof AirBlock ? var4 : Blocks.AIR.defaultBlockState();
         }

         for (BlockState sxxxx : var5) {
            if (sxxx.equals(sxxxx.getBlock())) {
               return this.withBlock(var6, sxxxx.getBlock());
            }
         }
      }

      return sxx.get(0).defaultBlockState();
   }

   private BlockState withBlock(BlockState var1, Block var2) {
      if (this.blockStateCache.containsKey(var1) && this.blockStateCache.get(var1).containsKey(var2)) {
         return this.blockStateCache.get(var1).get(var2);
      }

      var var3 = var1.getProperties();
      BlockState sx = var2.defaultBlockState();

      for (Property sxx : var3) {
         try {
            sx = this.copySingleProp(var1, sx, sxx);
         } catch (IllegalArgumentException var8) {
         }
      }

      this.blockStateCache.computeIfAbsent(var1, var0 -> new HashMap<>()).put(var2, sx);
      return sx;
   }
}
