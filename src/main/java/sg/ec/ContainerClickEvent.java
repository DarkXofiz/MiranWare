// Original binary: sg/ec/H94eskmwSCFzEOQp
package sg.ec;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class ContainerClickEvent extends Event {
   public static final ContainerClickEvent field08467 = new ContainerClickEvent();
   private Player field08468;
   private int field08469;
   private int field08470;
   private int field08471;
   private ClickType field08472;

   public Player method03767() {
      return this.field08468;
   }

   public void method03768(int var1) {
      this.field08469 = var1;
   }

   public void method03769(int var1, int var2, int var3, ClickType var4, Player var5, CallbackInfo var6) {
      this.field08469 = var1;
      this.field08470 = var2;
      this.field08471 = var3;
      this.field08472 = var4;
      this.field08468 = var5;
      super.method03208();
      if (this.method05694()) {
         var6.cancel();
      }
   }

   public void method03770(Player var1) {
      this.field08468 = var1;
   }

   public ClickType method03771() {
      return this.field08472;
   }

   public void method03772(int var1) {
      this.field08470 = var1;
   }

   public int method03773() {
      return this.field08471;
   }

   public void method03774(ClickType var1) {
      this.field08472 = var1;
   }

   public void method03775(int var1) {
      this.field08471 = var1;
   }

   public int method03776() {
      return this.field08469;
   }

   public int method03777() {
      return this.field08470;
   }
}
