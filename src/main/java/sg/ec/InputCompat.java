package sg.ec;

import org.lwjgl.glfw.GLFW;

/**
 * Hedef surum GLFW kullandigi icin tus / fare kodlari oldugu gibi gecer
 * (26.3'teki SDL cevirisine gerek yok). Metot imzalari ayni birakildi.
 */
public final class InputCompat {
   private static final long START = System.nanoTime();

   private InputCompat() {
   }

   public static int glfwKey(int key) {
      return key;
   }

   public static int sdlKey(int glfwKey) {
      return glfwKey;
   }

   public static int glfwButton(int button) {
      return button;
   }

   public static int sdlButton(int glfwButton) {
      return glfwButton;
   }

   public static boolean isGlfwKeyDown(int glfwKey) {
      long window = GLFW.glfwGetCurrentContext();
      return window != 0L && glfwKey >= 0 && GLFW.glfwGetKey(window, glfwKey) == GLFW.GLFW_PRESS;
   }

   /** 0 = sol, 1 = sag, 2 = orta. */
   public static boolean isMouseDown(int glfwButton) {
      long window = GLFW.glfwGetCurrentContext();
      return window != 0L && glfwButton >= 0 && GLFW.glfwGetMouseButton(window, glfwButton) == GLFW.GLFW_PRESS;
   }

   public static boolean isShiftDown() {
      return isGlfwKeyDown(GLFW.GLFW_KEY_LEFT_SHIFT) || isGlfwKeyDown(GLFW.GLFW_KEY_RIGHT_SHIFT);
   }

   public static double time() {
      return (System.nanoTime() - START) / 1.0E9;
   }

   public static void framebufferSize(long window, int[] width, int[] height) {
      GLFW.glfwGetFramebufferSize(window, width, height);
   }
}
