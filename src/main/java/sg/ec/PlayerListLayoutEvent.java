// Original binary: sg/ec/GZfycQPvKixY36El
package sg.ec;

// $VF: Compiled from s
public class PlayerListLayoutEvent extends Event {
   public static final PlayerListLayoutEvent field08065 = new PlayerListLayoutEvent();
   private int field08066;
   private int field08067;
   private long field08068;

   public void method03624(long var1) {
      this.field08068 = var1;
   }

   public void method03625(int var1) {
      this.field08067 = var1;
   }

   public int method03626() {
      return this.field08067;
   }

   public void method03627(int var1) {
      this.field08066 = var1;
   }

   public int method03628(int var1) {
      this.field08066 = var1;
      super.method03208();
      return this.field08066;
   }

   public int method03629() {
      return this.field08066;
   }

   public long method03630(long var1) {
      this.field08068 = var1;
      super.method03208();
      return this.field08068;
   }

   public long method03631() {
      return this.field08068;
   }

   public int method03632(int var1) {
      this.field08067 = var1;
      super.method03208();
      return this.field08067;
   }
}
