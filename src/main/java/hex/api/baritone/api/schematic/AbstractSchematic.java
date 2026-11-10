// Original binary: hex/api/baritone/api/schematic/AbstractSchematic
package hex.api.baritone.api.schematic;

// $VF: Compiled from s
public abstract class AbstractSchematic implements ISchematic {
   protected int x;
   protected int y;
   protected int z;

   public AbstractSchematic() {
      this(0, 0, 0);
   }

   public AbstractSchematic(int var1, int var2, int var3) {
      this.x = var1;
      this.y = var2;
      this.z = var3;
   }

   @Override
   public int heightY() {
      return this.y;
   }

   @Override
   public int lengthZ() {
      return this.z;
   }

   @Override
   public int widthX() {
      return this.x;
   }
}
