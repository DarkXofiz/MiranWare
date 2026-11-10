// Original binary: sg/ec/4RstOUg6MsAsv0x5
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class FriendAliasArgument implements ArgumentType<String>, MinecraftAccess {
   public String parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      Friend sx = FriendManager.INSTANCE.method00175(var2);
      if (sx == null) {
         throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().create("Friend '" + var2 + "' not found");
      } else {
         return sx.method03787();
      }
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = var2.getRemaining().toLowerCase();

      for (Friend var5 : FriendManager.INSTANCE.method00184().values()) {
         if (var5.method03787().toLowerCase().startsWith(var3)) {
            var2.suggest(var5.method03787());
         }

         if (var5.method03786() && var5.method03788().toLowerCase().startsWith(var3)) {
            var2.suggest(var5.method03788());
         }
      }

      return var2.buildFuture();
   }
}
