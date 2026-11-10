// Original binary: sg/ec/uZwpi0g7hjN1LVSh
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

// $VF: Compiled from s
public class BotNameArgument implements ArgumentType<String>, MinecraftAccess {
   public static final String field24602 = "all";
   private static final String field24603 = "all";

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      BotClient var3 = BotSessionManager.INSTANCE.method08761();
      ArrayList var4 = new ArrayList();
      var4.add(field24603);

      for (BotClient var6 : BotManager.INSTANCE.method03092()) {
         if (var6 != var3 && (var6.method00146().method05278() || BotSessionManager.INSTANCE.method08733(var6))) {
            var4.add(var6.method00137().method00491());
         }
      }

      return CommandSuggestionUtils.method09849(var2, var4, Function.identity());
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      return var1.readUnquotedString();
   }
}
