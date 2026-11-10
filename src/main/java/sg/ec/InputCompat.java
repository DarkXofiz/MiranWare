package sg.ec;

import com.mojang.blaze3d.platform.InputConstants;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.lwjgl.sdl.SDLMouse;
import org.lwjgl.sdl.SDLVideo;
import org.lwjgl.system.MemoryStack;

/**
 * 26.3 switched input from GLFW to SDL. The client keeps GLFW key / mouse codes internally
 * (keybinds, configs), so codes are translated at the boundary.
 */
public final class InputCompat {
   private static final long START = System.nanoTime();
   private static final Int2IntOpenHashMap GLFW_TO_SDL = new Int2IntOpenHashMap();
   private static final Int2IntOpenHashMap SDL_TO_GLFW = new Int2IntOpenHashMap();

   static {
      GLFW_TO_SDL.defaultReturnValue(-1);
      SDL_TO_GLFW.defaultReturnValue(-1);
      for (int i = 0; i < 26; i++) {
         map(65 + i, 4 + i);
      }
      for (int i = 1; i <= 9; i++) {
         map(48 + i, 29 + i);
      }
      map(48, 39);
      map(32, 44);
      map(39, 52);
      map(44, 54);
      map(45, 45);
      map(46, 55);
      map(47, 56);
      map(59, 51);
      map(61, 46);
      map(91, 47);
      map(92, 49);
      map(93, 48);
      map(96, 53);
      map(256, 41);
      map(257, 40);
      map(258, 43);
      map(259, 42);
      map(260, 73);
      map(261, 76);
      map(262, 79);
      map(263, 80);
      map(264, 81);
      map(265, 82);
      map(266, 75);
      map(267, 78);
      map(268, 74);
      map(269, 77);
      map(280, 57);
      map(281, 71);
      map(282, 83);
      map(283, 70);
      map(284, 72);
      for (int i = 0; i < 12; i++) {
         map(290 + i, 58 + i);
      }
      for (int i = 0; i < 12; i++) {
         map(302 + i, 104 + i);
      }
      for (int i = 1; i <= 9; i++) {
         map(320 + i, 88 + i);
      }
      map(320, 98);
      map(330, 99);
      map(331, 84);
      map(332, 85);
      map(333, 86);
      map(334, 87);
      map(335, 88);
      map(336, 103);
      map(340, 225);
      map(341, 224);
      map(342, 226);
      map(343, 227);
      map(344, 229);
      map(345, 228);
      map(346, 230);
      map(347, 231);
      map(348, 101);
   }

   private InputCompat() {
   }

   private static void map(int glfw, int sdl) {
      GLFW_TO_SDL.put(glfw, sdl);
      SDL_TO_GLFW.put(sdl, glfw);
   }

   /** SDL scancode (26.3 KeyEvent.key()) to GLFW key code. */
   public static int glfwKey(int sdlScancode) {
      return sdlScancode < 0 ? sdlScancode : SDL_TO_GLFW.get(sdlScancode);
   }

   /** GLFW key code to SDL scancode. */
   public static int sdlKey(int glfwKey) {
      return glfwKey < 0 ? glfwKey : GLFW_TO_SDL.get(glfwKey);
   }

   /** SDL mouse button (1 = left, 2 = middle, 3 = right) to GLFW button (0 = left, 1 = right, 2 = middle). */
   public static int glfwButton(int sdlButton) {
      return switch (sdlButton) {
         case 1 -> 0;
         case 2 -> 2;
         case 3 -> 1;
         default -> sdlButton < 0 ? sdlButton : sdlButton - 1;
      };
   }

   public static int sdlButton(int glfwButton) {
      return switch (glfwButton) {
         case 0 -> 1;
         case 1 -> 3;
         case 2 -> 2;
         default -> glfwButton + 1;
      };
   }

   public static boolean isGlfwKeyDown(int glfwKey) {
      int sdl = sdlKey(glfwKey);
      return sdl > 0 && InputConstants.isKeyDown(sdl);
   }

   /** GLFW-style mouse button index (0 = left, 1 = right, 2 = middle). */
   public static boolean isMouseDown(int glfwButton) {
      int sdl = sdlButton(glfwButton);
      try (MemoryStack stack = MemoryStack.stackPush()) {
         int state = SDLMouse.SDL_GetMouseState(stack.mallocFloat(1), stack.mallocFloat(1));
         return (state & (1 << (sdl - 1))) != 0;
      }
   }

   public static boolean isShiftDown() {
      return InputConstants.isKeyDown(InputConstants.KEY_LSHIFT) || InputConstants.isKeyDown(InputConstants.KEY_RSHIFT);
   }

   public static double time() {
      return (System.nanoTime() - START) / 1.0E9;
   }

   public static void framebufferSize(long window, int[] width, int[] height) {
      try (MemoryStack stack = MemoryStack.stackPush()) {
         var w = stack.mallocInt(1);
         var h = stack.mallocInt(1);
         if (SDLVideo.SDL_GetWindowSizeInPixels(window, w, h)) {
            width[0] = w.get(0);
            height[0] = h.get(0);
         }
      }
   }
}
