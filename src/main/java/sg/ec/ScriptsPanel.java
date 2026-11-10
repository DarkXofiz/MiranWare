// Original binary: sg/ec/4JvkeCs4zVcK9hjV
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.util.Util;

// $VF: Compiled from s
public class ScriptsPanel extends GuiPanel {
   private static final float field01887 = 34.0F;
   private static final float field01888 = 0;
   private static final float field01889 = 0;
   private static final float field01890 = 0;
   private static final float field01891 = 0;
   private static final float field01892 = 0;
   private static final float field01893 = 0;
   private static final float field01894 = 0;
   private static final float field01895 = 0;
   private static final float field01896 = 0;
   private static final float field01897 = 0;
   private static final float field01898 = 0;
   private static final String field01899 = "field01899";
   private static final String field01900 = "field01900";
   private static final String field01901 = "field01901";
   private static final String field01902 = "field01902";
   private static final String field01903 = "field01903";
   private static final String field01904 = "field01904";
   private static final String field01905 = "field01905";
   private static final String field01906 = "field01906";
   private final ClickGuiScreen field01907;
   private final List<LoadedScript> field01908 = new ArrayList<>();
   private String field01909;
   private static final float field01910 = 6.0F;
   private static final float field01911 = 6.0F;
   private static final float field01912 = 12.0F;
   private static final float field01913 = 12.0F;
   private static final float field01914 = 38.0F;
   private static final float field01915 = 4.0F;
   private static final String field01916 = "scripts:empty";
   private static final String field01917 = "Скриптов нет — положите .jar в папку scripts";
   private static final String field01918 = "Ничего не найдено";
   private static final float field01919 = 34.0F;
   private static final float field01920 = 38.0F;
   private static final float field01921 = 34.0F;
   private static final float field01922 = 34.0F;
   private static final float field01923 = 9.5F;
   private static final float field01924 = 9.0F;
   private static final float field01925 = 15.333333F;
   private static final float field01926 = 4.6666665F;
   private static final float field01927 = 15.333333F;
   private static final float field01928 = 9.333333F;
   private static final float field01929 = 3.0F;
   private static final float field01930 = 21.333332F;
   private static final float field01931 = 19.0F;
   private static final float field01932 = 4.0F;
   private static final float field01933 = 12.0F;
   private static final float field01934 = 12.0F;
   private static final float field01935 = 19.0F;
   private static final String field01936 = "scripts.menu";
   private static final float field01937 = 8.0F;
   private static final float field01938 = 9.0F;
   private static final float field01939 = 4.0F;
   private static final float field01940 = 8.0F;
   private static final float field01941 = 9.0F;
   private static final float field01942 = 8.0F;
   private static final float field01943 = 5.0F;
   private static final float field01944 = 7.0F;
   private static final float field01945 = 4.0F;
   private static final float field01946 = 7.0F;
   private static final float field01947 = 7.0F;
   private static final float field01948 = 19.0F;
   private static final float field01949 = 9.0F;
   private static final float field01950 = 11.0F;
   private static final float field01951 = 4.0F;
   private static final String field01952 = "Без настроек";
   private static final String field01953 = "настройка";
   private static final String field01954 = "настройки";
   private static final String field01955 = "настроек";
   private static final float field01956 = 11.0F;
   private static final float field01957 = 11.0F;
   private static final float field01958 = 4.0F;
   private static final float field01959 = 11.0F;
   private static final String field01960 = "Нужен перезапуск";
   private static final String field01961 = "—";
   private static final String field01962 = "Настройки";
   private static final String field01963 = "Перезагрузить";
   private static final String field01964 = "Открыть папку";

   private static String method00803(int var0, String var1, String var2, String var3) {
      int var4 = var0 % 100;
      int sx = var0 % 10;
      String sxx = var4 >= 11 && var4 <= 14 ? var3 : (sx == 1 ? var1 : (sx >= 2 && sx <= 4 ? var2 : var3));
      return var0 + " " + sxx;
   }

