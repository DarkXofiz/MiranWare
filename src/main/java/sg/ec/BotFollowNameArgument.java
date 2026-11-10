// Original binary: sg/ec/o4MxG67uvWI52McH
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
import net.minecraft.client.multiplayer.PlayerInfo;

// $VF: Compiled from s
public class BotFollowNameArgument implements ArgumentType<String>, MinecraftAccess {
   public static final String field22074 = "off";
   private static final String field22075 = "off";

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      ArrayList var3 = new ArrayList();
      var3.add(field22075);
      if (mc.player != null) {
         for (PlayerInfo var5 : mc.player.connection.getOnlinePlayers()) {
            var3.add(var5.getProfile().name());
         }
      }

      return CommandSuggestionUtils.method09849(var2, var3, Function.identity());
   }

   public String parse(StringReader var1) throws CommandSyntaxException {
      return var1.readUnquotedString();
   }
}
