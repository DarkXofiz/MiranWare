// Original binary: sg/ec/gtKvtxaLwrTsh7mV
package sg.ec;

// $VF: Compiled from s
public final class CameraAspectRatioHooks implements MinecraftAccess {
   public static float method08590(float var0, float var1) {
      float var2 = method08593();
      return var2 > 0.0F ? var2 : var0 / var1;
   }

   public static int method08591(int var0) {
      float var1 = method08593();
      return var1 <= 0.0F ? var0 : Math.max(1, Math.round(mc.getWindow().getHeight() * var1));
   }

   public static int method08592(int var0) {
      return Math.max(var0, method08591(var0));
   }

   private CameraAspectRatioHooks() {
   }

   public static float method08593() {
      Beautification var0 = ModuleManager.INSTANCE.method08178();
      return var0 != null && var0.method03937() ? var0.method03472() : 0.0F;
   }
}
