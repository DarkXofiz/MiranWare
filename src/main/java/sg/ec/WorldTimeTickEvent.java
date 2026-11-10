// Original binary: sg/ec/nliTD8RpAVZVSVIU
package sg.ec;

import net.minecraft.client.multiplayer.ClientLevel;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class WorldTimeTickEvent extends Event {
   public static final WorldTimeTickEvent field22027 = new WorldTimeTickEvent();
   private ClientLevel field22028;

   public ClientLevel method09734() {
      return this.field22028;
   }

   public void method09735(ClientLevel var1) {
      this.field22028 = var1;
   }

   public void method09736(ClientLevel var1, CallbackInfo var2) {
      this.field22028 = var1;
      super.method03208();
      if (this.method05694()) {
         var2.cancel();
      }
   }
}
