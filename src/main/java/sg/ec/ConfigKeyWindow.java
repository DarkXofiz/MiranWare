// Original binary: sg/ec/uvnvWTu899VDTXr3
package sg.ec;

import java.util.List;

// $VF: Compiled from s
public class ConfigKeyWindow extends ConfigActionWindow {
   public static final String field24608 = "configs.key";
   public static final float field24609 = 0;
   public static final float field24610 = 0;
   private static final int field24611 = 0;
   private static final String field24612 = "field24612";
   private static final String field24613 = "field24613";
   private static final String field24614 = "field24614";
   private static final String field24615 = "field24615";
   private static final String field24616 = "field24616";
   private final String field24617;
   private final TextInputWidget field24618;
   private final List<SettingsListWindow.Nested200> field24619;
   private boolean field24620 = true;
   private static final String field24621 = "configs.key";
   private static final float field24622 = 140.0F;
   private static final float field24623 = 84.0F;
   private static final String field24624 = "всем";
   private static final String field24625 = "Кому";
   private static final String field24626 = "Без пересылки";
   private static final String field24627 = "Создать ключ";

   private void method10975() {
      String var1 = this.field24618.method06672();
      GlobalRequestSender.method09378(var2 -> var2.method01825(this.field24617, var1, this.field24620));
      this.method09550();
   }

   public ConfigKeyWindow(String var1) {
      super("Ключ · " + var1, field24621, field24622, field24623);
      this.field24617 = var1;
      this.field24618 = this.method06849(field24624, 24, var1x -> this.method10975());
      this.field24618.method06716();
      this.field24619 = List.of(
         this.method06858(field24625, this.field24618),
         this.method06850(field24626, () -> this.field24620, var1x -> this.field24620 = var1x),
         this.method06830(() -> field24627, () -> GuiThemeStyle.Nested40.NORMAL, this::method10975)
      );
   }

   @Override
   protected List<SettingsListWindow.Nested200> method04173() {
      return this.field24619;
   }
}
