// Original binary: hex/api/baritone/api/command/datatypes/IDatatypeFor
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;

// $VF: Compiled from s
public interface IDatatypeFor<T> extends IDatatype {
   T get(IDatatypeContext var1) throws CommandException;
}
