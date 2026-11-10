// Original binary: sg/ec/oeCojdbM99kMuq65
package sg.ec;

// $VF: Compiled from s
public class AuraAttackTiming {
   private long field22157 = 0L;
   private final ElapsedTimer field22158 = new ElapsedTimer();

   public long method09850() {
      return this.field22157;
   }

   public void method09851(long var1) {
      this.field22158.method04694();
      this.field22157 = var1;
   }

   public ElapsedTimer method09852() {
      return this.field22158;
   }

   public boolean method09853(long var1) {
      return this.field22158.method04690(var1);
   }

   public boolean method09854() {
      return this.method09853(this.field22157);
   }
}
