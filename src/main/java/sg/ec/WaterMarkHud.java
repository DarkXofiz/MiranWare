// Original binary: sg/ec/4Ptfq2uNENPXvOIn
package sg.ec;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public class WaterMarkHud extends HudElement {
   private static final String field01965 = "Название клиента";
   private static final String field01966 = "field01966";
   private static final String field01967 = "field01967";
   private static final String field01968 = "field01968";
   private static final String field01969 = "field01969";
   private final NamedOption<Boolean> field01970;
   private final NamedOption<Boolean> field01971;
   private final NamedOption<Boolean> field01972;
   private final NamedOption<Boolean> field01973;
   private final NamedOption<Boolean> field01974;
   private final MultiToggleSetting field01975;
   private static final float field01976 = 0;
   private static final float field01977 = 0;
   private static final float field01978 = 0;
   private static final float field01979 = 0;
   private static final float field01980 = 0;
   private static final float field01981 = 0;
   private static final float field01982 = 0;
   private final List<WaterMarkHud.Nested28> field01983;
   private static final String field01984 = "field01984";
   private static final String field01985 = "field01985";
   private static final String field01986 = "field01986";
   private static final float field01987 = 0;
   private static final float field01988 = 0;
   private static final float field01989 = 0;
   private final DraggableElement field01990;
   private float field01991;
   private float field01992;
   private static final String field01993 = "WaterMark";
   private static final String field01994 = "Название клиента";
   private static final String field01995 = "Юзер нейм";
   private static final String field01996 = "Fps";
   private static final String field01997 = "Айпи сервера";
   private static final String field01998 = "Текущее время";
   private static final String field01999 = "Компоненты";
   private static final float field02000 = 5.0F;
   private static final float field02001 = 5.0F;
   private static final float field02002 = 6.0F;
   private static final float field02003 = 3.0F;
   private static final float field02004 = 19.0F;
   private static final float field02005 = 4.0F;
   private static final float field02006 = 17.5F;
   private static final float field02007 = 4.0F;
   private static final float field02008 = 15.0F;
   private static final float field02009 = 4.0F;
   private static final float field02010 = 15.0F;
   private static final float field02011 = 15.0F;
   private static final float field02012 = 5.0F;
   private static final float field02013 = 5.0F;
   private static final float field02014 = 5.0F;
   private static final float field02015 = 0.5F;
   private static final float field02016 = 7.0F;
   private static final String field02017 = "N";
   private static final String field02018 = "«";
   private static final String field02019 = "»";
   private static final String field02020 = "MiranWare";
   private static final float field02021 = 6.0F;
   private static final float field02022 = 4.0F;
   private static final float field02023 = 0.25F;
   private static final float field02024 = 0.75F;
   private static final float field02025 = 1.5F;
   private static final float field02026 = 6.0F;
   private static final float field02027 = 3.0F;
   private static final float field02028 = 3.0F;
   private static final String field02029 = "N";
   private static final String field02030 = "»";
   private static final String field02031 = "«";
   private static final float field02032 = 6.0F;
   private static final float field02033 = 6.0F;
   private static final String field02034 = "Unknown";
   private static final String field02035 = "HH:mm";

   private void method00842(NamedOption<Boolean> var1, boolean var2, String var3) {
      if (Boolean.TRUE.equals(var1.method08074())) {
         WaterMarkHud.Nested28 var4 = new WaterMarkHud.Nested28(var1, var3);
         var4.method00855(var2);
         var4.method00849(field14601.method09478(var3, field14607, -field14608));
         this.field01983.add(var4);
      }
   }

   private void method00843() {
      this.field01983.clear();
      long var1 = System.currentTimeMillis();
      String var3 = "Fps " + mc.getFps();
      String var4 = ProfileAPI.get().getModel().getName();
      String var5 = mc.getCurrentServer() == null ? field02034 : mc.getCurrentServer().ip;
      String var6 = LocalTime.now().format(DateTimeFormatter.ofPattern(field02035));
      this.method00842(this.field01970, true, ClientEnvironment.field07579);
      this.method00845(this.field01971, var4);
      this.method00845(this.field01972, var3);
      this.method00845(this.field01973, var5);
      this.method00845(this.field01974, var6);
   }

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      float var2 = 0.0F;

      for (int var3 = 0; var3 < this.field01983.size(); var3++) {
         WaterMarkHud.Nested28 var4 = this.field01983.get(var3);
         var2 += field02002 + var4.method00858();
         if (var3 < this.field01983.size() - 1) {
            var2 += field02003;
         }
      }

      float var20 = field02004 + var2 + field02005 + 1.0F;
      this.method06459(this.field01990, var20, field02006);
      boolean var21 = this.method06445();
      float var5 = this.method06464() + this.method06435() / 2.0F - field14607 / 2.0F;
      float var6 = var21 ? this.method06436() + var20 - field02007 - field02008 : this.method06436() + field02009;
      float var7 = var6 + (field02010 - this.field01991) / 2.0F;
      float var8 = var21 ? var6 - 0.0F : var6 + field02011 + 0.0F;
      int var9 = ColorUtils.method04611(this.method06460(), this.method06455());
      this.method06439(var1, this.method06436(), this.method06464(), var20, this.method06435(), field02012, this.method06466(), 1.0F);
      RoundedRectRenderer.method01272(var1, this.method06436(), this.method06464(), var20, this.method06435(), field02013, this.method06466(), var9);
      if (!this.method06447()) {
         GuiShadowRenderer.method10984(var1, this.method06436(), this.method06464(), var20, this.method06435(), field02014, field02015, field02016, var9);
      }

      Fonts.field00107
         .method09490(var1, field02017, var21 ? var7 + 1.0F : var7 - 1.0F, var5 + 1.0F, ColorUtils.method04621(45), field14607, field14608);
      String var10 = var21 ? field02018 : field02019;
      float var11 = var8;

      for (WaterMarkHud.Nested28 var13 : this.field01983) {
         String var14 = var13.method00852();
         String var15 = var13.method00853()
            ? FontFallbackManager.method07178(field02020, var14, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637(), 30, 5)
            : var14;
         float var16 = field02021 + var13.method00858();
         float var17 = var21 ? var11 - var16 : var11;
         float var18 = var21 ? var17 : var17 + 2.0F + field02022;
         float var19 = var21 ? var17 + var16 + field02023 - this.field01992 : var17 - field02024;
         field14601.method09480(var1, var10, var19, var5 + field02025, ColorUtils.method04604(210, 210, 210), field02026);
         field14601.method09490(var1, var15, var18, var5, this.method06438(), field14607, -field14608);
         var11 = var21 ? var17 - field02027 : var17 + var16 + field02028;
      }
   }

   private float method00844() {
      FontGlyph var1 = field14601.field21527.method07009(field02030.charAt(0));
      FontGlyph var2 = field14601.field21527.method07009(field02031.charAt(0));
      return var1 != null && var2 != null ? var1.method03703(field02032) + var2.method03697(field02033) : 0.0F;
   }

   @Override
   public void method00034(TickEvent var1) {
      this.field01991 = Fonts.field00107.method09478(field02029, field14607, field14608);
      this.field01992 = this.method00844();
      this.method00843();
      super.method00034(var1);
   }

   private void method00845(NamedOption<Boolean> var1, String var2) {
      this.method00842(var1, false, var2);
   }

   public WaterMarkHud() {
      super(field01993);
      this.field01970 = NamedOption.method08077(field01994, true);
      this.field01971 = NamedOption.method08077(field01995, true);
      this.field01972 = NamedOption.method08077(field01996, true);
      this.field01973 = NamedOption.method08077(field01997, false);
      this.field01974 = NamedOption.method08077(field01998, false);
      this.field01975 = new MultiToggleSetting(field01999)
         .method04517(this.field01970)
         .method04517(this.field01971)
         .method04517(this.field01972)
         .method04517(this.field01973)
         .method04517(this.field01974)
         .method04521(1)
         .method03023(this);
      this.field01983 = new ArrayList<>();
      this.field01990 = this.method06449(this, field02000, field02001);
   }

   // $VF: Compiled from s
   private static class Nested28 {
      private final NamedOption<Boolean> field02036;
      private String field02037;
      private boolean field02038;
      private float field02039;
      private float field02040;
      private float field02041;
      private float field02042;

      public NamedOption<Boolean> method00846() {
         return this.field02036;
      }

      public float method00847() {
         return this.field02040;
      }

      public void method00848(String var1) {
         this.field02037 = var1;
      }

      public void method00849(float var1) {
         this.field02041 = var1;
      }

      public void method00850(float var1) {
         this.field02042 = var1;
      }

      public void method00851(float var1) {
         this.field02040 = var1;
      }

      public String method00852() {
         return this.field02037;
      }

      public Nested28(NamedOption<Boolean> var1, String var2) {
         this.field02036 = var1;
         this.field02037 = var2;
      }

      public boolean method00853() {
         return this.field02038;
      }

      public void method00854(float var1) {
         this.field02039 = var1;
      }

      public void method00855(boolean var1) {
         this.field02038 = var1;
      }

      public float method00856() {
         return this.field02042;
      }

      public float method00857() {
         return this.field02039;
      }

      public float method00858() {
         return this.field02041;
      }
   }
}
