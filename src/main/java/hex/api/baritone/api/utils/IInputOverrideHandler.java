// Original binary: hex/api/baritone/api/utils/IInputOverrideHandler
package hex.api.baritone.api.utils;

import hex.api.baritone.api.behavior.IBehavior;
import hex.api.baritone.api.utils.input.Input;

// $VF: Compiled from s
public interface IInputOverrideHandler extends IBehavior {
   void setInputForceState(Input var1, boolean var2);

   boolean isInputForcedDown(Input var1);

   void setForcedSprint(boolean var1);

   boolean isForcedSprint();

   void clearAllKeys();
}
