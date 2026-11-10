// Original binary: hex/api/baritone/api/command/datatypes/ForDirection
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.Locale;
import java.util.stream.Stream;
import net.minecraft.core.Direction;

// $VF: Compiled from s
public enum ForDirection implements IDatatypeFor<Direction> {
   INSTANCE;

   public Direction get(IDatatypeContext var1) throws CommandException {
      return Direction.valueOf(var1.getConsumer().getString().toUpperCase(Locale.US));
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      return new TabCompleteHelper()
         .append(Stream.of(Direction.values()).map(Direction::getName).map(String::toLowerCase))
         .filterPrefix(var1.getConsumer().getString())
         .stream();
   }
}
