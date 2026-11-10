// Original binary: hex/api/baritone/api/command/datatypes/IDatatypePost
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;

// $VF: Compiled from s
public interface IDatatypePost<T, O> extends IDatatype {
   T apply(IDatatypeContext var1, O var2) throws CommandException;
}
