// Original binary: hex/api/baritone/api/schematic/mask/operator/NotMask
package hex.api.baritone.api.schematic.mask.operator;

import hex.api.baritone.api.schematic.mask.AbstractMask;
import hex.api.baritone.api.schematic.mask.Mask;
import hex.api.baritone.api.schematic.mask.StaticMask;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class NotMask extends AbstractMask {
   private final Mask source;

   @Override
   public boolean partOfMask(int var1, int var2, int var3, BlockState var4) {
      return !this.source.partOfMask(var1, var2, var3, var4);
   }

   public NotMask(Mask var1) {
      super(var1.widthX(), var1.heightY(), var1.lengthZ());
      this.source = var1;
   }

   // $VF: Compiled from s
   public static final class Static extends AbstractMask implements StaticMask {
      private final StaticMask source;

      public Static(StaticMask var1) {
         super(var1.widthX(), var1.heightY(), var1.lengthZ());
         this.source = var1;
      }

      @Override
      public boolean partOfMask(int var1, int var2, int var3) {
         return !this.source.partOfMask(var1, var2, var3);
      }
   }
}
