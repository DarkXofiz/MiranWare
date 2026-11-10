// Original binary: sg/ec/gzbdjPfyw3bAA2xq
package sg.ec;

import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GuiRectangleUtils {
   private static final String field19707 = "This is a utility class and cannot be instantiated";

   public static ScreenRectangle method08620(int var0, int var1, int var2, int var3, Matrix3x2f var4, ScreenRectangle var5) {
      ScreenRectangle var6 = new ScreenRectangle(var0, var1, var2 - var0, var3 - var1).transformMaxBounds(var4);
      return var5 != null ? var5.intersection(var6) : var6;
   }

   public static ScreenRectangle method08621(float var0, float var1, float var2, float var3, Matrix3x2f var4, ScreenRectangle var5) {
      return method08620((int)var0, (int)var1, (int)var2, (int)var3, var4, var5);
   }

   private GuiRectangleUtils() {
      throw new UnsupportedOperationException(field19707);
   }
}
