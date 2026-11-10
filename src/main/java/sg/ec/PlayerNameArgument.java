// Original binary: sg/ec/UuuZ1K3wGQp92UQ6
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class PlayerNameArgument implements ArgumentType<String>, MinecraftAccess {
   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      return CommandSuggestionUtils.method09849(var2, mc.player.connection.getOnlinePlayers(), var0 -> var0.getProfile().name());
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      return var1.readUnquotedString();
   }
}
