// Original binary: sg/ec/y3qUiPyQoYj9sYfF
package sg.ec;

// $VF: Compiled from s
public final class KeyFinderState {
   private final long field26372;
   private final ElapsedTimer field26373 = new ElapsedTimer();
   private boolean field26374;
   private static final long field26375 = 1000L;

   public long method11548() {
      return this.method11549() ? 0L : (this.field26372 - (System.currentTimeMillis() - this.field26373.field10288)) / field26375;
   }

   public KeyFinderState(long var1) {
      this.field26372 = var1;
   }

   public boolean method11549() {
      return !this.field26374 || this.field26373.method04699(this.field26372);
   }

   public void method11550() {
      this.field26374 = true;
      this.field26373.method04694();
   }
}
