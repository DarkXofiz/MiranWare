// Original binary: hex/api/baritone/command/argument/CommandArguments
package hex.api.baritone.command.argument;

import hex.api.baritone.api.command.argument.ICommandArgument;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// $VF: Compiled from s
public final class CommandArguments {
   private static final Pattern ARG_PATTERN = Pattern.compile(CommandArguments.бмш);
   private static final String бмН = "бмН";
   private static final String бмш = "бмш";

   public static CommandArgument unknown() {
      return new CommandArgument(-1, бмН, "");
   }

   private CommandArguments() {
   }

   public static List<ICommandArgument> from(String var0) {
      return from(var0, false);
   }


   public static List<ICommandArgument> from(String var0, boolean var1) {
      List var2 = new ArrayList<>();
      Matcher sx = ARG_PATTERN.matcher(var0);

      int sxx;
      for (sxx = -1; sx.find(); sxx = sx.end()) {
         var2.add(new CommandArgument(var2.size(), sx.group(), var0.substring(sx.start())));
      }

      if (var1 && sxx < var0.length()) {
         var2.add(new CommandArgument(var2.size(), "", ""));
      }

      return var2;
   }
}
