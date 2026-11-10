// Original binary: hex/api/baritone/process/ExploreProcess
package hex.api.baritone.process;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.cache.ICachedWorld;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalComposite;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import hex.api.baritone.api.pathing.goals.GoalYLevel;
import hex.api.baritone.api.process.IExploreProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.api.utils.MyChunkPos;
import hex.api.baritone.cache.CachedWorld;
import hex.api.baritone.utils.BaritoneProcessHelper;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.ChunkPos;

// $VF: Compiled from s
public final class ExploreProcess extends BaritoneProcessHelper implements IExploreProcess {
   private BlockPos explorationOrigin;
   private ExploreProcess.IChunkFilter filter;
   private int distanceCompleted;
   private static final String Алц = "Алц";
   private static final String АлМ = "АлМ";
   private static final String Ал5 = "Ал5";
   private static final String АлЖ = "АлЖ";
   private static final String Ало = "Ало";
   private static final String АлК = "АлК";

   private static Goal createGoal(int var0, int var1) {
      return Baritone.settings().exploreMaintainY.value == -1 ? new GoalXZ(var0, var1) : new GoalXZ(var0, var1)      // $VF: Compiled from s
 {
         @Override
         public double heuristic(int var1, int var2, int var3) {
            return super.heuristic(var1, var2, var3) + GoalYLevel.calculate(Baritone.settings().exploreMaintainY.value, var2);
         }
      };
   }

