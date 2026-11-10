// Original binary: sg/ec/kSnV4vkV6evixxpg
package sg.ec;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.network.chat.Component;
import sg.mx.ChatComponentMixin_1182;

// $VF: Compiled from s
public final class ChatMessageHooks {
   public static Component method09163(Component var0, int var1) {
      return ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CLIENT_MESSAGE)
         ? var0
         : Component.empty().append(var0).append(Component.literal(" (x" + var1 + ")").withStyle(ChatFormatting.GRAY));
   }

   public static void method09164(ChatComponent var0, GuiMessage var1) {
      BetterChat var2 = ModuleManager.INSTANCE.method08221();
      if (var2 != null && var2.method02221() && !ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CLIENT_MESSAGE)) {
         ChatMessageFlagsAccess var3 = (ChatMessageFlagsAccess)(Object)var1;
         String var4 = var3.getBaseText();
         if (!var4.isEmpty()) {
            var var5 = ((ChatComponentMixin_1182)(Object)var0).getAllMessages();

            for (int var6 = 0; var6 < var5.size(); var6++) {
               GuiMessage var7 = (GuiMessage)var5.get(var6);
               ChatMessageFlagsAccess var8 = (ChatMessageFlagsAccess)(Object)var7;
               if (var4.equals(var8.getBaseText())) {
                  var3.setRepeats(var8.getRepeats() + 1);
                  var5.remove(var6);
                  ((ChatComponentMixin_1182)(Object)var0).getVisibleMessages().removeIf(var1x -> var1x.parent() == var7);
                  return;
               }
            }
         }
      }
   }

   private ChatMessageHooks() {
   }
}
