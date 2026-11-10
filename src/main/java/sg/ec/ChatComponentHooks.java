// Original binary: sg/ec/Nmdhen1nBW9UYhU0
package sg.ec;

import net.minecraft.client.GuiMessage.Line;

// $VF: Compiled from s
public final class ChatComponentHooks {
   public static int method04728(Line var0, int var1) {
      return var0 == null ? var1 : ChatLineEvent.field12024.method05660(var0, var1, ((ChatTextMatchAccess)(Object)var0).getRawText());
   }

   private ChatComponentHooks() {
   }
}
