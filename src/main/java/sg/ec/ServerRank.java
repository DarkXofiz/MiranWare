// Original binary: sg/ec/cgatoWJODI6FoTEc
package sg.ec;

import net.minecraft.network.chat.Style;

// $VF: Compiled from s
public enum ServerRank implements TextDecorationEvent.Nested275 {
   INSTANCE;

   private volatile ServerRank.Nested213 field17776;

   public void method07288(boolean var1) {
      ServerRank.Nested213 var2 = var1 ? ServerRank.Nested215.field17782 : null;
      if (var2 != this.field17776) {
         this.field17776 = var2;
         TextCacheInvalidator.method07278();
         FormattedTextCache.method01892();
         ChatMessagePolicy.method04007();
      }
   }

   public TextDecorationEvent.Nested275 method07289() {
      return this.field17776 == null ? null : this;
   }

   @Override
   public TextDecorationEvent.Nested274 method07290(int var1) {
      ServerRank.Nested213 var2 = this.field17776;
      if (var2 == null) {
         return null;
      }

      int var3 = var1 - var2.field17777;
      return var3 >= 0 && var3 < var2.field17778.length ? var2.field17778[var3] : null;
   }

   // $VF: Compiled from s
   private static final class Nested213 {
      private final int field17777;
      private final TextDecorationEvent.Nested274[] field17778;

      private Nested213(int var1, TextDecorationEvent.Nested274[] var2) {
         this.field17777 = var1;
         this.field17778 = var2;
      }
   }

   // $VF: Compiled from s
   private static final class Nested214 {
      private final int field17779;
      private final TextDecorationEvent.Nested274[] field17780;
      private static final int field17781 = 16777215;

      private ServerRank.Nested214 method07291(int var1, String var2, int var3, int var4) {
         return this.method07293(var1, var2, var3, var4, null, 0);
      }

      private Nested214(int var1, int var2) {
         this.field17779 = var1;
         this.field17780 = new TextDecorationEvent.Nested274[var2 - var1 + 1];
      }

      private ServerRank.Nested213 method07292() {
         return new ServerRank.Nested213(this.field17779, this.field17780);
      }

      private ServerRank.Nested214 method07293(int var1, String var2, int var3, int var4, String var5, int var6) {
         int var7 = var2.length();
         int var8 = var5 == null ? var7 : var7 + var5.length();
         int[] var9 = new int[var8];
         Style[] var10 = new Style[var8];

         for (int var11 = 0; var11 < var7; var11++) {
            float var12 = var7 == 1 ? 0.0F : (float)var11 / (var7 - 1);
            var9[var11] = var2.charAt(var11);
            var10[var11] = method07294(ColorUtils.method04586(var12, var3, var4));
         }

         if (var5 != null) {
            Style var13 = method07294(var6);

            for (int var14 = 0; var14 < var5.length(); var14++) {
               var9[var7 + var14] = var5.charAt(var14);
               var10[var7 + var14] = var13;
            }
         }

         this.field17780[var1 - this.field17779] = new TextDecorationEvent.Nested274(var9, var10);
         return this;
      }

      private static Style method07294(int var0) {
         return Style.EMPTY.withColor(var0 & field17781).withBold(true);
      }
   }

