// Original binary: sg/ec/0pUXiaFPjOVLel9j
package sg.ec;

import hex.api.extensions.GuiMessage$LineExtensions;
import net.minecraft.client.multiplayer.chat.GuiMessage.Line;

// $VF: Compiled from s
public class ChatAlphaEvent extends Event {
   public static final ChatAlphaEvent field00417 = new ChatAlphaEvent();
   private boolean field00418;

   public void method00215(boolean var1) {
      this.field00418 = var1;
   }

   public float method00216(float var1, Line var2) {
      if (!this.method05698()) {
         return var1;
      } else {
         super.method03208();
         if (!this.method05694()) {
            return var1;
         } else {
            GuiMessage$LineExtensions var3 = (GuiMessage$LineExtensions)(Object)var2;
            if (var3 != null && var3.animation() != null) {
               var3.animation().method03375(1.0);
               return var1 * var3.animation().method03377();
            } else {
               return var1;
            }
         }
      }
   }

   public boolean method00217() {
      return this.field00418;
   }
}