   @Override
   public String displayName0() {
      return "Exploring around "
         + this.explorationOrigin
         + ", distance completed "
         + this.distanceCompleted
         + ", currently going to "
         + new GoalComposite(this.closestUncachedChunks(this.explorationOrigin, this.calcFilter()));
   }

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      if (var1) {
         this.logDirect(Алц);
         if (Baritone.settings().notificationOnExploreFinished.value) {
            this.logNotification(АлМ, true);
         }

         this.onLostControl();
         return null;
      } else {
         ExploreProcess.IChunkFilter var3 = this.calcFilter();
         if (!Baritone.settings().disableCompletionCheck.value && var3.countRemain() == 0) {
            this.logDirect(Ал5);
            if (Baritone.settings().notificationOnExploreFinished.value) {
               this.logNotification(АлЖ, false);
            }

            this.onLostControl();
            return null;
         } else {
            Goal[] sx = this.closestUncachedChunks(this.explorationOrigin, var3);
            if (sx == null) {
               this.logDebug(Ало);
               return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
            } else {
               return new PathingCommand(new GoalComposite(sx), PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH);
            }
         }
      }
   }

   @Override
   public void applyJsonFilter(Path var1, boolean var2) throws Exception {
      this.filter = new ExploreProcess.JsonChunkFilter(var1, var2);
   }

   public ExploreProcess.IChunkFilter calcFilter() {
      ExploreProcess.IChunkFilter var1;
      if (this.filter != null) {
         var1 = new ExploreProcess.EitherChunk(this, this.filter, new ExploreProcess.BaritoneChunkCache());
      } else {
         var1 = new ExploreProcess.BaritoneChunkCache();
      }

      return var1;
   }

   public ExploreProcess(Baritone var1) {
      super(var1);
   }


   private Goal[] closestUncachedChunks(BlockPos var1, ExploreProcess.IChunkFilter var2) {
      int var3 = var1.getX() >> 4;
      int sx = var1.getZ() >> 4;
      int sxx = Math.min(var2.countRemain(), Baritone.settings().exploreChunkSetMinimumSize.value);
      List<BlockPos> sxxx = new ArrayList<>();
      int sxxxx = Baritone.settings().worldExploringChunkOffset.value;
      int sxxxxx = this.distanceCompleted;

      while (true) {
         for (int sxxxxxx = -sxxxxx; sxxxxxx <= sxxxxx; sxxxxxx++) {
            int sxxxxxxx = sxxxxx - Math.abs(sxxxxxx);
            int sxxxxxxxx = 0;

            while (sxxxxxxxx < 2) {
               int sxxxxxxxxx = (sxxxxxxxx * 2 - 1) * sxxxxxxx;
               int sxxxxxxxxxx = Math.abs(sxxxxxx) + Math.abs(sxxxxxxxxx);
               if (sxxxxxxxxxx != sxxxxx) {
                  throw new IllegalStateException(String.format(АлК, sxxxxxx, sxxxxxxxxx, sxxxxxxxxxx, sxxxxx));
               }

               switch (var2.isAlreadyExplored(var3 + sxxxxxx, sx + sxxxxxxxxx)) {
                  case NOT_EXPLORED:
                  default:
                     int sxxxxxxxxxxx = (var3 + sxxxxxx << 4) + 8;
                     int sxxxxxxxxxxxx = (sx + sxxxxxxxxx << 4) + 8;
                     int sxxxxxxxxxxxxx = sxxxx << 4;
                     if (sxxxxxx < 0) {
                        sxxxxxxxxxxx -= sxxxxxxxxxxxxx;
                     } else {
                        sxxxxxxxxxxx += sxxxxxxxxxxxxx;
                     }

                     if (sxxxxxxxxx < 0) {
                        sxxxxxxxxxxxx -= sxxxxxxxxxxxxx;
                     } else {
                        sxxxxxxxxxxxx += sxxxxxxxxxxxxx;
                     }

                     sxxx.add(new BlockPos(sxxxxxxxxxxx, 0, sxxxxxxxxxxxx));
                  case EXPLORED:
                     sxxxxxxxx++;
                     break;
                  case UNKNOWN:
                     return null;
               }
            }
         }

         if (sxxxxx % 10 == 0) {
            sxx = Math.min(var2.countRemain(), Baritone.settings().exploreChunkSetMinimumSize.value);
         }

         if (sxxx.size() >= sxx) {
            return (hex.api.baritone.api.pathing.goals.Goal[]) sxxx.stream().map(var0 -> createGoal(var0.getX(), var0.getZ())).toArray(Goal[]::new);
         }

         if (sxxx.isEmpty()) {
            this.distanceCompleted = sxxxxx + 1;
         }

         sxxxxx++;
      }
   }

   @Override
   public boolean isActive() {
      return this.explorationOrigin != null;
   }

   @Override
   public void explore(int var1, int var2) {
      this.explorationOrigin = new BlockPos(var1, 0, var2);
      this.distanceCompleted = 0;
   }

   @Override
   public void onLostControl() {
      this.explorationOrigin = null;
   }

   // $VF: Compiled from s
   private class BaritoneChunkCache implements ExploreProcess.IChunkFilter {
      private final ICachedWorld cache = ExploreProcess.this.baritone.getWorldProvider().getCurrentWorld().getCachedWorld();
      private static final int АЛ弟 = 0;

      @Override
      public int countRemain() {
         return АЛ弟;
      }

      @Override
      public ExploreProcess.Status isAlreadyExplored(int var1, int var2) {
         int var3 = var1 << 4;
         int sx = var2 << 4;
         if (this.cache.isCached(var3, sx)) {
            return ExploreProcess.Status.EXPLORED;
         } else if (!((CachedWorld)this.cache).regionLoaded(var3, sx)) {
            Baritone.getExecutor().execute(() -> ((CachedWorld)this.cache).tryLoadFromDisk(var3 >> 9, sx >> 9));
            return ExploreProcess.Status.UNKNOWN;
         } else {
            return ExploreProcess.Status.NOT_EXPLORED;
         }
      }

   }

   // $VF: Compiled from s
   private class EitherChunk implements ExploreProcess.IChunkFilter {
      private final ExploreProcess.IChunkFilter a;
      private final ExploreProcess.IChunkFilter b;

      private EitherChunk(ExploreProcess var1, ExploreProcess.IChunkFilter var2, ExploreProcess.IChunkFilter var3) {
         Objects.requireNonNull(var1);
         super();
         this.a = var2;
         this.b = var3;
      }

      @Override
      public ExploreProcess.Status isAlreadyExplored(int var1, int var2) {
         return this.a.isAlreadyExplored(var1, var2) == ExploreProcess.Status.EXPLORED ? ExploreProcess.Status.EXPLORED : this.b.isAlreadyExplored(var1, var2);
      }

      @Override
      public int countRemain() {
         return Math.min(this.a.countRemain(), this.b.countRemain());
      }
   }

   // $VF: Compiled from s
   private interface IChunkFilter {
      int countRemain();

      ExploreProcess.Status isAlreadyExplored(int var1, int var2);
   }

   // $VF: Compiled from s
   private class JsonChunkFilter implements ExploreProcess.IChunkFilter {
      private final boolean invert;
      private final LongOpenHashSet inFilter;
      private final MyChunkPos[] positions;
      private static final int бУИ = 0;


      @Override
      public int countRemain() {
         if (!this.invert) {
            return бУИ;
         }

         int var1 = 0;
         ExploreProcess.BaritoneChunkCache sx = ExploreProcess.this.new BaritoneChunkCache();

         for (MyChunkPos sxx : this.positions) {
            if (sx.isAlreadyExplored(sxx.x, sxx.z) != ExploreProcess.Status.EXPLORED) {
               if (++var1 >= Baritone.settings().exploreChunkSetMinimumSize.value) {
                  return var1;
               }
            }
         }

         return var1;
      }

      private JsonChunkFilter(Path var2, boolean var3) throws Exception {
         this.invert = var3;
         Gson var4 = new GsonBuilder().create();
         this.positions = (MyChunkPos[])var4.fromJson(new InputStreamReader(Files.newInputStream(var2)), MyChunkPos[].class);
         ExploreProcess.this.logDirect("Loaded " + this.positions.length + " positions");
         this.inFilter = new LongOpenHashSet();

         for (MyChunkPos sx : this.positions) {
            this.inFilter.add(ChunkPos.asLong(sx.x, sx.z));
         }
      }

      @Override
      public ExploreProcess.Status isAlreadyExplored(int var1, int var2) {
         return this.inFilter.contains(ChunkPos.asLong(var1, var2)) ^ this.invert ? ExploreProcess.Status.EXPLORED : ExploreProcess.Status.UNKNOWN;
      }
   }

   // $VF: Compiled from s
   private enum Status {
      EXPLORED,
      NOT_EXPLORED,
      UNKNOWN;
   }
}
