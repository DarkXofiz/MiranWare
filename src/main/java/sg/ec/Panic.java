// Original binary: sg/ec/Nk7nKI0E1tnhINKl
package sg.ec;

// $VF: Compiled from s
public class Panic extends ClientModule {
   private final ModeSetting field10302;
   private static final String field10303 = "Режим скрытия";
   private static final String field10304 = "Скрывать окно";
   private static final String field10305 = "Черный экран";
   private static final String field10306 = "Черный экран";
   private static final String field10307 = "Panic";
   private static final String field10308 = "Черный экран";

   @Subscribe
   private void method04724(BlockCollisionEvent var1) {
      PanicController.method05867();
   }

   public Panic() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field10302 = new ModeSetting(field10303).method05597(field10304, field10305).method03017(field10306).method03023(this);
      this.method03935(field10307);
   }

   @Override
   public void method00245() {
      PanicController.method05863();
      super.method00245();
   }

   @Override
   public void method00276() {
      PanicController.method05864(this.field10302.method05600(field10308));
      super.method00276();
   }
}
