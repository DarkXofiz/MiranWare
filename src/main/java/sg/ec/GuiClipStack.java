// Original binary: sg/ec/1ze54qPOcQkzX4GV
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class GuiClipStack {
   private static final float field00720 = 255.0F;
   private static final String field00721 = "This is a utility class and cannot be instantiated";

   public static void method00339(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      method00344(var0, var1, var2, var3, var4, new CornerRadii(var5), var6, var7, 1.0F);
   }

   public static void method00340(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, float var7) {
      method00344(var0, var1, var2, var3, var4, var5, var6, 1.0F, var7);
   }

   private GuiClipStack() {
      throw new UnsupportedOperationException(field00721);
   }

   public static void method00341(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      method00344(var0, var1, var2, var3, var4, new CornerRadii(var5), var6, var7, var8);
   }

   public static void method00342() {
      GuiRenderBatch.method05181();
   }

   public static void method00343() {
      GuiRenderBatch.method05194();
   }

   public static void method00344(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, float var7, float var8
   ) {
      method00345(var0, var1, var2, var3, var4, var5, var6, var7, var8, -1);
   }

   public static void method00345(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, float var7, float var8, int var9
   ) {
      GuiRenderBatch.method05186(
         var0.guiRenderState,
         new ClipGuiRenderState(
            var1,
            var2,
            var3,
            var4,
            var5,
            var6,
            var7,
            new CornerColors(ColorUtils.method04616(var9, (int)(field00720 * var8))),
            var0.scissorStack.peek(),
            new Matrix3x2f(var0.pose())
         )
      );
   }
}
