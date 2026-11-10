// Original binary: hex/api/baritone/utils/pathing/Avoidance
package hex.api.baritone.utils.pathing;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.IPlayerContext;
import it.unimi.dsi.fastutil.longs.Long2DoubleOpenHashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enderman;
import net.minecraft.world.entity.monster.spider.Spider;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;

// $VF: Compiled from s
public class Avoidance {
   private final int centerX;
   private final int centerY;
   private final int centerZ;
   private final double coefficient;
   private final int radius;
   private final int radiusSq;
   private static final String АЖи = "АЖи";
   private static final double АЖщ = 0;

   public static List<Avoidance> create(IPlayerContext var0) {
      if (!Baritone.settings().avoidance.value) {
         return Collections.emptyList();
      }

      List<Avoidance> var1 = new ArrayList<>();
      double sx = Baritone.settings().mobSpawnerAvoidanceCoefficient.value;
      double sxx = Baritone.settings().mobAvoidanceCoefficient.value;
      if (sx != 1.0) {
         var0.worldData()
            .getCachedWorld()
            .getLocationsOf(АЖи, 1, var0.playerFeet().x, var0.playerFeet().z, 2)
            .forEach(var3 -> var1.add(new Avoidance(var3, sx, Baritone.settings().mobSpawnerAvoidanceRadius.value)));
      }

      if (sxx != 1.0) {
         var0.entitiesStream()
            .filter(var0x -> var0x instanceof Mob)
            .filter(var1x -> !(var1x instanceof Spider) || var0.player().getLightLevelDependentMagicValue() < АЖщ)
            .filter(var0x -> !(var0x instanceof ZombifiedPiglin) || ((ZombifiedPiglin)var0x).getLastHurtByMob() != null)
            .filter(var0x -> !(var0x instanceof Enderman) || ((Enderman)var0x).isCreepy())
            .forEach(var3 -> var1.add(new Avoidance(var3.blockPosition(), sxx, Baritone.settings().mobAvoidanceRadius.value)));
      }

      return var1;
   }

   public void applySpherical(Long2DoubleOpenHashMap var1) {
      for (int var2 = -this.radius; var2 <= this.radius; var2++) {
         for (int sx = -this.radius; sx <= this.radius; sx++) {
            for (int sxx = -this.radius; sxx <= this.radius; sxx++) {
               if (var2 * var2 + sx * sx + sxx * sxx <= this.radius * this.radius) {
                  long sxxx = BetterBlockPos.longHash(this.centerX + var2, this.centerY + sx, this.centerZ + sxx);
                  var1.put(sxxx, var1.get(sxxx) * this.coefficient);
               }
            }
         }
      }
   }


   public Avoidance(int var1, int var2, int var3, double var4, int var6) {
      this.centerX = var1;
      this.centerY = var2;
      this.centerZ = var3;
      this.coefficient = var4;
      this.radius = var6;
      this.radiusSq = var6 * var6;
   }

   public double coefficient(int var1, int var2, int var3) {
      int var4 = var1 - this.centerX;
      int sx = var2 - this.centerY;
      int sxx = var3 - this.centerZ;
      return var4 * var4 + sx * sx + sxx * sxx <= this.radiusSq ? this.coefficient : 1.0;
   }

   public Avoidance(BlockPos var1, double var2, int var4) {
      this(var1.getX(), var1.getY(), var1.getZ(), var2, var4);
   }
}
