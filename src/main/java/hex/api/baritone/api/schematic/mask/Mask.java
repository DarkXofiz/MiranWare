// Original binary: hex/api/baritone/api/schematic/mask/Mask
package hex.api.baritone.api.schematic.mask;

import hex.api.baritone.api.schematic.mask.operator.BinaryOperatorMask;
import hex.api.baritone.api.schematic.mask.operator.NotMask;
import hex.api.baritone.api.utils.BooleanBinaryOperators;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public interface Mask {
   int heightY();

   default Mask intersection(Mask var1) {
      return new BinaryOperatorMask(this, var1, BooleanBinaryOperators.AND);
   }

   boolean partOfMask(int var1, int var2, int var3, BlockState var4);

   int widthX();

   int lengthZ();

   default Mask union(Mask var1) {
      return new BinaryOperatorMask(this, var1, BooleanBinaryOperators.OR);
   }

   default Mask xor(Mask var1) {
      return new BinaryOperatorMask(this, var1, BooleanBinaryOperators.XOR);
   }

   default Mask not() {
      return new NotMask(this);
   }
}
