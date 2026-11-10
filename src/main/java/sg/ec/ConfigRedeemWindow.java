// Original binary: sg/ec/RSnmVC6wNiu0Sy8E
package sg.ec;

import java.util.List;

// $VF: Compiled from s
public class ConfigRedeemWindow extends ConfigActionWindow {
   public static final String field11418 = "configs.redeem";
   public static final float field11419 = 0;
   public static final float field11420 = 0;
   private static final int field11421 = 0;
   private static final String field11422 = "field11422";
   private static final String field11423 = "field11423";
   private static final String field11424 = "field11424";
   private static final String field11425 = "field11425";
   private final TextInputWidget field11426;
   private final List<SettingsListWindow.Nested200> field11427;
   private static final String field11428 = "Активация ключа";
   private static final String field11429 = "configs.redeem";
   private static final float field11430 = 150.0F;
   private static final float field11431 = 70.0F;
   private static final String field11432 = "вставь купленный ключ";
   private static final String field11433 = "Ключ";
   private static final String field11434 = "Активировать";

   public ConfigRedeemWindow() {
      super(field11428, field11429, field11430, field11431);
      this.field11426 = this.method06849(field11432, 64, var1 -> this.method05272());
      this.field11426.method06716();
      this.field11427 = List.of(
         this.method06858(field11433, this.field11426), this.method06830(() -> field11434, () -> GuiThemeStyle.Nested40.NORMAL, this::method05272)
      );
   }

   @Override
   protected List<SettingsListWindow.Nested200> method04173() {
      return this.field11427;
   }

   private void method05272() {
      String var1 = this.field11426.method06672();
      if (!var1.isEmpty()) {
         GlobalRequestSender.method09378(var1x -> var1x.method01842(var1));
      }

      this.method09550();
   }
}
