// Original binary: sg/ec/66Ah1QiOTQqHgLB2
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public final class RoundedRectRenderer {
   private static final float field02743 = 0.5F;
   private static final String field02744 = "This is a utility class and cannot be instantiated";

   public static void method01272(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, int var7) {
      method01273(var0, var1, var2, var3, var4, new CornerRadii(var5), var6, new CornerColors(var7));
   }

   private RoundedRectRenderer() {
      throw new UnsupportedOperationException(field02744);
   }

   public static void method01273(
      GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, CornerColors var7
   ) {
      if (ColorUtils.method04625(var7.color1()) >= 1
         || ColorUtils.method04625(var7.color2()) >= 1
         || ColorUtils.method04625(var7.color3()) >= 1
         || ColorUtils.method04625(var7.color4()) >= 1) {
         RoundedOutlineRenderState var8 = new RoundedOutlineRenderState(
            var1, var2, var3, var4, var5, var6, var7, var0.scissorStack.peek(), GuiPoseCache.method00056(var0.pose())
         );
         GuiRenderBatch.method05186(var0.guiRenderState, var8);
      }
   }

   public static void method01274(GuiGraphicsExtractor var0, float var1, float var2, float var3, int var4) {
      method01272(var0, var1 - var3 / 2.0F, var2 - var3 / 2.0F, var3, var3, var3 / 2.0F - 1.0F, field02743, var4);
   }

   public static void method01275(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, float var5, float var6, CornerColors var7) {
      method01273(var0, var1, var2, var3, var4, new CornerRadii(var5), var6, var7);
   }

   public static void method01276(GuiGraphicsExtractor var0, float var1, float var2, float var3, float var4, CornerRadii var5, float var6, int var7) {
      method01273(var0, var1, var2, var3, var4, var5, var6, new CornerColors(var7));
   }

   public static void method01277() {
      GuiRenderBatch.method05194();
   }

   public static void method01278() {
      GuiRenderBatch.method05181();
   }
}
