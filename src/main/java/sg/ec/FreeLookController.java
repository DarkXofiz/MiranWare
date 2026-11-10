// Original binary: sg/ec/pZOQQrh1hnevjrbN
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public class FreeLookController implements MinecraftAccess {
   private static final double field22787 = 0.15;
   private static boolean field22788;
   private static float field22789;
   private static float field22790;
   private static boolean field22791 = false;
   private static final double field22792 = 0.15;
   private static final double field22793 = 0.15;
   private static final float field22794 = -90.0F;
   private static final float field22795 = 90.0F;

   public static boolean method10124() {
      return field22791;
   }

   public static void method10125(float var0) {
      field22789 = var0;
   }

   private boolean method10126() {
      return mc.player != null && mc.level != null ? ModuleManager.INSTANCE.method08258().method03937() : false;
   }

   public static void method10127(boolean var0) {
      method10135(var0, true);
   }

   private void method10128(double var1, double var3) {
      field22789 = (float)(field22789 + var1 * field22792);
      field22790 = (float)(field22790 + var3 * field22793);
      if (!field22791) {
         field22790 = Mth.clamp(field22790, field22794, field22795);
      }
   }

   public static void method10129(float var0) {
      field22790 = var0;
   }

   public static boolean method10130() {
      return field22788;
   }

   public static float method10131() {
      return field22789;
   }

   public static void method10132(boolean var0) {
      field22791 = var0;
   }

   @Subscribe
   public void method10133(CameraRotationEvent var1) {
      if (!field22788 && !this.method10126()) {
         field22789 = var1.method05950();
         field22790 = var1.method05955();
      } else {
         var1.method05952(field22789);
         var1.method05951(field22790);
         var1.method05695(true);
      }
   }

   public static float method10134() {
      return field22790;
   }

   public static void method10135(boolean var0, boolean var1) {
      if (field22788 != var0) {
         field22788 = var0;
         if (var1) {
            method10136();
         }
      }
   }

   private static void method10136() {
      if (mc.player != null) {
         mc.player.setYRot(mc.player.getYRot() + Mth.wrapDegrees(field22789 - mc.player.getYRot()));
         mc.player.setXRot(field22790);
      }
   }

   public FreeLookController() {
      EventBus.method00263(this);
   }

   @Subscribe
   public void method10137(MouseTurnEvent var1) {
      if (field22788 || this.method10126()) {
         this.method10128(var1.method04330(), var1.method04331());
         var1.method05695(true);
      }
   }
}
