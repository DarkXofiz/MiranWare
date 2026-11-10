// Original binary: hex/api/baritone/api/command/datatypes/IDatatypeContext
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.argument.IArgConsumer;

// $VF: Compiled from s
public interface IDatatypeContext {
   IArgConsumer getConsumer();

   IBaritone getBaritone();
}
