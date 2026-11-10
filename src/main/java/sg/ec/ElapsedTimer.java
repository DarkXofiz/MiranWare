// Original binary: sg/ec/NEGaoHFhVhIo4jWh
package sg.ec;

// $VF: Compiled from s
public class ElapsedTimer {
   public long field10288 = System.currentTimeMillis();

   public boolean method04690(double var1) {
      return System.currentTimeMillis() - var1 >= this.field10288;
   }

   public void method04691(long var1) {
      this.field10288 = var1;
   }

   public boolean method04692() {
      return this.field10288 < System.currentTimeMillis();
   }

   public long method04693() {
      return System.currentTimeMillis() - this.field10288;
   }

   public void method04694() {
      this.field10288 = System.currentTimeMillis();
   }

   public long method04695() {
      return this.field10288;
   }

   public void method04696(long var1) {
      this.field10288 = System.currentTimeMillis() + var1;
   }

   public boolean method04697() {
      return System.currentTimeMillis() - this.field10288 <= 0L;
   }

   public boolean method04698(double var1) {
      boolean var3 = this.method04690(var1);
      if (var3) {
         this.method04694();
      }

      return var3;
   }

   public boolean method04699(long var1) {
      return System.currentTimeMillis() - this.field10288 > var1;
   }
}
