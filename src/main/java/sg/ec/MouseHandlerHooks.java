// Original binary: sg/ec/YTsln80jRKYsSnUN
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.input.MouseButtonInfo;
import net.minecraft.world.entity.player.Inventory;

// $VF: Compiled from s
public final class MouseHandlerHooks {
   public static boolean method06578(Minecraft var0, double var1, double var3, long var5, MouseButtonInfo var7, int var8) {
      int var9 = InputCompat.glfwButton(var7.button());
      if (var9 == -1) {
         return false;
      }

      if (var5 != var0.getWindow().handle()) {
         return false;
      }

      if ((var8 == 1 || var8 == 0) && ScriptRuntime.INSTANCE.method06196(var9, var8 == 1, var1, var3)) {
         return true;
      }

      if (var8 == 1 && var0.screen == null) {
         MouseButtonEvent.field15585.method06912(var1, var3, -100 + var9, InputAction.PRESS);
      } else if (var8 == 0) {
         MouseButtonEvent.field15585.method06912(var1, var3, -100 + var9, InputAction.RELEASE);
      }

      return false;
   }

   public static void method06579(Inventory var0, int var1) {
      if (!MouseGrabEvent.field08821.method03965(MouseGrabEvent.Nested115.MOUSE_SCROLL)) {
         MinecraftHooks.method04016(var0, var1);
      }
   }

   private MouseHandlerHooks() {
   }
}
