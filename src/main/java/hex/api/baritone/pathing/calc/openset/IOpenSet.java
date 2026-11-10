// Original binary: hex/api/baritone/pathing/calc/openset/IOpenSet
package hex.api.baritone.pathing.calc.openset;

import hex.api.baritone.pathing.calc.PathNode;

// $VF: Compiled from s
public interface IOpenSet {
   void update(PathNode var1);

   void insert(PathNode var1);

   boolean isEmpty();

   PathNode removeLowest();
}
