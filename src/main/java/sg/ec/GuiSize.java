// Original binary: sg/ec/OFcp9SPwwYMnGnJK
package sg.ec;

// $VF: Compiled from s
public class GuiSize {
   private final float field10493;
   private final float field10494;
   private final float field10495;
   private final float field10496;

   public float method04760() {
      return this.field10495;
   }

   public float method04761() {
      return this.field10494;
   }

   public GuiSize method04762(float var1) {
      var1 = -var1;
      return new GuiSize(this.field10493 * var1, this.field10494 * var1, this.field10495 * var1, this.field10496 * var1);
   }

   public static GuiSize method04763(float var0) {
      return new GuiSize(var0, var0, var0, var0);
   }

   public GuiSize method04764(float var1) {
      return new GuiSize(this.field10493 * var1, this.field10494 * var1, this.field10495 * var1, this.field10496 * var1);
   }

   public static GuiSize method04765(float var0, float var1) {
      return new GuiSize(var0, var0, var1, var1);
   }

   public float method04766() {
      return this.field10493;
   }

   public static GuiSize method04767(float var0, float var1, float var2, float var3) {
      return new GuiSize(var0, var1, var2, var3);
   }

   private GuiSize(float var1, float var2, float var3, float var4) {
      this.field10493 = var1;
      this.field10494 = var2;
      this.field10495 = var3;
      this.field10496 = var4;
   }

   public float method04768() {
      return this.field10496;
   }
}
