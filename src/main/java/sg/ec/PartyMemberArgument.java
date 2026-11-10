// Original binary: sg/ec/zpkr0GfYeGkKMWZe
package sg.ec;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;

// $VF: Compiled from s
public class PartyMemberArgument implements ArgumentType<PartyMember>, MinecraftAccess {
   private boolean field27939 = true;
   private static final String field27940 = "Client is not ready";
   private static final String field27941 = "You are not in a party";

   public PartyMemberArgument(boolean var1) {
      this.field27939 = var1;
   }

   public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> var1, SuggestionsBuilder var2) {
      String var3 = var2.getRemaining().toLowerCase();
      GlobalWebSocketClient var4 = MiranWare.getInstance().getClient();
      if (var4 == null) {
         return var2.buildFuture();
      }

      Party var5 = var4.getManager().method01805();
      if (var5 == null) {
         return var2.buildFuture();
      }

      PartyMember var6 = null;
      if (!this.field27939 && var4.getClientPlayer() != null) {
         var6 = var5.method10151(var1x -> var1x.method07566(var4.getClientPlayer()));
      }

      PartyMember var7 = var6;
      var5.method10148()
         .stream()
         .filter(var2x -> this.field27939 || var7 == null || !var2x.method07566(var7))
         .map(GlobalPlayer::method07586)
         .filter(var1x -> var1x != null && var1x.toLowerCase().startsWith(var3))
         .forEach(var2::suggest);
      return var2.buildFuture();
   }

   public PartyMember parse(StringReader var1) throws CommandSyntaxException {
      String var2 = var1.readString();
      GlobalWebSocketClient var3 = MiranWare.getInstance().getClient();
      if (var3 == null) {
         throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().create(field27940);
      }

      Party var4 = var3.getManager().method01805();
      if (var4 == null) {
         throw CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().create(field27941);
      }

      PartyMember var5 = null;
      if (!this.field27939 && var3.getClientPlayer() != null) {
         var5 = var4.method10151(var1x -> var1x.method07566(var3.getClientPlayer()));
      }

      PartyMember var6 = var5;
      return var4.method10148()
         .stream()
         .filter(var1x -> var1x.method07586().equalsIgnoreCase(var2))
         .filter(var2x -> this.field27939 || var6 == null || !var2x.method07566(var6))
         .findFirst()
         .orElseThrow(() -> CommandSyntaxException.BUILT_IN_EXCEPTIONS.dispatcherParseException().create("Friend '" + var2 + "' not found"));
   }

   public PartyMemberArgument() {
   }
}
