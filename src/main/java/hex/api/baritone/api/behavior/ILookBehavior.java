// Original binary: hex/api/baritone/api/behavior/ILookBehavior
package hex.api.baritone.api.behavior;

import hex.api.baritone.api.behavior.look.IAimProcessor;
import hex.api.baritone.api.utils.Rotation;

// $VF: Compiled from s
public interface ILookBehavior extends IBehavior {
   IAimProcessor getAimProcessor();

   void updateTarget(Rotation var1, boolean var2);
}
