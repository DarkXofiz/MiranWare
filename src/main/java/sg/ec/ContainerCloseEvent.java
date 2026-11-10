// Original binary: sg/ec/fVoCrRRBkPaTd4to
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class ContainerCloseEvent extends Event {
   public static final ContainerCloseEvent field19023 = new ContainerCloseEvent();
   private Screen field19024;
   private int field19025;

   public void method08155(Screen var1) {
      this.field19024 = var1;
   }

   public Screen method08156() {
      return this.field19024;
   }

   public void method08157(Minecraft var1, LocalPlayer var2, CallbackInfo var3) {
      this.field19024 = var1.gui.screen();
      this.field19025 = var2.containerMenu.containerId;
      super.method03208();
      if (this.method05694()) {
         var3.cancel();
      }
   }

   public void method08158(int var1) {
      this.field19025 = var1;
   }

   public int method08159() {
      return this.field19025;
   }
}
