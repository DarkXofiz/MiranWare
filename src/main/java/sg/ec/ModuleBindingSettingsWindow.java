// Original binary: sg/ec/jOhyIqfvJWD6SKQ7
package sg.ec;

// $VF: Compiled from s
public class ModuleBindingSettingsWindow extends SettingsWindow {
   public static final float field20404 = 150.0F;
   private final HudElement field20405;
   private final float field20406;
   private static final float field20407 = 150.0F;
   private static final float field20408 = 6.0F;
   private static final float field20409 = 7.0F;
   private static final float field20410 = 29.0F;
   private static final float field20411 = 150.0F;

   @Override
   public void method08971(float var1) {
      super.method08971(GuiHitTestUtils.method05615(this.field20406, field20407, var1));
   }

   @Override
   public void method06773() {
      this.field20405.method06442(false);
   }

   private float method08972() {
      float var1 = this.field20406;

      for (SettingComponent var3 : this.method04682()) {
         float var4 = var3 instanceof BooleanSettingComponent ? field20408 : field20409;
         float var5 = Fonts.field00110.method09486(var3.method10977().method03024(), var4);
         var1 = Math.max(var1, var5 + field20410);
      }

      return GuiHitTestUtils.method05615(this.field20406, field20411, var1);
   }

   public ModuleBindingSettingsWindow(String var1, HudElement var2) {
      super("Настройки " + var2.method06462(), var1, var2);
      this.field20405 = var2;
      this.field20406 = this.method09568();
      this.method08971(this.method08972());
   }

   @Override
   public void method04220() {
      super.method04220();
      this.method08971(this.method08972());
      this.field20405.method06442(true);
   }
}
