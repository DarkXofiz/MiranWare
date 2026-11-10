// Original binary: sg/ec/iT9Bk0Ogxo1Xgkbt
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

// $VF: Compiled from s
public class StaffNameArgument implements ArgumentType<String>, MinecraftAccess {
   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      return CommandSuggestionUtils.method09849(var2, StaffManager.INSTANCE.method02176(), Function.identity());
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      return CommandSuggestionUtils.method09848(var2, StaffManager.INSTANCE.method02176(), Function.identity(), "Staffs '" + var2 + "' not found");
   }
}
