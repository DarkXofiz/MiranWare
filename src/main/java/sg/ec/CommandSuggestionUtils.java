// Original binary: sg/ec/obzznjlling6Lt8J
package sg.ec;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

// $VF: Compiled from s
public final class CommandSuggestionUtils {
   public static <T> T method09848(String var0, Iterable<T> var1, Function<T, String> var2, String var3) throws CommandSyntaxException {
      for (T var5 : var1) {
         if (var2.apply(var5).equalsIgnoreCase(var0)) {
            return var5;
         }
      }

      throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().create(var3);
   }

   public static <T> CompletableFuture<Suggestions> method09849(SuggestionsBuilder var0, Iterable<T> var1, Function<T, String> var2) {
      String var3 = var0.getRemaining().toLowerCase();

      for (T var5 : var1) {
         String var6 = (String)var2.apply(var5);
         if (var6 != null && var6.toLowerCase().startsWith(var3)) {
            var0.suggest(var6);
         }
      }

      return var0.buildFuture();
   }

   private CommandSuggestionUtils() {
   }
}
