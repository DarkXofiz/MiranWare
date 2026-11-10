// Original binary: sg/ec/lWgepJ7zZRzi74V1
package sg.ec;

// $VF: Compiled from s
public class ChatKeyEvent extends Event {
   public static final ChatKeyEvent field21313 = new ChatKeyEvent();
   private int field21314;
   private int field21315;
   private int field21316;

   public void method09379(int var1, int var2, int var3) {
      this.field21314 = var1;
      this.field21315 = var2;
      this.field21316 = var3;
      super.method03208();
   }

   public int method09380() {
      return this.field21315;
   }

   public void method09381(int var1) {
      this.field21315 = var1;
   }

   public void method09382(int var1) {
      this.field21314 = var1;
   }

   public void method09383(int var1) {
      this.field21316 = var1;
   }

   public int method09384() {
      return this.field21316;
   }

   public int method09385() {
      return this.field21314;
   }
}
