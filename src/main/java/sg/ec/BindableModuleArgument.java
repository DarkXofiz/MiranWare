// Original binary: sg/ec/nxUvKjsWC0VM9k2l
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class BindableModuleArgument implements ArgumentType<ToggleableModule>, MinecraftAccess {
   private static final String field22060 = " ";

   private String normalizeName(String var1) {
      return var1.replace(field22060, "");
   }

   public ToggleableModule parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      String var3 = this.normalizeName(var2);
      return ModuleManager.INSTANCE
         .method05138()
         .stream()
         .filter(var2x -> this.normalizeName(var2x.method03925()).equalsIgnoreCase(var3) && var2x.method03930().method05871() != -1)
         .findFirst()
         .orElseThrow(() -> CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().create("Module '" + var2 + "' not found"));
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = var2.getRemaining().toLowerCase();
      ModuleManager.INSTANCE
         .method05138()
         .stream()
         .filter(var2x -> this.normalizeName(var2x.method03925()).toLowerCase().startsWith(var3) && var2x.method03930().method05871() != -1)
         .forEach(var2x -> var2.suggest(this.normalizeName(var2x.method03925())));
      return var2.buildFuture();
   }
}
