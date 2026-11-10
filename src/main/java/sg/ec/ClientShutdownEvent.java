// Original binary: sg/ec/kDKBXxHmM4cWnnHF
package sg.ec;

// $VF: Compiled from s
public class ClientShutdownEvent extends Event {
   public static final ClientShutdownEvent field20788 = new ClientShutdownEvent();
   private volatile boolean field20789;

   @Override
   public void method03208() {
      if (!this.field20789) {
         this.field20789 = true;
         super.method03208();
      }
   }
}
