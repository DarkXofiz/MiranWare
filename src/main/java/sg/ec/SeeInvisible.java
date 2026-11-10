// Original binary: sg/ec/MPgfgQcQpBwMSVYt
package sg.ec;

// $VF: Compiled from s
public class SeeInvisible extends ClientModule {
   private final ToggleSetting field10079;
   private final NumberSetting<Float> field10080;
   private static final String field10081 = "Показывать руки";
   private static final String field10082 = "Прозрачность";
   private static final float field10083 = 0.1F;
   private static final float field10084 = 0.05F;
   private static final float field10085 = 0.5F;
   private static final String field10086 = "See Invisible";

   public boolean method04538() {
      return this.method03937() && this.field10079.method05999() && mc.player != null && mc.player.isInvisible();
   }

   @Subscribe
   private void method04539(InvisibleEntityRenderEvent var1) {
      var1.method02607(ColorUtils.method04611(var1.method02604(), this.field10080.method03022()));
      var1.method05695(true);
   }

   public SeeInvisible() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field10079 = new ToggleSetting(field10081).method03017(false).method03023(this);
      this.field10080 = new NumberSetting<Float>(field10082)
         .method10835(field10083)
         .method10838(1.0F)
         .method10834(field10084)
         .method03017(field10085)
         .method03023(this);
      this.method03935(field10086);
   }

   public int method04540(int var1) {
      return this.method04538() ? ColorUtils.method04611(var1, this.field10080.method03022()) : var1;
   }
}
