// Original binary: sg/ec/Y02MpdMEYOAD6g1e
package sg.ec;

// $VF: Compiled from s
public class ChatMouseScrollEvent extends Event {
   public static final ChatMouseScrollEvent field14704 = new ChatMouseScrollEvent();
   private double field14705;
   private double field14706;
   private double field14707;
   private double field14708;

   public void method06513(double var1) {
      this.field14708 = var1;
   }

   public void method06514(double var1, double var3, double var5, double var7) {
      this.field14705 = var1;
      this.field14706 = var3;
      this.field14707 = var5;
      this.field14708 = var7;
      super.method03208();
   }

   public void method06515(double var1) {
      this.field14705 = var1;
   }

   public double method06516() {
      return this.field14707;
   }

   public void method06517(double var1) {
      this.field14707 = var1;
   }

   public double method06518() {
      return this.field14705;
   }

   public void method06519(double var1) {
      this.field14706 = var1;
   }

   public double method06520() {
      return this.field14708;
   }

   public double method06521() {
      return this.field14706;
   }
}
