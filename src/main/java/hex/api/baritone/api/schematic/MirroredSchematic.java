// Original binary: hex/api/baritone/api/schematic/MirroredSchematic
package hex.api.baritone.api.schematic;

import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class MirroredSchematic implements ISchematic {
   private final ISchematic schematic;
   private final Mirror mirror;
   private static final String ААв = "ААв";
   private static final String ААр = "ААр";

   @Override
   public int heightY() {
      return this.schematic.heightY();
   }

   public MirroredSchematic(ISchematic var1, Mirror var2) {
      this.schematic = var1;
      this.mirror = var2;
   }

   private static BlockState mirror(BlockState var0, Mirror var1) {
      return var0 == null ? null : var0.mirror(var1);
   }

   @Override
   public BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5) {
      return mirror(
         this.schematic
            .desiredState(
               mirrorX(var1, this.widthX(), this.mirror),
               var2,
               mirrorZ(var3, this.lengthZ(), this.mirror),
               mirror(var4, this.mirror),
               mirror(var5, this.mirror)
            ),
         this.mirror
      );
   }

   @Override
   public boolean inSchematic(int var1, int var2, int var3, BlockState var4) {
      return this.schematic.inSchematic(mirrorX(var1, this.widthX(), this.mirror), var2, mirrorZ(var3, this.lengthZ(), this.mirror), mirror(var4, this.mirror));
   }


   private static int mirrorX(int var0, int var1, Mirror var2) {
      switch (var2) {
         case NONE:
         case LEFT_RIGHT:
            return var0;
         case FRONT_BACK:
            return var1 - var0 - 1;
         default:
            throw new IllegalArgumentException(ААв);
      }
   }

   private static List<BlockState> mirror(List<BlockState> var0, Mirror var1) {
      return var0 == null ? null : var0.stream().map(var1x -> mirror(var1x, var1)).collect(Collectors.toList());
   }

   @Override
   public void reset() {
      this.schematic.reset();
   }

   @Override
   public int lengthZ() {
      return this.schematic.lengthZ();
   }

   @Override
   public int widthX() {
      return this.schematic.widthX();
   }

   private static int mirrorZ(int var0, int var1, Mirror var2) {
      switch (var2) {
         case NONE:
         case FRONT_BACK:
            return var0;
         case LEFT_RIGHT:
            return var1 - var0 - 1;
         default:
            throw new IllegalArgumentException(ААр);
      }
   }
}
