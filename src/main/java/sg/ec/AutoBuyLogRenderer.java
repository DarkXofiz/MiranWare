// Original binary: sg/ec/JbLhfybL0tF8c741
package sg.ec;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AutoBuyLogRenderer implements MinecraftAccess {
   public static final AutoBuyLogRenderer field08878 = new AutoBuyLogRenderer();
   private static final float field08879 = 158.0F;
   private static final float field08880 = 0;
   private static final float field08881 = 0;
   private static final float field08882 = 0;
   private static final float field08883 = 0;
   private static final float field08884 = 0;
   private static final float field08885 = 0;
   private static final float field08886 = 0;
   private static final float field08887 = 0;
   private static final float field08888 = 0;
   private static final float field08889 = 0;
   private static final float field08890 = 0;
   private static final float field08891 = 0;
   private static final float field08892 = 0;
   private static final float field08893 = 0;
   private static final float field08894 = 0;
   private static final float field08895 = 0;
   private static final float field08896 = 0;
   private static final float field08897 = 0;
   private static final float field08898 = 0;
   private static final float field08899 = 0;
   private static final float field08900 = 0;
   private static final float field08901 = 0;
   private static final float field08902 = 0;
   private static final float field08903 = 0;
   private static final float field08904 = 0;
   private static final float field08905 = 0;
   private static final float field08906 = 0;
   private static final float field08907 = 0;
   private static final float field08908 = 0;
   private static final float field08909 = 0;
   private static final float field08910 = 0;
   private static final long field08911 = 0;
   private static final long field08912 = 0;
   private static final long field08913 = 0;
   private static final float field08914 = 0;
   private static final int field08915 = ColorUtils.method04604(120, 230, 130);
   private static final int field08916 = ColorUtils.method04604(235, 90, 90);
   private final SimpleDateFormat field08917;
   private final AutoBuyLogRenderer.Nested121 field08918;
   private final AutoBuyLogRenderer.Nested121 field08919;
   private final AutoBuyLogRenderer.Nested121 field08920;
   private final SmoothAnimation field08921;
   private final AnimationUtils field08922;
   private final AnimationUtils field08923;
   private final AnimationUtils field08924;
   private final Map<String, AutoBuyLogRenderer.Nested120> field08925;
   private boolean field08926;
   private boolean field08927;
   private float field08928;
   private AutoBuyLogRenderer.Nested119 field08929;
   private float field08930;
   private float field08931;
   private float field08932;
   private float field08933;
   private float field08934;
   private float field08935;
   private float field08936;
   private float field08937;
   private float field08938;
   private float field08939;
   private float field08940;
   private float field08941;
   private float field08942;
   private boolean field08943;
   private boolean field08944;
   private float field08945;
   private float field08946;
   private Runnable field08947;
   private Runnable field08948;
   private static final String field08949 = "HH:mm";
   private static final String field08950 = "AutoBuy";
   private static final String field08951 = "Автоцены";
   private static final String field08952 = "Автопродажа";
   private static final long field08953 = 180L;
   private static final long field08954 = 150L;
   private static final long field08955 = 240L;
   private static final double field08956 = 0.21F;
   private static final float field08957 = 0.01F;
   private static final float field08958 = 12.0F;
   private static final float field08959 = -1.0F;
   private static final float field08960 = 7.0F;
   private static final float field08961 = 6.0F;
   private static final float field08962 = 7.0F;
   private static final float field08963 = 6.0F;
   private static final float field08964 = 158.0F;
   private static final float field08965 = 214.0F;
   private static final float field08966 = 7.0F;
   private static final float field08967 = 7.0F;
   private static final float field08968 = 32.0F;
   private static final float field08969 = 19.0F;
   private static final float field08970 = 10.0F;
   private static final float field08971 = 20.0F;
   private static final float field08972 = 7.0F;
   private static final float field08973 = 16.0F;
   private static final float field08974 = 8.5F;
   private static final float field08975 = 10.0F;
   private static final float field08976 = 6.0F;
   private static final float field08977 = 7.0F;
   private static final float field08978 = 21.0F;
   private static final float field08979 = 78.0F;
   private static final float field08980 = 48.0F;
   private static final float field08981 = 96.0F;
   private static final float field08982 = 21.0F;
   private static final float field08983 = 7.0F;
   private static final float field08984 = 78.0F;
   private static final float field08985 = 7.0F;
   private static final float field08986 = 78.0F;
   private static final float field08987 = 19.0F;
   private static final float field08988 = 19.0F;
   private static final float field08989 = 5.0F;
   private static final float field08990 = 78.0F;
   private static final float field08991 = 19.0F;
   private static final float field08992 = 262.0F;
   private static final float field08993 = 96.0F;
   private static final float field08994 = 21.0F;
   private static final float field08995 = 96.0F;
   private static final float field08996 = 5.0F;
   private static final float field08997 = 78.0F;
   private static final float field08998 = 19.0F;
   private static final float field08999 = 96.0F;
   private static final float field09000 = 78.0F;
   private static final float field09001 = 10.0F;
   private static final float field09002 = 78.0F;
   private static final float field09003 = 19.0F;
   private static final float field09004 = 17.0F;
   private static final float field09005 = 8.0F;
   private static final float field09006 = 30.0F;
   private static final float field09007 = 8.0F;
   private static final float field09008 = 0.78F;
   private static final float field09009 = 8.0F;
   private static final float field09010 = 0.5F;
   private static final float field09011 = 0.4F;
   private static final float field09012 = 7.5F;
   private static final float field09013 = 7.0F;
   private static final float field09014 = 7.0F;
   private static final float field09015 = 16.0F;
   private static final float field09016 = 10.0F;
   private static final float field09017 = 10.0F;
   private static final float field09018 = 20.0F;
   private static final float field09019 = 20.0F;
   private static final float field09020 = 4.5F;
   private static final float field09021 = 0.3F;
   private static final float field09022 = 3.0F;
   private static final float field09023 = 3.0F;
   private static final float field09024 = 14.0F;
   private static final float field09025 = 14.0F;
   private static final float field09026 = 3.0F;
   private static final float field09027 = 0.65F;
   private static final float field09028 = 17.0F;
   private static final float field09029 = 4.0F;
   private static final float field09030 = 0.45F;
   private static final float field09031 = 1.5F;
   private static final float field09032 = 1.5F;
   private static final float field09033 = 3.0F;
   private static final float field09034 = 14.0F;
   private static final float field09035 = 3.0F;
   private static final float field09036 = 0.32F;
   private static final float field09037 = 17.0F;
   private static final float field09038 = 8.5F;
   private static final float field09039 = 6.5F;
   private static final float field09040 = 0.85F;
   private static final float field09041 = 0.6F;
   private static final float field09042 = 6.5F;
   private static final String field09043 = "Покупок ещё не было";
   private static final String field09044 = "Лоты ещё не выставлялись";
   private static final float field09045 = 6.5F;
   private static final float field09046 = 0.55F;
   private static final float field09047 = 6.5F;
   private static final float field09048 = 30.0F;
   private static final float field09049 = 6.0F;
   private static final float field09050 = 12.0F;
   private static final float field09051 = 4.0F;
   private static final float field09052 = 6.5F;
   private static final float field09053 = 0.3F;
   private static final float field09054 = 30.0F;
   private static final float field09055 = 6.0F;
   private static final float field09056 = 30.0F;
   private static final float field09057 = 30.0F;
   private static final float field09058 = 8.0F;
   private static final float field09059 = 20.0F;
   private static final float field09060 = 7.0F;
   private static final float field09061 = 8.0F;
   private static final float field09062 = 0.5F;
   private static final float field09063 = 0.22F;
   private static final float field09064 = 0.01F;
   private static final float field09065 = 4.0F;
   private static final float field09066 = 28.0F;
   private static final float field09067 = 4.0F;
   private static final float field09068 = 0.04F;
   private static final float field09069 = 8.0F;
   private static final float field09070 = 15.0F;
   private static final float field09071 = 10.0F;
   private static final float field09072 = 20.0F;
   private static final float field09073 = 20.0F;
   private static final float field09074 = 4.5F;
   private static final float field09075 = 0.5F;
   private static final String field09076 = "—";
   private static final String field09077 = "в продаже";
   private static final float field09078 = 15.0F;
   private static final float field09079 = 8.0F;
   private static final float field09080 = 20.0F;
   private static final float field09081 = 7.0F;
   private static final float field09082 = 8.0F;
   private static final float field09083 = 6.5F;
   private static final float field09084 = 30.0F;
   private static final float field09085 = 6.5F;
   private static final float field09086 = 6.5F;
   private static final float field09087 = 8.0F;
   private static final float field09088 = 8.0F;
   private static final float field09089 = 6.5F;
   private static final float field09090 = 0.5F;
   private static final float field09091 = 0.7F;
   private static final float field09092 = 6.5F;
   private static final float field09093 = 0.01F;
   private static final float field09094 = 8.0F;
   private static final float field09095 = 8.0F;
   private static final float field09096 = 8.0F;
   private static final float field09097 = 0.9F;
   private static final float field09098 = 6.5F;
   private static final float field09099 = 0.55F;
   private static final float field09100 = 6.5F;
   private static final float field09101 = 7.5F;
   private static final float field09102 = 8.0F;
   private static final float field09103 = 7.0F;
   private static final float field09104 = 0.95F;
   private static final float field09105 = 7.5F;
   private static final float field09106 = 7.0F;
   private static final float field09107 = 0.99F;
   private static final float field09108 = 6.5F;
   private static final float field09109 = 3.0F;
   private static final float field09110 = 0.95F;
   private static final float field09111 = 6.5F;
   private static final float field09112 = 0.01F;
   private static final float field09113 = 6.5F;
   private static final float field09114 = 3.0F;
   private static final float field09115 = 0.8F;
   private static final float field09116 = 6.5F;
   private static final float field09117 = 19.0F;
   private static final float field09118 = 17.0F;
   private static final float field09119 = 10.0F;
   private static final float field09120 = 8.5F;
   private static final float field09121 = 6.5F;
   private static final float field09122 = 0.85F;
   private static final float field09123 = 6.5F;
   private static final float field09124 = 19.0F;
   private static final float field09125 = 9.5F;
   private static final float field09126 = 6.5F;
   private static final float field09127 = 10.0F;
   private static final float field09128 = 0.85F;
   private static final float field09129 = 6.5F;
   private static final String field09130 = "+";
   private static final float field09131 = 10.0F;
   private static final float field09132 = 6.5F;
   private static final float field09133 = 0.85F;
   private static final float field09134 = 6.5F;
   private static final float field09135 = 10.0F;
   private static final float field09136 = 20.0F;
   private static final float field09137 = 0.5F;
   private static final float field09138 = 0.32F;
   private static final float field09139 = 30.0F;
   private static final float field09140 = 4.0F;
   private static final float field09141 = 8.0F;
   private static final float field09142 = 16.0F;
   private static final float field09143 = 1.0E-4F;
   private static final float field09144 = 0.01F;
   private static final float field09145 = 2.5F;
   private static final float field09146 = 1.25F;
   private static final float field09147 = 0.6F;
   private static final float field09148 = 2.5F;
   private static final float field09149 = 3.0F;
   private static final float field09150 = 0.5F;
   private static final float field09151 = 17.0F;
   private static final float field09152 = 5.0F;
   private static final float field09153 = 12.5F;
   private static final float field09154 = 5.0F;
   private static final float field09155 = 12.5F;
   private static final float field09156 = 6.0F;
   private static final float field09157 = 8.0F;
   private static final float field09158 = 8.0F;
   private static final float field09159 = 4.5F;
   private static final float field09160 = 12.0F;
   private static final float field09161 = 12.0F;
   private static final float field09162 = 18.0F;
   private static final float field09163 = 30.0F;
   private static final float field09164 = 0.025F;

   private float method04018() {
      return method04034() ? field09004 : 0.0F;
   }

   private boolean method04019(float var1, float var2) {
      float var3 = this.field08930 + this.field08932 - field09156 - field09157;
      return GuiHitTestUtils.method05625(var1, var2, var3 - field09158 - 2.0F, this.field08946 + field09159, field09160, field09161);
   }

   @Subscribe
   private void method04020(ContainerRenderEvent var1) {
      boolean var2 = AutoBuySettings.field19624.method08558() && AuctionContainerUtils.method02626();
      this.field08921.method06162();
      this.field08921.method06168(var2 ? 1.0 : 0.0, field08956, Easings.field19400, true);
      this.field08927 = var2;
      float var3 = this.field08921.method06173();
      if (var3 <= field08957) {
         this.method04051();
      } else {
         this.method04053();
         this.method04026(var1);
         float var4 = GuiHitTestUtils.method05621(var3);
         int var5 = var1.method10117();
         int var6 = var1.method10104();
         this.field08922.method03375(this.method04044(var5, var6) ? 1.0 : 0.0);
         this.field08924.method03375(this.field08929.ordinal());
         this.field08947 = null;
         GuiGraphicsExtractor var7 = var1.method10118();
         var7.pose().pushMatrix();
         var7.pose().translate((1.0F - var4) * field08958 * this.method04022(var1), 0.0F);
         ItemRenderUtils.method08410();
         GuiRenderBatch.method05194();
         this.method04040(var7, var4);
         GuiRenderBatch.method05183();
         this.method04036(var7, var5, var6, var4);
         GuiRenderBatch.method05181();
         ItemRenderUtils.method08420();
         var7.pose().popMatrix();
      }
   }

   private float method04022(ContainerRenderEvent var1) {
      return this.field08930 > var1.method10120() ? 1.0F : field08959;
   }

   private void method04023(ContainerMouseEvent var1) {
      if (var1.method10087() == 0) {
         float var2 = (float)var1.method10098();
         float var3 = (float)var1.method10089();
         if (this.field08918.method04063(var2, var3) || this.field08919.method04063(var2, var3) || this.field08920.method04063(var2, var3)) {
            var1.method10083();
         } else if (GuiHitTestUtils.method05625(var2, var3, this.field08936, this.field08937, this.field08938, field09151)) {
            this.method04054(var2);
            var1.method10083();
         } else if (this.field08943
            && GuiHitTestUtils.method05625(var2, var3, this.method04049() - field09152, this.field08939, field09153, this.field08940)) {
            this.field08945 = GuiHitTestUtils.method05625(var2, var3, this.method04049() - field09154, this.field08941, field09155, this.field08942)
               ? var3 - this.field08941
               : this.field08942 / 2.0F;
            this.field08944 = true;
            this.method04062(var3);
            var1.method10083();
         } else if (this.field08947 != null && this.method04019(var2, var3)) {
            this.field08948 = this.field08947;
            var1.method10083();
         } else {
            if (this.method04044(var2, var3)) {
               var1.method10083();
            }
         }
      }
   }

   private void method04024(ContainerMouseEvent var1) {
      if (this.field08944) {
         this.method04062((float)var1.method10089());
         var1.method10083();
      }
   }

   private void method04025(GuiGraphicsExtractor var1, float var2) {
      ThemeSettings var3 = ThemeManager.INSTANCE.method09611();
      FontRenderer var4 = Fonts.field00110;
      float var5 = this.field08931 + this.field08933 - field09124;
      float var6 = var5 + field09125 - var4.method09485(field09126) / 2.0F;
      this.method04061(var1, var5, var2);
      String var7 = this.field08929 == AutoBuyLogRenderer.Nested119.BUYS ? "Куплено: " + this.method04029() : "Выставлено: " + this.method04029();
      var4.method09480(var1, var7, this.field08930 + field09127, var6, method04042(var3.field22110.method11676(), field09128 * var2), field09129);
      long var8 = this.field08929 == AutoBuyLogRenderer.Nested119.BUYS
         ? PurchaseHistory.field06969.method03135()
         : AuctionSaleHistory.field07563.method03358();
      String var10 = (this.field08929 == AutoBuyLogRenderer.Nested119.BUYS ? "" : field09130) + NumberFormatUtils.method08163(var8);
      var4.method09480(
         var1,
         var10,
         this.field08930 + this.field08932 - field09131 - var4.method09486(var10, field09132),
         var6,
         method04042(this.field08929 == AutoBuyLogRenderer.Nested119.BUYS ? var3.field22110.method11676() : var3.field22113.method11676(), field09133 * var2),
         field09134
      );
   }

   private void method04026(ContainerRenderEvent var1) {
      float var2 = var1.method10120();
      float var3 = var2 + var1.method10108();
      float var4 = mc.getWindow().getGuiScaledWidth();
      float var5 = var4 - var3 - field08960 - field08961;
      float var6 = var2 - field08962 - field08963;
      boolean var7 = var5 >= var6;
      this.field08932 = GuiHitTestUtils.method05615(field08964, field08965, Math.max(var5, var6));
      this.field08930 = var7 ? var3 + field08966 : var2 - field08967 - this.field08932;
      this.field08931 = var1.method10115();
      this.field08933 = var1.method10106();
      this.field08934 = this.field08931 + field08968;
      this.field08935 = this.field08931 + this.field08933 - field08969 - this.method04018();
      this.field08936 = this.field08930 + field08970 + field08971 + field08972;
      this.field08937 = this.field08931 + field08973 - field08974;
      this.field08938 = this.field08930 + this.field08932 - field08975 - this.field08936;
      float var8 = Math.max(field08976, AbstractContainerScreenHooks.method06045((int)this.field08931) - field08977 - field08978);
      float var9 = var7 ? var6 : var5;
      if (var9 >= field08979) {
         this.field08918.method04064(var2 + var1.method10108() / 2.0F - field08980, var8, field08981, field08982);
         float var12 = var7 ? var2 - field08983 - field08984 : var3 + field08985;
         this.field08919.method04064(var12, this.field08931, field08986, field08987);
         this.field08920.method04064(var12, this.field08931 + field08988 + field08989, field08990, field08991);
      } else {
         float var10 = field08992;
         float var11 = var2 + var1.method10108() / 2.0F - var10 / 2.0F;
         this.field08918.method04064(var11, var8, field08993, field08994);
         this.field08919.method04064(var11 + field08995 + field08996, var8 + 1.0F, field08997, field08998);
         this.field08920.method04064(var11 + field08999 + field09000 + field09001, var8 + 1.0F, field09002, field09003);
      }
   }

   private static String method04027(PurchaseHistory.Nested87 var0) {
      return "b" + var0.timestamp() + ":" + var0.name();
   }

   private int method04029() {
      return this.field08929 == AutoBuyLogRenderer.Nested119.BUYS
         ? PurchaseHistory.field06969.method03142(AutoBuyItemRegistry.INSTANCE.method10998()).size()
         : AuctionSaleHistory.field07563.method03356(AutoBuyItemRegistry.INSTANCE.method10998()).size();
   }

   private void method04030(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, PurchaseHistory.Nested87 var6, float var7) {
      ThemeSettings var8 = ThemeManager.INSTANCE.method09611();
      this.method04033(
         var1,
         var2,
         var3,
         var4,
         var5,
         var6.stack(),
         var6.name(),
         var6.stack().getCount(),
         var6.timestamp(),
         var7,
         NumberFormatUtils.method08160(var6),
         method04037(var6, var8),
         method04045(var6.paidPrice(), var6.reference()),
         var6.seller().isBlank() ? field09076 : var6.seller()
      );
   }

   private void method04031(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      float var5 = this.field08935 - this.field08934;
      if (var5 <= 1.0F) {
         this.method04051();
      } else {
         List var6 = this.field08929 == AutoBuyLogRenderer.Nested119.BUYS
            ? PurchaseHistory.field06969.method03142(AutoBuyItemRegistry.INSTANCE.method10998())
            : List.of();
         List var7 = this.field08929 == AutoBuyLogRenderer.Nested119.SALES
            ? AuctionSaleHistory.field07563.method03356(AutoBuyItemRegistry.INSTANCE.method10998())
            : List.of();
         int var8 = var6.size() + var7.size();
         if (var8 == 0) {
            this.method04051();
            Fonts.field00110
               .method09473(
                  var1,
                  this.field08929 == AutoBuyLogRenderer.Nested119.BUYS ? field09043 : field09044,
                  this.field08930 + this.field08932 / 2.0F,
                  this.field08934 + var5 / 2.0F - Fonts.field00110.method09485(field09045) / 2.0F,
                  method04042(ThemeManager.INSTANCE.method09611().field22110.method11676(), field09046 * var4),
                  field09047
               );
         } else {
            float var9 = var8 * field09048;
            this.field08928 = GuiHitTestUtils.method05615(-Math.max(0.0F, var9 - var5), 0.0F, this.field08928);
            this.field08923.method03375(this.field08928);
            float var10 = this.field08930 + field09049;
            float var11 = this.field08932 - field09050;
            float var12 = this.field08934 + 2.0F;
            RoundedRectRenderer.method01272(
               var1, var10, var12, var11, Math.min(var9, var5 - field09051), field09052, 1.0F, method04042(method04059(), field09053 * var4)
            );
            var1.enableScissor((int)this.field08930, (int)this.field08934, (int)Math.ceil(this.field08930 + this.field08932), (int)Math.ceil(this.field08935));
            float var13 = var12 + this.field08923.method03377();

            for (int var14 = 0; var14 < var8; var14++) {
               boolean var15 = var14 < var6.size();
               PurchaseHistory.Nested87 var16 = var15 ? (PurchaseHistory.Nested87)var6.get(var14) : null;
               AuctionSaleHistory.Nested94 var17 = var15 ? null : (AuctionSaleHistory.Nested94)var7.get(var14 - var6.size());
               AutoBuyLogRenderer.Nested120 var18 = this.field08925
                  .computeIfAbsent(var15 ? method04027(var16) : method04058(var17), var0 -> new AutoBuyLogRenderer.Nested120());
               var18.field09166.method03375(1.0);
               float var19 = var18.field09166.method03377();
               if (var13 + field09054 >= this.field08934 && var13 <= this.field08935) {
                  float var20 = var13 + (1.0F - var19) * field09055;
                  float var21 = var4 * var19;
                  boolean var22 = GuiHitTestUtils.method05624(var2, var3, var10, var20, var11, field09056)
                     && var3 >= this.field08934
                     && var3 <= this.field08935;
                  float var23 = this.method04039(var1, var21, var10, var20, var11, var18, var14 > 0, var22);
                  if (var15) {
                     this.method04030(var1, var21, var10, var20, var11, var16, var23);
                  } else {
                     this.method04048(var1, var21, var10, var20, var11, var17, var23);
                  }

                  if (var22) {
                     this.field08946 = var20;
                     this.field08947 = var15 ? () -> PurchaseHistory.field06969.method03144(var16) : () -> AuctionSaleHistory.field07563.method03360(var17);
                  }
               } else {
                  var18.field09167.method03375(0.0);
               }

               var13 += field09057;
            }

            var1.disableScissor();
            this.method04047(var6, var7);
         }
      }
   }

   private void method04032(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      float var6 = this.field08931 + field09015;
      float var7 = this.field08930 + field09016;
      float var8 = var6 - field09017;
      RoundedRectRenderer.method01272(var1, var7, var8, field09018, field09019, field09020, 1.0F, method04042(var5.field22113.method11676(), field09021 * var4));
      Identifier var9 = ClientTextures.INSTANCE.method04557(AutoBuyItemRegistry.INSTANCE.method10998().method06431());
      if (var9 != null) {
         boolean var10 = AutoBuyManager.INSTANCE.method09776();
         GuiTextureRenderer.method10257(
            var1,
            var9,
            var7 + field09022,
            var8 + field09023,
            field09024,
            field09025,
            new CornerRadii(field09026),
            1.0F,
            new CornerColors(method04042(-1, (var10 ? 1.0F : field09027) * var4))
         );
      }

      this.method04041(var1, var2, var3, var4);
   }

   private void method04033(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      ItemStack var6,
      String var7,
      int var8,
      long var9,
      float var11,
      String var12,
      int var13,
      String var14,
      String var15
   ) {
      ThemeSettings var16 = ThemeManager.INSTANCE.method09611();
      FontRenderer var17 = Fonts.field00110;
      float var18 = var4 + field09078;
      float var19 = var3 + field09079 + field09080 + field09081;
      float var20 = var3 + var5 - field09082;
      float var21 = var4 + field09083;
      float var22 = var4 + field09084 - field09085 - var17.method09485(field09086);
      ItemRenderUtils.method08415(var1, var6, var3 + field09087 + 2.0F, var18 - field09088, 1.0F, var2, 1.0F);
      String var23 = this.field08917.format(new Date(var9));
      float var24 = var17.method09486(var23, field09089);
      var17.method09480(
         var1, var23, var20 - var24, var21 + field09090, method04042(var16.field22110.method11676(), field09091 * (1.0F - var11) * var2), field09092
      );
      if (var11 > field09093) {
         GuiTextureRenderer.method10259(
            var1,
            ClientTextures.INSTANCE.method04566(),
            var20 - field09094,
            var21,
            field09095,
            field09096,
            method04042(var16.field22110.method11676(), field09097 * var11 * var2)
         );
      }

      float var25 = var17.method09486(var15, field09098);
      var17.method09480(var1, var15, var20 - var25, var22, method04042(var16.field22110.method11676(), field09099 * var2), field09100);
      String var26 = var8 > 1 ? var7 + " x" + var8 : var7;
      var17.method09480(
         var1,
         method04052(var17, var26, field09101, var20 - Math.max(var24, field09102) - field09103 - var19),
         var19,
         var21,
         method04042(var16.field22109.method11676(), field09104 * var2),
         field09105
      );
      float var27 = var20 - var25 - field09106 - var19;
      if (var11 < field09107) {
         var17.method09480(
            var1,
            method04052(var17, var12, field09108, var27),
            var19,
            var22 - field09109 * var11,
            method04042(var13, field09110 * (1.0F - var11) * var2),
            field09111
         );
      }

      if (var11 > field09112 && !var14.isEmpty()) {
         var17.method09480(
            var1,
            method04052(var17, var14, field09113, var27),
            var19,
            var22 + field09114 * (1.0F - var11),
            method04042(var16.field22109.method11676(), field09115 * var11 * var2),
            field09116
         );
      }
   }

   private static boolean method04034() {
      return AutoBuyManager.INSTANCE.method09774().method09139();
   }

   private void method04036(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.field08918.method04065(var1, var2, var3, var4, field09012);
      this.field08919.method04065(var1, var2, var3, var4, field09013);
      this.field08920.method04065(var1, var2, var3, var4, field09014);
      this.method04032(var1, var2, var3, var4);
      this.method04031(var1, var2, var3, var4);
      this.method04060(var1, var4);
      this.method04057(var1, var4);
      this.method04025(var1, var4);
   }

   private static int method04037(PurchaseHistory.Nested87 var0, ThemeSettings var1) {
      float var2 = var0.payback();
      if (var2 >= 2.0F) {
         return field08915;
      } else if (NumberFormatUtils.method08161(var0)) {
         return var1.field22113.method11676();
      } else {
         return var2 > 0.0F && var2 < 1.0F ? field08916 : var1.field22110.method11676();
      }
   }

   private void method04038(ContainerMouseEvent var1) {
      if (this.method04044((float)var1.method10098(), (float)var1.method10089())) {
         this.field08928 = this.field08928 + (float)var1.method10097() * field09162;
         var1.method10083();
      }
   }

   private AutoBuyLogRenderer() {
      this.field08917 = new SimpleDateFormat(field08949);
      this.field08918 = new AutoBuyLogRenderer.Nested121(field08950, AutoBuyManager.INSTANCE::method09776, AutoBuyManager.INSTANCE::method09761);
      this.field08919 = new AutoBuyLogRenderer.Nested121(
         field08951, AutoBuySettings.field19624::method08579, () -> AutoBuyManager.INSTANCE.method09757(!AutoBuySettings.field19624.method08579())
      );
      this.field08920 = new AutoBuyLogRenderer.Nested121(
         field08952, AutoBuySettings.field19624::method08557, () -> AutoBuyManager.INSTANCE.method09758(!AutoBuySettings.field19624.method08557())
      );
      this.field08921 = new SmoothAnimation();
      this.field08922 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field08953);
      this.field08923 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field08954);
      this.field08924 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field08955);
      this.field08925 = new LinkedHashMap<>();
      this.field08929 = AutoBuyLogRenderer.Nested119.BUYS;
   }

   private float method04039(
      GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, AutoBuyLogRenderer.Nested120 var6, boolean var7, boolean var8
   ) {
      ThemeSettings var9 = ThemeManager.INSTANCE.method09611();
      var6.field09167.method03375(var8 ? 1.0 : 0.0);
      float var10 = var6.field09167.method03377();
      if (var7) {
         float var11 = var3 + field09058 + field09059 + field09060;
         RoundedRectRenderer.method01272(
            var1, var11, var4, var3 + var5 - field09061 - var11, field09062, 0.0F, 0.0F, method04042(var9.field22117.method11676(), field09063 * var2)
         );
      }

      if (var10 > field09064) {
         RoundedRectRenderer.method01272(
            var1,
            var3 + 2.0F,
            var4 + 1.0F,
            var5 - field09065,
            field09066,
            field09067,
            1.0F,
            method04042(var9.field22109.method11676(), field09068 * var10 * var2)
         );
      }

      RoundedRectRenderer.method01272(
         var1, var3 + field09069, var4 + field09070 - field09071, field09072, field09073, field09074, 1.0F, method04042(method04059(), field09075 * var2)
      );
      return var10;
   }

   private void method04040(GuiGraphicsExtractor var1, float var2) {
      ThemeSettings var3 = ThemeManager.INSTANCE.method09611();
      GuiClipStack.method00341(var1, this.field08930, this.field08931, this.field08932, this.field08933, field09005, 1.0F, field09006, var2);
      RoundedRectRenderer.method01272(
         var1,
         this.field08930,
         this.field08931,
         this.field08932,
         this.field08933,
         field09007,
         1.0F,
         method04042(var3.field22119.method11676(), field09008 * var2)
      );
      GuiShapeRenderer.method09703(
         var1,
         this.field08930,
         this.field08931,
         this.field08932,
         this.field08933,
         field09009,
         field09010,
         method04042(var3.field22117.method11676(), field09011 * var2)
      );
   }

   private void method04041(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      ThemeSettings var5 = ThemeManager.INSTANCE.method09611();
      FontRenderer var6 = Fonts.field00110;
      float var7 = this.field08938 / AutoBuyLogRenderer.Nested119.values().length;
      RoundedRectRenderer.method01272(
         var1, this.field08936, this.field08937, this.field08938, field09028, field09029, 1.0F, method04042(method04059(), field09030 * var4)
      );
      RoundedRectRenderer.method01272(
         var1,
         this.field08936 + field09031 + var7 * this.field08924.method03377(),
         this.field08937 + field09032,
         var7 - field09033,
         field09034,
         field09035,
         1.0F,
         method04042(var5.field22113.method11676(), field09036 * var4)
      );

      for (AutoBuyLogRenderer.Nested119 var11 : AutoBuyLogRenderer.Nested119.values()) {
         float var12 = this.field08936 + var7 * var11.ordinal();
         boolean var13 = var11 == this.field08929;
         boolean var14 = GuiHitTestUtils.method05624(var2, var3, var12, this.field08937, var7, field09037);
         int var15 = var13 ? var5.field22109.method11676() : var5.field22110.method11676();
         var6.method09473(
            var1,
            var11.field09165,
            var12 + var7 / 2.0F,
            this.field08937 + field09038 - var6.method09485(field09039) / 2.0F,
            method04042(var15, (var13 ? 1.0F : (var14 ? field09040 : field09041)) * var4),
            field09042
         );
      }
   }

   private static int method04042(int var0, float var1) {
      return ColorUtils.method04611(var0, var1);
   }

   private boolean method04044(float var1, float var2) {
      return GuiHitTestUtils.method05625(var1, var2, this.field08930, this.field08931, this.field08932, this.field08933);
   }

   private static String method04045(long var0, long var2) {
      if (var0 <= 0L) {
         return var2 > 0L ? NumberFormatUtils.method08163(var2) : "";
      } else {
         return var2 > 0L ? NumberFormatUtils.method08163(var0) + " → " + NumberFormatUtils.method08163(var2) : NumberFormatUtils.method08163(var0);
      }
   }

   private void method04047(List<PurchaseHistory.Nested87> var1, List<AuctionSaleHistory.Nested94> var2) {
      if (this.field08925.size() > var1.size() + var2.size()) {
         var var3 = new HashSet(var1.size() + var2.size());

         for (PurchaseHistory.Nested87 var5 : var1) {
            var3.add(method04027(var5));
         }

         for (AuctionSaleHistory.Nested94 var7 : var2) {
            var3.add(method04058(var7));
         }

         this.field08925.keySet().retainAll(var3);
      }
   }

   private void method04048(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, AuctionSaleHistory.Nested94 var6, float var7) {
      ThemeSettings var8 = ThemeManager.INSTANCE.method09611();
      boolean var9 = var6.isSold();
      this.method04033(
         var1,
         var2,
         var3,
         var4,
         var5,
         var6.stack(),
         var6.name(),
         var6.stack().getCount(),
         var9 ? var6.soldAtMs() : var6.listedAtMs(),
         var7,
         NumberFormatUtils.method08163(var6.askPrice()),
         var9 ? field08915 : var8.field22113.method11676(),
         method04045(var6.paidPrice(), var6.askPrice()),
         var9 ? var6.buyer() : field09077
      );
   }

   private float method04049() {
      return this.field08930 + this.field08932 - field09148 - field09149;
   }

   public void method04050() {
      if (!this.field08926) {
         this.field08926 = true;
         EventBus.method00263(this);
      }
   }

   private void method04051() {
      this.field08925.clear();
      this.field08944 = false;
   }

   private static String method04052(FontRenderer var0, String var1, float var2, float var3) {
      if (!(var3 <= 0.0F) && !(var0.method09486(var1, var2) <= var3)) {
         String var4 = var1;

         while (var4.length() > 1 && var0.method09486(var4 + "…", var2) > var3) {
            var4 = var4.substring(0, var4.length() - 1);
         }

         return var4 + "…";
      } else {
         return var1;
      }
   }

   private void method04053() {
      if (this.field08948 != null) {
         this.field08948.run();
         this.field08948 = null;
         this.field08947 = null;
      }
   }

   private void method04054(float var1) {
      float var2 = this.field08938 / AutoBuyLogRenderer.Nested119.values().length;
      int var3 = GuiHitTestUtils.method05619(0, AutoBuyLogRenderer.Nested119.values().length - 1, (int)((var1 - this.field08936) / var2));
      if (AutoBuyLogRenderer.Nested119.values()[var3] != this.field08929) {
         this.field08929 = AutoBuyLogRenderer.Nested119.values()[var3];
         this.field08928 = 0.0F;
         this.field08923.method03374(0.0);
         this.field08923.method03369(0.0);
         this.method04051();
      }
   }

   @Subscribe
   private void method04055(ContainerMouseEvent var1) {
      if (this.field08927 && AuctionContainerUtils.method02626() && !(this.field08921.method06173() <= field09150)) {
         switch (var1.method10088()) {
            case CLICK:
               this.method04023(var1);
               break;
            case DRAG:
               this.method04024(var1);
               break;
            case RELEASE:
               this.method04056(var1);
               break;
            case SCROLL:
               this.method04038(var1);
         }
      }
   }

   private void method04056(ContainerMouseEvent var1) {
      if (this.field08944) {
         this.field08944 = false;
         var1.method10083();
      }
   }

   private void method04057(GuiGraphicsExtractor var1, float var2) {
      if (method04034()) {
         FontRenderer var3 = Fonts.field00110;
         float var4 = this.field08931 + this.field08933 - field09117 - field09118;
         this.method04061(var1, var4, var2);
         var3.method09480(
            var1,
            "Автоцены · " + AutoBuyManager.INSTANCE.method09774().method09150(),
            this.field08930 + field09119,
            var4 + field09120 - var3.method09485(field09121) / 2.0F,
            method04042(ThemeManager.INSTANCE.method09611().field22110.method11676(), field09122 * var2),
            field09123
         );
      }
   }

   private static String method04058(AuctionSaleHistory.Nested94 var0) {
      return "s" + var0.listedAtMs() + ":" + var0.name();
   }

   private static int method04059() {
      return ColorUtils.method04583(ThemeManager.INSTANCE.method09611().field22119.method11676(), ColorUtils.field10170, field09164);
   }

   private void method04060(GuiGraphicsExtractor var1, float var2) {
      float var3 = this.field08935 - this.field08934;
      float var4 = this.method04029() * field09139;
      this.field08943 = var3 > 1.0F && var4 > var3 + 1.0F;
      if (!this.field08943) {
         this.field08944 = false;
      } else {
         this.field08939 = this.field08934 + field09140;
         this.field08940 = var3 - field09141;
         this.field08942 = GuiHitTestUtils.method05615(field09142, this.field08940, this.field08940 * (var3 / var4));
         this.field08941 = this.field08939
            + Math.max(0.0F, this.field08940 - this.field08942)
               * GuiHitTestUtils.method05621(-this.field08923.method03377() / Math.max(field09143, var4 - var3));
         float var5 = this.field08944 ? 1.0F : this.field08922.method03377();
         if (var5 > field09144) {
            RoundedRectRenderer.method01272(
               var1,
               this.method04049(),
               this.field08941,
               field09145,
               this.field08942,
               field09146,
               1.0F,
               method04042(ThemeManager.INSTANCE.method09611().field22124.method11676(), field09147 * var5 * var2)
            );
         }
      }
   }

   private void method04061(GuiGraphicsExtractor var1, float var2, float var3) {
      RoundedRectRenderer.method01272(
         var1,
         this.field08930 + field09135,
         var2,
         this.field08932 - field09136,
         field09137,
         0.0F,
         0.0F,
         method04042(ThemeManager.INSTANCE.method09611().field22117.method11676(), field09138 * var3)
      );
   }

   private void method04062(float var1) {
      float var2 = Math.max(1.0F, this.field08940 - this.field08942);
      float var3 = GuiHitTestUtils.method05615(this.field08939, this.field08939 + var2, var1 - this.field08945);
      float var4 = GuiHitTestUtils.method05621((var3 - this.field08939) / var2);
      float var5 = this.field08935 - this.field08934;
      this.field08928 = -Math.max(0.0F, this.method04029() * field09163 - var5) * var4;
      this.field08923.method03374(this.field08928);
      this.field08923.method03369(this.field08928);
   }

   // $VF: Compiled from s
   private enum Nested119 {
      BUYS("Покупки"),
      SALES("Продажи");

      final String field09165;

      Nested119(String var3) {
         this.field09165 = var3;
      }
   }

   // $VF: Compiled from s
   private static final class Nested120 {
      final AnimationUtils field09166;
      final AnimationUtils field09167;
      private static final long field09168 = 230L;
      private static final long field09169 = 140L;

      private Nested120() {
         this.field09166 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field09168);
         this.field09167 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field09169);
      }
   }

   // $VF: Compiled from s
   private static final class Nested121 {
      private final String field09171;
      private final BooleanSupplier field09172;
      private final Runnable field09173;
      private final AnimationUtils field09174;
      private float field09175;
      private float field09176;
      private float field09177;
      private float field09178;
      private static final long field09179 = 150L;
      private static final float field09180 = 4.5F;
      private static final float field09181 = 20.0F;
      private static final float field09182 = 4.5F;
      private static final float field09183 = 0.72F;
      private static final float field09184 = 0.12F;
      private static final float field09185 = 4.5F;
      private static final float field09186 = 0.22F;
      private static final float field09187 = 0.06F;
      private static final float field09188 = 0.4F;
      private static final float field09189 = 4.5F;
      private static final float field09190 = 0.5F;
      private static final float field09191 = 0.4F;
      private static final float field09192 = 0.35F;
      private static final String field09193 = "ВКЛ";
      private static final String field09194 = "ВЫКЛ";

      boolean method04063(float var1, float var2) {
         if (!this.method04066(var1, var2)) {
            return false;
         }

         this.field09173.run();
         return true;
      }

      void method04064(float var1, float var2, float var3, float var4) {
         this.field09175 = var1;
         this.field09176 = var2;
         this.field09177 = var3;
         this.field09178 = var4;
      }

      void method04065(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5) {
         ThemeSettings var6 = ThemeManager.INSTANCE.method09611();
         FontRenderer var7 = Fonts.field00110;
         boolean var8 = this.field09172.getAsBoolean();
         this.field09174.method03375(this.method04066(var2, var3) ? 1.0 : 0.0);
         float var9 = this.field09174.method03377();
         int var10 = var8 ? var6.field22113.method11676() : var6.field22110.method11676();
         GuiClipStack.method00341(var1, this.field09175, this.field09176, this.field09177, this.field09178, field09180, 1.0F, field09181, var4);
         RoundedRectRenderer.method01272(
            var1,
            this.field09175,
            this.field09176,
            this.field09177,
            this.field09178,
            field09182,
            1.0F,
            AutoBuyLogRenderer.method04042(var6.field22119.method11676(), (field09183 + field09184 * var9) * var4)
         );
         RoundedRectRenderer.method01272(
            var1,
            this.field09175,
            this.field09176,
            this.field09177,
            this.field09178,
            field09185,
            1.0F,
            AutoBuyLogRenderer.method04042(var10, (var8 ? field09186 : field09187) * (1.0F + field09188 * var9) * var4)
         );
         GuiShapeRenderer.method09703(
            var1,
            this.field09175,
            this.field09176,
            this.field09177,
            this.field09178,
            field09189,
            field09190,
            AutoBuyLogRenderer.method04042(var10, (field09191 + field09192 * var9) * var4)
         );
         String var11 = this.field09171 + ": " + (var8 ? field09193 : field09194);
         int var12 = var8 ? var6.field22109.method11676() : ColorUtils.method04631(var6.field22110.method11676(), var6.field22109.method11676(), var9);
         var7.method09473(
            var1,
            var11,
            this.field09175 + this.field09177 / 2.0F,
            this.field09176 + this.field09178 / 2.0F - var7.method09485(var5) / 2.0F,
            AutoBuyLogRenderer.method04042(var12, var4),
            var5
         );
      }

      Nested121(String var1, BooleanSupplier var2, Runnable var3) {
         this.field09174 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field09179);
         this.field09171 = var1;
         this.field09172 = var2;
         this.field09173 = var3;
      }

      boolean method04066(float var1, float var2) {
         return GuiHitTestUtils.method05625(var1, var2, this.field09175, this.field09176, this.field09177, this.field09178);
      }
   }
}
