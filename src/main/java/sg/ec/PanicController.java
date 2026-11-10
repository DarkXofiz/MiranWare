// Original binary: sg/ec/UPYu6OVxWWpGsQIM
package sg.ec;

import com.mojang.blaze3d.platform.Window;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.W32APIOptions;
import net.minecraft.client.Minecraft;
import sg.mx.WindowMixin;

// $VF: Compiled from s
public class PanicController {
   private static final int field12489 = 17;
   private static final int field12490 = 0;
   private static final int field12491 = 0;
   private static final int field12492 = 0;
   private static final int field12493 = 0;
   private static final int field12494 = 0;
   private static final int field12495 = 0;
   private static final int field12496 = 0;
   private static final int field12497 = 0;
   private static volatile boolean field12498 = false;
   private static volatile int field12499 = 0;
   private static boolean field12500 = false;
   private static final int field12501 = 134217856;
   private static final long field12502 = -1L;
   private static final long field12503 = -1L;

   public static void method05862(long var0, boolean var2, boolean var3) {
      try {
         long var4 = 0L;
         if (var4 == 0L) {
            return;
         }

         HWND sx = new HWND(new Pointer(var4));
         PanicController.Nested177.field12504.SetWindowDisplayAffinity(sx, 17);
         if (var3) {
            HWND sxx = new HWND(new Pointer(field12503));
            PanicController.Nested177.field12504.SetWindowPos(sx, sxx, 0, 0, 0, 0, 19);
         }
      } catch (Throwable var8) {
      }
   }

   public static void method05863() {
      field12498 = false;
      method05869(0);
   }

   public static void method05864(boolean var0) {
      field12499 = var0 ? 1 : 17;
      field12498 = true;
      field12500 = method05866();
      method05869(field12499);
   }

   public static void method05865(long var0, boolean var2) {
      try {
         long var3 = 0L;
         if (var3 == 0L) {
            return;
         }

         HWND var5 = new HWND(new Pointer(var3));
         int var6 = PanicController.Nested177.field12504.GetWindowLong(var5, -20);
         var6 |= field12501;
         PanicController.Nested177.field12504.SetWindowLong(var5, -20, var6);
         PanicController.Nested177.field12504.SetWindowDisplayAffinity(var5, 17);
         HWND var7 = new HWND(new Pointer(field12502));
         PanicController.Nested177.field12504.SetWindowPos(var5, var7, 0, 0, 0, 0, 51);
      } catch (Throwable var8) {
      }
   }

   private static boolean method05866() {
      try {
         return Minecraft.getInstance().getWindow().isFullscreen();
      } catch (Throwable var1) {
         return false;
      }
   }

   public static void method05867() {
      if (field12498) {
         boolean var0 = method05866();
         if (var0 != field12500) {
            field12500 = var0;
            method05869(field12499);
         }

         method05868();
      }
   }

   private static void method05868() {
      try {
         Window var0 = Minecraft.getInstance().getWindow();
         long var1 = var0.handle();
         int[] var3 = new int[1];
         int[] var4 = new int[1];
         InputCompat.framebufferSize(var1, var3, var4);
         int var5 = var3[0];
         int var6 = var4[0];
         if (var5 <= 0 || var6 <= 0) {
            return;
         }

         if (var5 != var0.getWidth() || var6 != var0.getHeight()) {
            ((WindowMixin)(Object)var0).hexOnFramebufferResize(var5, var6);
         }
      } catch (Throwable var7) {
      }
   }

   private static void method05869(int var0) {
      try {
         long var1 = Minecraft.getInstance().getWindow().handle();
         long var3 = 0L;
         if (var3 != 0L) {
            HWND var5 = new HWND(new Pointer(var3));
            PanicController.Nested177.field12504.SetWindowDisplayAffinity(var5, var0);
         }
      } catch (Throwable var6) {
      }
   }

   // $VF: Compiled from s
   public interface Nested177 extends User32 {
      PanicController.Nested177 field12504 = Native.load("user32", PanicController.Nested177.class, W32APIOptions.DEFAULT_OPTIONS);

      @Override
      int SetWindowLong(HWND var1, int var2, int var3);

      @Override
      boolean SetWindowPos(HWND var1, HWND var2, int var3, int var4, int var5, int var6, int var7);

      @Override
      int GetWindowLong(HWND var1, int var2);

      boolean SetWindowDisplayAffinity(HWND var1, int var2);
   }
}
