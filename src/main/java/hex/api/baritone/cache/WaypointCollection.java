// Original binary: hex/api/baritone/cache/WaypointCollection
package hex.api.baritone.cache;

import hex.api.baritone.api.cache.IWaypoint;
import hex.api.baritone.api.cache.IWaypointCollection;
import hex.api.baritone.api.cache.Waypoint;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// $VF: Compiled from s
public class WaypointCollection implements IWaypointCollection {
   private static final long WAYPOINT_MAGIC_VALUE = 121977993584L;
   private final Path directory;
   private final Map<IWaypoint.Tag, Set<IWaypoint>> waypoints;
   private static final long б_э = 0;
   private static final long б_О = 0;

   private synchronized void save(IWaypoint.Tag var1) {
      Path var2 = this.directory.resolve(var1.name().toLowerCase() + ".mp4");

      try (
         FileOutputStream sx = new FileOutputStream(var2.toFile());
         BufferedOutputStream sxx = new BufferedOutputStream(sx);
         DataOutputStream sxxx = new DataOutputStream(sxx);
      ) {
         sxxx.writeLong(б_О);
         sxxx.writeLong(this.waypoints.get(var1).size());

         for (IWaypoint sxxxx : this.waypoints.get(var1)) {
            sxxx.writeUTF(sxxxx.getName());
            sxxx.writeLong(sxxxx.getCreationTimestamp());
            sxxx.writeInt(sxxxx.getLocation().getX());
            sxxx.writeInt(sxxxx.getLocation().getY());
            sxxx.writeInt(sxxxx.getLocation().getZ());
         }
      } catch (IOException var14) {
      }
   }

   WaypointCollection(Path var1) {
      this.directory = var1;
      if (!Files.exists(var1)) {
         try {
            Files.createDirectories(var1);
         } catch (IOException var3) {
         }
      }

      this.waypoints = new HashMap<>();
      this.load();
   }

   @Override
   public void removeWaypoint(IWaypoint var1) {
      if (this.waypoints.get(var1.getTag()).remove(var1)) {
         this.save(var1.getTag());
      }
   }

   @Override
   public Set<IWaypoint> getAllWaypoints() {
      return this.waypoints.values().stream().flatMap(Collection::stream).collect(Collectors.toSet());
   }

   @Override
   public IWaypoint getMostRecentByTag(IWaypoint.Tag var1) {
      return this.waypoints.get(var1).stream().min(Comparator.comparingLong(var0 -> -var0.getCreationTimestamp())).orElse(null);
   }

   @Override
   public Set<IWaypoint> getByTag(IWaypoint.Tag var1) {
      return Collections.unmodifiableSet(this.waypoints.get(var1));
   }


   private void load() {
      for (IWaypoint.Tag var4 : IWaypoint.Tag.values()) {
         this.load(var4);
      }
   }

   @Override
   public void addWaypoint(IWaypoint var1) {
      if (this.waypoints.get(var1.getTag()).add(var1)) {
         this.save(var1.getTag());
      }
   }

   private synchronized void load(IWaypoint.Tag var1) {
      this.waypoints.put(var1, new HashSet<>());
      Path var2 = this.directory.resolve(var1.name().toLowerCase() + ".mp4");
      if (Files.exists(var2)) {
         try (
            FileInputStream sx = new FileInputStream(var2.toFile());
            BufferedInputStream sxx = new BufferedInputStream(sx);
            DataInputStream sxxx = new DataInputStream(sxx);
         ) {
            long sxxxx = sxxx.readLong();
            if (sxxxx != б_э) {
               throw new IOException("Bad magic value " + sxxxx);
            }

            long sxxxxx = sxxx.readLong();

            while (sxxxxx-- > 0L) {
               String sxxxxxx = sxxx.readUTF();
               long sxxxxxxx = sxxx.readLong();
               int sxxxxxxxx = sxxx.readInt();
               int sxxxxxxxxx = sxxx.readInt();
               int sxxxxxxxxxx = sxxx.readInt();
               this.waypoints.get(var1).add(new Waypoint(sxxxxxx, var1, new BetterBlockPos(sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx), sxxxxxxx));
            }
         } catch (IOException var22) {
         }
      }
   }
}
