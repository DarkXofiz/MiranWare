// Original binary: sg/ec/RqXn9bNlaKCu9Rlu
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.phys.AABB;

// $VF: Compiled from s
public final class WardenSpawnerTracker {
   public static final int field11663 = -2070;
   public static final int field11664 = 0;
   public static final int field11665 = 0;
   public static final int field11666 = 0;
   private static final int field11667 = 0;
   private static final int field11668 = 0;
   private static final Pattern field11669 = Pattern.compile(WardenSpawnerTracker.field11694);
   private final List<BlockPos> field11670 = new ArrayList<>();
   private final List<WardenSpawnerTracker.Nested162> field11671 = new ArrayList<>();
   private final Map<Long, Long> field11672 = new HashMap<>();
   private int field11673;
   private int field11674;
   private static final int field11675 = Integer.MIN_VALUE;
   private static final long field11676 = -1L;
   private static final long field11677 = -1L;
   private static final int field11678 = Integer.MIN_VALUE;
   private static final double field11679 = -2070.0;
   private static final double field11680 = -1921.0;
   private static final double field11681 = -2076.0;
   private static final double field11682 = -1929.0;
   private static final double field11683 = -2070.0;
   private static final double field11684 = -60.0;
   private static final double field11685 = -2076.0;
   private static final double field11686 = -1920.0;
   private static final double field11687 = -32.0;
   private static final double field11688 = -1928.0;
   private static final long field11689 = 60L;
   private static final long field11690 = 1000L;
   private static final int field11691 = Integer.MAX_VALUE;
   private static final float field11692 = -1.0F;
   private static final long field11693 = 4294967295L;
   private static final String field11694 = "(\\d{1,2}):(\\d{2})\\s*$";

   public WardenSpawnerTracker() {
      this.field11673 = field11675;
      this.field11674 = -1;
   }

   public List<BlockPos> method05348(ClientLevel var1, LocalPlayer var2, int var3) {
      this.method05352(var1, var2, var3);
      return List.copyOf(this.field11670);
   }

   public long method05349(BlockPos var1) {
      if (var1 == null) {
         return field11676;
      }

      Long var2 = this.field11672.get(method05354(var1));
      if (var2 != null) {
         return var2;
      }

      WardenSpawnerTracker.Nested162 var3 = this.method05361(var1);
      return var3 == null ? field11677 : var3.method05363();
   }

   private void method05350(LevelChunk var1) {
      for (var var3 : var1.getBlockEntities().entrySet()) {
         BlockPos var4 = (BlockPos)var3.getKey();
         if (var4.getY() >= -60 && var4.getY() <= -35 && method05360(var4.getX(), var4.getZ())) {
            BlockState var5 = ((BlockEntity)var3.getValue()).getBlockState();
            if (var5.is(Blocks.CHEST) || var5.is(Blocks.TRAPPED_CHEST)) {
               this.field11670.add(var4);
            }
         }
      }
   }

   private void method05351(ClientLevel var1, LocalPlayer var2) {
      AABB var3 = new AABB(field11683, field11684, field11685, field11686, field11687, field11688);

      for (ArmorStand var5 : var1.getEntitiesOfClass(ArmorStand.class, var3)) {
         Matcher var6 = field11669.matcher(var5.getName().getString());
         if (var6.find()) {
            long var7 = (Integer.parseInt(var6.group(1)) * field11689 + Integer.parseInt(var6.group(2))) * field11690;
            BlockPos var9 = var5.blockPosition();
            this.field11672.put(method05354(var9), var7);
            BlockPos var10 = this.method05358(var9);
            if (var10 != null && this.method05361(var10) == null) {
               this.field11671.add(new WardenSpawnerTracker.Nested162(var10, var7, this.field11674));
            }
         }
      }
   }

   private void method05352(ClientLevel var1, LocalPlayer var2, int var3) {
      if (var1 != null && var2 != null) {
         if (this.field11673 != var2.tickCount || this.field11674 != var3) {
            this.field11673 = var2.tickCount;
            this.field11674 = var3;
            this.field11670.clear();
            this.field11672.clear();
            if (var1.dimension() != Level.OVERWORLD) {
               this.field11671.clear();
            } else {
               this.method05357(var1);
               this.method05351(var1, var2);

               for (WardenSpawnerTracker.Nested162 var5 : this.field11671) {
                  Long var6 = this.field11672.get(method05354(var5.field11695));
                  if (var6 != null) {
                     var5.method05362(var6, var3);
                  }
               }

               this.field11671.removeIf(var0 -> var0.method05363() <= 0L);
            }
         }
      }
   }

   public void method05353() {
      this.field11670.clear();
      this.field11671.clear();
      this.field11672.clear();
      this.field11673 = field11678;
   }

   private static long method05354(BlockPos var0) {
      return (long)var0.getX() << 32 | var0.getZ() & field11693;
   }

   public float method05356(BlockPos var1) {
      WardenSpawnerTracker.Nested162 var2 = this.method05361(var1);
      return var2 != null && var2.field11697 > 0L ? (float)var2.method05363() / (float)var2.field11697 : field11692;
   }

   private void method05357(ClientLevel var1) {
      int var2 = SectionPos.blockToSectionCoord(-2070);
      int var3 = SectionPos.blockToSectionCoord(-1921);
      int var4 = SectionPos.blockToSectionCoord(-2076);
      int var5 = SectionPos.blockToSectionCoord(-1929);

      for (int var6 = var2; var6 <= var3; var6++) {
         for (int var7 = var4; var7 <= var5; var7++) {
            LevelChunk var8 = var1.getChunkSource().getChunk(var6, var7, false);
            if (var8 != null) {
               this.method05350(var8);
            }
         }
      }
   }

   private BlockPos method05358(BlockPos var1) {
      BlockPos var2 = null;
      int var3 = field11691;

      for (BlockPos var5 : this.field11670) {
         if (var5.getX() == var1.getX() && var5.getZ() == var1.getZ()) {
            int var6 = Math.abs(var5.getY() - var1.getY());
            if (var6 < var3) {
               var3 = var6;
               var2 = var5;
            }
         }
      }

      return var2;
   }

   public boolean method05359(BlockPos var1) {
      return this.method05361(var1) != null;
   }

   public static boolean method05360(double var0, double var2) {
      return var0 >= field11679 && var0 <= field11680 && var2 >= field11681 && var2 <= field11682;
   }

   private WardenSpawnerTracker.Nested162 method05361(BlockPos var1) {
      for (WardenSpawnerTracker.Nested162 var3 : this.field11671) {
         if (var3.field11698 == this.field11674 && var3.field11695.getX() == var1.getX() && var3.field11695.getZ() == var1.getZ()) {
            return var3;
         }
      }

      return null;
   }

   // $VF: Compiled from s
   private static final class Nested162 {
      private final BlockPos field11695;
      private final ElapsedTimer field11696 = new ElapsedTimer();
      private long field11697;
      private int field11698;

      private Nested162(BlockPos var1, long var2, int var4) {
         this.field11695 = var1;
         this.field11697 = var2;
         this.field11698 = var4;
      }

      private void method05362(long var1, int var3) {
         if (var1 != this.field11697 || var3 != this.field11698) {
            this.field11697 = var1;
            this.field11696.method04694();
            this.field11698 = var3;
         }
      }

      private long method05363() {
         return Math.max(0L, this.field11697 - this.field11696.method04693());
      }
   }
}
