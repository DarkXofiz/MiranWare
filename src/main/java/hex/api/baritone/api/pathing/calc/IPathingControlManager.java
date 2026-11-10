// Original binary: hex/api/baritone/api/pathing/calc/IPathingControlManager
package hex.api.baritone.api.pathing.calc;

import hex.api.baritone.api.process.IBaritoneProcess;
import hex.api.baritone.api.process.PathingCommand;
import java.util.Optional;

// $VF: Compiled from s
public interface IPathingControlManager {
   Optional<PathingCommand> mostRecentCommand();

   Optional<IBaritoneProcess> mostRecentInControl();

   void registerProcess(IBaritoneProcess var1);
}
