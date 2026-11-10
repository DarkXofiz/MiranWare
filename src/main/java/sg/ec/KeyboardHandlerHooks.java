// Original binary: sg/ec/Q7No1EZqN5owQ9LH
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.input.KeyEvent;

// $VF: Compiled from s
public final class KeyboardHandlerHooks {
   public static boolean method05137(Minecraft var0, int var1, KeyEvent var2) {
      int var3 = InputCompat.glfwKey(var2.key());
      if (var3 == -1) {
         return false;
      }

      if ((var1 == 1 || var1 == 0) && ScriptRuntime.INSTANCE.method06198(var3, var2.keycode(), var2.modifiers(), var1 == 1)) {
         return true;
      }

      if (var0.gui.screen() == null && var1 == 1) {
         KeyInputEvent.field12526.method05886(var3, InputAction.PRESS);
      } else if (var1 == 0) {
         KeyInputEvent.field12526.method05886(var3, InputAction.RELEASE);
      }

      return false;
   }

   private KeyboardHandlerHooks() {
   }
}
