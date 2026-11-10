// Original binary: sg/ec/eXJZkiA3DGdG99Vh
package sg.ec;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.Identifier;
import org.joml.Matrix3x2fStack;
import org.joml.Vector2f;

// $VF: Compiled from s
public final class GpsManager implements MinecraftAccess {
   private static final SmoothAnimation field18651 = new SmoothAnimation();
   private static Vector2f field18652 = null;
   private static final CornerRadii field18653 = new CornerRadii(1.0F);
   private static final CornerColors field18654 = new CornerColors(-1);
   private static Identifier field18655 = null;
   private static final double field18656 = 0.1F;
   private static final double field18657 = 2.0;
   private static final double field18658 = 2.0;
   private static final double field18659 = 180.0;
   private static final double field18660 = Math.PI;
   private static final float field18661 = 0.25F;
   private static final float field18662 = 18.0F;
   private static final float field18663 = 90.0F;
   private static final float field18664 = (float) (Math.PI / 180.0);
   private static final float field18665 = 7.0F;
   private static final float field18666 = 0.1F;
   private static final float field18667 = 4.0F;
   private static final float field18668 = 7.0F;
   private static final float field18669 = 0.1F;
   private static final String field18670 = "This is a utility class and cannot be instantiated";
   private static final String field18671 = "GpsManager()";

   public static void method07826(GuiGraphics var0) {
      if (field18655 != null && mc.player != null) {
         field18651.method06162();
         field18651.method06168(mc.gameRenderer.getMainCamera().getYRot(), field18656, Easings.field19421, true);
         double var1 = field18652.x - mc.getEntityRenderDispatcher().camera.position().x();
         double sx = field18652.y - mc.getEntityRenderDispatcher().camera.position().z();
         double sxx = Math.cos(Math.toRadians(field18651.method06159()));
         double sxxx = Math.sin(Math.toRadians(field18651.method06159()));
         double sxxxx = -(sx * sxx - var1 * sxxx);
         double sxxxxx = -(var1 * sxx + sx * sxxx);
         double sxxxxxx = Math.sqrt(Math.pow(field18652.x - mc.player.getX(), field18657) + Math.pow(field18652.y - mc.player.getZ(), field18658));
         float sxxxxxxx = (float)(Math.atan2(sxxxx, sxxxxx) * field18659 / field18660);
         float sxxxxxxxx = mc.getWindow().getGuiScaledWidth() / 2.0F;
         float sxxxxxxxxx = mc.getWindow().getGuiScaledHeight() * field18661;
         float sxxxxxxxxxx = field18662;
         Matrix3x2fStack sxxxxxxxxxxx = var0.pose();
         sxxxxxxxxxxx.pushMatrix();
         sxxxxxxxxxxx.translate(sxxxxxxxx, sxxxxxxxxx);
         sxxxxxxxxxxx.rotate((sxxxxxxx + field18663) * field18664);
         float sxxxxxxxxxxxx = -(sxxxxxxxxxx / 2.0F);
         GuiTextureRenderer.method10253(
            var0, field18655, 1.0F, 1.0F, 1.0F, 1.0F, sxxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxxx, field18653, 1.0F, field18654
         );
         sxxxxxxxxxxx.popMatrix();
         Fonts.field00110
            .method09490(
               var0,
               (int)sxxxxxx + "m",
               sxxxxxxxx - Fonts.field00110.method09478((int)sxxxxxx + "m", field18665, field18666) / 2.0F,
               sxxxxxxxxx + sxxxxxxxxxx / 2.0F + field18667,
               -1,
               field18668,
               field18669
            );
      }
   }

   @Override
   public boolean equals(Object var1) {
      return var1 == this ? true : var1 instanceof GpsManager;
   }

   public static void method07827() {
      field18652 = null;
   }

   public static void method07828(Vector2f var0) {
      field18652 = var0;
   }

   @Override
   public String toString() {
      return field18671;
   }

   @Override
   public int hashCode() {
      boolean var1 = true;
      return 1;
   }

   public static void method07829() {
      field18655 = ClientTextures.INSTANCE.method04562().get(ModuleManager.INSTANCE.method08263().method04542().method03022());
   }

   public static Vector2f method07830() {
      return field18652;
   }

   private GpsManager() {
      throw new UnsupportedOperationException(field18670);
   }
}
