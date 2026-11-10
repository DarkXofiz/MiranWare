// Original binary: sg/ec/JTbMxMYLxvE915eu
package sg.ec;

import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.GuiMessage;
import net.minecraft.network.chat.Component;
import sg.mx.ChatComponentMixin_1182;

// $VF: Compiled from s
public final class ChatMessagePolicy implements MinecraftAccess {
   private static Component field08875;
   private static boolean field08876;

   private static boolean method04004(Component var0) {
      return field08875 != null && field08875 == var0;
   }

   public static boolean method04005(GuiMessage var0) {
      return var0 != null
         && ((ChatMessageFlagsAccess)(Object)var0).isClientMessage()
         && ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CLIENT_MESSAGE);
   }

   public static boolean method04006(Component var0) {
      if (!method04004(var0)) {
         return false;
      }

      field08875 = null;
      return true;
   }

   public static void method04007() {
      ChatComponent var0 = method04009();
      if (var0 != null) {
         ((ChatComponentMixin_1182)(Object)var0).IrefreshTrimmedMessages();
         var0.scrollChat(0);
      }
   }

   private ChatMessagePolicy() {
   }

   public static void method04008(Component var0) {
      field08875 = var0;
   }

   public static ChatComponent method04009() {
      return mc.gui != null && mc.gui != null ? mc.gui.getChat() : null;
   }

   public static void method04010() {
      boolean var0 = ClientFeaturePolicyEvent.field14592.method06426(ClientFeaturePolicyEvent.Nested186.CLIENT_MESSAGE);
      if (var0 != field08876) {
         field08876 = var0;
         method04007();
      }
   }
}
