// Original binary: hex/api/baritone/cache/WorldProvider
package hex.api.baritone.cache;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.cache.IWorldProvider;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.api.utils.Tuple;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.LevelResource;
import org.apache.commons.lang3.SystemUtils;

// $VF: Compiled from s
public class WorldProvider implements IWorldProvider {
   private static final Map<Path, WorldData> worldCache = new HashMap<>();
   private final Baritone baritone;
   private final IPlayerContext ctx;
   private WorldData currentWorld;
   private Level mcWorld;
   private static final String field00029 = "field00029";
   private static final String field00030 = "field00030";
   private static final String field00031 = "field00031";
   private static final String field00032 = "field00032";
   private static final String field00033 = "field00033";
   private static final String field00034 = "field00034";

   private Optional<Tuple<Path, Path>> getSaveDirectories(Level var1) {
      Path var3;
      Path sx;
      if (this.ctx.minecraft().hasSingleplayerServer()) {
         sx = this.ctx.minecraft().getSingleplayerServer().getWorldPath(LevelResource.ROOT);
         if (sx.relativize(this.ctx.minecraft().gameDirectory.toPath()).getNameCount() != 2) {
            sx = sx.getParent();
         }

         sx = sx.resolve(field00029);
         var3 = sx;
      } else {
         ServerData sxx = this.ctx.minecraft().getCurrentServer();
         if (sxx == null) {
            this.currentWorld = null;
            this.mcWorld = this.ctx.world();
            return Optional.empty();
         }

         String sxxx = sxx.isRealm() ? field00030 : sxx.ip;
         if (SystemUtils.IS_OS_WINDOWS) {
            sxxx = sxxx.replace(field00031, field00032);
         }

         sx = this.baritone.getDirectory().resolve(sxxx);
         var3 = this.baritone.getDirectory();
      }

      return Optional.of(new Tuple<>(sx, var3));
   }

   private Path getWorldDataDirectory(Path var1, Level var2) {
      Identifier var3 = var2.dimension().identifier();
      int sx = var2.dimensionType().logicalHeight();
      return var1.resolve(var3.getNamespace()).resolve(var3.getPath() + "_" + sx);
   }

   public final WorldData getCurrentWorld() {
      this.detectAndHandleBrokenLoading();
      return this.currentWorld;
   }

   public WorldProvider(Baritone var1) {
      this.baritone = var1;
      this.ctx = var1.getPlayerContext();
   }

   public final void closeWorld() {
      WorldData var1 = this.currentWorld;
      this.currentWorld = null;
      this.mcWorld = null;
      if (var1 != null) {
         var1.onClose();
      }
   }


   public final void initWorld(Level var1) {
      this.getSaveDirectories(var1).ifPresent(var2 -> {
         Path var3 = var2.getA();
         Path sx = var2.getB();

         try {
            Files.createDirectories(sx);
            Files.write(sx.resolve(field00033), field00034.getBytes(StandardCharsets.US_ASCII));
         } catch (IOException var10) {
         }

         Path sxx = this.getWorldDataDirectory(var3, var1);

         try {
            Files.createDirectories(sxx);
         } catch (IOException var9) {
         }

         synchronized (worldCache) {
            this.currentWorld = worldCache.computeIfAbsent(sxx, var1x -> new WorldData(var1x, var1.dimensionType(), var1.dimension()));
         }

         this.mcWorld = this.ctx.world();
      });
   }

   private void detectAndHandleBrokenLoading() {
      if (this.mcWorld != this.ctx.world()) {
         if (this.currentWorld != null) {
            this.closeWorld();
         }

         if (this.ctx.world() != null) {
            this.initWorld(this.ctx.world());
         }
      } else if (this.currentWorld == null
         && this.ctx.world() != null
         && (this.ctx.minecraft().hasSingleplayerServer() || this.ctx.minecraft().getCurrentServer() != null)) {
         this.initWorld(this.ctx.world());
      }
   }
}
