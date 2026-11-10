// Original binary: sg/ec/KAdVE5lN0MWoGjVf
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class AutoBuySettingsWindow extends SettingsListWindow {
   public static final String field09370 = "autobuy.settings";
   public static final float field09371 = 0;
   private static final float field09372 = 0;
   private static final float field09373 = 0;
   private static final int field09374 = 0;
   private static final int field09375 = 0;
   private static final int field09376 = 0;
   private static final float field09377 = 0;
   private static final String field09378 = "field09378";
   private static final String field09379 = "field09379";
   private static final String field09380 = "field09380";
   private static final String field09381 = "field09381";
   private static final String field09382 = "field09382";
   private static final String field09383 = "field09383";
   private static final String field09384 = "field09384";
   private static final String field09385 = "field09385";
   private final AutoBuyScreen field09386;
   private final List<SettingsListWindow.Nested200> field09387;
   private static final String field09388 = "autobuy.settings";
   private static final float field09389 = 150.0F;
   private static final float field09390 = 258.0F;
   private static final String field09391 = "Скупка";
   private static final String field09392 = "Сервер";
   private static final String field09393 = "Задержка действий, мс";
   private static final String field09394 = "Лимит тотемов (0 — выкл)";
   private static final String field09395 = "Команда аукциона";
   private static final String field09396 = "Режим торговли";
   private static final String field09397 = "Человеческий разброс";
   private static final String field09398 = "Синхронизация с тиком";
   private static final String field09399 = "Причины пропуска в чат";
   private static final String field09400 = "Панель поверх аукциона";
   private static final String field09401 = "Пить зелья невидимости";
   private static final String field09402 = "Окуп";
   private static final String field09403 = "Брать только дешевле рынка";
   private static final String field09404 = "Минимальная скидка, %";
   private static final String field09405 = "Подбор цен";
   private static final String field09406 = "Наценка к минимуму, %";
   private static final String field09407 = "Интервал разведки ботов, мин";
   private static final String field09408 = "Отладочный журнал";
   private static final String field09409 = "Перепродажа";
   private static final String field09410 = "Продавать купленное";
   private static final String field09411 = "Перевыставлять лоты";
   private static final String field09412 = "Надбавка к рынку, %";
   private static final String field09413 = "Анти-афк";
   private static final String field09414 = "Прокрут на месте";
   private static final String field09415 = "Команда";
   private static final String field09416 = "Интервал, мин";
   private static final String field09417 = "Чёрный список продавцов";
   private static final String field09418 = "ник и Enter";
   private static final String field09419 = "autobuy.log";
   private static final float field09420 = 180.0F;
   private static final float field09421 = 6.0F;
   private static final float field09422 = 180.0F;
   private static final float field09423 = 14.0F;
   private static final String field09424 = "Журнал покупок";
   private static final String field09425 = "Добавить предмет из руки";
   private static final String field09426 = "Остановить подбор";
   private static final String field09427 = "Спарсить цены";
   private static final String field09428 = "Остановить AutoBuy";
   private static final String field09429 = "Запустить AutoBuy";

   private void method04157(TextInputWidget var1) {
      String var2 = var1.method06672();
      var1.method06702();
      if (BlockedSellerRegistry.field08823.method03972(var2)) {
         this.method04187();
      }
   }

   @Override
   public boolean method01698() {
      return true;
   }

   private static void method04167() {
      AutoBuySettings.Nested239[] var0 = AutoBuySettings.Nested239.values();
      AutoBuySettings.field19624.method08582(var0[(AutoBuySettings.field19624.method08576().ordinal() + 1) % var0.length]);
   }

   private void method04172() {
      FloatingWindow var1 = this.method09580().method09669(field09419);
      if (var1 != null) {
         var1.method09572(true);
      } else {
         float var2 = Mth.clamp(this.method09576() - field09420 - field09421, 0.0F, GuiScaleUtils.method06753() - field09422);
         this.method09580().method09652(new AutoBuyLogWindow(), var2, this.method09560() + field09423);
      }
   }

   @Override
   protected List<SettingsListWindow.Nested200> method04173() {
      return this.field09387;
   }

   private List<SettingsListWindow.Nested200> method04177() {
      AutoBuySettings var1 = AutoBuySettings.field19624;
      AutoBuyManager var2 = AutoBuyManager.INSTANCE;
      ArrayList var3 = new ArrayList();
      var3.add(
         this.method06830(
            () -> var2.method09776() ? field09428 : field09429,
            () -> var2.method09776() ? GuiThemeStyle.Nested40.DANGER : GuiThemeStyle.Nested40.NORMAL,
            var2::method09761
         )
      );
      var3.add(
         this.method06830(
            () -> var1.method08579() ? field09426 : field09427,
            () -> var1.method08579() ? GuiThemeStyle.Nested40.DANGER : GuiThemeStyle.Nested40.NORMAL,
            () -> var2.method09757(!var1.method08579())
         )
      );
      var3.add(this.method06830(() -> field09425, () -> GuiThemeStyle.Nested40.NORMAL, this.field09386::method01735));
      var3.add(this.method06830(() -> field09424, () -> GuiThemeStyle.Nested40.NORMAL, this::method04172));
      var3.add(this.method06826(field09391));
      var3.add(
         this.method06821(
            field09392, method04196(), () -> AutoBuyItemRegistry.INSTANCE.method10998().ordinal(), var1x -> var2.method09763(AutoBuyServer.values()[var1x])
         )
      );
      var3.add(this.method06837(field09393, () -> String.valueOf(var1.method08559()), var1x -> var1.method08562(Integer.parseInt(var1x)), 8));
      var3.add(this.method06837(field09394, () -> String.valueOf(var1.method08554()), var1x -> var1.method08555(Integer.parseInt(var1x)), 8));
      var3.add(this.method06837(field09395, var1::method08556, var1::method08550, 48));
      var3.add(this.method06851(field09396, () -> var1.method08576().field19664, AutoBuySettingsWindow::method04167));
      var3.add(this.method06850(field09397, var1::method08541, var1::method08543));
      var3.add(this.method06850(field09398, var1::method08569, var1::method08567));
      var3.add(this.method06850(field09399, var1::method08580, var1::method08546));
      var3.add(this.method06850(field09400, var1::method08558, var1::method08561));
      var3.add(this.method06850(field09401, var1::method08551, var1::method08578));
      var3.add(this.method06826(field09402));
      var3.add(this.method06850(field09403, var1::method08552, var1::method08566));
      var3.add(this.method06837(field09404, () -> method06852(var1.method08538()), var1x -> var1.method08564(Float.parseFloat(var1x)), 8));
      var3.add(this.method06826(field09405));
      var3.add(this.method06837(field09406, () -> method06852(var1.method08574()), var1x -> var1.method08545(Float.parseFloat(var1x)), 8));
      var3.add(this.method06837(field09407, () -> method06852(var1.method08553()), var1x -> var1.method08568(Float.parseFloat(var1x)), 8));
      var3.add(this.method06850(field09408, var1::method08573, var1::method08542));
      var3.add(this.method06826(field09409));
      var3.add(this.method06850(field09410, var1::method08557, var2::method09758));
      var3.add(this.method06850(field09411, var1::method08549, var1::method08571));
      var3.add(this.method06837(field09412, () -> method06852(var1.method08565()), var1x -> var1.method08583(Float.parseFloat(var1x)), 8));
      var3.add(this.method06826(field09413));
      var3.add(this.method06850(field09414, var1::method08577, var1::method08570));
      var3.add(this.method06837(field09415, var1::method08544, var1::method08560, 48));
      var3.add(this.method06837(field09416, () -> method06852(var1.method08537()), var1x -> var1.method08547(Float.parseFloat(var1x)), 8));
      var3.add(this.method06826(field09417));
      var3.add(this.method04181());
      return List.copyOf(var3);
   }

   private SettingsListWindow.Nested200 method04181() {
      final TextInputWidget var1 = this.method06849(field09418, 24, this::method04157);
      return new SettingsListWindow.Nested200()      // $VF: Compiled from s
 {
         private static final float field09432 = 17.0F;
         private static final float field09433 = 14.0F;
         private static final float field09434 = 13.0F;
         private static final float field09435 = 4.0F;
         private static final float field09436 = 10.0F;
         private static final float field09437 = 7.0F;
         private static final float field09438 = 5.0F;
         private static final float field09439 = 6.0F;
         private static final float field09440 = 10.0F;
         private static final float field09441 = 10.0F;
         private static final float field09442 = 14.0F;

         @Override
         public void method04198(float var1x) {
            AutoBuySettingsWindow.this.method06841(var1, var1x);
            float var2 = var1x + field09434 + field09435;

            for (String sx : BlockedSellerRegistry.field08823.method03971()) {
               float sxx = AutoBuySettingsWindow.this.method06833() + AutoBuySettingsWindow.this.method06856() - field09436;
               float sxxx = var2 + field09437 - field09438;
               AutoBuySettingsWindow.this.method06847(sxx, sxxx);
               AutoBuySettingsWindow.this.method06827(sx, var2, sxx - field09439);
               AutoBuySettingsWindow.this.field15370.method03442(sxx, sxxx, field09440, field09441, () -> AutoBuySettingsWindow.this.method04191(sx));
               var2 += field09442;
            }
         }

         @Override
         public float method04200() {
            return field09432 + BlockedSellerRegistry.field08823.method03971().size() * field09433;
         }
      };
   }

   public AutoBuySettingsWindow(AutoBuyScreen var1) {
      super(field09388, field09389, field09390);
      this.field09386 = var1;
      this.field09387 = this.method04177();
   }

   @Override
   protected void method04187() {
      AutoBuyItemRegistry.INSTANCE.method10994();
   }

   private void method04191(String var1) {
      if (BlockedSellerRegistry.field08823.method03974(var1)) {
         this.method04187();
      }
   }

   private static String[] method04196() {
      AutoBuyServer[] var0 = AutoBuyServer.values();
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2].method06430();
      }

      return var1;
   }
}
