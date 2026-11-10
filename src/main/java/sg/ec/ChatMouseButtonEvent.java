// Original binary: sg/ec/XzfynIDUeH66yTHw
package sg.ec;

// $VF: Compiled from s
public class ChatMouseButtonEvent extends Event {
   public static final ChatMouseButtonEvent field14699 = new ChatMouseButtonEvent();
   private float field14700;
   private float field14701;
   private int field14702;
   private InputAction field14703;

   public void method06504(float var1) {
      this.field14701 = var1;
   }

   public float method06505() {
      return this.field14701;
   }

   public void method06506(float var1, float var2, int var3, InputAction var4) {
      this.field14700 = var1;
      this.field14701 = var2;
      this.field14702 = var3;
      this.field14703 = var4;
      super.method03208();
   }

   public void method06507(InputAction var1) {
      this.field14703 = var1;
   }

   public void method06508(float var1) {
      this.field14700 = var1;
   }

   public int method06509() {
      return this.field14702;
   }

   public float method06510() {
      return this.field14700;
   }

   public InputAction method06511() {
      return this.field14703;
   }

   public void method06512(int var1) {
      this.field14702 = var1;
   }
}
