// Original binary: sg/ec/SVf8G95lxcfS9xtP
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class AutoBuyEntryWindow extends SettingsListWindow {
   public static final String field11770 = "autobuy.entry";
   public static final float field11771 = 0;
   public static final float field11772 = 0;
   private static final int field11773 = 0;
   private static final int field11774 = 0;
   private final AutoBuyItem field11775;
   private List<SettingsListWindow.Nested200> field11776;
   private boolean field11777;
   private static final String field11778 = "autobuy.entry";
   private static final float field11779 = 150.0F;
   private static final float field11780 = 258.0F;
   private static final String field11781 = "Макс. цена за шт.";
   private static final String field11782 = "Мин. цена за шт.";
   private static final String field11783 = "Мин. прочность, %";
   private static final String field11784 = "Оценивать по содержимому";
   private static final String field11785 = "Своя наценка автоподбора";
   private static final String field11786 = "Наценка, %";

   public AutoBuyEntryWindow(AutoBuyItem var1) {
      super(var1.method10673(), field11778, field11779, field11780);
      this.field11775 = var1;
   }

   private List<SettingsListWindow.Nested200> method05456() {
      ArrayList var1 = new ArrayList();
      var1.add(this.method06837(field11781, () -> method05457(this.field11775.method10682()), this::method05462, 9));
      var1.add(this.method06837(field11782, () -> method05457(this.field11775.method10699()), var1x -> this.field11775.method10724(method05463(var1x)), 9));
      if (this.field11775.method10736()) {
         var1.add(
            this.method06837(field11783, () -> method06852(this.field11775.method10733()), var1x -> this.field11775.method10737(Float.parseFloat(var1x)), 5)
         );
      }

      var1.add(this.method06850(field11784, this.field11775::method10735, this.field11775::method10694));
      var1.add(this.method06850(field11785, this.field11775::method10715, this.field11775::method10707));
      if (this.field11775.method10715()) {
         var1.add(
            this.method06837(field11786, () -> method06852(this.field11775.method10718()), var1x -> this.field11775.method10713(Float.parseFloat(var1x)), 5)
         );
      }

      return List.copyOf(var1);
   }

   private static String method05457(int var0) {
      return var0 > 0 ? String.valueOf(var0) : "";
   }

   @Override
   protected void method04187() {
      AutoBuyItemRegistry.INSTANCE.method10994();
   }

   private void method05462(String var1) {
      int var2 = method05463(var1);
      if (var2 != this.field11775.method10682()) {
         this.field11775.method10669(var2);
         this.field11775.method10703(var2 > 0);
      }
   }

   @Override
   protected List<SettingsListWindow.Nested200> method04173() {
      if (this.field11776 == null || this.field11777 != this.field11775.method10715()) {
         this.field11777 = this.field11775.method10715();
         this.method06832();
         this.field11776 = this.method05456();
      }

      return this.field11776;
   }

   @Override
   public boolean method01686() {
      return true;
   }

   private static int method05463(String var0) {
      return var0.isBlank() ? 0 : Integer.parseInt(var0);
   }

   @Override
   protected ItemStack method05464() {
      return this.field11775.method10716();
   }
}
