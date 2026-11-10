// Original binary: sg/ec/zC0XiVWavMUfU3V1
package sg.ec;

// $VF: Compiled from s
public class ClickGUI extends ClientModule {
   private static final String field27853 = "Click GUI";

   public ClickGUI() {
      super(ModuleCategory.Render, ModuleSubCategory.Other);
      this.method03922(new KeyBinding(344));
      this.method03929(false);
      this.method03935(field27853);
   }

   @Override
   public void method00382() {
      ClientScreenManager.INSTANCE.method08319(MiranWare.getInstance().getMenuScreen());
   }
}
