// Original binary: sg/ec/HQZwm5gzeypgIpzY
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
import net.minecraft.world.level.block.entity.BlockEntityType;

// $VF: Compiled from s
public class BlockEntityTypeArgument implements MinecraftAccess, ArgumentType<BlockEntityType<?>> {
   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = BlockNameUtils.method03820(var2.getRemaining());

      for (BlockEntityType var5 : BuiltInRegistries.BLOCK_ENTITY_TYPE) {
         String var6 = BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(var5).getPath();
         if (BlockNameUtils.method03820(var6).startsWith(var3)) {
            var2.suggest(var6);
         }
      }

      return var2.buildFuture();
   }

   public BlockEntityType<?> parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      String var3 = BlockNameUtils.method03820(var2);

      for (BlockEntityType var5 : BuiltInRegistries.BLOCK_ENTITY_TYPE) {
         if (BlockNameUtils.method03820(BuiltInRegistries.BLOCK_ENTITY_TYPE.getKey(var5).getPath()).equals(var3)) {
            return var5;
         }
      }

      throw new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal("Неверный тайл-энтити: " + var2));
   }
}
