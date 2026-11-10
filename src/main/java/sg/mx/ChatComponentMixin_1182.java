// Original binary: sg/mx/MTOa9CKavI2HXxZq
package sg.mx;

import java.util.List;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.client.multiplayer.chat.GuiMessage;
import net.minecraft.client.multiplayer.chat.GuiMessage.Line;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(ChatComponent.class)
public interface ChatComponentMixin_1182 {
   @Accessor("trimmedMessages")
   List<Line> getVisibleMessages();

   @Accessor("allMessages")
   List<GuiMessage> getAllMessages();

   @Invoker("getWidth")
   int IgetWidth();

   @Invoker("getScale")
   double IgetChatScale();

   @Invoker("refreshTrimmedMessages")
   void IrefreshTrimmedMessages();
}
