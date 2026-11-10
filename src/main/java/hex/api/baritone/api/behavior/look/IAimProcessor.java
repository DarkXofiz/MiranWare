// Original binary: hex/api/baritone/api/behavior/look/IAimProcessor
package hex.api.baritone.api.behavior.look;

import hex.api.baritone.api.utils.Rotation;

// $VF: Compiled from s
public interface IAimProcessor {
   Rotation peekRotation(Rotation var1);

   ITickableAimProcessor fork();
}
