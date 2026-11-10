// Original binary: hex/api/baritone/api/schematic/mask/StaticMask
package hex.api.baritone.api.schematic.mask;

import hex.api.baritone.api.schematic.mask.operator.BinaryOperatorMask;
import hex.api.baritone.api.schematic.mask.operator.NotMask;
import hex.api.baritone.api.utils.BooleanBinaryOperators;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public interface StaticMask extends Mask {
   default StaticMask compute() {
      return new PreComputedMask(this);
   }

   boolean partOfMask(int var1, int var2, int var3);

   default StaticMask xor(StaticMask var1) {
      return new BinaryOperatorMask.Static(this, var1, BooleanBinaryOperators.XOR);
   }

   default StaticMask not() {
      return new NotMask.Static(this);
   }

   @Override
   default boolean partOfMask(int var1, int var2, int var3, BlockState var4) {
      return this.partOfMask(var1, var2, var3);
   }

   default StaticMask intersection(StaticMask var1) {
      return new BinaryOperatorMask.Static(this, var1, BooleanBinaryOperators.AND);
   }

   default StaticMask union(StaticMask var1) {
      return new BinaryOperatorMask.Static(this, var1, BooleanBinaryOperators.OR);
   }
}
