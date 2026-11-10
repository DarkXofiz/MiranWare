// Original binary: hex/api/baritone/api/schematic/mask/PreComputedMask
package hex.api.baritone.api.schematic.mask;

// $VF: Compiled from s
final class PreComputedMask extends AbstractMask implements StaticMask {
   private final boolean[][][] mask = new boolean[this.heightY()][this.lengthZ()][this.widthX()];

   public PreComputedMask(StaticMask var1) {
      super(var1.widthX(), var1.heightY(), var1.lengthZ());

      for (int var2 = 0; var2 < this.heightY(); var2++) {
         for (int sx = 0; sx < this.lengthZ(); sx++) {
            for (int sxx = 0; sxx < this.widthX(); sxx++) {
               this.mask[var2][sx][sxx] = var1.partOfMask(sxx, var2, sx);
            }
         }
      }
   }

   @Override
   public boolean partOfMask(int var1, int var2, int var3) {
      return this.mask[var2][var3][var1];
   }
}
