// Original binary: sg/ec/v6vqOGGxjXqJHYVd
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GuiShadowRenderer {
   private static final String field24631 = "This is a utility class and cannot be instantiated";

   public static void method10981() {
      GuiRenderBatch.method05194();
   }

   public static void method10982(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, float var7, CornerColors var8
   ) {
      GuiRenderBatch.method05186(
         var0.guiRenderState, new GuiShadowRenderState(var1, var2, var3, var4, var5, var6, var7, var8, var0.scissorStack.peek(), new Matrix3x2f(var0.pose()))
      );
   }

   public static void method10983() {
      GuiRenderBatch.method05181();
   }

   public static void method10984(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      method10982(var0, var1, var2, var3, var4, new CornerRadii(var5), var6, var7, new CornerColors(var8));
   }

   public static void method10985(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, float var7, int var8
   ) {
      method10982(var0, var1, var2, var3, var4, var5, var6, var7, new CornerColors(var8));
   }

   private GuiShadowRenderer() {
      throw new UnsupportedOperationException(field24631);
   }
}
