// Original binary: sg/ec/ryk91HZrLtlLDUoe
package sg.ec;

// $VF: Compiled from s
public class StreamerMode extends ClientModule {
   private static final String field23532 = "Скрывать ники";
   private static final String field23533 = "field23533";
   private final MultiToggleSetting field23534;
   private boolean field23535;
   private boolean field23536;
   private static final String field23537 = "Что делать";
   private static final String field23538 = "Скрывать ники";
   private static final String field23539 = "Кастомный скорборд";
   private static final String field23540 = "Streamer Mode";
   private static final String field23541 = "Кастомный скорборд";
   private static final String field23542 = "Скрывать ники";

   public boolean method10540() {
      return this.method03937() && this.field23535;
   }

   @Subscribe
   private void method10541(PlayerUpdateEvent var1) {
      boolean var2 = this.field23534.method04520(field23541);
      this.field23535 = this.field23534.method04520(field23542);
      if (var2) {
         ScoreboardTextFormatter.INSTANCE.method05635();
      } else if (this.field23536) {
         ScoreboardTextFormatter.INSTANCE.method05642();
      }

      this.field23536 = var2;
   }

   @Override
   public void method00245() {
      super.method00245();
      ScoreboardTextFormatter.INSTANCE.method05642();
   }

   public StreamerMode() {
      super(ModuleCategory.Misc, ModuleSubCategory.Other);
      this.field23534 = new MultiToggleSetting(field23537)
         .method04517(NamedOption.method08077(field23538, true))
         .method04517(NamedOption.method08077(field23539, false))
         .method03023(this);
      this.field23535 = false;
      this.field23536 = false;
      this.method03935(field23540);
   }

   @Subscribe
   private void method10542(PacketEvent var1) {
      if (this.field23536 && var1.method10904() && ScoreboardTextFormatter.INSTANCE.method05641(var1.method10897())) {
         var1.method05696();
      }
   }
}
