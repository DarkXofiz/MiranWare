// Original binary: sg/ec/CjWnUUYi9ISWH0sW
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
import net.minecraft.world.entity.EntityType;

// $VF: Compiled from s
public class EntityTypeArgument implements MinecraftAccess, ArgumentType<EntityType<?>> {
   public EntityType<?> parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      String var3 = BlockNameUtils.method03820(var2);

      for (EntityType var5 : BuiltInRegistries.ENTITY_TYPE) {
         if (BlockNameUtils.method03820(BuiltInRegistries.ENTITY_TYPE.getKey(var5).getPath()).equals(var3)) {
            return var5;
         }
      }

      throw new CommandSyntaxException(CommandSyntaxException.BUILT_IN_EXCEPTIONS.literalIncorrect(), Component.literal("Неверная сущность: " + var2));
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = BlockNameUtils.method03820(var2.getRemaining());

      for (EntityType var5 : BuiltInRegistries.ENTITY_TYPE) {
         String var6 = BuiltInRegistries.ENTITY_TYPE.getKey(var5).getPath();
         if (BlockNameUtils.method03820(var6).startsWith(var3)) {
            var2.suggest(var6);
         }
      }

      return var2.buildFuture();
   }
}
