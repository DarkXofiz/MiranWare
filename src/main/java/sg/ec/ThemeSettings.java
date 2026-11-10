// Original binary: sg/ec/oKne3C7r2yvRMI5N
package sg.ec;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public class ThemeSettings implements SettingsContainer {
   private final List<Setting<?>> field22101 = new ArrayList<>();
   private String field22102;
   private String field22103;
   public ColorSetting field22104;
   public ColorSetting field22105;
   public ColorSetting field22106;
   public ColorSetting field22107;
   public ColorSetting field22108;
   public ColorSetting field22109;
   public ColorSetting field22110;
   public ColorSetting field22111;
   public ColorSetting field22112;
   public ColorSetting field22113;
   public ColorSetting field22114;
   public ColorSetting field22115;
   public ColorSetting field22116;
   public ColorSetting field22117;
   public ColorSetting field22118;
   public ColorSetting field22119;
   public ColorSetting field22120;
   public ColorSetting field22121;
   public ColorSetting field22122;
   public ColorSetting field22123;
   public ColorSetting field22124;
   public ColorSetting field22125;
   public ColorSetting field22126;
   private static final String field22127 = "1 цвет";
   private static final String field22128 = "2 цвет";
   private static final String field22129 = "Фон худа";
   private static final String field22130 = "Текст худа";
   private static final String field22131 = "Текст заголовков";
   private static final String field22132 = "Текст";
   private static final String field22133 = "Неактивный текст";
   private static final String field22134 = "Слайдер";
   private static final String field22135 = "Круг слайдера";
   private static final String field22136 = "Переключатель";
   private static final String field22137 = "Неактивный переключатель";
   private static final String field22138 = "Кнопка";
   private static final String field22139 = "Неактивная кнопка";
   private static final String field22140 = "Обводка";
   private static final String field22141 = "Разделитель";
   private static final String field22142 = "Поле";
   private static final String field22143 = "Неактивное поле";
   private static final String field22144 = "Фон окон";
   private static final String field22145 = "Основной";
   private static final String field22146 = "Окно слайдера";
   private static final String field22147 = "Скролл бар";
   private static final String field22148 = "Лого";
   private static final String field22149 = "Фон в подсказках";

   public ColorSetting method09794() {
      return this.field22119;
   }

   @Override
   public List<Setting<?>> method03026() {
      return this.field22101;
   }

   public ColorSetting method09795() {
      return this.field22106;
   }

   public ColorSetting method09796() {
      return this.field22124;
   }

   public ColorSetting method09797() {
      return this.field22109;
   }

   public ColorSetting method09798() {
      return this.field22123;
   }

   public ColorSetting method09799() {
      return this.field22121;
   }

   public int method09800() {
      return this.field22104.method11676();
   }

   public ColorSetting method09801() {
      return this.field22113;
   }

   public ColorSetting method09802() {
      return this.field22118;
   }

   public ColorSetting method09803() {
      return this.field22104;
   }

   public ColorSetting method09804() {
      return this.field22116;
   }

   public ColorSetting method09805() {
      return this.field22108;
   }

   public void method09806(ColorSetting var1, int var2) {
   }

   private ColorSetting method09807(String var1, int var2, int var3, int var4, int var5) {
      ColorSetting var6 = new ColorSetting(var1)
         .method03017(new Color(ColorUtils.method04592(var2, var3, var4, var5), true))
         .method03023(this);
      Color var7 = var6.method03022();
      if (var7 != null) {
         var6.method11672(var7);
      }

      return var6;
   }

   private ColorSetting method09808(String var1, int var2, int var3, int var4) {
      ColorSetting var5 = new ColorSetting(var1).method03017(method09813(var2, var3, var4)).method03023(this);
      Color var6 = var5.method03022();
      if (var6 != null) {
         var5.method11672(var6);
      }

      return var5;
   }

   public int method09809() {
      return this.field22105.method11676();
   }

   public ColorSetting method09810() {
      return this.field22114;
   }

   public ColorSetting method09811() {
      return this.field22107;
   }

   public ColorSetting method09812() {
      return this.field22115;
   }

   private static Color method09813(int var0, int var1, int var2) {
      return new Color(ColorUtils.method04592(var0, var1, var2, 255), true);
   }

   public ColorSetting method09814() {
      return this.field22125;
   }

   public String method09815() {
      return this.field22102;
   }

   public ColorSetting method09816() {
      return this.field22122;
   }

   public String method09817() {
      return this.field22103;
   }

   public ThemeSettings(String var1) {
      this.field22104 = this.method09808(field22127, 144, 85, 237);
      this.field22105 = this.method09808(field22128, 144, 85, 237);
      this.field22106 = this.method09808(field22129, 15, 15, 15);
      this.field22107 = this.method09808(field22130, 255, 255, 255);
      this.field22108 = this.method09808(field22131, 88, 78, 110);
      this.field22109 = this.method09808(field22132, 88, 78, 110);
      this.field22110 = this.method09808(field22133, 108, 107, 112);
      this.field22111 = this.method09808(field22134, 119, 95, 168);
      this.field22112 = this.method09808(field22135, 200, 200, 200);
      this.field22113 = this.method09808(field22136, 119, 95, 168);
      this.field22114 = this.method09808(field22137, 40, 35, 53);
      this.field22115 = this.method09808(field22138, 70, 70, 70);
      this.field22116 = this.method09808(field22139, 90, 90, 90);
      this.field22117 = this.method09808(field22140, 20, 19, 24);
      this.field22118 = this.method09808(field22141, 180, 180, 180);
      this.field22119 = this.method09808(field22142, 56, 44, 79);
      this.field22120 = this.method09808(field22143, 29, 25, 38);
      this.field22121 = this.method09808(field22144, 56, 44, 79);
      this.field22122 = this.method09807(field22145, 19, 12, 25, 225);
      this.field22123 = this.method09807(field22146, 118, 76, 153, 255);
      this.field22124 = this.method09807(field22147, 179, 126, 253, 30);
      this.field22125 = this.method09807(field22148, 198, 133, 255, 255);
      this.field22126 = this.method09807(field22149, 19, 12, 25, 225);
      this.field22103 = ProfileAPI.get().getModel().getName();
      this.field22102 = var1;
   }

   public ColorSetting method09818() {
      return this.field22120;
   }

   public ColorSetting method09819() {
      return this.field22111;
   }

   public ColorSetting method09820() {
      return this.field22105;
   }

   public ColorSetting method09821() {
      return this.field22117;
   }

   public ColorSetting method09822() {
      return this.field22112;
   }

   public ColorSetting method09823() {
      return this.field22126;
   }

   public ColorSetting method09824() {
      return this.field22110;
   }

   public void method09825(String var1) {
      this.field22102 = var1;
   }

   public void method09826(String var1) {
      this.field22103 = var1;
   }
}
