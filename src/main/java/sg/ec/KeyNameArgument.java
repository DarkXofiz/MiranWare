// Original binary: sg/ec/jyLqL4K5otcnGvVp
package sg.ec;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class KeyNameArgument implements MinecraftAccess, ArgumentType<String> {
   private static final String field20742 = " ";
   private static final String field20743 = " ";

   public String parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();

      for (KeyboardKey var6 : KeyboardKey.values()) {
         if (var6.method00364().replace(field20742, "").equalsIgnoreCase(var2)) {
            return var6.method00364();
         }
      }

      throw new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), new LiteralMessage("Неверная кнопка: " + var2));
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      for (KeyboardKey var6 : KeyboardKey.values()) {
         if (var6.method00364().startsWith(var2.getRemaining().replace(field20743, ""))) {
            var2.suggest(var6.method00364());
         }
      }

      return var2.buildFuture();
   }
}
