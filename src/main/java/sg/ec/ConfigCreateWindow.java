// Original binary: sg/ec/ZRIjZCXUBtLrJSyx
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ConfigCreateWindow extends FloatingWindow {
   public static final String field15477 = "configs.create";
   public static final float field15478 = 0;
   private static final float field15479 = 0;
   private static final float field15480 = 0;
   private static final String field15481 = "field15481";
   private static final int field15482 = ColorUtils.method04604(235, 90, 90);
   private final boolean field15483;
   private final Runnable field15484;
   private final Runnable field15485;
   private final SmoothAnimation field15486 = new SmoothAnimation();
   private final SmoothAnimation field15487 = new SmoothAnimation();
   private static final String field15488 = "Создать";
   private static final String field15489 = "configs.create";
   private static final float field15490 = 96.0F;
   private static final float field15491 = 14.0F;
   private static final float field15492 = 21.0F;
   private static final float field15493 = 14.0F;
   private static final float field15494 = 96.0F;
   private static final float field15495 = 4.0F;
   private static final float field15496 = 4.0F;
   private static final float field15497 = 0.5F;
   private static final float field15498 = 14.0F;
   private static final float field15499 = 14.0F;
   private static final String field15500 = "Пустой конфиг";
   private static final float field15501 = 6.0F;
   private static final float field15502 = 7.0F;
   private static final float field15503 = 6.0F;
   private static final float field15504 = 6.0F;
   private static final float field15505 = 14.0F;
   private static final float field15506 = 4.0F;
   private static final float field15507 = 1.5F;
   private static final float field15508 = 14.0F;
   private static final float field15509 = 14.0F;
   private static final String field15510 = "С этими настройками";
   private static final float field15511 = 6.0F;
   private static final float field15512 = 4.5F;
   private static final float field15513 = 6.0F;
   private static final String field15514 = "защищён — передать нельзя";
   private static final float field15515 = 6.0F;
   private static final float field15516 = 4.5F;
   private static final float field15517 = 6.0F;
   private static final float field15518 = 0.9F;
   private static final float field15519 = 5.5F;
   private static final String field15520 = "С этими настройками";
   private static final float field15521 = 6.0F;
   private static final float field15522 = 6.0F;
   private static final float field15523 = 6.0F;
   private static final float field15524 = 0.01F;
   private static final float field15525 = 1.5F;
   private static final float field15526 = 3.0F;
   private static final float field15527 = 0.09F;
   private static final float field15528 = 14.0F;
   private static final float field15529 = 14.0F;
   private static final float field15530 = 14.0F;
   private static final double field15531 = 0.12F;

   private static int method06864() {
      return ThemeManager.INSTANCE.method09611().field22118.method11676();
   }

   private static int main() {
      return ThemeManager.INSTANCE.method09611().field22122.method11676();
   }

   public static float method06865(boolean var0) {
      return field15491 + (var0 ? field15492 : field15493) + 1.0F;
   }

   private void method06866(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (!(var7 <= field15524)) {
         RoundedRectRenderer.method01272(
            var1, var3 + field15525, var4 + 1.0F, var5 - field15526, var6 - 2.0F, 2.0F, 1.0F, method06867(method06870(), field15527 * var7 * var2)
         );
      }
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (var5 == 0) {
         float var6 = this.method09576();
         float var7 = this.method09560();
         float var8 = this.method09568();
         float var9 = this.method09574();
         if (GuiHitTestUtils.method05609(var1, var3, var6, var7, var8, field15528)) {
            this.method06869(this.field15484);
         } else {
            if (GuiHitTestUtils.method05609(var1, var3, var6, var7 + field15529, var8, var9 - field15530)) {
               this.method06869(this.field15485);
            }
         }
      }
   }

   private static int method06867(int var0, float var1) {
      return ColorUtils.method04611(var0, var1);
   }

   private static int method06868() {
      return ThemeManager.INSTANCE.method09611().field22117.method11676();
   }

   public ConfigCreateWindow(boolean var1, Runnable var2, Runnable var3) {
      super(field15488, field15489);
      this.field15483 = var1;
      this.field15484 = var2;
      this.field15485 = var3;
      this.method08971(field15490);
      this.method09561(method06865(var1));
   }

   @Override
   public void method00612(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method08971(field15494);
      this.method09561(method06865(this.field15483));
      float var5 = this.method09573().method06173();
      float var6 = this.method09576();
      float var7 = this.method09560();
      float var8 = this.method09568();
      float var9 = this.method09574();
      FontRenderer var10 = Fonts.field00110;
      RoundedRectRenderer.method01272(var1, var6, var7, var8, var9, field15495, 1.0F, method06867(main(), var5));
      GuiShapeRenderer.method09703(var1, var6, var7, var8, var9, field15496, field15497, method06867(method06868(), var5));
      this.method06866(
         var1, var5, var6, var7, var8, field15498, method06871(this.field15486, GuiHitTestUtils.method05624(var2, var3, var6, var7, var8, field15499))
      );
      var10.method09480(
         var1, field15500, var6 + field15501, var7 + field15502 - var10.method09485(field15503) / 2.0F, method06867(method06870(), var5), field15504
      );
      RoundedRectRenderer.method01272(var1, var6 + 2.0F, var7 + field15505, var8 - field15506, 1.0F, field15507, 1.0F, method06867(method06864(), var5));
      float var11 = var7 + field15508;
      float var12 = var9 - field15509;
      this.method06866(var1, var5, var6, var11, var8, var12, method06871(this.field15487, GuiHitTestUtils.method05624(var2, var3, var6, var11, var8, var12)));
      if (this.field15483) {
         var10.method09480(var1, field15510, var6 + field15511, var11 + field15512, method06867(method06870(), var5), field15513);
         var10.method09480(
            var1,
            field15514,
            var6 + field15515,
            var11 + field15516 + var10.method09485(field15517) + 2.0F,
            method06867(field15482, field15518 * var5),
            field15519
         );
      } else {
         var10.method09480(
            var1, field15520, var6 + field15521, var11 + var12 / 2.0F - var10.method09485(field15522) / 2.0F, method06867(method06870(), var5), field15523
         );
      }
   }

   private void method06869(Runnable var1) {
      if (var1 != null) {
         var1.run();
      }

      if (this.method09580() != null) {
         this.method09580().method09654(this);
      }
   }

   private static int method06870() {
      return ThemeManager.INSTANCE.method09611().field22109.method11676();
   }

   private static float method06871(SmoothAnimation var0, boolean var1) {
      var0.method06162();
      var0.method06168(var1 ? 1.0 : 0.0, field15531, Easings.field19400, true);
      return var0.method06173();
   }
}
