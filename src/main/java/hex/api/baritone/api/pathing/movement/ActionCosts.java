// Original binary: hex/api/baritone/api/pathing/movement/ActionCosts
package hex.api.baritone.api.pathing.movement;

// $VF: Compiled from s
public interface ActionCosts {
   double WALK_ONE_BLOCK_COST = 4.63284688441047;
   double WALK_ONE_IN_WATER_COST = 9.09090909090909;
   double WALK_ONE_OVER_SOUL_SAND_COST = 9.26569376882094;
   double LADDER_UP_ONE_COST = 8.51063829787234;
   double LADDER_DOWN_ONE_COST = 6.666666666666667;
   double SNEAK_ONE_BLOCK_COST = 15.384615384615383;
   double SPRINT_ONE_BLOCK_COST = 3.563791874554526;
   double SPRINT_MULTIPLIER = 0.7692444761225944;
   double WALK_OFF_BLOCK_COST = 3.7062775075283763;
   double CENTER_AFTER_FALL_COST = 0.9265693768820937;
   double COST_INF = 1000000.0;
   double[] FALL_N_BLOCKS_COST = generateFallNBlocksCost();
   double FALL_1_25_BLOCKS_COST = distanceToTicks(1.25);
   double FALL_0_25_BLOCKS_COST = distanceToTicks(0.25);
   double JUMP_ONE_BLOCK_COST = FALL_1_25_BLOCKS_COST - FALL_0_25_BLOCKS_COST;

   static double oldFormula(double var0) {
      return -3.92 * (99.0 - 49.5 * (Math.pow(0.98, var0) + 1.0) - var0);
   }

   static double distanceToTicks(double var0) {
      if (var0 == 0.0) {
         return 0.0;
      }

      double var2 = var0;
      int sx = 0;

      while (true) {
         double sxx = velocity(sx);
         if (var2 <= sxx) {
            return sx + var2 / sxx;
         }

         var2 -= sxx;
         sx++;
      }
   }

   static double[] generateFallNBlocksCost() {
      double[] var0 = new double[4097];

      for (int sx = 0; sx < 4097; sx++) {
         var0[sx] = distanceToTicks(sx);
      }

      return var0;
   }

   static double velocity(int var0) {
      return (Math.pow(0.98, var0) - 1.0) * -3.92;
   }
}
