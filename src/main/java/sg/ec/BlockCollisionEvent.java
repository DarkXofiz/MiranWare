// Original binary: sg/ec/h1ydYNkibdEyDS8J
package sg.ec;

// $VF: Compiled from s
public class BlockCollisionEvent extends Event {
   private long field19708;
   public static final BlockCollisionEvent field19709 = new BlockCollisionEvent();

   public long method08622(long var1) {
      this.field19708 = var1;
      super.method03208();
      return var1;
   }

   public long method08623() {
      return this.field19708;
   }

   public void method08624(long var1) {
      this.field19708 = var1;
   }
}
