// Original binary: hex/api/baritone/api/command/datatypes/ForAxis
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.Locale;
import java.util.stream.Stream;
import net.minecraft.core.Direction.Axis;

// $VF: Compiled from s
public enum ForAxis implements IDatatypeFor<Axis> {
   INSTANCE;

   public Axis get(IDatatypeContext var1) throws CommandException {
      return Axis.valueOf(var1.getConsumer().getString().toUpperCase(Locale.US));
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      return new TabCompleteHelper()
         .append(Stream.of(Axis.values()).map(Axis::getName).map(String::toLowerCase))
         .filterPrefix(var1.getConsumer().getString())
         .stream();
   }
}
