// Original binary: hex/api/baritone/api/cache/Waypoint
package hex.api.baritone.api.cache;

import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.Date;

// $VF: Compiled from s
public class Waypoint implements IWaypoint {
   private final String name;
   private final IWaypoint.Tag tag;
   private final long creationTimestamp;
   private final BetterBlockPos location;
   private static final String Ощ = "Ощ";

   public Waypoint(String var1, IWaypoint.Tag var2, BetterBlockPos var3) {
      this(var1, var2, var3, System.currentTimeMillis());
   }

   @Override
   public String toString() {
      return String.format(Ощ, this.name, BetterBlockPos.from(this.location).toString(), new Date(this.creationTimestamp).toString());
   }

   public Waypoint(String var1, IWaypoint.Tag var2, BetterBlockPos var3, long var4) {
      this.name = var1;
      this.tag = var2;
      this.location = var3;
      this.creationTimestamp = var4;
   }

   @Override
   public long getCreationTimestamp() {
      return this.creationTimestamp;
   }


   @Override
   public boolean equals(Object var1) {
      if (var1 == null) {
         return false;
      } else {
         return !(var1 instanceof IWaypoint var2)
            ? false
            : this.name.equals(var2.getName()) && this.tag == var2.getTag() && this.location.equals(var2.getLocation());
      }
   }

   @Override
   public int hashCode() {
      return this.name.hashCode() ^ this.tag.hashCode() ^ this.location.hashCode() ^ Long.hashCode(this.creationTimestamp);
   }

   @Override
   public String getName() {
      return this.name;
   }

   @Override
   public BetterBlockPos getLocation() {
      return this.location;
   }

   @Override
   public IWaypoint.Tag getTag() {
      return this.tag;
   }
}
