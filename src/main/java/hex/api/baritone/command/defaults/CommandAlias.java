// Original binary: hex/api/baritone/command/defaults/CommandAlias
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class CommandAlias extends Command {
   private final String shortDesc;
   public final String target;
   private static final String АеЩ = "АеЩ";
   private static final String Аем = "Аем";
   private static final String АеФ = "АеФ";

   public CommandAlias(IBaritone var1, String var2, String var3, String var4) {
      super(var1, var2);
      this.shortDesc = var3;
      this.target = var4;
   }

   public CommandAlias(IBaritone var1, List<String> var2, String var3, String var4) {
      super(var1, var2.toArray(new String[0]));
      this.shortDesc = var3;
      this.target = var4;
   }

   @Override
   public String getShortDesc() {
      return this.shortDesc;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return this.baritone.getCommandManager().tabComplete(String.format(Аем, this.target, var2.rawRest()));
   }


   @Override
   public List<String> getLongDesc() {
      return Collections.singletonList(String.format(АеФ, this.target));
   }

   @Override
   public void execute(String var1, IArgConsumer var2) {
      this.baritone.getCommandManager().execute(String.format(АеЩ, this.target, var2.rawRest()));
   }
}
