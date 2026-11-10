// Original binary: hex/api/baritone/api/schematic/mask/operator/BinaryOperatorMask
package hex.api.baritone.api.schematic.mask.operator;

import hex.api.baritone.api.schematic.mask.AbstractMask;
import hex.api.baritone.api.schematic.mask.Mask;
import hex.api.baritone.api.schematic.mask.StaticMask;
import hex.api.baritone.api.utils.BooleanBinaryOperator;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class BinaryOperatorMask extends AbstractMask {
   private final Mask a;
   private final Mask b;
   private final BooleanBinaryOperator operator;

   private static boolean partOfMask(Mask var0, int var1, int var2, int var3, BlockState var4) {
      return var1 < var0.widthX() && var2 < var0.heightY() && var3 < var0.lengthZ() && var0.partOfMask(var1, var2, var3, var4);
   }

   public BinaryOperatorMask(Mask var1, Mask var2, BooleanBinaryOperator var3) {
      super(Math.max(var1.widthX(), var2.widthX()), Math.max(var1.heightY(), var2.heightY()), Math.max(var1.lengthZ(), var2.lengthZ()));
      this.a = var1;
      this.b = var2;
      this.operator = var3;
   }

   @Override
   public boolean partOfMask(int var1, int var2, int var3, BlockState var4) {
      return this.operator.applyAsBoolean(partOfMask(this.a, var1, var2, var3, var4), partOfMask(this.b, var1, var2, var3, var4));
   }

   // $VF: Compiled from s
   public static final class Static extends AbstractMask implements StaticMask {
      private final StaticMask a;
      private final StaticMask b;
      private final BooleanBinaryOperator operator;

      private static boolean partOfMask(StaticMask var0, int var1, int var2, int var3) {
         return var1 < var0.widthX() && var2 < var0.heightY() && var3 < var0.lengthZ() && var0.partOfMask(var1, var2, var3);
      }

      public Static(StaticMask var1, StaticMask var2, BooleanBinaryOperator var3) {
         super(Math.max(var1.widthX(), var2.widthX()), Math.max(var1.heightY(), var2.heightY()), Math.max(var1.lengthZ(), var2.lengthZ()));
         this.a = var1;
         this.b = var2;
         this.operator = var3;
      }

      @Override
      public boolean partOfMask(int var1, int var2, int var3) {
         return this.operator.applyAsBoolean(partOfMask(this.a, var1, var2, var3), partOfMask(this.b, var1, var2, var3));
      }
   }
}
