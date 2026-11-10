// Original binary: sg/ec/tZfhxGGbUvdhBmFv
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class MediaPlayerHud extends HudElement {
   private static final float field23976 = 4.0F;
   private static final float field23977 = 0;
   private static final float field23978 = 0;
   private static final float field23979 = 0;
   private static final float field23980 = 0;
   private static final float field23981 = 0;
   private static final float field23982 = 0;
   private static final float field23983 = 0;
   private static final float field23984 = 0;
   private static final float field23985 = 0;
   private static final float field23986 = 0;
   private final NumberSetting<Integer> field23987;
   private final ToggleSetting field23988;
   private final ToggleSetting field23989;
   private final ToggleSetting field23990;
   private final DraggableElement field23991;
   private final SmoothAnimation field23992;
   private final SmoothAnimation field23993;
   private String field23994;
   private String field23995;
   private long field23996;
   private String field23997;
   private String field23998;
   private float field23999;
   private float field24000;
   private float field24001;
   private float field24002;
   private float field24003;
   private float field24004;
   private float field24005;
   private float field24006;
   private boolean field24007;
   private boolean field24008;
   private long field24009;
   private float field24010;
   private float field24011;
   private float field24012;
   private boolean field24013;
   private static final String field24014 = "MediaPlayer";
   private static final String field24015 = "Ширина";
   private static final String field24016 = "Обложка";
   private static final String field24017 = "Прогресс-бар";
   private static final String field24018 = "Кнопки управления";
   private static final long field24019 = -1L;
   private static final String field24020 = "Нет воспроизведения";
   private static final String field24021 = "Запустите плеер на ПК";
   private static final long field24022 = 1000L;
   private static final float field24023 = 7.0F;
   private static final float field24024 = 7.0F;
   private static final float field24025 = 22.0F;
   private static final float field24026 = 16.0F;
   private static final float field24027 = 16.0F;
   private static final float field24028 = 4.0F;
   private static final float field24029 = 4.0F;
   private static final float field24030 = 7.0F;
   private static final float field24031 = 4.0F;
   private static final float field24032 = 10.0F;
   private static final float field24033 = 8.0F;
   private static final float field24034 = 4.0F;
   private static final float field24035 = 4.0F;
   private static final String field24036 = "V";
   private static final float field24037 = 4.0F;
   private static final float field24038 = 22.0F;
   private static final float field24039 = 0.5F;
   private static final float field24040 = 22.0F;
   private static final float field24041 = 4.0F;
   private static final float field24042 = 4.0F;
   private static final float field24043 = 4.0F;
   private static final float field24044 = 0.9F;
   private static final float field24045 = 22.0F;
   private static final float field24046 = 22.0F;
   private static final float field24047 = 3.0F;
   private static final float field24048 = 22.0F;
   private static final float field24049 = 22.0F;
   private static final float field24050 = 3.0F;
   private static final float field24051 = 15.4F;
   private static final String field24052 = "V";
   private static final float field24053 = 22.0F;
   private static final float field24054 = 0.5F;
   private static final float field24055 = 22.0F;
   private static final float field24056 = 0.5F;
   private static final float field24057 = 0.12F;
   private static final float field24058 = 0.35F;
   private static final float field24059 = 16.0F;
   private static final float field24060 = 0.5F;
   private static final float field24061 = 7.0F;
   private static final float field24062 = 0.45F;
   private static final String field24063 = "Artist: ";
   private static final String field24064 = "Title: ";
   private static final float field24065 = 7.0F;
   private static final float field24066 = 7.0F;
   private static final float field24067 = 7.0F;
   private static final float field24068 = 7.0F;
   private static final float field24069 = 10.0F;
   private static final float field24070 = 10.0F;
   private static final float field24071 = 7.0F;
   private static final float field24072 = 7.0F;
   private static final float field24073 = 8.0F;
   private static final float field24074 = 26.0F;
   private static final float field24075 = 10.0F;
   private static final float field24076 = 7.0F;
   private static final float field24077 = 7.0F;
   private static final float field24078 = 8.0F;
   private static final float field24079 = 28.0F;
   private static final float field24080 = 10.0F;
   private static final float field24081 = 10.0F;
   private static final float field24082 = 7.0F;
   private static final float field24083 = 7.0F;
   private static final float field24084 = 7.0F;
   private static final float field24085 = 8.0F;
   private static final float field24086 = 28.0F;
   private static final float field24087 = 10.0F;
   private static final float field24088 = 8.5F;
   private static final float field24089 = 4.0F;
   private static final float field24090 = 7.0F;
   private static final float field24091 = 4.0F;
   private static final float field24092 = 4.0F;
   private static final float field24093 = 0.35F;
   private static final String field24094 = "R";
   private static final String field24095 = "S";
   private static final String field24096 = "T";
   private static final float field24097 = 7.0F;
   private static final float field24098 = 0.8F;
   private static final String field24099 = "U";
   private static final float field24100 = 7.0F;
   private static final float field24101 = 6.0F;
   private static final float field24102 = 0.5F;
   private static final float field24103 = 0.6F;
   private static final float field24104 = 4.0F;
   private static final float field24105 = 6.0F;
   private static final float field24106 = 0.18F;
   private static final float field24107 = 0.9F;
   private static final float field24108 = 3.0F;
   private static final float field24109 = 3.0F;
   private static final float field24110 = 13.0F;
   private static final float field24111 = 13.0F;
   private static final float field24112 = 3.0F;
   private static final float field24113 = 3.0F;
   private static final float field24114 = 3.0F;
   private static final String field24115 = "—";
   private static final long field24116 = 1000L;
   private static final long field24117 = 60L;
   private static final long field24118 = 60L;
   private static final long field24119 = 60L;
   private static final long field24120 = 3600L;
   private static final String field24121 = "%d:%02d:%02d";
   private static final String field24122 = "%d:%02d";

   private static String method10843(String var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.trim();
      return var1.isEmpty() ? field24115 : var1;
   }

   public MediaPlayerHud() {
      super(field24014);
      this.field23987 = new NumberSetting<Integer>(field24015).method10835(150).method10838(240).method10834(2).method03017(170).method03023(this);
      this.field23988 = new ToggleSetting(field24016).method03017(true).method03023(this);
      this.field23989 = new ToggleSetting(field24017).method03017(true).method03023(this);
      this.field23990 = new ToggleSetting(field24018).method03017(true).method03023(this);
      this.field23991 = this.method06449(this, 0.0F, 0.0F);
      this.field23992 = new SmoothAnimation();
      this.field23993 = new SmoothAnimation();
      this.field23994 = "";
      this.field23995 = "";
      this.field23996 = field24019;
      this.field23997 = "";
      this.field23998 = "";
   }

   @Override
   public void method00034(TickEvent var1) {
      WindowsMediaManager.method02529();
      super.method00034(var1);
   }

   @Override
   public void method00031(int var1, float var2, float var3) {
      if (var1 == 0 && this.field24008) {
         this.field24008 = false;
         WindowsMediaManager.method02533(this.field24009);
      } else {
         super.method00031(var1, var2, var3);
      }
   }

   @Override
   public void method00025(int var1, float var2, float var3) {
      super.method00025(var1, var2, var3);
      if (var1 == 0) {
         if (this.field24013 && this.field24012 > 0.0F) {
            float var4 = field24108;
            if (GuiHitTestUtils.method05625(var2, var3, this.field24010, this.field24011 - var4, this.field24012, 2.0F + var4 * 2.0F)) {
               this.field24008 = true;
               long var9 = Math.max(0L, WindowsMediaManager.field06031);
               float var7 = Mth.clamp((var2 - this.field24010) / this.field24012, 0.0F, 1.0F);
               this.field24009 = (long)(var7 * (float)var9);
               this.field23991.method02686(0);
               return;
            }
         }

         if (this.field24007) {
            float var8 = this.field24006 - field24109;
            float var5 = field24110;
            float var6 = field24111;
            if (GuiHitTestUtils.method05625(var2, var3, this.field24003 - field24112, var8, var6, var5)) {
               WindowsMediaManager.method02514();
               this.field23991.method02686(0);
            } else if (GuiHitTestUtils.method05625(var2, var3, this.field24004 - field24113, var8, var6 + 2.0F, var5)) {
               WindowsMediaManager.method02528();
               this.field23991.method02686(0);
            } else {
               if (GuiHitTestUtils.method05625(var2, var3, this.field24005 - field24114, var8, var6, var5)) {
                  WindowsMediaManager.method02511();
                  this.field23991.method02686(0);
               }
            }
         }
      }
   }

   private static String method10844(long var0) {
      if (var0 < 0L) {
         var0 = 0L;
      }

      long var2 = var0 / field24116;
      long var4 = var2 % field24117;
      long var6 = var2 / field24118 % field24119;
      long var8 = var2 / field24120;
      return var8 > 0L ? String.format(field24121, var8, var6, var4) : String.format(field24122, var6, var4);
   }

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      super.method00027(var1);
      FontRenderer var2 = Fonts.field00109;
      boolean var3 = WindowsMediaManager.field06035;
      boolean var4 = this.field23988.method05999();
      boolean var5 = this.field23989.method05999() && var3 && WindowsMediaManager.field06031 > 0L;
      boolean var6 = this.field23990.method05999();
      this.field24007 = var6;
      float var7 = this.field23987.method03022().intValue();
      float var8 = this.field23991.method02685();
      float var9 = this.field23991.method02669();
      float var10 = var9 + field14609;
      String var11 = var3 ? method10843(WindowsMediaManager.field06030) : field24020;
      String var12 = var3 ? method10843(WindowsMediaManager.field06029) : field24021;
      long var13 = Math.max(0L, WindowsMediaManager.field06031);
      long var15 = Mth.clamp(WindowsMediaManager.method02541(), 0L, Math.max(var13, 0L));
      long var17 = var15 / field24022;
      boolean var19 = !var12.equals(this.field23997) || !var11.equals(this.field23998);
      if (var19 || var17 != this.field23996) {
         if (var3 && var13 > 0L) {
            this.field23994 = method10844(var15);
            this.field23995 = method10844(var13);
         } else {
            this.field23994 = "";
            this.field23995 = "";
         }

         if (var19) {
            this.field24001 = var2.method09478(var11, field24023, -field14608);
            this.field24002 = var2.method09478(var12, field24024, -field14608);
         }

         this.field23996 = var17;
         this.field23997 = var12;
         this.field23998 = var11;
      }

      float var20 = var4 ? Math.max(field24025, field24026) : field24027;
      float var21 = var10 + field24028;
      float var22 = var21 + var20;
      boolean var23 = var3 && var13 > 0L;
      boolean var24 = var6 || var23;
      if (var24) {
         this.field24006 = var22 + field24029;
         var22 = this.field24006 + field24030;
      }

      float var25 = 0.0F;
      float var26 = var8 + field24031;
      float var27 = Math.max(field24032, var7 - field24033);
      if (var5) {
         var25 = var22 + field24034;
         var22 = var25 + 2.0F;
         this.field24010 = var26;
         this.field24011 = var25;
         this.field24012 = var27;
         this.field24013 = true;
      } else {
         this.field24013 = false;
         if (this.field24008) {
            this.field24008 = false;
         }
      }

      float var28 = var22 - var10 + field24035;
      float var29 = field14609 + var28;
      this.method06465(var8);
      this.method06453(var9);
      this.method06448(var7);
      this.method06456(var29);
      float var30 = 0.0F;
      if (var5) {
         if (this.field24008 && var13 > 0L) {
            Minecraft var31 = Minecraft.getInstance();
            float var32 = (float)(var31.mouseHandler.xpos() / var31.getWindow().getGuiScale()) / this.method06446();
            float var33 = Mth.clamp((var32 - var26) / var27, 0.0F, 1.0F);
            this.field24009 = (long)(var33 * (float)var13);
            var30 = var33;
            this.field23994 = method10844(this.field24009);
         } else {
            var30 = Mth.clamp(WindowsMediaManager.method02536(), 0.0F, 1.0F);
         }
      }

      String var51 = !this.field23994.isEmpty() && !this.field23995.isEmpty() ? this.field23994 + " / " + this.field23995 : "";
      this.method06441(var1, field24036);
      float var52 = var8 + field24037;
      float var53 = var21 + (var20 - field24038) * field24039;
      float var34 = var4 ? var52 + field24040 + field24041 : var8 + field24042;
      float var35 = var8 + var7 - field24043;
      if (var4) {
         int var36 = ColorUtils.method04611(ColorUtils.method04630(28, 28, 28), field24044);
         RoundedRectRenderer.method01272(var1, var52, var53, field24045, field24046, field24047, this.method06466(), var36);
         if (var3 && WindowsMediaManager.field06034 != null) {
            GuiTextureRenderer.method10255(var1, WindowsMediaManager.field06034, var52, var53, field24048, field24049, field24050, this.method06466(), -1);
         } else {
            float var37 = field24051;
            Fonts.field00107
               .method09480(
                  var1,
                  field24052,
                  var52 + (field24053 - var37) * field24054,
                  var53 + (field24055 - var37) * field24056 + var37 * field24057,
                  ColorUtils.method04611(this.method06438(), field24058),
                  var37
               );
         }
      }

      float var54 = var21 + (var20 - field24059) * field24060;
      float var55 = var54;
      float var38 = var55 + field24061 + 2.0F;
      int var39 = ColorUtils.method04611(this.method06438(), field24062);
      int var40 = this.method06438();
      if (var3) {
         String var41 = field24063;
         String var42 = field24064;
         if (this.field23999 <= 0.0F) {
            this.field23999 = var2.method09478(var41, field24065, -field14608);
            this.field24000 = var2.method09478(var42, field24066, -field14608);
         }

         float var43 = this.field23999;
         float var44 = this.field24000;
         var2.method09490(var1, var41, var34, var55, var39, field24067, -field14608);
         var2.method09490(var1, var42, var34, var38, var39, field24068, -field14608);
         float var45 = var34 + var43;
         float var46 = var34 + var44;
         float var47 = Math.max(field24069, var35 - var45);
         float var48 = Math.max(field24070, var35 - var46);
         float var49 = this.field24001;
         if (var49 <= var47) {
            this.field23993.method06157(0.0);
            var2.method09490(var1, var11, var45, var55, var40, field24071, -field14608);
         } else {
            TextRenderUtils.method00666(
               var1, this.field23993, var2, var11, var45, var55, var47, var40, field24072, -field14608, field24073, field24074, field24075
            );
         }

         float var50 = this.field24002;
         if (var50 <= var48) {
            this.field23992.method06157(0.0);
            var2.method09490(var1, var12, var46, var38, var40, field24076, -field14608);
         } else {
            TextRenderUtils.method00666(
               var1, this.field23992, var2, var12, var46, var38, var48, var40, field24077, -field14608, field24078, field24079, field24080
            );
         }
      } else {
         float var56 = Math.max(field24081, var35 - var34);
         var2.method09490(var1, var11, var34, var55, var39, field24082, -field14608);
         float var60 = this.field24002;
         if (var60 <= var56) {
            this.field23992.method06157(0.0);
            var2.method09490(var1, var12, var34, var38, var39, field24083, -field14608);
         } else {
            TextRenderUtils.method00666(
               var1, this.field23992, var2, var12, var34, var38, var56, var39, field24084, -field14608, field24085, field24086, field24087
            );
         }
      }

      if (var24) {
         if (var6) {
            float var57 = field24088;
            this.field24003 = var8 + field24089;
            this.field24004 = this.field24003 + field24090 + field24091;
            this.field24005 = this.field24004 + var57 + field24092;
            int var61 = var3 ? this.method06438() : ColorUtils.method04611(this.method06438(), field24093);
            String var64 = WindowsMediaManager.field06036 ? field24094 : field24095;
            Fonts.field00107.method09480(var1, field24096, this.field24003, this.field24006, var61, field24097);
            Fonts.field00107.method09480(var1, var64, this.field24004, this.field24006 - field24098, var61, var57);
            Fonts.field00107.method09480(var1, field24099, this.field24005, this.field24006, var61, field24100);
         }

         if (!var51.isEmpty()) {
            float var58 = var2.method09478(var51, field24101, -field14608);
            float var62 = this.field24006 + field24102;
            int var65 = ColorUtils.method04611(this.method06438(), field24103);
            var2.method09490(var1, var51, var8 + var7 - field24104 - var58, var62, var65, field24105, -field14608);
         }
      }

      if (var5) {
         int var59 = ColorUtils.method04611(ColorUtils.method04630(255, 255, 255), field24106);
         int var63 = ColorUtils.method04611(-1, field24107);
         RoundedRectRenderer.method01272(var1, var26, var25, var27, 2.0F, 1.0F, this.method06466(), var59);
         RoundedRectRenderer.method01272(var1, var26, var25, var27 * var30, 2.0F, 1.0F, this.method06466(), var63);
      }

      this.field23991.method02676(var7);
      this.field23991.method02696(var29);
   }
}
