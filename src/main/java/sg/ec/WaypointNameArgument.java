// Original binary: sg/ec/avCRKQQ1ER5N73Bc
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class WaypointNameArgument implements ArgumentType<String> {
   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = var2.getRemaining().toLowerCase(Locale.ROOT);
      WaypointManager.INSTANCE.method09839().stream().filter(var1x -> var1x.toLowerCase(Locale.ROOT).startsWith(var3)).forEach(var2::suggest);
      return var2.buildFuture();
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      return var1.readString();
   }
}
