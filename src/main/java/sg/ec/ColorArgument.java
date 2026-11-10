// Original binary: sg/ec/hVpfazhsJ9hMbl4F
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public class ColorArgument implements ArgumentType<NamedColor> {
   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = var2.getRemaining().toUpperCase();

      for (NamedColor var7 : NamedColor.values()) {
         if (var7.name().startsWith(var3)) {
            var2.suggest(var7.name());
         }
      }

      return var2.buildFuture();
   }

   public NamedColor parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      NamedColor var3 = NamedColor.method10138(var2);
      if (var3 == null) {
         throw new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal("Неизвестный цвет: " + var2));
      } else {
         return var3;
      }
   }
}