   // $VF: Compiled from s
   private static final class Nested215 {
      private static final ServerRank.Nested213 field17782 = new ServerRank.Nested214(
            ServerRank.Nested215.field17783, ServerRank.Nested215.field17784
         )
         .method07291(
            ServerRank.Nested215.field17785,
            ServerRank.Nested215.field17786,
            ColorUtils.method04604(120, 120, 120),
            ColorUtils.method04604(220, 220, 220)
         )
         .method07291(
            ServerRank.Nested215.field17787,
            ServerRank.Nested215.field17788,
            ColorUtils.method04604(1, 33, 248),
            ColorUtils.method04604(58, 94, 251)
         )
         .method07291(
            ServerRank.Nested215.field17789,
            ServerRank.Nested215.field17790,
            ColorUtils.method04604(248, 215, 0),
            ColorUtils.method04604(206, 247, 0)
         )
         .method07291(
            ServerRank.Nested215.field17791,
            ServerRank.Nested215.field17792,
            ColorUtils.method04604(43, 247, 1),
            ColorUtils.method04604(118, 247, 152)
         )
         .method07291(
            ServerRank.Nested215.field17793,
            ServerRank.Nested215.field17794,
            ColorUtils.method04604(63, 172, 218),
            ColorUtils.method04604(0, 239, 251)
         )
         .method07291(
            ServerRank.Nested215.field17795,
            ServerRank.Nested215.field17796,
            ColorUtils.method04604(248, 140, 0),
            ColorUtils.method04604(248, 190, 64)
         )
         .method07291(
            ServerRank.Nested215.field17797,
            ServerRank.Nested215.field17798,
            ColorUtils.method04604(215, 46, 46),
            ColorUtils.method04604(248, 80, 82)
         )
         .method07291(
            ServerRank.Nested215.field17799,
            ServerRank.Nested215.field17800,
            ColorUtils.method04604(246, 0, 224),
            ColorUtils.method04604(190, 35, 247)
         )
         .method07291(
            ServerRank.Nested215.field17801,
            ServerRank.Nested215.field17802,
            ColorUtils.method04604(80, 50, 138),
            ColorUtils.method04604(121, 81, 202)
         )
         .method07291(
            ServerRank.Nested215.field17803,
            ServerRank.Nested215.field17804,
            ColorUtils.method04604(236, 91, 34),
            ColorUtils.method04604(231, 127, 8)
         )
         .method07291(
            ServerRank.Nested215.field17805,
            ServerRank.Nested215.field17806,
            ColorUtils.method04604(27, 94, 21),
            ColorUtils.method04604(32, 149, 29)
         )
         .method07291(
            ServerRank.Nested215.field17807,
            ServerRank.Nested215.field17808,
            ColorUtils.method04604(235, 169, 32),
            ColorUtils.method04604(252, 212, 134)
         )
         .method07291(
            ServerRank.Nested215.field17809,
            ServerRank.Nested215.field17810,
            ColorUtils.method04604(157, 32, 32),
            ColorUtils.method04604(207, 51, 51)
         )
         .method07291(
            ServerRank.Nested215.field17811,
            ServerRank.Nested215.field17812,
            ColorUtils.method04604(94, 28, 28),
            ColorUtils.method04604(214, 64, 64)
         )
         .method07291(
            ServerRank.Nested215.field17813,
            ServerRank.Nested215.field17814,
            ColorUtils.method04604(0, 247, 0),
            ColorUtils.method04604(111, 247, 112)
         )
         .method07291(
            ServerRank.Nested215.field17815,
            ServerRank.Nested215.field17816,
            ColorUtils.method04604(255, 255, 0),
            ColorUtils.method04604(139, 132, 0)
         )
         .method07291(
            ServerRank.Nested215.field17817,
            ServerRank.Nested215.field17818,
            ColorUtils.method04604(204, 210, 218),
            ColorUtils.method04604(246, 249, 255)
         )
         .method07291(
            ServerRank.Nested215.field17819,
            ServerRank.Nested215.field17820,
            ColorUtils.method04604(36, 39, 40),
            ColorUtils.method04604(101, 103, 105)
         )
         .method07291(
            ServerRank.Nested215.field17821,
            ServerRank.Nested215.field17822,
            ColorUtils.method04604(239, 202, 35),
            ColorUtils.method04604(232, 226, 60)
         )
         .method07291(
            ServerRank.Nested215.field17823,
            ServerRank.Nested215.field17824,
            ColorUtils.method04604(80, 50, 138),
            ColorUtils.method04604(127, 91, 195)
         )
         .method07291(
            ServerRank.Nested215.field17825,
            ServerRank.Nested215.field17826,
            ColorUtils.method04604(255, 0, 0),
            ColorUtils.method04604(255, 255, 255)
         )
         .method07291(
            ServerRank.Nested215.field17827,
            ServerRank.Nested215.field17828,
            ColorUtils.method04604(241, 204, 45),
            ColorUtils.method04604(232, 226, 60)
         )
         .method07291(
            ServerRank.Nested215.field17829,
            ServerRank.Nested215.field17830,
            ColorUtils.method04604(100, 180, 255),
            ColorUtils.method04604(30, 110, 220)
         )
         .method07291(
            ServerRank.Nested215.field17831,
            ServerRank.Nested215.field17832,
            ColorUtils.method04604(62, 79, 255),
            ColorUtils.method04604(100, 113, 251)
         )
         .method07293(
            ServerRank.Nested215.field17833,
            ServerRank.Nested215.field17834,
            ColorUtils.method04604(62, 79, 255),
            ColorUtils.method04604(110, 123, 249),
            ServerRank.Nested215.field17835,
            ColorUtils.method04604(241, 160, 0)
         )
         .method07291(
            ServerRank.Nested215.field17836,
            ServerRank.Nested215.field17837,
            ColorUtils.method04604(49, 67, 255),
            ColorUtils.method04604(120, 133, 247)
         )
         .method07291(
            ServerRank.Nested215.field17838,
            ServerRank.Nested215.field17839,
            ColorUtils.method04604(76, 86, 194),
            ColorUtils.method04604(70, 84, 242)
         )
         .method07291(
            ServerRank.Nested215.field17840,
            ServerRank.Nested215.field17841,
            ColorUtils.method04604(0, 100, 100),
            ColorUtils.method04604(0, 255, 246)
         )
         .method07291(
            ServerRank.Nested215.field17842,
            ServerRank.Nested215.field17843,
            ColorUtils.method04604(254, 85, 85),
            ColorUtils.method04604(255, 40, 40)
         )
         .method07292();
      private static final int field17783 = 42240;
      private static final int field17784 = 42336;
      private static final int field17785 = 42240;
      private static final String field17786 = "PLAYER";
      private static final int field17787 = 42244;
      private static final String field17788 = "HERO";
      private static final int field17789 = 42248;
      private static final String field17790 = "TITAN";
      private static final int field17791 = 42258;
      private static final String field17792 = "AVENGER";
      private static final int field17793 = 42262;
      private static final String field17794 = "OVERLORD";
      private static final int field17795 = 42272;
      private static final String field17796 = "MAGISTER";
      private static final int field17797 = 42276;
      private static final String field17798 = "IMPERATOR";
      private static final int field17799 = 42280;
      private static final String field17800 = "DRAGON";
      private static final int field17801 = 42290;
      private static final String field17802 = "BULL";
      private static final int field17803 = 42294;
      private static final String field17804 = "TIGER";
      private static final int field17805 = 42304;
      private static final String field17806 = "HYDRA";
      private static final int field17807 = 42305;
      private static final String field17808 = "GOD";
      private static final int field17809 = 42308;
      private static final String field17810 = "DRACULA";
      private static final int field17811 = 42309;
      private static final String field17812 = "VAMPIRE";
      private static final int field17813 = 42312;
      private static final String field17814 = "COBRA";
      private static final int field17815 = 42313;
      private static final String field17816 = "PEGAS";
      private static final int field17817 = 42322;
      private static final String field17818 = "RABBIT";
      private static final int field17819 = 42326;
      private static final String field17820 = "BUNNY";
      private static final int field17821 = 42336;
      private static final String field17822 = "D.HELPER";
      private static final int field17823 = 42241;
      private static final String field17824 = "MEDIA";
      private static final int field17825 = 42245;
      private static final String field17826 = "YT";
      private static final int field17827 = 42249;
      private static final String field17828 = "HELPER";
      private static final int field17829 = 42259;
      private static final String field17830 = "ML.MODER";
      private static final int field17831 = 42263;
      private static final String field17832 = "MODER";
      private static final int field17833 = 42273;
      private static final String field17834 = "MODER";
      private static final String field17835 = "+";
      private static final int field17836 = 42277;
      private static final String field17837 = "ST.MODER";
      private static final int field17838 = 42281;
      private static final String field17839 = "GL.MODER";
      private static final int field17840 = 42291;
      private static final String field17841 = "ML.ADMIN";
      private static final int field17842 = 42295;
      private static final String field17843 = "ADMIN";
   }
}
