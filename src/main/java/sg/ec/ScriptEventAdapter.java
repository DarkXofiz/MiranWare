// Original binary: sg/ec/jOBJM0MyYjWhTZkF
package sg.ec;

import hex.script.api.Text;
import hex.script.api.event.ChatEvent;
import hex.script.api.event.KeyEvent;
import hex.script.api.event.MouseEvent;
import hex.script.api.event.ScreenEvent;
import hex.script.api.event.ScrollEvent;
import hex.script.api.event.TickEvent;
import hex.script.api.event.ChatEvent.TextOp;
import net.minecraft.client.multiplayer.chat.GuiMessageSource;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public final class ScriptEventAdapter implements MinecraftAccess {
   private final MouseEvent field20395 = new MouseEvent();
   private final ScrollEvent field20396 = new ScrollEvent();
   private final KeyEvent field20397 = new KeyEvent();
   private final ScreenEvent field20398 = new ScreenEvent();
   private final TickEvent field20399 = new TickEvent();
   private final ChatEvent field20400 = new ChatEvent();
   private final TextOp field20401 = this::method08968;
   private final ScriptEventNames field20402;
   private Component field20403;

   boolean method08963(double var1, double var3) {
      if (!this.field20402.method04786(ScrollEvent.class)) {
         return false;
      }

      this.field20396.set(var1, var3);
      ScriptScreenAdapter.method10159(this.field20396.screen());
      return this.field20402.method04785(this.field20396, true);
   }

   boolean method08964(int var1, boolean var2, double var3, double var5) {
      if (!this.field20402.method04786(MouseEvent.class)) {
         return false;
      }

      this.field20395.set(var1, var2, var3, var5);
      ScriptScreenAdapter.method10159(this.field20395.screen());
      return this.field20402.method04785(this.field20395, true);
   }

   private int method08965(GuiMessageSource var1) {
      if (var1 == GuiMessageSource.PLAYER) {
         return 0;
      } else {
         return var1 == GuiMessageSource.SYSTEM_CLIENT ? 2 : 1;
      }
   }

   void method08966() {
      if (this.field20402.method04786(TickEvent.class)) {
         this.field20402.method04785(this.field20399, false);
      }
   }

   boolean method08967(int var1, int var2, int var3, boolean var4) {
      if (!this.field20402.method04786(KeyEvent.class)) {
         return false;
      }

      this.field20397.set(var1, var2, var3, var4);
      ScriptScreenAdapter.method10159(this.field20397.screen());
      return this.field20402.method04785(this.field20397, true);
   }

   ScriptEventAdapter(ScriptEventNames var1) {
      this.field20402 = var1;
   }

   private Text method08968() {
      return ScriptTextAdapter.method09251(this.field20403);
   }

   void method08969(boolean var1) {
      if (this.field20402.method04786(ScreenEvent.class)) {
         this.field20398.set(var1);
         ScriptScreenAdapter.method10159(this.field20398.screen());
         this.field20402.method04785(this.field20398, false);
      }
   }

   boolean method08970(Component var1, GuiMessageSource var2) {
      if (!this.field20402.method04786(ChatEvent.class)) {
         return false;
      }

      this.field20403 = var1;
      this.field20400.set(var1 == null ? "" : var1.getString(), this.method08965(var2), this.field20401);

      try {
         return this.field20402.method04785(this.field20400, true);
      } finally {
         this.field20403 = null;
      }
   }
}
