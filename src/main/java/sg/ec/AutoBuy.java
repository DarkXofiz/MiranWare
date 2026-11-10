// Original binary: sg/ec/LADiwJWWbBodGh3A
package sg.ec;

// $VF: Compiled from s
public class AutoBuy extends ClientModule {
   private final ActionSetting field09855;
   private static final String field09856 = "Открыть список покупок";
   private static final String field09857 = "Auto Buy";
   private static final String field09858 = "Скупает лоты аукциона по заданным ценовым лимитам.";

   public AutoBuy() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field09855 = new ActionSetting(field09856).method03017(this::method04424).method03023(this);
      this.method03935(field09857);
      this.method03931(field09858);
   }

   @Override
   public void method00245() {
      super.method00245();
      AutoBuyManager.INSTANCE.method09760(false);
   }

   @Override
   public void method00276() {
      super.method00276();
      AutoBuyManager.INSTANCE.method09760(true);
   }

   private void method04424() {
      ClickGuiScreen var1 = MiranWare.getInstance().getMenuScreen();
      if (var1 != null) {
         var1.method09988(ModuleCategory.AutoBuy);
      }
   }
}
