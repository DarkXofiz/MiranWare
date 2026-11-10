// Original binary: sg/ec/ZhYyXlgAv4bMoTYq
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class ScrollbarRenderer {
   private static final float field15576 = 0.92F;
   private static final float field15577 = 3.0F;
   private static final float field15578 = 0.92F;
   private static final float field15579 = 0.07999998F;

   private ScrollbarRenderer() {
   }

   public static void method06911(GuiGraphicsExtractor var0, float var1, float var2, float var3) {
      float var4 = var3 * var3 * (field15577 - 2.0F * var3);
      float var5 = field15578 + field15579 * var4;
      var0.pose().pushMatrix();
      var0.pose().translate(var1, var2);
      var0.pose().scale(1.0F, var5);
      var0.pose().translate(-var1, -var2);
   }
}
