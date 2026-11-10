// Original binary: sg/ec/9sz3LWHkDQyrKHCC
package sg.ec;

// $VF: Compiled from s
public class Stopwatch {
   private long field05957 = System.currentTimeMillis();

   public long method02436() {
      return this.field05957;
   }

   public void method02437(long var1) {
      this.field05957 = var1;
   }

   public boolean method02438(long var1) {
      return System.currentTimeMillis() - this.field05957 > var1;
   }

   public void method02439() {
      this.field05957 = System.currentTimeMillis();
   }
}
