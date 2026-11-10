// Original binary: hex/api/baritone/api/behavior/look/ITickableAimProcessor
package hex.api.baritone.api.behavior.look;

import hex.api.baritone.api.utils.Rotation;

// $VF: Compiled from s
public interface ITickableAimProcessor extends IAimProcessor {
   void tick();

   void advance(int var1);

   Rotation nextRotation(Rotation var1);
}
