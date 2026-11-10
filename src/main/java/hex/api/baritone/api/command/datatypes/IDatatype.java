// Original binary: hex/api/baritone/api/command/datatypes/IDatatype
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import java.util.stream.Stream;

// $VF: Compiled from s
public interface IDatatype {
   Stream<String> tabComplete(IDatatypeContext var1) throws CommandException;
}
