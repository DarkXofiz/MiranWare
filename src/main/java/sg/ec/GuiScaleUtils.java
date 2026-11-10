// Original binary: sg/ec/YmJ7Zwk7sl70XFlx
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public final class GuiScaleUtils implements MinecraftAccess {
   private static final int field15037 = 2;
   private static double field15038 = GuiScaleUtils.field15043;
   private static int field15039 = 0;
   private static final double field15040 = 2.0;
   private static final double field15041 = 2.0;
   private static final String field15042 = "This is a utility class and cannot be instantiated";
   private static final double field15043 = 2.0;

   public static double method06743() {
      return field15038;
   }

   public static double method06744(double var0) {
      return var0 * method06751();
   }

   public static double method06745(double var0) {
      return var0 * method06751();
   }

   private GuiScaleUtils() {
      throw new UnsupportedOperationException(field15042);
   }

   public static Vec2 method06746(double var0, double var2) {
      return new Vec2(method06752((float)var0), method06749((float)var2));
   }

   public static void method06747(double var0) {
      field15038 = var0;
   }

   public static void method06748(GuiGraphicsExtractor var0) {
      if (field15039 > 0) {
         field15039--;
         if (field15039 == 0) {
            var0.pose().popMatrix();
            mc.getWindow().setGuiScale((int)method06743());
         }
      }
   }

   public static float method06749(float var0) {
      return var0 * method06751();
   }

   public static void method06750(GuiGraphicsExtractor var0) {
      if (field15039 == 0) {
         method06747(mc.getWindow().getGuiScale());
         mc.getWindow().setGuiScale(2);
         float var1 = (float)(field15040 / field15038);
         var0.pose().pushMatrix();
         var0.pose().scale(var1, var1);
      }

      field15039++;
   }

   private static float method06751() {
      return (float)(mc.getWindow().getGuiScale() / field15041);
   }

   public static float method06752(float var0) {
      return var0 * method06751();
   }

   public static float method06753() {
      return method06752(mc.getWindow().getGuiScaledWidth());
   }

   public static float method06754() {
      return method06749(mc.getWindow().getGuiScaledHeight());
   }
}
