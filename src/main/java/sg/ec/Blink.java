// Original binary: sg/ec/V9fe92ZvhamCL3S9
package sg.ec;

// $VF: Compiled from s
public class Blink extends ClientModule {
   private final ModeSetting field12686;
   private final NumberSetting<Integer> field12687;
   int field12688;
   private static final String field12689 = "Режим";
   private static final String field12690 = "toggle режим";
   private static final String field12691 = "Пульсация";
   private static final String field12692 = "toggle режим";
   private static final String field12693 = "Задержка в тиках";
   private static final String field12694 = "Blink";
   private static final String field12695 = "Пульсация";
   private static final String field12696 = "Blink";
   private static final String field12697 = "Blink";
   private static final String field12698 = "toggle режим";
   private static final String field12699 = "toggle режим";

   @Subscribe
   private void method05929(PlayerUpdateEvent var1) {
      if (this.field12686.method05600(field12695)) {
         this.field12688++;
         if (!PacketBufferManager.INSTNCE.method03607()) {
            this.method05931();
         }

         if (this.field12688 > this.field12687.method03022()) {
            this.method05932();
            this.method05930();
         }
      }
   }

   private void method05930() {
      PacketBufferManager.INSTNCE.method03606(field12697);
   }

   private void method05931() {
      PacketBufferManager.INSTNCE.method03604(field12696);
   }

   @Override
   public void method00245() {
      if (this.field12686.method05600(field12699) || PacketBufferManager.INSTNCE.method03607()) {
         this.method05930();
      }

      this.method05932();
      super.method00245();
   }

   public Blink() {
      super(ModuleCategory.Misc, ModuleSubCategory.Utility);
      this.field12686 = new ModeSetting(field12689).method05597(field12690, field12691).method03017(field12692).method03023(this);
      this.field12687 = new NumberSetting<Integer>(field12693).method10835(2).method10838(10).method10834(1).method03017(5).method03023(this);
      this.field12688 = 0;
      this.method03935(field12694);
   }

   private void method05932() {
      this.field12688 = 0;
   }

   @Override
   public void method00276() {
      if (this.field12686.method05600(field12698)) {
         this.method05931();
      }

      this.method05932();
      super.method00276();
   }
}
