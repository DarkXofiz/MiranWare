// Original binary: hex/api/baritone/api/command/Command
package hex.api.baritone.api.command;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.utils.IPlayerContext;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// $VF: Compiled from s
public abstract class Command implements ICommand {
   protected IBaritone baritone;
   protected IPlayerContext ctx;
   protected final List<String> names;

   protected Command(IBaritone var1, String... var2) {
      this.names = Collections.unmodifiableList(Stream.of(var2).map(var0 -> var0.toLowerCase(Locale.US)).collect(Collectors.toList()));
      this.baritone = var1;
      this.ctx = var1.getPlayerContext();
   }

   @Override
   public final List<String> getNames() {
      return this.names;
   }
}
