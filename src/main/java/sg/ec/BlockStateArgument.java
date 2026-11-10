// Original binary: sg/ec/Tp0XTFJA6GQpBeyo
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class BlockStateArgument implements MinecraftAccess, ArgumentType<BlockState> {
   public BlockState parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      String sx = BlockNameUtils.method03820(var2);

      for (Block sxx : BuiltInRegistries.BLOCK) {
         Identifier sxxx = BuiltInRegistries.BLOCK.getKey(sxx);
         if (BlockNameUtils.method03820(sxxx.getPath()).equals(sx)) {
            return sxx.defaultBlockState();
         }
      }

      throw new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal("Неверный блок: " + var2));
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = BlockNameUtils.method03820(var2.getRemaining());

      for (Block var5 : BuiltInRegistries.BLOCK) {
         String var6 = BuiltInRegistries.BLOCK.getKey(var5).getPath();
         if (BlockNameUtils.method03820(var6).startsWith(var3)) {
            var2.suggest(var6);
         }
      }

      return var2.buildFuture();
   }
}
