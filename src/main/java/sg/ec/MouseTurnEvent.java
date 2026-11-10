// Original binary: sg/ec/KurIA4SocgzFWInS
package sg.ec;

import net.minecraft.client.player.LocalPlayer;

// $VF: Compiled from s
public class MouseTurnEvent extends Event {
   public static final MouseTurnEvent field09721 = new MouseTurnEvent();
   private double field09722;
   private double field09723;

   public void method04329(double var1) {
      this.field09723 = var1;
   }

   public double method04330() {
      return this.field09722;
   }

   public double method04331() {
      return this.field09723;
   }

   public void method04332(LocalPlayer var1, double var2, double var4) {
      if (!this.method05698()) {
         var1.turn(var2, var4);
      } else {
         this.field09722 = var2;
         this.field09723 = var4;
         super.method03208();
         if (!this.method05694()) {
            var1.turn(this.field09722, this.field09723);
         }
      }
   }

   public void method04333(double var1) {
      this.field09722 = var1;
   }
}
