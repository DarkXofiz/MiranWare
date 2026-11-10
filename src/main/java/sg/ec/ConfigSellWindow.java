// Original binary: sg/ec/eK7Svp9RuEaCI84O
package sg.ec;

import java.util.List;
import java.util.function.IntConsumer;

// $VF: Compiled from s
public class ConfigSellWindow extends ConfigActionWindow {
   public static final String field18521 = "configs.sell";
   public static final float field18522 = 0;
   public static final float field18523 = 0;
   public static final int field18524 = 0;
   public static final int field18525 = 0;
   private static final String field18526 = "field18526";
   private static final String field18527 = "field18527";
   private static final String field18528 = "field18528";
   private final IntConsumer field18529;
   private final List<SettingsListWindow.Nested200> field18530;
   private int field18531 = 1;
   private static final String field18532 = "configs.sell";
   private static final float field18533 = 148.0F;
   private static final float field18534 = 70.0F;
   private static final String field18535 = "Одноразовых ключей";
   private static final double field18536 = 50.0;
   private static final String field18537 = "Выставить";

   @Override
   protected List<SettingsListWindow.Nested200> method04173() {
      return this.field18530;
   }

   public ConfigSellWindow(String var1, IntConsumer var2) {
      super("Продажа · " + var1, field18532, field18533, field18534);
      this.field18529 = var2;
      this.field18530 = List.of(
         this.method06844(field18535, 1.0, field18536, 1.0, () -> this.field18531, var1x -> this.field18531 = (int)var1x, var0 -> String.valueOf((int)var0)),
         this.method06830(() -> field18537, () -> GuiThemeStyle.Nested40.NORMAL, this::method07631)
      );
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if (var1 != 257 && var1 != 335) {
         super.method00611(var1, var2, var3);
      } else {
         this.method07631();
      }
   }

   private void method07631() {
      if (this.field18529 != null) {
         this.field18529.accept(this.field18531);
      }

      this.method09550();
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (this.method09578(var1, var3)) {
         this.field18531 = Math.clamp(this.field18531 + (int)Math.signum(var5), 1, 50);
      }
   }
}
