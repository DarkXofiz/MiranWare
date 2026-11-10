// Original binary: sg/ec/C8bQnqwMrUp4goAg
package sg.ec;

import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public final class HitResultConstraint {
   private boolean field06680;
   private BlockPos field06681;

   public void method02874(BlockPos var1) {
      this.field06680 = true;
      this.field06681 = var1;
   }

   public void method02875(HitResultEvent var1) {
      if (this.field06680 && this.field06681 != null) {
         if (var1.method03289() == HitResultEvent.Nested91.ENTITY) {
            var1.method05695(true);
         } else if (var1.method03289() == HitResultEvent.Nested91.BLOCK) {
            if (var1.method03282() == null || !this.field06681.equals(var1.method03282())) {
               var1.method03292(true);
               var1.method05695(true);
            }
         }
      }
   }

   public void method02876() {
      this.field06680 = false;
      this.field06681 = null;
   }
}
