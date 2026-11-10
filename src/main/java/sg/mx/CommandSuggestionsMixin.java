// Original binary: sg/mx/fmpkoJ2SCdv1Z1EA
package sg.mx;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.concurrent.CompletableFuture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.CommandSuggestions;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.CommandSuggestions.SuggestionsList;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.CommandManager;
import sg.ec.ClientFeaturePolicyEvent;

// $VF: Compiled from s
@Mixin(CommandSuggestions.class)
public abstract class CommandSuggestionsMixin {
   @Shadow
   @Final
   private EditBox input;
   @Shadow
   @Final
   private boolean onlyShowIfCursorPastError;
   @Shadow
   @Nullable
   private SuggestionsList suggestions;
   @Shadow
   @Nullable
   private CompletableFuture<Suggestions> pendingSuggestions;
   @Shadow
   private boolean keepSuggestions;
   @Shadow
   @Final
   private Minecraft minecraft;
   @Shadow
   private boolean currentParseIsCommand;
   @Shadow
   private boolean currentParseIsMessage;
   @Shadow
   private @org.jspecify.annotations.Nullable ParseResults<ClientSuggestionProvider> currentParse;
   private static final String field28032 = "field28032";

   @Shadow
   private static boolean hasMessageArguments(ParseResults<ClientSuggestionProvider> var0) {
      throw new UnsupportedOperationException(field28032);
   }

   @Shadow
   protected abstract void updateUsageInfo(ParseResults<ClientSuggestionProvider> var1, Suggestions var2);

   @Inject(method = "updateCommandInfo", at = @At("TAIL"))
   public void refresh(CallbackInfo var1) {
      if (!ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CHAT_COMMAND)) {
         StringReader var2 = new StringReader(this.input.getValue());
         boolean var3 = var2.canRead() && var2.peek() == '.';
         if (var3) {
            var2.skip();
         }

         int var4 = this.input.getCursorPosition();
         if (var3) {
            CommandDispatcher var5 = CommandManager.INSTANCE.method04654();
            if (this.currentParse == null) {
               this.currentParse = var5.parse(var2, this.minecraft.player.connection.getSuggestionsProvider());
            }

            this.currentParseIsCommand = true;
            this.currentParseIsMessage = hasMessageArguments(this.currentParse);
            int var6 = this.onlyShowIfCursorPastError ? var2.getCursor() : 1;
            if (var4 >= var6 && (this.suggestions == null || !this.keepSuggestions)) {
               this.pendingSuggestions = var5.getCompletionSuggestions(this.currentParse, var4);
               this.pendingSuggestions.thenAccept(var1x -> {
                  if (this.pendingSuggestions.isDone()) {
                     this.updateUsageInfo(this.currentParse, var1x);
                  }
               });
            }
         }
      }
   }

}
