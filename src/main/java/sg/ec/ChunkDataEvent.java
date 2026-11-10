// Original binary: sg/ec/rtV6Clhu7TSEKEVJ
package sg.ec;

// $VF: Compiled from s
public class ChunkDataEvent extends Event {
   public static final ChunkDataEvent field23495 = new ChunkDataEvent();
   private int field23496;
   private int field23497;

   public void method10522(int var1) {
      this.field23497 = var1;
   }

   public void method10523(int var1, int var2) {
      this.field23496 = var1;
      this.field23497 = var2;
      super.method03208();
   }

   public int method10524() {
      return this.field23496;
   }

   public void method10525(int var1) {
      this.field23496 = var1;
   }

   public int method10526() {
      return this.field23497;
   }
}
