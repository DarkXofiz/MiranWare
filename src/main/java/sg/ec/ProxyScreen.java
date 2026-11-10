// Original binary: sg/ec/6DHMbwavBuCVMOqk
package sg.ec;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.CharacterEvent;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class ProxyScreen extends Screen implements MinecraftAccess {
   private static final String field02784 = "ProxyMenu";
   private static final String field02785 = "field02785";
   private static final int field02786 = 0;
   private static final int field02787 = 0;
   private static final int field02788 = 0;
   private static final float field02789 = 0;
   private static final float field02790 = 0;
   private static final float field02791 = 0;
   private static final float field02792 = 0;
   private static final float field02793 = 0;
   private static final int field02794 = 0;
   private static final float field02795 = 0;
   private static final float field02796 = 0;
   private static final float field02797 = 0;
   private static final float field02798 = 0;
   private static final float field02799 = 0;
   private static final float field02800 = 0;
   private static final float field02801 = 0;
   private static final long field02802 = 0;
   private static final long field02803 = 0;
   private static final long field02804 = 0;
   private static final long field02805 = 0;
   private static final float field02806 = 0;
   private static final int field02807 = ColorUtils.method04604(235, 90, 90);
   private static Button field02808;
   private final Screen field02809;
   private final ProxyPingService field02810 = new ProxyPingService();
   private final Map<Object, AnimationUtils> field02811 = new LinkedHashMap<>();
   private final Map<Object, AnimationUtils> field02812 = new LinkedHashMap<>();
   private final AnimationUtils field02813;
   private final AnimationUtils field02814;
   private final List<ProxyScreen.Nested39> field02815;
   private final List<Runnable> field02816;
   private final TextInputWidget field02817;
   private final TextInputWidget field02818;
   private final TextInputWidget field02819;
   private final TextInputWidget field02820;
   private final TextInputWidget field02821;
   private ProxyConfig.Nested114 field02822;
   private String field02823;
   private String field02824;
   private boolean field02825;
   private int field02826;
   private float field02827;
   private static final String field02828 = "Прокси";
   private static final long field02829 = 220L;
   private static final long field02830 = 160L;
   private static final String field02831 = "Имя";
   private static final String field02832 = "IP:PORT";
   private static final String field02833 = "Логин";
   private static final String field02834 = "Пароль";
   private static final String field02835 = "Адрес пинга";
   private static final float field02836 = 6.5F;
   private static final float field02837 = 6.0F;
   private static final String field02838 = "ProxyMenu";
   private static final float field02839 = 0.025F;
   private static final float field02840 = 20.0F;
   private static final float field02841 = 4.0F;
   private static final float field02842 = 28.0F;
   private static final float field02843 = 10.0F;
   private static final float field02844 = 51.0F;
   private static final float field02845 = 10.0F;
   private static final float field02846 = 10.0F;
   private static final float field02847 = 11.0F;
   private static final float field02848 = 8.0F;
   private static final float field02849 = 15.0F;
   private static final float field02850 = 8.0F;
   private static final float field02851 = 7.0F;
   private static final float field02852 = 10.0F;
   private static final float field02853 = 302.0F;
   private static final float field02854 = 7.0F;
   private static final float field02855 = 302.0F;
   private static final float field02856 = 6.0F;
   private static final float field02857 = 0.94F;
   private static final float field02858 = 10.0F;
   private static final String field02859 = "Прокси";
   private static final float field02860 = 10.0F;
   private static final float field02861 = 8.0F;
   private static final String field02862 = "пусто";
   private static final float field02863 = 302.0F;
   private static final float field02864 = 10.0F;
   private static final float field02865 = 5.5F;
   private static final float field02866 = 2.5F;
   private static final float field02867 = 0.8F;
   private static final float field02868 = 5.5F;
   private static final float field02869 = 18.0F;
   private static final float field02870 = 10.0F;
   private static final float field02871 = 282.0F;
   private static final float field02872 = 10.0F;
   private static final float field02873 = 137.0F;
   private static final float field02874 = 10.0F;
   private static final float field02875 = 8.0F;
   private static final String field02876 = "f:name";
   private static final float field02877 = 22.0F;
   private static final String field02878 = "f:address";
   private static final String field02879 = "f:ping";
   private static final float field02880 = 22.0F;
   private static final String field02881 = "f:user";
   private static final String field02882 = "f:pass";
   private static final float field02883 = 27.0F;
   private static final float field02884 = 19.0F;
   private static final float field02885 = 282.0F;
   private static final float field02886 = 23.0F;
   private static final float field02887 = 0.9F;
   private static final float field02888 = 5.5F;
   private static final float field02889 = 20.0F;
   private static final float field02890 = 3.75F;
   private static final float field02891 = 0.3F;
   private static final String field02892 = "Прокси нет — заполни поля ниже и нажми «Добавить»";
   private static final float field02893 = 8.0F;
   private static final float field02894 = 10.0F;
   private static final float field02895 = 5.5F;
   private static final float field02896 = 0.75F;
   private static final float field02897 = 5.5F;
   private static final float field02898 = 24.0F;
   private static final float field02899 = 20.0F;
   private static final float field02900 = 4.0F;
   private static final float field02901 = 24.0F;
   private static final float field02902 = 20.0F;
   private static final float field02903 = 24.0F;
   private static final float field02904 = 24.0F;
   private static final float field02905 = 0.5F;
   private static final float field02906 = 20.0F;
   private static final float field02907 = 0.5F;
   private static final float field02908 = 20.0F;
   private static final float field02909 = 0.35F;
   private static final float field02910 = 0.3F;
   private static final float field02911 = 20.0F;
   private static final float field02912 = 3.75F;
   private static final float field02913 = 0.55F;
   private static final float field02914 = 0.6F;
   private static final float field02915 = 8.0F;
   private static final float field02916 = 10.0F;
   private static final float field02917 = 2.2F;
   private static final float field02918 = 0.5F;
   private static final float field02919 = 0.5F;
   private static final float field02920 = 10.0F;
   private static final float field02921 = 6.5F;
   private static final float field02922 = 14.0F;
   private static final float field02923 = 0.92F;
   private static final float field02924 = 6.5F;
   private static final float field02925 = 14.0F;
   private static final float field02926 = 6.5F;
   private static final float field02927 = 6.0F;
   private static final String field02928 = "  ·  авторизация";
   private static final float field02929 = 10.0F;
   private static final float field02930 = 5.5F;
   private static final float field02931 = 0.8F;
   private static final float field02932 = 5.5F;
   private static final float field02933 = 6.0F;
   private static final float field02934 = 13.0F;
   private static final float field02935 = 10.0F;
   private static final float field02936 = 6.5F;
   private static final float field02937 = 13.0F;
   private static final float field02938 = 13.0F;
   private static final float field02939 = 1.625F;
   private static final float field02940 = 0.55F;
   private static final float field02941 = 0.75F;
   private static final String field02942 = "X";
   private static final float field02943 = 5.5F;
   private static final float field02944 = 5.5F;
   private static final float field02945 = 13.0F;
   private static final float field02946 = 10.0F;
   private static final float field02947 = 20.0F;
   private static final float field02948 = 17.0F;
   private static final float field02949 = 3.75F;
   private static final float field02950 = 0.35F;
   private static final float field02951 = 0.6F;
   private static final float field02952 = 17.0F;
   private static final float field02953 = 17.0F;
   private static final String field02954 = "type";
   private static final float field02955 = 17.0F;
   private static final float field02956 = 3.75F;
   private static final float field02957 = 0.35F;
   private static final float field02958 = 0.35F;
   private static final float field02959 = 8.5F;
   private static final float field02960 = 6.5F;
   private static final float field02961 = 6.5F;
   private static final float field02962 = 18.0F;
   private static final float field02963 = 9.0F;
   private static final float field02964 = 6.0F;
   private static final float field02965 = 90.0F;
   private static final float field02966 = 11.0F;
   private static final String field02967 = "toggle";
   private static final String field02968 = "toggle:on";
   private static final float field02969 = 0.6F;
   private static final float field02970 = 0.15F;
   private static final float field02971 = 0.85F;
   private static final float field02972 = 4.5F;
   private static final float field02973 = 9.0F;
   private static final float field02974 = 6.0F;
   private static final float field02975 = 0.95F;
   private static final String field02976 = "Включить прокси";
   private static final float field02977 = 6.0F;
   private static final float field02978 = 6.0F;
   private static final float field02979 = 0.95F;
   private static final float field02980 = 0.95F;
   private static final float field02981 = 6.0F;
   private static final String field02982 = "Добавить";
   private static final String field02983 = "Сохранить";
   private static final float field02984 = 6.0F;
   private static final float field02985 = 3.0F;
   private static final float field02986 = 4.0F;
   private static final String field02987 = "b:submit";
   private static final String field02988 = "b:new";
   private static final String field02989 = "Новая";
   private static final String field02990 = "b:ping";
   private static final String field02991 = "Проверить";
   private static final String field02992 = "b:back";
   private static final String field02993 = "Назад";
   private static final float field02994 = 3.0F;
   private static final float field02995 = 15.0F;
   private static final float field02996 = 15.0F;
   private static final float field02997 = 15.0F;
   private static final float field02998 = 3.0F;
   private static final float field02999 = 15.0F;
   private static final float field03000 = 15.0F;
   private static final float field03001 = 0.4F;
   private static final float field03002 = 0.55F;
   private static final float field03003 = 0.7F;
   private static final float field03004 = 0.85F;
   private static final float field03005 = 15.0F;
   private static final float field03006 = 1.625F;
   private static final float field03007 = 7.5F;
   private static final float field03008 = 6.0F;
   private static final float field03009 = 0.95F;
   private static final float field03010 = 6.0F;
   private static final String field03011 = "Неверный IP:PORT";
   private static final String field03012 = "Не удалось добавить прокси";
   private static final String field03013 = "Сначала выбери прокси в списке";
   private static final String field03014 = "Неверный IP:PORT";
   private static final String field03015 = "mc.funtime.su";
   private static final String field03016 = "Неверный адрес пинга";
   private static final long field03017 = 170L;
   private static final long field03018 = 110L;

   @Override
   public void tick() {
      this.field02810.method04803();
   }

   private static void refreshMenuButton() {
      if (field02808 != null) {
         field02808.setMessage(menuButtonText());
      }
   }

   private void drawToggle(GuiGraphics var1, float var2, float var3, float var4, float var5) {
      ProxyManager var6 = ProxyManager.INSTANCE;
      boolean var7 = var6.method05240();
      float var8 = field02962;
      float var9 = field02963;
      ProxyScreen.Nested39 var10 = new ProxyScreen.Nested39(var4, var5, var8 + field02964 + field02965, field02966);
      float var11 = this.ease(field02967, var10.has(var2, var3));
      float var12 = this.state(field02968, var7);
      RoundedRectRenderer.method01272(
         var1,
         var4,
         var5 + 1.0F,
         var8,
         var9,
         var9 / 2.0F,
         1.0F,
         mix(this.col(inactiveField(), field02969 + field02970 * var11), this.col(switcher(), field02971), var12)
      );
      RoundedRectRenderer.method01274(var1, var4 + field02972 + var12 * (var8 - field02973), var5 + 1.0F + var9 / 2.0F, field02974, this.col(text(), field02975));
      FontRenderer var13 = Fonts.field00110;
      var13.method09480(
         var1,
         field02976,
         var4 + var8 + field02977,
         var5 + 1.0F + var9 / 2.0F - var13.method09485(field02978) / 2.0F,
         mix(this.col(inactiveText(), field02979), this.col(text(), field02980), var12),
         field02981
      );
      this.push(var10, this::toggleEnabled);
   }

   private float state(Object var1, boolean var2) {
      AnimationUtils var3 = this.field02812.computeIfAbsent(var1, var0 -> new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_EXPO, field03017));
      var3.method03375(var2 ? 1.0 : 0.0);
      return var3.method03377();
   }

   private void push(ProxyScreen.Nested39 var1, Runnable var2) {
      this.field02815.add(var1);
      this.field02816.add(var2);
   }

   private void select(String var1) {
      ProxyConfig var2 = ProxyManager.INSTANCE.method05225(var1);
      if (var2 != null) {
         ProxyManager.INSTANCE.method05226(var1);
         this.field02823 = var1;
         this.field02817.method06675(var2.method03916());
         this.field02818.method06675(var2.method03902());
         this.field02819.method06675(var2.method03899());
         this.field02820.method06675(var2.method03915());
         this.field02822 = var2.method03901();
         this.setMessage("", false);
         refreshMenuButton();
      }
   }

   private TextInputWidget[] fields() {
      return new TextInputWidget[]{this.field02817, this.field02818, this.field02819, this.field02820, this.field02821};
   }

   private void drawTypeChip(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6) {
      ProxyScreen.Nested39 var7 = new ProxyScreen.Nested39(var4, var5, var6, field02953);
      float var8 = this.ease(field02954, var7.has(var2, var3));
      RoundedRectRenderer.method01272(
         var1, var4, var5, var6, field02955, field02956, 1.0F, mix(this.col(inactiveField(), field02957), this.col(switcher(), field02958), var8)
      );
      FontRenderer var9 = Fonts.field00110;
      var9.method09473(
         var1, this.field02822.method03921(), var4 + var6 / 2.0F, var5 + field02959 - var9.method09485(field02960) / 2.0F, this.col(text(), 1.0F), field02961
      );
      this.push(var7, () -> this.field02822 = this.field02822.method03920());
   }

   private ProxyConfig buildEntry() {
      return ProxyConfig.method03905(
         this.field02817.method06672(), this.field02818.method06672(), this.field02822, this.field02819.method06672(), this.field02820.method06672()
      );
   }

   private void drawRow(GuiGraphics var1, float var2, float var3, ProxyConfig var4, float var5, float var6, float var7, boolean var8) {
      FontRenderer var9 = Fonts.field00110;
      boolean var10 = var4.method03913().equals(this.field02823);
      float var11 = this.state("active:" + var4.method03913(), ProxyManager.INSTANCE.method05229(var4.method03913()));
      float var12 = this.ease("row:" + var4.method03913(), var8 && GuiHitTestUtils.method05625(var2, var3, var5, var6, var7, field02908));
      int var13 = mix(this.col(inactiveField(), field02909), this.col(switcher(), field02910), var11);
      RoundedRectRenderer.method01272(var1, var5, var6, var7, field02911, field02912, 1.0F, mix(var13, this.col(field(), field02913), var12 * field02914));
      RoundedRectRenderer.method01274(
         var1,
         var5 + field02915,
         var6 + field02916,
         field02917 + field02918 * var11,
         mix(this.col(inactiveText(), field02919), this.col(switcher(), 1.0F), var11)
      );
      String var14 = var4.method03914();
      float var15 = var6 + field02920 - var9.method09485(field02921) / 2.0F;
      var9.method09480(var1, var14, var5 + field02922, var15, this.col(text(), var10 ? 1.0F : field02923), field02924);
      float var16 = var5 + field02925 + var9.method09486(var14, field02926) + field02927;
      String var17 = var4.method03902() + "  ·  " + var4.method03901().method03921() + (var4.method03918() ? field02928 : "");
      var9.method09480(var1, var17, var16, var6 + field02929 - var9.method09485(field02930) / 2.0F, this.col(inactiveText(), field02931), field02932);
      ProxyScreen.Nested39 var18 = new ProxyScreen.Nested39(
         var5 + var7 - field02933 - field02934, var6 + field02935 - field02936, field02937, field02938
      );
      float var19 = this.ease("del:" + var4.method03913(), var8 && var18.has(var2, var3));
      RoundedRectRenderer.method01272(
         var1,
         var18.field03019(),
         var18.field03020(),
         var18.field03021(),
         var18.field03022(),
         field02939,
         1.0F,
         mix(this.col(inactiveField(), field02940), this.col(field02807, field02941), var19)
      );
      Fonts.field00109
         .method09473(
            var1,
            field02942,
            var18.field03019() + var18.field03021() / 2.0F,
            var18.field03020() + var18.field03022() / 2.0F - Fonts.field00109.method09485(field02943) / 2.0F,
            this.col(mix(inactiveText(), text(), var19), 1.0F),
            field02944
         );
      if (var8) {
         this.push(var18, () -> this.delete(var4.method03913()));
         this.push(new ProxyScreen.Nested39(var5, var6, var7 - field02945 - field02946, field02947), () -> this.select(var4.method03913()));
      }
   }

   private static int inactiveText() {
      return theme().field22110.method11676();
   }

   private void blurFields() {
      for (TextInputWidget var4 : this.fields()) {
         var4.method06722();
      }
   }

   private void testPing() {
      ProxyConfig var1 = this.buildEntry();
      if (var1 == null) {
         this.setMessage(field03014, true);
      } else {
         String var2 = this.field02821.method06672();
         if (var2.isEmpty()) {
            var2 = field03015;
            this.field02821.method06675(var2);
         }

         int var3 = var2.lastIndexOf(58);
         String var4 = var3 > 0 ? var2.substring(0, var3) : var2;
         int var5 = var3 > 0 ? ProxyConfig.method03911(var2.substring(var3 + 1)) : 25565;
         if (!var4.isEmpty() && var5 > 0) {
            this.field02824 = "";
            this.field02825 = false;
            this.field02810.method04805(var4, var5, var1);
         } else {
            this.setMessage(field03016, true);
         }
      }
   }

   private static int softField() {
      return ColorUtils.method04583(field(), ColorUtils.field10170, field02839);
   }

   private int col(int var1, float var2) {
      return ColorUtils.method04611(var1, var2 * this.field02827);
   }

   private static int switcher() {
      return theme().field22113.method11676();
   }

   @Override
   public boolean mouseClicked(MouseButtonEvent var1, boolean var2) {
      if (InputCompat.glfwButton(var1.button()) != 0) {
         return super.mouseClicked(var1, var2);
      }

      Vec2 var3 = GuiScaleUtils.method06746(var1.x(), var1.y());
      float var4 = var3.x;
      float var5 = var3.y;
      boolean var6 = false;

      for (TextInputWidget var10 : this.fields()) {
         var6 |= var10.method06703(var4, var5, InputCompat.glfwButton(var1.button()));
      }

      if (var6) {
         return true;
      }

      this.blurFields();

      for (int var11 = this.field02815.size() - 1; var11 >= 0; var11--) {
         if (this.field02815.get(var11).has(var4, var5)) {
            this.field02816.get(var11).run();
            return true;
         }
      }

      return super.mouseClicked(var1, var2);
   }

   private void drawList(GuiGraphics var1, float var2, float var3, List<ProxyConfig> var4, float var5, float var6, float var7, int var8) {
      FontRenderer var9 = Fonts.field00110;
      if (var4.isEmpty()) {
         RoundedRectRenderer.method01272(var1, var5, var6, var7, field02889, field02890, 1.0F, this.col(inactiveField(), field02891));
         String var15 = field02892;
         var9.method09480(
            var1, var15, var5 + field02893, var6 + field02894 - var9.method09485(field02895) / 2.0F, this.col(inactiveText(), field02896), field02897
         );
      } else {
         this.field02826 = Math.max(0, Math.min(this.field02826, var4.size() - var8));
         this.field02814.method03375(this.field02826 * field02898);
         float var10 = this.field02814.method03377();
         float var11 = var8 * field02899 + Math.max(0, var8 - 1) * field02900;
         var1.enableScissor((int)var5, (int)var6, (int)(var5 + var7), (int)(var6 + var11));

         for (int var12 = 0; var12 < var4.size(); var12++) {
            float var13 = var6 + var12 * field02901 - var10;
            if (!(var13 + field02902 < var6 - field02903) && !(var13 > var6 + var11 + field02904)) {
               boolean var14 = var13 >= var6 - field02905 && var13 + field02906 <= var6 + var11 + field02907;
               this.drawRow(var1, var2, var3, (ProxyConfig)var4.get(var12), var5, var13, var7, var14);
            }
         }

         var1.disableScissor();
      }
   }

   private static TextInputWidget field(String var0, int var1) {
      TextInputWidget var2 = new TextInputWidget().method06678(Fonts.field00110, field02836);
      var2.method06717(var0);
      var2.method06669(var1);
      var2.method06734(field02837);
      return var2;
   }

   @Override
   public void extractRenderState(GuiGraphics var1, int var2, int var3, float var4) {
      super.extractRenderState(var1, var2, var3, var4);
      this.field02815.clear();
      this.field02816.clear();
      GuiScaleUtils.method06750(var1);
      this.field02813.method03375(1.0);
      this.field02827 = GuiHitTestUtils.method05615(0.0F, 1.0F, this.field02813.method03377());
      float var5 = GuiScaleUtils.method06752(var2);
      float var6 = GuiScaleUtils.method06749(var3);
      var var7 = ProxyManager.INSTANCE.method05237();
      int var8 = Math.min(5, Math.max(var7.size(), 1));
      float var9 = var8 * field02840 + Math.max(0, var8 - 1) * field02841;
      float var10 = field02842
         + var9
         + field02843
         + field02844
         + field02845
         + field02846
         + field02847
         + field02848
         + field02849
         + field02850
         + field02851
         + field02852;
      float var11 = (GuiScaleUtils.method06753() - field02853) / 2.0F;
      float var12 = (GuiScaleUtils.method06754() - var10) / 2.0F + field02854 * (1.0F - this.field02827);
      RoundedRectRenderer.method01272(var1, var11, var12, field02855, var10, field02856, 1.0F, this.col(softField(), field02857));
      FontRenderer var13 = Fonts.field00110;
      float var14 = var12 + field02858;
      var13.method09480(var1, field02859, var11 + field02860, var14, this.col(text(), 1.0F), field02861);
      String var15 = var7.isEmpty() ? field02862 : var7.size() + " шт.";
      var13.method09480(
         var1,
         var15,
         var11 + field02863 - field02864 - var13.method09486(var15, field02865),
         var14 + field02866,
         this.col(inactiveText(), field02867),
         field02868
      );
      var14 += field02869;
      this.drawList(var1, var5, var6, var7, var11 + field02870, var14, field02871, var8);
      var14 += var9 + field02872;
      float var16 = field02873;
      float var17 = var11 + field02874;
      float var18 = var17 + var16 + field02875;
      this.drawField(var1, var5, field02876, this.field02817, var17, var14, var16);
      this.drawTypeChip(var1, var5, var6, var18, var14, var16);
      var14 += field02877;
      this.drawField(var1, var5, field02878, this.field02818, var17, var14, var16);
      this.drawField(var1, var5, field02879, this.field02821, var18, var14, var16);
      var14 += field02880;
      this.drawField(var1, var5, field02881, this.field02819, var17, var14, var16);
      this.drawField(var1, var5, field02882, this.field02820, var18, var14, var16);
      var14 += field02883;
      this.drawToggle(var1, var5, var6, var17, var14);
      var14 += field02884;
      this.drawButtons(var1, var5, var6, var17, var14, field02885);
      var14 += field02886;
      String var19 = this.field02810.method04800().isEmpty() ? this.field02824 : this.field02810.method04800();
      if (!var19.isEmpty()) {
         int var20 = this.field02810.method04800().isEmpty() && this.field02825 ? field02807 : inactiveText();
         var13.method09480(var1, var19, var17, var14, this.col(var20, field02887), field02888);
      }

      GuiScaleUtils.method06748(var1);
   }

   private float ease(Object var1, boolean var2) {
      AnimationUtils var3 = this.field02811.computeIfAbsent(var1, var0 -> new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field03018));
      var3.method03375(var2 ? 1.0 : 0.0);
      return var3.method03377();
   }

   private static int text() {
      return theme().field22109.method11676();
   }

   private static int mix(int var0, int var1, float var2) {
      return ColorUtils.method04631(var0, var1, var2);
   }

   private void drawField(GuiGraphics var1, float var2, String var3, TextInputWidget var4, float var5, float var6, float var7) {
      float var8 = this.ease(var3, var4.method06726());
      RoundedRectRenderer.method01272(
         var1, var5, var6, var7, field02948, field02949, 1.0F, mix(this.col(inactiveField(), field02950), this.col(field(), field02951), var8)
      );
      var4.method06700(var5, var6, var7, field02952).method06670(var1, var2, this.field02827);
   }

   @Override
   public boolean mouseScrolled(double var1, double var3, double var5, double var7) {
      int var9 = ProxyManager.INSTANCE.method05237().size();
      if (var9 > 5) {
         this.field02826 = Math.max(0, Math.min(this.field02826 - (int)Math.signum(var7), var9 - 5));
         return true;
      } else {
         return super.mouseScrolled(var1, var3, var5, var7);
      }
   }

   private void delete(String var1) {
      ProxyManager.INSTANCE.method05224(var1);
      if (var1.equals(this.field02823)) {
         this.resetEditor();
      }

      refreshMenuButton();
   }

   private static ThemeSettings theme() {
      return ThemeManager.INSTANCE.method09611();
   }

   @Override
   public boolean mouseReleased(MouseButtonEvent var1) {
      Vec2 var2 = GuiScaleUtils.method06746(var1.x(), var1.y());

      for (TextInputWidget var6 : this.fields()) {
         var6.method06673(var2.x, var2.y, InputCompat.glfwButton(var1.button()));
      }

      return super.mouseReleased(var1);
   }

   private void submit() {
      ProxyConfig var1 = this.buildEntry();
      if (var1 == null) {
         this.setMessage(field03011, true);
      } else {
         ProxyConfig var2 = ProxyManager.INSTANCE.method05225(this.field02823);
         if (var2 == null) {
            ProxyConfig var3 = ProxyManager.INSTANCE.method05222(var1);
            if (var3 == null) {
               this.setMessage(field03012, true);
               return;
            }

            this.field02823 = var3.method03913();
            this.setMessage("Добавлено: " + var3.method03914(), false);
         } else {
            var2.method03910(this.field02817.method06672());
            var2.method03900(var1.method03904());
            var2.method03919(var1.method03912());
            var2.method03909(this.field02822);
            var2.method03903(this.field02819.method06672());
            var2.method03906(this.field02820.method06672());
            ProxyManager.INSTANCE.method05234();
            this.setMessage("Сохранено: " + var2.method03914(), false);
         }

         this.blurFields();
         refreshMenuButton();
      }
   }

   private void toggleEnabled() {
      ProxyManager var1 = ProxyManager.INSTANCE;
      boolean var2 = !var1.method05240();
      if (var2 && var1.method05227() == null) {
         this.setMessage(field03013, true);
      } else {
         var1.method05243(var2);
         var1.method05234();
         this.setMessage("", false);
         refreshMenuButton();
      }
   }

   private void resetEditor() {
      this.field02823 = "";

      for (TextInputWidget var4 : this.fields()) {
         if (var4 != this.field02821) {
            var4.method06692();
         }
      }

      this.field02822 = ProxyConfig.Nested114.SOCKS5;
      this.blurFields();
      this.setMessage("", false);
   }

   @Override
   public boolean charTyped(CharacterEvent var1) {
      boolean var2 = false;

      for (TextInputWidget var6 : this.fields()) {
         var2 |= var6.method06730((char)var1.codepoint());
      }

      return var2 || super.charTyped(var1);
   }

   private void drawButtons(GuiGraphics var1, float var2, float var3, float var4, float var5, float var6) {
      String var7 = this.field02823.isEmpty() ? field02982 : field02983;
      float var8 = field02984;
      float var9 = (var6 - var8 * field02985) / field02986;
      this.chip(var1, var2, var3, field02987, var7, var4, var5, var9, true);
      this.chip(var1, var2, var3, field02988, field02989, var4 + (var9 + var8), var5, var9, false);
      this.chip(var1, var2, var3, field02990, field02991, var4 + (var9 + var8) * 2.0F, var5, var9, false);
      this.chip(var1, var2, var3, field02992, field02993, var4 + (var9 + var8) * field02994, var5, var9, false);
      this.push(new ProxyScreen.Nested39(var4, var5, var9, field02995), this::submit);
      this.push(new ProxyScreen.Nested39(var4 + (var9 + var8), var5, var9, field02996), this::resetEditor);
      this.push(new ProxyScreen.Nested39(var4 + (var9 + var8) * 2.0F, var5, var9, field02997), this::testPing);
      this.push(new ProxyScreen.Nested39(var4 + (var9 + var8) * field02998, var5, var9, field02999), this::onClose);
   }

   private static int field() {
      return theme().field22119.method11676();
   }

   public ProxyScreen(Screen var1) {
      super(Component.literal(field02828));
      this.field02813 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_EXPO, field02829);
      this.field02814 = new AnimationUtils(AnimationUtils.Nested95.EASE_OUT_CUBIC, field02830);
      this.field02815 = new ArrayList<>();
      this.field02816 = new ArrayList<>();
      this.field02817 = field(field02831, 32);
      this.field02818 = field(field02832, 64);
      this.field02819 = field(field02833, 64);
      this.field02820 = field(field02834, 64);
      this.field02821 = field(field02835, 64);
      this.field02822 = ProxyConfig.Nested114.SOCKS5;
      this.field02823 = "";
      this.field02824 = "";
      this.field02827 = 1.0F;
      this.field02809 = var1;
   }

   private void chip(GuiGraphics var1, float var2, float var3, String var4, String var5, float var6, float var7, float var8, boolean var9) {
      ProxyScreen.Nested39 var10 = new ProxyScreen.Nested39(var6, var7, var8, field03000);
      float var11 = this.ease(var4, var10.has(var2, var3));
      int var12 = var9 ? this.col(switcher(), field03001) : this.col(inactiveField(), field03002);
      int var13 = var9 ? this.col(switcher(), field03003) : this.col(inactiveField(), field03004);
      RoundedRectRenderer.method01272(var1, var6, var7, var8, field03005, field03006, 1.0F, mix(var12, var13, var11));
      FontRenderer var14 = Fonts.field00110;
      var14.method09473(var1, var5, var6 + var8 / 2.0F, var7 + field03007 - var14.method09485(field03008) / 2.0F, this.col(text(), field03009), field03010);
   }

   public static Component menuButtonText() {
      ProxyConfig var0 = ProxyManager.INSTANCE.method05228();
      return Component.literal(var0 == null ? field02838 : var0.method03914());
   }

   private static int inactiveField() {
      return theme().field22120.method11676();
   }

   private void setMessage(String var1, boolean var2) {
      this.field02824 = var1;
      this.field02825 = var2;
      this.field02810.method04808();
   }

   public static Button createMenuButton(Screen var0) {
      Button var1 = Button.builder(menuButtonText(), var1x -> mc.gui.setScreen(new ProxyScreen(var0))).bounds(5, 5, 120, 20).build();
      field02808 = var1;
      return var1;
   }

   @Override
   public boolean keyPressed(KeyEvent var1) {
      if (InputCompat.glfwKey(var1.key()) == 256) {
         this.onClose();
         return true;
      }

      boolean var2 = false;

      for (TextInputWidget var6 : this.fields()) {
         var2 |= var6.method06726();
      }

      if (!var2) {
         return super.keyPressed(var1);
      }

      for (TextInputWidget var10 : this.fields()) {
         var10.method06733(InputCompat.glfwKey(var1.key()));
      }

      return true;
   }

   @Override
   public void onClose() {
      refreshMenuButton();
      mc.gui.setScreen(this.field02809);
   }

   // $VF: Compiled from s
   private record Nested39(float field03019, float field03020, float field03021, float field03022) {
      boolean has(float var1, float var2) {
         return GuiHitTestUtils.method05625(var1, var2, this.field03019, this.field03020, this.field03021, this.field03022);
      }
   }
}
