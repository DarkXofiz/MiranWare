// Original binary: sg/ec/acmq3ngRRIWTILqY
package sg.ec;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.common.ClientboundResourcePackPushPacket;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// $VF: Compiled from s
public class ResourcePackRequestEvent extends Event {
   public static final ResourcePackRequestEvent field15679 = new ResourcePackRequestEvent();
   private Connection field15680;
   private Minecraft field15681;
   private ClientboundResourcePackPushPacket field15682;

   public Minecraft method06959() {
      return this.field15681;
   }

   public Connection method06960() {
      return this.field15680;
   }

   public void method06961(Connection var1, Minecraft var2, ClientboundResourcePackPushPacket var3, CallbackInfo var4) {
      this.field15680 = var1;
      this.field15681 = var2;
      this.field15682 = var3;
      this.method03208();
      if (this.method05694()) {
         var4.cancel();
      }
   }

   public void method06962(Connection var1) {
      this.field15680 = var1;
   }

   public void method06963(ClientboundResourcePackPushPacket var1) {
      this.field15682 = var1;
   }

   public ClientboundResourcePackPushPacket method06964() {
      return this.field15682;
   }

   public void method06965(Minecraft var1) {
      this.field15681 = var1;
   }
}
