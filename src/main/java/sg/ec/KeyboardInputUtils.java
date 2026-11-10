// Original binary: sg/ec/5951y3c1uaEv3bDq
package sg.ec;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.CharacterEvent;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonInfo;

// $VF: Compiled from s
public final class KeyboardInputUtils {
   public static boolean method00908(Minecraft var0, long var1, double var3, double var5) {
      if (!method00909(var0, var1)) {
         return false;
      }

      Window var7 = var0.getWindow();
      boolean sx = var0.options.discreteMouseScroll().get();
      double sxx = var0.options.mouseWheelSensitivity().get();
      double sxxx = (sx ? Math.signum(var3) : var3) * sxx;
      double sxxxx = (sx ? Math.signum(var5) : var5) * sxx;
      double sxxxxx = var0.mouseHandler.getScaledXPos(var7);
      double sxxxxxx = var0.mouseHandler.getScaledYPos(var7);
      return ClientScreenManager.INSTANCE.method08326(sxxxxx, sxxxxxx, sxxx, sxxxx);
   }

   private static boolean method00909(Minecraft var0, long var1) {
      return ClientScreenManager.INSTANCE.method08316() && var1 == var0.getWindow().handle();
   }

   private KeyboardInputUtils() {
   }

   public static void method00910(GuiGraphics var0, float var1) {
      if (ClientScreenManager.INSTANCE.method08318()) {
         Minecraft var2 = Minecraft.getInstance();
         Window var3 = var2.getWindow();
         int var4 = (int)var2.mouseHandler.getScaledXPos(var3);
         int var5 = (int)var2.mouseHandler.getScaledYPos(var3);
         ClientScreenManager.INSTANCE.method08323(var0, var4, var5, var1);
      }
   }

   public static boolean method00911(Minecraft var0, long var1, CharacterEvent var3) {
      return !method00909(var0, var1) ? false : ClientScreenManager.INSTANCE.method08328((char)var3.codepoint(), 0);
   }

   private static boolean method00912(Minecraft var0, KeyEvent var1) {
      Screen var2 = var0.gui.screen();
      if (var2 != null && !InventoryInputPolicy.method01915(var2)) {
         ClickGUI var3 = ModuleManager.INSTANCE.method08250();
         if (var3 != null && var3.method03930().method05871() == InputCompat.glfwKey(var1.key())) {
            var3.method00382();
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public static boolean method00913(Minecraft var0, long var1, MouseButtonInfo var3, int var4) {
      if (!method00909(var0, var1)) {
         return false;
      }

      Window var5 = var0.getWindow();
      double var6 = var0.mouseHandler.getScaledXPos(var5);
      double var8 = var0.mouseHandler.getScaledYPos(var5);
      return var4 == 1
         ? ClientScreenManager.INSTANCE.method08324(var6, var8, InputCompat.glfwButton(var3.button()), false)
         : ClientScreenManager.INSTANCE.method08325(var6, var8, InputCompat.glfwButton(var3.button()));
   }

   public static void method00914() {
      ClientScreenManager.INSTANCE.method08322();
   }

   public static boolean method00915(Minecraft var0, long var1, int var3, KeyEvent var4) {
      if (var1 != var0.getWindow().handle()) {
         return false;
      }

      if (ClientScreenManager.INSTANCE.method08316()) {
         if (var3 == 0) {
            return true;
         } else {
            return var0.handleGlobalKeyPress(InputConstants.getKey(var4), var4.hasControlDownWithQuirk())
               ? true
               : ClientScreenManager.INSTANCE.method08327(InputCompat.glfwKey(var4.key()), var4.keycode(), var4.modifiers());
         }
      } else {
         return var3 != 0 && method00912(var0, var4);
      }
   }
}
