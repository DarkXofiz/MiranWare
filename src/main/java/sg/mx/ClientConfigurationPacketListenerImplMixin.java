// Original binary: sg/mx/W4wFGjEX4DV3EmVh
package sg.mx;

import net.minecraft.client.multiplayer.ClientConfigurationPacketListenerImpl;
import net.minecraft.network.protocol.common.ClientboundUpdateTagsPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.BotRegistrySnapshot;

// $VF: Compiled from s
@Mixin(ClientConfigurationPacketListenerImpl.class)
public abstract class ClientConfigurationPacketListenerImplMixin {
   @Inject(method = "handleUpdateTags", at = @At("RETURN"))
   private void onUpdateTags(ClientboundUpdateTagsPacket var1, CallbackInfo var2) {
      BotRegistrySnapshot.INSTANCE.method03167(var1.getTags());
   }
}
