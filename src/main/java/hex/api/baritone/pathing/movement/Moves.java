// Original binary: hex/api/baritone/pathing/movement/Moves
package hex.api.baritone.pathing.movement;

import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.pathing.movement.movements.MovementAscend;
import hex.api.baritone.pathing.movement.movements.MovementDescend;
import hex.api.baritone.pathing.movement.movements.MovementDiagonal;
import hex.api.baritone.pathing.movement.movements.MovementDownward;
import hex.api.baritone.pathing.movement.movements.MovementFall;
import hex.api.baritone.pathing.movement.movements.MovementParkour;
import hex.api.baritone.pathing.movement.movements.MovementPillar;
import hex.api.baritone.pathing.movement.movements.MovementTraverse;
import hex.api.baritone.utils.pathing.MutableMoveResult;
import net.minecraft.core.Direction;

// $VF: Compiled from s
public enum Moves {
   DOWNWARD(0, -1, 0)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementDownward(var1.getBaritone(), var2, var2.below());
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementDownward.cost(var1, var2, var3, var4);
      }
   },
   PILLAR(0, 1, 0)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementPillar(var1.getBaritone(), var2, var2.above());
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementPillar.cost(var1, var2, var3, var4);
      }
   },
   TRAVERSE_NORTH(0, 0, -1)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementTraverse(var1.getBaritone(), var2, var2.north());
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementTraverse.cost(var1, var2, var3, var4, var2, var4 - 1);
      }
   },
   TRAVERSE_SOUTH(0, 0, 1)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementTraverse(var1.getBaritone(), var2, var2.south());
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementTraverse.cost(var1, var2, var3, var4, var2, var4 + 1);
      }
   },
   TRAVERSE_EAST(1, 0, 0)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementTraverse(var1.getBaritone(), var2, var2.east());
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementTraverse.cost(var1, var2, var3, var4, var2 + 1, var4);
      }
   },
   TRAVERSE_WEST(-1, 0, 0)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementTraverse(var1.getBaritone(), var2, var2.west());
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementTraverse.cost(var1, var2, var3, var4, var2 - 1, var4);
      }
   },
   ASCEND_NORTH(0, 1, -1)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementAscend(var1.getBaritone(), var2, new BetterBlockPos(var2.x, var2.y + 1, var2.z - 1));
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementAscend.cost(var1, var2, var3, var4, var2, var4 - 1);
      }
   },
   ASCEND_SOUTH(0, 1, 1)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementAscend(var1.getBaritone(), var2, new BetterBlockPos(var2.x, var2.y + 1, var2.z + 1));
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementAscend.cost(var1, var2, var3, var4, var2, var4 + 1);
      }
   },
   ASCEND_EAST(1, 1, 0)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementAscend(var1.getBaritone(), var2, new BetterBlockPos(var2.x + 1, var2.y + 1, var2.z));
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementAscend.cost(var1, var2, var3, var4, var2 + 1, var4);
      }
   },
   ASCEND_WEST(-1, 1, 0)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return new MovementAscend(var1.getBaritone(), var2, new BetterBlockPos(var2.x - 1, var2.y + 1, var2.z));
      }

      @Override
      public double cost(CalculationContext var1, int var2, int var3, int var4) {
         return MovementAscend.cost(var1, var2, var3, var4, var2 - 1, var4);
      }
   },
   DESCEND_EAST(1, -1, 0, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return var3.y == var2.y - 1
            ? new MovementDescend(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z))
            : new MovementFall(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z));
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDescend.cost(var1, var2, var3, var4, var2 + 1, var4, var5);
      }
   },
   DESCEND_WEST(-1, -1, 0, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return var3.y == var2.y - 1
            ? new MovementDescend(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z))
            : new MovementFall(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z));
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDescend.cost(var1, var2, var3, var4, var2 - 1, var4, var5);
      }
   },
   DESCEND_NORTH(0, -1, -1, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return var3.y == var2.y - 1
            ? new MovementDescend(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z))
            : new MovementFall(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z));
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDescend.cost(var1, var2, var3, var4, var2, var4 - 1, var5);
      }
   },
   DESCEND_SOUTH(0, -1, 1, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return var3.y == var2.y - 1
            ? new MovementDescend(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z))
            : new MovementFall(var1.getBaritone(), var2, new BetterBlockPos(var3.x, var3.y, var3.z));
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDescend.cost(var1, var2, var3, var4, var2, var4 + 1, var5);
      }
   },
   DIAGONAL_NORTHEAST(1, 0, -1, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return new MovementDiagonal(var1.getBaritone(), var2, Direction.NORTH, Direction.EAST, var3.y - var2.y);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDiagonal.cost(var1, var2, var3, var4, var2 + 1, var4 - 1, var5);
      }
   },
   DIAGONAL_NORTHWEST(-1, 0, -1, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return new MovementDiagonal(var1.getBaritone(), var2, Direction.NORTH, Direction.WEST, var3.y - var2.y);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDiagonal.cost(var1, var2, var3, var4, var2 - 1, var4 - 1, var5);
      }
   },
   DIAGONAL_SOUTHEAST(1, 0, 1, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return new MovementDiagonal(var1.getBaritone(), var2, Direction.SOUTH, Direction.EAST, var3.y - var2.y);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDiagonal.cost(var1, var2, var3, var4, var2 + 1, var4 + 1, var5);
      }
   },
   DIAGONAL_SOUTHWEST(-1, 0, 1, false, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         MutableMoveResult var3 = new MutableMoveResult();
         this.apply(var1, var2.x, var2.y, var2.z, var3);
         return new MovementDiagonal(var1.getBaritone(), var2, Direction.SOUTH, Direction.WEST, var3.y - var2.y);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementDiagonal.cost(var1, var2, var3, var4, var2 - 1, var4 + 1, var5);
      }
   },
   PARKOUR_NORTH(0, 0, -4, true, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return MovementParkour.cost(var1, var2, Direction.NORTH);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementParkour.cost(var1, var2, var3, var4, Direction.NORTH, var5);
      }
   },
   PARKOUR_SOUTH(0, 0, 4, true, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return MovementParkour.cost(var1, var2, Direction.SOUTH);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementParkour.cost(var1, var2, var3, var4, Direction.SOUTH, var5);
      }
   },
   PARKOUR_EAST(4, 0, 0, true, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return MovementParkour.cost(var1, var2, Direction.EAST);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementParkour.cost(var1, var2, var3, var4, Direction.EAST, var5);
      }
   },
   PARKOUR_WEST(-4, 0, 0, true, true)   // $VF: Compiled from s
 {
      @Override
      public Movement apply0(CalculationContext var1, BetterBlockPos var2) {
         return MovementParkour.cost(var1, var2, Direction.WEST);
      }

      @Override
      public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
         MovementParkour.cost(var1, var2, var3, var4, Direction.WEST, var5);
      }
   };

   public final boolean dynamicXZ;
   public final boolean dynamicY;
   public final int xOffset;
   public final int yOffset;
   public final int zOffset;

   Moves(int var3, int var4, int var5, boolean var6, boolean var7) {
      this.xOffset = var3;
      this.yOffset = var4;
      this.zOffset = var5;
      this.dynamicXZ = var6;
      this.dynamicY = var7;
   }

   Moves(int var3, int var4, int var5) {
      this(var3, var4, var5, false, false);
   }

   public abstract Movement apply0(CalculationContext var1, BetterBlockPos var2);

   public void apply(CalculationContext var1, int var2, int var3, int var4, MutableMoveResult var5) {
      if (!this.dynamicXZ && !this.dynamicY) {
         var5.x = var2 + this.xOffset;
         var5.y = var3 + this.yOffset;
         var5.z = var4 + this.zOffset;
         var5.cost = this.cost(var1, var2, var3, var4);
      } else {
         throw new UnsupportedOperationException("Movements with dynamic offset must override `apply`");
      }
   }

   public double cost(CalculationContext var1, int var2, int var3, int var4) {
      throw new UnsupportedOperationException("Movements must override `cost` or `apply`");
   }
}
