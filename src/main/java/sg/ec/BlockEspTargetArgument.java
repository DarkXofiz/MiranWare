// Original binary: sg/ec/3ijUucWSsqrlIbkW
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public class BlockEspTargetArgument implements ArgumentType<String>, MinecraftAccess {
   private static final String field01757 = "BlockESPCommand не найден";

   public String parse(StringReader var1) throws CommandSyntaxException {
      String var2 = BlockNameUtils.method03820(var1.readString());
      BlockEspCommand var3 = CommandManager.INSTANCE.method04650(BlockEspCommand.class);
      if (var3 == null) {
         throw new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal(field01757));
      }

      var var4 = var3.method09429();
      return var4.stream()
         .filter(var1x -> BlockNameUtils.method03820(var1x).equals(var2))
         .findFirst()
         .orElseThrow(
            () -> new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal("Цель не найдена: " + var2))
         );
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      BlockEspCommand var3 = CommandManager.INSTANCE.method04650(BlockEspCommand.class);
      if (var3 == null) {
         return var2.buildFuture();
      }

      String var4 = BlockNameUtils.method03820(var2.getRemaining());
      var3.method09429().stream().filter(var1x -> BlockNameUtils.method03820(var1x).startsWith(var4)).forEach(var2::suggest);
      return var2.buildFuture();
   }
}
