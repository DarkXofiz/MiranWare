// Original binary: sg/ec/c3gzEbMoBw2HQ8cl
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class TextPromptScreen extends ClientScreen {
   private static final float field17508 = 208.0F;
   private static final float field17509 = 0;
   private static final float field17510 = 0;
   private static final float field17511 = 0;
   private static final float field17512 = 0;
   private static final float field17513 = 0;
   private static final float field17514 = 0;
   private static final float field17515 = 0;
   private static final float field17516 = 0;
   private static final float field17517 = 0;
   private static final float field17518 = 0;
   private static final float field17519 = 0;
   private static final float field17520 = 0;
   private static final float field17521 = 0;
   private static final float field17522 = 0;
   private static final float field17523 = 0;
   private static final float field17524 = 0;
   private static final float field17525 = 0;
   private static final int field17526 = 0;
   private static final String field17527 = "field17527";
   private static final String field17528 = "field17528";
   private static final String field17529 = "field17529";
   private static final String field17530 = "field17530";
   private static final String field17531 = "field17531";
   private static final String field17532 = "field17532";
   private final SmoothAnimation field17533 = new SmoothAnimation();
   private final SmoothAnimation field17534 = new SmoothAnimation();
   private final GuiClickRegions field17535 = new GuiClickRegions();
   private ConfigSharePromptManager.Nested72 field17536;
   private static final float field17537 = 174.0F;
   private static final float field17538 = 6.0F;
   private static final String field17539 = "Подтверди, если это ты: Discord-аккаунт будет привязан к твоему логину.";
   private static final float field17540 = 188.0F;
   private static final float field17541 = 6.0F;
   private static final float field17542 = 14.0F;
   private static final float field17543 = 7.0F;
   private static final float field17544 = 2.5F;
   private static final float field17545 = 10.0F;
   private static final float field17546 = 8.0F;
   private static final float field17547 = 2.5F;
   private static final float field17548 = 6.0F;
   private static final float field17549 = 6.0F;
   private static final float field17550 = 6.0F;
   private static final float field17551 = 6.0F;
   private static final float field17552 = 15.0F;
   private static final float field17553 = 10.0F;
   private static final float field17554 = 208.0F;
   private static final float field17555 = 104.0F;
   private static final float field17556 = 10.0F;
   private static final String field17557 = "Авторизация Discord";
   private static final float field17558 = 10.0F;
   private static final float field17559 = 8.0F;
   private static final float field17560 = 8.0F;
   private static final float field17561 = 2.5F;
   private static final float field17562 = 6.0F;
   private static final float field17563 = 188.0F;
   private static final float field17564 = 10.0F;
   private static final float field17565 = 6.0F;
   private static final float field17566 = 6.0F;
   private static final float field17567 = 6.0F;
   private static final float field17568 = 6.0F;
   private static final float field17569 = 10.0F;
   private static final float field17570 = 0.8F;
   private static final float field17571 = 6.0F;
   private static final float field17572 = 6.0F;
   private static final float field17573 = 2.5F;
   private static final float field17574 = 2.5F;
   private static final float field17575 = 6.0F;
   private static final float field17576 = 0.92F;
   private static final float field17577 = 208.0F;
   private static final float field17578 = 7.0F;
   private static final float field17579 = 35.0F;
   private static final float field17580 = 208.0F;
   private static final float field17581 = 7.0F;
   private static final float field17582 = 208.0F;
   private static final float field17583 = 7.0F;
   private static final float field17584 = 15.0F;
   private static final float field17585 = 0.6F;
   private static final float field17586 = 10.0F;
   private static final float field17587 = 188.0F;
   private static final float field17588 = 4.0F;
   private static final float field17589 = 4.0F;
   private static final float field17590 = 0.5F;
   private static final float field17591 = 0.45F;
   private static final float field17592 = 6.0F;
   private static final float field17593 = 14.0F;
   private static final float field17594 = 6.0F;
   private static final float field17595 = 7.0F;
   private static final float field17596 = 7.0F;
   private static final float field17597 = 7.0F;
   private static final float field17598 = 7.0F;
   private static final float field17599 = 7.0F;
   private static final float field17600 = 7.0F;
   private static final float field17601 = 6.0F;
   private static final float field17602 = 6.0F;
   private static final float field17603 = 7.0F;
   private static final float field17604 = 2.5F;
   private static final float field17605 = 7.0F;
   private static final float field17606 = 0.9F;
   private static final float field17607 = 6.0F;
   private static final float field17608 = 6.0F;
   private static final float field17609 = 2.5F;
   private static final float field17610 = 91.0F;
   private static final float field17611 = 10.0F;
   private static final float field17612 = 6.0F;
   private static final float field17613 = 15.0F;
   private static final float field17614 = 15.0F;
   private static final float field17615 = 15.0F;
   private static final String field17616 = "Подтвердить";
   private static final float field17617 = 15.0F;
   private static final String field17618 = "Отклонить";
   private static final float field17619 = 15.0F;
   private static final float field17620 = 15.0F;
   private static final double field17621 = 0.2F;
   private static final float field17622 = 6.0F;
   private static final float field17623 = 2.5F;
   private static final String field17624 = "\\s+";

   private static float method07221(SmoothAnimation var0, boolean var1) {
      var0.method06162();
      var0.method06158(var1 ? 1.0 : 0.0, field17621, Easings.field19400);
      return var0.method06173();
   }

   @Override
   public boolean method01477(double var1, double var3, int var5, boolean var6) {
      if (var5 != 0) {
         return true;
      }

      Vec2 var7 = GuiScaleUtils.method06746(var1, var3);
      this.field17535.method03441(var7.x, var7.y);
      return true;
   }

   private static float method07222(FontRenderer var0, List<String> var1) {
      return var1.isEmpty() ? 0.0F : var1.size() * var0.method09485(field17622) + (var1.size() - 1) * field17623;
   }

   private static List<String> method07223(FontRenderer var0, String var1, float var2, float var3) {
      ArrayList var4 = new ArrayList();
      if (var1 != null && !var1.isBlank() && !(var2 <= 0.0F)) {
         StringBuilder var5 = new StringBuilder();

         for (String var9 : var1.trim().split(field17624)) {
            String var10 = var5.isEmpty() ? var9 : var5 + " " + var9;
            if (var0.method09486(var10, var3) <= var2) {
               var5.setLength(0);
               var5.append(var10);
            } else {
               if (!var5.isEmpty()) {
                  var4.add(var5.toString());
               }

               var5.setLength(0);
               var5.append(var9);
               if (var4.size() == 3) {
                  break;
               }
            }
         }

         if (var4.size() < 3 && !var5.isEmpty()) {
            var4.add(var5.toString());
         }

         if (var4.size() > 3) {
            var4 = new ArrayList(var4.subList(0, 3));
         }

         int var11 = var4.size() - 1;
         if (var11 >= 0) {
            var4.set(var11, GuiThemeStyle.method01438(var0, (String)var4.get(var11), var3, var2));
         }

         return var4;
      } else {
         return var4;
      }
   }

   private void method07224(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5) {
      int var6 = GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22119.method11676(), field17576 * var5);
      GuiClipStack.method00341(var1, var2, var3, field17577, var4, field17578, 1.0F, field17579, var5);
      RoundedRectRenderer.method01272(var1, var2, var3, field17580, var4, field17581, 1.0F, var6);
      GuiShadowRenderer.method10984(var1, var2, var3, field17582, var4, field17583, 1.0F, field17584, GuiThemeStyle.method01443(var6, field17585));
   }

   private void method07225(GuiGraphicsExtractor var1, float var2, float var3, float var4, List<String> var5, float var6) {
      FontRenderer var7 = GuiThemeStyle.field03544;
      FontRenderer var8 = GuiThemeStyle.field03545;
      float var9 = var2 + field17586;
      float var10 = field17587;
      RoundedRectRenderer.method01272(var1, var9, var3, var10, var4, field17588, 1.0F, GuiThemeStyle.method01443(GuiThemeStyle.method01439(), var6));
      GuiShapeRenderer.method09703(
         var1,
         var9,
         var3,
         var10,
         var4,
         field17589,
         field17590,
         GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22117.method11676(), field17591 * var6)
      );
      String var11 = this.field17536.author().isEmpty() ? "" : "автор: " + this.field17536.author();
      float var12 = var11.isEmpty() ? 0.0F : var8.method09486(var11, field17592);
      float var13 = var10 - field17593 - (var12 > 0.0F ? var12 + field17594 : 0.0F);
      float var14 = var3 + field17595;
      var7.method09480(
         var1,
         GuiThemeStyle.method01438(var7, this.field17536.configName(), field17596, var13),
         var9 + field17597,
         var14,
         GuiThemeStyle.method01437(var6),
         field17598
      );
      if (!var11.isEmpty()) {
         var8.method09480(
            var1,
            var11,
            var9 + var10 - field17599 - var12,
            var14 + (var7.method09485(field17600) - var8.method09485(field17601)) / 2.0F,
            GuiThemeStyle.method01445(var6),
            field17602
         );
      }

      float var15 = var14 + var7.method09485(field17603) + field17604;

      for (String var17 : var5) {
         var8.method09480(var1, var17, var9 + field17605, var15, GuiThemeStyle.method01445(field17606 * var6), field17607);
         var15 += var8.method09485(field17608) + field17609;
      }
   }

   @Override
   protected void method01472(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      if (this.field17536 == null) {
         ClientScreenManager.INSTANCE.method08321();
      } else {
         ConfigSharePromptManager.Nested72 var5 = ConfigSharePromptManager.INSTANCE.method02650();
         if (var5 != null) {
            this.field17536 = var5;
         }

         float var6 = this.method01470();
         Vec2 var7 = GuiScaleUtils.method06746(var2, var3);
         this.field17535.method03440();
         FontRenderer var8 = GuiThemeStyle.field03543;
         FontRenderer var9 = GuiThemeStyle.field03544;
         FontRenderer var10 = GuiThemeStyle.field03545;
         var var11 = method07223(var10, this.field17536.description(), field17537, field17538);
         var var12 = method07223(var10, field17539, field17540, field17541);
         float var13 = field17542 + var9.method09485(field17543) + (var11.isEmpty() ? 0.0F : field17544 + method07222(var10, var11));
         float var14 = field17545
            + var8.method09485(field17546)
            + field17547
            + var10.method09485(field17548)
            + field17549
            + var13
            + field17550
            + method07222(var10, var12)
            + field17551
            + field17552
            + field17553;
         float var15 = (GuiScaleUtils.method06753() - field17554) / 2.0F;
         float var16 = (GuiScaleUtils.method06754() - var14) / 2.0F;
         this.method01467(var1, var15 + field17555, var16);
         this.method07224(var1, var15, var16, var14, var6);
         float var17 = var16 + field17556;
         var8.method09480(var1, field17557, var15 + field17558, var17, GuiThemeStyle.method01437(var6), field17559);
         var17 += var8.method09485(field17560) + field17561;
         var10.method09480(
            var1,
            GuiThemeStyle.method01438(var10, this.field17536.discordName() + " хочет добавить конфиг в твою библиотеку", field17562, field17563),
            var15 + field17564,
            var17,
            GuiThemeStyle.method01445(var6),
            field17565
         );
         var17 += var10.method09485(field17566) + field17567;
         this.method07225(var1, var15, var17, var13, var11, var6);
         var17 += var13 + field17568;

         for (String var19 : var12) {
            var10.method09480(var1, var19, var15 + field17569, var17, GuiThemeStyle.method01445(field17570 * var6), field17571);
            var17 += var10.method09485(field17572) + field17573;
         }

         var17 = var17 - field17574 + field17575;
         this.method07226(var1, var15, var17, var7, var6);
         var1.pose().popMatrix();
      }
   }

   private void method07226(GuiGraphicsExtractor var1, float var2, float var3, Vec2 var4, float var5) {
      float var6 = field17610;
      float var7 = var2 + field17611;
      float var8 = var7 + var6 + field17612;
      float var9 = method07221(this.field17533, GuiHitTestUtils.method05625(var4.x, var4.y, var7, var3, var6, field17613));
      float var10 = method07221(this.field17534, GuiHitTestUtils.method05625(var4.x, var4.y, var8, var3, var6, field17614));
      GuiThemeStyle.method01444(var1, var7, var3, var6, field17615, field17616, var9, GuiThemeStyle.Nested40.NORMAL, var5);
      GuiThemeStyle.method01444(var1, var8, var3, var6, field17617, field17618, var10, GuiThemeStyle.Nested40.DANGER, var5);
      this.field17535.method03442(var7, var3, var6, field17619, ConfigSharePromptManager.INSTANCE::method02652);
      this.field17535.method03442(var8, var3, var6, field17620, ConfigSharePromptManager.INSTANCE::method02653);
   }

   @Override
   protected void method01466() {
      if (ConfigSharePromptManager.INSTANCE.method02650() != null) {
         ConfigSharePromptManager.INSTANCE.method02653();
      }
   }

   @Override
   public boolean method01464(int var1, int var2, int var3) {
      if (var1 != 257 && var1 != 335) {
         return false;
      }

      ConfigSharePromptManager.INSTANCE.method02652();
      return true;
   }

   @Override
   protected void method01474() {
      this.field17536 = ConfigSharePromptManager.INSTANCE.method02650();
   }
}
