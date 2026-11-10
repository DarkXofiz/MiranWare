// Original binary: sg/ec/mO9Xg2UrXI8v00q8
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.util.FormattedCharSink;

// $VF: Compiled from s
public class FontRenderer {
   public final FontFace field21527;
   private static final int field21528 = 16777215;
   private static final float field21529 = 0.5F;

   public float method09471(GuiGraphicsExtractor var1, Component var2, float var3, float var4, int var5, float var6) {
      return this.method09477(var1, var2, var3, var4, var5, var6, 0.0F);
   }

   public float method09472(GuiGraphicsExtractor var1, Component var2, float var3, float var4, int var5, float var6, float var7, int var8) {
      return this.method09477(var1, var2, var3, var4, ColorUtils.method04616(var5, var8), var6, var7);
   }

   public float method09473(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5, float var6) {
      float var7 = this.method09486(var2, var6);
      this.method09480(var1, var2, var3 - var7 / 2.0F, var4, var5, var6);
      return var7;
   }

   public static String method09474(Component var0, int var1) {
      if (var0 == null) {
         return "";
      }

      final int var2 = var1 & field21528;
      int var3 = TextCacheInvalidator.field17747;
      ComponentTextCacheAccess var4 = var0 instanceof ComponentTextCacheAccess ? (ComponentTextCacheAccess)var0 : null;
      if (var4 != null) {
         String var5 = var4.hex$formattedText();
         if (var5 != null && var4.hex$formattedColor() == var2 && var4.hex$formattedGeneration() == var3) {
            return var5;
         }
      }

      final StringBuilder var7 = new StringBuilder();
      var0.getVisualOrderText()
         .accept(
            new FormattedCharSink()      // $VF: Compiled from s
       {
               private int field21530 = var2;
               private static final int field21533 = 16777215;

               @Override
               public boolean accept(int var1, Style var2x, int var3x) {
                  int var4x = var2x.getColor() != null ? var2x.getColor().getValue() & field21533 : var2;
                  if (var4x != this.field21530) {
                     var7.append(
                        ChatColorFormatter.method07520(
                           ColorUtils.method04588(var4x), ColorUtils.method04589(var4x), ColorUtils.method04587(var4x)
                        )
                     );
                     this.field21530 = var4x;
                  }

                  var7.appendCodePoint(var3x);
                  return true;
               }
            }
         );
      String var6 = var7.toString();
      if (var4 != null) {
         var4.hex$formattedText(var6, var2, var3);
      }

      return var6;
   }

   public static void method09475() {
      GuiRenderBatch.method05194();
   }

   public float method09476(Component var1, float var2, float var3) {
      return var1 == null ? 0.0F : this.method09478(method09483(var1), var2, var3);
   }

   public float method09477(GuiGraphicsExtractor var1, Component var2, float var3, float var4, int var5, float var6, float var7) {
      return this.method09490(var1, method09474(var2, var5), var3, var4, var5, var6, var7);
   }

   public float method09478(String var1, float var2, float var3) {
      return var1 != null && !var1.isEmpty() ? this.field21527.method06999(var1, var2, var3) : 0.0F;
   }

   private FontFace method09479(String var1) {
      return FontFace.method07010().method07017(var1).method07020(var1).method07018();
   }

   public float method09480(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5, float var6) {
      return this.method09490(var1, var2, var3, var4, var5, var6, 0.0F);
   }

   public float method09481(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5, int var6, float var7, float var8) {
      if (var2 == null) {
         return 0.0F;
      }

      MutableComponent var9 = Component.empty();

      for (int var10 = 0; var10 < var2.length(); var10++) {
         char var11 = var2.charAt(var10);
         MutableComponent var12 = Component.literal(String.valueOf(var11));
         int var13 = ColorUtils.method04613(5, var10 * 20, var5, var6);
         Style var14 = Style.EMPTY.withColor(TextColor.fromRgb(var13));
         var12.setStyle(var14);
         var9.append(var12);
      }

      return this.method09477(var1, var9, var3, var4, ColorUtils.method04616(var5, ColorUtils.method04625(var5)), var7, var8);
   }

   public FontRenderer(String var1) {
      this.field21527 = this.method09479(var1);
   }

   public float method09482(GuiGraphicsExtractor var1, String var2, float var3, float var4, CornerColors var5, float var6, float var7) {
      if (var2 != null && !var2.isEmpty()) {
         FontTextRenderState var8 = new FontTextRenderState(
            var2, this.field21527, var3, var4, field21529, var6, var5, var7, var1.scissorStack.peek(), GuiPoseCache.method00056(var1.pose())
         );
         GuiRenderBatch.method05186(var1.guiRenderState, var8);
         return 0.0F;
      } else {
         return 0.0F;
      }
   }

   public static String method09483(Component var0) {
      return method09474(var0, -1);
   }

   public static void method09484() {
      GuiRenderBatch.method05181();
   }

   public float method09485(float var1) {
      return var1;
   }

   public float method09486(String var1, float var2) {
      return this.method09478(var1, var2, 0.0F);
   }

   public void method09487(GuiGraphicsExtractor var1, String var2, float var3, float var4, float var5, int var6) {
      if (var2 != null && !var2.isEmpty()) {
         FontGlyph var7 = this.field21527.method07009(var2.charAt(0));
         if (var7 != null && var7.method03695()) {
            float var8 = var7.method03696();
            float var9 = var7.method03700();
            float var10 = var3 - (var7.method03694() + var8 / 2.0F) * var5;
            float var11 = var4 + var7.method03691() * var5 + 1.0F - var9 * var5 / 2.0F;
            this.method09480(var1, var2, var10, var11, var6, var5);
         } else {
            this.method09473(var1, var2, var3, var4 - var5 / 2.0F, var6, var5);
         }
      }
   }

   public float method09488(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5, float var6, float var7) {
      float var8 = this.method09478(var2, var6, var7);
      this.method09490(var1, var2, var3 - var8 / 2.0F, var4, var5, var6, var7);
      return var8;
   }

   public float method09489(Component var1, float var2) {
      return this.method09476(var1, var2, 0.0F);
   }

   public float method09490(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5, float var6, float var7) {
      return this.method09482(var1, var2, var3, var4, new CornerColors(var5), var6, var7);
   }
}
