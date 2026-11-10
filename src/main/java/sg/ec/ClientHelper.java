// Original binary: sg/ec/y5DiOHE67ZvwUtXi
package sg.ec;

// $VF: Compiled from s
public class ClientHelper extends ClientModule {
   private static final String field26376 = "ReallyWorld";
   private final MultiToggleSetting field26377;
   private final MultiToggleSetting field26378;
   private static final String field26379 = "Что выключить";
   private static final String field26380 = "Скролл по слотам";
   private static final String field26381 = "Заменять префиксы";
   private static final String field26382 = "ReallyWorld";
   private static final String field26383 = "Client Helper";
   private static final String field26384 = "ReallyWorld";
   private static final String field26385 = "Скролл по слотам";

   @Subscribe
   private void method11551(MouseGrabEvent var1) {
      if (this.field26377.method04520(field26385)) {
         var1.method05696();
      }
   }

   public ClientHelper() {
      super(ModuleCategory.Misc, ModuleSubCategory.Utility);
      this.field26377 = new MultiToggleSetting(field26379).method04517(NamedOption.method08077(field26380, false)).method03023(this);
      this.field26378 = new MultiToggleSetting(field26381).method04517(NamedOption.method08077(field26382, false)).method03023(this);
      this.method03935(field26383);
   }

   @Subscribe
   private void method11552(TextDecorationEvent var1) {
      var1.method09829(ServerRank.INSTANCE.method07289());
   }

   @Subscribe
   private void method11553(PlayerUpdateEvent var1) {
      ServerRank.INSTANCE.method07288(this.field26378.method04520(field26384));
   }

   @Override
   public void method00245() {
      super.method00245();
      ServerRank.INSTANCE.method07288(false);
   }
}
