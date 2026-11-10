// Original binary: sg/mx/mqkgd74xAtv59e54
package sg.mx;

import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.context.StringRange;
import com.mojang.brigadier.suggestion.Suggestion;
import com.mojang.brigadier.suggestion.Suggestions;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.event.events.TabCompleteEvent;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.client.gui.components.CommandSuggestions;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.CommandSuggestions.SuggestionsList;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
@Mixin(CommandSuggestions.class)
public class CommandSuggestionsMixin_1284 {
   @Shadow
   @Final
   private EditBox input;
   @Shadow
   @Final
   private List<FormattedCharSequence> commandUsage;
   @Shadow
   private ParseResults currentParse;
   @Shadow
   private CompletableFuture<Suggestions> pendingSuggestions;
   @Shadow
   private SuggestionsList suggestions;
   @Shadow
   private boolean keepSuggestions;
   private static final String field28037 = " ";

   @Inject(method = "updateCommandInfo", at = @At("HEAD"), cancellable = true)
   private void hex$baritoneTabComplete(CallbackInfo var1) {
      String var2 = this.input.getValue().substring(0, Math.min(this.input.getValue().length(), this.input.getCursorPosition()));
      TabCompleteEvent var3 = new TabCompleteEvent(var2);
      BaritoneAPI.getProvider().getPrimaryBaritone().getGameEventHandler().onPreTabComplete(var3);
      if (var3.isCancelled()) {
         var1.cancel();
      } else {
         if (var3.completions != null) {
            var1.cancel();
            this.currentParse = null;
            if (this.keepSuggestions) {
               return;
            }

            this.input.setSuggestion(null);
            this.suggestions = null;
            this.commandUsage.clear();
            if (var3.completions.length == 0) {
               this.pendingSuggestions = Suggestions.empty();
            } else {
               StringRange var4 = StringRange.between(var2.lastIndexOf(field28037) + 1, var2.length());
               var var5 = Stream.of(var3.completions).map(var1x -> new Suggestion(var4, var1x)).collect(Collectors.toList());
               Suggestions var6 = new Suggestions(var4, var5);
               this.pendingSuggestions = new CompletableFuture<>();
               this.pendingSuggestions.complete(var6);
            }

            ((CommandSuggestions)(Object)this).showSuggestions(true);
         }
      }
   }

}
