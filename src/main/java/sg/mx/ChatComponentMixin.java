// Original binary: sg/mx/1aLAwbUGNpHdjMQt
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.CommandHistory;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.util.ArrayListDeque;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ClientFeaturePolicyEvent;

// $VF: Compiled from s
@Mixin(ChatComponent.class)
public abstract class ChatComponentMixin {
   @Shadow
   @Final
   private CommandHistory commandHistory;

   @Inject(method = "addRecentChat", at = @At("TAIL"))
   private void onRecentChat(String var1, CallbackInfo var2) {
      if (hidden(var1)) {
         this.commandHistory.addCommand(var1);
      }
   }

   @ModifyReturnValue(method = "getRecentChat", at = @At("RETURN"))
   private ArrayListDeque<String> onRecentList(ArrayListDeque<String> var1) {
      if (!ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CHAT_COMMAND)) {
         return var1;
      }

      ArrayListDeque var2 = new ArrayListDeque<>(var1.size());

      for (String var4 : var1) {
         if (!hidden(var4)) {
            var2.addLast(var4);
         }
      }

      return var2;
   }

   @Unique
   private static boolean hidden(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         char var1 = var0.charAt(0);
         return var1 == '.' || var1 == '#';
      } else {
         return false;
      }
   }
}
