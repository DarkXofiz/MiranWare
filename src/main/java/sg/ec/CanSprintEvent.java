// Original binary: sg/ec/MqW231vfq1EgR1tn
package sg.ec;

import net.minecraft.client.player.LocalPlayer;

// $VF: Compiled from s
public class CanSprintEvent extends Event {
   public static final CanSprintEvent field10222 = new CanSprintEvent();
   private LocalPlayer field10223;
   private Boolean field10224;

   public boolean method04668(boolean var1, LocalPlayer var2) {
      this.field10223 = var2;
      this.field10224 = null;
      super.method03208();
      if (this.field10224 != null) {
         return this.field10224;
      } else {
         return this.method05694() ? var2.input.keyPresses.forward() : var1;
      }
   }

   public void method04669(Boolean var1) {
      this.field10224 = var1;
   }

   public LocalPlayer method04670() {
      return this.field10223;
   }

   public void method04671(LocalPlayer var1) {
      this.field10223 = var1;
   }

   public Boolean method04672() {
      return this.field10224;
   }
}
