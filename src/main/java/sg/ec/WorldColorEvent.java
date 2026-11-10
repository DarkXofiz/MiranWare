// Original binary: sg/ec/5ztKEHd1cmaAx6m0
package sg.ec;

import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

// $VF: Compiled from s
public class WorldColorEvent extends Event {
   public static final WorldColorEvent field02679 = new WorldColorEvent();
   private WorldColorEvent.Nested37 field02680;
   private int field02681;

   public void method01251(WorldColorEvent.Nested37 var1, Args var2) {
      this.field02680 = var1;
      var2.set(5, this.field02681);
      super.method03208();
   }

   public int method01252(WorldColorEvent.Nested37 var1, int var2) {
      if (!this.method05698()) {
         return var2;
      }

      this.field02680 = var1;
      this.field02681 = var2;
      super.method03208();
      return this.field02681;
   }

   public WorldColorEvent.Nested37 method01253() {
      return this.field02680;
   }

   public void method01254(int var1) {
      this.field02681 = var1;
   }

   public int method01255() {
      return this.field02681;
   }

   public void method01256(WorldColorEvent.Nested37 var1) {
      this.field02680 = var1;
   }

   // $VF: Compiled from s
   public enum Nested37 {
      CLOUD,
      SKY;
   }
}
