// Original binary: hex/api/baritone/api/schematic/mask/AbstractMask
package hex.api.baritone.api.schematic.mask;

// $VF: Compiled from s
public abstract class AbstractMask implements Mask {
   private final int widthX;
   private final int heightY;
   private final int lengthZ;

   public AbstractMask(int var1, int var2, int var3) {
      this.widthX = var1;
      this.heightY = var2;
      this.lengthZ = var3;
   }

   @Override
   public int widthX() {
      return this.widthX;
   }

   @Override
   public int lengthZ() {
      return this.lengthZ;
   }

   @Override
   public int heightY() {
      return this.heightY;
   }
}
