// Original binary: sg/ec/Udo2I8W6Y0sOrfWI
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ConfigSaleKeysWindow extends FloatingWindow {
   public static final String field12535 = "configs.saleKeys";
   public static final float field12536 = 0;
   public static final float field12537 = 0;
   private static final float field12538 = 0;
   private static final float field12539 = 0;
   private static final float field12540 = 0;
   private static final float field12541 = 0;
   private static final float field12542 = 0;
   private static final float field12543 = 0;
   private static final float field12544 = 0;
   private static final float field12545 = 0;
   private static final float field12546 = 0;
   private static final float field12547 = 0;
   private static final float field12548 = 0;
   private static final float field12549 = 0;
   private static final float field12550 = 0;
   private static final float field12551 = 0;
   private static final float field12552 = 0;
   private static final long field12553 = 0;
   private static final int field12554 = 0;
   private static final String field12555 = "field12555";
   private static final String field12556 = "field12556";
   private static final String field12557 = "field12557";
   private static final String field12558 = "field12558";
   private static final String field12559 = "field12559";
   private static final String field12560 = "field12560";
   private static final String field12561 = "field12561";
   private static final String field12562 = "field12562";
   private static final String field12563 = "field12563";
   private final String field12564;
   private final String field12565;
   private final ScrollController field12566 = new ScrollController();
   private final Map<Object, SmoothAnimation> field12567 = new HashMap<>();
   private final List<ConfigSaleKeysWindow.Nested178> field12568 = new ArrayList<>();
   private final FontRenderer field12569 = Fonts.field00110;
   private final FontRenderer field12570 = Fonts.field00111;
   private String field12571;
   private long field12572;
   private static final String field12573 = "Ключи";
   private static final String field12574 = "configs.saleKeys";
   private static final float field12575 = 196.0F;
   private static final float field12576 = 190.0F;
   private static final float field12577 = 15.0F;
   private static final float field12578 = 17.5F;
   private static final float field12579 = 2.5F;
   private static final float field12580 = 190.0F;
   private static final float field12581 = 26.0F;
   private static final float field12582 = 14.0F;
   private static final float field12583 = 14.0F;
   private static final float field12584 = 8.0F;
   private static final float field12585 = 7.0F;
   private static final float field12586 = 10.0F;
   private static final float field12587 = 6.0F;
   private static final float field12588 = 5.0F;
   private static final float field12589 = 7.0F;
   private static final float field12590 = 6.5F;
   private static final float field12591 = 7.0F;
   private static final float field12592 = 6.0F;
   private static final float field12593 = 6.5F;
   private static final float field12594 = 7.0F;
   private static final float field12595 = 15.0F;
   private static final float field12596 = 5.5F;
   private static final String field12597 = "close";
   private static final float field12598 = 10.0F;
   private static final float field12599 = 10.0F;
   private static final float field12600 = 5.0F;
   private static final float field12601 = 5.0F;
   private static final float field12602 = 6.0F;
   private static final float field12603 = 10.0F;
   private static final float field12604 = 10.0F;
   private static final float field12605 = 0.5F;
   private static final float field12606 = 26.0F;
   private static final String field12607 = "загрузка…";
   private static final float field12608 = 7.0F;
   private static final float field12609 = 14.0F;
   private static final float field12610 = 26.0F;
   private static final float field12611 = 7.0F;
   private static final float field12612 = 14.0F;
   private static final float field12613 = 7.0F;
   private static final String field12614 = "загрузка…";
   private static final String field12615 = "ключей нет";
   private static final float field12616 = 7.5F;
   private static final float field12617 = 5.5F;
   private static final float field12618 = 5.5F;
   private static final float field12619 = 17.5F;
   private static final float field12620 = 2.5F;
   private static final float field12621 = 15.0F;
   private static final float field12622 = 17.5F;
   private static final float field12623 = 15.0F;
   private static final float field12624 = 15.0F;
   private static final float field12625 = 3.0F;
   private static final float field12626 = 7.5F;
   private static final float field12627 = 5.25F;
   private static final float field12628 = 2.25F;
   private static final String field12629 = "Точно?";
   private static final String field12630 = "Отключить";
   private static final String field12631 = "Копировать";
   private static final float field12632 = 3.0F;
   private static final float field12633 = 7.5F;
   private static final float field12634 = 5.5F;
   private static final float field12635 = 5.0F;
   private static final float field12636 = 5.5F;
   private static final float field12637 = 5.5F;
   private static final float field12638 = 5.0F;
   private static final String field12639 = "свободен";
   private static final float field12640 = 5.5F;
   private static final float field12641 = 5.0F;
   private static final float field12642 = 5.5F;
   private static final float field12643 = 5.5F;
   private static final float field12644 = 10.5F;
   private static final float field12645 = 10.5F;
   private static final float field12646 = 5.5F;
   private static final float field12647 = 10.5F;
   private static final float field12648 = 7.0F;
   private static final float field12649 = 7.0F;
   private static final float field12650 = 14.0F;
   private static final float field12651 = 14.0F;
   private static final String field12652 = "export";
   private static final float field12653 = 14.0F;
   private static final float field12654 = 14.0F;
   private static final String field12655 = "Выгрузить свободные в файл";
   private static final float field12656 = 5.5F;
   private static final float field12657 = 14.0F;
   private static final long field12658 = 3000L;
   private static final String field12659 = "Market";
   private static final String field12660 = "Ключ скопирован в буфер обмена.";
   private static final double field12661 = 0.15F;
   private static final float field12662 = 0.99F;

   private void method05891() {
      if (this.method09580() != null) {
         this.method09580().method09654(this);
      }
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if (var1 == 256) {
         this.method05891();
      }
   }

   private void method05895(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      float var5 = this.method09576() + field12648;
      float var6 = this.method09560() + this.method09574() - field12649 - field12650;
      float var7 = this.method09568() - field12651;
      float var8 = this.method05896(field12652, GuiHitTestUtils.method05624(var2, var3, var5, var6, var7, field12653));
      ConfigPanelRenderer.method03125(var1, this.field12570, var5, var6, var7, field12654, field12655, field12656, var8, var4);
      this.field12568
         .add(new ConfigSaleKeysWindow.Nested178(var5, var6, var7, field12657, () -> GlobalRequestSender.method09378(var1x -> var1x.method01850(this.field12564))));
   }

   private float method05896(Object var1, boolean var2) {
      SmoothAnimation var3 = this.field12567.computeIfAbsent(var1, var0 -> new SmoothAnimation());
      var3.method06162();
      var3.method06168(var2 ? 1.0 : 0.0, field12661, Easings.field19400, true);
      return var3.method06173();
   }

   private boolean method05898(String var1) {
      return var1.equals(this.field12571) && System.currentTimeMillis() - this.field12572 < field12658;
   }

   public ConfigSaleKeysWindow(String var1, String var2) {
      super(field12573, field12574);
      this.field12564 = var1;
      this.field12565 = var2;
      this.method08971(field12575);
      this.method09561(field12576);
   }

   private void method05899(String var1) {
      if (this.method05898(var1)) {
         this.field12571 = null;
         GlobalRequestSender.method09378(var1x -> var1x.method01854(var1));
      } else {
         this.field12571 = var1;
         this.field12572 = System.currentTimeMillis();
      }
   }

   @Override
   public void method00612(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.field12568.clear();
      float var5 = this.method09573().method06173();
      var var6 = this.method05904();
      int var7 = var6 == null ? 0 : var6.size();
      float var8 = Math.max(field12577, var7 * field12578 - field12579);
      this.method09561(Math.min(field12580, field12581 + var8 + field12582 + field12583));
      GuiRenderBatch.method05183();
      ConfigPanelRenderer.method03124(var1, this.method09576(), this.method09560(), this.method09568(), this.method09574(), field12584, var5, this.method09579());
      this.method05909(var1, var6, var2, var3, var5);
      this.method05901(var1, var6, var2, var3, var5);
      this.method05895(var1, var2, var3, var5);
   }

   @Override
   public void method04220() {
      super.method04220();
      GlobalRequestSender.method09378(var1 -> var1.method01846(this.field12564));
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (var5 == 0 && !(this.method09573().method06173() < field12662)) {
         for (ConfigSaleKeysWindow.Nested178 var7 : this.field12568) {
            if (var7.has(var1, var3)) {
               var7.action().run();
               return;
            }
         }
      }
   }

   private void method05901(GuiGraphicsExtractor var1, List<SaleKeyListS2CPacket.Nested163> var2, int var3, int var4, float var5) {
      float var6 = this.method09576() + field12608;
      float var7 = this.method09568() - field12609;
      float var8 = this.method09560() + field12610 + field12611;
      float var9 = this.method09560() + this.method09574() - field12612 - field12613;
      if (var2 != null && !var2.isEmpty()) {
         float var10 = var2.size() * field12619 - field12620;
         this.field12566.method01152(var10 > var9 - var8);
         this.field12566.method01145();
         this.field12566.method01134(var10, var9 - var8);
         boolean var11 = GuiHitTestUtils.method05624(var3, var4, var6, var8, var7, var9 - var8);
         var1.enableScissor((int)var6, (int)var8, (int)Math.ceil(var6 + var7), (int)Math.ceil(var9));
         float var12 = var8 + this.field12566.method01136();

         for (SaleKeyListS2CPacket.Nested163 var14 : var2) {
            if (var12 + field12621 >= var8 && var12 <= var9) {
               this.method05906(var1, var14, var6, var12, var7, var3, var4, var11, var5);
            }

            var12 += field12622;
         }

         var1.disableScissor();
      } else {
         this.field12570
            .method09480(
               var1,
               var2 == null ? field12614 : field12615,
               var6,
               var8 + field12616 - this.field12570.method09485(field12617) / 2.0F,
               ConfigPanelRenderer.method03118(var5),
               field12618
            );
      }
   }

   private void method05903(String var1) {
      mc.keyboardHandler.setClipboard(var1);
      ChatTextUtils.method05101(field12659, field12660);
   }

   private List<SaleKeyListS2CPacket.Nested163> method05904() {
      GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
      if (var1 == null) {
         return null;
      }

      SaleKeyListS2CPacket var2 = var1.getManager().method01798();
      return var2 != null && this.field12564.equals(var2.method05369()) ? var2.method05365() : null;
   }

   private void method05906(
      GuiGraphicsExtractor var1, SaleKeyListS2CPacket.Nested163 var2, float var3, float var4, float var5, int var6, int var7, boolean var8, float var9
   ) {
      float var10 = this.method05896(var2.key(), var8 && GuiHitTestUtils.method05624(var6, var7, var3, var4, var5, field12623));
      ConfigPanelRenderer.method03116(var1, var3, var4, var5, field12624, field12625, var10, 0.0F, var9);
      float var11 = var4 + field12626 - field12627;
      float var12 = var3 + var5 - field12628;
      boolean var13 = this.method05898(var2.key());
      var12 = this.method05907(
         var1,
         var13 ? field12629 : field12630,
         ConfigPanelRenderer.method03127(-29813, var9),
         var12,
         var11,
         var2.key() + ":revoke",
         var6,
         var7,
         var8,
         var9,
         () -> this.method05899(var2.key())
      );
      if (!var2.redeemed()) {
         var12 = this.method05907(
            var1, field12631, -1, var12 - field12632, var11, var2.key() + ":copy", var6, var7, var8, var9, () -> this.method05903(var2.key())
         );
      }

      float var14 = var4 + field12633 - this.field12570.method09485(field12634) / 2.0F;
      float var15 = var3 + field12635;
      String var16 = var2.key().length() > 8 ? var2.key().substring(0, 8) + "…" : var2.key();
      this.field12569.method09480(var1, var16, var15, var14, ConfigPanelRenderer.method03126(var9), field12636);
      var15 += this.field12569.method09486(var16, field12637) + field12638;
      String var17 = var2.redeemed() ? var2.holder() : field12639;
      int var18 = var2.redeemed() ? ConfigPanelRenderer.method03115(var9) : ConfigPanelRenderer.method03118(var9);
      this.field12570
         .method09480(var1, GuiThemeStyle.method01438(this.field12570, var17, field12640, var12 - field12641 - var15), var15, var14, var18, field12642);
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      this.field12566.method01133(var5);
   }

   private float method05907(
      GuiGraphicsExtractor var1, String var2, int var3, float var4, float var5, Object var6, int var7, int var8, boolean var9, float var10, Runnable var11
   ) {
      float var12 = ConfigPanelRenderer.method03123(this.field12570, var2, field12643);
      float var13 = var4 - var12;
      float var14 = this.method05896(var6, var9 && GuiHitTestUtils.method05624(var7, var8, var13, var5, var12, field12644));
      int var15 = var3 == -1 ? ConfigPanelRenderer.method03120(var14, var10) : var3;
      ConfigPanelRenderer.method03107(var1, this.field12570, var13, var5, var12, field12645, var2, field12646, var15, var14, var10);
      if (var9) {
         this.field12568.add(new ConfigSaleKeysWindow.Nested178(var13, var5, var12, field12647, var11));
      }

      return var13;
   }

   private static String method05908(List<SaleKeyListS2CPacket.Nested163> var0) {
      if (var0 == null) {
         return field12607;
      }

      int var1 = 0;

      for (SaleKeyListS2CPacket.Nested163 var3 : var0) {
         if (var3.redeemed()) {
            var1++;
         }
      }

      return "Активировано " + var1 + " из " + var0.size();
   }

   private void method05909(GuiGraphicsExtractor var1, List<SaleKeyListS2CPacket.Nested163> var2, int var3, int var4, float var5) {
      float var6 = this.method09576() + this.method09568() - field12585 - field12586;
      float var7 = this.method09560() + field12587;
      float var8 = var6 - field12588 - (this.method09576() + field12589);
      this.field12569
         .method09480(
            var1,
            GuiThemeStyle.method01438(this.field12569, "Ключи · " + this.field12565, field12590, var8),
            this.method09576() + field12591,
            this.method09560() + field12592,
            ConfigPanelRenderer.method03126(var5),
            field12593
         );
      this.field12570
         .method09480(
            var1, method05908(var2), this.method09576() + field12594, this.method09560() + field12595, ConfigPanelRenderer.method03104(var5), field12596
         );
      float var9 = this.method05896(field12597, GuiHitTestUtils.method05624(var3, var4, var6, var7, field12598, field12599));
      ConfigPanelRenderer.method03113(var1, var6 + field12600, var7 + field12601, field12602, var9, var5);
      this.field12568.add(new ConfigSaleKeysWindow.Nested178(var6, var7, field12603, field12604, this::method05891));
      ConfigPanelRenderer.method03110(var1, this.method09576() + field12605, this.method09560() + field12606, this.method09568() - 1.0F, var5);
   }

   // $VF: Compiled from s
   private record Nested178(float field12663, float field12664, float field12665, float field12666, Runnable action) {
      boolean has(double var1, double var3) {
         return GuiHitTestUtils.method05609(var1, var3, this.field12663, this.field12664, this.field12665, this.field12666);
      }
   }
}
