// Original binary: hex/api/baritone/api/cache/IWaypointCollection
package hex.api.baritone.api.cache;

import java.util.Set;

// $VF: Compiled from s
public interface IWaypointCollection {
   IWaypoint getMostRecentByTag(IWaypoint.Tag var1);

   void addWaypoint(IWaypoint var1);

   Set<IWaypoint> getAllWaypoints();

   void removeWaypoint(IWaypoint var1);

   Set<IWaypoint> getByTag(IWaypoint.Tag var1);
}