   public ScriptsPanel(ClickGuiScreen var1) {
      this.field01907 = var1;
   }

   public void method00804() {
      this.method10196();
   }

   public void method00805(double var1, double var3, int var5) {
      if (var5 == 0) {
         this.method10220((float)var1, (float)var3);
      }
   }

   private static int method00806(ScriptModule var0) {
      int var1 = 0;

      for (Setting var3 : var0.method03932()) {
         if (SettingsWindow.method04684(var3)) {
            var1++;
         }
      }

      return var1;
   }

   private static void method00807() {
      net.minecraft.Util.getPlatform().openPath(ScriptRuntime.INSTANCE.method06231().method05737().toPath());
   }

   private void method00808(String var1) {
      this.field01908.clear();
      SortableArrayList var2 = ScriptRuntime.INSTANCE.method06229();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         LoadedScript var4 = (LoadedScript)var2.get(var3);
         if (var4.method03398() != null && (var1.isEmpty() || TextRenderUtils.method00672(var4.method03400()).contains(var1))) {
            this.field01908.add(var4);
         }
      }
   }

   private void method00809(LoadedScript var1, GuiPanel.Nested283 var2) {
      ArrayList var3 = new ArrayList();
      if (method00806(var1.method03398()) > 0) {
         var3.add(new ScriptsWindow.Nested34(GuiIcon.GEAR, field01962, () -> this.method00818(var1)));
      }

      var3.add(new ScriptsWindow.Nested34(GuiIcon.RELOAD, field01963, ScriptRuntime.INSTANCE::method06177));
      var3.add(new ScriptsWindow.Nested34(GuiIcon.FOLDER, field01964, ScriptsPanel::method00807));
      ScriptsWindow var4 = new ScriptsWindow(var3);
      float var5 = this.field01907.method09986() + this.field01907.method10015();
      float var6 = this.field01907.method09963() + this.field01907.method10026();
      float var7 = Math.min(var2.field23010(), var5 - var4.method09568() - 2.0F);
      float var8 = var2.field23011() + var2.field23013() + 2.0F;
      if (var8 + var4.method09574() > var6) {
         var8 = var2.field23011() - var4.method09574() - 2.0F;
      }

      this.field01907.method09983().method09652(var4, var7, var8);
      this.field01909 = var1.method03400();
   }

   public void method00811(GuiGraphics var1, int var2, int var3, float var4) {
      float var5 = this.field01907.method09986() + field01910;
      float var6 = this.field01907.method09963() + field01911;
      float var7 = this.field01907.method10015() - field01912;
      float var8 = this.field01907.method10026() - field01913;
      this.method10222();
      String var9 = this.field01907.method09960();
      this.method00808(var9);
      float var10 = this.field01908.isEmpty() ? 0.0F : this.field01908.size() * field01914 - field01915;
      float var11 = this.method10226(var10, var8);
      boolean var12 = this.field01908.isEmpty() && var9.isEmpty();
      this.method10164(var1, var4, var5, var6, var7, var8, field01916, var12 ? field01917 : field01918, this.field01908.isEmpty());
      if (!this.field01908.isEmpty()) {
         var1.enableScissor((int)var5, (int)var6, (int)Math.ceil(var5 + var7), (int)Math.ceil(var6 + var8));
         float var13 = var6 + var11;

         for (LoadedScript var15 : this.field01908) {
            if (var13 + field01919 >= var6 && var13 <= var6 + var8) {
               this.method00814(var1, var2, var3, var4, var5, var13, var7, var15);
            }

            var13 += field01920;
         }

         var1.disableScissor();
      }
   }

   public boolean method00813(double var1) {
      return this.method10181(var1);
   }

   private void method00814(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6, float var7, LoadedScript var8) {
      ScriptModule var9 = var8.method03398();
      FontRenderer var10 = Fonts.field00110;
      float var11 = this.method10168("scripts:row:" + var8.method03400(), GuiHitTestUtils.method05625(var2, var3, var5, var6, var7, field01921));
      this.method10224(var1, var4, var5, var6, var7, field01922, var11);
      float var12 = var6 + field01923;
      float var13 = var5 + var7 - field01924 - field01925;
      float var14 = var12 - field01926;
      this.method10180(var1, var13, var14, field01927, field01928, this.method10168("scripts:switch:" + var8.method03400(), var9.method03937()), var4);
      this.method10225(new GuiPanel.Nested283(var13 - field01929, var6, field01930, field01931), var9::method00382);
      GuiPanel.Nested283 var15 = new GuiPanel.Nested283(var13 - field01932 - field01933, var6, field01934, field01935);
      boolean var16 = var8.method03400().equals(this.field01909) && this.field01907.method09983().method09669(field01936) != null;
      this.method10178(var1, var15, this.method10168("scripts:dots:" + var8.method03400(), var15.has(var2, var3) || var16), field01937, var4);
      this.method10225(var15, () -> this.method00809(var8, var15));
      float var17 = var5 + field01938 + field01939;
      method00816(var8).method01190(var1, var17, var12, field01940, method10227(method00819(var8), var4));
      float var18 = var5 + field01941 + field01942 + field01943;
      String var19 = GuiThemeStyle.method01438(var10, var8.method03400(), field01944, var15.field23010() - field01945 - var18);
      var10.method09480(var1, var19, var18, var12 - var10.method09485(field01946) / 2.0F, method10227(method10175(), var4), field01947);
      float var20 = var6 + field01948;
      float var21 = var5 + field01949;
      var21 = this.method10167(var1, var21, var20, field01950, GuiIcon.FOLDER, method00817(var8), 0.0F, var4) + field01951;
      int var22 = method00806(var9);
      String var23 = var22 == 0 ? field01952 : method00803(var22, field01953, field01954, field01955);
      GuiPanel.Nested283 var24 = new GuiPanel.Nested283(var21, var20, method10176(var23), field01956);
      boolean var25 = this.field01907.method09983().method09669(ScriptSettingsWindow.method01902(var8)) != null;
      float var26 = var22 == 0 ? 0.0F : Math.max(var25 ? 1.0F : 0.0F, this.method10168("scripts:settings:" + var8.method03400(), var24.has(var2, var3)));
      var21 = this.method10167(var1, var21, var20, field01957, GuiIcon.GEAR, var23, var26, var4) + field01958;
      if (var22 > 0) {
         this.method10225(var24, () -> this.method00818(var8));
      }

      if (ScriptRuntime.INSTANCE.method06178(var8)) {
         this.method10204(var1, var21, var20, field01959, GuiIcon.RELOAD, field01960, field22872, var4);
      }
   }

   private static GuiIcon method00816(LoadedScript var0) {
      if (var0.method03391()) {
         return GuiIcon.ALERT;
      } else {
         return var0.method03392() ? GuiIcon.PLAY : GuiIcon.CHECK;
      }
   }

   private static String method00817(LoadedScript var0) {
      ScriptSourceLoader var1 = ScriptLifecycle.method03298(var0.method03393());
      return var1 == null ? field01961 : var1.method08403().getName();
   }

   private void method00818(LoadedScript var1) {
      ModuleContextMenu var2 = this.field01907.method09983();
      FloatingWindow var3 = var2.method09669(ScriptSettingsWindow.method01902(var1));
      if (var3 != null) {
         var2.method09654(var3);
      } else {
         for (FloatingWindow var5 : var2.method09655()) {
            if (var5 instanceof ScriptSettingsWindow) {
               var2.method09654(var5);
            }
         }

         this.field01907.method09968(new ScriptSettingsWindow(var1));
      }
   }

   private static int method00819(LoadedScript var0) {
      if (var0.method03391()) {
         return field22870;
      } else {
         return var0.method03392() ? method10198() : method10213();
      }
   }
}
