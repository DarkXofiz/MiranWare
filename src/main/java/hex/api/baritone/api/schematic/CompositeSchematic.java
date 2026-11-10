// Original binary: hex/api/baritone/api/schematic/CompositeSchematic
package hex.api.baritone.api.schematic;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class CompositeSchematic extends AbstractSchematic {
   private final List<CompositeSchematicEntry> schematics = new ArrayList<>();
   private CompositeSchematicEntry[] schematicArr;
   private static final String А5Г = "А5Г";

   private CompositeSchematicEntry getSchematic(int var1, int var2, int var3, BlockState var4) {
      for (CompositeSchematicEntry var8 : this.schematicArr) {
         if (var1 >= var8.x && var2 >= var8.y && var3 >= var8.z && var8.schematic.inSchematic(var1 - var8.x, var2 - var8.y, var3 - var8.z, var4)) {
            return var8;
         }
      }

      return null;
   }

   @Override
   public void reset() {
      for (CompositeSchematicEntry var4 : this.schematicArr) {
         var4.schematic.reset();
      }
   }

   private void recalcArr() {
      this.schematicArr = this.schematics.toArray(new CompositeSchematicEntry[0]);

      for (CompositeSchematicEntry var4 : this.schematicArr) {
         this.x = Math.max(this.x, var4.x + var4.schematic.widthX());
         this.y = Math.max(this.y, var4.y + var4.schematic.heightY());
         this.z = Math.max(this.z, var4.z + var4.schematic.lengthZ());
      }
   }

   @Override
   public boolean inSchematic(int var1, int var2, int var3, BlockState var4) {
      CompositeSchematicEntry var5 = this.getSchematic(var1, var2, var3, var4);
      return var5 != null && var5.schematic.inSchematic(var1 - var5.x, var2 - var5.y, var3 - var5.z, var4);
   }


   @Override
   public BlockState desiredState(int var1, int var2, int var3, BlockState var4, List<BlockState> var5) {
      CompositeSchematicEntry var6 = this.getSchematic(var1, var2, var3, var4);
      if (var6 == null) {
         throw new IllegalStateException(А5Г);
      } else {
         return var6.schematic.desiredState(var1 - var6.x, var2 - var6.y, var3 - var6.z, var4, var5);
      }
   }

   public CompositeSchematic(int var1, int var2, int var3) {
      super(var1, var2, var3);
      this.recalcArr();
   }

   public void put(ISchematic var1, int var2, int var3, int var4) {
      this.schematics.add(new CompositeSchematicEntry(var1, var2, var3, var4));
      this.recalcArr();
   }
}
