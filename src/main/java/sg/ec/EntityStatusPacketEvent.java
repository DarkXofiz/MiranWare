// Original binary: sg/ec/nSQmjz5MY3rIniDg
package sg.ec;

import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class EntityStatusPacketEvent extends Event {
   public static final EntityStatusPacketEvent field21957 = new EntityStatusPacketEvent();
   private ClientboundEntityEventPacket field21958;
   private CallbackInfo field21959;

   public CallbackInfo method09671() {
      return this.field21959;
   }

   public void method09672(ClientboundEntityEventPacket var1, CallbackInfo var2) {
      this.field21958 = var1;
      this.field21959 = var2;
      super.method03208();
   }

   public ClientboundEntityEventPacket method09673() {
      return this.field21958;
   }

   public void method09674(CallbackInfo var1) {
      this.field21959 = var1;
   }

   public void method09675(ClientboundEntityEventPacket var1) {
      this.field21958 = var1;
   }
}
