// Original binary: sg/ec/Q4inGIiTE7LeKfop
package sg.ec;

import net.minecraft.client.player.LocalPlayer;

// $VF: Compiled from s
public class ElytraStartEvent extends Event {
   public static final ElytraStartEvent field11209 = new ElytraStartEvent();
   private LocalPlayer field11210;
   private boolean field11211;

   public void method05131() {
      this.field11211 = true;
   }

   public LocalPlayer method05132() {
      return this.field11210;
   }

   public boolean method05133(LocalPlayer var1) {
      this.field11210 = var1;
      this.field11211 = false;
      super.method03208();
      return this.field11211;
   }

   public boolean method05134() {
      return this.field11211;
   }
}
