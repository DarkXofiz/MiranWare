// Original binary: sg/ec/QxTQBypsqQ96LcXm
package sg.ec;

import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.GuiMessage;

// $VF: Compiled from s
public class ChatMessageAddedEvent extends Event {
   public static final ChatMessageAddedEvent field11383 = new ChatMessageAddedEvent();
   private ChatComponent field11384;
   private GuiMessage field11385;

   public void method05250(ChatComponent var1, GuiMessage var2) {
      this.field11384 = var1;
      this.field11385 = var2;
      super.method03208();
   }

   public GuiMessage method05251() {
      return this.field11385;
   }

   public void method05252(GuiMessage var1) {
      this.field11385 = var1;
   }

   public void method05253(ChatComponent var1) {
      this.field11384 = var1;
   }

   public ChatComponent method05254() {
      return this.field11384;
   }
}
