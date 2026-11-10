// Original binary: sg/ec/0pklhFHLOqV5ETKZ
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
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public abstract class AbstractBlockArgument implements ArgumentType<Block>, MinecraftAccess {
   private static final String field00419 = "block.minecraft.";
   private static final String field00420 = " ";
   private static final String field00421 = "block.minecraft.";
   private static final String field00422 = "block.minecraft.";
   private static final String field00423 = " ";

   public Block parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      return this.blocks()
         .stream()
         .filter(var1x -> var1x.getDescriptionId().replace(field00422, "").replace(field00423, "").equals(var2))
         .findFirst()
         .orElseThrow(
            () -> new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal(this.errorMessage(var2)))
         );
   }

   protected abstract String errorMessage(String var1);

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      this.blocks()
         .stream()
         .filter(var1x -> var1x.getDescriptionId().replace(field00421, "").startsWith(var2.getRemaining()))
         .forEach(var1x -> var2.suggest(var1x.getDescriptionId().replace(field00419, "").replace(field00420, "")));
      return var2.buildFuture();
   }

   protected abstract List<Block> blocks();
}
