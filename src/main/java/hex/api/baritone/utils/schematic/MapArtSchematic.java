// Original binary: hex/api/baritone/utils/schematic/MapArtSchematic
package hex.api.baritone.utils.schematic;

import hex.api.baritone.api.schematic.IStaticSchematic;
import hex.api.baritone.api.schematic.MaskSchematic;
import java.util.OptionalInt;
import java.util.function.Predicate;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class MapArtSchematic extends MaskSchematic {
   private final int[][] heightMap;
   private static final int бие = 0;

   private static int[][] generateHeightMap(IStaticSchematic var0) {
      int[][] var1 = new int[var0.widthX()][var0.lengthZ()];
      int sx = 0;

      for (int sxx = 0; sxx < var0.widthX(); sxx++) {
         for (int sxxx = 0; sxxx < var0.lengthZ(); sxxx++) {
            BlockState[] sxxxx = var0.getColumn(sxx, sxxx);
            OptionalInt sxxxxx = lastIndexMatching(sxxxx, var0x -> !(var0x.getBlock() instanceof AirBlock));
            if (sxxxxx.isPresent()) {
               var1[sxx][sxxx] = sxxxxx.getAsInt();
            } else {
               sx++;
               var1[sxx][sxxx] = бие;
            }
         }
      }

      if (sx != 0) {
      }

      return var1;
   }


   public MapArtSchematic(IStaticSchematic var1) {
      super(var1);
      this.heightMap = generateHeightMap(var1);
   }

   private static <T> OptionalInt lastIndexMatching(T[] var0, Predicate<? super T> var1) {
      for (int var2 = var0.length - 1; var2 >= 0; var2--) {
         if (var1.test(var0[var2])) {
            return OptionalInt.of(var2);
         }
      }

      return OptionalInt.empty();
   }

   @Override
   protected boolean partOfMask(int var1, int var2, int var3, BlockState var4) {
      return var2 >= this.heightMap[var1][var3];
   }
}
